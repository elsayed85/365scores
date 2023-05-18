package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.dashboardSections.AbstractSectionObject;
/* compiled from: ApiRoundFilterGames.kt */
/* loaded from: classes2.dex */
public final class k1 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23078a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23079b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23080c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23081d;

    /* renamed from: e  reason: collision with root package name */
    private String f23082e;

    /* renamed from: f  reason: collision with root package name */
    private AbstractSectionObject[] f23083f;

    public k1(String filterKey, int i10, String section, boolean z10) {
        kotlin.jvm.internal.m.g(filterKey, "filterKey");
        kotlin.jvm.internal.m.g(section, "section");
        this.f23078a = filterKey;
        this.f23079b = i10;
        this.f23080c = section;
        this.f23081d = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[Catch: Exception -> 0x0044, LOOP:0: B:6:0x000a->B:15:0x0037, LOOP_END, TryCatch #0 {Exception -> 0x0044, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000c, B:9:0x0010, B:18:0x003d, B:15:0x0037), top: B:27:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.scores365.entitys.GamesObj a() {
        /*
            r10 = this;
            java.lang.String r0 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            r1 = 0
            com.scores365.entitys.dashboardSections.AbstractSectionObject[] r2 = r10.f23083f     // Catch: java.lang.Exception -> L44
            if (r2 == 0) goto L42
            int r3 = r2.length     // Catch: java.lang.Exception -> L44
            r4 = 0
            r5 = 0
        La:
            if (r5 >= r3) goto L3a
            r6 = r2[r5]     // Catch: java.lang.Exception -> L44
            if (r6 == 0) goto L33
            java.lang.String r7 = r6.getKey()     // Catch: java.lang.Exception -> L44
            java.lang.String r8 = "it.key"
            kotlin.jvm.internal.m.f(r7, r8)     // Catch: java.lang.Exception -> L44
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch: java.lang.Exception -> L44
            java.lang.String r7 = r7.toLowerCase(r8)     // Catch: java.lang.Exception -> L44
            kotlin.jvm.internal.m.f(r7, r0)     // Catch: java.lang.Exception -> L44
            java.lang.String r9 = r10.f23080c     // Catch: java.lang.Exception -> L44
            java.lang.String r8 = r9.toLowerCase(r8)     // Catch: java.lang.Exception -> L44
            kotlin.jvm.internal.m.f(r8, r0)     // Catch: java.lang.Exception -> L44
            boolean r7 = kotlin.jvm.internal.m.b(r7, r8)     // Catch: java.lang.Exception -> L44
            if (r7 == 0) goto L33
            r7 = 1
            goto L34
        L33:
            r7 = 0
        L34:
            if (r7 == 0) goto L37
            goto L3b
        L37:
            int r5 = r5 + 1
            goto La
        L3a:
            r6 = r1
        L3b:
            if (r6 == 0) goto L42
            java.lang.Object r0 = r6.getData()     // Catch: java.lang.Exception -> L44
            goto L4a
        L42:
            r0 = r1
            goto L4a
        L44:
            r0 = move-exception
            li.x0.N1(r0)
            kotlin.Unit r0 = kotlin.Unit.f33377a
        L4a:
            boolean r2 = r0 instanceof com.scores365.entitys.GamesObj
            if (r2 == 0) goto L51
            r1 = r0
            com.scores365.entitys.GamesObj r1 = (com.scores365.entitys.GamesObj) r1
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.api.k1.a():com.scores365.entitys.GamesObj");
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder("Data/Dashboard/?");
        sb2.append("roundfilter=" + this.f23078a);
        sb2.append("&filtersourcesout=true");
        sb2.append("&NewsLang=" + sf.b.X1().s2());
        sb2.append("&competitions=" + this.f23079b);
        sb2.append("&withtransfers=true");
        sb2.append("&Sections=" + this.f23080c);
        if (this.f23081d && li.x0.s2()) {
            sb2.append("&WithMainOdds=true");
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.m.f(sb3, "params.toString()");
        return sb3;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23083f = (AbstractSectionObject[]) GsonManager.getGson().h(new com.google.gson.o().a(str).e().p("Sections"), AbstractSectionObject[].class);
            this.f23082e = str;
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
