package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import li.x0;
/* loaded from: classes2.dex */
public class TvNetworkObj extends BaseObj {
    private static final long serialVersionUID = 6861545028824904592L;
    @p9.c("CountryID")
    public int CountryId;
    @p9.c("NetworkType")
    public int Type;
    @p9.c("Website")
    public String WebSite;
    @p9.c("NetworkID")
    public int networkId;
    @p9.c("Links")
    public ArrayList<tvNetworkLink> tvLinks = null;
    @p9.c("Bookmaker")
    public int bookmaker = -1;
    @p9.c("HideLogo")
    public boolean hideLogo = false;
    @p9.c("ImgVer")
    private int imgVer = -1;

    /* loaded from: classes2.dex */
    public enum eLiveStreamType {
        NONE(0),
        YOUTUBE(4),
        TWITCH(5);
        
        private int value;

        eLiveStreamType(int i10) {
            this.value = i10;
        }

        public static eLiveStreamType Create(int i10) {
            if (i10 == 4) {
                return YOUTUBE;
            }
            if (i10 == 5) {
                return TWITCH;
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public enum eTvNetworkLinkType {
        NON_STREAM,
        STREAM,
        AD
    }

    /* loaded from: classes2.dex */
    public static class tvNetworkLink implements Serializable {
        @p9.c("BroadcastType")
        public int broadcastType = -1;
        @p9.c("Link")
        private String link;
        private String linkProcessed;
        @p9.c("LinkType")
        public int networkType;

        public static eTvNetworkLinkType create(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 4 ? eTvNetworkLinkType.NON_STREAM : eTvNetworkLinkType.AD : eTvNetworkLinkType.STREAM : eTvNetworkLinkType.NON_STREAM;
        }

        public static eLiveStreamType createLiveType(int i10) {
            return i10 != 4 ? i10 != 5 ? eLiveStreamType.NONE : eLiveStreamType.TWITCH : eLiveStreamType.YOUTUBE;
        }

        public int getBroadcastType() {
            return this.broadcastType;
        }

        public String getLineLink() {
            if (this.linkProcessed == null) {
                this.linkProcessed = x0.W0(this.link);
            }
            x0.E1("oddsClickFea", "TvNetworkObj.tvNetworkLink linkProcessed: " + this.linkProcessed);
            return this.linkProcessed;
        }

        public eTvNetworkLinkType getNetworkType() {
            return create(this.networkType);
        }

        public boolean isLiveStreamingType() {
            try {
                return getNetworkType() == eTvNetworkLinkType.STREAM;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public boolean isTwitch() {
            try {
                return createLiveType(getBroadcastType()) == eLiveStreamType.TWITCH;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }

        public boolean isYoutube() {
            try {
                return createLiveType(getBroadcastType()) == eLiveStreamType.YOUTUBE;
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
    }

    public int getCountryId() {
        return this.CountryId;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public ArrayList<tvNetworkLink> getTvLinks() {
        return this.tvLinks;
    }

    public int getType() {
        return this.Type;
    }

    public String getWebSite() {
        return this.WebSite;
    }

    public boolean isLiveStream() {
        return this.tvLinks.get(0).isLiveStreamingType();
    }

    public boolean isStoryNetworkId() {
        return this.f23582id == 6347 || this.networkId == 6347;
    }
}
