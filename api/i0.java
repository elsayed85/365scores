package com.scores365.api;

import com.facebook.appevents.AppEventsConstants;
import com.scores365.entitys.ChartDashboardData;
import com.scores365.entitys.StatsDashboardData;
import org.json.JSONObject;
/* compiled from: ApiCompetitionStatistics.java */
/* loaded from: classes2.dex */
public class i0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private b f23055a;

    /* renamed from: b  reason: collision with root package name */
    private int f23056b;

    /* renamed from: c  reason: collision with root package name */
    private ChartDashboardData f23057c;

    /* renamed from: d  reason: collision with root package name */
    private StatsDashboardData f23058d;

    /* renamed from: e  reason: collision with root package name */
    private String f23059e;

    /* compiled from: ApiCompetitionStatistics.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23060a;

        static {
            int[] iArr = new int[b.values().length];
            f23060a = iArr;
            try {
                iArr[b.TopScorers.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23060a[b.StatsPage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: ApiCompetitionStatistics.java */
    /* loaded from: classes2.dex */
    public enum b {
        TopScorers,
        StatsPage
    }

    public i0(int i10, b bVar) {
        this.f23055a = bVar;
        this.f23056b = i10;
    }

    public ChartDashboardData a() {
        return this.f23057c;
    }

    public StatsDashboardData b() {
        return this.f23058d;
    }

    public void c(String str) {
        this.f23059e = str;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = a.f23060a[this.f23055a.ordinal()];
        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (i10 != 1 && i10 != 2) {
            str = "";
        }
        sb2.append("/Data/Statistics/Competition/Personal/Dashboard/?");
        String str2 = this.f23059e;
        if (str2 == null || str2.isEmpty()) {
            sb2.append("Competition=");
            sb2.append(this.f23056b);
        } else {
            sb2.append(this.f23059e);
        }
        sb2.append("&StatTypes=");
        sb2.append(str);
        sb2.append("&limit=20");
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        try {
            b bVar = this.f23055a;
            if (bVar == b.TopScorers) {
                this.f23057c = ChartDashboardData.parse(new JSONObject(str));
            } else if (bVar == b.StatsPage) {
                this.f23058d = StatsDashboardData.parse(str);
            }
        } catch (Exception unused) {
        }
    }
}
