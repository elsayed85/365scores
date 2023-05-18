package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.VideoObj;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import p9.c;
import se.g;
/* compiled from: CompetitionDetailsVideosObj.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsVideosObj extends CompetitionDetailsBaseCardObj {
    @c("Data")
    private final ArrayList<VideoObj> videos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompetitionDetailsVideosObj(ArrayList<VideoObj> videos) {
        super(0, 1, null);
        m.g(videos, "videos");
        this.videos = videos;
    }

    @Override // com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsBaseCardObj, se.e
    public g getCardType() {
        return g.Videos;
    }

    public final ArrayList<VideoObj> getVideos() {
        return this.videos;
    }
}
