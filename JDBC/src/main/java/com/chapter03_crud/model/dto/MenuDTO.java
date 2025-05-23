package com.chapter03_crud.model.dto;

public class MenuDTO {
    private int code;
    private  String name;
    private int price;
    private int categoryCode;
    private String orderable;

    public MenuDTO() {}


    public MenuDTO(int code, String name, int price, int categoryCode, String orderable) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.orderable = orderable;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getcategoryCode() {
        return categoryCode;
    }

    public void setcategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderable() {
        return orderable;
    }

    public void setOrderable(String orderable) {
        this.orderable = orderable;
    }

    @Override
    public String toString() {
        return "menuDTO{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderable='" + orderable + '\'' +
                '}';
    }
}
