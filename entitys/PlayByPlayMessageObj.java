package com.scores365.entitys;

import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.common.ConnectionResult;
import java.io.Serializable;
import java.util.ArrayList;
import li.x0;
/* loaded from: classes2.dex */
public class PlayByPlayMessageObj implements Serializable {
    private static final long serialVersionUID = -1115050136807292857L;
    @p9.c("TimeLineSecondaryText")
    private String addedTime;
    @p9.c("TimeLineSecondaryColor")
    private String addedTimeColor;
    @p9.c("Comment")
    private String comment;
    @p9.c("CommentBold")
    private boolean commentBold;
    @p9.c("CommentColor")
    private String commentColor;
    @p9.c("filterIds")
    private ArrayList<String> filterIds;
    @p9.c("Id")

    /* renamed from: id  reason: collision with root package name */
    private int f23594id;
    @p9.c("IncidentText")
    private String incidentText;
    @p9.c("IsMajor")
    private boolean isMajor;
    @p9.c("PBPEventKey")
    private String pbpEventKeys;
    @p9.c("Period")
    private String period;
    @p9.c("Players")
    private ArrayList<PlayerObj> players;
    @p9.c("Score")
    private ArrayList<String> score;
    @p9.c("Scores")
    private ArrayList<Integer> scores;
    @p9.c("ShowIcon")
    private boolean showIcon;
    @p9.c("SubTitle")
    private String subTitle;
    @p9.c("SubTitleColor")
    private String subTitleColor;
    @p9.c("TimeLineColor")
    private String timeLineColor;
    @p9.c("Timeline")
    private String timeline;
    @p9.c("Title")
    private String title;
    @p9.c("TitleColor")
    private String titleColor;
    private PlayByPlayMessageObj topMessage;
    @p9.c("Type")
    private int type;
    @p9.c("TypeName")
    private String typeName;
    @p9.c("CompetitorNum")
    private int competitorNum = -1;
    @p9.c("SportitiferEventTypeId")
    private int sportifierEventTypeId = -1;
    @p9.c("DriveId")
    private int driveId = -1;
    @p9.c("InnerId")
    private String innerId = "";
    @p9.c("LastModified")
    private String lastModified = "";
    @p9.c("SubtitleTerm")
    private boolean subtitleTerm = false;
    @p9.c("ShowLogo")
    private boolean showLogo = false;
    @p9.c("ShowPlayerImage")
    private boolean showPlayerImage = false;
    @p9.c("RelatedPlayerImage")
    private String relatedPlayerImage = "";
    @p9.c("Down")
    private int down = 0;
    @p9.c("Distance")
    private int distance = 0;
    @p9.c("YardLine")
    private String yardLine = "";
    @p9.c("RelevantPlayersIdx")
    private int[] relevantPlayersIdx = null;
    @p9.c("ShowTimePeriod")
    private boolean showTimePeriod = false;
    @p9.c("ShowScore")
    private boolean showScore = false;
    @p9.c("IsStatic")
    private boolean isStatic = false;
    private boolean isHeaderItemAnimationSupported = false;
    private boolean isGameItemAnimationSupported = false;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAddedTime() {
        return this.addedTime;
    }

    public String getAddedTimeColor() {
        return this.addedTimeColor;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentColor() {
        return this.commentColor;
    }

    public int getCompetitorNum() {
        return this.competitorNum;
    }

    public int getDriveId() {
        return this.driveId;
    }

    public ArrayList<String> getFilterIds() {
        return this.filterIds;
    }

    public int getId() {
        return this.f23594id;
    }

    public String getIncidentText() {
        return this.incidentText;
    }

    public String getPbpEventKeys() {
        return this.pbpEventKeys;
    }

    public String getPeriod() {
        return this.period;
    }

    public ArrayList<PlayerObj> getPlayers() {
        return this.players;
    }

    public PlayerObj getRelevantPlayerObj() {
        int i10;
        try {
            if (getRelevantPlayersIdx() == null || getRelevantPlayersIdx().length <= 0 || getPlayers().size() <= (i10 = getRelevantPlayersIdx()[0])) {
                return null;
            }
            return getPlayers().get(i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int[] getRelevantPlayersIdx() {
        return this.relevantPlayersIdx;
    }

    public ArrayList<String> getScore() {
        return this.score;
    }

    public String getScoreString() {
        String str;
        try {
            if (x0.l1()) {
                str = this.score.get(1) + " - " + this.score.get(0);
            } else {
                str = this.score.get(0) + " - " + this.score.get(1);
            }
            return str;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public ArrayList<Integer> getScores() {
        return this.scores;
    }

    public int getSportifierEventTypeId() {
        return this.sportifierEventTypeId;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getSubTitleColor() {
        return this.subTitleColor;
    }

    public String getTimeLineColor() {
        return this.timeLineColor;
    }

    public String getTimeline() {
        return this.timeline;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public PlayByPlayMessageObj getTopMessage() {
        return this.topMessage;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public boolean isCommentBold() {
        return this.commentBold;
    }

    public boolean isGameItemAnimationSupported() {
        return this.isGameItemAnimationSupported;
    }

    public boolean isHeaderItemAnimationSupported() {
        return this.isHeaderItemAnimationSupported;
    }

    public boolean isMajor() {
        return this.isMajor;
    }

    public boolean isPenalty() {
        try {
            int i10 = this.type;
            if (i10 != 14 && i10 != 47) {
                switch (i10) {
                    case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    case Constants.MAX_TREE_DEPTH /* 25 */:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        break;
                    default:
                        return false;
                }
            }
            return this.period.equals("5");
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isShowIcon() {
        return this.showIcon;
    }

    public boolean isStatic() {
        return this.isStatic;
    }

    public boolean isSubstitutionEvent() {
        return this.sportifierEventTypeId == 666;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setCommentBold(boolean z10) {
        this.commentBold = z10;
    }

    public void setCommentColor(String str) {
        this.commentColor = str;
    }

    public void setFilterIds(ArrayList<String> arrayList) {
        this.filterIds = arrayList;
    }

    public void setGameItemAnimationSupport(boolean z10) {
        this.isGameItemAnimationSupported = z10;
    }

    public void setHeaderItemAnimationSupport(boolean z10) {
        this.isHeaderItemAnimationSupported = z10;
    }

    public void setScore(ArrayList<String> arrayList) {
        this.score = arrayList;
    }

    public void setTopMessage(PlayByPlayMessageObj playByPlayMessageObj) {
        this.topMessage = playByPlayMessageObj;
    }

    public boolean showScore() {
        return this.showScore;
    }

    public boolean showTimePeriod() {
        return this.showTimePeriod;
    }
}
