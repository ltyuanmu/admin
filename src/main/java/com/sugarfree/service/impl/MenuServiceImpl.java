package com.sugarfree.service.impl;

import com.sugarfree.dao.mapper.TMenuNewMapper;
import com.sugarfree.dao.model.TMenuNew;
import com.sugarfree.invo.MenuInVo;
import com.sugarfree.outvo.MenuOutVo;
import com.sugarfree.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/9/10.
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService{

    @Autowired
    private TMenuNewMapper tMenuNewMapper;

    @Override
    public List<MenuOutVo> getMenuList() {
        return this.tMenuNewMapper.selectAll().stream().map(t -> {
            MenuOutVo outVo = new MenuOutVo();
            BeanUtils.copyProperties(t, outVo);
            return outVo;
        }).collect(Collectors.toList());
    }

    @Override
    public void modifyMenu(Integer id, MenuInVo inVo) {
        TMenuNew tMenuNew = new TMenuNew();
        tMenuNew.setId(id);
        BeanUtils.copyProperties(inVo, tMenuNew);
        tMenuNew.setUpdateTime(new Date());
        this.tMenuNewMapper.updateByPrimaryKeySelective(tMenuNew);
    }

    @Override
    public void createMenu(Integer id, MenuInVo inVo) {
        TMenuNew tMenuNew = new TMenuNew();
        tMenuNew.setId(id);
        BeanUtils.copyProperties(inVo, tMenuNew);
        tMenuNew.setCreateTime(new Date());
        tMenuNew.setUpdateTime(new Date());
        tMenuNew.setDeleteState("0");
        this.tMenuNewMapper.insertSelective(tMenuNew);
    }

    @Override
    public void deleteMenu(Integer id) {
        TMenuNew tMenuNew = new TMenuNew();
        tMenuNew.setId(id);
        tMenuNew.setUpdateTime(new Date());
        tMenuNew.setDeleteState("0");
        this.tMenuNewMapper.updateByPrimaryKeySelective(tMenuNew);
    }
}
