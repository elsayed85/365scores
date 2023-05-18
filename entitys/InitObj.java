package com.scores365.entitys;

import androidx.annotation.NonNull;
import com.scores365.bets.model.BetsObj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Vector;
import li.x0;
/* loaded from: classes2.dex */
public class InitObj {
    @p9.c("DefaultTimeZoneID")
    private int defaultTimeZoneID;
    @p9.c("DefaultTimeZoneId")
    private int defaultTimeZoneId;
    @p9.c("ImageSources")
    private ImageSources imageSources;
    @p9.c("Languages")
    private LinkedHashMap<Integer, LanguageObj> languages;
    @p9.c("LoginAvailable")
    public boolean loginAvailable;
    @p9.c("NotificationCategories")
    private LinkedHashMap<Integer, NotificationCategory> notificationCategories;
    private HashMap<Integer, LinkedHashSet<NotifiedUpdateObj>> notificationsPerSportType;
    @p9.c("NotifiedUpdates")
    private Vector<NotifiedUpdateObj> notifiedUpdates;
    private LinkedHashMap<Integer, NotifiedUpdateObj> notifiedUpdatesHash;
    @p9.c("SportTypes")
    private LinkedHashMap<Integer, SportTypeObj> sportTypes;
    private LinkedHashMap<Integer, SportTypeObj> sportTypesOrderedByOrderLevel;
    @p9.c("Terms")
    private Hashtable<String, TermObj> terms;
    @p9.c("VideoSources")
    private HashMap<Integer, VideoSources> videoSourceById;
    @p9.c("DefaultLangId")
    private int defaultLangId = -1;
    @p9.c("DefaultLangID")
    private int defaultLangID = -1;
    @p9.c("UserCountryID")
    private int userCountryID = -1;
    @p9.c("DefaultUserCountryID")
    private int defaultUserCountryID = -1;
    @p9.c("UserCityID")
    public int userCityId = -1;
    @p9.c("Popular")
    public Popular popularArrs = new Popular();
    @p9.c("Bets")
    public BetsObj bets = new BetsObj();

    /* loaded from: classes2.dex */
    public class Popular {
        @p9.c("Athletes")
        public LinkedHashSet<Integer> popularAthletes;
        @p9.c("Competitions")
        public LinkedHashSet<Integer> popularCompetitions;
        @p9.c("Competitors")
        public LinkedHashSet<Integer> popularCompetitors;
        @p9.c("Searches")
        public Searches searches;

        public Popular() {
            this.searches = new Searches();
        }
    }

    /* loaded from: classes2.dex */
    public class Searches {
        @p9.c("Competitions")
        LinkedHashSet<String> popularCompetitionSearches = new LinkedHashSet<>();
        @p9.c("Competitors")
        LinkedHashSet<String> popularCompetitorsSearches = new LinkedHashSet<>();

        public Searches() {
        }
    }

    public int getDefaultLangId() {
        int i10;
        int i11 = this.defaultLangId;
        return (i11 != -1 || (i10 = this.defaultLangID) <= 0) ? i11 : i10;
    }

    public int getDefaultTimeZoneId() {
        return (this.defaultLangId != -1 || this.defaultLangID <= 0) ? this.defaultTimeZoneId : this.defaultTimeZoneID;
    }

    public int getDefaultUserCountryID() {
        int i10;
        int i11 = this.defaultUserCountryID;
        return (i11 != -1 || (i10 = this.userCountryID) <= 0) ? i11 : i10;
    }

    public ImageSources getImageSources() {
        return this.imageSources;
    }

    public LinkedHashMap<Integer, LanguageObj> getLanguages() {
        return this.languages;
    }

    public LinkedHashMap<Integer, NotificationCategory> getNotificationCategories() {
        return this.notificationCategories;
    }

