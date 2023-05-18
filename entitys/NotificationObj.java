package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class NotificationObj implements Serializable {
    private static final long serialVersionUID = -7853356614726710246L;
    @p9.c("AnimationText")
    private String animationText;
    @p9.c("CompetitorNum")
    private int competitorNum;
    @p9.c("EntID")
    private int entId;
    @p9.c("Params")
    private ArrayList<ParamObj> params;
    @p9.c("TimeOfRelevancy")
    private int timeOfRelevancy;
    @p9.c("Type")
    private int type;

    public String getAnimationText() {
        return this.animationText;
    }

    public int getCompetitorNum() {
        return this.competitorNum;
    }

    public int getEntId() {
        return this.entId;
    }

    public int getTimeOfRelevancy() {
        return this.timeOfRelevancy;
    }

    public int getType() {
        return this.type;
    }
}
