package com.scores365.ui.bettingViews;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.t;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import lf.u;
import li.x0;
import rf.d1;
/* compiled from: LineupOddsBrandedListItem.kt */
/* loaded from: classes2.dex */
public final class LineupOddsBrandedListItem extends com.scores365.Design.PageObjects.b {
    public static final Companion Companion = new Companion(null);
    private final List<BetLine> betLines;
    private final BookMakerObj bookmaker;
    private final GameObj gameObj;

    /* compiled from: LineupOddsBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t onCreateViewHolder(ViewGroup parent) {
            m.g(parent, "parent");
            d1 c10 = d1.c(LayoutInflater.from(parent.getContext()), parent, false);
            m.f(c10, "inflate(LayoutInflater.f….context), parent, false)");
            return new LineupsOddsBrandedListItem(c10);
        }
    }

    /* compiled from: LineupOddsBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class LineupsOddsBrandedListItem extends t {
        private final d1 binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LineupsOddsBrandedListItem(d1 binding) {
            super(binding.getRoot());
            m.g(binding, "binding");
            this.binding = binding;
        }

        public final void bind(BookMakerObj bookmaker, List<? extends BetLine> betLines, GameObj gameObj) {
            m.g(bookmaker, "bookmaker");
            m.g(betLines, "betLines");
            m.g(gameObj, "gameObj");
            this.binding.f37636b.handleFrameUIData(bookmaker, betLines, x0.l(gameObj.homeAwayTeamOrder, true), gameObj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LineupOddsBrandedListItem(BookMakerObj bookmaker, List<? extends BetLine> betLines, GameObj gameObj) {
        m.g(bookmaker, "bookmaker");
        m.g(betLines, "betLines");
        m.g(gameObj, "gameObj");
        this.bookmaker = bookmaker;
        this.betLines = betLines;
        this.gameObj = gameObj;
    }

    public final List<BetLine> getBetLines() {
        return this.betLines;
    }

    public final BookMakerObj getBookmaker() {
        return this.bookmaker;
    }

    public final GameObj getGameObj() {
        return this.gameObj;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.LineupsOddsBrandedListItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof LineupsOddsBrandedListItem) {
            ((LineupsOddsBrandedListItem) e0Var).bind(this.bookmaker, this.betLines, this.gameObj);
        }
    }
}
