package com.scores365.dashboardEntities.dashboardScores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.dashboardEntities.dashboardScores.g;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
import nb.v;
/* compiled from: ScoresGameItemWithTvChannels.kt */
/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f23453b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final b f23454a;

    /* compiled from: ScoresGameItemWithTvChannels.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: ScoresGameItemWithTvChannels.kt */
        /* renamed from: com.scores365.dashboardEntities.dashboardScores.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0247a extends g.a {

            /* renamed from: f  reason: collision with root package name */
            private final View f23455f;

            /* renamed from: g  reason: collision with root package name */
            private final q.e f23456g;

            /* renamed from: h  reason: collision with root package name */
            private TextView f23457h;

            /* renamed from: i  reason: collision with root package name */
            private ConstraintLayout f23458i;

            /* renamed from: j  reason: collision with root package name */
            private View f23459j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0247a(View convertView, q.e itemClickListener) {
                super(convertView, itemClickListener);
                kotlin.jvm.internal.m.g(convertView, "convertView");
                kotlin.jvm.internal.m.g(itemClickListener, "itemClickListener");
                this.f23455f = convertView;
                this.f23456g = itemClickListener;
                try {
                    TextView textView = (TextView) convertView.findViewById(R.id.FH);
                    this.f23457h = textView;
                    if (textView != null) {
                        textView.setTypeface(o0.d(App.m()));
                    }
                    ConstraintLayout constraintLayout = (ConstraintLayout) convertView.findViewById(R.id.f22199o7);
                    this.f23458i = constraintLayout;
                    if (constraintLayout != null) {
                        constraintLayout.setBackground(null);
                    }
                    this.f23459j = convertView.findViewById(R.id.Df);
                    ConstraintLayout constraintLayout2 = this.f23458i;
                    kotlin.jvm.internal.m.d(constraintLayout2);
                    e1.C0(constraintLayout2, 0.0f);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            private final void c(View view, int i10, int i11, int i12, int i13) {
                if (i13 > 1) {
                    view.getLayoutParams().height += p0.s(i10);
                } else {
                    view.getLayoutParams().height += p0.s(i11);
                }
                TextView textView = this.f23457h;
                ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
                kotlin.jvm.internal.m.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = v.x(i12);
            }

            @Override // com.scores365.dashboardEntities.dashboardScores.f.a
            public View getLeftStripe() {
                return this.f23459j;
            }

            @Override // com.scores365.dashboardEntities.dashboardScores.g.a
            public boolean shouldAnimateOdds() {
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:3:0x0003, B:7:0x001a, B:10:0x0022, B:12:0x0026, B:18:0x0032, B:20:0x0060, B:23:0x0065, B:30:0x007a, B:19:0x0049, B:6:0x000f), top: B:35:0x0003 }] */
            @Override // com.scores365.dashboardEntities.dashboardScores.g.a, com.scores365.dashboardEntities.dashboardScores.f.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void updateViewHolder(com.scores365.dashboardEntities.dashboardScores.f r8, boolean r9, boolean r10, boolean r11) {
                /*
                    r7 = this;
                    super.updateViewHolder(r8, r9, r10, r11)
                    java.lang.String r9 = "null cannot be cast to non-null type com.scores365.dashboardEntities.dashboardScores.ScoresGameItemWithTvChannels"
                    kotlin.jvm.internal.m.e(r8, r9)     // Catch: java.lang.Exception -> L7e
                    com.scores365.dashboardEntities.dashboardScores.h r8 = (com.scores365.dashboardEntities.dashboardScores.h) r8     // Catch: java.lang.Exception -> L7e
                    android.widget.TextView r9 = r7.f23457h     // Catch: java.lang.Exception -> L7e
                    if (r9 != 0) goto Lf
                    goto L1a
                Lf:
                    com.scores365.dashboardEntities.dashboardScores.b r10 = r8.l()     // Catch: java.lang.Exception -> L7e
                    java.lang.String r10 = r10.b()     // Catch: java.lang.Exception -> L7e
                    r9.setText(r10)     // Catch: java.lang.Exception -> L7e
                L1a:
                    boolean r9 = r7.isOddsViewVisible     // Catch: java.lang.Exception -> L7e
                    r10 = 1
                    java.lang.String r11 = "itemView"
                    r0 = 0
                    if (r9 != 0) goto L49
                    android.widget.TextView r9 = r7.winDescription     // Catch: java.lang.Exception -> L7e
                    if (r9 == 0) goto L2e
                    int r9 = r9.getVisibility()     // Catch: java.lang.Exception -> L7e
                    if (r9 != 0) goto L2e
                    r9 = 1
                    goto L2f
                L2e:
                    r9 = 0
                L2f:
                    if (r9 == 0) goto L32
                    goto L49
                L32:
                    android.view.View r2 = r7.itemView     // Catch: java.lang.Exception -> L7e
                    kotlin.jvm.internal.m.f(r2, r11)     // Catch: java.lang.Exception -> L7e
                    r3 = 24
                    r4 = 16
                    r5 = 0
                    com.scores365.dashboardEntities.dashboardScores.b r9 = r8.l()     // Catch: java.lang.Exception -> L7e
                    int r6 = r9.a()     // Catch: java.lang.Exception -> L7e
                    r1 = r7
                    r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L7e
                    goto L60
                L49:
                    android.view.View r2 = r7.itemView     // Catch: java.lang.Exception -> L7e
                    kotlin.jvm.internal.m.f(r2, r11)     // Catch: java.lang.Exception -> L7e
                    r3 = 32
                    r4 = 24
                    r5 = 8
                    com.scores365.dashboardEntities.dashboardScores.b r9 = r8.l()     // Catch: java.lang.Exception -> L7e
                    int r6 = r9.a()     // Catch: java.lang.Exception -> L7e
                    r1 = r7
                    r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L7e
                L60:
                    android.widget.TextView r9 = r7.f23457h     // Catch: java.lang.Exception -> L7e
                    if (r9 != 0) goto L65
                    goto L82
                L65:
                    com.scores365.dashboardEntities.dashboardScores.b r8 = r8.l()     // Catch: java.lang.Exception -> L7e
                    java.lang.String r8 = r8.b()     // Catch: java.lang.Exception -> L7e
                    int r8 = r8.length()     // Catch: java.lang.Exception -> L7e
                    if (r8 <= 0) goto L74
                    goto L75
                L74:
                    r10 = 0
                L75:
                    if (r10 == 0) goto L78
                    goto L7a
                L78:
                    r0 = 8
                L7a:
                    r9.setVisibility(r0)     // Catch: java.lang.Exception -> L7e
                    goto L82
                L7e:
                    r8 = move-exception
                    li.x0.N1(r8)
                L82:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.scores365.dashboardEntities.dashboardScores.h.a.C0247a.updateViewHolder(com.scores365.dashboardEntities.dashboardScores.f, boolean, boolean, boolean):void");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a(ViewGroup parent, q.e itemClickListener) {
            kotlin.jvm.internal.m.g(parent, "parent");
            kotlin.jvm.internal.m.g(itemClickListener, "itemClickListener");
            try {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.R7, parent, false);
                kotlin.jvm.internal.m.f(inflate, "from(parent.context).inf…el_layout, parent, false)");
                return new C0247a(inflate, itemClickListener);
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, Locale locale, b channels) {
        super(gameObj, competitionObj, z10, z11, z12, z13, z14, locale, false, false, false);
        kotlin.jvm.internal.m.g(channels, "channels");
        this.f23454a = channels;
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.g, com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.GameWithTVChannel.ordinal();
    }

    public final b l() {
        return this.f23454a;
    }
}
