package com.scores365.NewsCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import li.x0;
/* loaded from: classes2.dex */
public class MyCoordinatorLayout extends CoordinatorLayout {

    /* renamed from: z  reason: collision with root package name */
    private boolean f21116z;

    public MyCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21116z = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.s0
    public boolean o(View view, View view2, int i10, int i11) {
        return this.f21116z && super.o(view, view2, i10, i11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return this.f21116z && super.onStartNestedScroll(view, view2, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void setAllowForScrool(boolean z10) {
        this.f21116z = z10;
    }
}
