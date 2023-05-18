package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.AthleteStatisticsObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.AthletesStatisticTypeObj;
import com.scores365.entitys.PlayerStatObj;
import com.scores365.entitys.SportTypesEnum;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class SinglePlayerOverallStatsItem extends com.scores365.Design.PageObjects.b {
    private static final int STATS_NUMBER = 6;
    private final int athleteId;
    private final AthletesObj athletesObj;
    private AthletesStatisticTypeObj clickedStatType = null;
    private int competitionId;
    private ArrayList<SingleAthleteStatisticsUiHelper> dataToRender;
    private int ordinalCount;

    /* loaded from: classes2.dex */
    public static class StatClickListener implements View.OnClickListener {
        private final WeakReference<SinglePlayerOverallStatsItem> itemRef;
        private final AthletesStatisticTypeObj statType;
        private final WeakReference<ViewHolder> vhRef;

        public StatClickListener(ViewHolder viewHolder, SinglePlayerOverallStatsItem singlePlayerOverallStatsItem, AthletesStatisticTypeObj athletesStatisticTypeObj) {
            this.vhRef = new WeakReference<>(viewHolder);
            this.itemRef = new WeakReference<>(singlePlayerOverallStatsItem);
            this.statType = athletesStatisticTypeObj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewHolder viewHolder = this.vhRef.get();
                SinglePlayerOverallStatsItem singlePlayerOverallStatsItem = this.itemRef.get();
                if (viewHolder == null || singlePlayerOverallStatsItem == null) {
                    return;
                }
                singlePlayerOverallStatsItem.clickedStatType = this.statType;
                ((t) viewHolder).itemView.performClick();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ArrayList<View> clickAreas;
        View dividerBottomLeft;
        View dividerBottomRight;
        View dividerTopLeft;
        View dividerTopRight;
        Guideline guideline;
        ArrayList<TextView> ordinals;
        ArrayList<ImageView> statIcons;
        ArrayList<TextView> statNames;
        ArrayList<TextView> statValues;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            this.statIcons = new ArrayList<>();
            this.statValues = new ArrayList<>();
            this.statNames = new ArrayList<>();
            this.clickAreas = new ArrayList<>();
            this.ordinals = new ArrayList<>();
            try {
                if (x0.l1()) {
                    this.statIcons.add((ImageView) view.findViewById(R.id.Ed));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Dd));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Cd));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Bd));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Ad));
                    this.statIcons.add((ImageView) view.findViewById(R.id.f22448zd));
                    this.statValues.add((TextView) view.findViewById(R.id.QF));
                    this.statValues.add((TextView) view.findViewById(R.id.PF));
                    this.statValues.add((TextView) view.findViewById(R.id.OF));
                    this.statValues.add((TextView) view.findViewById(R.id.IF));
                    this.statValues.add((TextView) view.findViewById(R.id.HF));
                    this.statValues.add((TextView) view.findViewById(R.id.GF));
                    this.statNames.add((TextView) view.findViewById(R.id.qF));
                    this.statNames.add((TextView) view.findViewById(R.id.pF));
                    this.statNames.add((TextView) view.findViewById(R.id.oF));
                    this.statNames.add((TextView) view.findViewById(R.id.nF));
                    this.statNames.add((TextView) view.findViewById(R.id.mF));
                    this.statNames.add((TextView) view.findViewById(R.id.lF));
                    this.ordinals.add((TextView) view.findViewById(R.id.wF));
                    this.ordinals.add((TextView) view.findViewById(R.id.vF));
                    this.ordinals.add((TextView) view.findViewById(R.id.uF));
                    this.ordinals.add((TextView) view.findViewById(R.id.tF));
                    this.ordinals.add((TextView) view.findViewById(R.id.sF));
                    this.ordinals.add((TextView) view.findViewById(R.id.rF));
                    this.clickAreas.add(view.findViewById(R.id.gt));
                    this.clickAreas.add(view.findViewById(R.id.ft));
                    this.clickAreas.add(view.findViewById(R.id.et));
                    this.clickAreas.add(view.findViewById(R.id.E0));
                    this.clickAreas.add(view.findViewById(R.id.f22413y0));
                    this.clickAreas.add(view.findViewById(R.id.f22369w0));
                } else {
                    this.statIcons.add((ImageView) view.findViewById(R.id.Cd));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Dd));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Ed));
                    this.statIcons.add((ImageView) view.findViewById(R.id.f22448zd));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Ad));
                    this.statIcons.add((ImageView) view.findViewById(R.id.Bd));
                    this.statValues.add((TextView) view.findViewById(R.id.OF));
                    this.statValues.add((TextView) view.findViewById(R.id.PF));
                    this.statValues.add((TextView) view.findViewById(R.id.QF));
                    this.statValues.add((TextView) view.findViewById(R.id.GF));
                    this.statValues.add((TextView) view.findViewById(R.id.HF));
                    this.statValues.add((TextView) view.findViewById(R.id.IF));
                    this.statNames.add((TextView) view.findViewById(R.id.oF));
                    this.statNames.add((TextView) view.findViewById(R.id.pF));
                    this.statNames.add((TextView) view.findViewById(R.id.qF));
                    this.statNames.add((TextView) view.findViewById(R.id.lF));
                    this.statNames.add((TextView) view.findViewById(R.id.mF));
                    this.statNames.add((TextView) view.findViewById(R.id.nF));
                    this.ordinals.add((TextView) view.findViewById(R.id.uF));
                    this.ordinals.add((TextView) view.findViewById(R.id.vF));
                    this.ordinals.add((TextView) view.findViewById(R.id.wF));
                    this.ordinals.add((TextView) view.findViewById(R.id.rF));
                    this.ordinals.add((TextView) view.findViewById(R.id.sF));
                    this.ordinals.add((TextView) view.findViewById(R.id.tF));
                    this.clickAreas.add(view.findViewById(R.id.et));
                    this.clickAreas.add(view.findViewById(R.id.ft));
                    this.clickAreas.add(view.findViewById(R.id.gt));
                    this.clickAreas.add(view.findViewById(R.id.f22369w0));
                    this.clickAreas.add(view.findViewById(R.id.f22413y0));
                    this.clickAreas.add(view.findViewById(R.id.E0));
                }
                this.dividerTopLeft = view.findViewById(R.id.CI);
                this.dividerTopRight = view.findViewById(R.id.DI);
                this.dividerBottomLeft = view.findViewById(R.id.zI);
                this.dividerBottomRight = view.findViewById(R.id.AI);
                Guideline guideline = (Guideline) view.findViewById(R.id.f22398x7);
                this.guideline = guideline;
                guideline.setGuidelinePercent(0.5f);
                Iterator<TextView> it = this.statValues.iterator();
                while (it.hasNext()) {
                    it.next().setTypeface(o0.c(App.m()));
                }
                Iterator<TextView> it2 = this.statNames.iterator();
                while (it2.hasNext()) {
                    it2.next().setTypeface(o0.d(App.m()));
                }
                view.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public SinglePlayerOverallStatsItem(AthletesObj athletesObj, int i10, int i11, AthleteStatisticsObj athleteStatisticsObj) {
        this.athletesObj = athletesObj;
        this.competitionId = i10;
        this.athleteId = i11;
        try {
            updateStatisticData(athleteStatisticsObj);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void handleSingleStat(ViewHolder viewHolder, int i10) {
        try {
            SingleAthleteStatisticsUiHelper singleAthleteStatisticsUiHelper = this.dataToRender.get(i10);
            li.u.x(singleAthleteStatisticsUiHelper.getImageUrl(), viewHolder.statIcons.get(i10));
            viewHolder.statNames.get(i10).setText(singleAthleteStatisticsUiHelper.getAthletesStatisticTypeObj().name);
            viewHolder.statValues.get(i10).setText(singleAthleteStatisticsUiHelper.getPlayerStatObj().getV());
            View view = viewHolder.clickAreas.get(i10);
            if (this.athletesObj.getAthleteById().get(Integer.valueOf(this.athleteId)).getSportTypeId() == SportTypesEnum.SOCCER.getValue()) {
                view.setOnClickListener(new StatClickListener(viewHolder, this, singleAthleteStatisticsUiHelper.getAthletesStatisticTypeObj()));
            } else {
                view.setBackgroundResource(0);
            }
            TextView textView = viewHolder.ordinals.get(i10);
            if (singleAthleteStatisticsUiHelper.getPlayerStatObj().getOrdinal() == null) {
                textView.setText("");
                return;
            }
            textView.setText(singleAthleteStatisticsUiHelper.getPlayerStatObj().getOrdinal());
            textView.setTypeface(o0.d(App.m()));
            this.ordinalCount = i10;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void handleViewVisibility(ViewHolder viewHolder) {
        try {
            new androidx.constraintlayout.widget.c().p((ConstraintLayout) ((t) viewHolder).itemView);
            if (this.dataToRender.size() > 5) {
                viewHolder.statIcons.get(5).setVisibility(0);
                viewHolder.statValues.get(5).setVisibility(0);
                viewHolder.statNames.get(5).setVisibility(0);
                viewHolder.clickAreas.get(5).setVisibility(0);
                if (x0.l1()) {
                    viewHolder.dividerBottomLeft.setVisibility(0);
                } else {
                    viewHolder.dividerBottomRight.setVisibility(0);
                }
            } else {
                viewHolder.statIcons.get(5).setVisibility(8);
                viewHolder.statValues.get(5).setVisibility(8);
                viewHolder.statNames.get(5).setVisibility(8);
                viewHolder.clickAreas.get(5).setVisibility(8);
                if (x0.l1()) {
                    viewHolder.dividerBottomLeft.setVisibility(8);
                } else {
                    viewHolder.dividerBottomRight.setVisibility(8);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.K8, viewGroup, false), eVar);
    }

    public AthletesStatisticTypeObj getClickedStatType() {
        return this.clickedStatType;
    }

    public int getCompetitionId() {
        return this.competitionId;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerOverallStatsItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ViewHolder viewHolder = (ViewHolder) e0Var;
        try {
            if (this.dataToRender != null) {
                handleViewVisibility(viewHolder);
                for (int i11 = 0; i11 < this.dataToRender.size(); i11++) {
                    handleSingleStat(viewHolder, i11);
                }
                if (this.ordinalCount > 0) {
                    viewHolder.guideline.setGuidelinePercent(0.55f);
                } else {
                    viewHolder.guideline.setGuidelinePercent(0.5f);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setClickedStatType(AthletesStatisticTypeObj athletesStatisticTypeObj) {
        this.clickedStatType = athletesStatisticTypeObj;
    }

    public void setCompetitionId(int i10) {
        this.competitionId = i10;
    }

    public void updateStatisticData(AthleteStatisticsObj athleteStatisticsObj) {
        PlayerStatObj[] playerStatObjArr;
        try {
            this.dataToRender = new ArrayList<>();
            int s10 = p0.s(24);
            p pVar = x0.n1() ? p.AthleteStatisticTypesLight : p.AthleteStatisticTypesDark;
            for (PlayerStatObj playerStatObj : athleteStatisticsObj.playerStatistics) {
                AthletesStatisticTypeObj athletesStatisticTypeObj = this.athletesObj.getAthleteStatTypes().get(Integer.valueOf(playerStatObj.getT()));
                String z10 = o.z(playerStatObj.getT(), x0.R0(athletesStatisticTypeObj != null ? athletesStatisticTypeObj.imgVer : -1, App.l().getImageSources().getSourcesType().get((x0.n1() ? p.AthleteStatisticTypesLight : p.AthleteStatisticTypesDark).getmName())), Integer.valueOf(s10), Integer.valueOf(s10), pVar);
                ArrayList<SingleAthleteStatisticsUiHelper> arrayList = this.dataToRender;
                AthletesStatisticTypeObj athletesStatisticTypeObj2 = this.athletesObj.getAthleteStatTypes().get(Integer.valueOf(playerStatObj.getT()));
                Objects.requireNonNull(athletesStatisticTypeObj2);
                arrayList.add(new SingleAthleteStatisticsUiHelper(z10, playerStatObj, athletesStatisticTypeObj2));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
