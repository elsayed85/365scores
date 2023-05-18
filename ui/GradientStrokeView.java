package com.scores365.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GradientStrokeView.kt */
/* loaded from: classes2.dex */
public final class GradientStrokeView extends View {
    private int bottomColor;
    private final hj.h paint$delegate;
    private float painterStrokeWidth;
    private int topColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientStrokeView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GradientStrokeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientStrokeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        hj.h b10;
        kotlin.jvm.internal.m.g(context, "context");
        b10 = hj.j.b(new GradientStrokeView$paint$2(this));
        this.paint$delegate = b10;
    }

    public /* synthetic */ GradientStrokeView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final Paint getPaint() {
        return (Paint) this.paint$delegate.getValue();
    }

    public final int getBottomColor() {
        return this.bottomColor;
    }

    public final float getPainterStrokeWidth() {
        return this.painterStrokeWidth;
    }

    public final int getTopColor() {
        return this.topColor;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(1);
        paint.setStrokeWidth(this.painterStrokeWidth);
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getPaint());
        }
    }

    public final void setBottomColor(int i10) {
        this.bottomColor = i10;
    }

    public final void setPainterStrokeWidth(float f10) {
        this.painterStrokeWidth = f10;
    }

    public final void setTopColor(int i10) {
        this.topColor = i10;
    }
}
