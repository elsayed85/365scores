package com.scores365.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
/* compiled from: BaseballDiamondBasesView.kt */
/* loaded from: classes2.dex */
public final class BaseballDiamondBasesView extends View {
    private int cubeFillerColor;
    private int cubeOutlineColor;
    private int[] loadedBases;
    private Paint mPaint;
    private float percentageDone;
    private float strokeWidth;

    public BaseballDiamondBasesView(Context context) {
        super(context);
        this.strokeWidth = p0.r(1.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseballDiamondBasesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        this.strokeWidth = p0.r(1.0f);
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseballDiamondBasesView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.g(context, "context");
        this.strokeWidth = p0.r(1.0f);
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        try {
            this.cubeOutlineColor = App.m().getResources().getColor(R.color.f21622l);
            this.cubeFillerColor = getResources().getColor(R.color.f21624n);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void adjustPaint(Paint paint, Integer num) {
        kotlin.jvm.internal.m.g(paint, "paint");
        if (num != null) {
            try {
                if (num.intValue() > 0) {
                    paint.setColor(this.cubeFillerColor);
                    paint.setStyle(Paint.Style.FILL);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        paint.setColor(this.cubeOutlineColor);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int e10;
        kotlin.jvm.internal.m.g(canvas, "canvas");
        try {
            super.draw(canvas);
            if (this.mPaint == null) {
                this.mPaint = new Paint();
            }
            Paint paint = this.mPaint;
            kotlin.jvm.internal.m.d(paint);
            paint.setStrokeWidth(p0.r(1.0f));
            e10 = uj.g.e(getWidth(), getHeight());
            float f10 = e10;
            float f11 = f10 / 7;
            float f12 = (f10 - f11) / 2;
            int[] iArr = this.loadedBases;
            adjustPaint(paint, iArr != null ? Integer.valueOf(iArr[0]) : null);
            int[] iArr2 = this.loadedBases;
            float indent = getIndent(iArr2 != null ? Integer.valueOf(iArr2[0]) : null);
            float f13 = f12 + f11;
            canvas.drawRect(f13 + indent, indent, f10 - indent, f12 - indent, paint);
            int[] iArr3 = this.loadedBases;
            adjustPaint(paint, iArr3 != null ? Integer.valueOf(iArr3[1]) : null);
            int[] iArr4 = this.loadedBases;
            float indent2 = getIndent(iArr4 != null ? Integer.valueOf(iArr4[1]) : null);
            float f14 = f12 - indent2;
            canvas.drawRect(indent2, indent2, f14, f14, paint);
            int[] iArr5 = this.loadedBases;
            adjustPaint(paint, iArr5 != null ? Integer.valueOf(iArr5[2]) : null);
            int[] iArr6 = this.loadedBases;
            float indent3 = getIndent(iArr6 != null ? Integer.valueOf(iArr6[2]) : null);
            canvas.drawRect(indent3, f13 + indent3, f12 - indent3, f10 - indent3, paint);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public final int getCubeFillerColor() {
        return this.cubeFillerColor;
    }

    public final int getCubeOutlineColor() {
        return this.cubeOutlineColor;
    }

    public final float getIndent(Integer num) {
        if (num != null) {
            try {
                if (num.intValue() > 0) {
                    return 0.0f;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return 0.0f;
            }
        }
        return p0.r(1.0f) / 2;
    }

    public final int[] getLoadedBases() {
        return this.loadedBases;
    }

    public final void setCubeFillerColor(int i10) {
        this.cubeFillerColor = i10;
    }

    public final void setCubeOutlineColor(int i10) {
        this.cubeOutlineColor = i10;
    }

    public final void setLoadedBases(int[] iArr) {
        this.loadedBases = iArr;
    }
}
