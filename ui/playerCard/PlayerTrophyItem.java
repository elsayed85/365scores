package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.PageObjects.f;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import li.o0;
import li.p0;
/* loaded from: classes2.dex */
public class PlayerTrophyItem extends com.scores365.Design.PageObjects.b implements f.b {
    private boolean isHidden = false;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        TextView bootNumber;
        ImageView competitorLogo;
        TextView competitorName;
        TextView goalNumber;
        TextView pitchNumber;
        TextView trophyDate;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            this.competitorLogo = (ImageView) view.findViewById(R.id.f21911bb);
            this.competitorName = (TextView) view.findViewById(R.id.Qx);
            this.trophyDate = (TextView) view.findViewById(R.id.BH);
            this.goalNumber = (TextView) view.findViewById(R.id.eA);
            this.bootNumber = (TextView) view.findViewById(R.id.Yw);
            this.pitchNumber = (TextView) view.findViewById(R.id.fC);
            this.competitorName.setTypeface(o0.d(App.m()));
            this.trophyDate.setTypeface(o0.d(App.m()));
            this.goalNumber.setTypeface(o0.d(App.m()));
            this.bootNumber.setTypeface(o0.d(App.m()));
            this.pitchNumber.setTypeface(o0.d(App.m()));
            view.setOnClickListener(new u(this, eVar));
        }
    }

    public PlayerTrophyItem(boolean z10) {
        setHidden(z10);
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.A6, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerTrophyItem.ordinal();
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            if (isHidden()) {
                ((t) viewHolder).itemView.getLayoutParams().height = 0;
                ((ViewGroup.MarginLayoutParams) ((t) viewHolder).itemView.getLayoutParams()).topMargin = 0;
            } else {
                ((t) viewHolder).itemView.getLayoutParams().height = p0.s(44);
                ((ViewGroup.MarginLayoutParams) ((t) viewHolder).itemView.getLayoutParams()).topMargin = p0.s(1);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.scores365.Design.PageObjects.f.b
    public void setHidden(boolean z10) {
        this.isHidden = z10;
    }

    @Override // com.scores365.Design.PageObjects.f.b
    public void setShouldAnimate(boolean z10) {
    }
}
