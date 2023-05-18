package com.scores365.Monetization.Stc;

import ag.d0;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.core.view.e1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.Design.Pages.SavedScrollStateRecyclerView;
import com.scores365.R;
import ee.k;
import java.util.ArrayList;
import li.o0;
import li.p0;
import li.u;
import li.x0;
/* loaded from: classes2.dex */
public class CompareGameCenterActivity extends c {
    ImageView awayTeamLogo;
    TextView awayTeamText;
    ImageView homeTeamLogo;
    TextView homeTeamText;
    RelativeLayout rlHeader;
    RelativeLayout rlProgressBar;
    protected com.scores365.Design.Pages.c rvBaseAdapter;
    public SavedScrollStateRecyclerView rvItems;
    protected RecyclerView.p rvLayoutMgr;
    LinearLayout teamsContainer;

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    protected void initRecyclerViewLayoutManager() {
        try {
            this.rvLayoutMgr = new LinearLayoutManager(App.m(), 1, false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.f22483c);
            relateToolbar();
            initActionBar();
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Jn);
            this.rlProgressBar = relativeLayout;
            relativeLayout.setVisibility(0);
            this.teamsContainer = (LinearLayout) findViewById(R.id.f21916bg);
            this.rlHeader = (RelativeLayout) findViewById(R.id.wn);
            if (x0.l1()) {
                this.homeTeamLogo = (ImageView) findViewById(R.id.Pc);
                this.awayTeamLogo = (ImageView) findViewById(R.id.Ub);
                this.homeTeamText = (TextView) findViewById(R.id.iD);
                this.awayTeamText = (TextView) findViewById(R.id.NA);
            } else {
                this.homeTeamLogo = (ImageView) findViewById(R.id.Ub);
                this.awayTeamLogo = (ImageView) findViewById(R.id.Pc);
                this.homeTeamText = (TextView) findViewById(R.id.NA);
                this.awayTeamText = (TextView) findViewById(R.id.iD);
            }
            u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeLogo, this.homeTeamLogo);
            u.x(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayLogo, this.awayTeamLogo);
            this.homeTeamText.setTypeface(o0.d(App.m()));
            this.awayTeamText.setTypeface(o0.d(App.m()));
            this.homeTeamText.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.HomeText);
            this.awayTeamText.setText(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.AwayText);
            this.rlHeader.getLayoutParams().height = (App.p() * 644) / 1440;
            this.rvItems = (SavedScrollStateRecyclerView) findViewById(R.id.Km);
            initRecyclerViewLayoutManager();
            this.rvItems.setLayoutManager(this.rvLayoutMgr);
            e1.I0(this.rvItems, x0.m0());
            Window window = getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(a.getColor(this, p0.A(R.attr.A1)));
            k.n(App.m(), "ad", ServerProtocol.DIALOG_PARAM_DISPLAY, null, null, false, AppEventsConstants.EVENT_PARAM_AD_TYPE, "comparison_game", "ad_screen", "game_center", "network", "SpecialExcutions");
            this.rlHeader.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.Monetization.Stc.CompareGameCenterActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        x0.M1(CompareNativeAdScoresCampaignMgr.comparisonFakeGame.URL);
                        k.n(App.m(), "ad", "click", null, null, false, AppEventsConstants.EVENT_PARAM_AD_TYPE, "comparison_game", "ad_screen", "game_center", "network", "SpecialExcutions");
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d0(p0.l0("GC_PREDICTIONS")));
            arrayList.add(new CompareWhoWillWinItem());
            arrayList.add(new d0(p0.l0("GAME_CENTER_STANDING_POSITION")));
            arrayList.add(new CompareGameCenterTableItem());
            arrayList.add(new d0(p0.l0("GAME_CENTER_RECENT_FORM")));
            arrayList.add(new CompareRecentForm());
            arrayList.add(new ComparePreviousMeetings());
            com.scores365.Design.Pages.c cVar = new com.scores365.Design.Pages.c(arrayList, null);
            this.rvBaseAdapter = cVar;
            this.rvItems.setAdapter(cVar);
            this.rlProgressBar.setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            if (menuItem.getItemId() != 16908332) {
                return false;
            }
            onBackPressed();
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
