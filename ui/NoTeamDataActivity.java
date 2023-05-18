package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.SportTypesEnum;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class NoTeamDataActivity extends com.scores365.Design.Activities.c {
    public static final String IMAGE_VERSION_KEY = "image_version";
    private String competitorName;
    private int competitor_id;
    private eNoTeamDataErrorType errorType;
    private String imgVer;
    ImageView ivClose;
    ImageView logo;
    private int playerId;
    private String playerName;
    TextView tvError;
    TextView tvPlayerName;
    TextView tvTeamName;
    private int sportId = -1;
    private int countryId = -1;

    /* renamed from: com.scores365.ui.NoTeamDataActivity$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$NoTeamDataActivity$eNoTeamDataErrorType;

        static {
            int[] iArr = new int[eNoTeamDataErrorType.values().length];
            $SwitchMap$com$scores365$ui$NoTeamDataActivity$eNoTeamDataErrorType = iArr;
            try {
                iArr[eNoTeamDataErrorType.SportType.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$ui$NoTeamDataActivity$eNoTeamDataErrorType[eNoTeamDataErrorType.Player.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$ui$NoTeamDataActivity$eNoTeamDataErrorType[eNoTeamDataErrorType.Team.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum eNoTeamDataErrorType {
        SportType,
        Team,
        Player
    }

    public static Intent createActivityIntent(eNoTeamDataErrorType enoteamdataerrortype, int i10, String str, int i11, int i12, Context context, String str2, String str3, int i13) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = new Intent(context, NoTeamDataActivity.class);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            intent.putExtra("error_type", enoteamdataerrortype);
            intent.putExtra("competitor_id", i10);
            intent.putExtra("sportId", i11);
            intent.putExtra("countryId", i12);
            intent.putExtra("competitor_name", str);
            intent.putExtra("player_name", str3);
            intent.putExtra("player_id", i13);
            intent.putExtra(IMAGE_VERSION_KEY, str2);
            return intent;
        } catch (Exception e11) {
            e = e11;
            intent2 = intent;
            x0.N1(e);
            return intent2;
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setTheme(App.f20805y);
            setContentView(R.layout.f22613m);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.height = p0.s(352);
            attributes.width = p0.s(288);
            setFinishOnTouchOutside(true);
            try {
                this.errorType = (eNoTeamDataErrorType) getIntent().getExtras().get("error_type");
            } catch (Exception unused) {
            }
            try {
                this.competitor_id = getIntent().getExtras().getInt("competitor_id");
            } catch (Exception unused2) {
            }
            try {
                this.sportId = getIntent().getExtras().getInt("sportId");
            } catch (Exception unused3) {
            }
            try {
                this.countryId = getIntent().getExtras().getInt("countryId");
            } catch (Exception unused4) {
            }
            try {
                this.competitorName = getIntent().getExtras().getString("competitor_name");
            } catch (Exception unused5) {
            }
            try {
                this.playerName = getIntent().getExtras().getString("player_name");
            } catch (Exception unused6) {
            }
            try {
                this.playerId = getIntent().getExtras().getInt("player_id");
            } catch (Exception unused7) {
            }
            try {
                this.imgVer = getIntent().getExtras().getString(IMAGE_VERSION_KEY);
            } catch (Exception unused8) {
            }
            ImageView imageView = (ImageView) findViewById(R.id.R3);
            if (this.sportId == SportTypesEnum.TENNIS.getValue()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                int s10 = p0.s(1);
                layoutParams.leftMargin = s10;
                layoutParams.rightMargin = s10;
                layoutParams.bottomMargin = s10;
                layoutParams.topMargin = s10;
                imageView.setLayoutParams(layoutParams);
                li.u.J(this.competitor_id, this.countryId, imageView, this.imgVer);
            } else {
                li.u.i(this.playerId, true, imageView, p0.K(R.attr.S0), false);
            }
            String str = "";
            int i10 = AnonymousClass2.$SwitchMap$com$scores365$ui$NoTeamDataActivity$eNoTeamDataErrorType[this.errorType.ordinal()];
            if (i10 == 1) {
                str = p0.l0("NOT_AVAILABLE_CLICK_SPORTTYPE");
            } else if (i10 == 2) {
                str = p0.l0("NOT_AVAILABLE_CLICK_PLAYER");
            } else if (i10 == 3) {
                str = p0.l0("NOT_AVAILABLE_CLICK_TEAM");
            }
            TextView textView = (TextView) findViewById(R.id.f21876a);
            this.tvError = textView;
            textView.setText(str);
            TextView textView2 = (TextView) findViewById(R.id.uG);
            this.tvTeamName = textView2;
            textView2.setText(this.competitorName);
            this.tvTeamName.setTypeface(o0.d(App.m()));
            TextView textView3 = (TextView) findViewById(R.id.nC);
            this.tvPlayerName = textView3;
            textView3.setText(this.playerName);
            this.tvPlayerName.setTypeface(o0.c(App.m()));
            ImageView imageView2 = (ImageView) findViewById(R.id.C3);
            this.ivClose = imageView2;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.NoTeamDataActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        NoTeamDataActivity.this.finish();
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
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
}
