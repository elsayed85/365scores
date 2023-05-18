package com.scores365.bets.model;

import java.io.Serializable;
import p9.c;
/* loaded from: classes2.dex */
public class LineTypeOption implements Serializable {
    @c("Competitor")
    public int competitor;
    @c("Name")
    public String name;
    @c("Num")
    public int num;
    @c("Template")
    public String template;

    public String getTemplate() {
        return this.template;
    }
}
