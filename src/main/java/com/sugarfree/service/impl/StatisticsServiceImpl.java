package com.sugarfree.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sugarfree.dao.mapper.StatisticsDao;
import com.sugarfree.dao.mapper.TPushStatMapper;
import com.sugarfree.dao.model.TPushStat;
import com.sugarfree.invo.StatisticsInVo;
import com.sugarfree.outvo.StatisticsOutVo;
import com.sugarfree.outvo.StatisticsPageOutVo;
import com.sugarfree.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private StatisticsDao statisticsDao;
    @Autowired
    private TPushStatMapper tPushStatMapper;

    @Override
    public StatisticsPageOutVo queryStatistics(StatisticsInVo inVo) {
        Example example = new Example(TPushStat.class);
        Example.Criteria criteria = example.createCriteria();
        if(inVo.getColumnId()!=null){
            criteria.andEqualTo("columnId",inVo.getColumnId());
        }
        if(inVo.getArticleId()!=null){
            criteria.andEqualTo("articleId",inVo.getArticleId());
        }
        if (StringUtils.isNotEmpty(inVo.getStartDate())){
            criteria.andGreaterThanOrEqualTo("pushTime",inVo.getStartDate());
        }
        if(StringUtils.isNotEmpty(inVo.getEndDate())){
            criteria.andLessThanOrEqualTo("pushTime",inVo.getEndDate());
        }
        example.orderBy("pushTime").desc().orderBy("columnId").asc().orderBy("articleId").asc();
        PageHelper.startPage(inVo.getPageNo(),inVo.getPageSize());
        List<TPushStat> tPushStats = this.tPushStatMapper.selectByExample(example);
        PageInfo<TPushStat> pageInfo = new PageInfo<>(tPushStats);
        List<StatisticsOutVo> list = tPushStats.stream().map(t -> {
            StatisticsOutVo stat = new StatisticsOutVo();
            BeanUtils.copyProperties(t, stat);
            BigDecimal decimal = BigDecimal.valueOf(t.getOpenNum()).divide(BigDecimal.valueOf(t.getPushNum()), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
            stat.setDensity(decimal.doubleValue() + "%");
            return stat;
        }).collect(Collectors.toList());
        StatisticsPageOutVo outVo = new StatisticsPageOutVo();
        outVo.setCount(pageInfo.getTotal());
        outVo.setList(list);
        outVo.setPageNo(inVo.getPageNo());
        outVo.setPageSize(inVo.getPageSize());
        //获得查询条件总打开数和总推送数
        Integer totalPushNum = this.statisticsDao.getTotalPushNum(inVo);
        Integer totalOpenNum = this.statisticsDao.getTotalOpenNum(inVo);
        outVo.setTotalPushNum(totalPushNum);
        outVo.setTotalOpenNum(totalOpenNum);
        BigDecimal decimal = BigDecimal.valueOf(totalOpenNum).divide(BigDecimal.valueOf(totalPushNum), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        outVo.setTotalDensity(decimal.doubleValue()+"%");
        return outVo;
    }

    @Override
    public void savePushStat() {
        //获得上一天时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        //得到时间后转换为年月日String
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(calendar.getTime());
        //获取上一天的所有统计数据
        List<TPushStat> pushStatByDate = this.statisticsDao.getPushStatByDate(date);
        //保存到表中
        pushStatByDate.forEach(tPushStatMapper::insertSelective);
    }
}
