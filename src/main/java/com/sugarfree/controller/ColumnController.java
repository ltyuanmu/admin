package com.sugarfree.controller;

import com.sugarfree.outvo.ArticleSimpleOutVo;
import com.sugarfree.outvo.ColumnSimpleOutVo;
import com.sugarfree.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@RestController
@RequestMapping("/column")
@PreAuthorize("hasRole('ADMIN')")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getColumns(){
        List<ColumnSimpleOutVo> simpleColumnList = columnService.getSimpleColumnList();
        return ResponseEntity.ok().body(simpleColumnList);
    }

    @GetMapping(value = "/{columnId}/article", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getArticleByColumnId(@PathVariable Integer columnId){
        List<ArticleSimpleOutVo> simpleArticleList = columnService.getSimpleArticleList(columnId);
        return ResponseEntity.ok().body(simpleArticleList);
    }
}
