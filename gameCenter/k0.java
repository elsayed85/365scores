package com.scores365.gameCenter;

import ag.i0;
import android.view.ViewGroup;
import com.scores365.Design.Pages.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: GameCenterDetailsPageAdapter.java */
/* loaded from: classes2.dex */
public class k0 extends t {

    /* renamed from: j  reason: collision with root package name */
    int f23988j;

    /* renamed from: k  reason: collision with root package name */
    boolean f23989k;

    public k0(ArrayList<com.scores365.Design.PageObjects.b> arrayList, q.e eVar, boolean z10) {
        super(arrayList, eVar);
        this.f23988j = 0;
        this.f23989k = z10;
    }

    @Override // com.scores365.gameCenter.t, androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B */
    public void onBindViewHolder(com.scores365.Design.Pages.t tVar, int i10) {
        super.onBindViewHolder(tVar, i10);
    }

    @Override // com.scores365.gameCenter.t, androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C */
    public com.scores365.Design.Pages.t onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return super.onCreateViewHolder(viewGroup, i10);
    }

    public void I(i0.a.b bVar) {
        this.f24051g = new WeakReference<>(bVar);
    }
}
