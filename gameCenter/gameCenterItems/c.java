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
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.SuspensionObj;
import com.scores365.entitys.eAthleteInjuryCategory;
import com.scores365.gameCenter.gameCenterItems.a;
import de.hdodenhof.circleimageview.CircleImageView;
import li.k;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: GameCenterLinupsSubPlayerItem.java */
/* loaded from: classes2.dex */
public class c extends com.scores365.Design.PageObjects.b implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public PlayerObj f23787a;

    /* renamed from: b  reason: collision with root package name */
    public int f23788b;

    /* renamed from: c  reason: collision with root package name */
    public int f23789c;

    /* renamed from: d  reason: collision with root package name */
    public int f23790d;

    /* renamed from: e  reason: collision with root package name */
    public EnumC0252c f23791e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23792f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23793g;

    /* renamed from: h  reason: collision with root package name */
    private String f23794h;

    /* renamed from: i  reason: collision with root package name */
    private a.EnumC0251a f23795i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameCenterLinupsSubPlayerItem.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23796a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f23797b;

        static {
            int[] iArr = new int[SuspensionObj.ESoccerSuspensionTypes.values().length];
            f23797b = iArr;
            try {
                iArr[SuspensionObj.ESoccerSuspensionTypes.RedCard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23797b[SuspensionObj.ESoccerSuspensionTypes.YellowCards.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23797b[SuspensionObj.ESoccerSuspensionTypes.Disciplinary.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[eAthleteInjuryCategory.values().length];
            f23796a = iArr2;
            try {
                iArr2[eAthleteInjuryCategory.MEDICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23796a[eAthleteInjuryCategory.UNKONWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23796a[eAthleteInjuryCategory.NATIONAL_TEAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23796a[eAthleteInjuryCategory.PERSONAL_REASONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: GameCenterLinupsSubPlayerItem.java */
    /* loaded from: classes2.dex */
    public static class b extends t {

        /* renamed from: f  reason: collision with root package name */
        private CircleImageView f23798f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f23799g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f23800h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f23801i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f23802j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f23803k;

        /* renamed from: l  reason: collision with root package name */
        private ImageView f23804l;

        /* renamed from: m  reason: collision with root package name */
        private RelativeLayout f23805m;

        /* renamed from: n  reason: collision with root package name */
        private TextView f23806n;

        /* renamed from: o  reason: collision with root package name */
        private ImageView f23807o;

        public b(View view, q.e eVar) {
            super(view);
            this.f23798f = (CircleImageView) view.findViewById(R.id.Yj);
            this.f23799g = (TextView) view.findViewById(R.id.f21943ck);
            this.f23800h = (TextView) view.findViewById(R.id.f21966dk);
            this.f23801i = (TextView) view.findViewById(R.id.f21989ek);
            this.f23802j = (TextView) view.findViewById(R.id.zB);
            this.f23803k = (TextView) view.findViewById(R.id.Zj);
            this.f23804l = (ImageView) view.findViewById(R.id.f21897ak);
            this.f23805m = (RelativeLayout) view.findViewById(R.id.On);
            this.f23806n = (TextView) view.findViewById(R.id.fG);
            this.f23807o = (ImageView) view.findViewById(R.id.f21920bk);
            this.f23800h.setTypeface(o0.d(App.m()));
            this.f23799g.setTypeface(o0.d(App.m()));
            this.f23801i.setTypeface(o0.d(App.m()));
            this.f23802j.setTypeface(o0.d(App.m()));
            this.f23803k.setTypeface(o0.d(App.m()));
            this.f23806n.setTypeface(o0.d(App.m()));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }
    }

    /* compiled from: GameCenterLinupsSubPlayerItem.java */
    /* renamed from: com.scores365.gameCenter.gameCenterItems.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0252c {
        NONE,
        RED,
        YELLOW,
        SECOND_YELLOW
    }

    public c(PlayerObj playerObj, int i10, int i11, EnumC0252c enumC0252c, boolean z10, int i12) {
        this.f23793g = true;
        this.f23787a = playerObj;
        this.f23788b = i10;
        this.f23789c = i11;
        this.f23791e = enumC0252c;
        this.f23792f = z10;
        this.f23790d = i12;
    }

    public c(PlayerObj playerObj, int i10, int i11, EnumC0252c enumC0252c, boolean z10, String str) {
        this.f23790d = -1;
        this.f23793g = true;
        this.f23787a = playerObj;
        this.f23788b = i10;
        this.f23789c = i11;
        this.f23791e = enumC0252c;
        this.f23792f = z10;
        this.f23794h = str;
    }

    public static int l(int i10, int i11) {
        try {
            if (i10 == -1) {
                if (i11 != -1) {
                    int i12 = a.f23797b[SuspensionObj.ESoccerSuspensionTypes.getValue(i11).ordinal()];
                    return i12 != 1 ? i12 != 2 ? p0.T(R.attr.I) : R.drawable.f21842w3 : R.drawable.f21780o5;
                }
                return 0;
            }
            int i13 = a.f23796a[eAthleteInjuryCategory.create(i10).ordinal()];
            if (i13 == 1 || i13 == 2) {
                return p0.T(R.attr.G);
            }
            if (i13 != 3) {
                if (i13 != 4) {
                    return 0;
                }
                return p0.T(R.attr.H);
            }
            return p0.T(R.attr.F);
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    public static b m(ViewGroup viewGroup, q.e eVar) {
        return new b(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22581j6, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22568i6, viewGroup, false), eVar);
    }

    @Override // ag.j0
    public a.EnumC0251a c() {
        return this.f23795i;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LINEUPS_BENCH.ordinal();
    }

    @Override // ag.j0
    public PlayerObj i() {
        return this.f23787a;
    }

    public void n(a.EnumC0251a enumC0251a) {
        this.f23795i = enumC0251a;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            b bVar = (b) e0Var;
            bVar.f23802j.setVisibility(8);
            boolean z10 = false;
            if (this.f23787a.getJerseyNum() > 0) {
                bVar.f23799g.setVisibility(0);
                bVar.f23799g.setText(String.valueOf(this.f23787a.getJerseyNum()));
            } else {
                bVar.f23799g.setVisibility(4);
            }
            bVar.f23800h.setText(this.f23787a.getPlayerName());
            StringBuilder sb2 = new StringBuilder();
            PlayerObj playerObj = this.f23787a;
            int i11 = this.f23790d;
            if (i11 == -1) {
                i11 = SportTypesEnum.SOCCER.getValue();
            }
            String formationPositionName = playerObj.getFormationPositionName(i11);
            String str = "";
            String str2 = this.f23787a.reason;
            if (str2 != null && !str2.isEmpty()) {
                str = this.f23787a.reason;
            }
            bVar.f23801i.setVisibility(0);
            if (!formationPositionName.isEmpty()) {
                sb2.append(formationPositionName);
            }
            if (!str.isEmpty()) {
                sb2.append(" - ");
                sb2.append(str);
            }
            if (sb2.toString().isEmpty()) {
                bVar.f23801i.setVisibility(8);
            } else {
                bVar.f23801i.setText(sb2.toString());
            }
            bVar.f23803k.setVisibility(8);
            if (this.f23787a.getSubtituteTime() > 0) {
                TextView textView = bVar.f23803k;
                textView.setText(String.valueOf(this.f23787a.getSubtituteTime()) + "'");
                bVar.f23803k.setTypeface(o0.d(App.m()));
                bVar.f23803k.setVisibility(0);
            }
            bVar.f23804l.setVisibility(8);
            EnumC0252c enumC0252c = this.f23791e;
            if (enumC0252c != EnumC0252c.NONE) {
                if (enumC0252c == EnumC0252c.RED) {
                    bVar.f23804l.setImageResource(R.drawable.f21780o5);
                } else if (enumC0252c == EnumC0252c.SECOND_YELLOW) {
                    bVar.f23804l.setImageResource(R.drawable.T6);
                } else if (enumC0252c == EnumC0252c.YELLOW) {
                    bVar.f23804l.setImageResource(R.drawable.U6);
                }
                bVar.f23804l.setVisibility(0);
            }
            if (this.f23793g) {
                PlayerObj.ePlayerStatus status = this.f23787a.getStatus();
                PlayerObj.ePlayerStatus eplayerstatus = PlayerObj.ePlayerStatus.SUSPENDED;
                if (status == eplayerstatus || this.f23787a.getStatus() == PlayerObj.ePlayerStatus.INJURED) {
                    try {
                        int l10 = (this.f23787a.getStatus() == eplayerstatus && this.f23794h == null) ? l(-1, this.f23787a.getSuspensionType().getId()) : (this.f23787a.getStatus() == PlayerObj.ePlayerStatus.INJURED && this.f23794h == null) ? l(this.f23787a.getAthleteInjuryCategory().getValue(), -1) : -1;
                        if (l10 != -1) {
                            bVar.f23804l.setVisibility(0);
                            bVar.f23804l.setImageResource(l10);
                        } else {
                            String str3 = this.f23794h;
                            if (str3 != null && !str3.isEmpty()) {
                                bVar.f23804l.setVisibility(0);
                                li.u.x(this.f23794h, bVar.f23804l);
                            }
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            }
            bVar.f23805m.setVisibility(8);
            if (this.f23788b > 0) {
                bVar.f23805m.setVisibility(0);
                bVar.f23806n.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f23807o.getLayoutParams();
                if (this.f23788b > 1) {
                    bVar.f23806n.setText(String.valueOf(this.f23788b));
                    bVar.f23806n.setVisibility(0);
                    layoutParams.topMargin = p0.s(-10);
                    layoutParams.leftMargin = p0.s(12);
                } else {
                    layoutParams.topMargin = p0.s(0);
                    layoutParams.leftMargin = p0.s(0);
                }
                bVar.f23807o.setLayoutParams(layoutParams);
            }
            li.u.j(this.f23787a.athleteId, false, bVar.f23798f, c.a.b(App.m(), R.drawable.f21845w6), this.f23792f, this.f23787a.getImgVer());
            PlayerObj.ePlayerStatus status2 = this.f23787a.getStatus();
            PlayerObj.ePlayerStatus eplayerstatus2 = PlayerObj.ePlayerStatus.MANAGEMENT;
            if (status2 != eplayerstatus2 || (this.f23787a.getStatus() == eplayerstatus2 && this.f23790d == 1)) {
                z10 = true;
            }
            ((t) bVar).itemView.setClickable(z10);
            if (sf.b.X1().L3()) {
                ((t) bVar).itemView.setOnLongClickListener(new k(this.f23787a.athleteId).b(bVar).b(bVar));
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.f23787a.getPlayerName());
            sb2.append(" ");
            sb2.append(this.f23787a.athleteId);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }
}
