package com.scores365.entitys.competitionsDetailsCards;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsNewComersObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsNewComersObj extends CompetitionDetailsBaseCardObj {
    @c("NewComers")
    private final ArrayList<NewComersDataObj> newComersData;

    /* compiled from: CompetitionDetailsNewComersObj.kt */
    /* loaded from: classes2.dex */
    public static final class NewComersDataObj implements Serializable {
        @c("Competitors")
        private final ArrayList<NewComersCompetitorObj> competitors;
        @c("HasMore")
        private final Boolean hasMore;
        @c("Title")
        private final String title;
        @c("Type")
        private final String type;

        public NewComersDataObj() {
            this(null, null, null, null, 15, null);
        }

        public NewComersDataObj(Boolean bool, String str, String str2, ArrayList<NewComersCompetitorObj> arrayList) {
            this.hasMore = bool;
            this.title = str;
            this.type = str2;
            this.competitors = arrayList;
        }

        public /* synthetic */ NewComersDataObj(Boolean bool, String str, String str2, ArrayList arrayList, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? Boolean.FALSE : bool, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : arrayList);
        }

        public final ArrayList<NewComersCompetitorObj> getCompetitors() {
            return this.competitors;
        }

        public final Boolean getHasMore() {
            return this.hasMore;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsNewComersObj(ArrayList<NewComersDataObj> newComersData) {
        super(0, 1, null);
        m.g(newComersData, "newComersData");
        this.newComersData = newComersData;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.Newcomers;
    }

    public final ArrayList<NewComersDataObj> getNewComersData() {
        return this.newComersData;
    }
}
