package com.scores365.utils;

import android.content.Context;
import b2.b;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.request.i;
import kotlin.jvm.internal.m;
/* compiled from: ScoresGlideModule.kt */
/* loaded from: classes2.dex */
public final class ScoresGlideModule extends q2.a implements d {

    /* compiled from: ScoresGlideModule.kt */
    /* loaded from: classes2.dex */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c.a f24432a;

        a(c.a aVar) {
            this.f24432a = aVar;
        }

        @Override // com.bumptech.glide.manager.m
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.m
        public void onStart() {
            this.f24432a.a(true);
        }

        @Override // com.bumptech.glide.manager.m
        public void onStop() {
        }
    }

    @Override // com.bumptech.glide.manager.d
    public c a(Context context, c.a listener) {
        m.g(context, "context");
        m.g(listener, "listener");
        return new a(listener);
    }

    @Override // q2.a
    public void c(Context context, com.bumptech.glide.d builder) {
        m.g(context, "context");
        m.g(builder, "builder");
        super.c(context, builder);
        builder.d(new i().k(b.PREFER_ARGB_8888));
        builder.b(this);
    }

    @Override // q2.a
    public boolean d() {
        return false;
    }
}
