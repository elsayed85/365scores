package com.scores365.gameCenter;

import com.scores365.entitys.GameObj;
import com.scores365.entitys.PlayByPlayMessageObj;
import java.util.ArrayList;
import java.util.List;
import vh.a;
/* compiled from: PlayByPlayPreviewMgr.kt */
/* loaded from: classes2.dex */
public final class r0 extends q0 {

    /* renamed from: g  reason: collision with root package name */
    private a.InterfaceC0616a<Boolean> f24036g;

    /* renamed from: h  reason: collision with root package name */
    private uh.a f24037h;

    /* compiled from: PlayByPlayPreviewMgr.kt */
    /* loaded from: classes2.dex */
    public static final class a implements a.InterfaceC0616a<Boolean> {
        a() {
        }

        @Override // vh.a.InterfaceC0616a
        /* renamed from: a */
        public void h0(Boolean bool) {
            a.InterfaceC0616a interfaceC0616a = r0.this.f24036g;
            if (interfaceC0616a != null) {
                interfaceC0616a.h0(bool);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(String baseUrl, GameObj game) {
        super(baseUrl, game);
        kotlin.jvm.internal.m.g(baseUrl, "baseUrl");
        kotlin.jvm.internal.m.g(game, "game");
        this.f24037h = new uh.a(this, new a());
    }

    public final void F(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        try {
            ArrayList arrayList2 = new ArrayList(G(3));
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int size = arrayList2.size();
            String str = null;
            String str2 = null;
            for (int i10 = 0; i10 < size; i10++) {
                arrayList3.add(e((PlayByPlayMessageObj) arrayList2.get(i10), 70, 70));
                arrayList4.add(e((PlayByPlayMessageObj) arrayList2.get(i10), 70, 70));
                if (i10 == 0) {
                    str = d((PlayByPlayMessageObj) arrayList2.get(i10), 100, 100);
                    str2 = d((PlayByPlayMessageObj) arrayList2.get(i10), 100, 100);
                }
            }
            if (arrayList != null && (!arrayList.isEmpty()) && (!arrayList2.isEmpty())) {
                int size2 = arrayList.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if (arrayList.get(i11).getObjectTypeNum() == lf.u.PBPBetRadarItem.ordinal()) {
                        com.scores365.Design.PageObjects.b bVar = arrayList.get(i11);
                        kotlin.jvm.internal.m.e(bVar, "null cannot be cast to non-null type com.scores365.gameCenter.gameCenterDetailsItems.PBPBetRadarItem");
                        ((xf.v) bVar).l(arrayList2, arrayList3, str, arrayList4, str2);
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final List<PlayByPlayMessageObj> G(int i10) {
        ArrayList<PlayByPlayMessageObj> items = o();
        kotlin.jvm.internal.m.f(items, "items");
        if (!items.isEmpty()) {
            List a10 = uh.a.f40281f.a(items, i10);
            kotlin.jvm.internal.m.e(a10, "null cannot be cast to non-null type kotlin.collections.MutableList<com.scores365.entitys.PlayByPlayMessageObj>");
            return kotlin.jvm.internal.b0.b(a10);
        }
        return items;
    }

    public final boolean H() {
        return this.f24037h.e();
    }

    public final void I(a.InterfaceC0616a<Boolean> interfaceC0616a) {
        this.f24036g = interfaceC0616a;
    }

    public final void J() {
        this.f24037h.f(true);
        this.f24037h.g();
    }

    public final void K() {
        this.f24037h.h();
    }

    public final void L(GameObj gameObj) {
        this.f24028e = gameObj;
    }
}
