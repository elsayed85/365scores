package com.scores365.entitys.notificationEntities;

import com.scores365.App;
import com.scores365.entitys.CompetitionObj;
import li.x0;
import sf.a;
/* loaded from: classes2.dex */
public class NotificationSettingsCompetitionObj extends NotificationSettingsBaseObj {
    private CompetitionObj competitionObj;

    public NotificationSettingsCompetitionObj(CompetitionObj competitionObj) {
        this.competitionObj = competitionObj;
    }

    public CompetitionObj getCompetitionObj() {
        return this.competitionObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityId() {
        try {
            if (getCompetitionObj() != null) {
                return getCompetitionObj().getID();
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityTypeForAnalytics() {
        return 1;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getNotificationSound(int i10) {
        try {
            return App.b.P(App.c.LEAGUE, this.competitionObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void insertNotification(int i10, int i11) {
        try {
            if (!App.b.s(this.competitionObj)) {
                App.b.d(this.competitionObj.getID(), this.competitionObj, App.c.LEAGUE, false);
            }
            App.b.I(App.c.LEAGUE, this.competitionObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isEntityMuted() {
        return App.b.d0(this.competitionObj.getID(), App.c.LEAGUE);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isNotificationExist(int i10) {
        try {
            return a.i0(App.m()).n1(this.competitionObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void muteEntity() {
        App.b.p0(this.competitionObj.getID(), App.c.LEAGUE);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void removeNotification(int i10) {
        try {
            App.b.r0(App.c.LEAGUE, this.competitionObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void resetNotifications() {
        try {
            App.b.a(this.competitionObj.getID(), this.competitionObj, App.c.LEAGUE);
            App.b.y();
            x0.A2(null, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void unmuteEntity() {
        App.b.z0(this.competitionObj.getID(), App.c.LEAGUE);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void updateNotification(int i10, int i11) {
        try {
            App.b.I(App.c.LEAGUE, this.competitionObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
