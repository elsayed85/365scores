package com.scores365.entitys.competitionsDetailsCards;

import com.scores365.entitys.TopPerformerObj;
import java.io.Serializable;
import kotlin.jvm.internal.m;
import p9.c;
/* compiled from: CompetitionDetailsData.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsData implements Serializable {
    @c("Cards")
    private final CardHelper cards;

    /* compiled from: CompetitionDetailsData.kt */
    /* loaded from: classes2.dex */
    public static final class CardHelper implements Serializable {
        @c("CompetitionDetails")
        private final GeneralCompetitionDetailsCard detailsCard;
        @c("FeaturedMatch")
        private final CompetitionDetailsFeaturedMatchObj featuredMatch;
        @c("LatestTransfers")
        private final CompetitionDetailsLatestTransfersObj latestTransfers;
        @c("Newcomers")
        private final CompetitionDetailsNewComersObj newcomers;
        @c("NewsPreview")
        private final CompetitionDetailsNewsPreviewObj newsPreview;
        @c("Outrights")
        private final CompetitionDetailsOutrightCardObj outrightObj;
        @c("StandingsPreview")
        private final CompetitionDetailsStandingsPreviewObj standingsPreview;
        @c("TeamOfTheWeek")
        private final CompetitionDetailsTeamsOfTheWeekObj teamOfTheWeek;
        @c("TopPlayers")
        private final TopPerformerObj topPlayers;
        @c("TopTeams")
        private final CompetitionDetailsTopTeamsObj topTeams;
        @c("Videos")
        private final CompetitionDetailsVideosObj videos;

        public CardHelper(GeneralCompetitionDetailsCard generalCompetitionDetailsCard, CompetitionDetailsFeaturedMatchObj competitionDetailsFeaturedMatchObj, TopPerformerObj topPerformerObj, CompetitionDetailsTopTeamsObj competitionDetailsTopTeamsObj, CompetitionDetailsLatestTransfersObj competitionDetailsLatestTransfersObj, CompetitionDetailsTeamsOfTheWeekObj competitionDetailsTeamsOfTheWeekObj, CompetitionDetailsNewComersObj competitionDetailsNewComersObj, CompetitionDetailsVideosObj competitionDetailsVideosObj, CompetitionDetailsNewsPreviewObj competitionDetailsNewsPreviewObj, CompetitionDetailsStandingsPreviewObj competitionDetailsStandingsPreviewObj, CompetitionDetailsOutrightCardObj competitionDetailsOutrightCardObj) {
            this.detailsCard = generalCompetitionDetailsCard;
            this.featuredMatch = competitionDetailsFeaturedMatchObj;
            this.topPlayers = topPerformerObj;
            this.topTeams = competitionDetailsTopTeamsObj;
            this.latestTransfers = competitionDetailsLatestTransfersObj;
            this.teamOfTheWeek = competitionDetailsTeamsOfTheWeekObj;
            this.newcomers = competitionDetailsNewComersObj;
            this.videos = competitionDetailsVideosObj;
            this.newsPreview = competitionDetailsNewsPreviewObj;
            this.standingsPreview = competitionDetailsStandingsPreviewObj;
            this.outrightObj = competitionDetailsOutrightCardObj;
        }

        public final GeneralCompetitionDetailsCard component1() {
            return this.detailsCard;
        }

        public final CompetitionDetailsStandingsPreviewObj component10() {
            return this.standingsPreview;
        }

        public final CompetitionDetailsOutrightCardObj component11() {
            return this.outrightObj;
        }

        public final CompetitionDetailsFeaturedMatchObj component2() {
            return this.featuredMatch;
        }

        public final TopPerformerObj component3() {
            return this.topPlayers;
        }

        public final CompetitionDetailsTopTeamsObj component4() {
            return this.topTeams;
        }

        public final CompetitionDetailsLatestTransfersObj component5() {
            return this.latestTransfers;
        }

        public final CompetitionDetailsTeamsOfTheWeekObj component6() {
            return this.teamOfTheWeek;
        }

        public final CompetitionDetailsNewComersObj component7() {
            return this.newcomers;
        }

        public final CompetitionDetailsVideosObj component8() {
            return this.videos;
        }

        public final CompetitionDetailsNewsPreviewObj component9() {
            return this.newsPreview;
        }

        public final CardHelper copy(GeneralCompetitionDetailsCard generalCompetitionDetailsCard, CompetitionDetailsFeaturedMatchObj competitionDetailsFeaturedMatchObj, TopPerformerObj topPerformerObj, CompetitionDetailsTopTeamsObj competitionDetailsTopTeamsObj, CompetitionDetailsLatestTransfersObj competitionDetailsLatestTransfersObj, CompetitionDetailsTeamsOfTheWeekObj competitionDetailsTeamsOfTheWeekObj, CompetitionDetailsNewComersObj competitionDetailsNewComersObj, CompetitionDetailsVideosObj competitionDetailsVideosObj, CompetitionDetailsNewsPreviewObj competitionDetailsNewsPreviewObj, CompetitionDetailsStandingsPreviewObj competitionDetailsStandingsPreviewObj, CompetitionDetailsOutrightCardObj competitionDetailsOutrightCardObj) {
            return new CardHelper(generalCompetitionDetailsCard, competitionDetailsFeaturedMatchObj, topPerformerObj, competitionDetailsTopTeamsObj, competitionDetailsLatestTransfersObj, competitionDetailsTeamsOfTheWeekObj, competitionDetailsNewComersObj, competitionDetailsVideosObj, competitionDetailsNewsPreviewObj, competitionDetailsStandingsPreviewObj, competitionDetailsOutrightCardObj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CardHelper) {
                CardHelper cardHelper = (CardHelper) obj;
                return m.b(this.detailsCard, cardHelper.detailsCard) && m.b(this.featuredMatch, cardHelper.featuredMatch) && m.b(this.topPlayers, cardHelper.topPlayers) && m.b(this.topTeams, cardHelper.topTeams) && m.b(this.latestTransfers, cardHelper.latestTransfers) && m.b(this.teamOfTheWeek, cardHelper.teamOfTheWeek) && m.b(this.newcomers, cardHelper.newcomers) && m.b(this.videos, cardHelper.videos) && m.b(this.newsPreview, cardHelper.newsPreview) && m.b(this.standingsPreview, cardHelper.standingsPreview) && m.b(this.outrightObj, cardHelper.outrightObj);
            }
            return false;
        }

        public final GeneralCompetitionDetailsCard getDetailsCard() {
            return this.detailsCard;
        }

        public final CompetitionDetailsFeaturedMatchObj getFeaturedMatch() {
            return this.featuredMatch;
        }

        public final CompetitionDetailsLatestTransfersObj getLatestTransfers() {
            return this.latestTransfers;
        }

        public final CompetitionDetailsNewComersObj getNewcomers() {
            return this.newcomers;
        }

        public final CompetitionDetailsNewsPreviewObj getNewsPreview() {
            return this.newsPreview;
        }

        public final CompetitionDetailsOutrightCardObj getOutrightObj() {
            return this.outrightObj;
        }

        public final CompetitionDetailsStandingsPreviewObj getStandingsPreview() {
            return this.standingsPreview;
        }

        public final CompetitionDetailsTeamsOfTheWeekObj getTeamOfTheWeek() {
            return this.teamOfTheWeek;
        }

        public final TopPerformerObj getTopPlayers() {
            return this.topPlayers;
        }

        public final CompetitionDetailsTopTeamsObj getTopTeams() {
            return this.topTeams;
        }

        public final CompetitionDetailsVideosObj getVideos() {
            return this.videos;
        }

        public int hashCode() {
            GeneralCompetitionDetailsCard generalCompetitionDetailsCard = this.detailsCard;
            int hashCode = (generalCompetitionDetailsCard == null ? 0 : generalCompetitionDetailsCard.hashCode()) * 31;
            CompetitionDetailsFeaturedMatchObj competitionDetailsFeaturedMatchObj = this.featuredMatch;
            int hashCode2 = (hashCode + (competitionDetailsFeaturedMatchObj == null ? 0 : competitionDetailsFeaturedMatchObj.hashCode())) * 31;
            TopPerformerObj topPerformerObj = this.topPlayers;
            int hashCode3 = (hashCode2 + (topPerformerObj == null ? 0 : topPerformerObj.hashCode())) * 31;
            CompetitionDetailsTopTeamsObj competitionDetailsTopTeamsObj = this.topTeams;
            int hashCode4 = (hashCode3 + (competitionDetailsTopTeamsObj == null ? 0 : competitionDetailsTopTeamsObj.hashCode())) * 31;
            CompetitionDetailsLatestTransfersObj competitionDetailsLatestTransfersObj = this.latestTransfers;
            int hashCode5 = (hashCode4 + (competitionDetailsLatestTransfersObj == null ? 0 : competitionDetailsLatestTransfersObj.hashCode())) * 31;
            CompetitionDetailsTeamsOfTheWeekObj competitionDetailsTeamsOfTheWeekObj = this.teamOfTheWeek;
            int hashCode6 = (hashCode5 + (competitionDetailsTeamsOfTheWeekObj == null ? 0 : competitionDetailsTeamsOfTheWeekObj.hashCode())) * 31;
            CompetitionDetailsNewComersObj competitionDetailsNewComersObj = this.newcomers;
            int hashCode7 = (hashCode6 + (competitionDetailsNewComersObj == null ? 0 : competitionDetailsNewComersObj.hashCode())) * 31;
            CompetitionDetailsVideosObj competitionDetailsVideosObj = this.videos;
            int hashCode8 = (hashCode7 + (competitionDetailsVideosObj == null ? 0 : competitionDetailsVideosObj.hashCode())) * 31;
            CompetitionDetailsNewsPreviewObj competitionDetailsNewsPreviewObj = this.newsPreview;
            int hashCode9 = (hashCode8 + (competitionDetailsNewsPreviewObj == null ? 0 : competitionDetailsNewsPreviewObj.hashCode())) * 31;
            CompetitionDetailsStandingsPreviewObj competitionDetailsStandingsPreviewObj = this.standingsPreview;
            int hashCode10 = (hashCode9 + (competitionDetailsStandingsPreviewObj == null ? 0 : competitionDetailsStandingsPreviewObj.hashCode())) * 31;
            CompetitionDetailsOutrightCardObj competitionDetailsOutrightCardObj = this.outrightObj;
            return hashCode10 + (competitionDetailsOutrightCardObj != null ? competitionDetailsOutrightCardObj.hashCode() : 0);
        }

        public String toString() {
            return "CardHelper(detailsCard=" + this.detailsCard + ", featuredMatch=" + this.featuredMatch + ", topPlayers=" + this.topPlayers + ", topTeams=" + this.topTeams + ", latestTransfers=" + this.latestTransfers + ", teamOfTheWeek=" + this.teamOfTheWeek + ", newcomers=" + this.newcomers + ", videos=" + this.videos + ", newsPreview=" + this.newsPreview + ", standingsPreview=" + this.standingsPreview + ", outrightObj=" + this.outrightObj + ')';
        }
    }

    public CompetitionDetailsData(CardHelper cards) {
        m.g(cards, "cards");
        this.cards = cards;
    }

    public final CardHelper getCards() {
        return this.cards;
    }
}
