package com.scores365.ui.playerCard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.api.b0;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.AthleteStats;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameStats;
import com.scores365.entitys.LastMatchesHeaderObj;
import com.scores365.entitys.LastMatchesObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.ui.playerCard.CustomHorizontalScrollView;
import com.scores365.ui.playerCard.LastMatchGameItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import li.o0;
import li.p0;
import li.x0;
import xf.y;
/* loaded from: classes2.dex */
public class AthleteMatchesPage extends q implements LastMatchGameItem.iScrollListener, CustomHorizontalScrollView.Companion.iScrollListener {
    AthleteObj athleteObj;
    LastMatchesObj lastMatchesObj;
    CustomHorizontalScrollView scoreBoxTitleHSV;
    ConstraintLayout scoreboxContainer;
    LinearLayout statsContainer;
    TextView titleTeamName;
    int currentLastMatchScrollPosition = 0;
    ArrayList<LastMatchesHeaderObj> headers = null;
    HashSet<Integer> titlePositions = new HashSet<>();
    HashMap<Integer, String> titleTeamNames = new HashMap<>();

    private ArrayList<com.scores365.Design.PageObjects.b> getLastMatchesItems() {
        int i10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            y headersCategories = SinglePlayerStatsPage.getHeadersCategories(this.lastMatchesObj, getArguments());
            if (headersCategories != null) {
                arrayList.add(headersCategories);
                i10 = this.lastMatchesObj.getHeaderCategories().get(getArguments().getInt(SinglePlayerStatsPage.HEADERS_CATEGORY_LAST_POSITION, 0)).getID();
            } else {
                i10 = -1;
            }
            this.headers = this.lastMatchesObj.getHeaders(i10);
            String str = "";
            Iterator<GameStats> it = this.lastMatchesObj.getGames().iterator();
            int i11 = 0;
            boolean z10 = false;
            while (it.hasNext()) {
                GameStats next = it.next();
                int relatedCompetitor = next.getRelatedCompetitor();
                if (i11 != relatedCompetitor) {
                    if (this.lastMatchesObj.hasHeaderData()) {
                        str = next.getGameObj().getComps()[0].getID() == relatedCompetitor ? next.getGameObj().getComps()[0].getShortName() : next.getGameObj().getComps()[1].getShortName();
                        this.titleTeamNames.put(Integer.valueOf(arrayList.size()), str);
                        this.titlePositions.add(Integer.valueOf(arrayList.size()));
                        LastMatchesTitleItem lastMatchesTitleItem = new LastMatchesTitleItem(str, this.headers, this);
                        if (!z10) {
                            lastMatchesTitleItem.setTopMargin(p0.s(1));
                        }
                        arrayList.add(lastMatchesTitleItem);
                        i11 = relatedCompetitor;
                        z10 = true;
                    } else {
                        i11 = relatedCompetitor;
                    }
                }
                this.titleTeamNames.put(Integer.valueOf(arrayList.size()), str);
                arrayList.add(LastMatchGameItem.getLastMatchGameItem(next, false, this.athleteObj.getSportTypeId(), -1, this, this.headers));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    public static AthleteMatchesPage newInstance(String str, int i10, AthleteObj athleteObj) {
        AthleteMatchesPage athleteMatchesPage = new AthleteMatchesPage();
        Bundle bundle = new Bundle();
        bundle.putString(AthleteMatchesActivity.ALL_MATCHES_LINK, str);
        bundle.putInt("athleteId", i10);
        athleteMatchesPage.setArguments(bundle);
        athleteMatchesPage.athleteObj = athleteObj;
        return athleteMatchesPage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            b0 b0Var = new b0(getArguments().getString(AthleteMatchesActivity.ALL_MATCHES_LINK));
            b0Var.call();
            LastMatchesObj a10 = b0Var.a();
            this.lastMatchesObj = a10;
            if (a10 != null && a10.getGames().size() > 0) {
                arrayList.addAll(getLastMatchesItems());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        int top;
        int s10;
        super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
        try {
            if (this.scoreboxContainer.getVisibility() == 0) {
                this.titleTeamName.setText(this.titleTeamNames.get(Integer.valueOf(i10)));
                if (!this.titlePositions.contains(Integer.valueOf(i10)) && !this.titlePositions.contains(Integer.valueOf(i10 + 1))) {
                    this.scoreboxContainer.setTranslationY(0.0f);
                    return;
                }
                if (this.titlePositions.contains(Integer.valueOf(i10 + 1))) {
                    top = this.rvItems.getChildAt(1).getTop();
                    s10 = p0.s(3);
                } else {
                    top = this.rvItems.getChildAt(0).getTop();
                    s10 = p0.s(3);
                }
                int i14 = top - s10;
                float dimension = App.m().getResources().getDimension(R.dimen.D);
                float dimension2 = App.m().getResources().getDimension(R.dimen.E);
                this.scoreboxContainer.setTranslationY((-dimension) + i14);
                if (this.scoreboxContainer.getTranslationY() > 0.0f) {
                    this.scoreboxContainer.setTranslationY(0.0f);
                } else if (this.scoreboxContainer.getTranslationY() < (-(dimension + dimension2))) {
                    this.scoreboxContainer.setTranslationY(0.0f);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public int getCurrentLastMatchesScrollPosition() {
        return this.currentLastMatchScrollPosition;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.P;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.ui.playerCard.LastMatchGameItem.iScrollListener
    public void onLastMatchHorizontalScroll(int i10, int i11) {
        try {
            this.currentLastMatchScrollPosition = i10;
            for (int i12 = 0; i12 < this.rvBaseAdapter.getItemCount(); i12++) {
                if (i12 != i11) {
                    RecyclerView.e0 a02 = this.rvItems.a0(i12);
                    if (a02 instanceof LastMatchGameItem.iSyncScrolledViewHolder) {
                        ((LastMatchGameItem.iSyncScrolledViewHolder) a02).scrollStatContainer(i10);
                    }
                }
            }
            if (i11 != -1) {
                this.scoreBoxTitleHSV.scrollTo(i10, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        CompetitionObj competitionObj;
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            int i11 = 1;
            if (!(A instanceof LastMatchGameItem)) {
                if (A instanceof y) {
                    int l10 = ((y) A).l();
                    int i12 = getArguments().getInt(SinglePlayerStatsPage.HEADERS_CATEGORY_LAST_POSITION, 0);
                    int id2 = this.athleteObj.getID();
                    int id3 = this.athleteObj.getLastMatchesObj().getHeaderCategories().get(l10).getID();
                    if (i12 != l10) {
                        getArguments().putInt(SinglePlayerStatsPage.HEADERS_CATEGORY_LAST_POSITION, l10);
                        HashMap hashMap = new HashMap();
                        hashMap.put("athlete_id", Integer.valueOf(id2));
                        hashMap.put("tab", Integer.valueOf(id3));
                        hashMap.put("type_tab", Integer.valueOf(l10));
                        ee.k.m(App.m(), "athlete", "stats", "type", "tab-click", true, hashMap);
                        this.headers = this.lastMatchesObj.getHeaders(id3);
                        ArrayList<com.scores365.Design.PageObjects.b> B = this.rvBaseAdapter.B();
                        Iterator<com.scores365.Design.PageObjects.b> it = B.iterator();
                        int i13 = 0;
                        while (it.hasNext()) {
                            com.scores365.Design.PageObjects.b next = it.next();
                            if (next instanceof LastMatchesTitleItem) {
                                ((LastMatchesTitleItem) next).setHeaders(this.headers);
                                onLastMatchHorizontalScroll(0, i13);
                            } else if (next instanceof LastMatchGameItem) {
                                ((LastMatchGameItem) next).setHeaders(this.headers);
                                onLastMatchHorizontalScroll(0, i13);
                            }
                            i13++;
                        }
                        this.rvBaseAdapter.notifyItemRangeChanged(1, B.size());
                        return;
                    }
                    return;
                }
                return;
            }
            GameObj gameObj = ((LastMatchGameItem) A).getGameStats().getGameObj();
            LastMatchesObj lastMatchesObj = this.lastMatchesObj;
            if (lastMatchesObj != null) {
                Iterator<CompetitionObj> it2 = lastMatchesObj.getCompetitions().iterator();
                while (it2.hasNext()) {
                    competitionObj = it2.next();
                    if (competitionObj.getID() == gameObj.getCompetitionID()) {
                        break;
                    }
                }
            }
            competitionObj = null;
            Intent z12 = GameCenterBaseActivity.z1(gameObj.getID(), bg.e.DETAILS, "previous-matches");
            ArrayList<AthleteStats> athleteStats = ((LastMatchGameItem) A).getGameStats().getAthleteStats();
            boolean z10 = !SinglePlayerProfilePage.isCoach(this.athleteObj.getPlayerPositionType(), this.athleteObj.getSportType()) && (athleteStats != null && !athleteStats.isEmpty()) && ((LastMatchGameItem) A).getGameStats().hasStats() && SinglePlayerStatsPage.shouldOpenLiveStatForSportType(this.athleteObj);
            if (z10 && ((LastMatchGameItem) A).isHasPlayed()) {
                zb.k W1 = zb.k.W1(new zb.l(gameObj.getID(), gameObj.getSportID(), getArguments().getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, false), a.EnumC0251a.HOME, getArguments().getInt("athleteId", -1), -1, gameObj.getCompetitionID(), -1, "", "last-matches", gameObj.getStatusObj().valueForAnalytics(), true, new se.f(false, ""), false));
                W1.d2(gameObj);
                W1.c2(competitionObj);
                W1.f2(true);
                W1.show(getChildFragmentManager(), "LiveStatsPopupDialog");
            } else if ((getActivity() instanceof com.scores365.Design.Activities.c) && !((com.scores365.Design.Activities.c) getActivity()).isOpeningActivityLocked()) {
                ((com.scores365.Design.Activities.c) getActivity()).lockUnLockActivityOpening();
                ((com.scores365.Design.Activities.c) getActivity()).startActivityForResultWithLock(z12, 888);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("athlete_id", Integer.valueOf(getArguments().getInt("athleteId", -1)));
            hashMap2.put("section", "previous-matches");
            hashMap2.put("competition_id", Integer.valueOf(gameObj.getCompetitionID()));
            hashMap2.put("game_id", Integer.valueOf(gameObj.getID()));
            if (!z10) {
                i11 = 0;
            }
            hashMap2.put("is_live_stats", Integer.valueOf(i11));
            hashMap2.put("type_tab", Integer.valueOf(getArguments().getInt(SinglePlayerStatsPage.HEADERS_CATEGORY_LAST_POSITION, 0)));
            ee.k.k(App.m(), "athlete", "stats", "game", "click", hashMap2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.playerCard.CustomHorizontalScrollView.Companion.iScrollListener
    public void onScrolled(int i10, int i11, int i12, int i13) {
        try {
            onLastMatchHorizontalScroll(i10, -1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        super.relateCustomViews(view);
        try {
            this.scoreboxContainer = (ConstraintLayout) view.findViewById(R.id.f22085j3);
            this.scoreBoxTitleHSV = (CustomHorizontalScrollView) view.findViewById(R.id.f22045h8);
            this.statsContainer = (LinearLayout) view.findViewById(R.id.f22407xg);
            TextView textView = (TextView) view.findViewById(R.id.uG);
            this.titleTeamName = textView;
            textView.setGravity((x0.l1() ? 5 : 3) | 16);
            this.titleTeamName.setTypeface(o0.d(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateListView(View view) {
        super.relateListView(view);
        try {
            if (this.athleteObj.getSportType() == SportTypesEnum.BASKETBALL) {
                this.rvItems.setPadding(0, 0, 0, 0);
            } else {
                this.rvItems.setPadding(0, p0.s(8), 0, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        try {
            if (this.athleteObj.getSportType() != SportTypesEnum.BASKETBALL) {
                this.scoreboxContainer.setVisibility(8);
                return;
            }
            this.scoreboxContainer.setVisibility(0);
            this.scoreboxContainer.setLayoutDirection(x0.l1() ? 1 : 0);
            this.statsContainer.removeAllViews();
            this.statsContainer.addView(new View(App.m()), new LinearLayout.LayoutParams(LastMatchGameBasketballItem.STATS_OFFSET, -1, 0.0f));
            Iterator<LastMatchesHeaderObj> it = this.headers.iterator();
            while (it.hasNext()) {
                this.statsContainer.addView(LastMatchGameItem.returnReasonTV(it.next().getTitle(), 0, false, true, true, false));
            }
            if (x0.l1()) {
                this.statsContainer.setRotationY(180.0f);
                this.scoreBoxTitleHSV.setRotationY(180.0f);
            }
            this.scoreBoxTitleHSV.scrollTo(this.currentLastMatchScrollPosition, 0);
            this.scoreBoxTitleHSV.setScrollListener(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
