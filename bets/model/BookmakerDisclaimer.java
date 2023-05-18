package com.scores365.bets.model;

import androidx.annotation.NonNull;
import com.scores365.entitys.BaseObj;
import p9.c;
/* loaded from: classes2.dex */
public class BookmakerDisclaimer extends BaseObj {
    @c("Text")
    private String text = "";
    @c("URL")
    private String url = "";

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    @NonNull
    public String toString() {
        return "BMDisclaimer{text='" + this.text + "', url='" + this.url + "'}";
    }
}
