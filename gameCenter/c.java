package com.scores365.gameCenter;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.WidgetObj;
import com.scores365.ui.CustomGameCenterHeaderView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import xf.b;
/* compiled from: BetRadarMgr.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23717a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23718b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23719c = false;

    /* renamed from: d  reason: collision with root package name */
    private GameLoaderWebView f23720d = null;

    /* renamed from: e  reason: collision with root package name */
    private GameObj f23721e = null;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<ViewGroup> f23722f = null;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<b.a> f23723g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f23724h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f23725i = -1;

    private void d(ViewGroup viewGroup, int i10, int i11) {
        try {
            ImageView imageView = new ImageView(App.m());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l());
            if (i11 == 1) {
                int i12 = layoutParams.height;
                int i13 = this.f23725i;
                layoutParams.height = i12 + i13;
                layoutParams.topMargin -= i13;
            }
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(j(i10, this.f23724h));
            viewGroup.addView(imageView);
            View progressBar = new ProgressBar(App.m(), null, 16842873);
            progressBar.setBackgroundResource(R.drawable.f21790q);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(li.p0.s(30), li.p0.s(30));
            layoutParams2.addRule(13);
            progressBar.setLayoutParams(layoutParams2);
            viewGroup.addView(progressBar);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void e(ViewGroup viewGroup) {
        try {
            if (!this.f23719c) {
                p("load");
                this.f23719c = true;
            }
            this.f23722f = new WeakReference<>(viewGroup);
            f(viewGroup, true);
            this.f23720d.setWebViewListeners(m(this.f23721e.getLMTWidget(), this.f23721e.widgetProviders));
            this.f23718b = true;
            this.f23720d.e(this.f23721e, this.f23722f);
            new Handler().postDelayed(new Runnable() { // from class: com.scores365.gameCenter.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.o();
                }
            }, 0L);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void f(ViewGroup viewGroup, boolean z10) {
        if (this.f23720d == null) {
            this.f23720d = new GameLoaderWebView(viewGroup.getContext());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, l());
            if (this.f23724h == 1) {
                int i10 = marginLayoutParams.height;
                int i11 = this.f23725i;
                marginLayoutParams.height = i10 + i11;
                marginLayoutParams.topMargin = -i11;
            }
            this.f23720d.setLayoutParams(marginLayoutParams);
            this.f23720d.setKeepScreenOn(true);
        }
        if (this.f23720d.getParent() != null) {
            ((ViewGroup) this.f23720d.getParent()).removeAllViews();
        }
        viewGroup.removeAllViews();
        viewGroup.addView(this.f23720d);
        if (z10) {
            d(viewGroup, this.f23721e.getSportID(), this.f23724h);
        }
    }

    public static String i(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : "betradar-v3" : "betradar" : "opta";
    }

    private static int j(int i10, int i11) {
        int i12;
        int i13 = R.drawable.f21851x4;
        try {
            if (i11 == 1) {
                i12 = R.drawable.f21835v4;
            } else if (i10 == SportTypesEnum.SOCCER.getValue()) {
                if (i11 == 2) {
                    i12 = R.drawable.f21851x4;
                } else if (i11 != 3) {
                    return i13;
                } else {
                    i12 = R.drawable.f21830v;
                }
            } else if (i10 == SportTypesEnum.BASKETBALL.getValue()) {
                if (i11 == 2) {
                    i12 = R.drawable.f21811s4;
                } else if (i11 != 3) {
                    return i13;
                } else {
                    i12 = R.drawable.f21806s;
                }
            } else if (i10 == SportTypesEnum.HANDBALL.getValue()) {
                i12 = R.drawable.f21819t4;
            } else if (i10 == SportTypesEnum.HOCKEY.getValue()) {
                if (i11 == 2) {
                    i12 = R.drawable.f21827u4;
                } else if (i11 != 3) {
                    return i13;
                } else {
                    i12 = R.drawable.f21822u;
                }
            } else if (i10 == SportTypesEnum.RUGBY.getValue()) {
                i12 = R.drawable.f21843w4;
            } else if (i10 == SportTypesEnum.TENNIS.getValue()) {
                i12 = R.drawable.f21859y4;
            } else if (i10 == SportTypesEnum.VOLLEYBALL.getValue()) {
                i12 = R.drawable.f21867z4;
            } else if (i10 == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                i12 = R.drawable.f21814t;
            } else if (i10 != SportTypesEnum.BASEBALL.getValue()) {
                return i13;
            } else {
                i12 = R.drawable.f21798r;
            }
            i13 = i12;
            return i13;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return i13;
        }
    }

    public static int m(WidgetObj widgetObj, ArrayList<String> arrayList) {
        if (widgetObj != null) {
            try {
                if (widgetObj.getProvider() != null) {
                    if (widgetObj.getProvider().equalsIgnoreCase("OPTA_LAW")) {
                        return 1;
                    }
                    if (widgetObj.getProvider().equalsIgnoreCase("SportRadarLMT_V3")) {
                        return 3;
                    }
                    return widgetObj.getProvider().equalsIgnoreCase("BetRadar") ? 2 : 0;
                }
                return 0;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return 0;
            }
        }
        return 0;
    }

    private double n(WidgetObj widgetObj) {
        double d10 = 1.777d;
        try {
            if (widgetObj != null) {
                d10 = widgetObj.getWidgetRatio();
            } else if (this.f23724h == 2) {
                d10 = 2.25d;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        try {
            WeakReference<b.a> weakReference = this.f23723g;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f23723g.get().u(this.f23720d.getParent().getParent() instanceof ConstraintLayout ? ((int) ((RelativeLayout) ((ConstraintLayout) ((RelativeLayout) this.f23720d.getParent()).getParent()).getParent()).getY()) + ((int) ((RelativeLayout) this.f23720d.getParent()).getY()) : (int) ((RelativeLayout) ((RelativeLayout) this.f23720d.getParent()).getParent()).getY());
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[Catch: Exception -> 0x0098, TryCatch #2 {Exception -> 0x0098, blocks: (B:18:0x0055, B:20:0x005d, B:21:0x005f, B:17:0x0052), top: B:30:0x0052 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void p(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            r3 = -1
            com.scores365.entitys.GameObj r4 = r11.f23721e     // Catch: java.lang.Exception -> L50
            int r4 = r4.getID()     // Catch: java.lang.Exception -> L50
            com.scores365.entitys.InitObj r5 = com.scores365.App.l()     // Catch: java.lang.Exception -> L4e
            java.util.LinkedHashMap r5 = r5.getSportTypes()     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.GameObj r6 = r11.f23721e     // Catch: java.lang.Exception -> L4e
            int r6 = r6.getSportID()     // Catch: java.lang.Exception -> L4e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L4e
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.SportTypeObj r5 = (com.scores365.entitys.SportTypeObj) r5     // Catch: java.lang.Exception -> L4e
            java.util.LinkedHashMap r5 = r5.getStatuses()     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.GameObj r6 = r11.f23721e     // Catch: java.lang.Exception -> L4e
            int r6 = r6.getStID()     // Catch: java.lang.Exception -> L4e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L4e
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Exception -> L4e
            com.scores365.entitys.StatusObj r5 = (com.scores365.entitys.StatusObj) r5     // Catch: java.lang.Exception -> L4e
            boolean r6 = r5.getIsNotStarted()     // Catch: java.lang.Exception -> L4e
            if (r6 == 0) goto L3e
            r3 = 0
            goto L55
        L3e:
            boolean r6 = r5.getIsActive()     // Catch: java.lang.Exception -> L4e
            if (r6 == 0) goto L46
            r3 = 2
            goto L55
        L46:
            boolean r5 = r5.getIsFinished()     // Catch: java.lang.Exception -> L4e
            if (r5 == 0) goto L55
            r3 = 1
            goto L55
        L4e:
            r5 = move-exception
            goto L52
        L50:
            r5 = move-exception
            r4 = -1
        L52:
            li.x0.N1(r5)     // Catch: java.lang.Exception -> L98
        L55:
            java.lang.String r5 = "display"
            boolean r5 = r12.equals(r5)     // Catch: java.lang.Exception -> L98
            if (r5 == 0) goto L5f
            xf.b.f42251d = r2     // Catch: java.lang.Exception -> L98
        L5f:
            android.content.Context r5 = com.scores365.App.m()     // Catch: java.lang.Exception -> L98
            java.lang.String r6 = "gamecenter"
            java.lang.String r7 = "live-match-tracker"
            r8 = 0
            r9 = 6
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Exception -> L98
            java.lang.String r10 = "game_id"
            r9[r1] = r10     // Catch: java.lang.Exception -> L98
            java.lang.String r1 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L98
            r9[r2] = r1     // Catch: java.lang.Exception -> L98
            java.lang.String r1 = "status"
            r9[r0] = r1     // Catch: java.lang.Exception -> L98
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L98
            r1 = 3
            r9[r1] = r0     // Catch: java.lang.Exception -> L98
            java.lang.String r0 = "provider"
            r1 = 4
            r9[r1] = r0     // Catch: java.lang.Exception -> L98
            int r0 = r11.f23724h     // Catch: java.lang.Exception -> L98
            java.lang.String r0 = i(r0)     // Catch: java.lang.Exception -> L98
            r1 = 5
            r9[r1] = r0     // Catch: java.lang.Exception -> L98
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r12
            r4 = r8
            r5 = r9
            ee.k.o(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L98
            goto L9c
        L98:
            r12 = move-exception
            li.x0.N1(r12)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.c.p(java.lang.String):void");
    }

    public void b(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            try {
                if (viewGroup.getChildAt(i10) instanceof ImageView) {
                    viewGroup.getChildAt(i10).setVisibility(4);
                } else if (viewGroup.getChildAt(i10) instanceof ProgressBar) {
                    viewGroup.getChildAt(i10).setVisibility(4);
                }
                if (viewGroup.getChildAt(i10) instanceof WebView) {
                    viewGroup.getChildAt(i10).setVisibility(0);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000f, B:8:0x0015, B:14:0x0021, B:18:0x002e, B:20:0x0035, B:30:0x005a, B:32:0x005e, B:33:0x0062, B:35:0x0068, B:25:0x0049, B:27:0x0055), top: B:40:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000f, B:8:0x0015, B:14:0x0021, B:18:0x002e, B:20:0x0035, B:30:0x005a, B:32:0x005e, B:33:0x0062, B:35:0x0068, B:25:0x0049, B:27:0x0055), top: B:40:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062 A[Catch: Exception -> 0x006c, TryCatch #0 {Exception -> 0x006c, blocks: (B:2:0x0000, B:4:0x0009, B:6:0x000f, B:8:0x0015, B:14:0x0021, B:18:0x002e, B:20:0x0035, B:30:0x005a, B:32:0x005e, B:33:0x0062, B:35:0x0068, B:25:0x0049, B:27:0x0055), top: B:40:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(com.scores365.entitys.GameObj r6, android.view.ViewGroup r7, xf.b.a r8) {
        /*
            r5 = this;
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch: java.lang.Exception -> L6c
            r0.<init>(r8)     // Catch: java.lang.Exception -> L6c
            r5.f23723g = r0     // Catch: java.lang.Exception -> L6c
            if (r6 == 0) goto Le
            com.scores365.entitys.WidgetObj r8 = r6.getLMTWidget()     // Catch: java.lang.Exception -> L6c
            goto Lf
        Le:
            r8 = 0
        Lf:
            com.scores365.gameCenter.GameLoaderWebView r0 = r5.f23720d     // Catch: java.lang.Exception -> L6c
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            boolean r0 = r0.d()     // Catch: java.lang.Exception -> L6c
            if (r0 != 0) goto L1c
            goto L1e
        L1c:
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r8 == 0) goto L2d
            java.lang.String r8 = r8.getWidgetURL()     // Catch: java.lang.Exception -> L6c
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Exception -> L6c
            if (r8 != 0) goto L2d
            r8 = 1
            goto L2e
        L2d:
            r8 = 0
        L2e:
            r5.b(r7)     // Catch: java.lang.Exception -> L6c
            r5.f23724h = r1     // Catch: java.lang.Exception -> L6c
            if (r6 == 0) goto L41
            com.scores365.entitys.WidgetObj r3 = r6.getLMTWidget()     // Catch: java.lang.Exception -> L6c
            java.util.ArrayList<java.lang.String> r4 = r6.widgetProviders     // Catch: java.lang.Exception -> L6c
            int r3 = m(r3, r4)     // Catch: java.lang.Exception -> L6c
            r5.f23724h = r3     // Catch: java.lang.Exception -> L6c
        L41:
            if (r0 == 0) goto L47
            if (r8 == 0) goto L5a
        L45:
            r1 = 1
            goto L5a
        L47:
            if (r8 == 0) goto L5a
            com.scores365.entitys.GameObj r8 = r5.f23721e     // Catch: java.lang.Exception -> L6c
            int r8 = r8.getID()     // Catch: java.lang.Exception -> L6c
            int r3 = r6.getID()     // Catch: java.lang.Exception -> L6c
            if (r8 != r3) goto L45
            boolean r8 = r5.f23718b     // Catch: java.lang.Exception -> L6c
            if (r8 != 0) goto L5a
            goto L45
        L5a:
            r5.f23721e = r6     // Catch: java.lang.Exception -> L6c
            if (r1 == 0) goto L62
            r5.e(r7)     // Catch: java.lang.Exception -> L6c
            goto L70
        L62:
            int r6 = r7.getChildCount()     // Catch: java.lang.Exception -> L6c
            if (r6 != 0) goto L70
            r5.f(r7, r0)     // Catch: java.lang.Exception -> L6c
            goto L70
        L6c:
            r6 = move-exception
            li.x0.N1(r6)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.c.c(com.scores365.entitys.GameObj, android.view.ViewGroup, xf.b$a):void");
    }

    public void g() {
        try {
            this.f23720d = null;
            this.f23721e = null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            this.f23720d = null;
        }
    }

    public void h() {
        try {
            GameLoaderWebView gameLoaderWebView = this.f23720d;
            if (gameLoaderWebView != null) {
                gameLoaderWebView.f();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public int[] k() {
        int[] iArr = new int[2];
        try {
            iArr[0] = this.f23720d.getWidth();
            int height = this.f23720d.getHeight();
            iArr[1] = height;
            if (this.f23724h == 1) {
                iArr[1] = height - this.f23725i;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return iArr;
    }

    public int l() {
        int s10 = li.p0.s(CustomGameCenterHeaderView.IMAGE_SIZE);
        try {
            WidgetObj lMTWidget = this.f23721e.getLMTWidget();
            if (lMTWidget != null) {
                s10 = (int) (App.m().getResources().getDisplayMetrics().widthPixels / n(lMTWidget));
                if (this.f23724h == 1) {
                    int i10 = (int) (s10 * 0.15f);
                    this.f23725i = i10;
                    return s10 - i10;
                }
                return s10;
            }
            return s10;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return s10;
        }
    }
}
