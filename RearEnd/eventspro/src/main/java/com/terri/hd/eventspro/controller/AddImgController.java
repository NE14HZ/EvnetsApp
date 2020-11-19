package com.terri.hd.eventspro.controller;

import com.terri.hd.eventspro.utils.AliyunOssUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/upload")
public class AddImgController {

    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

    /**
     * 文件上传
     * @param file
     */
    @RequestMapping(value = "/imgUpload",method = RequestMethod.POST)
    public String uploadBlog(MultipartFile file){
        String uploadUrl = null;
        try {
            if(null != file){
                String filename = file.getOriginalFilename();
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    uploadUrl= AliyunOssUtil.upload(newFile);
                }
            }
        }catch (Exception ex){
            logger.info("", ex);
        }
        //返回路径回前端
        return uploadUrl;
    }
}
