package com.scores365.branding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import ee.k;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class BrandingStripItem extends b {
    private String backgroundUrl = null;
    private BrandAsset brandAsset;
    private BrandingKey placement;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ImageView imageView;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.imageView = (ImageView) view.findViewById(R.id.Ld);
                view.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public BrandingStripItem(BrandAsset brandAsset, BrandingKey brandingKey) {
        this.brandAsset = brandAsset;
        this.placement = brandingKey;
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22713u0, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static void sendClickAnalytics(BrandingKey brandingKey, String str) {
        try {
            Context m10 = App.m();
            k.n(m10, "ad", "click", null, null, true, AppEventsConstants.EVENT_PARAM_AD_TYPE, "branding", "ad_screen", brandingKey.getValue(), "network", "Branding_" + str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void sendImpressionAnalytics(BrandingKey brandingKey, BrandAsset brandAsset) {
        try {
            String value = brandingKey.getValue();
            x0.S1("branding", value, "Branding_" + brandAsset.brand, "", brandAsset.getClickUrl(), "", "");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.brandingStripItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            String str = this.backgroundUrl;
            if (str != null) {
                li.u.x(str, viewHolder.imageView);
                ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) ((t) viewHolder).itemView.getLayoutParams())).topMargin = p0.s(9);
            } else {
                li.u.x(this.brandAsset.resource, viewHolder.imageView);
                ((ViewGroup.MarginLayoutParams) ((RecyclerView.q) ((t) viewHolder).itemView.getLayoutParams())).topMargin = p0.s(0);
            }
            x0.S(this.brandAsset.getImpressionUrl());
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.branding.BrandingStripItem.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        x0.M1(BrandingStripItem.this.brandAsset.getClickUrl());
                        BrandingStripItem.sendClickAnalytics(BrandingStripItem.this.placement, BrandingStripItem.this.brandAsset.brand);
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
            sendImpressionAnalytics(this.placement, this.brandAsset);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setBackgroundUrl(String str) {
        this.backgroundUrl = str;
    }
}
