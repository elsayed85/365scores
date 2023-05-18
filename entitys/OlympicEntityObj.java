package com.scores365.entitys;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import java.util.ArrayList;
import li.x0;
/* loaded from: classes2.dex */
public class OlympicEntityObj implements Serializable {
    @p9.c("BlockedLangs")
    private String BlockedLangs;
    @p9.c("SupportedCountries")
    private String SupportedCountries;
    @p9.c("age")
    private String age;
    @p9.c("bronze")
    private String bronze;
    @p9.c("cid")
    private int cid;
    @p9.c("gold")
    private String gold;
    @p9.c(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
    private String height;
    @p9.c("id")

    /* renamed from: id  reason: collision with root package name */
    private int f23592id;
    @p9.c("img")
    private String img;
    @p9.c("name")
    private String name;
    @p9.c("silver")
    private String silver;
    @p9.c("subTypeIcon")
    private int subTypeIcon;
    @p9.c("text")
    private String text;

    public String getAge() {
        return this.age;
    }

    public ArrayList<Integer> getBlockedLangs() {
        int i10;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : this.BlockedLangs.split(",")) {
            try {
                i10 = Integer.parseInt(str);
            } catch (Exception e10) {
                x0.N1(e10);
                i10 = -1;
            }
            arrayList.add(Integer.valueOf(i10));
            if (i10 == -1) {
                break;
            }
        }
        return arrayList;
    }

    public String getBronze() {
        return this.bronze;
    }

    public int getCid() {
        return this.cid;
    }

    public String getGold() {
        return this.gold;
    }

    public String getHeight() {
        return this.height;
    }

    public int getId() {
        return this.f23592id;
    }

    public String getImg() {
        return this.img;
    }

    public String getName() {
        return this.name;
    }

    public String getSilver() {
        return this.silver;
    }

    public int getSubTypeIcon() {
        return this.subTypeIcon;
    }

    public ArrayList<Integer> getSupportedCountries() {
        int i10;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : this.SupportedCountries.split(",")) {
            try {
                i10 = Integer.parseInt(str);
            } catch (Exception e10) {
                x0.N1(e10);
                i10 = -1;
            }
            arrayList.add(Integer.valueOf(i10));
            if (i10 == -1) {
                break;
            }
        }
        return arrayList;
    }

    public String getText() {
        return this.text;
    }
}
