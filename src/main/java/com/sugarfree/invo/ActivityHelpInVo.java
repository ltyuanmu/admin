package com.sugarfree.invo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityHelpInVo extends BasePageParamInVo {

    private Integer activityJoinId;
}
