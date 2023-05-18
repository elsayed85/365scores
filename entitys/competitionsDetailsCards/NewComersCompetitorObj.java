package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.CompObj;
import java.io.Serializable;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: NewComersCompetitorObj.kt */
/* loaded from: classes2.dex */
public final class NewComersCompetitorObj implements Serializable {
    @c("Competitor")
    private final CompObj competitor;
    @c("Description")
    private final String description;

    public NewComersCompetitorObj(String description, CompObj competitor) {
        m.g(description, "description");
        m.g(competitor, "competitor");
        this.description = description;
        this.competitor = competitor;
    }

    public final CompObj getCompetitor() {
        return this.competitor;
    }

    public final String getDescription() {
        return this.description;
    }
}
