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
public class SeeAllTableItem extends com.scores365.Design.PageObjects.b {
    public static final int SHOW_ALL_PROFILE_STAT = 1;
    public static final int SHOW_ALL_PROFILE_TROPHIES = 2;
    public static final int SHOW_ALL_STAT_LAST_MATCHES = 3;
    boolean isExpanded;
    private long randomId;
    String title;
    public int type;

    /* loaded from: classes2.dex */
    public static class SeeAllTableItemHolder extends t {
        ImageView arrowImage;
        TextView seeAllTV;

        public SeeAllTableItemHolder(View view, q.e eVar) {
            super(view);
            this.arrowImage = (ImageView) view.findViewById(R.id.f22092ja);
            TextView textView = (TextView) view.findViewById(R.id.Xo);
            this.seeAllTV = textView;
            textView.setVisibility(8);
            this.seeAllTV.setTypeface(o0.c(App.m()));
            this.arrowImage.setVisibility(8);
            view.setOnClickListener(new u(this, eVar));
        }
    }

    public SeeAllTableItem(String str, int i10) {
        this.randomId = -1L;
        this.isExpanded = false;
        this.title = str;
        this.type = i10;
    }

    public SeeAllTableItem(String str, int i10, boolean z10) {
        this.randomId = -1L;
        this.title = str;
        this.type = i10;
        this.isExpanded = z10;
    }

    public static SeeAllTableItemHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new SeeAllTableItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22743w6, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public long getItemId() {
        try {
            String str = this.title;
            if (str != null) {
                if (this.randomId == -1) {
                    this.randomId = str.hashCode();
                }
                return 1 + this.randomId;
            }
            return super.getItemId();
        } catch (Exception e10) {
            x0.N1(e10);
            return 1L;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.SeeAllTableItem.ordinal();
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        SeeAllTableItemHolder seeAllTableItemHolder = (SeeAllTableItemHolder) e0Var;
        String str = this.title;
        if (str != null && !str.isEmpty()) {
            seeAllTableItemHolder.arrowImage.setVisibility(8);
            seeAllTableItemHolder.seeAllTV.setVisibility(0);
            seeAllTableItemHolder.seeAllTV.setText(this.title);
            return;
        }
        seeAllTableItemHolder.arrowImage.setVisibility(0);
        seeAllTableItemHolder.seeAllTV.setVisibility(8);
        if (this.isExpanded) {
            seeAllTableItemHolder.arrowImage.setRotation(180.0f);
        } else {
            seeAllTableItemHolder.arrowImage.setRotation(0.0f);
        }
    }

    public void setExpanded() {
        this.isExpanded = !this.isExpanded;
    }
}
