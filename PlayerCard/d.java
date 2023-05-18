package com.scores365.PlayerCard;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import ee.k;
import java.util.LinkedHashMap;
import li.o0;
import li.p0;
import li.u;
import li.x0;
import nb.o;
import nb.p;
/* compiled from: SinglePlayerCareerSpinnerAdapter.java */
/* loaded from: classes2.dex */
public class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final int f21383a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21384b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f21385c = 0;

    /* renamed from: d  reason: collision with root package name */
    LinkedHashMap<Integer, b> f21386d;

    /* compiled from: SinglePlayerCareerSpinnerAdapter.java */
    /* loaded from: classes2.dex */
    public static class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        int f21387a;

        public a(int i10) {
            this.f21387a = i10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    k.n(App.m(), "athlete", "stats", "filter", "click", true, "athlete_id", String.valueOf(this.f21387a));
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return false;
        }
    }

    public d(LinkedHashMap<Integer, b> linkedHashMap, int i10) {
        new LinkedHashMap();
        this.f21386d = linkedHashMap;
        this.f21383a = i10;
    }

    private View a(int i10, View view, ViewGroup viewGroup, int i11) {
        View inflate;
        TextView textView;
        ImageView imageView;
        View view2 = null;
        String x10 = null;
        if (view == null) {
            try {
                inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
            } catch (Exception e10) {
                e = e10;
                x0.N1(e);
                return view2;
            }
        } else {
            inflate = view;
        }
        try {
            textView = (TextView) inflate.findViewById(R.id.Ox);
            imageView = (ImageView) inflate.findViewById(R.id.f22159mb);
            textView.setTypeface(o0.d(App.m()));
        } catch (Exception e11) {
            e = e11;
        }
        try {
            b bVar = this.f21386d.get(Integer.valueOf(i10));
            if (bVar == null) {
                textView.setText("");
                return inflate;
            }
            textView.setText(bVar.c());
            textView.setTextColor(p0.A(R.attr.U0));
            imageView.setVisibility(8);
            if (bVar.f21378e) {
                App.c y02 = x0.y0(bVar.f21379f);
                if (y02 == App.c.LEAGUE) {
                    x10 = o.x(x0.n1() ? p.CompetitionsLight : p.Competitions, bVar.b(), 100, 100, false, p.CountriesRoundFlags, -1, String.valueOf(-1));
                } else if (y02 == App.c.TEAM) {
                    x10 = o.x(p.Competitors, bVar.b(), 100, 100, false, null, -1, String.valueOf(-1));
                }
                if (x10 != null) {
                    imageView.setVisibility(0);
                    u.A(x10, imageView, p0.K(R.attr.f21594w0));
                    return inflate;
                }
                return inflate;
            }
            return inflate;
        } catch (Exception e12) {
            e = e12;
            view2 = inflate;
            x0.N1(e);
            return view2;
        }
    }

    private int b() {
        try {
            return x0.l1() ? R.layout.f22531f8 : R.layout.f22518e8;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    public void c(boolean z10) {
        if (getCount() > 1) {
            this.f21384b = z10;
        }
    }

    public void d(int i10) {
        this.f21385c = i10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        try {
            LinkedHashMap<Integer, b> linkedHashMap = this.f21386d;
            if (linkedHashMap != null) {
                return linkedHashMap.size();
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        View view2 = null;
        try {
            view2 = a(i10, view, viewGroup, b());
            if (i10 == this.f21385c) {
                view2.setBackgroundColor(p0.A(R.attr.f21557k));
            } else {
                view2.setBackgroundColor(p0.A(R.attr.f21547g1));
            }
            view2.findViewById(R.id.G4).setVisibility(0);
            ((ImageView) view2.findViewById(R.id.f22072id)).setVisibility(8);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        try {
            return this.f21386d.get(Integer.valueOf(i10));
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        try {
            b bVar = this.f21386d.get(Integer.valueOf(i10));
            if (bVar != null) {
                return bVar.b();
            }
            return -1L;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1L;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2 = null;
        try {
            view2 = a(i10, view, viewGroup, b());
            view2.setBackgroundResource(0);
            ImageView imageView = (ImageView) view2.findViewById(R.id.f22072id);
            TextView textView = (TextView) view2.findViewById(R.id.Ox);
            view2.findViewById(R.id.G4).setVisibility(8);
            if (getCount() > 1) {
                imageView.setImageResource(R.drawable.f21770n3);
                imageView.setVisibility(0);
                imageView.setRotation(this.f21384b ? 180.0f : 0.0f);
                a aVar = new a(this.f21383a);
                imageView.setOnTouchListener(aVar);
                textView.setOnTouchListener(aVar);
            } else {
                imageView.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view2;
    }
}
