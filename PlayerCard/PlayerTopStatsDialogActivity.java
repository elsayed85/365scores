package com.scores365.PlayerCard;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.R;
import com.scores365.api.c0;
import com.scores365.entitys.LastMatchesObj;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import ee.k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerTopStatsDialogActivity extends com.scores365.Design.Activities.d implements View.OnClickListener {
    TextView F;
    TextView G;
    TextView H;
    ProgressBar I;

    /* renamed from: b0  reason: collision with root package name */
    FrameLayout f21363b0;

    /* renamed from: f0  reason: collision with root package name */
    int f21364f0;

    /* renamed from: g0  reason: collision with root package name */
    int f21365g0;

    /* renamed from: h0  reason: collision with root package name */
    int f21366h0;

    /* renamed from: i0  reason: collision with root package name */
    long f21367i0 = 50;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerTopStatsDialogActivity.this.a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends AsyncTask<Void, Void, LastMatchesObj> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<PlayerTopStatsDialogActivity> f21369a;

        /* renamed from: b  reason: collision with root package name */
        private int f21370b;

        /* renamed from: c  reason: collision with root package name */
        private int f21371c;

        /* renamed from: d  reason: collision with root package name */
        private int f21372d;

        public b(PlayerTopStatsDialogActivity playerTopStatsDialogActivity, int i10, int i11, int i12) {
            this.f21369a = new WeakReference<>(playerTopStatsDialogActivity);
            this.f21370b = i10;
            this.f21371c = i11;
            this.f21372d = i12;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public LastMatchesObj doInBackground(Void... voidArr) {
            Log.d("LoadStatDataTask", "doInBackground: ");
            try {
                if (x0.o1(App.m())) {
                    c0 c0Var = new c0(this.f21370b, this.f21371c, this.f21372d);
                    c0Var.call();
                    return c0Var.a();
                }
                return null;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(LastMatchesObj lastMatchesObj) {
            super.onPostExecute(lastMatchesObj);
            try {
                PlayerTopStatsDialogActivity playerTopStatsDialogActivity = this.f21369a.get();
                if (playerTopStatsDialogActivity != null) {
                    playerTopStatsDialogActivity.b1(lastMatchesObj);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                WeakReference<PlayerTopStatsDialogActivity> weakReference = this.f21369a;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                this.f21369a.get().d1();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static Intent G(int i10, int i11, String str, int i12, String str2, boolean z10, String str3) {
        Intent intent = new Intent(App.m(), PlayerTopStatsDialogActivity.class);
        try {
            intent.putExtra("athleteId", i10);
            intent.putExtra(SinglePlayerCardActivity.COMPETITION_ID_KEY, i11);
            intent.putExtra("competitionName", str);
            intent.putExtra("statTypeId", i12);
            intent.putExtra("statTypeName", str2);
            intent.putExtra("screenForAnalyticsTag", str3);
            intent.putExtra("isManagement", z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        new b(this, this.f21364f0, this.f21365g0, this.f21366h0).execute(new Void[0]);
        this.f21367i0 *= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(LastMatchesObj lastMatchesObj) {
        int size;
        try {
            if (lastMatchesObj == null) {
                new Handler().postDelayed(new a(), this.f21367i0);
                return;
            }
            this.I.setVisibility(8);
            if (lastMatchesObj.getMissingStatMessage() != null) {
                this.H.setVisibility(0);
                this.H.setText(lastMatchesObj.getMissingStatMessage());
                size = 0;
            } else {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                size = lastMatchesObj.getGames().size();
                attributes.height = p0.s(56) + (Math.min(6, size) * p0.s(45)) + p0.s(7);
                attributes.width = App.p() - p0.s(64);
                getWindow().setAttributes(attributes);
                this.f21363b0.setVisibility(0);
                boolean booleanExtra = getIntent().getBooleanExtra("isManagement", false);
                getSupportFragmentManager().q().c(R.id.f21998f6, c.z1(lastMatchesObj, getIntent().getIntExtra("statTypeId", -1), getIntent().getIntExtra("athleteId", -1), booleanExtra), "PlayerTopStatsDialogListPageTag").h();
            }
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            Intent intent = getIntent();
            int intExtra = intent.getIntExtra("athleteId", -1);
            int intExtra2 = intent.getIntExtra(SinglePlayerCardActivity.COMPETITION_ID_KEY, -1);
            int intExtra3 = intent.getIntExtra("statTypeId", -1);
            String stringExtra = intent.getStringExtra("screenForAnalyticsTag");
            HashMap hashMap = new HashMap();
            hashMap.put("athlete_id", Integer.valueOf(intExtra));
            hashMap.put("competition_id", Integer.valueOf(intExtra2));
            hashMap.put("screen", stringExtra);
            hashMap.put("category", Integer.valueOf(intExtra3));
            hashMap.put("num_games", Integer.valueOf(size));
            k.k(App.m(), "athlete", "stats", "details", ServerProtocol.DIALOG_PARAM_DISPLAY, hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        try {
            this.I.setVisibility(0);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.f21363b0.setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void init() {
        try {
            this.F = (TextView) findViewById(R.id.I6);
            this.G = (TextView) findViewById(R.id.zr);
            this.H = (TextView) findViewById(R.id.Ey);
            this.I = (ProgressBar) findViewById(R.id.Ej);
            this.f21363b0 = (FrameLayout) findViewById(R.id.f21998f6);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setText() {
        try {
            String stringExtra = getIntent().getStringExtra("competitionName");
            this.F.setText(getIntent().getStringExtra("statTypeName"));
            this.G.setText(stringExtra);
            this.F.setTextSize(1, 16.0f);
            this.G.setTextSize(1, 12.0f);
            Typeface d10 = o0.d(getApplicationContext());
            this.F.setTypeface(d10);
            this.G.setTypeface(d10);
            this.H.setTypeface(d10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            Intent intent = new Intent();
            intent.putExtra("closed_activity_no_result", true);
            setResult(-1, intent);
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(App.f20805y);
        x0.g2(this);
        setContentView(R.layout.f22707t6);
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = p0.s(156);
            attributes.width = App.p() - p0.s(64);
            getWindow().setAttributes(attributes);
            init();
            setText();
            setFinishOnTouchOutside(true);
            Intent intent = getIntent();
            this.f21364f0 = intent.getIntExtra("athleteId", -1);
            this.f21365g0 = intent.getIntExtra(SinglePlayerCardActivity.COMPETITION_ID_KEY, -1);
            this.f21366h0 = intent.getIntExtra("statTypeId", -1);
            a1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
