package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import p9.c;
/* loaded from: classes2.dex */
public class ScoreBoxColumnsObj extends BaseObj {
    @c("Num")
    private int num = -1;
    @c("Order")
    private int order = -1;
    @c("ExtendedOrder")
    private int extendedOrder = -1;
    @c("ShortName")
    private String shortName = null;
    @c("Extended")
    private boolean extended = false;

    public int getExtendedOrder() {
        return this.extendedOrder;
    }

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public int getNum() {
        return this.num;
    }

    public int getOrder() {
        return this.order;
    }

    public String getShortName() {
        return this.shortName;
    }

    public boolean isExtended() {
        return this.extended;
    }
}
