package com.sugarfree.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sugarfree.dao.mapper.TActivityHelpMapper;
import com.sugarfree.dao.mapper.TActivityJoinMapper;
import com.sugarfree.dao.mapper.TActivityMapper;
import com.sugarfree.dao.model.TActivity;
import com.sugarfree.dao.model.TActivityHelp;
import com.sugarfree.dao.model.TActivityJoin;
import com.sugarfree.invo.ActivityHelpInVo;
import com.sugarfree.invo.ActivityInVo;
import com.sugarfree.invo.ActivityJoinInVo;
import com.sugarfree.invo.BasePageParamInVo;
import com.sugarfree.service.ActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private TActivityMapper tActivityMapper;
    @Autowired
    private TActivityHelpMapper tActivityHelpMapper;
    @Autowired
    private TActivityJoinMapper tActivityJoinMapper;

    @Override
    public PageInfo<TActivity> getActivityList(BasePageParamInVo inVo) {
        return PageHelper.startPage(inVo.getPageNo(), inVo.getPageSize()).doSelectPageInfo(() -> this.tActivityMapper.selectAll());
    }

    @Override
    public PageInfo<TActivityJoin> getActivityJoin(ActivityJoinInVo inVo) {
        return PageHelper.startPage(inVo.getPageNo(), inVo.getPageSize()).doSelectPageInfo(() -> {
            Example example = new Example(TActivityJoin.class);
            example.createCriteria()
                    .andEqualTo("activity_id",inVo.getActivityId());
            example.orderBy("id").asc();
            this.tActivityJoinMapper.selectByExample(example);
        });
    }

    @Override
    public PageInfo<TActivityHelp> getActivityHelp(ActivityHelpInVo inVo) {
        return PageHelper.startPage(inVo.getPageNo(), inVo.getPageSize()).doSelectPageInfo(() -> {
            Example example = new Example(TActivityHelp.class);
            example.createCriteria()
                    .andEqualTo("activity_join_id",inVo.getActivityJoinId());
            example.orderBy("id").asc();
            this.tActivityHelpMapper.selectByExample(example);
        });
    }

    @Override
    public void saveActivity(ActivityInVo tActivity) throws ParseException {
        TActivity create = new TActivity();
        BeanUtils.copyProperties(tActivity,create);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        create.setActivityStart(sf.parse(tActivity.getActivityStart()));
        create.setActivityEnd(sf.parse(tActivity.getActivityEnd()));
        this.tActivityMapper.insertSelective(create);
    }
}
