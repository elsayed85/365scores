package com.scores365.bets.model;

import com.scores365.entitys.BaseObj;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class ExtraContext extends BaseObj {
    @c("Context")
    public String contextStr;
    @c("Tag")
    public String tag;
    @c("Text")
    public String text;
    @c("URL")
    private String url;
    private String urlProcessed;

    public String getUrl() {
        if (this.urlProcessed == null) {
            this.urlProcessed = x0.W0(this.url);
        }
        x0.E1("oddsClickFea", "ExtraContext.getUrl urlProcessed: " + this.urlProcessed);
        return this.urlProcessed;
    }
}
