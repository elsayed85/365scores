package com.scores365.entitys;
/* loaded from: classes2.dex */
public class GeneralNotifyObj {
    private int notify_id;
    private int sound_id;
    private int sport_id;

    public GeneralNotifyObj() {
    }

    public GeneralNotifyObj(int i10, int i11, int i12) {
        this.sport_id = i10;
        this.notify_id = i11;
        this.sound_id = i12;
    }

    public int getNotifyID() {
        return this.notify_id;
    }

    public int getSound() {
        return this.sound_id;
    }

    public int getSportID() {
        return this.sport_id;
    }

    public void setSound(int i10) {
        this.sound_id = i10;
    }
}
