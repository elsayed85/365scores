package com.scores365.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class RequestUserEmailActivity extends com.scores365.Design.Activities.d implements View.OnClickListener {
    public static final int REQUEST_USER_EMAIL_ACTIVITY_CODE = 428;

    private void handleUserAction() {
        try {
            String str = "allow";
            if (androidx.core.content.a.checkSelfPermission(this, "android.permission.GET_ACCOUNTS") == 0) {
                setResult(-1);
            } else {
                setResult(0);
                str = "deny";
            }
            ee.k.n(App.m(), "app", "user-permission", "pop-up", "click", true, ShareConstants.FEED_SOURCE_PARAM, "sync", "permission_type", "contacts", "click_type", str);
            finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setGotItText(TextView textView) {
        textView.setText(p0.l0("GOT_IT_FOR_POPUPS"));
        textView.setOnClickListener(this);
        textView.setTypeface(o0.d(App.m()));
    }

    private void setNoText(TextView textView) {
        SpannableString spannableString = new SpannableString(p0.l0("NO_THANKS_FOR_POPUPS"));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        textView.setText(spannableString);
        textView.setOnClickListener(this);
        textView.setTypeface(o0.d(App.m()));
    }

    private void setTitleText(TextView textView) {
        try {
            String l02 = p0.l0("ACCESS_PERMISSION_POPUP");
            int indexOf = l02.indexOf("#");
            int lastIndexOf = l02.lastIndexOf("#");
            if (indexOf == -1 || lastIndexOf == -1) {
                textView.setText(l02);
            } else {
                SpannableString spannableString = new SpannableString(l02.replaceAll("#", ""));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.f21614d)), indexOf, lastIndexOf - 1, 33);
                textView.setText(spannableString);
            }
            textView.setTypeface(o0.d(App.m()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        try {
            int id2 = view.getId();
            if (id2 == R.id.jA) {
                androidx.core.app.b.g(this, new String[]{"android.permission.GET_ACCOUNTS"}, REQUEST_USER_EMAIL_ACTIVITY_CODE);
                str = "got-it";
            } else if (id2 == R.id.MB) {
                setResult(0);
                str = "no-thanks";
                finish();
            } else {
                str = null;
            }
            if (str != null) {
                ee.k.n(App.m(), "app", "user-permission", "pop-up", "click", true, ShareConstants.FEED_SOURCE_PARAM, "sync", "permission_type", "contacts", "click_type", str);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22732v7);
        try {
            setTitleText((TextView) findViewById(R.id.YG));
            setGotItText((TextView) findViewById(R.id.jA));
            setNoText((TextView) findViewById(R.id.MB));
            ee.k.n(App.m(), "app", "user-permission", "pop-up", "show", false, ShareConstants.FEED_SOURCE_PARAM, "sync", "permission_type", "contacts");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 != 428) {
            return;
        }
        try {
            handleUserAction();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
