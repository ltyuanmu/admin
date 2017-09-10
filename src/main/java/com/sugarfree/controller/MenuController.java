package com.sugarfree.controller;

import com.sugarfree.invo.ColumnThirdInVo;
import com.sugarfree.invo.MenuInVo;
import com.sugarfree.outvo.ColumnThirdOutVo;
import com.sugarfree.outvo.MenuOutVo;
import com.sugarfree.service.ColumnService;
import com.sugarfree.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/9/10.
 */
@RestController
@RequestMapping("/menu")
@PreAuthorize("hasRole('ADMIN')")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getMenuList(){
        List<MenuOutVo> list = menuService.getMenuList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity createMenu(MenuInVo inVo,Integer id){
        this.menuService.createMenu(id,inVo);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity modifyMenu(@PathVariable Integer id,MenuInVo inVo){
        this.menuService.modifyMenu(id, inVo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deleteMenu(@PathVariable Integer id){
        this.menuService.deleteMenu(id);
        return ResponseEntity.ok().build();
    }
}
