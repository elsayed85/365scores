package com.scores365.entitys;

import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public class Trophies extends BaseObj {
    public static final int TROPHY_TYPE_CLUB = 2;
    public static final int TROPHY_TYPE_INTERNATIONAL = 3;
    @p9.c("Trophies")
    private ArrayList<Trophy> trophies;
    @p9.c("Type")
    private int type = -1;
    @p9.c("Selected")
    private boolean selected = false;

    public ArrayList<Trophy> getTrophies() {
        return this.trophies;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public boolean isTrophyHasData(int i10) {
        try {
            Iterator<Trophy> it = this.trophies.iterator();
            while (it.hasNext()) {
                Trophy next = it.next();
                if (next.getCompetitionID() == i10) {
                    return next.getStats() != null;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
