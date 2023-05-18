package com.scores365.tournamentPromotion.multi_competitions;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import ji.b;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class MultiCompetitionsActivity extends c {
    private HashMap<CompetitionObj, ArrayList<CompObj>> F;
    private SearchView G;

    /* loaded from: classes2.dex */
    private static final class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<MultiCompetitionsActivity> f24349a;

        public a(MultiCompetitionsActivity multiCompetitionsActivity) {
            this.f24349a = new WeakReference<>(multiCompetitionsActivity);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            Boolean bool = Boolean.FALSE;
            try {
                if (this.f24349a.get() != null) {
                    try {
                        if (this.f24349a.get().getIntent().getExtras().containsKey("com_arr")) {
                            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.f24349a.get().getIntent().getExtras().getByteArray("com_arr")));
                            this.f24349a.get().F = (HashMap) objectInputStream.readObject();
                            objectInputStream.close();
                            bool = Boolean.TRUE;
                        }
                    } catch (IOException | ClassNotFoundException e10) {
                        x0.N1(e10);
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
            return bool;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            try {
                if (!bool.booleanValue() || this.f24349a.get() == null) {
                    return;
                }
                this.f24349a.get().e1();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static void g1(HashMap<CompetitionObj, ArrayList<CompObj>> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            throw new IllegalArgumentException("competitions HashMap _CANNOT_ be null or empty!");
        }
        try {
            Intent intent = new Intent(App.m(), MultiCompetitionsActivity.class);
            intent.addFlags(268435456);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(hashMap);
            intent.putExtra("com_arr", byteArrayOutputStream.toByteArray());
            App.m().startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void e1() {
        try {
            getSupportFragmentManager().q().p(R.id.f21929c6, b.I1(this.F, this.G)).h();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22590k2);
        initActionBar();
        this.G = (SearchView) findViewById(R.id.Ws);
        try {
            new a(this).execute(new Void[0]);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.f22784a, menu);
            MenuItem findItem = menu.findItem(R.id.f22036h);
            findItem.setTitle(p0.l0("SHARE_ITEM"));
            findItem.setVisible(false);
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return true;
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
}
