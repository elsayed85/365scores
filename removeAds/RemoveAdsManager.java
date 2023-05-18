package com.scores365.removeAds;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.api.v;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import li.x0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoveAdsManager {
    public static FriendsInvitedObj friendsUserInviteObj = null;
    public static final boolean isRemoveAdsAvailable = true;
    private static OnFriendsCountListener onFriendsCountListener;

    /* loaded from: classes2.dex */
    public interface OnFriendsCountListener {
        void OnFriendsCount(FriendsInvitedObj friendsInvitedObj);
    }

    /* loaded from: classes2.dex */
    public enum eRemoveAdsMethodType {
        FRIENDS_INVITATION,
        PACKAGE_BUYING
    }

    public static void changeAdsRemovalStatus(Context context, boolean z10, eRemoveAdsMethodType eremoveadsmethodtype) {
        try {
            if (eremoveadsmethodtype == eRemoveAdsMethodType.FRIENDS_INVITATION) {
                sf.b.X1().b7(z10);
            } else if (eremoveadsmethodtype == eRemoveAdsMethodType.PACKAGE_BUYING) {
                sendAnalyticsChangeStatusEventByPackageBuy(-1, true);
                sf.b.X1().c7(z10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void checkForFriendsInvitationStatus() {
        try {
            final Handler handler = onFriendsCountListener != null ? new Handler() : null;
            new Thread(new Runnable() { // from class: com.scores365.removeAds.RemoveAdsManager.1
                long timer;

                @Override // java.lang.Runnable
                public void run() {
                    boolean z10;
                    Handler handler2;
                    try {
                        v vVar = new v(App.m(), "GET_REFERRED_USERS_COUNT");
                        int i10 = 500;
                        int i11 = 50;
                        do {
                            vVar.call();
                            if (vVar.j()) {
                                z10 = false;
                            } else {
                                TimeUnit.MILLISECONDS.sleep(i10);
                                if (i10 < 10000) {
                                    i10 *= 2;
                                }
                                z10 = true;
                            }
                            i11--;
                            if (!z10) {
                                break;
                            }
                        } while (i11 > 0);
                        if (!z10) {
                            this.timer = System.currentTimeMillis();
                            String a10 = vVar.a();
                            FriendsInvitedObj parseObj = FriendsInvitedObj.parseObj(new JSONObject(a10));
                            if (a10 != null && !a10.equals("")) {
                                RemoveAdsManager.friendsUserInviteObj = parseObj;
                                if (parseObj != null) {
                                    RemoveAdsManager.sendAnalyticsChangeStatusEventByInviteFriends(parseObj.eligibleToBenefit);
                                    RemoveAdsManager.changeAdsRemovalStatus(App.m(), RemoveAdsManager.friendsUserInviteObj.eligibleToBenefit, eRemoveAdsMethodType.FRIENDS_INVITATION);
                                    Date date = RemoveAdsManager.friendsUserInviteObj.expirationDate;
                                    if (date != null) {
                                        RemoveAdsManager.markPurchaseTime(date);
                                    }
                                    sf.b.X1().m7();
                                    if (RemoveAdsManager.friendsUserInviteObj.totalRefferedCount > 0) {
                                        sf.b.X1().a7(true);
                                    }
                                    sf.b.X1().T6();
                                    if (RemoveAdsManager.friendsUserInviteObj.eligibleToBenefit) {
                                        sf.b.X1().F9(RemoveAdsManager.friendsUserInviteObj.usersNeededToRemoveAds);
                                        if (date != null) {
                                            sf.b.X1().L6(date.getTime());
                                        }
                                        sf.b.X1().M6(true);
                                        sf.b.X1().a7(true);
                                    }
                                }
                            }
                        }
                        if (RemoveAdsManager.onFriendsCountListener == null || (handler2 = handler) == null) {
                            return;
                        }
                        handler2.post(new Runnable() { // from class: com.scores365.removeAds.RemoveAdsManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    RemoveAdsManager.onFriendsCountListener.OnFriendsCount(RemoveAdsManager.friendsUserInviteObj);
                                } catch (Exception e10) {
                                    x0.N1(e10);
                                }
                            }
                        });
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            }).start();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static String getInviteFriendsLink(Context context) {
        StringBuilder sb2 = new StringBuilder("invite.365scores.com/?ref=");
        try {
            sb2.append(sf.b.X1().F2());
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    public static int getRemoveAdsTypeForAnalytics() {
        try {
            if (sf.b.X1().q()) {
                return 1;
            }
            return sf.b.X1().p() ? 2 : 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    private static boolean isEligibleFieldDoesNotExist(String str) {
        if (str != null) {
            try {
                if (str.isEmpty()) {
                    return false;
                }
                return !str.contains("EligibleToBenefit");
            } catch (Exception e10) {
                x0.N1(e10);
                return false;
            }
        }
        return false;
    }

    public static boolean isUserAdsRemoved(Context context) {
        try {
            if (!sf.b.X1().p()) {
                if (!sf.b.X1().q()) {
                    return true;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    public static void markPurchaseTime(@NonNull Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, -3);
        sf.b.X1().L6(calendar.getTimeInMillis());
    }

    public static void sendAnalyticsChangeStatusEventByInviteFriends(boolean z10) {
        if (z10) {
            try {
                if (!sf.b.X1().p()) {
                    ee.k.n(App.m(), "remove-ads", "confirmed", null, null, false, "type", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        if (!z10 && sf.b.X1().p()) {
            ee.k.p(App.m(), "remove-ads", "ceased", null, false);
        }
    }

    public static void sendAnalyticsChangeStatusEventByPackageBuy(int i10, boolean z10) {
        if (z10 && !sf.b.X1().q()) {
            ee.k.n(App.m(), "remove-ads", "confirmed", null, null, false, "type", "2", "type_of_pay", String.valueOf(i10));
        } else if (z10 || !sf.b.X1().q()) {
        } else {
            ee.k.p(App.m(), "remove-ads", "ceased", null, false);
        }
    }

    public static void setOnFriendsCountListener(OnFriendsCountListener onFriendsCountListener2) {
        onFriendsCountListener = onFriendsCountListener2;
    }
}
