package com.scores365.leadForm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.d;
import androidx.fragment.app.a0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import ee.k;
import hg.c;
import hg.e;
import hg.g;
import ig.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.x0;
/* compiled from: LeadFormActivity.kt */
/* loaded from: classes2.dex */
public class LeadFormActivity extends d implements ig.a, c {
    public static final a H = new a(null);
    private FrameLayout F;
    private fg.c G = new fg.c();

    /* compiled from: LeadFormActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(String source) {
            m.g(source, "source");
            Intent intent = new Intent(App.m(), LeadFormActivity.class);
            intent.putExtra("lead_form_anal_source", source);
            return intent;
        }
    }

    private final void a1() {
        finish();
    }

    private final void g1() {
        try {
            hg.c cVar = (hg.c) getSupportFragmentManager().v0().get(0);
            m.d(cVar);
            cVar.p();
            Bundle arguments = cVar.getArguments();
            if (arguments != null) {
                arguments.putInt("selected_team_id_key", this.G.b());
            }
            cVar.v1();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // ig.a
    public void a0() {
        c.a aVar = hg.c.f27888u;
        String a10 = aVar.a();
        Context m10 = App.m();
        String[] strArr = new String[10];
        strArr[0] = "promotion_name";
        strArr[1] = "lead-form";
        strArr[2] = "screen_name";
        strArr[3] = "details";
        strArr[4] = "screen_type";
        strArr[5] = a10;
        strArr[6] = "click_type";
        strArr[7] = "next";
        strArr[8] = ShareConstants.FEED_SOURCE_PARAM;
        Intent intent = getIntent();
        FrameLayout frameLayout = null;
        strArr[9] = intent != null ? intent.getStringExtra("lead_form_anal_source") : null;
        k.n(m10, "general", "promotion-feature", "screen", "click", false, strArr);
        a0 q10 = getSupportFragmentManager().q();
        FrameLayout frameLayout2 = this.F;
        if (frameLayout2 == null) {
            m.t("fl");
        } else {
            frameLayout = frameLayout2;
        }
        q10.p(frameLayout.getId(), aVar.b(this.G.b())).g("choose_team").h();
    }

    public final fg.c b1() {
        return this.G;
    }

    public void d1() {
        k.n(App.m(), "general", "promotion-feature", "screen", ServerProtocol.DIALOG_PARAM_DISPLAY, false, "promotion_name", "lead-form", "screen_name", "details", ShareConstants.FEED_SOURCE_PARAM, getIntent().getStringExtra("lead_form_anal_source"));
        a0 q10 = getSupportFragmentManager().q();
        FrameLayout frameLayout = this.F;
        if (frameLayout == null) {
            m.t("fl");
            frameLayout = null;
        }
        q10.p(frameLayout.getId(), e.E.a()).g("formPage").h();
    }

    public void e1() {
        try {
            startActivityForResult(LeadFormSearchActivity.f24106g0.a(this.G.b(), getIntent().getStringExtra("lead_form_anal_source")), 1233);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // ig.c
    public void h0() {
        String a10 = hg.c.f27888u.a();
        Context m10 = App.m();
        String[] strArr = new String[10];
        strArr[0] = "promotion_name";
        strArr[1] = "lead-form";
        strArr[2] = "screen_name";
        strArr[3] = "pick-team";
        strArr[4] = "screen_type";
        strArr[5] = a10;
        strArr[6] = "click_type";
        strArr[7] = "browse";
        strArr[8] = ShareConstants.FEED_SOURCE_PARAM;
        Intent intent = getIntent();
        strArr[9] = intent != null ? intent.getStringExtra("lead_form_anal_source") : null;
        k.n(m10, "general", "promotion-feature", "screen", "click", false, strArr);
        e1();
    }

    @Override // ig.a
    public void j0() {
        String a10 = hg.c.f27888u.a();
        Context m10 = App.m();
        String[] strArr = new String[16];
        strArr[0] = "promotion_name";
        strArr[1] = "lead-form";
        strArr[2] = "screen_name";
        strArr[3] = "browse-team";
        strArr[4] = "screen_type";
        strArr[5] = a10;
        strArr[6] = "entity_type";
        strArr[7] = "2";
        strArr[8] = "entity_id";
        strArr[9] = String.valueOf(this.G.b());
        strArr[10] = "is_followed";
        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        strArr[11] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        strArr[12] = "is_favorite";
        if (!App.b.T().contains(Integer.valueOf(this.G.b()))) {
            str = "0";
        }
        strArr[13] = str;
        strArr[14] = ShareConstants.FEED_SOURCE_PARAM;
        strArr[15] = getIntent().getStringExtra("lead_form_anal_source");
        k.n(m10, "general", "promotion-feature", "selection", null, false, strArr);
        g a11 = g.f27915l.a(this.G.b(), this.G.a());
        if (a11 != null) {
            a11.show(getSupportFragmentManager(), "popup");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        Boolean valueOf;
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1233 && i11 == -1) {
            if (intent != null) {
                try {
                    valueOf = Boolean.valueOf(intent.getBooleanExtra("isDirty", false));
                } catch (Exception e10) {
                    x0.N1(e10);
                    return;
                }
            } else {
                valueOf = null;
            }
            m.d(valueOf);
            if (!valueOf.booleanValue() || intent.getIntExtra("lead_form_selected", -1) == -1) {
                return;
            }
            this.G.d(intent.getIntExtra("lead_form_selected", -1));
            this.G.c((CompObj) intent.getSerializableExtra("team_object"));
            g1();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        try {
            if (getIntent() != null && getIntent().getBooleanExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, false)) {
                Intent x02 = x0.x0();
                x02.setFlags(268435456);
                x02.setFlags(67108864);
                startActivity(x02);
                finish();
            }
            if (getSupportFragmentManager().p0() < 1) {
                a1();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.D1(this);
        setActivityTheme();
        setContentView(R.layout.f22561i);
        setRequestedOrientation(1);
        View findViewById = findViewById(R.id.f22119kf);
        m.f(findViewById, "findViewById(R.id.lead_form_fl)");
        this.F = (FrameLayout) findViewById;
        try {
            Intent intent = getIntent();
            if (intent != null && intent.getData() != null) {
                getIntent().putExtra("lead_form_anal_source", "notification");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        d1();
    }

    protected void setActivityTheme() {
        try {
            if (App.f20805y == -1) {
                if (x0.n1()) {
                    App.f20805y = R.style.f22831f;
                } else {
                    App.f20805y = R.style.f22830e;
                }
            }
            setTheme(App.f20805y);
            App.f20804x = getTheme();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ig.c
    public void u0(jg.a teamObj) {
        m.g(teamObj, "teamObj");
        try {
            fg.c cVar = this.G;
            CompObj a10 = teamObj.a();
            Integer valueOf = a10 != null ? Integer.valueOf(a10.getID()) : null;
            m.d(valueOf);
            cVar.d(valueOf.intValue());
            this.G.c(teamObj.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
