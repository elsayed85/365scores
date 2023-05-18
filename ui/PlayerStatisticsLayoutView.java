package com.scores365.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.e1;
import com.scores365.R;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerStatisticsLayoutView extends RelativeLayout {
    public ImageView ivStatImage;
    public LinearLayout llData;
    public LinearLayout llTitles;
    public LinearLayout llTitlesNumbersLayout;

    public PlayerStatisticsLayoutView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        try {
            LayoutInflater.from(context).inflate(R.layout.f22746w9, (ViewGroup) this, true);
            this.ivStatImage = (ImageView) findViewById(R.id.f22426yd);
            this.llTitles = (LinearLayout) findViewById(R.id.Fg);
            this.llData = (LinearLayout) findViewById(R.id.Eg);
            this.llTitlesNumbersLayout = (LinearLayout) findViewById(R.id.Qg);
            e1.I0(this, x0.m0());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
