package com.scores365.Pages;

import ag.n0;
import ag.r0;
import ag.s0;
import ag.w0;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.Api;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.FilterCategoriesObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.MatchFactsObj;
import com.scores365.entitys.MessagesPBPObj;
import com.scores365.entitys.PlayByPlayDriveObj;
import com.scores365.entitys.PlayByPlayMessageObj;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.i0;
import com.scores365.gameCenter.q0;
import com.scores365.ui.CustomSpinner;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import li.p0;
import li.x0;
/* compiled from: PlayByPlayPage.java */
/* loaded from: classes2.dex */
public class w extends com.scores365.Design.Pages.d implements View.OnClickListener, q0.b, CustomSpinner.OnSpinnerEventsListener {
    private Animation A;
    private FrameLayout B;
    private Spinner C;
    private kd.b D;

    /* renamed from: s  reason: collision with root package name */
    q0 f21326s;

    /* renamed from: t  reason: collision with root package name */
    RelativeLayout f21327t;

    /* renamed from: u  reason: collision with root package name */
    ImageView f21328u;

    /* renamed from: v  reason: collision with root package name */
    ConstraintLayout f21329v;

    /* renamed from: x  reason: collision with root package name */
    GameObj f21331x;

    /* renamed from: y  reason: collision with root package name */
    private Handler f21332y;

    /* renamed from: z  reason: collision with root package name */
    private Animation f21333z;

