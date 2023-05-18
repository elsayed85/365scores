package com.scores365.dashboardEntities.dashboardScores;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.dashboard.ProgressCircleView;
import com.scores365.dashboardEntities.dashboardScores.f;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.RankingObj;
import com.scores365.entitys.SportTypeObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.eClockDirection;
import com.scores365.ui.CustomGameCenterHeaderView;
import com.scores365.ui.ScoresOddsView;
import com.scores365.ui.swipe.MyScoresItemTouchHelperCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
import nb.v;
/* compiled from: ScoresLiveGameItem.java */
/* loaded from: classes2.dex */
public class k extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f23472a;

    /* renamed from: b  reason: collision with root package name */
    private String f23473b;

    /* renamed from: c  reason: collision with root package name */
    boolean f23474c;

    /* renamed from: d  reason: collision with root package name */
    protected String f23475d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f23476e;

    /* renamed from: f  reason: collision with root package name */
    private int f23477f;

    /* renamed from: g  reason: collision with root package name */
    public c f23478g;

    /* compiled from: ScoresLiveGameItem.java */
    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<b> f23479a;

        /* renamed from: b  reason: collision with root package name */
        int f23480b;

        public a(b bVar, int i10) {
            this.f23479a = new WeakReference<>(bVar);
            this.f23480b = i10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                WeakReference<b> weakReference = this.f23479a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                k.z(this.f23479a.get(), this.f23480b);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: ScoresLiveGameItem.java */
    /* loaded from: classes2.dex */
    public static class b extends f.a {
        ImageView A;
        ScoresOddsView B;
        CustomGameCenterHeaderView.BaseballStatusViewsObj C;
        TextView D;
        TextView E;
        public int F;
        boolean G;
        private Animation.AnimationListener H;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintLayout f23481f;

        /* renamed from: g  reason: collision with root package name */
        ProgressCircleView f23482g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f23483h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f23484i;

        /* renamed from: j  reason: collision with root package name */
        TextView f23485j;

        /* renamed from: k  reason: collision with root package name */
        TextView f23486k;

        /* renamed from: l  reason: collision with root package name */
        TextView f23487l;

        /* renamed from: m  reason: collision with root package name */
        TextView f23488m;

        /* renamed from: n  reason: collision with root package name */
        TextView f23489n;

        /* renamed from: o  reason: collision with root package name */
        TextView f23490o;

        /* renamed from: p  reason: collision with root package name */
        TextView f23491p;

        /* renamed from: q  reason: collision with root package name */
        ImageView f23492q;

        /* renamed from: r  reason: collision with root package name */
        ImageView f23493r;

        /* renamed from: s  reason: collision with root package name */
        ImageView f23494s;

        /* renamed from: t  reason: collision with root package name */
        ImageView f23495t;

        /* renamed from: u  reason: collision with root package name */
        Timer f23496u;

        /* renamed from: v  reason: collision with root package name */
        Timer f23497v;

        /* renamed from: w  reason: collision with root package name */
        ValueAnimator f23498w;

        /* renamed from: x  reason: collision with root package name */
        TextView f23499x;

        /* renamed from: y  reason: collision with root package name */
        ImageView f23500y;

        /* renamed from: z  reason: collision with root package name */
        ImageView f23501z;

        /* compiled from: ScoresLiveGameItem.java */
        /* loaded from: classes2.dex */
        class a implements Animation.AnimationListener {
            a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                try {
                    b.this.B.setVisibility(8);
                    b.this.f23481f.setPadding(0, b.this.f23481f.getPaddingTop(), b.this.f23481f.getPaddingRight(), 0);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        public b(View view, q.e eVar) {
            super(view);
            this.f23498w = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.F = -1;
            this.H = new a();
            this.B = (ScoresOddsView) view.findViewById(R.id.mq);
            this.f23482g = (ProgressCircleView) view.findViewById(R.id.Pj);
            this.f23483h = (ImageView) view.findViewById(R.id.Hb);
            this.f23484i = (ImageView) view.findViewById(R.id.f22313ta);
            this.f23485j = (TextView) view.findViewById(R.id.Nr);
            this.f23486k = (TextView) view.findViewById(R.id.Or);
            this.f23487l = (TextView) view.findViewById(R.id.tu);
            this.f23488m = (TextView) view.findViewById(R.id.Dt);
            this.f23489n = (TextView) view.findViewById(R.id.ds);
            this.f23490o = (TextView) view.findViewById(R.id.Fo);
            this.f23491p = (TextView) view.findViewById(R.id.sw);
            this.f23501z = (ImageView) view.findViewById(R.id.f22025ga);
            this.A = (ImageView) view.findViewById(R.id.f22047ha);
            this.f23492q = (ImageView) view.findViewById(R.id.Ib);
            this.f23493r = (ImageView) view.findViewById(R.id.M8);
            this.f23494s = (ImageView) view.findViewById(R.id.f22335ua);
            this.f23495t = (ImageView) view.findViewById(R.id.f22024g9);
            this.f23499x = (TextView) view.findViewById(R.id.D);
            this.f23500y = (ImageView) view.findViewById(R.id.C);
            this.f23481f = (ConstraintLayout) view.findViewById(R.id.Fn);
            this.leftStripe = view.findViewById(R.id.Cf);
            this.C = new CustomGameCenterHeaderView.BaseballStatusViewsObj(view);
            this.D = (TextView) view.findViewById(R.id.OA);
            this.E = (TextView) view.findViewById(R.id.jD);
            if (Build.VERSION.SDK_INT >= 23) {
                ((t) this).itemView.setBackgroundColor(p0.A(R.attr.f21557k));
            }
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }

        private void d(k kVar) {
            if (!CustomGameCenterHeaderView.handleBaseballStatusViews(kVar.gameObj, this.C, x0.n1())) {
                ((ViewGroup.MarginLayoutParams) this.f23489n.getLayoutParams()).bottomMargin = 0;
                ((ViewGroup.MarginLayoutParams) this.f23499x.getLayoutParams()).bottomMargin = 0;
                this.C.basesView.setVisibility(8);
                this.C.ballsContainer.setVisibility(8);
                this.f23490o.setVisibility(0);
                this.D.setVisibility(8);
                this.E.setVisibility(8);
                ((ConstraintLayout.b) this.f23495t.getLayoutParams()).f4624f = this.f23490o.getId();
                ((ConstraintLayout.b) this.f23493r.getLayoutParams()).f4626g = this.f23490o.getId();
                return;
            }
            ((ViewGroup.MarginLayoutParams) this.f23489n.getLayoutParams()).bottomMargin = p0.s(10);
            ((ViewGroup.MarginLayoutParams) this.f23499x.getLayoutParams()).bottomMargin = p0.s(10);
            if (kVar.f23476e) {
                this.D.setText(String.valueOf(kVar.gameObj.getScores()[1].getScore()));
                this.E.setText(String.valueOf(kVar.gameObj.getScores()[0].getScore()));
            } else {
                this.D.setText(String.valueOf(kVar.gameObj.getScores()[0].getScore()));
                this.E.setText(String.valueOf(kVar.gameObj.getScores()[1].getScore()));
            }
            this.f23490o.setVisibility(4);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            ((ConstraintLayout.b) this.f23495t.getLayoutParams()).f4624f = this.E.getId();
            ((ConstraintLayout.b) this.f23493r.getLayoutParams()).f4626g = this.D.getId();
        }

        private void l(int i10) {
            if (i10 == 0 || App.f20803w) {
                return;
            }
            this.B.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21514n));
        }

        private void m(k kVar) {
            try {
                if (kVar.gameObj.IsHaveNotification()) {
                    kVar.t(kVar.gameObj.GetLatestNotification(), this);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public int getBottomOfItemView() {
            return p0.s(1);
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public MyScoresItemTouchHelperCallback.ButtonsState getButtonState() {
            return this.buttonsState;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public int getLeftOfItemView() {
            try {
                return p0.s(3);
            } catch (Exception e10) {
                x0.N1(e10);
                return 0;
            }
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public float getLooseCoordinateX() {
            return this.looseCoordinateX;
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public float getOffsetX() {
            return this.holderOffsetX;
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public Rect getRemoveButtonFrame() {
            return this.removeButtonFrame;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public int getTopMarginItemView() {
            return p0.s(1);
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public boolean isSelected() {
            return this.hasNotifications;
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public boolean isSwipeable() {
            return this.G;
        }

        public void n() {
            try {
                Timer timer = this.f23496u;
                if (timer != null) {
                    timer.cancel();
                    this.f23496u.purge();
                }
                Timer timer2 = this.f23497v;
                if (timer2 != null) {
                    timer2.cancel();
                    this.f23497v.purge();
                }
                this.f23498w.cancel();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public void setButtonState(MyScoresItemTouchHelperCallback.ButtonsState buttonsState) {
            this.buttonsState = buttonsState;
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public void setLooseCoordinateX(float f10) {
            this.looseCoordinateX = f10;
        }

        @Override // com.scores365.dashboardEntities.dashboardScores.f.a, com.scores365.ui.swipe.SwipeableViewHolder
        public void setOffsetX(float f10) {
            this.holderOffsetX = f10;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void toggleViewHolder() {
            try {
                int i10 = 0;
                this.hasNotifications = !this.hasNotifications;
                View leftStripe = getLeftStripe();
                if (!this.hasNotifications) {
                    i10 = 8;
                }
                leftStripe.setVisibility(i10);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:3:0x0004, B:5:0x0008, B:15:0x005b, B:17:0x0064, B:18:0x0069, B:20:0x0074, B:21:0x0079, B:23:0x0081, B:25:0x0085, B:27:0x0095, B:28:0x00a9, B:30:0x00b1, B:32:0x00b7, B:34:0x0107, B:36:0x010b, B:37:0x0117, B:39:0x012c, B:42:0x0145, B:44:0x014b, B:46:0x0151, B:48:0x0157, B:50:0x0165, B:65:0x023c, B:52:0x01aa, B:54:0x01b0, B:56:0x01b8, B:58:0x01c2, B:60:0x01cd, B:61:0x022b, B:63:0x022f, B:64:0x0237, B:33:0x00e6, B:14:0x0057), top: B:70:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:3:0x0004, B:5:0x0008, B:15:0x005b, B:17:0x0064, B:18:0x0069, B:20:0x0074, B:21:0x0079, B:23:0x0081, B:25:0x0085, B:27:0x0095, B:28:0x00a9, B:30:0x00b1, B:32:0x00b7, B:34:0x0107, B:36:0x010b, B:37:0x0117, B:39:0x012c, B:42:0x0145, B:44:0x014b, B:46:0x0151, B:48:0x0157, B:50:0x0165, B:65:0x023c, B:52:0x01aa, B:54:0x01b0, B:56:0x01b8, B:58:0x01c2, B:60:0x01cd, B:61:0x022b, B:63:0x022f, B:64:0x0237, B:33:0x00e6, B:14:0x0057), top: B:70:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x010b A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:3:0x0004, B:5:0x0008, B:15:0x005b, B:17:0x0064, B:18:0x0069, B:20:0x0074, B:21:0x0079, B:23:0x0081, B:25:0x0085, B:27:0x0095, B:28:0x00a9, B:30:0x00b1, B:32:0x00b7, B:34:0x0107, B:36:0x010b, B:37:0x0117, B:39:0x012c, B:42:0x0145, B:44:0x014b, B:46:0x0151, B:48:0x0157, B:50:0x0165, B:65:0x023c, B:52:0x01aa, B:54:0x01b0, B:56:0x01b8, B:58:0x01c2, B:60:0x01cd, B:61:0x022b, B:63:0x022f, B:64:0x0237, B:33:0x00e6, B:14:0x0057), top: B:70:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x012c A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:3:0x0004, B:5:0x0008, B:15:0x005b, B:17:0x0064, B:18:0x0069, B:20:0x0074, B:21:0x0079, B:23:0x0081, B:25:0x0085, B:27:0x0095, B:28:0x00a9, B:30:0x00b1, B:32:0x00b7, B:34:0x0107, B:36:0x010b, B:37:0x0117, B:39:0x012c, B:42:0x0145, B:44:0x014b, B:46:0x0151, B:48:0x0157, B:50:0x0165, B:65:0x023c, B:52:0x01aa, B:54:0x01b0, B:56:0x01b8, B:58:0x01c2, B:60:0x01cd, B:61:0x022b, B:63:0x022f, B:64:0x0237, B:33:0x00e6, B:14:0x0057), top: B:70:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x022f A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:3:0x0004, B:5:0x0008, B:15:0x005b, B:17:0x0064, B:18:0x0069, B:20:0x0074, B:21:0x0079, B:23:0x0081, B:25:0x0085, B:27:0x0095, B:28:0x00a9, B:30:0x00b1, B:32:0x00b7, B:34:0x0107, B:36:0x010b, B:37:0x0117, B:39:0x012c, B:42:0x0145, B:44:0x014b, B:46:0x0151, B:48:0x0157, B:50:0x0165, B:65:0x023c, B:52:0x01aa, B:54:0x01b0, B:56:0x01b8, B:58:0x01c2, B:60:0x01cd, B:61:0x022b, B:63:0x022f, B:64:0x0237, B:33:0x00e6, B:14:0x0057), top: B:70:0x0004 }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0237 A[Catch: Exception -> 0x0250, TryCatch #0 {Exception -> 0x0250, blocks: (B:3:0x0004, B:5:0x0008, B:15:0x005b, B:17:0x0064, B:18:0x0069, B:20:0x0074, B:21:0x0079, B:23:0x0081, B:25:0x0085, B:27:0x0095, B:28:0x00a9, B:30:0x00b1, B:32:0x00b7, B:34:0x0107, B:36:0x010b, B:37:0x0117, B:39:0x012c, B:42:0x0145, B:44:0x014b, B:46:0x0151, B:48:0x0157, B:50:0x0165, B:65:0x023c, B:52:0x01aa, B:54:0x01b0, B:56:0x01b8, B:58:0x01c2, B:60:0x01cd, B:61:0x022b, B:63:0x022f, B:64:0x0237, B:33:0x00e6, B:14:0x0057), top: B:70:0x0004 }] */
        @Override // com.scores365.dashboardEntities.dashboardScores.f.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateViewHolder(com.scores365.dashboardEntities.dashboardScores.f r28, boolean r29, boolean r30, boolean r31) {
            /*
                Method dump skipped, instructions count: 597
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboardEntities.dashboardScores.k.b.updateViewHolder(com.scores365.dashboardEntities.dashboardScores.f, boolean, boolean, boolean):void");
        }
    }

    /* compiled from: ScoresLiveGameItem.java */
    /* loaded from: classes2.dex */
    public static class c extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TextView> f23503a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<GameObj> f23504b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f23505c = new Handler();

        public c(TextView textView, GameObj gameObj) {
            this.f23503a = new WeakReference<>(textView);
            this.f23504b = new WeakReference<>(gameObj);
        }

        public void a() {
            try {
                cancel();
                this.f23503a = null;
                this.f23504b = null;
                Handler handler = this.f23505c;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                this.f23505c = null;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                WeakReference<TextView> weakReference = this.f23503a;
                if (weakReference == null || this.f23504b == null) {
                    return;
                }
                TextView textView = weakReference.get();
                GameObj gameObj = this.f23504b.get();
                if (textView == null || gameObj == null) {
                    return;
                }
                this.f23505c.post(new d(textView, gameObj.getLiveGameTime()));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: ScoresLiveGameItem.java */
    /* loaded from: classes2.dex */
    private static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TextView> f23506a;

        /* renamed from: b  reason: collision with root package name */
        private String f23507b;

        public d(TextView textView, String str) {
            this.f23506a = new WeakReference<>(textView);
            this.f23507b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TextView textView = this.f23506a.get();
                if (textView != null) {
                    try {
                        if (!textView.getText().equals(this.f23507b) && !this.f23507b.isEmpty()) {
                            textView.setText(this.f23507b);
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    public k(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, Locale locale) {
        super(gameObj, competitionObj, z10, z11, z12, locale);
        this.f23472a = null;
        this.f23473b = null;
        this.f23474c = false;
        this.f23475d = null;
        this.f23476e = false;
        this.f23477f = 8;
        this.f23478g = null;
        try {
            p pVar = p.Competitors;
            long id2 = gameObj.getComps()[0].getID();
            Integer valueOf = Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE);
            Integer valueOf2 = Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE);
            int sportID = gameObj.getSportID();
            SportTypesEnum sportTypesEnum = SportTypesEnum.TENNIS;
            this.f23472a = o.s(pVar, id2, valueOf, valueOf2, sportID == sportTypesEnum.getValue(), gameObj.getComps()[0].getImgVer());
            this.f23473b = o.s(pVar, gameObj.getComps()[1].getID(), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), gameObj.getSportID() == sportTypesEnum.getValue(), gameObj.getComps()[1].getImgVer());
            this.f23476e = x0.l(gameObj.homeAwayTeamOrder, true);
            y(null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void A(b bVar) {
        try {
            GameObj gameObj = this.gameObj;
            gameObj.setGT(gameObj.getGameMinutes());
            bVar.f23489n.setText(this.gameObj.getLiveGameTime());
            this.f23478g = new c(bVar.f23489n, this.gameObj);
            Timer timer = new Timer();
            bVar.f23496u = timer;
            timer.scheduleAtFixedRate(this.f23478g, 10L, 1000L);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.U7, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private void s(CompObj compObj, TextView textView) {
        if (compObj != null) {
            try {
                if (compObj.getRankingObjs() == null || compObj.getRankingObjs().isEmpty()) {
                    return;
                }
                RankingObj rankingObj = compObj.getRankingObjs().get(0);
                if (rankingObj.getPosition() > 0) {
                    textView.setText(String.valueOf(rankingObj.getPosition()));
                    textView.setTypeface(o0.c(App.m()));
                    textView.setVisibility(0);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void t(GameObj.LatestNotifications latestNotifications, b bVar) {
        try {
            if (latestNotifications.IsNotificationExpired() || this.gameObj.getBaseballStatusObj() != null) {
                return;
            }
            if (bVar.f23498w.isRunning()) {
                bVar.f23498w.cancel();
            }
            bVar.f23500y.setVisibility(0);
            li.u.A(o.r(x0.n1() ? p.NotificationsAnimationsLight : p.NotificationsAnimationsDark, latestNotifications.ID, Integer.valueOf(p0.s(20)), Integer.valueOf(p0.s(20)), false), bVar.f23500y, null);
            String str = latestNotifications.Name;
            if (str != null && !str.isEmpty()) {
                bVar.f23499x.setVisibility(0);
                bVar.f23499x.setText(latestNotifications.Name);
                bVar.f23499x.setTypeface(v.m());
                bVar.f23498w.addUpdateListener(new CustomGameCenterHeaderView.CrossFadeAnimationUpdateListener(bVar.f23489n, bVar.f23499x, null));
                bVar.f23498w.addListener(new a(bVar, this.gameObj.getSportID()));
                bVar.f23498w.setDuration(1000L);
                bVar.f23498w.setRepeatMode(2);
                bVar.f23498w.setRepeatCount((int) (((latestNotifications.expiredTime - System.currentTimeMillis()) / 1000) + 1));
                bVar.f23498w.setInterpolator(new LinearInterpolator());
                bVar.f23498w.start();
            }
            boolean l10 = x0.l(this.gameObj.homeAwayTeamOrder, true);
            bVar.f23501z.setVisibility(8);
            bVar.A.setVisibility(8);
            if ((latestNotifications.getCompetitorNum() == 1 && !l10) || (latestNotifications.getCompetitorNum() == 2 && l10)) {
                bVar.f23501z.setVisibility(0);
            }
            if ((latestNotifications.getCompetitorNum() == 2 && !l10) || (latestNotifications.getCompetitorNum() == 1 && l10)) {
                bVar.A.setVisibility(0);
            }
            if (!latestNotifications.isAlreadyRender) {
                bVar.f23500y.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21513m));
            }
            bVar.f23491p.setVisibility(8);
            latestNotifications.isAlreadyRender = true;
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea A[Catch: Exception -> 0x0155, TryCatch #0 {Exception -> 0x0155, blocks: (B:2:0x0000, B:4:0x0024, B:7:0x0034, B:9:0x0056, B:11:0x005f, B:13:0x006d, B:19:0x00e0, B:21:0x00ea, B:26:0x0107, B:28:0x010b, B:29:0x012e, B:22:0x00f1, B:24:0x00fa, B:25:0x0101, B:14:0x00a0, B:10:0x005b, B:15:0x00d3, B:17:0x00d7, B:18:0x00dc), top: B:34:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f1 A[Catch: Exception -> 0x0155, TryCatch #0 {Exception -> 0x0155, blocks: (B:2:0x0000, B:4:0x0024, B:7:0x0034, B:9:0x0056, B:11:0x005f, B:13:0x006d, B:19:0x00e0, B:21:0x00ea, B:26:0x0107, B:28:0x010b, B:29:0x012e, B:22:0x00f1, B:24:0x00fa, B:25:0x0101, B:14:0x00a0, B:10:0x005b, B:15:0x00d3, B:17:0x00d7, B:18:0x00dc), top: B:34:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010b A[Catch: Exception -> 0x0155, TryCatch #0 {Exception -> 0x0155, blocks: (B:2:0x0000, B:4:0x0024, B:7:0x0034, B:9:0x0056, B:11:0x005f, B:13:0x006d, B:19:0x00e0, B:21:0x00ea, B:26:0x0107, B:28:0x010b, B:29:0x012e, B:22:0x00f1, B:24:0x00fa, B:25:0x0101, B:14:0x00a0, B:10:0x005b, B:15:0x00d3, B:17:0x00d7, B:18:0x00dc), top: B:34:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012e A[Catch: Exception -> 0x0155, TRY_LEAVE, TryCatch #0 {Exception -> 0x0155, blocks: (B:2:0x0000, B:4:0x0024, B:7:0x0034, B:9:0x0056, B:11:0x005f, B:13:0x006d, B:19:0x00e0, B:21:0x00ea, B:26:0x0107, B:28:0x010b, B:29:0x012e, B:22:0x00f1, B:24:0x00fa, B:25:0x0101, B:14:0x00a0, B:10:0x005b, B:15:0x00d3, B:17:0x00d7, B:18:0x00dc), top: B:34:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u(com.scores365.dashboardEntities.dashboardScores.k.b r7) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboardEntities.dashboardScores.k.u(com.scores365.dashboardEntities.dashboardScores.k$b):void");
    }

    private void v(ProgressCircleView progressCircleView, GameObj gameObj, StatusObj statusObj) {
        ArrayList<ProgressCircleView.a> arrayList = new ArrayList<>();
        arrayList.add(new ProgressCircleView.a(progressCircleView.f23312a, 0.0f, 100.0f));
        if (statusObj.isExtraTime()) {
            arrayList.add(new ProgressCircleView.a(progressCircleView.f23314c, 0.0f, (float) gameObj.gameTimeCompletion));
            arrayList.add(new ProgressCircleView.a(progressCircleView.f23313b, 0.0f, gameObj.regularTimeCompletion));
        } else {
            arrayList.add(new ProgressCircleView.a(progressCircleView.f23313b, 0.0f, (float) gameObj.gameTimeCompletion));
        }
        progressCircleView.d(gameObj.GetMajorEvents(App.m()), App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getID(), gameObj.isExtraTime());
        progressCircleView.setDataArray(arrayList);
        progressCircleView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(b bVar) {
        try {
            RecyclerView.q qVar = (RecyclerView.q) ((t) bVar).itemView.getLayoutParams();
            if (!this.isLastItem || this.hasPlayersItemBelow) {
                ((ViewGroup.MarginLayoutParams) qVar).bottomMargin = 0;
            } else {
                ((ViewGroup.MarginLayoutParams) qVar).bottomMargin = p0.s(4);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(b bVar, SportTypeObj sportTypeObj, StatusObj statusObj) {
        CompObj compObj;
        CompObj compObj2;
        try {
            int sid = this.competitionObj.getSid();
            SportTypesEnum sportTypesEnum = SportTypesEnum.BASKETBALL;
            if (sid == sportTypesEnum.getValue() && this.competitionObj.SubSportType == 1) {
                if (statusObj.getID() != 16 && statusObj.getID() != 17) {
                    if (statusObj.getID() == 18 || statusObj.getID() == 19) {
                        statusObj = sportTypeObj.getStatuses().get(138);
                    }
                }
                statusObj = sportTypeObj.getStatuses().get(137);
            }
            bVar.f23485j.setTypeface(o0.d(App.m()));
            bVar.f23486k.setTypeface(o0.d(App.m()));
            if (this.f23476e) {
                bVar.f23485j.setText(this.gameObj.getComps()[1].getName());
                bVar.f23486k.setText(this.gameObj.getComps()[0].getName());
            } else {
                bVar.f23485j.setText(this.gameObj.getComps()[0].getName());
                bVar.f23486k.setText(this.gameObj.getComps()[1].getName());
            }
            bVar.f23487l.setVisibility(8);
            bVar.f23488m.setVisibility(8);
            int sportID = this.gameObj.getSportID();
            if (sportID == sportTypesEnum.getValue() || sportID == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                if (this.f23476e) {
                    compObj = this.gameObj.getComps()[1];
                    compObj2 = this.gameObj.getComps()[0];
                } else {
                    compObj = this.gameObj.getComps()[0];
                    compObj2 = this.gameObj.getComps()[1];
                }
                s(compObj, bVar.f23487l);
                s(compObj2, bVar.f23488m);
            }
            bVar.f23490o.setTypeface(o0.a(App.m()));
            y(bVar.f23490o);
            bVar.f23490o.setTextSize(1, 22.0f);
            bVar.f23491p.setTypeface(o0.a(App.m()));
            bVar.f23491p.setVisibility(8);
            bVar.f23491p.setText("");
            if (this.gameObj.getSportID() != SportTypesEnum.TENNIS.getValue() && this.gameObj.addedTime > 0) {
                TextView textView = bVar.f23491p;
                textView.setText("+" + this.gameObj.addedTime);
                bVar.f23491p.setVisibility(0);
            }
            Timer timer = bVar.f23496u;
            if (timer != null) {
                timer.cancel();
                bVar.f23496u = null;
            }
            c cVar = this.f23478g;
            if (cVar != null) {
                cVar.a();
                this.f23478g = null;
            }
            bVar.f23489n.setTextColor(p0.A(R.attr.U0));
            if (statusObj.getHasGameTime()) {
                A(bVar);
            } else {
                bVar.f23489n.setText(x0.I0(this.gameObj, true));
            }
            bVar.f23489n.setTypeface(o0.b(App.m()));
            bVar.f23482g.setVisibility(4);
            if (sportTypeObj.getSportTypeClockDirection() != eClockDirection.WITHOUT_CLOCK) {
                v(bVar.f23482g, this.gameObj, statusObj);
            }
            u(bVar);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private String y(TextView textView) {
        if (textView != null) {
            try {
                Typeface typeface = textView.getTypeface();
                float textSize = textView.getTextSize();
                textView.setTypeface(typeface);
                textView.setTextSize(textSize);
            } catch (Exception e10) {
                x0.N1(e10);
                return "";
            }
        }
        if (this.f23475d == null) {
            if (this.gameObj.getSportID() == SportTypesEnum.CRICKET.getValue()) {
                GameObj gameObj = this.gameObj;
                this.f23475d = x0.P(gameObj, gameObj.homeAwayTeamOrder);
            } else if (this.gameObj.getScores()[1].getScore() != -1 && this.gameObj.getScores()[0].getScore() != -1) {
                StringBuilder sb2 = new StringBuilder();
                boolean z10 = this.f23476e;
                int i10 = !z10 ? 1 : 0;
                sb2.append(this.gameObj.getScores()[z10 ? 1 : 0].getScore());
                sb2.append(" - ");
                sb2.append(this.gameObj.getScores()[i10].getScore());
                this.f23475d = sb2.toString();
            }
        }
        if (textView != null) {
            textView.setText(this.f23475d);
        }
        return this.f23475d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(b bVar, int i10) {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(App.m(), R.anim.f21506f);
            if (i10 == SportTypesEnum.TENNIS.getValue()) {
                bVar.f23489n.setVisibility(0);
                bVar.f23490o.startAnimation(loadAnimation);
                bVar.f23490o.setVisibility(0);
                bVar.f23491p.startAnimation(loadAnimation);
                bVar.f23491p.setVisibility(0);
                bVar.f23491p.setAlpha(1.0f);
            } else if (i10 == SportTypesEnum.SOCCER.getValue() || i10 == SportTypesEnum.HOCKEY.getValue() || i10 == SportTypesEnum.RUGBY.getValue() || i10 == SportTypesEnum.CRICKET.getValue()) {
                bVar.f23489n.setVisibility(0);
                bVar.f23489n.setAlpha(1.0f);
                bVar.f23491p.setAlpha(1.0f);
            }
            bVar.f23499x.setVisibility(8);
            bVar.f23500y.setVisibility(8);
            bVar.f23501z.setVisibility(8);
            bVar.A.setVisibility(8);
            Timer timer = bVar.f23497v;
            if (timer != null) {
                timer.purge();
                bVar.f23497v.cancel();
            }
            bVar.f23497v = null;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LiveGame.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ((b) e0Var).updateViewHolder(this, false, true, true);
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10, boolean z10, boolean z11) {
        try {
            ((b) e0Var).updateViewHolder(this, z10, true, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.f
    public void setGameObj(GameObj gameObj) {
        super.setGameObj(gameObj);
        this.f23475d = null;
        y(null);
    }
}
