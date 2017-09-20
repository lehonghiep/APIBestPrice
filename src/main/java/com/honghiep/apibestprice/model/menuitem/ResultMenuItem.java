package com.honghiep.apibestprice.model.menuitem;

import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class ResultMenuItem {
    List<MenuItemParent> menuItems;

    public ResultMenuItem(List<MenuItemParent> menuItems) {
        this.menuItems = menuItems;
    }
}
