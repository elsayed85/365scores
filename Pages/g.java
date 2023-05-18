package com.scores365.Pages;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.recyclerview.widget.RecyclerView;
import com.amazon.device.ads.DtbConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.Pages.g;
import com.scores365.R;
import com.scores365.entitys.GameObj;
import com.scores365.gameCenter.i0;
import com.scores365.ui.viewpagerindicator.CustomWebView;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import li.p0;
import li.x0;
/* compiled from: BuzzStoryItem.kt */
/* loaded from: classes2.dex */
public final class g extends com.scores365.Design.PageObjects.b {

    /* renamed from: d  reason: collision with root package name */
    public static final d f21242d = new d(null);

    /* renamed from: e  reason: collision with root package name */
    private static final String f21243e = g.class.getName();

    /* renamed from: a  reason: collision with root package name */
    private final GameObj f21244a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21245b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21246c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BuzzStoryItem.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final b f21247a;

        /* renamed from: b  reason: collision with root package name */
        private final GameObj f21248b;

        /* renamed from: c  reason: collision with root package name */
        private final long f21249c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f21250d;

        public a(b analyticsEvent, GameObj gameObj, long j10, boolean z10) {
            kotlin.jvm.internal.m.g(analyticsEvent, "analyticsEvent");
            kotlin.jvm.internal.m.g(gameObj, "gameObj");
            this.f21247a = analyticsEvent;
            this.f21248b = gameObj;
            this.f21249c = j10;
            this.f21250d = z10;
        }

        public /* synthetic */ a(b bVar, GameObj gameObj, long j10, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(bVar, gameObj, (i10 & 4) != 0 ? -1L : j10, (i10 & 8) != 0 ? false : z10);
        }

        public final b a() {
            return this.f21247a;
        }

        public final GameObj b() {
            return this.f21248b;
        }

        public final long c() {
            return this.f21249c;
        }

