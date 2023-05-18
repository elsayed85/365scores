package com.scores365.PlayerCard;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.entitys.AthleteStats;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameStats;
import com.scores365.entitys.LastMatchesHeaderObj;
import com.scores365.entitys.LastMatchesObj;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.ui.playerCard.LastMatchGameItem;
import com.scores365.ui.playerCard.LastMatchesTitleItem;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import li.x0;
import se.f;
import zb.k;
import zb.l;
/* compiled from: PlayerTopStatsDialogListPage.java */
/* loaded from: classes2.dex */
public class c extends q implements LastMatchGameItem.iScrollListener {

    /* renamed from: l  reason: collision with root package name */
    private LastMatchesObj f21381l;

    /* renamed from: m  reason: collision with root package name */
    int f21382m = 0;

    public static c z1(LastMatchesObj lastMatchesObj, int i10, int i11, boolean z10) {
        c cVar = new c();
        try {
            cVar.f21381l = lastMatchesObj;
            Bundle bundle = new Bundle();
            bundle.putInt("statTypeId", i10);
            bundle.putInt("athleteId", i11);
            bundle.putBoolean("isManagement", z10);
            cVar.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LastMatchesObj lastMatchesObj = this.f21381l;
            if (lastMatchesObj != null && lastMatchesObj.getGames() != null && !this.f21381l.getGames().isEmpty()) {
                ArrayList<LastMatchesHeaderObj> headers = this.f21381l.getHeaders(-1);
                if (this.f21381l.hasHeaderData()) {
                    arrayList.add(new LastMatchesTitleItem("", headers, this));
                    if (x0.l1()) {
                        this.f21382m = LastMatchGameItem.SCROLLED_STAT_WIDTH * headers.size();
                    }
                }
                Iterator<GameStats> it = this.f21381l.getGames().iterator();
                while (it.hasNext()) {
                    GameStats next = it.next();
                    arrayList.add(LastMatchGameItem.getLastMatchGameItem(next, false, next.getGameObj().getSportID(), y1(), this, headers));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public int getCurrentLastMatchesScrollPosition() {
        return this.f21382m;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public void onLastMatchHorizontalScroll(int i10, int i11) {
        try {
            this.f21382m = i10;
            for (int i12 = 0; i12 < this.rvBaseAdapter.getItemCount(); i12++) {
                if (i12 != i11) {
                    RecyclerView.e0 a02 = this.rvItems.a0(i12);
                    if (a02 instanceof LastMatchGameItem.iSyncScrolledViewHolder) {
                        ((LastMatchGameItem.iSyncScrolledViewHolder) a02).scrollStatContainer(i10);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof LastMatchGameItem) {
                int i11 = getArguments().getInt("athleteId", -1);
                boolean z10 = getArguments().getBoolean("isManagement", false);
                LastMatchGameItem lastMatchGameItem = (LastMatchGameItem) A;
                GameObj gameObj = lastMatchGameItem.getGameStats().getGameObj();
                ArrayList<AthleteStats> athleteStats = lastMatchGameItem.getGameStats().getAthleteStats();
                boolean z11 = (athleteStats == null || athleteStats.isEmpty()) ? false : true;
                boolean z12 = getArguments().getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, false);
                a.EnumC0251a enumC0251a = a.EnumC0251a.HOME;
                boolean z13 = !z10 && z11 && lastMatchGameItem.getGameStats().hasStats();
                if (z13 && lastMatchGameItem.isHasPlayed()) {
                    k.W1(new l(gameObj.getID(), gameObj.getSportID(), z12, enumC0251a, i11, -1, gameObj.getCompetitionID(), -1, "", "stats-div", gameObj.getStatusObj().valueForAnalytics(), true, new f(false, ""), false)).show(getChildFragmentManager(), "LiveStatsPopupDialog");
                } else {
                    getActivity().startActivity(GameCenterBaseActivity.v1(gameObj.getID(), gameObj.getCompetitionID(), bg.e.DETAILS, "details-div"));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("athlete_id", Integer.valueOf(x1()));
                hashMap.put("section", "div");
                hashMap.put("competition_id", Integer.valueOf(gameObj.getCompetitionID()));
                hashMap.put("game_id", Integer.valueOf(gameObj.getID()));
                hashMap.put("category", Integer.valueOf(y1()));
                hashMap.put("is_live_stats", Integer.valueOf(z13 ? 1 : 0));
                ee.k.k(App.m(), "athlete", "stats", "game", "click", hashMap);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public int x1() {
        try {
            return getArguments().getInt("athleteId", -1);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public int y1() {
        try {
            return getArguments().getInt("statTypeId", -1);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }
}
