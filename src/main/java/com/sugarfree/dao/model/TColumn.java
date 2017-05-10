package com.sugarfree.dao.model;

import javax.persistence.*;

@Table(name = "t_column")
public class TColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fk_menu_id")
    private Integer fkMenuId;

    private String img;

    @Column(name = "sub_title")
    private String subTitle;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return fk_menu_id
     */
    public Integer getFkMenuId() {
        return fkMenuId;
    }

    /**
     * @param fkMenuId
     */
    public void setFkMenuId(Integer fkMenuId) {
        this.fkMenuId = fkMenuId;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return sub_title
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * @param subTitle
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}