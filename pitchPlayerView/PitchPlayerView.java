package com.scores365.pitchPlayerView;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.PlayerObj;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.ui.NoTeamDataActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import ee.k;
import java.util.HashMap;
import li.o0;
import li.p0;
import li.x0;
import se.f;
/* loaded from: classes2.dex */
public class PitchPlayerView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public ConstraintLayout f24194a;

    /* renamed from: b  reason: collision with root package name */
    public CircleImageView f24195b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f24196c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f24197d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f24198e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24199f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24200g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f24201h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f24202i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f24203j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f24204k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f24205l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f24206m;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f24207n;

    /* renamed from: o  reason: collision with root package name */
    private View f24208o;

    /* renamed from: p  reason: collision with root package name */
    boolean f24209p;

    /* renamed from: q  reason: collision with root package name */
    float f24210q;

    /* renamed from: r  reason: collision with root package name */
    float f24211r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f24212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FragmentManager f24214c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f24215d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f24216e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f24217f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ PlayerObj f24218g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f24219h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f24220i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f24221j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ boolean f24222k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ boolean f24223l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ boolean f24224m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ String f24225n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ boolean f24226o;

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ int f24227p;

        a(int i10, int i11, FragmentManager fragmentManager, boolean z10, int i12, boolean z11, PlayerObj playerObj, String str, String str2, String str3, boolean z12, boolean z13, boolean z14, String str4, boolean z15, int i13) {
            this.f24212a = i10;
            this.f24213b = i11;
            this.f24214c = fragmentManager;
            this.f24215d = z10;
            this.f24216e = i12;
            this.f24217f = z11;
            this.f24218g = playerObj;
            this.f24219h = str;
            this.f24220i = str2;
            this.f24221j = str3;
            this.f24222k = z12;
            this.f24223l = z13;
            this.f24224m = z14;
            this.f24225n = str4;
            this.f24226o = z15;
            this.f24227p = i13;
        }

        private void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("competition_id", Integer.valueOf(this.f24216e));
            hashMap.put("season_num", Integer.valueOf(this.f24227p));
            hashMap.put("matchweek", this.f24225n);
            hashMap.put("athlete_id", Integer.valueOf(this.f24218g.athleteId));
            hashMap.put("position", Integer.valueOf(this.f24218g.getPosition()));
            hashMap.put("formation_position", Integer.valueOf(this.f24218g.getFormationPosition()));
            hashMap.put("competitor_id", Integer.valueOf(this.f24218g.competitorId));
            k.m(App.m(), "dashboard", "totw", "athlete", "click", true, hashMap);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                int i10 = this.f24212a;
                boolean z10 = PitchPlayerView.this.f24209p;
                int i11 = this.f24213b;
                FragmentManager fragmentManager = this.f24214c;
                Context m10 = App.m();
                a.EnumC0251a enumC0251a = this.f24215d ? a.EnumC0251a.HOME : a.EnumC0251a.AWAY;
                int i12 = this.f24216e;
                boolean z11 = this.f24217f;
                PlayerObj playerObj = this.f24218g;
                p0.s0(i10, z10, i11, fragmentManager, m10, enumC0251a, i12, z11, playerObj.athleteId, playerObj.pId, i12, this.f24219h, this.f24220i, this.f24221j, this.f24222k, this.f24223l, new f(this.f24224m, this.f24225n), this.f24226o);
                if (this.f24224m) {
                    a();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PlayerObj f24229a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24230b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24231c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24232d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f24233e;

        b(PlayerObj playerObj, int i10, String str, int i11, Context context) {
            this.f24229a = playerObj;
            this.f24230b = i10;
            this.f24231c = str;
            this.f24232d = i11;
            this.f24233e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            try {
                PlayerObj playerObj = this.f24229a;
                if (playerObj == null || playerObj.getPlayerName() == null || this.f24229a.getPlayerName().isEmpty()) {
                    str = "";
                    str2 = str;
                } else {
                    str2 = this.f24229a.getPlayerName();
                    str = this.f24229a.getImgVer();
                }
                NoTeamDataActivity.eNoTeamDataErrorType enoteamdataerrortype = NoTeamDataActivity.eNoTeamDataErrorType.Player;
                int i10 = this.f24230b;
                String str3 = this.f24231c;
                int i11 = this.f24232d;
                PlayerObj playerObj2 = this.f24229a;
                p0.m(enoteamdataerrortype, i10, str3, i11, playerObj2.countryId, this.f24233e, str, str2, playerObj2.athleteId);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public PitchPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24209p = false;
        this.f24210q = 1.0f;
        this.f24211r = 1.0f;
        View inflate = View.inflate(context, R.layout.K3, null);
        this.f24208o = inflate;
        addView(inflate);
        c(false);
        setPivotX(this.f24195b.getPivotX());
        setPivotY(this.f24195b.getPivotY());
    }

    public void a() {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(App.m(), R.anim.f21507g);
            if (this.f24196c.getVisibility() == 0) {
                this.f24196c.startAnimation(loadAnimation);
            }
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    public void b() {
        try {
            this.f24199f.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21510j));
            this.f24199f.setVisibility(8);
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    public void c(boolean z10) {
        try {
            this.f24194a = (ConstraintLayout) this.f24208o.findViewById(R.id.po);
            this.f24195b = (CircleImageView) this.f24208o.findViewById(R.id.f22403xc);
            this.f24196c = (LinearLayout) this.f24208o.findViewById(R.id.Kg);
            this.f24197d = (ImageView) this.f24208o.findViewById(R.id.Md);
            this.f24198e = (LinearLayout) this.f24208o.findViewById(R.id.f21962dg);
            this.f24200g = (TextView) this.f24208o.findViewById(R.id.fA);
            this.f24201h = (TextView) this.f24208o.findViewById(R.id.nC);
            this.f24202i = (ImageView) this.f24208o.findViewById(R.id.Lc);
            this.f24203j = (ImageView) this.f24208o.findViewById(R.id.f22135l9);
            this.f24204k = (ImageView) this.f24208o.findViewById(R.id.gA);
            this.f24205l = (TextView) this.f24208o.findViewById(R.id.EA);
            this.f24206m = (TextView) this.f24208o.findViewById(R.id.gG);
            this.f24207n = (RelativeLayout) this.f24208o.findViewById(R.id.f21939cg);
            this.f24199f = (TextView) this.f24208o.findViewById(R.id.f22146lk);
            this.f24205l.setTypeface(o0.d(App.m()));
            this.f24201h.setTypeface(o0.a(App.m()));
            this.f24199f.setTypeface(o0.c(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void d() {
        this.f24195b.setImageResource(R.drawable.f21845w6);
        this.f24196c.setVisibility(8);
        this.f24198e.setVisibility(8);
        this.f24202i.setVisibility(8);
        this.f24206m.setText("");
        this.f24201h.setText("");
        this.f24205l.setText("");
        this.f24200g.setText("");
    }

    public void e(View view, float f10, float f11) {
        view.setScaleX(f11);
        view.setScaleY(f11);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.content.Context r21, com.scores365.entitys.PlayerObj r22, int r23, int r24, int r25, java.lang.String r26, int r27, java.lang.String r28, java.lang.String r29, androidx.fragment.app.FragmentManager r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, int r36, java.lang.String r37, boolean r38) {
        /*
            r20 = this;
            r15 = r20
            r0 = r22
            int r1 = r0.athleteId     // Catch: java.lang.Exception -> L7b
            if (r1 > 0) goto L24
            if (r34 == 0) goto Lb
            goto L24
        Lb:
            android.view.View r1 = r15.f24208o     // Catch: java.lang.Exception -> L7b
            com.scores365.pitchPlayerView.PitchPlayerView$b r2 = new com.scores365.pitchPlayerView.PitchPlayerView$b     // Catch: java.lang.Exception -> L7b
            r27 = r2
            r28 = r20
            r29 = r22
            r30 = r23
            r31 = r26
            r32 = r25
            r33 = r21
            r27.<init>(r29, r30, r31, r32, r33)     // Catch: java.lang.Exception -> L7b
            r1.setOnClickListener(r2)     // Catch: java.lang.Exception -> L7b
            goto L56
        L24:
            android.view.View r14 = r15.f24208o     // Catch: java.lang.Exception -> L7b
            com.scores365.pitchPlayerView.PitchPlayerView$a r13 = new com.scores365.pitchPlayerView.PitchPlayerView$a     // Catch: java.lang.Exception -> L7b
            r1 = r13
            r2 = r20
            r3 = r25
            r4 = r27
            r5 = r30
            r6 = r32
            r7 = r24
            r8 = r31
            r9 = r22
            r10 = r26
            r11 = r28
            r12 = r29
            r0 = r13
            r13 = r33
            r19 = r14
            r14 = r34
            r15 = r35
            r16 = r37
            r17 = r38
            r18 = r36
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Exception -> L77
            r1 = r19
            r1.setOnClickListener(r0)     // Catch: java.lang.Exception -> L77
        L56:
            sf.b r0 = sf.b.X1()     // Catch: java.lang.Exception -> L77
            boolean r0 = r0.L3()     // Catch: java.lang.Exception -> L77
            if (r0 == 0) goto L74
            r1 = r20
            android.view.View r0 = r1.f24208o     // Catch: java.lang.Exception -> L72
            li.k r2 = new li.k     // Catch: java.lang.Exception -> L72
            r3 = r22
            int r3 = r3.athleteId     // Catch: java.lang.Exception -> L72
            long r3 = (long) r3     // Catch: java.lang.Exception -> L72
            r2.<init>(r3)     // Catch: java.lang.Exception -> L72
            r0.setOnLongClickListener(r2)     // Catch: java.lang.Exception -> L72
            goto L80
        L72:
            r0 = move-exception
            goto L7d
        L74:
            r1 = r20
            goto L80
        L77:
            r0 = move-exception
            r1 = r20
            goto L7d
        L7b:
            r0 = move-exception
            r1 = r15
        L7d:
            li.x0.N1(r0)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.pitchPlayerView.PitchPlayerView.f(android.content.Context, com.scores365.entitys.PlayerObj, int, int, int, java.lang.String, int, java.lang.String, java.lang.String, androidx.fragment.app.FragmentManager, boolean, boolean, boolean, boolean, boolean, int, java.lang.String, boolean):void");
    }

    public void g(PlayerObj playerObj, PitchPlayerView pitchPlayerView) {
        try {
            if (playerObj.getRankingToDisplay() < 0.0d) {
                pitchPlayerView.f24199f.setText(" - ");
            } else {
                pitchPlayerView.f24199f.setText("");
                pitchPlayerView.f24199f.setGravity(14);
                pitchPlayerView.f24199f.setText(String.valueOf(playerObj.getRankingToDisplay()));
            }
            pitchPlayerView.f24199f.setBackgroundResource(playerObj.getRankingBG());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public float getScaleFactor() {
        return this.f24211r;
    }

    public void h(PlayerObj playerObj, PitchPlayerView pitchPlayerView) {
        try {
            pitchPlayerView.f24199f.setText(String.valueOf(playerObj.getRankingToDisplay()));
            pitchPlayerView.f24199f.setBackgroundResource(PlayerObj.getTopRankingBG());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setNational(boolean z10) {
        this.f24209p = z10;
    }

    public void setPitchPlayerViewSize(double d10) {
        try {
            float f10 = (float) d10;
            e(this.f24195b, this.f24210q, f10);
            this.f24210q = f10;
            this.f24195b.requestLayout();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setScaleFactor(double d10) {
        this.f24211r = (float) d10;
    }
}
