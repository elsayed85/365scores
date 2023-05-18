package com.scores365;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.NotificationBroadcastReceiver;
import com.scores365.api.d;
import com.scores365.b;
import com.scores365.entitys.GCMNotificationObj;
import ee.k;
import java.lang.ref.WeakReference;
import li.c;
import li.h0;
import li.x0;
/* loaded from: classes2.dex */
public class NotificationBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<b.a> f21160a;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(b.a aVar, int i10, boolean z10) {
        aVar.i(i10, !z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(GCMNotificationObj gCMNotificationObj, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d.handleAlternateURL(h0.d(App.m())));
        sb2.append("/Users/Update/Mute/?deviceid=");
        sb2.append(sf.b.X1().F2());
        sb2.append("&devicetype=2&GameID=");
        sb2.append(gCMNotificationObj.getEntity());
        sb2.append("&mute=");
        sb2.append(z10 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
        x0.R(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Intent intent, Context context) {
        final b.a aVar;
        final GCMNotificationObj gCMNotificationObj = (GCMNotificationObj) intent.getSerializableExtra("notificationObject");
        if (gCMNotificationObj != null) {
            final int entity = gCMNotificationObj.getEntity();
            App.c cVar = App.c.GAME;
            final boolean d02 = App.b.d0(entity, cVar);
            if (d02) {
                App.b.z0(entity, cVar);
            } else {
                App.b.b(entity, null, cVar, -1, false, null);
                App.b.q0(entity, cVar, false);
            }
            boolean z10 = !d02;
            Context m10 = App.m();
            String[] strArr = new String[8];
            strArr[0] = "click_type";
            strArr[1] = z10 ? "off" : "on";
            strArr[2] = "entity_type";
            strArr[3] = "4";
            strArr[4] = "entity_id";
            strArr[5] = String.valueOf(entity);
            strArr[6] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[7] = "notification";
            k.o(m10, "notification", "button", "click", null, strArr);
            WeakReference<b.a> weakReference = f21160a;
            if (weakReference != null && (aVar = weakReference.get()) != null) {
                c.f34483a.e().execute(new Runnable() { // from class: nb.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        NotificationBroadcastReceiver.d(b.a.this, entity, d02);
                    }
                });
            }
            gCMNotificationObj.setIsFromNotification(true);
            gCMNotificationObj.setSound("Silence");
            gCMNotificationObj.setVibrateOn(false);
            c.f34483a.f().execute(new Runnable() { // from class: nb.b0
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationBroadcastReceiver.e(GCMNotificationObj.this, d02);
                }
            });
            new b(context).D(gCMNotificationObj);
        }
    }

    public static void g(b.a aVar) {
        f21160a = new WeakReference<>(aVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        c.f34483a.f().execute(new Runnable() { // from class: nb.z
            @Override // java.lang.Runnable
            public final void run() {
                NotificationBroadcastReceiver.f(intent, context);
            }
        });
    }
}
