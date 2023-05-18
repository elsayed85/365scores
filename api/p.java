package com.scores365.api;

import android.text.TextUtils;
import org.json.JSONObject;
/* compiled from: APIStadium.java */
/* loaded from: classes2.dex */
public class p extends d {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f23174a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f23175b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f23176c = -1;

    /* renamed from: d  reason: collision with root package name */
    private b f23177d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: APIStadium.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23178a;

        static {
            int[] iArr = new int[b.values().length];
            f23178a = iArr;
            try {
                iArr[b.DeviceCheckIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23178a[b.DeviceCheckOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: APIStadium.java */
    /* loaded from: classes2.dex */
    public enum b {
        DeviceCheckIn,
        DeviceCheckOut
    }

    public p() {
        this.BaseUrl = "http://comments.365scores.com";
        String l02 = li.p0.l0("COMMENTS_SERVER_URL");
        if (!TextUtils.isEmpty(l02)) {
            this.BaseUrl = l02;
        }
        this.usePostDataName = false;
    }

    private String d() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = a.f23178a[this.f23177d.ordinal()];
            if (i10 == 1 || i10 == 2) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("token", sf.b.X1().F2());
                jSONObject2.put("provider", "DV_AND");
                jSONObject.put("slug", this.f23175b);
                jSONObject.put("user", jSONObject2);
                jSONObject.put("selection", this.f23176c);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(String str, int i10) {
        try {
            this.f23177d = b.DeviceCheckIn;
            this.f23175b = str;
            this.f23176c = i10;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void b(String str) {
        try {
            this.f23177d = b.DeviceCheckOut;
            this.f23175b = str;
            this.f23176c = -1;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public JSONObject c() {
        return this.f23174a;
    }

    @Override // com.scores365.api.d
    public void call() {
        try {
            this.f23174a = null;
            parseJSON(e(getURL() + "/" + getParams(), d()));
        } catch (Exception e10) {
            li.x0.N1(e10);
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
        StringBuilder sb2 = new StringBuilder();
        try {
            int i10 = a.f23178a[this.f23177d.ordinal()];
            if (i10 == 1) {
                sb2.append("api/Location/checkin");
            } else if (i10 == 2) {
                sb2.append("api/Location/checkout");
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23174a = new JSONObject(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
