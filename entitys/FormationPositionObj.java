package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class FormationPositionObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = -6009791318332592926L;
    @p9.c("FatherPosition")
    public int fatherPosition;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    public int f23587id;
    @p9.c("Name")
    public String name;
    @p9.c("SName")
    public String shortName;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.f23587id);
    }
}
