package com.scores365.baseball;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.App;
import com.scores365.R;
import kotlin.jvm.internal.m;
import li.p0;
import li.x0;
/* compiled from: BaseballStateBallsView.kt */
/* loaded from: classes2.dex */
public final class BaseballStateBallsView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f23271a;

    /* renamed from: b  reason: collision with root package name */
    private int f23272b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f23273c;

    /* renamed from: d  reason: collision with root package name */
    private int f23274d;

    /* renamed from: e  reason: collision with root package name */
    private int f23275e;

    /* renamed from: f  reason: collision with root package name */
    private float f23276f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseballStateBallsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        this.f23274d = -1;
        this.f23275e = -1;
        this.f23276f = -1.0f;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseballStateBallsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.f23274d = -1;
        this.f23275e = -1;
        this.f23276f = -1.0f;
        a(context, attributeSet);
    }

    private final void a(Context context, AttributeSet attributeSet) {
        try {
            this.f23271a = App.m().getResources().getColor(R.color.f21622l);
            this.f23272b = getResources().getColor(R.color.f21624n);
            this.f23276f = p0.r(0.5f);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f22839a, 0, 0);
                m.f(obtainStyledAttributes, "context.obtainStyledAttr…ballStateBallsView, 0, 0)");
                this.f23274d = obtainStyledAttributes.getInt(R.styleable.f22841c, -1);
                this.f23275e = obtainStyledAttributes.getInt(R.styleable.f22842d, -1);
                this.f23276f = obtainStyledAttributes.getDimension(R.styleable.f22840b, p0.r(0.5f));
                obtainStyledAttributes.recycle();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        float f10;
        m.g(canvas, "canvas");
        try {
            super.draw(canvas);
            if (this.f23273c == null) {
                this.f23273c = new Paint();
            }
            Paint paint = this.f23273c;
            m.d(paint);
            paint.setStrokeWidth(this.f23276f);
            float height = getHeight();
            float f11 = height / 3;
            paint.setColor(this.f23272b);
            paint.setStyle(Paint.Style.FILL);
            RectF rectF = new RectF(0.0f, 0.0f, height, height);
            float r10 = p0.r(1.0f) / 2;
            int i10 = this.f23275e;
            int i11 = 1;
            if (1 > i10) {
                return;
            }
            float f12 = 0.0f;
            while (true) {
                if (i11 <= this.f23274d) {
                    paint.setColor(this.f23272b);
                    paint.setStyle(Paint.Style.FILL);
                    f10 = 0.0f;
                } else {
                    paint.setColor(this.f23271a);
                    paint.setStyle(Paint.Style.STROKE);
                    f10 = r10;
                }
                rectF.left = f12 + f10;
                rectF.right = (f12 + height) - f10;
                rectF.top = f10;
                rectF.bottom = height - f10;
                canvas.drawOval(rectF, paint);
                f12 += height + f11;
                if (i11 == i10) {
                    return;
                }
                i11++;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final int getCircleFillerColor() {
        return this.f23272b;
    }

    public final int getCircleOutlineColor() {
        return this.f23271a;
    }

    public final float getCircleStrokeWidth() {
        return this.f23276f;
    }

    public final int getFilledBalls() {
        return this.f23274d;
    }

    public final int getOverallBalls() {
        return this.f23275e;
    }

    public final void setCircleFillerColor(int i10) {
        this.f23272b = i10;
    }

    public final void setCircleOutlineColor(int i10) {
        this.f23271a = i10;
    }

    public final void setCircleStrokeWidth(float f10) {
        this.f23276f = f10;
    }

    public final void setFilledBalls(int i10) {
        this.f23274d = i10;
    }

    public final void setOverallBalls(int i10) {
        this.f23275e = i10;
    }
}
