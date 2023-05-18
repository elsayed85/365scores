package com.scores365.ui.playerCard;

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
import com.scores365.entitys.CompetitionObj;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
/* loaded from: classes2.dex */
public class PlayerTrophiesCompetitionSingleItem extends com.scores365.Design.PageObjects.b {
    private String competitionName;
    private CompetitionObj competitionObj;
    private boolean isSelected;
    private int trophyCount;
    private String trophyURL;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ImageView entityLogo;
        TextView entityName;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.entityName = (TextView) view.findViewById(R.id.jE);
                this.entityLogo = (ImageView) view.findViewById(R.id.Kc);
                this.entityName.setTypeface(o0.d(App.m()));
                view.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public PlayerTrophiesCompetitionSingleItem(boolean z10, CompetitionObj competitionObj, int i10, String str) {
        try {
            this.isSelected = z10;
            this.trophyCount = i10;
            this.competitionName = str;
            this.competitionObj = competitionObj;
            this.trophyURL = o.p(competitionObj.getID(), String.valueOf(-1), Integer.valueOf(p0.s(43)), Integer.valueOf(p0.s(43)), competitionObj.getCid());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22755x6, viewGroup, false), eVar);
    }

    public int getCompetitionId() {
        CompetitionObj competitionObj = this.competitionObj;
        if (competitionObj == null) {
            return -1;
        }
        return competitionObj.getID();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerTrophiesCompetitionSingleItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            ((t) viewHolder).itemView.getLayoutParams().width = App.p() / 3;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.competitionName);
            sb2.append(" (");
            sb2.append(this.trophyCount);
            sb2.append(")");
            viewHolder.entityName.setText(sb2);
            li.u.x(this.trophyURL, viewHolder.entityLogo);
            if (this.isSelected) {
                viewHolder.entityName.setTextColor(p0.A(R.attr.U0));
                viewHolder.entityLogo.setAlpha(1.0f);
                viewHolder.entityName.setTypeface(o0.c(App.m()));
            } else {
                viewHolder.entityName.setTextColor(p0.A(R.attr.f21565m1));
                viewHolder.entityLogo.setAlpha(0.5f);
                viewHolder.entityName.setTypeface(o0.d(App.m()));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setSelected(boolean z10) {
        this.isSelected = z10;
    }
}
