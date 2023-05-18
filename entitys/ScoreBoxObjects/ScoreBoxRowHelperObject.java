package com.scores365.entitys.ScoreBoxObjects;

import android.widget.ImageView;
import android.widget.TableRow;
/* loaded from: classes2.dex */
public class ScoreBoxRowHelperObject {
    private boolean allPlayersShouldHaveImg;
    private int athleteId = -1;
    private boolean isSummary;
    private boolean isTitle;
    private String link;
    private ImageView playerIV;
    private TableRow tableRow;
    private String titleText;

    public ScoreBoxRowHelperObject(ImageView imageView, TableRow tableRow, String str, boolean z10, boolean z11, String str2, boolean z12) {
        this.playerIV = imageView;
        this.tableRow = tableRow;
        this.link = str;
        this.allPlayersShouldHaveImg = z10;
        this.isTitle = z11;
        this.isSummary = z12;
        this.titleText = str2;
    }

    public int getAthleteId() {
        return this.athleteId;
    }

    public String getLink() {
        return this.link;
    }

    public ImageView getPlayerIV() {
        return this.playerIV;
    }

    public TableRow getTableRow() {
        return this.tableRow;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public boolean isAllPlayersShouldHaveImg() {
        return this.allPlayersShouldHaveImg;
    }

    public boolean isRowHaveIcon() {
        String str = this.link;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public boolean isSummary() {
        return this.isSummary;
    }

    public boolean isTitle() {
        return this.isTitle;
    }

    public void setAthleteId(int i10) {
        this.athleteId = i10;
    }
}
