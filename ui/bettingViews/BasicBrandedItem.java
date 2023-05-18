package com.scores365.ui.bettingViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.oddsView.OddsContainerAdDesign;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.p0;
import rf.e1;
import xf.q;
/* compiled from: BasicBrandedItem.kt */
/* loaded from: classes2.dex */
public class BasicBrandedItem extends OddsBrandedFrame {
    private String analSource;
    private e1 binding;
    private boolean isOnlyCenterOddEnabled;
    private boolean useBiggerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicBrandedItem(Context context) {
        super(context, null, 0, 6, null);
        m.g(context, "context");
        this.analSource = "lineups";
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicBrandedItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        m.g(context, "context");
        this.analSource = "lineups";
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicBrandedItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.analSource = "lineups";
        initView();
    }

    public /* synthetic */ BasicBrandedItem(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    public final String getAnalSource() {
        return this.analSource;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public BookmakerDescriptionView getBookmakerDescriptionView() {
        e1 e1Var = this.binding;
        m.d(e1Var);
        BookmakerDescriptionView bookmakerDescriptionView = e1Var.f37651b;
        m.f(bookmakerDescriptionView, "binding!!.bookmakerDescriptionView");
        return bookmakerDescriptionView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public ImageView getBookmakerImageView() {
        e1 e1Var = this.binding;
        m.d(e1Var);
        ImageView imageView = e1Var.f37652c;
        m.f(imageView, "binding!!.ivBookmaker");
        return imageView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public View getFrameRootView() {
        e1 e1Var = this.binding;
        m.d(e1Var);
        ConstraintLayout root = e1Var.getRoot();
        m.f(root, "binding!!.root");
        return root;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public TextView getSponsoredTitleTextView() {
        e1 e1Var = this.binding;
        m.d(e1Var);
        TextView textView = e1Var.f37654e;
        m.f(textView, "binding!!.tvSoneseredTitle");
        return textView;
    }

    public final boolean getUseBiggerView() {
        return this.useBiggerView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void handleBetLineData(BookMakerObj bookmaker, List<? extends BetLine> lines, boolean z10, GameObj gameObj) {
        m.g(bookmaker, "bookmaker");
        m.g(lines, "lines");
        m.g(gameObj, "gameObj");
        e1 e1Var = this.binding;
        if (e1Var != null) {
            OddsContainerAdDesign handleBetLineData$lambda$2$lambda$0 = e1Var.f37653d;
            handleBetLineData$lambda$2$lambda$0.setOnlyCenterOddEnabled(this.isOnlyCenterOddEnabled);
            m.f(handleBetLineData$lambda$2$lambda$0, "handleBetLineData$lambda$2$lambda$0");
            OddsContainerAdDesign.p(handleBetLineData$lambda$2$lambda$0, lines.get(0), bookmaker, z10, 0, 0, 0, false, this.analSource, gameObj, false, true, 120, null);
            if (this.useBiggerView) {
                e1Var.getRoot().getLayoutParams().height = p0.s(88);
                ViewGroup.LayoutParams layoutParams = e1Var.f37653d.getLayoutParams();
                m.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = p0.s(26);
                ViewGroup.LayoutParams layoutParams2 = e1Var.f37651b.getLayoutParams();
                m.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = 0;
                bVar.f4632j = -1;
                bVar.f4636l = 0;
            }
        }
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public final void initView() {
        this.binding = e1.c(LayoutInflater.from(getContext()), this, true);
    }

    public final boolean isOnlyCenterOddEnabled() {
        return this.isOnlyCenterOddEnabled;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void setAnalParams(BetLine line, GameObj gameObj, q.g.a clickListener) {
        m.g(line, "line");
        m.g(gameObj, "gameObj");
        m.g(clickListener, "clickListener");
        clickListener.a(gameObj, line, false, false, false, this.analSource, true, null, false, -1);
    }

    public final void setAnalSource(String str) {
        m.g(str, "<set-?>");
        this.analSource = str;
    }

    public final void setOnlyCenterOddEnabled(boolean z10) {
        this.isOnlyCenterOddEnabled = z10;
    }

    public final void setUseBiggerView(boolean z10) {
        this.useBiggerView = z10;
    }
}
