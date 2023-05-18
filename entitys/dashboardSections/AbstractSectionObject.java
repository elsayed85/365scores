package com.scores365.entitys.dashboardSections;

import li.x0;
import nb.o;
import p9.c;
/* loaded from: classes2.dex */
public abstract class AbstractSectionObject {
    @c("Name")
    private String Name;
    @c("SType")
    private int SType;
    @c("Live")
    private boolean isLive;
    @c("Key")
    private String key;
    @c("Default")
    public boolean openByDefault = false;
    @c("IconKey")
    private String iconKey = "";
    @c("Group")
    private int sectionGroup = -1;

    public abstract Object getData();

    public String getIconKey() {
        return this.iconKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.Name;
    }

    public int getSType() {
        return this.SType;
    }

    public int getSectionGroup() {
        return this.sectionGroup;
    }

    public String getSelectedIconUrl() {
        try {
            return o.j(getIconKey(), true);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getUnSelectedIconUrl() {
        try {
            return o.j(getIconKey(), false);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setAdditionalData() {
    }
}
