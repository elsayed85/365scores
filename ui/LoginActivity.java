package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ci.b;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseUser;
import com.scores365.App;
import com.scores365.R;
import de.hdodenhof.circleimageview.CircleImageView;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class LoginActivity extends com.scores365.Design.Activities.c implements View.OnClickListener, b.a.e {
    public static final String FORCE_LOGIN = "force_login";
    public static final String NAME_TAG = "nameTag";
    public static final String PROFILE_PICTURE_TAG = "profilePictureTag";
    private static final int RC_SIGN_IN = 1;
    private static final String SOURCE_OF_ACTIVITY_CALL = "source_of_activity_call";
    public static final String SPOT_IM_DELEGATE = "spot_im_delegate";
    public static final String TAG = "com.scores365.ui.LoginActivity";
    LinearLayout afterloginLayout;
    TextView connectWithFacebookText;
    TextView connectWithGoogleText;
    TextView disclaimer;
    TextView displayLastName;
    TextView displayNameText;
    ImageView emailIcon;
    RelativeLayout emailLayout;
    TextView emailText;
    TextView facebookButtonText;
    RelativeLayout facebookLoginLayout;
    LoginButton facebookNativeLoginButton;
    TextView googleButtonText;
    RelativeLayout googleLoginLayout;
    SignInButton googleNativeSignInButton;
    RelativeLayout loader;
    ImageView nameIcon;
    LinearLayout preloginLayout;
    TextView profileName;
    TextView signOutBtn;
    ci.b socialLoginMgr;
    CircleImageView userPhotoIV;
    String userEmail = null;
    String userPhotoURL = null;
    String userFirstName = null;
    String userLastName = null;

    public static Intent createLoginActivityIntent(String str, boolean z10) {
        Intent intent = new Intent(App.m(), LoginActivity.class);
        try {
            intent.addFlags(268435456);
            intent.putExtra(SOURCE_OF_ACTIVITY_CALL, str);
            intent.putExtra(FORCE_LOGIN, z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082 A[Catch: Exception -> 0x00dc, TRY_ENTER, TryCatch #0 {Exception -> 0x00dc, blocks: (B:3:0x0004, B:5:0x000b, B:7:0x0015, B:9:0x001f, B:13:0x002d, B:22:0x0043, B:24:0x0049, B:26:0x0053, B:28:0x0063, B:32:0x0082, B:36:0x0097, B:42:0x00a4, B:46:0x00b1, B:47:0x00ba, B:51:0x00cd), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba A[Catch: Exception -> 0x00dc, TryCatch #0 {Exception -> 0x00dc, blocks: (B:3:0x0004, B:5:0x000b, B:7:0x0015, B:9:0x001f, B:13:0x002d, B:22:0x0043, B:24:0x0049, B:26:0x0053, B:28:0x0063, B:32:0x0082, B:36:0x0097, B:42:0x00a4, B:46:0x00b1, B:47:0x00ba, B:51:0x00cd), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void handleDisplayAnalytics() {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.LoginActivity.handleDisplayAnalytics():void");
    }

    private void initViews() {
        try {
            this.connectWithFacebookText.setTypeface(o0.b(App.m()));
            this.connectWithGoogleText.setTypeface(o0.b(App.m()));
            this.disclaimer.setTypeface(o0.b(App.m()));
            this.facebookButtonText.setTypeface(o0.d(App.m()));
            this.googleButtonText.setTypeface(o0.d(App.m()));
            this.emailText.setTypeface(o0.b(App.m()));
            this.displayNameText.setTypeface(o0.b(App.m()));
            this.connectWithFacebookText.setText(p0.l0("CONNECT_WITH_FACEBOOK"));
            this.connectWithGoogleText.setText(p0.l0("CONNECT_WITH_GMAIL"));
            this.disclaimer.setText(p0.l0("LOGIN_ACCEPT_TERMS_AND_CONDITIONS"));
            this.facebookButtonText.setText(p0.l0("VIRTUAL_STADIUM_CONNECT"));
            this.signOutBtn.setText(p0.l0("LOGOUT_BUTTON_TITLE"));
            this.googleButtonText.setText(p0.l0("CONNECT_WITH_GMAIL"));
            this.googleNativeSignInButton.setOnClickListener(this);
            this.signOutBtn.setOnClickListener(this);
            this.facebookLoginLayout.setOnClickListener(this);
            this.googleLoginLayout.setOnClickListener(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void refreshMail(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    this.emailText.setText(str);
                    this.emailText.setVisibility(0);
                    this.preloginLayout.setVisibility(4);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        this.emailLayout.setVisibility(8);
        this.preloginLayout.setVisibility(4);
    }

    private void relateViews() {
        try {
            this.loader = (RelativeLayout) findViewById(R.id.Jn);
            this.googleNativeSignInButton = (SignInButton) findViewById(R.id.f22016g1);
            this.facebookNativeLoginButton = (LoginButton) findViewById(R.id.f22418y5);
            this.afterloginLayout = (LinearLayout) findViewById(R.id.Rf);
            this.preloginLayout = (LinearLayout) findViewById(R.id.Mn);
            this.signOutBtn = (TextView) findViewById(R.id.f22237q1);
            this.connectWithFacebookText = (TextView) findViewById(R.id.Wx);
            this.connectWithGoogleText = (TextView) findViewById(R.id.Xx);
            this.disclaimer = (TextView) findViewById(R.id.sy);
            this.facebookButtonText = (TextView) findViewById(R.id.gz);
            this.googleButtonText = (TextView) findViewById(R.id.hA);
            this.facebookLoginLayout = (RelativeLayout) findViewById(R.id.tn);
            this.googleLoginLayout = (RelativeLayout) findViewById(R.id.vn);
            this.userPhotoIV = (CircleImageView) findViewById(R.id.f22383we);
            this.profileName = (TextView) findViewById(R.id.LH);
            this.emailText = (TextView) findViewById(R.id.Dy);
            this.emailLayout = (RelativeLayout) findViewById(R.id.sn);
            this.displayNameText = (TextView) findViewById(R.id.wy);
            this.displayLastName = (TextView) findViewById(R.id.vy);
            this.emailIcon = (ImageView) findViewById(R.id.f22093jb);
            this.nameIcon = (ImageView) findViewById(R.id.f22138lc);
            if (x0.z2()) {
                return;
            }
            findViewById(R.id.tn).setVisibility(8);
            this.connectWithFacebookText.setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void sendLoginClick(String str) {
        try {
            boolean booleanExtra = (getIntent() == null || !getIntent().getBooleanExtra("is_from_image", false)) ? false : getIntent().getBooleanExtra("is_from_image", false);
            if (getIntent() != null && getIntent().getStringExtra(SOURCE_OF_ACTIVITY_CALL) != null && getIntent().getStringExtra(SOURCE_OF_ACTIVITY_CALL).equals(SPOT_IM_DELEGATE)) {
                ee.k.o(App.m(), "app", "open-web", "connect", "click", "network", str);
            }
            Context m10 = App.m();
            String[] strArr = new String[4];
            strArr[0] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[1] = booleanExtra ? "more-picture" : "more";
            strArr[2] = "platform";
            strArr[3] = str;
            ee.k.n(m10, "account", "log-in", "click", null, true, strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void sendLogoutClick() {
        try {
            boolean booleanExtra = (getIntent() == null || !getIntent().getBooleanExtra("is_from_image", false)) ? false : getIntent().getBooleanExtra("is_from_image", false);
            boolean z10 = sf.b.X1().P2() == 1;
            Context m10 = App.m();
            String[] strArr = new String[4];
            strArr[0] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[1] = booleanExtra ? "more-picture" : "more";
            strArr[2] = "platform";
            strArr[3] = z10 ? AccessToken.DEFAULT_GRAPH_DOMAIN : "google";
            ee.k.n(m10, "account", "log-out", "click", null, true, strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return isSpotImContext() ? p0.l0("CONNECT_TO_COMMENT_TITLE") : p0.l0("NEW_DASHBOARD_ACCOUNT");
    }

    @Override // ci.b.a.e
    public void hidePreLoader() {
        try {
            RelativeLayout relativeLayout = this.loader;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            this.signOutBtn.setClickable(true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ci.b.a.e
    public boolean isSpotImContext() {
        try {
            if (getIntent().getStringExtra(SOURCE_OF_ACTIVITY_CALL) == null || getIntent().getStringExtra(SOURCE_OF_ACTIVITY_CALL).isEmpty()) {
                return false;
            }
            return getIntent().getStringExtra(SOURCE_OF_ACTIVITY_CALL).equals(SPOT_IM_DELEGATE);
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        try {
            this.socialLoginMgr.i(i10, i11, intent);
            super.onActivityResult(i10, i11, intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            Intent intent = new Intent();
            FirebaseUser c10 = this.socialLoginMgr.f().c();
            Profile e10 = this.socialLoginMgr.e();
            if (c10 != null) {
                intent.putExtra(NAME_TAG, c10.getDisplayName());
                intent.putExtra(PROFILE_PICTURE_TAG, c10.getPhotoUrl() == null ? "" : c10.getPhotoUrl().toString());
            } else if (e10 != null) {
                intent.putExtra(NAME_TAG, e10.getFirstName() + " " + e10.getLastName());
                intent.putExtra(PROFILE_PICTURE_TAG, e10.getProfilePictureUri(p0.s(500), p0.s(500)).toString());
            }
            setResult(-1, intent);
            super.onBackPressed();
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == this.googleNativeSignInButton.getId()) {
                sendLoginClick("google");
                showPreLoader();
                this.socialLoginMgr.p();
            } else if (view.getId() == this.signOutBtn.getId()) {
                sendLogoutClick();
                this.socialLoginMgr.q();
                setUserInfo(null, null, null, null);
            } else if (view.getId() == this.facebookLoginLayout.getId()) {
                sendLoginClick(AccessToken.DEFAULT_GRAPH_DOMAIN);
                this.facebookNativeLoginButton.performClick();
            } else if (view.getId() == this.googleLoginLayout.getId()) {
                sendLoginClick("google");
                hidePreLoader();
                this.googleNativeSignInButton.performClick();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (x0.l1()) {
                setContentView(R.layout.Z3);
            } else {
                setContentView(R.layout.Y3);
            }
            x0.D1(this);
            initActionBar();
            relateViews();
            initViews();
            ci.b bVar = new ci.b(this, this, this.googleNativeSignInButton, this.facebookNativeLoginButton);
            this.socialLoginMgr = bVar;
            bVar.g();
            showPreLoginScreen();
            if (getIntent().getBooleanExtra(FORCE_LOGIN, false)) {
                if (this.socialLoginMgr.f().c() != null && sf.b.X1().P2() == 1) {
                    showAfterLoginScreen("Facebook");
                    showPreLoader();
                }
            } else if (this.socialLoginMgr.f().c() != null) {
                showAfterLoginScreen("Google+");
            }
            handleDisplayAnalytics();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            this.socialLoginMgr.s();
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

    @Override // ci.b.a.e
    public void onSocialMediaConnectionFinished() {
    }

    public void onSpotImProcessSuccess() {
        try {
            if (isSpotImContext()) {
                finish();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ci.b.a.e
    public void setUserInfo(String str, String str2, String str3, String str4) {
        try {
            this.userEmail = str;
            this.userPhotoURL = str2;
            this.userFirstName = str3;
            this.userLastName = str4;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ci.b.a.e
    public void showAfterLoginScreen(String str) {
        try {
            this.afterloginLayout.setVisibility(0);
            if (this.userEmail == null) {
                this.userEmail = sf.b.X1().M2();
            }
            if (this.userPhotoURL == null) {
                this.userPhotoURL = sf.b.X1().R2();
            }
            if (this.userFirstName == null) {
                this.userFirstName = sf.b.X1().N2();
            }
            if (this.userLastName == null) {
                this.userLastName = sf.b.X1().O2();
            }
            String str2 = this.userFirstName + " " + this.userLastName;
            String str3 = this.userPhotoURL;
            if (str3 != null && !str3.isEmpty()) {
                li.u.x(this.userPhotoURL, this.userPhotoIV);
            }
            String str4 = this.userFirstName;
            if (str4 != null && !str4.isEmpty()) {
                this.displayNameText.setText(this.userFirstName);
            }
            String str5 = this.userLastName;
            if (str5 != null && !str5.isEmpty()) {
                this.displayLastName.setText(this.userLastName);
            }
            this.profileName.setText(str2);
            refreshMail(this.userEmail);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void showPreLoader() {
        try {
            RelativeLayout relativeLayout = this.loader;
            if (relativeLayout == null || this.signOutBtn == null) {
                return;
            }
            relativeLayout.setVisibility(0);
            this.signOutBtn.setClickable(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // ci.b.a.e
    public void showPreLoginScreen() {
        try {
            this.afterloginLayout.setVisibility(8);
            this.preloginLayout.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
