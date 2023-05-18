package com.scores365.dashboard.search;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.api.n0;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.RelatedEntities;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import li.p0;
import li.x0;
import nb.v;
/* loaded from: classes2.dex */
public class ViewAllPopularEntitiesActivity extends c {
    private ArrayList<BaseObj> F;
    private RelatedEntities G;
    private int H = -1;
    private View I;

    /* loaded from: classes2.dex */
    public static class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        int f23388a;

        /* renamed from: b  reason: collision with root package name */
        boolean f23389b;

        /* renamed from: c  reason: collision with root package name */
        String f23390c;

        /* renamed from: d  reason: collision with root package name */
        WeakReference<d> f23391d;

        /* renamed from: e  reason: collision with root package name */
        String f23392e;

        public a(int i10, boolean z10, String str, d dVar, String str2) {
            this.f23388a = i10;
            this.f23389b = z10;
            this.f23390c = str;
            this.f23391d = new WeakReference<>(dVar);
            this.f23392e = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            boolean z10;
            int i10;
            ArrayList<BaseObj> f10;
            boolean z11 = false;
            int i11 = -1;
            try {
                d dVar = this.f23391d.get();
                if (dVar != null && dVar.getIntent() != null) {
                    z11 = dVar.getIntent().getBooleanExtra("isOnboardingContext", false);
                    i11 = dVar.getIntent().getIntExtra("sportId", -1);
                }
                z10 = z11;
                i10 = i11;
            } catch (Exception e10) {
                x0.N1(e10);
                z10 = z11;
                i10 = -1;
            }
            ArrayList<BaseObj> arrayList = new ArrayList<>();
            try {
                n0 n0Var = new n0(this.f23388a, this.f23390c, false, i10, -1, this.f23392e, z10);
                n0Var.call();
                arrayList.addAll(n0Var.e());
                if (this.f23388a == 6 && (f10 = n0Var.f(3)) != null) {
                    arrayList.addAll(f10);
                }
                WeakReference<d> weakReference = this.f23391d;
                if (weakReference == null || weakReference.get() == null) {
                    return null;
                }
                ViewAllPopularEntitiesActivity viewAllPopularEntitiesActivity = (ViewAllPopularEntitiesActivity) this.f23391d.get();
                viewAllPopularEntitiesActivity.o1(arrayList);
                viewAllPopularEntitiesActivity.m1(n0Var.a());
                viewAllPopularEntitiesActivity.q1(n0Var.b().getRelatedEntities());
                return null;
            } catch (Exception e11) {
                x0.N1(e11);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r52) {
            super.onPostExecute(r52);
            try {
                WeakReference<d> weakReference = this.f23391d;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ViewAllPopularEntitiesActivity viewAllPopularEntitiesActivity = (ViewAllPopularEntitiesActivity) this.f23391d.get();
                viewAllPopularEntitiesActivity.k1(this.f23388a, viewAllPopularEntitiesActivity.getIntent().getIntExtra("sportId", -1));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static Intent h1(int i10, ArrayList<BaseObj> arrayList, boolean z10, int i11, boolean z11, int i12, boolean z12, boolean z13, int i13, String str, boolean z14, CountryObj[] countryObjArr) {
        Intent intent = new Intent(App.m(), ViewAllPopularEntitiesActivity.class);
        try {
            intent.putExtra("dataTypeKey", i10);
            if (arrayList != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(arrayList);
                intent.putExtra("entityListTag", byteArrayOutputStream.toByteArray());
            }
            if (countryObjArr != null) {
                RelatedEntities relatedEntities = new RelatedEntities();
                relatedEntities.setCountries(countryObjArr);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream2).writeObject(relatedEntities);
                intent.putExtra("relatedEntitiesTag", byteArrayOutputStream2.toByteArray());
            }
            intent.putExtra("favouriteTag", z10);
            intent.putExtra("locationTag", i11);
            intent.putExtra("isPopularContextTag", z11);
            intent.putExtra("sportId", i12);
            intent.putExtra("is_lead_form", z13);
            intent.putExtra("lead_form_selected", i13);
            intent.putExtra("", z12);
            intent.putExtra("titleTag", str);
            intent.putExtra("isOnboardingContext", z14);
        } catch (IOException e10) {
            x0.N1(e10);
        }
        return intent;
    }

    public static Intent i1(int i10, boolean z10, String str, int i11, int i12, boolean z11, int i13, String str2, boolean z12, String str3) {
        Intent intent = new Intent(App.m(), ViewAllPopularEntitiesActivity.class);
        try {
            intent.putExtra("dataTypeKey", i10);
            intent.putExtra("limtSearch", z10);
            intent.putExtra("searchStringText", str);
            intent.putExtra("sportId", i11);
            intent.putExtra("is_lead_form", z11);
            intent.putExtra("lead_form_selected", i13);
            intent.putExtra("locationTag", i12);
            intent.putExtra("titleTag", str2);
            intent.putExtra("isOnboardingContext", z12);
            intent.putExtra("requestUrl", str3);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(int i10, int i11) {
        try {
            boolean booleanExtra = getIntent().getBooleanExtra("favouriteTag", false);
            boolean booleanExtra2 = getIntent().getBooleanExtra("isPopularContextTag", false);
            boolean booleanExtra3 = getIntent().getBooleanExtra("", false);
            getSupportFragmentManager().q().q(R.id.f21973e4, com.scores365.dashboard.search.a.z1(i10, this.F, this.G, i11, booleanExtra, this.H, getIntent().getIntExtra("locationTag", -1), booleanExtra2, booleanExtra3, getIntent().getBooleanExtra("is_lead_form", false), getIntent().getIntExtra("lead_form_selected", -1), getIntent().getBooleanExtra("isOnboardingContext", false)), "ViewAllEntitiesFragment").h();
            e1.C0(this.toolbar, p0.s(4));
            d1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void r1() {
        if (this.toolbar != null) {
            for (int i10 = 0; i10 < this.toolbar.getChildCount(); i10++) {
                View childAt = this.toolbar.getChildAt(i10);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(v.m());
                }
            }
        }
    }

    protected void d1() {
        try {
            View view = this.I;
            if (view != null) {
                view.setVisibility(8);
            }
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    protected void e1() {
        try {
            View view = this.I;
            if (view != null) {
                view.setVisibility(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    public void m1(int i10) {
        this.H = i10;
    }

    public void o1(ArrayList<BaseObj> arrayList) {
        this.F = arrayList;
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            Intent intent = new Intent();
            intent.putExtra(com.scores365.dashboard.search.a.f23393o, ((com.scores365.dashboard.search.a) getSupportFragmentManager().i0(R.id.f21973e4)).f23397l);
            try {
                if (getIntent().getBooleanExtra("is_lead_form", false)) {
                    intent.putExtra("lead_form_selected", getIntent().getIntExtra("lead_form_selected", -1));
                    intent.putExtra("team_object", getIntent().getSerializableExtra("team_object"));
                    intent.putExtra(com.scores365.dashboard.search.a.f23393o, true);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            setResult(-1, intent);
            super.onBackPressed();
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22724v);
        this.I = findViewById(R.id.Jn);
        e1();
        initActionBar();
        try {
            x0.D1(this);
            int intExtra = getIntent().getIntExtra("dataTypeKey", getIntent().getIntExtra("dataTypeKey", -1));
            boolean booleanExtra = getIntent().getBooleanExtra("limtSearch", false);
            int intExtra2 = getIntent().getIntExtra("sportId", -1);
            String stringExtra = getIntent().getStringExtra("searchStringText");
            String stringExtra2 = getIntent().getStringExtra("requestUrl");
            if (getIntent().getExtras().containsKey("relatedEntitiesTag")) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(getIntent().getExtras().getByteArray("relatedEntitiesTag")));
                q1((RelatedEntities) objectInputStream.readObject());
                objectInputStream.close();
            }
            if (getIntent().getExtras().containsKey("entityListTag")) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(getIntent().getExtras().getByteArray("entityListTag")));
                this.F = (ArrayList) objectInputStream2.readObject();
                objectInputStream2.close();
                k1(intExtra, intExtra2);
            } else {
                new a(intExtra, booleanExtra, stringExtra, this, stringExtra2).execute(new Void[0]);
            }
            String stringExtra3 = getIntent().getStringExtra("titleTag");
            if (stringExtra3 != null) {
                this.toolbar.setTitle(stringExtra3);
                this.toolbar.setTitleTextColor(p0.A(R.attr.B1));
                r1();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void q1(RelatedEntities relatedEntities) {
        this.G = relatedEntities;
    }
}
