package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: GroupCategoryObj.kt */
/* loaded from: classes2.dex */
public final class GroupCategoryObj implements Serializable {
    @p9.c("Default")

    /* renamed from: default  reason: not valid java name */
    private final boolean f5default;
    @p9.c("Name")
    private final String name;
    @p9.c("Num")
    private final int num;

    public GroupCategoryObj(boolean z10, String name, int i10) {
        m.g(name, "name");
        this.f5default = z10;
        this.name = name;
        this.num = i10;
    }

    public static /* synthetic */ GroupCategoryObj copy$default(GroupCategoryObj groupCategoryObj, boolean z10, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = groupCategoryObj.f5default;
        }
        if ((i11 & 2) != 0) {
            str = groupCategoryObj.name;
        }
        if ((i11 & 4) != 0) {
            i10 = groupCategoryObj.num;
        }
        return groupCategoryObj.copy(z10, str, i10);
    }

    public final boolean component1() {
        return this.f5default;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.num;
    }

    public final GroupCategoryObj copy(boolean z10, String name, int i10) {
        m.g(name, "name");
        return new GroupCategoryObj(z10, name, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GroupCategoryObj) {
            GroupCategoryObj groupCategoryObj = (GroupCategoryObj) obj;
            return this.f5default == groupCategoryObj.f5default && m.b(this.name, groupCategoryObj.name) && this.num == groupCategoryObj.num;
        }
        return false;
    }

    public final boolean getDefault() {
        return this.f5default;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNum() {
        return this.num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.f5default;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (((r02 * 31) + this.name.hashCode()) * 31) + this.num;
    }

    public String toString() {
        return "GroupCategoryObj(default=" + this.f5default + ", name=" + this.name + ", num=" + this.num + ')';
    }
}
