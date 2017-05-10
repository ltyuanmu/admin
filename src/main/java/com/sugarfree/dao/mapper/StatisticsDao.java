package com.sugarfree.dao.mapper;

import com.sugarfree.dao.model.TPushStat;

import java.util.List;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
public interface StatisticsDao {
    /**
     * 通过时间获得当天的推送统计 日期类型为 yyyy-MM-dd
     * @param date
     * @return
     */
    List<TPushStat> getPushStatByDate(String date);
}
