package com.scores365.entitys;
/* loaded from: classes2.dex */
public class SquadInsertionItem {
    private String characterFlag;
    private String characterImage;
    private String characterImageRight;
    private String characterName;
    private String characterRole;
    private String characterURL;
    private int charecterPositionID;
    private String impressionUrl;
    private boolean inAppBowser;
    private int location1First2Last;

    public SquadInsertionItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, int i10, int i11) {
        this.impressionUrl = str;
        this.characterName = str2;
        this.characterRole = str3;
        this.characterImage = str4;
        this.characterImageRight = str5;
        this.characterFlag = str6;
        this.characterURL = str7;
        this.inAppBowser = z10;
        this.charecterPositionID = i10;
        this.location1First2Last = i11;
    }

    public String getCharacterFlag() {
        return this.characterFlag;
    }

    public String getCharacterImage() {
        return this.characterImage;
    }

    public String getCharacterImageRight() {
        return this.characterImageRight;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public String getCharacterRole() {
        return this.characterRole;
    }

    public String getCharacterURL() {
        return this.characterURL;
    }

    public int getCharecterPositionID() {
        return this.charecterPositionID;
    }

    public String getImpressionUrl() {
        return this.impressionUrl;
    }

    public int getLocation1First2Last() {
        return this.location1First2Last;
    }

    public boolean isInAppBowser() {
        return this.inAppBowser;
    }
}
