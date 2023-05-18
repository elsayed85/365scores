package com.scores365.ui.playerCard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.AthletesStatisticTypeObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.PlayerStatObj;
import com.scores365.entitys.SportTypesEnum;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class PlayerCardProfileStatsItem extends com.scores365.Design.PageObjects.b {
    private AthletesStatisticTypeObj clickedStatType = null;
    private String competitionIconUrl;
    private CompetitionObj competitionObj;
    private ArrayList<SingleAthleteStatisticsUiHelper> dataToRender;
    private boolean isProfileCard;
    private LeagueClickListener leagueClickListener;
    private String titleName;

    /* loaded from: classes2.dex */
    public static class LeagueClickListener implements View.OnClickListener {
        private int athleteId;
        private CompetitionObj item;

        public LeagueClickListener(CompetitionObj competitionObj, int i10) {
            this.item = competitionObj;
            this.athleteId = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent t10 = x0.t(this.item, false, null, false, new ee.l("", "player_card_stats_card_header"));
                t10.addFlags(268435456);
                App.m().startActivity(t10);
                HashMap hashMap = new HashMap();
                hashMap.put("athlete_id", Integer.valueOf(this.athleteId));
                hashMap.put("entity_type", Integer.valueOf(App.c.LEAGUE.getValue()));
                hashMap.put("entity_id", Integer.valueOf(this.item.getID()));
                hashMap.put("section", "player-stats");
                ee.k.k(App.m(), "athlete", "entity", "click", null, hashMap);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class StatClickListener implements View.OnClickListener {
        private WeakReference<PlayerCardProfileStatsItem> itemRef;
        private AthletesStatisticTypeObj statType;
        private WeakReference<ViewHolder> vhRef;

        public StatClickListener(ViewHolder viewHolder, PlayerCardProfileStatsItem playerCardProfileStatsItem, AthletesStatisticTypeObj athletesStatisticTypeObj) {
            this.vhRef = new WeakReference<>(viewHolder);
            this.itemRef = new WeakReference<>(playerCardProfileStatsItem);
            this.statType = athletesStatisticTypeObj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewHolder viewHolder = this.vhRef.get();
                PlayerCardProfileStatsItem playerCardProfileStatsItem = this.itemRef.get();
                if (viewHolder == null || playerCardProfileStatsItem == null) {
                    return;
                }
                playerCardProfileStatsItem.clickedStatType = this.statType;
                ((t) viewHolder).itemView.performClick();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ArrayList<View> clickViews;
        View divider1;
        View divider2;
        View divider3;
        ArrayList<View> dividers;
        ImageView ivCompetition;
        TextView tvCompetition;
        ArrayList<TextView> tvStatData;
        ArrayList<ImageView> tvStatIcon;
        ArrayList<TextView> tvStatName;
        ArrayList<TextView> tvStatOrdinal;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.ivCompetition = (ImageView) view.findViewById(R.id.Ya);
                this.tvCompetition = (TextView) view.findViewById(R.id.Ox);
                this.divider1 = view.findViewById(R.id.S5);
                this.divider2 = view.findViewById(R.id.Qo);
                this.divider3 = view.findViewById(R.id.cs);
                this.tvCompetition.setTypeface(o0.d(App.m()));
                this.tvStatIcon = new ArrayList<>();
                this.tvStatData = new ArrayList<>();
                this.tvStatName = new ArrayList<>();
                this.clickViews = new ArrayList<>();
                this.dividers = new ArrayList<>();
                this.tvStatOrdinal = new ArrayList<>();
                this.tvStatIcon.add((ImageView) view.findViewById(R.id.f22292sb));
                this.tvStatIcon.add((ImageView) view.findViewById(R.id.Xc));
                this.tvStatIcon.add((ImageView) view.findViewById(R.id.Wd));
                this.tvStatIcon.add((ImageView) view.findViewById(R.id.f22380wb));
                this.tvStatData.add((TextView) view.findViewById(R.id.qz));
                this.tvStatData.add((TextView) view.findViewById(R.id.KD));
                this.tvStatData.add((TextView) view.findViewById(R.id.EG));
                this.tvStatData.add((TextView) view.findViewById(R.id.xz));
                this.tvStatName.add((TextView) view.findViewById(R.id.rz));
                this.tvStatName.add((TextView) view.findViewById(R.id.LD));
                this.tvStatName.add((TextView) view.findViewById(R.id.FG));
                this.tvStatName.add((TextView) view.findViewById(R.id.yz));
                this.tvStatOrdinal.add((TextView) view.findViewById(R.id.sz));
                this.tvStatOrdinal.add((TextView) view.findViewById(R.id.MD));
                this.tvStatOrdinal.add((TextView) view.findViewById(R.id.GG));
                this.tvStatOrdinal.add((TextView) view.findViewById(R.id.zz));
                this.clickViews.add(view.findViewById(R.id.R5));
                this.clickViews.add(view.findViewById(R.id.Po));
                this.clickViews.add(view.findViewById(R.id.bs));
                this.clickViews.add(view.findViewById(R.id.Y6));
                this.dividers.add(this.divider1);
                this.dividers.add(this.divider2);
                this.dividers.add(this.divider3);
                view.setLayoutDirection(0);
                if (x0.l1()) {
                    Collections.reverse(this.clickViews);
                    Collections.reverse(this.tvStatName);
                    Collections.reverse(this.tvStatData);
                    Collections.reverse(this.tvStatIcon);
                    Collections.reverse(this.tvStatOrdinal);
                    Collections.reverse(this.dividers);
                    view.setLayoutDirection(1);
                }
                Iterator<TextView> it = this.tvStatData.iterator();
                while (it.hasNext()) {
                    it.next().setTypeface(o0.c(App.m()));
                }
                Iterator<TextView> it2 = this.tvStatData.iterator();
                while (it2.hasNext()) {
                    it2.next().setTypeface(o0.d(App.m()));
                }
                Iterator<TextView> it3 = this.tvStatName.iterator();
                while (it3.hasNext()) {
                    it3.next().setTypeface(o0.d(App.m()));
                }
                view.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public PlayerCardProfileStatsItem(CompetitionObj competitionObj, AthleteStatisticsObj athleteStatisticsObj, int i10, LinkedHashMap<Integer, AthletesStatisticTypeObj> linkedHashMap, int i11, boolean z10, String str) {
        this.competitionObj = competitionObj;
        this.isProfileCard = z10;
        this.titleName = str;
        this.competitionIconUrl = o.x(x0.n1() ? p.CompetitionsLight : p.Competitions, competitionObj.getID(), 70, 70, false, p.CountriesRoundFlags, Integer.valueOf(competitionObj.getCid()), competitionObj.getImgVer());
        updateData(athleteStatisticsObj, i10, linkedHashMap);
        this.leagueClickListener = new LeagueClickListener(competitionObj, i11);
    }

    private void handleViewsVisibility(ViewHolder viewHolder) {
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                viewHolder.tvStatIcon.get(i10).setVisibility(8);
                viewHolder.tvStatData.get(i10).setVisibility(8);
                viewHolder.tvStatName.get(i10).setVisibility(8);
                viewHolder.clickViews.get(i10).setVisibility(8);
                if (i10 > 0) {
                    viewHolder.dividers.get(i10 - 1).setVisibility(8);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22607l6, viewGroup, false), eVar);
    }

    public AthletesStatisticTypeObj getClickedStatType() {
        return this.clickedStatType;
    }

    public CompetitionObj getCompetitionObj() {
        return this.competitionObj;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerDetailsProfileStatsItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            li.u.x(this.competitionIconUrl, viewHolder.ivCompetition);
            String str = this.titleName;
            if (str == null || str.isEmpty()) {
                viewHolder.tvCompetition.setVisibility(8);
                viewHolder.tvCompetition.setVisibility(8);
            } else {
                viewHolder.tvCompetition.setText(this.titleName);
                viewHolder.tvCompetition.setOnClickListener(this.leagueClickListener);
            }
            handleViewsVisibility(viewHolder);
            boolean z10 = false;
            for (int i11 = 0; i11 < this.dataToRender.size(); i11++) {
                viewHolder.tvStatIcon.get(i11).setVisibility(0);
                viewHolder.tvStatData.get(i11).setVisibility(0);
                viewHolder.tvStatName.get(i11).setVisibility(0);
                viewHolder.clickViews.get(i11).setVisibility(0);
                if (i11 > 0) {
                    viewHolder.dividers.get(i11 - 1).setVisibility(0);
                }
                li.u.x(this.dataToRender.get(i11).getImageUrl(), viewHolder.tvStatIcon.get(i11));
                viewHolder.tvStatData.get(i11).setText(this.dataToRender.get(i11).getPlayerStatObj().getV());
                viewHolder.tvStatName.get(i11).setText(this.dataToRender.get(i11).getAthletesStatisticTypeObj().name);
                if (this.competitionObj.getSid() == SportTypesEnum.SOCCER.getValue()) {
                    viewHolder.clickViews.get(i11).setOnClickListener(new StatClickListener(viewHolder, this, this.dataToRender.get(i11).getAthletesStatisticTypeObj()));
                } else {
                    viewHolder.clickViews.get(i11).setBackgroundResource(0);
                }
                if (this.dataToRender.get(i11).getPlayerStatObj().getOrdinal() != null) {
                    viewHolder.tvStatOrdinal.get(i11).setText(this.dataToRender.get(i11).getPlayerStatObj().getOrdinal());
                    viewHolder.tvStatOrdinal.get(i11).setTypeface(o0.d(App.m()));
                    z10 = true;
                }
                if (this.isProfileCard) {
                    ((ViewGroup.MarginLayoutParams) viewHolder.tvStatIcon.get(i11).getLayoutParams()).topMargin = (int) App.m().getResources().getDimension(R.dimen.F);
                } else {
                    ((ViewGroup.MarginLayoutParams) viewHolder.tvStatIcon.get(i11).getLayoutParams()).topMargin = ((int) App.m().getResources().getDimension(R.dimen.F)) - p0.s(10);
                }
            }
            if (this.isProfileCard) {
                ((ViewGroup.MarginLayoutParams) viewHolder.divider1.getLayoutParams()).topMargin = (int) App.m().getResources().getDimension(R.dimen.G);
                ((ViewGroup.MarginLayoutParams) viewHolder.divider2.getLayoutParams()).topMargin = (int) App.m().getResources().getDimension(R.dimen.G);
                ((ViewGroup.MarginLayoutParams) viewHolder.divider3.getLayoutParams()).topMargin = (int) App.m().getResources().getDimension(R.dimen.G);
            } else {
                ((ViewGroup.MarginLayoutParams) viewHolder.divider1.getLayoutParams()).topMargin = ((int) App.m().getResources().getDimension(R.dimen.G)) - p0.s(10);
                ((ViewGroup.MarginLayoutParams) viewHolder.divider2.getLayoutParams()).topMargin = ((int) App.m().getResources().getDimension(R.dimen.G)) - p0.s(10);
                ((ViewGroup.MarginLayoutParams) viewHolder.divider3.getLayoutParams()).topMargin = ((int) App.m().getResources().getDimension(R.dimen.G)) - p0.s(10);
            }
            Iterator<TextView> it = viewHolder.tvStatOrdinal.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(z10 ? 0 : 8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setClickedStatType(AthletesStatisticTypeObj athletesStatisticTypeObj) {
        this.clickedStatType = athletesStatisticTypeObj;
    }

    public void updateData(AthleteStatisticsObj athleteStatisticsObj, int i10, LinkedHashMap<Integer, AthletesStatisticTypeObj> linkedHashMap) {
        PlayerStatObj[] playerStatObjArr;
        int s10 = p0.s(24);
        this.dataToRender = new ArrayList<>();
        for (PlayerStatObj playerStatObj : athleteStatisticsObj.playerStatistics) {
            if (playerStatObj.isShowOnMainStatsCard() || !this.isProfileCard) {
                AthletesStatisticTypeObj athletesStatisticTypeObj = linkedHashMap.get(Integer.valueOf(playerStatObj.getT()));
                this.dataToRender.add(new SingleAthleteStatisticsUiHelper(o.z(playerStatObj.getT(), x0.R0(athletesStatisticTypeObj != null ? athletesStatisticTypeObj.imgVer : -1, App.l().getImageSources().getSourcesType().get((x0.n1() ? p.AthleteStatisticTypesLight : p.AthleteStatisticTypesDark).getmName())), Integer.valueOf(s10), Integer.valueOf(s10), x0.n1() ? p.AthleteStatisticTypesLight : p.AthleteStatisticTypesDark), playerStatObj, linkedHashMap.get(Integer.valueOf(playerStatObj.getT()))));
            }
        }
    }
}
