package com.scores365.Design.Activities;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.a0;
import cc.o0;
import cc.r;
import cc.v0;
import cc.z;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.scores365.App;
import com.scores365.Design.Activities.g;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.entitys.BottomNavigationMenuItem;
import com.scores365.removeAds.RemoveAdsManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lf.t;
import li.p0;
import li.u;
import li.x0;
import sc.i;
import sc.k;
import xe.j;
import xe.q;
/* compiled from: BottomNavigationActivity.java */
/* loaded from: classes2.dex */
public abstract class f extends com.scores365.Design.Activities.c implements com.scores365.Design.Activities.g {
    protected RelativeLayout G;
    protected RelativeLayout H;
    protected FrameLayout I;

    /* renamed from: b0  reason: collision with root package name */
    public BottomNavigationView f20869b0;

    /* renamed from: f0  reason: collision with root package name */
    protected View f20870f0;

    /* renamed from: g0  reason: collision with root package name */
    public ArrayList<BottomNavigationMenuItem> f20871g0;

    /* renamed from: i0  reason: collision with root package name */
    public RelativeLayout f20873i0;

    /* renamed from: p0  reason: collision with root package name */
    protected int f20880p0;
    private final g.a F = new g.a(0.0f, 0.0f);

    /* renamed from: h0  reason: collision with root package name */
    private long f20872h0 = 50;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f20874j0 = false;

    /* renamed from: k0  reason: collision with root package name */
    protected boolean f20875k0 = true;

    /* renamed from: l0  reason: collision with root package name */
    protected boolean f20876l0 = false;

    /* renamed from: m0  reason: collision with root package name */
    protected boolean f20877m0 = false;

    /* renamed from: n0  reason: collision with root package name */
    protected App.c f20878n0 = null;

    /* renamed from: o0  reason: collision with root package name */
    protected int f20879o0 = -1;

    /* renamed from: q0  reason: collision with root package name */
    private final BottomNavigationView.b f20881q0 = new b();

    /* renamed from: r0  reason: collision with root package name */
    public BottomNavigationView.c f20882r0 = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f20883a;

