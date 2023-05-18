package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.OlympicEntityObj;
import java.util.ArrayList;
import p9.c;
/* loaded from: classes2.dex */
public class OlympicsLegendsSection extends AbstractSectionObject {
    @c("Data")
    ArrayList<OlympicEntityObj> mData;

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public ArrayList<OlympicEntityObj> getData() {
        return this.mData;
    }
}
