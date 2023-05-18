package com.scores365.Design.PageObjects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import lf.u;
/* compiled from: PagingProgressBarItem.java */
/* loaded from: classes2.dex */
public class g extends b {

    /* compiled from: PagingProgressBarItem.java */
    /* loaded from: classes2.dex */
    public static class a extends t {
        public a(View view, q.e eVar) {
            super(view);
        }
    }

    public static a l(ViewGroup viewGroup, q.e eVar) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.N5, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.pagingProgressBarItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
    }
}
