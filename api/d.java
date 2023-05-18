package com.scores365.api;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.scores365.App;
import java.net.URI;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
/* compiled from: APIClient.java */
/* loaded from: classes2.dex */
public abstract class d {
    private static final String APP_TYPE_CONST = "&AppType=2";
    protected static final String APP_VERSION_CONST = "&AppVersion=";
    private static final String ATHLETE_SUPPORTED_CONST = "&athletesSupported=true";
    private static final String GOOGLE_LAYOUT_SUPPORT_CONST_PARAM = "&Layout=";
    private static final String GOOGLE_LAYOUT_SUPPORT_CONST_VALUE = "Google Policy Layout";
    protected static final int INDONESIA_COUNTRY_ID = 75;
    protected static final int KUWAIT_COUNTRY_ID = 126;
    private static final String LANG_CONST = "lang=";
    private static final String STORE_VERSION_CONST = "&StoreVersion=";
    protected static final String TAG = "APIClient";
    private static final String THEME_CONST = "&theme=";
    protected static final int TURKEY_COUNTRY_ID = 12;
    protected static final int TURKMENISTAN_COUNTRY_ID = 120;
    private static final String TZ_CONST = "&tz=";
    protected static final String UC_CONST = "&uc=";
    public boolean error;
    private HashMap<String, String> paramsPairs;
    protected boolean requestSuccess;
    protected StringBuilder requestUrlBuilder;
    protected String BaseUrl = "";
    protected boolean containSlash = true;
    private boolean allowPost = false;
    public boolean usePostDataName = true;
    protected String postData = "";

    private static HashMap<String, String> convertUrlParams(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Uri parse = Uri.parse(str);
            for (String str2 : parse.getQueryParameterNames()) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return hashMap;
    }

    private String getAppVersion() {
        sf.b X1 = sf.b.X1();
        return X1.Z9() ? X1.h2() : li.p0.a(App.m());
    }

