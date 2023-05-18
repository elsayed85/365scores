package com.scores365.ui.tooltips;

import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.scores365.ui.tooltips.ToolTipFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
/* compiled from: ToolTipData.kt */
/* loaded from: classes2.dex */
public final class ToolTipData {
    private final View.OnClickListener clickListener;
    private final ToolTipFactory.ToolTipDismissListener dismissListener;
    private long dismissTime;
    private final int imgRes;
    private boolean isDismissTimerEnabled;
    private final boolean isFadeInAnimationEnabled;
    private final OffsetX offsetX;
    private final OffsetY offsetY;
    private final int parentHeight;
    private final int parentWidth;
    private final String text;
    private final int textColor;
    private final int textHeight;
    private final float textSize;
    private final int textWidth;
    private final ToolTipMarginData toolTipMargins;
    private final int xPos;
    private final int yPos;

    /* compiled from: ToolTipData.kt */
    /* loaded from: classes2.dex */
    public static final class ToolTipBuilder {
        private View.OnClickListener clickListener;
        private ToolTipFactory.ToolTipDismissListener dismissListener;
        private long dismissToolTipTime;
        private int imgRes;
        private boolean isDismissTimerEnabled;
        private boolean isFadeInAnimationEnabled;
        private OffsetX offsetX;
        private OffsetY offsetY;
        private int parentHeight;
        private int parentWidth;
        private String text;
        private int textColor;
        private int textHeight;
        private float textSize;
        private int textWidth;
        private ToolTipMarginData toolTipMargins;

        /* renamed from: x  reason: collision with root package name */
        private int f24418x;

        /* renamed from: y  reason: collision with root package name */
        private int f24419y;

        public ToolTipBuilder() {
            this(null, 0, 0, 0, null, null, false, 0L, null, null, 0, 0, 0, 0, null, 0.0f, 0, false, 262143, null);
        }

        public ToolTipBuilder(String str, int i10, int i11, int i12, OffsetX offsetX, OffsetY offsetY, boolean z10, long j10, ToolTipFactory.ToolTipDismissListener toolTipDismissListener, View.OnClickListener onClickListener, int i13, int i14, int i15, int i16, ToolTipMarginData toolTipMarginData, float f10, int i17, boolean z11) {
            m.g(offsetX, "offsetX");
            m.g(offsetY, "offsetY");
            this.text = str;
            this.imgRes = i10;
            this.f24418x = i11;
            this.f24419y = i12;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.isDismissTimerEnabled = z10;
            this.dismissToolTipTime = j10;
            this.dismissListener = toolTipDismissListener;
            this.clickListener = onClickListener;
            this.parentWidth = i13;
            this.parentHeight = i14;
            this.textWidth = i15;
            this.textHeight = i16;
            this.toolTipMargins = toolTipMarginData;
            this.textSize = f10;
            this.textColor = i17;
            this.isFadeInAnimationEnabled = z11;
        }

