package com.scores365.entitys.competitionsDetailsCards;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.scores365.R;
import com.scores365.entitys.BaseObj;
import kotlin.text.h;
import kotlin.text.v;
import li.p0;
import p9.c;
/* compiled from: BettingAddonObj.kt */
/* loaded from: classes2.dex */
public final class BettingAddonObj extends BaseObj {
    @c("Title")
    private final String title = "";
    @c("CTA_Text")
    private final String ctaText = "";

    public final SpannableString getCtaSpannableText() {
        int K;
        int P;
        K = v.K(this.ctaText, "#", 0, false, 6, null);
        P = v.P(this.ctaText, "#", 0, false, 6, null);
        SpannableString spannableString = new SpannableString(new h("#").d(this.ctaText, ""));
        if (K > -1 && P > -1) {
            spannableString.setSpan(new ForegroundColorSpan(p0.A(R.attr.T0)), K, P - 1, 17);
        }
        return spannableString;
    }

    public final String getCtaText() {
        return this.ctaText;
    }

    public final String getTitle() {
        return this.title;
    }
}
