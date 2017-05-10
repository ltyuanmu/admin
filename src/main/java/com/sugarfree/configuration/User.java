package com.sugarfree.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@Component
@ConfigurationProperties(prefix = "user")
@Data
public class User {
    private String username;

    private String password;

    private Date lastPasswordResetDate = new Date(1494407475);

    private List<String> roles;
}
