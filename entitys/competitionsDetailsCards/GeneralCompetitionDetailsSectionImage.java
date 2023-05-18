package com.scores365.entitys.competitionsDetailsCards;

import java.io.Serializable;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: GeneralCompetitionDetailsSectionImage.kt */
/* loaded from: classes2.dex */
public final class GeneralCompetitionDetailsSectionImage implements Serializable {
    @c("Category")
    private final String category;
    @c("ID")

    /* renamed from: id  reason: collision with root package name */
    private final String f23608id;
    @c("ImgVer")
    private final int imageVersion;

    public GeneralCompetitionDetailsSectionImage(String id2, String category, int i10) {
        m.g(id2, "id");
        m.g(category, "category");
        this.f23608id = id2;
        this.category = category;
        this.imageVersion = i10;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getId() {
        return this.f23608id;
    }

    public final int getImageVersion() {
        return this.imageVersion;
    }
}
