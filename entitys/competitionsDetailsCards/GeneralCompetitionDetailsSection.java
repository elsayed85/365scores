package com.scores365.entitys.competitionsDetailsCards;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: GeneralCompetitionDetailsSection.kt */
/* loaded from: classes2.dex */
public final class GeneralCompetitionDetailsSection implements Serializable {
    @c("Action")
    private final GeneralCompetitionDetailsAction action;
    @c("Image")
    private final GeneralCompetitionDetailsSectionImage image;
    @c("Title")
    private final String title;
    @c("Top")
    private final boolean top;
    @c("Val")
    private final String value;

    public GeneralCompetitionDetailsSection(String title, String str, boolean z10, GeneralCompetitionDetailsSectionImage generalCompetitionDetailsSectionImage, GeneralCompetitionDetailsAction generalCompetitionDetailsAction) {
        m.g(title, "title");
        this.title = title;
        this.value = str;
        this.top = z10;
        this.image = generalCompetitionDetailsSectionImage;
        this.action = generalCompetitionDetailsAction;
    }

    public /* synthetic */ GeneralCompetitionDetailsSection(String str, String str2, boolean z10, GeneralCompetitionDetailsSectionImage generalCompetitionDetailsSectionImage, GeneralCompetitionDetailsAction generalCompetitionDetailsAction, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? false : z10, generalCompetitionDetailsSectionImage, generalCompetitionDetailsAction);
    }

    public final GeneralCompetitionDetailsAction getAction() {
        return this.action;
    }

    public final GeneralCompetitionDetailsSectionImage getImage() {
        return this.image;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getTop() {
        return this.top;
    }

    public final String getValue() {
        return this.value;
    }
}
