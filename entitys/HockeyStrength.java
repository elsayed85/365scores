package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: HockeyStrength.kt */
/* loaded from: classes2.dex */
public final class HockeyStrength implements Serializable {
    @p9.c("CompetitorNum")
    private int competitorNum;
    @p9.c("Desc")
    private final String desc;
    @p9.c("TimeLeft")
    private final String timeLeft;
    @p9.c("TimerLeftSec")
    private final int timerLeftSec;

    public HockeyStrength(int i10, String desc, String timeLeft, int i11) {
        m.g(desc, "desc");
        m.g(timeLeft, "timeLeft");
        this.competitorNum = i10;
        this.desc = desc;
        this.timeLeft = timeLeft;
        this.timerLeftSec = i11;
    }

    public static /* synthetic */ HockeyStrength copy$default(HockeyStrength hockeyStrength, int i10, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = hockeyStrength.competitorNum;
        }
        if ((i12 & 2) != 0) {
            str = hockeyStrength.desc;
        }
        if ((i12 & 4) != 0) {
            str2 = hockeyStrength.timeLeft;
        }
        if ((i12 & 8) != 0) {
            i11 = hockeyStrength.timerLeftSec;
        }
        return hockeyStrength.copy(i10, str, str2, i11);
    }

    public final int component1() {
        return this.competitorNum;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.timeLeft;
    }

    public final int component4() {
        return this.timerLeftSec;
    }

    public final HockeyStrength copy(int i10, String desc, String timeLeft, int i11) {
        m.g(desc, "desc");
        m.g(timeLeft, "timeLeft");
        return new HockeyStrength(i10, desc, timeLeft, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HockeyStrength) {
            HockeyStrength hockeyStrength = (HockeyStrength) obj;
            return this.competitorNum == hockeyStrength.competitorNum && m.b(this.desc, hockeyStrength.desc) && m.b(this.timeLeft, hockeyStrength.timeLeft) && this.timerLeftSec == hockeyStrength.timerLeftSec;
        }
        return false;
    }

    public final int getCompetitorNum() {
        return this.competitorNum;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getTimeLeft() {
        return this.timeLeft;
    }

    public final int getTimerLeftSec() {
        return this.timerLeftSec;
    }

    public int hashCode() {
        return (((((this.competitorNum * 31) + this.desc.hashCode()) * 31) + this.timeLeft.hashCode()) * 31) + this.timerLeftSec;
    }

    public final void setCompetitorNum(int i10) {
        this.competitorNum = i10;
    }

    public String toString() {
        return "HockeyStrength(competitorNum=" + this.competitorNum + ", desc=" + this.desc + ", timeLeft=" + this.timeLeft + ", timerLeftSec=" + this.timerLeftSec + ')';
    }
}
