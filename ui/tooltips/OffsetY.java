package com.scores365.ui.tooltips;

import kotlin.jvm.internal.m;
/* compiled from: OffsetY.kt */
/* loaded from: classes2.dex */
public final class OffsetY {
    private final int offset;
    private final OffsetTypeY type;

    public OffsetY(int i10, OffsetTypeY type) {
        m.g(type, "type");
        this.offset = i10;
        this.type = type;
    }

    public static /* synthetic */ OffsetY copy$default(OffsetY offsetY, int i10, OffsetTypeY offsetTypeY, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = offsetY.offset;
        }
        if ((i11 & 2) != 0) {
            offsetTypeY = offsetY.type;
        }
        return offsetY.copy(i10, offsetTypeY);
    }

    public final int component1() {
        return this.offset;
    }

    public final OffsetTypeY component2() {
        return this.type;
    }

    public final OffsetY copy(int i10, OffsetTypeY type) {
        m.g(type, "type");
        return new OffsetY(i10, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetY) {
            OffsetY offsetY = (OffsetY) obj;
            return this.offset == offsetY.offset && this.type == offsetY.type;
        }
        return false;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final OffsetTypeY getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.offset * 31) + this.type.hashCode();
    }

    public String toString() {
        return "OffsetY(offset=" + this.offset + ", type=" + this.type + ')';
    }
}
