package com.scores365.Design.PageObjects;

import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.R;
/* compiled from: BasePageObject.java */
/* loaded from: classes2.dex */
public abstract class c {
    public long getItemId() {
        return 0L;
    }

    public abstract int getObjectTypeNum();

    public int getSpanSize() {
        return 1;
    }

    public boolean isFullSpanWidthSize() {
        try {
            return App.m().getResources().getBoolean(R.bool.f21609e);
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean isMainScoresListItem() {
        return false;
    }

    public abstract void onBindViewHolder(RecyclerView.e0 e0Var, int i10);

    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10, boolean z10, boolean z11) {
    }
}
