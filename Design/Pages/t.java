package com.scores365.Design.Pages;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: RecyclerViewHolder.java */
/* loaded from: classes2.dex */
public class t extends RecyclerView.e0 {
    public View itemView;

    public t(View view) {
        super(view);
        this.itemView = view;
        if (sf.b.X1().L3()) {
            li.k kVar = new li.k(-1L);
            kVar.b(this);
            this.itemView.setOnLongClickListener(kVar);
        }
    }

    public boolean isSupportRTL() {
        return false;
    }
}