        public /* synthetic */ ToolTipBuilder(String str, int i10, int i11, int i12, OffsetX offsetX, OffsetY offsetY, boolean z10, long j10, ToolTipFactory.ToolTipDismissListener toolTipDismissListener, View.OnClickListener onClickListener, int i13, int i14, int i15, int i16, ToolTipMarginData toolTipMarginData, float f10, int i17, boolean z11, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? -1 : i10, (i18 & 4) != 0 ? 0 : i11, (i18 & 8) != 0 ? 0 : i12, (i18 & 16) != 0 ? new OffsetX(0, OffsetTypeX.NONE) : offsetX, (i18 & 32) != 0 ? new OffsetY(0, OffsetTypeY.NONE) : offsetY, (i18 & 64) != 0 ? false : z10, (i18 & UserVerificationMethods.USER_VERIFY_PATTERN) != 0 ? 5000L : j10, (i18 & 256) != 0 ? null : toolTipDismissListener, (i18 & 512) != 0 ? null : onClickListener, (i18 & UserVerificationMethods.USER_VERIFY_ALL) != 0 ? 0 : i13, (i18 & 2048) != 0 ? 0 : i14, (i18 & 4096) != 0 ? 0 : i15, (i18 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0 : i16, (i18 & 16384) != 0 ? null : toolTipMarginData, (i18 & 32768) != 0 ? 13.0f : f10, (i18 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? 0 : i17, (i18 & 131072) != 0 ? false : z11);
        }

        public final ToolTipData build() {
            ToolTipData toolTipData = new ToolTipData(this.text, this.imgRes, this.f24418x, this.f24419y, this.offsetX, this.offsetY, false, this.dismissListener, this.clickListener, this.parentWidth, this.parentHeight, this.textWidth, this.textHeight, this.toolTipMargins, this.textSize, this.textColor, this.isFadeInAnimationEnabled, 64, null);
            toolTipData.setDismissTime(this.dismissToolTipTime);
            return toolTipData;
        }

        public final ToolTipBuilder dismissTime(long j10) {
            this.dismissToolTipTime = j10 * 1000;
            return this;
        }

        public final View.OnClickListener getClickListener() {
            return this.clickListener;
        }

        public final ToolTipFactory.ToolTipDismissListener getDismissListener() {
            return this.dismissListener;
        }

        public final long getDismissToolTipTime() {
            return this.dismissToolTipTime;
        }

        public final OffsetX getOffsetX() {
            return this.offsetX;
        }

        public final OffsetY getOffsetY() {
            return this.offsetY;
        }

        public final int getParentHeight() {
            return this.parentHeight;
        }

        public final int getParentWidth() {
            return this.parentWidth;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final int getTextHeight() {
            return this.textHeight;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        public final int getTextWidth() {
            return this.textWidth;
        }

        public final ToolTipMarginData getToolTipMargins() {
            return this.toolTipMargins;
        }

        public final int getX() {
            return this.f24418x;
        }

        public final int getY() {
            return this.f24419y;
        }

        public final ToolTipBuilder imageResource(int i10) {
            this.imgRes = i10;
            return this;
        }

        public final ToolTipBuilder isDismissTimerEnabled(boolean z10) {
            this.isDismissTimerEnabled = z10;
            return this;
        }

        public final boolean isDismissTimerEnabled() {
            return this.isDismissTimerEnabled;
        }

        public final boolean isFadeInAnimationEnabled() {
            return this.isFadeInAnimationEnabled;
        }

        public final ToolTipBuilder offsetX(OffsetX offsetX) {
            m.g(offsetX, "offsetX");
            this.offsetX = offsetX;
            return this;
        }

        public final ToolTipBuilder offsetY(OffsetY offsetY) {
            m.g(offsetY, "offsetY");
            this.offsetY = offsetY;
            return this;
        }

        public final ToolTipBuilder onDismissListener(ToolTipFactory.ToolTipDismissListener listener) {
            m.g(listener, "listener");
            this.dismissListener = listener;
            return this;
        }

        public final void setClickListener(View.OnClickListener onClickListener) {
            this.clickListener = onClickListener;
        }

        public final void setDismissListener(ToolTipFactory.ToolTipDismissListener toolTipDismissListener) {
            this.dismissListener = toolTipDismissListener;
        }

        public final void setDismissTimerEnabled(boolean z10) {
            this.isDismissTimerEnabled = z10;
        }

        public final void setDismissToolTipTime(long j10) {
            this.dismissToolTipTime = j10;
        }

        public final ToolTipBuilder setFadeInAnimation(boolean z10) {
            this.isFadeInAnimationEnabled = z10;
            return this;
        }

        public final void setFadeInAnimationEnabled(boolean z10) {
            this.isFadeInAnimationEnabled = z10;
        }

        public final void setOffsetX(OffsetX offsetX) {
            m.g(offsetX, "<set-?>");
            this.offsetX = offsetX;
        }

        public final void setOffsetY(OffsetY offsetY) {
            m.g(offsetY, "<set-?>");
            this.offsetY = offsetY;
        }

        public final ToolTipBuilder setOnClickListener(View.OnClickListener onClickListener) {
            this.clickListener = onClickListener;
            return this;
        }

        public final void setParentHeight(int i10) {
            this.parentHeight = i10;
        }

        public final ToolTipBuilder setParentViewHeight(int i10) {
            this.parentHeight = i10;
            return this;
        }

        public final ToolTipBuilder setParentWidth(int i10) {
            this.parentWidth = i10;
            return this;
        }

        /* renamed from: setParentWidth  reason: collision with other method in class */
        public final void m175setParentWidth(int i10) {
            this.parentWidth = i10;
        }

        public final ToolTipBuilder setTextColor(int i10) {
            this.textColor = i10;
            return this;
        }

        /* renamed from: setTextColor  reason: collision with other method in class */
        public final void m176setTextColor(int i10) {
            this.textColor = i10;
        }

        public final void setTextHeight(int i10) {
            this.textHeight = i10;
        }

        public final ToolTipBuilder setTextSize(float f10) {
            this.textSize = f10;
            return this;
        }

        /* renamed from: setTextSize  reason: collision with other method in class */
        public final void m177setTextSize(float f10) {
            this.textSize = f10;
        }

        public final ToolTipBuilder setTextViewHeight(int i10) {
            this.textHeight = i10;
            return this;
        }

        public final ToolTipBuilder setTextWidth(int i10) {
            this.textWidth = i10;
            return this;
        }

        /* renamed from: setTextWidth  reason: collision with other method in class */
        public final void m178setTextWidth(int i10) {
            this.textWidth = i10;
        }

        public final ToolTipBuilder setToolTipMargins(ToolTipMarginData marginData) {
            m.g(marginData, "marginData");
            this.toolTipMargins = marginData;
            return this;
        }

        /* renamed from: setToolTipMargins  reason: collision with other method in class */
        public final void m179setToolTipMargins(ToolTipMarginData toolTipMarginData) {
            this.toolTipMargins = toolTipMarginData;
        }

        public final void setX(int i10) {
            this.f24418x = i10;
        }

        public final void setY(int i10) {
            this.f24419y = i10;
        }

        public final ToolTipBuilder text(String text) {
            m.g(text, "text");
            this.text = text;
            return this;
        }

        public final ToolTipBuilder xPos(int i10) {
            this.f24418x = i10;
            return this;
        }

        public final ToolTipBuilder yPos(int i10) {
            this.f24419y = i10;
            return this;
        }
    }

    /* compiled from: ToolTipData.kt */
    /* loaded from: classes2.dex */
    public static final class ToolTipMarginData {
        private final int bottom;
        private final int end;
        private final int start;
        private final int top;

        public ToolTipMarginData() {
            this(0, 0, 0, 0, 15, null);
        }

        public ToolTipMarginData(int i10, int i11, int i12, int i13) {
            this.start = i10;
            this.top = i11;
            this.end = i12;
            this.bottom = i13;
        }

        public /* synthetic */ ToolTipMarginData(int i10, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
            this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13);
        }

        public static /* synthetic */ ToolTipMarginData copy$default(ToolTipMarginData toolTipMarginData, int i10, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                i10 = toolTipMarginData.start;
            }
            if ((i14 & 2) != 0) {
                i11 = toolTipMarginData.top;
            }
            if ((i14 & 4) != 0) {
                i12 = toolTipMarginData.end;
            }
            if ((i14 & 8) != 0) {
                i13 = toolTipMarginData.bottom;
            }
            return toolTipMarginData.copy(i10, i11, i12, i13);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.top;
        }

        public final int component3() {
            return this.end;
        }

        public final int component4() {
            return this.bottom;
        }

        public final ToolTipMarginData copy(int i10, int i11, int i12, int i13) {
            return new ToolTipMarginData(i10, i11, i12, i13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToolTipMarginData) {
                ToolTipMarginData toolTipMarginData = (ToolTipMarginData) obj;
                return this.start == toolTipMarginData.start && this.top == toolTipMarginData.top && this.end == toolTipMarginData.end && this.bottom == toolTipMarginData.bottom;
            }
            return false;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getTop() {
            return this.top;
        }

        public int hashCode() {
            return (((((this.start * 31) + this.top) * 31) + this.end) * 31) + this.bottom;
        }

        public String toString() {
            return "ToolTipMarginData(start=" + this.start + ", top=" + this.top + ", end=" + this.end + ", bottom=" + this.bottom + ')';
        }
    }

    private ToolTipData(String str, int i10, int i11, int i12, OffsetX offsetX, OffsetY offsetY, boolean z10, ToolTipFactory.ToolTipDismissListener toolTipDismissListener, View.OnClickListener onClickListener, int i13, int i14, int i15, int i16, ToolTipMarginData toolTipMarginData, float f10, int i17, boolean z11) {
        this.text = str;
        this.imgRes = i10;
        this.xPos = i11;
        this.yPos = i12;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.isDismissTimerEnabled = z10;
        this.dismissListener = toolTipDismissListener;
        this.clickListener = onClickListener;
        this.parentWidth = i13;
        this.parentHeight = i14;
        this.textWidth = i15;
        this.textHeight = i16;
        this.toolTipMargins = toolTipMarginData;
        this.textSize = f10;
        this.textColor = i17;
        this.isFadeInAnimationEnabled = z11;
    }

    /* synthetic */ ToolTipData(String str, int i10, int i11, int i12, OffsetX offsetX, OffsetY offsetY, boolean z10, ToolTipFactory.ToolTipDismissListener toolTipDismissListener, View.OnClickListener onClickListener, int i13, int i14, int i15, int i16, ToolTipMarginData toolTipMarginData, float f10, int i17, boolean z11, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? null : str, (i18 & 2) != 0 ? -1 : i10, (i18 & 4) != 0 ? 0 : i11, (i18 & 8) != 0 ? 0 : i12, (i18 & 16) != 0 ? new OffsetX(0, OffsetTypeX.NONE) : offsetX, (i18 & 32) != 0 ? new OffsetY(0, OffsetTypeY.NONE) : offsetY, (i18 & 64) != 0 ? false : z10, (i18 & UserVerificationMethods.USER_VERIFY_PATTERN) != 0 ? null : toolTipDismissListener, (i18 & 256) != 0 ? null : onClickListener, (i18 & 512) != 0 ? 0 : i13, (i18 & UserVerificationMethods.USER_VERIFY_ALL) != 0 ? 0 : i14, (i18 & 2048) != 0 ? 0 : i15, (i18 & 4096) != 0 ? 0 : i16, (i18 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : toolTipMarginData, (i18 & 16384) != 0 ? 13.0f : f10, (i18 & 32768) != 0 ? 0 : i17, (i18 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? false : z11);
    }

    public final View.OnClickListener getClickListener() {
        return this.clickListener;
    }

    public final ToolTipFactory.ToolTipDismissListener getDismissListener() {
        return this.dismissListener;
    }

    public final long getDismissTime() {
        return this.dismissTime;
    }

    public final int getImgRes() {
        return this.imgRes;
    }

    public final OffsetX getOffsetX() {
        return this.offsetX;
    }

    public final OffsetY getOffsetY() {
        return this.offsetY;
    }

    public final int getParentHeight() {
        return this.parentHeight;
    }

    public final int getParentWidth() {
        return this.parentWidth;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextHeight() {
        return this.textHeight;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final int getTextWidth() {
        return this.textWidth;
    }

    public final ToolTipMarginData getToolTipMargins() {
        return this.toolTipMargins;
    }

    public final int getXPos() {
        return this.xPos;
    }

    public final int getYPos() {
        return this.yPos;
    }

    public final boolean isDismissTimerEnabled() {
        return this.isDismissTimerEnabled;
    }

    public final boolean isFadeInAnimationEnabled() {
        return this.isFadeInAnimationEnabled;
    }

    public final void setDismissTime(long j10) {
        this.dismissTime = j10 * 1000;
    }

    public final void setDismissTimerEnabled(boolean z10) {
        this.isDismissTimerEnabled = z10;
    }
}
