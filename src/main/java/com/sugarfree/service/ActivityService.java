package com.sugarfree.service;

import com.github.pagehelper.PageInfo;
import com.sugarfree.dao.model.TActivity;
import com.sugarfree.dao.model.TActivityHelp;
import com.sugarfree.dao.model.TActivityJoin;
import com.sugarfree.invo.ActivityHelpInVo;
import com.sugarfree.invo.ActivityInVo;
import com.sugarfree.invo.ActivityJoinInVo;
import com.sugarfree.invo.BasePageParamInVo;

import java.text.ParseException;


public interface ActivityService {

    /**
     * 查询活动列表
     * @return 活动列表
     */
    PageInfo<TActivity> getActivityList(BasePageParamInVo inVo);

    /**
     * 通过活动列表查询活动参与人
     * @param inVo 活动id
     * @return 活动参与信息
     */
    PageInfo<TActivityJoin> getActivityJoin(ActivityJoinInVo inVo);

    /**
     * 通过参与人获得活动助力信息
     * @param inVo 活动参与io
     * @return 返回活动助力
     */
    PageInfo<TActivityHelp> getActivityHelp(ActivityHelpInVo inVo);

    /**
     * 添加活动
     * @param tActivity 活动表
     */
    void saveActivity(ActivityInVo tActivity) throws ParseException;
}
