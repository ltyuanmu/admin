package com.sugarfree.service;

import com.github.pagehelper.Page;
import com.sugarfree.invo.StatisticsInVo;
import com.sugarfree.outvo.StatisticsOutVo;
import com.sugarfree.outvo.StatisticsPageOutVo;

/**
 * @ClassName: 统计服务
 * @Description:
 * @author: LT
 * @date: 2017/5/9
 */
public interface StatisticsService {
    /**
     * 查询统计数据
     * @param inVo
     * @return
     */
    StatisticsPageOutVo queryStatistics(StatisticsInVo inVo);

    /**
     * 保存当天推送统计
     */
    void savePushStat();
}
