package com.scores365.entitys;

import java.io.Serializable;
import java.util.Date;
/* loaded from: classes2.dex */
public class GamesDateObj implements Serializable, IGsonEntity<Long> {
    private static final long serialVersionUID = 3102418224716351595L;
    @p9.c("Date")
    public Date gamesDate;
    @p9.c("Count")
    public int numberOfGamesInDate;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Long getKey() {
        return Long.valueOf(this.gamesDate.getTime());
    }
}
