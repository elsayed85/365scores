package com.scores365.Design.Pagers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bg.d;
import bg.e;
import com.scores365.Design.Pagers.GameCenterTabsIndicator;
import com.scores365.R;
import com.scores365.gameCenter.i0;
import dd.a;
import dd.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.p0;
/* compiled from: GameCenterTabsIndicator.kt */
/* loaded from: classes2.dex */
public final class GameCenterTabsIndicator extends GeneralTabPageIndicator {
    private boolean G;
    private int H;
    private i0.m I;
    private int J;
    private long K;
    private d L;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameCenterTabsIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCenterTabsIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.H = -1;
        this.J = -1;
        this.K = -1L;
    }

    public /* synthetic */ GameCenterTabsIndicator(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GameCenterTabsIndicator this$0, int i10, View view) {
        m.g(this$0, "this$0");
        this$0.f20920f.setCurrentItem(i10);
        if (this$0.G && i10 == this$0.H) {
            this$0.t();
            this$0.u();
        }
    }

    private final void t() {
        this.H = -1;
        setTopTrend(false);
    }

    private final void u() {
        i0.m mVar = this.I;
        if (mVar != null) {
            mVar.p(e.TRENDS, this.L, false, null);
        }
        b bVar = b.f25119a;
        if (!bVar.i(this.J)) {
            bVar.g(new a(this.J, this.K));
        }
    }

    @Override // com.scores365.Design.Pagers.GeneralTabPageIndicator
    public View g(int i10, String str, String str2, boolean z10) {
        TextView textView;
        View v10 = super.g(i10, str, str2, z10);
        if (this.G && i10 == this.H && (textView = (TextView) v10.findViewById(R.id.pG)) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.f21864z1, 0, 0, 0);
            textView.setCompoundDrawablePadding(p0.s(2));
        }
        m.f(v10, "v");
        return v10;
    }

    public final int getGameId() {
        return this.J;
    }

    public final long getGameStartTime() {
        return this.K;
    }

    public final i0.m getListener() {
        return this.I;
    }

    public final d getMainPageType() {
        return this.L;
    }

    public final int getPositionForTopTrend() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pagers.GeneralTabPageIndicator
    public void h(final int i10, View view) {
        super.h(i10, view);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: qb.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GameCenterTabsIndicator.s(GameCenterTabsIndicator.this, i10, view2);
                }
            });
        }
    }

    public final void setGameId(int i10) {
        this.J = i10;
    }

    public final void setGameStartTime(long j10) {
        this.K = j10;
    }

    public final void setListener(i0.m mVar) {
        this.I = mVar;
    }

    public final void setMainPageType(d dVar) {
        this.L = dVar;
    }

    public final void setPositionForTopTrend(int i10) {
        this.H = i10;
    }

    public final void setTopTrend(boolean z10) {
        this.G = z10;
        l();
    }
}
