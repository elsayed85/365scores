package com.scores365.ui.playerCard;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.e;
import com.scores365.Design.Pages.t;
import lf.u;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerCardTrophiesChooserItem extends com.scores365.Design.PageObjects.e {
    int[] tabTrophyTypeIds;

    public PlayerCardTrophiesChooserItem(String str, String str2, String str3, int i10, boolean z10, boolean z11, float f10, int i11, int i12, int i13) {
        super(str, str2, str3, i10, z10, z11, f10, false);
        this.tabTrophyTypeIds = r0;
        int[] iArr = {i11, i12, i13};
    }

    public int getChosenTrophyTab() {
        try {
            return this.tabTrophyTypeIds[getChosenTab() - 1];
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.Design.PageObjects.e, com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerTrophiesChooserItem.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.PageObjects.e
    public TextView getTab1TextView(e.b bVar) {
        TextView tab1TextView = super.getTab1TextView(bVar);
        try {
            if (getTab3Text().isEmpty()) {
                return this.shouldReverse ? bVar.f20913g : bVar.f20912f;
            }
            return tab1TextView;
        } catch (Exception e10) {
            e10.printStackTrace();
            return tab1TextView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.PageObjects.e
    public TextView getTab2TextView(e.b bVar) {
        TextView tab2TextView = super.getTab2TextView(bVar);
        try {
            if (getTab3Text().isEmpty()) {
                return this.shouldReverse ? bVar.f20912f : bVar.f20913g;
            }
            return tab2TextView;
        } catch (Exception e10) {
            x0.N1(e10);
            return tab2TextView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.PageObjects.e
    public TextView getTab3TextView(e.b bVar) {
        TextView tab3TextView = super.getTab3TextView(bVar);
        try {
            return getTab3Text().isEmpty() ? bVar.f20914h : tab3TextView;
        } catch (Exception e10) {
            x0.N1(e10);
            return tab3TextView;
        }
    }

    @Override // com.scores365.Design.PageObjects.e, com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        super.onBindViewHolder(e0Var, i10);
        try {
            e.b bVar = (e.b) e0Var;
            ((t) bVar).itemView.setPadding(p0.s(70), ((t) bVar).itemView.getPaddingTop(), p0.s(70), ((t) bVar).itemView.getPaddingBottom());
            if (getTab3Text().isEmpty()) {
                bVar.f20914h.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
