package com.scores365.gameCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.R;
/* compiled from: RankingSwitchItem.java */
/* loaded from: classes2.dex */
public class t0 extends com.scores365.Design.PageObjects.b {

    /* compiled from: RankingSwitchItem.java */
    /* loaded from: classes2.dex */
    public static class a extends com.scores365.Design.Pages.t {

        /* renamed from: f  reason: collision with root package name */
        private TextView f24054f;

        /* renamed from: g  reason: collision with root package name */
        private SwitchCompat f24055g;

        public a(View view, q.e eVar) {
            super(view);
            this.f24055g = (SwitchCompat) view.findViewById(R.id.sm);
            TextView textView = (TextView) view.findViewById(R.id.tm);
            this.f24054f = textView;
            textView.setTypeface(li.o0.d(App.m()));
            if (li.x0.l1()) {
                ((com.scores365.Design.Pages.t) this).itemView.setLayoutDirection(1);
                this.f24054f.setGravity(5);
            } else {
                ((com.scores365.Design.Pages.t) this).itemView.setLayoutDirection(0);
                this.f24054f.setGravity(3);
            }
            ((com.scores365.Design.Pages.t) this).itemView.setOnClickListener(new com.scores365.Design.Pages.u(this, eVar));
        }

        @Override // com.scores365.Design.Pages.t
        public boolean isSupportRTL() {
            return true;
        }
    }

    public static a l(ViewGroup viewGroup, q.e eVar) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22595k7, viewGroup, false), eVar);
    }
}
