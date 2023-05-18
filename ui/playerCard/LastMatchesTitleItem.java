package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.LastMatchesHeaderObj;
import com.scores365.ui.playerCard.CustomHorizontalScrollView;
import com.scores365.ui.playerCard.LastMatchGameItem;
import com.scores365.ui.playerCard.LastMatchesTitleItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: LastMatchesTitleItem.kt */
/* loaded from: classes2.dex */
public final class LastMatchesTitleItem extends com.scores365.Design.PageObjects.b implements CustomHorizontalScrollView.Companion.iScrollListener {
    public static final Companion Companion = new Companion(null);
    private ArrayList<LastMatchesHeaderObj> headers;
    private int itemPosition;
    private final LastMatchGameItem.iScrollListener scrollListener;
    private final String teamName;
    private int topMargin;

    /* compiled from: LastMatchesTitleItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* compiled from: LastMatchesTitleItem.kt */
        /* loaded from: classes2.dex */
        public static final class ViewHolder extends t implements LastMatchGameItem.iSyncScrolledViewHolder {
            private final CustomHorizontalScrollView statsScrollView;
            private final LinearLayout statsScrolledContainer;
            private final TextView teamNameText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(View itemView, q.e eVar) {
                super(itemView);
                kotlin.jvm.internal.m.g(itemView, "itemView");
                View findViewById = itemView.findViewById(R.id.f22045h8);
                kotlin.jvm.internal.m.f(findViewById, "itemView.findViewById(R.id.hsv_stats_scroll_view)");
                this.statsScrollView = (CustomHorizontalScrollView) findViewById;
                View findViewById2 = itemView.findViewById(R.id.f22407xg);
                kotlin.jvm.internal.m.f(findViewById2, "itemView.findViewById(R.…scrolled_stats_container)");
                this.statsScrolledContainer = (LinearLayout) findViewById2;
                View findViewById3 = itemView.findViewById(R.id.uG);
                kotlin.jvm.internal.m.f(findViewById3, "itemView.findViewById(R.id.tv_team_name)");
                TextView textView = (TextView) findViewById3;
                this.teamNameText = textView;
                if (x0.l1()) {
                    itemView.setLayoutDirection(1);
                } else {
                    itemView.setLayoutDirection(0);
                }
                textView.setTypeface(o0.d(App.m()));
                ((t) this).itemView.setOnClickListener(new u(this, eVar));
            }

            public final CustomHorizontalScrollView getStatsScrollView() {
                return this.statsScrollView;
            }

            public final LinearLayout getStatsScrolledContainer() {
                return this.statsScrolledContainer;
            }

            public final TextView getTeamNameText() {
                return this.teamNameText;
            }

            @Override // com.scores365.Design.Pages.t
            public boolean isSupportRTL() {
                return true;
            }

            @Override // com.scores365.ui.playerCard.LastMatchGameItem.iSyncScrolledViewHolder
            public void scrollStatContainer(int i10) {
                try {
                    this.statsScrollView.scrollTo(i10, 0);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ViewHolder onCreateViewHolder(ViewGroup parent, q.e eVar) {
            kotlin.jvm.internal.m.g(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.E3, parent, false);
            kotlin.jvm.internal.m.f(inflate, "from(parent.context).inf…itle_item, parent, false)");
            return new ViewHolder(inflate, eVar);
        }
    }

    public LastMatchesTitleItem(String teamName, ArrayList<LastMatchesHeaderObj> headers, LastMatchGameItem.iScrollListener iscrolllistener) {
        kotlin.jvm.internal.m.g(teamName, "teamName");
        kotlin.jvm.internal.m.g(headers, "headers");
        this.teamName = teamName;
        this.headers = headers;
        this.scrollListener = iscrolllistener;
        this.topMargin = p0.s(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(LastMatchesTitleItem this$0, LastMatchesHeaderObj header, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(header, "$header");
        String description = header.getDescription();
        this$0.showToast(description == null || description.length() == 0 ? header.getTitle() : header.getDescription());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(Companion.ViewHolder holder, LastMatchesTitleItem this$0) {
        kotlin.jvm.internal.m.g(holder, "$holder");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        try {
            holder.getStatsScrollView().scrollTo(this$0.scrollListener.getCurrentLastMatchesScrollPosition(), 0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private final void showToast(String str) {
        Toast.makeText(App.m(), str, 0).show();
    }

    public final ArrayList<LastMatchesHeaderObj> getHeaders() {
        return this.headers;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.LastMatchesTitleItem.ordinal();
    }

    public final LastMatchGameItem.iScrollListener getScrollListener() {
        return this.scrollListener;
    }

    public final String getTeamName() {
        return this.teamName;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            kotlin.jvm.internal.m.e(e0Var, "null cannot be cast to non-null type com.scores365.ui.playerCard.LastMatchesTitleItem.Companion.ViewHolder");
            final Companion.ViewHolder viewHolder = (Companion.ViewHolder) e0Var;
            viewHolder.getStatsScrolledContainer().removeAllViews();
            viewHolder.getStatsScrolledContainer().addView(new View(App.m()), new LinearLayout.LayoutParams(LastMatchGameBasketballItem.STATS_OFFSET, -1, 0.0f));
            Iterator<LastMatchesHeaderObj> it = this.headers.iterator();
            while (it.hasNext()) {
                final LastMatchesHeaderObj next = it.next();
                TextView returnReasonTV = LastMatchGameItem.returnReasonTV(next.getTitle(), 0, false, true, true, false);
                LinearLayout statsScrolledContainer = viewHolder.getStatsScrolledContainer();
                returnReasonTV.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.playerCard.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LastMatchesTitleItem.onBindViewHolder$lambda$1$lambda$0(LastMatchesTitleItem.this, next, view);
                    }
                });
                statsScrolledContainer.addView(returnReasonTV);
            }
            viewHolder.getStatsScrollView().setScrollListener(this);
            this.itemPosition = i10;
            if (x0.l1()) {
                viewHolder.getStatsScrollView().setRotationY(180.0f);
                viewHolder.getStatsScrolledContainer().setRotationY(180.0f);
            }
            if (this.scrollListener != null) {
                viewHolder.getStatsScrollView().post(new Runnable() { // from class: com.scores365.ui.playerCard.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        LastMatchesTitleItem.onBindViewHolder$lambda$2(LastMatchesTitleItem.Companion.ViewHolder.this, this);
                    }
                });
            }
            viewHolder.getTeamNameText().setText(this.teamName);
            viewHolder.getTeamNameText().setGravity((x0.l1() ? 5 : 3) | 16);
            ViewGroup.LayoutParams layoutParams = ((t) viewHolder).itemView.getLayoutParams();
            kotlin.jvm.internal.m.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.topMargin;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.CustomHorizontalScrollView.Companion.iScrollListener
    public void onScrolled(int i10, int i11, int i12, int i13) {
        try {
            LastMatchGameItem.iScrollListener iscrolllistener = this.scrollListener;
            if (iscrolllistener != null) {
                iscrolllistener.onLastMatchHorizontalScroll(i10, this.itemPosition);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void setHeaders(ArrayList<LastMatchesHeaderObj> arrayList) {
        kotlin.jvm.internal.m.g(arrayList, "<set-?>");
        this.headers = arrayList;
    }

    public final void setTopMargin(int i10) {
        this.topMargin = i10;
    }
}
