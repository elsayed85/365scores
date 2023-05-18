package com.scores365.wear;

import android.app.NotificationManager;
import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.FreezableUtils;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import com.scores365.gameCenter.GameCenterBaseActivity;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import li.x0;
/* loaded from: classes2.dex */
public class WearService extends WearableListenerService {

    /* renamed from: a  reason: collision with root package name */
    public static GoogleApiClient f24433a;

    @Override // com.google.android.gms.wearable.WearableListenerService, android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            if (f24433a == null) {
                f24433a = new GoogleApiClient.Builder(this).addApi(Wearable.API).build();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        try {
            ArrayList<DataEvent> freezeIterable = FreezableUtils.freezeIterable(dataEventBuffer);
            if (f24433a.blockingConnect(30L, TimeUnit.SECONDS).isSuccess()) {
                for (DataEvent dataEvent : freezeIterable) {
                    DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
                    NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                    int i10 = dataMap.getInt("action.key", -1);
                    if (i10 == 2) {
                        Intent intent = new Intent(this, GameCenterBaseActivity.class);
                        intent.putExtra("gc_game_id", dataMap.getInt("gc_game_id"));
                        intent.putExtra("analyticsSource", "notification");
                        intent.putExtras(dataMap.getDataMap("extraDataMap.key").toBundle());
                        intent.addFlags(268435456);
                        notificationManager.cancel(dataMap.getInt("count.key"));
                        startActivity(intent);
                    } else if (i10 == 3) {
                        notificationManager.cancel(dataMap.getInt("count.key"));
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
