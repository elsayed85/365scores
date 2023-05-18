package com.scores365.ui.playerCard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.SocialStatEntity;
import com.scores365.ui.WebViewActivity;
import java.util.ArrayList;
import java.util.Iterator;
import lf.u;
import li.o0;
import li.x0;
import nb.o;
/* loaded from: classes2.dex */
public class SocialStatItem extends com.scores365.Design.PageObjects.b {
    private ArrayList<SocialCLickListener> clickListeners = new ArrayList<>();
    private ArrayList<SocialStatEntity> socialStatEntities;

    /* loaded from: classes2.dex */
    private static class SocialCLickListener implements View.OnClickListener {
        private int athleteId;
        private SocialStatEntity socialStatEntity;

        public SocialCLickListener(SocialStatEntity socialStatEntity, int i10) {
            this.socialStatEntity = socialStatEntity;
            this.athleteId = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(App.m(), WebViewActivity.class);
                intent.putExtra("url", this.socialStatEntity.url);
                intent.addFlags(268435456);
                App.m().startActivity(intent);
                ee.k.n(App.m(), "athlete", "social", "click", null, true, "athlete_id", String.valueOf(this.athleteId), "network", this.socialStatEntity.providerName);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ArrayList<ConstraintLayout> containers;
        ArrayList<View> dividers;
        ArrayList<TextView> mediaAmounts;
        ArrayList<ImageView> mediaLogos;
        ArrayList<TextView> mediaNames;

        public ViewHolder(View view) {
            super(view);
            this.containers = new ArrayList<>();
            this.mediaLogos = new ArrayList<>();
            this.mediaNames = new ArrayList<>();
            this.mediaAmounts = new ArrayList<>();
            this.dividers = new ArrayList<>();
            this.containers.add((ConstraintLayout) view.findViewById(R.id.f22054hh));
            this.containers.add((ConstraintLayout) view.findViewById(R.id.f22075ih));
            this.containers.add((ConstraintLayout) view.findViewById(R.id.f22099jh));
            for (int i10 = 0; i10 < 3; i10++) {
                this.mediaLogos.add((ImageView) this.containers.get(i10).findViewById(R.id.f22004fc));
                this.mediaNames.add((TextView) this.containers.get(i10).findViewById(R.id.vB));
                this.mediaAmounts.add((TextView) this.containers.get(i10).findViewById(R.id.uB));
                this.dividers.add(this.containers.get(i10).findViewById(R.id.G4));
                this.mediaNames.get(i10).setTypeface(o0.d(App.m()));
                this.mediaAmounts.get(i10).setTypeface(o0.d(App.m()));
            }
            if (this.containers.size() > 0) {
                ArrayList<ConstraintLayout> arrayList = this.containers;
                arrayList.get(arrayList.size() - 1).findViewById(R.id.G4).setVisibility(8);
            }
        }
    }

    public SocialStatItem(ArrayList<SocialStatEntity> arrayList, int i10) {
        this.socialStatEntities = arrayList;
        Iterator<SocialStatEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            this.clickListeners.add(new SocialCLickListener(it.next(), i10));
        }
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.Q8, viewGroup, false));
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerSocialStatItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            Iterator<SocialStatEntity> it = this.socialStatEntities.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                SocialStatEntity next = it.next();
                viewHolder.mediaNames.get(i11).setText(next.providerName);
                viewHolder.mediaAmounts.get(i11).setText(next.displayFollowers);
                li.u.x(o.v(next.provider, true, x0.n1()), viewHolder.mediaLogos.get(i11));
                viewHolder.containers.get(i11).setOnClickListener(this.clickListeners.get(i11));
                i11++;
            }
            if (this.socialStatEntities.size() == 2) {
                viewHolder.containers.get(2).setVisibility(8);
                ((LinearLayout) ((t) viewHolder).itemView).setWeightSum(2.0f);
                viewHolder.dividers.get(1).setVisibility(8);
            } else if (this.socialStatEntities.size() == 1) {
                viewHolder.containers.get(1).setVisibility(8);
                viewHolder.containers.get(2).setVisibility(8);
                viewHolder.dividers.get(0).setVisibility(8);
                ((LinearLayout) ((t) viewHolder).itemView).setWeightSum(1.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
