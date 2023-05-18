package com.scores365.Monetization.dhn.uiComponent;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.d;
import androidx.lifecycle.c0;
import androidx.lifecycle.e;
import androidx.lifecycle.t;
import cc.c1;
import com.scores365.App;
import com.scores365.Monetization.dhn.uiComponent.DHNInterstitialActivity;
import com.scores365.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import li.u;
import li.x0;
import pc.i;
import uc.f;
/* compiled from: DHNInterstitialActivity.kt */
/* loaded from: classes2.dex */
public final class DHNInterstitialActivity extends d {
    public static final a F = new a(null);

    /* compiled from: DHNInterstitialActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DHNInterstitialActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends n implements Function1<f, Unit> {
        b() {
            super(1);
        }

        public final void a(f fVar) {
            boolean z10 = true;
            if (fVar instanceof f.e ? true : fVar instanceof f.d ? true : fVar instanceof f.c) {
                return;
            }
            if (fVar instanceof f.C0586f) {
                DHNInterstitialActivity.this.G(((f.C0586f) fVar).a());
                return;
            }
            if (!(fVar instanceof f.b ? true : fVar instanceof f.a) && fVar != null) {
                z10 = false;
            }
            if (z10) {
                DHNInterstitialActivity.this.finish();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(f fVar) {
            a(fVar);
            return Unit.f33377a;
        }
    }

    /* compiled from: DHNInterstitialActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements c0, g {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f21105a;

        c(Function1 function) {
            m.g(function, "function");
            this.f21105a = function;
        }

        @Override // kotlin.jvm.internal.g
        public final hj.c<?> a() {
            return this.f21105a;
        }

        @Override // androidx.lifecycle.c0
        public final /* synthetic */ void d(Object obj) {
            this.f21105a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof g)) {
                return m.b(a(), ((g) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(final c1 c1Var) {
        if (c1Var instanceof rc.b) {
            getLifecycle().a(new e() { // from class: com.scores365.Monetization.dhn.uiComponent.DHNInterstitialActivity$showAd$1
                @Override // androidx.lifecycle.e
                public /* synthetic */ void onCreate(t tVar) {
                    androidx.lifecycle.d.a(this, tVar);
                }

                @Override // androidx.lifecycle.e
                public void onDestroy(t owner) {
                    m.g(owner, "owner");
                    c1.this.o();
                    this.getLifecycle().d(this);
                    androidx.lifecycle.d.b(this, owner);
                }

                @Override // androidx.lifecycle.e
                public /* synthetic */ void onPause(t tVar) {
                    androidx.lifecycle.d.c(this, tVar);
                }

                @Override // androidx.lifecycle.e
                public /* synthetic */ void onResume(t tVar) {
                    androidx.lifecycle.d.d(this, tVar);
                }

                @Override // androidx.lifecycle.e
                public /* synthetic */ void onStart(t tVar) {
                    androidx.lifecycle.d.e(this, tVar);
                }

                @Override // androidx.lifecycle.e
                public /* synthetic */ void onStop(t tVar) {
                    androidx.lifecycle.d.f(this, tVar);
                }
            });
        }
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Application application = getApplication();
        m.e(application, "null cannot be cast to non-null type com.scores365.App");
        oc.b k10 = ((App) application).k();
        if (k10 == null) {
            finish();
            return;
        }
        final pc.a l10 = k10.l(mc.a.INTERSTITIAL, intent.getIntExtra("ad_id", -1));
        if (l10 == null) {
            finish();
            return;
        }
        findViewById(R.id.Sa).setOnClickListener(new View.OnClickListener() { // from class: qc.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DHNInterstitialActivity.H(DHNInterstitialActivity.this, view);
            }
        });
        findViewById(R.id.W).setBackgroundColor(Color.parseColor(l10.g()));
        l10.w();
        i s10 = l10.s();
        if (s10 != null) {
            x0.S(s10.a());
        }
        ImageView imageView = (ImageView) findViewById(R.id.Ob);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: qc.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DHNInterstitialActivity.I(c1.this, l10, this, view);
            }
        });
        u.y(l10.p(), imageView, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(DHNInterstitialActivity this$0, View view) {
        m.g(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(c1 loader, pc.a aVar, DHNInterstitialActivity this$0, View view) {
        m.g(loader, "$loader");
        m.g(this$0, "this$0");
        if (loader instanceof rc.b) {
            ((rc.b) loader).onAdClicked();
        }
        qc.e.a(aVar);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(App.f20805y);
        setContentView(R.layout.f22714u1);
        Application application = getApplication();
        m.e(application, "null cannot be cast to non-null type com.scores365.App");
        uc.d n10 = ((App) application).n();
        m.f(n10, "application as App).interstitialController");
        n10.i().j(this, new c(new b()));
    }
}
