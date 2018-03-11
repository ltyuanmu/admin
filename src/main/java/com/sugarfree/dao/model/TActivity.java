package com.sugarfree.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_activity")
public class TActivity {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动名称
     */
    @Column(name = "activity_name")
    private String activityName;

    /**
     * 活动开始时间
     */
    @Column(name = "activity_start")
    private Date activityStart;

    /**
     * 活动结束时间
     */
    @Column(name = "activity_end")
    private Date activityEnd;

    /**
     * 活动奖品数
     */
    @Column(name = "activity_prize_count")
    private Integer activityPrizeCount;

    /**
     * 用户筹集数
     */
    @Column(name = "help_count")
    private Integer helpCount;

    /**
     * 活动背景图路径
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 启用标志(0:启用)
     */
    @Column(name = "enable_flag")
    private Boolean enableFlag;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取活动名称
     *
     * @return activity_name - 活动名称
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置活动名称
     *
     * @param activityName 活动名称
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * 获取活动开始时间
     *
     * @return activity_start - 活动开始时间
     */
    public Date getActivityStart() {
        return activityStart;
    }

    /**
     * 设置活动开始时间
     *
     * @param activityStart 活动开始时间
     */
    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    /**
     * 获取活动结束时间
     *
     * @return activity_end - 活动结束时间
     */
    public Date getActivityEnd() {
        return activityEnd;
    }

    /**
     * 设置活动结束时间
     *
     * @param activityEnd 活动结束时间
     */
    public void setActivityEnd(Date activityEnd) {
        this.activityEnd = activityEnd;
    }

    /**
     * 获取活动奖品数
     *
     * @return activity_prize_count - 活动奖品数
     */
    public Integer getActivityPrizeCount() {
        return activityPrizeCount;
    }

    /**
     * 设置活动奖品数
     *
     * @param activityPrizeCount 活动奖品数
     */
    public void setActivityPrizeCount(Integer activityPrizeCount) {
        this.activityPrizeCount = activityPrizeCount;
    }

    /**
     * 获取用户筹集数
     *
     * @return help_count - 用户筹集数
     */
    public Integer getHelpCount() {
        return helpCount;
    }

    /**
     * 设置用户筹集数
     *
     * @param helpCount 用户筹集数
     */
    public void setHelpCount(Integer helpCount) {
        this.helpCount = helpCount;
    }

    /**
     * 获取活动背景图路径
     *
     * @return img_url - 活动背景图路径
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置活动背景图路径
     *
     * @param imgUrl 活动背景图路径
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取启用标志(0:启用)
     *
     * @return enable_flag - 启用标志(0:启用)
     */
    public Boolean getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置启用标志(0:启用)
     *
     * @param enableFlag 启用标志(0:启用)
     */
    public void setEnableFlag(Boolean enableFlag) {
        this.enableFlag = enableFlag;
    }
}