package com.scores365.Design.Pages;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import li.x0;
/* loaded from: classes2.dex */
public class CustomStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public CustomStaggeredGridLayoutManager(int i10, int i11) {
        super(i10, i11);
    }

    public CustomStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public int getLayoutDirection() {
        try {
            return x0.l1() ? 1 : 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }
}
