package com.scores365.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class InfoDialog extends com.scores365.Design.Activities.d {
    public static final String GAME_ID_TAG = "game_id_tag";
    public static final String STATUS_TAG = "status_tag";
    ConstraintLayout container;
    ImageView ivStat;
    TextView tvAction;
    TextView tvAwayDesc;
    TextView tvAwayTitle;
    TextView tvDescription;
    TextView tvHomeDesc;
    TextView tvHomeTitle;
    TextView tvTitle;

    private void initializeView() {
        this.container = (ConstraintLayout) findViewById(R.id.W3);
        this.tvTitle = (TextView) findViewById(R.id.J9);
        this.tvDescription = (TextView) findViewById(R.id.F9);
        this.tvHomeTitle = (TextView) findViewById(R.id.H9);
        this.tvHomeDesc = (TextView) findViewById(R.id.G9);
        this.tvAwayTitle = (TextView) findViewById(R.id.E9);
        this.tvAwayDesc = (TextView) findViewById(R.id.D9);
        this.tvAction = (TextView) findViewById(R.id.C9);
        this.ivStat = (ImageView) findViewById(R.id.I9);
        this.container.setBackgroundColor(p0.A(R.attr.f21557k));
        this.tvTitle.setTextColor(p0.A(R.attr.U0));
        this.tvDescription.setTextColor(p0.A(R.attr.U0));
        this.tvHomeTitle.setTextColor(p0.A(R.attr.f21562l1));
        this.tvHomeDesc.setTextColor(p0.A(R.attr.f21565m1));
        this.tvAwayTitle.setTextColor(p0.A(R.attr.T0));
        this.tvAwayDesc.setTextColor(p0.A(R.attr.f21565m1));
        this.tvAction.setTextColor(p0.A(R.attr.T0));
        this.tvTitle.setTypeface(o0.c(App.m()));
        this.tvDescription.setTypeface(o0.d(App.m()));
        this.tvHomeTitle.setTypeface(o0.d(App.m()));
        this.tvHomeDesc.setTypeface(o0.b(App.m()));
        this.tvAwayTitle.setTypeface(o0.d(App.m()));
        this.tvAwayDesc.setTypeface(o0.b(App.m()));
        this.tvAction.setTypeface(o0.d(App.m()));
        this.tvAction.setBackgroundResource(R.drawable.f21804r5);
        this.tvAction.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InfoDialog.this.lambda$initializeView$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeView$0(View view) {
        finish();
    }

    public static void loadActivity(int i10, int i11) {
        try {
            Intent intent = new Intent(App.m(), InfoDialog.class);
            intent.setFlags(268435456);
            intent.putExtra(GAME_ID_TAG, i10);
            intent.putExtra(STATUS_TAG, i11);
            App.m().startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setViewsData() {
        try {
            this.tvTitle.setText(p0.l0("GAME_CENTER_MOMENTUM_TITLE"));
            this.tvDescription.setText(p0.l0("GAME_CENTER_MOMENTUM_DESC"));
            this.tvHomeTitle.setText(p0.l0("GAME_CENTER_HOME_TEAM"));
            this.tvHomeDesc.setText(p0.l0("GAME_CENTER_QUEEN_UNDER_PRESSURE"));
            this.tvAwayTitle.setText(p0.l0("GAME_CENTER_AWAY_TEAM"));
            this.tvAwayDesc.setText(p0.l0("GAME_CENTER_QUEEN_NOT_UNDER_PRESSURE"));
            this.tvAction.setText(p0.l0("GAME_CENTER_MOMENTUM_GOT_IT").toUpperCase());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setTheme(App.f20805y);
            setContentView(R.layout.f22704t3);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (sf.b.X1().T1() * 0.82d);
            attributes.height = -2;
            attributes.dimAmount = 0.8f;
            attributes.flags |= 2;
            getWindow().setAttributes(attributes);
            initializeView();
            setViewsData();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        try {
            super.onStop();
            ee.k.o(App.m(), "gamecenter", "momentum", "close", "click", "game_id", String.valueOf(getIntent().getIntExtra(GAME_ID_TAG, -1)), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(getIntent().getIntExtra(STATUS_TAG, -1)));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
