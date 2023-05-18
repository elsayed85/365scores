package com.scores365.Monetization.Stc;

import cc.p0;
import java.util.ArrayList;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class CompareNativeAdScoresCampaignMgr {
    public static final String WHO_WILL_WIN_VOTE_KEY = "9999999";
    public static ComparisonFakeGame comparisonFakeGame;
    private static Boolean isCampaingAvailable;

    /* loaded from: classes2.dex */
    public static class ComparisonFakeGame {
        @c("AwayLogo")
        public String AwayLogo;
        @c("AwayScore")
        public int AwayScore;
        @c("AwayText")
        public String AwayText;
        @c("CapDay")
        public int CapDay;
        @c("CapLifetime")
        public int CapLifetime;
        @c("ClickType")
        public String ClickType;
        @c("ComparisonFakeGameId")
        public int ComparisonFakeGameId;
        @c("GapBetweenSessions")
        public int GapBetweenSessions;
        @c("HomeLogo")
        public String HomeLogo;
        @c("HomeScore")
        public int HomeScore;
        @c("HomeText")
        public String HomeText;
        @c("ImpressionTracker")
        public String ImpressionTracker;
        @c("LeagueLogo")
        public String LeagueLogo;
        @c("LeagueName")
        public String LeagueName;
        @c("URL")
        public String URL;
        @c("WWWAwayTeam")
        public int WWWAwayTeam;
        @c("WWWDraw")
        public int WWWDraw;
        @c("WWWHomeTeam")
        public int WWWHomeTeam;
        @c("FavoriteTeams")
        private ArrayList<Integer> favoriteTeams = new ArrayList<>();
        @c("FollowingTeams")
        private ArrayList<Integer> followingTeams = new ArrayList<>();
        @c("FollowingLeagues")
        private ArrayList<Integer> followingLeagues = new ArrayList<>();
        private p0 targetingObj = null;

        private p0 getTargetingObj() {
            try {
                if (this.targetingObj == null) {
                    this.targetingObj = new p0(this.favoriteTeams, this.followingTeams, this.followingLeagues);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return this.targetingObj;
        }

        public boolean isTargetedForUserSelections() {
            return getTargetingObj().a();
        }
    }

    /* loaded from: classes2.dex */
    private static class SendImpressionTask implements Runnable {
        long timer;
        String url;

        public SendImpressionTask(String str) {
            this.url = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timer = System.currentTimeMillis();
            x0.R(this.url);
        }
    }

    public static void clear() {
        isCampaingAvailable = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isCampaignAvailable() {
        /*
            java.lang.Boolean r0 = com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.isCampaingAvailable     // Catch: java.lang.Exception -> Lac
            if (r0 != 0) goto Lb0
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> Lac
            com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.isCampaingAvailable = r0     // Catch: java.lang.Exception -> Lac
            boolean r0 = com.scores365.App.f20803w     // Catch: java.lang.Exception -> Lac
            if (r0 != 0) goto Lb0
            android.content.Context r0 = com.scores365.App.m()     // Catch: java.lang.Exception -> Lac
            boolean r0 = com.scores365.removeAds.RemoveAdsManager.isUserAdsRemoved(r0)     // Catch: java.lang.Exception -> Lac
            if (r0 != 0) goto Lb0
            com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr$ComparisonFakeGame r0 = com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.comparisonFakeGame     // Catch: java.lang.Exception -> Lac
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 == 0) goto Lb0
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch: java.lang.Exception -> Lac
            sf.b r3 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            long r3 = r3.e1()     // Catch: java.lang.Exception -> Lac
            r0.setTimeInMillis(r3)     // Catch: java.lang.Exception -> Lac
            java.util.Calendar r3 = java.util.Calendar.getInstance()     // Catch: java.lang.Exception -> Lac
            int r4 = r0.get(r2)     // Catch: java.lang.Exception -> Lac
            int r5 = r3.get(r2)     // Catch: java.lang.Exception -> Lac
            if (r4 != r5) goto L5a
            r4 = 6
            int r0 = r0.get(r4)     // Catch: java.lang.Exception -> Lac
            int r3 = r3.get(r4)     // Catch: java.lang.Exception -> Lac
            if (r0 != r3) goto L5a
            sf.b r0 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            int r0 = r0.p2()     // Catch: java.lang.Exception -> Lac
            com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr$ComparisonFakeGame r3 = com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.comparisonFakeGame     // Catch: java.lang.Exception -> Lac
            int r3 = r3.CapDay     // Catch: java.lang.Exception -> Lac
            if (r0 >= r3) goto L58
            goto L5a
        L58:
            r0 = 0
            goto L5b
        L5a:
            r0 = 1
        L5b:
            sf.b r3 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            int r3 = r3.W1()     // Catch: java.lang.Exception -> Lac
            sf.b r4 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            int r4 = r4.q2()     // Catch: java.lang.Exception -> Lac
            com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr$ComparisonFakeGame r5 = com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.comparisonFakeGame     // Catch: java.lang.Exception -> Lac
            int r6 = r5.CapLifetime     // Catch: java.lang.Exception -> Lac
            if (r4 >= r6) goto L73
            r4 = 1
            goto L74
        L73:
            r4 = 0
        L74:
            int r5 = r5.GapBetweenSessions     // Catch: java.lang.Exception -> Lac
            int r3 = r3 % r5
            if (r3 != 0) goto L7a
            r1 = 1
        L7a:
            if (r0 == 0) goto Lb0
            if (r1 == 0) goto Lb0
            if (r4 == 0) goto Lb0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> Lac
            com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.isCampaingAvailable = r0     // Catch: java.lang.Exception -> Lac
            sf.b r0 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            r0.q7()     // Catch: java.lang.Exception -> Lac
            sf.b r0 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            sf.b r1 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            int r1 = r1.p2()     // Catch: java.lang.Exception -> Lac
            int r1 = r1 + r2
            r0.T8(r1)     // Catch: java.lang.Exception -> Lac
            sf.b r0 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            sf.b r1 = sf.b.X1()     // Catch: java.lang.Exception -> Lac
            int r1 = r1.q2()     // Catch: java.lang.Exception -> Lac
            int r1 = r1 + r2
            r0.U8(r1)     // Catch: java.lang.Exception -> Lac
            goto Lb0
        Lac:
            r0 = move-exception
            li.x0.N1(r0)
        Lb0:
            java.lang.Boolean r0 = com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.isCampaingAvailable
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Monetization.Stc.CompareNativeAdScoresCampaignMgr.isCampaignAvailable():boolean");
    }

    public static boolean isTargetedForUserSelections() {
        ComparisonFakeGame comparisonFakeGame2 = comparisonFakeGame;
        return comparisonFakeGame2 != null && comparisonFakeGame2.isTargetedForUserSelections();
    }

    public static void sendImapression() {
        try {
            String str = comparisonFakeGame.ImpressionTracker;
            if (str == null || str.isEmpty()) {
                return;
            }
            new Thread(new SendImpressionTask(comparisonFakeGame.ImpressionTracker)).start();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
