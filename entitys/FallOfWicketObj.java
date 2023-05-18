package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FallOfWicketObj implements Serializable {
    private static final long serialVersionUID = -5066037336514792900L;
    @p9.c("Overs")
    public float Overs;
    @p9.c("Player")
    public String Player;
    @p9.c("Runs")
    public int Runns;
    @p9.c("Wckt")
    public int Wckt;

    public FallOfWicketObj(int i10, String str, int i11, int i12) {
        this.Wckt = i10;
        this.Player = str;
        this.Runns = i11;
        this.Overs = i12;
    }
}
