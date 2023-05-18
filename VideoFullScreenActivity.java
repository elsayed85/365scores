package com.scores365;

import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.scores365.Design.Activities.c;
import com.scores365.Pages.f;
import com.scores365.VideoFullScreenActivity;
import d5.o;
import i4.f;
import i4.h;
import i4.i;
import i4.i0;
import i4.j0;
import i4.k;
import i4.x;
import i4.z;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import li.x0;
import li.z;
import v5.d;
import y5.n;
import y5.r;
/* loaded from: classes2.dex */
public class VideoFullScreenActivity extends c implements MediaController.MediaPlayerControl, z.a, z.b {
    i0 F;
    PlayerView G;
    Handler H;
    public long I;

    /* renamed from: b0  reason: collision with root package name */
    ImageView f22869b0;

    /* renamed from: f0  reason: collision with root package name */
    ImageView f22870f0;

    /* renamed from: g0  reason: collision with root package name */
    ImageView f22871g0;

    /* renamed from: h0  reason: collision with root package name */
    ImageView f22872h0;

    /* renamed from: i0  reason: collision with root package name */
    ProgressBar f22873i0;

    /* renamed from: j0  reason: collision with root package name */
    TextView f22874j0;

    /* renamed from: k0  reason: collision with root package name */
    ConstraintLayout f22875k0;

    /* renamed from: l0  reason: collision with root package name */
    View f22876l0;

    /* renamed from: m0  reason: collision with root package name */
    View f22877m0;

    /* renamed from: p0  reason: collision with root package name */
    private Timer f22880p0;

    /* renamed from: q0  reason: collision with root package name */
    private li.z f22881q0;

    /* renamed from: s0  reason: collision with root package name */
    a f22883s0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f22878n0 = false;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f22879o0 = true;

    /* renamed from: r0  reason: collision with root package name */
    Handler f22882r0 = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<VideoFullScreenActivity> f22884a;

