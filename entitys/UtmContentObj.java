package com.scores365.entitys;

import com.facebook.share.internal.ShareConstants;
import java.io.Serializable;
/* compiled from: UtmContentObj.kt */
/* loaded from: classes2.dex */
public final class UtmContentObj implements Serializable {
    @p9.c(ShareConstants.FEED_SOURCE_PARAM)
    private final FacebookReferralSourceObj source;
    @p9.c("app")
    private final long app = -1;
    @p9.c("t")

    /* renamed from: t  reason: collision with root package name */
    private final long f23603t = -1;

    public final long getApp() {
        return this.app;
    }

    public final FacebookReferralSourceObj getSource() {
        return this.source;
    }

    public final long getT() {
        return this.f23603t;
    }

    public String toString() {
        return "Utm(app=" + this.app + ", t=" + this.f23603t + ", source=" + this.source + ')';
    }
}
