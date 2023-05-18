package com.scores365.entitys;

import com.google.android.gms.ads.RequestConfiguration;
import java.io.Serializable;
/* compiled from: LastMatchesHeaderObj.kt */
/* loaded from: classes2.dex */
public final class LastMatchesHeaderObj implements Serializable {
    @p9.c("Title")
    private String title = "";
    @p9.c(RequestConfiguration.MAX_AD_CONTENT_RATING_T)
    private int type = -1;
    @p9.c("Description")
    private String description = "";
    @p9.c("Category")
    private int category = -1;

    public final int getCategory() {
        return this.category;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final void setCategory(int i10) {
        this.category = i10;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(int i10) {
        this.type = i10;
    }
}
