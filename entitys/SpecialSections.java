package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SpecialSections implements Serializable {
    @p9.c("HeaderUrl")
    public String Header_URL;
    @p9.c("MenuUrl")
    public String Menu_URL;
    @p9.c("MenuColor")
    public String Menu_color;
    @p9.c("MenuPosition")
    public String Menu_pos_string;
    @p9.c("MenuSelectedColor")
    public String Menu_selected_color;
    @p9.c("SectionId")
    public String SectionID;
    ArrayList<TabObj> tabs;

    public SpecialSections() {
        this.SectionID = "";
        this.Header_URL = "";
        this.Menu_URL = "";
        this.Menu_pos_string = "";
        this.Menu_color = "";
        this.Menu_selected_color = "";
    }

    public SpecialSections(String str, String str2, String str3, String str4, String str5, String str6) {
        this.Menu_pos_string = str4;
        this.SectionID = str;
        this.Header_URL = str2;
        this.Menu_URL = str3;
        this.Menu_color = str5;
        this.Menu_selected_color = str6;
    }

    public String getHeader_URL() {
        return this.Header_URL;
    }

    public String getMenu_URL() {
        return this.Menu_URL;
    }

    public String getMenu_color() {
        return this.Menu_color;
    }

    public String getMenu_pos_string() {
        return this.Menu_pos_string;
    }

    public String getMenu_selected_color() {
        return this.Menu_selected_color;
    }

    public String getSectionID() {
        return this.SectionID;
    }

    public String getSelectedTabColor() {
        return this.Menu_selected_color;
    }

    public String getTabColor() {
        return this.Menu_color;
    }

    public ArrayList<TabObj> getTabs() {
        return this.tabs;
    }

    public void setTabs(ArrayList<TabObj> arrayList) {
        this.tabs = arrayList;
    }
}
