package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.TvNetworkObj;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class Bet365LandingActivity extends com.scores365.Design.Activities.c {
    private static final String FRAGMENT_TAG = "landingTag";
    public static final String GAME_ID = "gameId";
    public static final String GAME_TAG = "gameObj";
    public static final String HOME_AWAY_TEAM_ORDER_TAG = "homeAwayTeamOrderTag";
    public static final String IS_SOURCE_NOTIFICATION = "isSourceNotification";
    public static final String NOTIFICATION_SCREEN_NAME = "watch_live_promo";
    public static final String TITLE = "title";
    public static final String URL = "url";
    private GameObj gameObj;
    private RelativeLayout rlPb;

    /* loaded from: classes2.dex */
    private static class LoadGameData extends AsyncTask<String, Void, GameObj> {
        WeakReference<Bet365LandingActivity> activityRef;

        public LoadGameData(Bet365LandingActivity bet365LandingActivity) {
            this.activityRef = new WeakReference<>(bet365LandingActivity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public GameObj doInBackground(String... strArr) {
            try {
                com.scores365.api.h hVar = new com.scores365.api.h(App.m(), sf.a.i0(App.m()).k0(), sf.a.i0(App.m()).G0(), strArr[0], String.valueOf(sf.a.i0(App.m()).j0()), -1, -1);
                hVar.call();
                return hVar.a().getGames().get(Integer.valueOf(strArr[0]));
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(GameObj gameObj) {
            String str;
            super.onPostExecute((LoadGameData) gameObj);
            try {
                Bet365LandingActivity bet365LandingActivity = this.activityRef.get();
                if (bet365LandingActivity != null) {
                    bet365LandingActivity.rlPb.setVisibility(8);
                    try {
                        str = bet365LandingActivity.getIntent().getExtras().getString("url", "");
                    } catch (Exception e10) {
                        x0.N1(e10);
                        str = null;
                    }
                    if (str == null || str.isEmpty()) {
                        str = bet365LandingActivity.getBookmakerUrl(gameObj);
                    }
                    ((com.scores365.Design.Activities.c) bet365LandingActivity).toolbar.setTitle(bet365LandingActivity.getToolbarTitle(gameObj));
                    bet365LandingActivity.setFragment(gameObj, bet365LandingActivity.getIntent().getExtras().getString("title", ""), str, true, bet365LandingActivity.getIntent().getIntExtra(Bet365LandingActivity.HOME_AWAY_TEAM_ORDER_TAG, 1));
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                Bet365LandingActivity bet365LandingActivity = this.activityRef.get();
                if (bet365LandingActivity != null) {
                    bet365LandingActivity.rlPb.setVisibility(0);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void ExitScreen() {
        try {
            Intent x02 = x0.x0();
            x02.setFlags(268435456);
            x02.setFlags(67108864);
            startActivity(x02);
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static Intent getActivityIntent(GameObj gameObj, int i10) {
        Intent intent = new Intent(App.m(), Bet365LandingActivity.class);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(gameObj);
            intent.putExtra(GAME_TAG, byteArrayOutputStream.toByteArray());
            intent.putExtra(HOME_AWAY_TEAM_ORDER_TAG, i10);
        } catch (IOException e10) {
            x0.N1(e10);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getBookmakerUrl(GameObj gameObj) {
        Iterator<TvNetworkObj> it = gameObj.TvNetworks.iterator();
        String str = "";
        while (it.hasNext()) {
            TvNetworkObj next = it.next();
            if (next.bookmaker == 14) {
                str = next.getTvLinks().get(0).getLineLink();
            }
        }
        return str;
    }

    private GameObj getGameObj() {
        GameObj gameObj;
        Exception e10;
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(getIntent().getExtras().getByteArray(GAME_TAG)));
            gameObj = (GameObj) objectInputStream.readObject();
        } catch (Exception e11) {
            gameObj = null;
            e10 = e11;
        }
        try {
            objectInputStream.close();
        } catch (Exception e12) {
            e10 = e12;
            x0.N1(e10);
            return gameObj;
        }
        return gameObj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getToolbarTitle(GameObj gameObj) {
        if (gameObj != null) {
            try {
                gameObj = getGameObj();
            } catch (Exception e10) {
                x0.N1(e10);
                return "";
            }
        }
        if (gameObj != null) {
            boolean k10 = x0.k(gameObj.homeAwayTeamOrder);
            int i10 = !k10 ? 1 : 0;
            return gameObj.getComps()[k10 ? 1 : 0].getName() + " - " + gameObj.getComps()[i10].getName();
        }
        return p0.l0("WATCH_LIVE_LANDING_PAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFragment(GameObj gameObj, String str, String str2, boolean z10, int i10) {
        try {
            this.gameObj = gameObj;
            getSupportFragmentManager().q().q(R.id.f22065i6, Bet365LandingFragment.newInstance(gameObj, str, str2, z10, i10), FRAGMENT_TAG).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return getToolbarTitle(null);
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            try {
                Context m10 = App.m();
                String[] strArr = new String[10];
                strArr[0] = "promotion_name";
                strArr[1] = "watch-live";
                strArr[2] = "is_code";
                strArr[3] = "false";
                strArr[4] = "entity_type";
                strArr[5] = "4";
                strArr[6] = "entity_id";
                strArr[7] = String.valueOf(this.gameObj.getID());
                strArr[8] = ShareConstants.FEED_SOURCE_PARAM;
                strArr[9] = (getIntent().getExtras() == null || !getIntent().getExtras().getBoolean(IS_SOURCE_NOTIFICATION, false)) ? "gamecenter" : "notification";
                ee.k.o(m10, "general", "promotion-feature", "exit", null, strArr);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            if (getIntent().getExtras() == null || !getIntent().getExtras().getBoolean(IS_SOURCE_NOTIFICATION, false)) {
                super.onBackPressed();
            } else {
                ExitScreen();
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22611la);
        x0.D1(this);
        initActionBar();
        this.toolbar.setBackgroundColor(p0.A(R.attr.A1));
        try {
            this.rlPb = (RelativeLayout) findViewById(R.id.Jn);
            if (getIntent().getExtras() != null && getIntent().getExtras().getBoolean(IS_SOURCE_NOTIFICATION, false)) {
                new LoadGameData(this).execute(getIntent().getExtras().getString(GAME_ID, ""));
            } else if (getIntent().getExtras().containsKey(GAME_TAG)) {
                GameObj gameObj = getGameObj();
                this.toolbar.setTitle(getToolbarTitle(gameObj));
                setFragment(gameObj, p0.l0("WATCH_LIVE_LANDING_PAGE_DONT_MISS"), getBookmakerUrl(gameObj), false, getIntent().getIntExtra(HOME_AWAY_TEAM_ORDER_TAG, 1));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        onBackPressed();
        return true;
    }
}
