package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "section02Category")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Menu> menuList;

    protected Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public void setMenuList(List<Menu> menuList) {
    }
}
