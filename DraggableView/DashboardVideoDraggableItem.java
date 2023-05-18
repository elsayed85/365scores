package com.scores365.DraggableView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.scores365.App;
import com.scores365.DraggableView.DashboardVideoDraggableItem;
import com.scores365.removeAds.RemoveAdsManager;
import i4.i0;
import java.lang.ref.WeakReference;
import li.p0;
import li.x0;
import xe.j;
/* loaded from: classes2.dex */
public class DashboardVideoDraggableItem extends VideoDraggableView {

    /* renamed from: o  reason: collision with root package name */
    public boolean f21013o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f21014p;

    /* renamed from: q  reason: collision with root package name */
    WeakReference<j> f21015q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f21016r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f21017s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f21018t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i0 f21019a;

        a(i0 i0Var) {
            this.f21019a = i0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(i0 i0Var) {
            try {
                WeakReference<j> weakReference = DashboardVideoDraggableItem.this.f21015q;
                if (weakReference == null || weakReference.get() == null || !DashboardVideoDraggableItem.this.f21015q.get().b3()) {
                    return;
                }
                i0Var.l(true);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            try {
                DashboardVideoDraggableItem dashboardVideoDraggableItem = DashboardVideoDraggableItem.this;
                dashboardVideoDraggableItem.f21013o = true;
                if (!dashboardVideoDraggableItem.f21017s) {
                    this.f21019a.l(false);
                } else if (!App.f20792l.n()) {
                    Handler handler = new Handler();
                    final i0 i0Var = this.f21019a;
                    handler.postDelayed(new Runnable() { // from class: com.scores365.DraggableView.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            DashboardVideoDraggableItem.a.this.b(i0Var);
                        }
                    }, 300L);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<DashboardVideoDraggableItem> f21021a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<rb.c> f21022b;

        public b(DashboardVideoDraggableItem dashboardVideoDraggableItem, rb.c cVar) {
            this.f21021a = new WeakReference<>(dashboardVideoDraggableItem);
            this.f21022b = new WeakReference<>(cVar);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WeakReference<rb.c> weakReference;
            try {
                WeakReference<DashboardVideoDraggableItem> weakReference2 = this.f21021a;
                if (weakReference2 != null && weakReference2.get() != null && (weakReference = this.f21022b) != null && weakReference.get() != null) {
                    DashboardVideoDraggableItem dashboardVideoDraggableItem = this.f21021a.get();
                    try {
                        dashboardVideoDraggableItem.setScaleX(1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.6f));
                        dashboardVideoDraggableItem.setScaleY(1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.6f));
                        dashboardVideoDraggableItem.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * (this.f21022b.get().c1() - p0.s(80)));
                        dashboardVideoDraggableItem.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((App.p() - p0.s(142)) - p0.s(5)));
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<DashboardVideoDraggableItem> f21023a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<rb.c> f21024b;

        public c(DashboardVideoDraggableItem dashboardVideoDraggableItem, rb.c cVar) {
            this.f21023a = new WeakReference<>(dashboardVideoDraggableItem);
            this.f21024b = new WeakReference<>(cVar);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WeakReference<rb.c> weakReference;
            try {
                WeakReference<DashboardVideoDraggableItem> weakReference2 = this.f21023a;
                if (weakReference2 == null || weakReference2.get() == null || (weakReference = this.f21024b) == null || weakReference.get() == null) {
                    return;
                }
                DashboardVideoDraggableItem dashboardVideoDraggableItem = this.f21023a.get();
                dashboardVideoDraggableItem.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((App.p() - p0.s(142)) - p0.s(5)));
                dashboardVideoDraggableItem.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * (this.f21024b.get().c1() - p0.s(80)));
                dashboardVideoDraggableItem.setScaleX(1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.6f));
                dashboardVideoDraggableItem.setScaleY(1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.6f));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private final rb.c f21025a;

        public d(rb.c cVar) {
            this.f21025a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                this.f21025a.z0(false);
                ScoresDraggableView O0 = this.f21025a.O0();
                if (O0 != null) {
                    O0.setSmall(O0.g() ? false : true);
                    if (O0.f()) {
                        O0.h();
                    }
                }
                rb.c cVar = this.f21025a;
                if (cVar instanceof j) {
                    ((j) cVar).p3();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<rb.c> f21026a;

        /* renamed from: b  reason: collision with root package name */
        float f21027b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f21028c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        float f21029d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        float f21030e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        float f21031f = 0.0f;

        public e(rb.c cVar) {
            this.f21026a = new WeakReference<>(cVar);
        }

        private void a() {
            try {
                this.f21027b = 0.0f;
                this.f21030e = 0.0f;
                this.f21029d = 0.0f;
                this.f21028c = 0.0f;
                this.f21031f = 0.0f;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        private boolean b(float f10, float f11, float f12, float f13) {
            if (f13 > f11) {
                try {
                    return Math.abs(f13 - f11) > Math.abs(f12 - f10);
                } catch (Exception e10) {
                    x0.N1(e10);
                    return false;
                }
            }
            return false;
        }

        private boolean c(float f10, float f11, float f12, float f13) {
            if (f12 > f10) {
                float f14 = f12 - f10;
                try {
                    if (Math.abs(f14) > Math.abs(f13 - f11)) {
                        return Math.abs(f14) > ((float) App.p()) * 0.3f;
                    }
                    return false;
                } catch (Exception e10) {
                    x0.N1(e10);
                    return false;
                }
            }
            return false;
        }

        private boolean d(float f10, float f11, float f12, float f13) {
            if (f11 > f13) {
                try {
                    return Math.abs(f13 - f11) > Math.abs(f12 - f10);
                } catch (Exception e10) {
                    x0.N1(e10);
                    return false;
                }
            }
            return false;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            rb.c cVar;
            DashboardVideoDraggableItem dashboardVideoDraggableItem;
            try {
                WeakReference<rb.c> weakReference = this.f21026a;
                if (weakReference != null && (cVar = weakReference.get()) != null && (dashboardVideoDraggableItem = (DashboardVideoDraggableItem) cVar.O0()) != null && dashboardVideoDraggableItem.f21018t) {
                    if (dashboardVideoDraggableItem.g() && !dashboardVideoDraggableItem.f()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.f21027b = motionEvent.getX();
                            this.f21030e = motionEvent.getY();
                            this.f21031f = (float) System.currentTimeMillis();
                            return false;
                        } else if (action == 1) {
                            this.f21028c = motionEvent.getX();
                            this.f21029d = motionEvent.getY();
                            if (!dashboardVideoDraggableItem.g() || p0.q(this.f21027b, this.f21030e, this.f21028c, this.f21029d) >= p0.s(20)) {
                                if (c(this.f21027b, this.f21030e, this.f21028c, this.f21029d)) {
                                    if (dashboardVideoDraggableItem.g()) {
                                        cVar.N0();
                                    }
                                } else if (d(this.f21027b, this.f21030e, this.f21028c, this.f21029d)) {
                                    cVar.V0();
                                }
                            } else if (dashboardVideoDraggableItem.g()) {
                                cVar.V0();
                            }
                            this.f21027b = 0.0f;
                            this.f21030e = 0.0f;
                            this.f21029d = 0.0f;
                            this.f21028c = 0.0f;
                            this.f21031f = 0.0f;
                            return false;
                        }
                    }
                    if (!dashboardVideoDraggableItem.g() && !dashboardVideoDraggableItem.f()) {
                        int action2 = motionEvent.getAction();
                        if (action2 == 0) {
                            this.f21027b = motionEvent.getX();
                            this.f21030e = motionEvent.getY();
                            this.f21031f = (float) System.currentTimeMillis();
                            return false;
                        } else if (action2 == 1) {
                            this.f21028c = motionEvent.getX();
                            this.f21029d = motionEvent.getY();
                            if (dashboardVideoDraggableItem.g() || p0.q(this.f21027b, this.f21030e, this.f21028c, this.f21029d) >= p0.s(20)) {
                                if (b(this.f21027b, this.f21030e, this.f21028c, this.f21029d)) {
                                    cVar.t0();
                                }
                                a();
                                return false;
                            }
                            return false;
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return false;
        }
    }

    public DashboardVideoDraggableItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21013o = false;
        this.f21014p = false;
        this.f21016r = false;
        this.f21017s = false;
        this.f21018t = false;
    }

    public DashboardVideoDraggableItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21013o = false;
        this.f21014p = false;
        this.f21016r = false;
        this.f21017s = false;
        this.f21018t = false;
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    protected void A() {
        if (this.f21014p) {
            setVisibility(0);
        }
    }

    public boolean M() {
        return this.f21018t;
    }

    public boolean N() {
        return this.f21016r;
    }

    public void setAutoplay(boolean z10) {
        this.f21017s = z10;
    }

    public void setMinimizeOnScroll(boolean z10) {
        this.f21018t = z10;
    }

    public void setMuted(boolean z10) {
        this.f21016r = z10;
    }

    public void setScoresMainPageWeakReference(j jVar) {
        this.f21015q = new WeakReference<>(jVar);
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    public boolean t() {
        try {
            return !RemoveAdsManager.isUserAdsRemoved(App.m());
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    protected void u() {
        super.u();
        try {
            setVisibility(8);
            G();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    protected void w() {
        super.w();
        try {
            setVisibility(8);
            G();
            sf.b.X1().V8();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    protected void x(@NonNull i0 i0Var) {
        super.x(i0Var);
        try {
            i0Var.l(false);
            animate().alpha(1.0f).setDuration(0L).setListener(new a(i0Var));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    protected void y() {
        try {
            z();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    protected void z() {
        try {
            h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
