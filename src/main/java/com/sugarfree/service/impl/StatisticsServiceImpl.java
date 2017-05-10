package com.sugarfree.service.impl;

import com.sugarfree.dao.mapper.StatisticsDao;
import com.sugarfree.dao.mapper.TPushStatMapper;
import com.sugarfree.dao.model.TPushStat;
import com.sugarfree.invo.StatisticsInVo;
import com.sugarfree.outvo.StatisticsOutVo;
import com.sugarfree.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private StatisticsDao statisticsDao;
    @Autowired
    private TPushStatMapper tPushStatMapper;

    @Override
    public StatisticsOutVo queryStatistics(StatisticsInVo inVo) {
        return null;
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
