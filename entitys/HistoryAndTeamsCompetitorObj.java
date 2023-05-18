package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* compiled from: HistoryAndTeamsCompetitorObj.kt */
/* loaded from: classes2.dex */
public final class HistoryAndTeamsCompetitorObj implements Serializable {
    @p9.c("Competitor")
    private CompObj competitor;
    @p9.c("TitleExtraData")
    private ArrayList<TitleExtraDataObj> titleExtraData;
    @p9.c("Titles")
    private ArrayList<String> titles;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    private int f23590id = -1;
    @p9.c("Num")
    private int num = -1;
    @p9.c("GroupId")
    private int groupId = -1;

    public final CompObj getCompetitor() {
        return this.competitor;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.f23590id;
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

    public final void setCompetitor(CompObj compObj) {
        this.competitor = compObj;
    }

    public final void setGroupId(int i10) {
        this.groupId = i10;
    }

    public final void setId(int i10) {
        this.f23590id = i10;
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
}
