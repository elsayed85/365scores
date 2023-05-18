package com.scores365.Design.Pages;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* compiled from: SwipeRefreshPage.java */
/* loaded from: classes2.dex */
public abstract class y extends a implements z {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSwipeRefreshLayout$0(View view) {
        androidx.fragment.app.h activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || isStateSaved()) {
            return;
        }
        setLoadingProgressShown(view, false);
        onRefreshFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSwipeRefreshLayout$1(final View view) {
        reloadData();
        li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Design.Pages.v
            @Override // java.lang.Runnable
            public final void run() {
                y.this.lambda$initSwipeRefreshLayout$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSwipeRefreshLayout$2(final View view) {
        setLoadingProgressShown(view, true);
        li.c.f34483a.f().execute(new Runnable() { // from class: com.scores365.Design.Pages.w
            @Override // java.lang.Runnable
            public final void run() {
                y.this.lambda$initSwipeRefreshLayout$1(view);
            }
        });
    }

    private SwipeRefreshLayout relateSwipeRefreshView(@NonNull View view) {
        return (SwipeRefreshLayout) view.findViewById(getSwipeRefreshResourceID());
    }

    private void setLoadingProgressShown(@NonNull View view, boolean z10) {
        SwipeRefreshLayout relateSwipeRefreshView = relateSwipeRefreshView(view);
        if (relateSwipeRefreshView == null) {
            return;
        }
        relateSwipeRefreshView.setRefreshing(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initSwipeRefreshLayout(@NonNull final View view) {
        SwipeRefreshLayout relateSwipeRefreshView = relateSwipeRefreshView(view);
        if (relateSwipeRefreshView != null) {
            relateSwipeRefreshView.setEnabled(isSwipeEnabled());
            relateSwipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.scores365.Design.Pages.x
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    y.this.lambda$initSwipeRefreshLayout$2(view);
                }
            });
        }
    }

    public boolean isSwipeEnabled() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SwipeRefreshLayout relateSwipeRefreshView;
        View view = getView();
        if (view != null && (relateSwipeRefreshView = relateSwipeRefreshView(view)) != null) {
            relateSwipeRefreshView.setOnRefreshListener(null);
        }
        super.onDestroyView();
    }

    public void onRefreshFinished() {
    }

    public void reloadData() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRefreshLayoutPadding(int i10, int i11) {
        SwipeRefreshLayout relateSwipeRefreshView;
        View view = getView();
        if (view == null || (relateSwipeRefreshView = relateSwipeRefreshView(view)) == null) {
            return;
        }
        relateSwipeRefreshView.l(false, i10, i11);
    }

    public void setSwipeRefreshEnabled(boolean z10) {
        SwipeRefreshLayout relateSwipeRefreshView;
        View view = getView();
        if (view == null || (relateSwipeRefreshView = relateSwipeRefreshView(view)) == null) {
            return;
        }
        relateSwipeRefreshView.setEnabled(z10 && isSwipeEnabled());
    }
}
