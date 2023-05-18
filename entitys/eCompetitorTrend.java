package com.scores365.entitys;

import com.scores365.R;
import li.p0;
/* loaded from: classes2.dex */
public enum eCompetitorTrend {
    LOSE(0),
    WIN(1),
    DRAW(2),
    DRAW_WIN(3),
    DRAW_LOSE(4),
    LOSE_WIN(5),
    WIN_LOSE(6),
    WIN_DRAW(7),
    LOSE_DRAW(8),
    NONE(-1);
    
    private int value;

    /* renamed from: com.scores365.entitys.eCompetitorTrend$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$entitys$eCompetitorTrend;

        static {
            int[] iArr = new int[eCompetitorTrend.values().length];
            $SwitchMap$com$scores365$entitys$eCompetitorTrend = iArr;
            try {
                iArr[eCompetitorTrend.LOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.WIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.DRAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.DRAW_WIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.DRAW_LOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.LOSE_WIN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.WIN_LOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.WIN_DRAW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$scores365$entitys$eCompetitorTrend[eCompetitorTrend.LOSE_DRAW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    eCompetitorTrend(int i10) {
        this.value = i10;
    }

    public static eCompetitorTrend create(int i10) {
        switch (i10) {
            case 0:
                return LOSE;
            case 1:
                return WIN;
            case 2:
                return DRAW;
            case 3:
                return DRAW_WIN;
            case 4:
                return DRAW_LOSE;
            case 5:
                return LOSE_WIN;
            case 6:
                return WIN_LOSE;
            case 7:
                return WIN_DRAW;
            case 8:
                return LOSE_DRAW;
            default:
                return NONE;
        }
    }

    public int getBackgroundResource() {
        int i10 = 0;
        try {
            switch (AnonymousClass1.$SwitchMap$com$scores365$entitys$eCompetitorTrend[ordinal()]) {
                case 1:
                    i10 = p0.T(R.attr.Y0);
                    break;
                case 2:
                    i10 = p0.T(R.attr.f21532b1);
                    break;
                case 3:
                    i10 = p0.T(R.attr.V0);
                    break;
                case 4:
                    i10 = p0.T(R.attr.X0);
                    break;
                case 5:
                    i10 = p0.T(R.attr.W0);
                    break;
                case 6:
                    i10 = p0.T(R.attr.f21529a1);
                    break;
                case 7:
                    i10 = p0.T(R.attr.f21538d1);
                    break;
                case 8:
                    i10 = p0.T(R.attr.f21535c1);
                    break;
                case 9:
                    i10 = p0.T(R.attr.Z0);
                    break;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return i10;
    }

    public String getTextValue() {
        String str = "";
        try {
            switch (AnonymousClass1.$SwitchMap$com$scores365$entitys$eCompetitorTrend[ordinal()]) {
                case 1:
                    str = p0.l0("GAME_CENTER_H2H_LOSE");
                    break;
                case 2:
                    str = p0.l0("GAME_CENTER_H2H_WIN");
                    break;
                case 3:
                    str = p0.l0("GAME_CENTER_H2H_DRAW");
                    break;
                case 4:
                    str = p0.l0("GAME_CENTER_H2H_DRAW_WIN");
                    break;
                case 5:
                    str = p0.l0("GAME_CENTER_H2H_DRAW_LOSE");
                    break;
                case 6:
                    str = p0.l0("GAME_CENTER_H2H_LOSE_WIN");
                    break;
                case 7:
                    str = p0.l0("GAME_CENTER_H2H_WIN_LOSE");
                    break;
                case 8:
                    str = p0.l0("GAME_CENTER_H2H_WIN_DRAW");
                    break;
                case 9:
                    str = p0.l0("GAME_CENTER_H2H_LOSE_DRAW");
                    break;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str;
    }
}
