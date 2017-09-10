package com.sugarfree.service;

import com.sugarfree.dao.model.TMenuNew;
import com.sugarfree.invo.MenuInVo;
import com.sugarfree.outvo.MenuOutVo;

import java.util.List;

/**
 * Created by Administrator on 2017/9/10.
 */
public interface MenuService {
    List<MenuOutVo> getMenuList();

    void modifyMenu(Integer id,MenuInVo inVo);

    void createMenu(Integer id,MenuInVo inVo);

    void deleteMenu(Integer id);
}
