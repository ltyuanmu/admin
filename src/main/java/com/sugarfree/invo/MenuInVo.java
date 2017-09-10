package com.sugarfree.invo;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/10.
 */
@Data
public class MenuInVo implements Serializable {

    private String name;

    private String menuDesc;

    private String url;

    private String type;

    private Integer menuSort;
}
