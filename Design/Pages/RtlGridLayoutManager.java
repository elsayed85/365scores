package com.scores365.Design.Pages;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
/* loaded from: classes2.dex */
public class RtlGridLayoutManager extends GridLayoutManager {

    /* renamed from: j  reason: collision with root package name */
    boolean f20950j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20951k;

    public RtlGridLayoutManager(Context context, int i10) {
        super(context, i10);
        this.f20950j = false;
        this.f20951k = false;
    }

    public RtlGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f20950j = false;
        this.f20951k = false;
    }

    public void E() {
        this.f20950j = true;
    }

    public void F(boolean z10) {
        this.f20951k = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean canScrollVertically() {
        return !this.f20951k && super.canScrollVertically();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean isLayoutRTL() {
        return this.f20950j;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
