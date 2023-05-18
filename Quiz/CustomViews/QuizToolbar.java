package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import java.util.ArrayList;
import java.util.Iterator;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class QuizToolbar extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private TextView f21468d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21469e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f21470f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f21471g;

    public QuizToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public QuizToolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.f22543g7, this);
        try {
            this.f21468d = (TextView) findViewById(R.id.lm);
            this.f21469e = (TextView) findViewById(R.id.km);
            this.f21470f = (LinearLayout) findViewById(R.id.dm);
            this.f21471g = (LinearLayout) findViewById(R.id.xl);
            this.f21468d.setTypeface(o0.d(App.m()));
            this.f21469e.setTypeface(o0.d(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void d(String str, String str2, ArrayList<Object> arrayList, ArrayList<Object> arrayList2) {
        LinearLayout linearLayout = this.f21471g;
        if (linearLayout != null && arrayList2 != null) {
            linearLayout.removeAllViews();
            Iterator<Object> it = arrayList2.iterator();
            while (it.hasNext()) {
                this.f21471g.addView((View) it.next());
            }
        }
        LinearLayout linearLayout2 = this.f21470f;
        if (linearLayout2 != null && arrayList != null) {
            linearLayout2.removeAllViews();
            Iterator<Object> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f21470f.addView((View) it2.next());
            }
        }
        f(str2);
        g(str);
    }

    public void f(String str) {
        try {
            if (str != null) {
                this.f21469e.setText(str);
            } else {
                this.f21469e.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void g(String str) {
        try {
            if (str != null) {
                this.f21468d.setText(str);
            } else {
                this.f21468d.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public CoinView getCoinView() {
        try {
            LinearLayout linearLayout = this.f21471g;
            if (linearLayout == null || linearLayout.getChildCount() <= 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f21471g.getChildCount(); i10++) {
                if (this.f21471g.getChildAt(i10) instanceof CoinView) {
                    return (CoinView) this.f21471g.getChildAt(i10);
                }
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }
}
