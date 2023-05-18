package com.scores365.NewsCenter;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import cc.o0;
import com.scores365.App;
import com.scores365.api.l;
import com.scores365.branding.BrandingKey;
import com.scores365.branding.BrandingStripItem;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.EntityConnection;
import com.scores365.entitys.ImageDetailObj;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.TransferObj;
import com.scores365.entitys.eTransferStatus;
import com.scores365.removeAds.RemoveAdsManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import lf.d;
import lf.o;
import li.j0;
import li.p0;
import li.x0;
import sc.f;
import sc.i;
import xc.h;
import xc.j;
import xc.k;
/* compiled from: NewsDataMgr.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f21153a = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NewsDataMgr.java */
    /* loaded from: classes2.dex */
    public class a extends AsyncTask<Void, Void, NewsObj> {

        /* renamed from: a  reason: collision with root package name */
        int f21154a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<Integer> f21155b;

        /* renamed from: c  reason: collision with root package name */
        InterfaceC0234b f21156c;

        /* renamed from: e  reason: collision with root package name */
        int f21158e = 15;

        /* renamed from: d  reason: collision with root package name */
        boolean f21157d = true;

        public a(int i10, InterfaceC0234b interfaceC0234b) {
            this.f21154a = i10;
            this.f21156c = interfaceC0234b;
        }

        public a(ArrayList<Integer> arrayList, InterfaceC0234b interfaceC0234b) {
            this.f21155b = arrayList;
            this.f21156c = interfaceC0234b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public NewsObj doInBackground(Void... voidArr) {
            l lVar;
            int i10;
            try {
                int k02 = sf.a.i0(App.m()).k0();
                int G0 = sf.a.i0(App.m()).G0();
                while (true) {
                    lVar = this.f21157d ? new l(App.m(), this.f21154a, String.valueOf(k02), G0) : new l(App.m(), this.f21155b, String.valueOf(k02), G0);
                    lVar.call();
                    if (lVar.a() != null || (i10 = this.f21158e) <= 0) {
                        break;
                    }
                    this.f21158e = i10 - 1;
                }
                return lVar.a();
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(NewsObj newsObj) {
            super.onPostExecute(newsObj);
            try {
                if (this.f21156c != null) {
                    ArrayList<ItemObj> arrayList = new ArrayList<>();
                    for (ItemObj itemObj : newsObj.getItems()) {
                        arrayList.add(itemObj);
                    }
                    this.f21156c.F(arrayList, newsObj.competitorById);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NewsDataMgr.java */
    /* renamed from: com.scores365.NewsCenter.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0234b {
        void F(ArrayList<ItemObj> arrayList, Hashtable<Integer, CompObj> hashtable);
    }

    @NonNull
    private d b(@NonNull uc.d dVar) {
        return new d(dVar, i.SingleNews, f.BigLayout);
    }

    private boolean g(int i10) {
        return i10 == 2 || i10 == 3;
    }

    private boolean h() {
        try {
            if (RemoveAdsManager.isUserAdsRemoved(App.m())) {
                return false;
            }
            return o0.y().c0("NATIVE_SINGLENEWS_1_BANNER_OR_2_NATIVE_OR_3_BOTH") ? g(o0.y().s(o0.y().E("NATIVE_SINGLENEWS_1_BANNER_OR_2_NATIVE_OR_3_BOTH"), -1)) : g(o0.y().s(o0.y().E("NATIVE_SINGLENEWS_1_BANNER_OR_2_NATIVE_OR_3_BOTH_DEFAULT"), 1));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public Hashtable<Integer, CompObj> a(Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras == null || !extras.containsKey(NewsCenterActivity.S0)) {
                return null;
            }
            return (Hashtable) extras.getSerializable(NewsCenterActivity.S0);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public void c(int i10, InterfaceC0234b interfaceC0234b) {
        new a(i10, interfaceC0234b).execute(new Void[0]);
    }

    public void d(ArrayList<Integer> arrayList, InterfaceC0234b interfaceC0234b) {
        new a(arrayList, interfaceC0234b).execute(new Void[0]);
    }

    public ArrayList<ItemObj> e(Intent intent) {
        ArrayList<ItemObj> arrayList = new ArrayList<>();
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (extras.containsKey(NewsCenterActivity.Q0)) {
                    this.f21153a = extras.getInt(NewsCenterActivity.Q0, 0);
                }
                return extras.containsKey(NewsCenterActivity.R0) ? (ArrayList) extras.getSerializable(NewsCenterActivity.R0) : arrayList;
            }
            return arrayList;
        } catch (Exception e10) {
            x0.N1(e10);
            return arrayList;
        }
    }

    public ArrayList<com.scores365.Design.PageObjects.b> f(@NonNull uc.d dVar, ItemObj itemObj, Hashtable<Integer, CompObj> hashtable) {
        EntityConnection[] entitys;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            if (o0.y() != null && o0.y().k(BrandingKey.newsStrip) != null) {
                HashSet<Integer> hashSet = new HashSet<>();
                HashSet<Integer> hashSet2 = new HashSet<>();
                HashSet<Integer> hashSet3 = new HashSet<>();
                HashSet<Integer> hashSet4 = new HashSet<>();
                try {
                    hashSet.add(Integer.valueOf(itemObj.getID()));
                    for (EntityConnection entityConnection : itemObj.getEntitys()) {
                        int entityType = entityConnection.getEntityType();
                        if (entityType == 3) {
                            hashSet2.add(Integer.valueOf(entityConnection.getEntityID()));
                        } else if (entityType == 4) {
                            hashSet3.add(Integer.valueOf(entityConnection.getEntityID()));
                        } else if (entityType == 5) {
                            hashSet4.add(Integer.valueOf(entityConnection.getEntityID()));
                        }
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
                fc.a y10 = o0.y();
                BrandingKey brandingKey = BrandingKey.newsStrip;
                if (y10.Q(brandingKey, hashSet, hashSet3, hashSet2, hashSet4)) {
                    arrayList.add(new BrandingStripItem(o0.y().k(brandingKey), brandingKey));
                }
            }
            if (itemObj.getContentUrl() == null || itemObj.getContentUrl().isEmpty()) {
                arrayList.add(new h(itemObj.imageSource, false));
                arrayList.add(new xc.l(itemObj));
                TransferObj transferObj = itemObj.transferObj;
                if (transferObj != null && hashtable != null) {
                    CompObj compObj = hashtable.get(Integer.valueOf(transferObj.originTeam));
                    CompObj compObj2 = hashtable.get(Integer.valueOf(itemObj.transferObj.targetTeam));
                    j0.a c10 = jd.f.c(itemObj.transferObj.transferID);
                    int id2 = itemObj.transferObj.Status.getID();
                    eTransferStatus etransferstatus = eTransferStatus.CONFIRMED;
                    arrayList.add(new o(transferObj, compObj, compObj2, c10, -1, null, id2 != etransferstatus.getValue(), true, itemObj.transferObj.Status.getID() == etransferstatus.getValue()));
                }
                arrayList.add(new k(itemObj));
            } else {
                arrayList.add(new xc.l(itemObj));
                arrayList.add(new j(itemObj.getContentUrl()));
            }
            ArrayList arrayList2 = new ArrayList();
            LinkedHashMap<Integer, ItemObj> linkedHashMap = itemObj.extraItems;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                Iterator<Integer> it = itemObj.relatedNewsIds.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    if (itemObj.extraItems.containsKey(next)) {
                        arrayList2.add(itemObj.extraItems.get(next));
                    }
                }
            }
            if (arrayList2.size() > 0) {
                arrayList.add(new xc.i(p0.l0("NEWS_RELATED_ARTICLES")));
            }
            if (h()) {
                arrayList.add(b(dVar));
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ItemObj itemObj2 = (ItemObj) it2.next();
                ArrayList<ImageDetailObj> arrayList3 = itemObj2.imagesList;
                if (arrayList3 != null && arrayList3.size() > 0 && p0.k(itemObj2.imagesList.get(0).width)) {
                    arrayList.add(new nf.b(itemObj2, itemObj2.getSourceObj()));
                } else if (x0.l1()) {
                    arrayList.add(new nf.b(itemObj2, itemObj2.getSourceObj()));
                } else {
                    arrayList.add(new nf.b(itemObj2, itemObj2.getSourceObj()));
                }
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        return arrayList;
    }
}
