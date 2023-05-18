package com.scores365.ui.bettingViews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineType;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.oddsView.OddsContainerAdDesign;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import rf.f1;
import xf.q;
/* compiled from: LiveOddsBrandedItem.kt */
/* loaded from: classes2.dex */
public final class LiveOddsBrandedItem extends OddsBrandedFrame {
    private f1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOddsBrandedItem(Context context) {
        super(context, null, 0, 6, null);
        m.g(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOddsBrandedItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        m.g(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOddsBrandedItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        initView();
    }

    public /* synthetic */ LiveOddsBrandedItem(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public BookmakerDescriptionView getBookmakerDescriptionView() {
        f1 f1Var = this.binding;
        m.d(f1Var);
        BookmakerDescriptionView bookmakerDescriptionView = f1Var.f37694b;
        m.f(bookmakerDescriptionView, "binding!!.bookmakerDescriptionView");
        return bookmakerDescriptionView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public ImageView getBookmakerImageView() {
        f1 f1Var = this.binding;
        m.d(f1Var);
        ImageView imageView = f1Var.f37695c;
        m.f(imageView, "binding!!.ivBookmaker");
        return imageView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public View getFrameRootView() {
        f1 f1Var = this.binding;
        m.d(f1Var);
        ConstraintLayout root = f1Var.getRoot();
        m.f(root, "binding!!.root");
        return root;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public TextView getSponsoredTitleTextView() {
        f1 f1Var = this.binding;
        m.d(f1Var);
        TextView textView = f1Var.f37698f;
        m.f(textView, "binding!!.tvSoneseredTitle");
        return textView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void handleBetLineData(BookMakerObj bookmaker, List<? extends BetLine> lines, boolean z10, GameObj gameObj) {
        m.g(bookmaker, "bookmaker");
        m.g(lines, "lines");
        m.g(gameObj, "gameObj");
        f1 f1Var = this.binding;
        m.d(f1Var);
        TextView textView = f1Var.f37697e;
        textView.setTypeface(o0.d(textView.getContext()));
        BetLineType betLineType = App.l().bets.getLineTypes().get(Integer.valueOf(lines.get(0).type));
        String name = betLineType != null ? betLineType.getName() : null;
        m.d(name);
        StringBuilder sb2 = new StringBuilder(name);
        if (lines.get(0).optionAlias != null) {
            sb2.append(" (");
            sb2.append(lines.get(0).optionAlias);
            sb2.append(") ");
        }
        textView.setText(sb2);
        textView.setTextColor(Color.parseColor(bookmaker.generalTextColor));
        f1 f1Var2 = this.binding;
        m.d(f1Var2);
        OddsContainerAdDesign oddsContainerAdDesign = f1Var2.f37696d;
        m.f(oddsContainerAdDesign, "binding!!.oddsContainerAdDesign");
        OddsContainerAdDesign.p(oddsContainerAdDesign, lines.get(0), bookmaker, z10, 0, 0, 0, false, "live-odds", gameObj, false, false, 120, null);
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void initView() {
        this.binding = f1.c(LayoutInflater.from(getContext()), this, true);
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void setAnalParams(BetLine line, GameObj gameObj, q.g.a clickListener) {
        m.g(line, "line");
        m.g(gameObj, "gameObj");
        m.g(clickListener, "clickListener");
        clickListener.a(gameObj, line, false, false, false, "live-odds", false, null, false, -1);
    }
}
