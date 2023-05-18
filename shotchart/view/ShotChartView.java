package com.scores365.shotchart.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.entitys.SportTypesEnum;
import hj.h;
import hj.j;
import hj.o;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.r;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import li.p0;
import li.x0;
import wj.a0;
import wj.d1;
import wj.f2;
import wj.k;
import wj.n0;
import wj.o0;
import zh.c;
/* compiled from: ShotChartView.kt */
/* loaded from: classes2.dex */
public final class ShotChartView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f24254a;

    /* renamed from: b  reason: collision with root package name */
    private SportTypesEnum f24255b;

    /* renamed from: c  reason: collision with root package name */
    private final a0 f24256c;

    /* renamed from: d  reason: collision with root package name */
    private final n0 f24257d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24258e;

    /* renamed from: f  reason: collision with root package name */
    private int f24259f;

    /* renamed from: g  reason: collision with root package name */
    private final h f24260g;

    /* compiled from: ShotChartView.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Paint.Style f24261a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24262b;

        /* renamed from: c  reason: collision with root package name */
        private final int f24263c;

        /* renamed from: d  reason: collision with root package name */
        private final float f24264d;

        /* renamed from: e  reason: collision with root package name */
        private final float f24265e;

        public a(Paint.Style paintStyle, int i10, int i11, float f10, float f11) {
            m.g(paintStyle, "paintStyle");
            this.f24261a = paintStyle;
            this.f24262b = i10;
            this.f24263c = i11;
            this.f24264d = f10;
            this.f24265e = f11;
        }

        public final Paint.Style a() {
            return this.f24261a;
        }

        public final int b() {
            return this.f24262b;
        }

        public final int c() {
            return this.f24263c;
        }

        public final float d() {
            return this.f24264d;
        }

        public final float e() {
            return this.f24265e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f24261a == aVar.f24261a && this.f24262b == aVar.f24262b && this.f24263c == aVar.f24263c && Float.compare(this.f24264d, aVar.f24264d) == 0 && Float.compare(this.f24265e, aVar.f24265e) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f24261a.hashCode() * 31) + this.f24262b) * 31) + this.f24263c) * 31) + Float.floatToIntBits(this.f24264d)) * 31) + Float.floatToIntBits(this.f24265e);
        }

        public String toString() {
            return "ChartData(paintStyle=" + this.f24261a + ", primeColor=" + this.f24262b + ", secondColor=" + this.f24263c + ", xPoint=" + this.f24264d + ", yPoint=" + this.f24265e + ')';
        }
    }

    /* compiled from: ShotChartView.kt */
    @f(c = "com.scores365.shotchart.view.ShotChartView$drawData$1", f = "ShotChartView.kt", l = {82}, m = "invokeSuspend")
    /* loaded from: classes2.dex */
    static final class b extends l implements Function2<n0, d<? super Unit>, Object> {

        /* renamed from: f  reason: collision with root package name */
        Object f24266f;

        /* renamed from: g  reason: collision with root package name */
        int f24267g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ zh.c f24268h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ShotChartView f24269i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ int f24270j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ShotChartView.kt */
        @f(c = "com.scores365.shotchart.view.ShotChartView$drawData$1$1$2", f = "ShotChartView.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes2.dex */
        public static final class a extends l implements Function2<n0, d<? super Unit>, Object> {

            /* renamed from: f  reason: collision with root package name */
            int f24271f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ ShotChartView f24272g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ShotChartView shotChartView, d<? super a> dVar) {
                super(2, dVar);
                this.f24272g = shotChartView;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final d<Unit> create(Object obj, d<?> dVar) {
                return new a(this.f24272g, dVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(n0 n0Var, d<? super Unit> dVar) {
                return ((a) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kj.d.d();
                if (this.f24271f == 0) {
                    o.b(obj);
                    this.f24272g.invalidate();
                    return Unit.f33377a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: ShotChartView.kt */
        /* renamed from: com.scores365.shotchart.view.ShotChartView$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public /* synthetic */ class C0258b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f24273a;

            static {
                int[] iArr = new int[SportTypesEnum.values().length];
                try {
                    iArr[SportTypesEnum.HOCKEY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SportTypesEnum.BASKETBALL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f24273a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(zh.c cVar, ShotChartView shotChartView, int i10, d<? super b> dVar) {
            super(2, dVar);
            this.f24268h = cVar;
            this.f24269i = shotChartView;
            this.f24270j = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final d<Unit> create(Object obj, d<?> dVar) {
            return new b(this.f24268h, this.f24269i, this.f24270j, dVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, d<? super Unit> dVar) {
            return ((b) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00ea  */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 372
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.shotchart.view.ShotChartView.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ShotChartView.kt */
    /* loaded from: classes2.dex */
    static final class c extends n implements Function0<Paint> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f24274c = new c();

        c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Paint invoke() {
            return new Paint();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShotChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShotChartView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a0 b10;
        h b11;
        m.g(context, "context");
        this.f24254a = new CopyOnWriteArrayList<>();
        b10 = f2.b(null, 1, null);
        this.f24256c = b10;
        this.f24257d = o0.a(d1.b().plus(b10));
        b11 = j.b(c.f24274c);
        this.f24260g = b11;
    }

    public /* synthetic */ ShotChartView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void g(Canvas canvas, a aVar) {
        float r10 = p0.r(5.8f);
        float r11 = p0.r(6.5f);
        Paint paint = getPaint();
        paint.setStyle(aVar.a());
        paint.setColor(aVar.b());
        paint.setFlags(1);
        if (aVar.a() == Paint.Style.STROKE) {
            paint.setStrokeWidth(p0.r(3.5f));
            r10 = p0.r(6.5f);
        }
        canvas.drawCircle(aVar.d(), aVar.e(), r10, getPaint());
        Paint paint2 = getPaint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(p0.r(1.4f));
        paint2.setColor(aVar.c());
        paint2.setFlags(1);
        if (aVar.a() == Paint.Style.STROKE) {
            r11 = p0.r(5.8f);
        }
        canvas.drawCircle(aVar.d(), aVar.e(), r11, getPaint());
    }

    private final Paint getPaint() {
        return (Paint) this.f24260g.getValue();
    }

    private final void i(Canvas canvas, a aVar) {
        float r10 = p0.r(6.5f);
        float r11 = p0.r(3.5f);
        Paint paint = getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(aVar.b());
        paint.setFlags(1);
        paint.setStrokeWidth(p0.r(1.5f));
        canvas.drawCircle(aVar.d(), aVar.e(), r10, getPaint());
        Paint paint2 = getPaint();
        paint2.setStyle(aVar.a());
        paint2.setColor(aVar.b());
        paint2.setFlags(1);
        paint2.setStrokeWidth(p0.r(1.5f));
        canvas.drawCircle(aVar.d(), aVar.e(), r11, getPaint());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a j(c.a aVar, int i10, float f10, float f11, Paint.Style style, int i11) {
        return new a(style, i11, -1, aVar.a() == i10 ? getWidth() - l(f10) : l(f10), aVar.a() == i10 ? getHeight() - m(f11) : m(f11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a k(float f10, float f11, Paint.Style style, int i10) {
        return new a(style, i10, -1, l(f10), getHeight() - m(f11 * 2));
    }

    private final float l(float f10) {
        return (getWidth() * f10) / 100;
    }

    private final float m(float f10) {
        float f11 = 100;
        return this.f24259f + (((getHeight() - (this.f24259f * 2)) * (f11 - f10)) / f11);
    }

    public final void h(zh.c cVar, int i10) {
        try {
            k.d(this.f24257d, null, null, new b(cVar, this, i10, null), 3, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final boolean n() {
        return this.f24258e;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (!(!this.f24254a.isEmpty()) || canvas == null) {
                return;
            }
            int i10 = 0;
            for (Object obj : this.f24254a) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    r.q();
                }
                a chartData = (a) obj;
                SportTypesEnum sportTypesEnum = this.f24255b;
                if (sportTypesEnum == SportTypesEnum.BASKETBALL) {
                    m.f(chartData, "chartData");
                    g(canvas, chartData);
                } else if (sportTypesEnum == SportTypesEnum.HOCKEY) {
                    m.f(chartData, "chartData");
                    i(canvas, chartData);
                }
                i10 = i11;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void setInverted(boolean z10) {
        this.f24258e = z10;
    }
}
