package com.scores365.entitys;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Arrays;
import li.x0;
/* loaded from: classes2.dex */
public class GCMNotificationObj implements Serializable {
    public static int REPLACEMENT_BEHAVIOR_ONLY_REPLACE = 2;
    public static int REPLACEMENT_BEHAVIOR_REPLACE_OR_SHOW = 1;
    public static int REPLACEMENT_BEHAVIOR_SHOW = 0;
    public static int REPLACEMENT_SOUND_BEHAVIOR_NO_SOUND = 1;
    public static int REPLACEMENT_SOUND_BEHAVIOR_NO_SOUND_ON_REPLACE = 2;
    public static int REPLACEMENT_SOUND_BEHAVIOR_PLAY;
    @p9.c("Params")
    public NotificationsParamsObj[] NotificationsParams;
    @p9.c("PLAY_SOUND")
    private boolean PlaySound;
    @p9.c("SHOW_ICON")
    private boolean ShowIcon;
    @p9.c("ActionEdit")
    private String actionEdit;
    @p9.c("ActionMute")
    private String actionMute;
    @p9.c("AndroidGroupKey")
    private int androidGroupKey;
    @p9.c("AndroidGroupTitle")
    private String androidGroupTitle;
    @p9.c("AndroidTextForGroup")
    private String androidTextForGroup;
    @p9.c("Comp")
    private int competitionId;
    @p9.c("Comps")
    private int[] comps;
    @p9.c("Ent")
    private int entity;
    @p9.c("NID")

    /* renamed from: id  reason: collision with root package name */
    private int f23588id;
    @p9.c("IsVibrateOn")
    private boolean isVibrateOn;
    @p9.c("LangId")
    private int langId;
    private String notificationId;
    @p9.c("Text")
    private String text;
    @p9.c("Title")
    private String title;
    @p9.c("ADV_URL")
    private String URL = "";
    @p9.c("ADV_ID")
    private int ADV_ID = -1;
    @p9.c("Game")
    public NotificationGameObj Game = null;
    @p9.c("StatKey")
    private String statKey = "";
    @p9.c("Likes")
    private int likes = -1;
    @p9.c("Shares")
    private int shares = -1;
    @p9.c("ImgWidth")
    private int imgWidth = -1;
    @p9.c("ImgHeight")
    private int imgHeight = -1;
    @p9.c("ImgUrl")
    private String imgUrl = "";
    @p9.c("SkipDetails")
    private boolean skipDetails = false;
    @p9.c("Url")
    private String Url = "";
    @p9.c("ShareUrl")
    private String ShareUrl = "";
    @p9.c("hasLMT")
    private boolean hasLMT = false;
    @p9.c("Sound")
    private String sound = null;
    @p9.c("replacement-behavior")
    private int replacementBehavior = -1;
    @p9.c("replacement-key")
    private String replacementKey = "";
    @p9.c("replacement-sound-behavior")
    private int replacementSoundBehavior = -1;
    @p9.c("Screen")
    public String ScreenName = "";
    private boolean isFromNotification = false;
    private int randomNid = -1;

    public int GetAdvID() {
        return this.ADV_ID;
    }

    public String getActionEdit() {
        return this.actionEdit;
    }

    public String getActionMute() {
        return this.actionMute;
    }

    public String getAdvUrl() {
        return this.URL;
    }

    public int getAndroidGroupKey() {
        return this.androidGroupKey;
    }

    public String getAndroidGroupTitle() {
        return this.androidGroupTitle;
    }

    public String getAndroidTextForGroup() {
        return this.androidTextForGroup;
    }

    public int getCompetitionID() {
        return this.competitionId;
    }

    public int[] getComps() {
        return this.comps;
    }

    public int getEntity() {
        return this.entity;
    }

