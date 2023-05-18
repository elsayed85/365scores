package com.scores365.ui.playerCard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthletesObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.NationalTeamStatObj;
import com.scores365.entitys.NationalTeamStatsObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.entitys.eDashboardSection;
import java.util.ArrayList;
import java.util.Iterator;
import li.o0;
import li.p0;
import li.u;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class PlayerDetailsItem extends com.scores365.Design.PageObjects.b {
    private int athleteId;
    private AthleteObj athleteObj;
    private AthletesObj athletesObj;
    private ClubCountryClickListener clubClickListener;
    private String clubLogoUrl;
    private ClubCountryClickListener countryClickListener;
    private String countryLogoUrl;
    private boolean isCoach;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ClubCountryClickListener implements View.OnClickListener {
        String analyticsSection;
        int athleteId;
        int competitorId;
        Type type;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public enum Type {
            Club,
            Country
        }

        public ClubCountryClickListener(int i10, int i11, String str, Type type) {
            this.athleteId = i11;
            this.competitorId = i10;
            this.analyticsSection = str;
            this.type = type;
        }

        private String getEntityEntraceSourceByType(Type type) {
            return type.equals(Type.Club) ? "player_card_current_club" : type.equals(Type.Country) ? "player_card_nationality_club" : "";
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent s10 = x0.s(App.c.TEAM, this.competitorId, eDashboardSection.SCORES, "", false, 0, getEntityEntraceSourceByType(this.type));
                s10.addFlags(268435456);
                App.m().startActivity(s10);
                ee.k.n(App.m(), "athlete", "entity", "click", null, true, "athlete_id", String.valueOf(this.athleteId), "section", this.analyticsSection, "entity_type", "2", "entity_id", String.valueOf(this.competitorId));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        private View clickAreaLeft;
        private View clickAreaRight;
        private boolean isStatsAdded;
        private ImageView ivLeftCompetitorLogo;
        private ImageView ivRightCompetitorLogo;
        private LinearLayout statTitleContainer;
        private ArrayList<TextView> statTitles;
        private LinearLayout statValueContainer;
        private ArrayList<TextView> statValues;
        private TextView tvLeftCompetitorName;
        private TextView tvLeftCompetitorText;
        private TextView tvRightCompetitorName;
        private TextView tvRightCompetitorText;
        private View verticalDivider;

        public ViewHolder(View view) {
            super(view);
            this.statTitles = new ArrayList<>();
            this.statValues = new ArrayList<>();
            this.isStatsAdded = false;
            try {
                this.statTitleContainer = (LinearLayout) view.findViewById(R.id.Fg);
                this.statValueContainer = (LinearLayout) view.findViewById(R.id.Gg);
                this.tvLeftCompetitorName = (TextView) view.findViewById(R.id.JA);
                this.tvLeftCompetitorText = (TextView) view.findViewById(R.id.KA);
                this.tvRightCompetitorName = (TextView) view.findViewById(R.id.eD);
                this.tvRightCompetitorText = (TextView) view.findViewById(R.id.fD);
                this.ivLeftCompetitorLogo = (ImageView) view.findViewById(R.id.Rb);
                this.ivRightCompetitorLogo = (ImageView) view.findViewById(R.id.Mc);
                this.verticalDivider = view.findViewById(R.id.xI);
                this.clickAreaLeft = view.findViewById(R.id.f22394x3);
                this.clickAreaRight = view.findViewById(R.id.f22416y3);
                this.tvLeftCompetitorName.setTypeface(o0.c(App.m()));
                this.tvLeftCompetitorText.setTypeface(o0.d(App.m()));
                this.tvRightCompetitorName.setTypeface(o0.c(App.m()));
                this.tvRightCompetitorText.setTypeface(o0.d(App.m()));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public PlayerDetailsItem(AthletesObj athletesObj, AthleteObj athleteObj, int i10) {
        int i11;
        this.athletesObj = athletesObj;
        this.athleteObj = athleteObj;
        this.athleteId = i10;
        try {
            this.isCoach = SinglePlayerProfilePage.isCoach(athleteObj.getPlayerPositionType(), athleteObj.getSportType());
            CompObj compObj = athletesObj.getCompetitorsById().containsKey(Integer.valueOf(athleteObj.clubId)) ? athletesObj.getCompetitorsById().get(Integer.valueOf(athleteObj.clubId)) : athletesObj.getCompetitorsById().get(Integer.valueOf(athleteObj.nationalTeamId));
            if (compObj != null) {
                this.clubLogoUrl = o.s(p.Competitors, compObj.getID(), 150, 150, false, compObj.getImgVer());
                this.clubClickListener = new ClubCountryClickListener(compObj.getID(), i10, "player-details", ClubCountryClickListener.Type.Club);
            }
            if (athleteObj.getNationalTeamStatsObj() != null) {
                CompObj compObj2 = athletesObj.getCompetitorsById().get(Integer.valueOf(athleteObj.getNationalTeamStatsObj().getCompetitor()));
                i11 = compObj2 != null ? compObj2.getID() : -1;
            } else {
                i11 = athleteObj.nationalTeamId;
            }
            this.countryLogoUrl = o.s(p.CountriesRoundFlags, athleteObj.nationality, 150, 150, false, athletesObj.getCountryById().get(Integer.valueOf(athleteObj.nationality)).getImgVer());
            if (!this.isCoach || athletesObj.getCompetitorsById().containsKey(Integer.valueOf(i11))) {
                this.countryClickListener = new ClubCountryClickListener(i11, i10, "player-details", ClubCountryClickListener.Type.Country);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22594k6, viewGroup, false));
    }

    private void setNationalTeamData(ViewHolder viewHolder, TextView textView, ImageView imageView, TextView textView2, View view, int i10, NationalTeamStatsObj nationalTeamStatsObj, int i11) {
        try {
            u.x(this.countryLogoUrl, imageView);
            if (((this.isCoach || i10 == -1) ? this.athletesObj.getCountryById().get(Integer.valueOf(i11)) : this.athletesObj.getCountryById().get(Integer.valueOf(this.athletesObj.getCompetitorsById().get(Integer.valueOf(i10)).getCountryID()))) != null) {
                textView.setText(this.athleteObj.nationalityName);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.athletesObj.getAthleteStatTypes() == null || nationalTeamStatsObj == null || nationalTeamStatsObj.getStats() == null || nationalTeamStatsObj.getStats().isEmpty()) {
                sb2.append(p0.l0("NEW_PLAYER_CARD_SOCCER_NATIONALITY"));
            } else {
                Iterator<NationalTeamStatObj> it = nationalTeamStatsObj.getStats().iterator();
                while (it.hasNext()) {
                    NationalTeamStatObj next = it.next();
                    if (this.athletesObj.getAthleteStatTypes().containsKey(Integer.valueOf(next.getType()))) {
                        if (sb2.length() > 0) {
                            sb2.append(" ");
                        }
                        if (next.getType() == 5 && this.athleteObj.getSportTypeId() == SportTypesEnum.SOCCER.getValue()) {
                            sb2.append(p0.l0("NEW_PLAYER_CARD_SOCCER_INTERNATIONAL_CAPS"));
                        } else {
                            sb2.append(this.athletesObj.getAthleteStatTypes().get(Integer.valueOf(next.getType())).getName());
                        }
                        sb2.append("(");
                        sb2.append(next.getValue());
                        sb2.append(")");
                    }
                }
            }
            textView2.setText(sb2);
            textView2.setVisibility(0);
            imageView.setVisibility(0);
            textView.setVisibility(0);
            view.setVisibility(0);
            viewHolder.verticalDivider.setVisibility(0);
            ConstraintLayout.b bVar = (ConstraintLayout.b) viewHolder.verticalDivider.getLayoutParams();
            bVar.f4622e = 0;
            bVar.f4628h = 0;
            if (!this.isCoach && i10 != -1) {
                view.setOnClickListener(this.countryClickListener);
                return;
            }
            view.setOnClickListener(null);
            view.setBackground(null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerDetailsItem.ordinal();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x012c A[Catch: Exception -> 0x0325, TryCatch #0 {Exception -> 0x0325, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0049, B:8:0x0054, B:9:0x0063, B:57:0x023c, B:60:0x0243, B:62:0x024f, B:64:0x028a, B:66:0x02a7, B:65:0x0299, B:67:0x02e5, B:68:0x02e8, B:70:0x02f4, B:16:0x0075, B:17:0x0092, B:18:0x00b3, B:21:0x00c1, B:23:0x00c7, B:26:0x00f3, B:28:0x00f9, B:30:0x00ff, B:33:0x012c, B:35:0x013b, B:36:0x0152, B:38:0x015a, B:40:0x0175, B:41:0x0180, B:42:0x0189, B:43:0x01a2, B:45:0x01b8, B:47:0x01d4, B:49:0x01da, B:55:0x021f, B:50:0x01f2, B:51:0x01fc, B:53:0x0202, B:54:0x0218, B:56:0x0225, B:5:0x0029), top: B:75:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0189 A[Catch: Exception -> 0x0325, TryCatch #0 {Exception -> 0x0325, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0049, B:8:0x0054, B:9:0x0063, B:57:0x023c, B:60:0x0243, B:62:0x024f, B:64:0x028a, B:66:0x02a7, B:65:0x0299, B:67:0x02e5, B:68:0x02e8, B:70:0x02f4, B:16:0x0075, B:17:0x0092, B:18:0x00b3, B:21:0x00c1, B:23:0x00c7, B:26:0x00f3, B:28:0x00f9, B:30:0x00ff, B:33:0x012c, B:35:0x013b, B:36:0x0152, B:38:0x015a, B:40:0x0175, B:41:0x0180, B:42:0x0189, B:43:0x01a2, B:45:0x01b8, B:47:0x01d4, B:49:0x01da, B:55:0x021f, B:50:0x01f2, B:51:0x01fc, B:53:0x0202, B:54:0x0218, B:56:0x0225, B:5:0x0029), top: B:75:0x0000 }] */
    @Override // com.scores365.Design.PageObjects.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.e0 r14, int r15) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.PlayerDetailsItem.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$e0, int):void");
    }
}
