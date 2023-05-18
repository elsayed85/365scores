package com.scores365.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLineOption;
import com.scores365.entitys.oddsPreviewEntities.OddsPreviewCell;
import java.util.ArrayList;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ScoresOddsView extends LinearLayout {
    View divider;
    ArrayList<ImageView> imageViews;
    View odd1;
    View odd2;
    View odd3;
    ArrayList<View> oddsViews;
    private float singleOddsWidthCellOnTwoOptions;
    ArrayList<TextView> textViews;
    ArrayList<TextView> textViewsYellow;
    ArrayList<TextView> titleViews;

    public ScoresOddsView(Context context) {
        super(context);
        this.singleOddsWidthCellOnTwoOptions = -1.0f;
        init();
    }

    public ScoresOddsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.singleOddsWidthCellOnTwoOptions = -1.0f;
        init();
    }

    public ScoresOddsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.singleOddsWidthCellOnTwoOptions = -1.0f;
        init();
    }

    private void init() {
        try {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.Z7, this);
            this.divider = findViewById(R.id.G4);
            this.odd1 = findViewById(R.id.WB);
            this.odd2 = findViewById(R.id.XB);
            this.odd3 = findViewById(R.id.YB);
            ArrayList<View> arrayList = new ArrayList<>();
            this.oddsViews = arrayList;
            arrayList.add(this.odd1);
            this.oddsViews.add(this.odd2);
            this.oddsViews.add(this.odd3);
            ArrayList<TextView> arrayList2 = new ArrayList<>();
            this.titleViews = arrayList2;
            arrayList2.add((TextView) this.odd1.findViewById(R.id.Xi));
            this.titleViews.add((TextView) this.odd2.findViewById(R.id.Xi));
            this.titleViews.add((TextView) this.odd3.findViewById(R.id.Xi));
            ArrayList<TextView> arrayList3 = new ArrayList<>();
            this.textViewsYellow = arrayList3;
            arrayList3.add((TextView) this.odd1.findViewById(R.id.f22255qj));
            this.textViewsYellow.add((TextView) this.odd2.findViewById(R.id.f22255qj));
            this.textViewsYellow.add((TextView) this.odd3.findViewById(R.id.f22255qj));
            ArrayList<ImageView> arrayList4 = new ArrayList<>();
            this.imageViews = arrayList4;
            arrayList4.add((ImageView) this.odd1.findViewById(R.id.f22167mj));
            this.imageViews.add((ImageView) this.odd2.findViewById(R.id.f22167mj));
            this.imageViews.add((ImageView) this.odd3.findViewById(R.id.f22167mj));
            ArrayList<TextView> arrayList5 = new ArrayList<>();
            this.textViews = arrayList5;
            arrayList5.add((TextView) this.odd1.findViewById(R.id.f22189nj));
            this.textViews.add((TextView) this.odd2.findViewById(R.id.f22189nj));
            this.textViews.add((TextView) this.odd3.findViewById(R.id.f22189nj));
            this.titleViews.get(0).setTypeface(o0.c(App.m()));
            this.titleViews.get(1).setTypeface(o0.c(App.m()));
            this.titleViews.get(2).setTypeface(o0.c(App.m()));
            this.textViews.get(0).setTypeface(o0.d(App.m()));
            this.textViews.get(1).setTypeface(o0.d(App.m()));
            this.textViews.get(2).setTypeface(o0.d(App.m()));
            this.textViewsYellow.get(0).setTypeface(o0.d(App.m()));
            this.textViewsYellow.get(1).setTypeface(o0.d(App.m()));
            this.textViewsYellow.get(2).setTypeface(o0.d(App.m()));
            this.singleOddsWidthCellOnTwoOptions = (App.p() - (getResources().getDimension(R.dimen.I) * 2.0f)) / 2.0f;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void resetViews(boolean z10) {
        int i10 = x0.n1() ? 0 : 100;
        int k10 = androidx.core.graphics.a.k(p0.A(R.attr.f21603z0), 100);
        int k11 = androidx.core.graphics.a.k(p0.A(R.attr.A0), i10);
        View view = this.oddsViews.get(0);
        View view2 = this.oddsViews.get(1);
        View view3 = this.oddsViews.get(2);
        view.setBackgroundColor(k10);
        view2.setBackgroundColor(k11);
        view3.setBackgroundColor(k10);
        if (!z10) {
            this.divider.setVisibility(8);
            view2.setVisibility(0);
            if (x0.n1()) {
                return;
            }
            setPadding(p0.s(1), p0.s(1), p0.s(1), p0.s(1));
            return;
        }
        view2.setVisibility(8);
        this.divider.setVisibility(8);
        view.setBackgroundColor(k11);
        view3.setBackgroundColor(k10);
        if (x0.n1()) {
            this.divider.setBackgroundColor(p0.B(R.color.f21622l));
        }
    }

    public void setBetLineFromOptions(BetLineOption[] betLineOptionArr, boolean z10, int i10, boolean z11, boolean z12, int i11) {
        try {
            String[] strArr = new String[betLineOptionArr.length];
            String[] strArr2 = new String[betLineOptionArr.length];
            for (int i12 = 0; i12 < betLineOptionArr.length; i12++) {
                strArr[i12] = betLineOptionArr[i12].getOddsByUserChoice();
                strArr2[i12] = App.l().bets.getLineTypes().get(Integer.valueOf(i10)).getNameByTypeAndNum(betLineOptionArr[i12].getNum());
            }
            setBetLineFromOptions(strArr, strArr2, z10, z11, z12, betLineOptionArr, i11);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setBetLineFromOptions(String[] strArr, String[] strArr2, boolean z10, boolean z11, boolean z12, BetLineOption[] betLineOptionArr, int i10) {
        int termArrowId;
        try {
            resetViews(betLineOptionArr.length == 2);
            for (int i11 = 0; i11 < strArr.length; i11++) {
                int length = x0.l(i10, true) ? (strArr.length - 1) - i11 : i11;
                if (length != 0 && betLineOptionArr.length == 2) {
                    length++;
                }
                this.oddsViews.get(length).setVisibility(0);
                this.textViews.get(length).setText(strArr[i11]);
                this.textViews.get(length).setVisibility(0);
                this.titleViews.get(length).setText(strArr2[i11]);
                this.titleViews.get(length).setVisibility(0);
                this.textViewsYellow.get(length).setVisibility(8);
                if (betLineOptionArr[i11].lead != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("(");
                    sb2.append(betLineOptionArr[i11].lead);
                    sb2.append(")");
                    this.textViewsYellow.get(length).setText(sb2);
                    this.textViewsYellow.get(length).setVisibility(0);
                }
                this.imageViews.get(length).setVisibility(8);
                if (betLineOptionArr[i11].doesHaveOldRate() && (termArrowId = betLineOptionArr[i11].getTermArrowId()) != -1) {
                    this.imageViews.get(length).setImageResource(termArrowId);
                    this.imageViews.get(length).setVisibility(0);
                }
                if (!z11 && !z12 && (!z10 || !betLineOptionArr[i11].won)) {
                    this.textViews.get(length).setTextColor(p0.A(R.attr.f21565m1));
                    this.titleViews.get(length).setTextColor(p0.A(R.attr.f21565m1));
                    this.textViews.get(length).setTextSize(1, 11.0f);
                    if (z11 && !x0.n1()) {
                        this.textViews.get(length).setTextColor(getResources().getColor(R.color.f21635y));
                    }
                }
                this.textViews.get(length).setTextColor(p0.A(R.attr.U0));
                this.titleViews.get(length).setTextColor(p0.A(R.attr.U0));
                this.textViews.get(length).setTextSize(1, 11.0f);
                if (z11) {
                    this.textViews.get(length).setTextColor(getResources().getColor(R.color.f21635y));
                }
            }
            int s10 = p0.s(91);
            if (strArr.length == 3) {
                int p10 = (App.p() - (s10 * 3)) / 2;
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) getLayoutParams())).leftMargin = p10;
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) getLayoutParams())).rightMargin = p10;
            } else if (strArr.length == 2) {
                int p11 = (App.p() - (s10 * 2)) / 2;
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) getLayoutParams())).leftMargin = p11;
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) getLayoutParams())).rightMargin = p11;
            }
            measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setOddsPreview(ArrayList<OddsPreviewCell> arrayList, int i10) {
        try {
            resetViews(arrayList.size() == 2);
            boolean z10 = false;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                int size = x0.l(i10, true) ? (arrayList.size() - 1) - i11 : i11;
                if (size != 0 && arrayList.size() == 2) {
                    size++;
                }
                this.titleViews.get(size).setVisibility(8);
                this.textViewsYellow.get(size).setVisibility(8);
                this.imageViews.get(size).setVisibility(8);
                this.oddsViews.get(size).setVisibility(0);
                this.textViews.get(size).setVisibility(0);
                this.textViews.get(size).setText(arrayList.get(i11).getText());
                if (arrayList.size() == 2) {
                    TextPaint textPaint = new TextPaint();
                    textPaint.setAntiAlias(true);
                    textPaint.setTextSize(getResources().getDisplayMetrics().density * 13.0f);
                    if (textPaint.measureText(this.textViews.get(size).getText().toString()) > this.singleOddsWidthCellOnTwoOptions) {
                        z10 = true;
                    }
                }
                if (arrayList.get(i11).isBold()) {
                    this.textViews.get(size).setTextColor(p0.A(R.attr.U0));
                } else {
                    this.textViews.get(size).setTextColor(p0.A(R.attr.f21565m1));
                }
                this.textViews.get(size).setTextSize(1, 11.0f);
            }
            measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int s10 = z10 ? p0.s(16) : (int) getResources().getDimension(R.dimen.I);
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) getLayoutParams())).leftMargin = s10;
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) getLayoutParams())).rightMargin = s10;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
