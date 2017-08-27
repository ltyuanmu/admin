package com.sugarfree.service;

import com.sugarfree.dao.model.TColumnThird;
import com.sugarfree.invo.ColumnThirdInVo;
import com.sugarfree.outvo.ArticleSimpleOutVo;
import com.sugarfree.outvo.ColumnSimpleOutVo;
import com.sugarfree.outvo.ColumnThirdOutVo;

import java.util.List;

/**
 * @ClassName: ${}
 * @Description:
 * @author: LT
 * @date: 2017/5/9
 */
public interface ColumnService {
    /**
     * 获得栏目列表
     * @return
     */
    List<ColumnSimpleOutVo> getSimpleColumnList();

    /**
     * 获得基本文章信息
     * @param columnId
     * @return
     */
    List<ArticleSimpleOutVo> getSimpleArticleList(Integer columnId);

    List<ColumnThirdOutVo> getColumnThirdList();

    void saveColumnThird(ColumnThirdInVo inVo);

    void modifyColumnThird(Integer id,ColumnThirdInVo inVo);

    void deleteColumnThird(Integer id);

}
