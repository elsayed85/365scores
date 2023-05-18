package com.scores365.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.share.widget.ShareDialog;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.ItemObj;
import com.scores365.ui.viewpagerindicator.CustomWebView;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class WebViewActivity extends com.scores365.Design.Activities.c {
    public static final String OPEN_IN_EXTERNAL_BROWSER = "open_in_external_browser";
    public static final String PLAYBUZZ_BUNDLE_TAG = "playbuzz";
    private boolean isNeedToRefresh = true;
    private boolean isStartFromNotification = false;
    private ItemObj mItemObj;
    private String mShareUrl;
    private String mUrl;
    private CustomProgressBar pbLoading;
    private CustomWebView web_content;

    private void handleFinishActivity() {
        try {
            Intent x02 = x0.x0();
            x02.setFlags(268435456);
            x02.setFlags(67108864);
            x02.putExtra("startFromNotif", true);
            startActivity(x02);
            finish();
        } catch (Exception e10) {
            finish();
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x014e A[Catch: Exception -> 0x01c9, TryCatch #2 {Exception -> 0x01c9, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0014, B:9:0x0026, B:10:0x003a, B:13:0x0044, B:15:0x004e, B:17:0x005e, B:22:0x008f, B:27:0x00a6, B:29:0x00aa, B:51:0x0140, B:53:0x014e, B:55:0x0166, B:56:0x016f, B:58:0x0173, B:62:0x017e, B:26:0x00a3, B:21:0x008c, B:30:0x00b1, B:32:0x00b7, B:34:0x00c1, B:36:0x00d1, B:37:0x00e1, B:43:0x0104, B:45:0x010c, B:48:0x0119, B:49:0x0137, B:18:0x007e, B:23:0x009a), top: B:71:0x0004, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0166 A[Catch: Exception -> 0x01c9, TryCatch #2 {Exception -> 0x01c9, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0014, B:9:0x0026, B:10:0x003a, B:13:0x0044, B:15:0x004e, B:17:0x005e, B:22:0x008f, B:27:0x00a6, B:29:0x00aa, B:51:0x0140, B:53:0x014e, B:55:0x0166, B:56:0x016f, B:58:0x0173, B:62:0x017e, B:26:0x00a3, B:21:0x008c, B:30:0x00b1, B:32:0x00b7, B:34:0x00c1, B:36:0x00d1, B:37:0x00e1, B:43:0x0104, B:45:0x010c, B:48:0x0119, B:49:0x0137, B:18:0x007e, B:23:0x009a), top: B:71:0x0004, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016f A[Catch: Exception -> 0x01c9, TryCatch #2 {Exception -> 0x01c9, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x0014, B:9:0x0026, B:10:0x003a, B:13:0x0044, B:15:0x004e, B:17:0x005e, B:22:0x008f, B:27:0x00a6, B:29:0x00aa, B:51:0x0140, B:53:0x014e, B:55:0x0166, B:56:0x016f, B:58:0x0173, B:62:0x017e, B:26:0x00a3, B:21:0x008c, B:30:0x00b1, B:32:0x00b7, B:34:0x00c1, B:36:0x00d1, B:37:0x00e1, B:43:0x0104, B:45:0x010c, B:48:0x0119, B:49:0x0137, B:18:0x007e, B:23:0x009a), top: B:71:0x0004, inners: #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadActivityData() {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.WebViewActivity.loadActivityData():void");
    }

    private void shareAction() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            String str = this.mUrl;
            String str2 = this.mShareUrl;
            if (str2 != null && !str2.isEmpty()) {
                str = this.mShareUrl;
            }
            ee.k.n(App.m(), "webview", ShareDialog.WEB_SHARE_DIALOG, null, null, false, "url", str);
            intent.putExtra("android.intent.extra.TEXT", str);
            startActivity(Intent.createChooser(intent, ""));
        } catch (Exception unused) {
        }
    }

    private boolean shouldSupportWebViewBack() {
        try {
            if (!this.web_content.canGoBack() || this.mItemObj == null) {
                return false;
            }
            for (String str : p0.l0("NEWS_SOURCES_ALLOW_BACK").split(",")) {
                if (Integer.valueOf(str).intValue() == this.mItemObj.getSourceID()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (shouldSupportWebViewBack()) {
                this.web_content.goBack();
            } else if (this.isStartFromNotification) {
                handleFinishActivity();
            } else {
                super.onBackPressed();
            }
        } catch (Exception e10) {
            x0.N1(e10);
            super.onBackPressed();
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22612lb);
        x0.D1(this);
        loadActivityData();
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.f22785b, menu);
        MenuItem findItem = menu.findItem(R.id.f22036h);
        findItem.setTitle(p0.l0("SHARE_ITEM"));
        if (this.isStartFromNotification) {
            return true;
        }
        findItem.setVisible(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        try {
            this.web_content.clearCache(true);
            this.web_content.destroyDrawingCache();
            this.web_content.removeAllViews();
            this.web_content.destroy();
            this.web_content.stopLoading();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            setIntent(intent);
            loadActivityData();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId == R.id.f22036h) {
            shareAction();
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }

    @TargetApi(16)
    public void setWebViewSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(false);
        settings.setBuiltInZoomControls(true);
        settings.setDatabaseEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setMixedContentMode(0);
    }
}
