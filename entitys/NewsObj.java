package com.scores365.entitys;

import com.scores365.api.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class NewsObj implements Serializable {
    @p9.c("Competitors")
    public Hashtable<Integer, CompObj> competitorById;
    @p9.c("ExtraItems")
    public LinkedHashMap<Integer, ItemObj> extraItems;
    @p9.c("Items")
    private ItemObj[] items;
    @p9.c("NewsType")
    public String newsType;
    @p9.c("Paging")
    public Paging paging;
    @p9.c("NewsSources")
    private LinkedHashMap<Integer, SourceObj> sources;

    /* loaded from: classes2.dex */
    public static class Paging implements Serializable {
        @p9.c("RefreshPage")
        public String refreshPage = "";
        @p9.c("BasePage")
        public String basePage = "";
        @p9.c("NextPage")
        public String nextPage = "";
        @p9.c("UpdatesPage")
        public String updatePage = "";
        @p9.c("PreviousPage")
        public String previousPage = "";
        @p9.c("FullPage")
        public String fullPage = "";
    }

    public NewsObj() {
        this.newsType = "";
        this.paging = new Paging();
    }

    public NewsObj(ItemObj[] itemObjArr, LinkedHashMap<Integer, SourceObj> linkedHashMap, String str, LinkedHashMap<Integer, ItemObj> linkedHashMap2, Paging paging) {
        this.newsType = "";
        new Paging();
        this.items = itemObjArr;
        this.sources = linkedHashMap;
        this.newsType = str;
        this.extraItems = linkedHashMap2;
        this.paging = paging;
        w.n(itemObjArr, linkedHashMap);
    }

    public static void setItemsRelative(ItemObj[] itemObjArr, LinkedHashMap<Integer, ItemObj> linkedHashMap, HashMap<Integer, SourceObj> hashMap) {
        try {
            HashMap hashMap2 = new HashMap();
            for (ItemObj itemObj : itemObjArr) {
                hashMap2.put(Integer.valueOf(itemObj.getID()), itemObj);
            }
            if (linkedHashMap != null) {
                for (ItemObj itemObj2 : linkedHashMap.values()) {
                    if (hashMap.containsKey(Integer.valueOf(itemObj2.getSourceID()))) {
                        itemObj2.setSourceObj(hashMap.get(Integer.valueOf(itemObj2.getSourceID())));
                    }
                }
            }
            if (linkedHashMap != null) {
                for (ItemObj itemObj3 : itemObjArr) {
                    Iterator<Integer> it = itemObj3.relatedNewsIds.iterator();
                    while (it.hasNext()) {
                        Integer next = it.next();
                        if (hashMap2.containsKey(next)) {
                            itemObj3.extraItems.put(next, (ItemObj) hashMap2.get(next));
                        } else if (linkedHashMap.containsKey(next)) {
                            itemObj3.extraItems.put(next, linkedHashMap.get(next));
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public ItemObj[] getItems() {
        return this.items;
    }

    public String getNewsType() {
        return this.newsType;
    }

    public String getNextPage() {
        return this.paging.nextPage;
    }

    public String getRefreshPage() {
        return this.paging.refreshPage;
    }

    public SourceObj getSourceForItem(ItemObj itemObj) {
        SourceObj sourceObj = this.sources.get(Integer.valueOf(itemObj.getSourceID()));
        return sourceObj == null ? new SourceObj() : sourceObj;
    }

    public LinkedHashMap<Integer, SourceObj> getSources() {
        return this.sources;
    }

    public void mergeNewsObj(NewsObj newsObj) {
        ItemObj[] itemObjArr;
        ItemObj[] itemObjArr2;
        try {
            this.sources.putAll(newsObj.getSources());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (ItemObj itemObj : newsObj.items) {
                linkedHashMap.put(Integer.valueOf(itemObj.getID()), itemObj);
            }
            for (ItemObj itemObj2 : this.items) {
                linkedHashMap.put(Integer.valueOf(itemObj2.getID()), itemObj2);
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.values());
            this.items = new ItemObj[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                this.items[i10] = (ItemObj) arrayList.get(i10);
            }
            if (this.extraItems == null) {
                this.extraItems = new LinkedHashMap<>();
            }
            LinkedHashMap<Integer, ItemObj> linkedHashMap2 = newsObj.extraItems;
            if (linkedHashMap2 != null) {
                this.extraItems.putAll(linkedHashMap2);
            }
            String str = newsObj.paging.nextPage;
            if (str != null && !str.isEmpty()) {
                this.paging.nextPage = newsObj.paging.nextPage;
            }
            String str2 = newsObj.paging.refreshPage;
            if (str2 != null && !str2.isEmpty()) {
                this.paging.refreshPage = newsObj.paging.refreshPage;
            }
            String str3 = newsObj.paging.basePage;
            if (str3 != null && !str3.isEmpty()) {
                this.paging.basePage = newsObj.paging.basePage;
            }
            String str4 = newsObj.paging.updatePage;
            if (str4 == null || str4.isEmpty()) {
                return;
            }
            this.paging.updatePage = newsObj.paging.updatePage;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setCompetitorById(Hashtable<Integer, CompObj> hashtable) {
        this.competitorById = hashtable;
    }
}
