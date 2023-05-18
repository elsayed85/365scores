package com.scores365.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import java.util.HashMap;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class PreVideoActivity extends com.scores365.Design.Activities.c {
    public static final String SOURCE_FOR_ANALYTICS_TAG = "sorceTag";
    public static final String VIDEO_ID_TAG = "videoId";
    private ImageView ivPlaySign;
    private ImageView ivVideoImage;
    private LinearLayout llLinkContainer;
    private TextView tvGoToVideo;
    private TextView tvLink;
    private TextView tvNotOwner;
    private TextView tvPrivacyPolicyLink;
    private TextView tvSubTitle;
    private TextView tvThirdPartyDigging;
    private TextView tvTosLink;
    private TextView tvUsesApiServices;
    private int videoType = 0;
    private String videoId = "";
    private String sourceForAnalytics = "";
    private long gameId = 0;
    private String gameStatus = "";
    private String videoLink = "";
    private int videoSource = -1;
    boolean shouldFinishActivity = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GoToVideoClickListener implements View.OnClickListener {
        private final String analyticsValue;

        public GoToVideoClickListener(@NonNull String str) {
            this.analyticsValue = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            uc.d interstitialController = PreVideoActivity.this.getInterstitialController();
            if (PreVideoActivity.this.gameId > 0) {
                interstitialController.t(true);
                HashMap hashMap = new HashMap();
                hashMap.put("video_type", String.valueOf(PreVideoActivity.this.videoType));
                hashMap.put("game_id", String.valueOf(PreVideoActivity.this.gameId));
                hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, PreVideoActivity.this.gameStatus);
                hashMap.put("video_id", PreVideoActivity.this.videoId);
                hashMap.put(ShareConstants.FEED_SOURCE_PARAM, PreVideoActivity.this.sourceForAnalytics);
                ee.k.k(PreVideoActivity.this.getApplicationContext(), "gamecenter", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "play", this.analyticsValue, hashMap);
            }
            PreVideoActivity.this.shouldFinishActivity = true;
            interstitialController.t(true);
            PreVideoActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PreVideoActivity.this.videoLink)));
        }
    }

    private String getTermString(String str) {
        return p0.l0(str);
    }

    private void init() {
        this.tvSubTitle = (TextView) findViewById(R.id.QC);
        this.tvNotOwner = (TextView) findViewById(R.id.PC);
        this.tvThirdPartyDigging = (TextView) findViewById(R.id.RC);
        this.tvGoToVideo = (TextView) findViewById(R.id.NC);
        this.tvLink = (TextView) findViewById(R.id.OC);
        this.ivVideoImage = (ImageView) findViewById(R.id.Dc);
        this.ivPlaySign = (ImageView) findViewById(R.id.f22359vc);
        this.tvUsesApiServices = (TextView) findViewById(R.id.MH);
        this.llLinkContainer = (LinearLayout) findViewById(R.id.f22164mg);
        this.tvTosLink = (TextView) findViewById(R.id.tH);
        this.tvPrivacyPolicyLink = (TextView) findViewById(R.id.WC);
        this.tvGoToVideo.setOnClickListener(new GoToVideoClickListener("go-to-video"));
        this.ivPlaySign.setOnClickListener(new GoToVideoClickListener("click"));
        this.ivVideoImage.setOnClickListener(new GoToVideoClickListener("click"));
    }

    private void initImageLoader(final String str) {
        li.u.B(str, this.ivVideoImage, null, new s2.c<Bitmap>() { // from class: com.scores365.ui.PreVideoActivity.1
            @Override // s2.i
            public void onLoadCleared(Drawable drawable) {
            }

            @Override // s2.c, s2.i
            public void onLoadFailed(Drawable drawable) {
                super.onLoadFailed(drawable);
                try {
                    PreVideoActivity.this.ivVideoImage.setBackground(p0.K(R.attr.f21591v0));
                    PreVideoActivity.this.ivPlaySign.bringToFront();
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            @Override // s2.i
            public void onResourceReady(@NonNull Bitmap bitmap, t2.b bVar) {
                try {
                    if (str.equals("")) {
                        PreVideoActivity.this.ivVideoImage.setBackground(p0.K(R.attr.f21591v0));
                        PreVideoActivity.this.ivPlaySign.bringToFront();
                    } else {
                        PreVideoActivity.this.ivVideoImage.setImageBitmap(bitmap);
                        PreVideoActivity.this.ivPlaySign.bringToFront();
                        PreVideoActivity.this.ivVideoImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTextInViews$0(View view) {
        try {
            this.shouldFinishActivity = false;
            x0.M1("https://www.youtube.com/t/terms");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setTextInViews$1(View view) {
        try {
            this.shouldFinishActivity = false;
            x0.M1("http://www.google.com/policies/privacy");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setTextInViews() {
        try {
            this.tvSubTitle.setText(getTermString("YOU_ARE_LEAVING"));
            this.tvNotOwner.setText(getTermString("WE_ARE_NOT_OWNER"));
            this.tvThirdPartyDigging.setText(getTermString("365_NOT_HOSTED"));
            this.tvGoToVideo.setText(getTermString("GO_TO_VIDEO"));
            this.tvLink.setText(this.videoLink);
            if (this.videoSource == 1) {
                this.llLinkContainer.setVisibility(0);
                this.tvUsesApiServices.setVisibility(0);
                TextView textView = this.tvTosLink;
                textView.setPaintFlags(textView.getPaintFlags() | 8);
                TextView textView2 = this.tvPrivacyPolicyLink;
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
                this.tvUsesApiServices.setText(getTermString("YOUTUBE_API_SERVICES_MSG"));
                this.tvUsesApiServices.setTypeface(o0.d(App.m()));
                this.tvTosLink.setText(getTermString("YOUTUBE_TOS"));
                this.tvTosLink.setTypeface(o0.d(App.m()));
                this.tvPrivacyPolicyLink.setText(getTermString("GOOGLE_PP"));
                this.tvPrivacyPolicyLink.setTypeface(o0.d(App.m()));
                this.ivPlaySign.setImageResource(R.drawable.W6);
                this.tvTosLink.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.j0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreVideoActivity.this.lambda$setTextInViews$0(view);
                    }
                });
                this.tvPrivacyPolicyLink.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.k0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PreVideoActivity.this.lambda$setTextInViews$1(view);
                    }
                });
            }
            this.tvSubTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvNotOwner.setTypeface(o0.d(getApplicationContext()));
            this.tvThirdPartyDigging.setTypeface(o0.b(getApplicationContext()));
            this.tvGoToVideo.setTypeface(o0.c(getApplicationContext()));
            this.tvLink.setTypeface(o0.d(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.D1(this);
        x0.g2(this);
        setContentView(R.layout.f22664q);
        try {
            initActionBar();
            init();
            Bundle extras = getIntent().getExtras();
            this.videoLink = extras.getString("videoLink");
            String string = extras.getString("videoImageUrl");
            this.videoType = extras.getInt("videoType");
            this.videoSource = extras.getInt("videoSource");
            this.videoId = extras.getString(VIDEO_ID_TAG);
            this.sourceForAnalytics = extras.getString(SOURCE_FOR_ANALYTICS_TAG);
            this.gameId = extras.getLong("game_id");
            if (extras.containsKey("game_status")) {
                this.gameStatus = extras.getString("game_status");
            }
            setTextInViews();
            initImageLoader(string);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            this.toolbar.setElevation(p0.s(4));
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        try {
            super.onStop();
            if (this.shouldFinishActivity) {
                finish();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
