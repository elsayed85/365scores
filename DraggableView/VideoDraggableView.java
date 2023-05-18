package com.scores365.DraggableView;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import cc.w0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.scores365.App;
import i4.b0;
import i4.f;
import i4.h;
import i4.i;
import i4.i0;
import i4.j0;
import i4.k;
import i4.x;
import i4.z;
import li.x0;
import v5.d;
import y5.n;
/* loaded from: classes2.dex */
public abstract class VideoDraggableView extends ScoresDraggableView implements AdEvent.AdEventListener, z.b {

    /* renamed from: g  reason: collision with root package name */
    private PlayerView f21051g;

    /* renamed from: h  reason: collision with root package name */
    private i0 f21052h;

    /* renamed from: i  reason: collision with root package name */
    private View.OnTouchListener f21053i;

    /* renamed from: j  reason: collision with root package name */
    private int f21054j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21055k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21056l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21057m;

    /* renamed from: n  reason: collision with root package name */
    b0.b f21058n;

    /* loaded from: classes2.dex */
    class a implements b0.b {
        a() {
        }

        @Override // i4.b0.b
        public void m(int i10, Object obj) {
            try {
                if (VideoDraggableView.this.f21054j < 4) {
                    long duration = VideoDraggableView.this.f21052h.getDuration();
                    VideoDraggableView.p(VideoDraggableView.this);
                    long j10 = (duration / 4) * VideoDraggableView.this.f21054j;
                    if (VideoDraggableView.this.f21054j < 4) {
                        VideoDraggableView.this.f21052h.o0(VideoDraggableView.this.f21058n).p(2).o(j10).m(new Handler()).l();
                    }
                    String str = VideoDraggableView.this.f21054j - 1 == 1 ? "0.25" : VideoDraggableView.this.f21054j - 1 == 2 ? "0.5" : VideoDraggableView.this.f21054j - 1 == 3 ? "0.75" : VideoDraggableView.this.f21054j - 1 == 4 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : null;
                    if (str != null) {
                        VideoDraggableView.this.H(str);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21060a;

        static {
            int[] iArr = new int[AdEvent.AdEventType.values().length];
            f21060a = iArr;
            try {
                iArr[AdEvent.AdEventType.SKIPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21060a[AdEvent.AdEventType.ALL_ADS_COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21060a[AdEvent.AdEventType.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VideoDraggableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21054j = 0;
        this.f21055k = false;
        this.f21056l = false;
        this.f21057m = false;
        this.f21058n = new a();
    }

    public VideoDraggableView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21054j = 0;
        this.f21055k = false;
        this.f21056l = false;
        this.f21057m = false;
        this.f21058n = new a();
    }

    private void I(@NonNull String str, @NonNull String str2, float f10) {
        try {
            Context context = getContext();
            f a10 = new f.a().b(new n(true, 16)).c(25000, 30000, ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION).e(50).d(true).a();
            G();
            i0 b10 = k.b(context, new h(context), new DefaultTrackSelector(), a10);
            this.f21052h = b10;
            b10.f(this);
            this.f21052h.x0(f10);
            FrameLayout frameLayout = new FrameLayout(context);
            PlayerView playerView = new PlayerView(context);
            this.f21051g = playerView;
            frameLayout.addView(playerView);
            addView(frameLayout);
            rb.b.f37438a.c(context, this.f21052h, this.f21051g, str, str2, this);
            this.f21052h.l(true);
            this.f21051g.setPlayer(this.f21052h);
            this.f21051g.setControllerHideDuringAds(true);
            this.f21051g.setUseController(false);
            View videoSurfaceView = this.f21051g.getVideoSurfaceView();
            videoSurfaceView.setOnTouchListener(this.f21053i);
            videoSurfaceView.setDuplicateParentStateEnabled(true);
            r(frameLayout);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    static /* synthetic */ int p(VideoDraggableView videoDraggableView) {
        int i10 = videoDraggableView.f21054j;
        videoDraggableView.f21054j = i10 + 1;
        return i10;
    }

    protected void A() {
    }

    public boolean B() {
        try {
            return this.f21052h != null;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // i4.z.b
    public void B0() {
    }

    public boolean C() {
        return this.f21055k;
    }

    public void D(@NonNull String str, @NonNull String str2, float f10) {
        try {
            if (t()) {
                this.f21057m = true;
                w0.f();
                w0.v();
                I(str, str2, f10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void E() {
        try {
            if (this.f21052h != null) {
                x0.E1("topFloatingVideoBug", "pausePlayer");
                this.f21052h.l(false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void E0(TrackGroupArray trackGroupArray, d dVar) {
    }

    public void F() {
        try {
            if (this.f21052h != null) {
                x0.E1("topFloatingVideoBug", "playPlayer");
                this.f21052h.l(true);
                setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        i0 i0Var = this.f21052h;
        if (i0Var != null) {
            i0Var.r0();
            setOnTouchListener(null);
        }
        this.f21052h = null;
    }

    protected void H(String str) {
        try {
            Context m10 = App.m();
            String[] strArr = new String[14];
            strArr[0] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[1] = "dashboard";
            strArr[2] = "mode";
            strArr[3] = ob.a.l() ? "branded" : "non-branded";
            strArr[4] = "type_of_click";
            strArr[5] = "autoplay";
            strArr[6] = "screen";
            strArr[7] = "my-scores";
            strArr[8] = "is_muted";
            strArr[9] = this.f21052h.getVolume() == 0.0f ? "mute" : "unmute";
            strArr[10] = "duration";
            strArr[11] = String.valueOf(this.f21052h.getDuration() / 1000);
            strArr[12] = "time_seen";
            strArr[13] = str;
            ee.k.n(m10, "365tv", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "seen", null, false, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean J() {
        return this.f21057m;
    }

    @Override // i4.z.b
    public void L0(j0 j0Var, Object obj, int i10) {
    }

    @Override // i4.z.b
    public void P0(boolean z10, int i10) {
        try {
            x0.E1("topFloatingVideoBug", "onPlayerStateChanged. playWhenReady: " + z10 + " state: " + i10);
            if (i10 == 1) {
                z();
            }
            if (i10 == 4) {
                y();
            }
            if (i10 == 3 && z10) {
                A();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void R0(i iVar) {
    }

    @Override // i4.z.b
    public void b(x xVar) {
    }

    @Override // i4.z.b
    public void e(boolean z10) {
    }

    public i0 getPlayer() {
        return this.f21052h;
    }

    public PlayerView getPlayerView() {
        return this.f21051g;
    }

    @Override // com.scores365.DraggableView.ScoresDraggableView
    public void h() {
        super.h();
        try {
            setVisibility(8);
            i0 i0Var = this.f21052h;
            if (i0Var != null) {
                i0Var.r0();
            }
            this.f21052h = null;
            if (getParent() != null) {
                ((ViewManager) getParent()).removeView(this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void l(boolean z10) {
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
    public void onAdEvent(AdEvent adEvent) {
        try {
            int i10 = b.f21060a[adEvent.getType().ordinal()];
            if (i10 == 1) {
                try {
                    setSkipped(true);
                    w();
                    return;
                } catch (Exception e10) {
                    x0.N1(e10);
                    return;
                }
            } else if (i10 == 2) {
                try {
                    this.f21056l = true;
                    if (C()) {
                        setSkipped(false);
                    } else {
                        u();
                    }
                    return;
                } catch (Exception e11) {
                    x0.N1(e11);
                    return;
                }
            } else if (i10 != 3) {
                return;
            } else {
                try {
                    FrameLayout overlayFrameLayout = this.f21051g.getOverlayFrameLayout();
                    if (overlayFrameLayout.getChildCount() > 0) {
                        overlayFrameLayout.getChildAt(0).setOnTouchListener(this.f21053i);
                    }
                    x(this.f21052h);
                    return;
                } catch (Exception e12) {
                    x0.N1(e12);
                    return;
                }
            }
        } catch (Exception e13) {
            x0.N1(e13);
        }
        x0.N1(e13);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.DraggableView.ScoresDraggableView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            setAlpha(0.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void onRepeatModeChanged(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(FrameLayout frameLayout) {
    }

    public boolean s() {
        return this.f21056l;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f21053i = onTouchListener;
    }

    public void setSkipped(boolean z10) {
        this.f21055k = z10;
    }

    public abstract boolean t();

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
    }

    @Override // i4.z.b
    public void v(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(@NonNull i0 i0Var) {
    }

    protected void y() {
    }

    protected void z() {
    }
}
