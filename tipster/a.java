package com.scores365.tipster;

import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.b0;
import com.amazon.device.ads.DtbConstants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.Design.PageObjects.b;
import com.scores365.R;
import com.scores365.bets.model.BetLineOption;
import com.scores365.entitys.DailyTipObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.PurchasesObj;
import com.scores365.entitys.TipBalanceObj;
import com.scores365.entitys.TipMetadataObj;
import com.scores365.entitys.TipPurchaseObj;
import com.scores365.insight.InsightBetLineObj;
import com.scores365.insight.RelatedOddsObj;
import com.scores365.insight.SingleInsightObj;
import com.scores365.ui.GeneralNotificationListFragment;
import com.scores365.ui.WebViewActivity;
import ee.k;
import fi.l;
import gi.b;
import gi.c;
import gi.e;
import gi.i;
import gi.m;
import gi.n;
import gi.r;
import gi.w;
import gi.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.p0;
import li.x0;
/* compiled from: TipsterMgr.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f24303a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f24304b = 3;

    /* compiled from: TipsterMgr.java */
    /* renamed from: com.scores365.tipster.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class View$OnClickListenerC0259a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final String f24305a;

        /* renamed from: b  reason: collision with root package name */
        private final String f24306b;

        public View$OnClickListenerC0259a(String str, String str2) {
            this.f24305a = str;
            this.f24306b = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(App.m(), WebViewActivity.class);
                intent.putExtra("url", p0.l0("TIPS_ELUA"));
                intent.setFlags(268435456);
                App.m().startActivity(intent);
                HashMap hashMap = new HashMap();
                if (!this.f24305a.isEmpty()) {
                    hashMap.put("screen", this.f24305a);
                }
                hashMap.put(ShareConstants.FEED_SOURCE_PARAM, this.f24306b);
                hashMap.put("type", "0");
                k.m(App.m(), "tip-sale", "eula", "click", null, true, hashMap);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private static boolean a(RelatedOddsObj relatedOddsObj, int i10, int i11) {
        try {
            if (relatedOddsObj.linesMap.get(Integer.valueOf(i10)) != null) {
                for (BetLineOption betLineOption : relatedOddsObj.linesMap.get(Integer.valueOf(i10)).lineOptions) {
                    if (betLineOption.getNum() == i11) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static boolean b(PurchasesObj purchasesObj, DailyTipObj dailyTipObj) {
        if (purchasesObj == null) {
            return false;
        }
        try {
            ArrayList<TipPurchaseObj> activePurchases = purchasesObj.getActivePurchases();
            LinkedHashMap<Integer, SingleInsightObj> linkedHashMap = dailyTipObj == null ? null : dailyTipObj.insightsMap;
            if (activePurchases != null) {
                for (TipPurchaseObj tipPurchaseObj : activePurchases) {
                    TipMetadataObj tipMetadataObj = tipPurchaseObj.tipMetadata;
                    int i10 = tipMetadataObj.entityId;
                    if (tipMetadataObj.purchaseType.equals("TipSubscription") || tipPurchaseObj.tipMetadata.purchaseType.equals("TipSubscription30") || i10 == -1) {
                        return true;
                    }
                    if (linkedHashMap != null && linkedHashMap.containsKey(Integer.valueOf(i10))) {
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            ng.a.f35508a.a("TipsterMgr", "error parsing active purchases", e10);
        }
        return false;
    }

    private static boolean c(@NonNull DailyTipObj dailyTipObj) {
        LinkedHashMap<Integer, SingleInsightObj> linkedHashMap = dailyTipObj.insightsMap;
        return (linkedHashMap == null || linkedHashMap.isEmpty()) ? false : true;
    }

    private static boolean d(@NonNull PurchasesObj purchasesObj) {
        TipBalanceObj tipBalanceObj = purchasesObj.tipBalance;
        if (tipBalanceObj == null) {
            return false;
        }
        return tipBalanceObj.getFreeTipCount() > 0 || tipBalanceObj.getTipCount() > 0 || tipBalanceObj.shouldUseRefundData();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0160 A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:3:0x000b, B:5:0x0014, B:13:0x0032, B:16:0x0051, B:18:0x0057, B:20:0x0069, B:22:0x007b, B:24:0x009a, B:26:0x00a8, B:28:0x00ac, B:29:0x00bc, B:31:0x00d3, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:43:0x0160, B:44:0x0165, B:46:0x0177, B:47:0x017c, B:49:0x0182, B:51:0x01b9, B:52:0x01bc, B:54:0x01c5, B:55:0x01cd, B:57:0x01d7, B:59:0x01db, B:76:0x026a, B:23:0x008b, B:61:0x01eb, B:63:0x0201, B:65:0x0208, B:69:0x0212, B:70:0x0215, B:74:0x0228, B:73:0x021c), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0177 A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:3:0x000b, B:5:0x0014, B:13:0x0032, B:16:0x0051, B:18:0x0057, B:20:0x0069, B:22:0x007b, B:24:0x009a, B:26:0x00a8, B:28:0x00ac, B:29:0x00bc, B:31:0x00d3, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:43:0x0160, B:44:0x0165, B:46:0x0177, B:47:0x017c, B:49:0x0182, B:51:0x01b9, B:52:0x01bc, B:54:0x01c5, B:55:0x01cd, B:57:0x01d7, B:59:0x01db, B:76:0x026a, B:23:0x008b, B:61:0x01eb, B:63:0x0201, B:65:0x0208, B:69:0x0212, B:70:0x0215, B:74:0x0228, B:73:0x021c), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b9 A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:3:0x000b, B:5:0x0014, B:13:0x0032, B:16:0x0051, B:18:0x0057, B:20:0x0069, B:22:0x007b, B:24:0x009a, B:26:0x00a8, B:28:0x00ac, B:29:0x00bc, B:31:0x00d3, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:43:0x0160, B:44:0x0165, B:46:0x0177, B:47:0x017c, B:49:0x0182, B:51:0x01b9, B:52:0x01bc, B:54:0x01c5, B:55:0x01cd, B:57:0x01d7, B:59:0x01db, B:76:0x026a, B:23:0x008b, B:61:0x01eb, B:63:0x0201, B:65:0x0208, B:69:0x0212, B:70:0x0215, B:74:0x0228, B:73:0x021c), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c5 A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:3:0x000b, B:5:0x0014, B:13:0x0032, B:16:0x0051, B:18:0x0057, B:20:0x0069, B:22:0x007b, B:24:0x009a, B:26:0x00a8, B:28:0x00ac, B:29:0x00bc, B:31:0x00d3, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:43:0x0160, B:44:0x0165, B:46:0x0177, B:47:0x017c, B:49:0x0182, B:51:0x01b9, B:52:0x01bc, B:54:0x01c5, B:55:0x01cd, B:57:0x01d7, B:59:0x01db, B:76:0x026a, B:23:0x008b, B:61:0x01eb, B:63:0x0201, B:65:0x0208, B:69:0x0212, B:70:0x0215, B:74:0x0228, B:73:0x021c), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0212 A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:3:0x000b, B:5:0x0014, B:13:0x0032, B:16:0x0051, B:18:0x0057, B:20:0x0069, B:22:0x007b, B:24:0x009a, B:26:0x00a8, B:28:0x00ac, B:29:0x00bc, B:31:0x00d3, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:43:0x0160, B:44:0x0165, B:46:0x0177, B:47:0x017c, B:49:0x0182, B:51:0x01b9, B:52:0x01bc, B:54:0x01c5, B:55:0x01cd, B:57:0x01d7, B:59:0x01db, B:76:0x026a, B:23:0x008b, B:61:0x01eb, B:63:0x0201, B:65:0x0208, B:69:0x0212, B:70:0x0215, B:74:0x0228, B:73:0x021c), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021c A[Catch: Exception -> 0x026e, TryCatch #0 {Exception -> 0x026e, blocks: (B:3:0x000b, B:5:0x0014, B:13:0x0032, B:16:0x0051, B:18:0x0057, B:20:0x0069, B:22:0x007b, B:24:0x009a, B:26:0x00a8, B:28:0x00ac, B:29:0x00bc, B:31:0x00d3, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:43:0x0160, B:44:0x0165, B:46:0x0177, B:47:0x017c, B:49:0x0182, B:51:0x01b9, B:52:0x01bc, B:54:0x01c5, B:55:0x01cd, B:57:0x01d7, B:59:0x01db, B:76:0x026a, B:23:0x008b, B:61:0x01eb, B:63:0x0201, B:65:0x0208, B:69:0x0212, B:70:0x0215, B:74:0x0228, B:73:0x021c), top: B:81:0x000b }] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<com.scores365.Design.PageObjects.b> e(@androidx.annotation.NonNull ne.b r26, com.scores365.entitys.DailyTipObj r27, com.scores365.entitys.PurchasesObj r28, fi.l r29, boolean r30, @androidx.annotation.NonNull androidx.lifecycle.b0<java.lang.Boolean> r31) {
        /*
            Method dump skipped, instructions count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.tipster.a.e(ne.b, com.scores365.entitys.DailyTipObj, com.scores365.entitys.PurchasesObj, fi.l, boolean, androidx.lifecycle.b0):java.util.ArrayList");
    }

    public static ArrayList<b> f(@NonNull ne.b bVar, DailyTipObj dailyTipObj, PurchasesObj purchasesObj, int i10, l lVar, boolean z10) {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            arrayList.add(new n(dailyTipObj.agents.get(0), true));
            if (z10) {
                arrayList.addAll(i(bVar, dailyTipObj, purchasesObj, i10, lVar));
            } else {
                arrayList.addAll(h(bVar, purchasesObj, lVar));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @NonNull
    private static ArrayList<b> g(@NonNull ne.b bVar, @NonNull DailyTipObj dailyTipObj, @NonNull PurchasesObj purchasesObj, int i10, l lVar, boolean z10, @NonNull b0<Boolean> b0Var) {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            arrayList.add(new n(dailyTipObj.agents.get(0), true));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (!z10 && !d(purchasesObj)) {
            arrayList.addAll(w(bVar, dailyTipObj, purchasesObj, lVar, b0Var));
            return arrayList;
        }
        if (dailyTipObj.isSingle(i10)) {
            arrayList.addAll(z(bVar, dailyTipObj, purchasesObj, lVar, z10, b0Var));
        } else {
            arrayList.addAll(e(bVar, dailyTipObj, purchasesObj, lVar, z10, b0Var));
        }
        return arrayList;
    }

    @NonNull
    private static ArrayList<b> h(@NonNull ne.b bVar, PurchasesObj purchasesObj, l lVar) {
        int i10;
        m mVar;
        String str;
        TipBalanceObj tipBalanceObj;
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            arrayList.add(new gi.b(false, b.c.AlarmClock, "", true));
            if (purchasesObj == null || (tipBalanceObj = purchasesObj.tipBalance) == null) {
                i10 = 0;
            } else {
                r7 = tipBalanceObj.getFreeTipCount() > 0;
                i10 = purchasesObj.tipBalance.getTipCount();
            }
            lVar.N1(false, false, r7, false, false, false, false);
            String E1 = lVar.E1();
            String sourceForAnalytics = lVar.getSourceForAnalytics();
            if (r7) {
                mVar = new m(p0.l0("TIPS_IN_APP_FREE_BUTTON"), true, false, true, false, purchasesObj.tipBalance.getFreeTipCount());
            } else if (bVar.F()) {
                mVar = null;
            } else {
                String l02 = p0.l0("TIPS_SINGLE_TIP");
                try {
                    str = p0.l0("TIPS_SINGLE_TIP").replace("#PRICE", bVar.C("single_tip_product"));
                } catch (Exception e10) {
                    x0.N1(e10);
                    str = l02;
                }
                mVar = new m(str, true, true, false, false, i10);
            }
            if (mVar != null) {
                arrayList.add(mVar);
            }
            arrayList.add(p());
            arrayList.add(new w(p0.l0("SUBSCRIPTIONS_PLANS")));
            arrayList.add(new y());
            arrayList.add(new i(E1, sourceForAnalytics, true));
        } catch (Exception e11) {
            x0.N1(e11);
        }
        return arrayList;
    }

    @NonNull
    private static ArrayList<com.scores365.Design.PageObjects.b> i(@NonNull ne.b bVar, DailyTipObj dailyTipObj, PurchasesObj purchasesObj, int i10, l lVar) {
        String l10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            lVar.N1(false, true, false, false, false, false, false);
            LinkedHashMap<Integer, SingleInsightObj> linkedHashMap = dailyTipObj.insightsMap;
            if (linkedHashMap == null || linkedHashMap.get(Integer.valueOf(i10)) == null) {
                if (linkedHashMap != null && v(purchasesObj, linkedHashMap.values().iterator().next().getID())) {
                    lVar.Q1(true);
                    arrayList.add(new gi.b(true, b.c.AlarmClock, "", false));
                    arrayList.add(new i(lVar.E1(), lVar.getSourceForAnalytics(), true));
                } else if (t(purchasesObj)) {
                    arrayList.add(new gi.b(true, b.c.AlarmClock, p0.l0("TIPS_WEEKLY_PURCHASED"), false));
                    if (!s(purchasesObj) && u(purchasesObj) && (l10 = l(bVar, purchasesObj, null)) != null) {
                        arrayList.add(new r(l10, true));
                    }
                    arrayList.add(new y());
                } else {
                    lVar.Q1(true);
                    arrayList.add(new gi.b(true, b.c.AlarmClock, "", true));
                    String l11 = l(bVar, purchasesObj, null);
                    if (l11 != null) {
                        arrayList.add(new r(l11, true));
                    }
                    arrayList.add(new y());
                    arrayList.add(new i(lVar.E1(), lVar.getSourceForAnalytics(), true));
                }
            } else if (linkedHashMap.get(Integer.valueOf(i10)).innerInsight != null) {
                arrayList.add(new gi.b(true, b.c.DailyDouble, "", true));
            } else {
                arrayList.add(new gi.b(true, b.c.AlarmClock, "", false));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @NonNull
    public static ArrayList<com.scores365.Design.PageObjects.b> j(@NonNull ne.b bVar, @NonNull DailyTipObj dailyTipObj, @NonNull PurchasesObj purchasesObj, int i10, l lVar, boolean z10, @NonNull b0<Boolean> b0Var) {
        try {
            return c(dailyTipObj) ? g(bVar, dailyTipObj, purchasesObj, i10, lVar, z10, b0Var) : f(bVar, dailyTipObj, purchasesObj, i10, lVar, z10);
        } catch (Exception e10) {
            x0.N1(e10);
            return new ArrayList<>(0);
        }
    }

    private static String k(@NonNull ne.b bVar, PurchasesObj purchasesObj) {
        String str = null;
        try {
            if (!bVar.c0("tips_monthly_subs2")) {
                if (bVar.c0("tips_weekly_subs2")) {
                    str = p0.l0("SUBSCRIPTIONS_MONTHLY_DISCOUNT");
                } else if (bVar.c0("single_tip_product") || q(purchasesObj)) {
                    str = p0.l0("SUBSCRIPTIONS_PLANS");
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return str;
    }

    private static String l(@NonNull ne.b bVar, PurchasesObj purchasesObj, DailyTipObj dailyTipObj) {
        LinkedHashMap<Integer, SingleInsightObj> linkedHashMap;
        int i10;
        if (dailyTipObj != null && (linkedHashMap = dailyTipObj.insightsMap) != null) {
            try {
                try {
                    i10 = ((Integer) linkedHashMap.keySet().toArray()[0]).intValue();
                } catch (Exception e10) {
                    x0.N1(e10);
                    i10 = -1;
                }
                if (!bVar.c0("tips_monthly_subs2")) {
                    if (bVar.c0("tips_weekly_subs2")) {
                        return p0.l0("SUBSCRIPTIONS_MONTHLY_DISCOUNT");
                    }
                    if (b(purchasesObj, dailyTipObj) || r(purchasesObj, i10)) {
                        return p0.l0("SUBSCRIPTIONS_PLANS");
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
            return null;
        }
        return k(bVar, purchasesObj);
    }

    public static String m(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        return z14 ? z15 ? "11" : "12" : z10 ? z11 ? z15 ? "10" : "9" : z15 ? z12 ? "8" : "7" : z16 ? z12 ? "14" : DtbConstants.NETWORK_TYPE_LTE : z12 ? "6" : "5" : z11 ? z13 ? GeneralNotificationListFragment.ANALYTICS_ENTITY_TYPE_SPORT_TYPE : "4" : z12 ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    public static SingleInsightObj n(ArrayList<SingleInsightObj> arrayList, DailyTipObj dailyTipObj) {
        try {
            Iterator<SingleInsightObj> it = arrayList.iterator();
            while (it.hasNext()) {
                SingleInsightObj next = it.next();
                if (next.getBetLine() != null && a(dailyTipObj.relatedOdds, next.getBetLine().lineId, next.getBetLine().optionNum)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static int o(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return 0;
                }
                return R.drawable.D3;
            }
            return R.drawable.f21744k1;
        }
        return R.drawable.f21762m3;
    }

    private static e p() {
        return new e(p0.l0("PURCHASE_SCREEN_TITLE"));
    }

    public static boolean q(PurchasesObj purchasesObj) {
        if (purchasesObj != null) {
            try {
                if (purchasesObj.getActivePurchases() == null) {
                    return false;
                }
                Iterator<TipPurchaseObj> it = purchasesObj.getActivePurchases().iterator();
                while (it.hasNext()) {
                    if (it.next().tipMetadata.purchaseType.equals("FreeTip")) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    private static boolean r(PurchasesObj purchasesObj, int i10) {
        try {
            if (purchasesObj.getActivePurchases() != null) {
                Iterator<TipPurchaseObj> it = purchasesObj.getActivePurchases().iterator();
                while (it.hasNext()) {
                    if (i10 == it.next().tipMetadata.entityId) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private static boolean s(PurchasesObj purchasesObj) {
        String str;
        if (purchasesObj != null) {
            try {
                if (purchasesObj.getActivePurchases() == null || purchasesObj.getActivePurchases().isEmpty()) {
                    return false;
                }
                Iterator<TipPurchaseObj> it = purchasesObj.getActivePurchases().iterator();
                while (it.hasNext()) {
                    TipMetadataObj tipMetadataObj = it.next().tipMetadata;
                    if (tipMetadataObj != null && (str = tipMetadataObj.purchaseType) != null && str.equals("TipSubscription30")) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    private static boolean t(PurchasesObj purchasesObj) {
        if (purchasesObj != null) {
            try {
                if (purchasesObj.getActivePurchases() == null || purchasesObj.getActivePurchases().isEmpty()) {
                    return false;
                }
                Iterator<TipPurchaseObj> it = purchasesObj.getActivePurchases().iterator();
                while (it.hasNext()) {
                    TipPurchaseObj next = it.next();
                    TipMetadataObj tipMetadataObj = next.tipMetadata;
                    if (tipMetadataObj != null && (tipMetadataObj.purchaseType.equals("TipSubscription") || next.tipMetadata.purchaseType.equals("TipSubscription30"))) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    private static boolean u(PurchasesObj purchasesObj) {
        String str;
        if (purchasesObj != null) {
            try {
                if (purchasesObj.getActivePurchases() == null || purchasesObj.getActivePurchases().isEmpty()) {
                    return false;
                }
                Iterator<TipPurchaseObj> it = purchasesObj.getActivePurchases().iterator();
                while (it.hasNext()) {
                    TipPurchaseObj next = it.next();
                    TipMetadataObj tipMetadataObj = next.tipMetadata;
                    if (tipMetadataObj != null && (str = tipMetadataObj.purchaseType) != null && (str.equals("TipSubscription") || next.tipMetadata.purchaseType.equals("TipSubscription7"))) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    private static boolean v(PurchasesObj purchasesObj, int i10) {
        if (purchasesObj != null) {
            try {
                if (purchasesObj.getActivePurchases() == null) {
                    return false;
                }
                Iterator<TipPurchaseObj> it = purchasesObj.getActivePurchases().iterator();
                while (it.hasNext()) {
                    TipMetadataObj tipMetadataObj = it.next().tipMetadata;
                    if (tipMetadataObj.entityId == i10 && tipMetadataObj.purchaseType.equals("Tip")) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    @NonNull
    private static ArrayList<com.scores365.Design.PageObjects.b> w(@NonNull ne.b bVar, @NonNull DailyTipObj dailyTipObj, @NonNull PurchasesObj purchasesObj, l lVar, @NonNull b0<Boolean> b0Var) {
        GameObj gameObj;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<Integer, SingleInsightObj> linkedHashMap = dailyTipObj.insightsMap;
            SingleInsightObj next = linkedHashMap == null ? null : linkedHashMap.values().iterator().next();
            int id2 = next == null ? -1 : next.getID();
            boolean isSingle = dailyTipObj.isSingle(id2);
            boolean d10 = d(purchasesObj);
            boolean z10 = (next == null || next.gameObj == null) ? false : true;
            lVar.N1(true, false, d10, false, false, !isSingle, !z10);
            String E1 = lVar.E1();
            String sourceForAnalytics = lVar.getSourceForAnalytics();
            if (!isSingle) {
                arrayList.add(new gi.b(false, b.c.DailyDouble, "", true));
            } else if (z10) {
                arrayList.add(new c(next.gameObj, E1, String.valueOf(dailyTipObj.agents.get(0).getID()), next.outcome, true, x(id2, purchasesObj), b0Var));
            } else {
                arrayList.add(new gi.b(false, b.c.DailySingle, p0.l0("TIPS_OUR_DAILY_TIP"), false));
            }
            lVar.P1("4");
            if (isSingle && (gameObj = next.gameObj) != null) {
                lVar.O1(String.valueOf(gameObj.getID()));
            }
            arrayList.add(d10 ? new m(p0.l0("TIPS_IN_APP_FREE_BUTTON").replace("#NUM_OF_FREE_TIPS", String.valueOf(purchasesObj.tipBalance.getFreeTipCount())), true, false, true, false, purchasesObj.tipBalance.getFreeTipCount()) : new m(p0.l0("TIPS_IN_APP_PAID_TEXT").replace("#PRICE", bVar.C("single_tip_product")), true, true, false, false, purchasesObj.tipBalance.getFreeTipCount()));
            arrayList.add(p());
            arrayList.add(new w(p0.l0("SUBSCRIPTIONS_PLANS")));
            arrayList.add(new y());
            arrayList.add(new i(E1, sourceForAnalytics, true));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018 A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #0 {Exception -> 0x0029, blocks: (B:4:0x0003, B:7:0x000a, B:8:0x0012, B:10:0x0018), top: B:18:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean x(int r3, com.scores365.entitys.PurchasesObj r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L2d
            java.util.ArrayList r1 = r4.getActivePurchases()     // Catch: java.lang.Exception -> L29
            if (r1 != 0) goto La
            goto L2d
        La:
            java.util.ArrayList r4 = r4.getActivePurchases()     // Catch: java.lang.Exception -> L29
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L29
        L12:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Exception -> L29
            if (r1 == 0) goto L2d
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Exception -> L29
            com.scores365.entitys.TipPurchaseObj r1 = (com.scores365.entitys.TipPurchaseObj) r1     // Catch: java.lang.Exception -> L29
            com.scores365.entitys.TipMetadataObj r1 = r1.tipMetadata     // Catch: java.lang.Exception -> L29
            int r1 = r1.entityId     // Catch: java.lang.Exception -> L29
            if (r1 == r3) goto L27
            r2 = -1
            if (r1 != r2) goto L12
        L27:
            r0 = 1
            goto L2d
        L29:
            r3 = move-exception
            li.x0.N1(r3)
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.tipster.a.x(int, com.scores365.entitys.PurchasesObj):boolean");
    }

    private static boolean y(SingleInsightObj singleInsightObj, RelatedOddsObj relatedOddsObj) {
        InsightBetLineObj betLine = singleInsightObj.getBetLine();
        try {
            return x0.s2() && a(relatedOddsObj, betLine.lineId, betLine.optionNum);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0185 A[Catch: Exception -> 0x01fd, TryCatch #0 {Exception -> 0x01fd, blocks: (B:3:0x000b, B:5:0x001a, B:10:0x0031, B:15:0x0055, B:20:0x007d, B:22:0x0081, B:25:0x00c2, B:28:0x00ca, B:30:0x00dc, B:31:0x0106, B:33:0x010c, B:36:0x0115, B:38:0x017f, B:40:0x0185, B:41:0x018d, B:43:0x0197, B:45:0x019b, B:52:0x01f9, B:37:0x0169, B:48:0x01b5, B:49:0x01ce, B:23:0x00b0, B:18:0x006c), top: B:57:0x000b }] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList<com.scores365.Design.PageObjects.b> z(@androidx.annotation.NonNull ne.b r25, com.scores365.entitys.DailyTipObj r26, com.scores365.entitys.PurchasesObj r27, fi.l r28, boolean r29, @androidx.annotation.NonNull androidx.lifecycle.b0<java.lang.Boolean> r30) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.tipster.a.z(ne.b, com.scores365.entitys.DailyTipObj, com.scores365.entitys.PurchasesObj, fi.l, boolean, androidx.lifecycle.b0):java.util.ArrayList");
    }
}
