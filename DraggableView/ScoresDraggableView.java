package com.scores365.DraggableView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import l0.c;
import li.x0;
/* loaded from: classes2.dex */
public class ScoresDraggableView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private c f21047d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21048e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21049f;

    /* loaded from: classes2.dex */
    class a extends c.AbstractC0427c {
        a() {
        }

        @Override // l0.c.AbstractC0427c
        public int b(@NonNull View view, int i10, int i11) {
            return i11;
        }

        @Override // l0.c.AbstractC0427c
        public int e(@NonNull View view) {
            return 0;
        }

        @Override // l0.c.AbstractC0427c
        public boolean g(int i10) {
            return super.g(i10);
        }

        @Override // l0.c.AbstractC0427c
        public void h(int i10, int i11) {
            super.h(i10, i11);
        }

        @Override // l0.c.AbstractC0427c
        public void j(int i10) {
            super.j(i10);
        }

        @Override // l0.c.AbstractC0427c
        public void k(@NonNull View view, int i10, int i11, int i12, int i13) {
            super.k(view, 0, i11, 0, i13);
        }

        @Override // l0.c.AbstractC0427c
        public void l(@NonNull View view, float f10, float f11) {
            super.l(view, 0.0f, f11);
            if (ScoresDraggableView.this.f21047d != null) {
                if (f11 > 0.0f) {
                    ScoresDraggableView.this.f21047d.P(view.getLeft(), ScoresDraggableView.this.getMeasuredHeight());
                } else {
                    ScoresDraggableView.this.f21047d.P(view.getLeft(), 0);
                }
            }
            ScoresDraggableView.this.invalidate();
        }

        @Override // l0.c.AbstractC0427c
        public boolean m(@NonNull View view, int i10) {
            return true;
        }
    }

    public ScoresDraggableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21048e = false;
    }

    public ScoresDraggableView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21048e = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        try {
            c cVar = this.f21047d;
            if (cVar == null || !cVar.n(true)) {
                return;
            }
            e1.l0(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean f() {
        return this.f21049f;
    }

    public boolean g() {
        return this.f21048e;
    }

    public void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f21047d = c.o(this, 1.0f, new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f21047d;
        if (cVar != null) {
            cVar.a();
        }
        this.f21047d = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c cVar = this.f21047d;
        return cVar != null && cVar.Q(motionEvent);
    }

    public void setRemoved(boolean z10) {
        this.f21049f = z10;
    }

    public void setSmall(boolean z10) {
        this.f21048e = z10;
    }
}
