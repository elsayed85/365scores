package com.scores365.gameCenter;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.WidgetObj;
import com.scores365.ui.CustomProgressBar;
/* compiled from: StatisticWidgetMgr.java */
/* loaded from: classes2.dex */
public class w0 {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f24083c;

    /* renamed from: a  reason: collision with root package name */
    private GameObj f24084a;

    /* renamed from: b  reason: collision with root package name */
    private WebView f24085b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StatisticWidgetMgr.java */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f24086a;

        /* compiled from: StatisticWidgetMgr.java */
        /* renamed from: com.scores365.gameCenter.w0$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0253a implements Runnable {
            RunnableC0253a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a aVar = a.this;
                    w0.this.b(aVar.f24086a);
                } catch (Exception e10) {
                    li.x0.N1(e10);
                }
            }
        }

        a(ViewGroup viewGroup) {
            this.f24086a = viewGroup;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            try {
                super.onPageFinished(webView, str);
                if (webView.getProgress() == 100) {
                    new Handler().postDelayed(new RunnableC0253a(), 800L);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    public w0(@NonNull Context context) {
        j(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            try {
                if (viewGroup.getChildAt(i10) instanceof WebView) {
                    viewGroup.getChildAt(i10).startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21506f));
                    viewGroup.getChildAt(i10).setVisibility(0);
                    viewGroup.getChildAt(i10).bringToFront();
                }
                if (viewGroup.getChildAt(i10) instanceof CustomProgressBar) {
                    viewGroup.getChildAt(i10).startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21508h));
                    viewGroup.getChildAt(i10).setVisibility(8);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
                return;
            }
        }
    }

    private void d(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            try {
                if (viewGroup.getChildAt(i10) instanceof WebView) {
                    viewGroup.getChildAt(i10).startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21508h));
                    viewGroup.getChildAt(i10).setVisibility(4);
                }
                if (viewGroup.getChildAt(i10) instanceof CustomProgressBar) {
                    viewGroup.getChildAt(i10).startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21506f));
                    viewGroup.getChildAt(i10).setVisibility(0);
                    viewGroup.getChildAt(i10).bringToFront();
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
                return;
            }
        }
    }

    private void e(ViewGroup viewGroup, String str) {
        try {
            g(viewGroup, true);
            this.f24085b.setWebViewClient(new a(viewGroup));
            this.f24085b.getSettings().setJavaScriptEnabled(true);
            this.f24085b.setWebChromeClient(new WebChromeClient());
            this.f24085b.getSettings().setCacheMode(-1);
            this.f24085b.loadUrl(str);
            f24083c = true;
            viewGroup.getLayoutParams().height = i();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void g(ViewGroup viewGroup, boolean z10) {
        try {
            if (this.f24085b == null) {
                j(viewGroup.getContext());
            }
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                try {
                    if (viewGroup.getChildAt(i10) instanceof WebView) {
                        viewGroup.removeViewAt(i10);
                    }
                } catch (Exception e10) {
                    li.x0.N1(e10);
                }
            }
            viewGroup.removeView(this.f24085b);
            if (this.f24085b.getParent() != null) {
                ((ViewGroup) this.f24085b.getParent()).removeView(this.f24085b);
            }
            viewGroup.addView(this.f24085b);
            if (z10) {
                d(viewGroup);
            } else {
                b(viewGroup);
            }
            this.f24085b.setWebViewClient(new WebViewClient());
            try {
                if (this.f24085b.getUrl() == null) {
                    this.f24085b.loadUrl(h(this.f24084a));
                }
            } catch (Exception e11) {
                li.x0.N1(e11);
            }
        } catch (Exception e12) {
            li.x0.N1(e12);
        }
    }

    private String h(GameObj gameObj) {
        try {
            WidgetObj momentumWidget = gameObj.getMomentumWidget();
            return momentumWidget != null ? Uri.parse(momentumWidget.getWidgetURL()).toString() : "";
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    private void j(@NonNull Context context) {
        try {
            WebView webView = new WebView(context);
            this.f24085b = webView;
            webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            try {
                this.f24085b.setWebChromeClient(new WebChromeClient());
                this.f24085b.getSettings().setJavaScriptEnabled(true);
                this.f24085b.getSettings().setDomStorageEnabled(true);
                this.f24085b.getSettings().setAllowFileAccess(true);
                this.f24085b.getSettings().setCacheMode(1);
                this.f24085b.setLayerType(1, null);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    public void a() {
        try {
            this.f24085b = null;
            f24083c = false;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002e A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:2:0x0000, B:6:0x0009, B:20:0x002a, B:22:0x002e, B:23:0x0036, B:25:0x003c, B:14:0x001a, B:16:0x001e), top: B:30:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[Catch: Exception -> 0x0040, TryCatch #0 {Exception -> 0x0040, blocks: (B:2:0x0000, B:6:0x0009, B:20:0x002a, B:22:0x002e, B:23:0x0036, B:25:0x003c, B:14:0x001a, B:16:0x001e), top: B:30:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(com.scores365.entitys.GameObj r5, android.view.ViewGroup r6) {
        /*
            r4 = this;
            boolean r0 = com.scores365.gameCenter.w0.f24083c     // Catch: java.lang.Exception -> L40
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            com.scores365.entitys.WidgetObj r3 = r5.getMomentumWidget()     // Catch: java.lang.Exception -> L40
            if (r3 == 0) goto L11
            r3 = 1
            goto L12
        L11:
            r3 = 0
        L12:
            if (r0 == 0) goto L18
            if (r3 == 0) goto L29
        L16:
            r0 = 1
            goto L2a
        L18:
            if (r3 == 0) goto L29
            com.scores365.entitys.GameObj r0 = r4.f24084a     // Catch: java.lang.Exception -> L40
            if (r0 == 0) goto L16
            int r0 = r0.getID()     // Catch: java.lang.Exception -> L40
            int r3 = r5.getID()     // Catch: java.lang.Exception -> L40
            if (r0 == r3) goto L29
            goto L16
        L29:
            r0 = 0
        L2a:
            r4.f24084a = r5     // Catch: java.lang.Exception -> L40
            if (r0 == 0) goto L36
            java.lang.String r5 = r4.h(r5)     // Catch: java.lang.Exception -> L40
            r4.e(r6, r5)     // Catch: java.lang.Exception -> L40
            goto L44
        L36:
            int r5 = r6.getChildCount()     // Catch: java.lang.Exception -> L40
            if (r5 < r2) goto L44
            r4.g(r6, r1)     // Catch: java.lang.Exception -> L40
            goto L44
        L40:
            r5 = move-exception
            li.x0.N1(r5)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.w0.c(com.scores365.entitys.GameObj, android.view.ViewGroup):void");
    }

    public int i() {
        int s10 = li.p0.s(90);
        try {
            WidgetObj momentumWidget = this.f24084a.getMomentumWidget();
            if (momentumWidget != null) {
                double widgetRatio = momentumWidget.getWidgetRatio();
                return widgetRatio > 1.0d ? (int) (App.m().getResources().getDisplayMetrics().widthPixels / widgetRatio) : s10;
            }
            return s10;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return s10;
        }
    }
}
