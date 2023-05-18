package com.scores365.entitys;

import com.scores365.entitys.ScoreBoxObjects.ScoreBoxValueObj;
import java.util.ArrayList;
/* compiled from: HistoryRowObj.kt */
/* loaded from: classes2.dex */
public final class HistoryRowObj extends BaseObj {
    @p9.c("Group")
    private GroupObj group;
    @p9.c("TitleExtraData")
    private ArrayList<TitleExtraDataObj> titleExtraData;
    @p9.c("Titles")
    private ArrayList<String> titles;
    @p9.c("Values")
    private ArrayList<ScoreBoxValueObj> values;
    @p9.c(alternate = {"EntityId"}, value = "CompetitorId")
    private int competitorId = -1;
    @p9.c("Num")
    private int num = -1;

    public final int getCompetitorId() {
        return this.competitorId;
    }

    public final GroupObj getGroup() {
        return this.group;
    }

    public final int getNum() {
        return this.num;
    }

    public final ArrayList<TitleExtraDataObj> getTitleExtraData() {
        return this.titleExtraData;
    }

    public final ArrayList<String> getTitles() {
        return this.titles;
    }

    public final ArrayList<ScoreBoxValueObj> getValues() {
        return this.values;
    }

    public final void setCompetitorId(int i10) {
        this.competitorId = i10;
    }

    public final void setGroup(GroupObj groupObj) {
        this.group = groupObj;
    }

    public final void setNum(int i10) {
        this.num = i10;
    }

    public final void setTitleExtraData(ArrayList<TitleExtraDataObj> arrayList) {
        this.titleExtraData = arrayList;
    }

    public final void setTitles(ArrayList<String> arrayList) {
        this.titles = arrayList;
    }

    public final void setValues(ArrayList<ScoreBoxValueObj> arrayList) {
        this.values = arrayList;
    }
}
