package com.scores365.branding;

import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BrandingExtraParams implements Serializable {
    @c("BannerImg")
    public String bannerImg;
    @c("HitLevelFormula")
    private String hitLevelFormula;
    @c("HitLevelFormulaTokens")
    private HashSet<Integer> hitLevelFormulaTokens;
    @c("MinValueToShow")
    private String minValueToShow;
    @c("PBPEventId")
    public String pbpEventId;
    private HashMap<Integer, Integer> playerIds;
    @c("PlayerIdsRanking")
    public String playerIdsRanking;
    @c("Term")
    private String term;
    @c("TermTitle")
    public String title;
    @c("TopLogoURL")
    private String topLogoUrl;
    @c("TopLogoURLW")
    private String topLogoUrlW;

    public int getAthleteDataForPlayerCard(int i10) {
        try {
            if (this.playerIds == null) {
                this.playerIds = new HashMap<>();
                String str = this.playerIdsRanking;
                if (str != null && !str.isEmpty()) {
                    for (String str2 : this.playerIdsRanking.split("_")) {
                        String[] split = str2.split(CertificateUtil.DELIMITER);
                        if (x0.r1(split[0]) && x0.r1(split[1])) {
                            this.playerIds.put(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
                        }
                    }
                }
            }
            if (this.playerIds.containsKey(Integer.valueOf(i10))) {
                return this.playerIds.get(Integer.valueOf(i10)).intValue();
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public String getHitLevelFormula() {
        return this.hitLevelFormula;
    }

    public HashSet<Integer> getHitLevelFormulaTokens() {
        return this.hitLevelFormulaTokens;
    }

    public String getMinValueToShow() {
        return this.minValueToShow;
    }

    public String getTerm() {
        return this.term;
    }

    public String getTopLogoURL() {
        String str;
        try {
            return (!x0.n1() || (str = this.topLogoUrlW) == null || str.isEmpty()) ? this.topLogoUrl : this.topLogoUrlW;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }
}