        public a(VideoFullScreenActivity videoFullScreenActivity) {
            this.f22884a = new WeakReference<>(videoFullScreenActivity);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeakReference<VideoFullScreenActivity> weakReference = this.f22884a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f22884a.get().q1();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        PlayerView f22885a;

        /* renamed from: b  reason: collision with root package name */
        TextView f22886b;

        /* renamed from: c  reason: collision with root package name */
        Handler f22887c;

        /* renamed from: d  reason: collision with root package name */
        long f22888d;

        public b(PlayerView playerView, TextView textView, Handler handler, long j10) {
            this.f22885a = playerView;
            this.f22886b = textView;
            this.f22887c = handler;
            this.f22888d = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    String videoPositionText = f.getVideoPositionText(this.f22888d - this.f22885a.getPlayer().getCurrentPosition());
                    this.f22886b.invalidate();
                    this.f22886b.setText(videoPositionText);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                if (this.f22886b == null || (handler = this.f22887c) == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: nb.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoFullScreenActivity.b.this.b();
                    }
                });
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void C1() {
        try {
            Timer timer = this.f22880p0;
            if (timer != null) {
                timer.cancel();
                this.f22880p0.purge();
                this.f22880p0 = null;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initViews() {
        try {
            this.f22875k0 = (ConstraintLayout) findViewById(R.id.SH);
            this.f22874j0 = (TextView) findViewById(R.id.RH);
            this.f22869b0 = (ImageView) findViewById(R.id.f22315tc);
            this.f22877m0 = findViewById(R.id.f22436z1);
            this.f22876l0 = findViewById(R.id.A1);
            this.f22870f0 = (ImageView) findViewById(R.id.I1);
            this.f22871g0 = (ImageView) findViewById(R.id.H1);
            this.f22872h0 = (ImageView) findViewById(R.id.f22108k4);
            this.f22873i0 = (ProgressBar) findViewById(R.id.Lj);
            y1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void m1() {
        try {
            if (getIntent() != null && getIntent().getExtras() != null) {
                if (getIntent().getExtras().getBoolean("shouldDelayOrientationManager", false)) {
                    new Handler().postDelayed(new Runnable() { // from class: nb.f0
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoFullScreenActivity.this.r1();
                        }
                    }, 5000L);
                } else {
                    this.f22881q0.enable();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void o1(long j10, boolean z10, String str, long j11) {
        try {
            this.H = new Handler();
            this.G = (PlayerView) findViewById(R.id.Wj);
            boolean z11 = true;
            i0 b10 = k.b(App.m(), new h(App.m()), new DefaultTrackSelector(), new f.a().b(new n(true, 16)).c(25000, 30000, ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION).e(50).d(true).a());
            this.F = b10;
            this.G.setPlayer(b10);
            this.F.n(new o.b(new r(this, a6.i0.M(this, App.m().getString(R.string.f22812a)))).O(Uri.parse(str)));
            this.F.setRepeatMode(2);
            this.F.seekTo(j10);
            this.F.f(this);
            this.F.x0(0.0f);
            this.f22870f0.setImageResource(R.drawable.f21841w2);
            if (!com.scores365.Pages.f.isMuted() && ((AudioManager) getSystemService("audio")).requestAudioFocus(null, 3, 1) == 1) {
                this.F.x0(1.0f);
                this.f22870f0.setImageResource(R.drawable.J3);
            }
            if (z10) {
                z11 = false;
            }
            z1(z11);
            if (z10) {
                this.f22872h0.setVisibility(0);
            } else {
                this.f22872h0.setVisibility(8);
            }
            Timer timer = new Timer();
            this.f22880p0 = timer;
            timer.schedule(new b(this.G, this.f22874j0, new Handler(), j11), 0L, 1000L);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1() {
        try {
            li.z zVar = this.f22881q0;
            if (zVar != null) {
                zVar.enable();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(View view) {
        x1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(View view) {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(View view) {
        B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(View view) {
        try {
            if (this.f22879o0) {
                z1(false);
            } else {
                z1(true);
                this.f22872h0.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void x1() {
        try {
            if (com.scores365.Pages.f.isMuted()) {
                com.scores365.Pages.f.setIsMuted(false);
                this.f22870f0.setImageResource(R.drawable.J3);
                if (com.scores365.Pages.f.tryToTurnOnSound()) {
                    this.F.x0(1.0f);
                }
            } else {
                com.scores365.Pages.f.setIsMuted(true);
                this.f22870f0.setImageResource(R.drawable.f21841w2);
                this.F.x0(0.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void y1() {
        try {
            ImageView imageView = this.f22870f0;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: nb.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoFullScreenActivity.this.s1(view);
                    }
                });
            }
            ImageView imageView2 = this.f22871g0;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: nb.h0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoFullScreenActivity.this.t1(view);
                    }
                });
            }
            View view = this.f22877m0;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: nb.i0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        VideoFullScreenActivity.this.u1(view2);
                    }
                });
            }
            View view2 = this.f22876l0;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: nb.j0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        VideoFullScreenActivity.this.v1(view3);
                    }
                });
            }
            ImageView imageView3 = this.f22869b0;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: nb.k0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        VideoFullScreenActivity.this.w1(view3);
                    }
                });
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void A1() {
        try {
            this.f22878n0 = true;
            this.f22877m0.setVisibility(0);
            this.f22871g0.setVisibility(0);
            if (this.f22873i0.getVisibility() == 8) {
                this.f22869b0.setVisibility(0);
            }
            a aVar = new a(this);
            this.f22883s0 = aVar;
            this.f22882r0.postDelayed(aVar, 3000L);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void B0() {
    }

    public void B1() {
        try {
            if (this.f22878n0) {
                q1();
            } else {
                A1();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void E0(TrackGroupArray trackGroupArray, d dVar) {
    }

    @Override // i4.z.b
    public void L0(j0 j0Var, Object obj, int i10) {
    }

    @Override // i4.z.b
    public void P0(boolean z10, int i10) {
        try {
            if (i10 == 2) {
                this.f22873i0.setVisibility(0);
            } else {
                this.f22873i0.setVisibility(8);
                if (this.f22878n0) {
                    this.f22869b0.setVisibility(0);
                }
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

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    @Override // i4.z.b
    public void e(boolean z10) {
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return 0;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return false;
    }

    @Override // i4.z.b
    public void l(boolean z10) {
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            C1();
            Intent intent = new Intent();
            intent.putExtra("PositionInVideo", this.G.getPlayer().getCurrentPosition());
            intent.putExtra("isPaused", !this.G.getPlayer().C());
            setResult(1, intent);
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (x0.l1()) {
                setContentView(R.layout.Za);
            } else {
                setContentView(R.layout.Ya);
            }
            try {
                initActionBar(false);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            initViews();
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("url");
            long j10 = extras.getLong("PositionInVideo");
            long j11 = 0;
            if (extras.getLong("videoDuration") >= 0) {
                j11 = extras.getLong("videoDuration");
            }
            boolean z10 = extras.getBoolean("isPaused", false);
            this.I = extras.getInt("itemID");
            this.f22874j0.setText(com.scores365.Pages.f.getVideoPositionText(j11 - j10));
            o1(j10, z10, string, j11);
            this.f22882r0 = new Handler();
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            setRequestedOrientation(1);
            li.z zVar = this.f22881q0;
            if (zVar != null) {
                zVar.b(null);
                this.f22881q0.a();
            }
            this.f22881q0 = null;
            this.F.r0();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // li.z.a
    public void onOrientationChange(z.c cVar) {
        try {
            if (cVar == z.c.PORTRAIT) {
                onBackPressed();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // i4.z.b
    public void onRepeatModeChanged(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            this.f22881q0 = new li.z(App.m(), this);
            if (!App.f20803w) {
                m1();
            }
            try {
                if (this.f22879o0) {
                    this.F.l(true);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            this.F.r0();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
    }

    public void q1() {
        try {
            this.f22878n0 = false;
            this.f22877m0.setVisibility(4);
            this.f22869b0.setVisibility(4);
            this.f22871g0.setVisibility(4);
            Handler handler = this.f22882r0;
            if (handler != null) {
                handler.removeCallbacks(this.f22883s0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i10) {
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
    }

    @Override // i4.z.b
    public void v(int i10) {
    }

    public void z1(boolean z10) {
        this.f22879o0 = z10;
        try {
            this.F.l(z10);
            if (z10) {
                this.f22869b0.setImageResource(R.drawable.G2);
            } else {
                this.f22869b0.setImageResource(R.drawable.H2);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
