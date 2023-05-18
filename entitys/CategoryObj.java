package com.scores365.entitys;
/* loaded from: classes2.dex */
public class CategoryObj extends BaseObj {
    @p9.c("CompetitionsToShow")
    private int competitionsToShow = 0;
    @p9.c("Current")
    private boolean current = false;
    @p9.c("TextColor")
    private String textColor = null;
    @p9.c("BrowseUrl")
    private String browseUrl = null;
    @p9.c("EntitiesCount")
    private int entitiesCount = 0;
    @p9.c("EntityType")
    private int entityType = 0;
    @p9.c("EntityID")
    private int entityID = 0;

    public String getBrowseUrl() {
        return this.browseUrl;
    }

    public int getCompetitionsToShow() {
        return this.competitionsToShow;
    }

    public int getEntitiesCount() {
        return this.entitiesCount;
    }

    public int getEntityID() {
        return this.entityID;
    }

    public int getEntityType() {
        return this.entityType;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public boolean isCurrent() {
        return this.current;
    }

    public boolean shouldShowSportTypes() {
        return this.entityType != 1 || this.entityID <= 0;
    }
}
