package com.scores365.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class AskBeforeExit extends com.scores365.Design.Activities.d {
    public static final int EXIT_ACTIVITY_CODE = 887;
    public static final String SHOW_CHECK_BOX = "show_check_box";
    private Button btnNo;
    private Button btnYes;
    private CheckBox cbDontAskAgain;
    private LinearLayout llBtnsHolder;
    private RelativeLayout mainContainer;
    private TextView tvMsg;
    private TextView tvTitle;

    public static Intent getActivityIntent() {
        return getActivityIntent(true);
    }

    public static Intent getActivityIntent(boolean z10) {
        Intent intent = new Intent(App.m(), AskBeforeExit.class);
        intent.putExtra(SHOW_CHECK_BOX, z10);
        return intent;
    }

    private void initializeColors() {
        try {
            this.mainContainer.setBackgroundResource(p0.T(R.attr.f21554j));
            this.tvTitle.setTextColor(p0.A(R.attr.U0));
            this.tvMsg.setTextColor(p0.A(R.attr.U0));
            this.cbDontAskAgain.setTextColor(p0.A(R.attr.f21565m1));
            this.btnYes.setTextColor(p0.A(R.attr.T0));
            this.btnNo.setTextColor(p0.A(R.attr.T0));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setActivityTheme();
            getWindow().addFlags(2);
            setContentView(R.layout.O);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = -2;
            attributes.width = -2;
            attributes.dimAmount = 0.7f;
            getWindow().setAttributes(attributes);
            this.mainContainer = (RelativeLayout) findViewById(R.id.f21963dh);
            this.tvTitle = (TextView) findViewById(R.id.mA);
            this.llBtnsHolder = (LinearLayout) findViewById(R.id.Wf);
            this.cbDontAskAgain = (CheckBox) findViewById(R.id.f21879a2);
            this.btnNo = (Button) findViewById(R.id.f22060i1);
            this.btnYes = (Button) findViewById(R.id.f22304t1);
            this.tvMsg = (TextView) findViewById(R.id.YG);
            initializeColors();
            this.tvTitle.setTypeface(o0.d(App.m()));
            this.tvMsg.setTypeface(o0.d(App.m()));
            this.cbDontAskAgain.setTypeface(o0.d(App.m()));
            this.btnNo.setTypeface(o0.c(App.m()));
            this.btnYes.setTypeface(o0.c(App.m()));
            this.tvTitle.setText(p0.l0("DASHBOARD_EXIT_APP"));
            this.cbDontAskAgain.setText(p0.l0("EXIT_CONF_CHECKBOX"));
            this.btnNo.setText(p0.l0("DASHBOARD_EXIT_MESSAGE_NO"));
            this.btnYes.setText(p0.l0("DASHBOARD_EXIT_MESSAGE_YES"));
            this.tvMsg.setText(p0.l0("DASHBOARD_EXIT_MESSAGE"));
            this.btnNo.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.AskBeforeExit.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AskBeforeExit.this.onBackPressed();
                }
            });
            this.btnYes.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.AskBeforeExit.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AskBeforeExit.this.setResult(-1);
                    AskBeforeExit.this.finish();
                }
            });
            this.cbDontAskAgain.setChecked(!sf.b.X1().i4());
            this.cbDontAskAgain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.AskBeforeExit.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    try {
                        sf.b.X1().U6(!z10);
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.llBtnsHolder.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cbDontAskAgain.getLayoutParams();
            this.cbDontAskAgain.setBackgroundResource(0);
            if (x0.l1()) {
                layoutParams.addRule(9);
                layoutParams2.addRule(11);
                this.cbDontAskAgain.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.f21742k, 0);
                this.mainContainer.setPadding(p0.s(16), 0, p0.s(24), 0);
                this.llBtnsHolder.setPadding(0, 0, p0.s(8), 0);
            } else {
                layoutParams.addRule(11);
                layoutParams2.addRule(9);
                this.cbDontAskAgain.setCompoundDrawablesWithIntrinsicBounds(R.drawable.f21742k, 0, 0, 0);
                this.mainContainer.setPadding(p0.s(24), 0, p0.s(16), 0);
                this.llBtnsHolder.setPadding(p0.s(8), 0, 0, 0);
            }
            this.llBtnsHolder.setLayoutParams(layoutParams);
            this.cbDontAskAgain.setLayoutParams(layoutParams2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            if (getIntent().getExtras().getBoolean(SHOW_CHECK_BOX, true)) {
                this.cbDontAskAgain.setVisibility(0);
            } else {
                this.cbDontAskAgain.setVisibility(8);
            }
            if (x0.l1()) {
                this.tvMsg.setGravity(5);
            } else {
                this.tvMsg.setGravity(3);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "onDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        finish();
        setResult(0);
    }
}
