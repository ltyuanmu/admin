package com.sugarfree.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_push_stat")
public class TPushStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 栏目id
     */
    @Column(name = "column_id")
    private Integer columnId;

    /**
     * 栏目名
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 文章id
     */
    @Column(name = "article_id")
    private Integer articleId;

    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 推送时间(天数)
     */
    @Column(name = "push_time")
    private Date pushTime;

    /**
     * 推送人数
     */
    @Column(name = "push_num")
    private Integer pushNum;

    /**
     * 当天打开推送文章的人数
     */
    @Column(name = "open_num")
    private Integer openNum;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取栏目id
     *
     * @return column_id - 栏目id
     */
    public Integer getColumnId() {
        return columnId;
    }

    /**
     * 设置栏目id
     *
     * @param columnId 栏目id
     */
    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取栏目名
     *
     * @return column_name - 栏目名
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置栏目名
     *
     * @param columnName 栏目名
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 获取文章id
     *
     * @return article_id - 文章id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置文章id
     *
     * @param articleId 文章id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * @return article_title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * @param articleTitle
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 获取推送时间(天数)
     *
     * @return push_time - 推送时间(天数)
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     * 设置推送时间(天数)
     *
     * @param pushTime 推送时间(天数)
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    /**
     * 获取推送人数
     *
     * @return push_num - 推送人数
     */
    public Integer getPushNum() {
        return pushNum;
    }

    /**
     * 设置推送人数
     *
     * @param pushNum 推送人数
     */
    public void setPushNum(Integer pushNum) {
        this.pushNum = pushNum;
    }

    /**
     * 获取当天打开推送文章的人数
     *
     * @return open_num - 当天打开推送文章的人数
     */
    public Integer getOpenNum() {
        return openNum;
    }

    /**
     * 设置当天打开推送文章的人数
     *
     * @param openNum 当天打开推送文章的人数
     */
    public void setOpenNum(Integer openNum) {
        this.openNum = openNum;
    }
}