package com.scores365.entitys;
/* loaded from: classes2.dex */
public enum eDashboardEntityType {
    SportType(1),
    Country(2),
    Competition(3),
    Competitor(4),
    Game(5),
    Athlete(6);
    
    private int value;

    eDashboardEntityType(int i10) {
        this.value = i10;
    }

    public static eDashboardEntityType create(int i10) {
        switch (i10) {
            case 1:
                return SportType;
            case 2:
                return Country;
            case 3:
                return Competition;
            case 4:
                return Competitor;
            case 5:
                return Game;
            case 6:
                return Athlete;
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
