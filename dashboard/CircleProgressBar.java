package com.scores365.dashboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CircleProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f23284a;

    /* renamed from: b  reason: collision with root package name */
    private int f23285b;

    /* renamed from: c  reason: collision with root package name */
    private int f23286c;

    /* renamed from: d  reason: collision with root package name */
    private float f23287d;

    /* renamed from: e  reason: collision with root package name */
    private float f23288e;

    /* renamed from: f  reason: collision with root package name */
    private float f23289f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f23290g;

    /* renamed from: h  reason: collision with root package name */
    private int f23291h;

    /* renamed from: i  reason: collision with root package name */
    private b f23292i;

    /* renamed from: j  reason: collision with root package name */
    private a f23293j;

    /* renamed from: k  reason: collision with root package name */
    private float f23294k;

    /* loaded from: classes2.dex */
    public enum a {
        FORWARD,
        BACKWARD
    }

    /* loaded from: classes2.dex */
    public enum b {
        LEFT,
        RIGHT
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23289f = 1.0f;
        this.f23293j = a.FORWARD;
        a(context, attributeSet);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23289f = 1.0f;
        this.f23293j = a.FORWARD;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.f22856r, 0, 0);
            this.f23284a = obtainStyledAttributes.getInt(R.styleable.f22857s, 0);
            this.f23285b = obtainStyledAttributes.getInt(R.styleable.f22858t, 0);
            this.f23288e = obtainStyledAttributes.getFloat(R.styleable.f22860v, 0.0f);
            float dimension = obtainStyledAttributes.getDimension(R.styleable.f22861w, p0.s(2));
            this.f23287d = dimension;
            this.f23294k = obtainStyledAttributes.getDimension(R.styleable.f22859u, dimension);
            obtainStyledAttributes.recycle();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007b A[Catch: Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:2:0x0000, B:4:0x0007, B:5:0x000e, B:7:0x0056, B:8:0x005a, B:13:0x0071, B:15:0x007b, B:16:0x00b2, B:18:0x00b6, B:9:0x005d, B:11:0x0061, B:12:0x006c), top: B:23:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b2 A[Catch: Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:2:0x0000, B:4:0x0007, B:5:0x000e, B:7:0x0056, B:8:0x005a, B:13:0x0071, B:15:0x007b, B:16:0x00b2, B:18:0x00b6, B:9:0x005d, B:11:0x0061, B:12:0x006c), top: B:23:0x0000 }] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboard.CircleProgressBar.draw(android.graphics.Canvas):void");
    }

    public void setAnimatedIntermediateValue(float f10) {
        this.f23289f = f10;
        invalidate();
    }

    public void setAnimationDirection(a aVar) {
        this.f23293j = aVar;
    }

    public void setDirection(b bVar) {
        this.f23292i = bVar;
    }

    public void setFractionFilled(float f10) {
        this.f23288e = f10;
    }

    public void setStrokeWidth(float f10) {
        this.f23287d = f10;
        this.f23294k = f10;
        invalidate();
    }
}
