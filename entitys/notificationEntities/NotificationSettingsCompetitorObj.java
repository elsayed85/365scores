package com.scores365.entitys.notificationEntities;

import com.scores365.App;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.GeneralNotifyObj;
import com.scores365.entitys.NotifiedUpdateObj;
import com.scores365.entitys.SportTypesEnum;
import java.util.Iterator;
import java.util.Vector;
import li.x0;
import sf.a;
/* loaded from: classes2.dex */
public class NotificationSettingsCompetitorObj extends NotificationSettingsBaseObj {
    private CompObj compObj;

    public NotificationSettingsCompetitorObj(CompObj compObj) {
        this.compObj = compObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean autoSelectNotification() {
        return true;
    }

    public CompObj getCompObj() {
        return this.compObj;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityId() {
        try {
            if (getCompObj() != null) {
                return getCompObj().getID();
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getEntityTypeForAnalytics() {
        return 2;
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public int getNotificationSound(int i10) {
        try {
            return App.b.P(App.c.TEAM, this.compObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void insertNotification(int i10, int i11) {
        try {
            if (!App.b.s(this.compObj)) {
                App.b.d(this.compObj.getID(), this.compObj, App.c.TEAM, false);
            }
            App.b.I(App.c.TEAM, this.compObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isEntityMuted() {
        return App.b.d0(this.compObj.getID(), App.c.TEAM);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public boolean isNotificationExist(int i10) {
        try {
            return App.b.g0(App.c.TEAM, this.compObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void muteEntity() {
        App.b.p0(this.compObj.getID(), App.c.TEAM);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void removeNotification(int i10) {
        try {
            App.b.r0(App.c.TEAM, this.compObj.getID(), i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void resetNotifications() {
        boolean z10;
        try {
            App.b.a(this.compObj.getID(), this.compObj, App.c.TEAM);
            Vector<GeneralNotifyObj> S = a.i0(App.m()).S(this.compObj.getSportID());
            Iterator<NotifiedUpdateObj> it = x0.s0(SportTypesEnum.create(this.compObj.getSportID())).iterator();
            while (it.hasNext()) {
                NotifiedUpdateObj next = it.next();
                Iterator<GeneralNotifyObj> it2 = S.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z10 = false;
                        break;
                    }
                    GeneralNotifyObj next2 = it2.next();
                    if (next.getID() == next2.getNotifyID()) {
                        updateOrInsertNotification(next.getID(), next2.getSound());
                        z10 = true;
                        break;
                    }
                }
                if (!z10) {
                    removeNotification(next.getID());
                }
            }
            App.b.z0(this.compObj.getID(), App.c.TEAM);
            App.b.y();
            x0.A2(null, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void unmuteEntity() {
        App.b.z0(this.compObj.getID(), App.c.TEAM);
    }

    @Override // com.scores365.entitys.notificationEntities.NotificationSettingsBaseObj
    public void updateNotification(int i10, int i11) {
        try {
            App.b.I(App.c.TEAM, this.compObj.getID(), i10, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
