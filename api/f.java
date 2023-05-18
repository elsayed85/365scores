package com.scores365.api;

import android.content.Context;
import com.scores365.App;
import x1.o;
/* compiled from: APIFeedback.java */
/* loaded from: classes2.dex */
public class f extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f22974a;

    /* renamed from: b  reason: collision with root package name */
    private String f22975b;

    /* renamed from: c  reason: collision with root package name */
    private String f22976c;

    /* renamed from: d  reason: collision with root package name */
    private String f22977d;

    /* renamed from: e  reason: collision with root package name */
    private String f22978e;

    /* renamed from: f  reason: collision with root package name */
    private String f22979f;

    /* renamed from: g  reason: collision with root package name */
    private String f22980g;

    /* renamed from: h  reason: collision with root package name */
    private String f22981h;

    /* renamed from: i  reason: collision with root package name */
    private String f22982i;

    /* renamed from: j  reason: collision with root package name */
    private String f22983j;

    /* renamed from: k  reason: collision with root package name */
    private String f22984k;

    /* renamed from: l  reason: collision with root package name */
    private String f22985l;

    /* renamed from: m  reason: collision with root package name */
    private String f22986m;

    /* renamed from: n  reason: collision with root package name */
    private String f22987n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: APIFeedback.java */
    /* loaded from: classes2.dex */
    public class a implements o.b<String> {
        a() {
        }

        @Override // x1.o.b
        /* renamed from: b */
        public void a(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: APIFeedback.java */
    /* loaded from: classes2.dex */
    public class b implements o.a {
        b() {
        }

        @Override // x1.o.a
        public void b(x1.t tVar) {
        }
    }

    public f(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.f22974a = str;
        this.f22975b = str2;
        this.f22976c = str3;
        this.f22977d = str4;
        this.f22978e = str5;
        this.f22979f = str6;
        this.f22980g = str7;
        this.f22981h = str8;
        this.f22982i = str9;
        this.f22983j = str10;
        this.f22984k = str11;
        this.f22985l = str12;
        this.f22986m = str13;
    }

    protected String a(String str, String str2) {
        try {
            w1 w1Var = new w1(1, str, new a(), new b());
            w1Var.V(str2);
            x1.a().a(w1Var);
            return "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @Override // com.scores365.api.d
    public void call() {
        parseJSON(a(getURL(), getParams()));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(2:2|3)|(17:5|6|7|8|9|10|11|13|14|15|(1:17)(1:30)|18|19|20|(1:24)|26|27)|38|6|7|8|9|10|11|13|14|15|(0)(0)|18|19|20|(2:22|24)|26|27) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:1|2|3|(17:5|6|7|8|9|10|11|13|14|15|(1:17)(1:30)|18|19|20|(1:24)|26|27)|38|6|7|8|9|10|11|13|14|15|(0)(0)|18|19|20|(2:22|24)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0074, code lost:
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
        r15 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
        r16 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0373  */
    @Override // com.scores365.api.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String getParams() {
        /*
            Method dump skipped, instructions count: 1047
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.api.f.getParams():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return App.l().getTerms().get("FEEDBACK_URL").getName();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22987n = str;
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
