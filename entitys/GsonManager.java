package com.scores365.entitys;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.e;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.s;
import com.google.gson.x;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.dashboardSections.AbstractSectionObject;
import com.scores365.entitys.dashboardSections.BuzzSection;
import com.scores365.entitys.dashboardSections.CompetitionDetailsSection;
import com.scores365.entitys.dashboardSections.GroupsSection;
import com.scores365.entitys.dashboardSections.HighlightsSection;
import com.scores365.entitys.dashboardSections.HistoryAndTeamsSection;
import com.scores365.entitys.dashboardSections.NewsSection;
import com.scores365.entitys.dashboardSections.OlympicsLegendsSection;
import com.scores365.entitys.dashboardSections.OlympicsMedalsSection;
import com.scores365.entitys.dashboardSections.OutrightsSection;
import com.scores365.entitys.dashboardSections.PlayersListSection;
import com.scores365.entitys.dashboardSections.RuntimeTypeAdapterFactory;
import com.scores365.entitys.dashboardSections.ScoresSection;
import com.scores365.entitys.dashboardSections.SocialSection;
import com.scores365.entitys.dashboardSections.SquadSection;
import com.scores365.entitys.dashboardSections.StandingsSection;
import com.scores365.entitys.dashboardSections.StatsSection;
import com.scores365.entitys.dashboardSections.TopScorerSection;
import com.scores365.entitys.dashboardSections.TransfersSection;
import com.scores365.ui.GeneralNotificationListFragment;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import li.x0;
/* loaded from: classes2.dex */
public class GsonManager {
    private static Gson defaultGson;
    private static Gson gson;
    private static Gson gsonBrandingData;
    private static final Object lock = new Object();

    /* loaded from: classes2.dex */
    public static class ArrayListTypeAdapterFactory implements x {
        private <E> TypeAdapter<ArrayList<E>> newArrayListAdapter(final TypeAdapter<E> typeAdapter) {
            return new TypeAdapter<ArrayList<E>>() { // from class: com.scores365.entitys.GsonManager.ArrayListTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public ArrayList<E> read(s9.a aVar) {
                    ArrayList<E> arrayList = new ArrayList<>();
                    if (aVar.s0() == s9.b.NULL) {
                        aVar.Y();
                    }
                    try {
                        aVar.a();
                        while (aVar.n()) {
                            arrayList.add(typeAdapter.read(aVar));
                        }
                        aVar.g();
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                    return arrayList;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(s9.c cVar, ArrayList<E> arrayList) {
                }
            };
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != ArrayList.class) {
                return null;
            }
            return newArrayListAdapter(gson.p(com.google.gson.reflect.a.get(((ParameterizedType) aVar.getType()).getActualTypeArguments()[0])));
        }
    }

