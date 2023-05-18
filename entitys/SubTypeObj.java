package com.scores365.entitys;
/* loaded from: classes2.dex */
public class SubTypeObj extends BaseObj {
    @p9.c("AliasName")
    private String aliasName;
    @p9.c("SName")
    private String sname;

    public String getAliasName() {
        return this.aliasName;
    }

    @Override // com.scores365.entitys.BaseObj
    public String getName() {
        return this.name;
    }

    public String getShortName() {
        String str = this.sname;
        return (str == null || str.isEmpty()) ? this.name : this.sname;
    }
}
