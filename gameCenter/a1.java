package com.scores365.gameCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.q;
import com.scores365.R;
import com.scores365.entitys.SetsObj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: TennisSetChooserItem.java */
/* loaded from: classes2.dex */
public class a1 extends com.scores365.Design.PageObjects.b {

    /* renamed from: a  reason: collision with root package name */
    private SetsObj f23707a;

    /* renamed from: b  reason: collision with root package name */
    private int f23708b;

    /* compiled from: TennisSetChooserItem.java */
    /* loaded from: classes2.dex */
    private static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<b> f23709a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<a1> f23710b;

        /* renamed from: c  reason: collision with root package name */
        int f23711c;

        public a(b bVar, a1 a1Var, int i10) {
            this.f23709a = new WeakReference<>(bVar);
            this.f23710b = new WeakReference<>(a1Var);
            this.f23711c = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WeakReference<a1> weakReference;
            try {
                WeakReference<b> weakReference2 = this.f23709a;
                if (weakReference2 == null || weakReference2.get() == null || (weakReference = this.f23710b) == null || weakReference.get() == null) {
                    return;
                }
                this.f23710b.get().f23708b = this.f23711c;
                ((com.scores365.Design.Pages.t) this.f23709a.get()).itemView.callOnClick();
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TennisSetChooserItem.java */
    /* loaded from: classes2.dex */
    public static class b extends com.scores365.Design.Pages.t {

        /* renamed from: f  reason: collision with root package name */
        ArrayList<TextView> f23712f;

        public b(View view, q.e eVar) {
            super(view);
            ArrayList<TextView> arrayList = new ArrayList<>();
            this.f23712f = arrayList;
            try {
                arrayList.add((TextView) ((com.scores365.Design.Pages.t) this).itemView.findViewById(R.id.VD));
                this.f23712f.add((TextView) ((com.scores365.Design.Pages.t) this).itemView.findViewById(R.id.WD));
                this.f23712f.add((TextView) ((com.scores365.Design.Pages.t) this).itemView.findViewById(R.id.XD));
                this.f23712f.add((TextView) ((com.scores365.Design.Pages.t) this).itemView.findViewById(R.id.YD));
                this.f23712f.add((TextView) ((com.scores365.Design.Pages.t) this).itemView.findViewById(R.id.ZD));
                ((com.scores365.Design.Pages.t) this).itemView.setOnClickListener(new com.scores365.Design.Pages.u(this, eVar));
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    public a1(SetsObj setsObj, int i10) {
        this.f23707a = setsObj;
        this.f23708b = i10;
    }

    public static com.scores365.Design.Pages.t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.J9, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.TennisSetChooserItem.ordinal();
    }

    public int m() {
        return this.f23708b;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            b bVar = (b) e0Var;
            int min = Math.min(this.f23707a.getSets().size(), 5);
            for (int i11 = 0; i11 < min; i11++) {
                TextView textView = li.x0.l1() ? bVar.f23712f.get((min - i11) - 1) : bVar.f23712f.get(i11);
                textView.setText(this.f23707a.getSets().get(i11).getName());
                textView.setVisibility(0);
                textView.setSelected(false);
                textView.setOnClickListener(new a(bVar, this, i11));
            }
            if (li.x0.l1()) {
                bVar.f23712f.get((min - this.f23708b) - 1).setSelected(true);
            } else {
                bVar.f23712f.get(this.f23708b).setSelected(true);
            }
            for (int size = this.f23707a.getSets().size(); size < bVar.f23712f.size(); size++) {
                bVar.f23712f.get(size).setVisibility(8);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
