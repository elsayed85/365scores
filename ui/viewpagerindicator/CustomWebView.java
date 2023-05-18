package com.scores365.ui.viewpagerindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class CustomWebView extends WebView {
    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();

    public CustomWebView(Context context) {
        super(context);
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (view.getClass().getName().equals("com.adobe.flashplayer.FlashPaintSurface")) {
            ((SurfaceView) view).setZOrderOnTop(false);
        }
        super.addView(view, i10);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        new Timer().schedule(new TimerTask() { // from class: com.scores365.ui.viewpagerindicator.CustomWebView.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.post(new Runnable() { // from class: com.scores365.ui.viewpagerindicator.CustomWebView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        this.udestroy();
                    }
                });
            }
        }, ZOOM_CONTROLS_TIMEOUT + 1000);
    }

    public void udestroy() {
        super.destroy();
    }
}
