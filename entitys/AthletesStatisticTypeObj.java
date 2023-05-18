package com.scores365.entitys;

import java.io.Serializable;
import li.x0;
/* loaded from: classes2.dex */
public class AthletesStatisticTypeObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = -5809711832460691182L;
    @p9.c("AliasName")
    public String aliasName;
    @p9.c("Category")
    public int category;
    @p9.c("Description")
    public String description;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    public int f23580id;
    @p9.c("ImgVer")
    public int imgVer = -1;
    @p9.c("Name")
    public String name;
    @p9.c("NameInMissingPlayers")
    public String nameInMissingPlayers;
    @p9.c("SName")
    private String shortName;
    @p9.c("Visible")
    public boolean visible;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.f23580id);
    }

    public String getName() {
        String str = this.name;
        return str != null ? str : "";
    }

    public String getShortName() {
        String str = this.name;
        try {
            String str2 = this.shortName;
            return (str2 == null || str2.isEmpty()) ? str : this.shortName;
        } catch (Exception e10) {
            x0.N1(e10);
            return str;
        }
    }
}
