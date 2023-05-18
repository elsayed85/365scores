package com.scores365.Design.Pages;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.scores365.Design.Pages.q;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import li.x0;
/* compiled from: MainScoresPageAdapter.java */
/* loaded from: classes2.dex */
public class r extends c {

    /* renamed from: m  reason: collision with root package name */
    private boolean f21003m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21004n;

    public r(ArrayList<com.scores365.Design.PageObjects.b> arrayList, q.e eVar, boolean z10, boolean z11) {
        super(arrayList, eVar);
        this.f21003m = false;
        this.f21004n = false;
        L(z10);
        K(z11);
        setHasStableIds(true);
    }

    public boolean J() {
        return this.f21003m;
    }

    public void K(boolean z10) {
        this.f21004n = z10;
    }

    public void L(boolean z10) {
        this.f21003m = z10;
    }

    @Override // com.scores365.Design.Pages.c, androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i10) {
        try {
            long itemId = A(i10).getItemId();
            return itemId != 0 ? itemId : super.getItemId(i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return super.getItemId(i10);
        }
    }

    @Override // com.scores365.Design.Pages.c, androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            if (this.f20954f.get(i10).isMainScoresListItem()) {
                this.f20954f.get(i10).onBindViewHolder(e0Var, i10, this.f21003m, this.f21004n);
                if (e0Var.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c) {
                    ((StaggeredGridLayoutManager.c) e0Var.itemView.getLayoutParams()).l(this.f20954f.get(i10).isFullSpanWidthSize());
                }
            } else {
                super.onBindViewHolder(e0Var, i10);
            }
        } catch (Exception e10) {
            super.onBindViewHolder(e0Var, i10);
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.c, androidx.recyclerview.widget.RecyclerView.h
    @NonNull
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        Hashtable<Integer, Integer> hashtable = this.f20953e;
        t tVar = null;
        if (hashtable != null) {
            for (Map.Entry<Integer, Integer> entry : hashtable.entrySet()) {
                if (i10 == entry.getValue().intValue()) {
                    int intValue = entry.getKey().intValue();
                    if (intValue == lf.u.AllScoresCompetitionItem.ordinal()) {
                        tVar = ef.a.onCreateViewHolder(viewGroup, this.f20955g.get());
                    } else if (intValue == lf.u.AllScoresTvSportTypeItem.ordinal()) {
                        tVar = ef.h.f25981f.a(viewGroup, this.f20955g.get(), this.f21004n);
                    }
                }
            }
            return tVar == null ? super.onCreateViewHolder(viewGroup, i10) : tVar;
        }
        return null;
    }
}
