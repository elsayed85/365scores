package com.scores365.entitys.dashboardSections;

import com.scores365.entitys.OlympicMedalEntry;
import java.util.ArrayList;
import p9.c;
/* loaded from: classes2.dex */
public class OlympicsMedalsSection extends AbstractSectionObject {
    @c("Data")
    OlympicsMedalsRows mData;

    /* loaded from: classes2.dex */
    public class OlympicsMedalsRows {
        @c("Rows")
        ArrayList<OlympicMedalEntry> rows;

        public OlympicsMedalsRows() {
        }

        public ArrayList<OlympicMedalEntry> getRows() {
            return this.rows;
        }
    }

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public OlympicsMedalsRows getData() {
        return this.mData;
    }
}
