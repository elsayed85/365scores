package com.scores365.Pages;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Pages.g;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.TvNetworkObj;
import com.scores365.gameCenter.GameCenterBaseActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import li.x0;
/* compiled from: StoryPage.kt */
/* loaded from: classes2.dex */
public final class d0 extends com.scores365.Design.Pages.q {

    /* renamed from: n  reason: collision with root package name */
    public static final a f21205n = new a(null);

    /* renamed from: l  reason: collision with root package name */
    private GameObj f21206l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f21207m;

    /* compiled from: StoryPage.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.scores365.Design.Pages.a a(GameObj gameObj) {
            d0 d0Var = new d0();
            d0Var.setArguments(new Bundle());
            d0Var.f21206l = gameObj;
            return d0Var;
        }
    }

    private final boolean A1() {
        androidx.fragment.app.h activity = getActivity();
        if (activity instanceof GameCenterBaseActivity) {
            return ((GameCenterBaseActivity) activity).R2();
        }
        return false;
    }

    private final String z1() {
        HashSet<TvNetworkObj> tvNetworks;
        Object obj;
        ArrayList<TvNetworkObj.tvNetworkLink> arrayList;
        Object Q;
        boolean z10;
        GameObj gameObj = this.f21206l;
        if (gameObj == null || (tvNetworks = gameObj.getTvNetworks()) == null) {
            return null;
        }
        Iterator<T> it = tvNetworks.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((TvNetworkObj) obj).networkId == 6347) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                break;
            }
        }
        TvNetworkObj tvNetworkObj = (TvNetworkObj) obj;
        if (tvNetworkObj == null || (arrayList = tvNetworkObj.tvLinks) == null) {
            return null;
        }
        Q = kotlin.collections.z.Q(arrayList);
        TvNetworkObj.tvNetworkLink tvnetworklink = (TvNetworkObj.tvNetworkLink) Q;
        if (tvnetworklink != null) {
            return tvnetworklink.getLineLink();
        }
        return null;
    }

    public final void B1() {
        try {
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            if ((cVar != null ? cVar.A(0) : null) instanceof g) {
                RecyclerView.e0 a02 = this.rvItems.a0(0);
                if (a02 instanceof g.c) {
                    com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(0);
                    kotlin.jvm.internal.m.e(A, "null cannot be cast to non-null type com.scores365.Pages.BuzzStoryItem");
                    ((g) A).m((g.c) a02);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
    @Override // com.scores365.Design.Pages.q
    public <T> T LoadData() {
        ?? r02 = (T) new ArrayList();
        if (this.f21207m) {
            String z12 = z1();
            GameObj gameObj = this.f21206l;
            if (z12 != null && gameObj != null) {
                r02.add(new g(gameObj, z12, A1()));
            }
        }
        return r02;
    }

    @Override // com.scores365.Design.Pages.q
    public void LoadDataAsync() {
        super.LoadDataAsync();
    }

    @Override // com.scores365.Design.Pages.a
    public /* bridge */ /* synthetic */ String getIconLink() {
        return (String) y1();
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return "";
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        this.f21207m = z10;
        if (z10) {
            LoadDataAsync();
        }
    }

    public Void y1() {
        return null;
    }
}
