package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgentRecordObj extends BaseObj {
    @p9.c("ROI")
    public DisplayData ROI;
    @p9.c("Losses")
    public int losses;
    @p9.c("NumberOfTips")
    public int numberOfTips;
    @p9.c("Trend")
    public ArrayList<Integer> trend = new ArrayList<>();
    @p9.c("Units")
    public DisplayData units;
    @p9.c("Voids")
    public int voids;
    @p9.c("WinPCT")
    public DisplayData winPct;
    @p9.c("Wins")
    public int wins;

    /* loaded from: classes2.dex */
    public static class DisplayData implements Serializable {
        @p9.c("Display")
        public String display;
        @p9.c("Value")
        public double value;
    }
}
