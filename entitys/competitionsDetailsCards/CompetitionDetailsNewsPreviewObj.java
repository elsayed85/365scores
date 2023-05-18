package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.NewsObj;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsNewsPreviewObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsNewsPreviewObj extends CompetitionDetailsBaseCardObj {
    @c("News")
    private final NewsObj newsObj;
    @c("Title")
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsNewsPreviewObj(String str, NewsObj newsObj) {
        super(0, 1, null);
        m.g(newsObj, "newsObj");
        this.title = str;
        this.newsObj = newsObj;
    }

    public /* synthetic */ CompetitionDetailsNewsPreviewObj(String str, NewsObj newsObj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, newsObj);
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.NewsPreview;
    }

    public final NewsObj getNewsObj() {
        return this.newsObj;
    }

    public final String getTitle() {
        return this.title;
    }
}
