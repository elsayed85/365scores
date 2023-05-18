package com.scores365.NewsCenter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ControllableAppBarLayout extends AppBarLayout {

    /* renamed from: u  reason: collision with root package name */
    private AppBarLayout.Behavior f21108u;

    /* renamed from: v  reason: collision with root package name */
    private WeakReference<CoordinatorLayout> f21109v;

    /* renamed from: w  reason: collision with root package name */
    private c f21110w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f21111x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f21112y;

    /* renamed from: z  reason: collision with root package name */
    private int f21113z;

    /* loaded from: classes2.dex */
    class a extends AppBarLayout.Behavior.a {
        a() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.e
        public boolean a(@NonNull AppBarLayout appBarLayout) {
            return ControllableAppBarLayout.this.f21112y;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21115a;

        static {
            int[] iArr = new int[c.values().length];
            f21115a = iArr;
            try {
                iArr[c.COLLAPSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21115a[c.COLLAPSE_WITH_ANIMATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21115a[c.EXPAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21115a[c.EXPAND_WITH_ANIMATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum c {
        COLLAPSE,
        COLLAPSE_WITH_ANIMATION,
        EXPAND,
        EXPAND_WITH_ANIMATION,
        NONE
    }

    public ControllableAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21110w = c.NONE;
        this.f21111x = false;
        this.f21112y = true;
    }

    private synchronized void E() {
        int i10 = b.f21115a[this.f21110w.ordinal()];
        if (i10 == 1) {
            J();
        } else if (i10 == 2) {
            I();
        } else if (i10 == 3) {
            L();
        } else if (i10 == 4) {
            K();
        }
        this.f21110w = c.NONE;
    }

    private void I() {
        if (this.f21109v.get() != null) {
            this.f21108u.onNestedFling(this.f21109v.get(), this, null, 0.0f, getHeight(), true);
        }
    }

    private void J() {
        if (this.f21109v.get() != null) {
            this.f21108u.onNestedPreScroll(this.f21109v.get(), this, null, 0, -p0.s(50), new int[]{0, 0});
        }
    }

    private void K() {
        if (this.f21109v.get() != null) {
            this.f21108u.onNestedFling(this.f21109v.get(), this, null, 0.0f, (-getHeight()) * 5, false);
        }
    }

    private void L() {
        if (this.f21109v.get() != null) {
            this.f21108u.setTopAndBottomOffset(0);
        }
    }

    public void F() {
        t(false, false);
    }

    public void G() {
        H(false);
    }

    public void H(boolean z10) {
        this.f21110w = z10 ? c.EXPAND_WITH_ANIMATION : c.EXPAND;
        requestLayout();
    }

    public AppBarLayout.Behavior getmBehavior() {
        return this.f21108u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!(getLayoutParams() instanceof CoordinatorLayout.f) || !(getParent() instanceof CoordinatorLayout)) {
            throw new IllegalStateException("ControllableAppBarLayout must be a direct child of CoordinatorLayout.");
        }
        this.f21109v = new WeakReference<>((CoordinatorLayout) getParent());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21111x) {
            return;
        }
        this.f21111x = true;
        if (this.f21110w != c.NONE) {
            E();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (i12 - i10 <= 0 || i13 - i11 <= 0 || !this.f21111x || this.f21110w == c.NONE) {
            return;
        }
        E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.AppBarLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        try {
            if (this.f21108u == null) {
                AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) ((CoordinatorLayout.f) getLayoutParams()).f();
                this.f21108u = behavior;
                behavior.setDragCallback(new a());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.View
    public void setElevation(float f10) {
        try {
            int i10 = this.f21113z;
            if (i10 > -1) {
                super.setElevation(i10);
            } else {
                super.setElevation(f10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setForcedElevation(int i10) {
        this.f21113z = i10;
    }

    public void setIsAllowedToScroll(boolean z10) {
        this.f21112y = z10;
    }
}
