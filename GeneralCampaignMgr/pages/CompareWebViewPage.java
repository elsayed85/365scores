package com.scores365.GeneralCampaignMgr.pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.scores365.App;
import com.scores365.Design.Pages.a;
import com.scores365.R;
import com.scores365.ui.WebViewActivity;
import java.lang.ref.WeakReference;
import li.x0;
/* loaded from: classes2.dex */
public class CompareWebViewPage extends a implements OnMonetizationJsCallbackListener {

    /* renamed from: l  reason: collision with root package name */
    private WebView f21092l;

    /* loaded from: classes2.dex */
    public static class MonetizationJavaScriptInterface {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<OnMonetizationJsCallbackListener> f21093a;

        public MonetizationJavaScriptInterface(OnMonetizationJsCallbackListener onMonetizationJsCallbackListener) {
            this.f21093a = new WeakReference<>(onMonetizationJsCallbackListener);
        }

        @JavascriptInterface
        public void myBallsClick(String str) {
            try {
                OnMonetizationJsCallbackListener onMonetizationJsCallbackListener = this.f21093a.get();
                if (onMonetizationJsCallbackListener != null) {
                    onMonetizationJsCallbackListener.g0(str);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static CompareWebViewPage s1(String str, String str2) {
        CompareWebViewPage compareWebViewPage = new CompareWebViewPage();
        Bundle bundle = new Bundle();
        bundle.putString("url_args", str);
        bundle.putString("title_args", str2);
        compareWebViewPage.setArguments(bundle);
        return compareWebViewPage;
    }

    @Override // com.scores365.GeneralCampaignMgr.pages.OnMonetizationJsCallbackListener
    public void g0(String str) {
        try {
            Intent intent = new Intent(App.m(), WebViewActivity.class);
            intent.putExtra("url", str);
            startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return getArguments().getString("title_args", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.N0, viewGroup, false);
        try {
            WebView webView = (WebView) inflate.findViewById(R.id.oJ);
            this.f21092l = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            this.f21092l.getSettings().setLoadsImagesAutomatically(true);
            this.f21092l.setWebViewClient(new WebViewClient());
            this.f21092l.addJavascriptInterface(new MonetizationJavaScriptInterface(this), "monetization");
            this.f21092l.loadUrl(getArguments().getString("url_args", ""));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            this.f21092l.removeJavascriptInterface("monetization");
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            this.f21092l.clearCache(true);
            this.f21092l.destroyDrawingCache();
            this.f21092l.removeAllViews();
            this.f21092l.destroy();
            this.f21092l.stopLoading();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onDestroyView();
    }

    public WebView r1() {
        return this.f21092l;
    }
}
