package com.scores365.Design.Activities;
/* compiled from: PageScrollListener.java */
/* loaded from: classes2.dex */
public interface g {

    /* compiled from: PageScrollListener.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private float f20905a;

        /* renamed from: b  reason: collision with root package name */
        private float f20906b;

        public a(float f10, float f11) {
            this.f20905a = f10;
            this.f20906b = f11;
        }

        public float a() {
            return this.f20906b;
        }

        public float b() {
            return this.f20905a;
        }

        public void c(float f10) {
            this.f20906b = f10;
        }

        public void d(float f10) {
            this.f20905a = f10;
        }
    }

    a onPageScroll(int i10);
}
