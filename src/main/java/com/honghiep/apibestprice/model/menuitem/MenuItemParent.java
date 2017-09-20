package com.honghiep.apibestprice.model.menuitem;

import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class MenuItemParent{
    private int idParent;

    private String titleParent;

    private String linkParent;

    private List<MenuItemChild>menuItemChildren;

    public MenuItemParent(int idParent, String title, String link, List<MenuItemChild>menuItemChildren) {
        this.idParent=idParent;
        this.menuItemChildren=menuItemChildren;
        this.titleParent =title;
        this.linkParent =link;
    }

    public List<MenuItemChild> getMenuItemChildren() {
        return menuItemChildren;
    }

    public String getTitleParent() {
        return titleParent;
    }

    public String getLinkParent() {
        return linkParent;
    }

    public int getIdParent() {
        return idParent;
    }
}
