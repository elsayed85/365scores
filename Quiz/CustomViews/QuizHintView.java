package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import java.lang.ref.WeakReference;
import li.o0;
import li.x0;
import ud.a;
/* loaded from: classes2.dex */
public class QuizHintView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    TextView f21433d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f21434e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f21435f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f21436g;

    /* renamed from: h  reason: collision with root package name */
    CoinView f21437h;

    /* renamed from: i  reason: collision with root package name */
    int f21438i;

    /* renamed from: j  reason: collision with root package name */
    String f21439j;

    /* renamed from: k  reason: collision with root package name */
    WeakReference<a> f21440k;

    /* renamed from: l  reason: collision with root package name */
    int f21441l;

    /* renamed from: m  reason: collision with root package name */
    int f21442m;

    /* renamed from: n  reason: collision with root package name */
    boolean f21443n;

    public QuizHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21438i = -1;
        this.f21439j = null;
        this.f21440k = null;
        this.f21441l = -1;
        this.f21442m = -1;
        this.f21443n = false;
        d();
    }

    public QuizHintView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21438i = -1;
        this.f21439j = null;
        this.f21440k = null;
        this.f21441l = -1;
        this.f21442m = -1;
        this.f21443n = false;
        d();
    }

    public void d() {
        try {
            View.inflate(getContext(), R.layout.M6, this);
            this.f21433d = (TextView) findViewById(R.id.Gl);
            this.f21434e = (ImageView) findViewById(R.id.Dl);
            this.f21437h = (CoinView) findViewById(R.id.Fl);
            this.f21435f = (ImageView) findViewById(R.id.El);
            this.f21436g = (ImageView) findViewById(R.id.Cl);
            this.f21433d.setTypeface(o0.a(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void f(int i10, int i11, int i12, String str, boolean z10) {
        try {
            this.f21443n = z10;
            if (z10) {
                this.f21437h.setVisibility(4);
                this.f21436g.setVisibility(4);
                this.f21435f.setVisibility(0);
            } else {
                this.f21437h.setVisibility(0);
                this.f21437h.d(i10, 20, 20, 47);
                this.f21436g.setVisibility(0);
                this.f21435f.setVisibility(8);
            }
            this.f21438i = i10;
            this.f21441l = i11;
            this.f21442m = i12;
            this.f21439j = str;
            this.f21433d.setBackgroundResource(i12);
            this.f21434e.setImageResource(this.f21441l);
            this.f21433d.setText(this.f21439j);
            if (!x0.l1()) {
                ((ConstraintLayout) this.f21437h.getParent()).setLayoutDirection(0);
                return;
            }
            ((ConstraintLayout) this.f21437h.getParent()).setLayoutDirection(1);
            this.f21434e.setScaleX(-1.0f);
            this.f21436g.setScaleX(-1.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public int getNumOfCoinsForHint() {
        return this.f21438i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            WeakReference<a> weakReference = this.f21440k;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f21440k.get().a(this.f21443n);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setHintClickListener(a aVar) {
        this.f21440k = new WeakReference<>(aVar);
        ((ConstraintLayout) this.f21437h.getParent()).setOnClickListener(this);
    }
}
