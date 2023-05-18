package com.scores365.bets.model;

import androidx.annotation.NonNull;
import com.scores365.entitys.BaseObj;
import java.util.ArrayList;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BookMakerObj extends BaseObj {
    @c("ActionButton")
    public BookmakerActionButton actionButton;
    @c("Disclaimer")
    public BookmakerDisclaimer disclaimer;
    @c("Offers")
    public ArrayList<BookmakerOfferObj> offers;
    @c("Sponsored")
    public boolean sponsored;
    @c("Tag")
    public String tag;
    @c("URL")
    private String url;
    private String urlProcessed;
    @c("UseDeepestLink")
    public boolean useDeepestLink;
    @c("ShowLinksInBrowser")
    public boolean showLinksInBrowser = false;
    @c("ImgVer")
    private int imgVer = -1;
    @c("Color")
    public String color = "";
    @c("SecondaryColor")
    public String secondaryColor = "";
    @c("PromotionTextColor")
    public String promotionTextColor = "";
    @c("CTATextColor")
    public String CTATextColor = "";
    @c("CTABGColor")
    public String CTABGColor = "";
    @c("LiveColor")
    public String liveColor = "";
    @c("GeneralTextColor")
    public String generalTextColor = "";
    @c("PromotionText")
    public String promotionText = "";
    @c("CTAText")
    public String CTAText = "";

    public String getActionButtonClickUrl() {
        ExtraContext[] extraContextArr;
        ExtraContext extraContext;
        try {
            BookmakerActionButton bookmakerActionButton = this.actionButton;
            return (bookmakerActionButton == null || (extraContextArr = bookmakerActionButton.extraContexts) == null || extraContextArr.length <= 0 || (extraContext = extraContextArr[0]) == null || extraContext.getUrl() == null) ? this.actionButton.getUrl() : this.actionButton.extraContexts[0].getUrl();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getActionButtonClickUrlWithSpecificContext(String str) {
        BookmakerActionButton bookmakerActionButton;
        ExtraContext extraContext;
        String str2 = "";
        try {
            BookmakerActionButton bookmakerActionButton2 = this.actionButton;
            if (bookmakerActionButton2 != null && bookmakerActionButton2.extraContexts != null && (extraContext = bookmakerActionButton2.getExtraContextsByContextName().get(str)) != null) {
                str2 = extraContext.getUrl();
            }
            return (!str2.isEmpty() || (bookmakerActionButton = this.actionButton) == null) ? str2 : bookmakerActionButton.getUrl();
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getColor() {
        return this.color;
    }

    public String getImgVer() {
        return String.valueOf(this.imgVer);
    }

    public String getUrl() {
        if (this.urlProcessed == null) {
            this.urlProcessed = x0.W0(this.url);
        }
        x0.E1("oddsClickFea", "BookMakerObj.getUrl urlProcessed: " + this.urlProcessed);
        return this.urlProcessed;
    }

    @NonNull
    public String toString() {
        return "BMObj{name=" + this.name + ", url='" + this.url + "', tag='" + this.tag + "', CTAText='" + this.CTAText + "', promotionText='" + this.promotionText + "', \noffers=" + this.offers + "\n, actionButton=" + this.actionButton + ", disclaimer=" + this.disclaimer + ", imgVer=" + this.imgVer + ", color='" + this.color + "', secondaryColor='" + this.secondaryColor + "', promotionTextColor='" + this.promotionTextColor + "', CTATextColor='" + this.CTATextColor + "', CTABGColor='" + this.CTABGColor + "', liveColor='" + this.liveColor + "', generalTextColor='" + this.generalTextColor + "', url='" + this.url + "', urlProcessed='" + this.urlProcessed + "', showLinksInBrowser=" + this.showLinksInBrowser + ", useDeepestLink=" + this.useDeepestLink + ", sponsored=" + this.sponsored + '}';
    }
}
