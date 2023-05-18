package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import p9.c;
/* loaded from: classes2.dex */
public class ScoreBoxSummaryObj extends BaseObj {
    @c("Title")
    private String title = null;
    @c("Values")
    private ArrayList<ScoreBoxValueObj> valueObjs = null;

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<ScoreBoxValueObj> getValueObjs() {
        return this.valueObjs;
    }
}
