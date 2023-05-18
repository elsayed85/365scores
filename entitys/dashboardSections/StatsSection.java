package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.StatsDashboardData;
import p9.c;
/* loaded from: classes2.dex */
public class StatsSection extends AbstractSectionObject {
    @c("Data")
    private StatsDashboardData Data;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public Object getData() {
        return this.Data;
    }
}
