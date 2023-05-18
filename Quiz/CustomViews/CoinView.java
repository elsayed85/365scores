package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.res.h;
import androidx.core.graphics.g;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class CoinView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    ImageView f21400d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21401e;

    /* renamed from: f  reason: collision with root package name */
    private int f21402f;

    /* renamed from: g  reason: collision with root package name */
    private int f21403g;

    /* renamed from: h  reason: collision with root package name */
    private int f21404h;

    /* renamed from: i  reason: collision with root package name */
    private int f21405i;

    public CoinView(Context context) {
        super(context);
        this.f21402f = -1;
        this.f21403g = -1;
        this.f21404h = 0;
        this.f21405i = 0;
        initView();
    }

    public CoinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21402f = -1;
        this.f21403g = -1;
        this.f21404h = 0;
        this.f21405i = 0;
        initView();
    }

    public CoinView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21402f = -1;
        this.f21403g = -1;
        this.f21404h = 0;
        this.f21405i = 0;
        initView();
    }

    private void f() {
        try {
            String z10 = p0.z(this.f21404h);
            this.f21401e.setText(z10);
            if (this.f21402f == -1) {
                this.f21401e.setTextSize(1, this.f21403g);
            } else if (z10.length() > 3) {
                this.f21401e.setTextSize(1, this.f21402f);
            } else {
                this.f21401e.setTextSize(1, this.f21403g);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initView() {
        try {
            Context context = getContext();
            View.inflate(context, R.layout.P0, this);
            this.f21400d = (ImageView) findViewById(R.id.L3);
            TextView textView = new TextView(context);
            this.f21401e = textView;
            textView.setShadowLayer(1.0f, 0.0f, 2.0f, -16777216);
            this.f21401e.setTypeface(g.a(context, o0.a(context), 3));
            ((ConstraintLayout) this.f21400d.getParent()).addView(this.f21401e);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void d(int i10, int i11, int i12, int i13) {
        try {
            this.f21404h = i10;
            this.f21402f = i11;
            this.f21403g = i12;
            this.f21405i = i13;
            f();
            this.f21401e.setLayoutParams(new Constraints.a(p0.s(i13), p0.s(i13)));
            ((ConstraintLayout.b) this.f21401e.getLayoutParams()).f4630i = R.id.L3;
            ((ConstraintLayout.b) this.f21401e.getLayoutParams()).f4636l = R.id.L3;
            ((ConstraintLayout.b) this.f21401e.getLayoutParams()).f4652t = R.id.L3;
            ((ConstraintLayout.b) this.f21401e.getLayoutParams()).f4656v = R.id.L3;
            this.f21401e.setGravity(17);
            Context context = this.f21401e.getContext();
            this.f21401e.setTextColor(h.d(context.getResources(), R.color.f21620j, context.getTheme()));
            this.f21400d.getLayoutParams().height = p0.s(this.f21405i);
            this.f21400d.getLayoutParams().width = p0.s(this.f21405i);
            invalidate();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void g(int i10) {
        try {
            this.f21404h = i10;
            f();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
