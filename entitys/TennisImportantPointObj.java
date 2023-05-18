package com.scores365.entitys;

import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TennisImportantPointObj extends BaseObj {
    @p9.c("Competitor")
    private int competitor;
    @p9.c("Type")
    private int type;

    public int getBadgeBackground() {
        int i10 = 0;
        try {
            int i11 = this.type;
            if (i11 == 1) {
                i10 = p0.w(App.m(), R.attr.f21595w1);
            } else if (i11 == 2) {
                i10 = p0.w(App.m(), R.attr.f21589u1);
            } else if (i11 == 3) {
                i10 = p0.w(App.m(), R.attr.f21592v1);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return i10;
    }

    public String getBadgeText() {
        String str = "";
        try {
            int i10 = this.type;
            if (i10 == 1) {
                str = p0.l0("BP_TENNIS");
            } else if (i10 == 2) {
                str = p0.l0("SP_TENNIS");
            } else if (i10 == 3) {
                str = p0.l0("MP_TENNIS");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return str;
    }

    public int getCompetitor() {
        return this.competitor;
    }

    public int getType() {
        return this.type;
    }
}
