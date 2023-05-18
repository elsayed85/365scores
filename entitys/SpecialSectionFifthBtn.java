package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SpecialSectionFifthBtn extends MonetizationSectionObj {
    @p9.c("Tabs")
    public ArrayList<TabObj> tabs = new ArrayList<>();
    @p9.c("EntityId")
    public int entityID = -1;
    @p9.c("EntityType")
    public int entityType = -1;

    public int getEntityID() {
        return this.entityID;
    }

    public int getEntityType() {
        return this.entityType;
    }

    @Override // com.scores365.entitys.SpecialSections
    public ArrayList<TabObj> getTabs() {
        return this.tabs;
    }
}
