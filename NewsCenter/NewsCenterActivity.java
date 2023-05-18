package com.scores365.NewsCenter;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import cc.c1;
import cc.o0;
import cc.z0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scores365.App;
import com.scores365.NewsCenter.NewsCenterActivity;
import com.scores365.NewsCenter.b;
import com.scores365.Pages.u;
import com.scores365.Quiz.Activities.QuizModeActivity;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsVideoObj;
import com.scores365.removeAds.RemoveAdsManager;
import d5.o;
import d5.s;
import ee.k;
import gc.g0;
import i4.b0;
import i4.f;
import i4.i0;
import i4.j0;
import i4.r;
import i4.x;
import i4.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import li.p0;
import li.x0;
import n4.a;
import sc.i;
import uc.f;
import xc.h;
import y5.n;
/* loaded from: classes2.dex */
public class NewsCenterActivity extends com.scores365.Design.Activities.c implements wh.b, g0, View.OnClickListener, o0.b, z.b, xc.a {
    private static ArrayList<ItemObj> O0 = null;
    public static boolean P0 = true;
    public static String Q0 = "start_position";
    public static String R0 = "items_list";
    public static String S0 = "competitors_hashtable";
    public static String T0 = "isInnerNewsClicked";
    public static com.scores365.NewsCenter.b U0;
    private ViewPager D0;
    private RelativeLayout E0;
    public u F0;
    private RelativeLayout H;
    ConstraintLayout K0;
    ImageView L0;
    ImageView M0;

    /* renamed from: b0  reason: collision with root package name */
    private CollapsingToolbarLayout f21117b0;

    /* renamed from: f0  reason: collision with root package name */
    private MyCoordinatorLayout f21118f0;

    /* renamed from: g0  reason: collision with root package name */
    private ControllableAppBarLayout f21119g0;

    /* renamed from: h0  reason: collision with root package name */
    private ConstraintLayout f21120h0;

    /* renamed from: i0  reason: collision with root package name */
    private ImageView f21121i0;

    /* renamed from: j0  reason: collision with root package name */
    private ImageView f21122j0;

    /* renamed from: k0  reason: collision with root package name */
    public ImageView f21123k0;

    /* renamed from: l0  reason: collision with root package name */
    public ImageView f21124l0;

    /* renamed from: m0  reason: collision with root package name */
    public ImageView f21125m0;

    /* renamed from: n0  reason: collision with root package name */
    public ImageView f21126n0;

    /* renamed from: o0  reason: collision with root package name */
    private PlayerView f21127o0;

    /* renamed from: p0  reason: collision with root package name */
    public i0 f21128p0;

    /* renamed from: q0  reason: collision with root package name */
    private ConstraintLayout f21129q0;

    /* renamed from: r0  reason: collision with root package name */
    private CollapsingToolbarLayout.c f21130r0;

    /* renamed from: s0  reason: collision with root package name */
    private Dialog f21131s0;

    /* renamed from: t0  reason: collision with root package name */
    ArrayList<ItemObj> f21132t0;

    /* renamed from: u0  reason: collision with root package name */
    private LayerDrawable f21133u0;

    /* renamed from: w0  reason: collision with root package name */
    public MenuItem f21135w0;
    public boolean F = false;
    public boolean G = false;
    private boolean I = false;

    /* renamed from: v0  reason: collision with root package name */
    public int f21134v0 = -1;

    /* renamed from: x0  reason: collision with root package name */
    boolean f21136x0 = false;

    /* renamed from: y0  reason: collision with root package name */
    boolean f21137y0 = false;

