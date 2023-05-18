package com.scores365.api;
/* compiled from: ApiNextGame.kt */
/* loaded from: classes2.dex */
public final class a1 extends i {
    private final long E;
    private final String F;

    public a1(long j10, String nextGameUrl) {
        kotlin.jvm.internal.m.g(nextGameUrl, "nextGameUrl");
        this.E = j10;
        this.F = nextGameUrl;
    }

    @Override // com.scores365.api.i, com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder(this.F);
        if (this.E > 0) {
            sb2.append("&uid=");
            sb2.append(this.E);
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.m.f(sb3, "params.toString()");
        return sb3;
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
