package com.scores365.removeAds;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.scores365.App;
import com.scores365.R;
import com.scores365.removeAds.RemoveAdsManager;
import com.scores365.ui.Splash;
import java.util.Date;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class RemoveAdsBasicActivity extends com.scores365.Design.Activities.c {
    public static final /* synthetic */ int F = 0;
    public OnActivityResultEventListener onActivityResultEventListener = null;
    public RelativeLayout rlPbHolder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.removeAds.RemoveAdsBasicActivity$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType;

        static {
            int[] iArr = new int[eRemoveAdsScreenType.values().length];
            $SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType = iArr;
            try {
                iArr[eRemoveAdsScreenType.OPEN_SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType[eRemoveAdsScreenType.BUY_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType[eRemoveAdsScreenType.SOCIAL_LOGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType[eRemoveAdsScreenType.APPROVEMENT_SCREEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType[eRemoveAdsScreenType.LIFETIME_SELL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnActivityResultEventListener {
        void onActivityResultEvent(int i10, int i11, Intent intent);
    }

    private eRemoveAdsScreenType getScreenTypeToStart(boolean z10) {
        eRemoveAdsScreenType eremoveadsscreentype = eRemoveAdsScreenType.OPEN_SCREEN;
        if (z10) {
            try {
                return sf.b.X1().Z3() ? eRemoveAdsScreenType.APPROVEMENT_SCREEN : eRemoveAdsScreenType.SOCIAL_LOGIN;
            } catch (Exception e10) {
                x0.N1(e10);
                return eremoveadsscreentype;
            }
        }
        return eremoveadsscreentype;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Date date, boolean z10, FriendsInvitedObj friendsInvitedObj) {
        try {
            this.rlPbHolder.setVisibility(8);
            if (date == null && !z10) {
                replaceFragment(getScreenTypeToStart(friendsInvitedObj != null && friendsInvitedObj.eligibleToBenefit), friendsInvitedObj, false, null);
                return;
            }
            replaceFragment(eRemoveAdsScreenType.APPROVEMENT_SCREEN, RemoveAdsManager.friendsUserInviteObj, z10, date);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void replaceFragment(@NonNull eRemoveAdsScreenType eremoveadsscreentype, FriendsInvitedObj friendsInvitedObj, boolean z10, Date date) {
        Fragment newInstance;
        int i10 = AnonymousClass1.$SwitchMap$com$scores365$removeAds$eRemoveAdsScreenType[eremoveadsscreentype.ordinal()];
        String str = "remove_ads_option_a";
        if (i10 == 1) {
            newInstance = RemoveAdsFirstScreenOptionAFragment.newInstance(friendsInvitedObj != null ? friendsInvitedObj.currRoundRefferedCount : 0);
        } else if (i10 == 2) {
            newInstance = RemoveAdsFirstScreenOptionBFragment.newInstance();
            str = "remove_ads_option_b";
        } else if (i10 != 3) {
            if (i10 == 4) {
                Intent intent = getIntent();
                boolean booleanExtra = intent != null ? intent.getBooleanExtra("is_lifetime", false) : false;
                if (booleanExtra) {
                    z10 = booleanExtra;
                }
                newInstance = RemoveAdsFinalScreenFragment.newInstance(z10, date);
            } else if (i10 != 5) {
                newInstance = RemoveAdsFirstScreenOptionAFragment.newInstance(friendsInvitedObj.currRoundRefferedCount);
            } else {
                newInstance = RemoveAdsLifeTimeFragment.newInstance();
            }
            str = "remove_ads_final_screen";
        } else {
            newInstance = InviteFriendsConfirmationFragment.newInstance(friendsInvitedObj.expirationDate);
            str = "invite_friends_confirmation";
        }
        getSupportFragmentManager().q().q(R.id.Ae, newInstance, str).h();
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("REMOVE_ADS");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        try {
            OnActivityResultEventListener onActivityResultEventListener = this.onActivityResultEventListener;
            if (onActivityResultEventListener != null) {
                onActivityResultEventListener.onActivityResultEvent(i10, i11, intent);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            if (getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("remove_ads_starting_screen") || getIntent().getExtras().get("remove_ads_starting_screen") == null || ((Integer) getIntent().getExtras().get("remove_ads_starting_screen")).intValue() != eRemoveAdsScreenType.APPROVEMENT_SCREEN.getValue()) {
                super.onBackPressed();
            } else {
                Intent intent = new Intent(App.m(), Splash.class);
                sf.b.X1().c7(true);
                intent.setFlags(1342210048);
                startActivity(intent);
            }
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005b -> B:24:0x005e). Please submit an issue!!! */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ne.b i10 = ((App) getApplication()).i();
        Intent intent = getIntent();
        eRemoveAdsScreenType eremoveadsscreentype = (intent == null || !intent.getBooleanExtra("remove_ads_starting_screen", false)) ? null : i10.I() ? eRemoveAdsScreenType.LIFETIME_SELL : eRemoveAdsScreenType.BUY_SCREEN;
        final Date y10 = i10.y();
        final boolean O = i10.O();
        try {
            setContentView(R.layout.f22752x3);
            initActionBar();
            if (eremoveadsscreentype == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Jn);
                this.rlPbHolder = relativeLayout;
                relativeLayout.setVisibility(0);
                RemoveAdsManager.setOnFriendsCountListener(new RemoveAdsManager.OnFriendsCountListener() { // from class: com.scores365.removeAds.a
                    @Override // com.scores365.removeAds.RemoveAdsManager.OnFriendsCountListener
                    public final void OnFriendsCount(FriendsInvitedObj friendsInvitedObj) {
                        RemoveAdsBasicActivity.this.lambda$onCreate$0(y10, O, friendsInvitedObj);
                    }
                });
                RemoveAdsManager.checkForFriendsInvitationStatus();
            } else {
                replaceFragment(eremoveadsscreentype, RemoveAdsManager.friendsUserInviteObj, O, y10);
            }
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
            if (menuItem.getItemId() == 16908332) {
                onBackPressed();
                return true;
            }
            return super.onOptionsItemSelected(menuItem);
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }
}
