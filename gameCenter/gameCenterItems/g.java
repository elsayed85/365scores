package com.scores365.gameCenter.gameCenterItems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.e1;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.GameObj;
import com.scores365.gameCenter.gameCenterItems.a;
import java.lang.ref.WeakReference;
import li.o0;
import li.x0;
/* compiled from: PlayerStatsHeaderItem.java */
/* loaded from: classes2.dex */
public class g extends com.scores365.Design.PageObjects.b {

    /* renamed from: a  reason: collision with root package name */
    private GameObj f23883a;

    /* renamed from: b  reason: collision with root package name */
    public c f23884b;

    /* renamed from: c  reason: collision with root package name */
    public int f23885c;

    /* compiled from: PlayerStatsHeaderItem.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private c f23886a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<b> f23887b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<g> f23888c;

        public a(c cVar, g gVar, b bVar) {
            this.f23887b = new WeakReference<>(bVar);
            this.f23888c = new WeakReference<>(gVar);
            this.f23886a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WeakReference<b> weakReference;
            try {
                WeakReference<g> weakReference2 = this.f23888c;
                if (weakReference2 == null || weakReference2.get() == null || (weakReference = this.f23887b) == null || weakReference.get() == null) {
                    return;
                }
                this.f23888c.get().f23884b = this.f23886a;
                ((t) this.f23887b.get()).itemView.performClick();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerStatsHeaderItem.java */
    /* loaded from: classes2.dex */
    public static class b extends t {

        /* renamed from: f  reason: collision with root package name */
        private TextView f23890f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f23891g;

        public b(View view, q.e eVar) {
            super(view);
            try {
                this.f23890f = (TextView) view.findViewById(R.id.NA);
                this.f23891g = (TextView) view.findViewById(R.id.iD);
                this.f23890f.setTypeface(o0.d(App.m()));
                this.f23891g.setTypeface(o0.d(App.m()));
                view.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: PlayerStatsHeaderItem.java */
    /* loaded from: classes2.dex */
    public enum c {
        GENERAL(-1),
        HOME(0),
        AWAY(1);
        
        private int value;

        c(int i10) {
            this.value = i10;
        }

        public static c create(int i10) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        return null;
                    }
                    return AWAY;
                }
                return HOME;
            }
            return GENERAL;
        }

        public int getValue() {
            return this.value;
        }

        public a.EnumC0251a toLineupsListType() {
            a.EnumC0251a enumC0251a = null;
            try {
                if (this == HOME) {
                    enumC0251a = a.EnumC0251a.HOME;
                } else if (this == AWAY) {
                    enumC0251a = a.EnumC0251a.AWAY;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return enumC0251a;
        }
    }

    public static b l(ViewGroup viewGroup, q.e eVar) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22671q6, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.PLAYER_STATISTICS_HEADER.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        TextView textView;
        TextView textView2;
        try {
            b bVar = (b) e0Var;
            boolean z10 = true;
            if (x0.l(this.f23885c, true)) {
                textView = bVar.f23891g;
                textView2 = bVar.f23890f;
            } else {
                textView = bVar.f23890f;
                textView2 = bVar.f23891g;
            }
            e1.I0(((t) bVar).itemView, 0);
            textView.setText(this.f23883a.getComps()[0].getShortName());
            textView2.setText(this.f23883a.getComps()[1].getShortName());
            c cVar = c.HOME;
            textView.setOnClickListener(new a(cVar, this, bVar));
            c cVar2 = c.AWAY;
            textView2.setOnClickListener(new a(cVar2, this, bVar));
            textView.setSelected(this.f23884b == cVar);
            if (this.f23884b != cVar2) {
                z10 = false;
            }
            textView2.setSelected(z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
