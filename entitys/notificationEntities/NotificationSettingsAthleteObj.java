package com.scores365.entitys.notificationEntities;

import com.scores365.App;
import com.scores365.entitys.AthleteObj;
import kotlin.jvm.internal.m;
import li.x0;
/* compiled from: NotificationSettingsAthleteObj.kt */
/* loaded from: classes2.dex */
public final class NotificationSettingsAthleteObj extends NotificationSettingsBaseObj {
    private final AthleteObj athleteObj;

    public NotificationSettingsAthleteObj(AthleteObj athleteObj) {
        m.g(athleteObj, "athleteObj");
        this.athleteObj = athleteObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean autoSelectNotification() {
        return true;
    }

    public final AthleteObj getAthleteObj() {
        return this.athleteObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityId() {
        return this.athleteObj.getID();
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityTypeForAnalytics() {
        return 5;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getNotificationSound(int i10) {
        try {
            return App.b.P(App.c.ATHLETE, this.athleteObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void insertNotification(int i10, int i11) {
        try {
            int id2 = this.athleteObj.getID();
            App.c cVar = App.c.ATHLETE;
            if (!App.b.r(id2, cVar)) {
                App.b.a(this.athleteObj.getID(), this.athleteObj, cVar);
            }
            App.b.I(cVar, this.athleteObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isEntityMuted() {
        return App.b.d0(this.athleteObj.getID(), App.c.ATHLETE);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isNotificationExist(int i10) {
        try {
            return App.b.g0(App.c.ATHLETE, this.athleteObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void muteEntity() {
        App.b.p0(this.athleteObj.getID(), App.c.ATHLETE);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void removeNotification(int i10) {
        try {
            int id2 = this.athleteObj.getID();
            App.c cVar = App.c.ATHLETE;
            if (!App.b.r(id2, cVar)) {
                App.b.a(this.athleteObj.getID(), this.athleteObj, cVar);
            }
            App.b.r0(cVar, this.athleteObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void resetNotifications() {
        try {
            App.b.G(this.athleteObj.getID(), this.athleteObj.getSportTypeId(), App.c.ATHLETE);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void unmuteEntity() {
        App.b.z0(this.athleteObj.getID(), App.c.ATHLETE);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void updateNotification(int i10, int i11) {
        try {
            int id2 = this.athleteObj.getID();
            App.c cVar = App.c.ATHLETE;
            if (!App.b.r(id2, cVar)) {
                App.b.a(this.athleteObj.getID(), this.athleteObj, cVar);
            }
            App.b.I(cVar, this.athleteObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
