package com.scores365.Design.Pages;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.q;
import java.lang.ref.WeakReference;
import li.x0;
/* compiled from: RecyclerViewItemClickImplementation.java */
/* loaded from: classes2.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<q.e> f21005a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<RecyclerView.e0> f21006b;

    public u(RecyclerView.e0 e0Var, q.e eVar) {
        this.f21005a = new WeakReference<>(eVar);
        this.f21006b = new WeakReference<>(e0Var);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            q.e eVar = this.f21005a.get();
            RecyclerView.e0 e0Var = this.f21006b.get();
            if (eVar == null || e0Var == null) {
                return;
            }
            eVar.OnRecylerItemClick(e0Var.getAdapterPosition());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
