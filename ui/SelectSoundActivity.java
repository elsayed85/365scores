package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.flurry.android.FlurryAgent;
import com.scores365.App;
import com.scores365.R;
import java.util.HashMap;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SelectSoundActivity extends com.scores365.Design.Activities.c implements View.OnClickListener {
    public static final int DEFAULT_SOUND_ID = -2;
    public static String EXTRA_SOURCE = "source_tag";
    TextView notificationNameView;
    SelectSoundFragment selectSoundFragment;
    TextView submitButton;
    TextView titleView;

    public static Intent getActivityIntent(Context context, int i10, int i11, String str, int i12, int i13, String str2) {
        Intent intent = new Intent(context, SelectSoundActivity.class);
        try {
            intent.putExtra(SelectSoundFragment.SOUND_ID_TAG, i10);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, i11);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_NAME_TAG, str);
            intent.putExtra(SelectSoundFragment.ENTITY_TYPE_FOR_ANALYTICS, i12);
            intent.putExtra(NotificationListActivity.EXTRA_SOURCE, str2);
            intent.putExtra(NotificationListActivity.ENTITY_EXTRA_ID, i13);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    public static Intent getActivityIntent(Context context, int i10, int i11, String str, String str2) {
        Intent intent = new Intent(context, SelectSoundActivity.class);
        try {
            intent.putExtra(SelectSoundFragment.SOUND_ID_TAG, i10);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, i11);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_NAME_TAG, str);
            intent.putExtra(SelectSoundFragment.ENTITY_TYPE_FOR_ANALYTICS, -1);
            intent.putExtra(NotificationListActivity.EXTRA_SOURCE, str2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    public static Intent getActivityIntent(Context context, int i10, int i11, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, SelectSoundActivity.class);
        try {
            intent.putExtra(SelectSoundFragment.SOUND_ID_TAG, i10);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, i11);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_NAME_TAG, str2);
            intent.putExtra(SelectSoundFragment.ENTITY_TYPE_FOR_ANALYTICS, str);
            intent.putExtra(NotificationListActivity.EXTRA_SOURCE, str3);
            intent.putExtra(NotificationListActivity.ENTITY_EXTRA_ID, str4);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    private String getSource() {
        try {
            return getIntent().getStringExtra(EXTRA_SOURCE);
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private void handleAnalyticsForSound(String str, boolean z10, String str2, int i10, int i11) {
        HashMap hashMap = new HashMap();
        hashMap.put("entity_type", str);
        hashMap.put("entity_id", str2);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, getSource());
        hashMap.put("is_changed", z10 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        hashMap.put("notification_type_id", Integer.valueOf(i10));
        hashMap.put("sound_id", Integer.valueOf(i11));
        ee.k.k(App.m(), "notification", "sound", "click", null, hashMap);
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int selectedSoundId = ((SelectSoundFragment) getSupportFragmentManager().i0(R.id.f22043h6)).getSelectedSoundId();
            String stringExtra = getIntent().getStringExtra(SelectSoundFragment.ENTITY_TYPE_FOR_ANALYTICS);
            String stringExtra2 = getIntent().getStringExtra(NotificationListActivity.ENTITY_EXTRA_ID);
            boolean isDirty = ((SelectSoundFragment) getSupportFragmentManager().i0(R.id.f22043h6)).isDirty();
            int intExtra = getIntent().getIntExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, -1);
            handleAnalyticsForSound(stringExtra, isDirty, stringExtra2, intExtra, selectedSoundId);
            Intent intent = new Intent();
            intent.putExtra(SelectSoundFragment.SOUND_ID_TAG, selectedSoundId);
            intent.putExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, intExtra);
            setResult(-1, intent);
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (x0.n1()) {
                setTheme(R.style.f22837l);
            } else {
                setTheme(R.style.f22836k);
            }
            setContentView(R.layout.f22712u);
            TextView textView = (TextView) findViewById(R.id.Cx);
            this.titleView = textView;
            textView.setText(p0.l0("NEW_DASHBAORD_CHOOSE_SOUND"));
            this.titleView.setTypeface(o0.d(App.m()));
            TextView textView2 = (TextView) findViewById(R.id.SB);
            this.notificationNameView = textView2;
            textView2.setTypeface(o0.d(App.m()));
            this.notificationNameView.setText(getIntent().getStringExtra(SelectSoundFragment.NOTIFICATION_NAME_TAG));
            TextView textView3 = (TextView) findViewById(R.id.pz);
            this.submitButton = textView3;
            textView3.setTypeface(o0.d(App.m()));
            this.submitButton.setText(p0.l0("NEW_DASHBAORD_SAVE_SOUND"));
            this.submitButton.setOnClickListener(this);
            try {
                Intent intent = getIntent();
                this.selectSoundFragment = SelectSoundFragment.newInstance(intent.getIntExtra(SelectSoundFragment.SOUND_ID_TAG, -2), intent.getIntExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, -1));
                getSupportFragmentManager().q().p(R.id.f22043h6, this.selectSoundFragment).h();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        } catch (Exception e11) {
            x0.N1(e11);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            FlurryAgent.onStartSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            FlurryAgent.onEndSession(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    protected boolean shouldSetTheme() {
        return false;
    }
}
