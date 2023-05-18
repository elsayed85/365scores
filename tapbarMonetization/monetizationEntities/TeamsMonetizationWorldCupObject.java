package com.scores365.tapbarMonetization.monetizationEntities;

import di.l;
import p9.c;
/* loaded from: classes2.dex */
public class TeamsMonetizationWorldCupObject extends ContentMonetizationWorldCupObject {
    @c("appearance")
    private String appearance;
    @c("bg_image")
    private String backgroundImage;
    @c("ranking")
    private String ranking;
    @c("titles")
    private String titles;

    public TeamsMonetizationWorldCupObject(String str, String str2, String str3, boolean z10, l.b bVar, String str4, String str5, String str6, String str7) {
        super(str, str2, str3, z10, bVar);
        this.backgroundImage = str4;
        this.appearance = str5;
        this.titles = str6;
        this.ranking = str7;
    }

    public String getAppearance() {
        return this.appearance;
    }

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public String getRanking() {
        return this.ranking;
    }

    public String getTitles() {
        return this.titles;
    }

    public void setAppearance(String str) {
        this.appearance = str;
    }

    public void setBackgroundImage(String str) {
        this.backgroundImage = str;
    }

    public void setRanking(String str) {
        this.ranking = str;
    }

    public void setTitles(String str) {
        this.titles = str;
    }
}
