package com.scores365.entitys.ScoreBoxObjects;

import com.scores365.entitys.AthleteTrophiesEntityObj;
import java.io.Serializable;
import p9.c;
/* loaded from: classes2.dex */
public class StatLegendObj implements Serializable {
    @c("Entity")
    private AthleteTrophiesEntityObj entityObj;
    @c("Title")
    private String title = "";
    @c("Icon")
    private boolean showIcons = false;

    public AthleteTrophiesEntityObj getEntityObj() {
        return this.entityObj;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isShowIcons() {
        return this.showIcons;
    }
}
