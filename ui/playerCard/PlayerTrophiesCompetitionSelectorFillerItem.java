package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import lf.u;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerTrophiesCompetitionSelectorFillerItem extends com.scores365.Design.PageObjects.b {
    boolean isHalfWidthRegularItem;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public PlayerTrophiesCompetitionSelectorFillerItem(boolean z10) {
        this.isHalfWidthRegularItem = z10;
    }

    public static t onCreateViewHolder(ViewGroup viewGroup) {
        try {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22555h6, viewGroup, false));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerTrophiesCompetitionSelectorFillerItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ViewHolder viewHolder = (ViewHolder) e0Var;
        if (this.isHalfWidthRegularItem) {
            ((t) viewHolder).itemView.getLayoutParams().width = App.p() / 6;
            return;
        }
        ((t) viewHolder).itemView.getLayoutParams().width = App.p() / 3;
    }
}
