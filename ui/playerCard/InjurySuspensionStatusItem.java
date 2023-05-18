package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.ui.playerCard.PlayerCardNextGameItem;
import lf.u;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class InjurySuspensionStatusItem extends com.scores365.Design.PageObjects.b {
    private final PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData injuryData;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        private final ImageView ivIcon;
        private final TextView tvMessage;
        private final TextView tvMessageSecondary;

        public ViewHolder(View view) {
            super(view);
            this.ivIcon = (ImageView) view.findViewById(R.id.Mb);
            TextView textView = (TextView) view.findViewById(R.id.wB);
            this.tvMessage = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.OD);
            this.tvMessageSecondary = textView2;
            textView.setTypeface(o0.d(App.m()));
            textView2.setTypeface(o0.d(App.m()));
            if (x0.l1()) {
                view.setLayoutDirection(1);
            }
        }

        @Override // com.scores365.Design.Pages.t
        public boolean isSupportRTL() {
            return true;
        }
    }

    public InjurySuspensionStatusItem(PlayerCardNextGameItem.Companion.InjurySuspensionStatusItemData injurySuspensionStatusItemData) {
        this.injuryData = injurySuspensionStatusItemData;
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22716u3, viewGroup, false));
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerInjurySuspensionStatusItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            viewHolder.tvMessage.setText(this.injuryData.getMessage());
            if (this.injuryData.getMessage() == null || !this.injuryData.getMessage().isEmpty()) {
                viewHolder.tvMessage.setVisibility(0);
            } else {
                viewHolder.tvMessage.setVisibility(8);
            }
            if (this.injuryData.getMessageSecondary() == null || !this.injuryData.getMessageSecondary().isEmpty()) {
                viewHolder.tvMessageSecondary.setVisibility(0);
            } else {
                viewHolder.tvMessageSecondary.setVisibility(8);
            }
            viewHolder.tvMessageSecondary.setText(this.injuryData.getMessageSecondary());
            if (this.injuryData.getIconLink() == null || this.injuryData.getIconLink().isEmpty()) {
                viewHolder.ivIcon.setImageResource(this.injuryData.getIconResource());
            } else {
                li.u.x(this.injuryData.getIconLink(), viewHolder.ivIcon);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
