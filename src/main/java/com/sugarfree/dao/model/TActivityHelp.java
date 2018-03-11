package com.sugarfree.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_activity_help")
public class TActivityHelp {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 活动id
     */
    @Column(name = "activity_id")
    private Integer activityId;

    /**
     * 活动参与人id
     */
    @Column(name = "activity_join_id")
    private Integer activityJoinId;

    /**
     * 助力时间
     */
    @Column(name = "help_date")
    private Date helpDate;

    /**
     * 活动助力人openid
     */
    @Column(name = "help_open_id")
    private String helpOpenId;

    /**
     * 活动助力人用户昵称
     */
    @Column(name = "help_nickname")
    private String helpNickname;

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
     * 获取活动id
     *
     * @return activity_id - 活动id
     */
    public Integer getActivityId() {
        return activityId;
    }

    /**
     * 设置活动id
     *
     * @param activityId 活动id
     */
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    /**
     * 获取活动参与人id
     *
     * @return activity_join_id - 活动参与人id
     */
    public Integer getActivityJoinId() {
        return activityJoinId;
    }

    /**
     * 设置活动参与人id
     *
     * @param activityJoinId 活动参与人id
     */
    public void setActivityJoinId(Integer activityJoinId) {
        this.activityJoinId = activityJoinId;
    }

    /**
     * 获取助力时间
     *
     * @return help_date - 助力时间
     */
    public Date getHelpDate() {
        return helpDate;
    }

    /**
     * 设置助力时间
     *
     * @param helpDate 助力时间
     */
    public void setHelpDate(Date helpDate) {
        this.helpDate = helpDate;
    }

    /**
     * 获取活动助力人openid
     *
     * @return help_open_id - 活动助力人openid
     */
    public String getHelpOpenId() {
        return helpOpenId;
    }

    /**
     * 设置活动助力人openid
     *
     * @param helpOpenId 活动助力人openid
     */
    public void setHelpOpenId(String helpOpenId) {
        this.helpOpenId = helpOpenId;
    }

    /**
     * 获取活动助力人用户昵称
     *
     * @return help_nickname - 活动助力人用户昵称
     */
    public String getHelpNickname() {
        return helpNickname;
    }

    /**
     * 设置活动助力人用户昵称
     *
     * @param helpNickname 活动助力人用户昵称
     */
    public void setHelpNickname(String helpNickname) {
        this.helpNickname = helpNickname;
    }
}