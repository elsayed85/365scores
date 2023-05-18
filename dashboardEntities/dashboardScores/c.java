package com.scores365.dashboardEntities.dashboardScores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: ScoreItemNoGames.java */
/* loaded from: classes2.dex */
public class c extends i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScoreItemNoGames.java */
    /* loaded from: classes2.dex */
    public static class a extends t {

        /* renamed from: f  reason: collision with root package name */
        TextView f23436f;

        /* renamed from: g  reason: collision with root package name */
        TextView f23437g;

        public a(View view, q.e eVar) {
            super(view);
            this.f23436f = (TextView) view.findViewById(R.id.f22373w4);
            this.f23437g = (TextView) view.findViewById(R.id.Zo);
            this.f23436f.setTypeface(o0.d(App.m()));
            this.f23437g.setTypeface(o0.c(App.m()));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.H7, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.i
    public long getId() {
        return 0L;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.noItems.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        return 1;
    }

    public int hashCode() {
        return getObjectTypeNum();
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        a aVar = (a) e0Var;
        try {
            aVar.f23436f.setText(p0.l0("SELECTED_TEAMS_NOT_PLAY"));
            aVar.f23437g.setText(p0.l0("EMPTY_SCREEN_SCORES_BUTTON"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
