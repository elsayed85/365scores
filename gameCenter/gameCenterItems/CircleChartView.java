package com.scores365.gameCenter.gameCenterItems;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.R;
import java.util.ArrayList;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CircleChartView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f23744a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f23745b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<a> f23746c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23747d;

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f23748a;

        /* renamed from: b  reason: collision with root package name */
        public int f23749b;

        public a(int i10, int i11) {
            this.f23748a = i10;
            this.f23749b = i11;
        }
    }

    public CircleChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23746c = new ArrayList<>();
        this.f23747d = false;
        c(context, attributeSet);
    }

    public CircleChartView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23746c = new ArrayList<>();
        this.f23747d = false;
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.f22856r, 0, 0);
            this.f23744a = obtainStyledAttributes.getDimension(R.styleable.f22844f, p0.s(8));
            obtainStyledAttributes.recycle();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void a(int i10, int i11) {
        this.f23746c.add(new a(i10, i11));
    }

    public void b() {
        this.f23746c.clear();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int size;
        try {
            super.draw(canvas);
            if (this.f23745b == null) {
                this.f23745b = new Paint();
            }
            int min = Math.min(getWidth(), getHeight());
            this.f23745b.setFlags(1);
            this.f23745b.setStrokeWidth(this.f23744a);
            RectF rectF = new RectF();
            this.f23745b.setStyle(Paint.Style.STROKE);
            int s10 = ((int) this.f23744a) + p0.s(4);
            float f10 = s10;
            float f11 = min - s10;
            rectF.set(f10, f10, f11, f11);
            int i10 = 0;
            for (int i11 = 0; i11 < this.f23746c.size(); i11++) {
                i10 += this.f23746c.get(i11).f23748a;
            }
            float f12 = 0.0f;
            for (int i12 = 0; i12 < this.f23746c.size(); i12++) {
                this.f23745b.setColor(this.f23746c.get(this.f23747d ? (this.f23746c.size() - 1) - i12 : i12).f23749b);
                float f13 = (this.f23746c.get(size).f23748a * 360.0f) / i10;
                canvas.drawArc(rectF, f12 + 270.0f, 360.0f - f12, false, this.f23745b);
                f12 += f13;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setRtl(boolean z10) {
        this.f23747d = z10;
    }
}
