package com.scores365.Design.Pages;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.scores365.Design.Pages.q;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import li.x0;
/* compiled from: InfiniteRecyclerAdapter.kt */
/* loaded from: classes2.dex */
public final class l extends c {

    /* renamed from: m  reason: collision with root package name */
    public static final a f20991m = new a(null);

    /* compiled from: InfiniteRecyclerAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(ArrayList<com.scores365.Design.PageObjects.b> listItems, q.e itemClickListener) {
        super(listItems, itemClickListener);
        kotlin.jvm.internal.m.g(listItems, "listItems");
        kotlin.jvm.internal.m.g(itemClickListener, "itemClickListener");
    }

    @Override // com.scores365.Design.Pages.c
    public com.scores365.Design.PageObjects.b A(int i10) {
        com.scores365.Design.PageObjects.b bVar;
        try {
            bVar = super.A(J(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            bVar = null;
        }
        kotlin.jvm.internal.m.d(bVar);
        return bVar;
    }

    @Override // com.scores365.Design.Pages.c
    public int C() {
        try {
            if (this.f20954f != null) {
                return getItemCount() / 2;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return 0;
    }

    public final int J(int i10) {
        try {
            return this.f20954f.size() != 0 ? i10 % this.f20954f.size() : i10;
        } catch (Exception e10) {
            x0.N1(e10);
            return i10;
        }
    }

    @Override // com.scores365.Design.Pages.c, androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f20954f;
            if (arrayList != null) {
                return arrayList.size() * 2 * ModuleDescriptor.MODULE_VERSION;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return 0;
    }

    @Override // com.scores365.Design.Pages.c, androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i10) {
        return super.getItemId(J(i10));
    }

    @Override // com.scores365.Design.Pages.c, androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.e0 holder, int i10) {
        kotlin.jvm.internal.m.g(holder, "holder");
        super.onBindViewHolder(holder, J(i10));
    }
}
