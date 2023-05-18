package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class BaseObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = 3673297764031634323L;
    @p9.c(alternate = {"Id"}, value = "ID")

    /* renamed from: id  reason: collision with root package name */
    protected int f23582id;
    @p9.c("Name")
    protected String name;

    public BaseObj() {
    }

    public BaseObj(int i10, String str) {
        this.f23582id = i10;
        this.name = str;
    }

    public int getID() {
        return this.f23582id;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(getID());
    }

    public String getName() {
        return this.name;
    }

    public void setId(int i10) {
        this.f23582id = i10;
    }
}
