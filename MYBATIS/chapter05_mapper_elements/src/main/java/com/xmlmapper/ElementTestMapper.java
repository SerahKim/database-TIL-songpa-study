package com.xmlmapper;

import com.common.MenuAndCategoryDTO;
import com.common.MenuDTO;

import java.util.List;

public interface ElementTestMapper {
    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructor();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();
}
