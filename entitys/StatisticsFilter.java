package com.scores365.entitys;

import kotlin.jvm.internal.m;
/* compiled from: GameStatisticFilter.kt */
/* loaded from: classes2.dex */
public final class StatisticsFilter extends BaseObj {
    @p9.c("Path")
    private final String path;
    @p9.c("Selected")
    private boolean selected;

    public StatisticsFilter(String path, boolean z10) {
        m.g(path, "path");
        this.path = path;
        this.selected = z10;
    }

    public static /* synthetic */ StatisticsFilter copy$default(StatisticsFilter statisticsFilter, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = statisticsFilter.path;
        }
        if ((i10 & 2) != 0) {
            z10 = statisticsFilter.selected;
        }
        return statisticsFilter.copy(str, z10);
    }

    public final String component1() {
        return this.path;
    }

    public final boolean component2() {
        return this.selected;
    }

    public final StatisticsFilter copy(String path, boolean z10) {
        m.g(path, "path");
        return new StatisticsFilter(path, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StatisticsFilter) {
            StatisticsFilter statisticsFilter = (StatisticsFilter) obj;
            return m.b(this.path, statisticsFilter.path) && this.selected == statisticsFilter.selected;
        }
        return false;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.path.hashCode() * 31;
        boolean z10 = this.selected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setSelected(boolean z10) {
        this.selected = z10;
    }

    public String toString() {
        return "StatisticsFilter(path=" + this.path + ", selected=" + this.selected + ')';
    }
}
