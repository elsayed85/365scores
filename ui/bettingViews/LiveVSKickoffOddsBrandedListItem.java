package com.scores365.ui.bettingViews;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.gameCenter.i0;
import com.scores365.ui.OddsView;
import ee.k;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.x0;
import rf.i1;
import xf.u;
/* compiled from: LiveVSKickoffOddsBrandedListItem.kt */
/* loaded from: classes2.dex */
public final class LiveVSKickoffOddsBrandedListItem extends com.scores365.Design.PageObjects.b {
    public static final Companion Companion = new Companion(null);
    private final List<BetLine> betLines;
    private final BookMakerObj bookmaker;
    private final GameObj gameObj;

    /* compiled from: LiveVSKickoffOddsBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t onCreateViewHolder(ViewGroup parent) {
            m.g(parent, "parent");
            i1 c10 = i1.c(LayoutInflater.from(parent.getContext()), parent, false);
            m.f(c10, "inflate(LayoutInflater.f….context), parent, false)");
            return new C0264LiveVSKickoffOddsBrandedListItem(c10);
        }
    }

    /* compiled from: LiveVSKickoffOddsBrandedListItem.kt */
    /* renamed from: com.scores365.ui.bettingViews.LiveVSKickoffOddsBrandedListItem$LiveVSKickoffOddsBrandedListItem  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0264LiveVSKickoffOddsBrandedListItem extends t {
        private final i1 binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0264LiveVSKickoffOddsBrandedListItem(i1 binding) {
            super(binding.getRoot());
            m.g(binding, "binding");
            this.binding = binding;
        }

        public final void bind(BookMakerObj bookmaker, List<? extends BetLine> betLines, GameObj gameObj) {
            m.g(bookmaker, "bookmaker");
            m.g(betLines, "betLines");
            m.g(gameObj, "gameObj");
            try {
                this.binding.f37754b.handleFrameUIData(bookmaker, betLines, x0.l(gameObj.homeAwayTeamOrder, true), gameObj);
                if (u.f42585f) {
                    return;
                }
                u.f42585f = true;
                k.n(App.m(), "gamecenter", "bets-impressions", "show", null, false, "game_id", String.valueOf(gameObj.getID()), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(gameObj), "section", "8", "market_type", String.valueOf(betLines.get(0).type), "bookie_id", String.valueOf(betLines.get(0).bookmakerId), "button_design", OddsView.getBetNowBtnDesignForAnalytics());
                ke.d.p(betLines.get(0).getTrackingURL());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveVSKickoffOddsBrandedListItem(BookMakerObj bookmaker, List<? extends BetLine> betLines, GameObj gameObj) {
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
        return lf.u.LiveVSKickoffOddsBrandedListItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof C0264LiveVSKickoffOddsBrandedListItem) {
            ((C0264LiveVSKickoffOddsBrandedListItem) e0Var).bind(this.bookmaker, this.betLines, this.gameObj);
        }
    }
}
