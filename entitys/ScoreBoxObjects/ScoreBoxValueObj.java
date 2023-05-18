package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import p9.c;
/* loaded from: classes2.dex */
public class ScoreBoxValueObj extends BaseObj {
    @c("ColumnNum")
    private int columnNum = -1;
    @c("Value")
    private String value = null;

    public int getColumnNum() {
        return this.columnNum;
    }

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public String getValue() {
        return this.value;
    }
}
