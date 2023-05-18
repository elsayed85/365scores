package com.scores365.entitys;

import com.scores365.App;
import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class StatObj implements Serializable {
    private static final long serialVersionUID = -6524006707866521241L;
    @p9.c("ValsPct")
    private float[] statFloatValues;
    @p9.c("Type")
    private int type;
    @p9.c("Vals")
    private String[] vals;

    public boolean getIsPrimary(int i10) {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(i10)).getStatisticsTypes().get(Integer.valueOf(getType())).primary;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public StatisticType getStatisticTypeObj(int i10) {
        try {
            return App.l().getSportTypes().get(Integer.valueOf(i10)).getStatisticsTypes().get(Integer.valueOf(getType()));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public float getStatisticsPctAsFloat(int i10) {
        return this.statFloatValues[i10];
    }

    public int getStatisticsPctAsInt(int i10) {
        return (int) (this.statFloatValues[i10] * 100.0f);
    }

    public int getType() {
        return this.type;
    }

    public String[] getVals() {
        return this.vals;
    }
}
