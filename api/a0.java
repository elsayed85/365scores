package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.allScoresCategories.AllScoresCategories;
/* compiled from: ApiAllScoresCategories.kt */
/* loaded from: classes2.dex */
public final class a0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private AllScoresCategories f22922a;

    public final AllScoresCategories a() {
        return this.f22922a;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "Data/Init/AllScores?";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f22922a = (AllScoresCategories) GsonManager.getGson().l(str, AllScoresCategories.class);
    }
}
