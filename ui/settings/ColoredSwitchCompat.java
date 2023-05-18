package com.scores365.ui.settings;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.scores365.R;
import li.p0;
/* loaded from: classes2.dex */
public class ColoredSwitchCompat extends SwitchCompat {
    public ColoredSwitchCompat(Context context) {
        super(context);
    }

    public ColoredSwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColoredSwitchCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        try {
            getTrackDrawable().setColorFilter(p0.A(R.attr.f21580r1), PorterDuff.Mode.MULTIPLY);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
