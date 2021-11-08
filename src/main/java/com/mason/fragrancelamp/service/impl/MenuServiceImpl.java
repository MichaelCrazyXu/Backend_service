package com.mason.fragrancelamp.service.impl;

import com.mason.fragrancelamp.entity.Menu;
import com.mason.fragrancelamp.entity.PageRequest;
import com.mason.fragrancelamp.mapper.MenuMapper;
import com.mason.fragrancelamp.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenus() {
        List<Menu> menuList = menuMapper.getMenus();
        return menuList;
    }

    @Override
    public int getTotalCount() {
        int total = menuMapper.getTotalCount();
        return total;
    }

    @Override
    public int addMenu(Menu menu) {
        menuMapper.addMenu(menu);

        int id = menu.getMenu_id();

        return id;
    }

    @Override
    public int updateMenu(Menu menu) {
        int result = menuMapper.updateMenu(menu);
        return result;
    }

    @Override
    public int deleteMenuById(int id) {
        int result = menuMapper.deleteMenu(id);
        return result;
    }

}
