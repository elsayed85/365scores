package com.scores365.ui.swipe;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.scores365.ui.swipe.MyScoresItemTouchHelperCallback;
import java.lang.ref.WeakReference;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CustomItemTouchHelper extends i {
    protected AbstractItemTouchHelperCallback callback;

    /* loaded from: classes2.dex */
    public static class RecyclerViewTouchListener implements View.OnTouchListener {
        private static final float threshold = p0.s(100);
        CustomItemTouchHelper helper;
        WeakReference<SwipeableListPage> swipeableListPageRef;

        public RecyclerViewTouchListener(CustomItemTouchHelper customItemTouchHelper, SwipeableListPage swipeableListPage) {
            this.helper = customItemTouchHelper;
            this.swipeableListPageRef = new WeakReference<>(swipeableListPage);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            SwipeableViewHolder swipeableViewHolder;
            try {
                AbstractItemTouchHelperCallback abstractItemTouchHelperCallback = this.helper.callback;
                boolean z10 = true;
                if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                    z10 = false;
                }
                abstractItemTouchHelperCallback.swipeBack = z10;
                AbstractItemTouchHelperCallback abstractItemTouchHelperCallback2 = this.helper.callback;
                if (abstractItemTouchHelperCallback2.swipeBack && abstractItemTouchHelperCallback2.currentDx > threshold && (swipeableViewHolder = abstractItemTouchHelperCallback2.currentHolder) != null) {
                    swipeableViewHolder.toggleViewHolder();
                    WeakReference<SwipeableListPage> weakReference = this.swipeableListPageRef;
                    SwipeableListPage swipeableListPage = weakReference != null ? weakReference.get() : null;
                    if (swipeableListPage != null) {
                        swipeableListPage.onSwiped(swipeableViewHolder.getLayoutPosition());
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return false;
        }
    }

    public CustomItemTouchHelper(i.e eVar) {
        super(eVar);
        if (eVar instanceof AbstractItemTouchHelperCallback) {
            this.callback = (AbstractItemTouchHelperCallback) eVar;
        }
    }

    @Override // androidx.recyclerview.widget.i
    public void attachToRecyclerView(RecyclerView recyclerView) {
        super.attachToRecyclerView(recyclerView);
    }

    public AbstractItemTouchHelperCallback getCallback() {
        return this.callback;
    }

    protected boolean isCurrentHolderOpened() {
        try {
            if (getCallback() == null || getCallback().getCurrentHolder() == null) {
                return false;
            }
            return getCallback().getCurrentHolder().getButtonState() == MyScoresItemTouchHelperCallback.ButtonsState.RIGHT_VISIBLE;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.i, androidx.recyclerview.widget.RecyclerView.o
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        try {
            if (getCallback() == null || getCallback().getCurrentHolder() == null) {
                super.onDrawOver(canvas, recyclerView, b0Var);
            } else if (getCallback().getCurrentHolder().getButtonState() != MyScoresItemTouchHelperCallback.ButtonsState.RIGHT_VISIBLE) {
                super.onDrawOver(canvas, recyclerView, b0Var);
            } else if (getCallback() instanceof MyScoresItemTouchHelperCallback) {
                RecyclerView.e0 e0Var = (RecyclerView.e0) getCallback().getCurrentHolder();
                if (e0Var.itemView.getTranslationX() == getCallback().getCurrentHolder().getOffsetX()) {
                    MyScoresItemTouchHelperCallback.drawStretchedButtons(canvas, e0Var, getCallback().getCurrentHolder().getOffsetX(), false);
                }
            }
        } catch (Exception e10) {
            super.onDrawOver(canvas, recyclerView, b0Var);
            x0.N1(e10);
        }
    }
}
