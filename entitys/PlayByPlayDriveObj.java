package com.scores365.entitys;

import java.io.Serializable;
/* compiled from: PlayByPlayDriveObj.kt */
/* loaded from: classes2.dex */
public final class PlayByPlayDriveObj implements Serializable, IGsonEntity<Integer> {
    @p9.c("HasScore")
    private final boolean hasScore;
    @p9.c("Id")

    /* renamed from: id  reason: collision with root package name */
    private final int f23593id;
    @p9.c("Score")
    private final Integer[] score;
    @p9.c("ScoreBefore")
    private final Integer[] scoreBefore;
    @p9.c("Resolution")
    private final String resolution = "";
    @p9.c("StartAt")
    private final String startAt = "";
    @p9.c("TotalTime")
    private final String totalTime = "";
    @p9.c("ScoreType")
    private final String scoreType = "";
    @p9.c("TotalPlays")
    private final int totalPlays = -1;
    @p9.c("TotalYards")
    private final int totalYards = -1;
    @p9.c("CompetitorNum")
    private final int competitorNum = -1;

    public final int getCompetitorNum() {
        return this.competitorNum;
    }

    public final boolean getHasScore() {
        return this.hasScore;
    }

    public final int getId() {
        return this.f23593id;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.f23593id);
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final Integer[] getScore() {
        return this.score;
    }

    public final Integer[] getScoreBefore() {
        return this.scoreBefore;
    }

    public final String getScoreType() {
        return this.scoreType;
    }

    public final String getStartAt() {
        return this.startAt;
    }

    public final int getTotalPlays() {
        return this.totalPlays;
    }

    public final String getTotalTime() {
        return this.totalTime;
    }

    public final int getTotalYards() {
        return this.totalYards;
    }
}
