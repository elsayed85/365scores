package com.scores365;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import bg.e;
import com.scores365.App;
import com.scores365.api.f;
import com.scores365.dashboard.StandingsAndFixturesActivity;
import com.scores365.entitys.GCMNotificationObj;
import com.scores365.entitys.NotificationsParamsObj;
import com.scores365.tipster.TipsterStandaloneActivity;
import com.scores365.ui.Bet365LandingActivity;
import com.scores365.ui.Splash;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import di.k;
import java.util.ArrayList;
import java.util.TimeZone;
import li.c;
import li.k0;
import li.l0;
import li.u;
import li.x0;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: NotificationsManager.java */
/* loaded from: classes2.dex */
public class b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f23270a;

    /* compiled from: NotificationsManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        void i(int i10, boolean z10);
    }

    public b(@NonNull Context context) {
        this.f23270a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(GCMNotificationObj gCMNotificationObj) {
        try {
            ng.a.f35508a.b("NotificationsManager", "handling silent update notification", null);
            if (!App.b.j0()) {
                App.b.t();
            }
            x0.B2(null, null, true);
        } catch (Exception e10) {
            ng.a aVar = ng.a.f35508a;
            aVar.c("NotificationsManager", "error silent update notification=" + gCMNotificationObj, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        try {
            Context context = this.f23270a;
            f fVar = new f(context, "Silent Feedback", context.getPackageManager().getPackageInfo(this.f23270a.getPackageName(), 0).versionName, Build.VERSION.RELEASE, x0.Z(), TimeZone.getDefault().getID(), this.f23270a.getResources().getConfiguration().locale.getCountry(), App.l().getLanguages().get(Integer.valueOf(sf.a.i0(this.f23270a).k0())).getName(), x0.r0(this.f23270a), "", "", "", x0.Q0(this.f23270a), x0.a0());
            ng.a.f35508a.c("FeedbackReport", "submitting feedback now", new qg.a());
            fVar.call();
        } catch (Exception e10) {
            ng.a.f35508a.c("NotificationsManager", "error sending feedback for notification", e10);
        }
    }

    public static void C(Intent intent) {
        if (intent != null) {
            try {
                if (intent.getComponent() != null) {
                    intent.putExtra("notificationClass", Class.forName(intent.getComponent().getClassName()));
                    intent.putExtra("notificationTime", System.currentTimeMillis());
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
        intent.setClass(App.m(), Splash.class);
    }

    private void E(@NonNull final GCMNotificationObj gCMNotificationObj) {
        c.f34483a.f().execute(new Runnable() { // from class: nb.e0
            @Override // java.lang.Runnable
            public final void run() {
                com.scores365.b.A(GCMNotificationObj.this);
            }
        });
    }

    private void F() {
        c.f34483a.f().execute(new Runnable() { // from class: nb.d0
            @Override // java.lang.Runnable
            public final void run() {
                com.scores365.b.this.B();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e4 A[Catch: Exception -> 0x030f, TryCatch #0 {Exception -> 0x030f, blocks: (B:3:0x000e, B:5:0x0065, B:7:0x0081, B:11:0x009f, B:13:0x00e4, B:17:0x0104, B:19:0x0148, B:22:0x0202, B:27:0x0236, B:29:0x023e, B:31:0x0289, B:33:0x02aa, B:35:0x02b6, B:20:0x0197, B:21:0x01c9), top: B:40:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01c9 A[Catch: Exception -> 0x030f, TryCatch #0 {Exception -> 0x030f, blocks: (B:3:0x000e, B:5:0x0065, B:7:0x0081, B:11:0x009f, B:13:0x00e4, B:17:0x0104, B:19:0x0148, B:22:0x0202, B:27:0x0236, B:29:0x023e, B:31:0x0289, B:33:0x02aa, B:35:0x02b6, B:20:0x0197, B:21:0x01c9), top: B:40:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(com.scores365.entitys.GCMNotificationObj r24, int r25) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.b.c(com.scores365.entitys.GCMNotificationObj, int):void");
    }

    private void d(Intent intent, GCMNotificationObj gCMNotificationObj) {
        if (intent != null) {
            intent.putExtra(com.scores365.Design.Activities.c.IS_NOTIFICATION_ACTIVITY, true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("notification_id", gCMNotificationObj.getNotificationId());
                jSONObject.put("nid", gCMNotificationObj.getID());
                jSONObject.put("is_auto", gCMNotificationObj.getID() == -1 ? 0 : 1);
                if (gCMNotificationObj.getID() != -1) {
                    jSONObject.put("Screen", "gamecenter");
                } else {
                    jSONObject.put("Screen", gCMNotificationObj.ScreenName);
                }
                jSONObject.put("sub_screen", gCMNotificationObj.getSubScreen());
                if (gCMNotificationObj.getID() != -1) {
                    jSONObject.put("EntityType", "4");
                } else {
                    jSONObject.put("EntityType", gCMNotificationObj.getParam("EntityType"));
                }
                if (gCMNotificationObj.getID() != -1) {
                    jSONObject.put("EntityId", String.valueOf(gCMNotificationObj.Game.GameID));
                } else {
                    jSONObject.put("EntityId", gCMNotificationObj.getParam("EntityId"));
                }
                jSONObject.put("item_id", gCMNotificationObj.getItemId());
            } catch (JSONException e10) {
                x0.N1(e10);
            }
            intent.putExtra(com.scores365.Design.Activities.c.NOTIFICATION_ANALTICS_EVENT, jSONObject.toString());
            intent.putExtra(com.scores365.Design.Activities.c.NOTIFICATION_URL_GUID, sh.a.f39207a.g());
        }
    }

    private static void f(int i10, NotificationManager notificationManager, Notification notification) {
        ng.a aVar = ng.a.f35508a;
        aVar.b("NotificationsManager", "firing notification id=" + i10 + ", notification=" + notification, null);
        w(notificationManager);
        notificationManager.notify(i10, notification);
        aVar.b("NotificationsManager", "notification id=" + i10 + " handled", null);
    }

    private static ArrayList<String> g(NotificationManager notificationManager, int i10) {
        StatusBarNotification[] activeNotifications;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                activeNotifications = notificationManager.getActiveNotifications();
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (statusBarNotification.getId() == i10) {
                        return (ArrayList) statusBarNotification.getNotification().extras.getSerializable("LINES_KEY");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private static ArrayList<String> h(NotificationManager notificationManager, int i10) {
        StatusBarNotification[] activeNotifications;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                activeNotifications = notificationManager.getActiveNotifications();
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (statusBarNotification.getId() == i10) {
                        return (ArrayList) statusBarNotification.getNotification().extras.getSerializable("REPLACEMENT_KEY");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private static int i() {
        int i10 = R.drawable.f21745k2;
        try {
            return x0.l0() ? R.drawable.T2 : i10;
        } catch (Exception e10) {
            x0.N1(e10);
            return i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.scores365.ui.playerCard.SinglePlayerCardActivity.eAthletePageType j(java.lang.String r6) {
        /*
            r5 = this;
            com.scores365.ui.playerCard.SinglePlayerCardActivity$eAthletePageType r0 = com.scores365.ui.playerCard.SinglePlayerCardActivity.eAthletePageType.PROFILE
            java.lang.String r6 = r6.toLowerCase()     // Catch: java.lang.Exception -> L48
            int r1 = r6.hashCode()     // Catch: java.lang.Exception -> L48
            r2 = -309425751(0xffffffffed8e89a9, float:-5.5141615E27)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L30
            r2 = 3035859(0x2e52d3, float:4.254145E-39)
            if (r1 == r2) goto L26
            r2 = 3540564(0x360654, float:4.961387E-39)
            if (r1 == r2) goto L1c
            goto L3a
        L1c:
            java.lang.String r1 = "stat"
            boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L48
            if (r6 == 0) goto L3a
            r6 = 2
            goto L3b
        L26:
            java.lang.String r1 = "buzz"
            boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L48
            if (r6 == 0) goto L3a
            r6 = 1
            goto L3b
        L30:
            java.lang.String r1 = "profile"
            boolean r6 = r6.equals(r1)     // Catch: java.lang.Exception -> L48
            if (r6 == 0) goto L3a
            r6 = 0
            goto L3b
        L3a:
            r6 = -1
        L3b:
            if (r6 == 0) goto L4c
            if (r6 == r4) goto L45
            if (r6 == r3) goto L42
            goto L4c
        L42:
            com.scores365.ui.playerCard.SinglePlayerCardActivity$eAthletePageType r0 = com.scores365.ui.playerCard.SinglePlayerCardActivity.eAthletePageType.STATS     // Catch: java.lang.Exception -> L48
            goto L4c
        L45:
            com.scores365.ui.playerCard.SinglePlayerCardActivity$eAthletePageType r0 = com.scores365.ui.playerCard.SinglePlayerCardActivity.eAthletePageType.BUZZ     // Catch: java.lang.Exception -> L48
            goto L4c
        L48:
            r6 = move-exception
            li.x0.N1(r6)
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.b.j(java.lang.String):com.scores365.ui.playerCard.SinglePlayerCardActivity$eAthletePageType");
    }

    private int k(GCMNotificationObj gCMNotificationObj) {
        int intValue;
        try {
            String param = gCMNotificationObj.getParam("COMPETITOR_NUM");
            if (param == null || param.isEmpty() || (intValue = Integer.valueOf(param).intValue()) <= -1) {
                return -1;
            }
            return gCMNotificationObj.getComps()[intValue - 1];
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    private e l(String str) {
        char c10;
        e eVar = e.DETAILS;
        try {
            String lowerCase = str.toLowerCase();
            switch (lowerCase.hashCode()) {
                case -1905512560:
                    if (lowerCase.equals("game_statistics")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1768833263:
                    if (lowerCase.equals("game_h2h")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1768824079:
                    if (lowerCase.equals("game_pbp")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1669234313:
                    if (lowerCase.equals("game_lineups")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1491925879:
                    if (lowerCase.equals("buzz_story")) {
                        c10 = '\r';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -865586570:
                    if (lowerCase.equals("trends")) {
                        c10 = '\f';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -838073253:
                    if (lowerCase.equals("game_game_video")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -745673490:
                    if (lowerCase.equals("game_player_stats")) {
                        c10 = 11;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -288435467:
                    if (lowerCase.equals("game_details")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3035859:
                    if (lowerCase.equals("buzz")) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 111090763:
                    if (lowerCase.equals("game_insight")) {
                        c10 = '\t';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1000972032:
                    if (lowerCase.equals("game_news")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1001000273:
                    if (lowerCase.equals("game_odds")) {
                        c10 = '\n';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1701498266:
                    if (lowerCase.equals("game_standings")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    return eVar;
                case 1:
                    return e.LINEUPS;
                case 2:
                    return e.HIGHLIGHTS;
                case 3:
                    return e.STANDINGS;
                case 4:
                    return e.STATISTICS;
                case 5:
                    return e.HEAD_2_HEAD;
                case 6:
                    return e.PLAY_BY_PLAY;
                case 7:
                    return e.NEWS;
                case '\b':
                    return e.BUZZ;
                case '\t':
                    return e.INSIGHTS;
                case '\n':
                    return e.ODDS;
                case 11:
                    return e.PLAYER_STATISTICS;
                case '\f':
                    return e.TRENDS;
                case '\r':
                    return e.STORY;
                default:
                    return eVar;
            }
        } catch (Exception e10) {
            x0.N1(e10);
            return eVar;
        }
    }

    public static Intent m(@NonNull Context context, Class cls) {
        return new Intent(context, Splash.class).putExtra("notificationClass", cls);
    }

    private String n(int i10, boolean z10) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                l0.e();
                StringBuilder sb2 = new StringBuilder("5_365Channel");
                sb2.append(i10);
                sb2.append("_");
                sb2.append(z10 ? "vibrateOn" : "vibrateOff");
                return sb2.toString();
            }
            return "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private int o(GCMNotificationObj gCMNotificationObj) {
        k0 i10 = l0.i(gCMNotificationObj.getSoundName());
        return i10 != null ? i10.f34608a : gCMNotificationObj.isDefaultNotificationSound() ? -4 : -1;
    }

    private int p(GCMNotificationObj gCMNotificationObj) {
        NotificationsParamsObj[] notificationsParamsObjArr;
        try {
            for (NotificationsParamsObj notificationsParamsObj : gCMNotificationObj.NotificationsParams) {
                if (notificationsParamsObj.mKey.toLowerCase().equals("test_id")) {
                    return Integer.valueOf(notificationsParamsObj.GetParam("test_id")).intValue();
                }
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    private Intent q(GCMNotificationObj gCMNotificationObj) {
        String param;
        int parseInt;
        int parseInt2;
        int parseInt3;
        Intent createSinglePlayerCardActivityIntent;
        Intent intent = null;
        try {
            param = gCMNotificationObj.getParam("SubScreen");
            parseInt = Integer.parseInt(gCMNotificationObj.getParam("EntityId"));
            parseInt2 = (gCMNotificationObj.getParam("PromotedItem") == null || gCMNotificationObj.getParam("PromotedItem").isEmpty()) ? 0 : Integer.parseInt(gCMNotificationObj.getParam("PromotedItem"));
            parseInt3 = (gCMNotificationObj.getParam("Type") == null || gCMNotificationObj.getParam("Type").isEmpty()) ? -1 : Integer.parseInt(gCMNotificationObj.getParam("Type"));
            createSinglePlayerCardActivityIntent = SinglePlayerCardActivity.createSinglePlayerCardActivityIntent(parseInt, -1, false, "notification", j(param), parseInt2, parseInt3, true);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            createSinglePlayerCardActivityIntent.addFlags(805306368);
            C(createSinglePlayerCardActivityIntent);
            ng.a aVar = ng.a.f35508a;
            aVar.b("NotificationsManager", "created athlete notification intent=" + createSinglePlayerCardActivityIntent + ", entityId=" + parseInt + ", subScreenName=" + param + ", statType=" + parseInt3 + ", promotionId=" + parseInt2, null);
            return createSinglePlayerCardActivityIntent;
        } catch (Exception e11) {
            e = e11;
            intent = createSinglePlayerCardActivityIntent;
            x0.N1(e);
            return intent;
        }
    }

    private Intent r(GCMNotificationObj gCMNotificationObj, String str) {
        Intent intent = null;
        try {
            intent = TipsterStandaloneActivity.e1(com.scores365.tipster.a.f24303a, (gCMNotificationObj.getParam("Ent") == null || gCMNotificationObj.getParam("Ent").isEmpty()) ? -1 : Integer.valueOf(gCMNotificationObj.getParam("Ent")).intValue(), str);
            C(intent);
            intent.addFlags(805306368);
            return intent;
        } catch (Exception e10) {
            x0.N1(e10);
            return intent;
        }
    }

    private void s(int i10) {
        if (i10 > 0) {
            try {
                if (sf.b.X1().W3(i10)) {
                    return;
                }
                String R = x0.R("https://fcmtest-160314.appspot.com/?deviceID=" + x0.x(sf.b.X1().F2()) + "&testid=" + i10);
                if (R.isEmpty() || !new JSONObject(R).get("result").equals("OK")) {
                    return;
                }
                sf.b.X1().p6(i10);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|3|(4:5|(1:7)(2:68|(1:70)(1:71))|8|9)(1:72)|(3:10|11|(1:13)(1:61))|(7:(2:15|16)|31|(2:33|34)(2:42|43)|35|(1:37)|38|40)|(5:18|19|(1:21)(1:56)|22|23)|24|25|26|(1:28)|29|30|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f9, code lost:
        li.x0.N1(r13);
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f A[Catch: Exception -> 0x008a, TRY_LEAVE, TryCatch #5 {Exception -> 0x008a, blocks: (B:21:0x0053, B:23:0x005f), top: B:78:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b A[Catch: Exception -> 0x00c2, TRY_LEAVE, TryCatch #8 {Exception -> 0x00c2, blocks: (B:33:0x008f, B:35:0x009b), top: B:84:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5 A[Catch: NumberFormatException -> 0x00f8, Exception -> 0x016f, TryCatch #3 {NumberFormatException -> 0x00f8, blocks: (B:46:0x00c9, B:48:0x00d5, B:49:0x00d9), top: B:74:0x00c9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff A[Catch: Exception -> 0x016f, TRY_LEAVE, TryCatch #1 {Exception -> 0x016f, blocks: (B:20:0x0050, B:32:0x008c, B:44:0x00c4, B:46:0x00c9, B:48:0x00d5, B:49:0x00d9, B:55:0x00ff, B:58:0x0116, B:52:0x00f9), top: B:72:0x0050, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0116 A[Catch: Exception -> 0x016f, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x016f, blocks: (B:20:0x0050, B:32:0x008c, B:44:0x00c4, B:46:0x00c9, B:48:0x00d5, B:49:0x00d9, B:55:0x00ff, B:58:0x0116, B:52:0x00f9), top: B:72:0x0050, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0130 A[Catch: Exception -> 0x016c, TryCatch #4 {Exception -> 0x016c, blocks: (B:56:0x0112, B:60:0x0123, B:62:0x0130, B:63:0x0135, B:59:0x011e), top: B:76:0x00fd }] */
    /* JADX WARN: Type inference failed for: r13v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.content.Intent t(com.scores365.entitys.GCMNotificationObj r13) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.b.t(com.scores365.entitys.GCMNotificationObj):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0233 A[Catch: Exception -> 0x030a, TryCatch #0 {Exception -> 0x030a, blocks: (B:3:0x0006, B:5:0x002f, B:7:0x0038, B:9:0x0044, B:13:0x0065, B:17:0x00af, B:19:0x00c1, B:20:0x00c4, B:22:0x00f0, B:24:0x010c, B:28:0x0149, B:32:0x016f, B:34:0x01b3, B:42:0x02ad, B:44:0x02b4, B:46:0x02d4, B:45:0x02d1, B:35:0x01d5, B:36:0x01da, B:38:0x0220, B:40:0x0233, B:41:0x0236, B:11:0x0049, B:6:0x0034), top: B:51:0x0006, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02b4 A[Catch: Exception -> 0x030a, TryCatch #0 {Exception -> 0x030a, blocks: (B:3:0x0006, B:5:0x002f, B:7:0x0038, B:9:0x0044, B:13:0x0065, B:17:0x00af, B:19:0x00c1, B:20:0x00c4, B:22:0x00f0, B:24:0x010c, B:28:0x0149, B:32:0x016f, B:34:0x01b3, B:42:0x02ad, B:44:0x02b4, B:46:0x02d4, B:45:0x02d1, B:35:0x01d5, B:36:0x01da, B:38:0x0220, B:40:0x0233, B:41:0x0236, B:11:0x0049, B:6:0x0034), top: B:51:0x0006, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02d1 A[Catch: Exception -> 0x030a, TryCatch #0 {Exception -> 0x030a, blocks: (B:3:0x0006, B:5:0x002f, B:7:0x0038, B:9:0x0044, B:13:0x0065, B:17:0x00af, B:19:0x00c1, B:20:0x00c4, B:22:0x00f0, B:24:0x010c, B:28:0x0149, B:32:0x016f, B:34:0x01b3, B:42:0x02ad, B:44:0x02b4, B:46:0x02d4, B:45:0x02d1, B:35:0x01d5, B:36:0x01da, B:38:0x0220, B:40:0x0233, B:41:0x0236, B:11:0x0049, B:6:0x0034), top: B:51:0x0006, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void u(com.scores365.entitys.GCMNotificationObj r20, int r21) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.b.u(com.scores365.entitys.GCMNotificationObj, int):void");
    }

    private Intent v() {
        Intent intent;
        Exception e10;
        try {
            intent = new Intent(App.m(), StandingsAndFixturesActivity.class);
        } catch (Exception e11) {
            intent = null;
            e10 = e11;
        }
        try {
            C(intent);
            intent.addFlags(603979776);
            ng.a.f35508a.b("NotificationsManager", "created new standings notification intent=" + intent, null);
            return intent;
        } catch (Exception e12) {
            e10 = e12;
            x0.N1(e10);
            return intent;
        }
    }

    private static void w(NotificationManager notificationManager) {
        StatusBarNotification[] activeNotifications;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                activeNotifications = notificationManager.getActiveNotifications();
                if (activeNotifications.length >= 24) {
                    long j10 = Long.MAX_VALUE;
                    int i10 = 0;
                    for (int i11 = 0; i11 < activeNotifications.length; i11++) {
                        if (activeNotifications[i11].getPostTime() < j10 && activeNotifications[i11].getId() != Integer.MAX_VALUE) {
                            j10 = activeNotifications[i11].getPostTime();
                            i10 = i11;
                        }
                    }
                    notificationManager.cancel(activeNotifications[i10].getId());
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private Bitmap x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ng.a aVar = ng.a.f35508a;
            aVar.b("NotificationsManager", "loading notification image from url=" + str, null);
            Bitmap t10 = u.t(this.f23270a, str);
            aVar.b("NotificationsManager", "creating cropped image from bitmap=" + t10, null);
            Bitmap e10 = e(t10, 1.0f, true);
            aVar.b("NotificationsManager", "created cropped image=" + e10, null);
            return e10;
        } catch (Exception e11) {
            ng.a aVar2 = ng.a.f35508a;
            aVar2.b("NotificationsManager", "error creating notification image from url=" + str, e11);
            return null;
        }
    }

    private Intent y(GCMNotificationObj gCMNotificationObj) {
        Intent m10 = m(this.f23270a, Bet365LandingActivity.class);
        try {
            m10.addFlags(805306368);
            m10.putExtra(Bet365LandingActivity.GAME_ID, gCMNotificationObj.getParam("GameID"));
            m10.putExtra("title", gCMNotificationObj.getParam("Headline"));
            m10.putExtra(Bet365LandingActivity.IS_SOURCE_NOTIFICATION, true);
            if (gCMNotificationObj.getParam("URL") != null && !gCMNotificationObj.getParam("URL").isEmpty()) {
                m10.putExtra("url", gCMNotificationObj.getParam("URL"));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return m10;
    }

    private Intent z(GCMNotificationObj gCMNotificationObj) {
        Intent m10 = m(this.f23270a, k.class);
        try {
            m10.addFlags(805306368);
            m10.putExtra("starting_srceen", gCMNotificationObj.getParam("sub_screen"));
            m10.putExtra("starting_tab", gCMNotificationObj.getParam("starting_tab"));
            m10.putExtra(Bet365LandingActivity.IS_SOURCE_NOTIFICATION, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return m10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(45:1|(3:2|(1:4)(2:437|438)|5)|6|(2:8|(2:10|(2:12|13)(43:15|(2:17|(1:19)(1:20))(2:294|(2:296|297)(2:298|(2:300|301)(2:302|(2:304|305)(2:306|(2:308|309)(2:310|(2:312|313)(2:314|(36:316|(2:290|291)|24|(2:279|(5:281|(1:283)(1:288)|284|(1:286)|287)(1:289))(1:28)|29|30|31|33|34|35|(1:37)(1:273)|38|39|(1:41)(1:270)|42|(2:262|263)|44|(18:128|129|130|131|132|(2:255|256)(1:134)|135|(1:137)|142|(27:172|173|174|175|176|177|178|179|180|(4:182|183|184|(5:232|(3:234|(3:236|237|238)(1:240)|239)|241|189|(13:195|(1:230)(1:201)|202|203|204|205|206|207|208|209|(3:211|(2:213|215)(2:217|218)|216)|219|220)(2:193|194)))(1:244)|188|189|(1:191)|195|(2:197|199)|230|202|203|204|205|206|207|208|209|(0)|219|220)(1:144)|145|146|(6:149|150|(1:156)(1:153)|154|155|147)|161|162|163|164|165)(1:46)|(1:48)(1:127)|49|50|(1:53)|54|55|56|57|58|59|60|61|62|63|(5:67|(1:(1:72)(1:71))|73|74|(1:80))|116|86|(2:108|(2:110|111)(1:112))(9:90|91|92|93|94|95|(1:99)|100|101))(3:317|(1:319)(2:322|(1:324)(3:325|(8:395|396|397|398|399|400|401|402)(3:327|(1:394)(2:331|(3:384|385|(1:387)(1:390))(2:333|(5:367|368|(1:381)(3:372|374|375)|376|377)(42:335|(4:348|349|350|(5:352|354|355|(1:357)(1:360)|358)(1:364))(2:339|(2:341|(1:343)(1:344))(2:345|(1:347)))|22|(0)|24|(1:26)|279|(0)(0)|29|30|31|33|34|35|(0)(0)|38|39|(0)(0)|42|(0)|44|(0)(0)|(0)(0)|49|50|(1:53)|54|55|56|57|58|59|60|61|62|63|(7:65|67|(0)|73|74|(0)|80)|116|86|(1:88)|108|(0)(0))))|388)|363))|320)))))))|21|22|(0)|24|(0)|279|(0)(0)|29|30|31|33|34|35|(0)(0)|38|39|(0)(0)|42|(0)|44|(0)(0)|(0)(0)|49|50|(0)|54|55|56|57|58|59|60|61|62|63|(0)|116|86|(0)|108|(0)(0)))(1:416))(3:417|(1:419)(2:421|(1:423)(2:424|(1:435)(4:428|429|430|431)))|420)|321|(0)|24|(0)|279|(0)(0)|29|30|31|33|34|35|(0)(0)|38|39|(0)(0)|42|(0)|44|(0)(0)|(0)(0)|49|50|(0)|54|55|56|57|58|59|60|61|62|63|(0)|116|86|(0)|108|(0)(0)|(3:(0)|(1:113)|(1:414))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(6:(4:182|183|184|(5:232|(3:234|(3:236|237|238)(1:240)|239)|241|189|(13:195|(1:230)(1:201)|202|203|204|205|206|207|208|209|(3:211|(2:213|215)(2:217|218)|216)|219|220)(2:193|194)))(1:244)|208|209|(0)|219|220)|202|203|204|205|206|207) */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x08b0, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x08b9, code lost:
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x09c8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x09ca, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x09cd, code lost:
        r6 = r1;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x09d0, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x09d1, code lost:
        r28 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x09d8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x09d9, code lost:
        r28 = r3;
        r23 = r9;
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x09e5, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x09e6, code lost:
        r28 = r3;
        r23 = r9;
        r18 = r10;
        r19 = r12;
        r3 = false;
        r6 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0aef, code lost:
        r8 = "]";
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0af2, code lost:
        r8 = "]";
        r9 = r19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x097d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x098a  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x098d  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0994 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0a6c  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0a75  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0b17  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0be3  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0709 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x06fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0480 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:462:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v61 */
    /* JADX WARN: Type inference failed for: r7v64 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D(@androidx.annotation.NonNull com.scores365.entitys.GCMNotificationObj r34) {
        /*
            Method dump skipped, instructions count: 3080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.b.D(com.scores365.entitys.GCMNotificationObj):void");
    }

    public Bitmap e(Bitmap bitmap, float f10, boolean z10) {
        int i10;
        try {
            ng.a aVar = ng.a.f35508a;
            aVar.b("NotificationsManager", "creating cropped image from source=" + bitmap + ", ratio=" + f10 + ", isCentered=" + z10, null);
            if (f10 > 0.0f) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (bitmap.getWidth() >= bitmap.getHeight() * f10) {
                    int i11 = (int) (height * f10);
                    r8 = z10 ? (width - i11) / 2 : 0;
                    width = i11;
                } else {
                    int i12 = (int) (width / f10);
                    if (z10) {
                        i10 = (height - i12) / 2;
                        height = i12;
                        return Bitmap.createBitmap(bitmap, r8, i10, width, height);
                    }
                    height = i12;
                }
                i10 = 0;
                return Bitmap.createBitmap(bitmap, r8, i10, width, height);
            }
            return bitmap;
        } catch (Exception unused) {
            ng.a aVar2 = ng.a.f35508a;
            aVar2.c("NotificationsManager", "error creating cropped image from source=" + bitmap + ", ratio=" + f10 + ", isCentered=" + z10, null);
            return bitmap;
        }
    }
}
