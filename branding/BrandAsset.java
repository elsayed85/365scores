package com.scores365.branding;

import com.facebook.internal.security.CertificateUtil;
import com.scores365.entitys.IGsonEntity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BrandAsset implements Serializable, IGsonEntity<String> {
    @c("BrandName")
    public String brand;
    @c("ClickUrl")
    private String clickUrl;
    @c("EntryId")
    public String entryid;
    @c("ImaTag")
    public String imaTag;
    @c("ImpressionUrl")
    private String impression_url;
    private HashMap<Integer, Integer> playerIds;
    @c("Resource")
    protected String resource;
    @c("ResourceW")
    protected String resourceWhite;
    @c("SponsoredByText")
    public boolean shouldShowSponsoredByText;
    @c("StatusesIds")
    private String statusesIds;
    @c("Thumbnail")
    public String thumbnailImageUrl;
    @c("VideoType")
    public String type;
    @c("ExtraParams")
    private HashMap<String, String> extraParams = new HashMap<>();
    HashSet<Integer> tokens = null;

    public boolean avoidHeaderFolding() {
        try {
            return Boolean.parseBoolean(this.extraParams.get("AvoidHeaderFolding"));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public int getAthleteDataForPlayerCard(int i10) {
        try {
            if (this.playerIds == null) {
                this.playerIds = new HashMap<>();
                String str = this.extraParams.get("PlayerIdsRanking");
                if (str != null && !str.isEmpty()) {
                    for (String str2 : str.split("_")) {
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

    public String getBannerImg() {
        return this.extraParams.get("BannerImg");
    }

    public String getClickUrl() {
        return x0.R1(this.clickUrl);
    }

    public String getHitLevelFormula() {
        return this.extraParams.get("HitLevelFormula");
    }

    public HashSet<Integer> getHitLevelFormulaTokens() {
        String[] split;
        try {
            if (this.tokens == null) {
                this.tokens = new HashSet<>();
                String str = this.extraParams.get("HitLevelFormulaTokens");
                if (str != null) {
                    for (String str2 : str.split(",")) {
                        if (x0.r1(str2)) {
                            this.tokens.add(Integer.valueOf(str2));
                        }
                    }
                }
            }
        } catch (NumberFormatException e10) {
            x0.N1(e10);
        }
        return this.tokens;
    }

    public String getImpressionUrl() {
        String str = this.impression_url;
        try {
            return str.contains("%%CACHEBUSTER%%") ? this.impression_url.replace("%%CACHEBUSTER%%", String.valueOf(System.currentTimeMillis())) : str;
        } catch (Exception e10) {
            x0.N1(e10);
            return str;
        }
    }

    @Override // com.scores365.entitys.IGsonEntity
    public String getKey() {
        return this.brand;
    }

    public String getMinValueToShow() {
        return this.extraParams.get("MinValueToShow");
    }

    public String getPbpEventId() {
        return this.extraParams.get("PBPEventId");
    }

    public String getResource() {
        String str;
        try {
            return (!x0.n1() || (str = this.resourceWhite) == null || str.isEmpty()) ? this.resource : this.resourceWhite;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getTerm() {
        return this.extraParams.get("Term");
    }

    public String getTermTitle() {
        return this.extraParams.get("TermTitle");
    }

    public int getTopBookmaker() {
        try {
            return Integer.valueOf(this.extraParams.get("BookmakerID")).intValue();
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public String getTopLeftLogoURL() {
        try {
            String str = this.extraParams.get("TopLeftLogoURLW");
            return (!x0.n1() || str == null || str.isEmpty()) ? this.extraParams.get("TopLeftLogoURL") : str;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getTopLogoURL() {
        try {
            String str = this.extraParams.get("TopLogoURLW");
            return (!x0.n1() || str == null || str.isEmpty()) ? this.extraParams.get("TopLogoURL") : str;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getTopRightLogoURL() {
        try {
            String str = this.extraParams.get("TopRightLogoURLW");
            return (!x0.n1() || str == null || str.isEmpty()) ? this.extraParams.get("TopRightLogoURL") : str;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public boolean isStatusExist(int i10) {
        try {
            for (String str : this.statusesIds.split(",")) {
                if (i10 == Integer.parseInt(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean shouldHideCompetitionLogo() {
        try {
            return Boolean.parseBoolean(this.extraParams.get("HideLogo"));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean shouldHideCompetitionName() {
        try {
            return Boolean.parseBoolean(this.extraParams.get("HideCompetitionName"));
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