    public NotifiedUpdateObj getNotificationType(int i10, int i11) {
        try {
            Iterator<NotifiedUpdateObj> it = this.notifiedUpdates.iterator();
            while (it.hasNext()) {
                NotifiedUpdateObj next = it.next();
                if (i10 == next.getID() && i11 == next.sportTypeId()) {
                    return next;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public LinkedHashSet<NotifiedUpdateObj> getNotificationsBySportType(int i10) {
        try {
            return this.notificationsPerSportType.get(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<NotifiedUpdateObj>>> getNotificationsPerSportTypePerCategoryForEntityType(int i10) {
        LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<NotifiedUpdateObj>>> linkedHashMap = new LinkedHashMap<>();
        try {
            Iterator<NotifiedUpdateObj> it = this.notifiedUpdates.iterator();
            while (it.hasNext()) {
                NotifiedUpdateObj next = it.next();
                if (!linkedHashMap.containsKey(Integer.valueOf(next.sportTypeId()))) {
                    linkedHashMap.put(Integer.valueOf(next.sportTypeId()), new LinkedHashMap<>());
                }
                RelevantEntitiesType relevantEntityType = next.getRelevantEntityType(i10);
                if (relevantEntityType != null) {
                    if (!linkedHashMap.get(Integer.valueOf(next.sportTypeId())).containsKey(relevantEntityType.getCategory())) {
                        linkedHashMap.get(Integer.valueOf(next.sportTypeId())).put(relevantEntityType.getCategory(), new ArrayList<>());
                    }
                    linkedHashMap.get(Integer.valueOf(next.sportTypeId())).get(relevantEntityType.getCategory()).add(next);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return linkedHashMap;
    }

    public Vector<NotifiedUpdateObj> getNotifiedUpdates() {
        return this.notifiedUpdates;
    }

    public LinkedHashMap<Integer, NotifiedUpdateObj> getNotifiedUpdatesHash() {
        if (this.notifiedUpdatesHash == null) {
            this.notifiedUpdatesHash = new LinkedHashMap<>();
            Iterator<NotifiedUpdateObj> it = this.notifiedUpdates.iterator();
            while (it.hasNext()) {
                NotifiedUpdateObj next = it.next();
                this.notifiedUpdatesHash.put(Integer.valueOf(next.getID()), next);
            }
        }
        return this.notifiedUpdatesHash;
    }

    public LinkedHashSet<Integer> getPopularCompetitions() {
        return this.popularArrs.popularCompetitions;
    }

    public LinkedHashSet<Integer> getPopularCompetitors() {
        return this.popularArrs.popularCompetitors;
    }

    public LinkedHashMap<Integer, SportTypeObj> getSportTypes() {
        return this.sportTypes;
    }

    public LinkedHashMap<Integer, SportTypeObj> getSportTypesSortedByOrderLevel() {
        LinkedHashMap<Integer, SportTypeObj> linkedHashMap;
        Exception e10;
        LinkedHashMap<Integer, SportTypeObj> linkedHashMap2 = this.sportTypesOrderedByOrderLevel;
        if (linkedHashMap2 == null) {
            try {
                linkedHashMap = new LinkedHashMap<>();
            } catch (Exception e11) {
                linkedHashMap = linkedHashMap2;
                e10 = e11;
            }
            try {
                ArrayList arrayList = new ArrayList(this.sportTypes.values());
                Collections.sort(arrayList, new Comparator<SportTypeObj>() { // from class: com.scores365.entitys.InitObj.1
                    @Override // java.util.Comparator
                    public int compare(SportTypeObj sportTypeObj, SportTypeObj sportTypeObj2) {
                        try {
                            return sportTypeObj.orderLevel - sportTypeObj2.orderLevel;
                        } catch (Exception unused) {
                            return 0;
                        }
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    SportTypeObj sportTypeObj = (SportTypeObj) it.next();
                    linkedHashMap.put(Integer.valueOf(sportTypeObj.getID()), sportTypeObj);
                }
                this.sportTypesOrderedByOrderLevel = linkedHashMap;
                linkedHashMap2 = linkedHashMap;
            } catch (Exception e12) {
                e10 = e12;
                x0.N1(e10);
                return linkedHashMap;
            }
        }
        return linkedHashMap2;
    }

    public Hashtable<String, TermObj> getTerms() {
        return this.terms;
    }

    public VideoSources getVideoSourceObj(int i10) {
        try {
            HashMap<Integer, VideoSources> hashMap = this.videoSourceById;
            if (hashMap != null) {
                return hashMap.get(Integer.valueOf(i10));
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public void initNotificationsPerSportType() {
        try {
            this.notificationsPerSportType = new HashMap<>();
            Vector<NotifiedUpdateObj> vector = this.notifiedUpdates;
            if (vector != null) {
                Iterator<NotifiedUpdateObj> it = vector.iterator();
                while (it.hasNext()) {
                    NotifiedUpdateObj next = it.next();
                    if (!this.notificationsPerSportType.containsKey(Integer.valueOf(next.sportTypeId()))) {
                        this.notificationsPerSportType.put(Integer.valueOf(next.sportTypeId()), new LinkedHashSet<>());
                    }
                    this.notificationsPerSportType.get(Integer.valueOf(next.sportTypeId())).add(next);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InitObj{defaultLangId=");
        sb2.append(this.defaultLangId);
        sb2.append(", defaultTimeZoneId=");
        sb2.append(this.defaultTimeZoneId);
        sb2.append(", userCountryID=");
        sb2.append(this.userCountryID);
        sb2.append(", userCityId=");
        sb2.append(this.userCityId);
        sb2.append(", loginAvailable=");
        sb2.append(this.loginAvailable);
        sb2.append(", term map size=");
        Hashtable<String, TermObj> hashtable = this.terms;
        sb2.append(hashtable == null ? "null" : Integer.valueOf(hashtable.size()));
        sb2.append('}');
        return sb2.toString();
    }
}
