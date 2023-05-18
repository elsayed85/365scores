package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import java.util.Iterator;
import p9.c;
/* loaded from: classes2.dex */
public class ScoreBoxPlayersStatistics extends BaseObj {
    @c("Expandable")
    private boolean expandable = false;
    @c("Categories")
    private ArrayList<ScoreBoxCategotyObj> categories = null;
    @c("Tables")
    private ArrayList<ScoreBoxTablesObj> tables = null;
    @c("Subjects")
    private ArrayList<ScoreBoxSubjectObj> subjects = null;

    public ArrayList<ScoreBoxCategotyObj> getCategories() {
        return this.categories;
    }

    public String getCategoryTitleFromID(int i10) {
        Iterator<ScoreBoxCategotyObj> it = getCategories().iterator();
        while (it.hasNext()) {
            ScoreBoxCategotyObj next = it.next();
            if (next.getID() == i10) {
                return next.getName();
            }
        }
        return "";
    }

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public ArrayList<ScoreBoxSubjectObj> getSubjects() {
        return this.subjects;
    }

    public ArrayList<ScoreBoxTablesObj> getTables() {
        return this.tables;
    }

    public boolean isExpandable() {
        return this.expandable;
    }
}
