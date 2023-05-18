package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.ScoreBoxObjects.ScoreBoxRowHelperObject;
import java.util.ArrayList;
import java.util.Iterator;
import lf.u;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ProfileTrophyItem extends com.scores365.Design.PageObjects.b {
    ClickType clickType = null;
    private ArrayList<ScoreBoxRowHelperObject> seasonsRows;
    private boolean showOnly3;
    private ArrayList<TableRow> statisticsRows;

    /* loaded from: classes2.dex */
    public enum ClickType {
        DownArrow,
        BoxScore
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        private TableLayout scoreboxTableView;
        private TableLayout seasonsTableView;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                this.seasonsTableView = (TableLayout) view.findViewById(R.id.f22262r4);
                TableLayout tableLayout = (TableLayout) view.findViewById(R.id.f22285s4);
                this.scoreboxTableView = tableLayout;
                tableLayout.getLayoutParams().width = p0.s((int) (p0.A0(App.p()) * 0.4d));
                this.seasonsTableView.getLayoutParams().width = p0.s((int) (p0.A0(App.p()) * 0.6d));
                this.scoreboxTableView.setStretchAllColumns(true);
                view.setSoundEffectsEnabled(false);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public ProfileTrophyItem(ArrayList<ScoreBoxRowHelperObject> arrayList, ArrayList<TableRow> arrayList2, boolean z10) {
        this.seasonsRows = arrayList;
        this.statisticsRows = arrayList2;
        this.showOnly3 = z10;
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.F7, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.G7, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public long getItemId() {
        double d10 = -1.0d;
        try {
            double random = Math.random();
            String l02 = p0.l0("DISABLED_NOTIFICATIONS_NOTICE");
            if (l02 != null) {
                if (random == -1.0d) {
                    random = l02.hashCode();
                }
                d10 = (-1.0d) + random;
            } else {
                d10 = super.getItemId();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return (long) d10;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.ProfileTropyItem.ordinal();
    }

    public boolean isShowOnly3() {
        return this.showOnly3;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            int i11 = 0;
            if (this.seasonsRows != null) {
                viewHolder.seasonsTableView.removeAllViews();
                Iterator<ScoreBoxRowHelperObject> it = this.seasonsRows.iterator();
                int i12 = 0;
                while (it.hasNext()) {
                    ScoreBoxRowHelperObject next = it.next();
                    if (next.getTableRow().getParent() != null) {
                        ((ViewGroup) next.getTableRow().getParent()).removeView(next.getTableRow());
                    }
                    viewHolder.seasonsTableView.addView(next.getTableRow());
                    if (next.isAllPlayersShouldHaveImg()) {
                        li.u.A(next.getLink(), next.getPlayerIV(), p0.K(R.attr.f21594w0));
                        next.getPlayerIV().setVisibility(0);
                    }
                    i12++;
                    if (this.showOnly3 && i12 > 3) {
                        break;
                    }
                }
            }
            if (this.statisticsRows != null) {
                viewHolder.scoreboxTableView.removeAllViews();
                Iterator<TableRow> it2 = this.statisticsRows.iterator();
                while (it2.hasNext()) {
                    TableRow next2 = it2.next();
                    if (next2 != null && next2.getParent() != null) {
                        ((ViewGroup) next2.getParent()).removeView(next2);
                    }
                    viewHolder.scoreboxTableView.addView(next2);
                    if (this.showOnly3 && i11 == 3) {
                        return;
                    }
                    i11++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setSeasonsRows(ArrayList<ScoreBoxRowHelperObject> arrayList) {
        this.seasonsRows = arrayList;
    }

    public void setShowOnly3() {
        this.showOnly3 = !this.showOnly3;
    }

    public void setShowOnly3(boolean z10) {
        this.showOnly3 = z10;
    }

    public void setStatisticsRows(ArrayList<TableRow> arrayList) {
        this.statisticsRows = arrayList;
    }
}
