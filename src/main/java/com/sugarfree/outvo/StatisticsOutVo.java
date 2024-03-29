package com.sugarfree.outvo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/9
 */
@Data
public class StatisticsOutVo {
    /**栏目id*/
    private Integer columnId;
    /**栏目名*/
    private String columnName;
    /**文章id*/
    private Integer articleId;
    /**文章名*/
    private String articleTitle;
    /**推送人数*/
    private Integer pushNum;
    /**推送时间*/
    private Date pushTime;
    /**打开人数*/
    private Integer openNum;
    /**比例*/
    private String density;

}
