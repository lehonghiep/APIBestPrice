package com.honghiep.apibestprice.model.menuitem;

/**
 * Created by honghiep on 07/09/2017.
 */

public class MenuItemChild {

    private int idChild;

    private String titleChild;

    private String linkChild;

    public MenuItemChild(int idChild, String title, String link) {
        this.idChild=idChild;
        this.titleChild = title;
        this.linkChild = link;
    }

    public String getTitleChild() {
        return titleChild;
    }

    public String getLinkChild() {
        return linkChild;
    }
}
