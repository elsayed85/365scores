package com.scores365.entitys;

import java.io.Serializable;
/* compiled from: RelevantEntitiesType.kt */
/* loaded from: classes2.dex */
public final class RelevantEntitiesType implements Serializable {
    @p9.c("Name")
    private String name;
    @p9.c("Type")
    private String type;
    @p9.c("EntityTypeId")
    private Integer entityTypeId = -1;
    @p9.c("Category")
    private Integer category = -1;
    @p9.c("SelectedByDef")
    private Boolean selectedByDef = Boolean.FALSE;

    public final Integer getCategory() {
        return this.category;
    }

    public final Integer getEntityTypeId() {
        return this.entityTypeId;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getSelectedByDef() {
        return this.selectedByDef;
    }

    public final String getType() {
        return this.type;
    }

    public final void setCategory(Integer num) {
        this.category = num;
    }

    public final void setEntityTypeId(Integer num) {
        this.entityTypeId = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSelectedByDef(Boolean bool) {
        this.selectedByDef = bool;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
