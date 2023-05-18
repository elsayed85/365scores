package com.scores365.entitys;

import java.util.HashSet;
import java.util.Iterator;
import li.x0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CountryObj extends BaseObj implements Comparable {
    private static final long serialVersionUID = -7590964139738418530L;
    @p9.c("FatherCountryId")
    private int fatherCountryId;
    @p9.c("GamesCount")
    private int gamesCount;
    @p9.c("ImgVer")
    private int imgVer;
    @p9.c("NotReal")
    public boolean isCountryNotReal;
    @p9.c("IsInternational")
    private boolean isInternational;
    @p9.c("LiveCount")
    private int liveCount;
    @p9.c("PhoneCode")
    public int phoneCode;
    @p9.c("Sports")
    private HashSet<Integer> supportedSportType;

    public CountryObj() {
        this.supportedSportType = new HashSet<>();
        this.isInternational = false;
        this.isCountryNotReal = false;
        this.phoneCode = -1;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.imgVer = -1;
        this.fatherCountryId = -1;
    }

    public CountryObj(int i10, String str) {
        super(i10, str);
        new HashSet();
        this.isInternational = false;
        this.isCountryNotReal = false;
        this.phoneCode = -1;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.imgVer = -1;
        this.fatherCountryId = -1;
        this.supportedSportType = null;
    }

    public CountryObj(int i10, String str, HashSet<Integer> hashSet, boolean z10) {
        super(i10, str);
        new HashSet();
        this.isInternational = false;
        this.phoneCode = -1;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.imgVer = -1;
        this.fatherCountryId = -1;
        this.supportedSportType = hashSet;
        this.isCountryNotReal = z10;
    }

    public CountryObj(String str, String str2) {
        super(Integer.parseInt(str), str2);
        new HashSet();
        this.isInternational = false;
        this.isCountryNotReal = false;
        this.phoneCode = -1;
        this.gamesCount = -1;
        this.liveCount = -1;
        this.imgVer = -1;
        this.fatherCountryId = -1;
        this.supportedSportType = null;
    }

    public static CountryObj parseJson(JSONObject jSONObject) {
        try {
            return (CountryObj) GsonManager.getGson().l(jSONObject.toString(), CountryObj.class);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof CountryObj)) {
            return 0;
        }
        return this.name.compareToIgnoreCase(((CountryObj) obj).name);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CountryObj)) {
            return false;
        }
        CountryObj countryObj = (CountryObj) obj;
        return countryObj.f23582id == this.f23582id && countryObj.name.equalsIgnoreCase(this.name);
    }

    public int getFatherCountryId() {
        return this.fatherCountryId;
    }

    public int getGamesCount() {
        return this.gamesCount;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public int getLiveCount() {
        return this.liveCount;
    }

    public String getSpotrsTypesForCountryAsString() {
        Iterator<Integer> it;
        String str = "";
        while (this.supportedSportType.iterator().hasNext()) {
            str = str + it.next() + ",";
        }
        if (!str.isEmpty()) {
            str.substring(0, str.lastIndexOf(44));
        }
        return str;
    }

    public HashSet<Integer> getSupportedSportTypeInCountry() {
        return this.supportedSportType;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        try {
            return this.f23582id;
        } catch (Exception e10) {
            x0.N1(e10);
            return hashCode;
        }
    }

    public boolean isInternational() {
        return this.isInternational;
    }

    public void setFatherCountryId(int i10) {
        this.fatherCountryId = i10;
    }

    public void setGamesCount(int i10) {
        this.gamesCount = i10;
    }

    public void setIsInternational(boolean z10) {
        this.isInternational = z10;
    }

    public void setLiveCount(int i10) {
        this.liveCount = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.f23582id);
            sb2.append(" - ");
            sb2.append(this.name);
        } catch (Exception unused) {
        }
        return sb2.toString();
    }
}
