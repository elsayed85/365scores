package com.scores365.api;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.AccessToken;
import com.scores365.App;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.NotifiedUpdateObj;
import com.scores365.removeAds.RemoveAdsManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: APIUsers.java */
/* loaded from: classes2.dex */
public class v extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f23227a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23228b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f23229c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f23230d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f23231e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23232f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23233g;

    public v(@NonNull Context context, @NonNull String str) {
        this.f23227a = str;
        this.f23233g = li.x0.z1(context);
        SetBaseUrl(li.h0.d(context));
    }

    private String c(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    private void d(JSONArray jSONArray) {
        Vector<NotifiedUpdateObj> vector;
        Iterator<BaseObj> it;
        Vector<NotifiedUpdateObj> vector2;
        Iterator<BaseObj> it2;
        String str;
        Vector<BaseObj> N = App.b.N();
        if (N == null || N.isEmpty()) {
            return;
        }
        Vector<NotifiedUpdateObj> notifiedUpdates = App.l().getNotifiedUpdates();
        Iterator<BaseObj> it3 = N.iterator();
        while (it3.hasNext()) {
            AthleteObj athleteObj = (AthleteObj) it3.next();
            App.c cVar = App.c.ATHLETE;
            if (!App.b.f0(cVar, athleteObj.getID()) || App.b.d0(athleteObj.getID(), cVar)) {
                vector = notifiedUpdates;
                it = it3;
                if (App.b.d0(athleteObj.getID(), cVar) && li.x0.Z0(athleteObj.getSportTypeId())) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("EntityType", 4);
                        jSONObject.put("EntityID", athleteObj.getID());
                        jSONObject.put("NID", -1);
                        jSONObject.put("SID", athleteObj.getSportTypeId());
                        jSONObject.put("PlaySound", false);
                        jSONObject.put("Sound", "");
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        li.x0.N1(e10);
                    }
                }
            } else {
                int i10 = 0;
                while (i10 < notifiedUpdates.size()) {
                    NotifiedUpdateObj notifiedUpdateObj = notifiedUpdates.get(i10);
                    if (athleteObj.getSportTypeId() == notifiedUpdateObj.sportTypeId()) {
                        App.c cVar2 = App.c.ATHLETE;
                        if (App.b.g0(cVar2, athleteObj.getID(), notifiedUpdateObj.getID())) {
                            int P = App.b.P(cVar2, athleteObj.getID(), notifiedUpdateObj.getID());
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("EntityType", 4);
                                jSONObject2.put("EntityID", athleteObj.getID());
                                jSONObject2.put("NID", notifiedUpdateObj.getID());
                                jSONObject2.put("SID", athleteObj.getSportTypeId());
                                jSONObject2.put("PlaySound", P != -1);
                                if (P > -1) {
                                    try {
                                        li.k0 b10 = li.l0.b(P, notifiedUpdateObj.getID());
                                        vector2 = notifiedUpdates;
                                        try {
                                            if (P != b10.f34608a) {
                                                it2 = it3;
                                                try {
                                                    sf.a.i0(App.m()).f2(athleteObj.getID(), notifiedUpdateObj.getID(), b10.f34608a);
                                                } catch (Exception unused) {
                                                    str = "";
                                                    jSONObject2.put("Sound", str);
                                                    jSONArray.put(jSONObject2);
                                                    i10++;
                                                    notifiedUpdates = vector2;
                                                    it3 = it2;
                                                }
                                            } else {
                                                it2 = it3;
                                            }
                                            str = b10.f34609b;
                                        } catch (Exception unused2) {
                                            it2 = it3;
                                            str = "";
                                            jSONObject2.put("Sound", str);
                                            jSONArray.put(jSONObject2);
                                            i10++;
                                            notifiedUpdates = vector2;
                                            it3 = it2;
                                        }
                                    } catch (Exception unused3) {
                                        vector2 = notifiedUpdates;
                                    }
                                    try {
                                        jSONObject2.put("Sound", str);
                                    } catch (Exception e11) {
                                        e = e11;
                                        li.x0.N1(e);
                                        i10++;
                                        notifiedUpdates = vector2;
                                        it3 = it2;
                                    }
                                } else {
                                    vector2 = notifiedUpdates;
                                    it2 = it3;
                                }
                                jSONArray.put(jSONObject2);
                            } catch (Exception e12) {
                                e = e12;
                                vector2 = notifiedUpdates;
                                it2 = it3;
                            }
                            i10++;
                            notifiedUpdates = vector2;
                            it3 = it2;
                        }
                    }
                    vector2 = notifiedUpdates;
                    it2 = it3;
                    i10++;
                    notifiedUpdates = vector2;
                    it3 = it2;
                }
                vector = notifiedUpdates;
                it = it3;
            }
            notifiedUpdates = vector;
            it3 = it;
        }
    }

    private String e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return c(str2);
        }
        return c(str) + " " + str2;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            StringBuilder sb2 = new StringBuilder(str);
            for (int i10 = 0; i10 < str.length(); i10++) {
                sb2.setCharAt(i10, (char) (str.charAt(i10) + 1));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private void g(JSONArray jSONArray) {
        Iterator<Integer> it;
        boolean z10;
        if (App.b.m() == null && sf.b.X1().V1().isEmpty()) {
            return;
        }
        if (App.b.m() != null) {
            it = App.b.m().iterator();
            z10 = true;
        } else {
            it = sf.b.X1().V1().iterator();
            z10 = false;
        }
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            App.c cVar = App.c.GAME;
            Vector<Integer> Q = App.b.Q(cVar, intValue);
            if (Q == null || Q.isEmpty()) {
                Q = sf.a.i0(App.m()).p0(intValue);
            }
            if (sf.a.i0(App.m()).k1(intValue) || (z10 && App.b.f0(cVar, intValue))) {
                for (int i10 = 0; i10 < Q.size(); i10++) {
                    int intValue2 = Q.get(i10).intValue();
                    int o02 = sf.a.i0(App.m()).o0(intValue, intValue2);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("EntityType", 3);
                        jSONObject.put("EntityID", intValue);
                        jSONObject.put("NID", intValue2);
                        jSONObject.put("SID", 1);
                        jSONObject.put("PlaySound", o02 != -1);
                        if (o02 > -1) {
                            String str = "";
                            try {
                                li.k0 b10 = li.l0.b(o02, intValue2);
                                if (o02 != b10.f34608a) {
                                    sf.a.i0(App.m()).U1(intValue, intValue2, b10.f34608a);
                                }
                                str = b10.f34609b;
                            } catch (Exception unused) {
                            }
                            jSONObject.put("Sound", str);
                        }
                        jSONArray.put(jSONObject);
                    } catch (Exception e10) {
                        li.x0.N1(e10);
                    }
                }
            }
        }
    }

    private void h(JSONArray jSONArray) {
        Iterator<CompetitionObj> it;
        Iterator<CompetitionObj> it2;
        Vector<Integer> vector;
        String str;
        if ((App.b.i() == null || App.b.i().isEmpty()) && sf.b.X1().X2().isEmpty()) {
            return;
        }
        Iterator<CompetitionObj> it3 = App.b.i() != null ? App.b.i().iterator() : sf.b.X1().X2().values().iterator();
        while (it3.hasNext()) {
            CompetitionObj next = it3.next();
            App.c cVar = App.c.LEAGUE;
            Vector<Integer> Q = App.b.Q(cVar, next.getID());
            if (Q == null || Q.isEmpty()) {
                Q = sf.a.i0(App.m()).v0(next.getID());
            }
            int i10 = 1;
            if (!sf.a.i0(App.m()).m1(next.getID()) || App.b.d0(next.getID(), cVar)) {
                it = it3;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("EntityType", 1);
                    jSONObject.put("EntityID", next.getID());
                    jSONObject.put("NID", -1);
                    jSONObject.put("SID", next.getSid());
                    jSONObject.put("PlaySound", false);
                    jSONObject.put("Sound", "");
                    jSONArray.put(jSONObject);
                } catch (JSONException e10) {
                    li.x0.N1(e10);
                }
            } else {
                int i11 = 0;
                while (i11 < Q.size()) {
                    int intValue = Q.get(i11).intValue();
                    int u02 = sf.a.i0(App.m()).u0(next.getID(), intValue);
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("EntityType", i10);
                        jSONObject2.put("EntityID", next.getID());
                        jSONObject2.put("NID", intValue);
                        jSONObject2.put("SID", next.getSid());
                        jSONObject2.put("PlaySound", u02 != -1);
                        if (u02 > -1) {
                            try {
                                li.k0 b10 = li.l0.b(u02, intValue);
                                it2 = it3;
                                try {
                                    if (u02 != b10.f34608a) {
                                        vector = Q;
                                        try {
                                            sf.a.i0(App.m()).X1(next.getID(), intValue, b10.f34608a);
                                        } catch (Exception unused) {
                                            str = "";
                                            jSONObject2.put("Sound", str);
                                            jSONArray.put(jSONObject2);
                                            i11++;
                                            it3 = it2;
                                            Q = vector;
                                            i10 = 1;
                                        }
                                    } else {
                                        vector = Q;
                                    }
                                    str = b10.f34609b;
                                } catch (Exception unused2) {
                                    vector = Q;
                                    str = "";
                                    jSONObject2.put("Sound", str);
                                    jSONArray.put(jSONObject2);
                                    i11++;
                                    it3 = it2;
                                    Q = vector;
                                    i10 = 1;
                                }
                            } catch (Exception unused3) {
                                it2 = it3;
                            }
                            try {
                                jSONObject2.put("Sound", str);
                            } catch (Exception e11) {
                                e = e11;
                                li.x0.N1(e);
                                i11++;
                                it3 = it2;
                                Q = vector;
                                i10 = 1;
                            }
                        } else {
                            it2 = it3;
                            vector = Q;
                        }
                        jSONArray.put(jSONObject2);
                    } catch (Exception e12) {
                        e = e12;
                        it2 = it3;
                        vector = Q;
                    }
                    i11++;
                    it3 = it2;
                    Q = vector;
                    i10 = 1;
                }
                it = it3;
            }
            it3 = it;
        }
    }

    private void i(JSONArray jSONArray) {
        Vector<NotifiedUpdateObj> vector;
        Iterator<CompObj> it;
        Vector<NotifiedUpdateObj> vector2;
        Iterator<CompObj> it2;
        String str;
        if ((App.b.l() == null || App.b.l().isEmpty()) && sf.b.X1().Z2().isEmpty()) {
            return;
        }
        Vector<NotifiedUpdateObj> notifiedUpdates = App.l().getNotifiedUpdates();
        Iterator<CompObj> it3 = App.b.l().iterator();
        while (it3.hasNext()) {
            CompObj next = it3.next();
            App.c cVar = App.c.TEAM;
            if (!App.b.f0(cVar, next.getID()) || App.b.d0(next.getID(), cVar)) {
                vector = notifiedUpdates;
                it = it3;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("EntityType", 2);
                    jSONObject.put("EntityID", next.getID());
                    jSONObject.put("NID", -1);
                    jSONObject.put("SID", next.getSportID());
                    jSONObject.put("PlaySound", false);
                    jSONObject.put("Sound", "");
                    jSONArray.put(jSONObject);
                } catch (JSONException e10) {
                    li.x0.N1(e10);
                }
            } else {
                int i10 = 0;
                while (i10 < notifiedUpdates.size()) {
                    NotifiedUpdateObj notifiedUpdateObj = notifiedUpdates.get(i10);
                    if (next.getSportID() == notifiedUpdateObj.sportTypeId()) {
                        App.c cVar2 = App.c.TEAM;
                        if (App.b.g0(cVar2, next.getID(), notifiedUpdateObj.getID())) {
                            int P = App.b.P(cVar2, next.getID(), notifiedUpdateObj.getID());
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("EntityType", 2);
                                jSONObject2.put("EntityID", next.getID());
                                jSONObject2.put("NID", notifiedUpdateObj.getID());
                                jSONObject2.put("SID", next.getSportID());
                                jSONObject2.put("PlaySound", P != -1);
                                if (P > -1) {
                                    try {
                                        li.k0 b10 = li.l0.b(P, notifiedUpdateObj.getID());
                                        vector2 = notifiedUpdates;
                                        try {
                                            if (P != b10.f34608a) {
                                                it2 = it3;
                                                try {
                                                    sf.a.i0(App.m()).f2(next.getID(), notifiedUpdateObj.getID(), b10.f34608a);
                                                } catch (Exception unused) {
                                                    str = "";
                                                    jSONObject2.put("Sound", str);
                                                    jSONArray.put(jSONObject2);
                                                    i10++;
                                                    notifiedUpdates = vector2;
                                                    it3 = it2;
                                                }
                                            } else {
                                                it2 = it3;
                                            }
                                            str = b10.f34609b;
                                        } catch (Exception unused2) {
                                            it2 = it3;
                                            str = "";
                                            jSONObject2.put("Sound", str);
                                            jSONArray.put(jSONObject2);
                                            i10++;
                                            notifiedUpdates = vector2;
                                            it3 = it2;
                                        }
                                    } catch (Exception unused3) {
                                        vector2 = notifiedUpdates;
                                    }
                                    try {
                                        jSONObject2.put("Sound", str);
                                    } catch (Exception e11) {
                                        e = e11;
                                        li.x0.N1(e);
                                        i10++;
                                        notifiedUpdates = vector2;
                                        it3 = it2;
                                    }
                                } else {
                                    vector2 = notifiedUpdates;
                                    it2 = it3;
                                }
                                jSONArray.put(jSONObject2);
                            } catch (Exception e12) {
                                e = e12;
                                vector2 = notifiedUpdates;
                                it2 = it3;
                            }
                            i10++;
                            notifiedUpdates = vector2;
                            it3 = it2;
                        }
                    }
                    vector2 = notifiedUpdates;
                    it2 = it3;
                    i10++;
                    notifiedUpdates = vector2;
                    it3 = it2;
                }
                vector = notifiedUpdates;
                it = it3;
            }
            notifiedUpdates = vector;
            it3 = it;
        }
    }

    public String a() {
        return this.f23230d;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0341 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03e8 A[Catch: JSONException -> 0x041d, TRY_LEAVE, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03fb A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0323 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0391 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x036b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d9 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e6 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f3 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020c A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021d A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0235 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023e A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02b2 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02d5 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f9 A[Catch: JSONException -> 0x041d, TryCatch #9 {JSONException -> 0x041d, blocks: (B:5:0x002b, B:60:0x01ba, B:62:0x01d9, B:64:0x01df, B:66:0x01e6, B:68:0x01ec, B:70:0x01f3, B:72:0x01f9, B:73:0x01fe, B:75:0x020c, B:76:0x0219, B:78:0x021d, B:79:0x0223, B:81:0x0235, B:82:0x023a, B:84:0x023e, B:85:0x0242, B:89:0x027a, B:91:0x02b2, B:93:0x02e2, B:95:0x02f9, B:97:0x02ff, B:98:0x0303, B:100:0x0309, B:106:0x032f, B:108:0x0341, B:110:0x0347, B:111:0x034b, B:113:0x0351, B:119:0x0377, B:120:0x038e, B:124:0x039d, B:125:0x03b4, B:129:0x03c4, B:130:0x03e2, B:132:0x03e8, B:135:0x03f2, B:137:0x03fb, B:138:0x0401, B:114:0x035b, B:115:0x0368, B:101:0x0313, B:102:0x0320, B:92:0x02d5, B:59:0x01b7), top: B:180:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b() {
        /*
            Method dump skipped, instructions count: 1125
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.api.v.b():java.lang.String");
    }

    @Override // com.scores365.api.d
    public void call() {
        this.f23230d = "";
        setPostData(b());
        super.call();
        if (this.requestSuccess) {
            return;
        }
        ee.k.p(App.m(), AccessToken.DEFAULT_GRAPH_DOMAIN, "ssl-request", "failed", false);
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        String str = this.f23227a;
        if (str != "GET_REFERRED_USERS_COUNT") {
            return str == "GET_USER_SELECTIONS" ? "Users/Get/" : "Users/Update/";
        }
        return "Users/Get/ReferredUsers/Status/?DeviceId=" + sf.b.X1().F2() + "&DeviceType=2&AdvertisingID=" + sf.b.X1().M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public long getTimeoutConnection() {
        return "GET_USER_SELECTIONS".equals(this.f23227a) ? TimeUnit.SECONDS.toMillis(7L) : super.getTimeoutConnection();
    }

    public boolean j() {
        return li.x0.s1(this.f23230d);
    }

    public void k(String[] strArr, String[] strArr2) {
        JSONObject jSONObject;
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "banners_start_date";
        this.f23228b = true;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e10) {
            e = e10;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (strArr == null || strArr2 == null) {
                str = "remove_ads";
                str2 = "inters_start_date";
            } else {
                str = "remove_ads";
                str2 = "inters_start_date";
                int i10 = 0;
                while (i10 < strArr.length) {
                    String str6 = str5;
                    jSONObject.put(strArr[i10], strArr2[i10]);
                    arrayList.add(strArr[i10]);
                    i10++;
                    str5 = str6;
                }
            }
            String str7 = str5;
            try {
                if (!arrayList.contains("Version")) {
                    jSONObject.put("Version", sf.b.X1().b());
                }
                if (!arrayList.contains("Get Token Tries")) {
                    jSONObject.put("Get Token Tries", "0");
                }
                if (!arrayList.contains("Gcm Type")) {
                    jSONObject.put("Gcm Type", "FCM");
                }
                String str8 = "";
                if (!arrayList.contains("Token Get Time") && !sf.b.X1().f().equals("")) {
                    jSONObject.put("Token Get Time", sf.b.X1().f());
                }
                if (!arrayList.contains("Gcm Error") && !sf.b.X1().e().equals("")) {
                    jSONObject.put("Gcm Error", sf.b.X1().e());
                }
                if (!arrayList.contains("HasAlreadyLottorizedForAds")) {
                    jSONObject.put("HasAlreadyLottorizedForAds", true);
                }
                if (!arrayList.contains("HasLotterizedToGetAds")) {
                    jSONObject.put("HasLotterizedToGetAds", true);
                }
                if (!arrayList.contains("HasLotterizedToGetInterAds")) {
                    jSONObject.put("HasLotterizedToGetInterAds", true);
                }
                try {
                    str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(-1L));
                } catch (Exception unused) {
                    str3 = "";
                }
                if (!arrayList.contains("AdsStartDate")) {
                    jSONObject.put("AdsStartDate", str3);
                }
                try {
                    str4 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).format(new Date(-1L));
                } catch (Exception unused2) {
                    str4 = "";
                }
                if (!arrayList.contains(str7)) {
                    jSONObject.put(str7, str4);
                }
                try {
                    str8 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH).format(new Date(-1L));
                } catch (Exception unused3) {
                }
                String str9 = str2;
                if (!arrayList.contains(str9)) {
                    jSONObject.put(str9, str8);
                }
                String str10 = str;
                if (!arrayList.contains(str10)) {
                    jSONObject.put(str10, String.valueOf(RemoveAdsManager.isUserAdsRemoved(App.m())));
                }
                if (!arrayList.contains("remove_ads_buying")) {
                    jSONObject.put("remove_ads_buying", sf.b.X1().q());
                }
                if (!arrayList.contains("remove_ads_invite_friends")) {
                    jSONObject.put("remove_ads_invite_friends", sf.b.X1().p());
                }
            } catch (Exception e11) {
                li.x0.N1(e11);
            }
            this.f23229c = jSONObject.toString();
        } catch (JSONException e12) {
            e = e12;
            li.x0.N1(e);
        }
    }

    public void l(String[] strArr, String[] strArr2, boolean z10, boolean z11) {
        boolean z12;
        String str;
        String[] strArr3 = strArr;
        this.f23228b = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("IsTeamsDefault", z10);
            jSONObject.put("IsLeaguesDefault", z11);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            if (strArr3 != null && strArr2 != null) {
                int i10 = 0;
                while (i10 < strArr3.length) {
                    String str3 = strArr3[i10];
                    if (str3 != null && !str3.equals("") && (str = strArr2[i10]) != null && !str.equals("")) {
                        jSONObject.put(strArr3[i10], strArr2[i10]);
                    }
                    i10++;
                    strArr3 = strArr;
                }
            }
            try {
                if (!arrayList.contains("Version")) {
                    jSONObject.put("Version", sf.b.X1().b());
                }
                if (!arrayList.contains("Get Token Tries")) {
                    jSONObject.put("Get Token Tries", "0");
                }
                if (!arrayList.contains("Gcm Type")) {
                    jSONObject.put("Gcm Type", "FCM");
                }
                if (!arrayList.contains("Token Get Time") && !sf.b.X1().f().equals("")) {
                    jSONObject.put("Token Get Time", sf.b.X1().f());
                }
                if (!arrayList.contains("Gcm Error") && !sf.b.X1().e().equals("")) {
                    jSONObject.put("Gcm Error", sf.b.X1().e());
                }
                if (arrayList.contains("HasAlreadyLottorizedForAds")) {
                    z12 = true;
                } else {
                    z12 = true;
                    jSONObject.put("HasAlreadyLottorizedForAds", true);
                }
                if (!arrayList.contains("HasLotterizedToGetAds")) {
                    jSONObject.put("HasLotterizedToGetAds", z12);
                }
                if (!arrayList.contains("HasLotterizedToGetInterAds")) {
                    jSONObject.put("HasLotterizedToGetInterAds", z12);
                }
                try {
                    str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(-1L));
                } catch (Exception unused) {
                }
                if (!arrayList.contains("AdsStartDate")) {
                    jSONObject.put("AdsStartDate", str2);
                }
            } catch (Exception unused2) {
            }
            this.f23229c = jSONObject.toString();
        } catch (JSONException e10) {
            li.x0.N1(e10);
        }
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        this.f23230d = str;
        if ("UPDATE_ADD_USER".equals(this.f23227a) && j()) {
            li.f0.f34556a.b(true);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }
}
