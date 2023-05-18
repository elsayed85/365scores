package com.scores365.ui.playerCard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.entitys.AthleteTrophiesScoreBoxColumnObj;
import com.scores365.entitys.AthletesStatisticTypeObj;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxTablesObj;
import com.scores365.entitys.SportTypesEnum;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import li.x0;
/* loaded from: classes2.dex */
public class LegendClickListener implements View.OnClickListener {
    private int athleteId;
    private LinkedHashMap<Integer, AthletesStatisticTypeObj> athleteStatTypes;
    private ArrayList<AthleteTrophiesScoreBoxColumnObj> columns = new ArrayList<>();
    private boolean isNational;
    WeakReference<iScrollToLegandInPage> pageRef;
    private int sportId;

    public LegendClickListener(iScrollToLegandInPage iscrolltolegandinpage, int i10, boolean z10, int i11, LinkedHashMap<Integer, AthletesStatisticTypeObj> linkedHashMap) {
        this.pageRef = new WeakReference<>(iscrolltolegandinpage);
        this.athleteId = i10;
        this.isNational = z10;
        this.sportId = i11;
        this.athleteStatTypes = linkedHashMap;
    }

    private String getDescription(int i10) {
        AthletesStatisticTypeObj athletesStatisticTypeObj = this.athleteStatTypes.get(Integer.valueOf(i10));
        if (athletesStatisticTypeObj != null) {
            String str = athletesStatisticTypeObj.description;
            return str != null ? str : athletesStatisticTypeObj.name;
        }
        return null;
    }

    public void addColumns(ScoreBoxTablesObj scoreBoxTablesObj) {
        try {
            this.columns.addAll(scoreBoxTablesObj.getColumns());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            WeakReference<iScrollToLegandInPage> weakReference = this.pageRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            boolean z10 = (this.sportId == SportTypesEnum.BASKETBALL.getValue() || this.sportId == SportTypesEnum.AMERICAN_FOOTBALL.getValue()) ? false : true;
            if (z10) {
                this.pageRef.get().handleLegendClick(z10, null);
            } else if ((view instanceof TextView) && view.getTag() != null) {
                int intValue = ((Integer) view.getTag()).intValue();
                String description = getDescription(this.columns.get(intValue).getEntity().getId());
                iScrollToLegandInPage iscrolltolegandinpage = this.pageRef.get();
                if (description == null) {
                    description = this.columns.get(intValue).getName();
                }
                iscrolltolegandinpage.handleLegendClick(z10, description);
            }
            Context m10 = App.m();
            String[] strArr = new String[8];
            strArr[0] = "athlete_id";
            strArr[1] = String.valueOf(this.athleteId);
            strArr[2] = "section";
            strArr[3] = "career-stats";
            strArr[4] = "category_id";
            strArr[5] = "";
            strArr[6] = "team_stat_type";
            strArr[7] = this.isNational ? "national" : "club";
            ee.k.n(m10, "athlete", "legend", "click", null, true, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