    private static String getUrlPath(String str) {
        try {
            return Uri.parse(str).getPath();
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    public static String handleAlternateURL(String str) {
        try {
            int j02 = sf.a.i0(App.m()).j0();
            return (j02 == 12 || j02 == INDONESIA_COUNTRY_ID || j02 == TURKMENISTAN_COUNTRY_ID || j02 == KUWAIT_COUNTRY_ID) ? str.toLowerCase().replace("365scores.com", "scores-alt.com") : str;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return str;
        }
    }

    private static boolean isUrlExceedsLengthLimit(String str) {
        try {
            return str.length() > 2000;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SetBaseUrl(String str) {
        this.BaseUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void call() {
        u1 u1Var;
        try {
            this.requestUrlBuilder = getRequestUrl();
            y1.m d10 = y1.m.d();
            if (this.allowPost) {
                w1 w1Var = new w1(1, URI.create(this.requestUrlBuilder.toString()).normalize().toString(), d10, d10);
                HashMap<String, String> hashMap = this.paramsPairs;
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    hashMap.put("Data", this.postData);
                }
                w1Var.W(hashMap);
                u1Var = w1Var;
            } else {
                u1Var = new u1(0, URI.create(this.requestUrlBuilder.toString()).normalize().toString(), d10, d10);
            }
            x1.n a10 = x1.a();
            u1Var.O(new x1.e((int) getTimeoutConnection(), w.d(), 1.0f));
            u1Var.Q(shouldCache());
            a10.a(u1Var);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str = (String) d10.get(getTimeoutConnection(), TimeUnit.MILLISECONDS);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (str != null) {
                    parseJSON(str);
                    this.requestSuccess = true;
                }
                ng.a aVar = ng.a.f35508a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[");
                sb2.append(u1Var.s());
                sb2.append("]");
                sb2.append(u1Var.C());
                sb2.append(" executionTime=");
                sb2.append(currentTimeMillis2);
                sb2.append(", parsingTime=");
                sb2.append(System.currentTimeMillis() - currentTimeMillis3);
                sb2.append(", totalTime=");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                sb2.append(" ,resultSize=");
                sb2.append(str == null ? "null" : Integer.valueOf(str.length()));
                aVar.b(TAG, sb2.toString(), null);
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                this.requestSuccess = false;
                ng.a aVar2 = ng.a.f35508a;
                aVar2.c(TAG, "[" + u1Var.s() + "]" + u1Var.C(), cause);
                ee.k.p(App.m(), "app", "ssl-request", "failed", false);
            } catch (Exception e11) {
                this.requestSuccess = false;
                ng.a aVar3 = ng.a.f35508a;
                aVar3.a(TAG, "[" + u1Var.s() + "]" + u1Var.C(), e11);
            }
        } catch (Exception e12) {
            ng.a aVar4 = ng.a.f35508a;
            aVar4.c(TAG, "error getting network response, api=" + this, e12);
        }
    }

    protected String getBaseParams(String str) {
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            try {
                if (!str.contains(LANG_CONST)) {
                    sb2.append(LANG_CONST);
                    sb2.append(sf.a.i0(App.m()).k0());
                }
            } catch (Exception e10) {
                ng.a.f35508a.c(TAG, "error appending base params", e10);
            }
        }
        if (str != null && !str.contains(APP_TYPE_CONST)) {
            sb2.append(APP_TYPE_CONST);
        }
        if (str != null && !str.contains(APP_VERSION_CONST)) {
            sb2.append(APP_VERSION_CONST);
            sb2.append(getAppVersion());
        }
        if (str != null && !str.contains(UC_CONST)) {
            sb2.append(UC_CONST);
            sb2.append(sf.a.i0(App.m()).j0());
        }
        if (str != null && !str.contains(TZ_CONST)) {
            sb2.append(TZ_CONST);
            sb2.append(sf.a.i0(App.m()).l0());
        }
        if (str != null && !str.contains(THEME_CONST)) {
            sb2.append(THEME_CONST);
            sb2.append(li.x0.n1() ? "light" : "dark");
        }
        if (str != null && !str.contains(STORE_VERSION_CONST)) {
            sb2.append(STORE_VERSION_CONST);
            sb2.append(getAppVersion());
        }
        sb2.append(ATHLETE_SUPPORTED_CONST);
        try {
            if (ke.a.f33223a.g().booleanValue() && str != null && !str.contains(GOOGLE_LAYOUT_SUPPORT_CONST_PARAM)) {
                sb2.append(GOOGLE_LAYOUT_SUPPORT_CONST_PARAM);
                sb2.append(li.x0.x(GOOGLE_LAYOUT_SUPPORT_CONST_VALUE));
            }
        } catch (Exception e11) {
            ng.a.f35508a.c(TAG, "error appending google layout base params", e11);
        }
        String E2 = !li.f.f() ? sf.b.X1().E2() : null;
        if (E2 != null && !E2.isEmpty()) {
            sb2.append("&");
            sb2.append("publisher");
            sb2.append("=");
            sb2.append(li.x0.x(E2));
            sb2.append("&");
            sb2.append("campaign");
            sb2.append("=");
            sb2.append(li.x0.x(sf.b.X1().C2()));
            sb2.append("&");
            sb2.append("adgroup");
            sb2.append("=");
            sb2.append(li.x0.x(sf.b.X1().B2()));
        }
        return sb2.toString();
    }

    protected abstract String getParams();

    @NonNull
    protected StringBuilder getRequestUrl() {
        String baseParams;
        String params = getParams();
        StringBuilder sb2 = new StringBuilder(handleAlternateURL(getURL()));
        if (params != null && !params.isEmpty()) {
            if (this.containSlash) {
                sb2.append("/");
            }
            sb2.append(params);
        }
        if (shouldAddBaseParams() && (baseParams = getBaseParams(params)) != null && !baseParams.isEmpty()) {
            if (sb2.charAt(sb2.length() - 1) == '?' || sb2.charAt(sb2.length() - 1) == '&') {
                sb2.append(baseParams);
            } else {
                sb2.append("&");
                sb2.append(baseParams);
            }
        }
        if (isUrlExceedsLengthLimit(sb2.toString())) {
            this.allowPost = true;
            String urlPath = getUrlPath(sb2.toString());
            this.paramsPairs = convertUrlParams(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getURL());
            sb3.append(this.containSlash ? "/" : "");
            sb3.append(urlPath);
            sb2 = new StringBuilder(sb3.toString());
        }
        return new StringBuilder(URI.create(sb2.toString()).normalize().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getTimeoutConnection() {
        return w.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getURL() {
        Exception e10;
        String str;
        try {
            str = this.BaseUrl;
        } catch (Exception e11) {
            e10 = e11;
        }
        try {
            if (str.equals("")) {
                try {
                    this.BaseUrl = App.t();
                } catch (Exception unused) {
                    this.BaseUrl = li.h0.c(App.m());
                }
                return this.BaseUrl;
            }
            return str;
        } catch (Exception e12) {
            e10 = e12;
            ng.a aVar = ng.a.f35508a;
            aVar.c(TAG, "error getting url" + e10.getMessage(), e10);
            return "";
        }
    }

    public boolean isRequestSuccess() {
        return this.requestSuccess;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRequestError(Exception exc) {
        li.x0.N1(exc);
    }

    protected abstract void parseJSON(String str);

    public void setPostData(String str) {
        this.allowPost = true;
        this.postData = str;
    }

    protected boolean shouldAddBaseParams() {
        return true;
    }

    protected boolean shouldCache() {
        return true;
    }

    @NonNull
    public String toString() {
        return "APIClient{url=" + getURL() + ", requestSuccess=" + this.requestSuccess + '}';
    }
}
