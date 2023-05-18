package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AthletesStatisticCategoryObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = 2829011036307840708L;
    @p9.c("AliasName")
    public String aliasName;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    public int f23579id;
    @p9.c("Name")
    public String name;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.f23579id);
    }
}
