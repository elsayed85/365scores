package com.scores365.entitys;

import com.scores365.entitys.ScoreBoxObjects.ScoreBoxValueObj;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AthleteTrophiesScoreBoxRowObj implements Serializable {
    @p9.c("Clickable")
    private boolean clickable;
    @p9.c("Values")
    private ArrayList<ScoreBoxValueObj> values;
    @p9.c("EntityId")
    private int entityID = -1;
    @p9.c("Num")
    private int num = -1;
    @p9.c("Title")
    private String title = "";
    @p9.c("SecondaryTitle")
    private String secondaryTitle = "";

    public int getEntityID() {
        return this.entityID;
    }

    public int getNum() {
        return this.num;
    }

    public String getSecondaryTitle() {
        return this.secondaryTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<ScoreBoxValueObj> getValues() {
        return this.values;
    }

    public boolean isClickable() {
        return this.clickable;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
