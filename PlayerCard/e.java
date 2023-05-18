package com.scores365.PlayerCard;

import com.scores365.entitys.BaseObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxCategotyObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxSubjectObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxTablesObj;
import com.scores365.entitys.ScoreBoxObjects.StatLegendObj;
import java.util.ArrayList;
/* compiled from: StatsCareerObject.java */
/* loaded from: classes2.dex */
public class e extends BaseObj {
    @p9.c("Expandable")

    /* renamed from: a  reason: collision with root package name */
    private boolean f21388a = false;
    @p9.c("Categories")

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<ScoreBoxCategotyObj> f21389b = null;
    @p9.c("Tables")

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<ScoreBoxTablesObj> f21390c = null;
    @p9.c("Subjects")

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<ScoreBoxSubjectObj> f21391d = null;
    @p9.c("Legend")

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<StatLegendObj> f21392e = null;

    public ArrayList<StatLegendObj> a() {
        return this.f21392e;
    }

    public ArrayList<ScoreBoxCategotyObj> getCategories() {
        return this.f21389b;
    }

    public ArrayList<ScoreBoxTablesObj> getTables() {
        return this.f21390c;
    }
}
