package com.scores365.ui.playerCard;

import com.scores365.entitys.AthletesStatisticTypeObj;
import com.scores365.entitys.PlayerStatObj;
/* compiled from: SingleAthleteStatisticsUiHelper.kt */
/* loaded from: classes2.dex */
public final class SingleAthleteStatisticsUiHelper {
    private final AthletesStatisticTypeObj athletesStatisticTypeObj;
    private final String imageUrl;
    private final PlayerStatObj playerStatObj;

    public SingleAthleteStatisticsUiHelper(String imageUrl, PlayerStatObj playerStatObj, AthletesStatisticTypeObj athletesStatisticTypeObj) {
        kotlin.jvm.internal.m.g(imageUrl, "imageUrl");
        kotlin.jvm.internal.m.g(playerStatObj, "playerStatObj");
        kotlin.jvm.internal.m.g(athletesStatisticTypeObj, "athletesStatisticTypeObj");
        this.imageUrl = imageUrl;
        this.playerStatObj = playerStatObj;
        this.athletesStatisticTypeObj = athletesStatisticTypeObj;
    }

    public final AthletesStatisticTypeObj getAthletesStatisticTypeObj() {
        return this.athletesStatisticTypeObj;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final PlayerStatObj getPlayerStatObj() {
        return this.playerStatObj;
    }
}
