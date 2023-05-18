package com.scores365.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.e1;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
import li.z0;
/* loaded from: classes2.dex */
public class LocalizationSettingsActivity extends com.scores365.Design.Activities.c {
    private int lastLanguageID;
    private LinearLayout llFeedbackBtn;
    private RelativeLayout llGeneralLanguage;
    private RelativeLayout llNewsLanguage;
    public Dialog progress2;
    private TextView tvFeedbackTitle;
    private TextView tvGeneralLanguageTitle;
    private TextView tvGeneralLanguageValue;
    private TextView tvLocalizationTitle;
    private TextView tvNewsLanguageTitle;
    private TextView tvNewsLanguageValue;
    private boolean isDirty = false;
    private boolean isLanguageChanged = false;
    private String lastNewsLanguageIDs = "";
    View.OnClickListener generalLanguageClickListener = new View.OnClickListener() { // from class: com.scores365.ui.LocalizationSettingsActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(LocalizationSettingsActivity.this.getApplicationContext(), SelectLanguage.class);
                intent.setFlags(67108864);
                LocalizationSettingsActivity.this.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    };
    View.OnClickListener newsLanguageClickListener = new View.OnClickListener() { // from class: com.scores365.ui.LocalizationSettingsActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(LocalizationSettingsActivity.this.getApplicationContext(), SelectLanguage.class);
                intent.setAction("2");
                intent.setFlags(67108864);
                LocalizationSettingsActivity.this.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    };
    View.OnClickListener feedBackClickListener = new View.OnClickListener() { // from class: com.scores365.ui.LocalizationSettingsActivity.3
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

    private void initViews() {
        this.tvLocalizationTitle = (TextView) findViewById(R.id.Vg);
        this.llGeneralLanguage = (RelativeLayout) findViewById(R.id.Fe);
        this.tvGeneralLanguageTitle = (TextView) findViewById(R.id.He);
        this.tvGeneralLanguageValue = (TextView) findViewById(R.id.Ie);
        this.llNewsLanguage = (RelativeLayout) findViewById(R.id.f22010fi);
        this.tvNewsLanguageTitle = (TextView) findViewById(R.id.f22299si);
        this.tvNewsLanguageValue = (TextView) findViewById(R.id.f22321ti);
        this.llFeedbackBtn = (LinearLayout) findViewById(R.id.A5);
        this.tvFeedbackTitle = (TextView) findViewById(R.id.B5);
    }

    private void measureTextViews() {
        try {
            TextView textView = this.tvGeneralLanguageTitle;
            textView.measure(textView.getWidth(), this.tvGeneralLanguageTitle.getHeight());
            TextView textView2 = this.tvNewsLanguageTitle;
            textView2.measure(textView2.getWidth(), this.tvNewsLanguageTitle.getHeight());
            int max = Math.max(this.tvGeneralLanguageTitle.getMeasuredWidth(), this.tvNewsLanguageTitle.getMeasuredWidth());
            int width = (getWindowManager().getDefaultDisplay().getWidth() - max) - p0.s(30);
            this.tvGeneralLanguageValue.setMinWidth(width);
            this.tvNewsLanguageValue.setMinWidth(width);
            this.tvGeneralLanguageValue.setMaxWidth(width);
            this.tvNewsLanguageValue.setMaxWidth(width);
            this.tvGeneralLanguageValue.setGravity(x0.K());
            this.tvNewsLanguageValue.setGravity(x0.K());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void sendSettingsChangedAnalyticsEvent(String str) {
        try {
            ee.k.o(App.m(), "more", "news", "setting-changed", null, "setting_type", str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setListeners() {
        this.llGeneralLanguage.setOnClickListener(this.generalLanguageClickListener);
        this.llNewsLanguage.setOnClickListener(this.newsLanguageClickListener);
        this.llFeedbackBtn.setOnClickListener(this.feedBackClickListener);
    }

    private void updateLanguageText() {
        try {
            this.tvGeneralLanguageValue.setText(App.l().getLanguages().get(Integer.valueOf(sf.a.i0(this).k0())).getName());
            if (this.lastLanguageID != sf.a.i0(getApplicationContext()).k0()) {
                this.lastLanguageID = sf.a.i0(getApplicationContext()).k0();
                this.isLanguageChanged = true;
                this.isDirty = true;
            }
        } catch (Exception unused) {
        }
    }

    private void updateNewsLang() {
        try {
            if (!this.lastNewsLanguageIDs.equals(sf.b.X1().s2())) {
                this.lastNewsLanguageIDs = sf.b.X1().s2();
                this.isLanguageChanged = true;
            }
            this.tvNewsLanguageValue.setText(x0.r0(getApplicationContext()));
            this.tvNewsLanguageValue.setGravity(x0.K());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void updateTextViews() {
        try {
            this.toolbar.setTitle(p0.l0("SETTINGS_LANGUAGE_LANGUAGE"));
            this.tvLocalizationTitle.setText(p0.l0("SETTINGS_LANGUAGE_LANGUAGE"));
            this.tvGeneralLanguageTitle.setText(p0.l0("SETTINGS_LANG"));
            this.tvNewsLanguageTitle.setText(p0.l0("SETTINGS_NEWS_LANG"));
            this.tvFeedbackTitle.setText(p0.l0("FEEDBACK"));
            this.tvLocalizationTitle.setTypeface(o0.c(getApplicationContext()));
            this.tvGeneralLanguageTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvNewsLanguageTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvGeneralLanguageValue.setTypeface(o0.d(getApplicationContext()));
            this.tvNewsLanguageValue.setTypeface(o0.d(getApplicationContext()));
            this.tvFeedbackTitle.setTypeface(o0.d(getApplicationContext()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        measureTextViews();
    }

    @Override // com.scores365.Design.Activities.c
    public int getAppIcon() {
        return 0;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("SETTINGS_LANGUAGE_LANGUAGE");
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (sf.a.i0(getApplicationContext()).h0()) {
                if (this.isLanguageChanged) {
                    Intent x02 = x0.x0();
                    x02.setFlags(268435456);
                    x02.setFlags(67108864);
                    startActivity(x02);
                    sendSettingsChangedAnalyticsEvent("language");
                } else {
                    super.onBackPressed();
                }
            } else if (z0.g()) {
                this.progress2 = p0.H0(this, "", null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.j2(this);
        x0.D1(this);
        setContentView(R.layout.f22587k);
        initActionBar();
        try {
            initViews();
            updateTextViews();
            setListeners();
            this.lastLanguageID = sf.a.i0(this).k0();
            this.lastNewsLanguageIDs = sf.b.X1().s2();
            updateLanguageText();
            updateNewsLang();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            this.toolbar.setElevation(p0.s(4));
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        z0.a();
        try {
            if (this.isDirty) {
                this.isDirty = false;
                sf.a.i0(getApplicationContext()).D();
                sf.a.i0(getApplicationContext()).I();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            updateLanguageText();
            updateNewsLang();
            updateTextViews();
            this.isDirty = true;
            updateNewsLang();
            e1.I0(findViewById(R.id.Fn), x0.m0());
            initActionBar();
        } catch (Exception unused) {
        }
    }
}
