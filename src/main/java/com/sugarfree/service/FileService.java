package com.sugarfree.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/21
 */
public interface FileService {
    /**
     * 传入文件返回url路径
     * @param inputStream
     * @return
     */
    String upload(InputStream inputStream,String suffixName) throws IOException;
}
