package com.scores365.ui.bettingViews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.g;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.oddsView.OddsContainerAdDesign;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import rf.h1;
import xf.q;
/* compiled from: LiveVSKickoffOddsBrandedItem.kt */
/* loaded from: classes2.dex */
public final class LiveVSKickoffOddsBrandedItem extends OddsBrandedFrame {
    private h1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVSKickoffOddsBrandedItem(Context context) {
        super(context, null, 0, 6, null);
        m.g(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVSKickoffOddsBrandedItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        m.g(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveVSKickoffOddsBrandedItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        initView();
    }

    public /* synthetic */ LiveVSKickoffOddsBrandedItem(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    public final h1 getBinding() {
        return this.binding;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public BookmakerDescriptionView getBookmakerDescriptionView() {
        h1 h1Var = this.binding;
        m.d(h1Var);
        BookmakerDescriptionView bookmakerDescriptionView = h1Var.f37729b;
        m.f(bookmakerDescriptionView, "binding!!.bookmakerDescriptionView");
        return bookmakerDescriptionView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public ImageView getBookmakerImageView() {
        h1 h1Var = this.binding;
        m.d(h1Var);
        ImageView imageView = h1Var.f37730c;
        m.f(imageView, "binding!!.ivBookmaker");
        return imageView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public View getFrameRootView() {
        h1 h1Var = this.binding;
        m.d(h1Var);
        ConstraintLayout root = h1Var.getRoot();
        m.f(root, "binding!!.root");
        return root;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public TextView getSponsoredTitleTextView() {
        h1 h1Var = this.binding;
        m.d(h1Var);
        TextView textView = h1Var.f37735h;
        m.f(textView, "binding!!.tvSoneseredTitle");
        return textView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void handleBetLineData(BookMakerObj bookmaker, List<? extends BetLine> lines, boolean z10, GameObj gameObj) {
        m.g(bookmaker, "bookmaker");
        m.g(lines, "lines");
        m.g(gameObj, "gameObj");
        h1 h1Var = this.binding;
        m.d(h1Var);
        TextView textView = h1Var.f37733f;
        textView.setText(p0.l0("ODDS_COMPARISON_LIVE"));
        textView.setTypeface(g.a(textView.getContext(), o0.d(textView.getContext()), 1));
        h1 h1Var2 = this.binding;
        m.d(h1Var2);
        OddsContainerAdDesign oddsContainerAdDesign = h1Var2.f37731d;
        m.f(oddsContainerAdDesign, "binding!!.oddsContainerAdDesign");
        OddsContainerAdDesign.p(oddsContainerAdDesign, lines.get(0), bookmaker, z10, 0, 0, 0, false, "odds-comparison", gameObj, false, false, 120, null);
        h1 h1Var3 = this.binding;
        m.d(h1Var3);
        TextView textView2 = h1Var3.f37734g;
        textView2.setText(p0.l0("ODDS_COMPARISON_PRE"));
        textView2.setTypeface(o0.c(App.m()));
        textView2.setTextColor(Color.parseColor(bookmaker.generalTextColor));
        h1 h1Var4 = this.binding;
        m.d(h1Var4);
        OddsContainerAdDesign oddsContainerAdDesignPreGame = h1Var4.f37732e;
        int A = p0.A(R.attr.f21565m1);
        int A2 = p0.A(R.attr.f21565m1);
        m.f(oddsContainerAdDesignPreGame, "oddsContainerAdDesignPreGame");
        OddsContainerAdDesign.p(oddsContainerAdDesignPreGame, lines.get(0), bookmaker, z10, 0, A, A2, true, "odds-comparison", gameObj, false, false, 8, null);
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void initView() {
        this.binding = h1.c(LayoutInflater.from(getContext()), this, true);
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void setAnalParams(BetLine line, GameObj gameObj, q.g.a clickListener) {
        m.g(line, "line");
        m.g(gameObj, "gameObj");
        m.g(clickListener, "clickListener");
        clickListener.a(gameObj, line, false, false, false, "odds-comparison", false, null, false, -1);
    }

    public final void setBinding(h1 h1Var) {
        this.binding = h1Var;
    }
}
