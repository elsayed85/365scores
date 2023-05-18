package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.GamesObj;
import p9.c;
/* loaded from: classes2.dex */
public class GroupsSection extends AbstractSectionObject {
    @c("Data")
    private GamesObj Data;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public Object getData() {
        return this.Data;
    }
}
