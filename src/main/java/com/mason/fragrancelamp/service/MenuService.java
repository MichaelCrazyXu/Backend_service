package com.mason.fragrancelamp.service;

import com.mason.fragrancelamp.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    List<Menu> getMenus();

    int getTotalCount();

    int addMenu(@Param("menu") Menu menu);

    int updateMenu(Menu menu);

    int deleteMenuById(@Param("id") int id);

}
