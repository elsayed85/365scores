package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.AthletesObj;
import p9.c;
/* loaded from: classes2.dex */
public class PlayersListSection extends AbstractSectionObject {
    @c("Data")
    private AthletesObj Data;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public AthletesObj getData() {
        return this.Data;
    }
}
