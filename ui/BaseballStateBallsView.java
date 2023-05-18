package com.scores365.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
/* compiled from: BaseballStateBallsView.kt */
/* loaded from: classes2.dex */
public final class BaseballStateBallsView extends View {
    private int circleFillerColor;
    private int circleOutlineColor;
    private int filledBalls;
    private Paint mPaint;
    private int overallBalls;

    public BaseballStateBallsView(Context context) {
        super(context);
        this.filledBalls = -1;
        this.overallBalls = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseballStateBallsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        this.filledBalls = -1;
        this.overallBalls = -1;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseballStateBallsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.m.g(context, "context");
        this.filledBalls = -1;
        this.overallBalls = -1;
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        try {
            this.circleOutlineColor = App.m().getResources().getColor(R.color.f21622l);
            this.circleFillerColor = getResources().getColor(R.color.f21624n);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        float f10;
        kotlin.jvm.internal.m.g(canvas, "canvas");
        try {
            super.draw(canvas);
            if (this.mPaint == null) {
                this.mPaint = new Paint();
            }
            Paint paint = this.mPaint;
            kotlin.jvm.internal.m.d(paint);
            paint.setStrokeWidth(p0.r(0.5f));
            float height = getHeight();
            float f11 = height / 3;
            paint.setColor(this.circleFillerColor);
            paint.setStyle(Paint.Style.FILL);
            RectF rectF = new RectF(0.0f, 0.0f, height, height);
            float r10 = p0.r(1.0f) / 2;
            int i10 = this.overallBalls;
            int i11 = 1;
            if (1 > i10) {
                return;
            }
            float f12 = 0.0f;
            while (true) {
                if (i11 <= this.filledBalls) {
                    paint.setColor(this.circleFillerColor);
                    paint.setStyle(Paint.Style.FILL);
                    f10 = 0.0f;
                } else {
                    paint.setColor(this.circleOutlineColor);
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
        return this.circleFillerColor;
    }

    public final int getCircleOutlineColor() {
        return this.circleOutlineColor;
    }

    public final int getFilledBalls() {
        return this.filledBalls;
    }

    public final int getOverallBalls() {
        return this.overallBalls;
    }

    public final void setCircleFillerColor(int i10) {
        this.circleFillerColor = i10;
    }

    public final void setCircleOutlineColor(int i10) {
        this.circleOutlineColor = i10;
    }

    public final void setFilledBalls(int i10) {
        this.filledBalls = i10;
    }

    public final void setOverallBalls(int i10) {
        this.overallBalls = i10;
    }
}
