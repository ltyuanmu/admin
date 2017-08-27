package com.sugarfree.service.impl;

import com.sugarfree.dao.mapper.TArticleMapper;
import com.sugarfree.dao.mapper.TColumnThirdMapper;
import com.sugarfree.dao.mapper.TMenuMapper;
import com.sugarfree.dao.model.TArticle;
import com.sugarfree.dao.model.TColumnThird;
import com.sugarfree.dao.model.TMenu;
import com.sugarfree.invo.ColumnThirdInVo;
import com.sugarfree.outvo.ArticleSimpleOutVo;
import com.sugarfree.outvo.ColumnSimpleOutVo;
import com.sugarfree.outvo.ColumnThirdOutVo;
import com.sugarfree.service.ColumnService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    @Autowired
    public TColumnThirdMapper tColumnThirdMapper;

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

    @Override
    public List<ColumnThirdOutVo> getColumnThirdList() {
        TColumnThird tColumnThird = new TColumnThird();
        tColumnThird.setDeleteState("0");
        List<TColumnThird> list = this.tColumnThirdMapper.select(tColumnThird);
        List<ColumnThirdOutVo> outVos = list.stream().map(t -> {
            ColumnThirdOutVo outVo = new ColumnThirdOutVo();
            BeanUtils.copyProperties(t, outVo);
            return outVo;
        }).collect(Collectors.toList());
        outVos.sort((t1,t2)->t1.getSort()-t2.getSort());

        return outVos;
    }

    @Override
    public void saveColumnThird(ColumnThirdInVo inVo) {
        TColumnThird tColumnThird = new TColumnThird();
        BeanUtils.copyProperties(inVo, tColumnThird);
        tColumnThird.setDeleteState("0");
        tColumnThird.setCreateTime(new Date());
        this.tColumnThirdMapper.insertSelective(tColumnThird);
    }

    @Override
    public void modifyColumnThird(Integer id, ColumnThirdInVo inVo) {
        TColumnThird tColumnThird = new TColumnThird();
        BeanUtils.copyProperties(inVo, tColumnThird);
        tColumnThird.setId(id);
        this.tColumnThirdMapper.updateByPrimaryKeySelective(tColumnThird);
    }

    @Override
    public void deleteColumnThird(Integer id) {
        TColumnThird tColumnThird = new TColumnThird();
        tColumnThird.setId(id);
        tColumnThird.setDeleteState("1");
        this.tColumnThirdMapper.updateByPrimaryKeySelective(tColumnThird);
    }


}
