package com.scores365.dashboard.scores;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.flurry.android.FlurryAgent;
import com.scores365.App;
import com.scores365.Design.Activities.d;
import com.scores365.R;
import ee.k;
import li.o0;
import li.p0;
import li.x0;
import sf.b;
/* loaded from: classes2.dex */
public class EditorsChoiceRemoveActivity extends d implements View.OnClickListener {
    TextView F;
    TextView G;
    TextView H;
    TextView I;

    /* renamed from: b0  reason: collision with root package name */
    ImageView f23381b0;

    /* renamed from: f0  reason: collision with root package name */
    ImageView f23382f0;

    /* renamed from: g0  reason: collision with root package name */
    private final View.OnClickListener f23383g0 = new a();

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                EditorsChoiceRemoveActivity.this.e1("exit");
                EditorsChoiceRemoveActivity.this.finish();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void a1() {
        b.X1().m6(true);
    }

    private void b1() {
        b.X1().m6(false);
    }

    private void d1() {
        try {
            k.h(App.m(), "dashboard", "editor-choice-remove", ServerProtocol.DIALOG_PARAM_DISPLAY);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(String str) {
        try {
            k.n(App.m(), "dashboard", "editor-choice-remove", "click", null, true, ShareConstants.FEED_SOURCE_PARAM, "my-scores", "click_type", str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        a1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        boolean z10;
        int id2 = view.getId();
        if (id2 == R.id.Wm) {
            b1();
            z10 = true;
            str = "yes";
        } else {
            if (id2 == R.id.Tm) {
                a1();
                str = "no";
            } else {
                str = "";
            }
            z10 = false;
        }
        e1(str);
        if (z10) {
            setResult(991);
        } else {
            setResult(992);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (x0.n1()) {
                setTheme(R.style.f22837l);
            } else {
                setTheme(R.style.f22836k);
            }
            setContentView(R.layout.f22762y1);
            try {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.height = -2;
                attributes.width = p0.s(300);
                getWindow().setAttributes(attributes);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            TextView textView = (TextView) findViewById(R.id.Wm);
            this.F = textView;
            textView.setText(p0.l0("YES"));
            this.F.setTypeface(o0.d(App.m()));
            TextView textView2 = (TextView) findViewById(R.id.Tm);
            this.G = textView2;
            textView2.setText(p0.l0("NO"));
            this.G.setTypeface(o0.d(App.m()));
            this.F.setOnClickListener(this);
            this.G.setOnClickListener(this);
            TextView textView3 = (TextView) findViewById(R.id.Vm);
            this.H = textView3;
            textView3.setText(p0.l0("NEW_DASHBAORD_EDITOR_CHOICE"));
            this.H.setTypeface(o0.d(App.m()));
            TextView textView4 = (TextView) findViewById(R.id.Um);
            this.I = textView4;
            textView4.setText(p0.l0("NEW_DASHBAORD_INTEREST"));
            this.I.setTypeface(o0.d(App.m()));
            ImageView imageView = (ImageView) findViewById(R.id.Sr);
            this.f23381b0 = imageView;
            imageView.setImageResource(R.drawable.f21848x1);
            ImageView imageView2 = (ImageView) findViewById(R.id.C3);
            this.f23382f0 = imageView2;
            imageView2.setOnClickListener(this.f23383g0);
            d1();
        } catch (Exception e11) {
            x0.N1(e11);
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
    @Override // com.scores365.Design.Activities.d, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            FlurryAgent.onStartSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            FlurryAgent.onEndSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
