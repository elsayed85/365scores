package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.R;
import li.x0;
import ud.g;
/* loaded from: classes2.dex */
public class WatchVideoStrip extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    TextView f21472d;

    /* renamed from: e  reason: collision with root package name */
    TextView f21473e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f21474f;

    /* renamed from: g  reason: collision with root package name */
    CoinView f21475g;

    /* renamed from: h  reason: collision with root package name */
    g f21476h;

    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f21477a;

        a(View view) {
            this.f21477a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f21477a;
            if (view != null) {
                view.setEnabled(true);
            }
        }
    }

    public WatchVideoStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public WatchVideoStrip(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d();
    }

    public void d() {
        try {
            View.inflate(getContext(), R.layout.f22534fb, this);
            this.f21475g = (CoinView) findViewById(R.id.WI);
            this.f21472d = (TextView) findViewById(R.id.XI);
            this.f21473e = (TextView) findViewById(R.id.bJ);
            this.f21474f = (ImageView) findViewById(R.id.aJ);
            if (x0.l1()) {
                ((ConstraintLayout) this.f21475g.getParent()).setLayoutDirection(1);
                this.f21474f.setImageResource(R.drawable.K6);
            } else {
                ((ConstraintLayout) this.f21475g.getParent()).setLayoutDirection(0);
                this.f21474f.setImageResource(R.drawable.J6);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void f(int i10, int i11, int i12, String str, String str2) {
        try {
            this.f21475g.d(i10, i11, i12, 28);
            if (x0.l1()) {
                str = " " + str;
            }
            this.f21472d.setText(str);
            this.f21473e.setText(str2);
            this.f21473e.setOnClickListener(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Handler handler;
        a aVar;
        try {
            try {
                view.setEnabled(false);
                g gVar = this.f21476h;
                if (gVar != null) {
                    gVar.B0();
                }
                handler = new Handler();
                aVar = new a(view);
            } catch (Exception e10) {
                x0.N1(e10);
                handler = new Handler();
                aVar = new a(view);
            }
            handler.postDelayed(aVar, 500L);
        } catch (Throwable th2) {
            new Handler().postDelayed(new a(view), 500L);
            throw th2;
        }
    }

    public void setClickListener(g gVar) {
        this.f21476h = gVar;
    }
}
