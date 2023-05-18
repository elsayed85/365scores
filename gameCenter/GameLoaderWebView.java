package com.scores365.gameCenter;

import android.content.Context;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.scores365.entitys.GameObj;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class GameLoaderWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<ViewGroup> f23678a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23679b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23680c;

    /* renamed from: d  reason: collision with root package name */
    private long f23681d;

    /* renamed from: e  reason: collision with root package name */
    private String f23682e;

    /* loaded from: classes2.dex */
    public static class LiveTrackerJavaScriptInterface {

        /* renamed from: a  reason: collision with root package name */
        c f23683a;

        /* renamed from: b  reason: collision with root package name */
        Handler f23684b = new Handler();

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LiveTrackerJavaScriptInterface.this.f23683a.a();
            }
        }

        public LiveTrackerJavaScriptInterface(c cVar) {
            this.f23683a = null;
            this.f23683a = cVar;
        }

        @JavascriptInterface
        public void adClick(String str) {
        }

        @JavascriptInterface
        public void postRender() {
            if (this.f23683a != null) {
                this.f23684b.postDelayed(new a(), 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements c {
        b() {
        }

        @Override // com.scores365.gameCenter.GameLoaderWebView.c
        public void a() {
            try {
                GameLoaderWebView.this.f23680c = true;
                GameCenterBaseActivity.f23611w1.b((GameLoaderWebView.this.f23678a == null || GameLoaderWebView.this.f23678a.get() == null) ? null : (ViewGroup) GameLoaderWebView.this.f23678a.get());
                GameLoaderWebView.this.f23682e = null;
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    public GameLoaderWebView(Context context) {
        super(context);
        this.f23678a = null;
        this.f23679b = false;
        this.f23680c = false;
        this.f23682e = null;
    }

    public boolean d() {
        return this.f23680c;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            this.f23680c = false;
            setKeepScreenOn(false);
            super.destroy();
        } catch (Exception e10) {
            super.destroy();
            li.x0.N1(e10);
        }
    }

    public void e(GameObj gameObj, WeakReference<ViewGroup> weakReference) {
        try {
            this.f23678a = weakReference;
            String widgetURL = gameObj.getLMTWidget().getWidgetURL();
            String str = this.f23682e;
            if (str == null || !str.equals(widgetURL)) {
                this.f23682e = widgetURL;
                loadUrl(widgetURL);
            }
            this.f23681d = System.currentTimeMillis();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void f() {
        this.f23680c = false;
        setKeepScreenOn(false);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void setWebViewListeners(int i10) {
        if (this.f23679b) {
            return;
        }
        try {
            WebSettings settings = getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            setWebChromeClient(new WebChromeClient());
            setWebViewClient(new a());
            getSettings().setDomStorageEnabled(true);
            if (i10 == 1) {
                getSettings().setUseWideViewPort(true);
                setInitialScale(1);
            }
            addJavascriptInterface(new LiveTrackerJavaScriptInterface(new b()), "MobileFunctions");
            getSettings().setAllowFileAccess(true);
            setLayerType(2, null);
            this.f23679b = true;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
