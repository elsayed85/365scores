package com.scores365.Quiz.CustomViews.quizKeyboard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.scores365.App;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class QuizKeyboardView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private sd.b f21488d;

    /* renamed from: e  reason: collision with root package name */
    private sd.a f21489e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f21490f;

    /* renamed from: g  reason: collision with root package name */
    private List<rd.a> f21491g;

    /* renamed from: h  reason: collision with root package name */
    private List<List<rd.a>> f21492h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        sd.a f21493a;

        /* renamed from: b  reason: collision with root package name */
        QuizKeyboardView f21494b;

        /* renamed from: c  reason: collision with root package name */
        List<rd.a> f21495c;

        private b(sd.a aVar, QuizKeyboardView quizKeyboardView, List<rd.a> list) {
            this.f21493a = aVar;
            this.f21494b = quizKeyboardView;
            this.f21495c = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                String charValue = ((rd.a) view).getCharValue();
                sd.a aVar = this.f21493a;
                if (aVar == null || !aVar.E(charValue)) {
                    return;
                }
                view.setEnabled(false);
                ((rd.a) view).setTextColor(Color.parseColor("#515f6d"));
                this.f21495c.add((rd.a) view);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public QuizKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QuizKeyboardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void B() {
        try {
            c cVar = new c();
            cVar.p(this);
            int size = this.f21492h.size();
            if (size <= 1) {
                ((ConstraintLayout.b) this.f21492h.get(0).get(0).getLayoutParams()).f4630i = 0;
                ((ConstraintLayout.b) this.f21492h.get(0).get(0).getLayoutParams()).f4636l = 0;
                return;
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = this.f21492h.get(i10).get(0).getId();
                fArr[i10] = 1.0f;
            }
            cVar.y(0, 3, 0, 4, iArr, fArr, 2);
            cVar.i(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void C() {
        try {
            int size = this.f21492h.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 != 0) {
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.f21492h.get(i10).get(0).getLayoutParams())).topMargin = p0.s(12);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void d() {
        try {
            int size = this.f21492h.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<rd.a> list = this.f21492h.get(i10);
                for (int i11 = 1; i11 < list.size(); i11++) {
                    ((ConstraintLayout.b) list.get(i11).getLayoutParams()).f4630i = list.get(0).getId();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private rd.a g(int i10, int i11, String str, int i12, boolean z10) {
        rd.a aVar;
        rd.a aVar2 = null;
        try {
            aVar = new rd.a(App.m(), str, i12);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            aVar.setId(View.generateViewId());
            aVar.setText(str);
            aVar.setTextSize(1, 26.0f);
            aVar.setTypeface(o0.c(App.m()));
            aVar.setGravity(17);
            if (z10) {
                aVar.setTextColor(Color.parseColor("#ffffff"));
            } else {
                aVar.setTextColor(Color.parseColor("#515f6d"));
            }
            setCharTextViewFrame(aVar);
            aVar.setEnabled(z10);
            ConstraintLayout.b bVar = new ConstraintLayout.b(p0.s(i10), p0.s(i11));
            bVar.N = 2;
            aVar.setLayoutParams(bVar);
            return aVar;
        } catch (Exception e11) {
            e = e11;
            aVar2 = aVar;
            x0.N1(e);
            return aVar2;
        }
    }

    private List<String> h(List<String> list) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        try {
            arrayList = new ArrayList();
        } catch (Exception e10) {
            e = e10;
        }
        try {
            for (String str : list) {
                arrayList.add(str);
            }
            return arrayList;
        } catch (Exception e11) {
            e = e11;
            arrayList2 = arrayList;
            x0.N1(e);
            return arrayList2;
        }
    }

    private List<Integer> p() {
        ArrayList arrayList = new ArrayList();
        try {
            int size = this.f21490f.size() / 8;
            int size2 = this.f21490f.size() % 8;
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(8);
            }
            if (size2 != 0) {
                arrayList.add(Integer.valueOf(size2));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private void r() {
        try {
            s();
            t();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void s() {
        boolean z10;
        int u10;
        try {
            List<Integer> p10 = p();
            if (p10 == null || p10.size() <= 0) {
                return;
            }
            this.f21491g = new ArrayList();
            this.f21492h = new ArrayList();
            List<String> h10 = (this.f21488d.a() == null || this.f21488d.a().size() <= 0) ? null : h(this.f21488d.a());
            int i10 = 0;
            for (Integer num : p10) {
                int intValue = num.intValue();
                ArrayList arrayList = new ArrayList();
                this.f21492h.add(arrayList);
                for (int i11 = 0; i11 < intValue; i11++) {
                    String str = this.f21488d.b().get(i10);
                    if (h10 == null || h10.size() <= 0 || (u10 = u(h10, str)) == -1) {
                        z10 = true;
                    } else {
                        h10.remove(u10);
                        z10 = false;
                    }
                    rd.a g10 = g(32, 40, str, i10, z10);
                    g10.setEnabled(z10);
                    g10.setOnClickListener(new b(this.f21489e, this, this.f21491g));
                    if (!z10) {
                        this.f21491g.add(g10);
                    }
                    arrayList.add(g10);
                    addView(g10);
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setCharTextViewFrame(rd.a aVar) {
        try {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(new RectShape());
            shapeDrawable.getPaint().setStrokeWidth(p0.s(1));
            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable.getPaint().setDither(true);
            shapeDrawable.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 40.0f, Color.parseColor("#bfcedc"), Color.parseColor("#515f6d"), Shader.TileMode.CLAMP));
            aVar.setBackground(shapeDrawable);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void t() {
        try {
            B();
            C();
            y();
            d();
            z();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private int u(List<String> list, String str) {
        int i10 = 0;
        while (true) {
            try {
                if (i10 >= list.size()) {
                    i10 = -1;
                    break;
                } else if (list.get(i10).equals(str)) {
                    break;
                } else {
                    i10++;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return -1;
            }
        }
        return i10;
    }

    private rd.a w(String str) {
        try {
            for (rd.a aVar : this.f21491g) {
                if (aVar.getCharValue().equals(str)) {
                    return aVar;
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private rd.a x(String str) {
        rd.a aVar = null;
        try {
            for (List<rd.a> list : this.f21492h) {
                Iterator<rd.a> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        rd.a next = it.next();
                        if (next.getCharValue().equals(str) && next.isEnabled()) {
                            aVar = next;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return aVar;
    }

    private void y() {
        try {
            int size = this.f21492h.size();
            for (int i10 = 0; i10 < size; i10++) {
                c cVar = new c();
                cVar.p(this);
                List<rd.a> list = this.f21492h.get(i10);
                int size2 = list.size();
                int[] iArr = new int[size2];
                float[] fArr = new float[size2];
                for (int i11 = 0; i11 < list.size(); i11++) {
                    iArr[i11] = list.get(x0.l1() ? (list.size() - i11) - 1 : i11).getId();
                    fArr[i11] = 1.0f;
                }
                cVar.w(0, 1, 0, 2, iArr, fArr, 2);
                cVar.i(this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void z() {
        try {
            int size = this.f21492h.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<rd.a> list = this.f21492h.get(i10);
                for (int i11 = 1; i11 < list.size(); i11++) {
                    rd.a aVar = list.get(i11);
                    if (x0.l1()) {
                        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) aVar.getLayoutParams())).rightMargin = p0.s(8);
                    } else {
                        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) aVar.getLayoutParams())).leftMargin = p0.s(8);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void A(sd.b bVar, sd.a aVar) {
        this.f21488d = bVar;
        this.f21489e = aVar;
        this.f21490f = bVar.b();
        r();
    }

    public void f() {
        try {
            for (int size = this.f21491g.size() - 1; size >= 0; size--) {
                rd.a aVar = this.f21491g.get(size);
                aVar.setEnabled(true);
                aVar.setTextColor(Color.parseColor("#ffffff"));
                this.f21491g.remove(size);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public List<String> getDisabledCharactersList() {
        ArrayList arrayList;
        Exception e10;
        try {
            arrayList = new ArrayList();
            try {
                for (rd.a aVar : this.f21491g) {
                    arrayList.add(aVar.getCharValue());
                }
            } catch (Exception e11) {
                e10 = e11;
                x0.N1(e10);
                return arrayList;
            }
        } catch (Exception e12) {
            arrayList = null;
            e10 = e12;
        }
        return arrayList;
    }

    public List<String> getOptionalCharacters() {
        return this.f21490f;
    }

    public void i(String str) {
        try {
            rd.a x10 = x(str);
            if (x10 != null) {
                x10.setTextColor(Color.parseColor("#515f6d"));
                x10.setEnabled(false);
                this.f21491g.add(x10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void q(String str) {
        try {
            rd.a w10 = w(str);
            if (w10 != null) {
                this.f21491g.remove(w10);
                w10.setTextColor(Color.parseColor("#ffffff"));
                w10.setEnabled(true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
