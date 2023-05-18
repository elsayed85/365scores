package com.scores365.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.scores365.App;
/* compiled from: ImageHandler.kt */
/* loaded from: classes2.dex */
public final class ImageHandler {
    private final ImageView imageView;
    private final Drawable placeHolder;
    private final com.bumptech.glide.request.h<Bitmap> requestListener;
    private final s2.i<Bitmap> target;
    private final String url;
    private final boolean useRoundMask;

    public ImageHandler(String url, ImageView imageView, Drawable drawable, s2.i<Bitmap> iVar, boolean z10, com.bumptech.glide.request.h<Bitmap> hVar) {
        kotlin.jvm.internal.m.g(url, "url");
        this.url = url;
        this.imageView = imageView;
        this.placeHolder = drawable;
        this.target = iVar;
        this.useRoundMask = z10;
        this.requestListener = hVar;
    }

    public final void handle() {
        com.bumptech.glide.request.i iVar = new com.bumptech.glide.request.i();
        Drawable drawable = this.placeHolder;
        if (drawable != null) {
            iVar.Z(drawable);
        }
        if (this.useRoundMask) {
            iVar.c();
        }
        ImageView imageView = this.imageView;
        com.bumptech.glide.l t10 = imageView == null ? com.bumptech.glide.c.t(App.m()) : com.bumptech.glide.c.u(imageView);
        kotlin.jvm.internal.m.f(t10, "if (imageView == null) G…lse Glide.with(imageView)");
        com.bumptech.glide.k<Bitmap> I0 = t10.b().I0(this.url);
        I0.a(iVar);
        I0.O0(com.bumptech.glide.b.f(17432576));
        I0.E0(this.requestListener);
        s2.i<Bitmap> iVar2 = this.target;
        if (iVar2 != null) {
            I0.z0(iVar2);
            return;
        }
        ImageView imageView2 = this.imageView;
        if (imageView2 != null) {
            I0.C0(imageView2);
        }
    }
}
