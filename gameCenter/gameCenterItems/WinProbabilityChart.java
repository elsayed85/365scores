package com.scores365.gameCenter.gameCenterItems;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.App;
import com.scores365.R;
import com.scores365.api.y1;
import com.scores365.entitys.WinProbabilityObj;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import li.p0;
import li.x0;
/* compiled from: WinProbabilityChart.kt */
/* loaded from: classes2.dex */
public final class WinProbabilityChart extends View {

    /* renamed from: a  reason: collision with root package name */
    private WinProbabilityObj f23771a;

    /* renamed from: b  reason: collision with root package name */
    private float f23772b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23773c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f23774d;

    /* compiled from: WinProbabilityChart.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void g(float f10);

        void o(boolean z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinProbabilityChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        this.f23772b = 0.5f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinProbabilityChart(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.f23772b = 0.5f;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        m.g(canvas, "canvas");
        try {
            super.draw(canvas);
            if (this.f23774d == null) {
                this.f23774d = new Paint();
            }
            Paint paint = this.f23774d;
            m.d(paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setFlags(1);
            paint.setPathEffect(null);
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            paint.setColor(App.m().getResources().getColor(R.color.f21613c));
            float r10 = p0.r(0.5f);
            paint.setStrokeWidth(r10);
            float f10 = width;
            canvas.drawRect(0.0f, 0.0f, f10, r10, paint);
            float f11 = height;
            float f12 = 4;
            float f13 = f11 / f12;
            canvas.drawLine(0.0f, f13, f10, f13, paint);
            float f14 = f11 / 2;
            canvas.drawLine(0.0f, f14, f10, f14, paint);
            float f15 = (3 * f11) / f12;
            canvas.drawLine(0.0f, f15, f10, f15, paint);
            canvas.drawRect(0.0f, f11 - r10, f10, f11, paint);
            int parseColor = Color.parseColor("#0403f4");
            int A = p0.A(R.attr.f21559k1);
            if (this.f23771a != null) {
                paint.setStrokeWidth(p0.r(1.5f));
                WinProbabilityObj winProbabilityObj = this.f23771a;
                m.d(winProbabilityObj);
                ArrayList<y1> winProbabilityEntries = winProbabilityObj.getWinProbabilityEntries();
                m.d(winProbabilityEntries);
                int size = winProbabilityEntries.size() - 2;
                if (size >= 0) {
                    int i13 = 0;
                    while (true) {
                        WinProbabilityObj winProbabilityObj2 = this.f23771a;
                        m.d(winProbabilityObj2);
                        ArrayList<y1> winProbabilityEntries2 = winProbabilityObj2.getWinProbabilityEntries();
                        m.d(winProbabilityEntries2);
                        y1 y1Var = winProbabilityEntries2.get(i13);
                        m.f(y1Var, "winProbabilityObj!!.winProbabilityEntries!![i]");
                        y1 y1Var2 = y1Var;
                        WinProbabilityObj winProbabilityObj3 = this.f23771a;
                        m.d(winProbabilityObj3);
                        ArrayList<y1> winProbabilityEntries3 = winProbabilityObj3.getWinProbabilityEntries();
                        m.d(winProbabilityEntries3);
                        int i14 = i13 + 1;
                        y1 y1Var3 = winProbabilityEntries3.get(i14);
                        m.f(y1Var3, "winProbabilityObj!!.winProbabilityEntries!![i + 1]");
                        y1 y1Var4 = y1Var3;
                        if ((!y1Var2.h() || y1Var4.h()) && (y1Var2.h() || !y1Var4.h())) {
                            i10 = i14;
                            i11 = i13;
                            i12 = size;
                            paint.setColor(y1Var2.h() ? A : parseColor);
                            float f16 = 100;
                            canvas.drawLine((y1Var2.a() * f10) / f16, (this.f23773c ? y1Var2.d() : 1 - y1Var2.d()) * f11, (y1Var4.a() * f10) / f16, (this.f23773c ? y1Var4.d() : 1 - y1Var4.d()) * f11, paint);
                        } else {
                            paint.setColor(!y1Var2.h() ? parseColor : A);
                            float a10 = y1Var2.a() + ((y1Var4.a() - y1Var2.a()) * ((0.5f - y1Var2.d()) / (y1Var4.d() - y1Var2.d())));
                            float f17 = 100;
                            float f18 = (a10 * f10) / f17;
                            i10 = i14;
                            i11 = i13;
                            i12 = size;
                            canvas.drawLine((y1Var2.a() * f10) / f17, (this.f23773c ? y1Var2.d() : 1 - y1Var2.d()) * f11, f18, (this.f23773c ? 0.5f : 1 - 0.5f) * f11, paint);
                            paint.setColor(!y1Var2.h() ? A : parseColor);
                            boolean z10 = this.f23773c;
                            canvas.drawLine(f18, (z10 ? 0.5f : 1 - 0.5f) * f11, (y1Var4.a() * f10) / f17, (z10 ? y1Var4.d() : 1 - y1Var4.d()) * f11, paint);
                        }
                        if (i11 == i12) {
                            break;
                        }
                        size = i12;
                        i13 = i10;
                    }
                }
                paint.setColor(p0.A(R.attr.f21565m1));
                paint.setPathEffect(new DashPathEffect(new float[]{p0.r(4.0f), p0.r(2.0f)}, 0.0f));
                paint.setStrokeWidth(p0.r(1.0f));
                float f19 = this.f23772b;
                canvas.drawLine(f19 * f10, 0.0f, f19 * f10, f11, paint);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final boolean getAreCompetitorsInverted() {
        return this.f23773c;
    }

    public final float getSelectedCompletionFraction() {
        return this.f23772b;
    }

    public final WinProbabilityObj getWinProbabilityObj() {
        return this.f23771a;
    }

    public final void setAreCompetitorsInverted(boolean z10) {
        this.f23773c = z10;
    }

    public final void setSelectedCompletionFraction(float f10) {
        this.f23772b = f10;
    }

    public final void setWinProbabilityObj(WinProbabilityObj winProbabilityObj) {
        this.f23771a = winProbabilityObj;
    }
}
