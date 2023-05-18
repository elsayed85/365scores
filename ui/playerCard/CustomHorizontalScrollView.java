package com.scores365.ui.playerCard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import li.x0;
/* compiled from: CustomHorizontalScrollView.kt */
/* loaded from: classes2.dex */
public final class CustomHorizontalScrollView extends HorizontalScrollView {
    public static final Companion Companion = new Companion(null);
    private boolean mScrollable;
    private Companion.iScrollListener scrollListener;

    /* compiled from: CustomHorizontalScrollView.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* compiled from: CustomHorizontalScrollView.kt */
        /* loaded from: classes2.dex */
        public interface iScrollListener {
            void onScrolled(int i10, int i11, int i12, int i13);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHorizontalScrollView(Context context) {
        super(context);
        kotlin.jvm.internal.m.g(context, "context");
        this.mScrollable = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        this.mScrollable = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHorizontalScrollView(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        this.mScrollable = true;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i10) {
    }

    public final boolean getMScrollable() {
        return this.mScrollable;
    }

    public final Companion.iScrollListener getScrollListener() {
        return this.scrollListener;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mScrollable && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        try {
            Companion.iScrollListener iscrolllistener = this.scrollListener;
            if (iscrolllistener != null) {
                iscrolllistener.onScrolled(i10, i11, i12, i13);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.m.g(ev, "ev");
        return ev.getAction() == 0 ? this.mScrollable && super.onTouchEvent(ev) : super.onTouchEvent(ev);
    }

    public final void setMScrollable(boolean z10) {
        this.mScrollable = z10;
    }

    public final void setScrollListener(Companion.iScrollListener iscrolllistener) {
        this.scrollListener = iscrolllistener;
    }
}