    public int getID() {
        return this.f23588id;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public String getItemId() {
        try {
            String param = getParam("PromotedItem");
            return param.isEmpty() ? String.valueOf(getEntity()) : param;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public int getLangId() {
        return this.langId;
    }

    public int getLikes() {
        return this.likes;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public String getParam(String str) {
        String str2 = "";
        try {
            if (this.NotificationsParams != null) {
                int i10 = 0;
                while (true) {
                    NotificationsParamsObj[] notificationsParamsObjArr = this.NotificationsParams;
                    if (i10 >= notificationsParamsObjArr.length) {
                        break;
                    }
                    if (notificationsParamsObjArr[i10].mKey.equals(str)) {
                        str2 = this.NotificationsParams[i10].mValue;
                    }
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return str2;
    }

    public String getParamsUrl() {
        try {
            return this.NotificationsParams[1].mValue;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public boolean getPlaySound() {
        if (isFromNotification()) {
            return false;
        }
        return this.PlaySound;
    }

    public int getRandomNid() {
        return this.randomNid;
    }

    public int getReplacementBehavior() {
        return this.replacementBehavior;
    }

    public String getReplacementKey() {
        return this.replacementKey;
    }

    public int getReplacementSoundBehavior() {
        return this.replacementSoundBehavior;
    }

    public String getShareUrl() {
        return this.ShareUrl;
    }

    public int getShares() {
        return this.shares;
    }

    public boolean getShowIcon() {
        return this.ShowIcon;
    }

    public String getSoundName() {
        return this.sound;
    }

    public String getStatKey() {
        return this.statKey;
    }

    public String getSubScreen() {
        try {
            String param = getParam("subScreen");
            if (param.isEmpty()) {
                param = getParam("SubScreen");
            }
            return param.isEmpty() ? getParam("sub_screen") : param;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.Url;
    }

    public boolean isDefaultNotificationSound() {
        try {
            String str = this.sound;
            if (str == null || str.isEmpty()) {
                return false;
            }
            return this.sound.equalsIgnoreCase("default");
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isFromNotification() {
        return this.isFromNotification;
    }

    public boolean isHasLMT() {
        return this.hasLMT;
    }

    public boolean isOpenUrlInExternalBrowser() {
        try {
            return Boolean.valueOf(this.NotificationsParams[0].mValue).booleanValue();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isSkipDetails() {
        return this.skipDetails;
    }

    public boolean isVibrateOn() {
        return this.isVibrateOn;
    }

    public void setIsFromNotification(boolean z10) {
        this.isFromNotification = z10;
    }

    public void setNotificationId(String str) {
        this.notificationId = str;
    }

    public void setRandomNid(int i10) {
        this.randomNid = i10;
    }

    public void setSound(String str) {
        this.sound = str;
    }

    public void setVibrateOn(boolean z10) {
        this.isVibrateOn = z10;
    }

    @NonNull
    public String toString() {
        return "GCMNotificationObj{id=" + this.f23588id + ", notificationId='" + this.notificationId + "', ScreenName='" + this.ScreenName + "', entity=" + this.entity + ", comps=" + Arrays.toString(this.comps) + ", competitionId=" + this.competitionId + ", Url='" + this.Url + "', URL='" + this.URL + "', ADV_ID=" + this.ADV_ID + ", NotificationsParams=" + Arrays.toString(this.NotificationsParams) + ", Game=" + this.Game + ", statKey='" + this.statKey + "', imgUrl='" + this.imgUrl + "', imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", skipDetails=" + this.skipDetails + ", ShareUrl='" + this.ShareUrl + "', hasLMT=" + this.hasLMT + ", sound='" + this.sound + "', langId=" + this.langId + ", isVibrateOn=" + this.isVibrateOn + ", actionMute='" + this.actionMute + "', actionEdit='" + this.actionEdit + "', androidTextForGroup='" + this.androidTextForGroup + "', androidGroupKey=" + this.androidGroupKey + ", androidGroupTitle='" + this.androidGroupTitle + "', replacementBehavior=" + this.replacementBehavior + ", replacementKey='" + this.replacementKey + "', replacementSoundBehavior=" + this.replacementSoundBehavior + ", isFromNotification=" + this.isFromNotification + ", randomNid=" + this.randomNid + '}';
    }
}
