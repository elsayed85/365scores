package com.scores365.entitys;

import java.util.List;
import kotlin.jvm.internal.m;
/* compiled from: GameStatistics.kt */
/* loaded from: classes2.dex */
public final class GameStatistics {
    @p9.c("Statistics")
    private final List<StatObj> statistics;

    /* JADX WARN: Multi-variable type inference failed */
    public GameStatistics(List<? extends StatObj> list) {
        this.statistics = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameStatistics copy$default(GameStatistics gameStatistics, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = gameStatistics.statistics;
        }
        return gameStatistics.copy(list);
    }

    public final List<StatObj> component1() {
        return this.statistics;
    }

    public final GameStatistics copy(List<? extends StatObj> list) {
        return new GameStatistics(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GameStatistics) && m.b(this.statistics, ((GameStatistics) obj).statistics);
    }

    public final List<StatObj> getStatistics() {
        return this.statistics;
    }

    public int hashCode() {
        List<StatObj> list = this.statistics;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "GameStatistics(statistics=" + this.statistics + ')';
    }
}
