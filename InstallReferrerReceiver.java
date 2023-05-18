package com.scores365;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import li.x0;
/* loaded from: classes2.dex */
public class InstallReferrerReceiver extends BroadcastReceiver {
    private static Map<String, String> a(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split("&")) {
                hashMap.put(str2.split("=")[0], str2.split("=")[1]);
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        try {
            String string = intent.getExtras().getString("referrer", null);
            if (string == null || (str = a(URLDecoder.decode(string, "UTF8")).get("referrer_udid")) == null || str.equals("")) {
                return;
            }
            sf.b.X1().s8(str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
