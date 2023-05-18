package com.scores365.tournamentPromotion;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.NotifiedUpdateObj;
import com.scores365.tournamentPromotion.TournamentPromotionActivity;
import com.scores365.ui.NotificationListActivity;
import ee.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import li.l0;
import li.o0;
import li.p0;
import li.x0;
import nd.j;
/* compiled from: TournamentNotificationFragment.java */
/* loaded from: classes2.dex */
public class c extends Fragment implements View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f24340l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f24341m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f24342n;

    /* renamed from: o  reason: collision with root package name */
    private TournamentPromotionActivity.f f24343o;

    /* renamed from: p  reason: collision with root package name */
    private nd.a f24344p;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<CheckBox> f24345q = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private int f24346r = -1;

    /* renamed from: s  reason: collision with root package name */
    private HashMap<Integer, Boolean> f24347s = new HashMap<>();

    /* renamed from: t  reason: collision with root package name */
    private boolean f24348t = true;

    private void s1() {
        try {
            if (this.f24344p.c() == 2) {
                this.f24342n.findViewById(R.id.dE).setVisibility(8);
                this.f24342n.findViewById(R.id.f22114ka).setVisibility(8);
                this.f24342n.findViewById(R.id.f22158ma).setVisibility(8);
            } else {
                this.f24342n.findViewById(R.id.dE).setVisibility(0);
                TextView textView = (TextView) this.f24342n.findViewById(R.id.dE);
                textView.setText(this.f24344p.f35281f.f35299d.toUpperCase());
                textView.setTextColor(p0.V());
                textView.setTypeface(o0.d(App.m()));
                if (x0.l1()) {
                    this.f24342n.setGravity(8388629);
                    ((ImageView) this.f24342n.findViewById(R.id.f22158ma)).setVisibility(8);
                    ((ImageView) this.f24342n.findViewById(R.id.f22114ka)).setImageResource(p0.T(R.attr.f21548h));
                } else {
                    ((ImageView) this.f24342n.findViewById(R.id.f22114ka)).setVisibility(8);
                    ((ImageView) this.f24342n.findViewById(R.id.f22158ma)).setImageResource(p0.T(R.attr.f21551i));
                    this.f24342n.setGravity(8388627);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void t1() {
        int o10 = App.o();
        int p10 = App.p();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24341m.getLayoutParams();
        layoutParams.topMargin = (o10 * 9) / 100;
        layoutParams.bottomMargin = (o10 * 5) / 100;
        int i10 = (p10 * 7) / 10;
        ((RelativeLayout.LayoutParams) this.f24340l.getLayoutParams()).width = i10;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f24342n.getLayoutParams();
        layoutParams2.width = i10;
        layoutParams2.bottomMargin = (p10 * 8) / 100;
        layoutParams2.topMargin = (p10 * 4) / 100;
    }

    private void u1(CheckBox checkBox, int i10) {
        try {
            int intValue = ((Integer) checkBox.getTag()).intValue();
            checkBox.setChecked(sf.a.i0(App.m()).n1(i10, App.l().getNotificationType(intValue, this.f24346r).getID()));
            if (!this.f24347s.containsKey(Integer.valueOf(intValue)) && checkBox.isChecked()) {
                this.f24347s.put(Integer.valueOf(intValue), Boolean.FALSE);
            } else if (this.f24347s.containsKey(Integer.valueOf(intValue)) && !checkBox.isChecked()) {
                this.f24347s.remove(Integer.valueOf(intValue));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static c v1(TournamentPromotionActivity.f fVar, nd.a aVar) {
        c cVar = new c();
        cVar.f24343o = fVar;
        cVar.f24344p = aVar;
        cVar.f24346r = aVar.f35282g.f35316l.get(Integer.valueOf(aVar.f35282g.f35311g.iterator().next().intValue())).getSid();
        cVar.setArguments(new Bundle());
        return cVar;
    }

    private void w1(boolean z10) {
        if (z10) {
            char c10 = 7;
            int i10 = 14;
            if (this.f24344p.c() == 2) {
                for (Integer num : a.f24325f.keySet()) {
                    for (Integer num2 : this.f24347s.keySet()) {
                        Context m10 = App.m();
                        String[] strArr = new String[14];
                        strArr[0] = "with_sound";
                        strArr[1] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                        strArr[2] = "entity_type";
                        strArr[3] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                        strArr[4] = "entity_id";
                        strArr[5] = String.valueOf(num);
                        strArr[6] = "notification_type";
                        strArr[c10] = String.valueOf(num2);
                        strArr[8] = ServerProtocol.DIALOG_PARAM_STATE;
                        strArr[9] = "select";
                        strArr[10] = ShareConstants.FEED_SOURCE_PARAM;
                        strArr[11] = "wizard-tournament";
                        strArr[12] = "type-of-click";
                        strArr[13] = this.f24347s.get(num2).booleanValue() ? "auto" : "edit";
                        k.n(m10, "notification", "edit", "click", null, true, strArr);
                        c10 = 7;
                    }
                }
            } else {
                Iterator<Integer> it = this.f24344p.f35282g.f35311g.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    for (Integer num3 : this.f24347s.keySet()) {
                        Context m11 = App.m();
                        String[] strArr2 = new String[i10];
                        strArr2[0] = "with_sound";
                        strArr2[1] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                        strArr2[2] = "entity_type";
                        strArr2[3] = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                        strArr2[4] = "entity_id";
                        strArr2[5] = String.valueOf(next);
                        strArr2[6] = "notification_type";
                        strArr2[7] = String.valueOf(num3);
                        strArr2[8] = ServerProtocol.DIALOG_PARAM_STATE;
                        strArr2[9] = "select";
                        strArr2[10] = ShareConstants.FEED_SOURCE_PARAM;
                        strArr2[11] = "wizard-tournament";
                        strArr2[12] = "type-of-click";
                        strArr2[13] = this.f24347s.get(num3).booleanValue() ? "auto" : "edit";
                        k.n(m11, "notification", "edit", "click", null, true, strArr2);
                        i10 = 14;
                    }
                }
            }
        } else {
            ((TournamentPromotionActivity) getActivity()).G = true;
            if (this.f24344p.c() == 2) {
                for (Integer num4 : a.f24325f.keySet()) {
                    Iterator<NotifiedUpdateObj> it2 = App.l().getNotifiedUpdates().iterator();
                    while (it2.hasNext()) {
                        NotifiedUpdateObj next2 = it2.next();
                        try {
                            if (next2.sportTypeId() == sf.a.i0(App.m()).X(num4.intValue()).getSid()) {
                                sf.a.i0(App.m()).E1(num4.intValue(), next2.getID());
                            }
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                }
            } else {
                for (Integer num5 : this.f24344p.f35282g.f35316l.keySet()) {
                    Iterator<NotifiedUpdateObj> it3 = App.l().getNotifiedUpdates().iterator();
                    while (it3.hasNext()) {
                        NotifiedUpdateObj next3 = it3.next();
                        if (next3.sportTypeId() == this.f24344p.f35282g.f35316l.get(num5).getSid()) {
                            sf.a.i0(App.m()).E1(num5.intValue(), next3.getID());
                        }
                    }
                }
            }
        }
        App.b.y();
        x0.A2(null, null);
        TournamentPromotionActivity.f fVar = this.f24343o;
        if (fVar != null) {
            fVar.a(TournamentPromotionActivity.e.NOTIFICATIONS, false, false);
        }
    }

    private void x1() {
        int[] autoSelectType;
        HashSet hashSet = new HashSet();
        HashMap<Integer, CompetitionObj> hashMap = this.f24344p.f35282g.f35316l;
        int id2 = hashMap.get(hashMap.keySet().iterator().next()).getID();
        CompetitionObj competitionObj = this.f24344p.f35282g.f35316l.get(Integer.valueOf(id2));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Iterator<j> it = this.f24344p.f35281f.f35301f.iterator();
            while (it.hasNext()) {
                j next = it.next();
                linkedHashMap.put(Integer.valueOf(next.f35322a), next);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        Iterator it2 = linkedHashMap.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                NotificationListActivity.startNotificationListActivity(competitionObj, "wizard-tournament", hashSet, this.f24344p.f35281f.f35299d.toUpperCase(), false);
                return;
            }
            j jVar = (j) it2.next();
            if (sf.a.i0(App.m()).n1(id2, jVar.f35322a)) {
                hashSet.add(Integer.valueOf(jVar.f35322a));
                NotifiedUpdateObj notifiedUpdateObj = App.l().getNotifiedUpdatesHash().get(Integer.valueOf(jVar.f35322a));
                if (notifiedUpdateObj != null && notifiedUpdateObj.isAutoSelectedNotificationsListNotEmpty()) {
                    for (int i10 : notifiedUpdateObj.getAutoSelectType()) {
                        NotifiedUpdateObj notifiedUpdateObj2 = App.l().getNotifiedUpdatesHash().get(Integer.valueOf(i10));
                        if (notifiedUpdateObj2 != null && notifiedUpdateObj2.getIsDisplayed() && notifiedUpdateObj2.isRelevantForEntityType(1)) {
                            hashSet.add(Integer.valueOf(i10));
                        }
                    }
                }
            }
        }
    }

    private void y1() {
        Vector<Integer> v02;
        try {
            if (this.f24344p.c() != 2) {
                for (Integer num : this.f24344p.f35282g.f35316l.keySet()) {
                    Iterator<CheckBox> it = this.f24345q.iterator();
                    while (it.hasNext()) {
                        u1(it.next(), num.intValue());
                    }
                }
                v02 = sf.a.i0(App.m()).v0(this.f24344p.f35282g.f35316l.keySet().iterator().next().intValue());
            } else {
                for (Integer num2 : a.f24325f.keySet()) {
                    Iterator<CheckBox> it2 = this.f24345q.iterator();
                    while (it2.hasNext()) {
                        u1(it2.next(), num2.intValue());
                    }
                }
                v02 = sf.a.i0(App.m()).v0(a.f24325f.keySet().iterator().next().intValue());
            }
            if (v02 == null || v02.isEmpty()) {
                this.f24347s.clear();
                return;
            }
            Iterator<Integer> it3 = v02.iterator();
            while (it3.hasNext()) {
                Integer next = it3.next();
                if (!this.f24347s.containsKey(next)) {
                    this.f24347s.put(next, Boolean.FALSE);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int[] autoSelectType;
        int[] autoSelectType2;
        try {
            int id2 = view.getId();
            if (id2 == R.id.JB) {
                w1(true);
                k.n(App.m(), "wizard-tournament", "default_notification", "next", "click", true, "promotion_id", String.valueOf(this.f24344p.b()));
            } else if (id2 == R.id.kE) {
                w1(false);
                k.n(App.m(), "wizard-tournament", "default_notification", "skip", "click", true, "promotion_id", String.valueOf(this.f24344p.b()));
            } else if (id2 == R.id.go) {
                x1();
                k.n(App.m(), "wizard-tournament", "default_notification", "more_options", "click", true, "promotion_id", String.valueOf(this.f24344p.b()));
            } else {
                int i10 = R.id.Z1;
                if (id2 != i10) {
                    if (id2 == R.id.In) {
                        view.findViewById(i10).performClick();
                        return;
                    }
                    return;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                if (this.f24347s == null) {
                    this.f24347s = new HashMap<>();
                }
                for (Integer num : this.f24344p.f35282g.f35316l.keySet()) {
                    if (((CheckBox) view).isChecked()) {
                        App.b.I(App.c.LEAGUE, num.intValue(), intValue, l0.h(intValue).f34608a);
                        this.f24347s.put(Integer.valueOf(intValue), Boolean.FALSE);
                        NotifiedUpdateObj notifiedUpdateObj = App.l().getNotifiedUpdatesHash().get(Integer.valueOf(intValue));
                        if (notifiedUpdateObj != null && notifiedUpdateObj.isAutoSelectedNotificationsListNotEmpty()) {
                            for (int i11 : notifiedUpdateObj.getAutoSelectType()) {
                                NotifiedUpdateObj notifiedUpdateObj2 = App.l().getNotifiedUpdatesHash().get(Integer.valueOf(i11));
                                if (notifiedUpdateObj2 != null && notifiedUpdateObj2.getIsDisplayed() && notifiedUpdateObj2.isRelevantForEntityType(1)) {
                                    App.b.I(App.c.LEAGUE, num.intValue(), i11, l0.h(i11).f34608a);
                                }
                            }
                        }
                    } else {
                        App.b.r0(App.c.LEAGUE, num.intValue(), intValue);
                        this.f24347s.remove(Integer.valueOf(intValue));
                        NotifiedUpdateObj notifiedUpdateObj3 = App.l().getNotifiedUpdatesHash().get(Integer.valueOf(intValue));
                        if (notifiedUpdateObj3 != null && notifiedUpdateObj3.isAutoSelectedNotificationsListNotEmpty()) {
                            for (int i12 : notifiedUpdateObj3.getAutoSelectType()) {
                                NotifiedUpdateObj notifiedUpdateObj4 = App.l().getNotifiedUpdatesHash().get(Integer.valueOf(i12));
                                if (notifiedUpdateObj4 != null && notifiedUpdateObj4.getIsDisplayed() && notifiedUpdateObj4.isRelevantForEntityType(1)) {
                                    App.b.r0(App.c.LEAGUE, num.intValue(), i12);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            k.n(App.m(), "wizard-tournament", "default_notification", "show", null, true, "promotion_id", String.valueOf(this.f24344p.b()));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.Ia, viewGroup, false);
            this.f24340l = (LinearLayout) view.findViewById(R.id.Rg);
            this.f24341m = (TextView) view.findViewById(R.id.YG);
            this.f24342n = (LinearLayout) view.findViewById(R.id.go);
            TextView textView = (TextView) view.findViewById(R.id.JB);
            TextView textView2 = (TextView) view.findViewById(R.id.kE);
            this.f24342n.setOnClickListener(this);
            textView.setOnClickListener(this);
            textView.setBackgroundResource(p0.T(R.attr.C1));
            textView.setTypeface(o0.d(App.m()));
            textView.setTextSize(1, 14.0f);
            textView.setText(this.f24344p.f35281f.f35297b);
            textView2.setOnClickListener(this);
            textView2.setTextColor(p0.o0());
            textView2.setTextSize(1, 14.0f);
            textView2.setTypeface(o0.d(App.m()));
            textView2.setTextSize(1, 14.0f);
            textView2.setText(this.f24344p.f35281f.f35298c);
            this.f24341m.setTypeface(o0.b(App.m()));
            this.f24341m.setTextColor(p0.A(R.attr.U0));
            this.f24341m.setTextSize(1, 24.0f);
            this.f24341m.setText(this.f24344p.f35281f.f35296a);
            r1();
            s1();
            t1();
            return view;
        } catch (Exception e10) {
            x0.N1(e10);
            return view;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            if (!this.f24348t) {
                y1();
            }
            this.f24348t = false;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void r1() {
        try {
            this.f24340l.removeAllViews();
            this.f24345q.clear();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Iterator<j> it = this.f24344p.f35281f.f35301f.iterator();
                while (it.hasNext()) {
                    j next = it.next();
                    linkedHashMap.put(Integer.valueOf(next.f35322a), next);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            for (j jVar : linkedHashMap.values()) {
                NotifiedUpdateObj notificationType = App.l().getNotificationType(jVar.f35322a, this.f24346r);
                RelativeLayout relativeLayout = x0.l1() ? (RelativeLayout) LayoutInflater.from(App.m()).inflate(R.layout.Ka, (ViewGroup) this.f24340l, false) : (RelativeLayout) LayoutInflater.from(App.m()).inflate(R.layout.Ja, (ViewGroup) this.f24340l, false);
                CheckBox checkBox = (CheckBox) relativeLayout.findViewById(R.id.Z1);
                TextView textView = (TextView) relativeLayout.findViewById(R.id.zx);
                relativeLayout.getLayoutParams().height = App.o() / 10;
                textView.setTypeface(o0.b(App.m()));
                checkBox.setButtonDrawable(p0.K(R.attr.f21541e1));
                String str = jVar.f35324c;
                if (str == null || str.isEmpty()) {
                    textView.setText(notificationType.getName());
                } else {
                    textView.setText(jVar.f35324c);
                }
                textView.setTextColor(p0.A(R.attr.U0));
                if (x0.l1()) {
                    textView.setGravity(8388613);
                } else {
                    textView.setGravity(8388611);
                }
                checkBox.setTag(Integer.valueOf(notificationType.getID()));
                checkBox.setOnClickListener(this);
                relativeLayout.setOnClickListener(this);
                if (((TournamentPromotionActivity) getActivity()).G) {
                    if (this.f24344p.c() == 2) {
                        for (Integer num : a.f24325f.keySet()) {
                            if (jVar.f35323b) {
                                sf.a i02 = sf.a.i0(App.m());
                                int intValue = num.intValue();
                                int i10 = jVar.f35322a;
                                i02.q(intValue, i10, l0.h(i10).f34608a);
                            } else {
                                sf.a.i0(App.m()).E1(num.intValue(), jVar.f35322a);
                            }
                        }
                    } else {
                        for (Integer num2 : this.f24344p.f35282g.f35316l.keySet()) {
                            if (jVar.f35323b) {
                                sf.a i03 = sf.a.i0(App.m());
                                int intValue2 = num2.intValue();
                                int i11 = jVar.f35322a;
                                i03.q(intValue2, i11, l0.h(i11).f34608a);
                            } else {
                                sf.a.i0(App.m()).E1(num2.intValue(), jVar.f35322a);
                            }
                        }
                    }
                    checkBox.setChecked(jVar.f35323b);
                } else if (this.f24344p.c() == 2) {
                    checkBox.setChecked(sf.a.i0(App.m()).n1(a.f24325f.keySet().iterator().next().intValue(), jVar.f35322a));
                } else {
                    checkBox.setChecked(sf.a.i0(App.m()).n1(this.f24344p.f35282g.f35316l.keySet().iterator().next().intValue(), jVar.f35322a));
                }
                if (this.f24347s == null) {
                    this.f24347s = new HashMap<>();
                }
                if (jVar.f35323b && checkBox.isChecked()) {
                    this.f24347s.put(Integer.valueOf(jVar.f35322a), Boolean.TRUE);
                }
                this.f24345q.add(checkBox);
                this.f24340l.addView(relativeLayout);
            }
            ((TournamentPromotionActivity) getActivity()).G = false;
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }
}
