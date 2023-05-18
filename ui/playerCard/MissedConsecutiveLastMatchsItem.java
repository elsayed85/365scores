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
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class MissedConsecutiveLastMatchsItem extends com.scores365.Design.PageObjects.b {
    private long randomId = -1;

    /* loaded from: classes2.dex */
    public static class MissedConsecutiveLastMatchsItemViewHolder extends t {
        TextView datesBetweenTV;
        TextView didntPlayXmatchesTV;
        ImageView downArrowIV;

        public MissedConsecutiveLastMatchsItemViewHolder(View view, q.e eVar) {
            super(view);
            this.datesBetweenTV = (TextView) view.findViewById(R.id.f22351v4);
            this.didntPlayXmatchesTV = (TextView) view.findViewById(R.id.B4);
            this.downArrowIV = (ImageView) view.findViewById(R.id.E);
            this.datesBetweenTV.setTypeface(o0.d(App.m()));
            this.didntPlayXmatchesTV.setTypeface(o0.d(App.m()));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }
    }

    public static MissedConsecutiveLastMatchsItemViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new MissedConsecutiveLastMatchsItemViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22475b4, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22462a4, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.MissedConsecutiveLastMatchsItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        try {
            return com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
    }
}
