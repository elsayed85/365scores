package com.scores365.entitys;
/* loaded from: classes2.dex */
public enum SportTypesEnum {
    SOCCER(1),
    BASKETBALL(2),
    TENNIS(3),
    HOCKEY(4),
    HANDBALL(5),
    AMERICAN_FOOTBALL(6),
    BASEBALL(7),
    VOLLEYBALL(8),
    RUGBY(9),
    OLYMPIC_GAMES(10),
    CRICKET(11),
    TABLE_TENNIS(12),
    E_SPORT(13);
    
    private int value;

    SportTypesEnum(int i10) {
        this.value = i10;
    }

    public static SportTypesEnum create(int i10) {
        switch (i10) {
            case 1:
                return SOCCER;
            case 2:
                return BASKETBALL;
            case 3:
                return TENNIS;
            case 4:
                return HOCKEY;
            case 5:
                return HANDBALL;
            case 6:
                return AMERICAN_FOOTBALL;
            case 7:
                return BASEBALL;
            case 8:
                return VOLLEYBALL;
            case 9:
                return RUGBY;
            case 10:
                return OLYMPIC_GAMES;
            case 11:
                return CRICKET;
            case 12:
                return TABLE_TENNIS;
            case 13:
                return E_SPORT;
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }
}
