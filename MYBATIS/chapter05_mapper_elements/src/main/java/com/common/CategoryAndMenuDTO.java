package com.common;

import java.util.List;

public class CategoryAndMenuDTO {
    private int code;
    private String name;
    private Integer refCategoryCode;
    private List<MenuDTO> menuDTOList;

    public CategoryAndMenuDTO() {}

    public CategoryAndMenuDTO(int code, String name, Integer refCategoryCode, List<MenuDTO> menuDTOList) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
        this.menuDTOList = menuDTOList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<MenuDTO> getMenuDTOList() {
        return menuDTOList;
    }

    public void setMenuDTOList(List<MenuDTO> menuDTOList) {
        this.menuDTOList = menuDTOList;
    }

    @Override
    public String toString() {
        return "CategoryAndMenuDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuDTOList=" + menuDTOList +
                '}';
    }
}
