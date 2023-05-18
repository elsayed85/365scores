package com.scores365.gameCenter.gameCenterItems;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.PageObjects.e;
import com.scores365.Design.Pages.t;
import com.scores365.entitys.GameObj;
import li.x0;
import nb.u;
/* compiled from: GameCenterLineupsTeamChooserItem.java */
/* loaded from: classes2.dex */
public class a extends com.scores365.Design.PageObjects.e {

    /* compiled from: GameCenterLineupsTeamChooserItem.java */
    /* renamed from: com.scores365.gameCenter.gameCenterItems.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0251a {
        HOME,
        AWAY
    }

    public a(GameObj gameObj, EnumC0251a enumC0251a, boolean z10, int i10) {
        super(u.b(gameObj.getComps()[0]), u.b(gameObj.getComps()[1]), "", enumC0251a == EnumC0251a.HOME ? 1 : 2, x0.l(i10, true), false, 0.0f, false);
    }

    @Override // com.scores365.Design.PageObjects.e, com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LINEUPS_TEAMS_CHOOSER_ITEM.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.PageObjects.e
    public TextView getTab1TextView(e.b bVar) {
        try {
            return this.shouldReverse ? bVar.f20913g : bVar.f20912f;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.PageObjects.e
    public TextView getTab2TextView(e.b bVar) {
        try {
            return this.shouldReverse ? bVar.f20912f : bVar.f20913g;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.PageObjects.e
    public TextView getTab3TextView(e.b bVar) {
        return bVar.f20914h;
    }

    public EnumC0251a l() {
        try {
            return this.chosenTab == 1 ? EnumC0251a.HOME : EnumC0251a.AWAY;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.scores365.Design.PageObjects.e, com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        super.onBindViewHolder(e0Var, i10);
        try {
            e.b bVar = (e.b) e0Var;
            bVar.f20914h.setVisibility(8);
            int p10 = App.p() / 6;
            View view = ((t) bVar).itemView;
            view.setPadding(p10, view.getPaddingTop(), p10, ((t) bVar).itemView.getPaddingBottom());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
