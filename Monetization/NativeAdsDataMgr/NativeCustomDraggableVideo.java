package com.scores365.Monetization.NativeAdsDataMgr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.scores365.DraggableView.ScoresDraggableView;
import kotlin.jvm.internal.m;
/* compiled from: NativeCustomDraggableVideo.kt */
/* loaded from: classes2.dex */
public final class NativeCustomDraggableVideo extends ScoresDraggableView {

    /* renamed from: g  reason: collision with root package name */
    private NativeCustomFormatAd f21098g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21099h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21100i;

    /* renamed from: j  reason: collision with root package name */
    private View.OnTouchListener f21101j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeCustomDraggableVideo(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m.g(context, "context");
        m.g(attrs, "attrs");
    }

    public final boolean getMinimized() {
        return this.f21100i;
    }

    public final View.OnTouchListener getTouchListener() {
        return this.f21101j;
    }

    public final void setMinimizeOnScroll(boolean z10) {
        this.f21099h = z10;
    }

    public final void setMinimized(boolean z10) {
        this.f21100i = z10;
    }

    public final void setMyTouchListener(View.OnTouchListener listener) {
        m.g(listener, "listener");
        this.f21101j = listener;
    }

    public final void setNativeCustomFormatAd(NativeCustomFormatAd ad2) {
        m.g(ad2, "ad");
        this.f21098g = ad2;
    }

    public final void setTouchListener(View.OnTouchListener onTouchListener) {
        this.f21101j = onTouchListener;
    }
}
