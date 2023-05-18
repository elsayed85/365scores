package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import lf.u;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerTrophiesTitleIconsItem extends com.scores365.Design.PageObjects.b {

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        private ImageView ivIcon;
        private TextView tvMessage;

        public ViewHolder(View view) {
            super(view);
            this.tvMessage = (TextView) view.findViewById(R.id.wB);
            this.ivIcon = (ImageView) view.findViewById(R.id.Mb);
            if (x0.l1()) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) this.ivIcon.getLayoutParams();
                bVar.f4628h = 0;
                bVar.f4622e = -1;
                bVar.f4630i = 0;
                bVar.f4636l = 0;
                ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.tvMessage.getLayoutParams();
                bVar2.f4626g = this.ivIcon.getId();
                bVar2.f4624f = -1;
                bVar2.f4630i = 0;
                bVar2.f4636l = 0;
            }
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22779z6, viewGroup, false));
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerTrophiesTitleItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
