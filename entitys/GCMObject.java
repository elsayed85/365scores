package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class GCMObject {
    @p9.c("GamesWithNewHighlights")
    private int[] gamesWithNewHighlights;
    @p9.c("GamesWithNewVideos")
    private int[] gamesWithNewVideos;
    @p9.c("UID")
    private long lastUpdateID;
    @p9.c("ID")
    private String notificationId;
    @p9.c("Notifications")
    private GCMNotificationObj[] notifications;

    public int[] getGamesWithHighlights() {
        return this.gamesWithNewHighlights;
    }

    public int[] getGamesWithVideos() {
        return this.gamesWithNewVideos;
    }

    public long getLastUpdateID() {
        return this.lastUpdateID;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public GCMNotificationObj[] getNotifications() {
        return this.notifications;
    }

    @NonNull
    public String toString() {
        return "GCMObject{lastUpdateID=" + this.lastUpdateID + ", gamesWithNewVideos=" + Arrays.toString(this.gamesWithNewVideos) + ", gamesWithNewHighlights=" + Arrays.toString(this.gamesWithNewHighlights) + ", notifications=" + Arrays.toString(this.notifications) + ", notificationId='" + this.notificationId + "'}";
    }
}
