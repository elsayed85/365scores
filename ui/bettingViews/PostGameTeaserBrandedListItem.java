package com.scores365.ui.bettingViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BetLineType;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.GameTeaserObj;
import com.scores365.gameCenter.i0;
import com.scores365.ui.OddsView;
import ee.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import lf.u;
import li.x0;
import rf.z1;
/* compiled from: PostGameTeaserBrandedListItem.kt */
/* loaded from: classes2.dex */
public final class PostGameTeaserBrandedListItem extends com.scores365.Design.PageObjects.b {
    public static final Companion Companion = new Companion(null);
    private final List<BetLine> betLines;
    private BookMakerObj bookmaker;
    private GameObj gameObj;
    public GameTeaserObj gameTeaserObj;

    /* compiled from: PostGameTeaserBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t onCreateViewHolder(ViewGroup parent) {
            m.g(parent, "parent");
            z1 c10 = z1.c(LayoutInflater.from(parent.getContext()), parent, false);
            m.f(c10, "inflate(LayoutInflater.f….context), parent, false)");
            return new PostGameTeaserBrandedListItemHolder(c10);
        }
    }

    /* compiled from: PostGameTeaserBrandedListItem.kt */
    /* loaded from: classes2.dex */
    public static final class PostGameTeaserBrandedListItemHolder extends t {
        private final z1 binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostGameTeaserBrandedListItemHolder(z1 binding) {
            super(binding.getRoot());
            m.g(binding, "binding");
            this.binding = binding;
        }

        public final void bind(BookMakerObj bookmaker, List<? extends BetLine> betLines, GameObj gameObj, GameTeaserObj gameTeaserObj) {
            m.g(bookmaker, "bookmaker");
            m.g(betLines, "betLines");
            m.g(gameObj, "gameObj");
            m.g(gameTeaserObj, "gameTeaserObj");
            this.binding.f38198b.setPostGameTeaser(gameTeaserObj);
            this.binding.f38198b.handleFrameUIData(bookmaker, betLines, x0.l(gameObj.homeAwayTeamOrder, true), gameObj);
            try {
                BetLineType betLineType = App.l().bets.getLineTypes().get(Integer.valueOf(gameTeaserObj.getOddsObj().getBetLines()[0].getBetLineType().getID()));
                Context m10 = App.m();
                String[] strArr = new String[12];
                strArr[0] = "game_id";
                strArr[1] = String.valueOf(gameObj.getID());
                strArr[2] = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
                strArr[3] = i0.D0(gameObj);
                strArr[4] = "section";
                strArr[5] = "7";
                strArr[6] = "market_type";
                strArr[7] = (betLineType == null || (r11 = Integer.valueOf(betLineType.getID()).toString()) == null) ? "" : "";
                strArr[8] = "bookie_id";
                strArr[9] = String.valueOf(gameTeaserObj.getOddsObj().getBetLines()[0].bookmakerId);
                strArr[10] = "button_design";
                strArr[11] = OddsView.getBetNowBtnDesignForAnalytics();
                k.n(m10, "gamecenter", "bets-impressions", "show", null, false, strArr);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public PostGameTeaserBrandedListItem() {
        this.betLines = new ArrayList();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PostGameTeaserBrandedListItem(BookMakerObj bookmaker, GameObj gameObj, GameTeaserObj gameTeaserObj) {
        this();
        m.g(bookmaker, "bookmaker");
        m.g(gameObj, "gameObj");
        m.g(gameTeaserObj, "gameTeaserObj");
        setGameTeaserObj(gameTeaserObj);
        this.bookmaker = bookmaker;
        this.gameObj = gameObj;
        BetLine[] betLines = gameTeaserObj.getOddsObj().getBetLines();
        m.f(betLines, "gameTeaserObj.oddsObj.betLines");
        for (BetLine it : betLines) {
            List<BetLine> list = this.betLines;
            m.f(it, "it");
            list.add(it);
        }
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

    public final GameTeaserObj getGameTeaserObj() {
        GameTeaserObj gameTeaserObj = this.gameTeaserObj;
        if (gameTeaserObj != null) {
            return gameTeaserObj;
        }
        m.t("gameTeaserObj");
        return null;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.PostGameTeaserBrandedListItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof PostGameTeaserBrandedListItemHolder) {
            BookMakerObj bookMakerObj = this.bookmaker;
            m.d(bookMakerObj);
            List<BetLine> list = this.betLines;
            GameObj gameObj = this.gameObj;
            m.d(gameObj);
            ((PostGameTeaserBrandedListItemHolder) e0Var).bind(bookMakerObj, list, gameObj, getGameTeaserObj());
        }
    }

    public final void setBookmaker(BookMakerObj bookMakerObj) {
        this.bookmaker = bookMakerObj;
    }

    public final void setGameObj(GameObj gameObj) {
        this.gameObj = gameObj;
    }

    public final void setGameTeaserObj(GameTeaserObj gameTeaserObj) {
        m.g(gameTeaserObj, "<set-?>");
        this.gameTeaserObj = gameTeaserObj;
    }
}
