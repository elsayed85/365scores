package com.scores365.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.BetObj;
import com.scores365.entitys.EntityObj;
import com.scores365.entitys.GamesObj;
import com.scores365.entitys.GsonManager;
import com.scores365.entitys.InitObj;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.SourceObj;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
/* compiled from: APIUtils.java */
/* loaded from: classes2.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static int f23236a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static int f23237b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static int f23238c = -1;

    public static LinkedList<BetObj> a(String str) {
        return new LinkedList<>(Arrays.asList((BetObj[]) GsonManager.getGson().l(str, BetObj[].class)));
    }

    public static int b() {
        try {
            if (f23238c == -1) {
                String l02 = li.p0.l0("CONNECTION_TIMEOUT");
                if (l02.isEmpty() || !li.x0.r1(l02)) {
                    f23238c = 15000;
                } else {
                    f23238c = Integer.parseInt(l02) * 1000;
                }
            }
            return f23238c;
        } catch (Exception unused) {
            return 120000;
        }
    }

    public static long c() {
        try {
            if (f23237b == -1) {
                String l02 = li.p0.l0("CONNECTION_RETRY_FREQ");
                if (l02.isEmpty() || !li.x0.r1(l02)) {
                    f23237b = 15000;
                } else {
                    f23237b = Integer.parseInt(l02) * 1000;
                }
            }
            return f23237b;
        } catch (Exception unused) {
            return DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD;
        }
    }

    public static int d() {
        try {
            if (f23236a == -1) {
                String l02 = li.p0.l0("CONNECTION_RETRY_COUNT");
                if (l02.isEmpty() || !li.x0.r1(l02)) {
                    f23236a = 3;
                } else {
                    f23236a = Integer.parseInt(l02) * 1000;
                }
            }
            return f23236a;
        } catch (Exception unused) {
            return 3;
        }
    }

    public static String e() {
        try {
            return li.p0.l0("NETWORK_PROBLEM");
        } catch (Exception unused) {
            return "";
        }
    }

    public static AthletesObj f(String str) {
        try {
            return (AthletesObj) GsonManager.getGson().l(str, AthletesObj.class);
        } catch (com.google.gson.s e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static EntityObj g(String str) {
        Exception e10;
        EntityObj entityObj;
        try {
            entityObj = (EntityObj) GsonManager.getGson().l(str, EntityObj.class);
        } catch (Exception e11) {
            e10 = e11;
            entityObj = null;
        }
        try {
            entityObj.mapCountries(entityObj.getCountries());
            entityObj.setCompetitors(entityObj.getCompetitors());
            entityObj.setCompetitions(entityObj.getCompetitions());
        } catch (Exception e12) {
            e10 = e12;
            li.x0.N1(e10);
            return entityObj;
        }
        return entityObj;
    }

    public static GamesObj h(String str) {
        try {
            return (GamesObj) GsonManager.getGson().l(str, GamesObj.class);
        } catch (com.google.gson.s e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static InitObj i(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            ng.a.f35508a.c("APIUtils", "got empty init data=" + str, new IllegalArgumentException("init data shouldn't be empty, data=[" + str + "]"));
            return null;
        }
        try {
            InitObj initObj = (InitObj) GsonManager.getGson().l(str, InitObj.class);
            initObj.initNotificationsPerSportType();
            ng.a.f35508a.b("APIUtils", "got valid init data=" + initObj, null);
            return initObj;
        } catch (Exception e10) {
            ng.a.f35508a.c("APIUtils", "error parsing init object, error=" + e10.getMessage() + ", data=" + str, e10);
            return null;
        }
    }

    public static zb.h j(String str) {
        try {
            return (zb.h) GsonManager.getGson().l(str, zb.h.class);
        } catch (com.google.gson.s e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static ue.d k(String str) {
        try {
            return (ue.d) GsonManager.getGson().l(str, ue.d.class);
        } catch (com.google.gson.s e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static NewsObj l(String str) {
        return (NewsObj) GsonManager.getGson().l(str, NewsObj.class);
    }

    public static ed.d m(String str) {
        try {
            return (ed.d) GsonManager.getGson().l(str, ed.d.class);
        } catch (com.google.gson.s e10) {
            li.x0.N1(e10);
            return null;
        }
    }

    public static void n(ItemObj[] itemObjArr, HashMap<Integer, SourceObj> hashMap) {
        for (ItemObj itemObj : itemObjArr) {
            if (hashMap.containsKey(Integer.valueOf(itemObj.getSourceID()))) {
                itemObj.setSourceObj(hashMap.get(Integer.valueOf(itemObj.getSourceID())));
            }
        }
    }
}
