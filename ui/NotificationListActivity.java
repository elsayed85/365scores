package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.a1;
import androidx.lifecycle.w0;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.AthleteObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GamesObj;
import com.scores365.gameCenter.i0;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class NotificationListActivity extends com.scores365.Design.Activities.c implements i0.k {
    public static String ENTITY_EXTRA_ID = "entityId";
    public static String ENTITY_EXTRA_NAME = "entityName";
    public static String EXTRA_IS_FROM_NOTIFICATION = "isFromNotification";
    public static String EXTRA_SOURCE = "source_tag";
    public static String FORCED_NOTIFICATIONS = "forced_notifications_tag";
    public static String FORCED_TITLE = "forced_title_tag";
    public static String START_FROM_GAME_NOTIF = "startFromGameNotif";
    private int entityId;
    private App.c entityType;
    private String forcedTitle;
    private boolean isFromNotification;
    private RelativeLayout preLoader;
    private int sportType;
    private int team1Id;
    private int team2Id;
    private xe.c viewModel;
    private String entityName = "";
    private int leagueID = -1;
    private int entityTypeForAnalytics = -1;
    private boolean isDirty = false;
    private final a1 viewModelStoreOwner = this;

    private App.c getEntityTypeFromEntity(Object obj) {
        App.c cVar;
        if (obj != null) {
            try {
                if (obj instanceof CompObj) {
                    cVar = App.c.TEAM;
                } else if (obj instanceof CompetitionObj) {
                    cVar = App.c.LEAGUE;
                } else if (obj instanceof GameObj) {
                    cVar = App.c.GAME;
                } else if (!(obj instanceof AthleteObj)) {
                    return null;
                } else {
                    cVar = App.c.ATHLETE;
                }
                return cVar;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
        return null;
    }

    public static Intent getNotificationListActivity(int i10, int i11, String str, boolean z10) {
        Intent intent = new Intent(App.m(), NotificationListActivity.class);
        try {
            intent.putExtra(ENTITY_EXTRA_ID, i10);
            intent.putExtra("leagueID", i11);
            intent.putExtra(EXTRA_SOURCE, str);
            intent.putExtra(EXTRA_IS_FROM_NOTIFICATION, z10);
            intent.setFlags(335544320);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    public static Intent getNotificationListActivity(Serializable serializable, int i10, String str) {
        Intent intent = new Intent(App.m(), NotificationListActivity.class);
        try {
            intent.putExtra(ENTITY_EXTRA_NAME, serializable);
            intent.putExtra(ENTITY_EXTRA_ID, i10);
            intent.putExtra(EXTRA_SOURCE, str);
            intent.putExtra("leagueID", i10);
            intent.setFlags(335544320);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    public static Intent getNotificationListActivityIntent(Serializable serializable, String str, HashSet<Integer> hashSet, String str2, boolean z10) {
        Intent intent = new Intent(App.m(), NotificationListActivity.class);
        try {
            intent.putExtra(ENTITY_EXTRA_NAME, serializable);
            intent.putExtra(EXTRA_SOURCE, str);
            intent.putExtra(FORCED_NOTIFICATIONS, hashSet);
            intent.putExtra(FORCED_TITLE, str2);
            intent.putExtra("send_analytics_at_finish", z10);
            intent.setFlags(67108864);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    private String getSource() {
        try {
            return getIntent().getStringExtra(EXTRA_SOURCE);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private void handleAnalytics() {
        Context m10 = App.m();
        String[] strArr = new String[8];
        strArr[0] = "entity_type";
        strArr[1] = String.valueOf(this.entityTypeForAnalytics);
        strArr[2] = "entity_id";
        strArr[3] = String.valueOf(this.entityId);
        strArr[4] = ShareConstants.FEED_SOURCE_PARAM;
        strArr[5] = getSource();
        strArr[6] = "is_changed";
        strArr[7] = this.isDirty ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        ee.k.o(m10, "notification", "edit", "click", null, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(GameObj gameObj) {
        if (isDestroyed() || isFinishing() || gameObj == null) {
            return;
        }
        renderEntityData(gameObj);
        this.preLoader.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(int i10) {
        try {
            com.scores365.api.h hVar = new com.scores365.api.h(this, -1, -1, String.valueOf(i10), "", -1, -1);
            hVar.call();
            GamesObj a10 = hVar.a();
            final GameObj gameObj = null;
            LinkedHashMap<Integer, GameObj> games = a10 == null ? null : a10.getGames();
            if (games != null) {
                gameObj = games.get(Integer.valueOf(i10));
            }
            li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.ui.x
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationListActivity.this.lambda$onCreate$0(gameObj);
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01f1 A[Catch: Exception -> 0x02c1, TryCatch #1 {Exception -> 0x02c1, blocks: (B:2:0x0000, B:4:0x0006, B:17:0x00da, B:19:0x00de, B:21:0x00e8, B:23:0x00f0, B:26:0x0103, B:28:0x0109, B:30:0x011d, B:31:0x0140, B:50:0x01d7, B:52:0x01e5, B:58:0x01f1, B:59:0x01fc, B:32:0x0143, B:35:0x014c, B:37:0x0152, B:39:0x0166, B:40:0x0189, B:41:0x018c, B:44:0x0197, B:46:0x019d, B:48:0x01b1, B:49:0x01d4, B:60:0x01fe, B:72:0x0236, B:74:0x023f, B:76:0x0249, B:77:0x0255, B:78:0x0259, B:80:0x025f, B:82:0x0269, B:86:0x0276, B:83:0x026d, B:85:0x0273, B:71:0x0233, B:5:0x0020, B:7:0x0024, B:8:0x0047, B:10:0x004b, B:12:0x0066, B:13:0x00b0, B:14:0x00ba, B:16:0x00be, B:61:0x0205, B:64:0x020a, B:66:0x0212, B:68:0x021c), top: B:93:0x0000, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void renderEntityData(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.NotificationListActivity.renderEntityData(java.lang.Object):void");
    }

    public static void startNotificationListActivity(Serializable serializable, String str, HashSet<Integer> hashSet, String str2, boolean z10) {
        try {
            Intent intent = new Intent(App.m(), NotificationListActivity.class);
            intent.putExtra(ENTITY_EXTRA_NAME, serializable);
            intent.putExtra(EXTRA_SOURCE, str);
            intent.putExtra(FORCED_NOTIFICATIONS, hashSet);
            intent.putExtra(FORCED_TITLE, str2);
            intent.putExtra("send_analytics_at_finish", z10);
            intent.setFlags(335544320);
            App.m().startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void startNotificationListActivity(Serializable serializable, String str, boolean z10) {
        startNotificationListActivity(serializable, str, null, null, z10);
    }

    @Override // com.scores365.gameCenter.i0.k
    public void OnGameCompleteGameData(GameObj gameObj, CompetitionObj competitionObj, boolean z10) {
        renderEntityData(gameObj);
        this.preLoader.setVisibility(8);
    }

    public App.c getEntityType() {
        return this.entityType;
    }

    public int getEntityTypeForAnalytics() {
        return this.entityTypeForAnalytics;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isFromNotification) {
            Intent x02 = x0.x0();
            x02.setFlags(268435456);
            x02.setFlags(67108864);
            x02.putExtra(START_FROM_GAME_NOTIF, true);
            startActivity(x02);
            finish();
        } else {
            Intent intent = new Intent();
            intent.putExtra("entityID", this.entityId);
            intent.putExtra("entityType", this.entityType.getValue());
            setResult(-1, intent);
            finish();
            super.onBackPressed();
        }
        handleAnalytics();
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            this.viewModel = (xe.c) new w0(this.viewModelStoreOwner).a(xe.c.class);
            super.onCreate(bundle);
            x0.j2(this);
            x0.D1(this);
            setContentView(R.layout.f22593k5);
            initActionBar();
            this.preLoader = (RelativeLayout) findViewById(R.id.Jn);
            this.isFromNotification = getIntent().getBooleanExtra(EXTRA_IS_FROM_NOTIFICATION, false);
            Serializable serializableExtra = getIntent().getSerializableExtra(ENTITY_EXTRA_NAME);
            this.entityType = getEntityTypeFromEntity(serializableExtra);
            if (serializableExtra != null) {
                renderEntityData(serializableExtra);
            } else {
                this.preLoader.setVisibility(0);
                final int intExtra = getIntent().getIntExtra(ENTITY_EXTRA_ID, -1);
                if (intExtra != -1) {
                    li.c.f34483a.f().execute(new Runnable() { // from class: com.scores365.ui.y
                        @Override // java.lang.Runnable
                        public final void run() {
                            NotificationListActivity.this.lambda$onCreate$1(intExtra);
                        }
                    });
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setElevation(p0.s(4));
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

    public void setDirty(boolean z10) {
        this.isDirty = z10;
    }
}
