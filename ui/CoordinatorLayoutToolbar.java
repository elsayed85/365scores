package com.scores365.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class CoordinatorLayoutToolbar extends Toolbar {
    ImageView logoView;
    TextView titleView;

    public CoordinatorLayoutToolbar(Context context) {
        super(context);
        this.logoView = null;
        this.titleView = null;
    }

    public CoordinatorLayoutToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.logoView = null;
        this.titleView = null;
    }

    public CoordinatorLayoutToolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.logoView = null;
        this.titleView = null;
    }

    private boolean isChild(View view) {
        return view.getParent() == this;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(int i10) {
        super.setLogo(i10);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(Drawable drawable) {
        super.setLogo((Drawable) null);
        try {
            if (this.logoView == null) {
                this.logoView = (ImageView) findViewById(R.id.Vs);
            }
            ImageView imageView = this.logoView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        super.setTitle((CharSequence) null);
        try {
            if (this.titleView == null) {
                TextView textView = (TextView) findViewById(R.id.Zr);
                this.titleView = textView;
                if (textView != null) {
                    textView.setTypeface(o0.a(App.m()));
                }
            }
            TextView textView2 = this.titleView;
            if (textView2 != null) {
                textView2.setText(charSequence);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
