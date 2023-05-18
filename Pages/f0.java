package com.scores365.Pages;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompStageObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GroupGameObj;
import com.scores365.entitys.SeasonObj;
import com.scores365.entitys.TableObj;
import com.scores365.gameCenter.GameCenterBaseActivity;
import com.scores365.ui.InfoDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import li.x0;
/* compiled from: TournamentPage.java */
/* loaded from: classes2.dex */
public class f0 extends c0 {
    public static e A;

    /* renamed from: u  reason: collision with root package name */
    private yd.a f21226u;

    /* renamed from: v  reason: collision with root package name */
    private RelativeLayout f21227v;

    /* renamed from: w  reason: collision with root package name */
    private RelativeLayout f21228w;

    /* renamed from: x  reason: collision with root package name */
    private LinearLayout f21229x;

    /* renamed from: y  reason: collision with root package name */
    private CardView f21230y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f21231z;

    /* compiled from: TournamentPage.java */
    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.c {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            try {
                return ((GridLayoutManager) ((com.scores365.Design.Pages.q) f0.this).rvLayoutMgr).u();
            } catch (Exception e10) {
                x0.N1(e10);
                return 1;
            }
        }
    }

    /* compiled from: TournamentPage.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21233a;

        static {
            int[] iArr = new int[e.values().length];
            f21233a = iArr;
            try {
                iArr[e.BACKWARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21233a[e.FORWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21233a[e.GAME_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TournamentPage.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<CompetitionObj> f21234a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<f0> f21235b;

        /* renamed from: c  reason: collision with root package name */
        private int f21236c;

        public c(int i10, f0 f0Var, CompetitionObj competitionObj) {
            this.f21235b = new WeakReference<>(f0Var);
            this.f21234a = new WeakReference<>(competitionObj);
            this.f21236c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f0 f0Var = this.f21235b.get();
                CompetitionObj competitionObj = this.f21234a.get();
                if (f0Var == null || competitionObj == null) {
                    return;
                }
                new d(this.f21236c, f0Var, competitionObj).execute(new Void[0]);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: TournamentPage.java */
    /* loaded from: classes2.dex */
    private class d extends AsyncTask<Void, Void, TableObj> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<CompetitionObj> f21238a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<f0> f21239b;

        /* renamed from: c  reason: collision with root package name */
        private int f21240c;

        public d(int i10, f0 f0Var, CompetitionObj competitionObj) {
            this.f21239b = new WeakReference<>(f0Var);
            this.f21238a = new WeakReference<>(competitionObj);
            this.f21240c = i10;
        }

        private TableObj b(CompetitionObj competitionObj) {
            SeasonObj seasonObj;
            CompStageObj compStageObj;
            try {
                SeasonObj[] sessions = competitionObj.getSessions();
                int i10 = 0;
                while (true) {
                    if (i10 >= sessions.length) {
                        seasonObj = null;
                        break;
                    } else if (sessions[i10].getNum() == competitionObj.CurrSeason) {
                        seasonObj = sessions[i10];
                        break;
                    } else {
                        i10++;
                    }
                }
                try {
                    if (seasonObj.getStages() != null) {
                        CompStageObj[] stages = seasonObj.getStages();
                        for (int i11 = 0; i11 < stages.length; i11++) {
                            if (stages[i11].getNum() == competitionObj.CurrStage) {
                                compStageObj = stages[i11];
                                break;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                compStageObj = null;
                com.scores365.api.r rVar = new com.scores365.api.r(competitionObj.getID(), seasonObj.getNum(), (compStageObj == null || !compStageObj.getHasTable()) ? -1 : compStageObj.getNum(), -1, false);
                rVar.a();
                rVar.call();
                return rVar.f23199h;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public TableObj doInBackground(Void... voidArr) {
            try {
                CompetitionObj competitionObj = this.f21238a.get();
                if (competitionObj == null || !x0.o1(App.m())) {
                    return null;
                }
                return b(competitionObj);
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(TableObj tableObj) {
            try {
                super.onPostExecute(tableObj);
                f0 f0Var = this.f21239b.get();
                CompetitionObj competitionObj = this.f21238a.get();
                if (f0Var != null && competitionObj != null) {
                    if (tableObj != null) {
                        f0Var.l(false);
                        competitionObj.tableObj = tableObj;
                        f0Var.I1(competitionObj, -1, false);
                    } else {
                        this.f21240c *= 2;
                        new Handler().postDelayed(new c(this.f21240c, f0Var, competitionObj), this.f21240c);
                    }
                }
                f0 f0Var2 = f0.this;
                f0Var2.f21226u = new yd.a(competitionObj, f0Var2.getArguments().getInt("game_stage_tag", -1), f0.this.getArguments().getInt("stage_num_tag", 1), f0.this.getArguments().getInt(InfoDialog.GAME_ID_TAG, 1));
                f0.this.V1(false);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            try {
                super.onPreExecute();
                f0 f0Var = this.f21239b.get();
                if (f0Var != null) {
                    f0Var.l(true);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: TournamentPage.java */
    /* loaded from: classes2.dex */
    public enum e {
        BACKWARD,
        FORWARD,
        GAME_CLICK
    }

    private void R1() {
        try {
            T1((zd.b) this.f21194q.get(0));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static f0 S1(String str, ArrayList<CompetitionObj> arrayList, sc.i iVar, int i10, int i11, int i12) {
        f0 f0Var = new f0();
        try {
            f0Var.f21195r = arrayList;
            f0Var.f21189l = str;
            f0Var.placement = iVar;
            A = e.BACKWARD;
            Bundle bundle = new Bundle();
            bundle.putInt("game_stage_tag", i10);
            bundle.putInt("stage_num_tag", i11);
            bundle.putInt(InfoDialog.GAME_ID_TAG, i12);
            f0Var.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return f0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1(boolean z10) {
        try {
            try {
                this.f21228w.setVisibility(8);
                this.f21229x.setVisibility(0);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            this.f21194q = this.f21226u.d();
            if (this.f21226u.b().isFinal()) {
                this.f21229x.setVisibility(8);
                this.f21228w.setVisibility(0);
                R1();
            } else {
                if (this.f21226u.b().getHasTable()) {
                    H1(this.f21195r.get(0));
                }
                com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
                if (cVar == null) {
                    id.f fVar = new id.f(this.f21194q, this.recylerItemClickListener, this.f21196s);
                    this.rvBaseAdapter = fVar;
                    this.rvItems.setAdapter(fVar);
                    this.f21192o = true;
                } else {
                    cVar.H(this.f21194q);
                    if (this.f21226u.b().getHasTable()) {
                        com.scores365.Design.Pages.c cVar2 = this.rvBaseAdapter;
                        if (cVar2 instanceof id.f) {
                            ((id.f) cVar2).f28574m = this.f21196s;
                        }
                    }
                    this.rvBaseAdapter.notifyDataSetChanged();
                }
            }
            if (z10) {
                e eVar = A;
                e eVar2 = e.FORWARD;
                if (eVar == eVar2) {
                    this.f21229x.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21524x));
                } else {
                    this.f21229x.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21523w));
                }
                if (this.f21226u.b().isFinal() && A == eVar2) {
                    this.f21228w.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21524x));
                    this.f21229x.setVisibility(8);
                    this.f21228w.setVisibility(0);
                } else if (this.f21226u.b().isFinal() && A == e.BACKWARD) {
                    this.f21228w.startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21526z));
                    this.f21229x.setVisibility(0);
                    this.f21228w.setVisibility(8);
                }
            }
            if (this.f21226u.c() > 0) {
                ((LinearLayoutManager) this.rvLayoutMgr).scrollToPositionWithOffset(this.f21226u.c(), 0);
                this.rvItems.t1(0, -1);
                this.rvItems.t1(0, 1);
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        try {
            this.f21194q = new ArrayList<>();
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public void T1(zd.b bVar) {
        try {
            GroupGameObj groupGameObj = bVar.f43830l;
            if (groupGameObj != null) {
                this.f21231z.setText(groupGameObj.groupName);
            } else {
                this.f21230y.setVisibility(8);
                this.f21231z.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void U1(View view) {
        try {
            this.f21230y = (CardView) view.findViewById(R.id.f22240q4);
            this.f21231z = (TextView) view.findViewById(R.id.nt);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.Ha;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public int getPaddingSize() {
        try {
            if (getParentFragment() instanceof zc.c) {
                return ((zc.c) getParentFragment()).getPaddingSize(this);
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean hasContentPadding() {
        try {
            if (getParentFragment() instanceof zc.c) {
                return ((zc.c) getParentFragment()).T1();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        super.initRecyclerViewLayoutManager();
        RecyclerView.p pVar = this.rvLayoutMgr;
        if (pVar instanceof GridLayoutManager) {
            ((GridLayoutManager) pVar).C(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            if (this.f21194q.get(i10) instanceof zd.b) {
                zd.b bVar = (zd.b) this.f21194q.get(i10);
                int i11 = b.f21233a[bVar.f43833o.ordinal()];
                if (i11 == 1) {
                    this.f21226u.a();
                    V1(true);
                } else if (i11 == 2) {
                    this.f21226u.g();
                    V1(true);
                } else if (i11 == 3) {
                    startActivity(GameCenterBaseActivity.z1(bVar.f43834p, bg.e.DETAILS, "tournament"));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        this.f21226u = new yd.a(this.f21195r.get(0), getArguments().getInt("game_stage_tag", -1), getArguments().getInt("stage_num_tag", 1), getArguments().getInt(InfoDialog.GAME_ID_TAG, -1));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.Xh);
        this.f21227v = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f21190m = (RelativeLayout) view.findViewById(R.id.Jn);
        this.f21228w = (RelativeLayout) view.findViewById(R.id.lt);
        this.f21229x = (LinearLayout) view.findViewById(R.id.f22186ng);
        this.f21190m.setVisibility(8);
        U1(view);
    }

    @Override // com.scores365.Pages.c0, com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        try {
            if (this.f21195r.get(0).isCompetitionHasTable() && this.f21195r.get(0).tableObj == null) {
                new d(500, this, this.f21195r.get(0)).execute(new Void[0]);
            }
            V1(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
