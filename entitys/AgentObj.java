package com.scores365.entitys;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgentObj extends BaseObj {
    @p9.c("Record")
    private AgentRecordObj agentRecordObj;
    @p9.c("ProviderID")
    protected int providerID;
    @p9.c("ImgVer")
    private int imgVer = -1;
    @p9.c("Sports")
    private ArrayList<Integer> agentSports = new ArrayList<>();

    public AgentRecordObj getAgentRecordObj() {
        return this.agentRecordObj;
    }

    public ArrayList<Integer> getAgentSports() {
        return this.agentSports;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public int getProviderID() {
        return this.providerID;
    }
}
