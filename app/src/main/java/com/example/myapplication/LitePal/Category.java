package com.example.myapplication.LitePal;

import org.litepal.crud.LitePalSupport;

public class Category extends LitePalSupport {
    private int id;
    private String categoryName;
    int categoryCode;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
