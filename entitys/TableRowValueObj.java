package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class TableRowValueObj implements Serializable {
    public boolean isDirty;
    public boolean isExpanded;
    public Object object;
    public int width;

    public TableRowValueObj(boolean z10, Object obj, boolean z11) {
        this.isDirty = z10;
        this.object = obj;
        this.isExpanded = z11;
        this.width = -1;
    }

    public TableRowValueObj(boolean z10, Object obj, boolean z11, int i10) {
        this.isDirty = z10;
        this.object = obj;
        this.isExpanded = z11;
        this.width = i10;
    }
}
