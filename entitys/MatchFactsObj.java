package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class MatchFactsObj implements Serializable {
    @p9.c("InnerId")
    private String innerId;
    @p9.c("Provider")
    private String provider;
    @p9.c("Text")
    private String text;
    @p9.c("Type")
    private String type;

    public String getFactText() {
        return this.text;
    }

    public String getInnerId() {
        return this.innerId;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getType() {
        return this.type;
    }
}