    /* loaded from: classes2.dex */
    public static class CompetitorTypeDeserializer implements i<CompObj.eCompetitorType> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.i
        public CompObj.eCompetitorType deserialize(j jVar, Type type, h hVar) {
            return CompObj.eCompetitorType.create(jVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class DateDeserializer implements i<Date> {
        private DateDeserializer() {
        }

        @Override // com.google.gson.i
        public Date deserialize(j jVar, Type type, h hVar) {
            try {
                String h10 = jVar.h();
                if (h10.contains(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                    h10 = h10.substring(0, 10) + " " + h10.substring(11);
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.US);
                ParsePosition parsePosition = new ParsePosition(0);
                parsePosition.setIndex(0);
                parsePosition.setErrorIndex(-1);
                return parsePosition.getErrorIndex() != -1 ? new SimpleDateFormat("dd-MM-yyyy").parse(h10, parsePosition) : simpleDateFormat.parse(h10, parsePosition);
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class EventTypeLinkedHashMapTypeAdapter extends TypeAdapter<LinkedHashMap<Integer, EventTypeObj>> {
        @Override // com.google.gson.TypeAdapter
        public LinkedHashMap<Integer, EventTypeObj> read(s9.a aVar) {
            LinkedHashMap<Integer, EventTypeObj> linkedHashMap = new LinkedHashMap<>();
            try {
                aVar.a();
                int i10 = 0;
                while (aVar.n()) {
                    try {
                        EventTypeObj eventTypeObj = (EventTypeObj) GsonManager.gson.o(aVar, EventTypeObj.class);
                        int i11 = i10 + 1;
                        eventTypeObj.EventNum = i10;
                        linkedHashMap.put(Integer.valueOf(i10), eventTypeObj);
                        i10 = i11;
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
                aVar.g();
            } catch (IOException e11) {
                x0.N1(e11);
            }
            return linkedHashMap;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(s9.c cVar, LinkedHashMap<Integer, EventTypeObj> linkedHashMap) {
        }
    }

    /* loaded from: classes2.dex */
    public static class HashMapTypeAdapterFactory implements x {
        private <K, V> TypeAdapter<HashMap<K, Object>> newHashMapAdapter(final Class<K> cls, final TypeAdapter<V> typeAdapter) {
            return new TypeAdapter<HashMap<K, Object>>() { // from class: com.scores365.entitys.GsonManager.HashMapTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public HashMap<K, Object> read(s9.a aVar) {
                    HashMap<K, Object> hashMap = new HashMap<>();
                    aVar.a();
                    while (aVar.n()) {
                        try {
                            Object read = typeAdapter.read(aVar);
                            hashMap.put(cls.cast(((IGsonEntity) read).getKey()), read);
                        } catch (IOException e10) {
                            x0.N1(e10);
                        }
                    }
                    aVar.g();
                    return hashMap;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(s9.c cVar, HashMap<K, Object> hashMap) {
                }
            };
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != HashMap.class) {
                return null;
            }
            return newHashMapAdapter((Class) ((ParameterizedType) aVar.getType()).getActualTypeArguments()[0], gson.p(com.google.gson.reflect.a.get(((ParameterizedType) aVar.getType()).getActualTypeArguments()[1])));
        }
    }

    /* loaded from: classes2.dex */
    public static class HashSetTypeAdapterFactory implements x {
        private <E> TypeAdapter<HashSet<E>> newHashSetAdapter(final TypeAdapter<E> typeAdapter) {
            return new TypeAdapter<HashSet<E>>() { // from class: com.scores365.entitys.GsonManager.HashSetTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public HashSet<E> read(s9.a aVar) {
                    HashSet<E> hashSet = new HashSet<>();
                    aVar.a();
                    while (aVar.n()) {
                        try {
                            hashSet.add(typeAdapter.read(aVar));
                        } catch (k | s | IOException e10) {
                            x0.N1(e10);
                        }
                    }
                    aVar.g();
                    return hashSet;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(s9.c cVar, HashSet<E> hashSet) {
                }
            };
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != HashSet.class) {
                return null;
            }
            return newHashSetAdapter(gson.p(com.google.gson.reflect.a.get(((ParameterizedType) aVar.getType()).getActualTypeArguments()[0])));
        }
    }

    /* loaded from: classes2.dex */
    public static class HashTableTypeAdapterFactory implements x {
        private <K, V> TypeAdapter<Hashtable<K, Object>> newHashTableAdapter(final Class<K> cls, final TypeAdapter<V> typeAdapter) {
            return new TypeAdapter<Hashtable<K, Object>>() { // from class: com.scores365.entitys.GsonManager.HashTableTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public Hashtable<K, Object> read(s9.a aVar) {
                    Hashtable<K, Object> hashtable = new Hashtable<>();
                    aVar.a();
                    while (aVar.n()) {
                        try {
                            Object read = typeAdapter.read(aVar);
                            hashtable.put(cls.cast(((IGsonEntity) read).getKey()), read);
                        } catch (IOException e10) {
                            x0.N1(e10);
                        }
                    }
                    aVar.g();
                    return hashtable;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(s9.c cVar, Hashtable<K, Object> hashtable) {
                }
            };
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != Hashtable.class) {
                return null;
            }
            return newHashTableAdapter((Class) ((ParameterizedType) aVar.getType()).getActualTypeArguments()[0], gson.p(com.google.gson.reflect.a.get(((ParameterizedType) aVar.getType()).getActualTypeArguments()[1])));
        }
    }

    /* loaded from: classes2.dex */
    public static class LinkedHashMapTypeAdapterFactory implements x {
        private <K, V> TypeAdapter<LinkedHashMap<K, Object>> newLinkedHashMapAdapter(final Class<K> cls, final TypeAdapter<V> typeAdapter) {
            return new TypeAdapter<LinkedHashMap<K, Object>>() { // from class: com.scores365.entitys.GsonManager.LinkedHashMapTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public LinkedHashMap<K, Object> read(s9.a aVar) {
                    LinkedHashMap<K, Object> linkedHashMap = new LinkedHashMap<>();
                    aVar.a();
                    while (aVar.n()) {
                        try {
                            Object read = typeAdapter.read(aVar);
                            linkedHashMap.put(cls.cast(((IGsonEntity) read).getKey()), read);
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                    aVar.g();
                    return linkedHashMap;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(s9.c cVar, LinkedHashMap<K, Object> linkedHashMap) {
                }
            };
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != LinkedHashMap.class) {
                return null;
            }
            return newLinkedHashMapAdapter((Class) ((ParameterizedType) aVar.getType()).getActualTypeArguments()[0], gson.p(com.google.gson.reflect.a.get(((ParameterizedType) aVar.getType()).getActualTypeArguments()[1])));
        }
    }

    /* loaded from: classes2.dex */
    public static class NewsObjTypeAdapter extends TypeAdapter<NewsObj> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public NewsObj read(s9.a aVar) {
            try {
                m e10 = l.a(aVar).e();
                LinkedHashMap linkedHashMap = (LinkedHashMap) GsonManager.getGson().i(e10.p("NewsSources"), new com.google.gson.reflect.a<LinkedHashMap<Integer, SourceObj>>() { // from class: com.scores365.entitys.GsonManager.NewsObjTypeAdapter.1
                }.getType());
                ItemObj[] itemObjArr = (ItemObj[]) GsonManager.getGson().h(e10.p("Items"), ItemObj[].class);
                j p10 = e10.p("NewsType");
                String h10 = p10 != null ? p10.h() : "";
                LinkedHashMap linkedHashMap2 = (LinkedHashMap) GsonManager.getGson().i(e10.p("ExtraItems"), new com.google.gson.reflect.a<LinkedHashMap<Integer, ItemObj>>() { // from class: com.scores365.entitys.GsonManager.NewsObjTypeAdapter.2
                }.getType());
                NewsObj.Paging paging = (NewsObj.Paging) GsonManager.getGson().h(e10.p("Paging"), NewsObj.Paging.class);
                NewsObj.setItemsRelative(itemObjArr, linkedHashMap2, linkedHashMap);
                Hashtable hashtable = e10.t("Competitors") ? (Hashtable) GsonManager.getGson().i(e10.p("Competitors"), new com.google.gson.reflect.a<Hashtable<Integer, CompObj>>() { // from class: com.scores365.entitys.GsonManager.NewsObjTypeAdapter.3
                }.getType()) : null;
                NewsObj newsObj = new NewsObj(itemObjArr, linkedHashMap, h10, linkedHashMap2, paging);
                newsObj.setCompetitorById(hashtable);
                return newsObj;
            } catch (Exception e11) {
                x0.N1(e11);
                return null;
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(s9.c cVar, NewsObj newsObj) {
        }
    }

    /* loaded from: classes2.dex */
    public static class ScoresObjArrayTypeAdapter extends TypeAdapter<ScoreObj[]> {
        @Override // com.google.gson.TypeAdapter
        public ScoreObj[] read(s9.a aVar) {
            ScoreObj[] scoreObjArr = null;
            try {
                List list = (List) GsonManager.gson.o(aVar, new com.google.gson.reflect.a<ArrayList<Double>>() { // from class: com.scores365.entitys.GsonManager.ScoresObjArrayTypeAdapter.1
                }.getType());
                scoreObjArr = new ScoreObj[list.size()];
                for (int i10 = 0; i10 < list.size(); i10++) {
                    scoreObjArr[i10] = new ScoreObj(((Double) list.get(i10)).doubleValue());
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return scoreObjArr;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(s9.c cVar, ScoreObj[] scoreObjArr) {
        }
    }

    /* loaded from: classes2.dex */
    public static class SportTypeTypeAdapterFactory implements x {
        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            try {
                final TypeAdapter<T> r10 = gson.r(this, aVar);
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == SportTypeObj.class) {
                    return new TypeAdapter<T>() { // from class: com.scores365.entitys.GsonManager.SportTypeTypeAdapterFactory.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.google.gson.TypeAdapter
                        public T read(s9.a aVar2) {
                            Exception e10;
                            SportTypeObj sportTypeObj;
                            T t10;
                            try {
                                sportTypeObj = (SportTypeObj) r10.read(aVar2);
                            } catch (Exception e11) {
                                e10 = e11;
                                sportTypeObj = null;
                            }
                            try {
                                LinkedHashMap<Integer, EventTypeObj> linkedHashMap = new LinkedHashMap<>();
                                for (EventTypeObj eventTypeObj : sportTypeObj.getEventTypes().values()) {
                                    linkedHashMap.put(Integer.valueOf(eventTypeObj.EventNum), eventTypeObj);
                                }
                                sportTypeObj.setEventTypesPerIndex(linkedHashMap);
                                t10 = sportTypeObj;
                            } catch (Exception e12) {
                                e10 = e12;
                                x0.N1(e10);
                                t10 = sportTypeObj;
                                return t10;
                            }
                            return t10;
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void write(s9.c cVar, T t10) {
                        }
                    };
                }
                if (rawType == TransfersObj.class) {
                    return new TypeAdapter<T>() { // from class: com.scores365.entitys.GsonManager.SportTypeTypeAdapterFactory.2
                        /* JADX WARN: Type inference failed for: r6v2, types: [T, com.scores365.entitys.TransfersObj] */
                        @Override // com.google.gson.TypeAdapter
                        public T read(s9.a aVar2) {
                            ArrayList<ItemObj> arrayList;
                            ?? r62 = (TransfersObj) r10.read(aVar2);
                            try {
                                LinkedHashMap<Integer, TransferObj> linkedHashMap = r62.transfersById;
                                if (linkedHashMap != null) {
                                    for (TransferObj transferObj : linkedHashMap.values()) {
                                        if (transferObj != null && (arrayList = transferObj.relativeArticles) != null) {
                                            Iterator<ItemObj> it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                ItemObj next = it.next();
                                                if (next != null) {
                                                    try {
                                                        next.setSourceObj(r62.sourceObjById.get(Integer.valueOf(next.getSourceID())));
                                                    } catch (Exception e10) {
                                                        x0.N1(e10);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e11) {
                                x0.N1(e11);
                            }
                            return r62;
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void write(s9.c cVar, T t10) {
                        }
                    };
                }
                return null;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class VectorTypeAdapterFactory implements x {
        private <E> TypeAdapter<Vector<E>> newVectorAdapter(final TypeAdapter<E> typeAdapter) {
            return new TypeAdapter<Vector<E>>() { // from class: com.scores365.entitys.GsonManager.VectorTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public Vector<E> read(s9.a aVar) {
                    Vector<E> vector = new Vector<>();
                    aVar.a();
                    while (aVar.n()) {
                        try {
                            vector.add(typeAdapter.read(aVar));
                        } catch (k | s | IOException e10) {
                            x0.N1(e10);
                        }
                    }
                    aVar.g();
                    return vector;
                }

                @Override // com.google.gson.TypeAdapter
                public void write(s9.c cVar, Vector<E> vector) {
                }
            };
        }

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> create(Gson gson, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() != Vector.class) {
                return null;
            }
            return newVectorAdapter(gson.p(com.google.gson.reflect.a.get(((ParameterizedType) aVar.getType()).getActualTypeArguments()[0])));
        }
    }

    public static Gson getDefaultGson() {
        if (defaultGson == null) {
            synchronized (lock) {
                if (defaultGson == null) {
                    defaultGson = new e().b();
                }
            }
        }
        return defaultGson;
    }

    public static Gson getGson() {
        if (gson == null) {
            synchronized (lock) {
                if (gson == null) {
                    RuntimeTypeAdapterFactory registerSubtype = RuntimeTypeAdapterFactory.of(AbstractSectionObject.class, "SType").registerSubtype(ScoresSection.class, AppEventsConstants.EVENT_PARAM_VALUE_YES).registerSubtype(NewsSection.class, "2").registerSubtype(HighlightsSection.class, GeneralNotificationListFragment.ANALYTICS_ENTITY_TYPE_SPORT_TYPE).registerSubtype(TransfersSection.class, "12").registerSubtype(StandingsSection.class, "7").registerSubtype(StatsSection.class, "15").registerSubtype(GroupsSection.class, "8").registerSubtype(TopScorerSection.class, "11").registerSubtype(PlayersListSection.class, "9").registerSubtype(SocialSection.class, "4").registerSubtype(StandingsSection.class, "14").registerSubtype(OlympicsLegendsSection.class, "17").registerSubtype(OlympicsMedalsSection.class, "16").registerSubtype(SquadSection.class, "10").registerSubtype(CompetitionDetailsSection.class, "20").registerSubtype(HistoryAndTeamsSection.class, "21").registerSubtype(OutrightsSection.class, "22").registerSubtype(BuzzSection.class, "100");
                    RuntimeTypeAdapterFactory registerSubtype2 = RuntimeTypeAdapterFactory.of(nd.c.class, "Type").registerSubtype(nd.a.class, AppEventsConstants.EVENT_PARAM_VALUE_YES).registerSubtype(nd.b.class, GeneralNotificationListFragment.ANALYTICS_ENTITY_TYPE_SPORT_TYPE);
                    Type type = new com.google.gson.reflect.a<ScoreObj[]>() { // from class: com.scores365.entitys.GsonManager.1
                    }.getType();
                    gson = new e().d(registerSubtype).c(NewsObj.class, new NewsObjTypeAdapter()).c(type, new ScoresObjArrayTypeAdapter()).d(new SportTypeTypeAdapterFactory()).d(registerSubtype2).d(new HashTableTypeAdapterFactory()).d(new VectorTypeAdapterFactory()).d(new HashMapTypeAdapterFactory()).d(new ArrayListTypeAdapterFactory()).d(new LinkedHashMapTypeAdapterFactory()).d(new HashSetTypeAdapterFactory()).c(Date.class, new DateDeserializer()).c(CompObj.eCompetitorType.class, new CompetitorTypeDeserializer()).c(new com.google.gson.reflect.a<LinkedHashMap<Integer, EventTypeObj>>() { // from class: com.scores365.entitys.GsonManager.2
                    }.getType(), new EventTypeLinkedHashMapTypeAdapter()).b();
                }
            }
        }
        return gson;
    }

    public static Gson gsonBrandingData() {
        if (gsonBrandingData == null) {
            synchronized (lock) {
                if (gsonBrandingData == null) {
                    gsonBrandingData = new e().d(new LinkedHashMapTypeAdapterFactory()).b();
                }
            }
        }
        return gsonBrandingData;
    }
}