    /* renamed from: z0  reason: collision with root package name */
    int f21138z0 = 256;
    int A0 = 0;
    private final int[] B0 = new int[3];
    private int C0 = 0;
    public boolean G0 = false;
    r H0 = null;
    b0.b I0 = new c();
    boolean J0 = false;
    private boolean N0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements AdEvent.AdEventListener {
        a() {
        }

        @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
        public void onAdEvent(AdEvent adEvent) {
            int i10 = e.f21143a[adEvent.getType().ordinal()];
            if (i10 == 1) {
                NewsCenterActivity.this.f21126n0.setVisibility(0);
                NewsCenterActivity.this.f21124l0.setVisibility(0);
            } else if (i10 == 2) {
                NewsCenterActivity.this.f21126n0.setVisibility(8);
                NewsCenterActivity.this.f21124l0.setVisibility(8);
            } else if (i10 != 3) {
            } else {
                NewsCenterActivity.this.f21126n0.setVisibility(0);
                NewsCenterActivity.this.f21124l0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements b.InterfaceC0234b {
        b() {
        }

        @Override // com.scores365.NewsCenter.b.InterfaceC0234b
        public void F(ArrayList<ItemObj> arrayList, Hashtable<Integer, CompObj> hashtable) {
            try {
                Intent intent = new Intent();
                intent.putExtra(NewsCenterActivity.Q0, 0);
                intent.putExtra("is_news", true);
                intent.putExtra(NewsCenterActivity.R0, arrayList);
                if (hashtable != null) {
                    intent.putExtra(NewsCenterActivity.S0, hashtable);
                }
                NewsCenterActivity.this.setIntent(intent);
                NewsCenterActivity.this.W1();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements b0.b {
        c() {
        }

        @Override // i4.b0.b
        public void m(int i10, Object obj) {
            try {
                if (NewsCenterActivity.this.C0 < 4) {
                    long duration = NewsCenterActivity.this.f21128p0.getDuration();
                    NewsCenterActivity.m1(NewsCenterActivity.this);
                    long j10 = (duration / 4) * NewsCenterActivity.this.C0;
                    if (NewsCenterActivity.this.C0 < 4) {
                        NewsCenterActivity newsCenterActivity = NewsCenterActivity.this;
                        newsCenterActivity.f21128p0.o0(newsCenterActivity.I0).p(2).o(j10).m(new Handler()).l();
                    }
                    String str = NewsCenterActivity.this.C0 - 1 == 1 ? "0.25" : NewsCenterActivity.this.C0 - 1 == 2 ? "0.5" : NewsCenterActivity.this.C0 - 1 == 3 ? "0.75" : NewsCenterActivity.this.C0 - 1 == 4 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : null;
                    if (str != null) {
                        NewsCenterActivity.this.a2(str);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends Dialog {
        d(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            try {
                NewsCenterActivity.this.G1();
                super.onBackPressed();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21143a;

        static {
            int[] iArr = new int[AdEvent.AdEventType.values().length];
            f21143a = iArr;
            try {
                iArr[AdEvent.AdEventType.SKIPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21143a[AdEvent.AdEventType.AD_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21143a[AdEvent.AdEventType.ALL_ADS_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f extends s2.c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<NewsCenterActivity> f21144a;

        /* renamed from: b  reason: collision with root package name */
        private final String f21145b;

        public f(NewsCenterActivity newsCenterActivity, String str) {
            this.f21144a = new WeakReference<>(newsCenterActivity);
            this.f21145b = str;
        }

        @Override // s2.i
        public void onLoadCleared(Drawable drawable) {
        }

        public void onResourceReady(@NonNull Bitmap bitmap, t2.b<? super Bitmap> bVar) {
            try {
                NewsCenterActivity newsCenterActivity = this.f21144a.get();
                if (newsCenterActivity != null) {
                    int i10 = 0;
                    if (newsCenterActivity.D0.getAdapter().e() <= 1 && (newsCenterActivity.getIntent() == null || !newsCenterActivity.getIntent().getBooleanExtra(NewsCenterActivity.T0, false))) {
                        newsCenterActivity.f21123k0.setImageBitmap(bitmap);
                        newsCenterActivity.f21123k0.requestLayout();
                    }
                    int currentItem = newsCenterActivity.D0.getCurrentItem();
                    if (currentItem <= 0 || !p0.X(newsCenterActivity.f21132t0.get(currentItem - 1)).equals(this.f21145b)) {
                        i10 = p0.X(newsCenterActivity.f21132t0.get(currentItem)).equals(this.f21145b) ? 1 : (currentItem >= newsCenterActivity.F0.e() - 1 || !p0.X(newsCenterActivity.f21132t0.get(currentItem + 1)).equals(this.f21145b)) ? -1 : 2;
                    }
                    if (i10 != -1) {
                        int i11 = newsCenterActivity.B0[i10];
                        newsCenterActivity.f21133u0.setDrawableByLayerId(i10, new BitmapDrawable(App.m().getResources(), bitmap));
                        newsCenterActivity.f21133u0.getDrawable(i10).setAlpha(i11);
                    }
                    newsCenterActivity.f21123k0.requestLayout();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // s2.i
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, t2.b bVar) {
            onResourceReady((Bitmap) obj, (t2.b<? super Bitmap>) bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g extends AsyncTask<Void, Void, ArrayList<ItemObj>> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<NewsCenterActivity> f21146a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements ViewPager.j {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NewsCenterActivity f21147a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ArrayList f21148b;

            a(NewsCenterActivity newsCenterActivity, ArrayList arrayList) {
                this.f21147a = newsCenterActivity;
                this.f21148b = arrayList;
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrollStateChanged(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageScrolled(int i10, float f10, int i11) {
                try {
                    int currentItem = this.f21147a.D0.getCurrentItem();
                    if (i10 == currentItem) {
                        this.f21147a.B0[0] = 0;
                        this.f21147a.B0[1] = (int) ((1.0f - f10) * 255.0f);
                        this.f21147a.B0[2] = (int) (f10 * 255.0f);
                    } else if (i10 == currentItem + 1) {
                        this.f21147a.B0[0] = 0;
                        this.f21147a.B0[1] = 0;
                        this.f21147a.B0[2] = 255;
                    } else if (i10 == currentItem - 1) {
                        this.f21147a.B0[0] = (int) ((1.0f - f10) * 255.0f);
                        this.f21147a.B0[1] = (int) (f10 * 255.0f);
                        this.f21147a.B0[2] = 0;
                    }
                    this.f21147a.f21133u0.getDrawable(0).setAlpha(this.f21147a.B0[0]);
                    this.f21147a.f21133u0.getDrawable(1).setAlpha(this.f21147a.B0[1]);
                    this.f21147a.f21133u0.getDrawable(2).setAlpha(this.f21147a.B0[2]);
                    this.f21147a.f21123k0.invalidate();
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.j
            public void onPageSelected(int i10) {
                try {
                    g.this.d(this.f21147a, i10);
                    NewsCenterActivity newsCenterActivity = this.f21147a;
                    if (newsCenterActivity.f21134v0 - 1 == i10) {
                        newsCenterActivity.f21133u0.setDrawableByLayerId(2, this.f21147a.f21133u0.getDrawable(1));
                        this.f21147a.f21133u0.getDrawable(2).setAlpha(this.f21147a.B0[1]);
                        this.f21147a.f21133u0.setDrawableByLayerId(1, this.f21147a.f21133u0.getDrawable(0));
                        this.f21147a.f21133u0.getDrawable(1).setAlpha(this.f21147a.B0[0]);
                        this.f21147a.f21133u0.setDrawableByLayerId(0, new ColorDrawable(p0.A(R.attr.A1)));
                        this.f21147a.f21133u0.getDrawable(0).setAlpha(0);
                        if (i10 != 0) {
                            int i11 = i10 - 1;
                            if (this.f21147a.f21132t0.get(i11).isBigImage() && !this.f21147a.f21132t0.get(i11).shouldShowVideo()) {
                                String X = p0.X(this.f21147a.f21132t0.get(i11));
                                li.u.B(X, null, null, new f(this.f21147a, X));
                            }
                        }
                    } else {
                        newsCenterActivity.f21133u0.setDrawableByLayerId(0, this.f21147a.f21133u0.getDrawable(1));
                        this.f21147a.f21133u0.getDrawable(0).setAlpha(this.f21147a.B0[1]);
                        this.f21147a.f21133u0.setDrawableByLayerId(1, this.f21147a.f21133u0.getDrawable(2));
                        this.f21147a.f21133u0.getDrawable(1).setAlpha(this.f21147a.B0[2]);
                        this.f21147a.f21133u0.setDrawableByLayerId(2, new ColorDrawable(p0.A(R.attr.A1)));
                        this.f21147a.f21133u0.getDrawable(2).setAlpha(0);
                        int i12 = i10 + 1;
                        if (i12 != this.f21147a.F0.e() && this.f21147a.f21132t0.get(i12).isBigImage() && !this.f21147a.f21132t0.get(i12).shouldShowVideo()) {
                            String X2 = p0.X(this.f21147a.f21132t0.get(i12));
                            li.u.B(X2, null, null, new f(this.f21147a, X2));
                        }
                    }
                    NewsCenterActivity newsCenterActivity2 = this.f21147a;
                    newsCenterActivity2.f21134v0 = i10;
                    newsCenterActivity2.f21123k0.invalidate();
                    x0.b2(((ItemObj) this.f21148b.get(i10)).getID(), "news-item", false, false);
                    if (this.f21147a.D0.getAdapter().i(this.f21147a.D0, this.f21147a.D0.getCurrentItem()) != null && (this.f21147a.D0.getAdapter().i(this.f21147a.D0, this.f21147a.D0.getCurrentItem()) instanceof com.scores365.NewsCenter.a)) {
                        com.scores365.NewsCenter.a aVar = (com.scores365.NewsCenter.a) this.f21147a.D0.getAdapter().i(this.f21147a.D0, this.f21147a.D0.getCurrentItem());
                        ItemObj itemObj = aVar.f21150l;
                        this.f21147a.e2(i10, true);
                        this.f21147a.f21129q0.setVisibility(8);
                        ArrayList<NewsVideoObj> arrayList = itemObj.newsVideos;
                        if (arrayList == null || arrayList.size() <= 0) {
                            this.f21147a.f21128p0.l(false);
                            this.f21147a.f21128p0.T();
                            this.f21147a.f21123k0.setVisibility(0);
                            ((h) aVar.getRvBaseAdapter().B().get(0)).l(false);
                        } else {
                            this.f21147a.f21123k0.setVisibility(8);
                            ((h) aVar.getRvBaseAdapter().B().get(0)).l(true);
                            this.f21147a.f21128p0.l(true);
                        }
                        aVar.getRvBaseAdapter().notifyItemChanged(0);
                    }
                    this.f21147a.invalidateOptionsMenu();
                } catch (Exception e10) {
                    x0.N1(e10);
                }
                this.f21147a.E1(i10, true);
            }
        }

        public g(NewsCenterActivity newsCenterActivity) {
            this.f21146a = new WeakReference<>(newsCenterActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(NewsCenterActivity newsCenterActivity, int i10) {
            try {
                if (newsCenterActivity.f21132t0.get(i10).isBigImage()) {
                    newsCenterActivity.f21119g0.G();
                    newsCenterActivity.f21119g0.setIsAllowedToScroll(true);
                    newsCenterActivity.f21118f0.setAllowForScrool(true);
                } else {
                    newsCenterActivity.f21119g0.F();
                    newsCenterActivity.f21119g0.setIsAllowedToScroll(false);
                    newsCenterActivity.f21118f0.setAllowForScrool(false);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public ArrayList<ItemObj> doInBackground(Void... voidArr) {
            Intent intent;
            ArrayList<ItemObj> arrayList;
            ArrayList<ItemObj> arrayList2 = null;
            try {
                NewsCenterActivity newsCenterActivity = this.f21146a.get();
                intent = newsCenterActivity != null ? newsCenterActivity.getIntent() : null;
                if (NewsCenterActivity.U0 == null) {
                    NewsCenterActivity.U0 = new com.scores365.NewsCenter.b();
                }
                NewsCenterActivity.U0.e(intent);
                arrayList = NewsCenterActivity.O0;
            } catch (Exception e10) {
                e = e10;
            }
            try {
                ArrayList unused = NewsCenterActivity.O0 = null;
            } catch (Exception e11) {
                e = e11;
                arrayList2 = arrayList;
                x0.N1(e);
                return arrayList2;
            }
            if (arrayList == null) {
                try {
                    arrayList2 = NewsCenterActivity.U0.e(intent);
                    return arrayList2;
                } catch (Exception e12) {
                    x0.N1(e12);
                    return arrayList;
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<ItemObj> arrayList) {
            try {
                NewsCenterActivity newsCenterActivity = this.f21146a.get();
                if (newsCenterActivity != null) {
                    Hashtable<Integer, CompObj> a10 = NewsCenterActivity.U0.a(newsCenterActivity.getIntent());
                    newsCenterActivity.f21132t0 = arrayList;
                    ArrayList<com.scores365.Design.Pages.b> arrayList2 = new ArrayList<>();
                    Iterator<ItemObj> it = newsCenterActivity.f21132t0.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new xc.e("", "", i.SingleNews, false, it.next(), a10));
                    }
                    u uVar = newsCenterActivity.F0;
                    if (uVar == null) {
                        newsCenterActivity.F0 = new u(newsCenterActivity.getSupportFragmentManager(), arrayList2);
                    } else {
                        uVar.x(arrayList2);
                        newsCenterActivity.F0.k();
                    }
                    if (newsCenterActivity.D0 != null) {
                        newsCenterActivity.D0.setAdapter(newsCenterActivity.F0);
                        newsCenterActivity.D0.setCurrentItem(NewsCenterActivity.U0.f21153a);
                        int i10 = NewsCenterActivity.U0.f21153a;
                        newsCenterActivity.f21134v0 = i10;
                        d(newsCenterActivity, i10);
                        newsCenterActivity.f21133u0 = new LayerDrawable(new Drawable[]{new ColorDrawable(p0.A(R.attr.A1)), new ColorDrawable(p0.A(R.attr.A1)), new ColorDrawable(p0.A(R.attr.A1))});
                        newsCenterActivity.f21133u0.setId(0, 0);
                        newsCenterActivity.f21133u0.setId(1, 1);
                        newsCenterActivity.f21133u0.setId(2, 2);
                        newsCenterActivity.f21123k0.setImageDrawable(newsCenterActivity.f21133u0);
                        if (newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a).isBigImage() && !newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a).shouldShowVideo()) {
                            String X = p0.X(newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a));
                            f fVar = new f(newsCenterActivity, X);
                            li.u.B(X, null, null, fVar);
                            newsCenterActivity.f21123k0.setTag(fVar);
                        }
                        int i11 = NewsCenterActivity.U0.f21153a;
                        if (i11 > 0 && newsCenterActivity.f21132t0.get(i11 - 1).isBigImage() && !newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a - 1).shouldShowVideo()) {
                            String X2 = p0.X(newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a - 1));
                            li.u.B(X2, null, null, new f(newsCenterActivity, X2));
                        }
                        if (NewsCenterActivity.U0.f21153a + 1 < newsCenterActivity.F0.e() && newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a + 1).isBigImage() && !newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a + 1).shouldShowVideo()) {
                            String X3 = p0.X(newsCenterActivity.f21132t0.get(NewsCenterActivity.U0.f21153a + 1));
                            li.u.B(X3, null, null, new f(newsCenterActivity, X3));
                        }
                        newsCenterActivity.invalidateOptionsMenu();
                        newsCenterActivity.D0.c(new a(newsCenterActivity, arrayList));
                    }
                    newsCenterActivity.E0.setVisibility(8);
                    if (newsCenterActivity.G0 && !App.B && App.f20802v > 0) {
                        App.B = true;
                        k.n(App.m(), "app", "loading-time", null, null, false, ShareConstants.FEED_SOURCE_PARAM, "article-notification", "duration", String.valueOf(System.currentTimeMillis() - App.f20802v));
                    }
                    newsCenterActivity.e2(NewsCenterActivity.U0.f21153a, true);
                    if (!newsCenterActivity.I) {
                        if (od.a.M0()) {
                            newsCenterActivity.O1();
                            sf.b.X1().h3();
                            sf.b.X1().n5();
                        } else {
                            newsCenterActivity.A0 = 0;
                        }
                    }
                    newsCenterActivity.E1(NewsCenterActivity.U0.f21153a, true);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(int i10, boolean z10) {
        try {
            Fragment fragment = (Fragment) this.D0.getAdapter().i(this.D0, i10);
            if (fragment instanceof com.scores365.NewsCenter.c) {
                if (z10) {
                    ((com.scores365.NewsCenter.c) fragment).N(this, this, this.F);
                }
                ((com.scores365.NewsCenter.c) fragment).u();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExitScreen() {
        try {
            if (this.G0) {
                startActivity(x0.x0());
                finish();
            } else {
                finish();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private s F1(String str, String str2) {
        try {
            y5.r rVar = new y5.r(this, a6.i0.M(this, App.m().getString(R.string.f22812a)));
            o O = new o.b(rVar).O(Uri.parse(str));
            if (str2 != null) {
                return new e5.e(O, rVar, H1(str2), this.f21127o0);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        try {
            if (this.f21136x0) {
                setRequestedOrientation(1);
            }
            ((ViewGroup) this.f21127o0.getParent()).removeView(this.f21127o0);
            ((ViewGroup) this.K0.getParent()).removeView(this.K0);
            this.f21129q0.addView(this.f21127o0, 0, new ViewGroup.LayoutParams(-1, -1));
            ((ViewGroup.MarginLayoutParams) this.f21127o0.getLayoutParams()).topMargin = p0.s(52);
            this.f21136x0 = false;
            this.f21131s0.dismiss();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private e5.b H1(String str) {
        try {
            Uri parse = Uri.parse(str);
            ImaSdkSettings createImaSdkSettings = ImaSdkFactory.getInstance().createImaSdkSettings();
            String C = o0.y().C("STICKY_VIDEO_NEWS_ADS_AUTO_PLAY");
            createImaSdkSettings.setAutoPlayAdBreaks(!TextUtils.isEmpty(C) && Boolean.parseBoolean(C));
            createImaSdkSettings.setDebugMode(true);
            a.b bVar = new a.b(App.m());
            bVar.c(createImaSdkSettings).d(30000);
            bVar.b(new a());
            return bVar.a(parse);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Intent I1(Context context, ArrayList<ItemObj> arrayList, int i10, boolean z10, boolean z11) {
        Intent intent = new Intent(context, NewsCenterActivity.class);
        if (arrayList != null) {
            try {
                if (arrayList.size() > 50) {
                    ArrayList arrayList2 = new ArrayList();
                    int size = i10 < 25 ? 0 : i10 > arrayList.size() - 25 ? arrayList.size() - 50 : i10 - 25;
                    for (int i11 = size; i11 < size + 50; i11++) {
                        arrayList2.add(arrayList.get(i11));
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        intent.putExtra(Q0, i10);
        O0 = arrayList;
        intent.putExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, z10);
        intent.putExtra(T0, z11);
        intent.setFlags(335544320);
        return intent;
    }

    private int K1() {
        return p0.s(this.f21138z0 + this.A0);
    }

    private void L1() {
        try {
            this.f21129q0.setVisibility(8);
            this.f21128p0.r0();
            this.f21123k0.setVisibility(8);
            AppBarLayout.f fVar = (AppBarLayout.f) this.f21117b0.getLayoutParams();
            fVar.g(0);
            ((LinearLayout.LayoutParams) fVar).height = p0.s(52);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void M1() {
        try {
            if (this.f21136x0) {
                this.f21125m0.setImageResource(R.drawable.E1);
                this.f21136x0 = false;
                G1();
                setRequestedOrientation(1);
            } else {
                this.f21125m0.setImageResource(R.drawable.f21746k3);
                this.f21136x0 = true;
                R1();
                X1();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void N1() {
        try {
            if (this.f21128p0 != null) {
                if (this.f21137y0) {
                    c2();
                } else {
                    b2();
                }
                this.f21137y0 = !this.f21137y0;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        try {
            li.u.x(od.a.C(), this.f21121i0);
            this.f21117b0.getLayoutParams().height = K1();
            this.f21117b0.forceLayout();
            this.A0 = FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            ((ViewGroup.MarginLayoutParams) this.f21123k0.getLayoutParams()).topMargin = p0.s(this.A0);
            this.f21120h0.setVisibility(0);
            this.f21122j0.setOnClickListener(this);
            this.f21121i0.setOnClickListener(this);
            od.a.j0("news-item");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void P1() {
        try {
            this.f21127o0.setVisibility(8);
            this.f21129q0.setVisibility(8);
            AppBarLayout.f fVar = (AppBarLayout.f) this.f21117b0.getLayoutParams();
            fVar.g(3);
            ((LinearLayout.LayoutParams) fVar).height = p0.s(this.f21138z0 + this.A0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void Q1() {
        try {
            this.A0 = 0;
            this.f21120h0.setVisibility(8);
            this.f21117b0.getLayoutParams().height = K1();
            ((ViewGroup.MarginLayoutParams) this.f21123k0.getLayoutParams()).topMargin = p0.s(this.A0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void R1() {
        try {
            d dVar = new d(this, 16973834);
            this.f21131s0 = dVar;
            dVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xc.c
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    NewsCenterActivity.this.T1(dialogInterface);
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean S1() {
        try {
            if (this.f21132t0.get(this.D0.getCurrentItem()).getUrlOfVideoToShow() != null) {
                return !this.f21132t0.get(this.D0.getCurrentItem()).getUrlOfVideoToShow().isEmpty();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(DialogInterface dialogInterface) {
        try {
            setRequestedOrientation(1);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1() {
        try {
            e2(U0.f21153a, false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void V1() {
        try {
            int intExtra = getIntent().getIntExtra("articleId", 0);
            try {
                ((NotificationManager) getApplicationContext().getSystemService("notification")).cancel(intExtra);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            U0.c(intExtra, new b());
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W1() {
        try {
            new g(this).execute(new Void[0]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void X1() {
        try {
            ((ViewGroup) this.f21127o0.getParent()).removeView(this.f21127o0);
            this.f21131s0.addContentView(this.f21127o0, new ViewGroup.LayoutParams(-1, -1));
            if (this.K0 == null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.U4, (ViewGroup) null);
                this.K0 = constraintLayout;
                this.L0 = (ImageView) constraintLayout.findViewById(R.id.f22402xb);
                this.M0 = (ImageView) this.K0.findViewById(R.id.f22094jc);
                this.L0.setOnClickListener(this);
                this.M0.setOnClickListener(this);
            }
            this.f21131s0.addContentView(this.K0, new ViewGroup.LayoutParams(-1, -1));
            if (this.f21137y0) {
                this.M0.setImageResource(R.drawable.J3);
            } else {
                this.M0.setImageResource(R.drawable.f21841w2);
            }
            this.f21136x0 = true;
            this.f21131s0.show();
            setRequestedOrientation(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void Y1(Context context, ArrayList<ItemObj> arrayList, int i10, boolean z10, boolean z11) {
        try {
            context.startActivity(I1(context, arrayList, i10, z10, z11));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(String str) {
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
            strArr[7] = "News";
            strArr[8] = "is_muted";
            strArr[9] = this.f21137y0 ? "mute" : "unmute";
            strArr[10] = "duration";
            strArr[11] = String.valueOf(this.f21128p0.getDuration() / 1000);
            strArr[12] = "time_seen";
            strArr[13] = str;
            k.n(m10, "365tv", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "seen", null, false, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void b2() {
        try {
            this.f21128p0.x0(0.0f);
            ImageView imageView = this.M0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.f21841w2);
            }
            this.f21126n0.setImageResource(R.drawable.f21841w2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void c2() {
        try {
            this.f21128p0.x0(1.0f);
            ImageView imageView = this.M0;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.J3);
            }
            this.f21126n0.setImageResource(R.drawable.J3);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(int i10, boolean z10) {
        try {
            if (RemoveAdsManager.isUserAdsRemoved(App.m())) {
                P1();
            } else {
                String urlOfVideoToShow = this.f21132t0.get(i10).getUrlOfVideoToShow();
                if (urlOfVideoToShow != null) {
                    if (o0.y() != null) {
                        androidx.viewpager.widget.a adapter = this.D0.getAdapter();
                        ViewPager viewPager = this.D0;
                        if (((com.scores365.NewsCenter.a) adapter.i(viewPager, viewPager.getCurrentItem())).f21150l.getHasVideo()) {
                            f2(urlOfVideoToShow, null);
                            this.I = true;
                        }
                    } else {
                        P1();
                        if (z10) {
                            o0.i(getApplicationContext(), true, true, this);
                        }
                    }
                } else if (d2()) {
                    String C = o0.y().C("STICKY_VIDEO_NEWS_SOURCE");
                    String C2 = o0.y().C("STICKY_VIDEO_NEWS_ADS_TAG");
                    if (C != null && !C.isEmpty()) {
                        f2(C, C2);
                        this.f21123k0.setVisibility(8);
                        this.I = true;
                    }
                } else {
                    P1();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    static /* synthetic */ int m1(NewsCenterActivity newsCenterActivity) {
        int i10 = newsCenterActivity.C0;
        newsCenterActivity.C0 = i10 + 1;
        return i10;
    }

    @Override // i4.z.b
    public void B0() {
    }

    @Override // i4.z.b
    public void E0(TrackGroupArray trackGroupArray, v5.d dVar) {
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public ViewGroup GetBannerHolderView() {
        return this.H;
    }

    public RelativeLayout J1() {
        return this.H;
    }

    @Override // i4.z.b
    public void L0(j0 j0Var, Object obj, int i10) {
    }

    @Override // i4.z.b
    public void P0(boolean z10, int i10) {
        if (i10 == 4) {
            try {
                this.f21124l0.callOnClick();
                a2(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        if (i10 == 3 && z10) {
            this.C0 = 0;
            a2("0");
            this.f21128p0.o0(this.I0).p(2).o(0L).m(new Handler()).l();
        }
    }

    @Override // i4.z.b
    public void R0(i4.i iVar) {
    }

    @Override // gc.g0
    @NonNull
    public sc.f W0() {
        return sc.f.BigLayout;
    }

    public void Z1() {
        if (this.N0) {
            return;
        }
        this.N0 = true;
        k.h(App.m(), "ad", "mpu-conditions", "met");
    }

    @Override // i4.z.b
    public void b(x xVar) {
    }

    @Override // xc.a
    public void b0() {
        this.F = true;
        cc.r.F(this, this, i.SingleNews, null);
    }

    @Override // cc.o0.b
    public void c0() {
        try {
            runOnUiThread(new Runnable() { // from class: xc.d
                @Override // java.lang.Runnable
                public final void run() {
                    NewsCenterActivity.this.U1();
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean d2() {
        try {
            if (o0.y().C("STICKY_VIDEO_NEWS_ENABLED") == null || !Boolean.valueOf(o0.y().C("STICKY_VIDEO_NEWS_ENABLED")).booleanValue() || !sf.b.X1().v4()) {
                if (!S1()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // i4.z.b
    public void e(boolean z10) {
    }

    public void f2(String str, String str2) {
        try {
            boolean z10 = true;
            if (this.H0 == null) {
                this.H0 = new f.a().b(new n(true, 16)).c(25000, 30000, ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION).e(50).d(true).a();
            }
            if (this.f21128p0 == null) {
                this.f21128p0 = i4.k.b(App.m(), new i4.h(App.m()), new DefaultTrackSelector(), this.H0);
            }
            this.f21127o0.setVisibility(0);
            this.f21127o0.setPlayer(this.f21128p0);
            this.f21127o0.setControllerHideDuringAds(true);
            this.f21127o0.setUseController(false);
            this.f21137y0 = false;
            fc.a y10 = o0.y();
            if (y10 != null) {
                this.f21137y0 = !y10.i("STICKY_VIDEO_NEWS_SOUND_ON");
            }
            if (this.f21137y0) {
                b2();
            } else {
                c2();
            }
            int p10 = (((App.p() - p0.s(6)) * 9) / 16) + p0.s(52);
            ((FrameLayout.LayoutParams) this.f21130r0).height = p10;
            this.f21129q0.setVisibility(0);
            this.f21128p0.n(F1(str, str2));
            String C = y10 == null ? "" : y10.C("STICKY_VIDEO_NEWS_AUTO_PLAY");
            if (TextUtils.isEmpty(C) || !Boolean.parseBoolean(C)) {
                z10 = false;
            }
            this.f21128p0.l(z10);
            this.f21128p0.f(this);
            this.f21119g0.G();
            AppBarLayout.f fVar = (AppBarLayout.f) this.f21117b0.getLayoutParams();
            fVar.g(0);
            ((LinearLayout.LayoutParams) fVar).height = p10;
            this.f21125m0.setVisibility(8);
            this.f21126n0.setVisibility(0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // wh.b
    public void finishLoading() {
        this.E0.setVisibility(8);
    }

    @Override // wh.b
    public Activity getActivityForUI() {
        return this;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public i getPlacement() {
        return i.SingleNews;
    }

    @Override // i4.z.b
    public void l(boolean z10) {
    }

    @Override // xc.a
    public void loadBanner() {
    }

    @Override // gc.g0
    public void m0() {
        try {
            if (this.J0) {
                return;
            }
            this.J0 = true;
            androidx.viewpager.widget.a adapter = this.D0.getAdapter();
            ViewPager viewPager = this.D0;
            ((com.scores365.NewsCenter.a) adapter.i(viewPager, viewPager.getCurrentItem())).I1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            try {
                i0 i0Var = this.f21128p0;
                if (i0Var != null) {
                    i0Var.T();
                    this.f21128p0.r0();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            P0 = false;
            uc.d n10 = ((App) getApplication()).n();
            uc.f f10 = n10.i().f();
            if ((f10 instanceof f.e) && !((f.e) f10).b().g() && n10.u(this, (f.e) f10, new c1.a() { // from class: xc.b
                @Override // cc.c1.a
                public final void a() {
                    NewsCenterActivity.this.ExitScreen();
                }
            })) {
                return;
            }
            ExitScreen();
        } catch (Exception e11) {
            x0.N1(e11);
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NonNull View view) {
        int id2 = view.getId();
        if (id2 == R.id.f22094jc || id2 == R.id.f22116kc) {
            N1();
        } else if (id2 == R.id.f22424yb) {
            M1();
        } else if (id2 == R.id.Ta) {
            L1();
        } else if (id2 == R.id.Ua) {
            Q1();
            od.a.i0("news-item", true);
        } else if (id2 == R.id.Il) {
            startActivity(QuizModeActivity.C1("promotion", false));
            od.a.i0("news-item", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.S4);
        initActionBar();
        if (U0 == null) {
            U0 = new com.scores365.NewsCenter.b();
        }
        try {
            P0 = true;
            this.H = (RelativeLayout) findViewById(R.id.f22125l);
            this.E0 = (RelativeLayout) findViewById(R.id.Jn);
            this.G0 = getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false);
            this.f21117b0 = (CollapsingToolbarLayout) findViewById(R.id.f22112k8);
            MyCoordinatorLayout myCoordinatorLayout = (MyCoordinatorLayout) findViewById(R.id.f22156m8);
            this.f21118f0 = myCoordinatorLayout;
            myCoordinatorLayout.setAllowForScrool(true);
            if (this.G0) {
                V1();
            } else {
                W1();
            }
            Toolbar toolbar = (Toolbar) findViewById(R.id.f21968e);
            this.toolbar = toolbar;
            toolbar.setBackgroundResource(0);
            this.f21120h0 = (ConstraintLayout) findViewById(R.id.Hl);
            this.f21121i0 = (ImageView) findViewById(R.id.Il);
            this.f21122j0 = (ImageView) findViewById(R.id.Ua);
            this.f21123k0 = (ImageView) findViewById(R.id.f22134l8);
            this.f21124l0 = (ImageView) findViewById(R.id.Ta);
            this.f21125m0 = (ImageView) findViewById(R.id.f22424yb);
            this.f21126n0 = (ImageView) findViewById(R.id.f22116kc);
            this.f21124l0.setOnClickListener(this);
            this.f21124l0.setVisibility(8);
            this.f21125m0.setOnClickListener(this);
            this.f21126n0.setOnClickListener(this);
            this.f21127o0 = (PlayerView) findViewById(R.id.f22352v5);
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.Z5);
            this.f21129q0 = constraintLayout;
            this.f21130r0 = (CollapsingToolbarLayout.c) constraintLayout.getLayoutParams();
            this.f21119g0 = (ControllableAppBarLayout) findViewById(R.id.f22090j8);
            this.D0 = (ViewPager) findViewById(R.id.PI);
            if (this.G0) {
                x0.b2(getIntent().getIntExtra("articleId", 0), "notification", false, false);
            }
            if (!od.a.M0()) {
                this.A0 = 0;
                return;
            }
            O1();
            sf.b.X1().h3();
            sf.b.X1().n5();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.f22785b, menu);
            MenuItem findItem = menu.findItem(R.id.f22036h);
            this.f21135w0 = findItem;
            findItem.setTitle(p0.l0("SHARE_ITEM"));
            this.f21135w0.setVisible(true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            finish();
            startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId;
        try {
            itemId = menuItem.getItemId();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.f22036h) {
            if (itemId == R.id.f21991f) {
                M1();
                return true;
            }
            if (itemId == R.id.f22014g) {
                N1();
                return true;
            }
            return false;
        } else {
            ItemObj itemObj = this.f21132t0.get(this.D0.getCurrentItem());
            String contentUrl = itemObj.getContentUrl();
            if (TextUtils.isEmpty(contentUrl)) {
                Iterator<Fragment> it = getSupportFragmentManager().v0().iterator();
                if (it.hasNext()) {
                    li.i0.a(it.next(), getInterstitialController(), this, itemObj, itemObj.getSourceObj(), !this.f21132t0.get(this.f21134v0).isBigImage(), false);
                }
            } else {
                startActivity(x0.f(this, itemObj.getID(), itemObj.getTitle(), contentUrl));
            }
            x0.f2(String.valueOf(itemObj.getID()), "all-news", "news-item", "2", AppEventsConstants.EVENT_PARAM_VALUE_YES, null);
            return true;
        }
    }

    @Override // i4.z.b
    public void onRepeatModeChanged(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        try {
            if (getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false) && App.f20792l.l()) {
                ec.e.f25767v = "News new sessions";
            } else {
                ec.e.f25767v = "News from background";
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onResume();
        try {
            if (U0 == null) {
                U0 = new com.scores365.NewsCenter.b();
            }
            i0 i0Var = this.f21128p0;
            if (i0Var != null) {
                i0Var.l(true);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // com.scores365.Design.Activities.c, cc.e1
    public void setMpuHandler(z0 z0Var) {
        try {
            super.setMpuHandler(z0Var);
            E1(this.D0.getCurrentItem(), false);
        } catch (NumberFormatException e10) {
            x0.N1(e10);
        }
    }

    @Override // wh.b
    public void startLoading() {
        this.E0.setVisibility(0);
    }

    @Override // i4.z.b
    public void v(int i10) {
    }
}
