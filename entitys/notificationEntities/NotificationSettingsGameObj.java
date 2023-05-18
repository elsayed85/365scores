package com.scores365.entitys.notificationEntities;

import com.scores365.App;
import com.scores365.entitys.GameObj;
import li.x0;
/* loaded from: classes2.dex */
public class NotificationSettingsGameObj extends NotificationSettingsBaseObj {
    private GameObj gameObj;

    public NotificationSettingsGameObj(GameObj gameObj) {
        this.gameObj = gameObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityId() {
        return getGameObj().getID();
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityTypeForAnalytics() {
        return 4;
    }

    public GameObj getGameObj() {
        return this.gameObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getNotificationSound(int i10) {
        try {
            return App.b.P(App.c.GAME, this.gameObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void insertNotification(int i10, int i11) {
        try {
            int id2 = this.gameObj.getID();
            App.c cVar = App.c.GAME;
            if (!App.b.r(id2, cVar)) {
                App.b.a(this.gameObj.getID(), this.gameObj, cVar);
            }
            App.b.I(cVar, this.gameObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isEntityMuted() {
        return App.b.d0(this.gameObj.getID(), App.c.GAME);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isNotificationExist(int i10) {
        try {
            return App.b.g0(App.c.GAME, this.gameObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void muteEntity() {
        App.b.p0(this.gameObj.getID(), App.c.GAME);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void removeNotification(int i10) {
        try {
            int id2 = this.gameObj.getID();
            App.c cVar = App.c.GAME;
            if (!App.b.r(id2, cVar)) {
                App.b.a(this.gameObj.getID(), this.gameObj, cVar);
            }
            App.b.r0(cVar, this.gameObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void resetNotifications() {
        try {
            App.b.G(this.gameObj.getID(), this.gameObj.getSportID(), App.c.GAME);
            x0.A2(null, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void unmuteEntity() {
        App.b.z0(this.gameObj.getID(), App.c.GAME);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void updateNotification(int i10, int i11) {
        try {
            int id2 = this.gameObj.getID();
            App.c cVar = App.c.GAME;
            if (!App.b.r(id2, cVar)) {
                App.b.a(this.gameObj.getID(), this.gameObj, cVar);
            }
            App.b.I(cVar, this.gameObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
