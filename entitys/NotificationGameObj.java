package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class NotificationGameObj implements Serializable {
    @p9.c("ID")
    public int GameID = -1;
    @p9.c("SID")
    public int SID = -1;
    @p9.c("Comp")
    public int CompetitionID = -1;
    @p9.c("HasLMT")
    public boolean hasLmt = false;
    @p9.c("Comps")
    public Comps[] comps = new Comps[2];

    /* loaded from: classes2.dex */
    public class Comps implements Serializable {
        @p9.c("ID")
        public int CompID = -1;
        @p9.c("Name")
        public String CompName = "";
        @p9.c("Score")
        public int CompScore = 0;

        public Comps() {
        }

        @NonNull
        public String toString() {
            return "Comp{CompID=" + this.CompID + ", CompName='" + this.CompName + "', CompScore=" + this.CompScore + '}';
        }
    }

    @NonNull
    public String toString() {
        return "Game{GameID=" + this.GameID + ", SID=" + this.SID + ", CompetitionID=" + this.CompetitionID + ", hasLmt=" + this.hasLmt + ", comps=" + Arrays.toString(this.comps) + '}';
    }
}
