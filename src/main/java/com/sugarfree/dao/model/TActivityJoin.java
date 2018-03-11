package com.sugarfree.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_activity_join")
public class TActivityJoin {
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
     * 参与时间
     */
    @Column(name = "join_date")
    private Date joinDate;

    /**
     * 参与人openid
     */
    @Column(name = "join_open_id")
    private String joinOpenId;

    /**
     * 参与人用户昵称
     */
    @Column(name = "join_nickname")
    private String joinNickname;

    /**
     * 填写姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 填写电话
     */
    private String mobile;

    /**
     * 填写地址
     */
    private String address;

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
     * 获取参与时间
     *
     * @return join_date - 参与时间
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * 设置参与时间
     *
     * @param joinDate 参与时间
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * 获取参与人openid
     *
     * @return join_open_id - 参与人openid
     */
    public String getJoinOpenId() {
        return joinOpenId;
    }

    /**
     * 设置参与人openid
     *
     * @param joinOpenId 参与人openid
     */
    public void setJoinOpenId(String joinOpenId) {
        this.joinOpenId = joinOpenId;
    }

    /**
     * 获取参与人用户昵称
     *
     * @return join_nickname - 参与人用户昵称
     */
    public String getJoinNickname() {
        return joinNickname;
    }

    /**
     * 设置参与人用户昵称
     *
     * @param joinNickname 参与人用户昵称
     */
    public void setJoinNickname(String joinNickname) {
        this.joinNickname = joinNickname;
    }

    /**
     * 获取填写姓名
     *
     * @return real_name - 填写姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置填写姓名
     *
     * @param realName 填写姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取填写电话
     *
     * @return mobile - 填写电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置填写电话
     *
     * @param mobile 填写电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取填写地址
     *
     * @return address - 填写地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置填写地址
     *
     * @param address 填写地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
}