package com.sugarfree.service;

import com.sugarfree.dao.model.TBaseMap;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/21
 */
public interface QRCodeService {
    /**
     * 添加底图
     * @param url 路径
     */
    String addBaseMap(String url);
    /**
     *修改底图
     * @param url 路径
     */
    String modifyBaseMap(String url);
    /**
     *获得底图
     */
    String getBaseMap();

    void deleteBaseMap();

    /**
     * 获得底图
     * @return
     */
    TBaseMap getBaseMapBean();
}
