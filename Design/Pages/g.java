package com.scores365.Design.Pages;

import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.AbsListView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.R;
import li.x0;
/* compiled from: FeedPage.java */
/* loaded from: classes2.dex */
public abstract class g extends q {
    protected lf.c filterObj;
    private final Handler requestHandler;
    private final com.scores365.Design.PageObjects.g pagingProgressBarItem = new com.scores365.Design.PageObjects.g();
    private boolean isLoadingPrevData = false;
    protected boolean isLoadingNextData = false;
    protected int positionToRetainInNextRequest = -1;
    public boolean hasPrevItems = true;
    public boolean hasNextItems = true;
    public boolean isRefreshEnabled = true;
    protected boolean userTouchedRecyclerView = true;
    protected boolean shouldIgnoreUserTouchForPaging = false;

    public g() {
        HandlerThread handlerThread = new HandlerThread("feedRequestHandler");
        handlerThread.start();
        this.requestHandler = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoadingItemsFinished$0(boolean z10) {
        androidx.fragment.app.h activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || isStateSaved()) {
            return;
        }
        if (z10) {
            getNextItems();
        } else {
            getPreviousItems();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        try {
            super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
            int lastVisibilePositionFromLayoutMgr = getLastVisibilePositionFromLayoutMgr();
            if (this.rvItems != null) {
                if (this.userTouchedRecyclerView || this.shouldIgnoreUserTouchForPaging) {
                    handlePagingIfNeeded(i10, lastVisibilePositionFromLayoutMgr);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollStateChangedEvent(AbsListView absListView, int i10) {
        super.OnScrollStateChangedEvent(absListView, i10);
        if (i10 == 1) {
            try {
                if (this.userTouchedRecyclerView) {
                    return;
                }
                this.userTouchedRecyclerView = true;
                handlePagingIfNeeded();
            } catch (Resources.NotFoundException e10) {
                x0.N1(e10);
            }
        }
    }

    public lf.c getFilterObj() {
        return this.filterObj;
    }

    protected int getLastItemPositionForPreviousPageFeed() {
        try {
            return this.rvBaseAdapter.getItemCount() - com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.N1;
    }

    protected void getNextItems() {
    }

    protected void getPreviousItems() {
    }

    @Override // com.scores365.Design.Pages.q, com.scores365.Design.Pages.a
    public void handleContentPadding() {
        super.handleContentPadding();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handlePagingIfNeeded() {
        try {
            handlePagingIfNeeded(-1, -1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void handlePagingIfNeeded(int i10, int i11) {
        try {
            if (this.isLoadingNextData || this.isLoadingPrevData) {
                return;
            }
            if (i10 == -1 || i11 == -1) {
                RecyclerView.p pVar = this.rvLayoutMgr;
                if (pVar instanceof GridLayoutManager) {
                    i10 = ((GridLayoutManager) pVar).findFirstVisibleItemPosition();
                    i11 = ((GridLayoutManager) this.rvLayoutMgr).findLastVisibleItemPosition();
                } else if (pVar instanceof LinearLayoutManager) {
                    i10 = ((LinearLayoutManager) pVar).findFirstVisibleItemPosition();
                    i11 = ((LinearLayoutManager) this.rvLayoutMgr).findLastVisibleItemPosition();
                }
            }
            if (i10 == 0 && hasNextItems()) {
                this.isLoadingNextData = true;
                this.rvBaseAdapter.B().add(0, this.pagingProgressBarItem);
                this.rvBaseAdapter.I();
                this.rvBaseAdapter.notifyItemInserted(0);
                getNextItems();
            } else if (i11 < getLastItemPositionForPreviousPageFeed() || !hasPreviousItems()) {
            } else {
                this.isLoadingPrevData = true;
                this.rvBaseAdapter.B().add(this.pagingProgressBarItem);
                this.rvBaseAdapter.I();
                c cVar = this.rvBaseAdapter;
                cVar.notifyItemInserted(cVar.getItemCount());
                getPreviousItems();
            }
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    protected abstract boolean hasNextItems();

    protected abstract boolean hasPreviousItems();

    public void lockPageDataRefresh() {
    }

    @Override // com.scores365.Design.Pages.y, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.requestHandler.removeCallbacksAndMessages(null);
        this.rvItems = null;
        this.rvBaseAdapter = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingItemsFinished(boolean z10, final boolean z11) {
        c cVar = this.rvBaseAdapter;
        RecyclerView recyclerView = this.rvItems;
        if (recyclerView == null) {
            return;
        }
        this.requestHandler.removeCallbacksAndMessages(null);
        if (z10) {
            if (cVar != null) {
                RecyclerView.m itemAnimator = recyclerView.getItemAnimator();
                if (itemAnimator != null) {
                    itemAnimator.k();
                }
                removePagingItemFromList(cVar);
                cVar.notifyDataSetChanged();
                int i10 = this.positionToRetainInNextRequest;
                if (i10 != -1) {
                    recyclerView.p1(i10);
                }
            }
            resetHandleListScrolled();
        } else {
            this.requestHandler.removeCallbacksAndMessages(null);
            this.requestHandler.postDelayed(new Runnable() { // from class: com.scores365.Design.Pages.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.lambda$onLoadingItemsFinished$0(z11);
                }
            }, 1000L);
        }
        if (z11) {
            this.isLoadingNextData = false;
        } else {
            this.isLoadingPrevData = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removePagingItemFromList(c cVar) {
        try {
            int indexOf = cVar.B().indexOf(this.pagingProgressBarItem);
            if (indexOf != -1) {
                cVar.B().remove(indexOf);
                cVar.notifyItemRemoved(indexOf);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setFilterObj(lf.c cVar) {
        this.filterObj = cVar;
    }
}
