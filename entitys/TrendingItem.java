package com.scores365.entitys;

import java.io.Serializable;
import java.util.Date;
/* loaded from: classes2.dex */
public class TrendingItem implements Serializable {
    @p9.c("NewsItemID")
    private int newsItemID;
    @p9.c("Image")
    private String trendingImage;
    @p9.c("Seq")
    private int trendingSeq;
    @p9.c("Time")
    private Date trendingTime;
    @p9.c("Title")
    private String trendingTitle;
    @p9.c("Type")
    private int trendingType;
    @p9.c("VType")
    private int trendingVType;

    /* loaded from: classes2.dex */
    public enum eTrendingItem {
        BUZZ(1),
        NEWS(2),
        VIDEO(3);
        
        private int value;

        eTrendingItem(int i10) {
            this.value = i10;
        }

        public static eTrendingItem create(int i10) {
            return i10 != 1 ? i10 != 2 ? VIDEO : NEWS : BUZZ;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int getNewsItemID() {
        return this.newsItemID;
    }

    public String getTrendingImage() {
        return this.trendingImage;
    }

    public int getTrendingSeq() {
        return this.trendingSeq;
    }

    public Date getTrendingTime() {
        return this.trendingTime;
    }

    public String getTrendingTitle() {
        return this.trendingTitle;
    }

    public eTrendingItem getTrendingType() {
        return eTrendingItem.create(this.trendingType);
    }

    public int getTrendingVType() {
        return this.trendingVType;
    }
}
