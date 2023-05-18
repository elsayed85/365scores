package com.scores365.api;

import com.scores365.entitys.CategorizedObj;
import com.scores365.entitys.GsonManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ApiMainOnBoardingCompetitions.kt */
/* loaded from: classes2.dex */
public final class v0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final int f23234a;

    /* renamed from: b  reason: collision with root package name */
    private CategorizedObj f23235b;

    public v0(int i10) {
        this.f23234a = i10;
        this.containSlash = false;
    }

    public /* synthetic */ v0(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1 : i10);
    }

    public final CategorizedObj a() {
        return this.f23235b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        if (this.f23234a != -1) {
            return "Data/Entities/Competitions/OnBoarding/?sid=" + this.f23234a;
        }
        return "Data/Entities/Competitions/OnBoarding/?";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        if (!(str == null || str.length() == 0)) {
            this.f23235b = (CategorizedObj) GsonManager.getGson().l(str, CategorizedObj.class);
            return;
        }
        ng.a aVar = ng.a.f35508a;
        aVar.c("APIClient", "error parsing categorized objects", new IllegalArgumentException("json data can't be empty, data=" + str));
    }
}
