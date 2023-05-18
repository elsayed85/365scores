package com.scores365.DraggableView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cc.o0;
import cc.w0;
import com.scores365.App;
import com.scores365.DraggableView.GameCenterVideoDraggableItem;
import com.scores365.R;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.removeAds.RemoveAdsManager;
import i4.i0;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.m;
import li.p0;
import li.x0;
import sf.b;
/* compiled from: GameCenterVideoDraggableItem.kt */
/* loaded from: classes2.dex */
public final class GameCenterVideoDraggableItem extends VideoDraggableView {

    /* renamed from: o  reason: collision with root package name */
    private WeakReference<GameCenterBaseActivity> f21032o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21033p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21034q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f21035r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f21036s;

    /* renamed from: t  reason: collision with root package name */
    private long f21037t;

    /* compiled from: GameCenterVideoDraggableItem.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<GameCenterVideoDraggableItem> f21038a;

        public a(GameCenterVideoDraggableItem gameCenterVideoDraggableItem) {
            this.f21038a = new WeakReference<>(gameCenterVideoDraggableItem);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator p02) {
            m.g(p02, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator p02) {
            m.g(p02, "p0");
            try {
                WeakReference<GameCenterVideoDraggableItem> weakReference = this.f21038a;
                if (weakReference != null) {
                    m.d(weakReference);
                    if (weakReference.get() != null) {
                        WeakReference<GameCenterVideoDraggableItem> weakReference2 = this.f21038a;
                        m.d(weakReference2);
                        GameCenterVideoDraggableItem gameCenterVideoDraggableItem = weakReference2.get();
                        m.d(gameCenterVideoDraggableItem);
                        ViewGroup.LayoutParams layoutParams = gameCenterVideoDraggableItem.getLayoutParams();
                        layoutParams.width = 432;
                        layoutParams.height = 267;
                        gameCenterVideoDraggableItem.setScaleX(1.0f);
                        gameCenterVideoDraggableItem.setScaleY(1.0f);
                        gameCenterVideoDraggableItem.requestLayout();
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator p02) {
            m.g(p02, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator p02) {
            m.g(p02, "p0");
        }
    }

    /* compiled from: GameCenterVideoDraggableItem.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<GameCenterVideoDraggableItem> f21039a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<rb.c> f21040b;

        public b(GameCenterVideoDraggableItem gameCenterVideoDraggableItem, rb.c cVar) {
            this.f21039a = new WeakReference<>(gameCenterVideoDraggableItem);
            this.f21040b = new WeakReference<>(cVar);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            WeakReference<rb.c> weakReference;
            rb.c cVar;
            m.g(animation, "animation");
            try {
                WeakReference<GameCenterVideoDraggableItem> weakReference2 = this.f21039a;
                if (weakReference2 != null) {
                    m.d(weakReference2);
                    if (weakReference2.get() == null || (weakReference = this.f21040b) == null) {
                        return;
                    }
                    m.d(weakReference);
                    if (weakReference.get() != null) {
                        WeakReference<GameCenterVideoDraggableItem> weakReference3 = this.f21039a;
                        m.d(weakReference3);
                        GameCenterVideoDraggableItem gameCenterVideoDraggableItem = weakReference3.get();
                        m.d(gameCenterVideoDraggableItem);
                        Object animatedValue = animation.getAnimatedValue();
                        m.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        gameCenterVideoDraggableItem.setTranslationX(((Float) animatedValue).floatValue() * ((App.p() - p0.s(142)) - p0.s(20)));
                        ViewGroup.LayoutParams layoutParams = gameCenterVideoDraggableItem.getLayoutParams();
                        m.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        Object animatedValue2 = animation.getAnimatedValue();
                        m.e(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                        float floatValue = ((Float) animatedValue2).floatValue();
                        WeakReference<rb.c> weakReference4 = this.f21040b;
                        m.d(weakReference4);
                        m.d(weakReference4.get());
                        gameCenterVideoDraggableItem.setTranslationY(floatValue * ((cVar.c1() - i10) + p0.s(170)));
                        float f10 = 1;
                        Object animatedValue3 = animation.getAnimatedValue();
                        m.e(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                        gameCenterVideoDraggableItem.setScaleX(f10 - (((Float) animatedValue3).floatValue() * 0.6f));
                        Object animatedValue4 = animation.getAnimatedValue();
                        m.e(animatedValue4, "null cannot be cast to non-null type kotlin.Float");
                        gameCenterVideoDraggableItem.setScaleY(f10 - (((Float) animatedValue4).floatValue() * 0.6f));
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: GameCenterVideoDraggableItem.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<rb.c> f21041a;

        /* renamed from: b  reason: collision with root package name */
        private float f21042b;

