package com.scores365.api;

import com.scores365.App;
import com.scores365.entitys.CategorizedObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GsonManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ApiMainOnBoardingCompetitors.kt */
/* loaded from: classes2.dex */
public final class w0 extends d {

    /* renamed from: e  reason: collision with root package name */
    public static final a f23239e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f23240a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23241b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23242c;

    /* renamed from: d  reason: collision with root package name */
    private CategorizedObj f23243d;

    /* compiled from: ApiMainOnBoardingCompetitors.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            String W;
            try {
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                Vector<CompetitionObj> i10 = App.b.i();
                kotlin.jvm.internal.m.f(i10, "GetCompetitions()");
                for (CompetitionObj it : i10) {
                    Integer valueOf = Integer.valueOf(it.getID());
                    kotlin.jvm.internal.m.f(it, "it");
                    hashMap.put(valueOf, it);
                    if (!ph.a.f36660a.c().contains(Integer.valueOf(it.getID()))) {
                        arrayList.add(Integer.valueOf(it.getID()));
                    }
                }
                for (Number number : ph.a.f36660a.c()) {
                    int intValue = number.intValue();
                    if (hashMap.containsKey(Integer.valueOf(intValue))) {
                        arrayList.add(Integer.valueOf(intValue));
                    }
                }
                W = kotlin.collections.z.W(arrayList, ",", null, null, 0, null, null, 62, null);
                return W;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return "";
            }
        }
    }

    public w0(int i10, boolean z10, String str) {
        this.f23240a = i10;
        this.f23241b = z10;
        this.f23242c = str;
        this.containSlash = false;
    }

    public /* synthetic */ w0(int i10, boolean z10, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? null : str);
    }

    public final CategorizedObj a() {
        return this.f23243d;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        boolean z10;
        boolean z11 = true;
        String str = "Data/Entities/Competitors/OnBoarding/?";
        if (this.f23241b) {
            str = "Data/Entities/Competitors/OnBoarding/?categorized=" + this.f23241b;
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f23240a != -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(z10 ? "&" : "");
            sb2.append("sid=");
            sb2.append(this.f23240a);
            str = sb2.toString();
            z10 = true;
        }
        String str2 = this.f23242c;
        if (str2 != null && str2.length() != 0) {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(z10 ? "&" : "");
        sb3.append("competitions=");
        sb3.append(this.f23242c);
        return sb3.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23243d = (CategorizedObj) GsonManager.getGson().l(str, CategorizedObj.class);
    }
}
