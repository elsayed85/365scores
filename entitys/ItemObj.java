package com.scores365.entitys;

import android.net.Uri;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import li.p0;
import li.x0;
import nf.e;
/* loaded from: classes2.dex */
public class ItemObj implements Serializable, IGsonEntity<Integer> {
    private static final String KALTURA_CONTENT_TYPE = "player/kaltura";
    private static final long serialVersionUID = -7880689671641138440L;
    @p9.c("AuthorImage")
    public ImageDetailObj authorImage;
    @p9.c("ContentURL")
    private String contentUrl;
    @p9.c("EntitiesConnection")
    private EntityConnection[] entitys;
    @p9.c("HasVideo")
    private boolean hasVideo;
    @p9.c("ID")

    /* renamed from: id  reason: collision with root package name */
    private int f23591id;
    @p9.c("ImageSource")
    public String imageSource;
    @p9.c("Layout")
    private int layout;
    @p9.c("PublishTime")
    private Date publishTime;
    @p9.c("SocialStats")
    public SocialStatsObj socialStatsObj;
    @p9.c("SourceID")
    private int sourceID;
    private SourceObj sourceObj;
    @p9.c("Title")
    private String title;
    @p9.c("Transfer")
    public TransferObj transferObj;
    @p9.c("Type")
    private int type;
    @p9.c("Url")
    private String url;
    public boolean IsAdvObject = false;
    @p9.c("ImageWidth")
    public int ImageWidth = -1;
    @p9.c("ImageHeight")
    public int ImageHeight = -1;
    @p9.c("Description")
    private String description = "";
    @p9.c("RawHTML")
    public String RawHTML = "";
    @p9.c("EditorialCaption")
    private String editorialCaption = "";
    @p9.c("ShareUrl")
    public String shareUrl = "";
    @p9.c("Author")
    private String author = "";
    @p9.c("LangID")
    public int newsLangId = 0;
    @p9.c("Summary")
    public String summary = "";
    @p9.c("ImgVer")
    private int imgVer = -1;
    @p9.c("SkipDetails")
    public boolean skipDetails = false;
    @p9.c("Videos")
    public ArrayList<NewsVideoObj> newsVideos = new ArrayList<>();
    @p9.c("Images")
    public ArrayList<ImageDetailObj> imagesList = new ArrayList<>();
    @p9.c("RequireDisclaimer")
    public boolean requireDisclaimer = true;
    @p9.c("DisclaimerType")
    public String disclaimerType = "";
    @p9.c("DisplayAuthor")
    public boolean displayAuthor = false;
    @p9.c("AllowReadMore")
    public boolean AllowReadMore = true;
    @p9.c("Related")
    public HashSet<Integer> relatedNewsIds = new HashSet<>();
    @p9.c("ExtraItems")
    public LinkedHashMap<Integer, ItemObj> extraItems = new LinkedHashMap<>();
    private String publishTimeString = "";

    public String getAuthor() {
        return this.author;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEditorialCaption() {
        return this.editorialCaption;
    }

    public EntityConnection[] getEntitys() {
        return this.entitys;
    }

    public boolean getHasVideo() {
        return this.hasVideo;
    }

    public int getID() {
        return this.f23591id;
    }

    public int getId() {
        return this.f23591id;
    }

    public String getImageSources() {
        return this.imageSource;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(getID());
    }

    public int getLayout() {
        return this.layout;
    }

    public nf.c getListItem(SourceObj sourceObj, int i10) {
        if (getType() == 9) {
            return new nf.a(this, sourceObj, true, i10);
        }
        ArrayList<ImageDetailObj> arrayList = this.imagesList;
        return (arrayList == null || arrayList.size() <= 0 || !p0.k(this.imagesList.get(0).width)) ? x0.l1() ? new e(this, sourceObj) : new nf.d(this, sourceObj) : new nf.a(this, sourceObj, false, i10);
    }

    public String getOriginalURL() {
        return this.url;
    }

    public Date getPublishTime() {
        return this.publishTime;
    }

    public String getPublishTimeString() {
        if (this.publishTimeString.isEmpty()) {
            this.publishTimeString = p0.a0(getPublishTime());
        }
        return this.publishTimeString;
    }

    public int getSourceID() {
        return this.sourceID;
    }

    public SourceObj getSourceObj() {
        return this.sourceObj;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getURL() {
        try {
            Uri parse = Uri.parse(this.url);
            Uri.Builder buildUpon = parse.buildUpon();
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (!queryParameterNames.contains("utm_source")) {
                buildUpon = buildUpon.appendQueryParameter("utm_source", "365Scores Mobile app");
            }
            if (!queryParameterNames.contains("utm_medium")) {
                buildUpon = buildUpon.appendQueryParameter("utm_medium", "Contact us for more traffic");
            }
            if (!queryParameterNames.contains("utm_campaign")) {
                buildUpon = buildUpon.appendQueryParameter("utm_campaign", "partners@365scores.com");
            }
            return buildUpon.build().toString();
        } catch (Exception e10) {
            String str = this.url;
            x0.N1(e10);
            return str;
        }
    }

    public String getUrlOfVideoToShow() {
        String str = null;
        try {
            Iterator<NewsVideoObj> it = this.newsVideos.iterator();
            while (it.hasNext()) {
                NewsVideoObj next = it.next();
                if (next.sticky != null) {
                    str = next.url;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public boolean hasSticky() {
        try {
            ArrayList<NewsVideoObj> arrayList = this.newsVideos;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<NewsVideoObj> it = this.newsVideos.iterator();
            while (it.hasNext()) {
                if (it.next().sticky.booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isBigImage() {
        try {
            ArrayList<ImageDetailObj> arrayList = this.imagesList;
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            return p0.k(this.imagesList.get(0).width);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isMissingRelatedItems() {
        return this.relatedNewsIds.size() != this.extraItems.size();
    }

    public boolean isNewsIdRTL() {
        try {
            int i10 = this.newsLangId;
            return i10 == 2 || i10 == 27;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void setSourceObj(SourceObj sourceObj) {
        this.sourceObj = sourceObj;
    }

    public boolean shouldShowVideo() {
        try {
            return getUrlOfVideoToShow() != null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public String toString() {
        StringBuilder sb2;
        StringBuilder sb3 = null;
        try {
            sb2 = new StringBuilder();
        } catch (Exception unused) {
        }
        try {
            sb2.append(this.f23591id);
            sb2.append("|");
            sb2.append(this.title);
            sb2.append("|");
            EntityConnection[] entityConnectionArr = this.entitys;
            if (entityConnectionArr != null) {
                for (EntityConnection entityConnection : entityConnectionArr) {
                    sb2.append(entityConnection.getEntityType());
                    sb2.append(" ");
                    sb2.append(entityConnection.getEntityID());
                    sb2.append(",");
                }
            }
        } catch (Exception unused2) {
            sb3 = sb2;
            sb3.append(super.toString());
            sb2 = sb3;
            return sb2.toString();
        }
        return sb2.toString();
    }
}
