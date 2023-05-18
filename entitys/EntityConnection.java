package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class EntityConnection implements Serializable {
    private static final long serialVersionUID = -8537028931328111212L;
    @p9.c("EntityID")
    private int entityID;
    @p9.c("EntityType")
    private int entityType;

    public int getEntityID() {
        return this.entityID;
    }

    public int getEntityType() {
        return this.entityType;
    }
}
