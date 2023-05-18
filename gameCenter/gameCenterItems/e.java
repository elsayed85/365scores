package com.scores365.gameCenter.gameCenterItems;

import ag.j0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.SuspensionObj;
import com.scores365.entitys.eAthleteInjuryCategory;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.gameCenter.gameCenterItems.c;
import de.hdodenhof.circleimageview.CircleImageView;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: GameCenterNewLinupsSubPlayerItem.java */
/* loaded from: classes2.dex */
public class e extends com.scores365.Design.PageObjects.b implements j0 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f23812a;

    /* renamed from: b  reason: collision with root package name */
    public PlayerObj f23813b;

    /* renamed from: c  reason: collision with root package name */
    public int f23814c;

    /* renamed from: d  reason: collision with root package name */
    public int f23815d;

    /* renamed from: e  reason: collision with root package name */
    public int f23816e;

    /* renamed from: f  reason: collision with root package name */
    public c.EnumC0252c f23817f;

    /* renamed from: g  reason: collision with root package name */
    public String f23818g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23819h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23820i;

    /* renamed from: j  reason: collision with root package name */
    private a.EnumC0251a f23821j = null;

    /* compiled from: GameCenterNewLinupsSubPlayerItem.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23822a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23823b;

        static {
            int[] iArr = new int[eAthleteInjuryCategory.values().length];
            f23823b = iArr;
            try {
                iArr[eAthleteInjuryCategory.MEDICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23823b[eAthleteInjuryCategory.UNKONWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23823b[eAthleteInjuryCategory.NATIONAL_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23823b[eAthleteInjuryCategory.PERSONAL_REASONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[SuspensionObj.ESoccerSuspensionTypes.values().length];
            f23822a = iArr2;
            try {
                iArr2[SuspensionObj.ESoccerSuspensionTypes.RedCard.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23822a[SuspensionObj.ESoccerSuspensionTypes.YellowCards.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23822a[SuspensionObj.ESoccerSuspensionTypes.Disciplinary.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: GameCenterNewLinupsSubPlayerItem.java */
    /* loaded from: classes2.dex */
    public static class b extends t {

        /* renamed from: f  reason: collision with root package name */
        private CircleImageView f23824f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f23825g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f23826h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f23827i;

        /* renamed from: j  reason: collision with root package name */
        private TextView f23828j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f23829k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f23830l;

        /* renamed from: m  reason: collision with root package name */
        private ImageView f23831m;

        /* renamed from: n  reason: collision with root package name */
        private RelativeLayout f23832n;

        /* renamed from: o  reason: collision with root package name */
        private TextView f23833o;

        /* renamed from: p  reason: collision with root package name */
        private ImageView f23834p;

        public b(View view, q.e eVar) {
            super(view);
            this.f23824f = (CircleImageView) view.findViewById(R.id.f22190nk);
            this.f23826h = (TextView) view.findViewById(R.id.f22234pk);
            this.f23825g = (TextView) view.findViewById(R.id.f22212ok);
            this.f23827i = (TextView) view.findViewById(R.id.f22057hk);
            this.f23828j = (TextView) view.findViewById(R.id.f22102jk);
            this.f23829k = (TextView) view.findViewById(R.id.f22124kk);
            this.f23830l = (TextView) view.findViewById(R.id.f22256qk);
            this.f23831m = (ImageView) view.findViewById(R.id.f22012fk);
            this.f23832n = (RelativeLayout) view.findViewById(R.id.Pn);
            this.f23833o = (TextView) view.findViewById(R.id.kC);
            this.f23834p = (ImageView) view.findViewById(R.id.f22035gk);
            this.f23826h.setTypeface(o0.d(App.m()));
            this.f23825g.setTypeface(o0.d(App.m()));
            this.f23827i.setTypeface(o0.d(App.m()));
            this.f23828j.setTypeface(o0.d(App.m()));
            this.f23829k.setTypeface(o0.d(App.m()));
            this.f23830l.setTypeface(o0.d(App.m()));
            this.f23833o.setTypeface(o0.d(App.m()));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }
    }

    public e(PlayerObj playerObj, int i10, int i11, c.EnumC0252c enumC0252c, String str, int i12, boolean z10, boolean z11, boolean z12) {
        this.f23813b = playerObj;
        this.f23814c = i10;
        this.f23815d = i11;
        this.f23812a = z12;
        this.f23817f = enumC0252c;
        this.f23818g = str;
        this.f23816e = i12;
        this.f23819h = z10;
        this.f23820i = z11;
    }

    public static b l(ViewGroup viewGroup, q.e eVar) {
        return new b(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22695s6, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22683r6, viewGroup, false), eVar);
    }

    @Override // ag.j0
    public a.EnumC0251a c() {
        return this.f23821j;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LINEUPS_BENCH_NEW.ordinal();
    }

    @Override // ag.j0
    public PlayerObj i() {
        return this.f23813b;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        int i11;
        try {
            b bVar = (b) e0Var;
            if (this.f23813b.getJerseyNum() > 0) {
                bVar.f23825g.setVisibility(0);
                bVar.f23825g.setText(String.valueOf(this.f23813b.getJerseyNum()));
            } else {
                bVar.f23825g.setVisibility(4);
            }
            bVar.f23827i.setText(this.f23813b.getPlayerName());
            bVar.f23828j.setVisibility(0);
            bVar.f23826h.setVisibility(0);
            if (this.f23818g.isEmpty()) {
                bVar.f23828j.setVisibility(8);
                bVar.f23826h.setVisibility(8);
            } else {
                bVar.f23828j.setText(this.f23818g);
                if (this.f23816e != -1) {
                    bVar.f23826h.setVisibility(0);
                    bVar.f23826h.setText(String.valueOf(this.f23816e));
                } else {
                    bVar.f23826h.setVisibility(4);
                }
            }
            bVar.f23830l.setVisibility(8);
            if (this.f23813b.getSubtituteTime() > 0) {
                TextView textView = bVar.f23830l;
                textView.setText(String.valueOf(this.f23813b.getSubtituteTime()) + "'");
                bVar.f23830l.setTypeface(o0.d(App.m()));
                bVar.f23830l.setVisibility(0);
            }
            if (this.f23820i) {
                bVar.f23829k.setVisibility(0);
                bVar.f23829k.setTypeface(o0.d(App.m()));
                if (this.f23812a) {
                    bVar.f23829k.setBackgroundResource(PlayerObj.getTopRankingBG());
                } else {
                    bVar.f23829k.setBackgroundResource(this.f23813b.getRankingBG());
                }
                if (this.f23813b.getRankingToDisplay() > -1.0d) {
                    bVar.f23829k.setText(String.valueOf(this.f23813b.getRankingToDisplay()));
                } else {
                    bVar.f23829k.setText("-");
                }
            } else {
                bVar.f23829k.setVisibility(8);
            }
            bVar.f23831m.setVisibility(8);
            c.EnumC0252c enumC0252c = this.f23817f;
            if (enumC0252c != c.EnumC0252c.NONE) {
                if (enumC0252c == c.EnumC0252c.RED) {
                    bVar.f23831m.setImageResource(R.drawable.f21780o5);
                } else if (enumC0252c == c.EnumC0252c.SECOND_YELLOW) {
                    bVar.f23831m.setImageResource(R.drawable.T6);
                } else if (enumC0252c == c.EnumC0252c.YELLOW) {
                    bVar.f23831m.setImageResource(R.drawable.U6);
                }
                bVar.f23831m.setVisibility(0);
            }
            PlayerObj.ePlayerStatus status = this.f23813b.getStatus();
            PlayerObj.ePlayerStatus eplayerstatus = PlayerObj.ePlayerStatus.SUSPENDED;
            if (status == eplayerstatus || this.f23813b.getStatus() == PlayerObj.ePlayerStatus.INJURED) {
                try {
                    if (this.f23813b.getStatus() == eplayerstatus) {
                        int i12 = a.f23822a[this.f23813b.getSuspensionType().ordinal()];
                        i11 = i12 != 1 ? i12 != 2 ? p0.T(R.attr.I) : R.drawable.f21842w3 : R.drawable.f21780o5;
                    } else {
                        if (this.f23813b.getStatus() == PlayerObj.ePlayerStatus.INJURED) {
                            int i13 = a.f23823b[this.f23813b.getAthleteInjuryCategory().ordinal()];
                            if (i13 == 1 || i13 == 2) {
                                i11 = p0.T(R.attr.G);
                            } else if (i13 == 3) {
                                i11 = p0.T(R.attr.F);
                            } else if (i13 == 4) {
                                i11 = p0.T(R.attr.H);
                            }
                        }
                        i11 = -1;
                    }
                    if (i11 != -1) {
                        bVar.f23831m.setVisibility(0);
                        bVar.f23831m.setImageResource(i11);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            bVar.f23832n.setVisibility(8);
            if (this.f23814c > 0) {
                bVar.f23832n.setVisibility(0);
                bVar.f23833o.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f23834p.getLayoutParams();
                if (this.f23814c > 1) {
                    bVar.f23833o.setText(String.valueOf(this.f23814c));
                    bVar.f23833o.setVisibility(0);
                    layoutParams.topMargin = p0.s(-10);
                    layoutParams.leftMargin = p0.s(12);
                } else {
                    layoutParams.topMargin = p0.s(0);
                    layoutParams.leftMargin = p0.s(0);
                }
                bVar.f23834p.setLayoutParams(layoutParams);
            }
            li.u.j(this.f23813b.athleteId, false, bVar.f23824f, c.a.b(App.m(), R.drawable.f21845w6), this.f23819h, this.f23813b.getImgVer());
            ((t) bVar).itemView.setClickable(this.f23813b.getStatus() != PlayerObj.ePlayerStatus.MANAGEMENT);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.f23813b.getPlayerName());
            sb2.append(" ");
            sb2.append(this.f23813b.athleteId);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }
}
