package com.scores365.gameCenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import java.io.FileInputStream;
/* loaded from: classes2.dex */
public class GameCenterSubMenuTutorialActivity extends com.scores365.Design.Activities.d implements View.OnClickListener {
    ImageView F;
    ImageView G;
    TextView H;
    boolean I = false;

    private void a1() {
        try {
            Intent intent = new Intent();
            intent.putExtra("moveToPageFromTutorial", true);
            setResult(-1, intent);
            finish();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void d1() {
        try {
            if (this.I) {
                return;
            }
            ee.k.n(App.m(), "app", "tutorial", "click", null, false, "screen", "play-by-play", ShareConstants.FEED_SOURCE_PARAM, "close");
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void e1() {
        try {
            ee.k.n(App.m(), "app", "tutorial", "click", null, false, "screen", "play-by-play", ShareConstants.FEED_SOURCE_PARAM, "try-it");
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    private void g1() {
        try {
            ee.k.n(App.m(), "app", "tutorial", ServerProtocol.DIALOG_PARAM_DISPLAY, null, false, "screen", "play-by-play");
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    public void b1(Bitmap bitmap) {
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int p10 = (int) (App.p() * 0.8d);
            attributes.height = (bitmap.getHeight() * p10) / bitmap.getWidth();
            attributes.width = p10;
            getWindow().setAttributes(attributes);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 == R.id.F3) {
                finish();
            } else if (id2 == R.id.st) {
                e1();
                this.I = true;
                a1();
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setTheme(R.style.f22826a);
            setContentView(R.layout.f22522f);
            this.F = (ImageView) findViewById(R.id.F3);
            this.G = (ImageView) findViewById(R.id.tt);
            TextView textView = (TextView) findViewById(R.id.st);
            this.H = textView;
            textView.setTextSize(1, 15.0f);
            this.H.setTextColor(li.p0.A(R.attr.T0));
            this.F.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.H.setText(getIntent().getStringExtra("tryIt"));
            g1();
            Bitmap bitmap = null;
            try {
                FileInputStream openFileInput = openFileInput(getIntent().getStringExtra("Bitmap_Image_Filename"));
                bitmap = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                this.G.setImageBitmap(bitmap);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            b1(bitmap);
            setFinishOnTouchOutside(true);
            if (li.x0.l1()) {
                ImageView imageView = this.F;
                if (imageView != null) {
                    ((ConstraintLayout.b) imageView.getLayoutParams()).f4622e = -1;
                }
            } else {
                ImageView imageView2 = this.F;
                if (imageView2 != null) {
                    ((ConstraintLayout.b) imageView2.getLayoutParams()).f4628h = -1;
                }
            }
            sf.b.X1().pa(bg.e.valueOf(getIntent().getStringExtra("SubMenuType")));
        } catch (Exception e11) {
            li.x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.h, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            d1();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
