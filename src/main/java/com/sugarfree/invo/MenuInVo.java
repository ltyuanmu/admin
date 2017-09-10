package com.sugarfree.invo;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/10.
 */
@Data
public class MenuInVo {

    private String name;

    private String menuDesc;

    private String url;

    private String type;

    private Integer menuSort;
}
