package com.scores365.entitys.competitionsDetailsCards;

import java.util.ArrayList;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: GeneralCompetitionDetailsCard.kt */
/* loaded from: classes2.dex */
public final class GeneralCompetitionDetailsCard extends CompetitionDetailsBaseCardObj {
    @c("Sections")
    private final ArrayList<GeneralCompetitionDetailsSection> sections;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneralCompetitionDetailsCard(ArrayList<GeneralCompetitionDetailsSection> sections) {
        super(0, 1, null);
        m.g(sections, "sections");
        this.sections = sections;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.CompetitionDetails;
    }

    public final ArrayList<GeneralCompetitionDetailsSection> getSections() {
        return this.sections;
    }
}
