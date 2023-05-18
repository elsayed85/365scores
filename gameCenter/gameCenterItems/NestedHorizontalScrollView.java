package com.scores365.gameCenter.gameCenterItems;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.scores365.ui.playerCard.CustomHorizontalScrollView;
import li.x0;
/* loaded from: classes2.dex */
public class NestedHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    float f23750a;

    /* renamed from: b  reason: collision with root package name */
    float f23751b;

    /* renamed from: c  reason: collision with root package name */
    private CustomHorizontalScrollView.Companion.iScrollListener f23752c;

    public NestedHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23752c = null;
    }

    public NestedHorizontalScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f23752c = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        try {
            CustomHorizontalScrollView.Companion.iScrollListener iscrolllistener = this.f23752c;
            if (iscrolllistener != null) {
                iscrolllistener.onScrolled(i10, i11, i12, i13);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f23750a = motionEvent.getX();
                this.f23751b = motionEvent.getY();
            } else if (actionMasked == 2) {
                float x10 = motionEvent.getX() - this.f23750a;
                if (Math.abs(x10) > Math.abs(motionEvent.getY() - this.f23751b)) {
                    if (x10 > 0.0f && getScrollX() == 0) {
                        return false;
                    }
                    int width = getChildAt(0).getWidth();
                    if (x10 < 0.0f && getScrollX() + getWidth() >= width) {
                        return false;
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void setScrollListener(CustomHorizontalScrollView.Companion.iScrollListener iscrolllistener) {
        this.f23752c = iscrolllistener;
    }
}
