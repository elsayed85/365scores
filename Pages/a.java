package com.scores365.Pages;

import ag.h0;
import ag.k0;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.scores365.Design.Pages.q;
import com.scores365.branding.BrandingStripItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import li.x0;
/* compiled from: BaseExpandableRecyclerViewAdapter.java */
/* loaded from: classes2.dex */
public class a extends ab.a<RecyclerView.e0, RecyclerView.e0> {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> f21165e;

    /* renamed from: f  reason: collision with root package name */
    protected Hashtable<Integer, Integer> f21166f = new Hashtable<>();

    /* renamed from: g  reason: collision with root package name */
    protected WeakReference<q.e> f21167g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseExpandableRecyclerViewAdapter.java */
    /* renamed from: com.scores365.Pages.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0235a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21168a;

        static {
            int[] iArr = new int[lf.u.values().length];
            f21168a = iArr;
            try {
                iArr[lf.u.GroupsGameItem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21168a[lf.u.TournamentselectCompetitorItem.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21168a[lf.u.STATS_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21168a[lf.u.STATS_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21168a[lf.u.STATS_CHILD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21168a[lf.u.STATS_FOOTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21168a[lf.u.GroupsFiller.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21168a[lf.u.GroupsDateItem.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f21168a[lf.u.GROUP_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21168a[lf.u.StandingsFooter.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f21168a[lf.u.ODDS_GROUP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f21168a[lf.u.ODDS_LINE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f21168a[lf.u.ODDS_STRIP_18.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f21168a[lf.u.ODDS_TITLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f21168a[lf.u.ODDS_SUB_FILTER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f21168a[lf.u.GAME_CENTER_TITLE_ITEM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f21168a[lf.u.LineupsCompetitionStatsNameItem.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f21168a[lf.u.brandingStripItem.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f21168a[lf.u.BannerStripItem.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public a(ArrayList<ArrayList<com.scores365.Design.PageObjects.b>> arrayList, q.e eVar) {
        this.f21165e = arrayList;
        setHasStableIds(true);
        F();
        this.f21167g = new WeakReference<>(eVar);
    }

    @NonNull
    private ArrayList<com.scores365.Design.PageObjects.b> D(int i10) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f21165e.get(i10);
        return new ArrayList<>(arrayList.subList(1, arrayList.size()));
    }

    public void B(RecyclerViewExpandableItemManager recyclerViewExpandableItemManager) {
        try {
            Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = this.f21165e.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (it.next().get(0) instanceof pb.b) {
                    recyclerViewExpandableItemManager.c(i10);
                }
                i10++;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public com.scores365.Design.PageObjects.b C(int i10) {
        try {
            return this.f21165e.get(i10).get(0);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    protected RecyclerView.e0 E(lf.u uVar, ViewGroup viewGroup) {
        RecyclerView.e0 l10;
        View view;
        RecyclerView.e0 e0Var = null;
        try {
            switch (C0235a.f21168a[uVar.ordinal()]) {
                case 1:
                    l10 = of.f.l(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 2:
                    l10 = ji.c.l(viewGroup);
                    e0Var = l10;
                    break;
                case 3:
                    l10 = ld.k.r(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 4:
                    l10 = ld.l.onCreateViewHolder(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 5:
                    l10 = ld.m.o(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 6:
                    l10 = ld.j.onCreateViewHolder(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 7:
                    l10 = h0.onCreateViewHolder(viewGroup);
                    e0Var = l10;
                    break;
                case 8:
                    l10 = of.c.l(viewGroup);
                    e0Var = l10;
                    break;
                case 9:
                    l10 = of.e.onCreateViewHolder(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 10:
                    l10 = of.i.onCreateViewHolder(viewGroup);
                    e0Var = l10;
                    break;
                case 11:
                    l10 = ld.b.p(viewGroup, null);
                    e0Var = l10;
                    break;
                case 12:
                    l10 = ld.d.n(viewGroup);
                    e0Var = l10;
                    break;
                case 13:
                    l10 = ld.e.onCreateViewHolder(viewGroup, null);
                    e0Var = l10;
                    break;
                case 14:
                    l10 = ld.i.l(viewGroup);
                    e0Var = l10;
                    break;
                case 15:
                    l10 = ld.f.m(viewGroup, null);
                    e0Var = l10;
                    break;
                case 16:
                    l10 = ag.d0.l(viewGroup);
                    e0Var = l10;
                    break;
                case 17:
                    l10 = k0.l(viewGroup);
                    e0Var = l10;
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    l10 = BrandingStripItem.onCreateViewHolder(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
                case 19:
                    l10 = gc.j.f26997b.a(viewGroup, this.f21167g.get());
                    e0Var = l10;
                    break;
            }
            if (e0Var != null && (view = e0Var.itemView) != null) {
                e1.I0(view, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return e0Var;
    }

    public void F() {
        try {
            int size = this.f21165e.size();
            Iterator<ArrayList<com.scores365.Design.PageObjects.b>> it = this.f21165e.iterator();
            while (it.hasNext()) {
                Iterator<com.scores365.Design.PageObjects.b> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    int objectTypeNum = it2.next().getObjectTypeNum();
                    if (!this.f21166f.containsKey(Integer.valueOf(objectTypeNum))) {
                        this.f21166f.put(Integer.valueOf(objectTypeNum), Integer.valueOf(size));
                        size++;
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // za.a
    public void c(RecyclerView.e0 e0Var, int i10, int i11) {
        this.f21165e.get(i10).get(0).onBindViewHolder(e0Var, i10);
    }

    @Override // za.a
    public RecyclerView.e0 d(ViewGroup viewGroup, int i10) {
        return E(lf.u.values()[i10], viewGroup);
    }

    @Override // za.a
    public int g(int i10, int i11) {
        return D(i10).get(i11).getObjectTypeNum();
    }

    @Override // za.a
    public long getChildId(int i10, int i11) {
        return D(i10).get(i11).getItemId();
    }

    @Override // za.a
    public int getGroupCount() {
        return this.f21165e.size();
    }

    @Override // za.a
    public long getGroupId(int i10) {
        return this.f21165e.get(i10).get(0).getItemId();
    }

    @Override // za.a
    public void i(RecyclerView.e0 e0Var, int i10, int i11, int i12) {
        try {
            D(i10).get(i11).onBindViewHolder(e0Var, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // za.a
    public int o(int i10) {
        return this.f21165e.get(i10).size() - 1;
    }

    @Override // za.a
    public RecyclerView.e0 q(ViewGroup viewGroup, int i10) {
        return E(lf.u.values()[i10], viewGroup);
    }

    @Override // za.a
    public boolean s(RecyclerView.e0 e0Var, int i10, int i11, int i12, boolean z10) {
        return true;
    }

    @Override // za.a
    public int v(int i10) {
        return this.f21165e.get(i10).get(0).getObjectTypeNum();
    }
}
