package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.ChartDashboardData;
import p9.c;
/* loaded from: classes2.dex */
public class TopScorerSection extends AbstractSectionObject {
    @c("Data")
    private ChartDashboardData Data;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public ChartDashboardData getData() {
        return this.Data;
    }
}
