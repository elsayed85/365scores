package com.scores365.api;

import com.scores365.entitys.GsonManager;
import com.scores365.entitys.ServerMaintenanceObj;
/* compiled from: ApiMaintenance.kt */
/* loaded from: classes2.dex */
public final class x0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private final String f23250a = "ApiMaintenance";

    /* renamed from: b  reason: collision with root package name */
    private ServerMaintenanceObj f23251b;

    /* compiled from: ApiMaintenance.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.google.gson.reflect.a<ServerMaintenanceObj> {
        a() {
        }
    }

    public final ServerMaintenanceObj a() {
        return this.f23251b;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        return "?apptype=2";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.api.d
    public String getURL() {
        return "http://maintenancestatus.365scores.com/";
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            this.f23251b = (ServerMaintenanceObj) GsonManager.getGson().m(str, new a().getType());
        } catch (Exception e10) {
            ng.a aVar = ng.a.f35508a;
            String str2 = this.f23250a;
            aVar.c(str2, "error parsing maintenance info, data=" + str, e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        return false;
    }

    @Override // com.scores365.api.d
    protected boolean shouldCache() {
        return false;
    }
}