        a(ViewTreeObserver viewTreeObserver) {
            this.f20883a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                int visibility = f.this.f20873i0.getVisibility();
                if (((Integer) f.this.f20873i0.getTag()).intValue() != visibility) {
                    if (this.f20883a.isAlive()) {
                        this.f20883a.removeOnGlobalLayoutListener(this);
                    }
                    RelativeLayout relativeLayout = f.this.f20873i0;
                    relativeLayout.setTag(Integer.valueOf(relativeLayout.getVisibility()));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) f.this.I.getLayoutParams();
                    if (visibility == 0) {
                        marginLayoutParams.bottomMargin = (int) App.m().getResources().getDimension(R.dimen.f21638c);
                    } else {
                        marginLayoutParams.bottomMargin = 0;
                    }
                }
            } catch (Resources.NotFoundException e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    class b implements BottomNavigationView.b {
        b() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.b
        public void a(@NonNull MenuItem menuItem) {
            try {
                f.this.y1(menuItem);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    class c implements BottomNavigationView.c {
        c() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean a(@NonNull MenuItem menuItem) {
            Fragment currentFragment = f.this.getCurrentFragment();
            Fragment x12 = f.this.x1(menuItem);
            if (x12 != null) {
                try {
                    if (f.this.u1(menuItem)) {
                        for (int i10 = 0; i10 < f.this.f20869b0.getMenu().size() && !p0.d.f(f.this.f20869b0, i10); i10++) {
                        }
                        Iterator<BottomNavigationMenuItem> it = f.this.f20871g0.iterator();
                        int i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (menuItem.getItemId() == it.next().f23583id) {
                                p0.d.b(f.this.f20869b0, i11);
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    f fVar = f.this;
                    if (fVar.f20875k0 || !fVar.getSupportFragmentManager().v0().contains(x12)) {
                        a0 b10 = f.this.getSupportFragmentManager().q().b(R.id.f21973e4, x12);
                        if (x12 instanceof xe.b) {
                            b10.g(null);
                        }
                        b10.w(x12).h();
                    }
                    f.this.getSupportFragmentManager().q().w(x12).h();
                    for (Fragment fragment : f.this.getSupportFragmentManager().v0()) {
                        if (fragment != x12) {
                            f.this.getSupportFragmentManager().q().n(fragment).h();
                        }
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
            f.this.L1(x12);
            f.this.J1(x12, currentFragment);
            f.this.f20869b0.setTranslationY(0.0f);
            f.this.f20870f0.setTranslationY(0.0f);
            if (x12 != null) {
                for (int i12 = 0; i12 < f.this.f20869b0.getMenu().size(); i12++) {
                    MenuItem item = f.this.f20869b0.getMenu().getItem(i12);
                    f.this.R1(item, item.getItemId() == menuItem.getItemId());
                }
            }
            if (f.this.f20880p0 > -1) {
                try {
                    new Handler().postDelayed(new g(f.this), 500L);
                } catch (Exception e11) {
                    x0.N1(e11);
                }
            }
            return x12 != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    public static class d implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<f> f20887a;

        public d(f fVar) {
            this.f20887a = new WeakReference<>(fVar);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            try {
                WeakReference<f> weakReference = this.f20887a;
                if (weakReference == null || weakReference.get() == null) {
                    return true;
                }
                this.f20887a.get().z1();
                return true;
            } catch (Exception e10) {
                x0.N1(e10);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    public static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<f> f20888a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f20889b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f20890c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f20891d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f20892e;

        public e(f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            this.f20888a = new WeakReference<>(fVar);
            this.f20889b = z10;
            this.f20890c = z11;
            this.f20891d = z12;
            this.f20892e = z13;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = this.f20888a.get();
                if (fVar != null) {
                    new Thread(new RunnableC0229f(fVar, this.f20889b, this.f20890c, this.f20891d, this.f20892e, null)).start();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: BottomNavigationActivity.java */
    /* renamed from: com.scores365.Design.Activities.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class RunnableC0229f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<f> f20893a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f20894b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f20895c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f20896d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f20897e;

        private RunnableC0229f(f fVar, boolean z10, boolean z11, boolean z12, boolean z13) {
            this.f20893a = new WeakReference<>(fVar);
            this.f20894b = z10;
            this.f20895c = z11;
            this.f20896d = z12;
            this.f20897e = z13;
        }

        /* synthetic */ RunnableC0229f(f fVar, boolean z10, boolean z11, boolean z12, boolean z13, a aVar) {
            this(fVar, z10, z11, z12, z13);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                f fVar = this.f20893a.get();
                if (fVar != null) {
                    if (this.f20897e || !x0.q2()) {
                        fVar.runOnUiThread(new h(fVar, fVar.q1(false), this.f20894b, this.f20895c, this.f20896d, false));
                        return;
                    }
                    if (fVar.q1(true)) {
                        fVar.runOnUiThread(new h(fVar, true, this.f20894b, this.f20895c, this.f20896d, true));
                    }
                    try {
                        boolean q12 = fVar.q1(false);
                        boolean z11 = this.f20894b;
                        boolean z12 = this.f20895c;
                        if (!q12 && !this.f20896d) {
                            z10 = false;
                            fVar.runOnUiThread(new h(fVar, q12, z11, z12, z10, false));
                        }
                        z10 = true;
                        fVar.runOnUiThread(new h(fVar, q12, z11, z12, z10, false));
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    public static class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<f> f20898a;

        public g(f fVar) {
            this.f20898a = new WeakReference<>(fVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeakReference<f> weakReference = this.f20898a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f20898a.get().N1();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: BottomNavigationActivity.java */
    /* loaded from: classes2.dex */
    private static class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<f> f20899a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f20900b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f20901c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f20902d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f20903e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f20904f;

        public h(f fVar, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.f20899a = new WeakReference<>(fVar);
            this.f20900b = z10;
            this.f20901c = z11;
            this.f20902d = z12;
            this.f20903e = z13;
            this.f20904f = z14;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = this.f20899a.get();
                if (fVar != null && !fVar.isDestroyed()) {
                    if (fVar.f20876l0 && this.f20904f) {
                        return;
                    }
                    if (!this.f20904f && this.f20900b) {
                        fVar.f20876l0 = true;
                    }
                    if (this.f20902d) {
                        fVar.Q1();
                        return;
                    } else if (!this.f20900b) {
                        if (fVar.f20872h0 < TimeUnit.SECONDS.toMillis(4L)) {
                            f.h1(fVar, 2L);
                        }
                        fVar.F1();
                        return;
                    } else {
                        fVar.B1(fVar.t1(), this.f20901c);
                        fVar.m1(false);
                        if (this.f20903e && (fVar instanceof MainDashboardActivity) && ((MainDashboardActivity) fVar).k2() != null) {
                            ((j) ((MainDashboardActivity) fVar).k2()).m3(false, this.f20904f);
                        }
                        if (!(fVar instanceof MainDashboardActivity) || ((MainDashboardActivity) fVar).k2() == null) {
                            return;
                        }
                        if (this.f20904f) {
                            ((j) ((MainDashboardActivity) fVar).k2()).D2();
                            return;
                        } else {
                            ((j) ((MainDashboardActivity) fVar).k2()).n3();
                            return;
                        }
                    }
                }
                ng.a.f35508a.a("BottomNavigation", "bottom navigation already destroyed", null);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1(MenuItem menuItem, boolean z10) {
        try {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.G0) {
                if (z10) {
                    menuItem.setIcon(R.drawable.f21674b3);
                } else {
                    menuItem.setIcon(R.drawable.f21666a3);
                }
            } else if (itemId == R.id.f22391x0) {
                if (z10) {
                    menuItem.setIcon(R.drawable.f21793q2);
                } else {
                    menuItem.setIcon(R.drawable.f21785p2);
                }
            } else if (itemId == R.id.f22303t0) {
                if (z10) {
                    menuItem.setIcon(R.drawable.f21802r3);
                } else {
                    menuItem.setIcon(R.drawable.f21794q3);
                }
            } else if (itemId == R.id.A0) {
                if (z10) {
                    menuItem.setIcon(R.drawable.f21817t2);
                } else {
                    menuItem.setIcon(R.drawable.f21809s2);
                }
            } else if (itemId == R.id.f22281s0) {
                if (z10) {
                    if (com.scores365.tournamentPromotion.a.f24323d == null) {
                        com.scores365.tournamentPromotion.a.f24323d = new BitmapDrawable(App.m().getResources(), u.u(Uri.parse(com.scores365.tournamentPromotion.a.j().d().b())));
                    }
                    menuItem.setIcon(com.scores365.tournamentPromotion.a.f24323d);
                    return;
                }
                if (com.scores365.tournamentPromotion.a.f24322c == null) {
                    com.scores365.tournamentPromotion.a.f24322c = new BitmapDrawable(App.m().getResources(), u.u(Uri.parse(com.scores365.tournamentPromotion.a.j().d().h())));
                }
                menuItem.setIcon(com.scores365.tournamentPromotion.a.f24322c);
            } else if (itemId == R.id.K0) {
                if (z10) {
                    menuItem.setIcon(v0.f10102c);
                } else {
                    menuItem.setIcon(v0.f10103d);
                }
            } else if (itemId == R.id.qq) {
                if (z10) {
                    menuItem.setIcon(v0.f10102c);
                } else {
                    menuItem.setIcon(v0.f10103d);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    static /* synthetic */ long h1(f fVar, long j10) {
        long j11 = fVar.f20872h0 * j10;
        fVar.f20872h0 = j11;
        return j11;
    }

    private void o1(List<Integer> list) {
        for (Integer num : list) {
            this.f20869b0.findViewById(num.intValue()).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.scores365.Design.Activities.e
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean w12;
                    w12 = f.w1(view);
                    return w12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean w1(View view) {
        return true;
    }

    protected void A1() {
    }

    protected void B1(ArrayList<BottomNavigationMenuItem> arrayList, boolean z10) {
        try {
            this.f20871g0 = arrayList;
            this.f20869b0.getMenu().clear();
            this.f20880p0 = -1;
            ArrayList arrayList2 = new ArrayList();
            Iterator<BottomNavigationMenuItem> it = arrayList.iterator();
            int i10 = 0;
            int i11 = -1;
            while (it.hasNext()) {
                BottomNavigationMenuItem next = it.next();
                arrayList2.add(Integer.valueOf(next.f23583id));
                int i12 = next.icon;
                if (i12 == -711986) {
                    this.f20869b0.getMenu().add(0, next.f23583id, next.order, next.title).setIcon(v0.f10102c).setShowAsAction(2);
                } else if (i12 == -711987) {
                    if (com.scores365.tournamentPromotion.a.f24323d != null && com.scores365.tournamentPromotion.a.f24322c != null) {
                        this.f20869b0.getMenu().add(0, next.f23583id, next.order, next.title).setIcon(com.scores365.tournamentPromotion.a.f24322c).setShowAsAction(2);
                        this.f20880p0 = i10;
                    }
                } else if (i12 == -711985) {
                    this.f20869b0.getMenu().add(0, next.f23583id, next.order, next.title).setIcon(v0.f10103d).setShowAsAction(2);
                } else if (next.f23583id == t.BETTING_FIFTH_BTN.getValue()) {
                    this.f20869b0.getMenu().add(0, next.f23583id, next.order, next.title).setIcon(le.b.f34226a.b()).setShowAsAction(2);
                } else {
                    this.f20869b0.getMenu().add(0, next.f23583id, next.order, next.title).setIcon(next.icon).setShowAsAction(2);
                }
                if (z10) {
                    p0.d.f(this.f20869b0, i10);
                }
                if (i11 == -1) {
                    i11 = next.f23583id;
                }
                i10++;
            }
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                p0.d.g(this.f20869b0, i13);
                if (arrayList.get(i13).isBadgeVisible()) {
                    p0.d.a(this.f20869b0, i13, arrayList.get(i13));
                }
            }
            N1();
            p0.d.e(this.f20869b0);
            p0.d.c(this.f20869b0);
            this.f20869b0.setOnNavigationItemSelectedListener(this.f20882r0);
            this.f20869b0.setOnNavigationItemReselectedListener(this.f20881q0);
            o1(arrayList2);
            A1();
            k1();
            m1(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void C1() {
        E1(false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D1(boolean z10, boolean z11, boolean z12) {
        E1(z10, z11, z12, true);
    }

    protected void E1(boolean z10, boolean z11, boolean z12, boolean z13) {
        try {
            new Handler().postDelayed(new e(this, z10, z11, z12, z13), this.f20872h0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void F1() {
        E1(false, false, false, true);
    }

    protected void G1() {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ln);
            this.f20873i0 = relativeLayout;
            relativeLayout.setTag(Integer.valueOf(relativeLayout.getVisibility()));
            ViewTreeObserver viewTreeObserver = this.f20873i0.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new a(viewTreeObserver));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public ViewGroup GetBannerHolderView() {
        return this.f20873i0;
    }

    protected void H1() {
        try {
            this.f20869b0 = (BottomNavigationView) findViewById(R.id.C0);
            this.f20870f0 = findViewById(R.id.Kr);
            this.f20869b0.setItemIconTintList(null);
            this.f20869b0.setItemIconSize(p0.s(40));
            e1.C0(this.f20869b0, 8.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void I1() {
        try {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Fn);
            this.G = relativeLayout;
            if (relativeLayout != null) {
                e1.I0(relativeLayout, 0);
            }
            this.H = (RelativeLayout) findViewById(R.id.Jn);
            this.I = (FrameLayout) findViewById(R.id.f21973e4);
            G1();
            H1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void J1(Fragment fragment, Fragment fragment2) {
        try {
            if (RemoveAdsManager.isUserAdsRemoved(App.m()) || z.b()) {
                return;
            }
            boolean z10 = true ^ (fragment instanceof xe.b);
            if ((!(fragment2 instanceof xe.b)) != z10) {
                M1(z10);
                if (z10 && (fragment instanceof q)) {
                    q qVar = (q) fragment;
                    this.f20878n0 = qVar.Y1();
                    this.f20879o0 = qVar.W1();
                }
                e1();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void K1() {
        try {
            if (this.f20869b0 == null || p0.A0(1700) >= p0.A0((int) this.f20869b0.getY())) {
                return;
            }
            this.f20869b0.setTranslationY(0.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void L1(Fragment fragment) {
        try {
            if (!RemoveAdsManager.isUserAdsRemoved(App.m()) && (fragment instanceof cc.e1)) {
                if (getCurrBanner() == null || !((cc.e1) fragment).isBannerNeedToBeVisible()) {
                    this.f20873i0.setVisibility(8);
                } else {
                    this.f20873i0.setVisibility(0);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void M1(boolean z10) {
        this.f20877m0 = z10;
    }

    protected void N1() {
        try {
            if (this.f20880p0 > -1) {
                ((com.google.android.material.bottomnavigation.a) ((com.google.android.material.bottomnavigation.b) this.f20869b0.getChildAt(0)).getChildAt(this.f20880p0)).setOnLongClickListener(new d(this));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void O1() {
        setContentView(R.layout.f22627n0);
    }

    protected boolean P1() {
        return true;
    }

    protected abstract void Q1();

    protected void e1() {
        k n10;
        i placement = getPlacement();
        if (placement == null || RemoveAdsManager.isUserAdsRemoved(this) || (n10 = o0.n(placement)) == null || n10 == k.Native) {
            return;
        }
        r.l(this, this);
    }

    protected Fragment getCurrentFragment() {
        try {
            for (Fragment fragment : getSupportFragmentManager().v0()) {
                if (fragment.isVisible()) {
                    return fragment;
                }
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public boolean isBannerNeedToBeShown() {
        return true;
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public boolean isBannerNeedToBeVisible() {
        try {
            Fragment i02 = getSupportFragmentManager().i0(R.id.f21973e4);
            if (i02 == null) {
                return true;
            }
            if (i02 instanceof cc.e1) {
                return ((cc.e1) i02).isBannerNeedToBeVisible();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    protected void k1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m1(boolean z10) {
        try {
            RelativeLayout relativeLayout = this.H;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(z10 ? 0 : 8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            O1();
            I1();
            m1(true);
            if (P1()) {
                C1();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.g
    public g.a onPageScroll(int i10) {
        try {
            float f10 = 0.0f;
            this.F.d(0.0f);
            this.F.c(0.0f);
            float translationY = this.f20869b0.getTranslationY() + i10;
            if (translationY > this.f20869b0.getHeight()) {
                f10 = this.f20869b0.getHeight();
            } else if (translationY >= 0.0f) {
                f10 = translationY;
            }
            this.f20869b0.setTranslationY(f10);
            this.f20870f0.setTranslationY(f10);
            this.F.c(f10);
            ViewGroup GetBannerHolderView = GetBannerHolderView();
            if (GetBannerHolderView != null) {
                GetBannerHolderView.setTranslationY(f10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            e1();
            this.f20869b0.setTranslationY(0.0f);
            this.f20870f0.setTranslationY(0.0f);
            ViewGroup GetBannerHolderView = GetBannerHolderView();
            if (GetBannerHolderView != null) {
                GetBannerHolderView.setTranslationY(0.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected boolean q1(boolean z10) {
        return true;
    }

    public int r1() {
        return this.f20879o0;
    }

    public App.c s1() {
        return this.f20878n0;
    }

    protected abstract ArrayList<BottomNavigationMenuItem> t1();

    protected boolean u1(MenuItem menuItem) {
        return true;
    }

    public boolean v1() {
        return this.f20877m0;
    }

    protected abstract Fragment x1(MenuItem menuItem);

    protected abstract void y1(MenuItem menuItem);

    /* JADX INFO: Access modifiers changed from: protected */
    public void z1() {
    }
}
