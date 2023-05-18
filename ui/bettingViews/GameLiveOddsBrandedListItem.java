package com.scores365.ui.bettingViews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import lf.u;
import li.x0;
import rf.g1;
/* compiled from: GameLiveOddsBrandedListItem.kt */
/* loaded from: classes2.dex */
public final class GameLiveOddsBrandedListItem extends com.scores365.Design.PageObjects.b {
    public static final Companion Companion = new Companion(null);
    private static int adDesignHeight;
    private static int itemHeight;
    private final List<BetLine> betLines;
    private BookMakerObj bookmaker;
    private GameObj gameObj;
    private boolean isTeamsRTL;

    /* compiled from: GameLiveOddsBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clear() {
            setItemHeight(0);
            setAdDesignHeight(0);
        }

        public final int getAdDesignHeight() {
            return GameLiveOddsBrandedListItem.adDesignHeight;
        }

        public final int getItemHeight() {
            return GameLiveOddsBrandedListItem.itemHeight;
        }

        public final t onCreateViewHolder(ViewGroup parent) {
            m.g(parent, "parent");
            g1 c10 = g1.c(LayoutInflater.from(parent.getContext()), parent, false);
            m.f(c10, "inflate(LayoutInflater.f….context), parent, false)");
            return new LiveOddsBrandedInnerListItem(c10);
        }

        public final void setAdDesignHeight(int i10) {
            GameLiveOddsBrandedListItem.adDesignHeight = i10;
        }

        public final void setItemHeight(int i10) {
            GameLiveOddsBrandedListItem.itemHeight = i10;
        }
    }

    /* compiled from: GameLiveOddsBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class LiveOddsBrandedInnerListItem extends t {
        private final g1 binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveOddsBrandedInnerListItem(g1 binding) {
            super(binding.getRoot());
            m.g(binding, "binding");
            this.binding = binding;
        }

        private final void setMaxHeight() {
            this.binding.getRoot().measure(0, 0);
            View findViewById = this.binding.getRoot().findViewById(R.id.Zi);
            findViewById.measure(0, 0);
            int measuredHeight = this.binding.getRoot().getMeasuredHeight();
            int measuredHeight2 = findViewById.getMeasuredHeight();
            Companion companion = GameLiveOddsBrandedListItem.Companion;
            if (companion.getItemHeight() < measuredHeight) {
                companion.setItemHeight(measuredHeight);
            }
            if (companion.getAdDesignHeight() < measuredHeight2) {
                companion.setAdDesignHeight(measuredHeight2);
            }
            this.binding.getRoot().getLayoutParams().height = companion.getItemHeight();
            findViewById.getLayoutParams().height = companion.getAdDesignHeight();
        }

        public final void bind(GameLiveOddsBrandedListItem item) {
            m.g(item, "item");
            try {
                LiveOddsBrandedItem liveOddsBrandedItem = this.binding.f37709b;
                BookMakerObj bookmaker = item.getBookmaker();
                List<BetLine> betLines = item.getBetLines();
                boolean isTeamsRTL = item.isTeamsRTL();
                GameObj gameObj = item.getGameObj();
                m.d(gameObj);
                liveOddsBrandedItem.handleFrameUIData(bookmaker, betLines, isTeamsRTL, gameObj);
                setMaxHeight();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public GameLiveOddsBrandedListItem() {
        this.betLines = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameLiveOddsBrandedListItem(BetLine odd, BookMakerObj bookmaker, GameObj gameObj) {
        this();
        m.g(odd, "odd");
        m.g(bookmaker, "bookmaker");
        m.g(gameObj, "gameObj");
        this.betLines.add(odd);
        this.bookmaker = bookmaker;
        this.gameObj = gameObj;
        this.isTeamsRTL = x0.l(gameObj.homeAwayTeamOrder, true);
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
        return u.LiveOddsBrandedListItem.ordinal();
    }

    public final boolean isTeamsRTL() {
        return this.isTeamsRTL;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof LiveOddsBrandedInnerListItem) {
            ((LiveOddsBrandedInnerListItem) e0Var).bind(this);
        }
    }

    public final void setBookmaker(BookMakerObj bookMakerObj) {
        this.bookmaker = bookMakerObj;
    }

    public final void setGameObj(GameObj gameObj) {
        this.gameObj = gameObj;
    }

    public final void setTeamsRTL(boolean z10) {
        this.isTeamsRTL = z10;
    }
}