        public final boolean d() {
            return this.f21250d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f21247a == aVar.f21247a && kotlin.jvm.internal.m.b(this.f21248b, aVar.f21248b) && this.f21249c == aVar.f21249c && this.f21250d == aVar.f21250d;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.f21247a.hashCode() * 31) + this.f21248b.hashCode()) * 31) + o1.t.a(this.f21249c)) * 31;
            boolean z10 = this.f21250d;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return hashCode + i10;
        }

        public String toString() {
            return "BuzzAnalyticsData(analyticsEvent=" + this.f21247a + ", gameObj=" + this.f21248b + ", pageLoadTime=" + this.f21249c + ", isFromNotification=" + this.f21250d + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BuzzStoryItem.kt */
    /* loaded from: classes2.dex */
    public enum b {
        STORY_DISPLAY,
        STORY_AD_CLICK
    }

    /* compiled from: BuzzStoryItem.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.scores365.Design.Pages.t {

        /* renamed from: f  reason: collision with root package name */
        private final rf.w f21251f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f21252g;

        /* renamed from: h  reason: collision with root package name */
        private MotionEvent f21253h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f21254i;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: BuzzStoryItem.kt */
        /* loaded from: classes2.dex */
        public static final class a extends WebViewClient {

            /* renamed from: a  reason: collision with root package name */
            private GameObj f21255a;

            /* renamed from: b  reason: collision with root package name */
            private c f21256b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f21257c;

            /* renamed from: d  reason: collision with root package name */
            private long f21258d;

            /* renamed from: e  reason: collision with root package name */
            private long f21259e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f21260f;

            public final void a(boolean z10) {
                this.f21260f = z10;
            }

            public final void b(GameObj gameObj) {
                this.f21255a = gameObj;
            }

            public final void c(c cVar) {
                this.f21256b = cVar;
            }

            public final void d(long j10) {
                this.f21258d = j10;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                c cVar;
                if (!this.f21257c) {
                    this.f21257c = true;
                    long currentTimeMillis = System.currentTimeMillis() - this.f21258d;
                    this.f21259e = currentTimeMillis;
                    GameObj gameObj = this.f21255a;
                    if (gameObj != null && currentTimeMillis > 0 && (cVar = this.f21256b) != null) {
                        cVar.q(new a(b.STORY_DISPLAY, gameObj, currentTimeMillis, this.f21260f));
                    }
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest webResourceRequest) {
                boolean w10;
                boolean w11;
                c cVar;
                kotlin.jvm.internal.m.g(view, "view");
                if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                    return super.shouldOverrideUrlLoading(view, webResourceRequest);
                }
                GameObj gameObj = this.f21255a;
                if (gameObj != null && (cVar = this.f21256b) != null && cVar != null) {
                    cVar.q(new a(b.STORY_AD_CLICK, gameObj, 0L, false, 12, null));
                }
                String scheme = webResourceRequest.getUrl().getScheme();
                if (scheme != null) {
                    w10 = kotlin.text.u.w(scheme, DtbConstants.HTTP, false, 2, null);
                    if (!w10) {
                        w11 = kotlin.text.u.w(scheme, DtbConstants.HTTPS, false, 2, null);
                        if (!w11) {
                            try {
                                view.getContext().startActivity(new Intent("android.intent.action.VIEW", webResourceRequest.getUrl()));
                                return true;
                            } catch (Exception e10) {
                                x0.N1(e10);
                                String str = g.f21243e;
                                Log.i(str, "Exception:" + e10);
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: BuzzStoryItem.kt */
        /* loaded from: classes2.dex */
        public static final class b extends WebChromeClient {

            /* renamed from: a  reason: collision with root package name */
            private GameObj f21261a;

            /* renamed from: b  reason: collision with root package name */
            private c f21262b;

            public final void a(GameObj gameObj) {
                this.f21261a = gameObj;
            }

            public final void b(c cVar) {
                this.f21262b = cVar;
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            }
        }

        /* compiled from: BuzzStoryItem.kt */
        /* renamed from: com.scores365.Pages.g$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public /* synthetic */ class C0237c {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f21263a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.STORY_DISPLAY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.STORY_AD_CLICK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f21263a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(rf.w binding) {
            super(binding.getRoot());
            kotlin.jvm.internal.m.g(binding, "binding");
            this.f21251f = binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
            if (r0 != 6) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final boolean m(com.scores365.Pages.g.c r5, android.view.View r6, android.view.MotionEvent r7) {
            /*
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.m.g(r5, r0)
                boolean r0 = r5.f21254i
                r1 = 0
                r2 = 0
                if (r0 == 0) goto Le
                r5.f21253h = r1
                goto L37
            Le:
                int r0 = r7.getAction()
                r3 = 1
                if (r0 == 0) goto L30
                if (r0 == r3) goto L24
                r4 = 3
                if (r0 == r4) goto L21
                r1 = 5
                if (r0 == r1) goto L30
                r1 = 6
                if (r0 == r1) goto L24
                goto L37
            L21:
                r5.f21253h = r1
                goto L37
            L24:
                java.lang.String r0 = "v"
                kotlin.jvm.internal.m.f(r6, r0)
                android.view.MotionEvent r0 = r5.f21253h
                boolean r2 = r5.o(r6, r7, r0)
                goto L37
            L30:
                android.view.MotionEvent r6 = android.view.MotionEvent.obtain(r7)
                r5.f21253h = r6
                r2 = 1
            L37:
                r5.f21252g = r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.g.c.m(com.scores365.Pages.g$c, android.view.View, android.view.MotionEvent):boolean");
        }

        private final boolean o(View view, MotionEvent motionEvent, MotionEvent motionEvent2) {
            if (motionEvent2 != null) {
                this.f21254i = true;
                view.onTouchEvent(motionEvent2);
                view.onTouchEvent(motionEvent);
                this.f21254i = false;
                return true;
            }
            return false;
        }

        @SuppressLint({"SetJavaScriptEnabled"})
        private final void p(c cVar, String str, GameObj gameObj, boolean z10) {
            CustomWebView customWebView = this.f21251f.f38089b;
            customWebView.getLayoutParams().height = (int) (App.p() * 1.6d);
            WebSettings settings = customWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setDomStorageEnabled(true);
            customWebView.setScrollBarStyle(33554432);
            customWebView.setScrollbarFadingEnabled(false);
            b bVar = new b();
            bVar.a(gameObj);
            bVar.b(cVar);
            customWebView.setWebChromeClient(bVar);
            a aVar = new a();
            aVar.b(gameObj);
            aVar.c(cVar);
            aVar.d(System.currentTimeMillis());
            aVar.a(z10);
            customWebView.setWebViewClient(aVar);
            customWebView.setBackgroundColor(p0.A(R.attr.f21557k));
            customWebView.loadUrl(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q(a aVar) {
            String str;
            String str2;
            GameObj b10 = aVar.b();
            b a10 = aVar.a();
            HashMap hashMap = new HashMap();
            String valueOf = String.valueOf(b10.getID());
            boolean d10 = aVar.d();
            String T = i0.T(b10);
            hashMap.put("game_id", valueOf);
            hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, T);
            hashMap.put("location", "gamecenter");
            hashMap.put("is_notification", Boolean.valueOf(d10));
            int i10 = C0237c.f21263a[a10.ordinal()];
            if (i10 == 1) {
                if (aVar.c() > -1) {
                    hashMap.put("time_loaded", Float.valueOf(((float) aVar.c()) / 1000.0f));
                }
                str = ServerProtocol.DIALOG_PARAM_DISPLAY;
                str2 = "";
            } else if (i10 != 2) {
                str = "";
                str2 = str;
            } else {
                str = "ad";
                str2 = "click";
            }
            ee.k.k(null, "gamecenter", "stories", str, str2, hashMap);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final void l(GameObj gameObj, String url, boolean z10) {
            kotlin.jvm.internal.m.g(gameObj, "gameObj");
            kotlin.jvm.internal.m.g(url, "url");
            this.f21251f.f38089b.setOnTouchListener(new View.OnTouchListener() { // from class: com.scores365.Pages.h
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m10;
                    m10 = g.c.m(g.c.this, view, motionEvent);
                    return m10;
                }
            });
            p(this, url, gameObj, z10);
        }

        public final rf.w n() {
            return this.f21251f;
        }
    }

    /* compiled from: BuzzStoryItem.kt */
    /* loaded from: classes2.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.scores365.Design.Pages.t a(ViewGroup parent) {
            kotlin.jvm.internal.m.g(parent, "parent");
            rf.w c10 = rf.w.c(LayoutInflater.from(parent.getContext()), parent, false);
            kotlin.jvm.internal.m.f(c10, "inflate(inflater, parent, false)");
            return new c(c10);
        }
    }

    public g(GameObj gameObj, String url, boolean z10) {
        kotlin.jvm.internal.m.g(gameObj, "gameObj");
        kotlin.jvm.internal.m.g(url, "url");
        this.f21244a = gameObj;
        this.f21245b = url;
        this.f21246c = z10;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.BuzzStoryItem.ordinal();
    }

    public final void m(c holder) {
        kotlin.jvm.internal.m.g(holder, "holder");
        try {
            holder.n().f38089b.loadUrl("");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof c) {
            ((c) e0Var).l(this.f21244a, this.f21245b, this.f21246c);
        }
    }
}
