package com.scores365.gameCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.R;
/* compiled from: TitleWithCardItem.java */
/* loaded from: classes2.dex */
public class b1 extends com.scores365.Design.PageObjects.b {

    /* renamed from: a  reason: collision with root package name */
    private String f23715a;

    /* compiled from: TitleWithCardItem.java */
    /* loaded from: classes2.dex */
    public static class a extends com.scores365.Design.Pages.t {

        /* renamed from: f  reason: collision with root package name */
        private TextView f23716f;

        public a(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.iG);
            this.f23716f = textView;
            textView.setTypeface(li.o0.d(App.m()));
        }
    }

    public b1(String str) {
        this.f23715a = str;
    }

    public static a l(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22723ua, viewGroup, false));
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.TitleWithCardItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getSpanSize() {
        try {
            return com.scores365.Design.Activities.c.fragmentSpanSize;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            a aVar = (a) e0Var;
            aVar.f23716f.setText(this.f23715a);
            if (li.x0.l1()) {
                aVar.f23716f.setGravity(21);
            } else {
                aVar.f23716f.setGravity(19);
            }
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
