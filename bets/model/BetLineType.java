package com.scores365.bets.model;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BetLineType extends BaseObj {
    @c("AliasName")
    public String aliasName;
    @c("InPlayState")
    public boolean inPlayState;
    @c("PredictionTitle")
    public String predictionTitle;
    @c("PrematchState")
    public boolean prematchState;
    @c("SportType")
    public int sportType;
    @c("Title")
    public String title;
    @c("Options")
    public ArrayList<LineTypeOption> lineTypeOptions = null;
    @c("ImgVer")
    private int imgVer = -1;

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public String getNameByTypeAndNum(int i10) {
        String str = "";
        try {
            Iterator<LineTypeOption> it = this.lineTypeOptions.iterator();
            while (it.hasNext()) {
                LineTypeOption next = it.next();
                if (next.num == i10) {
                    str = next.name;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return str;
    }
}
