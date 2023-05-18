package com.scores365.Design.PageObjects;

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
import java.lang.ref.WeakReference;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: GeneralChooserItem.java */
/* loaded from: classes2.dex */
public class e extends com.scores365.Design.PageObjects.b {
    public static final int TAB_1 = 1;
    public static final int TAB_2 = 2;
    public static final int TAB_3 = 3;
    protected float cardSideMargin;
    protected int chosenTab;
    protected boolean isHeadToHeadItem;
    protected boolean shouldHaveCardBackground;
    public boolean shouldReverse;
    protected String tab1Text;
    protected String tab2Text;
    protected String tab3Text;

    /* compiled from: GeneralChooserItem.java */
    /* loaded from: classes2.dex */
    private static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<b> f20909a;

        /* renamed from: b  reason: collision with root package name */
        private int f20910b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<e> f20911c;

        public a(e eVar, int i10, b bVar) {
            this.f20910b = i10;
            this.f20909a = new WeakReference<>(bVar);
            this.f20911c = new WeakReference<>(eVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                WeakReference<e> weakReference = this.f20911c;
                e eVar = (weakReference == null || weakReference.get() == null) ? null : this.f20911c.get();
                WeakReference<b> weakReference2 = this.f20909a;
                b bVar = weakReference2 != null ? weakReference2.get() : null;
                if (eVar == null || bVar == null) {
                    return;
                }
                this.f20911c.get().chosenTab = this.f20910b;
                ((t) bVar).itemView.performClick();
                ((t) bVar).itemView.setSoundEffectsEnabled(false);
                e.setSelectedTab(eVar.getTab1TextView(bVar), eVar.getTab2TextView(bVar), eVar.getTab3TextView(bVar), this.f20910b);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: GeneralChooserItem.java */
    /* loaded from: classes2.dex */
    public static class b extends t {

        /* renamed from: f  reason: collision with root package name */
        public TextView f20912f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f20913g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20914h;

        public b(View view, q.e eVar) {
            super(view);
            try {
                view.setOnClickListener(new u(this, eVar));
                this.f20913g = (TextView) view.findViewById(R.id.Fw);
                this.f20912f = (TextView) view.findViewById(R.id.NA);
                this.f20914h = (TextView) view.findViewById(R.id.iD);
                this.f20912f.setTypeface(o0.d(App.m()));
                this.f20913g.setTypeface(o0.d(App.m()));
                this.f20914h.setTypeface(o0.d(App.m()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public e(String str, String str2, String str3, int i10, boolean z10, boolean z11, float f10, boolean z12) {
        this.tab1Text = str;
        this.tab2Text = str2;
        this.tab3Text = str3;
        this.chosenTab = i10;
        this.shouldReverse = z10;
        this.shouldHaveCardBackground = z11;
        this.cardSideMargin = f10;
        this.isHeadToHeadItem = z12;
    }

    public static b onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22513e3, viewGroup, false), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setSelectedTab(TextView textView, TextView textView2, TextView textView3, int i10) {
        try {
            textView.setSelected(false);
            textView2.setSelected(false);
            textView3.setSelected(false);
            if (i10 == 1) {
                textView.setSelected(true);
            } else if (i10 == 2) {
                textView2.setSelected(true);
            } else if (i10 == 3) {
                textView3.setSelected(true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public int getChosenTab() {
        return this.chosenTab;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.generalChooserItem.ordinal();
    }

    public String getTab1Text() {
        return this.tab1Text;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getTab1TextView(b bVar) {
        try {
            return this.shouldReverse ? bVar.f20914h : bVar.f20912f;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getTab2Text() {
        return this.tab2Text;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getTab2TextView(b bVar) {
        try {
            return bVar.f20913g;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public String getTab3Text() {
        return this.tab3Text;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getTab3TextView(b bVar) {
        try {
            return this.shouldReverse ? bVar.f20912f : bVar.f20914h;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            b bVar = (b) e0Var;
            TextView tab1TextView = getTab1TextView(bVar);
            TextView tab2TextView = getTab2TextView(bVar);
            TextView tab3TextView = getTab3TextView(bVar);
            if (x0.l1() && this.isHeadToHeadItem) {
                tab3TextView = tab1TextView;
                tab1TextView = tab3TextView;
            }
            tab1TextView.setText(getTab1Text());
            tab2TextView.setText(getTab2Text());
            tab3TextView.setText(getTab3Text());
            tab1TextView.setTypeface(o0.d(App.m()));
            tab2TextView.setTypeface(o0.d(App.m()));
            tab3TextView.setTypeface(o0.d(App.m()));
            tab1TextView.setOnClickListener(new a(this, 1, bVar));
            tab2TextView.setOnClickListener(new a(this, 2, bVar));
            tab3TextView.setOnClickListener(new a(this, 3, bVar));
            setSelectedTab(tab1TextView, tab2TextView, tab3TextView, this.chosenTab);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((t) bVar).itemView.getLayoutParams();
            if (this.shouldHaveCardBackground) {
                ((t) bVar).itemView.setBackgroundResource(p0.w(App.m(), R.attr.f21557k));
                marginLayoutParams.leftMargin = Math.round(this.cardSideMargin);
                marginLayoutParams.rightMargin = Math.round(this.cardSideMargin);
                e1.C0(((t) bVar).itemView, App.m().getResources().getDimension(androidx.cardview.R.dimen.f3942a));
                return;
            }
            ((t) bVar).itemView.setBackgroundResource(0);
            marginLayoutParams.leftMargin = 0;
            marginLayoutParams.rightMargin = 0;
            e1.C0(((t) bVar).itemView, 0.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setChosenTab(int i10) {
        this.chosenTab = i10;
    }
}
