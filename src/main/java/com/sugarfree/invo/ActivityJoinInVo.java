package com.sugarfree.invo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityJoinInVo extends BasePageParamInVo {

    private Integer activityId;
}
