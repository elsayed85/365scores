package com.scores365.Design.Pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class HotFixRecyclerView extends RecyclerView {
    public HotFixRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotFixRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void C1() {
        try {
            super.C1();
        } catch (NullPointerException e10) {
            ng.a.f35508a.c("HotFixRecyclerView", "error stopping rv scroll", e10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e10) {
            ng.a.f35508a.c("HotFixRecyclerView", "error during rv dispatchTouchEvent", e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        try {
            super.onLayout(z10, i10, i11, i12, i13);
        } catch (Exception e10) {
            ng.a.f35508a.c("HotFixRecyclerView", "error during rv onLayout", e10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e10) {
            ng.a.f35508a.c("HotFixRecyclerView", "error during rv onTouch", e10);
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollTo(int i10, int i11) {
        try {
            super.scrollTo(i10, i11);
        } catch (Exception e10) {
            ng.a.f35508a.c("HotFixRecyclerView", "error scrolling rv", e10);
        }
    }
}
