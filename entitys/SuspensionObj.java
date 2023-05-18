package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SuspensionObj implements Serializable {
    @p9.c("Competition")
    public int competition;
    @p9.c("GamesCount")
    public int gamesCount;
    @p9.c("SuspensionType")
    private int suspensionType;
    @p9.c("SuspensionTypeImgID")
    private int suspensionTypeImgID = -1;
    @p9.c("TypeName")
    private String typeName;

    /* loaded from: classes2.dex */
    public enum ESoccerSuspensionTypes {
        RedCard(1),
        YellowCards(2),
        Disciplinary(3),
        Unidentified(-1);
        

        /* renamed from: id  reason: collision with root package name */
        int f23599id;

        ESoccerSuspensionTypes(int i10) {
            this.f23599id = i10;
        }

        public static ESoccerSuspensionTypes getValue(int i10) {
            ESoccerSuspensionTypes[] values;
            for (ESoccerSuspensionTypes eSoccerSuspensionTypes : values()) {
                if (eSoccerSuspensionTypes.getId() == i10) {
                    return eSoccerSuspensionTypes;
                }
            }
            return Unidentified;
        }

        public int getId() {
            return this.f23599id;
        }
    }

    public ESoccerSuspensionTypes getSuspensionType() {
        return ESoccerSuspensionTypes.getValue(this.suspensionType);
    }

    public int getSuspensionTypeImgID() {
        return this.suspensionTypeImgID;
    }

    public int getSuspensionTypeInt() {
        return this.suspensionType;
    }

    public String getTypeName() {
        return this.typeName;
    }
}
