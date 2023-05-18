package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import p9.c;
/* loaded from: classes2.dex */
public class ScoreBoxRowsObj extends BaseObj {
    @c("PlayerID")
    private int playerID = -1;
    @c("Num")
    private int num = -1;
    @c("GroupID")
    private int groupID = -1;
    @c("Values")
    private ArrayList<ScoreBoxValueObj> values = null;

    public int getGroupID() {
        return this.groupID;
    }

    @Override // com.scores365.entitys.BaseObj
    public int getID() {
        return -1;
    }

    public int getNum() {
        return this.num;
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public ArrayList<ScoreBoxValueObj> getValues() {
        return this.values;
    }
}
