package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GameSummaryObj implements Serializable {
    @p9.c("Participants")
    public ArrayList<OlympicParticipantObj> gameParticipants;

    public GameSummaryObj() {
    }

    public GameSummaryObj(ArrayList<OlympicParticipantObj> arrayList) {
        this.gameParticipants = arrayList;
    }
}
