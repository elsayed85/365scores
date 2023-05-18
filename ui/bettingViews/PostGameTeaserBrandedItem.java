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
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameTeaserObj;
import com.scores365.ui.CustomGameCenterHeaderView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.u;
import rf.e2;
import rf.y1;
import xf.q;
/* compiled from: PostGameTeaserBrandedItem.kt */
/* loaded from: classes2.dex */
public final class PostGameTeaserBrandedItem extends OddsBrandedFrame {
    private y1 binding;
    private GameObj gameObj;
    private GameTeaserObj postGameTeaser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostGameTeaserBrandedItem(Context context) {
        super(context, null, 0, 6, null);
        m.g(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostGameTeaserBrandedItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        m.g(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostGameTeaserBrandedItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        initView();
    }

    public /* synthetic */ PostGameTeaserBrandedItem(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    private final void setGameViews(GameObj gameObj, boolean z10, e2 e2Var, BookMakerObj bookMakerObj) {
        CompObj[] comps = gameObj.getComps();
        CompObj compObj = z10 ? comps[1] : comps[0];
        CompObj compObj2 = z10 ? gameObj.getComps()[0] : gameObj.getComps()[1];
        u.k(compObj.getID(), false, e2Var.f37658d);
        TextView textView = e2Var.f37672r;
        textView.setText(compObj.getShortName());
        textView.setTypeface(o0.c(textView.getContext()));
        textView.setTextColor(Color.parseColor(bookMakerObj.generalTextColor));
        e2Var.f37672r.setTextSize(1, 13.0f);
        u.k(compObj2.getID(), false, e2Var.f37657c);
        TextView textView2 = e2Var.f37668n;
        textView2.setText(compObj2.getShortName());
        textView2.setTypeface(o0.c(textView2.getContext()));
        textView2.setTextColor(Color.parseColor(bookMakerObj.generalTextColor));
        e2Var.f37668n.setTextSize(1, 13.0f);
        TextView textView3 = e2Var.f37670p;
        textView3.setText(CustomGameCenterHeaderView.getDateString(gameObj.getSTime()));
        textView3.setTypeface(g.a(textView3.getContext(), o0.d(textView3.getContext()), 1));
        textView3.setTextColor(Color.parseColor(bookMakerObj.generalTextColor));
        e2Var.f37670p.setTextSize(1, 14.0f);
        e2Var.f37670p.setVisibility(0);
        e2Var.f37656b.setVisibility(0);
    }

    public final y1 getBinding() {
        return this.binding;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public BookmakerDescriptionView getBookmakerDescriptionView() {
        y1 y1Var = this.binding;
        m.d(y1Var);
        BookmakerDescriptionView bookmakerDescriptionView = y1Var.f38166b;
        m.f(bookmakerDescriptionView, "binding!!.bookmakerDescriptionView");
        return bookmakerDescriptionView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public ImageView getBookmakerImageView() {
        y1 y1Var = this.binding;
        m.d(y1Var);
        ImageView imageView = y1Var.f38169e;
        m.f(imageView, "binding!!.ivBookmaker");
        return imageView;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public View getFrameRootView() {
        y1 y1Var = this.binding;
        m.d(y1Var);
        ConstraintLayout root = y1Var.getRoot();
        m.f(root, "binding!!.root");
        return root;
    }

    public final GameObj getGameObj() {
        return this.gameObj;
    }

    public final GameTeaserObj getPostGameTeaser() {
        return this.postGameTeaser;
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public TextView getSponsoredTitleTextView() {
        y1 y1Var = this.binding;
        m.d(y1Var);
        TextView textView = y1Var.f38173i;
        m.f(textView, "binding!!.tvSoneseredTitle");
        return textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0154  */
    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleBetLineData(com.scores365.bets.model.BookMakerObj r24, java.util.List<? extends com.scores365.bets.model.BetLine> r25, boolean r26, com.scores365.entitys.GameObj r27) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.bettingViews.PostGameTeaserBrandedItem.handleBetLineData(com.scores365.bets.model.BookMakerObj, java.util.List, boolean, com.scores365.entitys.GameObj):void");
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void initView() {
        this.binding = y1.c(LayoutInflater.from(getContext()), this, true);
    }

    @Override // com.scores365.ui.bettingViews.OddsBrandedFrame
    public void setAnalParams(BetLine line, GameObj gameObj, q.g.a clickListener) {
        m.g(line, "line");
        m.g(gameObj, "gameObj");
        m.g(clickListener, "clickListener");
        clickListener.a(gameObj, line, false, false, false, "game-teaser", false, null, false, -1);
    }

    public final void setBinding(y1 y1Var) {
        this.binding = y1Var;
    }

    public final void setGameObj(GameObj gameObj) {
        this.gameObj = gameObj;
    }

    public final void setPostGameTeaser(GameTeaserObj gameTeaserObj) {
        this.postGameTeaser = gameTeaserObj;
    }
}
