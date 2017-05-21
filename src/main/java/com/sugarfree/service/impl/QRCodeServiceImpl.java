package com.sugarfree.service.impl;

import com.sugarfree.dao.mapper.TBaseMapMapper;
import com.sugarfree.dao.model.TBaseMap;
import com.sugarfree.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QRCodeServiceImpl implements QRCodeService {

    @Autowired
    private TBaseMapMapper tBaseMapMapper;

    @Override
    public String addBaseMap(String url) {
        return modifyBaseMap(url);
    }

    @Override
    public String modifyBaseMap(String url) {
        TBaseMap baseMapBean = getBaseMapBean();
        if(baseMapBean==null){
            TBaseMap baseMap = new TBaseMap();
            baseMap.setUrl(url);
            baseMap.setDeleteState(false);
            this.tBaseMapMapper.insertSelective(baseMap);
            return url;
        }else{
            baseMapBean.setUrl(url);
            this.tBaseMapMapper.updateByPrimaryKey(baseMapBean);
            return url;
        }
    }

    @Override
    public String getBaseMap() {
        return Optional.ofNullable(getBaseMapBean()).map(TBaseMap::getUrl).orElse(null);
    }

    @Override
    public void deleteBaseMap() {
        TBaseMap baseMapBean = getBaseMapBean();
        if(baseMapBean!=null){
            baseMapBean.setDeleteState(true);
            this.tBaseMapMapper.updateByPrimaryKey(baseMapBean);
        }
    }

    @Override
    public TBaseMap getBaseMapBean() {
        TBaseMap baseMap = new TBaseMap();
        baseMap.setDeleteState(false);
        List<TBaseMap> select = this.tBaseMapMapper.select(baseMap);
        return select.stream().findFirst().orElse(null);
    }
}
