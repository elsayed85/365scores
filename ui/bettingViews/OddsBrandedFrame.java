package com.scores365.ui.bettingViews;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.bets.model.BetLine;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.GameObj;
import com.scores365.ui.bettingViews.BookmakerDescriptionView;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import li.u;
import li.x0;
import nb.o;
import xf.q;
/* compiled from: OddsBrandedFrame.kt */
/* loaded from: classes2.dex */
public abstract class OddsBrandedFrame extends ConstraintLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OddsBrandedFrame(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
    }

    public /* synthetic */ OddsBrandedFrame(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBookmakerGeneralClick(List<? extends BetLine> list, BookMakerObj bookMakerObj, GameObj gameObj) {
        String actionButtonClickUrl;
        try {
            boolean z10 = true;
            if (list.size() == 1 && list.get(0).getLineLink() != null) {
                String lineLink = list.get(0).getLineLink();
                m.f(lineLink, "lines[0].lineLink");
                if (lineLink.length() <= 0) {
                    z10 = false;
                }
                if (z10) {
                    actionButtonClickUrl = list.get(0).getLineLink();
                    q.g.a aVar = new q.g.a(actionButtonClickUrl);
                    setAnalParams(list.get(0), gameObj, aVar);
                    aVar.onClick(getRootView());
                }
            }
            actionButtonClickUrl = bookMakerObj != null ? bookMakerObj.getActionButtonClickUrl() : null;
            q.g.a aVar2 = new q.g.a(actionButtonClickUrl);
            setAnalParams(list.get(0), gameObj, aVar2);
            aVar2.onClick(getRootView());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFrameUIData$lambda$0(OddsBrandedFrame this$0, List lines, BookMakerObj bookMakerObj, GameObj gameObj, View view) {
        m.g(this$0, "this$0");
        m.g(lines, "$lines");
        m.g(gameObj, "$gameObj");
        this$0.handleBookmakerGeneralClick(lines, bookMakerObj, gameObj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFrameUIData$lambda$2$lambda$1(OddsBrandedFrame this$0, List lines, BookMakerObj bookMakerObj, GameObj gameObj, View view) {
        m.g(this$0, "this$0");
        m.g(lines, "$lines");
        m.g(gameObj, "$gameObj");
        this$0.handleBookmakerGeneralClick(lines, bookMakerObj, gameObj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleFrameUIData$lambda$3(OddsBrandedFrame this$0, List lines, BookMakerObj bookMakerObj, GameObj gameObj, View view) {
        m.g(this$0, "this$0");
        m.g(lines, "$lines");
        m.g(gameObj, "$gameObj");
        this$0.handleBookmakerGeneralClick(lines, bookMakerObj, gameObj);
    }

    public abstract BookmakerDescriptionView getBookmakerDescriptionView();

    public abstract ImageView getBookmakerImageView();

    public abstract View getFrameRootView();

    public abstract TextView getSponsoredTitleTextView();

    public abstract void handleBetLineData(BookMakerObj bookMakerObj, List<? extends BetLine> list, boolean z10, GameObj gameObj);

    public final void handleFrameUIData(final BookMakerObj bookMakerObj, final List<? extends BetLine> lines, boolean z10, final GameObj gameObj) {
        m.g(lines, "lines");
        m.g(gameObj, "gameObj");
        try {
            View frameRootView = getFrameRootView();
            m.d(bookMakerObj);
            frameRootView.setBackgroundColor(Color.parseColor(bookMakerObj.secondaryColor));
            getFrameRootView().setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.bettingViews.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OddsBrandedFrame.handleFrameUIData$lambda$0(OddsBrandedFrame.this, lines, bookMakerObj, gameObj, view);
                }
            });
            TextView sponsoredTitleTextView = getSponsoredTitleTextView();
            sponsoredTitleTextView.setText(p0.l0("SPONSORED_AD_BETTING"));
            sponsoredTitleTextView.setTextColor(Color.parseColor(bookMakerObj.promotionTextColor));
            sponsoredTitleTextView.setBackgroundColor(Color.parseColor(bookMakerObj.color));
            sponsoredTitleTextView.setTypeface(o0.d(sponsoredTitleTextView.getContext()));
            sponsoredTitleTextView.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.bettingViews.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OddsBrandedFrame.handleFrameUIData$lambda$2$lambda$1(OddsBrandedFrame.this, lines, bookMakerObj, gameObj, view);
                }
            });
            u.x(o.f(bookMakerObj.getID(), bookMakerObj.getImgVer()), getBookmakerImageView());
            getBookmakerImageView().setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.bettingViews.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OddsBrandedFrame.handleFrameUIData$lambda$3(OddsBrandedFrame.this, lines, bookMakerObj, gameObj, view);
                }
            });
            handleBetLineData(bookMakerObj, lines, z10, gameObj);
            BookmakerDescriptionView bookmakerDescriptionView = getBookmakerDescriptionView();
            bookmakerDescriptionView.setBgColor(Color.parseColor(bookMakerObj.color));
            bookmakerDescriptionView.setActionButtonBgColor(Color.parseColor(bookMakerObj.CTABGColor));
            bookmakerDescriptionView.setActionButtonTextColor(Color.parseColor(bookMakerObj.CTATextColor));
            bookmakerDescriptionView.setDescriptionTextColor(Color.parseColor(bookMakerObj.promotionTextColor));
            bookmakerDescriptionView.setDescriptionText(bookMakerObj.promotionText);
            bookmakerDescriptionView.setActionButtonText(bookMakerObj.CTAText);
            bookmakerDescriptionView.setData(new BookmakerDescriptionView.ActionButtonClickListener() { // from class: com.scores365.ui.bettingViews.OddsBrandedFrame$handleFrameUIData$4$1
                @Override // com.scores365.ui.bettingViews.BookmakerDescriptionView.ActionButtonClickListener
                public void onActionButtonClick() {
                    OddsBrandedFrame.this.handleBookmakerGeneralClick(lines, bookMakerObj, gameObj);
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public abstract void initView();

    public abstract void setAnalParams(BetLine betLine, GameObj gameObj, q.g.a aVar);
}
