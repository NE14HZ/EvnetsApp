package com.terri.hd.eventspro.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.terri.hd.eventspro.controller.FBEventController;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
@PropertySource("classpath:aliOss.properties")
@ConfigurationProperties(prefix = "oss")
@Data
public class AliOssUtil {

    private static final Logger logger = LoggerFactory.getLogger(FBEventController.class);

    private static String fileUrl = null;

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String fileHost;


    public String upload(File file){
        // String endpoint = ossConfig.getEndpoint();
        // String accessKeyId = ossConfig.getAccessKeyId();
        // String accessKeySecret = ossConfig.getAccessKeySecret();
        // String bucketName = ossConfig.getBucketName();
        // String fileHost = ossConfig.getFileHost();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());

        UUID uuid = UUID.randomUUID();

        if(null == file){
            return null;
        }

        OSSClient ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        try {
            //容器不存在，就创建
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            fileUrl = fileHost+"/"+(dateStr + "/" + uuid.toString().replace("-","")+"-"+file.getName());

            //获取访问URL
            //设置访问URL过期时间
            Date expiration = new Date(new Date().getTime() + 3600L * 1000000L);
            GeneratePresignedUrlRequest generatePresignedUrlRequest;
            generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileUrl);
            generatePresignedUrlRequest.setExpiration(expiration);
            URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
            if(null != result){
                return url.toString();
            }
        }catch (ClientException ce){
            logger.info("", ce);
        }finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }

}
