package com.scores365.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.scores365.R;
import com.scores365.branding.BrandAsset;
import com.scores365.branding.BrandingKey;
import com.scores365.branding.BrandingStripItem;
import li.x0;
/* loaded from: classes2.dex */
public class Fifa20Mgr {

    /* loaded from: classes2.dex */
    private static class BannerClickListener implements View.OnClickListener {
        BrandAsset brandAsset;
        BrandingKey brandingKey;

        public BannerClickListener(BrandAsset brandAsset, BrandingKey brandingKey) {
            this.brandAsset = brandAsset;
            this.brandingKey = brandingKey;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                x0.M1(this.brandAsset.getClickUrl());
                BrandingStripItem.sendClickAnalytics(this.brandingKey, this.brandAsset.brand);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static void handlePlayerCardView(ViewGroup viewGroup, BrandAsset brandAsset, int i10, BrandingKey brandingKey) {
        try {
            li.u.x(brandAsset.getResource(), (ImageView) viewGroup.findViewById(R.id.f22445za));
            ((TextView) viewGroup.findViewById(R.id.YG)).setText(brandAsset.getTermTitle().replace("#", String.valueOf(i10)));
            ((DiamondView) viewGroup.findViewById(R.id.T4)).setPercentFill(i10 / 100.0f);
            viewGroup.setOnClickListener(new BannerClickListener(brandAsset, brandingKey));
            BrandingStripItem.sendImpressionAnalytics(brandingKey, brandAsset);
            x0.S(brandAsset.getImpressionUrl());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
