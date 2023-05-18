package com.scores365.entitys;

import java.io.Serializable;
import java.util.Date;
/* loaded from: classes2.dex */
public class TopFloatingMapObj implements Serializable {
    private Date countDownUntil;

    /* renamed from: id  reason: collision with root package name */
    private final int f23602id;
    private final int numberOfTimesSeenDay;
    private final int numberOfTimesSeenLifeTime;

    public TopFloatingMapObj(int i10, int i11, int i12, Date date) {
        this.f23602id = i10;
        this.numberOfTimesSeenDay = i11;
        this.numberOfTimesSeenLifeTime = i12;
        this.countDownUntil = date;
    }

    public Date getCountDownUntil() {
        return this.countDownUntil;
    }

    public int getId() {
        return this.f23602id;
    }

    public int getNumberOfTimesSeenDay() {
        return this.numberOfTimesSeenDay;
    }

    public int getNumberOfTimesSeenLifeTime() {
        return this.numberOfTimesSeenLifeTime;
    }

    public void setCountDownUntil(Date date) {
        this.countDownUntil = date;
    }
}
