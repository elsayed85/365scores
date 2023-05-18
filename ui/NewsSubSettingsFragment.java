package com.scores365.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.scores365.App;
import com.scores365.R;
import com.scores365.ui.BaseSettingsFragmentActivity;
import java.util.HashSet;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class NewsSubSettingsFragment extends com.scores365.Design.Pages.a implements BaseSettingsFragmentActivity.ShouldRestartRootActivityListener {
    private LinearLayout llFeedbackBtn;
    private RelativeLayout llNewsLanguage;
    private RelativeLayout rlNewsSource;
    private TextView tvFeedbackTitle;
    private TextView tvNewsLanguageTitle;
    private TextView tvNewsLanguageValue;
    private TextView tvNewsSourceTitle;
    private String lastNewsLanguageIDs = "";
    private HashSet<Integer> removedNewsSources = new HashSet<>();
    public boolean isNeedToRestartMainActivity = false;
    public boolean isLanguageChanged = false;
    public boolean isNewsSourcesChanged = false;
    View.OnClickListener feedBackClickListener = new View.OnClickListener() { // from class: com.scores365.ui.NewsSubSettingsFragment.1
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
    View.OnClickListener newsLanguageClickListener = new View.OnClickListener() { // from class: com.scores365.ui.NewsSubSettingsFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(App.m(), SelectLanguage.class);
                intent.setAction("2");
                intent.setFlags(67108864);
                NewsSubSettingsFragment.this.startActivity(intent);
                NewsSubSettingsFragment.sendSettingsClickAnalyticsEvent("language");
            } catch (Exception unused) {
            }
        }
    };
    View.OnClickListener newsSourceClickListener = new View.OnClickListener() { // from class: com.scores365.ui.NewsSubSettingsFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(App.m(), BaseSettingsFragmentActivity.class);
                intent.putExtra("isSelectNewsSource", true);
                NewsSubSettingsFragment.this.startActivity(intent);
                NewsSubSettingsFragment.sendSettingsClickAnalyticsEvent(ShareConstants.FEED_SOURCE_PARAM);
            } catch (Exception unused) {
            }
        }
    };

    public static NewsSubSettingsFragment newInstance() {
        try {
            return new NewsSubSettingsFragment();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static void sendSettingsClickAnalyticsEvent(String str) {
        try {
            ee.k.o(App.m(), "more", "news", "setting", "click", "setting_type", str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void updateNewsLang() {
        try {
            String s22 = sf.b.X1().s2();
            if (!this.lastNewsLanguageIDs.equals(s22)) {
                this.lastNewsLanguageIDs = s22;
                this.isLanguageChanged = true;
            }
            HashSet<Integer> x12 = sf.b.X1().x1();
            if (!this.removedNewsSources.equals(x12)) {
                this.removedNewsSources = x12;
                this.isNewsSourcesChanged = true;
            }
            this.tvNewsLanguageValue.setText(x0.r0(App.m()));
            this.tvNewsLanguageValue.setGravity(x0.K() | 16);
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
        return p0.l0("SETTINGS_LANGUAGE_NEWS");
    }

    public boolean isLanguageChanged() {
        return this.isLanguageChanged;
    }

    public boolean isNewsSourcesChanged() {
        return this.isNewsSourcesChanged;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.f22463a5, viewGroup, false);
            this.llFeedbackBtn = (LinearLayout) view.findViewById(R.id.A5);
            this.tvFeedbackTitle = (TextView) view.findViewById(R.id.B5);
            this.llFeedbackBtn.setOnClickListener(this.feedBackClickListener);
            this.tvFeedbackTitle.setTypeface(o0.d(App.m().getApplicationContext()));
            this.tvFeedbackTitle.setText(p0.l0("FEEDBACK"));
            this.lastNewsLanguageIDs = sf.b.X1().s2();
            this.removedNewsSources = sf.b.X1().x1();
            this.llNewsLanguage = (RelativeLayout) view.findViewById(R.id.Gn);
            this.tvNewsLanguageTitle = (TextView) view.findViewById(R.id.f22076ii);
            this.tvNewsLanguageValue = (TextView) view.findViewById(R.id.f22100ji);
            this.llNewsLanguage.setOnClickListener(this.newsLanguageClickListener);
            this.tvNewsLanguageTitle.setText(p0.l0("SETTINGS_NEWS_LANG"));
            this.tvNewsLanguageTitle.setTypeface(o0.d(App.m().getApplicationContext()));
            this.tvNewsLanguageValue.setTypeface(o0.d(App.m().getApplicationContext()));
            updateNewsLang();
            this.rlNewsSource = (RelativeLayout) view.findViewById(R.id.Hn);
            this.tvNewsSourceTitle = (TextView) view.findViewById(R.id.GB);
            this.rlNewsSource.setOnClickListener(this.newsSourceClickListener);
            this.tvNewsSourceTitle.setText(p0.l0("SETTINGS_LANGUAGE_NEWS_SOURCES"));
            this.tvNewsSourceTitle.setTypeface(o0.d(App.m().getApplicationContext()));
            this.tvNewsSourceTitle.setGravity(x0.L());
            TextView textView = (TextView) view.findViewById(R.id.gs);
            textView.setTypeface(o0.d(App.m().getApplicationContext()));
            textView.setText(p0.l0("SETTINGS_LANGUAGE_NEWS"));
            return view;
        } catch (Exception e10) {
            x0.N1(e10);
            return view;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            if (!this.lastNewsLanguageIDs.equals(sf.b.X1().s2()) || !this.removedNewsSources.equals(sf.b.X1().x1())) {
                updateNewsLang();
                this.isNeedToRestartMainActivity = true;
                App.b.y0();
            }
            ((com.scores365.Design.Activities.c) getActivity()).RefreshActionbar();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.ui.BaseSettingsFragmentActivity.ShouldRestartRootActivityListener
    public boolean shouldRestartRootActivity() {
        return this.isLanguageChanged || this.isNewsSourcesChanged;
    }
}
