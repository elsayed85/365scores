package com.scores365.entitys;

import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class PositionObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = -4825723570503716901L;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    public int f23597id;
    @p9.c("Name")
    private String name;
    @p9.c("Title")
    private String title = "";
    @p9.c("AliasName")
    private String alias = "";

    public String getAlias() {
        return this.alias;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.f23597id);
    }

    public String getPositionName() {
        try {
            return this.name;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getPositionTitle() {
        Exception e10;
        try {
            try {
                return !this.title.equals("") ? this.title : this.name;
            } catch (Exception e11) {
                e10 = e11;
                x0.N1(e10);
                return "";
            }
        } catch (Exception e12) {
            e10 = e12;
        }
    }
}
