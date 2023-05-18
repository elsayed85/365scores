package com.scores365.gameCenter.gameCenterItems;

import ag.o;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.transition.k;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.PlayerObj;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.pitchPlayerView.PitchPlayerView;
import java.util.HashMap;
import java.util.Locale;
import li.o0;
import li.p0;
import li.u;
import li.x0;
import nb.p;
import se.q0;
/* loaded from: classes2.dex */
public class VisualLineup extends ConstraintLayout {

    /* renamed from: t  reason: collision with root package name */
    private static int f23753t = 11;

    /* renamed from: u  reason: collision with root package name */
    static q0 f23754u;

    /* renamed from: d  reason: collision with root package name */
    private ConstraintLayout f23755d;

    /* renamed from: e  reason: collision with root package name */
    public androidx.constraintlayout.widget.c f23756e;

    /* renamed from: f  reason: collision with root package name */
    public androidx.constraintlayout.widget.c f23757f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f23758g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23759h;

    /* renamed from: i  reason: collision with root package name */
    public PitchPlayerView[] f23760i;

    /* renamed from: j  reason: collision with root package name */
    public Pair<Float, Float>[] f23761j;

    /* renamed from: k  reason: collision with root package name */
    o f23762k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23763l;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: m  reason: collision with root package name */
    HashMap<Integer, Integer> f23764m;
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: n  reason: collision with root package name */
    HashMap<Integer, Integer> f23765n;

    /* renamed from: o  reason: collision with root package name */
    private String f23766o;

    /* renamed from: p  reason: collision with root package name */
    private String f23767p;

    /* renamed from: q  reason: collision with root package name */
    int f23768q;

    /* renamed from: r  reason: collision with root package name */
    private FragmentManager f23769r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f23770s;

