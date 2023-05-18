package com.scores365.entitys;
/* loaded from: classes2.dex */
public class TermObj implements IGsonEntity<String> {
    @p9.c("AliasName")
    private String aliasName;
    @p9.c("Name")
    private String name;

    public String getAliasName() {
        return this.aliasName;
    }

    @Override // com.scores365.entitys.IGsonEntity
    public String getKey() {
        return getAliasName();
    }

    public String getName() {
        return this.name;
    }
}
