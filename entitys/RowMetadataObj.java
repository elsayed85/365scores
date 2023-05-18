package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RowMetadataObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = 2677925066057601530L;
    @p9.c("Color")
    public String color;
    @p9.c("DestinationType")
    public int destinationType;
    @p9.c("Num")
    public int rowNum;
    @p9.c("Destination")
    public String destination = "";
    @p9.c("GuaranteedText")
    public String guaranteedText = "";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.rowNum);
    }
}
