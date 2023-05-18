package com.scores365.webSync.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import sj.c;
import uj.g;
/* compiled from: TargetView.kt */
/* loaded from: classes2.dex */
public final class TargetView extends View {

    /* renamed from: j  reason: collision with root package name */
    public static final a f24443j = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Paint f24444a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f24445b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f24446c;

    /* renamed from: d  reason: collision with root package name */
    private xi.a f24447d;

    /* renamed from: e  reason: collision with root package name */
    private int f24448e;

    /* renamed from: f  reason: collision with root package name */
    private int f24449f;

    /* renamed from: g  reason: collision with root package name */
    private float f24450g;

    /* renamed from: h  reason: collision with root package name */
    private float f24451h;

    /* renamed from: i  reason: collision with root package name */
    private float f24452i;

    /* compiled from: TargetView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TargetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TargetView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int b10;
        int b11;
        int b12;
        m.g(context, "context");
        Paint paint = new Paint(1);
        this.f24444a = paint;
        this.f24450g = 1.0f;
        this.f24451h = 1.0f;
        this.f24452i = 0.75f;
        float f10 = context.getResources().getDisplayMetrics().density;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f24445b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f24446c = path;
        c(1.0f, 1.0f);
        setMaskColor(1996488704);
        setFrameColor(-1);
        b10 = c.b(7.0f * f10);
        setFrameThickness(b10);
        b11 = c.b(80.0f * f10);
        setFrameCornersSize(b11);
        b12 = c.b(f10 * 8.0f);
        setFrameCornersRadius(b12);
        setFrameSize(0.75f);
    }

    public /* synthetic */ TargetView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void a(int i10, int i11) {
        int b10;
        int b11;
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        float f10 = i10;
        float f11 = i11;
        float f12 = this.f24450g / this.f24451h;
        if (f10 / f11 <= f12) {
            b11 = c.b(f10 * this.f24452i);
            b10 = c.b(b11 / f12);
        } else {
            b10 = c.b(f11 * this.f24452i);
            b11 = c.b(b10 * f12);
        }
        int i12 = (i10 - b11) / 2;
        int i13 = (i11 - b10) / 2;
        this.f24447d = new xi.a(i12, i13, b11 + i12, b10 + i13);
    }

    static /* synthetic */ void b(TargetView targetView, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = targetView.getWidth();
        }
        if ((i12 & 2) != 0) {
            i11 = targetView.getHeight();
        }
        targetView.a(i10, i11);
    }

    public final void c(float f10, float f11) {
        this.f24450g = f10;
        this.f24451h = f11;
        b(this, 0, 0, 3, null);
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final float getFrameAspectRatioHeight() {
        return this.f24451h;
    }

    public final float getFrameAspectRatioWidth() {
        return this.f24450g;
    }

    public final int getFrameColor() {
        return this.f24445b.getColor();
    }

    public final int getFrameCornersRadius() {
        return this.f24449f;
    }

    public final int getFrameCornersSize() {
        return this.f24448e;
    }

    public final xi.a getFrameRect() {
        return this.f24447d;
    }

    public final float getFrameSize() {
        return this.f24452i;
    }

    public final int getFrameThickness() {
        return (int) this.f24445b.getStrokeWidth();
    }

    public final int getMaskColor() {
        return this.f24444a.getColor();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float a10;
        float d10;
        m.g(canvas, "canvas");
        xi.a aVar = this.f24447d;
        if (aVar == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float d11 = aVar.d();
        float b10 = aVar.b();
        float c10 = aVar.c();
        float a11 = aVar.a();
        float f10 = this.f24448e;
        float f11 = this.f24449f;
        Path path = this.f24446c;
        if (f11 <= 0.0f) {
            path.reset();
            path.moveTo(b10, d11);
            path.lineTo(c10, d11);
            path.lineTo(c10, a11);
            path.lineTo(b10, a11);
            path.lineTo(b10, d11);
            path.moveTo(0.0f, 0.0f);
            float f12 = width;
            path.lineTo(f12, 0.0f);
            float f13 = height;
            path.lineTo(f12, f13);
            path.lineTo(0.0f, f13);
            path.lineTo(0.0f, 0.0f);
            canvas.drawPath(path, this.f24444a);
            path.reset();
            float f14 = d11 + f10;
            path.moveTo(b10, f14);
            path.lineTo(b10, d11);
            float f15 = b10 + f10;
            path.lineTo(f15, d11);
            float f16 = c10 - f10;
            path.moveTo(f16, d11);
            path.lineTo(c10, d11);
            path.lineTo(c10, f14);
            float f17 = a11 - f10;
            path.moveTo(c10, f17);
            path.lineTo(c10, a11);
            path.lineTo(f16, a11);
            path.moveTo(f15, a11);
            path.lineTo(b10, a11);
            path.lineTo(b10, f17);
            canvas.drawPath(path, this.f24445b);
            return;
        }
        a10 = g.a(f10 - 1, 0.0f);
        d10 = g.d(f11, a10);
        path.reset();
        float f18 = d11 + d10;
        path.moveTo(b10, f18);
        float f19 = b10 + d10;
        path.quadTo(b10, d11, f19, d11);
        float f20 = c10 - d10;
        path.lineTo(f20, d11);
        path.quadTo(c10, d11, c10, f18);
        float f21 = a11 - d10;
        path.lineTo(c10, f21);
        path.quadTo(c10, a11, f20, a11);
        path.lineTo(f19, a11);
        path.quadTo(b10, a11, b10, f21);
        path.lineTo(b10, f18);
        path.moveTo(0.0f, 0.0f);
        float f22 = width;
        path.lineTo(f22, 0.0f);
        float f23 = height;
        path.lineTo(f22, f23);
        path.lineTo(0.0f, f23);
        path.lineTo(0.0f, 0.0f);
        canvas.drawPath(path, this.f24444a);
        path.reset();
        float f24 = d11 + f10;
        path.moveTo(b10, f24);
        path.lineTo(b10, f18);
        path.quadTo(b10, d11, f19, d11);
        float f25 = b10 + f10;
        path.lineTo(f25, d11);
        float f26 = c10 - f10;
        path.moveTo(f26, d11);
        path.lineTo(f20, d11);
        path.quadTo(c10, d11, c10, f18);
        path.lineTo(c10, f24);
        float f27 = a11 - f10;
        path.moveTo(c10, f27);
        path.lineTo(c10, f21);
        path.quadTo(c10, a11, f20, a11);
        path.lineTo(f26, a11);
        path.moveTo(f25, a11);
        path.lineTo(f19, a11);
        path.quadTo(b10, a11, b10, f21);
        path.lineTo(b10, f27);
        canvas.drawPath(path, this.f24445b);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        a(i12 - i10, i13 - i11);
    }

    public final void setFrameAspectRatioHeight(float f10) {
        this.f24451h = f10;
        b(this, 0, 0, 3, null);
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setFrameAspectRatioWidth(float f10) {
        this.f24450g = f10;
        b(this, 0, 0, 3, null);
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setFrameColor(int i10) {
        this.f24445b.setColor(i10);
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setFrameCornersRadius(int i10) {
        this.f24449f = i10;
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setFrameCornersSize(int i10) {
        this.f24448e = i10;
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setFrameSize(float f10) {
        this.f24452i = f10;
        b(this, 0, 0, 3, null);
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setFrameThickness(int i10) {
        this.f24445b.setStrokeWidth(i10);
        if (isLaidOut()) {
            invalidate();
        }
    }

    public final void setMaskColor(int i10) {
        this.f24444a.setColor(i10);
        if (isLaidOut()) {
            invalidate();
        }
    }
}
