package com.scores365.NewsCenter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.R;
/* loaded from: classes2.dex */
public class NewsCenterStickyPlayerControlView extends PlayerControlView {
    public NewsCenterStickyPlayerControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a0();
    }

    public NewsCenterStickyPlayerControlView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a0();
    }

    protected void a0() {
        try {
            ((AppCompatImageButton) findViewById(R.id.f15908q)).setImageResource(0);
            findViewById(R.id.f15908q).setBackgroundResource(0);
            findViewById(R.id.f15908q).setOnClickListener(null);
            ((AppCompatImageButton) findViewById(R.id.f15899h)).setImageResource(0);
            findViewById(R.id.f15899h).setBackgroundResource(0);
            findViewById(R.id.f15899h).setOnClickListener(null);
            ((AppCompatImageButton) findViewById(R.id.f15900i)).setImageResource(0);
            findViewById(R.id.f15900i).setBackgroundResource(0);
            findViewById(R.id.f15900i).setOnClickListener(null);
            ((AppCompatImageButton) findViewById(R.id.f15905n)).setImageResource(0);
            findViewById(R.id.f15905n).setBackgroundResource(0);
            findViewById(R.id.f15905n).setOnClickListener(null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
