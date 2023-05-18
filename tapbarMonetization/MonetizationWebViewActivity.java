package com.scores365.tapbarMonetization;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.facebook.FacebookSdk;
import com.scores365.App;
import com.scores365.R;
import com.scores365.branding.BrandAsset;
import com.scores365.branding.BrandingKey;
import com.scores365.branding.BrandingStripItem;
import com.scores365.ui.CustomProgressBar;
import com.scores365.ui.viewpagerindicator.CustomWebView;
import li.o0;
import li.p0;
import li.u;
import li.x0;
/* loaded from: classes2.dex */
public class MonetizationWebViewActivity extends com.scores365.Design.Activities.c {
    private WebView F;
    private CustomProgressBar G;
    private boolean H = true;

    /* loaded from: classes2.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            try {
                super.onProgressChanged(webView, i10);
                MonetizationWebViewActivity.this.G.setProgress(i10);
                if (i10 == 100) {
                    MonetizationWebViewActivity.this.G.setVisibility(8);
                    if (MonetizationWebViewActivity.this.H) {
                        MonetizationWebViewActivity.this.H = false;
                        webView.reload();
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }
    }

    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BrandAsset f24277a;

        c(BrandAsset brandAsset) {
            this.f24277a = brandAsset;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                x0.M1(this.f24277a.getClickUrl());
                BrandingStripItem.sendClickAnalytics(BrandingKey.worldCup, this.f24277a.brand);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static Intent h1(String str) {
        Intent intent = new Intent(App.m(), MonetizationWebViewActivity.class);
        intent.putExtra("urlTag", str);
        return intent;
    }

    @Override // com.scores365.Design.Activities.c
    public void HandleToolbarOptions(Toolbar toolbar) {
        try {
            super.HandleToolbarOptions(toolbar);
            LinearLayout linearLayout = (LinearLayout) toolbar.findViewById(R.id.Ts);
            linearLayout.setVisibility(0);
            ImageView imageView = (ImageView) toolbar.findViewById(R.id.kJ);
            ImageView imageView2 = (ImageView) toolbar.findViewById(R.id.jJ);
            ImageView imageView3 = (ImageView) toolbar.findViewById(R.id.lJ);
            TextView textView = (TextView) toolbar.findViewById(R.id.mJ);
            TextView textView2 = (TextView) toolbar.findViewById(R.id.vo);
            textView.setTypeface(o0.d(App.m()));
            textView2.setTypeface(o0.d(App.m()));
            imageView.setImageResource(R.drawable.W3);
            imageView2.setImageResource(R.drawable.f21761m2);
            BrandAsset k10 = cc.o0.y() != null ? cc.o0.y().k(BrandingKey.worldCup) : null;
            if (k10 == null) {
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
                textView.setVisibility(8);
                textView2.setVisibility(8);
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).topMargin = p0.s(10);
                return;
            }
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) imageView3.getLayoutParams()).topMargin = p0.s(10);
            ((ViewGroup.MarginLayoutParams) imageView3.getLayoutParams()).bottomMargin = p0.s(10);
            imageView3.getLayoutParams().height = p0.s(80);
            u.x(k10.getResource(), imageView3);
            imageView3.setOnClickListener(new c(k10));
            x0.S(k10.getImpressionUrl());
            BrandingStripItem.sendImpressionAnalytics(BrandingKey.worldCup, k10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22705t4);
        try {
            initActionBar();
            getSupportActionBar().t(true);
            getSupportActionBar().u(false);
            p0.E0(this, 0);
            String string = getIntent().getExtras().getString("urlTag", null);
            this.H = string != null && string.contains(FacebookSdk.FACEBOOK_COM);
            CustomProgressBar customProgressBar = (CustomProgressBar) findViewById(R.id.Ej);
            this.G = customProgressBar;
            customProgressBar.setVisibility(0);
            CustomWebView customWebView = (CustomWebView) findViewById(R.id.dJ);
            this.F = customWebView;
            setWebViewSettings(customWebView);
            this.F.setWebChromeClient(new a());
            this.F.setWebViewClient(new b());
            this.F.loadUrl(string);
            this.F.getSettings().setUseWideViewPort(true);
            this.F.setInitialScale(50);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        onBackPressed();
        return true;
    }

    @TargetApi(16)
    public void setWebViewSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setLoadWithOverviewMode(false);
        settings.setUseWideViewPort(false);
        settings.setBuiltInZoomControls(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
    }
}
