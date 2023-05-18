package com.scores365.Design.Pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: o0  reason: collision with root package name */
    private boolean f20949o0;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20949o0 = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f20949o0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f20949o0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setSwipePagingEnabled(boolean z10) {
        this.f20949o0 = z10;
    }
}
