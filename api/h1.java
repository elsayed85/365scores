package com.scores365.api;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.scores365.App;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.PurchasesObj;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ApiPurchase.java */
/* loaded from: classes2.dex */
public class h1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private b f23020a;

    /* renamed from: b  reason: collision with root package name */
    public PurchasesObj f23021b;

    /* renamed from: c  reason: collision with root package name */
    public String f23022c;

    /* renamed from: d  reason: collision with root package name */
    public String f23023d;

    /* renamed from: e  reason: collision with root package name */
    public String f23024e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f23025f;

    /* renamed from: g  reason: collision with root package name */
    public int f23026g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23027h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApiPurchase.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23028a;

        static {
            int[] iArr = new int[b.values().length];
            f23028a = iArr;
            try {
                iArr[b.GET_ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23028a[b.PURCHASE_MADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: ApiPurchase.java */
    /* loaded from: classes2.dex */
    public enum b {
        GET_ACTIVE,
        PURCHASE_MADE
    }

    public h1(b bVar, String str) {
        d(bVar, str, null, null, -1, false, null);
    }

    public h1(b bVar, String str, JSONObject jSONObject, String str2, int i10, boolean z10, String str3) {
        this.usePostDataName = false;
        d(bVar, str, jSONObject, str2, i10, z10, str3);
    }

    private String a() {
        try {
            if (this.f23020a == b.PURCHASE_MADE) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("DeviceID", sf.b.X1().F2());
                jSONObject2.put("AppType", 2);
                jSONObject2.put("AppVersion", li.p0.a(App.m()));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("Store", this.f23025f != null ? "GooglePlay" : "365Scores");
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = this.f23025f;
                if (jSONObject5 != null) {
                    jSONObject4.put("ProductID", jSONObject5.optString("productId"));
                    JSONObject jSONObject6 = this.f23025f;
                    jSONObject4.put("Token", jSONObject6.optString("token", jSONObject6.optString(SDKConstants.PARAM_PURCHASE_TOKEN)));
                    jSONObject3.put("PurchaseProof", jSONObject4);
                }
                JSONObject jSONObject7 = this.f23025f;
                jSONObject3.put("Date", jSONObject7 != null ? jSONObject7.optLong("purchaseTime") : System.currentTimeMillis());
                jSONObject3.put("Price", this.f23024e);
                jSONObject3.put("Quantity", 1);
                JSONObject jSONObject8 = new JSONObject();
                if (this.f23027h && this.f23025f == null) {
                    jSONObject8.put("ProductType", "Tip");
                } else if (TextUtils.isEmpty(this.f23023d)) {
                    jSONObject8.put("ProductType", c());
                } else {
                    jSONObject8.put("ProductType", this.f23023d);
                }
                int i10 = this.f23026g;
                if (i10 > 0) {
                    jSONObject8.put("EntityID", i10);
                }
                jSONObject.put("User", jSONObject2);
                jSONObject.put("Transaction", jSONObject3);
                jSONObject.put("Metadata", jSONObject8);
                return jSONObject.toString();
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("purchases/GetActive/?DeviceID=");
        sb2.append(sf.b.X1().F2());
        sb2.append("&lang=");
        sb2.append(sf.a.i0(App.m()).k0());
        sb2.append("&AppType=2");
        sb2.append("&AppVersion=");
        sb2.append(li.p0.a(App.m()));
        String str = this.f23022c;
        if (str != null && !str.isEmpty()) {
            sb2.append("&notification=");
            sb2.append(this.f23022c);
        }
        sb2.append("&UserCountry=");
        sb2.append(sf.a.i0(App.m()).j0());
        return sb2.toString();
    }

    private String c() {
        return this.f23027h ? "Tip" : "FreeTip";
    }

    private void d(b bVar, String str, JSONObject jSONObject, String str2, int i10, boolean z10, String str3) {
        this.f23020a = bVar;
        this.f23022c = str;
        this.f23025f = jSONObject;
        this.f23026g = i10;
        this.f23027h = z10;
        this.f23023d = str3;
        this.f23024e = str2;
    }

    @Override // com.scores365.api.d
    public void call() {
        try {
            if (this.f23020a == b.PURCHASE_MADE) {
                parseJSON(e(getURL() + "/" + getParams(), a()));
            } else {
                super.call();
            }
        } catch (Exception e10) {
            ng.a aVar = ng.a.f35508a;
            aVar.c("APIClient", "error calling purchase api, type=" + this.f23020a, e10);
        }
    }

    protected String e(String str, String str2) {
        try {
            y1.m d10 = y1.m.d();
            x1.n a10 = x1.a();
            w1 w1Var = new w1(1, str, d10, d10);
            w1Var.V(str2);
            w1Var.X(true);
            w1Var.O(new x1.e((int) w.c(), w.d(), 1.0f));
            w1Var.Q(false);
            a10.a(w1Var);
            return (String) d10.get();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        int i10 = a.f23028a[this.f23020a.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            return "Purchases/PurchaseMade";
        }
        return b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        String I1 = sf.b.X1().I1();
        return I1 == null ? "http://purchase.365scores.com/" : I1;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            if (this.f23020a == b.GET_ACTIVE) {
                this.f23021b = (PurchasesObj) GsonManager.getGson().l(str, PurchasesObj.class);
            } else {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("OK")) {
                    PurchasesObj purchasesObj = new PurchasesObj();
                    this.f23021b = purchasesObj;
                    purchasesObj.isDataOk = jSONObject.getBoolean("OK");
                }
            }
        } catch (JSONException e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
