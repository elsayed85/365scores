package com.scores365.gameCenter.annonymous;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.scores365.App;
import com.scores365.Design.Activities.c;
import com.scores365.R;
import com.scores365.ui.Bet365LandingFragment;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import li.p0;
import li.x0;
import wf.a;
/* loaded from: classes2.dex */
public class AnnonyGameCenterBaseActivity extends c {
    private qf.c F;
    private String G;

    private void d1() {
        try {
            if (getIntent().getExtras().containsKey("GAME_OBJ")) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(getIntent().getExtras().getByteArray("GAME_OBJ")));
                this.F = (qf.c) objectInputStream.readObject();
                objectInputStream.close();
            }
            if (getIntent().getExtras().containsKey("COMPETITION_OBJ")) {
                this.G = getIntent().getExtras().getString("COMPETITION_OBJ");
            }
        } catch (IOException e10) {
            x0.N1(e10);
        } catch (ClassNotFoundException e11) {
            x0.N1(e11);
        }
    }

    public static void e1(qf.c cVar, String str, int i10) {
        try {
            Intent intent = new Intent(App.m(), AnnonyGameCenterBaseActivity.class);
            intent.addFlags(268435456);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(cVar);
            intent.putExtra("GAME_OBJ", byteArrayOutputStream.toByteArray());
            intent.putExtra(Bet365LandingFragment.HOME_AWAY_TEAM_ORDER_KEY, i10);
            intent.putExtra("COMPETITION_OBJ", str);
            App.m().startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22590k2);
        initActionBar();
        d1();
        getSupportFragmentManager().q().p(R.id.f21929c6, a.A1(this.F, this.G, getIntent().getIntExtra(Bet365LandingFragment.HOME_AWAY_TEAM_ORDER_KEY, 1))).h();
    }

    @Override // com.scores365.Design.Activities.c, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.f22785b, menu);
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
