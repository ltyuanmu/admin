package com.sugarfree.controller;

import com.sugarfree.invo.ColumnThirdInVo;
import com.sugarfree.outvo.ArticleSimpleOutVo;
import com.sugarfree.outvo.ColumnSimpleOutVo;
import com.sugarfree.outvo.ColumnThirdOutVo;
import com.sugarfree.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/8/27.
 */
@RestController
@RequestMapping("/third/column")
@PreAuthorize("hasRole('ADMIN')")
public class ThirdColumnController {

    @Autowired
    private ColumnService columnService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getColumnThirdList(){
        List<ColumnThirdOutVo> list = columnService.getColumnThirdList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveColumnThird(ColumnThirdInVo inVo){
        this.columnService.saveColumnThird(inVo);
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getArticleByColumnId(@PathVariable Integer id,ColumnThirdInVo inVo){
        this.columnService.modifyColumnThird(id, inVo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getArticleByColumnId(@PathVariable Integer id){
        this.columnService.deleteColumnThird(id);
        return ResponseEntity.ok().build();
    }
}
