package com.scores365.entitys;

import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public class TrophiesData extends BaseObj {
    @p9.c("Categories")
    private ArrayList<Trophies> categories;

    public ArrayList<Trophies> getCategories() {
        return this.categories;
    }

    public Trophies getCategoryById(int i10) {
        Trophies trophies = null;
        try {
            Iterator<Trophies> it = this.categories.iterator();
            while (it.hasNext()) {
                Trophies next = it.next();
                if (next.getType() == i10) {
                    trophies = next;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return trophies;
    }
}
