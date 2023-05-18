package com.scores365.entitys;

import java.util.LinkedHashMap;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SeasonObj extends BaseObj {
    private static final long serialVersionUID = 4812973980308058837L;
    @p9.c("HasBrackets")
    private boolean hasBrackets;
    @p9.c("HasSeed")
    private boolean hasSeed;
    @p9.c("HasTbl")
    private boolean hasTable;
    @p9.c("KnockoutTitle")
    private String knockoutTitle;
    @p9.c("Num")
    private int num;
    @p9.c("Stages")
    private LinkedHashMap<Integer, CompStageObj> stages;
    @p9.c("UseName")
    private boolean useName;
    @p9.c("SName")
    private String ShortName = "";
    private CompStageObj[] stagesArray = null;

    public CompStageObj GetStageNum(int i10) {
        CompStageObj[] stages;
        CompStageObj compStageObj = null;
        try {
            for (CompStageObj compStageObj2 : getStages()) {
                if (compStageObj2.getNum() == i10) {
                    compStageObj = compStageObj2;
                }
            }
        } catch (Exception unused) {
        }
        return compStageObj;
    }

    public boolean getHasBrackets() {
        return this.hasBrackets;
    }

    public boolean getHasTable() {
        return this.hasTable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.BaseObj, com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.num);
    }

    public String getKnockoutTitle() {
        String l02 = p0.l0("MOBILE_DASHBOARD_SECTION_BRACKETS");
        try {
            String str = this.knockoutTitle;
            return (str == null || str.isEmpty()) ? l02 : this.knockoutTitle;
        } catch (Exception e10) {
            x0.N1(e10);
            return l02;
        }
    }

    @Override // com.scores365.entitys.BaseObj
    public String getName() {
        return this.name;
    }

    public int getNum() {
        return this.num;
    }

    public String getShortName() {
        String str = this.ShortName;
        return (str == null || str.equals("")) ? this.name : this.ShortName;
    }

    public CompStageObj[] getStages() {
        LinkedHashMap<Integer, CompStageObj> linkedHashMap;
        try {
            if (this.stagesArray == null && (linkedHashMap = this.stages) != null) {
                this.stagesArray = new CompStageObj[linkedHashMap.size()];
                int i10 = 0;
                for (CompStageObj compStageObj : this.stages.values()) {
                    this.stagesArray[i10] = compStageObj;
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.stagesArray;
    }

    public boolean getUseName() {
        return this.useName;
    }

    public boolean isHasSeed() {
        return this.hasSeed;
    }

    public void mergeSeasonObj(SeasonObj seasonObj) {
        try {
            this.stagesArray = null;
            LinkedHashMap<Integer, CompStageObj> linkedHashMap = this.stages;
            if (linkedHashMap == null) {
                this.stages = seasonObj.stages;
            } else {
                LinkedHashMap<Integer, CompStageObj> linkedHashMap2 = seasonObj.stages;
                if (linkedHashMap2 != null) {
                    linkedHashMap.putAll(linkedHashMap2);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
