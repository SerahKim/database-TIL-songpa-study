package com.xmlconfig;

import java.awt.*;
import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        for(MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }

    public void printErrorMessage() {
    }
}
