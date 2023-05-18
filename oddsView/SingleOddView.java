package com.scores365.oddsView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineOption;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.ui.OddsView;
import ee.k;
import hj.r;
import java.util.HashMap;
import je.b;
import kotlin.collections.j0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import li.x0;
import sh.a;
import xf.f0;
/* compiled from: SingleOddView.kt */
/* loaded from: classes2.dex */
public final class SingleOddView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: x  reason: collision with root package name */
    public static final a f24128x = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private ImageView f24129d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24130e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24131f;

    /* renamed from: g  reason: collision with root package name */
    private String f24132g;

    /* renamed from: h  reason: collision with root package name */
    private BetLineOption f24133h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24134i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24135j;

    /* renamed from: k  reason: collision with root package name */
    private int f24136k;

    /* renamed from: l  reason: collision with root package name */
    private String f24137l;

    /* renamed from: m  reason: collision with root package name */
    private GameObj f24138m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24139n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24140o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24141p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f24142q;

    /* renamed from: r  reason: collision with root package name */
    private BetLine f24143r;

    /* renamed from: s  reason: collision with root package name */
    private BookMakerObj f24144s;

    /* renamed from: t  reason: collision with root package name */
    private int f24145t;

    /* renamed from: u  reason: collision with root package name */
    private f0 f24146u;

    /* renamed from: v  reason: collision with root package name */
    private HashMap<String, Object> f24147v;

    /* renamed from: w  reason: collision with root package name */
    private int f24148w;

    /* compiled from: SingleOddView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String url) {
            m.g(context, "context");
            m.g(url, "url");
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                x0.E1("oddsClickFea", "SingleOddView.directExternalUrl. urlToOpenOnClick: " + url);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleOddView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleOddView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.f24136k = -1;
        View.inflate(context, R.layout.I8, this);
        View findViewById = findViewById(R.id.Lp);
        m.f(findViewById, "findViewById(R.id.single_odd_arrow_iv)");
        this.f24129d = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.Op);
        m.f(findViewById2, "findViewById(R.id.single_odd_value_tv)");
        this.f24130e = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.Np);
        m.f(findViewById3, "findViewById(R.id.single_odd_spread_tv)");
        this.f24131f = (TextView) findViewById3;
        this.f24130e.setTypeface(o0.d(App.m()));
        setLayoutDirection(x0.l1() ? 1 : 0);
        setOnClickListener(this);
        this.f24145t = -1;
        this.f24148w = -1;
    }

    public /* synthetic */ SingleOddView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void d(BetLineOption betLineOption) {
        int termArrowId;
        try {
            this.f24129d.setVisibility(8);
            if (!betLineOption.doesHaveOldRate() || (termArrowId = betLineOption.getTermArrowId()) == -1) {
                return;
            }
            this.f24129d.setImageResource(termArrowId);
            this.f24129d.setVisibility(0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void f(String str) {
        try {
            if (str != null) {
                this.f24130e.setText(str);
                this.f24130e.setVisibility(0);
            } else {
                this.f24130e.setVisibility(8);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void g(String str) {
        try {
            if (str != null) {
                this.f24131f.setText(str);
                this.f24131f.setVisibility(0);
            } else {
                this.f24131f.setVisibility(8);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void h(BetLineOption betLineOption) {
        Drawable K;
        try {
            if (!this.f24134i && !this.f24135j) {
                K = betLineOption.won ? p0.K(R.attr.f21577q1) : p0.K(R.attr.f21568n1);
                setBackground(K);
            }
            K = betLineOption.won ? p0.K(R.attr.f21574p1) : p0.K(R.attr.f21571o1);
            setBackground(K);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final HashMap<String, Object> getAnalyticData() {
        return this.f24147v;
    }

    public final BetLine getBetLine() {
        return this.f24143r;
    }

    public final int getBetLineTypeForBi() {
        return this.f24136k;
    }

    public final BookMakerObj getBookMakerObj() {
        return this.f24144s;
    }

    public final int getCompetitionIdForBi() {
        return this.f24148w;
    }

    public final GameObj getGameObj() {
        return this.f24138m;
    }

    public final boolean getHasInsights() {
        return this.f24141p;
    }

    public final String getSource() {
        return this.f24137l;
    }

    public final int getWwwEntityId() {
        return this.f24145t;
    }

    public final f0 getWwwInnerDataItem() {
        return this.f24146u;
    }

    public final void i(String str, GameObj gameObj, boolean z10, boolean z11, boolean z12, boolean z13, BetLine betLine, BookMakerObj bookMakerObj, int i10, f0 f0Var) {
        this.f24137l = str;
        this.f24138m = gameObj;
        this.f24139n = z10;
        this.f24140o = z11;
        this.f24141p = z12;
        this.f24142q = z13;
        this.f24143r = betLine;
        this.f24144s = bookMakerObj;
        this.f24145t = i10;
        this.f24146u = f0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        HashMap<String, Object> j10;
        try {
            f0 f0Var = this.f24146u;
            if (f0Var != null && f0Var != null) {
                j10 = j0.j(r.a("athlete_id", String.valueOf(f0Var.a())), r.a("competition_id", String.valueOf(f0Var.b())), r.a("is_favorite_athlete", Boolean.valueOf(f0Var.d())));
                this.f24147v = j10;
            }
            a.C0569a c0569a = sh.a.f39207a;
            String g10 = c0569a.g();
            String str2 = this.f24132g;
            if (str2 != null) {
                m.d(str2);
                str = c0569a.p(str2, g10);
                a aVar = f24128x;
                Context context = getContext();
                m.f(context, "context");
                aVar.a(context, str);
                BookMakerObj bookMakerObj = this.f24144s;
                if (bookMakerObj != null) {
                    b.a aVar2 = b.f32619a;
                    m.d(bookMakerObj);
                    b.a.j(aVar2, null, bookMakerObj.getID(), 1, null);
                }
            } else {
                str = null;
            }
            if (!this.f24134i && !this.f24135j) {
                String str3 = this.f24137l;
                GameObj gameObj = this.f24138m;
                BetLineOption betLineOption = this.f24133h;
                OddsView.sendClickAnalyticsEvent(str3, gameObj, String.valueOf(betLineOption != null ? betLineOption.getOddsByUserChoice(false) : null), AppEventsConstants.EVENT_PARAM_VALUE_YES, this.f24139n, true, this.f24141p, false, this.f24140o, this.f24143r, this.f24147v, false, this.f24144s, str, this.f24142q, this.f24145t, g10);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("market_type", Integer.valueOf(this.f24136k));
            BookMakerObj bookMakerObj2 = this.f24144s;
            hashMap.put("bookie_id", String.valueOf(bookMakerObj2 != null ? Integer.valueOf(bookMakerObj2.getID()) : null));
            hashMap.put("click_type", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            hashMap.put("guid", g10);
            hashMap.put("competition_id", Integer.valueOf(this.f24148w));
            if (str != null) {
                hashMap.put("url", str);
            }
            k.m(App.m(), "dashboard", this.f24135j ? "outright-card" : "outright", "bookie", "click", true, hashMap);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void p(String str, String str2, String str3, String str4, BetLineOption betLineOption) {
        m.g(betLineOption, "betLineOption");
        try {
            f(str);
            this.f24132g = str4;
            this.f24130e.setVisibility(0);
            this.f24133h = betLineOption;
            d(betLineOption);
            h(betLineOption);
            g(str3);
            invalidate();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void setAnalyticData(HashMap<String, Object> hashMap) {
        this.f24147v = hashMap;
    }

    public final void setBetLine(BetLine betLine) {
        this.f24143r = betLine;
    }

    public final void setBetLineTypeForBi(int i10) {
        this.f24136k = i10;
    }

    public final void setBookMakerObj(BookMakerObj bookMakerObj) {
        this.f24144s = bookMakerObj;
    }

    public final void setCompetitionIdForBi(int i10) {
        this.f24148w = i10;
    }

    public final void setGameObj(GameObj gameObj) {
        this.f24138m = gameObj;
    }

    public final void setHasInsights(boolean z10) {
        this.f24141p = z10;
    }

    public final void setOutrightCardContext(boolean z10) {
        this.f24135j = z10;
    }

    public final void setOutrightContext(boolean z10) {
        this.f24134i = z10;
    }

    public final void setPredictionsItem(boolean z10) {
        this.f24139n = z10;
    }

    public final void setSource(String str) {
        this.f24137l = str;
    }

    public final void setSourceLineups(boolean z10) {
        this.f24140o = z10;
    }

    public final void setWwwEntityId(int i10) {
        this.f24145t = i10;
    }

    public final void setWwwInnerDataItem(f0 f0Var) {
        this.f24146u = f0Var;
    }

    public final void setWwwScope(boolean z10) {
        this.f24142q = z10;
    }
}
