package com.sugarfree.invo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/27.
 */
@Data
public class ColumnThirdInVo implements Serializable {
    /**名称*/
    private String columnName;
    /**描述*/
    private String columnDesc;
    /**更新数量*/
    private Integer updateNum;
    /**订阅数量*/
    private Integer subNum;
    /**图片*/
    private String img;
    /**路径*/
    private String url;
    /**排序*/
    private Integer sort;
}
