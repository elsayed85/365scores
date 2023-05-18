package com.scores365.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes2.dex */
public class CustomProgressBar extends ProgressBar {
    private boolean inverse;
    private boolean mirror;

    public CustomProgressBar(Context context) {
        super(context);
        this.inverse = false;
        this.mirror = false;
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inverse = false;
        this.mirror = false;
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.inverse = false;
        this.mirror = false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        float height = getHeight() / 2.0f;
        float width = getWidth() / 2.0f;
        if (this.inverse) {
            canvas.rotate(180.0f, width, height);
        }
        if (this.mirror) {
            canvas.scale(-1.0f, 1.0f, width, height);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    public void setInverse() {
        this.inverse = true;
    }

    public void setMirror() {
        this.mirror = true;
    }
}
