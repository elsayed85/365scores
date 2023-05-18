package com.scores365.gameCenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import of.q;
/* loaded from: classes2.dex */
public class NameAndScoreView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private TextView f23691d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f23692e;

    public NameAndScoreView(Context context) {
        super(context);
        initView();
    }

    public NameAndScoreView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void initView() {
        try {
            View inflate = li.x0.l1() ? View.inflate(getContext(), R.layout.F4, this) : View.inflate(getContext(), R.layout.E4, this);
            this.f23691d = (TextView) inflate.findViewById(R.id.Pf);
            TextView textView = (TextView) inflate.findViewById(R.id.so);
            this.f23692e = textView;
            textView.setTypeface(li.o0.d(App.m()));
            this.f23692e.setEllipsize(TextUtils.TruncateAt.END);
            this.f23692e.setMaxLines(2);
            this.f23692e.setTag(q.c.NAME);
            this.f23691d.setTag(q.c.LIVE_SCORE);
            this.f23692e.setGravity(19);
            if (li.x0.l1()) {
                this.f23692e.setGravity(21);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public TextView getNameTv() {
        return this.f23692e;
    }

    public TextView getScoresTv() {
        return this.f23691d;
    }

    public void setProperties(String str) {
        try {
            TextView textView = this.f23692e;
            if (textView != null) {
                textView.setText(str);
                this.f23692e.setVisibility(0);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
