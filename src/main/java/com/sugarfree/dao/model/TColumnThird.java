package com.sugarfree.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_column_third")
public class TColumnThird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "column_desc")
    private String columnDesc;


    @Column(name = "update_num")
    private Integer updateNum;


    @Column(name = "sub_num")
    private Integer subNum;


    private String img;

    private String url;

    private Integer sort;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_user")
    private Date updateUser;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "delete_state")
    private String deleteState;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getColumnName() {
        return columnName;
    }


    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    public String getColumnDesc() {
        return columnDesc;
    }


    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc;
    }


    public Integer getUpdateNum() {
        return updateNum;
    }


    public void setUpdateNum(Integer updateNum) {
        this.updateNum = updateNum;
    }


    public Integer getSubNum() {
        return subNum;
    }


    public void setSubNum(Integer subNum) {
        this.subNum = subNum;
    }


    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public Integer getSort() {
        return sort;
    }


    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public String getCreateUser() {
        return createUser;
    }


    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateUser() {
        return updateUser;
    }


    public void setUpdateUser(Date updateUser) {
        this.updateUser = updateUser;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getDeleteState() {
        return deleteState;
    }


    public void setDeleteState(String deleteState) {
        this.deleteState = deleteState;
    }
}