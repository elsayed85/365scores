package com.scores365.ui.swipe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import li.x0;
/* loaded from: classes2.dex */
public class AllScoresFakeLeftStarView extends View {
    int bottomOfView;
    private final Paint mPaint;
    private final Rect rect;
    int topOfView;
    private RecyclerView.e0 viewHolder;

    public AllScoresFakeLeftStarView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.rect = new Rect();
    }

    public AllScoresFakeLeftStarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.rect = new Rect();
    }

    public AllScoresFakeLeftStarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.rect = new Rect();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int height = (this.viewHolder.itemView.getHeight() * 42) / 64;
            int i10 = this.bottomOfView;
            AllScoresItemTouchHelperCallback.drawLeftIconWithFrame(canvas, getRight(), height, i10 - this.topOfView, 0, i10, 0, false, this.mPaint, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setBottomOfView(int i10) {
        this.bottomOfView = i10;
    }

    public void setTopOfView(int i10) {
        this.topOfView = i10;
    }

    public void setViewHolder(RecyclerView.e0 e0Var) {
        this.viewHolder = e0Var;
    }
}
