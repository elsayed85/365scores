package com.scores365.gameCenter;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.Collection;
/* compiled from: GameCenterBasePage.java */
/* loaded from: classes2.dex */
public abstract class s extends com.scores365.Design.Pages.q implements q.e {

    /* renamed from: l  reason: collision with root package name */
    protected t f24039l;

    /* renamed from: m  reason: collision with root package name */
    protected GameObj f24040m;

    /* renamed from: n  reason: collision with root package name */
    protected CompetitionObj f24041n;

    /* renamed from: o  reason: collision with root package name */
    protected i0 f24042o;

    /* renamed from: p  reason: collision with root package name */
    protected bg.e f24043p;

    /* compiled from: GameCenterBasePage.java */
    /* loaded from: classes2.dex */
    class a extends LinearLayoutManager {
        a(Context context, int i10, boolean z10) {
            super(context, i10, z10);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public void onLayoutCompleted(RecyclerView.b0 b0Var) {
            super.onLayoutCompleted(b0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.f22715u2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            this.rvLayoutMgr = new a(App.m(), 1, false);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> boolean isDataReady(T t10) {
        try {
            return this.f24042o.v2();
        } catch (Exception e10) {
            li.x0.N1(e10);
            return false;
        }
    }

    public bg.e x1() {
        return this.f24043p;
    }

    public void y1() {
        try {
            HideMainPreloader();
            renderData((ArrayList) LoadData());
            resetHandleListScrolled();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
