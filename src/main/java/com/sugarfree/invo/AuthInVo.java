package com.sugarfree.invo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@Data
public class AuthInVo implements Serializable{
    private String username;
    private String password;
}
