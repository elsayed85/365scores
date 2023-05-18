package com.scores365.Pages;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.api.i0;
import com.scores365.entitys.ChartDashboardData;
import com.scores365.ui.GeneralNotificationListActivity;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: TopScorersPage.java */
/* loaded from: classes2.dex */
public class e0 extends com.scores365.Design.Pages.q {

    /* renamed from: l  reason: collision with root package name */
    private ChartDashboardData f21209l;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<com.scores365.Design.PageObjects.b> f21210m;

    /* renamed from: q  reason: collision with root package name */
    private Spinner f21214q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f21215r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f21216s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f21217t;

    /* renamed from: u  reason: collision with root package name */
    private NestedScrollView f21218u;

    /* renamed from: v  reason: collision with root package name */
    private String f21219v;

    /* renamed from: w  reason: collision with root package name */
    private String f21220w;

    /* renamed from: n  reason: collision with root package name */
    private String f21211n = "";

    /* renamed from: o  reason: collision with root package name */
    private int f21212o = -1;

    /* renamed from: p  reason: collision with root package name */
    private String f21213p = "";

    /* renamed from: x  reason: collision with root package name */
    private boolean f21221x = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TopScorersPage.java */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* compiled from: TopScorersPage.java */
        /* renamed from: com.scores365.Pages.e0$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0236a implements Comparator<com.scores365.Design.PageObjects.b> {
            C0236a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(com.scores365.Design.PageObjects.b bVar, com.scores365.Design.PageObjects.b bVar2) {
                try {
                    return Integer.parseInt(((ld.m) bVar2).f34189b.getAmount()) - Integer.parseInt(((ld.m) bVar).f34189b.getAmount());
                } catch (Exception unused) {
                    return 0;
                }
            }
        }

        /* compiled from: TopScorersPage.java */
        /* loaded from: classes2.dex */
        class b implements Comparator<com.scores365.Design.PageObjects.b> {
            b() {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(com.scores365.Design.PageObjects.b bVar, com.scores365.Design.PageObjects.b bVar2) {
                float parseFloat;
                try {
                    parseFloat = Float.parseFloat(((ld.m) bVar2).f34189b.getMinPerChart()) - Float.parseFloat(((ld.m) bVar).f34189b.getMinPerChart());
                } catch (Exception unused) {
                }
                if (parseFloat > 0.0f) {
                    return -1;
                }
                return parseFloat < 0.0f ? 1 : 0;
            }
        }

        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            try {
                if (i10 == 0) {
                    Collections.sort(e0.this.f21210m, new C0236a());
                } else {
                    Collections.sort(e0.this.f21210m, new b());
                }
                ((com.scores365.Design.Pages.q) e0.this).rvBaseAdapter.notifyDataSetChanged();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            try {
                e0.this.f21214q.setSelection(0);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TopScorersPage.java */
    /* loaded from: classes2.dex */
    public static class b extends AsyncTask<Void, Void, ChartDashboardData> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<e0> f21225a;

        public b(e0 e0Var) {
            this.f21225a = new WeakReference<>(e0Var);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public ChartDashboardData doInBackground(Void... voidArr) {
            try {
                e0 e0Var = this.f21225a.get();
                i0 i0Var = new i0(e0Var != null ? e0Var.getArguments().getInt("competition_id_tag", -1) : -1, i0.b.TopScorers);
                i0Var.call();
                return i0Var.a();
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(ChartDashboardData chartDashboardData) {
            super.onPostExecute(chartDashboardData);
            try {
                e0 e0Var = this.f21225a.get();
                if (e0Var != null) {
                    e0 e0Var2 = e0Var;
                    e0Var2.f21209l = chartDashboardData;
                    e0Var2.renderData(e0Var2.LoadData());
                    e0Var2.HideMainPreloader();
                    com.scores365.Design.Activities.h hVar = e0Var.getParentFragment() instanceof com.scores365.Design.Activities.h ? (com.scores365.Design.Activities.h) e0Var.getParentFragment() : null;
                    if (hVar != null) {
                        hVar.a(chartDashboardData, e0Var);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                e0 e0Var = this.f21225a.get();
                if (e0Var != null) {
                    e0Var.getArguments().putBoolean("is_task_started_tag", true);
                    e0Var.ShowMainPreloader();
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[Catch: Exception -> 0x0302, TRY_LEAVE, TryCatch #4 {Exception -> 0x0302, blocks: (B:12:0x0022, B:14:0x0026, B:16:0x002a, B:17:0x003f, B:19:0x0045, B:22:0x0055, B:24:0x0073, B:26:0x0095, B:28:0x00bb, B:47:0x0205, B:49:0x022b, B:51:0x023d, B:53:0x0255, B:55:0x025d, B:61:0x0282, B:65:0x029f, B:64:0x0288, B:56:0x0262, B:58:0x027b, B:30:0x00df, B:32:0x0101, B:34:0x0125, B:36:0x014d, B:37:0x0171, B:39:0x0175, B:41:0x0193, B:43:0x01b7, B:45:0x01df), top: B:97:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.ArrayList<com.scores365.Design.PageObjects.b> B1() {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.e0.B1():java.util.ArrayList");
    }

    private void C1() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(getArguments().getString("state_1", ""));
            arrayList.add(getArguments().getString("state_2", ""));
            ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), p0.h0(), arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.N);
            this.f21214q.setAdapter((SpinnerAdapter) arrayAdapter);
            this.f21214q.setOnItemSelectedListener(new a());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static e0 D1(ChartDashboardData chartDashboardData, String str, boolean z10, boolean z11, sc.i iVar, int i10, boolean z12, String str2, String str3, boolean z13, String str4, String str5, String str6, boolean z14, boolean z15, boolean z16, int i11) {
        e0 e0Var = new e0();
        try {
            e0Var.f21209l = chartDashboardData;
            e0Var.placement = iVar;
            e0Var.f21211n = str4;
            e0Var.f21212o = i10;
            e0Var.f21213p = str5;
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            bundle.putBoolean("IsNeedToShowTeamName", z10);
            bundle.putBoolean("IsNeedToShowTeamIcon", z11);
            bundle.putBoolean("game_center_score_tag", z12);
            bundle.putInt("competition_id_tag", i10);
            bundle.putString("state_1", str3);
            bundle.putString("state_2", str2);
            bundle.putBoolean("spinner_key", z13);
            bundle.putBoolean("isTeamStats", z14);
            bundle.putBoolean("isLeagueStats", z15);
            bundle.putBoolean("isTeamNational", z16);
            bundle.putInt(GeneralNotificationListActivity.SPORT_TYPE_TAG, i11);
            bundle.putString("page_key", str6);
            e0Var.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return e0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> B1 = B1();
        this.f21210m = B1;
        return B1;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return this.pageIconLink;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return (getArguments().getBoolean("game_center_score_tag", false) && App.f20803w) ? R.layout.f22690s1 : R.layout.f22678r1;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        try {
            return getArguments().getString("title");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            ld.m mVar = (ld.m) this.f21210m.get(i10);
            getActivity().startActivity(SinglePlayerCardActivity.createSinglePlayerCardActivityIntent(mVar.f34189b.entity.playerId, this.f21209l.competitionObj.getID(), false));
            if (this.f21211n.equals("")) {
                ee.k.o(getActivity().getApplicationContext(), "athlete", "click", null, null, "page", "dashboard", "athlete_id", String.valueOf(mVar.f34189b.entity.playerId));
            } else {
                ee.k.q(App.m(), "athlete", "click", null, true, "athlete_id", String.valueOf(mVar.f34189b.entity.playerId), "page", "showAllstats", "statisticTitle", this.f21213p, "entity_type", AppEventsConstants.EVENT_PARAM_VALUE_YES, "entity_id", String.valueOf(this.f21212o));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        LinearLayout linearLayout;
        if (x0.l1()) {
            linearLayout = (LinearLayout) view.findViewById(R.id.f21985eg);
            this.f21215r = (TextView) view.findViewById(R.id.yx);
            this.f21216s = (TextView) view.findViewById(R.id.wx);
            this.f21217t = (TextView) view.findViewById(R.id.f22279rx);
        } else {
            linearLayout = (LinearLayout) view.findViewById(R.id.f22008fg);
            this.f21215r = (TextView) view.findViewById(R.id.xx);
            this.f21216s = (TextView) view.findViewById(R.id.vx);
            this.f21217t = (TextView) view.findViewById(R.id.qx);
        }
        this.f21215r.setTextColor(p0.A(R.attr.f21565m1));
        this.f21216s.setTextColor(p0.A(R.attr.f21565m1));
        this.f21217t.setTextColor(p0.A(R.attr.f21565m1));
        this.f21215r.setTextSize(1, 13.0f);
        this.f21216s.setTextSize(1, 13.0f);
        this.f21217t.setTextSize(1, 13.0f);
        this.f21215r.setTypeface(o0.b(App.m()));
        this.f21216s.setTypeface(o0.b(App.m()));
        this.f21217t.setTypeface(o0.b(App.m()));
        this.f21215r.setText(p0.l0("COMPETITION_NAME"));
        linearLayout.setVisibility(8);
        this.f21214q = (Spinner) view.findViewById(R.id.Bq);
        this.f21218u = (NestedScrollView) view.findViewById(R.id.Er);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0100 A[Catch: Exception -> 0x010e, TRY_LEAVE, TryCatch #0 {Exception -> 0x010e, blocks: (B:29:0x00e5, B:31:0x0100), top: B:39:0x00e5, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // com.scores365.Design.Pages.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends java.util.Collection> void renderData(T r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.e0.renderData(java.util.Collection):void");
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        try {
            super.updatePageData(obj);
            this.f21209l = (ChartDashboardData) obj;
            LoadDataAsync();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
