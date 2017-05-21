package com.sugarfree.configuration;

import com.qiniu.common.Zone;
import com.qiniu.util.Auth;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/21
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
@Data
public class FileConfig {

    private String accessKey;
    private String secretKey;
    private String bucket;
    private String domainOfBucket;

}
