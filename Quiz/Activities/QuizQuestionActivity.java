package com.scores365.Quiz.Activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.a0;
import cc.c1;
import com.scores365.App;
import com.scores365.Quiz.Activities.QuizQuestionActivity;
import com.scores365.Quiz.CustomViews.QuizToolbar;
import com.scores365.R;
import java.util.HashMap;
import li.p0;
import li.x0;
import pd.b;
import sc.i;
import td.g;
import uc.d;
import uc.f;
import wd.k;
/* loaded from: classes2.dex */
public class QuizQuestionActivity extends b implements g.c {

    /* renamed from: f0  reason: collision with root package name */
    int f21395f0 = -1;

    /* loaded from: classes2.dex */
    public enum a {
        NOT_FINISHED(0),
        FINISHED_LEVEL(1),
        FINISHED_STAGE(2),
        FINISHED_MODE(3);
        
        private final int value;

        a(int i10) {
            this.value = i10;
        }

        public static a create(int i10) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return null;
                        }
                        return FINISHED_MODE;
                    }
                    return FINISHED_STAGE;
                }
                return FINISHED_LEVEL;
            }
            return NOT_FINISHED;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Intent E1(int i10, int i11) {
        Intent intent = new Intent(App.m(), QuizQuestionActivity.class);
        try {
            intent.putExtra("mode_id_tag", i10);
            intent.putExtra("stage_id_tag", i11);
            intent.putExtra("title_tag", od.a.D().U(i10).f41298b);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return intent;
    }

    private int F1() {
        try {
            return getIntent().getIntExtra("mode_id_tag", -1);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    private int G1() {
        try {
            return getIntent().getIntExtra("stage_id_tag", -1);
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H1() {
        k Y = od.a.D().Y(F1(), G1(), this.f21395f0);
        if (Y == null || !Y.f41323f) {
            d n10 = ((App) getApplication()).n();
            f f10 = n10.j().f();
            if (f10 instanceof f.e) {
                n10.u(this, (f.e) f10, new c1.a() { // from class: pd.d
                    @Override // cc.c1.a
                    public final void a() {
                        QuizQuestionActivity.I1();
                    }
                });
            } else {
                sf.b.X1().t3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I1() {
    }

    private void K1(int i10) {
        try {
            if (i10 == 2) {
                this.f21395f0 = od.a.D().P(F1(), G1(), this.f21395f0).f41286b;
            } else if (i10 == 1) {
                this.f21395f0 = od.a.D().R(F1(), G1(), this.f21395f0).f41286b;
            }
            J1(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b
    protected boolean A1() {
        return false;
    }

    protected void J1(int i10) {
        int i11;
        int i12;
        try {
            g x12 = g.x1(F1(), G1(), this.f21395f0, this);
            a0 q10 = getSupportFragmentManager().q();
            boolean l12 = x0.l1();
            if (i10 != 0) {
                if (i10 == 2) {
                    i11 = l12 ? R.anim.f21523w : R.anim.f21524x;
                    i12 = l12 ? R.anim.f21526z : R.anim.f21525y;
                } else if (i10 == 1) {
                    i11 = !l12 ? R.anim.f21523w : R.anim.f21524x;
                    i12 = !l12 ? R.anim.f21526z : R.anim.f21525y;
                } else {
                    i11 = 0;
                    i12 = 0;
                }
                q10.s(i11, i12);
            }
            QuizToolbar quizToolbar = this.F;
            if (quizToolbar != null && quizToolbar.getCoinView() != null) {
                this.F.getCoinView().g(od.a.D().v());
            }
            q10.p(R.id.sl, x12).r(new Runnable() { // from class: pd.c
                @Override // java.lang.Runnable
                public final void run() {
                    QuizQuestionActivity.this.H1();
                }
            }).h();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // td.g.c
    public void M0() {
        try {
            K1(1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b
    protected HashMap<String, Object> a1() {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            hashMap.put("mode_num", String.valueOf(F1()));
            hashMap.put("stage_num", String.valueOf(G1()));
            hashMap.put("level_num", Integer.valueOf(this.f21395f0));
            hashMap.put("screen", "levels");
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return hashMap;
    }

    @Override // pd.b
    protected String e1() {
        return "levels";
    }

    @Override // td.g.c
    public void f(int i10) {
        try {
            this.f21395f0 = i10;
            this.F.f(g1());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b
    protected String g1() {
        StringBuilder sb2 = new StringBuilder();
        try {
            if (this.f21395f0 > -1) {
                sb2.append(p0.l0("QUIZ_GAME_STAGE_NUMBER_GAME_SCREEN").replaceAll("#NUM", String.valueOf(G1())));
                sb2.append(" - ");
                sb2.append(p0.l0("QUIZ_GAME_LEVEL_NUM").replaceAll("#NUM", String.valueOf(this.f21395f0)));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    @Override // cc.e1
    public i getPlacement() {
        return i.Quiz;
    }

    @Override // pd.b
    protected String h1() {
        try {
            return getIntent().getStringExtra("title_tag");
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // pd.b, com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            J1(0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // td.g.c
    public void w0() {
        try {
            K1(2);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // pd.b
    protected boolean x1() {
        return false;
    }

    @Override // pd.b
    protected boolean y1() {
        return false;
    }

    @Override // pd.b
    protected boolean z1() {
        return true;
    }
}
