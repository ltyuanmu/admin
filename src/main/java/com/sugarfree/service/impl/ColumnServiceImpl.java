package com.sugarfree.service.impl;

import com.sugarfree.dao.mapper.TArticleMapper;
import com.sugarfree.dao.mapper.TMenuMapper;
import com.sugarfree.dao.model.TArticle;
import com.sugarfree.dao.model.TMenu;
import com.sugarfree.outvo.ArticleSimpleOutVo;
import com.sugarfree.outvo.ColumnSimpleOutVo;
import com.sugarfree.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/10
 */
@Service
@Transactional
public class ColumnServiceImpl implements ColumnService{
    @Autowired
    public TMenuMapper tMenuMapper;

    @Autowired
    public TArticleMapper tArticleMapper;

    @Override
    public List<ColumnSimpleOutVo> getSimpleColumnList() {
        Example example = new Example(TMenu.class);
        example.createCriteria()
                .andEqualTo("deleteState","0")
                .andLike("id","10%")
                .andNotEqualTo("id","10");
        example.orderBy("id").asc();
        List<TMenu> tMenus = this.tMenuMapper.selectByExample(example);
        return tMenus.stream().map(t->{
            ColumnSimpleOutVo outVo = new ColumnSimpleOutVo();
            outVo.setColumnId(t.getId());
            outVo.setColumnName(t.getName());
            return outVo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ArticleSimpleOutVo> getSimpleArticleList(Integer columnId) {
        Example example = new Example(TArticle.class);
        example.createCriteria()
                .andEqualTo("deleteState","0")
                .andEqualTo("fkMenuId",columnId);
        example.orderBy("id").asc();
        List<TArticle> tArticles = this.tArticleMapper.selectByExample(example);
        return tArticles.stream().map(t -> {
            ArticleSimpleOutVo outVo = new ArticleSimpleOutVo();
            outVo.setArticleId(t.getId());
            outVo.setArticleTitle(t.getTitle());
            return outVo;
        }).collect(Collectors.toList());
    }


}
