package com.scores365.entitys.notificationEntities;

import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public abstract class NotificationSettingsBaseObj implements Serializable {
    public static ArrayList<NotificationSettingsBaseObj> entitiesToNotificationEntities(ArrayList<?> arrayList) {
        ArrayList<NotificationSettingsBaseObj> arrayList2 = new ArrayList<>();
        try {
            Iterator<?> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(newInstance(it.next()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList2;
    }

    public static NotificationSettingsBaseObj newInstance(Object obj) {
        NotificationSettingsBaseObj notificationSettingsAthleteObj;
        try {
            if (obj instanceof CompObj) {
                notificationSettingsAthleteObj = new NotificationSettingsCompetitorObj((CompObj) obj);
            } else if (obj instanceof CompetitionObj) {
                notificationSettingsAthleteObj = new NotificationSettingsCompetitionObj((CompetitionObj) obj);
            } else if (obj instanceof GameObj) {
                notificationSettingsAthleteObj = new NotificationSettingsGameObj((GameObj) obj);
            } else if (!(obj instanceof AthleteObj)) {
                return null;
            } else {
                notificationSettingsAthleteObj = new NotificationSettingsAthleteObj((AthleteObj) obj);
            }
            return notificationSettingsAthleteObj;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public boolean autoSelectNotification() {
        return false;
    }

    public abstract int getEntityId();

    public abstract int getEntityTypeForAnalytics();

    public abstract int getNotificationSound(int i10);

    public abstract void insertNotification(int i10, int i11);

    public abstract boolean isEntityMuted();

    public abstract boolean isNotificationExist(int i10);

    public abstract void muteEntity();

    public abstract void removeNotification(int i10);

    public abstract void resetNotifications();

    public abstract void unmuteEntity();

    public abstract void updateNotification(int i10, int i11);

    public void updateOrInsertNotification(int i10, int i11) {
        try {
            if (isNotificationExist(i10)) {
                updateNotification(i10, i11);
            } else {
                insertNotification(i10, i11);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
