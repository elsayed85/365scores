package com.scores365.entitys;

import java.io.Serializable;
/* compiled from: FilterCategoriesObj.kt */
/* loaded from: classes2.dex */
public final class FilterCategoriesObj implements Serializable {
    @p9.c("clearFilter")
    private final Boolean clearFilter;
    @p9.c("filterID")
    private final String filterID;
    @p9.c("Selected")
    private final Boolean selected;
    @p9.c("Title")
    private final String title;

    public final Boolean getClearFilter() {
        return this.clearFilter;
    }

    public final String getFilterID() {
        return this.filterID;
    }

    public final Boolean getSelected() {
        return this.selected;
    }

    public final String getTitle() {
        return this.title;
    }
}
