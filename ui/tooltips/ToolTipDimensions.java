package com.scores365.ui.tooltips;
/* compiled from: ToolTipDimensions.kt */
/* loaded from: classes2.dex */
public final class ToolTipDimensions {
    private final int height;
    private final int width;

    public ToolTipDimensions(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public static /* synthetic */ ToolTipDimensions copy$default(ToolTipDimensions toolTipDimensions, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = toolTipDimensions.width;
        }
        if ((i12 & 2) != 0) {
            i11 = toolTipDimensions.height;
        }
        return toolTipDimensions.copy(i10, i11);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final ToolTipDimensions copy(int i10, int i11) {
        return new ToolTipDimensions(i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToolTipDimensions) {
            ToolTipDimensions toolTipDimensions = (ToolTipDimensions) obj;
            return this.width == toolTipDimensions.width && this.height == toolTipDimensions.height;
        }
        return false;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "ToolTipDimensions(width=" + this.width + ", height=" + this.height + ')';
    }
}
