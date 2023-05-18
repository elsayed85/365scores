package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.m;
/* compiled from: TeamsGroupObj.kt */
/* loaded from: classes2.dex */
public final class TeamsGroupObj implements Serializable {
    @p9.c("Id")

    /* renamed from: id  reason: collision with root package name */
    private int f23601id = -1;
    @p9.c("Title")
    private String title = "";
    @p9.c("ImageCategory")
    private String imageCategory = "";

    public final int getId() {
        return this.f23601id;
    }

    public final String getImageCategory() {
        return this.imageCategory;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setId(int i10) {
        this.f23601id = i10;
    }

    public final void setImageCategory(String str) {
        m.g(str, "<set-?>");
        this.imageCategory = str;
    }

    public final void setTitle(String str) {
        m.g(str, "<set-?>");
        this.title = str;
    }
}
