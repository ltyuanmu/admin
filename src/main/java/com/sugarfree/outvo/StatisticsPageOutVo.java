package com.sugarfree.outvo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/9
 */
@Data
public class StatisticsPageOutVo extends PageOutVo<StatisticsOutVo>{

    /**总推送人数*/
    private Integer totalPushNum;
    /**总打开人数人数*/
    private Integer totalOpenNum;
    /**总比例*/
    private String totalDensity;

}
