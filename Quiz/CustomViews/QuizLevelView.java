package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class QuizLevelView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private int f21444d;

    /* renamed from: e  reason: collision with root package name */
    private int f21445e;

    /* renamed from: f  reason: collision with root package name */
    private int f21446f;

    /* renamed from: g  reason: collision with root package name */
    private String f21447g;

    /* renamed from: h  reason: collision with root package name */
    private String f21448h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f21449i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f21450j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f21451k;

    /* loaded from: classes2.dex */
    public enum a {
        FACEBOOK(0),
        IN_PROGRESS(1),
        COMPLETED(2),
        LOCKED(3);
        
        private int value;

        a(int i10) {
            this.value = i10;
        }

        public static a create(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return LOCKED;
                    }
                    return COMPLETED;
                }
                return IN_PROGRESS;
            }
            return FACEBOOK;
        }

        public int getValue() {
            return this.value;
        }
    }

    public QuizLevelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21444d = -1;
        this.f21445e = -1;
        this.f21446f = -1;
        this.f21447g = null;
        this.f21448h = null;
        g();
    }

    public QuizLevelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21444d = -1;
        this.f21445e = -1;
        this.f21446f = -1;
        this.f21447g = null;
        this.f21448h = null;
        g();
    }

    public static int d(a aVar) {
        int i10 = R.drawable.I0;
        int ordinal = aVar.ordinal();
        return ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? i10 : R.drawable.D4 : R.drawable.C4 : R.drawable.I0 : R.drawable.X;
    }

    public static int f(a aVar) {
        int i10 = R.drawable.R5;
        int ordinal = aVar.ordinal();
        return ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? i10 : R.drawable.P5 : R.drawable.N5 : R.drawable.R5 : R.drawable.Y;
    }

    private void i() {
        try {
            this.f21450j.setVisibility(8);
            this.f21451k.setImageResource(0);
            int i10 = this.f21445e;
            if (i10 != -1) {
                this.f21451k.setBackgroundResource(i10);
            }
            if (this.f21444d != 0) {
                this.f21450j.setVisibility(8);
                this.f21451k.setImageResource(this.f21444d);
            } else if (this.f21447g != null) {
                this.f21450j.setVisibility(0);
                this.f21450j.setText(this.f21447g);
                this.f21451k.setImageResource(0);
            }
            int i11 = this.f21446f;
            if (i11 != 0) {
                this.f21449i.setBackgroundResource(i11);
            }
            String str = this.f21448h;
            if (str != null) {
                this.f21449i.setText(str);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void g() {
        try {
            View.inflate(getContext(), R.layout.N6, this);
            this.f21449i = (TextView) findViewById(R.id.Ml);
            this.f21450j = (TextView) findViewById(R.id.Kl);
            this.f21451k = (ImageView) findViewById(R.id.Ll);
            if (x0.l1()) {
                ((ConstraintLayout) this.f21449i.getParent()).setLayoutDirection(1);
                this.f21451k.setScaleX(-1.0f);
            } else {
                ((ConstraintLayout) this.f21449i.getParent()).setLayoutDirection(0);
            }
            this.f21449i.setTypeface(o0.a(App.m()));
            this.f21450j.setTypeface(o0.a(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void h(int i10, int i11, String str, int i12, String str2, a aVar) {
        try {
            this.f21444d = i10;
            this.f21445e = i11;
            this.f21447g = str;
            this.f21446f = i12;
            this.f21448h = str2;
            i();
            if (x0.l1() && aVar == a.FACEBOOK) {
                ((ConstraintLayout) this.f21449i.getParent()).setLayoutDirection(0);
                this.f21451k.setScaleX(1.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
