package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class QuizSettingsItemView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private c f21452d;

    /* renamed from: e  reason: collision with root package name */
    private SwitchCompat f21453e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21454f;

    /* loaded from: classes2.dex */
    public interface a {
        void H0(c cVar, boolean z10);
    }

    /* loaded from: classes2.dex */
    public static class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        a f21455a;

        /* renamed from: b  reason: collision with root package name */
        c f21456b;

        public b(c cVar, a aVar) {
            this.f21456b = cVar;
            this.f21455a = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            a aVar = this.f21455a;
            if (aVar != null) {
                aVar.H0(this.f21456b, z10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum c {
        SOUND,
        VIBRATION,
        NOTIFICATION
    }

    public QuizSettingsItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public QuizSettingsItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d(context);
    }

    public void d(Context context) {
        try {
            if (x0.l1()) {
                View.inflate(context, R.layout.Z6, this);
                ((TextView) findViewById(R.id.op)).setGravity(5);
            } else {
                View.inflate(context, R.layout.Y6, this);
            }
            this.f21454f = (TextView) findViewById(R.id.op);
            this.f21453e = (SwitchCompat) findViewById(R.id.pp);
            this.f21454f.setTypeface(o0.d(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSettingName(String str) {
        try {
            this.f21454f.setText(str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSettingType(c cVar) {
        this.f21452d = cVar;
    }

    public void setSwitchListener(a aVar) {
        this.f21453e.setOnCheckedChangeListener(new b(this.f21452d, aVar));
    }

    public void setSwitchStatus(boolean z10) {
        try {
            this.f21453e.setChecked(z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
