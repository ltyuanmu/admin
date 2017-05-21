package com.sugarfree.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.sugarfree.configuration.FileConfig;
import com.sugarfree.service.FileService;
import com.sugarfree.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/21
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService{

    @Autowired
    private FileConfig fileConfig;

    @Override
    public String upload(InputStream inputStream,String suffixName) throws IOException {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = fileConfig.getAccessKey();
        String secretKey = fileConfig.getSecretKey();
        String bucket = fileConfig.getBucket();
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = StringUtil.generateShortUuid()+suffixName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(inputStream,key,upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            log.info(putRet.key);
            log.info(putRet.hash);
            return fileConfig.getDomainOfBucket()+putRet.key;
        } catch (QiniuException ex) {
            throw new IOException(ex);
        }
    }

}
