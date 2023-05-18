package com.scores365.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import li.x0;
/* loaded from: classes2.dex */
public class FixScrollingFooterBehavior extends AppBarLayout.ScrollingViewBehavior {
    private AppBarLayout appBarLayout;

    public FixScrollingFooterBehavior() {
    }

    public FixScrollingFooterBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int calculateBottomPadding(AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange() + appBarLayout.getTop();
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        try {
            if (this.appBarLayout == null) {
                this.appBarLayout = (AppBarLayout) view2;
            }
            boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            int calculateBottomPadding = calculateBottomPadding(this.appBarLayout);
            boolean z10 = calculateBottomPadding != view.getPaddingBottom();
            if (z10) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), calculateBottomPadding);
                view.requestLayout();
            }
            return z10 || onDependentViewChanged;
        } catch (Exception e10) {
            x0.N1(e10);
            return super.onDependentViewChanged(coordinatorLayout, view, view2);
        }
    }
}