        /* renamed from: c  reason: collision with root package name */
        private float f21043c;

        /* renamed from: d  reason: collision with root package name */
        private float f21044d;

        /* renamed from: e  reason: collision with root package name */
        private float f21045e;

        /* renamed from: f  reason: collision with root package name */
        private float f21046f;

        public c(rb.c draggableViewListener) {
            m.g(draggableViewListener, "draggableViewListener");
            this.f21041a = new WeakReference<>(draggableViewListener);
        }

        private final void a() {
            try {
                this.f21042b = 0.0f;
                this.f21045e = 0.0f;
                this.f21044d = 0.0f;
                this.f21043c = 0.0f;
                this.f21046f = 0.0f;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        private final boolean b(float f10, float f11, float f12, float f13) {
            if (f13 > f11) {
                try {
                    if (Math.abs(f13 - f11) > Math.abs(f12 - f10)) {
                        return true;
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            return false;
        }

        private final boolean c(float f10, float f11, float f12, float f13) {
            if (f12 > f10) {
                float f14 = f12 - f10;
                try {
                    if (Math.abs(f14) > Math.abs(f13 - f11)) {
                        if (Math.abs(f14) > App.p() * 0.3f) {
                            return true;
                        }
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            return false;
        }

        private final boolean d(float f10, float f11, float f12, float f13) {
            if (f11 > f13) {
                try {
                    if (Math.abs(f13 - f11) > Math.abs(f12 - f10)) {
                        return true;
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            return false;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v10, MotionEvent event) {
            m.g(v10, "v");
            m.g(event, "event");
            try {
                WeakReference<rb.c> weakReference = this.f21041a;
                if (weakReference != null) {
                    m.d(weakReference);
                    rb.c cVar = weakReference.get();
                    if (cVar != null) {
                        ScoresDraggableView O0 = cVar.O0();
                        m.e(O0, "null cannot be cast to non-null type com.scores365.DraggableView.GameCenterVideoDraggableItem");
                        GameCenterVideoDraggableItem gameCenterVideoDraggableItem = (GameCenterVideoDraggableItem) O0;
                        if (gameCenterVideoDraggableItem.g() && !gameCenterVideoDraggableItem.f()) {
                            int action = event.getAction();
                            if (action == 0) {
                                this.f21042b = event.getX();
                                this.f21045e = event.getY();
                                this.f21046f = (float) System.currentTimeMillis();
                                return false;
                            } else if (action == 1) {
                                this.f21043c = event.getX();
                                this.f21044d = event.getY();
                                if (!gameCenterVideoDraggableItem.g() || p0.q(this.f21042b, this.f21045e, this.f21043c, this.f21044d) >= p0.s(20)) {
                                    if (c(this.f21042b, this.f21045e, this.f21043c, this.f21044d)) {
                                        if (gameCenterVideoDraggableItem.g()) {
                                            cVar.N0();
                                        }
                                    } else if (d(this.f21042b, this.f21045e, this.f21043c, this.f21044d)) {
                                        cVar.V0();
                                    }
                                } else if (gameCenterVideoDraggableItem.g()) {
                                    cVar.V0();
                                }
                                this.f21042b = 0.0f;
                                this.f21045e = 0.0f;
                                this.f21044d = 0.0f;
                                this.f21043c = 0.0f;
                                this.f21046f = 0.0f;
                                return false;
                            }
                        }
                        if (!gameCenterVideoDraggableItem.g() && !gameCenterVideoDraggableItem.f()) {
                            int action2 = event.getAction();
                            if (action2 == 0) {
                                this.f21042b = event.getX();
                                this.f21045e = event.getY();
                                this.f21046f = (float) System.currentTimeMillis();
                                return false;
                            } else if (action2 == 1) {
                                this.f21043c = event.getX();
                                this.f21044d = event.getY();
                                if (gameCenterVideoDraggableItem.g() || p0.q(this.f21042b, this.f21045e, this.f21043c, this.f21044d) >= p0.s(20)) {
                                    if (b(this.f21042b, this.f21045e, this.f21043c, this.f21044d)) {
                                        cVar.t0();
                                    }
                                    a();
                                    return false;
                                }
                                return false;
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCenterVideoDraggableItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.g(context, "context");
        m.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCenterVideoDraggableItem(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m.g(context, "context");
        m.g(attrs, "attrs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(GameCenterVideoDraggableItem this$0, View view) {
        m.g(this$0, "this$0");
        try {
            this$0.getPlayer().x0((this$0.getPlayer().getVolume() > 0.0f ? 1 : (this$0.getPlayer().getVolume() == 0.0f ? 0 : -1)) == 0 ? 1.0f : 0.0f);
            ImageView imageView = this$0.f21036s;
            m.d(imageView);
            this$0.P(imageView);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private final void P(ImageView imageView) {
        try {
            imageView.setImageResource((getPlayer().getVolume() > 0.0f ? 1 : (getPlayer().getVolume() == 0.0f ? 0 : -1)) == 0 ? R.drawable.f21833v2 : R.drawable.I3);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final boolean M() {
        return this.f21033p;
    }

    public final boolean N() {
        return this.f21034q;
    }

    public final boolean O() {
        return this.f21035r;
    }

    public final long getAdStartTime() {
        return this.f21037t;
    }

    public final WeakReference<GameCenterBaseActivity> getGameCenterWeakReference() {
        return this.f21032o;
    }

    public final ImageView getMuteButton() {
        return this.f21036s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.DraggableView.VideoDraggableView
    public void r(FrameLayout frameLayout) {
        m.g(frameLayout, "frameLayout");
        try {
            super.r(frameLayout);
            getPlayerView().getPlayer().l(true);
            this.f21036s = new ImageView(App.m());
            int s10 = p0.s(35);
            ImageView imageView = this.f21036s;
            if (imageView != null) {
                imageView.setLayoutParams(new FrameLayout.LayoutParams(s10, s10, 51));
            }
            ImageView imageView2 = this.f21036s;
            ViewGroup.LayoutParams layoutParams = imageView2 != null ? imageView2.getLayoutParams() : null;
            m.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).topMargin = p0.s(5);
            frameLayout.addView(this.f21036s);
            int s11 = p0.s(5);
            ImageView imageView3 = this.f21036s;
            if (imageView3 != null) {
                imageView3.setPadding(s11, s11, s11, s11);
            }
            ImageView imageView4 = this.f21036s;
            m.d(imageView4);
            P(imageView4);
            ImageView imageView5 = this.f21036s;
            if (imageView5 != null) {
                imageView5.setOnClickListener(new View.OnClickListener() { // from class: rb.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GameCenterVideoDraggableItem.L(GameCenterVideoDraggableItem.this, view);
                    }
                });
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void setAdStartTime(long j10) {
        this.f21037t = j10;
    }

    public final void setDoneWithShowAnimation(boolean z10) {
        this.f21033p = z10;
    }

    public final void setGameCenterWeakReference(GameCenterBaseActivity gameCenterBaseActivity) {
        m.g(gameCenterBaseActivity, "gameCenterBaseActivity");
        this.f21032o = new WeakReference<>(gameCenterBaseActivity);
    }

    public final void setGameCenterWeakReference(WeakReference<GameCenterBaseActivity> weakReference) {
        this.f21032o = weakReference;
    }

    public final void setMuteButton(ImageView imageView) {
        this.f21036s = imageView;
    }

    public final void setReadyToPlay(boolean z10) {
        this.f21034q = z10;
    }

    public final void setShrinked(boolean z10) {
        this.f21035r = z10;
    }

    @Override // com.scores365.DraggableView.VideoDraggableView
    public boolean t() {
        int parseInt;
        if (o0.y().C("LMT_VIDEO_CAP") == null) {
            parseInt = 0;
        } else {
            String C = o0.y().C("LMT_VIDEO_CAP");
            m.f(C, "getSettings().getTermInS…Settings(\"LMT_VIDEO_CAP\")");
            parseInt = Integer.parseInt(C);
        }
        return !RemoveAdsManager.isUserAdsRemoved(App.m()) && Boolean.parseBoolean(o0.y().C("LMT_VIDEO_ENABLED")) && sf.b.X1().c(b.e.GameCenterVisitForLmtAd, App.m()) % parseInt == 0 && !w0.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.DraggableView.VideoDraggableView
    public void u() {
        super.u();
        try {
            setVisibility(8);
            G();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.DraggableView.VideoDraggableView
    public void w() {
        super.w();
        try {
            setVisibility(8);
            G();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.DraggableView.VideoDraggableView
    public void x(i0 player) {
        WeakReference<GameCenterBaseActivity> weakReference;
        m.g(player, "player");
        super.x(player);
        try {
            setAlpha(1.0f);
            setVisibility(0);
            this.f21033p = true;
            if (App.f20792l.n() || (weakReference = this.f21032o) == null) {
                return;
            }
            m.d(weakReference);
            if (weakReference.get() != null) {
                player.l(true);
                this.f21037t = System.currentTimeMillis();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
