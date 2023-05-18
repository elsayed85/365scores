package com.scores365.dashboard.following;

import af.e;
import af.g;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.ui.CustomGameCenterHeaderView;
import ee.k;
import li.o0;
import li.p0;
import li.u;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class RemoveFavouriteTeamPopUpActivity extends com.scores365.Design.Activities.d {
    TextView F;
    TextView G;
    TextView H;
    TextView I;

    /* renamed from: b0  reason: collision with root package name */
    ImageView f23365b0;

    /* renamed from: f0  reason: collision with root package name */
    ImageView f23366f0;

    /* renamed from: g0  reason: collision with root package name */
    String f23367g0;

    /* renamed from: h0  reason: collision with root package name */
    String f23368h0;

    /* renamed from: i0  reason: collision with root package name */
    int f23369i0;

    /* renamed from: j0  reason: collision with root package name */
    int f23370j0;

    /* renamed from: k0  reason: collision with root package name */
    int f23371k0;

    /* renamed from: l0  reason: collision with root package name */
    g f23372l0;

    /* renamed from: m0  reason: collision with root package name */
    int f23373m0;

    /* renamed from: n0  reason: collision with root package name */
    private BaseObj f23374n0;

    /* renamed from: o0  reason: collision with root package name */
    private final View.OnClickListener f23375o0 = new a();

    /* renamed from: p0  reason: collision with root package name */
    private final View.OnClickListener f23376p0 = new b();

    /* renamed from: q0  reason: collision with root package name */
    private final View.OnClickListener f23377q0 = new c();

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                RemoveFavouriteTeamPopUpActivity removeFavouriteTeamPopUpActivity = RemoveFavouriteTeamPopUpActivity.this;
                removeFavouriteTeamPopUpActivity.H((e) removeFavouriteTeamPopUpActivity.f23372l0, d.no);
                Intent intent = new Intent();
                intent.putExtra("should_remove_competitor", false);
                RemoveFavouriteTeamPopUpActivity.this.setResult(993, intent);
                RemoveFavouriteTeamPopUpActivity.this.finish();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                RemoveFavouriteTeamPopUpActivity removeFavouriteTeamPopUpActivity = RemoveFavouriteTeamPopUpActivity.this;
                removeFavouriteTeamPopUpActivity.H((e) removeFavouriteTeamPopUpActivity.f23372l0, d.yes);
                Intent intent = new Intent();
                intent.putExtra("should_remove_competitor", true);
                intent.putExtra("follow_base_obj", RemoveFavouriteTeamPopUpActivity.this.f23372l0);
                intent.putExtra("baseObjFollowed", RemoveFavouriteTeamPopUpActivity.this.f23374n0);
                intent.putExtra("container_tag", RemoveFavouriteTeamPopUpActivity.this.f23373m0);
                RemoveFavouriteTeamPopUpActivity.this.setResult(993, intent);
                RemoveFavouriteTeamPopUpActivity.this.finish();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                RemoveFavouriteTeamPopUpActivity removeFavouriteTeamPopUpActivity = RemoveFavouriteTeamPopUpActivity.this;
                removeFavouriteTeamPopUpActivity.H((e) removeFavouriteTeamPopUpActivity.f23372l0, d.exit);
                RemoveFavouriteTeamPopUpActivity.this.finish();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum d {
        yes,
        no,
        exit
    }

    public static Intent F(e eVar, int i10, boolean z10, BaseObj baseObj) {
        Intent intent = new Intent(App.m(), RemoveFavouriteTeamPopUpActivity.class);
        try {
            intent.putExtra("country_id", eVar.m());
            intent.putExtra("team_id", eVar.n());
            intent.putExtra("team_name", eVar.b());
            intent.putExtra("sport_id", eVar.p());
            intent.putExtra("follow_base_obj", eVar);
            intent.putExtra("baseObjFollowed", baseObj);
            intent.putExtra("container_tag", i10);
            intent.putExtra("img_version_tag", eVar.o());
            intent.putExtra("athlete_removal", z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    private void G(e eVar) {
        try {
            Context m10 = App.m();
            String[] strArr = new String[8];
            strArr[0] = "entity_type";
            strArr[1] = eVar instanceof af.d ? "2" : "5";
            strArr[2] = "entity_id";
            strArr[3] = String.valueOf(eVar.n());
            strArr[4] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[5] = eVar instanceof af.d ? "teams" : "athletes";
            strArr[6] = "screen";
            strArr[7] = "following";
            k.q(m10, "selection-menu", "itemsdelete", null, true, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(e eVar, d dVar) {
        try {
            if (dVar == d.yes) {
                G(eVar);
                if (getIntent().getBooleanExtra("athlete_removal", false)) {
                    App.c cVar = App.c.ATHLETE;
                    x0.e2(cVar, eVar.n(), eVar.p(), false, true, false, false, "favorite", "", "unselect", false, false);
                    x0.e2(cVar, eVar.n(), eVar.p(), false, true, false, false, "following", "", "unselect", false, false);
                } else {
                    boolean z10 = sf.a.i0(App.m()).a0(eVar.n()).getType() == CompObj.eCompetitorType.NATIONAL;
                    boolean p12 = sf.a.i0(App.m()).p1(eVar.n());
                    App.c cVar2 = App.c.TEAM;
                    x0.e2(cVar2, eVar.n(), eVar.p(), false, true, false, false, "favorite", "", "unselect", z10, p12);
                    x0.e2(cVar2, eVar.n(), eVar.p(), false, true, false, false, "following", "", "unselect", z10, p12);
                }
            }
            k.o(App.m(), "selection-menu", "itemsdelete-popup", "click", null, "entity_type", String.valueOf(2), "click_type", dVar.name());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void a1() {
        try {
            k.o(App.m(), "selection-menu", "itemsdelete-popup", ServerProtocol.DIALOG_PARAM_DISPLAY, null, "entity_type", String.valueOf(2), "entity_id", String.valueOf(((e) this.f23372l0).n()), ShareConstants.FEED_SOURCE_PARAM, "teams", "screen", "following");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void b1(ImageView imageView) {
        int i10;
        try {
            if (this.f23369i0 != -1 && this.f23370j0 != -1) {
                if (getIntent().getBooleanExtra("athlete_removal", false)) {
                    u.i(this.f23370j0, true, imageView, p0.K(R.attr.f21594w0), false);
                } else if (this.f23369i0 != SportTypesEnum.TENNIS.getValue() || (i10 = this.f23371k0) == -1) {
                    u.A(o.l(p.Competitors, this.f23370j0, Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), Integer.valueOf((int) CustomGameCenterHeaderView.IMAGE_SIZE), false, true, Integer.valueOf(this.f23369i0), null, null, this.f23368h0), imageView, p0.K(R.attr.f21594w0));
                } else {
                    u.J(this.f23370j0, i10, imageView, this.f23368h0);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void init() {
        try {
            this.F = (TextView) findViewById(R.id.Vm);
            this.G = (TextView) findViewById(R.id.Um);
            this.f23365b0 = (ImageView) findViewById(R.id.C3);
            this.f23366f0 = (ImageView) findViewById(R.id.Sr);
            this.H = (TextView) findViewById(R.id.Wm);
            this.I = (TextView) findViewById(R.id.Tm);
            this.H.setOnClickListener(this.f23376p0);
            this.I.setOnClickListener(this.f23375o0);
            this.f23365b0.setOnClickListener(this.f23377q0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setText() {
        try {
            this.F.setText(this.f23367g0);
            g gVar = this.f23372l0;
            boolean z10 = gVar instanceof af.d;
            boolean z11 = z10 && ((af.d) gVar).p() == 3;
            if (z10 && ((af.d) this.f23372l0).p() != 3) {
                this.G.setText(p0.l0("NEW_DASHBOARD_REMOVE").replace("#TEAM", this.f23367g0));
            } else if ((this.f23372l0 instanceof af.a) || z11) {
                this.G.setText(p0.l0("NEW_DASHBOARD_REMOVE_PLAYERS").replace("#PLAYERNAME", this.f23367g0));
            }
            this.I.setText(p0.l0("NO"));
            this.H.setText(p0.l0("YES"));
            b1(this.f23366f0);
            this.F.setTypeface(o0.c(getApplicationContext()));
            this.G.setTypeface(o0.b(getApplicationContext()));
            this.F.setTypeface(o0.d(getApplicationContext()));
            this.G.setTypeface(o0.b(getApplicationContext()));
            this.I.setTypeface(o0.d(getApplicationContext()));
            this.H.setTypeface(o0.d(getApplicationContext()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23369i0 = getIntent().getIntExtra("sport_id", -1);
        this.f23371k0 = getIntent().getIntExtra("country_id", -1);
        this.f23370j0 = getIntent().getIntExtra("team_id", -1);
        this.f23367g0 = getIntent().getStringExtra("team_name");
        this.f23372l0 = (g) getIntent().getSerializableExtra("follow_base_obj");
        this.f23374n0 = (BaseObj) getIntent().getSerializableExtra("baseObjFollowed");
        this.f23368h0 = getIntent().getStringExtra("img_version_tag");
        this.f23373m0 = getIntent().getIntExtra("container_tag", -1);
        setTheme(App.f20805y);
        x0.g2(this);
        setContentView(R.layout.f22688s);
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = -2;
            attributes.width = p0.s(300);
            getWindow().setAttributes(attributes);
            init();
            setText();
            a1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
