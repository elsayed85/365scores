package com.scores365.analytics.firehose;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
/* compiled from: FirehoseBackgroundWorker.kt */
/* loaded from: classes2.dex */
public final class FirehoseBackgroundWorker extends Worker {

    /* renamed from: e  reason: collision with root package name */
    public static final a f22913e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f22914a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22915b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f22916c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22917d;

    /* compiled from: FirehoseBackgroundWorker.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirehoseBackgroundWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.g(context, "context");
        m.g(workerParameters, "workerParameters");
        this.f22914a = context;
        this.f22915b = "FirehoseBackgroundWorker";
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.f22916c = defaultSharedPreferences;
        this.f22917d = defaultSharedPreferences.getBoolean("use_bi_debug_stream", false) ? "mobile_stg_users_qa" : "mobile_stg_users";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.work.m.a doWork() {
        /*
            r12 = this;
            fe.b r0 = fe.b.f26425a
            android.content.Context r1 = r12.f22914a
            java.lang.String r2 = r12.f22915b
            com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.KinesisFirehoseRecorder r0 = r0.b(r1, r2)
            if (r0 == 0) goto Ld0
            ng.a r7 = ng.a.f35508a
            java.lang.String r2 = r12.f22915b
            java.lang.String r3 = "firehose tracker initialized"
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            ng.c.a.b(r1, r2, r3, r4, r5, r6)
            androidx.work.f r1 = r12.getInputData()
            java.lang.String r2 = "json"
            java.lang.String r8 = r1.i(r2)
            if (r8 == 0) goto L2e
            boolean r1 = kotlin.text.l.p(r8)
            if (r1 == 0) goto L2c
            goto L2e
        L2c:
            r1 = 0
            goto L2f
        L2e:
            r1 = 1
        L2f:
            java.lang.String r9 = "success()"
            if (r1 == 0) goto L3b
            androidx.work.m$a r0 = androidx.work.m.a.c()
            kotlin.jvm.internal.m.f(r0, r9)
            return r0
        L3b:
            android.content.SharedPreferences r1 = r12.f22916c
            r2 = -1
            java.lang.String r10 = "LastFirehoseUserDataJsonHash"
            int r1 = r1.getInt(r10, r2)
            int r2 = r8.hashCode()
            if (r1 != r2) goto L52
            androidx.work.m$a r0 = androidx.work.m.a.c()
            kotlin.jvm.internal.m.f(r0, r9)
            return r0
        L52:
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>(r8)
            java.lang.String r1 = "table"
            java.lang.String r2 = "365.stg.users"
            r11.put(r1, r2)
            sf.b r1 = sf.b.X1()
            java.lang.String r1 = r1.j()
            java.lang.String r2 = "server_time_string"
            r11.put(r2, r1)
            sf.b r1 = sf.b.X1()
            long r1 = r1.h()
            java.lang.String r3 = "last_server_time_taken"
            r11.put(r3, r1)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = ee.m.c(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "datekey"
            r11.put(r2, r1)
            java.lang.String r2 = r12.f22915b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "firehose worker data="
            r1.append(r3)
            r1.append(r11)
            java.lang.String r3 = r1.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            ng.c.a.b(r1, r2, r3, r4, r5, r6)
            java.lang.String r1 = r11.toString()
            java.lang.String r2 = r12.f22917d
            r0.c(r1, r2)
            r0.e()
            android.content.SharedPreferences r0 = r12.f22916c
            android.content.SharedPreferences$Editor r0 = r0.edit()
            int r1 = r8.hashCode()
            android.content.SharedPreferences$Editor r0 = r0.putInt(r10, r1)
            r0.apply()
            java.lang.String r2 = r12.f22915b
            java.lang.String r3 = "firehose worker submitted all data"
            r1 = r7
            ng.c.a.b(r1, r2, r3, r4, r5, r6)
            androidx.work.m$a r0 = androidx.work.m.a.c()
            kotlin.jvm.internal.m.f(r0, r9)
            return r0
        Ld0:
            ng.a r1 = ng.a.f35508a
            java.lang.String r2 = r12.f22915b
            java.lang.String r3 = "firehose recorder is null"
            r4 = 0
            r5 = 4
            r6 = 0
            ng.c.a.b(r1, r2, r3, r4, r5, r6)
            int r0 = r12.getRunAttemptCount()
            r1 = 2
            if (r0 >= r1) goto Lea
            androidx.work.m$a r0 = androidx.work.m.a.b()
            java.lang.String r1 = "retry()"
            goto Lf0
        Lea:
            androidx.work.m$a r0 = androidx.work.m.a.a()
            java.lang.String r1 = "failure()"
        Lf0:
            kotlin.jvm.internal.m.f(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.analytics.firehose.FirehoseBackgroundWorker.doWork():androidx.work.m$a");
    }
}
