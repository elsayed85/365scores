package com.scores365.gameCenter;

import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.SportTypeObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.StageObj;
import com.scores365.entitys.StageTimeObj;
import com.scores365.entitys.StatusObj;
import com.scores365.entitys.notificationEntities.ExtraScoreObj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* compiled from: GeneralScoresTableDataMgr.java */
/* loaded from: classes2.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    static int f23999a;

    /* renamed from: b  reason: collision with root package name */
    static int f24000b;

    /* renamed from: c  reason: collision with root package name */
    static float f24001c;

    /* renamed from: d  reason: collision with root package name */
    static int f24002d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneralScoresTableDataMgr.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24003a;

        static {
            int[] iArr = new int[SportTypesEnum.values().length];
            f24003a = iArr;
            try {
                iArr[SportTypesEnum.TENNIS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24003a[SportTypesEnum.CRICKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: GeneralScoresTableDataMgr.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f24004a;

        /* renamed from: b  reason: collision with root package name */
        int f24005b;

        /* renamed from: c  reason: collision with root package name */
        float f24006c;

        /* renamed from: d  reason: collision with root package name */
        boolean f24007d;

        /* renamed from: e  reason: collision with root package name */
        boolean f24008e;

        /* renamed from: f  reason: collision with root package name */
        boolean f24009f;

        /* renamed from: g  reason: collision with root package name */
        int f24010g;

        /* renamed from: h  reason: collision with root package name */
        boolean f24011h;

        /* renamed from: i  reason: collision with root package name */
        int f24012i;

        /* renamed from: j  reason: collision with root package name */
        boolean f24013j;

        /* renamed from: k  reason: collision with root package name */
        int f24014k;

        /* renamed from: l  reason: collision with root package name */
        public int f24015l;

        public b() {
            this.f24011h = false;
            this.f24013j = false;
        }

        public b(String str, int i10, float f10, boolean z10, boolean z11, int i11, int i12, boolean z12, int i13, int i14) {
            this(str, i10, f10, z10, z11, i11, i12, false, z12, i13, i14);
        }

        public b(String str, int i10, float f10, boolean z10, boolean z11, int i11, int i12, boolean z12, boolean z13, int i13, int i14) {
            this.f24011h = false;
            this.f24004a = str;
            this.f24005b = i10;
            this.f24006c = f10;
            this.f24007d = z10;
            this.f24008e = z11;
            this.f24010g = i11;
            this.f24012i = i12;
            this.f24013j = z12;
            this.f24009f = z13;
            this.f24014k = i13;
            this.f24015l = i14;
        }

        public int a() {
            return this.f24014k;
        }

        public int b() {
            return this.f24012i;
        }

        public String c() {
            return String.valueOf(this.f24012i);
        }

        public int d() {
            return this.f24005b;
        }

        public float e() {
            return this.f24006c;
        }

        public String f() {
            return this.f24004a;
        }

        public int g() {
            return this.f24010g;
        }

        public boolean h() {
            return this.f24007d;
        }

        public boolean i() {
            return this.f24011h;
        }
    }

    /* compiled from: GeneralScoresTableDataMgr.java */
    /* loaded from: classes2.dex */
    public enum c {
        HOME_WIN,
        AWAY_WIN,
        TIE
    }

    private static HashMap<Integer, ArrayList<b>> a(HashMap<Integer, ArrayList<b>> hashMap) {
        try {
            HashMap<Integer, ArrayList<b>> hashMap2 = new HashMap<>();
            for (Integer num : hashMap.keySet()) {
                hashMap2.put(num, new ArrayList<>());
                if (!hashMap.get(num).isEmpty()) {
                    for (int size = hashMap.get(num).size(); size > 0; size--) {
                        hashMap2.get(num).add(hashMap.get(num).get(size - 1));
                    }
                }
            }
            return hashMap2;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return hashMap;
        }
    }

    public static HashMap<Integer, ArrayList<b>> b(GameObj gameObj, CompetitionObj competitionObj) {
        HashMap<Integer, ArrayList<b>> hashMap;
        int i10;
        LinkedHashMap<Integer, StageTimeObj> linkedHashMap;
        boolean z10;
        o();
        HashMap<Integer, ArrayList<b>> hashMap2 = null;
        try {
            hashMap = new HashMap<>();
        } catch (Exception e10) {
            e = e10;
        }
        try {
            ArrayList<b> arrayList = new ArrayList<>();
            ArrayList<b> arrayList2 = new ArrayList<>();
            ArrayList<b> arrayList3 = new ArrayList<>();
            ArrayList<b> arrayList4 = new ArrayList<>();
            int i11 = li.x0.l1() ? 21 : 19;
            arrayList.add(new b(" ", f23999a, f24001c, false, false, f24002d, -1, false, -1, -1));
            int i12 = 0;
            arrayList2.add(new b(gameObj.getComps()[0].getShortName(), f23999a, f24001c, gameObj.getWinner() == 1, false, i11, -1, true, false, -1, -1));
            arrayList3.add(new b(gameObj.getComps()[1].getShortName(), f23999a, f24001c, gameObj.getWinner() == 2, false, i11, -1, true, false, -1, -1));
            int i13 = a.f24003a[SportTypesEnum.create(gameObj.getSportID()).ordinal()];
            if (i13 != 1) {
                i10 = 2;
                if (i13 != 2) {
                    d(arrayList, arrayList2, arrayList3, gameObj, competitionObj);
                } else {
                    c(arrayList, arrayList2, arrayList3, gameObj);
                }
            } else {
                i10 = 2;
                e(arrayList, arrayList2, arrayList3, gameObj, competitionObj);
            }
            hashMap.put(0, arrayList);
            if (li.x0.k(gameObj.homeAwayTeamOrder)) {
                hashMap.put(Integer.valueOf(i10), arrayList2);
                hashMap.put(1, arrayList3);
            } else {
                hashMap.put(1, arrayList2);
                hashMap.put(Integer.valueOf(i10), arrayList3);
            }
            if (!gameObj.getStatusObj().getIsNotStarted() && (linkedHashMap = gameObj.stageTimes) != null && !linkedHashMap.isEmpty()) {
                float dimension = App.m().getResources().getDimension(R.dimen.f21655t);
                Iterator<b> it = arrayList.iterator();
                int i14 = -1;
                boolean z11 = false;
                boolean z12 = false;
                while (it.hasNext()) {
                    b next = it.next();
                    if (gameObj.stageTimes.containsKey(Integer.valueOf(next.f24015l))) {
                        i14 = n();
                        arrayList4.add(new b(gameObj.stageTimes.get(Integer.valueOf(next.f24015l)).time, i14, dimension, false, false, f24002d, -1, App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStages().get(Integer.valueOf(next.f24015l)).isMain(), -1, next.f24015l));
                    } else {
                        if (z11 || !gameObj.getIsActive()) {
                            z10 = false;
                        } else {
                            arrayList4.add(new b(" ", i14, dimension, false, false, f24002d, -1, false, -1, -1));
                            z10 = true;
                            z11 = true;
                        }
                        if (!z12 && gameObj.isFinished()) {
                            arrayList4.add(new b(" ", i14, dimension, false, false, f24002d, -1, false, -1, -1));
                            z10 = true;
                            z12 = true;
                        }
                        if (!z10) {
                            arrayList4.add(new b("", -1, dimension, false, false, f24002d, -1, false, -1, -1));
                        }
                    }
                }
                hashMap.put(3, arrayList4);
            }
            int size = arrayList.size();
            for (int i15 = size - 1; i15 >= 0; i15--) {
                if (arrayList.get(i15).f24009f) {
                    i12++;
                    int i16 = size - i12;
                    if (arrayList.size() > i15) {
                        arrayList.add(i16, arrayList.remove(i15));
                    }
                    if (arrayList2.size() > i15) {
                        arrayList2.add(i16, arrayList2.remove(i15));
                    }
                    if (arrayList3.size() > i15) {
                        arrayList3.add(i16, arrayList3.remove(i15));
                    }
                    if (arrayList4.size() > i15) {
                        arrayList4.add(i16, arrayList4.remove(i15));
                    }
                }
            }
            return li.x0.l1() ? a(hashMap) : hashMap;
        } catch (Exception e11) {
            e = e11;
            hashMap2 = hashMap;
            li.x0.N1(e);
            return hashMap2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    private static HashMap<Integer, ArrayList<b>> c(ArrayList<b> arrayList, ArrayList<b> arrayList2, ArrayList<b> arrayList3, GameObj gameObj) {
        o();
        try {
            ?? r22 = 1;
            int i10 = 1;
            for (StatusObj statusObj : App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID())).getStatuses().values()) {
                if (statusObj.getID() != 145) {
                    if (statusObj.getID() == 146 && gameObj.hasSecondInning()) {
                    }
                    r22 = 1;
                }
                String inningScore = gameObj.getInningScore(r22, i10, r22);
                String inningScore2 = gameObj.getInningScore(2, i10, r22);
                i10++;
                if (!inningScore.isEmpty() || !inningScore2.isEmpty() || (!statusObj.isExtraTime() && !statusObj.isPenalties())) {
                    arrayList.add(new b(statusObj.getShortName(), f24000b, f24001c, false, false, f24002d, -1, false, -1, -1));
                    arrayList2.add(new b(inningScore, f23999a, f24001c, false, true, f24002d, -1, false, -1, -1));
                    arrayList3.add(new b(inningScore2, f23999a, f24001c, false, true, f24002d, -1, false, -1, -1));
                    r22 = 1;
                }
                r22 = 1;
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private static HashMap<Integer, ArrayList<b>> d(ArrayList<b> arrayList, ArrayList<b> arrayList2, ArrayList<b> arrayList3, GameObj gameObj, CompetitionObj competitionObj) {
        int i10;
        int i11;
        int i12;
        o();
        try {
            SportTypeObj sportTypeObj = App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID()));
            ArrayList arrayList4 = new ArrayList(sportTypeObj.getStages().keySet());
            int i13 = 1;
            for (int i14 = 0; i14 <= sportTypeObj.getStages().size() - 1; i14++) {
                StageObj stageObj = sportTypeObj.getStages().get(arrayList4.get(i14));
                int i15 = (i13 - 1) * 2;
                i13++;
                if (competitionObj == null || gameObj.getSportID() != SportTypesEnum.BASKETBALL.getValue() || competitionObj.SubSportType != SportTypeObj.EBasketBallSubSportTypes.TwoHalves.getValue() || (stageObj.getID() != 16 && stageObj.getID() != 18)) {
                    String valueOf = gameObj.getScores()[i15].getScore() < 0 ? "-" : String.valueOf(gameObj.getScores()[i15].getScore());
                    int i16 = i15 + 1;
                    String valueOf2 = String.valueOf(gameObj.getScores()[i16].getScore());
                    if (gameObj.getScores()[i16].getScore() < 0) {
                        valueOf2 = "-";
                    }
                    if (!stageObj.isOptional() || ((!valueOf.isEmpty() && !valueOf.equals("-")) || (!valueOf2.isEmpty() && !valueOf2.equals("-")))) {
                        c i17 = i(gameObj.getScores()[i15].getScore(), gameObj.getScores()[i16].getScore());
                        int j10 = j(gameObj.getStage() == stageObj.getID());
                        int sportID = gameObj.getSportID();
                        SportTypesEnum sportTypesEnum = SportTypesEnum.BASKETBALL;
                        if (sportID != sportTypesEnum.getValue() || competitionObj.SubSportType != 1) {
                            arrayList.add(new b(stageObj.getShortName(), j10, f24001c, false, false, f24002d, -1, stageObj.isMain(), -1, stageObj.getID()));
                        } else if (stageObj.getID() == 17) {
                            arrayList.add(new b(App.l().getSportTypes().get(Integer.valueOf(sportTypesEnum.getValue())).getStatuses().get(137).getShortName(), j10, f24001c, false, false, f24002d, -1, stageObj.isMain(), -1, stageObj.getID()));
                        } else if (stageObj.getID() == 19) {
                            arrayList.add(new b(App.l().getSportTypes().get(Integer.valueOf(sportTypesEnum.getValue())).getStatuses().get(138).getShortName(), j10, f24001c, false, false, f24002d, -1, stageObj.isMain(), -1, stageObj.getID()));
                        } else if (stageObj.getID() == 20) {
                            arrayList.add(new b(App.l().getSportTypes().get(Integer.valueOf(sportTypesEnum.getValue())).getStatuses().get(20).getShortName(), j10, f24001c, false, false, f24002d, -1, stageObj.isMain(), -1, stageObj.getID()));
                        } else {
                            arrayList.add(new b(stageObj.getShortName(), j10, f24001c, false, false, f24002d, -1, stageObj.isMain(), -1, stageObj.getID()));
                        }
                        boolean z10 = !gameObj.isFinished() && ((gameObj.getIsActive() && sportTypeObj.getStatuses().get(Integer.valueOf(gameObj.getStID())).scoreStage == stageObj.getID()) || stageObj.isMain());
                        int m10 = z10 ? j10 : m();
                        if (!z10) {
                            j10 = l();
                        }
                        if (gameObj.isFinished() && stageObj.getID() == sportTypeObj.getCurrentResultStage()) {
                            int g10 = g();
                            int h10 = h();
                            m10 = k();
                            i11 = h10;
                            i10 = g10;
                            j10 = f();
                        } else {
                            i10 = -1;
                            i11 = -1;
                        }
                        if (stageObj.isMain()) {
                            i12 = j10;
                        } else {
                            i12 = i17 == c.HOME_WIN ? m10 : j10;
                            if (i17 == c.AWAY_WIN) {
                                j10 = m10;
                            }
                        }
                        arrayList2.add(new b(valueOf, i12, f24001c, false, true, f24002d, -1, stageObj.isMain(), i17 == c.HOME_WIN ? i10 : i11, stageObj.getID()));
                        float f10 = f24001c;
                        int i18 = f24002d;
                        boolean isMain = stageObj.isMain();
                        if (i17 == c.AWAY_WIN) {
                            i11 = i10;
                        }
                        arrayList3.add(new b(valueOf2, j10, f10, false, true, i18, -1, isMain, i11, stageObj.getID()));
                    }
                }
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private static HashMap<Integer, ArrayList<b>> e(ArrayList<b> arrayList, ArrayList<b> arrayList2, ArrayList<b> arrayList3, GameObj gameObj, CompetitionObj competitionObj) {
        int i10;
        int i11;
        ArrayList arrayList4;
        int i12;
        int i13;
        int i14;
        int i15;
        SportTypeObj sportTypeObj;
        GameObj gameObj2 = gameObj;
        int i16 = 1;
        if (gameObj.getServe() == 1) {
            arrayList2.get(0).f24011h = true;
        } else if (gameObj.getServe() == 2) {
            arrayList3.get(0).f24011h = true;
        }
        o();
        try {
            SportTypeObj sportTypeObj2 = App.l().getSportTypes().get(Integer.valueOf(gameObj.getSportID()));
            ArrayList arrayList5 = new ArrayList(sportTypeObj2.getStages().keySet());
            int i17 = 0;
            int i18 = 1;
            while (i17 < sportTypeObj2.getStages().size()) {
                StageObj stageObj = sportTypeObj2.getStages().get(arrayList5.get(i17));
                if ((competitionObj.SubSportType == SportTypeObj.ETennisSubSportTypes.FiveSets.getValue() || (stageObj.getID() != 30 && stageObj.getID() != 31)) && (gameObj.getIsActive() || i17 != i16)) {
                    f23999a = li.p0.A(R.attr.U0);
                    if (i17 == i16) {
                        f23999a = li.p0.A(R.attr.f21565m1);
                    }
                    boolean z10 = i17 > i16;
                    int i19 = (i18 - 1) * 2;
                    String valueOf = String.valueOf(gameObj.getScores()[i19].getScore());
                    if (gameObj.getScores()[i19].getScore() < 0) {
                        valueOf = "";
                    } else if (gameObj.getScores()[i19].getScore() == 50) {
                        valueOf = "Ad";
                    }
                    int i20 = i19 + 1;
                    String valueOf2 = gameObj.getScores()[i20].getScore() < 0 ? "" : gameObj.getScores()[i20].getScore() == 50 ? "Ad" : String.valueOf(gameObj.getScores()[i20].getScore());
                    ArrayList<ExtraScoreObj> arrayList6 = gameObj2.extraScore;
                    if (arrayList6 == null || arrayList6.isEmpty()) {
                        i10 = -1;
                        i11 = -1;
                    } else {
                        Iterator<ExtraScoreObj> it = gameObj2.extraScore.iterator();
                        int i21 = -1;
                        int i22 = -1;
                        while (it.hasNext()) {
                            ExtraScoreObj next = it.next();
                            if (stageObj.getID() == next.stageId) {
                                i21 = next.scores[0].getScore();
                                i22 = next.scores[1].getScore();
                            }
                        }
                        i10 = i21;
                        i11 = i22;
                    }
                    c i23 = i(gameObj.getScores()[i19].getScore(), gameObj.getScores()[i20].getScore());
                    boolean z11 = (gameObj.getIsActive() && sportTypeObj2.getStatuses().get(Integer.valueOf(gameObj.getStID())).scoreStage == stageObj.getID()) || stageObj.isMain();
                    int j10 = j(z11);
                    int m10 = z11 ? j10 : m();
                    int l10 = z11 ? j10 : l();
                    arrayList4 = arrayList5;
                    if (stageObj.getID() == 34 && sportTypeObj2.getID() == 3) {
                        m10 = l10;
                    }
                    if (gameObj.isFinished() && stageObj.getID() == sportTypeObj2.getCurrentResultStage()) {
                        i15 = g();
                        i14 = h();
                        i12 = k();
                        i13 = f();
                    } else {
                        i12 = m10;
                        i13 = l10;
                        i14 = -1;
                        i15 = -1;
                    }
                    sportTypeObj = sportTypeObj2;
                    arrayList.add(new b(stageObj.getShortName(), j10, f24001c, false, false, f24002d, -1, stageObj.isMain(), -1, stageObj.getID()));
                    c cVar = c.HOME_WIN;
                    int i24 = i13;
                    arrayList2.add(new b(valueOf, i23 == cVar ? i12 : i13, f24001c, false, z10, f24002d, i10, stageObj.isMain(), i23 == cVar ? i15 : i14, stageObj.getID()));
                    c cVar2 = c.AWAY_WIN;
                    arrayList3.add(new b(valueOf2, i23 == cVar2 ? i12 : i24, f24001c, false, z10, f24002d, i11, stageObj.isMain(), i23 == cVar2 ? i15 : i14, stageObj.getID()));
                    i18++;
                    i17++;
                    gameObj2 = gameObj;
                    sportTypeObj2 = sportTypeObj;
                    arrayList5 = arrayList4;
                    i16 = 1;
                }
                i18++;
                sportTypeObj = sportTypeObj2;
                arrayList4 = arrayList5;
                i17++;
                gameObj2 = gameObj;
                sportTypeObj2 = sportTypeObj;
                arrayList5 = arrayList4;
                i16 = 1;
            }
            return null;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    private static int f() {
        return li.p0.A(R.attr.B1);
    }

    private static int g() {
        return li.p0.A(R.attr.T0);
    }

    private static int h() {
        return !li.x0.n1() ? li.p0.A(R.attr.f21598x1) : li.p0.A(R.attr.f21598x1);
    }

    private static c i(int i10, int i11) {
        c cVar = c.TIE;
        try {
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        if (i10 <= i11) {
            if (i10 < i11) {
                cVar = c.AWAY_WIN;
            }
            return cVar;
        }
        cVar = c.HOME_WIN;
        return cVar;
    }

    private static int j(boolean z10) {
        return z10 ? li.p0.A(R.attr.U0) : li.p0.A(R.attr.f21565m1);
    }

    private static int k() {
        return li.p0.A(R.attr.B1);
    }

    private static int l() {
        return li.p0.A(R.attr.f21565m1);
    }

    private static int m() {
        return li.p0.A(R.attr.T0);
    }

    private static int n() {
        return li.p0.A(R.attr.f21565m1);
    }

    private static void o() {
        f23999a = li.p0.A(R.attr.U0);
        f24000b = li.p0.A(R.attr.f21565m1);
        f24001c = App.m().getResources().getDimension(R.dimen.f21656u);
        f24002d = 17;
    }
}
