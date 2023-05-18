package com.scores365.Pages.Standings;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.api.g;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GamesObj;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import li.x0;
/* loaded from: classes2.dex */
public class GroupsAllFixturesActivity extends c {
    private CompetitionObj F;
    private GamesObj G;
    String H;
    String I;

    /* renamed from: b0  reason: collision with root package name */
    int f21161b0;

    /* renamed from: f0  reason: collision with root package name */
    int f21162f0;

    /* renamed from: g0  reason: collision with root package name */
    int f21163g0;

    /* loaded from: classes2.dex */
    private static final class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<GroupsAllFixturesActivity> f21164a;

        public a(GroupsAllFixturesActivity groupsAllFixturesActivity) {
            this.f21164a = new WeakReference<>(groupsAllFixturesActivity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            Boolean bool = Boolean.FALSE;
            try {
                if (this.f21164a.get() != null) {
                    try {
                        if (this.f21164a.get().getIntent().getExtras().containsKey("competition_")) {
                            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.f21164a.get().getIntent().getExtras().getByteArray("competition_")));
                            this.f21164a.get().F = (CompetitionObj) objectInputStream.readObject();
                            objectInputStream.close();
                            bool = Boolean.TRUE;
                        }
                        this.f21164a.get().H = this.f21164a.get().getIntent().getExtras().getString("page_title_");
                        this.f21164a.get().f21162f0 = this.f21164a.get().getIntent().getExtras().getInt("group_");
                        this.f21164a.get().f21161b0 = this.f21164a.get().getIntent().getExtras().getInt("Sassonnn al titen lo shom davar!..");
                        this.f21164a.get().I = this.f21164a.get().getIntent().getExtras().getString("stage_name_");
                        this.f21164a.get().f21163g0 = this.f21164a.get().getIntent().getExtras().getInt("stage_");
                        g gVar = new g(App.m(), this.f21164a.get().F.getID(), this.f21164a.get().f21163g0, this.f21164a.get().f21161b0, this.f21164a.get().f21162f0);
                        gVar.call();
                        this.f21164a.get().G = gVar.a();
                        return gVar.a() != null ? Boolean.TRUE : bool;
                    } catch (Exception e10) {
                        x0.N1(e10);
                        return bool;
                    }
                }
                return bool;
            } catch (Exception e11) {
                x0.N1(e11);
                return bool;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            try {
                if (this.f21164a.get() != null) {
                    this.f21164a.get().k1(8);
                }
                if (!bool.booleanValue() || this.f21164a.get() == null) {
                    return;
                }
                this.f21164a.get().i1();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            if (this.f21164a.get() != null) {
                this.f21164a.get().k1(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        try {
            getSupportFragmentManager().q().p(R.id.f21929c6, id.a.y1(this.G, this.F)).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void m1(String str, CompetitionObj competitionObj, String str2, int i10, int i11, int i12, int i13) {
        Bundle bundle = new Bundle();
        try {
            Intent intent = new Intent(App.m(), GroupsAllFixturesActivity.class);
            intent.addFlags(268435456);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(competitionObj);
                bundle.putByteArray("competition_", byteArrayOutputStream.toByteArray());
            } catch (IOException e10) {
                x0.N1(e10);
            }
            bundle.putString("page_title_", str);
            bundle.putString("stage_name_", str2);
            bundle.putInt("Sassonnn al titen lo shom davar!..", i11);
            bundle.putInt("group_", i12);
            bundle.putInt("stage_", i13);
            intent.putExtras(bundle);
            App.m().startActivity(intent);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return getIntent().getExtras().containsKey("page_title_") ? getIntent().getExtras().getString("page_title_") : "";
    }

    public void k1(int i10) {
        try {
            findViewById(R.id.Jn).setVisibility(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22590k2);
        initActionBar();
        try {
            new a(this).execute(new Void[0]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.f22784a, menu);
            menu.findItem(R.id.f22036h).setVisible(false);
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        onBackPressed();
        return true;
    }
}
