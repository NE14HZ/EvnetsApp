package com.terri.hd.eventspro.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


// 阿里云OSS信息配置类
public class OssConfig {

    public String endpoint;

    public String accessKeyId;

    public String accessKeySecret;

    public String bucketName;

    public String fileHost;

    public String urlPrefix;

}
