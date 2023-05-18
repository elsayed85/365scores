package com.scores365.bets.model;

import androidx.annotation.NonNull;
import com.scores365.entitys.BaseObj;
import p9.c;
/* loaded from: classes2.dex */
public class BookmakerOfferObj extends BaseObj {
    @c("Text")
    public String bookmakerOffer;
    @c("URL")
    public String url;

    @NonNull
    public String toString() {
        return "BMOffer{id=" + this.f23582id + ", name='" + this.name + "', text='" + this.bookmakerOffer + "', url='" + this.url + "'}";
    }
}
