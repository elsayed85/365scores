package com.scores365.NewsCenter;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.c0;
import cc.e1;
import cc.o0;
import cc.q0;
import cc.z0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.widget.ShareDialog;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.NewsCenter.b;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.ItemObj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import li.i0;
import li.j0;
import li.x0;
import nf.c;
import sc.f;
import uc.d;
import xc.h;
import xc.k;
/* compiled from: NewsCenterFragment.java */
/* loaded from: classes2.dex */
public class a extends q implements b.InterfaceC0234b, c {

    /* renamed from: l  reason: collision with root package name */
    public ItemObj f21150l;

    /* renamed from: m  reason: collision with root package name */
    public Hashtable<Integer, CompObj> f21151m;

    /* renamed from: n  reason: collision with root package name */
    boolean f21152n = false;

    private int A1() {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next() instanceof q0) {
                    return i10;
                }
                i10++;
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    private int B1() {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next() instanceof k) {
                    return i10 + 1;
                }
                i10++;
            }
            return 3;
        } catch (Exception e10) {
            x0.N1(e10);
            return 3;
        }
    }

    private void C1() {
        try {
            if ((getActivity() instanceof NewsCenterActivity) && (getRvBaseAdapter().B().get(0) instanceof h) && getRvBaseAdapter().B() != null) {
                boolean d22 = ((NewsCenterActivity) getActivity()).d2();
                ((h) getRvBaseAdapter().B().get(0)).l(d22);
                getRvBaseAdapter().notifyItemChanged(0);
                if (d22) {
                    sf.b.X1().r7();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean D1() {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof q0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1(d dVar, Hashtable hashtable) {
        try {
            renderData(NewsCenterActivity.U0.f(dVar, this.f21150l, hashtable));
            this.rvBaseAdapter.notifyDataSetChanged();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(Boolean bool) {
        if (bool.booleanValue()) {
            renderData(LoadData());
        }
    }

    public static a G1(ItemObj itemObj, Hashtable<Integer, CompObj> hashtable) {
        a aVar = new a();
        aVar.f21150l = itemObj;
        aVar.f21151m = hashtable;
        aVar.f21152n = j0.e(j0.c.NEWS, itemObj.getID(), j0.a.LIKE);
        return aVar;
    }

    private boolean H1() {
        try {
            return Integer.parseInt(o0.y().C("ARTICLE_MPU_TEXT_MAX_LENGTH")) > this.f21150l.getTitle().length() + this.f21150l.getDescription().length();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private q0 z1() {
        try {
            if (D1() || !(getActivity() instanceof NewsCenterActivity)) {
                return null;
            }
            z0 mpuHandler = ((NewsCenterActivity) getActivity()).getMpuHandler();
            if ((mpuHandler != null && (mpuHandler.f() == sc.h.ReadyToShow || mpuHandler.f() == sc.h.Showing || mpuHandler.f() == sc.h.Shown)) && H1()) {
                return new q0((e1) getActivity(), false);
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.NewsCenter.b.InterfaceC0234b
    public void F(ArrayList<ItemObj> arrayList, final Hashtable<Integer, CompObj> hashtable) {
        try {
            Iterator<ItemObj> it = arrayList.iterator();
            while (it.hasNext()) {
                ItemObj next = it.next();
                this.f21150l.extraItems.put(Integer.valueOf(next.getID()), next);
            }
            if (hashtable == null || this.f21151m != null) {
                hashtable = this.f21151m;
            }
            androidx.fragment.app.h activity = getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && !isStateSaved()) {
                final d n10 = ((App) activity.getApplication()).n();
                activity.runOnUiThread(new Runnable() { // from class: xc.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.scores365.NewsCenter.a.this.E1(n10, hashtable);
                    }
                });
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void I1() {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next() instanceof lf.d) {
                    this.rvBaseAdapter.notifyItemChanged(i10);
                    return;
                }
                i10++;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        return NewsCenterActivity.U0.f(((App) getActivity().getApplication()).n(), this.f21150l, this.f21151m);
    }

    @Override // com.scores365.NewsCenter.c
    public void N(e1 e1Var, xc.a aVar, boolean z10) {
        try {
            if (!H1() || e1Var == null || e1Var.getMpuHandler() != null || z10) {
                if (aVar != null) {
                    aVar.loadBanner();
                }
            } else if (aVar != null) {
                aVar.b0();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return this.pageIconLink;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.T4;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return "NEWS";
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onDataRendered() {
        super.onDataRendered();
        try {
            C1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            App app = (App) activity.getApplication();
            try {
                com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
                if (A instanceof nf.c) {
                    nf.c cVar = (nf.c) A;
                    if (cVar.f35483n == c.b.share) {
                        cVar.f35483n = c.b.general;
                        i0.a(this, app.n(), (wh.b) activity, cVar.f35470a, cVar.f35471b, !(cVar instanceof nf.a), false);
                        ee.k.o(App.m(), ShareDialog.WEB_SHARE_DIALOG, "click", null, null, "entity_type", "2", "entity_id", String.valueOf(cVar.f35470a.getID()), "type_of_share", AppEventsConstants.EVENT_PARAM_VALUE_YES, "is_inner_share", AppEventsConstants.EVENT_PARAM_VALUE_YES, "is_intro", "0", "position", "main");
                    } else {
                        ItemObj itemObj = ((nf.c) A).f35470a;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(itemObj);
                        NewsCenterActivity.Y1(activity, arrayList, 0, ((NewsCenterActivity) activity).G0, true);
                        x0.b2(itemObj.getID(), "news-item", true, false);
                    }
                }
            } catch (Exception e10) {
                e = e10;
                x0.N1(e);
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            if (this.f21150l.isMissingRelatedItems()) {
                NewsCenterActivity.U0.d(new ArrayList<>(this.f21150l.relatedNewsIds), this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        o0.m().j(getViewLifecycleOwner(), new c0() { // from class: xc.g
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                com.scores365.NewsCenter.a.this.F1((Boolean) obj);
            }
        });
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        try {
            super.renderData(t10);
            if (((NewsCenterActivity) getActivity()).G0) {
                o0.Q(f.BigLayout, (NewsCenterActivity) getActivity());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.NewsCenter.c
    public void u() {
        try {
            if (D1()) {
                int A1 = A1();
                ((q0) this.rvBaseAdapter.A(A1)).f10069d = false;
                this.rvBaseAdapter.notifyItemChanged(A1);
                ((NewsCenterActivity) getActivity()).J1().setVisibility(8);
                ((NewsCenterActivity) getActivity()).Z1();
            } else {
                q0 z12 = z1();
                if (z12 != null) {
                    this.rvBaseAdapter.B().add(B1(), z12);
                    z12.f10067b = true;
                    z12.f10068c = false;
                    this.rvBaseAdapter.I();
                    getRvBaseAdapter().notifyItemInserted(B1());
                    ((NewsCenterActivity) getActivity()).J1().setVisibility(8);
                    ((NewsCenterActivity) getActivity()).Z1();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
