package com.scores365.Quiz.CustomViews.quizProfileDataRaw;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import java.util.ArrayList;
import java.util.List;
import li.x0;
/* loaded from: classes2.dex */
public class QuizProfileDataRawView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    List<TextView> f21496d;

    public QuizProfileDataRawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public QuizProfileDataRawView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void initView() {
        try {
            if (x0.l1()) {
                View.inflate(App.m(), R.layout.Q6, this);
                ((TextView) findViewById(R.id.Ms)).setGravity(5);
                Log.e("entered", "entered");
            } else {
                View.inflate(App.m(), R.layout.P6, this);
            }
            ArrayList arrayList = new ArrayList();
            this.f21496d = arrayList;
            arrayList.add((TextView) findViewById(R.id.Ms));
            this.f21496d.add((TextView) findViewById(R.id.uI));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void d() {
        SpannableString spannableString;
        SpannableString spannableString2;
        try {
            if (x0.l1()) {
                spannableString = new SpannableString(" " + ((Object) this.f21496d.get(0).getText()));
                spannableString2 = new SpannableString(" " + ((Object) this.f21496d.get(1).getText()));
            } else {
                spannableString = new SpannableString(this.f21496d.get(0).getText());
                spannableString2 = new SpannableString(((Object) this.f21496d.get(1).getText()) + " ");
            }
            spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 0);
            this.f21496d.get(0).setText(spannableString);
            spannableString2.setSpan(new StyleSpan(2), 0, spannableString2.length(), 0);
            this.f21496d.get(1).setText(spannableString2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void f(String str, String str2, Typeface typeface, String str3, boolean z10) {
        try {
            setTitle(str);
            setValue(str3);
            setTextsColor(str2);
            setTextsTypeFace(typeface);
            if (z10) {
                d();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setTextsColor(String str) {
        try {
            this.f21496d.get(0).setTextColor(Color.parseColor(str));
            this.f21496d.get(1).setTextColor(Color.parseColor(str));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setTextsTypeFace(Typeface typeface) {
        try {
            this.f21496d.get(0).setTypeface(typeface);
            this.f21496d.get(1).setTypeface(typeface);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setTitle(String str) {
        try {
            this.f21496d.get(0).setText(str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setValue(String str) {
        try {
            this.f21496d.get(1).setText(str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
