package com.scores365.Quiz.CustomViews.quizAnswer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
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
public class QuizAnswerView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private com.scores365.Quiz.CustomViews.quizAnswer.a f21479d;

    /* renamed from: e  reason: collision with root package name */
    private rd.b f21480e;

    /* renamed from: f  reason: collision with root package name */
    private List<List<rd.a>> f21481f;

    /* renamed from: g  reason: collision with root package name */
    private List<List<Integer>> f21482g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        rd.b f21483a;

        private b(rd.b bVar) {
            this.f21483a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                String charSequence = ((rd.a) view).getText().toString();
                rd.b bVar = this.f21483a;
                if (bVar == null || !bVar.h(charSequence, ((rd.a) view).getCharIndex())) {
                    return;
                }
                ((rd.a) view).setCharValue(" ");
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public QuizAnswerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QuizAnswerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void A() {
        try {
            c cVar = new c();
            cVar.p(this);
            int size = this.f21481f.size();
            if (size <= 1) {
                ((ConstraintLayout.b) this.f21481f.get(0).get(0).getLayoutParams()).f4630i = 0;
                ((ConstraintLayout.b) this.f21481f.get(0).get(0).getLayoutParams()).f4636l = 0;
                return;
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = this.f21481f.get(i10).get(0).getId();
                fArr[i10] = 1.0f;
            }
            cVar.y(0, 3, 0, 4, iArr, fArr, 2);
            cVar.i(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void B() {
        int size = this.f21481f.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                try {
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.f21481f.get(i10).get(0).getLayoutParams())).topMargin = p0.s(8);
                } catch (Exception e10) {
                    x0.N1(e10);
                    return;
                }
            }
        }
    }

    public static ArrayList<String> C(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int length = str.length() - 1; length >= 0; length--) {
                sb2.insert(0, str.charAt(length));
                if (!u(str.charAt(length))) {
                    arrayList.add(0, sb2.toString());
                    sb2 = new StringBuilder();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private void f() {
        try {
            int size = this.f21481f.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<rd.a> list = this.f21481f.get(i10);
                for (int i11 = 1; i11 < list.size() - 1; i11++) {
                    ((ConstraintLayout.b) list.get(i11).getLayoutParams()).f4630i = list.get(0).getId();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private rd.a h(int i10, int i11, String str, int i12, boolean z10) {
        rd.a aVar;
        rd.a aVar2 = null;
        try {
            aVar = new rd.a(App.m(), str, i12, z10);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            aVar.setId(View.generateViewId());
            aVar.setMaxLines(1);
            aVar.setEllipsize(TextUtils.TruncateAt.END);
            aVar.setText(str);
            aVar.setTextSize(1, 26.0f);
            aVar.setTypeface(o0.c(App.m()));
            aVar.setTextColor(Color.parseColor("#FFFFFF"));
            aVar.setGravity(1);
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

    private void i(List<Integer> list) {
        int i10 = -1;
        int i11 = 11;
        for (int i12 = 0; i12 < list.size(); i12++) {
            try {
                int intValue = list.get(i12).intValue();
                if (i11 + intValue + 1 <= 11) {
                    i11 += intValue + 1;
                } else {
                    i10++;
                    this.f21482g.add(new ArrayList());
                    i11 = intValue;
                }
                this.f21482g.get(i10).add(Integer.valueOf(intValue));
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #1 {Exception -> 0x0056, blocks: (B:14:0x004c, B:16:0x0051), top: B:26:0x004c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String p(int r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = " "
            r0.<init>(r1)
            com.scores365.Quiz.CustomViews.quizAnswer.a r1 = r6.f21479d     // Catch: java.lang.Exception -> L5b
            java.lang.String r1 = r1.b()     // Catch: java.lang.Exception -> L5b
            if (r1 == 0) goto L5f
            com.scores365.Quiz.CustomViews.quizAnswer.a r1 = r6.f21479d     // Catch: java.lang.Exception -> L5b
            java.lang.String r1 = r1.b()     // Catch: java.lang.Exception -> L5b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L5b
            if (r1 != 0) goto L5f
            com.scores365.Quiz.CustomViews.quizAnswer.a r1 = r6.f21479d     // Catch: java.lang.Exception -> L5b
            java.lang.String r1 = r1.b()     // Catch: java.lang.Exception -> L5b
            char r1 = r1.charAt(r7)     // Catch: java.lang.Exception -> L5b
            com.scores365.Quiz.CustomViews.quizAnswer.a r2 = r6.f21479d     // Catch: java.lang.Exception -> L5b
            java.lang.String r2 = r2.b()     // Catch: java.lang.Exception -> L5b
            int r2 = r2.length()     // Catch: java.lang.Exception -> L5b
            r3 = 1
            int r7 = r7 + r3
            r4 = 0
            if (r2 <= r7) goto L46
            com.scores365.Quiz.CustomViews.quizAnswer.a r2 = r6.f21479d     // Catch: java.lang.Exception -> L5b
            java.lang.String r2 = r2.b()     // Catch: java.lang.Exception -> L5b
            char r7 = r2.charAt(r7)     // Catch: java.lang.Exception -> L5b
            boolean r2 = u(r7)     // Catch: java.lang.Exception -> L5b
            r4 = r7
            if (r2 == 0) goto L46
            goto L47
        L46:
            r3 = 0
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5b
            r7.<init>()     // Catch: java.lang.Exception -> L5b
            r7.append(r1)     // Catch: java.lang.Exception -> L56
            if (r3 == 0) goto L54
            r7.append(r4)     // Catch: java.lang.Exception -> L56
        L54:
            r0 = r7
            goto L5f
        L56:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L5c
        L5b:
            r7 = move-exception
        L5c:
            li.x0.N1(r7)
        L5f:
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Quiz.CustomViews.quizAnswer.QuizAnswerView.p(int):java.lang.String");
    }

    private void q() {
        try {
            List<Integer> c10 = this.f21479d.c();
            this.f21482g = new ArrayList();
            i(c10);
            r();
            s();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void r() {
        this.f21481f = new ArrayList();
        try {
            int i10 = 0;
            int i11 = 0;
            for (List<Integer> list : this.f21482g) {
                ArrayList arrayList = new ArrayList();
                this.f21481f.add(arrayList);
                for (int i12 = 0; i12 < list.size(); i12++) {
                    if (i12 != 0) {
                        rd.a h10 = h(20, 40, " ", i10, true);
                        h10.setVisibility(4);
                        arrayList.add(h10);
                        addView(h10);
                        i10++;
                        i11++;
                    }
                    int i13 = 0;
                    while (i13 < list.get(i12).intValue()) {
                        String p10 = p(i11);
                        if (p10.length() > 1) {
                            i11++;
                        }
                        rd.a h11 = h(30, 40, p10, i10, false);
                        x(h11, i13 == list.get(i12).intValue() - 1);
                        if (this.f21479d.f21486c) {
                            h11.setEnabled(true);
                            h11.setOnClickListener(new b(this.f21480e));
                        } else {
                            h11.setEnabled(false);
                        }
                        arrayList.add(h11);
                        addView(h11);
                        i10++;
                        i11++;
                        i13++;
                    }
                }
                arrayList.add(new rd.a(App.m(), " ", i10, true));
                i10++;
                i11++;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void s() {
        try {
            A();
            B();
            z();
            f();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static boolean u(char c10) {
        return c10 == '\'' || c10 == '\"' || c10 == 1523 || c10 == 1524;
    }

    private void x(rd.a aVar, boolean z10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(p0.s(3));
        try {
            com.scores365.Quiz.CustomViews.quizAnswer.a aVar2 = this.f21479d;
            if (aVar2.f21486c) {
                gradientDrawable.setStroke(p0.s(1), Color.parseColor(aVar2.a()));
            } else {
                gradientDrawable.setStroke(p0.s(1), Color.parseColor("#515f6d"));
            }
            if (z10) {
                aVar.setBackground(gradientDrawable);
                return;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable});
            if (x0.l1()) {
                layerDrawable.setLayerInset(0, p0.s(-1), 0, 0, 0);
            } else {
                layerDrawable.setLayerInset(0, 0, 0, p0.s(-1), 0);
            }
            aVar.setBackground(layerDrawable);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void z() {
        try {
            int size = this.f21481f.size();
            for (int i10 = 0; i10 < size; i10++) {
                c cVar = new c();
                cVar.p(this);
                List<rd.a> list = this.f21481f.get(i10);
                int size2 = list.size() - 1;
                int[] iArr = new int[size2];
                float[] fArr = new float[size2];
                for (int i11 = 0; i11 < list.size() - 1; i11++) {
                    iArr[i11] = list.get(x0.l1() ? ((list.size() - 1) - i11) - 1 : i11).getId();
                    fArr[i11] = 1.0f;
                }
                cVar.w(0, 1, 0, 2, iArr, fArr, 2);
                cVar.i(this);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean d(String str) {
        try {
            for (List<rd.a> list : this.f21481f) {
                for (rd.a aVar : list) {
                    if (aVar.getCharValue().equals("") || aVar.getCharValue().equals(" ")) {
                        if (!aVar.a()) {
                            aVar.setCharValue(str);
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void g() {
        try {
            for (List<rd.a> list : this.f21481f) {
                for (rd.a aVar : list) {
                    if (!aVar.a()) {
                        aVar.setCharValue(" ");
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public String getAnswer() {
        StringBuilder sb2 = new StringBuilder("");
        for (int i10 = 0; i10 < this.f21481f.size(); i10++) {
            try {
                List<rd.a> list = this.f21481f.get(i10);
                int size = list.size();
                if (i10 == this.f21481f.size() - 1) {
                    size--;
                }
                for (int i11 = 0; i11 < size; i11++) {
                    sb2.append(list.get(i11).getCharValue());
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[Catch: Exception -> 0x0062, TryCatch #0 {Exception -> 0x0062, blocks: (B:3:0x0003, B:5:0x000b, B:7:0x0021, B:10:0x0026, B:12:0x0032, B:17:0x0041, B:19:0x004b, B:20:0x004e), top: B:26:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setFullAnswer(java.lang.String r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = 0
        L3:
            java.util.List<java.util.List<rd.a>> r3 = r11.f21481f     // Catch: java.lang.Exception -> L62
            int r3 = r3.size()     // Catch: java.lang.Exception -> L62
            if (r1 >= r3) goto L66
            java.util.List<java.util.List<rd.a>> r3 = r11.f21481f     // Catch: java.lang.Exception -> L62
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Exception -> L62
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Exception -> L62
            int r4 = r3.size()     // Catch: java.lang.Exception -> L62
            java.util.List<java.util.List<rd.a>> r5 = r11.f21481f     // Catch: java.lang.Exception -> L62
            int r5 = r5.size()     // Catch: java.lang.Exception -> L62
            r6 = 1
            int r5 = r5 - r6
            if (r1 != r5) goto L23
            int r4 = r4 + (-1)
        L23:
            r5 = 0
        L24:
            if (r5 >= r4) goto L5f
            char r7 = r12.charAt(r2)     // Catch: java.lang.Exception -> L62
            int r8 = r12.length()     // Catch: java.lang.Exception -> L62
            int r9 = r2 + 1
            if (r8 <= r9) goto L3f
            char r8 = r12.charAt(r9)     // Catch: java.lang.Exception -> L62
            boolean r10 = u(r8)     // Catch: java.lang.Exception -> L62
            if (r10 == 0) goto L40
            r2 = r9
            r9 = 1
            goto L41
        L3f:
            r8 = 0
        L40:
            r9 = 0
        L41:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L62
            r10.<init>()     // Catch: java.lang.Exception -> L62
            r10.append(r7)     // Catch: java.lang.Exception -> L62
            if (r9 == 0) goto L4e
            r10.append(r8)     // Catch: java.lang.Exception -> L62
        L4e:
            java.lang.Object r7 = r3.get(r5)     // Catch: java.lang.Exception -> L62
            rd.a r7 = (rd.a) r7     // Catch: java.lang.Exception -> L62
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Exception -> L62
            r7.setCharValue(r8)     // Catch: java.lang.Exception -> L62
            int r2 = r2 + r6
            int r5 = r5 + 1
            goto L24
        L5f:
            int r1 = r1 + 1
            goto L3
        L62:
            r12 = move-exception
            li.x0.N1(r12)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Quiz.CustomViews.quizAnswer.QuizAnswerView.setFullAnswer(java.lang.String):void");
    }

    public void setIsEditable(boolean z10) {
        this.f21479d.d(z10);
    }

    public boolean t() {
        boolean z10 = true;
        try {
            for (List<rd.a> list : this.f21481f) {
                Iterator<rd.a> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        rd.a next = it.next();
                        if (next.getCharValue().equals(" ") && !next.a()) {
                            z10 = false;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return z10;
    }

    public void w(com.scores365.Quiz.CustomViews.quizAnswer.a aVar, rd.b bVar) {
        this.f21479d = aVar;
        this.f21480e = bVar;
        q();
    }

    public String y(String str) {
        String str2 = null;
        try {
            str2 = this.f21481f.get(0).get(0).getCharValue();
            this.f21481f.get(0).get(0).setCharValue(str);
            return str2;
        } catch (Exception e10) {
            x0.N1(e10);
            return str2;
        }
    }
}
