package com.xmlconfig;

import java.util.List;

public class MenuController {
    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void selectAllMenu() {
        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage();
        }


    }
 }
