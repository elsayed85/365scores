package com.scores365.ui.swipe;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import li.x0;
/* loaded from: classes2.dex */
public class MyScoresFakeButtonsView extends View {
    SwipeableViewHolder swipeableViewHolder;

    public MyScoresFakeButtonsView(Context context) {
        super(context);
    }

    public MyScoresFakeButtonsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyScoresFakeButtonsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            MyScoresItemTouchHelperCallback.drawStretchedButtons(canvas, (RecyclerView.e0) this.swipeableViewHolder, getWidth(), true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSwipeableViewHolder(SwipeableViewHolder swipeableViewHolder) {
        this.swipeableViewHolder = swipeableViewHolder;
    }
}
