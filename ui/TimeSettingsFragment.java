package com.scores365.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.scores365.App;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.entitys.LanguageObj;
import com.scores365.ui.BaseSettingsFragmentActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lg.a;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TimeSettingsFragment extends Fragment implements BaseSettingsFragmentActivity.ShouldRestartRootActivityListener {
    private Button changeTimeZoneBtn;
    private int lastTimeZoneID;
    private LinearLayout llFeedbackBtn;
    private ConstraintLayout llTimeZoneCenterItem;
    private RelativeLayout preLoader;
    private AppCompatRadioButton rb12;
    private AppCompatRadioButton rb24;
    private RelativeLayout rl12;
    private RelativeLayout rl24;
    private TextView timeZoneDate;
    private TextView timeZoneDay;
    private TextView timeZoneTime;
    private TextView tvFeedbackTitle;
    private TextView use12Title;
    private TextView use24Title;
    private Locale userLocale;
    private TextView wrongTimeZoneTv;
    private boolean needToRefresh = false;
    private boolean is_24 = sf.b.X1().r();
    a.f localDataArriveListener = new a.f() { // from class: com.scores365.ui.TimeSettingsFragment.8
        @Override // lg.a.f
        public void onLocalDataArrive() {
            try {
                TimeSettingsFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.scores365.ui.TimeSettingsFragment.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TimeSettingsFragment.this.preLoader.setVisibility(8);
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                });
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    View.OnClickListener feedBackClickListener = new View.OnClickListener() { // from class: com.scores365.ui.TimeSettingsFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                FaqOptions faqOptions = new FaqOptions();
                faqOptions.showContactUsOnFaqNotHelpful(false);
                faqOptions.showContactUsOnFaqScreens(false);
                faqOptions.showContactUsOnAppBar(false);
                Freshchat.showFAQs(App.m(), faqOptions);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };

    public static TimeSettingsFragment newInstance() {
        try {
            return new TimeSettingsFragment();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.lastTimeZoneID = sf.a.i0(App.m()).G0();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            int i10 = 0;
            view = layoutInflater.inflate(R.layout.K9, viewGroup, false);
            this.userLocale = Locale.getDefault();
            LanguageObj languageObj = App.l().getLanguages().get(Integer.valueOf(sf.a.i0(App.m()).k0()));
            Locale[] availableLocales = Locale.getAvailableLocales();
            int length = availableLocales.length;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                Locale locale = availableLocales[i10];
                if (languageObj.getAndroidLocale().equals(locale.toString())) {
                    this.userLocale = locale;
                    break;
                }
                i10++;
            }
            this.use24Title = (TextView) view.findViewById(R.id.pI);
            this.use12Title = (TextView) view.findViewById(R.id.oI);
            this.preLoader = (RelativeLayout) view.findViewById(R.id.hs);
            this.timeZoneTime = (TextView) view.findViewById(R.id.f22218p4);
            this.timeZoneDay = (TextView) view.findViewById(R.id.f22196o4);
            this.timeZoneDate = (TextView) view.findViewById(R.id.f22174n4);
            this.wrongTimeZoneTv = (TextView) view.findViewById(R.id.nJ);
            this.changeTimeZoneBtn = (Button) view.findViewById(R.id.A2);
            this.rb12 = (AppCompatRadioButton) view.findViewById(R.id.f21977e8);
            this.rb24 = (AppCompatRadioButton) view.findViewById(R.id.f22000f8);
            this.llTimeZoneCenterItem = (ConstraintLayout) view.findViewById(R.id.es);
            this.rl12 = (RelativeLayout) view.findViewById(R.id.Y3);
            this.rl24 = (RelativeLayout) view.findViewById(R.id.Z3);
            this.wrongTimeZoneTv.setTypeface(o0.d(App.m()));
            this.changeTimeZoneBtn.setTypeface(o0.d(App.m()));
            this.timeZoneTime.setTypeface(o0.b(App.m()));
            this.timeZoneDay.setTypeface(o0.d(App.m()));
            this.timeZoneDate.setTypeface(o0.d(App.m()));
            this.use24Title.setTypeface(o0.d(App.m()));
            this.use12Title.setTypeface(o0.d(App.m()));
            this.llFeedbackBtn = (LinearLayout) view.findViewById(R.id.A5);
            this.tvFeedbackTitle = (TextView) view.findViewById(R.id.B5);
            this.llFeedbackBtn.setOnClickListener(this.feedBackClickListener);
            this.tvFeedbackTitle.setTypeface(o0.d(App.m()));
            this.wrongTimeZoneTv.setText(p0.l0("WRONG_TIME_ZONE"));
            this.use24Title.setText(p0.l0("USE_24_HOURS_FORMAT"));
            this.use12Title.setText(p0.l0("USE_12_HOURS_FORMAT"));
            this.tvFeedbackTitle.setText(p0.l0("FEEDBACK"));
            this.changeTimeZoneBtn.setText(p0.l0("CHANGE_YOUR_TIME_ZONE"));
            new SimpleDateFormat("hh:mm aaa");
            new SimpleDateFormat("HH:mm");
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm", this.userLocale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", this.userLocale);
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("E", this.userLocale);
            SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("MMM d", this.userLocale);
            if (this.is_24) {
                this.timeZoneTime.setText(simpleDateFormat2.format(date));
            } else {
                this.timeZoneTime.setText(simpleDateFormat.format(date));
            }
            this.timeZoneDay.setText(simpleDateFormat3.format(date));
            this.timeZoneDate.setText(simpleDateFormat4.format(date));
            this.changeTimeZoneBtn.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.TimeSettingsFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TimeSettingsFragment.this.needToRefresh = true;
                    TimeSettingsFragment.this.startActivity(new Intent("android.settings.DATE_SETTINGS"));
                    ee.k.p(App.m(), "time-zone", "change-tz", "click", true);
                }
            });
            this.use12Title.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.TimeSettingsFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TimeSettingsFragment.this.rb12.setChecked(true);
                    TimeSettingsFragment.this.rb24.setChecked(false);
                }
            });
            this.use24Title.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.TimeSettingsFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TimeSettingsFragment.this.rb24.setChecked(true);
                    TimeSettingsFragment.this.rb12.setChecked(false);
                }
            });
            this.rl12.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.TimeSettingsFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TimeSettingsFragment.this.rb12.setChecked(true);
                    TimeSettingsFragment.this.rb24.setChecked(false);
                }
            });
            this.rl24.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.TimeSettingsFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TimeSettingsFragment.this.rb24.setChecked(true);
                    TimeSettingsFragment.this.rb12.setChecked(false);
                }
            });
            this.rb12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.TimeSettingsFragment.6
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    if (z10) {
                        TimeSettingsFragment.this.rb24.setChecked(false);
                        if (sf.b.X1().r()) {
                            MainDashboardActivity.Z0 = true;
                        }
                        sf.b.X1().D9(false);
                        TimeSettingsFragment.this.needToRefresh = true;
                        TimeSettingsFragment.this.timeZoneTime.setText(new SimpleDateFormat("hh:mm", TimeSettingsFragment.this.userLocale).format(new Date(System.currentTimeMillis())));
                    }
                }
            });
            this.rb24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.TimeSettingsFragment.7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    if (z10) {
                        TimeSettingsFragment.this.rb12.setChecked(false);
                        if (!sf.b.X1().r()) {
                            MainDashboardActivity.Z0 = true;
                        }
                        sf.b.X1().D9(true);
                        TimeSettingsFragment.this.needToRefresh = true;
                        TimeSettingsFragment.this.timeZoneTime.setText(new SimpleDateFormat("HH:mm", TimeSettingsFragment.this.userLocale).format(new Date(System.currentTimeMillis())));
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.is_24 && !sf.b.X1().r()) {
            ee.k.q(App.m(), "time-zone", "select-format", "click", true, "format", "12");
        }
        if (this.is_24 || !sf.b.X1().r()) {
            return;
        }
        ee.k.q(App.m(), "time-zone", "select-format", "click", true, "format", "24");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            if (sf.b.X1().r()) {
                AppCompatRadioButton appCompatRadioButton = this.rb24;
                if (appCompatRadioButton != null) {
                    appCompatRadioButton.setChecked(true);
                }
            } else {
                AppCompatRadioButton appCompatRadioButton2 = this.rb12;
                if (appCompatRadioButton2 != null) {
                    appCompatRadioButton2.setChecked(true);
                }
            }
            boolean h12 = x0.h1();
            App.f20801u = h12;
            if (h12) {
                MainDashboardActivity.Z0 = true;
                this.preLoader.setGravity(0);
                new Thread(new a.d(this.localDataArriveListener)).start();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.scores365.ui.BaseSettingsFragmentActivity.ShouldRestartRootActivityListener
    public boolean shouldRestartRootActivity() {
        return this.needToRefresh;
    }
}
