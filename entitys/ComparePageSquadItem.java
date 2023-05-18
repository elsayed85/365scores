package com.scores365.entitys;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import ee.k;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ComparePageSquadItem extends com.scores365.Design.PageObjects.b {
    public SquadInsertionItem itemToBind;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        RelativeLayout container;
        RelativeLayout containerRTL;
        long itemID;
        ImageView ivClubImage;
        ImageView ivPlayerImage;
        ImageView ivPlayerJerseyNum;
        TextView tvPlayerJerseyNum;
        TextView tvPlayerName;
        TextView tvPlayerPosition;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.container = (RelativeLayout) view.findViewById(R.id.Kn);
                this.containerRTL = (RelativeLayout) view.findViewById(R.id.Ln);
                this.container.setVisibility(8);
                this.containerRTL.setVisibility(8);
                if (x0.l1()) {
                    this.containerRTL.setVisibility(0);
                    this.ivPlayerImage = (ImageView) view.findViewById(R.id.Hq);
                    this.ivClubImage = (ImageView) view.findViewById(R.id.Rd);
                    this.tvPlayerName = (TextView) view.findViewById(R.id.Nq);
                    this.tvPlayerPosition = (TextView) view.findViewById(R.id.Pq);
                    this.ivPlayerJerseyNum = (ImageView) view.findViewById(R.id.Jq);
                    TextView textView = (TextView) view.findViewById(R.id.Lq);
                    this.tvPlayerJerseyNum = textView;
                    textView.setVisibility(4);
                    this.ivPlayerJerseyNum.setVisibility(0);
                } else {
                    this.container.setVisibility(0);
                    this.ivPlayerImage = (ImageView) view.findViewById(R.id.Gq);
                    this.ivClubImage = (ImageView) view.findViewById(R.id.Qd);
                    this.tvPlayerName = (TextView) view.findViewById(R.id.Mq);
                    this.tvPlayerPosition = (TextView) view.findViewById(R.id.Oq);
                    this.ivPlayerJerseyNum = (ImageView) view.findViewById(R.id.Iq);
                    TextView textView2 = (TextView) view.findViewById(R.id.Kq);
                    this.tvPlayerJerseyNum = textView2;
                    textView2.setVisibility(4);
                    this.ivPlayerJerseyNum.setVisibility(0);
                }
                this.tvPlayerName.setTypeface(o0.d(App.m()));
                this.tvPlayerPosition.setTypeface(o0.d(App.m()));
                view.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public ComparePageSquadItem(SquadInsertionItem squadInsertionItem) {
        this.itemToBind = squadInsertionItem;
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.U8, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.compareSquadItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            li.u.D(this.itemToBind.getCharacterImage(), viewHolder.ivPlayerImage, null, true);
            viewHolder.tvPlayerName.setText(this.itemToBind.getCharacterName());
            li.u.x(this.itemToBind.getCharacterImageRight(), viewHolder.ivPlayerJerseyNum);
            viewHolder.tvPlayerPosition.setText(this.itemToBind.getCharacterRole());
            viewHolder.ivClubImage.setVisibility(0);
            li.u.x(this.itemToBind.getCharacterFlag(), viewHolder.ivClubImage);
            viewHolder.container.setBackgroundResource(p0.T(R.attr.f21560l));
            viewHolder.containerRTL.setBackgroundResource(p0.T(R.attr.f21560l));
            ((t) viewHolder).itemView.setSoundEffectsEnabled(true);
            viewHolder.containerRTL.setBackgroundResource(p0.A(R.attr.f21560l));
            viewHolder.container.setBackgroundResource(p0.A(R.attr.f21560l));
            ((t) viewHolder).itemView.setSoundEffectsEnabled(false);
            x0.S(this.itemToBind.getImpressionUrl());
            k.n(App.m(), "ad", ServerProtocol.DIALOG_PARAM_DISPLAY, null, null, false, AppEventsConstants.EVENT_PARAM_AD_TYPE, "squad_insertion", "ad_screen", "PlayersList", "network", "SpecialExcutions");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
