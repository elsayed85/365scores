package com.scores365.entitys;

import ag.u1;
import java.io.Serializable;
import java.util.Date;
import li.x0;
/* loaded from: classes2.dex */
public class VideoObj implements Serializable {
    private static final long serialVersionUID = -1115050136807292854L;
    @p9.c("Caption")
    private String caption;
    @p9.c("Comp")
    private String comp;
    @p9.c("Comps")
    private CompObj[] comps;
    @p9.c("CreateTime")
    public Date createTime;
    @p9.c("GT")
    private int gt;
    @p9.c("MobileID")
    private String mobileId;
    @p9.c("RequireDisclaimer")
    private boolean requireDisclaimer;
    @p9.c("STime")
    private Date sTime;
    @p9.c("Score")
    private String score;
    @p9.c("ScoreSeq")
    private int scoreSeq;
    @p9.c("ShowOnMain")
    private boolean showOnMain;
    @p9.c("SID")
    private int sportId;
    @p9.c("Thumbnail")
    private String thumbnail;
    @p9.c("VType")
    private int type;
    @p9.c("URL")
    private String url;
    @p9.c("VID")
    private String vid;
    @p9.c("Src")
    public int videoSource;
    @p9.c("EventType")
    public int eventType = -1;
    @p9.c("EventNum")
    public int eventNum = -1;
    @p9.c("EmbeddingAllowed")
    private boolean embeddingAllowed = true;

    private String vidFromYouTubeOnly() {
        String str = this.vid;
        return (str == null || str.isEmpty()) ? u1.m(this.url) : this.vid;
    }

    public String getCaption() {
        return this.caption;
    }

    public String getComp() {
        return this.comp;
    }

    public CompObj[] getComps() {
        return this.comps;
    }

    public int getGT() {
        return this.gt;
    }

    public String getMobileID() {
        return this.mobileId;
    }

    public Date getSTime() {
        return this.sTime;
    }

    public String getScore() {
        return this.score;
    }

    public int getScoreSEQ() {
        return this.scoreSeq;
    }

    public int getSportID() {
        return this.sportId;
    }

    public String getThumbnail() {
        String str = this.thumbnail;
        if (str == null || str.isEmpty()) {
            if (this.url.contains("dailymotion.com")) {
                return "http://www.dailymotion.com/thumbnail/video/" + this.vid;
            } else if (this.url.contains("youtube.com")) {
                return "http://img.youtube.com/vi/" + vidFromYouTubeOnly() + "/0.jpg";
            } else {
                return str;
            }
        }
        return str;
    }

    public int getType() {
        return this.type;
    }

    public String getURL() {
        return this.url;
    }

    public String getVid() {
        return this.vid;
    }

    public String getVideoIdForAnalytics() {
        String vid = getVid();
        if (vid != null) {
            try {
                if (!vid.isEmpty()) {
                    return vid;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return vid;
            }
        }
        return getURL();
    }

    public boolean isEmbeddingAllowed() {
        return this.embeddingAllowed;
    }

    public boolean isRequireDisclaimer() {
        return this.requireDisclaimer;
    }

    public boolean isShowOnMain() {
        return this.showOnMain;
    }

    public boolean isVideoSupportEmbedding() {
        try {
            return this.url.contains("youtube");
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
