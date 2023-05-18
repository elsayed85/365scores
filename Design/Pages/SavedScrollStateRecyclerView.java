package com.scores365.Design.Pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import li.x0;
/* loaded from: classes2.dex */
public class SavedScrollStateRecyclerView extends HotFixRecyclerView {
    private RecyclerView.u P0;
    private boolean Q0;
    private boolean R0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.u {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            try {
                super.onScrollStateChanged(recyclerView, i10);
                if (SavedScrollStateRecyclerView.this.P0 != null) {
                    SavedScrollStateRecyclerView.this.P0.onScrollStateChanged(recyclerView, i10);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            try {
                super.onScrolled(recyclerView, i10, i11);
                if (SavedScrollStateRecyclerView.this.P0 == null || SavedScrollStateRecyclerView.this.Q0) {
                    return;
                }
                SavedScrollStateRecyclerView.this.P0.onScrolled(recyclerView, i10, i11);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public SavedScrollStateRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q0 = false;
        this.R0 = true;
        H1();
    }

    public SavedScrollStateRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Q0 = false;
        this.R0 = true;
        H1();
    }

    private void H1() {
        super.l(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void l(RecyclerView.u uVar) {
        this.P0 = uVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.R0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.scores365.Design.Pages.HotFixRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.R0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScrollingEnabled(boolean z10) {
        this.R0 = z10;
    }

    public void setShouldBlockNestedScroll(boolean z10) {
        this.Q0 = z10;
    }
}
