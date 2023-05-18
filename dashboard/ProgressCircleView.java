package com.scores365.dashboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.EventObj;
import com.scores365.entitys.SportTypesEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ProgressCircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f23312a;

    /* renamed from: b  reason: collision with root package name */
    public int f23313b;

    /* renamed from: c  reason: collision with root package name */
    public int f23314c;

    /* renamed from: d  reason: collision with root package name */
    private float f23315d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<a> f23316e;

    /* renamed from: f  reason: collision with root package name */
    private int f23317f;

    /* renamed from: g  reason: collision with root package name */
    private float f23318g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f23319h;

    /* renamed from: i  reason: collision with root package name */
    private int f23320i;

    /* renamed from: j  reason: collision with root package name */
    private int f23321j;

    /* renamed from: k  reason: collision with root package name */
    private List<EventObj> f23322k;

    /* renamed from: l  reason: collision with root package name */
    private int f23323l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23324m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f23325n;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f23326a;

        /* renamed from: b  reason: collision with root package name */
        public float f23327b;

        /* renamed from: c  reason: collision with root package name */
        public float f23328c;

        public a(int i10, float f10, float f11) {
            this.f23326a = i10;
            this.f23327b = f10;
            this.f23328c = f11;
        }
    }

    public ProgressCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23315d = p0.s(2);
        this.f23323l = 0;
        this.f23324m = false;
        this.f23325n = false;
        c(context, attributeSet);
    }

    public ProgressCircleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23315d = p0.s(2);
        this.f23323l = 0;
        this.f23324m = false;
        this.f23325n = false;
        c(context, attributeSet);
    }

    private void c(Context context, AttributeSet attributeSet) {
        try {
            if (x0.n1()) {
                this.f23312a = App.m().getResources().getColor(R.color.f21622l);
            } else {
                this.f23312a = App.m().getResources().getColor(R.color.f21619i);
            }
            this.f23313b = getResources().getColor(R.color.f21624n);
            this.f23314c = p0.A(R.attr.f21559k1);
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.H, 0, 0);
            this.f23316e = new ArrayList<>();
            this.f23318g = obtainStyledAttributes.getFloat(R.styleable.J, 0.0f);
            this.f23315d = obtainStyledAttributes.getDimension(R.styleable.I, p0.s(2));
            obtainStyledAttributes.recycle();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void a(int i10, EventObj eventObj, int i11, double d10, Canvas canvas) {
        float f10;
        float f11;
        double d11;
        double cos;
        double d12;
        float f12;
        try {
            Bitmap L = p0.L(eventObj, i11);
            if (L != null) {
                float width = L.getWidth() / 2;
                float width2 = canvas.getWidth() / 2;
                float width3 = canvas.getWidth() / 2;
                float f13 = i10;
                float f14 = width2 - f13;
                float f15 = width3 - f13;
                if (d10 <= 25.0d) {
                    double d13 = width2;
                    double d14 = i10;
                    double d15 = (float) ((d10 / 25.0d) * 90.0d);
                    f10 = ((float) (d13 + (Math.sin(Math.toRadians(d15)) * d14))) - width;
                    f12 = (float) (f15 + (d14 * (1.0d - Math.cos(Math.toRadians(d15)))));
                } else {
                    if (d10 <= 50.0d) {
                        double d16 = i10;
                        double d17 = 90.0f - ((float) (((d10 - 25.0d) / 25.0d) * 90.0d));
                        f10 = ((float) (width2 + (Math.sin(Math.toRadians(d17)) * d16))) - width;
                        d12 = width3 + (d16 * Math.cos(Math.toRadians(d17)));
                    } else {
                        if (d10 <= 75.0d) {
                            double d18 = i10;
                            double d19 = (float) (((d10 - 50.0d) / 25.0d) * 90.0d);
                            f10 = ((float) (f14 + ((1.0d - Math.sin(Math.toRadians(d19))) * d18))) - width;
                            d11 = width3;
                            cos = d18 * Math.cos(Math.toRadians(d19));
                        } else if (d10 > 100.0d) {
                            f10 = 0.0f;
                            f11 = 0.0f;
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            paint.setFilterBitmap(true);
                            paint.setDither(true);
                            canvas.drawBitmap(L, f10, f11, paint);
                        } else {
                            double d20 = i10;
                            double d21 = 90.0f - ((float) (((d10 - 75.0d) / 25.0d) * 90.0d));
                            f10 = ((float) (f14 + ((1.0d - Math.sin(Math.toRadians(d21))) * d20))) - width;
                            d11 = f15;
                            cos = d20 * (1.0d - Math.cos(Math.toRadians(d21)));
                        }
                        d12 = d11 + cos;
                    }
                    f12 = (float) d12;
                }
                f11 = f12 - width;
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setFilterBitmap(true);
                paint2.setDither(true);
                canvas.drawBitmap(L, f10, f11, paint2);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void b(int i10, Canvas canvas) {
        Bitmap decodeResource = BitmapFactory.decodeResource(App.m().getResources(), R.drawable.f21708f5);
        float width = decodeResource.getWidth() / 2;
        double d10 = i10;
        double d11 = 90.0f;
        float width2 = ((float) (((canvas.getWidth() / 2) - i10) + ((1.0d - Math.sin(Math.toRadians(d11))) * d10))) - width;
        float width3 = ((float) ((canvas.getWidth() / 2) + (d10 * Math.cos(Math.toRadians(d11))))) - width;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawBitmap(decodeResource, width2, width3, paint);
    }

    public void d(List<EventObj> list, int i10, boolean z10) {
        this.f23322k = list;
        this.f23323l = i10;
        this.f23324m = z10;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
            if (this.f23319h == null) {
                this.f23319h = new Paint();
            }
            this.f23317f = Math.min(canvas.getWidth(), canvas.getHeight());
            this.f23319h.setFlags(1);
            int width = canvas.getWidth() / 7;
            this.f23320i = width;
            this.f23321j = (width * 3) / 4;
            int s10 = p0.s(7);
            int i10 = (this.f23317f / 2) - s10;
            this.f23319h.setStrokeWidth(this.f23315d);
            RectF rectF = new RectF();
            this.f23319h.setStyle(Paint.Style.STROKE);
            float f10 = s10;
            int i11 = this.f23317f;
            rectF.set(f10, f10, i11 - s10, i11 - s10);
            Iterator<a> it = this.f23316e.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.f23328c != -1.0f) {
                    this.f23319h.setColor(next.f23326a);
                    canvas.drawArc(rectF, 270.0f, (next.f23328c * 360.0f) / 100.0f, false, this.f23319h);
                }
            }
            if (this.f23324m && this.f23323l == SportTypesEnum.SOCCER.getValue()) {
                b(i10, canvas);
            }
            List<EventObj> list = this.f23322k;
            if (list != null) {
                for (EventObj eventObj : list) {
                    if (eventObj.GameCompletion >= 0.0d && !eventObj.isNotInPlay()) {
                        a(i10, eventObj, this.f23323l, eventObj.GameCompletion, canvas);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setDataArray(ArrayList<a> arrayList) {
        this.f23316e = arrayList;
        invalidate();
    }

    public void setStrokeWidth(int i10) {
        this.f23315d = i10;
    }
}
