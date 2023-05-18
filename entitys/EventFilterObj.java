package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: EventFilterObj.kt */
/* loaded from: classes2.dex */
public final class EventFilterObj implements Serializable {
    @p9.c("Id")

    /* renamed from: id  reason: collision with root package name */
    private int f23584id;
    @p9.c("Name")
    private String name = "";

    public final int getId() {
        return this.f23584id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setId(int i10) {
        this.f23584id = i10;
    }

    public final void setName(String str) {
        m.g(str, "<set-?>");
        this.name = str;
    }
}
