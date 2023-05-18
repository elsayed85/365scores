package com.scores365.ui.tooltips;

import kotlin.jvm.internal.m;
/* compiled from: OffsetX.kt */
/* loaded from: classes2.dex */
public final class OffsetX {
    private final int offset;
    private final OffsetTypeX type;

    public OffsetX(int i10, OffsetTypeX type) {
        m.g(type, "type");
        this.offset = i10;
        this.type = type;
    }

    public static /* synthetic */ OffsetX copy$default(OffsetX offsetX, int i10, OffsetTypeX offsetTypeX, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = offsetX.offset;
        }
        if ((i11 & 2) != 0) {
            offsetTypeX = offsetX.type;
        }
        return offsetX.copy(i10, offsetTypeX);
    }

    public final int component1() {
        return this.offset;
    }

    public final OffsetTypeX component2() {
        return this.type;
    }

    public final OffsetX copy(int i10, OffsetTypeX type) {
        m.g(type, "type");
        return new OffsetX(i10, type);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetX) {
            OffsetX offsetX = (OffsetX) obj;
            return this.offset == offsetX.offset && this.type == offsetX.type;
        }
        return false;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final OffsetTypeX getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.offset * 31) + this.type.hashCode();
    }

    public String toString() {
        return "OffsetX(offset=" + this.offset + ", type=" + this.type + ')';
    }
}
