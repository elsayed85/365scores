package com.scores365.gameCenter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rf.h2;
/* compiled from: StageTitleItem.kt */
/* loaded from: classes2.dex */
public final class v0 extends com.scores365.Design.PageObjects.b {

    /* renamed from: h  reason: collision with root package name */
    public static final a f24072h = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final GameObj f24073a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24074b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24075c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24076d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f24077e;

    /* renamed from: f  reason: collision with root package name */
    private int f24078f;

    /* renamed from: g  reason: collision with root package name */
    private final hj.h f24079g;

    /* compiled from: StageTitleItem.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.scores365.Design.Pages.t a(ViewGroup parent, q.e eVar) {
            kotlin.jvm.internal.m.g(parent, "parent");
            h2 c10 = h2.c(LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.m.f(c10, "inflate(\n               …rent, false\n            )");
            return new b(c10, eVar);
        }
    }

    /* compiled from: StageTitleItem.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.scores365.Design.Pages.t {

        /* renamed from: f  reason: collision with root package name */
        private final h2 f24080f;

        /* renamed from: g  reason: collision with root package name */
        private int f24081g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h2 binding, q.e eVar) {
            super(binding.getRoot());
            kotlin.jvm.internal.m.g(binding, "binding");
            this.f24080f = binding;
            this.f24081g = -1;
        }

        public final void c(GameObj gameObj, String stageTitle, List<String> imageUrls, boolean z10, boolean z11, boolean z12) {
            kotlin.jvm.internal.m.g(gameObj, "gameObj");
            kotlin.jvm.internal.m.g(stageTitle, "stageTitle");
            kotlin.jvm.internal.m.g(imageUrls, "imageUrls");
            h2 h2Var = this.f24080f;
            if (this.f24081g > -1) {
                ConstraintLayout root = h2Var.getRoot();
                kotlin.jvm.internal.m.f(root, "root");
                nb.v.b(root, this.f24081g, 0, 0, 0, 14, null);
            }
            if (li.x0.l1()) {
                this.f24080f.getRoot().setLayoutDirection(1);
            }
            TextView textView = h2Var.f37739d;
            textView.setText(stageTitle);
            textView.setTypeface(li.o0.d(App.m()));
            textView.setVisibility(z10 ? 0 : 4);
            List l10 = li.x0.k(gameObj.homeAwayTeamOrder) ? kotlin.collections.r.l(h2Var.f37737b, h2Var.f37738c) : kotlin.collections.r.l(h2Var.f37738c, h2Var.f37737b);
            int i10 = 0;
            for (Object obj : imageUrls) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.r.q();
                }
                li.u.x((String) obj, (ImageView) l10.get(i10));
                i10 = i11;
            }
            h2Var.f37737b.setVisibility(z11 ? 0 : 4);
            h2Var.f37738c.setVisibility(z12 ? 0 : 4);
        }

        public final void d(int i10) {
            this.f24081g = i10;
        }
    }

    /* compiled from: StageTitleItem.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.n implements Function0<ArrayList<String>> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f24082c = new c();

        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final ArrayList<String> invoke() {
            return new ArrayList<>();
        }
    }

    public v0(GameObj gameObj, String stageTitle, boolean z10, boolean z11, boolean z12) {
        hj.h b10;
        kotlin.jvm.internal.m.g(gameObj, "gameObj");
        kotlin.jvm.internal.m.g(stageTitle, "stageTitle");
        this.f24073a = gameObj;
        this.f24074b = stageTitle;
        this.f24075c = z10;
        this.f24076d = z11;
        this.f24077e = z12;
        this.f24078f = -1;
        b10 = hj.j.b(c.f24082c);
        this.f24079g = b10;
        for (int i10 = 0; i10 < 2; i10++) {
            String compImageUrl = nb.o.s(nb.p.Competitors, this.f24073a.getComps()[i10].getID(), 70, 70, false, this.f24073a.getComps()[i10].getImgVer());
            List<String> l10 = l();
            kotlin.jvm.internal.m.f(compImageUrl, "compImageUrl");
            l10.add(compImageUrl);
        }
    }

    public /* synthetic */ v0(GameObj gameObj, String str, boolean z10, boolean z11, boolean z12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(gameObj, str, (i10 & 4) != 0 ? true : z10, (i10 & 8) != 0 ? true : z11, (i10 & 16) != 0 ? true : z12);
    }

    private final List<String> l() {
        return (List) this.f24079g.getValue();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.StageTitleItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof b) {
            int i11 = this.f24078f;
            if (i11 > -1) {
                ((b) e0Var).d(i11);
            }
            ((b) e0Var).c(this.f24073a, this.f24074b, l(), this.f24075c, this.f24076d, this.f24077e);
        }
    }

    public final void setTopMargin(int i10) {
        this.f24078f = i10;
    }
}
