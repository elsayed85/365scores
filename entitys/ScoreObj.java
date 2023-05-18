package com.scores365.entitys;

import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class ScoreObj implements Serializable {
    private static final long serialVersionUID = -3531500124000736140L;
    public double score;

    public ScoreObj(double d10) {
        this.score = d10;
    }

    public int getScore() {
        return (int) this.score;
    }

    public String getStringScore() {
        String valueOf = String.valueOf(this.score);
        try {
            double d10 = this.score;
            int i10 = (int) d10;
            return d10 - ((double) i10) == 0.0d ? String.valueOf(i10) : valueOf;
        } catch (Exception e10) {
            x0.N1(e10);
            return valueOf;
        }
    }
}
