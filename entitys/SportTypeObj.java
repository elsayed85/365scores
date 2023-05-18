package com.scores365.entitys;

import java.util.HashMap;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class SportTypeObj extends BaseObj {
    @p9.c("Positions")
    public LinkedHashMap<Integer, PositionObj> athletePositions;
    @p9.c("AthletsStatisticTypes")
    public LinkedHashMap<Integer, AthletesStatisticTypeObj> athleteStatics;
    @p9.c("AthletsStatisticCategories")
    public LinkedHashMap<Integer, AthletesStatisticCategoryObj> athleteStatisticCategories;
    @p9.c("CurrResultStage")
    private int currentResultStage;
    @p9.c("EventTypes")
    private LinkedHashMap<Integer, EventTypeObj> eventTypes;
    private LinkedHashMap<Integer, EventTypeObj> eventTypesPerIndex;
    @p9.c("EventsCategories")
    public int eventsCategories;
    @p9.c("FormationPositions")
    public LinkedHashMap<Integer, FormationPositionObj> formationPositions;
    @p9.c("OlympicMedalTypes")
    public LinkedHashMap<Integer, BaseObj> olympicMedalsType;
    @p9.c("OlympicSports")
    public LinkedHashMap<Integer, BaseObj> olympicSports;
    @p9.c("OrderLevel")
    public int orderLevel;
    @p9.c("ShortName")
    private String shortName;
    @p9.c("Stages")
    private LinkedHashMap<Integer, StageObj> stages;
    @p9.c("StatisticCategories")
    private LinkedHashMap<Integer, StatisticCategoryObj> statisticCategories;
    @p9.c("StatisticTypes")
    private LinkedHashMap<Integer, StatisticType> statisticTypes;
    @p9.c("Statuses")
    private LinkedHashMap<Integer, StatusObj> statuses;
    @p9.c("TieSupported")
    public boolean tieSupported;
    @p9.c("ClockDirection")
    private int sportTypeClockDirection = -1;
    @p9.c("CricketPlayingStatuses")
    HashMap<Integer, BaseObj> CricketPlayingStatuses = new HashMap<>();
    @p9.c("SurfaceTypes")
    public LinkedHashMap<Integer, SurfaceTypeObj> surfaceTypes = new LinkedHashMap<>();
    @p9.c("HasInternationalClubs")
    public boolean hasInternationalClubs = false;
    @p9.c("HasInternationalNations")
    public boolean hasInternationalNations = false;
    @p9.c("ImgVer")
    private int imgVer = -1;
    @p9.c("DefaultCompetitorType")
    private int defaultCompetitorType = -1;
    @p9.c("ShowEventsOrderFromBottom")
    private boolean showEventsOrderFromBottom = false;

    /* loaded from: classes2.dex */
    public enum EBasketBallSubSportTypes {
        Regular(0),
        TwoHalves(1);
        
        private int value;

        EBasketBallSubSportTypes(int i10) {
            this.value = i10;
        }

        public static EBasketBallSubSportTypes create(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    return null;
                }
                return TwoHalves;
            }
            return Regular;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum ETennisSubSportTypes {
        Regular(0),
        FiveSets(1);
        
        private int value;

        ETennisSubSportTypes(int i10) {
            this.value = i10;
        }

        public static ETennisSubSportTypes create(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    return null;
                }
                return FiveSets;
            }
            return Regular;
        }

        public int getValue() {
            return this.value;
        }
    }

    public BaseObj GetCricketPlayingStatus(int i10) {
        try {
            return this.CricketPlayingStatuses.get(Integer.valueOf(i10));
        } catch (Exception unused) {
            return null;
        }
    }

    public int getCurrentResultStage() {
        return this.currentResultStage;
    }

    public int getDefaultCompetitorType() {
        return this.defaultCompetitorType;
    }

    public EventTypeObj getEventByIndex(int i10) {
        try {
            this.eventTypesPerIndex = new LinkedHashMap<>();
            for (EventTypeObj eventTypeObj : this.eventTypes.values()) {
                this.eventTypesPerIndex.put(Integer.valueOf(eventTypeObj.EventNum), eventTypeObj);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            return this.eventTypesPerIndex.get(Integer.valueOf(i10));
        } catch (Exception unused) {
            return null;
        }
    }

    public LinkedHashMap<Integer, EventTypeObj> getEventTypes() {
        return this.eventTypes;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public String getShortName() {
        return this.shortName;
    }

    public eClockDirection getSportTypeClockDirection() {
        return eClockDirection.create(this.sportTypeClockDirection);
    }

    public LinkedHashMap<Integer, StageObj> getStages() {
        return this.stages;
    }

    public LinkedHashMap<Integer, StatisticCategoryObj> getStatisticsCategories() {
        return this.statisticCategories;
    }

    public LinkedHashMap<Integer, StatisticType> getStatisticsTypes() {
        return this.statisticTypes;
    }

    public LinkedHashMap<Integer, StatusObj> getStatuses() {
        return this.statuses;
    }

    public boolean isHasInternationalClubs() {
        return this.hasInternationalClubs;
    }

    public boolean isHasInternationalNations() {
        return this.hasInternationalNations;
    }

    public boolean isTieSupported() {
        return this.tieSupported;
    }

    public void setCricketPlayingStatuses(HashMap<Integer, BaseObj> hashMap) {
        this.CricketPlayingStatuses = hashMap;
    }

    public void setEventTypesPerIndex(LinkedHashMap<Integer, EventTypeObj> linkedHashMap) {
        this.eventTypesPerIndex = linkedHashMap;
    }

    public boolean shouldShowEventsOrderFromBottom() {
        return this.showEventsOrderFromBottom;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("id: ");
            sb2.append(this.f23582id);
            sb2.append("|name: ");
            sb2.append(this.name);
            sb2.append("|orderLevel:");
            sb2.append(this.orderLevel);
        } catch (Exception e10) {
            x0.N1(e10);
            sb2 = new StringBuilder();
            sb2.append(super.toString());
        }
        return sb2.toString();
    }
}
