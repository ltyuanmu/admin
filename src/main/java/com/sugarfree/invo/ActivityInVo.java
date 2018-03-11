package com.sugarfree.invo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.util.Date;

@Data
public class ActivityInVo {

    private String activityName;

    /**
     * 活动开始时间
     */
    private String activityStart;

    /**
     * 活动结束时间
     */
    private String activityEnd;

    /**
     * 活动奖品数
     */
    private Integer activityPrizeCount;

    /**
     * 用户筹集数
     */
    private Integer helpCount;

    /**
     * 活动背景图路径
     */
    private String imgUrl;

    /**
     * 启用标志(0:启用)
     */
    private Boolean enableFlag;
}
