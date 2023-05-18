package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.NewsObj;
import p9.c;
/* loaded from: classes2.dex */
public class BuzzSection extends AbstractSectionObject {
    @c("Data")
    private NewsObj Data;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public NewsObj getData() {
        return this.Data;
    }
}
