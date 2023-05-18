package com.scores365.ui.playerCard;

import com.scores365.Pages.r;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.SocialStatEntity;
import com.scores365.entitys.SourceObj;
import com.scores365.entitys.TransfersObj;
import com.scores365.entitys.eDashboardSection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import li.x0;
/* loaded from: classes2.dex */
public class SinglePlayerBuzzPageCreator extends com.scores365.Design.Pages.b {
    private int athleteId;
    private NewsObj buzzData;
    public eDashboardSection currentSection;
    private String emptyMsg;
    private lf.c filterObj;
    private boolean isFromNotification;
    private ArrayList<ItemObj> newsItems;
    private String newsType;
    private String nextPage;
    public LinkedHashSet<jf.b> pagesTypeSet;
    private int promotedItem;
    private String refreshPage;
    private int scope;
    private boolean showAds;
    private boolean showDirectDealsAds;
    private ArrayList<SocialStatEntity> socialStatEntities;
    private Hashtable<Integer, SourceObj> sourceNewsById;
    private TransfersObj transfersObj;

    public SinglePlayerBuzzPageCreator(String str, String str2, sc.i iVar, boolean z10, String str3, NewsObj newsObj, String str4, int i10, boolean z11, boolean z12, boolean z13, ArrayList<SocialStatEntity> arrayList, int i11, int i12, LinkedHashSet<jf.b> linkedHashSet, NewsObj newsObj2, TransfersObj transfersObj) {
        super(str, str2, iVar, z10, str3);
        this.buzzData = newsObj;
        this.showAds = z12;
        this.emptyMsg = str4;
        this.scope = i10;
        this.isFromNotification = z11;
        this.showDirectDealsAds = z13;
        this.socialStatEntities = arrayList;
        this.athleteId = i11;
        this.promotedItem = i12;
        this.pagesTypeSet = linkedHashSet;
        this.transfersObj = transfersObj;
        this.currentSection = linkedHashSet.size() > 0 ? linkedHashSet.iterator().next().f32663a : null;
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i11));
        this.filterObj = new lf.c(new HashSet(), new HashSet(), new HashSet(), hashSet);
        if (newsObj2 != null) {
            try {
                this.newsItems = new ArrayList<>(Arrays.asList(newsObj2.getItems()));
                this.sourceNewsById = new Hashtable<>(newsObj2.getSources());
                this.newsType = newsObj2.newsType;
                this.nextPage = newsObj2.getNextPage();
                this.refreshPage = newsObj2.getRefreshPage();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @Override // com.scores365.Design.Pages.b
    public com.scores365.Design.Pages.a CreatePage() {
        eDashboardSection edashboardsection = this.currentSection;
        return edashboardsection == eDashboardSection.NEWS ? r.B1(this.newsItems, this.sourceNewsById, "", this.filterObj, this.newsType, null, this.nextPage, this.refreshPage, null, "", false, sc.i.SingleNews, false, this.pageKey, false) : edashboardsection == eDashboardSection.TRANSFERS ? jd.e.T1(this.transfersObj, this.filterObj, this.title, this.iconLink, null, false, this.placement, this.pageKey) : PlayerBuzzPage.newInstance(this.buzzData, this.isFromNotification, -1, null, this.promotedItem, this.emptyMsg, this.pageKey, this.scope, this.showAds, this.showDirectDealsAds, this.socialStatEntities, this.athleteId);
    }

    @Override // com.scores365.Design.Pages.b
    public eDashboardSection getDashboardSection() {
        return eDashboardSection.BUZZ;
    }

    @Override // com.scores365.Design.Pages.b
    public Object updateData(Object obj) {
        super.updateData(obj);
        this.buzzData = (NewsObj) obj;
        return obj;
    }
}
