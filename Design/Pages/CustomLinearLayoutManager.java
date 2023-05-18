package com.scores365.Design.Pages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.R;
/* compiled from: CustomLinearLayoutManager.kt */
/* loaded from: classes2.dex */
public final class CustomLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20944a;

    /* renamed from: b  reason: collision with root package name */
    private final float f20945b;

    /* renamed from: c  reason: collision with root package name */
    private final float f20946c;

    /* renamed from: d  reason: collision with root package name */
    private final float f20947d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20948e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
        kotlin.jvm.internal.m.g(context, "context");
        this.f20945b = 0.09f;
        this.f20946c = 0.9f;
        this.f20947d = 0.9f;
    }

    public CustomLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f20945b = 0.09f;
        this.f20946c = 0.9f;
        this.f20947d = 0.9f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally() && !this.f20944a;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public boolean canScrollVertically() {
        return super.canScrollVertically() && !this.f20944a;
    }

    public final void k() {
        ViewGroup viewGroup;
        float width = getWidth() / 2.0f;
        float f10 = this.f20946c * width;
        float f11 = 1.0f - this.f20945b;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            kotlin.jvm.internal.m.d(childAt);
            float min = (Math.min(f10, Math.abs(width - ((getDecoratedRight(childAt) + getDecoratedLeft(childAt)) / 2.0f))) - 0.0f) / (f10 - 0.0f);
            float f12 = ((f11 - 1.0f) * min) + 1.0f;
            childAt.setScaleX(f12);
            childAt.setScaleY(f12);
            if (childAt instanceof ViewGroup) {
                View childAt2 = ((ViewGroup) childAt).getChildAt(viewGroup.getChildCount() - 1);
                if (childAt2.getId() == R.id.E4) {
                    float f13 = 0;
                    childAt2.setAlpha(f13 + ((0.4f - f13) * min));
                }
            }
        }
    }

    public final void l(boolean z10) {
        this.f20944a = z10;
    }

    public final void m(boolean z10) {
        this.f20948e = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public int scrollHorizontallyBy(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i10, wVar, b0Var);
        if (getOrientation() == 0 && this.f20948e) {
            k();
        }
        return scrollHorizontallyBy;
    }
}
