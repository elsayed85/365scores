package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class CompStageObj extends BaseObj {
    private static final long serialVersionUID = -3033329716465714974L;
    @p9.c("Games")
    private ArrayList<GameObj> gamesArr;
    @p9.c("GroupCategories")
    private ArrayList<GroupCategoryObj> groupCategories;
    @p9.c("Groups")
    private GroupObj[] groups;
    @p9.c("HasTbl")
    private boolean hasTbl;
    @p9.c("Num")
    private int num;
    @p9.c("UseName")
    private boolean useName;
    @p9.c("SName")
    private String shortName = "";
    @p9.c("ConnectedToNextStage")
    private boolean connectedToNextStage = false;
    @p9.c("IsFinal")
    private boolean isFinal = false;
    @p9.c("ShowGames")
    private boolean ShowGames = false;

    public boolean equals(Object obj) {
        try {
            return this.num == ((CompStageObj) obj).num;
        } catch (Exception unused) {
            return false;
        }
    }

    public ArrayList<GameObj> getGamesArr() {
        return this.gamesArr;
    }

    public ArrayList<GroupCategoryObj> getGroupCategories() {
        return this.groupCategories;
    }

    public GroupObj[] getGroups() {
        return this.groups;
    }

    public boolean getHasTable() {
        return this.hasTbl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.BaseObj, com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.num);
    }

    @Override // com.scores365.entitys.BaseObj
    public String getName() {
        return this.name;
    }

    public int getNum() {
        return this.num;
    }

    public String getShortName() {
        String str = this.shortName;
        return (str == null || str.isEmpty()) ? this.name : this.shortName;
    }

    public boolean getUseName() {
        return this.useName;
    }

    public boolean isConnectedToNextStage() {
        return this.connectedToNextStage;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public boolean isShowGames() {
        return this.ShowGames;
    }
}
