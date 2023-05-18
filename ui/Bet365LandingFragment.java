package com.scores365.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.SportTypesEnum;
import li.o0;
import li.p0;
import li.x0;
import sh.a;
/* loaded from: classes2.dex */
public class Bet365LandingFragment extends com.scores365.Design.Pages.a implements View.OnClickListener {
    public static final String GAME_OBJ = "game_obj_key";
    public static final String HOME_AWAY_TEAM_ORDER_KEY = "homeAwayTeamOrderKey";
    public static final String NOTIFICATION_KEY = "notificationKey";
    public static final String TITLE_KEY = "titleKey";
    public static final String URL_KEY = "urlKey";
    GameObj gameObj;
    ImageView ivAwayTeamLogo;
    ImageView ivHomeTeamLogo;
    TextView mainText;
    TextView tvCTA;
    TextView tvEula;
    TextView tvInstructions1;
    TextView tvInstructions2;
    TextView tvInstructions3;
    TextView tvTitle;
    TextView tvVersus;
    TextView tvWatchLiveButton;
    TextView tvWatchLiveSubText;
    TextView website;

    public static Bet365LandingFragment newInstance(GameObj gameObj, String str, String str2, boolean z10, int i10) {
        Bet365LandingFragment bet365LandingFragment = new Bet365LandingFragment();
        try {
            Bundle bundle = new Bundle();
            bundle.putString(TITLE_KEY, str);
            bundle.putSerializable(GAME_OBJ, gameObj);
            bundle.putString(URL_KEY, str2);
            bundle.putBoolean(NOTIFICATION_KEY, z10);
            bundle.putInt(HOME_AWAY_TEAM_ORDER_KEY, i10);
            bet365LandingFragment.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return bet365LandingFragment;
    }

    private void setTexts() {
        BookMakerObj m22;
        try {
            String string = getArguments().getString(TITLE_KEY);
            if (string == null || string.isEmpty()) {
                this.tvTitle.setText(p0.l0("WATCH_LIVE_LANDING_PAGE_DONT_MISS"));
            } else {
                this.tvTitle.setText(getArguments().getString(TITLE_KEY));
            }
            this.tvVersus.setText(p0.l0("WATCH_LIVE_VS_TITLE"));
            this.tvVersus.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, p0.s(75), new int[]{Color.parseColor("#ffffff"), Color.parseColor("#7a7a7a")}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            this.tvWatchLiveSubText.setText(p0.l0("WATCH_LIVE_PROMO_SCREEN_STEPS"));
            this.tvWatchLiveButton.setText(p0.l0("WATCH_LIVE_GAME_BUTTON"));
            this.tvInstructions1.setText(p0.l0("WATCH_LIVE_LANDING_PAGE_OPEN"));
            this.tvInstructions2.setText(p0.l0("WATCH_LIVE_LANDING_PAGE_FUND"));
            this.tvInstructions3.setText(p0.l0("WATCH_LIVE_LANDING_PAGE_ENJOY"));
            this.tvCTA.setText(p0.l0("WATCH_LIVE_LANDING_PAGE"));
            TextView textView = this.tvEula;
            String l02 = p0.l0("WATCH_LIVE_LANDING_PAGE_ELUA");
            textView.setText(Html.fromHtml(l02.replace("#EULA_LINK_TERM", "<font color=#03a9f4>" + p0.l0("TIPS_ELUA") + " </font>")));
            this.website.setText("");
            this.mainText.setText("");
            if (this.gameObj.getBestOddsObj() == null || this.gameObj.getBestOddsObj().getBookMakerObjs() == null || (m22 = x0.m2(this.gameObj.getBestOddsObj().getBookMakerObjs().values())) == null) {
                return;
            }
            TextView textView2 = this.website;
            textView2.setText(Html.fromHtml("<i>" + m22.disclaimer.getUrl() + "</i>"));
            TextView textView3 = this.mainText;
            textView3.setText(Html.fromHtml("<i>" + m22.disclaimer.getText() + "</i>"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() != this.tvCTA.getId() && view.getId() != this.tvWatchLiveButton.getId()) {
                if (view.getId() == this.tvEula.getId()) {
                    x0.M1(p0.l0("TIPS_ELUA"));
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
                    strArr[9] = getArguments().getBoolean(NOTIFICATION_KEY) ? "notification" : "gamecenter";
                    ee.k.o(m10, "general", "promotion-feature", "eula", "click", strArr);
                    return;
                }
                return;
            }
            a.C0569a c0569a = sh.a.f39207a;
            String g10 = c0569a.g();
            String string = getArguments().getString(URL_KEY);
            if (string != null && !string.isEmpty()) {
                string = c0569a.p(string, g10);
                x0.M1(string);
                je.b.f32619a.i("", 14);
            }
            String str = view.getId() == this.tvCTA.getId() ? "blue" : "orange";
            Context m11 = App.m();
            String[] strArr2 = new String[18];
            strArr2[0] = "promotion_name";
            strArr2[1] = "watch-live";
            strArr2[2] = "is_code";
            strArr2[3] = "false";
            strArr2[4] = "entity_type";
            strArr2[5] = "4";
            strArr2[6] = "entity_id";
            strArr2[7] = String.valueOf(this.gameObj.getID());
            strArr2[8] = ShareConstants.FEED_SOURCE_PARAM;
            strArr2[9] = getArguments().getBoolean(NOTIFICATION_KEY) ? "notification" : "gamecenter";
            strArr2[10] = "affiliate_link";
            strArr2[11] = string;
            strArr2[12] = "game_status";
            strArr2[13] = com.scores365.gameCenter.i0.D0(this.gameObj);
            strArr2[14] = "guid";
            strArr2[15] = g10;
            strArr2[16] = "click_type";
            strArr2[17] = str;
            ee.k.o(m11, "general", "promotion-feature", "click", null, strArr2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f22484c0, viewGroup, false);
        try {
            this.tvTitle = (TextView) inflate.findViewById(R.id.YG);
            this.tvVersus = (TextView) inflate.findViewById(R.id.PH);
            this.tvWatchLiveButton = (TextView) inflate.findViewById(R.id.XH);
            this.tvWatchLiveSubText = (TextView) inflate.findViewById(R.id.YH);
            this.tvInstructions1 = (TextView) inflate.findViewById(R.id.kw);
            this.tvInstructions2 = (TextView) inflate.findViewById(R.id.lw);
            this.tvInstructions3 = (TextView) inflate.findViewById(R.id.mw);
            this.tvCTA = (TextView) inflate.findViewById(R.id.gy);
            this.tvEula = (TextView) inflate.findViewById(R.id.My);
            this.website = (TextView) inflate.findViewById(R.id.cI);
            this.mainText = (TextView) inflate.findViewById(R.id.pB);
            this.website.setTypeface(o0.d(App.m()));
            this.mainText.setTypeface(o0.d(App.m()));
            this.tvTitle.setTypeface(o0.c(App.m()));
            this.tvVersus.setTypeface(o0.c(App.m()));
            this.tvWatchLiveButton.setTypeface(o0.c(App.m()));
            this.tvWatchLiveSubText.setTypeface(o0.c(App.m()));
            this.tvInstructions1.setTypeface(o0.d(App.m()));
            this.tvInstructions2.setTypeface(o0.d(App.m()));
            this.tvInstructions3.setTypeface(o0.d(App.m()));
            this.tvCTA.setTypeface(o0.c(App.m()));
            this.tvEula.setTypeface(o0.d(App.m()));
            inflate.setLayoutDirection(x0.l1() ? 1 : 0);
            if (x0.l1()) {
                this.tvInstructions1.setGravity(5);
                this.tvInstructions1.setGravity(5);
                this.tvInstructions1.setGravity(5);
            } else {
                this.tvInstructions1.setGravity(3);
                this.tvInstructions1.setGravity(3);
                this.tvInstructions1.setGravity(3);
            }
            this.gameObj = (GameObj) getArguments().getSerializable(GAME_OBJ);
            setTexts();
            this.tvCTA.setOnClickListener(this);
            this.tvWatchLiveButton.setOnClickListener(this);
            this.tvEula.setOnClickListener(this);
            GameObj gameObj = this.gameObj;
            if (gameObj != null) {
                if (x0.l(gameObj.homeAwayTeamOrder, true)) {
                    this.ivHomeTeamLogo = (ImageView) inflate.findViewById(R.id.Pc);
                    this.ivAwayTeamLogo = (ImageView) inflate.findViewById(R.id.Ub);
                } else {
                    this.ivHomeTeamLogo = (ImageView) inflate.findViewById(R.id.Ub);
                    this.ivAwayTeamLogo = (ImageView) inflate.findViewById(R.id.Pc);
                }
                if (this.gameObj.getSportID() == SportTypesEnum.TENNIS.getValue()) {
                    li.u.J(this.gameObj.getComps()[0].getID(), this.gameObj.getComps()[0].getCountryID(), this.ivHomeTeamLogo, this.gameObj.getComps()[0].getImgVer());
                    li.u.J(this.gameObj.getComps()[1].getID(), this.gameObj.getComps()[1].getCountryID(), this.ivAwayTeamLogo, this.gameObj.getComps()[1].getImgVer());
                } else {
                    li.u.m(this.gameObj.getComps()[0].getID(), false, this.ivHomeTeamLogo, this.gameObj.getComps()[0].getImgVer(), p0.K(R.attr.f21594w0), this.gameObj.getComps()[0].getSportID());
                    li.u.m(this.gameObj.getComps()[1].getID(), false, this.ivAwayTeamLogo, this.gameObj.getComps()[1].getImgVer(), p0.K(R.attr.f21594w0), this.gameObj.getComps()[1].getSportID());
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Context m10 = App.m();
            String[] strArr = new String[14];
            strArr[0] = "promotion_name";
            strArr[1] = "watch-live";
            strArr[2] = "is_code";
            strArr[3] = "false";
            strArr[4] = "entity_type";
            strArr[5] = "4";
            strArr[6] = "entity_id";
            strArr[7] = String.valueOf(this.gameObj.getID());
            strArr[8] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[9] = getArguments().getBoolean(NOTIFICATION_KEY) ? "notification" : "gamecenter";
            strArr[10] = "affiliate_link";
            strArr[11] = getArguments().getString(URL_KEY, "");
            strArr[12] = "game_status";
            strArr[13] = com.scores365.gameCenter.i0.D0(this.gameObj);
            ee.k.o(m10, "general", "promotion-feature", ServerProtocol.DIALOG_PARAM_DISPLAY, null, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
