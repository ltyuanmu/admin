package com.sugarfree.invo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/9
 */
@Data
public class StatisticsInVo {
    /**开始时间*/
    private Date startDate;
    /**结束时间*/
    private Date endDate;
    /**栏目id*/
    private Integer columnId;
    /**文章id*/
    private Integer articleId;
}
