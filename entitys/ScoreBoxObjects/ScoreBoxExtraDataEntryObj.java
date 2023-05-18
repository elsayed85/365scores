package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import p9.c;
/* compiled from: ScoreBoxExtraDataEntryObj.kt */
/* loaded from: classes2.dex */
public final class ScoreBoxExtraDataEntryObj extends BaseObj {
    @c("Data")
    private ArrayList<ScoreBoxExtraDataEntryParamObj> data;

    public final ArrayList<ScoreBoxExtraDataEntryParamObj> getData() {
        return this.data;
    }

    public final void setData(ArrayList<ScoreBoxExtraDataEntryParamObj> arrayList) {
        this.data = arrayList;
    }
}
