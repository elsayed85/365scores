package com.scores365.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.Quiz.Activities.QuizModeActivity;
import com.scores365.R;
import li.g0;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: ServerMaintenanceActivity.kt */
/* loaded from: classes2.dex */
public final class ServerMaintenanceActivity extends com.scores365.Design.Activities.d implements View.OnClickListener {
    private ConstraintLayout mainContainer;
    private TextView mainText;
    private TextView quizButton;
    private TextView title;
    private TextView whileYouWaitText;

    public final ConstraintLayout getMainContainer() {
        return this.mainContainer;
    }

    public final TextView getMainText() {
        return this.mainText;
    }

    public final TextView getQuizButton() {
        return this.quizButton;
    }

    @Override // android.app.Activity
    public final TextView getTitle() {
        return this.title;
    }

    public final TextView getWhileYouWaitText() {
        return this.whileYouWaitText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            ee.k.l(App.m(), "app", "is-down", "click", null, true);
            startActivity(QuizModeActivity.C1("app-down", false));
            li.g0.f34558a.l(true);
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
            setContentView(R.layout.f22685r8);
            this.title = (TextView) findViewById(R.id.YG);
            this.mainText = (TextView) findViewById(R.id.qB);
            this.whileYouWaitText = (TextView) findViewById(R.id.eI);
            this.quizButton = (TextView) findViewById(R.id.YC);
            this.mainContainer = (ConstraintLayout) findViewById(R.id.f22129l3);
            TextView textView = this.title;
            if (textView != null) {
                textView.setTypeface(o0.c(App.m()));
            }
            TextView textView2 = this.mainText;
            if (textView2 != null) {
                textView2.setTypeface(o0.d(App.m()));
            }
            TextView textView3 = this.whileYouWaitText;
            if (textView3 != null) {
                textView3.setTypeface(o0.d(App.m()));
            }
            TextView textView4 = this.quizButton;
            if (textView4 != null) {
                textView4.setTypeface(o0.c(App.m()));
            }
            TextView textView5 = this.title;
            if (textView5 != null) {
                textView5.setText(p0.l0("MAINTANENCE_SCREEN_MAIN_TEXT"));
            }
            TextView textView6 = this.mainText;
            if (textView6 != null) {
                textView6.setText(p0.l0("MAINTANENCE_SCREEN_SUB_TEXT"));
            }
            TextView textView7 = this.whileYouWaitText;
            if (textView7 != null) {
                textView7.setText(p0.l0("MAINTANENCE_SCREEN_365QUIZZES_PROMOTION"));
            }
            TextView textView8 = this.quizButton;
            if (textView8 != null) {
                textView8.setText(p0.l0("MAINTANENCE_SCREEN_365QUIZZES_BUTTON"));
            }
            if (od.a.x0()) {
                TextView textView9 = this.quizButton;
                if (textView9 != null) {
                    textView9.setOnClickListener(this);
                }
                TextView textView10 = this.quizButton;
                if (textView10 != null) {
                    textView10.setVisibility(0);
                }
            } else {
                TextView textView11 = this.quizButton;
                if (textView11 != null) {
                    textView11.setVisibility(8);
                }
            }
            ConstraintLayout constraintLayout = this.mainContainer;
            if (constraintLayout != null) {
                constraintLayout.setLayoutDirection(x0.l1() ? 1 : 0);
            }
            ee.k.i(App.m(), "app", "is-down", ServerProtocol.DIALOG_PARAM_DISPLAY, null);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            g0.a aVar = li.g0.f34558a;
            if (aVar.h()) {
                finishAffinity();
                aVar.l(false);
                Log.d("maintenanceFeature", "ServerMaintenanceActivity.closed app after coming back from quiz");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void setMainContainer(ConstraintLayout constraintLayout) {
        this.mainContainer = constraintLayout;
    }

    public final void setMainText(TextView textView) {
        this.mainText = textView;
    }

    public final void setQuizButton(TextView textView) {
        this.quizButton = textView;
    }

    public final void setTitle(TextView textView) {
        this.title = textView;
    }

    public final void setWhileYouWaitText(TextView textView) {
        this.whileYouWaitText = textView;
    }
}
