package com.scores365.oddsView;

import android.content.Context;
import android.content.Intent;
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
import com.scores365.bets.model.BookMakerObj;
import com.scores365.bets.model.EOddsFormats;
import com.scores365.entitys.GameObj;
import com.scores365.ui.OddsView;
import je.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import li.x0;
import sh.a;
/* compiled from: SingleOddAdDesignView.kt */
/* loaded from: classes2.dex */
public final class SingleOddAdDesignView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private ImageView f24114d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24115e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24116f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24117g;

    /* renamed from: h  reason: collision with root package name */
    private String f24118h;

    /* renamed from: i  reason: collision with root package name */
    private ConstraintLayout f24119i;

    /* renamed from: j  reason: collision with root package name */
    private String f24120j;

    /* renamed from: k  reason: collision with root package name */
    private GameObj f24121k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24122l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24123m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24124n;

    /* renamed from: o  reason: collision with root package name */
    private BetLine f24125o;

    /* renamed from: p  reason: collision with root package name */
    private BookMakerObj f24126p;

    /* compiled from: SingleOddAdDesignView.kt */
    /* loaded from: classes2.dex */
    public enum a {
        None,
        RegularWithBackground,
        Left,
        Right,
        Below
    }

    /* compiled from: SingleOddAdDesignView.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24127a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.RegularWithBackground.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.Left.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.Right.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.Below.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f24127a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SingleOddAdDesignView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleOddAdDesignView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        View.inflate(context, R.layout.H8, this);
        View findViewById = findViewById(R.id.Lp);
        m.f(findViewById, "findViewById(R.id.single_odd_arrow_iv)");
        this.f24114d = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.Mp);
        m.f(findViewById2, "findViewById(R.id.single_odd_option_num_tv)");
        this.f24115e = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.Op);
        m.f(findViewById3, "findViewById(R.id.single_odd_value_tv)");
        this.f24116f = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.Np);
        m.f(findViewById4, "findViewById(R.id.single_odd_spread_tv)");
        this.f24117g = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.W2);
        m.f(findViewById5, "findViewById(R.id.cl_background_container)");
        this.f24119i = (ConstraintLayout) findViewById5;
        this.f24116f.setTextColor(p0.A(R.attr.U0));
        this.f24115e.setTextColor(p0.A(R.attr.U0));
        this.f24117g.setTextColor(p0.A(R.attr.f21556j1));
        this.f24115e.setTypeface(o0.c(App.m()));
        this.f24116f.setTypeface(o0.c(App.m()));
        this.f24117g.setTypeface(o0.c(App.m()));
        this.f24115e.getTextDirection();
        setLayoutDirection(x0.l1() ? 1 : 0);
        setOnClickListener(this);
    }

    public /* synthetic */ SingleOddAdDesignView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void f(String str) {
        try {
            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            x0.E1("oddsClickFea", "directExternalUrl. url: " + str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void g(int i10) {
        try {
            this.f24114d.setVisibility(8);
            if (i10 > -1) {
                this.f24114d.setImageResource(i10);
                this.f24114d.setVisibility(0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void h(String str) {
        if (str != null) {
            try {
                this.f24116f.setText(str);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0017 A[Catch: Exception -> 0x000f, TryCatch #0 {Exception -> 0x000f, blocks: (B:4:0x0006, B:13:0x0017, B:28:0x0135, B:30:0x0139, B:31:0x013f, B:23:0x007c, B:24:0x009d, B:25:0x00c3, B:26:0x00e9, B:27:0x0130, B:32:0x0145), top: B:36:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0145 A[Catch: Exception -> 0x000f, TRY_LEAVE, TryCatch #0 {Exception -> 0x000f, blocks: (B:4:0x0006, B:13:0x0017, B:28:0x0135, B:30:0x0139, B:31:0x013f, B:23:0x007c, B:24:0x009d, B:25:0x00c3, B:26:0x00e9, B:27:0x0130, B:32:0x0145), top: B:36:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i(java.lang.String r7, com.scores365.oddsView.SingleOddAdDesignView.a r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.oddsView.SingleOddAdDesignView.i(java.lang.String, com.scores365.oddsView.SingleOddAdDesignView$a, int, int, int):void");
    }

    private final void p(String str) {
        try {
            if (str != null) {
                this.f24117g.setText(str);
                this.f24117g.setVisibility(0);
            } else {
                this.f24117g.setVisibility(8);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void d(int i10) {
        this.f24119i.getLayoutParams().width = i10;
    }

    public final BetLine getBetLine() {
        return this.f24125o;
    }

    public final BookMakerObj getBookMakerObj() {
        return this.f24126p;
    }

    public final GameObj getGameObj() {
        return this.f24121k;
    }

    public final String getSource() {
        return this.f24120j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        try {
            a.C0569a c0569a = sh.a.f39207a;
            String g10 = c0569a.g();
            String str2 = this.f24118h;
            if (str2 != null) {
                m.d(str2);
                str = c0569a.p(str2, g10);
                f(str);
                BookMakerObj bookMakerObj = this.f24126p;
                if (bookMakerObj != null) {
                    b.a aVar = je.b.f32619a;
                    m.d(bookMakerObj);
                    b.a.j(aVar, null, bookMakerObj.getID(), 1, null);
                }
            } else {
                str = null;
            }
            OddsView.sendClickAnalyticsEvent(this.f24120j, this.f24121k, null, AppEventsConstants.EVENT_PARAM_VALUE_YES, this.f24122l, true, false, false, this.f24123m, this.f24125o, null, false, this.f24126p, str, this.f24124n, -1, g10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void q() {
        this.f24115e.setVisibility(8);
    }

    public final void r(String str, GameObj gameObj, boolean z10, boolean z11, boolean z12, BetLine betLine, BookMakerObj bookMakerObj) {
        this.f24120j = str;
        this.f24121k = gameObj;
        this.f24122l = z10;
        this.f24123m = z11;
        this.f24124n = z12;
        this.f24125o = betLine;
        this.f24126p = bookMakerObj;
    }

    public final void s(String str, EOddsFormats oddsFormat, String str2, String str3, String str4, int i10, int i11, int i12, int i13, a textLocation) {
        m.g(oddsFormat, "oddsFormat");
        m.g(textLocation, "textLocation");
        try {
            h(str);
            this.f24118h = str4;
            i(str2, textLocation, i11, i12, i13);
            g(i10);
            p(str3);
            this.f24119i.setBackgroundColor(i11);
            this.f24116f.setTextColor(i12);
            invalidate();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void setBetLine(BetLine betLine) {
        this.f24125o = betLine;
    }

    public final void setBookMakerObj(BookMakerObj bookMakerObj) {
        this.f24126p = bookMakerObj;
    }

    public final void setGameObj(GameObj gameObj) {
        this.f24121k = gameObj;
    }

    public final void setPredictionsItem(boolean z10) {
        this.f24122l = z10;
    }

    public final void setSource(String str) {
        this.f24120j = str;
    }

    public final void setSourceLineups(boolean z10) {
        this.f24123m = z10;
    }

    public final void setWwwScope(boolean z10) {
        this.f24124n = z10;
    }
}
