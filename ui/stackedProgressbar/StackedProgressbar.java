package com.scores365.ui.stackedProgressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.R;
import java.util.ArrayList;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class StackedProgressbar extends View {
    private float animationValue;
    private boolean isAnimationDirectionRTL;
    private boolean isRtl;
    private ArrayList<StackedProgressbarItem> mProgressItemsList;
    Path path;
    private int progressBarWidth;
    Paint progressPaint;
    private int selection;

    public StackedProgressbar(Context context) {
        super(context);
        this.selection = -1;
        this.progressBarWidth = 0;
        this.isAnimationDirectionRTL = false;
        this.animationValue = 1.0f;
    }

    public StackedProgressbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.selection = -1;
        this.progressBarWidth = 0;
        this.isAnimationDirectionRTL = false;
        this.animationValue = 1.0f;
        init();
    }

    public StackedProgressbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.selection = -1;
        this.progressBarWidth = 0;
        this.isAnimationDirectionRTL = false;
        this.animationValue = 1.0f;
        init();
    }

    private int getXCoordinate(int i10) {
        try {
            return this.isRtl ? this.progressBarWidth - i10 : i10;
        } catch (Exception e10) {
            x0.N1(e10);
            return i10;
        }
    }

    public void init() {
    }

    public void initData(ArrayList<StackedProgressbarItem> arrayList, boolean z10) {
        try {
            this.mProgressItemsList = arrayList;
            this.isRtl = z10;
            this.progressPaint = new Paint();
            this.path = new Path();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        float f10;
        try {
            ArrayList<StackedProgressbarItem> arrayList = this.mProgressItemsList;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.progressBarWidth = getWidth();
            int height = getHeight();
            int i11 = 0;
            int i12 = 0;
            while (i11 < this.mProgressItemsList.size()) {
                StackedProgressbarItem stackedProgressbarItem = this.mProgressItemsList.get(i11);
                this.progressPaint.reset();
                int i13 = this.selection;
                if ((i13 == -1 || i11 != i13 - 1) && !(this.mProgressItemsList.size() == 2 && this.selection == 3 && i11 == 1)) {
                    this.progressPaint.setColor(stackedProgressbarItem.color);
                } else {
                    this.progressPaint.setColor(p0.A(R.attr.T0));
                }
                float f11 = stackedProgressbarItem.progressItemPercentage;
                int i14 = this.progressBarWidth;
                int i15 = (int) (i14 * f11);
                if (i11 == 0) {
                    if (!this.isAnimationDirectionRTL) {
                        f10 = i15 * this.animationValue;
                    } else if (f11 != 0.0f) {
                        i15 = (int) (i15 * ((1.0f / f11) - (((1.0f - f11) * this.animationValue) / f11)));
                    } else {
                        f10 = i14 * (1.0f - this.animationValue);
                    }
                    i15 = (int) f10;
                }
                int i16 = i15 + i12;
                if (i11 != this.mProgressItemsList.size() - 1 || i16 == (i10 = this.progressBarWidth)) {
                    i10 = i16;
                }
                this.path.reset();
                this.path.moveTo(getXCoordinate(i10), 0.0f);
                if (i11 == 0) {
                    this.path.lineTo(getXCoordinate(i12), 0.0f);
                } else {
                    this.path.lineTo(getXCoordinate(i12 + 10), 0.0f);
                }
                float f12 = height;
                this.path.lineTo(getXCoordinate(i12), f12);
                if (i11 == this.mProgressItemsList.size() - 1) {
                    this.path.lineTo(getXCoordinate(i10), f12);
                } else {
                    this.path.lineTo(getXCoordinate(i10 - 10), f12);
                }
                this.path.lineTo(getXCoordinate(i10), 0.0f);
                canvas.drawPath(this.path, this.progressPaint);
                i11++;
                i12 = i10;
            }
            super.onDraw(canvas);
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setAnimationDirectionRTL(boolean z10) {
        this.isAnimationDirectionRTL = z10;
    }

    public void setAnimationValue(float f10) {
        this.animationValue = f10;
        invalidate();
    }

    public void setSelection(int i10) {
        this.selection = i10;
    }
}
