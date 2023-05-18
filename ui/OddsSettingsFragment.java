package com.scores365.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.SwitchCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.EOddsFormats;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.tipster.TipsterTelegramChannelInviteActivity;
import com.scores365.ui.BaseSettingsFragmentActivity;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class OddsSettingsFragment extends com.scores365.Design.Pages.a implements BaseSettingsFragmentActivity.ShouldRestartRootActivityListener {
    private TextView american;
    private AppCompatRadioButton americanRB;
    private RelativeLayout americanRL;
    private TextView decimal;
    private AppCompatRadioButton decimalRB;
    private RelativeLayout decimalRL;
    private TextView fraction;
    private AppCompatRadioButton fractionalRB;
    private RelativeLayout fractionalRL;
    private TextView oddsTitle;
    private LinearLayout oddsTypeContainer;
    private SwitchCompat sendOddsSwitch;
    private TextView sendOddsText;
    private TextView showOdds;
    private SwitchCompat showOddsBut;
    private TextView telegramChannelText;
    private RelativeLayout telegramContainer;
    private TextView telegramTitle;
    private boolean isDirty = false;
    private EOddsFormats currTypeOfOdds = EOddsFormats.DECIMAL;
    View.OnClickListener radioButtonOperation = new View.OnClickListener() { // from class: com.scores365.ui.OddsSettingsFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (view.getTag() == null || view.getTag() == OddsSettingsFragment.this.currTypeOfOdds) {
                    return;
                }
                OddsSettingsFragment.this.currTypeOfOdds = (EOddsFormats) view.getTag();
                sf.b.X1().b9(OddsSettingsFragment.this.currTypeOfOdds);
                MainDashboardActivity.Z0 = true;
                OddsSettingsFragment.this.isDirty = true;
                OddsSettingsFragment.this.updateSelectionByCurrentTypeOfOdds();
                OddsSettingsFragment.this.setResultIntentData();
                ee.k.q(App.m(), "settings-odds", "select-format", "click", true, "format", OddsSettingsFragment.this.currTypeOfOdds.toString().toLowerCase());
                sf.b.X1().A8(false);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    View.OnClickListener oddsClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.OddsSettingsFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            boolean z10;
            try {
                if (x0.s2()) {
                    str = "disable";
                    OddsSettingsFragment.this.oddsTypeContainer.setVisibility(8);
                    z10 = false;
                } else {
                    str = "enable";
                    OddsSettingsFragment.this.oddsTypeContainer.setVisibility(0);
                    z10 = true;
                }
                MainDashboardActivity.Z0 = true;
                OddsSettingsFragment.this.isDirty = true;
                OddsSettingsFragment.this.setResultIntentData();
                sf.b.X1().W7(z10);
                OddsSettingsFragment.this.setOnClickForAllRelativeLayouts(z10);
                ee.k.q(App.m(), "settings-odds", "show-odds", "click", true, "type", str);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    View.OnClickListener sendOddsNotificationClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.OddsSettingsFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            try {
                if (sf.b.X1().m4()) {
                    sf.b.X1().K7(false);
                    str = "2";
                } else {
                    sf.b.X1().K7(true);
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
                ee.k.o(App.m(), "settings", "notifications", "enable-betting-notifications", "click", ServerProtocol.DIALOG_PARAM_STATE, str, ShareConstants.FEED_SOURCE_PARAM, "2");
                OddsSettingsFragment.this.isDirty = true;
                OddsSettingsFragment.this.setResultIntentData();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    View.OnClickListener telegramClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.OddsSettingsFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                App.m().startActivity(TipsterTelegramChannelInviteActivity.d1(AppEventsConstants.EVENT_PARAM_VALUE_YES));
                ee.k.p(App.m(), "settings-odds", "join-telegram", "click", true);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.OddsSettingsFragment$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$bets$model$EOddsFormats;

        static {
            int[] iArr = new int[EOddsFormats.values().length];
            $SwitchMap$com$scores365$bets$model$EOddsFormats = iArr;
            try {
                iArr[EOddsFormats.DECIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$bets$model$EOddsFormats[EOddsFormats.FRACTIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$bets$model$EOddsFormats[EOddsFormats.AMERICAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static OddsSettingsFragment newInstance() {
        try {
            return new OddsSettingsFragment();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnClickForAllRelativeLayouts(boolean z10) {
        try {
            RelativeLayout relativeLayout = this.decimalRL;
            EOddsFormats eOddsFormats = EOddsFormats.DECIMAL;
            relativeLayout.setTag(eOddsFormats);
            RelativeLayout relativeLayout2 = this.fractionalRL;
            EOddsFormats eOddsFormats2 = EOddsFormats.FRACTIONAL;
            relativeLayout2.setTag(eOddsFormats2);
            RelativeLayout relativeLayout3 = this.americanRL;
            EOddsFormats eOddsFormats3 = EOddsFormats.AMERICAN;
            relativeLayout3.setTag(eOddsFormats3);
            this.decimalRB.setTag(eOddsFormats);
            this.fractionalRB.setTag(eOddsFormats2);
            this.americanRB.setTag(eOddsFormats3);
            androidx.core.widget.d.c(this.decimalRB, androidx.core.content.a.getColorStateList(App.m(), p0.T(R.attr.T0)));
            androidx.core.widget.d.c(this.fractionalRB, androidx.core.content.a.getColorStateList(App.m(), p0.T(R.attr.T0)));
            androidx.core.widget.d.c(this.americanRB, androidx.core.content.a.getColorStateList(App.m(), p0.T(R.attr.T0)));
            if (z10) {
                this.decimalRL.setOnClickListener(this.radioButtonOperation);
                this.fractionalRL.setOnClickListener(this.radioButtonOperation);
                this.americanRL.setOnClickListener(this.radioButtonOperation);
                this.decimalRB.setOnClickListener(this.radioButtonOperation);
                this.fractionalRB.setOnClickListener(this.radioButtonOperation);
                this.americanRB.setOnClickListener(this.radioButtonOperation);
            } else {
                this.decimalRL.setOnClickListener(null);
                this.fractionalRL.setOnClickListener(null);
                this.americanRL.setOnClickListener(null);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResultIntentData() {
        try {
            Intent intent = new Intent();
            intent.putExtra("update_dashboard", true);
            getActivity().setResult(-1, intent);
        } catch (Exception unused) {
        }
    }

    private void setTextForAllTV() {
        try {
            String l02 = p0.l0("ODDS_FORMAT_DECIMAL_EXMP");
            String l03 = p0.l0("ODDS_FORMAT_FRACTIONAL_EXMP");
            String l04 = p0.l0("ODDS_FORMAT_AMERICAN_EXMP");
            this.sendOddsText.setText(p0.l0("TIPS_BETTING_NOTIFICATION"));
            this.showOdds.setText(p0.l0("BETTING_SHOW_ODDS"));
            this.oddsTitle.setText(p0.l0("SETTINGS_ODDS_TYPE"));
            StringBuilder sb2 = new StringBuilder(p0.l0("GC_ODDS_DECIMAL"));
            sb2.append(" ");
            sb2.append(l02);
            StringBuilder sb3 = new StringBuilder(p0.l0("GC_ODDS_FRACTIONAL"));
            sb3.append(" ");
            sb3.append(l03);
            StringBuilder sb4 = new StringBuilder(p0.l0("GC_ODDS_AMERICAN"));
            sb4.append(" ");
            if (x0.l1()) {
                sb4.append("\u200e");
            }
            sb4.append(l04);
            if (x0.l1()) {
                sb4.append("\u200e");
            }
            this.decimal.setText(sb2);
            this.fraction.setText(sb3);
            this.american.setText(sb4);
            this.telegramTitle.setText(p0.l0("BETTING_TELEGRAM_TITLE"));
            this.telegramChannelText.setText(p0.l0("TELEGRAM_INVITE_SCREEN_TITLE"));
            this.sendOddsText.setTypeface(o0.d(App.m()));
            this.oddsTitle.setTypeface(o0.d(App.m()));
            this.showOdds.setTypeface(o0.d(App.m()));
            this.decimal.setTextSize(1, 15.0f);
            this.decimal.setTypeface(o0.d(App.m()));
            this.fraction.setTextSize(1, 15.0f);
            this.fraction.setTypeface(o0.d(App.m()));
            this.american.setTextSize(1, 15.0f);
            this.american.setTypeface(o0.d(App.m()));
            this.telegramTitle.setTypeface(o0.d(App.m()));
            this.telegramChannelText.setTypeface(o0.b(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectionByCurrentTypeOfOdds() {
        try {
            this.decimal.setTextColor(p0.A(R.attr.f21565m1));
            this.fraction.setTextColor(p0.A(R.attr.f21565m1));
            this.american.setTextColor(p0.A(R.attr.f21565m1));
            this.decimalRB.setChecked(false);
            this.fractionalRB.setChecked(false);
            this.americanRB.setChecked(false);
            int i10 = AnonymousClass5.$SwitchMap$com$scores365$bets$model$EOddsFormats[this.currTypeOfOdds.ordinal()];
            if (i10 == 1) {
                this.decimal.setTextColor(p0.A(R.attr.U0));
                this.decimalRB.setChecked(true);
            } else if (i10 == 2) {
                this.fraction.setTextColor(p0.A(R.attr.U0));
                this.fractionalRB.setChecked(true);
            } else if (i10 == 3) {
                this.american.setTextColor(p0.A(R.attr.U0));
                this.americanRB.setChecked(true);
            }
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            int i10 = 0;
            view = x0.l1() ? layoutInflater.inflate(R.layout.f22742w5, viewGroup, false) : layoutInflater.inflate(R.layout.f22730v5, viewGroup, false);
            this.sendOddsText = (TextView) view.findViewById(R.id.SD);
            if (x0.l1()) {
                this.sendOddsText.setGravity(5);
            } else {
                this.sendOddsText.setGravity(3);
            }
            this.showOdds = (TextView) view.findViewById(R.id.f22034gj);
            if (x0.l1()) {
                this.showOdds.setGravity(5);
            } else {
                this.showOdds.setGravity(3);
            }
            this.oddsTitle = (TextView) view.findViewById(R.id.zp);
            this.decimal = (TextView) view.findViewById(R.id.vp);
            this.fraction = (TextView) view.findViewById(R.id.yp);
            this.american = (TextView) view.findViewById(R.id.sp);
            this.showOddsBut = (SwitchCompat) view.findViewById(R.id.Hp);
            this.oddsTypeContainer = (LinearLayout) view.findViewById(R.id.f22252qg);
            this.decimalRB = (AppCompatRadioButton) view.findViewById(R.id.tp);
            this.fractionalRB = (AppCompatRadioButton) view.findViewById(R.id.wp);
            this.americanRB = (AppCompatRadioButton) view.findViewById(R.id.qp);
            this.decimalRL = (RelativeLayout) view.findViewById(R.id.up);
            this.fractionalRL = (RelativeLayout) view.findViewById(R.id.xp);
            this.americanRL = (RelativeLayout) view.findViewById(R.id.rp);
            this.currTypeOfOdds = sf.b.X1().A2();
            this.showOddsBut.setOnClickListener(this.oddsClickLinstener);
            this.showOddsBut.setChecked(sf.b.X1().s4());
            LinearLayout linearLayout = this.oddsTypeContainer;
            if (!sf.b.X1().s4()) {
                i10 = 8;
            }
            linearLayout.setVisibility(i10);
            SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.zo);
            this.sendOddsSwitch = switchCompat;
            switchCompat.setOnClickListener(this.sendOddsNotificationClickLinstener);
            this.sendOddsSwitch.setChecked(sf.b.X1().m4());
            this.telegramTitle = (TextView) view.findViewById(R.id.zG);
            this.telegramChannelText = (TextView) view.findViewById(R.id.yG);
            this.telegramContainer = (RelativeLayout) view.findViewById(R.id.mo);
            view.findViewById(R.id.Vr);
            this.telegramContainer.setOnClickListener(this.telegramClickLinstener);
            setTextForAllTV();
            updateSelectionByCurrentTypeOfOdds();
            setOnClickForAllRelativeLayouts(sf.b.X1().s4());
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        x0.A2(null, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            this.currTypeOfOdds = sf.b.X1().A2();
            updateSelectionByCurrentTypeOfOdds();
        } catch (Exception unused) {
        }
    }

    @Override // com.scores365.ui.BaseSettingsFragmentActivity.ShouldRestartRootActivityListener
    public boolean shouldRestartRootActivity() {
        return this.isDirty;
    }
}
