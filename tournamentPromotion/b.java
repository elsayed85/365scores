package com.scores365.tournamentPromotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.tournamentPromotion.TournamentPromotionActivity;
import ee.k;
import li.o0;
import li.p0;
import li.u;
import li.x0;
/* compiled from: TournamentLandFragment.java */
/* loaded from: classes2.dex */
public class b extends Fragment implements View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    private TournamentPromotionActivity.f f24334l;

    /* renamed from: m  reason: collision with root package name */
    private nd.a f24335m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f24336n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f24337o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f24338p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f24339q;

    private void r1() {
        try {
            TournamentPromotionActivity.f fVar = this.f24334l;
            if (fVar != null) {
                fVar.a(TournamentPromotionActivity.e.LANDING, true, false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private String s1() {
        try {
            nd.a aVar = this.f24335m;
            String str = aVar.f35280e.f35319b;
            for (Integer num : aVar.f35282g.f35316l.keySet()) {
                if (App.b.r(num.intValue(), App.c.LEAGUE)) {
                    return p0.l0("NEXT");
                }
            }
            return str;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private void t1() {
        try {
            this.f24338p.setEnabled(false);
            this.f24339q.setEnabled(false);
            TournamentPromotionActivity.f fVar = this.f24334l;
            if (fVar != null) {
                fVar.a(TournamentPromotionActivity.e.LANDING, false, false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static b u1(TournamentPromotionActivity.f fVar, nd.a aVar, String str) {
        b bVar = new b();
        bVar.f24334l = fVar;
        bVar.f24335m = aVar;
        Bundle bundle = new Bundle();
        bundle.putString("screen_source_tag", str);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 == R.id.f21970e1) {
                t1();
                sf.b.X1().d6(this.f24335m.b());
                k.n(App.m(), "wizard-tournament", "intro", "follow", "click", true, "promotion_id", String.valueOf(this.f24335m.b()));
            } else if (id2 == R.id.QB) {
                r1();
                sf.b.X1().d6(this.f24335m.b());
                k.n(App.m(), "wizard-tournament", "intro", "not_now", "click", true, "promotion_id", String.valueOf(this.f24335m.b()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            k.n(App.m(), "wizard-tournament", "intro", "show", null, false, "promotion_id", String.valueOf(this.f24335m.b()), ShareConstants.FEED_SOURCE_PARAM, getArguments().getString("screen_source_tag", ""));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.La, viewGroup, false);
            this.f24336n = (ImageView) view.findViewById(R.id.f21935cc);
            this.f24337o = (TextView) view.findViewById(R.id.uH);
            this.f24338p = (TextView) view.findViewById(R.id.f21970e1);
            this.f24339q = (TextView) view.findViewById(R.id.QB);
            this.f24336n.getLayoutParams().height = App.o() / 2;
            u.x(this.f24335m.f35280e.f35321d, this.f24336n);
            this.f24338p.setOnClickListener(this);
            this.f24339q.setOnClickListener(this);
            this.f24339q.setTextColor(p0.o0());
            this.f24337o.setTypeface(o0.b(App.m()));
            this.f24338p.setTypeface(o0.b(App.m()));
            this.f24339q.setTypeface(o0.b(App.m()));
            this.f24337o.setText(this.f24335m.f35280e.f35318a);
            this.f24338p.setText(s1());
            this.f24339q.setText(this.f24335m.f35280e.f35320c);
            return view;
        } catch (Exception e10) {
            x0.N1(e10);
            return view;
        }
    }
}
