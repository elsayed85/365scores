package com.scores365.gameCenter;

import android.os.Handler;
import com.scores365.App;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.FilterCategoriesObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.MessagesPBPObj;
import com.scores365.entitys.PlayByPlayDriveObj;
import com.scores365.entitys.PlayByPlayMessageObj;
import com.scores365.entitys.SportTypesEnum;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: PlayByPlayMgr.java */
/* loaded from: classes2.dex */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    MessagesPBPObj f24024a;

    /* renamed from: b  reason: collision with root package name */
    protected String f24025b = null;

    /* renamed from: c  reason: collision with root package name */
    protected yf.d f24026c = null;

    /* renamed from: d  reason: collision with root package name */
    protected int f24027d = -1;

    /* renamed from: e  reason: collision with root package name */
    protected GameObj f24028e;

    /* renamed from: f  reason: collision with root package name */
    protected final String f24029f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayByPlayMgr.java */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f24030a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<q0> f24031b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<Handler> f24032c;

        public a(q0 q0Var, b bVar, Handler handler) {
            this.f24030a = new WeakReference<>(bVar);
            this.f24031b = new WeakReference<>(q0Var);
            this.f24032c = new WeakReference<>(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                q0 q0Var = this.f24031b.get();
                if (q0Var != null) {
                    MessagesPBPObj t10 = q0Var.t();
                    ArrayList<PlayByPlayMessageObj> g10 = q0Var.g(t10);
                    q0Var.z(t10);
                    b bVar = this.f24030a.get();
                    if (bVar == null || (handler = this.f24032c.get()) == null) {
                        return;
                    }
                    handler.post(new c(bVar, g10));
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: PlayByPlayMgr.java */
    /* loaded from: classes2.dex */
    public interface b {
        void M(ArrayList<PlayByPlayMessageObj> arrayList);
    }

    /* compiled from: PlayByPlayMgr.java */
    /* loaded from: classes2.dex */
    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f24033a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<PlayByPlayMessageObj> f24034b;

        public c(b bVar, ArrayList<PlayByPlayMessageObj> arrayList) {
            this.f24033a = new WeakReference<>(bVar);
            this.f24034b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b bVar = this.f24033a.get();
                if (bVar != null) {
                    bVar.M(this.f24034b);
                }
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: PlayByPlayMgr.java */
    /* loaded from: classes2.dex */
    public interface d {
        PlayByPlayMessageObj getMessage();
    }

    public q0(String str, GameObj gameObj) {
        this.f24029f = str;
        this.f24028e = gameObj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessagesPBPObj t() {
        try {
            return f();
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public void A(int i10) {
        this.f24027d = i10;
    }

    public void B(yf.d dVar) {
        this.f24026c = dVar;
    }

    public void C(ArrayList<FilterCategoriesObj> arrayList) {
        MessagesPBPObj messagesPBPObj = this.f24024a;
        if (messagesPBPObj != null) {
            messagesPBPObj.setFilterCategories(arrayList);
        }
    }

    public void D(String str) {
        this.f24025b = str;
    }

    public ArrayList<com.scores365.Design.PageObjects.b> b(ArrayList<PlayByPlayMessageObj> arrayList) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        try {
            Iterator<PlayByPlayMessageObj> it = arrayList.iterator();
            while (it.hasNext()) {
                PlayByPlayMessageObj next = it.next();
                ag.s0 s0Var = new ag.s0(this.f24028e, next, e(next, 70, 70), e(next.getTopMessage(), 70, 70));
                s0Var.m(true);
                arrayList2.add(s0Var);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList2;
    }

    public void c(MessagesPBPObj messagesPBPObj) {
        if (k().size() < messagesPBPObj.getFilterCategories().size()) {
            C(messagesPBPObj.getFilterCategories());
        }
    }

    public String d(PlayByPlayMessageObj playByPlayMessageObj, int i10, int i11) {
        int i12;
        String imgVer;
        boolean z10;
        String str;
        if (playByPlayMessageObj != null) {
            try {
                if (playByPlayMessageObj.getPlayers() == null || playByPlayMessageObj.getPlayers().isEmpty()) {
                    return null;
                }
                if (this.f24028e.getSportID() == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) {
                    i12 = -1;
                    if (playByPlayMessageObj.getRelevantPlayersIdx() == null || playByPlayMessageObj.getRelevantPlayersIdx().length <= 0) {
                        imgVer = null;
                        z10 = false;
                    } else {
                        int i13 = playByPlayMessageObj.getRelevantPlayersIdx()[0];
                        if (playByPlayMessageObj.getPlayers().size() > i13) {
                            i12 = playByPlayMessageObj.getPlayers().get(i13).athleteId;
                            str = playByPlayMessageObj.getPlayers().get(i13).getImgVer();
                            z10 = true;
                        } else {
                            str = null;
                            z10 = false;
                        }
                        imgVer = str;
                    }
                } else {
                    i12 = playByPlayMessageObj.getPlayers().get(0).athleteId;
                    imgVer = playByPlayMessageObj.getPlayers().get(0).getImgVer();
                    z10 = true;
                }
                CompObj compObj = playByPlayMessageObj.getCompetitorNum() == 1 ? this.f24028e.getComps()[0] : playByPlayMessageObj.getCompetitorNum() == 2 ? this.f24028e.getComps()[1] : null;
                if (z10) {
                    return nb.o.b(i12, compObj != null && compObj.isNational(), imgVer, i10, i11);
                }
                return null;
            } catch (Exception e10) {
                li.x0.N1(e10);
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[Catch: Exception -> 0x0014, TRY_LEAVE, TryCatch #0 {Exception -> 0x0014, blocks: (B:4:0x0004, B:6:0x000a, B:15:0x002b, B:10:0x0018, B:12:0x001f), top: B:19:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String e(com.scores365.entitys.PlayByPlayMessageObj r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L16
            int r2 = r10.getCompetitorNum()     // Catch: java.lang.Exception -> L14
            if (r2 != r0) goto L16
            com.scores365.entitys.GameObj r10 = r9.f24028e     // Catch: java.lang.Exception -> L14
            com.scores365.entitys.CompObj[] r10 = r10.getComps()     // Catch: java.lang.Exception -> L14
            r0 = 0
            r10 = r10[r0]     // Catch: java.lang.Exception -> L14
            goto L29
        L14:
            r10 = move-exception
            goto L45
        L16:
            if (r10 == 0) goto L28
            int r10 = r10.getCompetitorNum()     // Catch: java.lang.Exception -> L14
            r2 = 2
            if (r10 != r2) goto L28
            com.scores365.entitys.GameObj r10 = r9.f24028e     // Catch: java.lang.Exception -> L14
            com.scores365.entitys.CompObj[] r10 = r10.getComps()     // Catch: java.lang.Exception -> L14
            r10 = r10[r0]     // Catch: java.lang.Exception -> L14
            goto L29
        L28:
            r10 = r1
        L29:
            if (r10 == 0) goto L48
            nb.p r2 = nb.p.Competitors     // Catch: java.lang.Exception -> L14
            int r0 = r10.getID()     // Catch: java.lang.Exception -> L14
            long r3 = (long) r0     // Catch: java.lang.Exception -> L14
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Exception -> L14
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Exception -> L14
            r7 = 0
            java.lang.String r8 = r10.getImgVer()     // Catch: java.lang.Exception -> L14
            java.lang.String r10 = nb.o.s(r2, r3, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L14
            r1 = r10
            goto L48
        L45:
            li.x0.N1(r10)
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.q0.e(com.scores365.entitys.PlayByPlayMessageObj, int, int):java.lang.String");
    }

    public MessagesPBPObj f() {
        MessagesPBPObj messagesPBPObj = null;
        try {
            com.scores365.api.c1 c1Var = new com.scores365.api.c1(App.m(), l());
            c1Var.call();
            messagesPBPObj = c1Var.a();
            if (this.f24024a == null) {
                this.f24024a = messagesPBPObj;
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return messagesPBPObj;
    }

    public ArrayList<PlayByPlayMessageObj> g(MessagesPBPObj messagesPBPObj) {
        ArrayList<PlayByPlayMessageObj> arrayList = new ArrayList<>();
        if (messagesPBPObj != null) {
            try {
                return this.f24024a.getDeltaOfList(messagesPBPObj.getMessages());
            } catch (Exception e10) {
                li.x0.N1(e10);
                return arrayList;
            }
        }
        return arrayList;
    }

    public ArrayList<PlayByPlayDriveObj> h() {
        try {
            MessagesPBPObj messagesPBPObj = this.f24024a;
            if (messagesPBPObj != null) {
                return messagesPBPObj.getDrives();
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public int i() {
        return this.f24027d;
    }

    public yf.d j() {
        return this.f24026c;
    }

    public ArrayList<FilterCategoriesObj> k() {
        MessagesPBPObj messagesPBPObj = this.f24024a;
        if (messagesPBPObj != null) {
            return messagesPBPObj.getFilterCategories();
        }
        return null;
    }

    public String l() {
        return this.f24029f;
    }

    public ArrayList<PlayByPlayMessageObj> m() {
        ArrayList<PlayByPlayMessageObj> arrayList = new ArrayList<>();
        try {
            Iterator<PlayByPlayMessageObj> it = this.f24024a.getMessages().iterator();
            while (it.hasNext()) {
                PlayByPlayMessageObj next = it.next();
                if (next.isMajor()) {
                    arrayList.add(next);
                }
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return arrayList;
    }

    public ArrayList<PlayByPlayMessageObj> n(FilterCategoriesObj filterCategoriesObj) {
        ArrayList<PlayByPlayMessageObj> arrayList = new ArrayList<>();
        ArrayList<PlayByPlayMessageObj> o10 = o();
        if (o10 != null && !o10.isEmpty() && filterCategoriesObj != null) {
            if (filterCategoriesObj.getClearFilter() != null && filterCategoriesObj.getClearFilter().booleanValue()) {
                arrayList.addAll(o10);
            } else if (filterCategoriesObj.getFilterID() != null) {
                Iterator<PlayByPlayMessageObj> it = o10.iterator();
                while (it.hasNext()) {
                    PlayByPlayMessageObj next = it.next();
                    ArrayList<String> filterIds = next.getFilterIds();
                    if (filterIds != null && !filterIds.isEmpty()) {
                        for (int i10 = 0; i10 < filterIds.size(); i10++) {
                            filterIds.set(i10, filterIds.get(i10).toLowerCase());
                        }
                        if (filterIds.contains(filterCategoriesObj.getFilterID().toLowerCase())) {
                            arrayList.add(next);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<PlayByPlayMessageObj> o() {
        try {
            MessagesPBPObj messagesPBPObj = this.f24024a;
            if (messagesPBPObj != null) {
                return messagesPBPObj.getMessages();
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public String p() {
        return this.f24025b;
    }

    public FilterCategoriesObj q() {
        MessagesPBPObj messagesPBPObj = this.f24024a;
        if (messagesPBPObj != null && messagesPBPObj.getFilterCategories() != null) {
            Iterator<FilterCategoriesObj> it = this.f24024a.getFilterCategories().iterator();
            while (it.hasNext()) {
                FilterCategoriesObj next = it.next();
                if (next.getSelected() != null && next.getSelected().booleanValue()) {
                    return next;
                }
            }
        }
        return null;
    }

    public int r() {
        try {
            MessagesPBPObj messagesPBPObj = this.f24024a;
            if (messagesPBPObj != null) {
                return messagesPBPObj.getTtl();
            }
            return 30;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return 30;
        }
    }

    public String s() {
        try {
            MessagesPBPObj messagesPBPObj = this.f24024a;
            if (messagesPBPObj != null) {
                return messagesPBPObj.getUpdateUrl();
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public void u(b bVar, Handler handler) {
        try {
            new Thread(new a(this, bVar, handler)).start();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public boolean v() {
        return this.f24024a != null;
    }

    public boolean w() {
        try {
            MessagesPBPObj messagesPBPObj = this.f24024a;
            if (messagesPBPObj == null || messagesPBPObj.getMessages() == null || this.f24024a.getMessages().isEmpty()) {
                return false;
            }
            Iterator<PlayByPlayMessageObj> it = this.f24024a.getMessages().iterator();
            while (it.hasNext()) {
                if (it.next().isMajor()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public boolean x(MessagesPBPObj messagesPBPObj) {
        return !this.f24024a.getDeltaOfList(messagesPBPObj.getMessages()).isEmpty();
    }

    public boolean y(long j10) {
        MessagesPBPObj messagesPBPObj = this.f24024a;
        return (messagesPBPObj == null || ((long) messagesPBPObj.getTtl()) == j10) ? false : true;
    }

    public void z(MessagesPBPObj messagesPBPObj) {
        if (messagesPBPObj != null) {
            try {
                this.f24024a.updateList(messagesPBPObj.getMessages());
                this.f24024a.updateDrives(messagesPBPObj.getDrives());
                this.f24024a.setUpdateUrl(messagesPBPObj.getUpdateUrl());
                this.f24024a.setTTL(messagesPBPObj.getTtl());
                if (messagesPBPObj.getFilterCategories() == null || this.f24024a.getFilterCategories() == null || this.f24024a.getFilterCategories().isEmpty()) {
                    return;
                }
                c(messagesPBPObj);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }
}
