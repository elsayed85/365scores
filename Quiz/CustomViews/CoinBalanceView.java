package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.g;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CoinBalanceView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    CoinView f21396d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21397e;

    /* renamed from: f  reason: collision with root package name */
    String f21398f;

    /* renamed from: g  reason: collision with root package name */
    int f21399g;

    public CoinBalanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21398f = "";
        this.f21399g = -1;
        d();
    }

    public CoinBalanceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21398f = "";
        this.f21399g = -1;
        d();
    }

    public void d() {
        View.inflate(getContext(), R.layout.O0, this);
        try {
            this.f21397e = (TextView) findViewById(R.id.I3);
            this.f21396d = (CoinView) findViewById(R.id.K);
            if (x0.l1()) {
                ((ConstraintLayout) this.f21397e.getParent()).setLayoutDirection(1);
            } else {
                ((ConstraintLayout) this.f21397e.getParent()).setLayoutDirection(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setProperties(int i10) {
        try {
            this.f21398f = p0.l0("QUIZ_GAME_COINS_BALANCE");
            if (x0.l1()) {
                this.f21398f = " " + this.f21398f;
            }
            this.f21399g = i10;
            this.f21396d.d(i10, 12, 16, 37);
            Context context = this.f21397e.getContext();
            this.f21397e.setTextSize(1, 16.0f);
            this.f21397e.setText(this.f21398f);
            this.f21397e.setTypeface(g.a(context, o0.a(context), 3));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
