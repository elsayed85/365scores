package com.scores365.api;

import android.content.Context;
import com.scores365.entitys.GamesObj;
/* compiled from: APIAthletesFutureMatch.kt */
/* loaded from: classes2.dex */
public final class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22923a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22924b;

    /* renamed from: c  reason: collision with root package name */
    private GamesObj f22925c;

    public b(Context context, String nextMatchApiURL) {
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(nextMatchApiURL, "nextMatchApiURL");
        this.f22923a = context;
        this.f22924b = nextMatchApiURL;
    }

    public final GamesObj a() {
        GamesObj gamesObj = this.f22925c;
        if (gamesObj != null) {
            return gamesObj;
        }
        throw new AssertionError("gamesObj inside APIAthletesFutureMatch.kt is set to null by another thread");
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return this.f22924b;
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f22925c = w.h(str);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
