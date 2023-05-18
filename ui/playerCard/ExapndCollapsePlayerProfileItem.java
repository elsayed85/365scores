package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.f;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
/* loaded from: classes2.dex */
public class ExapndCollapsePlayerProfileItem extends com.scores365.Design.PageObjects.b implements f.a {
    private String analSource;
    private int collapsedItemsCount;
    private boolean isExpanded;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ImageView arrowImage;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            this.arrowImage = (ImageView) view.findViewById(R.id.f22092ja);
            view.setOnClickListener(new u(this, eVar));
        }
    }

    public ExapndCollapsePlayerProfileItem(boolean z10, int i10, String str) {
        this.isExpanded = z10;
        this.collapsedItemsCount = i10;
        this.analSource = str;
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22743w6, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.f.a
    public String getAnalyticsSource() {
        return this.analSource;
    }

    @Override // com.scores365.Design.PageObjects.f.a
    public int getCollapsedItemsCount() {
        return this.collapsedItemsCount;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerTransferShowAllItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.f.a
    public boolean isExpanded() {
        return this.isExpanded;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ViewHolder viewHolder = (ViewHolder) e0Var;
        if (this.isExpanded) {
            viewHolder.arrowImage.setRotation(180.0f);
        } else {
            viewHolder.arrowImage.setRotation(0.0f);
        }
    }

    @Override // com.scores365.Design.PageObjects.f.a
    public void setExpanded(boolean z10) {
        this.isExpanded = z10;
    }
}
