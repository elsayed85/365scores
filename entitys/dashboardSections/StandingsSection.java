package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.StandingsObj;
import p9.c;
/* loaded from: classes2.dex */
public class StandingsSection extends AbstractSectionObject {
    @c("Data")
    private StandingsObj Data;
    @c("ShowOnlyTables")
    private boolean ShowOnlyTables;
    @c("HasBrackets")
    private boolean hasBrackets;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public StandingsObj getData() {
        return this.Data;
    }

    public boolean hasBrackets() {
        return this.hasBrackets;
    }

    public boolean isShowOnlyTables() {
        return this.ShowOnlyTables;
    }
}
