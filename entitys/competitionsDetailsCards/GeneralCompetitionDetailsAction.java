package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: GeneralCompetitionDetailsAction.kt */
/* loaded from: classes2.dex */
public final class GeneralCompetitionDetailsAction extends BaseObj {
    @c("Entities")
    private final ArrayList<Integer> entities;
    @c("EntityType")
    private final int entityType;
    @c("Type")
    private final String type;

    public GeneralCompetitionDetailsAction(String type, int i10, ArrayList<Integer> entities) {
        m.g(type, "type");
        m.g(entities, "entities");
        this.type = type;
        this.entityType = i10;
        this.entities = entities;
    }

    public final ArrayList<Integer> getEntities() {
        return this.entities;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final String getType() {
        return this.type;
    }
}
