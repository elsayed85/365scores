package com.scores365.tipster;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.api.m1;
import com.scores365.api.n0;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CountryObj;
import ee.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TipsterTelegramChannelInviteActivity extends com.scores365.Design.Activities.c implements View.OnClickListener {
    TextView F;
    TextView G;
    TextView H;
    TextView I;

    /* renamed from: b0  reason: collision with root package name */
    TextView f24287b0;

    /* renamed from: f0  reason: collision with root package name */
    AppCompatEditText f24288f0;

    /* renamed from: g0  reason: collision with root package name */
    AppCompatEditText f24289g0;

    /* renamed from: h0  reason: collision with root package name */
    AppCompatSpinner f24290h0;

    /* renamed from: i0  reason: collision with root package name */
    RelativeLayout f24291i0;

    /* renamed from: j0  reason: collision with root package name */
    Handler f24292j0;

    /* renamed from: k0  reason: collision with root package name */
    TextView[] f24293k0 = new TextView[4];

    /* renamed from: l0  reason: collision with root package name */
    boolean f24294l0 = true;

    /* loaded from: classes2.dex */
    private static class a extends AsyncTask<Void, Void, ArrayList<CountryObj>> {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<TipsterTelegramChannelInviteActivity> f24295a;

        public a(TipsterTelegramChannelInviteActivity tipsterTelegramChannelInviteActivity) {
            this.f24295a = new WeakReference<>(tipsterTelegramChannelInviteActivity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public ArrayList<CountryObj> doInBackground(Void... voidArr) {
            ArrayList<CountryObj> arrayList = new ArrayList<>();
            try {
                n0 n0Var = new n0(7);
                n0Var.call();
                Iterator<BaseObj> it = n0Var.e().iterator();
                while (it.hasNext()) {
                    BaseObj next = it.next();
                    if (next instanceof CountryObj) {
                        arrayList.add((CountryObj) next);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(ArrayList<CountryObj> arrayList) {
            super.onPostExecute(arrayList);
            try {
                WeakReference<TipsterTelegramChannelInviteActivity> weakReference = this.f24295a;
                TipsterTelegramChannelInviteActivity tipsterTelegramChannelInviteActivity = weakReference != null ? weakReference.get() : null;
                if (tipsterTelegramChannelInviteActivity != null) {
                    gi.a aVar = new gi.a(arrayList);
                    tipsterTelegramChannelInviteActivity.f24290h0.setAdapter((SpinnerAdapter) aVar);
                    int a10 = aVar.a(sf.a.i0(App.m()).j0());
                    if (a10 != -1) {
                        tipsterTelegramChannelInviteActivity.f24290h0.setSelection(a10);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f24296a;

        /* renamed from: b  reason: collision with root package name */
        String f24297b;

        /* renamed from: c  reason: collision with root package name */
        WeakReference<Handler> f24298c;

        /* renamed from: d  reason: collision with root package name */
        WeakReference<Activity> f24299d;

        /* renamed from: e  reason: collision with root package name */
        long f24300e;

        public b(String str, String str2, Activity activity, Handler handler) {
            this.f24296a = str;
            this.f24297b = str2;
            this.f24299d = new WeakReference<>(activity);
            this.f24298c = new WeakReference<>(handler);
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                this.f24300e = System.currentTimeMillis();
                Activity activity = this.f24299d.get();
                if (activity != null && (activity instanceof TipsterTelegramChannelInviteActivity)) {
                    ((TipsterTelegramChannelInviteActivity) activity).f24294l0 = false;
                }
                m1 m1Var = new m1(this.f24296a, this.f24297b);
                m1Var.call();
                Activity activity2 = this.f24299d.get();
                if (activity2 == null || (handler = this.f24298c.get()) == null) {
                    return;
                }
                handler.post(new c(activity2, m1Var.a()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f24301a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<Activity> f24302b;

        public c(Activity activity, boolean z10) {
            this.f24301a = z10;
            this.f24302b = new WeakReference<>(activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Activity activity = this.f24302b.get();
                if (activity != null && (activity instanceof TipsterTelegramChannelInviteActivity)) {
                    ((TipsterTelegramChannelInviteActivity) activity).f24294l0 = true;
                    ((TipsterTelegramChannelInviteActivity) activity).f24291i0.setVisibility(8);
                    if (this.f24301a) {
                        Toast.makeText(App.m(), p0.l0("TELEGRAM_FEEDBACK_MESSAGE"), 0).show();
                        activity.finish();
                    } else {
                        Toast.makeText(App.m(), p0.l0("TELEGRAM_FEEDBACK_FAILURE_MESSAGE"), 0).show();
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static Intent d1(String str) {
        Intent intent = new Intent(App.m(), TipsterTelegramChannelInviteActivity.class);
        intent.putExtra("sourceTag", str);
        intent.setFlags(268435456);
        return intent;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("TELEGRAM_INVITE_SCREEN_TITLE");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (this.f24294l0) {
                Object selectedItem = this.f24290h0.getSelectedItem();
                if (selectedItem instanceof CountryObj) {
                    CountryObj countryObj = (CountryObj) selectedItem;
                    String obj = this.f24289g0.getText().toString();
                    String obj2 = this.f24288f0.getText().toString();
                    if (obj.isEmpty() || obj2.isEmpty()) {
                        Toast.makeText(App.m(), p0.l0("TELEGRAM_MISSING_MESSAGE"), 0).show();
                    } else {
                        String str = "+" + countryObj.phoneCode + obj;
                        if (x0.j1(obj2)) {
                            this.f24291i0.setVisibility(0);
                            new Thread(new b(str, obj2, this, this.f24292j0)).start();
                            k.q(App.m(), "join-telegram", "button", "click", true, "email", obj2, "telephone", str, ShareConstants.FEED_SOURCE_PARAM, getIntent().getStringExtra("sourceTag"));
                        } else {
                            Toast.makeText(App.m(), p0.l0("TELEGRAM_WRONG_EMAIL"), 0).show();
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (x0.l1()) {
            setContentView(R.layout.f22663pa);
        } else {
            setContentView(R.layout.f22650oa);
        }
        try {
            x0.D1(this);
            initActionBar();
            this.F = (TextView) findViewById(R.id.fF);
            this.G = (TextView) findViewById(R.id.oz);
            this.f24287b0 = (TextView) findViewById(R.id.FA);
            this.H = (TextView) findViewById(R.id.rB);
            this.I = (TextView) findViewById(R.id.qy);
            this.f24288f0 = (AppCompatEditText) findViewById(R.id.f22175n5);
            this.f24290h0 = (AppCompatSpinner) findViewById(R.id.f22219p5);
            this.f24289g0 = (AppCompatEditText) findViewById(R.id.f22241q5);
            this.f24293k0[0] = (TextView) findViewById(R.id.jz);
            this.f24293k0[1] = (TextView) findViewById(R.id.kz);
            this.f24293k0[2] = (TextView) findViewById(R.id.lz);
            this.f24293k0[3] = (TextView) findViewById(R.id.mz);
            this.f24291i0 = (RelativeLayout) findViewById(R.id.Jn);
            this.H.setTypeface(o0.d(App.m()));
            this.I.setTypeface(o0.b(App.m()));
            this.F.setTypeface(o0.d(App.m()));
            this.G.setTypeface(o0.b(App.m()));
            this.f24287b0.setTypeface(o0.c(App.m()));
            this.H.setText(p0.l0("TIPSTERS_PROMOTION_TITLE").replaceAll("#", ""));
            this.F.setText("* " + p0.l0("TELEGTAM_DOWNLOAD"));
            this.f24288f0.setInputType(524288);
            this.G.setText(p0.l0("TELEGRAM_INFORMATION"));
            this.f24287b0.setText(p0.l0("TELEGRAM_BUTTON"));
            this.f24287b0.setOnClickListener(this);
            for (TextView textView : this.f24293k0) {
                textView.setTypeface(o0.b(App.m()));
            }
            this.f24293k0[0].setText(p0.l0("BULLET_EXTRA_DAILY"));
            this.f24293k0[1].setText(p0.l0("BULLET_LIVE_GAME"));
            this.f24293k0[2].setText(p0.l0("BULLET_ADDITIONAL_BETTING"));
            this.f24293k0[3].setText(p0.l0("BULLET_BETS_TO_AVOID"));
            this.I.setText(Html.fromHtml(p0.l0("TELEGRAM_INVITE_SCREEN_SLOGEN").replaceAll("#", "<font color=#03a9f4>") + "</font>"));
            this.f24288f0.setHint(p0.l0("TELEGRAM_EMAIL"));
            this.f24288f0.setTypeface(o0.d(App.m()));
            this.f24289g0.setTypeface(o0.d(App.m()));
            new a(this).execute(new Void[0]);
            this.f24292j0 = new Handler();
            k.q(App.m(), "join-telegram", ServerProtocol.DIALOG_PARAM_DISPLAY, null, true, ShareConstants.FEED_SOURCE_PARAM, getIntent().getStringExtra("sourceTag"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
