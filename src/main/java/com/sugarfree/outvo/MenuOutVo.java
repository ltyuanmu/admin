package com.sugarfree.outvo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/10.
 */
@Data
public class MenuOutVo implements Serializable {
    private Integer id;

    private String name;

    private String menuDesc;

    private String url;

    private String type;

    private Integer menuSort;
}
