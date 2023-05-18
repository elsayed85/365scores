package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import java.lang.ref.WeakReference;
import li.o0;
import li.p0;
import li.x0;
import ud.d;
/* loaded from: classes2.dex */
public class PreviousNextView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    int f21415d;

    /* renamed from: e  reason: collision with root package name */
    int f21416e;

    /* renamed from: f  reason: collision with root package name */
    boolean f21417f;

    /* renamed from: g  reason: collision with root package name */
    boolean f21418g;

    /* renamed from: h  reason: collision with root package name */
    TextView f21419h;

    /* renamed from: i  reason: collision with root package name */
    TextView f21420i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<d> f21421j;

    public PreviousNextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21415d = Color.parseColor("#8796aa");
        this.f21416e = Color.parseColor("#515f6d");
        this.f21417f = false;
        this.f21418g = false;
        d();
    }

    public PreviousNextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21415d = Color.parseColor("#8796aa");
        this.f21416e = Color.parseColor("#515f6d");
        this.f21417f = false;
        this.f21418g = false;
        d();
    }

    protected void d() {
        try {
            View.inflate(getContext(), R.layout.O6, this);
            this.f21420i = (TextView) findViewById(R.id.Ai);
            TextView textView = (TextView) findViewById(R.id.Sk);
            this.f21419h = textView;
            textView.setText(p0.l0("QUIZ_GAME_PREVIOUS_LEVEL"));
            this.f21420i.setText(p0.l0("QUIZ_GAME_NEXT_LEVEL"));
            this.f21419h.setTypeface(o0.d(App.m()));
            this.f21420i.setTypeface(o0.d(App.m()));
            if (x0.l1()) {
                ((ConstraintLayout) this.f21420i.getParent()).setLayoutDirection(1);
                this.f21420i.setGravity(8388613);
                this.f21419h.setGravity(8388611);
            } else {
                ((ConstraintLayout) this.f21420i.getParent()).setLayoutDirection(0);
                this.f21419h.setGravity(8388613);
                this.f21420i.setGravity(8388611);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void f(boolean z10, boolean z11) {
        try {
            this.f21417f = z10;
            this.f21418g = z11;
            if (z10) {
                this.f21419h.setTextColor(this.f21415d);
                this.f21419h.setOnClickListener(this);
            } else {
                this.f21419h.setOnClickListener(null);
                this.f21419h.setTextColor(this.f21416e);
            }
            if (this.f21418g) {
                this.f21420i.setTextColor(this.f21415d);
                this.f21420i.setOnClickListener(this);
                return;
            }
            this.f21420i.setOnClickListener(null);
            this.f21420i.setTextColor(this.f21416e);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            WeakReference<d> weakReference = this.f21421j;
            if (weakReference != null && weakReference.get() != null) {
                d dVar = this.f21421j.get();
                if (this.f21418g && view.getId() == R.id.Ai) {
                    dVar.u0(false);
                } else if (this.f21417f && view.getId() == R.id.Sk) {
                    dVar.n();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setListener(d dVar) {
        try {
            this.f21421j = new WeakReference<>(dVar);
            this.f21419h.setOnClickListener(this);
            this.f21420i.setOnClickListener(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
