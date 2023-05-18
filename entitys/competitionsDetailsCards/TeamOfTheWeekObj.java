package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.LineUpsObj;
import java.io.Serializable;
import p9.c;
/* compiled from: TeamOfTheWeekObj.kt */
/* loaded from: classes2.dex */
public final class TeamOfTheWeekObj implements Serializable {
    @c("Key")
    private final String key;
    @c("Lineup")
    private LineUpsObj lineup;
    @c("Name")
    private final String name;

    public TeamOfTheWeekObj(String str, String str2, LineUpsObj lineUpsObj) {
        this.key = str;
        this.name = str2;
        this.lineup = lineUpsObj;
    }

    public final String getKey() {
        return this.key;
    }

    public final LineUpsObj getLineup() {
        return this.lineup;
    }

    public final String getName() {
        return this.name;
    }

    public final void setLineup(LineUpsObj lineUpsObj) {
        this.lineup = lineUpsObj;
    }
}