    public VisualLineup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23756e = new androidx.constraintlayout.widget.c();
        this.f23757f = new androidx.constraintlayout.widget.c();
        int i10 = f23753t;
        this.f23760i = new PitchPlayerView[i10];
        this.f23761j = new Pair[i10];
        this.f23763l = true;
        this.f23764m = new HashMap<>();
        this.f23765n = new HashMap<>();
        this.f23766o = "";
        this.f23767p = "";
        this.f23768q = -1;
        p();
    }

    public VisualLineup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23756e = new androidx.constraintlayout.widget.c();
        this.f23757f = new androidx.constraintlayout.widget.c();
        int i11 = f23753t;
        this.f23760i = new PitchPlayerView[i11];
        this.f23761j = new Pair[i11];
        this.f23763l = true;
        this.f23764m = new HashMap<>();
        this.f23765n = new HashMap<>();
        this.f23766o = "";
        this.f23767p = "";
        this.f23768q = -1;
        p();
    }

    private void D(PitchPlayerView pitchPlayerView, PlayerObj playerObj, double d10) {
        try {
            if (this.f23759h) {
                pitchPlayerView.f24199f.setVisibility(0);
            }
            if (d10 == -2.147483648E9d || d10 != playerObj.getRankingToDisplay()) {
                pitchPlayerView.g(playerObj, pitchPlayerView);
            } else {
                pitchPlayerView.h(playerObj, pitchPlayerView);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pitchPlayerView.f24199f.getLayoutParams();
            if (!this.f23770s) {
                marginLayoutParams.bottomMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
                marginLayoutParams.leftMargin = (int) (p0.s(4) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
                return;
            }
            ((ViewGroup.MarginLayoutParams) pitchPlayerView.f24201h.getLayoutParams()).topMargin = p0.s(3);
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.p(pitchPlayerView.f24194a);
            cVar.s(pitchPlayerView.f24199f.getId(), 2, 0, 2);
            cVar.i(pitchPlayerView.f24194a);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void E(PitchPlayerView pitchPlayerView, PlayerObj playerObj, boolean z10) {
        try {
            o oVar = this.f23762k;
            if (oVar != null && oVar.g().get(Integer.valueOf(playerObj.pId)) != null) {
                pitchPlayerView.f24196c.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pitchPlayerView.f24196c.getLayoutParams();
                marginLayoutParams.rightMargin = (int) (p0.s(8) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
                marginLayoutParams.bottomMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
                if (z10) {
                    pitchPlayerView.f24206m.setVisibility(0);
                    pitchPlayerView.f24206m.setTypeface(o0.d(App.m()));
                    pitchPlayerView.f24206m.setText(App.m().getString(R.string.f22818g, this.f23762k.g().get(Integer.valueOf(playerObj.pId))));
                    pitchPlayerView.f24196c.setPadding(p0.s(4), p0.s(1), p0.s(3), p0.s(1));
                } else {
                    pitchPlayerView.f24206m.setVisibility(8);
                    pitchPlayerView.f24196c.setPadding(p0.s(2), p0.s(1), p0.s(2), p0.s(1));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void F(PitchPlayerView pitchPlayerView, PlayerObj playerObj) {
        try {
            pitchPlayerView.f24203j.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) pitchPlayerView.f24203j.getLayoutParams()).rightMargin = (int) (p0.s(4) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
            String l10 = nb.o.l(p.Competitors, playerObj.competitorId, 70, 70, false, true, Integer.valueOf(f23754u.g()), null, null, playerObj.getImgVer());
            ImageView imageView = pitchPlayerView.f24203j;
            u.A(l10, imageView, u.f(imageView.getLayoutParams().width));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static double g(PlayerObj[] playerObjArr) {
        double d10 = -2.147483648E9d;
        try {
            double d11 = -2.147483648E9d;
            for (PlayerObj playerObj : playerObjArr) {
                try {
                    if (playerObj.getRankingToDisplay() > 0.0d) {
                        if (d11 == -2.147483648E9d) {
                            d11 = playerObj.getRankingToDisplay();
                        }
                        if (d11 < playerObj.getRankingToDisplay()) {
                            d11 = playerObj.getRankingToDisplay();
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    d10 = d11;
                    x0.N1(e);
                    return d10;
                }
            }
            return d11;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static int h(PlayerObj[] playerObjArr) {
        int i10 = -1;
        try {
            double d10 = -2.147483648E9d;
            for (PlayerObj playerObj : playerObjArr) {
                if (playerObj.getRankingToDisplay() > 0.0d) {
                    if (d10 == -2.147483648E9d) {
                        d10 = playerObj.getRankingToDisplay();
                        i10 = playerObj.pId;
                    }
                    if (d10 < playerObj.getRankingToDisplay()) {
                        d10 = playerObj.getRankingToDisplay();
                        i10 = playerObj.pId;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i10;
    }

    private void p() {
        try {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.P1, this);
            TextView textView = (TextView) findViewById(R.id.wz);
            this.f23758g = textView;
            textView.setTextColor(p0.A(R.attr.f21565m1));
            this.f23758g.setTypeface(o0.d(App.m()));
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.f21940ch);
            this.f23755d = constraintLayout;
            this.f23756e.p(constraintLayout);
            this.f23757f.p(this.f23755d);
            for (int i10 = 0; i10 < f23753t; i10++) {
                this.f23760i[i10] = (PitchPlayerView) findViewById(getResources().getIdentifier(String.format(Locale.US, "imageView%d", Integer.valueOf(i10)), "id", getContext().getPackageName()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean q(CompObj compObj) {
        if (compObj != null) {
            try {
                return compObj.getType() == CompObj.eCompetitorType.NATIONAL;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    private boolean r(a.EnumC0251a enumC0251a, int i10) {
        if (enumC0251a == a.EnumC0251a.HOME) {
            if (this.f23764m.containsKey(Integer.valueOf(i10)) && this.f23764m.get(Integer.valueOf(i10)).intValue() > 4) {
                return true;
            }
        } else if (enumC0251a == a.EnumC0251a.AWAY && this.f23765n.containsKey(Integer.valueOf(i10)) && this.f23765n.get(Integer.valueOf(i10)).intValue() > 4) {
            return true;
        }
        return false;
    }

    private void s() {
        for (PlayerObj playerObj : f23754u.d().get(0).getPlayers()) {
            int positionLine = playerObj.getPositionLine();
            if (this.f23764m.containsKey(Integer.valueOf(positionLine))) {
                this.f23764m.put(Integer.valueOf(positionLine), Integer.valueOf(this.f23764m.get(Integer.valueOf(positionLine)).intValue() + 1));
            } else {
                this.f23764m.put(Integer.valueOf(positionLine), 1);
            }
        }
        d(f23754u.d().get(0).getPlayers(), this.f23756e);
        if (f23754u.d().size() > 1) {
            for (PlayerObj playerObj2 : f23754u.d().get(1).getPlayers()) {
                int positionLine2 = playerObj2.getPositionLine();
                if (this.f23765n.containsKey(Integer.valueOf(positionLine2))) {
                    this.f23765n.put(Integer.valueOf(positionLine2), Integer.valueOf(this.f23765n.get(Integer.valueOf(positionLine2)).intValue() + 1));
                } else {
                    this.f23765n.put(Integer.valueOf(positionLine2), 1);
                }
            }
            d(f23754u.d().get(1).getPlayers(), this.f23757f);
        }
    }

    private void setAnimationForData(PitchPlayerView pitchPlayerView) {
        try {
            pitchPlayerView.b();
            pitchPlayerView.a();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setPlayersVisibility(PlayerObj[] playerObjArr) {
        for (PitchPlayerView pitchPlayerView : this.f23760i) {
            pitchPlayerView.setVisibility(8);
        }
        for (int i10 = 0; i10 < Math.min(playerObjArr.length, f23753t); i10++) {
            PlayerObj playerObj = playerObjArr[i10];
            if (playerObj.fieldLine <= -1 || playerObj.fieldSide <= -1) {
                Log.d("VisualLineup", "item number" + i10 + " fields is less than zero in setPlayersVisibility");
            } else {
                this.f23760i[i10].setVisibility(0);
            }
        }
    }

    private void t(PitchPlayerView pitchPlayerView, PlayerObj playerObj) {
        try {
            ((ViewGroup.MarginLayoutParams) pitchPlayerView.f24202i.getLayoutParams()).rightMargin = (int) (p0.s(4) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
            pitchPlayerView.f24202i.setVisibility(4);
            o oVar = this.f23762k;
            if (oVar != null) {
                if (oVar.h().get(Integer.valueOf(playerObj.pId)) != null) {
                    pitchPlayerView.f24202i.setVisibility(0);
                    pitchPlayerView.f24202i.setImageResource(R.drawable.U6);
                }
                if (this.f23762k.e().get(Integer.valueOf(playerObj.pId)) != null) {
                    pitchPlayerView.f24202i.setVisibility(0);
                    pitchPlayerView.f24202i.setImageResource(R.drawable.T6);
                }
                if (this.f23762k.c().get(Integer.valueOf(playerObj.pId)) != null) {
                    pitchPlayerView.f24202i.setVisibility(0);
                    pitchPlayerView.f24202i.setImageResource(R.drawable.f21780o5);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void u(PitchPlayerView pitchPlayerView, PlayerObj playerObj) {
        try {
            o oVar = this.f23762k;
            Integer num = oVar != null ? oVar.a().get(Integer.valueOf(playerObj.pId)) : null;
            pitchPlayerView.f24198e.setVisibility(8);
            pitchPlayerView.f24198e.setBackgroundResource(0);
            pitchPlayerView.f24204k.setImageDrawable(null);
            if (num != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pitchPlayerView.f24198e.getLayoutParams();
                marginLayoutParams.rightMargin = (int) (p0.s(8) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
                marginLayoutParams.topMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
                pitchPlayerView.f24198e.setPadding(p0.s(1), p0.s(1), p0.s(4), p0.s(1));
                pitchPlayerView.f24198e.setVisibility(0);
                pitchPlayerView.f24198e.setBackgroundResource(R.drawable.f21731i4);
                if (num.intValue() <= 1) {
                    pitchPlayerView.f24198e.setPadding(p0.s(1), p0.s(2), p0.s(1), p0.s(2));
                    pitchPlayerView.f24200g.setVisibility(8);
                    return;
                }
                marginLayoutParams.rightMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
                pitchPlayerView.f24200g.setVisibility(0);
                if (num.intValue() < 3) {
                    pitchPlayerView.f24200g.setText(String.valueOf(num));
                    pitchPlayerView.f24198e.getLayoutParams().height = p0.s(12);
                    ((ViewGroup.MarginLayoutParams) pitchPlayerView.f24204k.getLayoutParams()).rightMargin = p0.s(0);
                    return;
                }
                pitchPlayerView.f24198e.setBackgroundResource(R.drawable.E0);
                pitchPlayerView.f24198e.getLayoutParams().height = p0.s(14);
                ((ViewGroup.MarginLayoutParams) pitchPlayerView.f24204k.getLayoutParams()).rightMargin = p0.s(2);
                pitchPlayerView.f24200g.setText(String.valueOf(num.intValue()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void w(PitchPlayerView pitchPlayerView, boolean z10) {
        try {
            pitchPlayerView.setNational(z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void x(PitchPlayerView pitchPlayerView, PlayerObj playerObj) {
        try {
            o oVar = this.f23762k;
            Integer num = oVar != null ? oVar.b().get(Integer.valueOf(playerObj.pId)) : null;
            pitchPlayerView.f24198e.setVisibility(8);
            pitchPlayerView.f24198e.setBackgroundResource(0);
            if (num != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pitchPlayerView.f24198e.getLayoutParams();
                marginLayoutParams.rightMargin = (int) (p0.s(8) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
                marginLayoutParams.topMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
                pitchPlayerView.f24198e.setPadding(p0.s(4), p0.s(1), p0.s(1), p0.s(1));
                pitchPlayerView.f24198e.setVisibility(0);
                pitchPlayerView.f24198e.setBackgroundResource(R.drawable.f21731i4);
                if (num.intValue() == 1) {
                    pitchPlayerView.f24204k.setImageResource(R.drawable.V4);
                }
                if (num.intValue() <= 1) {
                    pitchPlayerView.f24198e.setPadding(p0.s(1), p0.s(1), p0.s(1), p0.s(1));
                    pitchPlayerView.f24200g.setVisibility(8);
                    return;
                }
                marginLayoutParams.rightMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
                pitchPlayerView.f24204k.setImageResource(R.drawable.V4);
                pitchPlayerView.f24200g.setVisibility(0);
                pitchPlayerView.f24200g.setText(String.valueOf(num));
                pitchPlayerView.f24198e.getLayoutParams().height = p0.s(12);
                ((ViewGroup.MarginLayoutParams) pitchPlayerView.f24204k.getLayoutParams()).rightMargin = p0.s(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void y(PitchPlayerView pitchPlayerView, PlayerObj playerObj, a.EnumC0251a enumC0251a) {
        String shortNameFromFullName;
        try {
            pitchPlayerView.f24201h.setTypeface(o0.d(App.m()));
            pitchPlayerView.f24201h.setVisibility(0);
            pitchPlayerView.f24201h.setTextColor(-1);
            q0 q0Var = f23754u;
            if (q0Var == null || !q0Var.d().get(0).isHasRankings()) {
                pitchPlayerView.f24199f.setVisibility(8);
            } else {
                pitchPlayerView.f24199f.setVisibility(0);
            }
            if (playerObj.getShortName() == null || playerObj.getShortName().isEmpty()) {
                String shortNameFromFullName2 = playerObj.getShortNameFromFullName();
                if (shortNameFromFullName2.length() < 11 && !r(enumC0251a, playerObj.getPositionLine())) {
                    shortNameFromFullName = shortNameFromFullName2;
                }
                shortNameFromFullName = playerObj.getShortNameFromFullName();
            } else {
                shortNameFromFullName = playerObj.getShortName();
            }
            pitchPlayerView.f24201h.setText(shortNameFromFullName);
            if (playerObj.getJerseyNum() > 0) {
                if (playerObj.getJerseyNum() > 100) {
                    pitchPlayerView.f24205l.setTextSize(7.0f);
                }
                pitchPlayerView.f24205l.setText(String.valueOf(playerObj.getJerseyNum()));
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pitchPlayerView.f24205l.getLayoutParams();
            marginLayoutParams.leftMargin = (int) (p0.s(8) + (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor())));
            marginLayoutParams.topMargin = (int) (p0.s(25) * (1.0f - pitchPlayerView.getScaleFactor()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void z(PitchPlayerView pitchPlayerView, PlayerObj playerObj, boolean z10) {
        try {
            if (this.f23759h) {
                u.y(nb.o.d(playerObj.athleteId, true, z10, playerObj.getImgVer()), pitchPlayerView.f24195b, R.drawable.f21845w6);
            } else {
                u.h(playerObj.athleteId, false, pitchPlayerView.f24195b, R.drawable.f21845w6, z10, playerObj.getImgVer());
            }
            o oVar = this.f23762k;
            if (oVar == null || !oVar.a().containsKey(Integer.valueOf(playerObj.pId)) || this.f23762k.a().get(Integer.valueOf(playerObj.pId)).intValue() < 3) {
                pitchPlayerView.f24195b.setBorderWidth(p0.s(1));
                pitchPlayerView.f24195b.setBorderColor(p0.A(R.attr.f21565m1));
                return;
            }
            pitchPlayerView.f24195b.setBorderWidth(p0.s(3));
            pitchPlayerView.f24195b.setBorderColor(p0.A(R.attr.f21556j1));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void A(String str, a.EnumC0251a enumC0251a, boolean z10) {
        PlayerObj[] players;
        boolean z11;
        int i10;
        boolean z12;
        String str2;
        int i11;
        a.EnumC0251a enumC0251a2 = a.EnumC0251a.HOME;
        if (enumC0251a == enumC0251a2) {
            players = f23754u.d().get(0).getPlayers();
            z11 = false;
        } else {
            players = f23754u.d().get(1).getPlayers();
            z11 = true;
        }
        g1.a aVar = new g1.a();
        aVar.W(250L);
        k.a(this.f23755d, aVar);
        try {
            if (this.f23770s) {
                this.f23758g.setVisibility(8);
            } else {
                this.f23758g.setText(str);
                if ((enumC0251a == enumC0251a2) ^ x0.l1()) {
                    this.f23758g.setGravity(3);
                } else {
                    this.f23758g.setGravity(5);
                }
            }
            double g10 = g(players);
            HashMap hashMap = new HashMap();
            int i12 = 0;
            while (true) {
                i10 = -1;
                if (i12 >= Math.min(players.length, f23753t)) {
                    break;
                }
                PlayerObj playerObj = players[i12];
                int i13 = playerObj.fieldLine;
                if (i13 > -1 && playerObj.fieldSide > -1) {
                    if (!hashMap.containsKey(Integer.valueOf(i13))) {
                        hashMap.put(Integer.valueOf(players[i12].fieldLine), 0);
                    }
                    hashMap.put(Integer.valueOf(players[i12].fieldLine), Integer.valueOf(((Integer) hashMap.get(Integer.valueOf(players[i12].fieldLine))).intValue() + 1));
                }
                i12++;
            }
            int i14 = 0;
            while (i14 < Math.min(players.length, f23753t)) {
                PlayerObj playerObj2 = players[i14];
                int i15 = playerObj2.fieldLine;
                if (i15 <= i10 || playerObj2.fieldSide <= i10) {
                    Log.d("VisualLineup", "item number" + i14 + " fields is less than zero in setPlayers");
                } else {
                    double i16 = i(i15);
                    if (((Integer) hashMap.get(Integer.valueOf(players[i14].fieldLine))).intValue() > 4) {
                        i16 *= 0.9d;
                    }
                    this.f23760i[i14].setScaleFactor(i16);
                    int b10 = f23754u.b();
                    boolean z13 = !z11;
                    boolean z14 = players[i14].getStatus() == PlayerObj.ePlayerStatus.MANAGEMENT;
                    CompObj compObj = f23754u.f().get(Integer.valueOf(players[i14].competitorId));
                    int id2 = compObj != null ? compObj.getID() : -1;
                    String shortName = compObj != null ? compObj.getShortName() : "";
                    boolean q10 = q(compObj);
                    if (this.f23770s) {
                        PlayerObj playerObj3 = players[i14];
                        z12 = playerObj3.gameId > 0 && playerObj3.isHasStats();
                        i11 = players[i14].gameId;
                        str2 = "team-of-the-week";
                    } else {
                        boolean isHasPlayerStats = f23754u.d().get(enumC0251a.ordinal()).isHasPlayerStats();
                        int i17 = this.f23768q;
                        z12 = isHasPlayerStats;
                        str2 = this.f23766o;
                        i11 = i17;
                    }
                    this.f23760i[i14].f(App.m(), players[i14], id2, b10, f23754u.g(), shortName, i11, str2, this.f23767p, this.f23769r, z14, z13, f23754u.i(), z12, this.f23770s, f23754u.a(), f23754u.e(), this.f23763l);
                    this.f23760i[i14].d();
                    int dimension = (int) (App.m().getResources().getDimension(R.dimen.f21659x) * (p0.A0(App.p()) > 411 ? p0.A0(App.p()) / 411.0f : 1.0f));
                    this.f23760i[i14].f24195b.getLayoutParams().height = dimension;
                    this.f23760i[i14].f24195b.getLayoutParams().width = dimension;
                    y(this.f23760i[i14], players[i14], enumC0251a);
                    E(this.f23760i[i14], players[i14], !z10);
                    if (z10) {
                        D(this.f23760i[i14], players[i14], g10);
                    } else {
                        this.f23760i[i14].f24199f.setVisibility(8);
                    }
                    t(this.f23760i[i14], players[i14]);
                    w(this.f23760i[i14], q10);
                    if (!this.f23770s) {
                        o oVar = this.f23762k;
                        if (oVar == null || !oVar.a().containsKey(Integer.valueOf(players[i14].pId))) {
                            x(this.f23760i[i14], players[i14]);
                        } else {
                            u(this.f23760i[i14], players[i14]);
                        }
                    }
                    z(this.f23760i[i14], players[i14], q10);
                    this.f23760i[i14].setPitchPlayerViewSize(i16);
                    if (this.f23770s) {
                        F(this.f23760i[i14], players[i14]);
                        this.f23760i[i14].f24196c.setVisibility(8);
                        this.f23760i[i14].f24205l.setVisibility(8);
                        this.f23760i[i14].f24198e.setVisibility(8);
                        this.f23760i[i14].f24202i.setVisibility(8);
                    } else {
                        this.f23760i[i14].f24203j.setVisibility(8);
                    }
                }
                i14++;
                i10 = -1;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (enumC0251a == a.EnumC0251a.HOME) {
            this.f23756e.i(this.f23755d);
        } else {
            this.f23757f.i(this.f23755d);
        }
        setPlayersVisibility(players);
    }

    public void B(String str, a.EnumC0251a enumC0251a, boolean z10) {
        PlayerObj[] players;
        boolean z11;
        boolean z12;
        double d10;
        try {
            a.EnumC0251a enumC0251a2 = a.EnumC0251a.HOME;
            if (enumC0251a == enumC0251a2) {
                players = f23754u.d().get(0).getPlayers();
                z11 = false;
            } else {
                players = f23754u.d().get(1).getPlayers();
                z11 = true;
            }
            g1.a aVar = new g1.a();
            aVar.W(250L);
            k.a(this.f23755d, aVar);
            try {
                if (this.f23770s) {
                    this.f23758g.setVisibility(8);
                } else {
                    this.f23758g.setText(str);
                    if ((enumC0251a == enumC0251a2) ^ x0.l1()) {
                        this.f23758g.setGravity(3);
                    } else {
                        this.f23758g.setGravity(5);
                    }
                }
                double g10 = g(players);
                int i10 = 0;
                while (i10 < Math.min(players.length, f23753t)) {
                    PlayerObj playerObj = players[i10];
                    if (playerObj.fieldLine <= -1 || playerObj.fieldSide <= -1) {
                        z12 = z11;
                        d10 = g10;
                        Log.d("VisualLineup", "item number" + i10 + " fields is less than zero in setPlayersWithAnimations");
                    } else {
                        int b10 = f23754u.b();
                        boolean z13 = players[i10].getStatus() == PlayerObj.ePlayerStatus.MANAGEMENT;
                        boolean z14 = !z11;
                        CompObj compObj = f23754u.f().get(Integer.valueOf(players[i10].competitorId));
                        int id2 = compObj != null ? compObj.getID() : -1;
                        String shortName = compObj != null ? compObj.getShortName() : "";
                        boolean q10 = q(compObj);
                        z12 = z11;
                        double d11 = g10;
                        this.f23760i[i10].f(App.m(), players[i10], id2, b10, f23754u.g(), shortName, this.f23768q, this.f23766o, this.f23767p, this.f23769r, z13, z14, f23754u.i(), f23754u.d().get(enumC0251a.ordinal()).isHasPlayerStats(), this.f23770s, -1, null, this.f23763l);
                        this.f23760i[i10].d();
                        int dimension = (int) (App.m().getResources().getDimension(R.dimen.f21659x) * (p0.A0(App.p()) > 411 ? p0.A0(App.p()) / 411.0f : 1.0f));
                        this.f23760i[i10].f24195b.getLayoutParams().height = dimension;
                        this.f23760i[i10].f24195b.getLayoutParams().width = dimension;
                        y(this.f23760i[i10], players[i10], enumC0251a);
                        t(this.f23760i[i10], players[i10]);
                        w(this.f23760i[i10], q10);
                        o oVar = this.f23762k;
                        if (oVar == null || !oVar.a().containsKey(Integer.valueOf(players[i10].pId))) {
                            x(this.f23760i[i10], players[i10]);
                        } else {
                            u(this.f23760i[i10], players[i10]);
                        }
                        E(this.f23760i[i10], players[i10], !z10);
                        if (z10) {
                            d10 = d11;
                            D(this.f23760i[i10], players[i10], d10);
                        } else {
                            setAnimationForData(this.f23760i[i10]);
                            d10 = d11;
                        }
                        z(this.f23760i[i10], players[i10], q10);
                        this.f23760i[i10].setPitchPlayerViewSize(i(players[i10].fieldLine));
                    }
                    i10++;
                    g10 = d10;
                    z11 = z12;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            if (enumC0251a == a.EnumC0251a.HOME) {
                this.f23756e.i(this.f23755d);
            } else {
                this.f23757f.i(this.f23755d);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    public void C(String str, String str2, int i10, FragmentManager fragmentManager) {
        this.f23766o = str;
        this.f23767p = str2;
        this.f23768q = i10;
        this.f23769r = fragmentManager;
    }

    public void d(PlayerObj[] playerObjArr, androidx.constraintlayout.widget.c cVar) {
        for (int i10 = 0; i10 < Math.min(playerObjArr.length, f23753t); i10++) {
            PlayerObj playerObj = playerObjArr[i10];
            int i11 = playerObj.fieldLine;
            if (i11 <= -1 || playerObj.fieldSide <= -1) {
                Log.d("VisualLineup", "item number" + i10 + " fields is less than zero in getConstraintSetForTeam");
            } else {
                float f10 = f(i11);
                float f11 = ((playerObjArr[i10].fieldSide / 100.0f) * f10) + ((1.0f - f10) / 2.0f);
                if (f11 < 0.0f) {
                    f11 = 0.0f;
                }
                if (f11 > 1.0f) {
                    f11 = 1.0f;
                }
                if (App.f20803w) {
                    f11 = ((f11 - 0.5f) * 0.9f) + 0.5f;
                }
                cVar.X(this.f23760i[i10].getId(), f11);
                float f12 = 1.0f - ((App.f20803w ? playerObjArr[i10].fieldLine * 0.9f : playerObjArr[i10].fieldLine) / 100.0f);
                cVar.a0(this.f23760i[i10].getId(), f12);
                this.f23761j[i10] = new Pair<>(Float.valueOf(f11), Float.valueOf(f12));
            }
        }
    }

    public float f(int i10) {
        return 1.0f - ((0.32999998f * ((i10 / 100.0f) - 0.2f)) / 0.8f);
    }

    public double i(int i10) {
        return (55.0d - ((i10 / 100.0d) * 10)) / 55.0d;
    }

    public void setForShare(boolean z10) {
        this.f23759h = z10;
    }

    public void setFromDashBoardDetails(boolean z10) {
        this.f23770s = z10;
    }

    public void setGCScope(boolean z10) {
        this.f23763l = z10;
    }

    public void setGameCenterLineupsMetadata(o oVar) {
        this.f23762k = oVar;
    }

    public void setVisualLineupsData(q0 q0Var) {
        f23754u = q0Var;
        s();
    }
}
