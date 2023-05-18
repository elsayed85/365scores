package com.scores365.entitys;

import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public class StatisticCategoryObj extends BaseObj {
    private static final long serialVersionUID = 4950987144008871224L;
    @p9.c("OrderByPosition")
    private ArrayList<OrderByPosition> orderByPositionHashList;
    @p9.c("OrderLevel")
    private int orderLevel;
    @p9.c("SubCategories")
    private ArrayList<BaseObj> subCategories;
    @p9.c("Subject")
    private String subject;

    public StatisticCategoryObj() {
        this.subject = "";
    }

    public StatisticCategoryObj(int i10, String str, String str2) {
        super(i10, str);
        this.subject = str2;
    }

    public int getOrderByPositionWithFallback(int i10) {
        ArrayList<OrderByPosition> arrayList;
        int i11 = -1;
        try {
            arrayList = this.orderByPositionHashList;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (arrayList == null) {
            return this.orderLevel;
        }
        Iterator<OrderByPosition> it = arrayList.iterator();
        while (it.hasNext()) {
            OrderByPosition next = it.next();
            if (next != null && next.getPosition() == i10) {
                i11 = next.getPositionOrder();
            }
        }
        return i11;
    }

    public int getOrederLevel() {
        return this.orderLevel;
    }

    public ArrayList<BaseObj> getSubCategories() {
        return this.subCategories;
    }

    public BaseObj getSubCategory(int i10) {
        try {
            ArrayList<BaseObj> arrayList = this.subCategories;
            if (arrayList != null) {
                Iterator<BaseObj> it = arrayList.iterator();
                while (it.hasNext()) {
                    BaseObj next = it.next();
                    if (next.f23582id == i10) {
                        return next;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getSubject() {
        return this.subject;
    }
}