    /* renamed from: w  reason: collision with root package name */
    boolean f21330w = false;
    private boolean E = false;
    private boolean F = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayByPlayPage.java */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0032 -> B:17:0x003a). Please submit an issue!!! */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            try {
                if (w.this.D != null && !w.this.D.isEmpty()) {
                    try {
                        if (w.this.D.k()) {
                            w.this.k2(i10, true);
                        } else {
                            w.this.D.n(true);
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayByPlayPage.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    ee.k.o(w.this.C.getContext(), "gamecenter", "play-by-play", "tab", "click", "game_id", String.valueOf(w.this.f21331x.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(w.this.f21331x), "tab", w.this.D.h(), "click_type", "open");
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayByPlayPage.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f21336a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f21337b;

        c(boolean z10, int i10) {
            this.f21336a = z10;
            this.f21337b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f21336a || !w.this.y2()) {
                    if (w.this.getFirstVisiblePositionFromLayoutMgr() - this.f21337b < 1) {
                        w.this.rvItems.x1(0);
                    } else {
                        w.this.z2();
                    }
                } else if (w.this.getLastVisibilePositionFromLayoutMgr() + this.f21337b > ((com.scores365.Design.Pages.q) w.this).rvBaseAdapter.getItemCount() - 2) {
                    w wVar = w.this;
                    wVar.rvItems.p1(((com.scores365.Design.Pages.q) wVar).rvBaseAdapter.getItemCount() - 1);
                } else {
                    w.this.z2();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: PlayByPlayPage.java */
    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (w.this.f21331x.getSportID() != SportTypesEnum.AMERICAN_FOOTBALL.getValue() && w.this.f21331x.getSportID() != SportTypesEnum.HOCKEY.getValue() && w.this.f21331x.getSportID() != SportTypesEnum.BASKETBALL.getValue()) {
                    w.this.rvItems.p1(0);
                }
                RecyclerView recyclerView = w.this.rvItems;
                recyclerView.p1(recyclerView.getAdapter().getItemCount() - 1);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayByPlayPage.java */
    /* loaded from: classes2.dex */
    public static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f21340a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f21341b;

        /* renamed from: c  reason: collision with root package name */
        boolean f21342c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f21343d;

        /* renamed from: e  reason: collision with root package name */
        int f21344e;

        /* renamed from: f  reason: collision with root package name */
        boolean f21345f;

        /* renamed from: g  reason: collision with root package name */
        WeakReference<w> f21346g;

        public e(int i10, ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList, boolean z10, ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList2, int i11, w wVar, boolean z11) {
            this.f21340a = i10;
            this.f21341b = arrayList;
            this.f21342c = z10;
            this.f21343d = arrayList2;
            this.f21344e = i11;
            this.f21346g = new WeakReference<>(wVar);
            this.f21345f = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                w wVar = this.f21346g.get();
                if (wVar != null) {
                    wVar.C2(this.f21340a, this.f21341b, this.f21342c, this.f21343d, this.f21344e, this.f21345f);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void B2() {
        try {
            ConstraintLayout constraintLayout = this.f21329v;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
        ((com.scores365.gameCenter.gameCenterItems.f) r0).f23844j = false;
        ((com.scores365.gameCenter.gameCenterItems.f) r0).n((com.scores365.gameCenter.gameCenterItems.f.b) r3.rvItems.a0(r6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C2(int r4, java.util.ArrayList<java.util.ArrayList<com.scores365.Design.PageObjects.b>> r5, boolean r6, java.util.ArrayList<java.util.ArrayList<com.scores365.Design.PageObjects.b>> r7, int r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.w.C2(int, java.util.ArrayList, boolean, java.util.ArrayList, int, boolean):void");
    }

    private void D2(ArrayList<PlayByPlayMessageObj> arrayList) {
        try {
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList2 = new ArrayList<>();
            if (this.f21331x.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                arrayList2 = X1(arrayList);
            } else if (this.f21331x.getSportID() == SportTypesEnum.HOCKEY.getValue()) {
                Collections.reverse(arrayList);
                arrayList2.get(0).addAll(0, v2(arrayList));
            } else {
                if (this.f21331x.getSportID() == SportTypesEnum.BASKETBALL.getValue()) {
                    Collections.reverse(arrayList);
                }
                arrayList2.add(this.E ? this.f21326s.b(arrayList) : Y1(arrayList));
            }
            n2(arrayList2, false);
            p2();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:20|(1:22)(2:81|(1:83)(23:84|(1:25)(1:80)|26|(21:74|75|76|29|30|(1:32)(1:70)|33|34|35|(1:37)(2:63|(1:65)(2:66|(1:68)(11:69|39|(1:41)(1:62)|42|(1:44)(1:61)|45|(1:47)(1:60)|48|(3:53|54|(1:56))|50|51)))|38|39|(0)(0)|42|(0)(0)|45|(0)(0)|48|(0)|50|51)|28|29|30|(0)(0)|33|34|35|(0)(0)|38|39|(0)(0)|42|(0)(0)|45|(0)(0)|48|(0)|50|51))|23|(0)(0)|26|(0)|28|29|30|(0)(0)|33|34|35|(0)(0)|38|39|(0)(0)|42|(0)(0)|45|(0)(0)|48|(0)|50|51) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ee, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ef, code lost:
        li.x0.N1(r0);
        r25 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b A[Catch: Exception -> 0x01d5, TryCatch #2 {Exception -> 0x01d5, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x0016, B:9:0x001c, B:11:0x0033, B:13:0x003e, B:14:0x0044, B:16:0x004b, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:29:0x0080, B:31:0x009d, B:46:0x00f4, B:58:0x0127, B:66:0x013e, B:70:0x014f, B:77:0x01ad, B:69:0x0149, B:65:0x0139, B:61:0x012f, B:51:0x0107, B:54:0x0116, B:45:0x00ef, B:36:0x00c5, B:24:0x006d, B:26:0x0074, B:79:0x01b3, B:81:0x01b9, B:83:0x01c6, B:38:0x00ca, B:40:0x00d0, B:72:0x0176, B:74:0x0188, B:33:0x00af), top: B:92:0x0007, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080 A[Catch: Exception -> 0x01d5, TryCatch #2 {Exception -> 0x01d5, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x0016, B:9:0x001c, B:11:0x0033, B:13:0x003e, B:14:0x0044, B:16:0x004b, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:29:0x0080, B:31:0x009d, B:46:0x00f4, B:58:0x0127, B:66:0x013e, B:70:0x014f, B:77:0x01ad, B:69:0x0149, B:65:0x0139, B:61:0x012f, B:51:0x0107, B:54:0x0116, B:45:0x00ef, B:36:0x00c5, B:24:0x006d, B:26:0x0074, B:79:0x01b3, B:81:0x01b9, B:83:0x01c6, B:38:0x00ca, B:40:0x00d0, B:72:0x0176, B:74:0x0188, B:33:0x00af), top: B:92:0x0007, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ee, blocks: (B:38:0x00ca, B:40:0x00d0), top: B:88:0x00ca, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0107 A[Catch: Exception -> 0x01d5, TryCatch #2 {Exception -> 0x01d5, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x0016, B:9:0x001c, B:11:0x0033, B:13:0x003e, B:14:0x0044, B:16:0x004b, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:29:0x0080, B:31:0x009d, B:46:0x00f4, B:58:0x0127, B:66:0x013e, B:70:0x014f, B:77:0x01ad, B:69:0x0149, B:65:0x0139, B:61:0x012f, B:51:0x0107, B:54:0x0116, B:45:0x00ef, B:36:0x00c5, B:24:0x006d, B:26:0x0074, B:79:0x01b3, B:81:0x01b9, B:83:0x01c6, B:38:0x00ca, B:40:0x00d0, B:72:0x0176, B:74:0x0188, B:33:0x00af), top: B:92:0x0007, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012f A[Catch: Exception -> 0x01d5, TryCatch #2 {Exception -> 0x01d5, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x0016, B:9:0x001c, B:11:0x0033, B:13:0x003e, B:14:0x0044, B:16:0x004b, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:29:0x0080, B:31:0x009d, B:46:0x00f4, B:58:0x0127, B:66:0x013e, B:70:0x014f, B:77:0x01ad, B:69:0x0149, B:65:0x0139, B:61:0x012f, B:51:0x0107, B:54:0x0116, B:45:0x00ef, B:36:0x00c5, B:24:0x006d, B:26:0x0074, B:79:0x01b3, B:81:0x01b9, B:83:0x01c6, B:38:0x00ca, B:40:0x00d0, B:72:0x0176, B:74:0x0188, B:33:0x00af), top: B:92:0x0007, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0139 A[Catch: Exception -> 0x01d5, TryCatch #2 {Exception -> 0x01d5, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x0016, B:9:0x001c, B:11:0x0033, B:13:0x003e, B:14:0x0044, B:16:0x004b, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:29:0x0080, B:31:0x009d, B:46:0x00f4, B:58:0x0127, B:66:0x013e, B:70:0x014f, B:77:0x01ad, B:69:0x0149, B:65:0x0139, B:61:0x012f, B:51:0x0107, B:54:0x0116, B:45:0x00ef, B:36:0x00c5, B:24:0x006d, B:26:0x0074, B:79:0x01b3, B:81:0x01b9, B:83:0x01c6, B:38:0x00ca, B:40:0x00d0, B:72:0x0176, B:74:0x0188, B:33:0x00af), top: B:92:0x0007, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0149 A[Catch: Exception -> 0x01d5, TryCatch #2 {Exception -> 0x01d5, blocks: (B:3:0x0007, B:5:0x0012, B:7:0x0016, B:9:0x001c, B:11:0x0033, B:13:0x003e, B:14:0x0044, B:16:0x004b, B:18:0x0057, B:20:0x005d, B:22:0x0063, B:29:0x0080, B:31:0x009d, B:46:0x00f4, B:58:0x0127, B:66:0x013e, B:70:0x014f, B:77:0x01ad, B:69:0x0149, B:65:0x0139, B:61:0x012f, B:51:0x0107, B:54:0x0116, B:45:0x00ef, B:36:0x00c5, B:24:0x006d, B:26:0x0074, B:79:0x01b3, B:81:0x01b9, B:83:0x01c6, B:38:0x00ca, B:40:0x00d0, B:72:0x0176, B:74:0x0188, B:33:0x00af), top: B:92:0x0007, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.Design.PageObjects.b> Y1(java.util.ArrayList<com.scores365.entitys.PlayByPlayMessageObj> r28) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.w.Y1(java.util.ArrayList):java.util.ArrayList");
    }

    private void b2(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList) {
        FilterCategoriesObj filterCategoriesObj;
        try {
            if (!this.E || (filterCategoriesObj = this.D.f().get(this.D.i())) == null) {
                return;
            }
            if (filterCategoriesObj.getClearFilter() == null || !filterCategoriesObj.getClearFilter().booleanValue()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = arrayList.get(size);
                    for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                        com.scores365.Design.PageObjects.b bVar = arrayList2.get(size2);
                        if (bVar instanceof q0.d) {
                            String g10 = this.D.g();
                            ArrayList<String> filterIds = ((q0.d) bVar).getMessage().getFilterIds();
                            for (int i10 = 0; i10 < filterIds.size(); i10++) {
                                filterIds.set(i10, filterIds.get(i10).toLowerCase());
                            }
                            if (!filterIds.contains(g10)) {
                                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    it.next().remove(bVar);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> c2(FilterCategoriesObj filterCategoriesObj) {
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = new ArrayList<>();
        try {
            ArrayList<PlayByPlayMessageObj> n10 = this.f21326s.n(filterCategoriesObj);
            if (!n10.isEmpty()) {
                if (this.f21331x.getSportID() == SportTypesEnum.HOCKEY.getValue()) {
                    Collections.reverse(n10);
                    arrayList.add(v2(n10));
                } else {
                    if (this.f21331x.getSportID() == SportTypesEnum.BASKETBALL.getValue()) {
                        Collections.reverse(n10);
                    }
                    arrayList.add(this.f21326s.b(n10));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private int d2() {
        try {
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            if (cVar == null || cVar.B() == null) {
                return -1;
            }
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            boolean z10 = false;
            int i10 = 0;
            while (it.hasNext()) {
                com.scores365.Design.PageObjects.b next = it.next();
                if (next instanceof yc.r) {
                    z10 = true;
                } else if ((z10 && (next instanceof com.scores365.gameCenter.gameCenterItems.f)) || (z10 && (next instanceof s0))) {
                    return i10 - 1;
                }
                i10++;
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    private int e2(String str) {
        int i10;
        boolean z10 = false;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    ArrayList<com.scores365.Design.PageObjects.b> B = getRvBaseAdapter().B();
                    i10 = 0;
                    while (i10 < B.size()) {
                        com.scores365.Design.PageObjects.b bVar = B.get(i10);
                        if ((bVar instanceof com.scores365.gameCenter.gameCenterItems.f) && ((com.scores365.gameCenter.gameCenterItems.f) bVar).l().getPbpEventKeys() != null && !((com.scores365.gameCenter.gameCenterItems.f) bVar).l().getPbpEventKeys().isEmpty() && ((com.scores365.gameCenter.gameCenterItems.f) bVar).l().getPbpEventKeys().equals(str)) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        i10 = -1;
        if (z10) {
            return i10;
        }
        return -1;
    }

    private int f2(yf.d dVar, int i10) {
        int i11;
        int i12 = -1;
        if (dVar == null || i10 <= -1) {
            return -1;
        }
        try {
            ArrayList<com.scores365.Design.PageObjects.b> B = getRvBaseAdapter().B();
            int i13 = 5;
            int i14 = -1;
            for (int i15 = 0; i15 < B.size(); i15++) {
                try {
                    com.scores365.Design.PageObjects.b bVar = B.get(i15);
                    if (bVar instanceof com.scores365.gameCenter.gameCenterItems.f) {
                        PlayByPlayMessageObj l10 = ((com.scores365.gameCenter.gameCenterItems.f) bVar).l();
                        try {
                            i11 = Integer.parseInt(l10.getTimeline());
                        } catch (NumberFormatException unused) {
                            i11 = -1;
                        }
                        int abs = (i11 < 0 || i10 < 0) ? -1 : Math.abs(i11 - i10);
                        int i16 = (l10 == null || l10.getPlayers() == null || l10.getPlayers().get(0) == null) ? -1 : l10.getPlayers().get(0).athleteId;
                        int sportifierEventTypeId = l10.getSportifierEventTypeId();
                        if (abs > -1 && abs < i13 && i16 > -1 && i16 == dVar.getAthleteID() && sportifierEventTypeId != -1 && (sportifierEventTypeId == dVar.getTypeId() || (l10.isSubstitutionEvent() && (dVar instanceof yf.e)))) {
                            i14 = i15;
                            i13 = abs;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    i12 = i14;
                    x0.N1(e);
                    return i12;
                }
            }
            return i14;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private int g2(int i10) {
        int i11;
        int i12 = -1;
        if (i10 <= -1) {
            return -1;
        }
        try {
            ArrayList<com.scores365.Design.PageObjects.b> B = getRvBaseAdapter().B();
            int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            int i14 = -1;
            for (int i15 = 0; i15 < B.size(); i15++) {
                try {
                    com.scores365.Design.PageObjects.b bVar = B.get(i15);
                    if (bVar instanceof com.scores365.gameCenter.gameCenterItems.f) {
                        try {
                            i11 = Integer.parseInt(((com.scores365.gameCenter.gameCenterItems.f) bVar).l().getTimeline());
                        } catch (NumberFormatException unused) {
                            i11 = -1;
                        }
                        int i16 = (i11 < 0 || i10 < 0) ? -1 : i11 - i10;
                        if (i16 > -1 && i16 <= i13) {
                            if (i16 == 0) {
                                return i15;
                            }
                            i14 = i15;
                            i13 = i16;
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    i12 = i14;
                    x0.N1(e);
                    return i12;
                }
            }
            return i14;
        } catch (Exception e11) {
            e = e11;
        }
    }

    private void h2() {
        try {
            this.f21330w = false;
            LoadDataAsync();
            ee.k.n(App.m(), "gamecenter", "play-by-play", "tab", "click", true, "game_id", String.valueOf(this.f21331x.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(this.f21331x), ShareConstants.FEED_SOURCE_PARAM, "tab", "tab", "all");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void handleSpinner(View view) {
        try {
            this.C = (Spinner) view.findViewById(R.id.Bq);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.tq);
            this.B = frameLayout;
            frameLayout.setVisibility(0);
            Spinner spinner = this.C;
            if (spinner instanceof CustomSpinner) {
                ((CustomSpinner) spinner).setSpinnerEventsListener(this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void i2() {
        try {
            ee.k.n(App.m(), "gamecenter", "play-by-play", "new-updates", "click", true, "game_id", String.valueOf(this.f21331x.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(this.f21331x), ShareConstants.FEED_SOURCE_PARAM, "tab", "tab", "important");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void j2() {
        try {
            ee.k.n(App.m(), "gamecenter", "play-by-play", "new-updates", ServerProtocol.DIALOG_PARAM_DISPLAY, true, "game_id", String.valueOf(this.f21331x.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(this.f21331x), ShareConstants.FEED_SOURCE_PARAM, "tab", "tab", "important");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(final int i10, final boolean z10) {
        Spinner spinner = this.C;
        if (spinner != null) {
            spinner.getHandler().post(new Runnable() { // from class: com.scores365.Pages.v
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.u2(i10, z10);
                }
            });
        }
    }

    private void l2() {
        try {
            this.f21330w = true;
            LoadDataAsync();
            ee.k.n(App.m(), "gamecenter", "play-by-play", "tab", "click", true, "game_id", String.valueOf(this.f21331x.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(this.f21331x), ShareConstants.FEED_SOURCE_PARAM, "tab", "tab", "important");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void m2() {
        try {
            this.D = new kd.b();
            this.C.setSelected(false);
            this.C.setOnItemSelectedListener(new a());
            this.C.setOnTouchListener(new b());
            this.D.l(this.f21326s.k());
            int j10 = this.D.j();
            this.D.m(j10);
            this.C.setAdapter((SpinnerAdapter) this.D);
            this.C.setSelection(j10, false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void o2() {
        try {
            if (this.f21327t.getVisibility() != 8) {
                if (this.A == null) {
                    this.A = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.A);
                }
                this.f21327t.startAnimation(this.A);
                this.f21327t.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void p2() {
        try {
            ConstraintLayout constraintLayout = this.f21329v;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean q2() {
        try {
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            if (cVar == null || cVar.B() == null) {
                return false;
            }
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof ag.r) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static boolean r2(CompObj compObj) {
        try {
            return compObj.getType() == CompObj.eCompetitorType.NATIONAL;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private boolean s2(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return true;
                }
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = arrayList.iterator();
                while (it.hasNext()) {
                    ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                    if (next != null && !next.isEmpty()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e10) {
                x0.N1(e10);
                return true;
            }
        }
        return true;
    }

    private boolean t2() {
        GameObj gameObj = this.f21331x;
        return gameObj != null && gameObj.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(int i10, boolean z10) {
        try {
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> c22 = c2(this.D.f().get(i10));
            if (c22.isEmpty()) {
                return;
            }
            this.D.m(i10);
            if (getRvBaseAdapter() != null) {
                getRvBaseAdapter().z();
            }
            n2(c22, true);
            String h10 = this.D.h();
            if (z10) {
                ee.k.o(this.C.getContext(), "gamecenter", "play-by-play", "tab", "click", "game_id", String.valueOf(this.f21331x.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.T(this.f21331x), "tab", h10, "click_type", "close");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static w w2(q0 q0Var, GameObj gameObj) {
        w wVar = new w();
        wVar.f21326s = q0Var;
        wVar.f21331x = gameObj;
        wVar.setArguments(new Bundle());
        return wVar;
    }

    private void x2(int i10, boolean z10) {
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            int id2 = A instanceof n0 ? ((n0) A).l().getId() : -1;
            HashMap hashMap = new HashMap();
            hashMap.put("game_id", Integer.valueOf(this.f21331x.getID()));
            hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(this.f21331x));
            hashMap.put("group_num", Integer.valueOf(id2));
            hashMap.put("click_type", z10 ? "open" : "close");
            ee.k.k(App.m(), "gamecenter", "play-by-play", "group", "click", hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y2() {
        try {
            if (this.f21331x.getSportID() != SportTypesEnum.HOCKEY.getValue()) {
                if (this.f21331x.getSportID() != SportTypesEnum.BASKETBALL.getValue()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2() {
        try {
            if (this.f21327t.getVisibility() != 0) {
                this.f21327t.setVisibility(0);
                j2();
                if (this.f21333z == null) {
                    this.f21333z = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.f21519s);
                }
                this.f21327t.setTranslationY(0.0f);
                this.f21327t.startAnimation(this.f21333z);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void A2() {
        try {
            this.B.setTranslationY(0.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.d
    protected void D1(int i10) {
        super.D1(i10);
        x2(i10, false);
    }

    @Override // com.scores365.Design.Pages.d
    protected void E1(int i10) {
        super.E1(i10);
        x2(i10, true);
    }

    @Override // com.scores365.Design.Pages.d
    protected void I1(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList, boolean z10) {
        try {
            Spinner spinner = this.C;
            if (spinner == null || spinner.getVisibility() != 0 || this.f21326s.k() == null) {
                if (!s2(arrayList)) {
                    n2(arrayList, z10);
                }
            } else if (this.f21326s.k().size() > this.D.f().size()) {
                this.D.l(this.f21326s.k());
                int j10 = this.D.j();
                this.C.setSelection(j10, false);
                k2(j10, false);
            } else if (!s2(arrayList)) {
                n2(arrayList, z10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.d
    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> K1() {
        ArrayList<PlayByPlayMessageObj> m10;
        GameObj gameObj;
        String playByPlayFeedURL;
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = new ArrayList<>();
        try {
            if (this.f21326s == null && (gameObj = this.f21331x) != null && (playByPlayFeedURL = gameObj.getPlayByPlayFeedURL()) != null && !playByPlayFeedURL.isEmpty()) {
                this.f21326s = new q0(playByPlayFeedURL, this.f21331x);
            }
            if (this.f21326s.v()) {
                this.f21326s.u(this, this.f21332y);
            } else {
                this.f21326s.f();
            }
            if (this.f21326s.v()) {
                if (this.f21331x.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                    arrayList = Z1();
                } else if (this.f21331x.getSportID() == SportTypesEnum.HOCKEY.getValue()) {
                    arrayList = a2();
                } else {
                    arrayList.add(new ArrayList<>());
                    if (this.f21330w) {
                        m10 = this.f21326s.m();
                    } else {
                        FilterCategoriesObj q10 = this.f21326s.q();
                        m10 = q10 != null ? this.f21326s.n(q10) : this.f21326s.o();
                    }
                    if (this.f21331x.getSportID() == SportTypesEnum.BASKETBALL.getValue()) {
                        Collections.reverse(m10);
                    }
                    if (this.E) {
                        arrayList.get(0).addAll(this.f21326s.b(m10));
                    } else {
                        arrayList.get(0).addAll(Y1(m10));
                    }
                    if (!s2(arrayList) && !this.E) {
                        arrayList.get(0).add(0, new yc.r(p0.l0("PLAY_BY_PLAY")));
                        arrayList.get(0).add(new r0());
                    }
                }
            }
            if (this.f21331x.getSportID() != SportTypesEnum.AMERICAN_FOOTBALL.getValue() && this.f21331x.getSportID() != SportTypesEnum.HOCKEY.getValue()) {
                if (!this.E && !this.f21330w && this.f21331x.hasMatchFacts()) {
                    if (arrayList.isEmpty()) {
                        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
                        arrayList2.add(new yc.r(p0.l0("MATCH_FACTS_APP")));
                        arrayList.add(arrayList2);
                    } else {
                        arrayList.get(0).add(new yc.r(p0.l0("MATCH_FACTS_APP")));
                    }
                    for (MatchFactsObj matchFactsObj : this.f21331x.getMatchFactsObj()) {
                        arrayList.get(0).add(new ag.q0(matchFactsObj));
                    }
                    if (!arrayList.isEmpty()) {
                        arrayList.get(0).add(new r0());
                    }
                }
                if (!this.E && this.f21326s.w()) {
                    arrayList.get(0).add(0, new ag.r(this.f21330w));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.gameCenter.q0.b
    public void M(ArrayList<PlayByPlayMessageObj> arrayList) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper() || arrayList == null || arrayList.isEmpty()) {
                return;
            }
            D2(arrayList);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.g, com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        FrameLayout frameLayout;
        super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
        if (i10 == 0) {
            try {
                o2();
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        if (!hasContentPadding() || (frameLayout = this.B) == null) {
            return;
        }
        frameLayout.setTranslationY(frameLayout.getTranslationY() - i13);
        if (this.B.getTranslationY() > 0.0f) {
            this.B.setTranslationY(0.0f);
        } else if (this.B.getTranslationY() < (-getPaddingSize())) {
            this.B.setTranslationY(-getPaddingSize());
        } else if (this.F) {
            this.B.setTranslationY(0.0f);
            if (getActivity() != null && (getActivity() instanceof GameCenterBaseActivity)) {
                ((GameCenterBaseActivity) getActivity()).showSubmenu();
            }
            this.F = false;
        }
    }

    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> X1(ArrayList<PlayByPlayMessageObj> arrayList) {
        PlayByPlayDriveObj playByPlayDriveObj;
        PlayerObj relevantPlayerObj;
        PlayerObj relevantPlayerObj2;
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> G1 = G1();
        try {
            ArrayList<PlayByPlayDriveObj> h10 = this.f21326s.h();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                PlayByPlayMessageObj playByPlayMessageObj = arrayList.get(size);
                Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = G1.iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    ArrayList<com.scores365.Design.PageObjects.b> next = it.next();
                    com.scores365.Design.PageObjects.b bVar = next.get(0);
                    if (bVar instanceof n0) {
                        PlayByPlayDriveObj l10 = ((n0) bVar).l();
                        if (l10.getId() == playByPlayMessageObj.getDriveId()) {
                            int competitorNum = l10.getCompetitorNum() - 1;
                            next.add(new ag.p0(playByPlayMessageObj, nb.o.d(relevantPlayerObj2.athleteId, false, r2(this.f21331x.getComps()[competitorNum]), playByPlayMessageObj.getRelevantPlayerObj().getImgVer()), this.f21331x, competitorNum));
                            z10 = true;
                        }
                    }
                }
                if (!z10) {
                    Iterator<PlayByPlayDriveObj> it2 = h10.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            playByPlayDriveObj = null;
                            break;
                        }
                        playByPlayDriveObj = it2.next();
                        if (playByPlayDriveObj.getId() == playByPlayMessageObj.getDriveId()) {
                            break;
                        }
                    }
                    if (playByPlayDriveObj != null) {
                        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
                        arrayList2.add(new n0(playByPlayDriveObj, this.f21331x));
                        int competitorNum2 = playByPlayDriveObj.getCompetitorNum() - 1;
                        arrayList2.add(new ag.p0(playByPlayMessageObj, nb.o.d(relevantPlayerObj.athleteId, false, r2(this.f21331x.getComps()[competitorNum2]), playByPlayMessageObj.getRelevantPlayerObj().getImgVer()), this.f21331x, competitorNum2));
                        G1.add(arrayList2);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        M1(G1);
        return G1;
    }

    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> Z1() {
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = new ArrayList<>();
        try {
            ArrayList<PlayByPlayMessageObj> o10 = this.f21326s.o();
            Iterator<PlayByPlayDriveObj> it = this.f21326s.h().iterator();
            while (it.hasNext()) {
                PlayByPlayDriveObj next = it.next();
                ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
                arrayList2.add(new n0(next, this.f21331x));
                Iterator<PlayByPlayMessageObj> it2 = o10.iterator();
                while (it2.hasNext()) {
                    PlayByPlayMessageObj next2 = it2.next();
                    if (next2.getDriveId() == next.getId()) {
                        int competitorNum = next.getCompetitorNum() - 1;
                        boolean r22 = r2(this.f21331x.getComps()[competitorNum]);
                        PlayerObj relevantPlayerObj = next2.getRelevantPlayerObj();
                        arrayList2.add(new ag.p0(next2, relevantPlayerObj != null ? nb.o.d(relevantPlayerObj.athleteId, false, r22, relevantPlayerObj.getImgVer()) : null, this.f21331x, competitorNum));
                    }
                }
                if (!arrayList2.isEmpty() && arrayList2.size() > 1) {
                    Collections.reverse(arrayList2.subList(1, arrayList2.size()));
                }
                arrayList.add(arrayList2);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> a2() {
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList = new ArrayList<>();
        try {
            FilterCategoriesObj q10 = this.f21326s.q();
            ArrayList<PlayByPlayMessageObj> n10 = q10 != null ? this.f21326s.n(q10) : this.f21326s.o();
            Collections.reverse(n10);
            arrayList.add(v2(n10));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.d
    protected String getBaseUrlPath() {
        return "";
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.g, com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.f22503d6;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.Design.Pages.q
    protected int getRecyclerViewResourceID() {
        return R.id.Km;
    }

    @Override // com.scores365.Design.Pages.q, com.scores365.Design.Pages.z
    public int getSwipeRefreshResourceID() {
        try {
            return R.id.Vj;
        } catch (Exception e10) {
            x0.N1(e10);
            return super.getSwipeRefreshResourceID();
        }
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    @Override // com.scores365.Design.Pages.d
    protected ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> getUpdateDataListItems(String str) {
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList;
        ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList2 = null;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    MessagesPBPObj messagesPBPObj = (MessagesPBPObj) GsonManager.getGson().l(str, MessagesPBPObj.class);
                    ArrayList<PlayByPlayMessageObj> g10 = this.f21326s.g(messagesPBPObj);
                    boolean z10 = messagesPBPObj != null && this.f21326s.y((long) messagesPBPObj.getTtl());
                    this.f21326s.z(messagesPBPObj);
                    if (this.f21331x.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                        arrayList = X1(g10);
                    } else {
                        ?? sportID = this.f21331x.getSportID();
                        try {
                            if (sportID == SportTypesEnum.HOCKEY.getValue()) {
                                arrayList = new ArrayList<>();
                                Collections.reverse(g10);
                                arrayList.add(v2(g10));
                            } else {
                                if (this.f21331x.getSportID() == SportTypesEnum.BASKETBALL.getValue()) {
                                    Collections.reverse(g10);
                                }
                                arrayList = new ArrayList<>();
                                arrayList.add(this.E ? this.f21326s.b(g10) : Y1(g10));
                            }
                        } catch (Exception e10) {
                            arrayList2 = sportID;
                            e = e10;
                            x0.N1(e);
                            return arrayList2;
                        }
                    }
                    arrayList2 = arrayList;
                    if (z10) {
                        startUpdater(false);
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        }
        return arrayList2;
    }

    @Override // com.scores365.Design.Pages.d
    protected String getUpdateUrl() {
        try {
            q0 q0Var = this.f21326s;
            if (q0Var != null) {
                return q0Var.s();
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.Design.Pages.d
    protected long getUpdatesStartDelay() {
        return TimeUnit.SECONDS.toMillis(3L);
    }

    @Override // com.scores365.Design.Pages.d
    protected long getUpdatesTimeInterval() {
        try {
            q0 q0Var = this.f21326s;
            long millis = q0Var != null ? TimeUnit.SECONDS.toMillis(q0Var.r()) : -1L;
            return millis < 1 ? TimeUnit.SECONDS.toMillis(10L) : millis;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1L;
        }
    }

    @Override // com.scores365.Design.Pages.g, com.scores365.Design.Pages.q, com.scores365.Design.Pages.a
    public void handleContentPadding() {
        super.handleContentPadding();
        if (this.E && hasContentPadding()) {
            ((ViewGroup.MarginLayoutParams) this.B.getLayoutParams()).topMargin = getPaddingSize();
            this.rvItems.setPadding(0, getPaddingSize() + p0.s(66), 0, p0.s(8));
        }
    }

    @Override // com.scores365.Design.Pages.g
    protected boolean hasNextItems() {
        return false;
    }

    @Override // com.scores365.Design.Pages.g
    protected boolean hasPreviousItems() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initParams() {
        try {
            this.f21332y = new Handler();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public boolean isSwipeEnabled() {
        return false;
    }

    protected void n2(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList, boolean z10) {
        int i10;
        int i11;
        try {
            if (this.rvBaseAdapter == null || arrayList == null || arrayList.isEmpty()) {
                return;
            }
            ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> G1 = G1();
            boolean q22 = q2();
            int d22 = d2();
            boolean z11 = false;
            if (q22) {
                i10 = d22;
                i11 = 2;
            } else {
                i10 = -1;
                if (d22 > -1) {
                    G1.get(0).remove(d22);
                    this.rvBaseAdapter.H(com.scores365.Design.Pages.e.C1(G1));
                    this.rvBaseAdapter.notifyItemRemoved(d22);
                    z11 = true;
                } else {
                    i10 = d22;
                }
                i11 = 0;
            }
            if (z11) {
                new Handler().postDelayed(new e(i10, arrayList, q22, G1, i11, this, z10), 400L);
            } else {
                C2(i10, arrayList, q22, G1, i11, z10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            try {
                if (view.getId() == R.id.Ps) {
                    i2();
                    int d10 = this.D.d();
                    k2(d10, false);
                    this.C.setSelection(d10, false);
                    new Handler().postDelayed(new d(), 250L);
                    o2();
                    this.F = true;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @Override // com.scores365.Design.Pages.d, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getArguments().putBoolean("shouldUpdaterStartFromOnResume", true);
    }

    @Override // com.scores365.Design.Pages.d, com.scores365.Design.Pages.q
    protected void onRecyclerViewItemClick(int i10) {
        try {
            super.onRecyclerViewItemClick(i10);
            if (this.rvBaseAdapter.A(i10).getObjectTypeNum() == lf.u.PlayByPlayChooserItem.ordinal()) {
                if (((ag.r) this.rvBaseAdapter.A(i10)).l()) {
                    l2();
                } else {
                    h2();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.CustomSpinner.OnSpinnerEventsListener
    public void onSpinnerClosed() {
        this.D.c(false);
        this.D.notifyDataSetChanged();
    }

    @Override // com.scores365.ui.CustomSpinner.OnSpinnerEventsListener
    public void onSpinnerOpened() {
        this.D.c(true);
        this.D.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087 A[Catch: Exception -> 0x008b, TRY_LEAVE, TryCatch #0 {Exception -> 0x008b, blocks: (B:3:0x0003, B:5:0x0059, B:6:0x0060, B:8:0x0071, B:13:0x0083, B:15:0x0087), top: B:20:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.scores365.Design.Pages.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void relateCustomViews(android.view.View r4) {
        /*
            r3 = this;
            super.relateCustomViews(r4)
            int r0 = com.scores365.R.id.f22151m3     // Catch: java.lang.Exception -> L8b
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Exception -> L8b
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0     // Catch: java.lang.Exception -> L8b
            r3.f21329v = r0     // Catch: java.lang.Exception -> L8b
            int r0 = com.scores365.R.id.HH     // Catch: java.lang.Exception -> L8b
            android.view.View r0 = r4.findViewById(r0)     // Catch: java.lang.Exception -> L8b
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch: java.lang.Exception -> L8b
            int r1 = com.scores365.R.id.Ps     // Catch: java.lang.Exception -> L8b
            android.view.View r1 = r4.findViewById(r1)     // Catch: java.lang.Exception -> L8b
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1     // Catch: java.lang.Exception -> L8b
            r3.f21327t = r1     // Catch: java.lang.Exception -> L8b
            int r1 = com.scores365.R.id.f22361ve     // Catch: java.lang.Exception -> L8b
            android.view.View r1 = r4.findViewById(r1)     // Catch: java.lang.Exception -> L8b
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch: java.lang.Exception -> L8b
            r3.f21328u = r1     // Catch: java.lang.Exception -> L8b
            android.widget.RelativeLayout r1 = r3.f21327t     // Catch: java.lang.Exception -> L8b
            r2 = 8
            r1.setVisibility(r2)     // Catch: java.lang.Exception -> L8b
            android.content.Context r1 = com.scores365.App.m()     // Catch: java.lang.Exception -> L8b
            android.graphics.Typeface r1 = li.o0.d(r1)     // Catch: java.lang.Exception -> L8b
            r0.setTypeface(r1)     // Catch: java.lang.Exception -> L8b
            java.lang.String r1 = "SOCIAL_FEED_NEW_UPDATES"
            java.lang.String r1 = li.p0.l0(r1)     // Catch: java.lang.Exception -> L8b
            r0.setText(r1)     // Catch: java.lang.Exception -> L8b
            android.widget.RelativeLayout r0 = r3.f21327t     // Catch: java.lang.Exception -> L8b
            int r1 = li.p0.s(r2)     // Catch: java.lang.Exception -> L8b
            float r1 = (float) r1     // Catch: java.lang.Exception -> L8b
            androidx.core.view.e1.C0(r0, r1)     // Catch: java.lang.Exception -> L8b
            android.widget.RelativeLayout r0 = r3.f21327t     // Catch: java.lang.Exception -> L8b
            r0.setOnClickListener(r3)     // Catch: java.lang.Exception -> L8b
            boolean r0 = r3.y2()     // Catch: java.lang.Exception -> L8b
            if (r0 == 0) goto L60
            android.widget.ImageView r0 = r3.f21328u     // Catch: java.lang.Exception -> L8b
            r1 = 1127481344(0x43340000, float:180.0)
            r0.setRotation(r1)     // Catch: java.lang.Exception -> L8b
        L60:
            r3.B2()     // Catch: java.lang.Exception -> L8b
            com.scores365.entitys.GameObj r0 = r3.f21331x     // Catch: java.lang.Exception -> L8b
            int r0 = r0.getSportID()     // Catch: java.lang.Exception -> L8b
            com.scores365.entitys.SportTypesEnum r1 = com.scores365.entitys.SportTypesEnum.BASKETBALL     // Catch: java.lang.Exception -> L8b
            int r1 = r1.getValue()     // Catch: java.lang.Exception -> L8b
            if (r0 == r1) goto L82
            com.scores365.entitys.GameObj r0 = r3.f21331x     // Catch: java.lang.Exception -> L8b
            int r0 = r0.getSportID()     // Catch: java.lang.Exception -> L8b
            com.scores365.entitys.SportTypesEnum r1 = com.scores365.entitys.SportTypesEnum.HOCKEY     // Catch: java.lang.Exception -> L8b
            int r1 = r1.getValue()     // Catch: java.lang.Exception -> L8b
            if (r0 != r1) goto L80
            goto L82
        L80:
            r0 = 0
            goto L83
        L82:
            r0 = 1
        L83:
            r3.E = r0     // Catch: java.lang.Exception -> L8b
            if (r0 == 0) goto L8f
            r3.handleSpinner(r4)     // Catch: java.lang.Exception -> L8b
            goto L8f
        L8b:
            r4 = move-exception
            li.x0.N1(r4)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.w.relateCustomViews(android.view.View):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0071 A[Catch: Exception -> 0x0095, TryCatch #0 {Exception -> 0x0095, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000f, B:10:0x0033, B:12:0x0071, B:14:0x0077, B:19:0x0081, B:21:0x0087, B:22:0x008f, B:9:0x0020), top: B:27:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077 A[Catch: Exception -> 0x0095, TryCatch #0 {Exception -> 0x0095, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000f, B:10:0x0033, B:12:0x0071, B:14:0x0077, B:19:0x0081, B:21:0x0087, B:22:0x008f, B:9:0x0020), top: B:27:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    @Override // com.scores365.Design.Pages.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends java.util.Collection> void renderData(T r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L20
            boolean r1 = r6.isEmpty()     // Catch: java.lang.Exception -> L95
            if (r1 != 0) goto L20
            boolean r1 = r5.isListEmpty()     // Catch: java.lang.Exception -> L95
            if (r1 != 0) goto L20
            androidx.recyclerview.widget.RecyclerView r1 = r5.rvItems     // Catch: java.lang.Exception -> L95
            r1.setVisibility(r0)     // Catch: java.lang.Exception -> L95
            com.scores365.Design.Pages.c r1 = new com.scores365.Design.Pages.c     // Catch: java.lang.Exception -> L95
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch: java.lang.Exception -> L95
            com.scores365.Design.Pages.q$e r2 = r5.recylerItemClickListener     // Catch: java.lang.Exception -> L95
            r1.<init>(r6, r2)     // Catch: java.lang.Exception -> L95
            r5.rvBaseAdapter = r1     // Catch: java.lang.Exception -> L95
            goto L33
        L20:
            androidx.recyclerview.widget.RecyclerView r6 = r5.rvItems     // Catch: java.lang.Exception -> L95
            r6.setVisibility(r0)     // Catch: java.lang.Exception -> L95
            com.scores365.Design.Pages.c r6 = new com.scores365.Design.Pages.c     // Catch: java.lang.Exception -> L95
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L95
            r1.<init>()     // Catch: java.lang.Exception -> L95
            com.scores365.Design.Pages.q$e r2 = r5.recylerItemClickListener     // Catch: java.lang.Exception -> L95
            r6.<init>(r1, r2)     // Catch: java.lang.Exception -> L95
            r5.rvBaseAdapter = r6     // Catch: java.lang.Exception -> L95
        L33:
            androidx.recyclerview.widget.RecyclerView r6 = r5.rvItems     // Catch: java.lang.Exception -> L95
            r6.setHasFixedSize(r0)     // Catch: java.lang.Exception -> L95
            androidx.recyclerview.widget.RecyclerView r6 = r5.rvItems     // Catch: java.lang.Exception -> L95
            com.scores365.Design.Pages.c r1 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> L95
            r6.setAdapter(r1)     // Catch: java.lang.Exception -> L95
            r5.m2()     // Catch: java.lang.Exception -> L95
            r5.p2()     // Catch: java.lang.Exception -> L95
            r5.onDataRendered()     // Catch: java.lang.Exception -> L95
            com.scores365.gameCenter.q0 r6 = r5.f21326s     // Catch: java.lang.Exception -> L95
            java.lang.String r6 = r6.p()     // Catch: java.lang.Exception -> L95
            com.scores365.gameCenter.q0 r1 = r5.f21326s     // Catch: java.lang.Exception -> L95
            yf.d r1 = r1.j()     // Catch: java.lang.Exception -> L95
            com.scores365.gameCenter.q0 r2 = r5.f21326s     // Catch: java.lang.Exception -> L95
            int r2 = r2.i()     // Catch: java.lang.Exception -> L95
            com.scores365.gameCenter.q0 r3 = r5.f21326s     // Catch: java.lang.Exception -> L95
            r4 = 0
            r3.D(r4)     // Catch: java.lang.Exception -> L95
            com.scores365.gameCenter.q0 r3 = r5.f21326s     // Catch: java.lang.Exception -> L95
            r3.B(r4)     // Catch: java.lang.Exception -> L95
            com.scores365.gameCenter.q0 r3 = r5.f21326s     // Catch: java.lang.Exception -> L95
            r4 = -1
            r3.A(r4)     // Catch: java.lang.Exception -> L95
            int r6 = r5.e2(r6)     // Catch: java.lang.Exception -> L95
            if (r6 >= 0) goto L75
            int r6 = r5.f2(r1, r2)     // Catch: java.lang.Exception -> L95
        L75:
            if (r6 >= 0) goto L7b
            int r6 = r5.g2(r2)     // Catch: java.lang.Exception -> L95
        L7b:
            if (r6 >= 0) goto L7e
            goto L7f
        L7e:
            r0 = r6
        L7f:
            if (r0 != 0) goto L8f
            boolean r6 = r5.t2()     // Catch: java.lang.Exception -> L95
            if (r6 == 0) goto L8f
            com.scores365.Design.Pages.c r6 = r5.rvBaseAdapter     // Catch: java.lang.Exception -> L95
            int r6 = r6.getItemCount()     // Catch: java.lang.Exception -> L95
            int r0 = r6 + (-1)
        L8f:
            androidx.recyclerview.widget.RecyclerView r6 = r5.rvItems     // Catch: java.lang.Exception -> L95
            r6.p1(r0)     // Catch: java.lang.Exception -> L95
            goto L99
        L95:
            r6 = move-exception
            li.x0.N1(r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.w.renderData(java.util.Collection):void");
    }

    @Override // com.scores365.Design.Pages.d
    protected boolean useBaseUrlPath() {
        return false;
    }

    protected ArrayList<com.scores365.Design.PageObjects.b> v2(ArrayList<PlayByPlayMessageObj> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            Iterator<PlayByPlayMessageObj> it = arrayList.iterator();
            while (it.hasNext()) {
                PlayByPlayMessageObj next = it.next();
                if (next.isStatic()) {
                    arrayList2.add(new ag.x0(next, this.f21331x));
                } else {
                    arrayList2.add(new w0(next, this.f21331x));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }
}
