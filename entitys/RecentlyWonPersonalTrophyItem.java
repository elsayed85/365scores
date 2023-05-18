package com.scores365.entitys;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.entitys.RecentlyWonPersonalTrophyItem;
import ee.k;
import ee.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.u;
import li.x0;
import nb.o;
import nb.v;
import rf.c2;
/* compiled from: RecentlyWonPersonalTrophyItem.kt */
/* loaded from: classes2.dex */
public final class RecentlyWonPersonalTrophyItem extends com.scores365.Design.PageObjects.b {
    public static final Companion Companion = new Companion(null);
    private final int athleteId;
    private final CompetitionObj competitionObj;
    private final RecentlyWonPersonalTrophyObj recentlyWonPersonalTrophyObj;

    /* compiled from: RecentlyWonPersonalTrophyItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t onCreateViewHolder(ViewGroup parent, q.e clickListener) {
            m.g(parent, "parent");
            m.g(clickListener, "clickListener");
            c2 c10 = c2.c(LayoutInflater.from(parent.getContext()), parent, false);
            m.f(c10, "inflate(\n               …      false\n            )");
            return new ViewHolder(c10, clickListener);
        }
    }

    /* compiled from: RecentlyWonPersonalTrophyItem.kt */
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends t {
        private final c2 binding;
        private final q.e clickListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(c2 binding, q.e clickListener) {
            super(binding.getRoot());
            m.g(binding, "binding");
            m.g(clickListener, "clickListener");
            this.binding = binding;
            this.clickListener = clickListener;
        }

        private final void actionListener(int i10, int i11) {
            Intent r10 = x0.r(App.c.LEAGUE, i10, eDashboardSection.COMPETITION_DETAILS, new l("", "player_card_last_trophy"), false, 0);
            r10.setFlags(268435456);
            App.m().startActivity(r10);
            k.n(App.m(), "athlete", "last-trophy", "entity", "click", true, "athlete_id", String.valueOf(i11), "competition_id", String.valueOf(i10), "click_type", "competition");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4$lambda$1$lambda$0(ViewHolder this$0, View view) {
            m.g(this$0, "this$0");
            this$0.clickListener.OnRecylerItemClick(this$0.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4$lambda$3$lambda$2(ViewHolder this$0, int i10, int i11, View view) {
            m.g(this$0, "this$0");
            this$0.actionListener(i10, i11);
        }

        public final void bind(RecentlyWonPersonalTrophyObj recentlyWonPersonalTrophyObj, CompetitionObj competitionObj, final int i10) {
            m.g(recentlyWonPersonalTrophyObj, "recentlyWonPersonalTrophyObj");
            m.g(competitionObj, "competitionObj");
            String component1 = recentlyWonPersonalTrophyObj.component1();
            final int component2 = recentlyWonPersonalTrophyObj.component2();
            c2 c2Var = this.binding;
            ConstraintLayout bind$lambda$4$lambda$1 = c2Var.getRoot();
            m.f(bind$lambda$4$lambda$1, "bind$lambda$4$lambda$1");
            v.u(bind$lambda$4$lambda$1);
            bind$lambda$4$lambda$1.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.entitys.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecentlyWonPersonalTrophyItem.ViewHolder.bind$lambda$4$lambda$1$lambda$0(RecentlyWonPersonalTrophyItem.ViewHolder.this, view);
                }
            });
            TextView tvThrophy = c2Var.f37609e;
            m.f(tvThrophy, "tvThrophy");
            v.v(tvThrophy, component1, v.m());
            TextView bind$lambda$4$lambda$3 = c2Var.f37608d;
            m.f(bind$lambda$4$lambda$3, "bind$lambda$4$lambda$3");
            v.v(bind$lambda$4$lambda$3, competitionObj.getShortName(), v.m());
            bind$lambda$4$lambda$3.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.entitys.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecentlyWonPersonalTrophyItem.ViewHolder.bind$lambda$4$lambda$3$lambda$2(RecentlyWonPersonalTrophyItem.ViewHolder.this, component2, i10, view);
                }
            });
            u.x(o.p(component2, "-1", 32, 48, -1), c2Var.f37607c);
        }

        public final c2 getBinding() {
            return this.binding;
        }

        public final q.e getClickListener() {
            return this.clickListener;
        }
    }

    public RecentlyWonPersonalTrophyItem(RecentlyWonPersonalTrophyObj recentlyWonPersonalTrophyObj, CompetitionObj competitionObj, int i10) {
        m.g(recentlyWonPersonalTrophyObj, "recentlyWonPersonalTrophyObj");
        m.g(competitionObj, "competitionObj");
        this.recentlyWonPersonalTrophyObj = recentlyWonPersonalTrophyObj;
        this.competitionObj = competitionObj;
        this.athleteId = i10;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.playerRecentlyWonTrophy.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof ViewHolder) {
            ((ViewHolder) e0Var).bind(new RecentlyWonPersonalTrophyObj(this.recentlyWonPersonalTrophyObj.getTitle(), this.recentlyWonPersonalTrophyObj.getCompetitionID()), this.competitionObj, this.athleteId);
        }
    }
}
