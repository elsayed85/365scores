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
import java.util.Date;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerLastMatchExpandItem extends com.scores365.Design.PageObjects.b {
    private boolean isExpanded;
    private String numOfGamesOut;
    private StringBuilder outDates;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ImageView arrowImage;
        TextView datesText;
        TextView gamesNumberText;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.datesText = (TextView) view.findViewById(R.id.ny);
                this.gamesNumberText = (TextView) view.findViewById(R.id.Yz);
                this.arrowImage = (ImageView) view.findViewById(R.id.f22092ja);
                this.datesText.setTypeface(o0.d(App.m()));
                this.gamesNumberText.setTypeface(o0.d(App.m()));
                ((t) this).itemView.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public PlayerLastMatchExpandItem(boolean z10, int i10, Date date, Date date2) {
        this.isExpanded = z10;
        StringBuilder sb2 = new StringBuilder();
        this.outDates = sb2;
        sb2.append(x0.T(date, true));
        this.outDates.append(" - ");
        this.outDates.append(x0.T(date2, true));
        this.numOfGamesOut = p0.l0("NEW_PLAYER_CARD_DIDNT_PARTICIPATED_STATUS").replace("#", String.valueOf(i10));
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22633n6, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22620m6, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerLastMatchExpandItem.ordinal();
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            if (this.isExpanded) {
                viewHolder.arrowImage.setRotation(180.0f);
                viewHolder.gamesNumberText.setText("");
            } else {
                viewHolder.arrowImage.setRotation(0.0f);
                viewHolder.gamesNumberText.setText(this.numOfGamesOut);
            }
            viewHolder.datesText.setText(this.outDates);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setExpanded(boolean z10) {
        this.isExpanded = z10;
    }
}
