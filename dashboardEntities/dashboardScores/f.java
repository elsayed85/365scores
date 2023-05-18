package com.scores365.dashboardEntities.dashboardScores;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.view.View;
import com.scores365.App;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.StatusObj;
import com.scores365.ui.swipe.MyScoresItemTouchHelperCallback;
import com.scores365.ui.swipe.SwipeableViewHolder;
import ef.s;
import java.util.Date;
import java.util.Locale;
import lf.u;
import li.x0;
/* compiled from: ScoresGame.java */
/* loaded from: classes2.dex */
public abstract class f extends e implements s {
    protected CompetitionObj competitionObj;
    protected GameObj gameObj;
    protected boolean hasNotifications;
    boolean isGameHasOnlyGameNotifications;
    boolean isUnderCompetitionsByCountryInAllScores;
    private Locale locale;
    protected boolean shouldShowLeftStripe;
    boolean isScoresTabItem = false;
    protected StringBuilder dateName = null;
    int hashCodeLocal = -1;

    /* compiled from: ScoresGame.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends t implements SwipeableViewHolder {
        protected MyScoresItemTouchHelperCallback.ButtonsState buttonsState;
        protected boolean hasNotifications;
        protected float holderOffsetX;
        protected boolean invertLeftColors;
        boolean isSwipable;
        protected View leftStripe;
        protected float looseCoordinateX;
        protected Rect notificationButtonFrame;
        protected Rect removeButtonFrame;
        protected boolean shouldShowLeftStripe;

        /* compiled from: ScoresGame.java */
        /* renamed from: com.scores365.dashboardEntities.dashboardScores.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0245a implements Animator.AnimatorListener {
            C0245a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    a.this.setOffsetX(0.0f);
                    a.this.handleLeftStripeVisibility();
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public a(View view) {
            super(view);
            this.holderOffsetX = 0.0f;
            this.looseCoordinateX = 0.0f;
            this.notificationButtonFrame = new Rect();
            this.removeButtonFrame = new Rect();
            this.buttonsState = MyScoresItemTouchHelperCallback.ButtonsState.INITIAL;
            this.hasNotifications = false;
            this.invertLeftColors = false;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public MyScoresItemTouchHelperCallback.ButtonsState getButtonState() {
            return this.buttonsState;
        }

        public View getLeftStripe() {
            return this.leftStripe;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public float getLooseCoordinateX() {
            return this.looseCoordinateX;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public Rect getNotificationButtonFrame() {
            return this.notificationButtonFrame;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public float getOffsetX() {
            return this.holderOffsetX;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public Rect getRemoveButtonFrame() {
            return this.removeButtonFrame;
        }

        public float getSwipeWidth() {
            return App.m().getResources().getDimension(R.dimen.A) * 2.0f;
        }

        public void handleLeftStripeVisibility() {
            try {
                if (getLeftStripe() != null) {
                    getLeftStripe().setVisibility((this.hasNotifications && this.shouldShowLeftStripe) ? 0 : 8);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public boolean isInvertLeftColors() {
            return this.invertLeftColors;
        }

        public boolean isSwipeable() {
            return this.isSwipable;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void restoreInitialState() {
            try {
                View view = ((t) this).itemView;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.addListener(new C0245a());
                ofFloat.start();
                this.buttonsState = MyScoresItemTouchHelperCallback.ButtonsState.INITIAL;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void restoreInitialStateWithoutAnimation() {
            try {
                setOffsetX(0.0f);
                setLooseCoordinateX(0.0f);
                ((t) this).itemView.setTranslationX(0.0f);
                this.buttonsState = MyScoresItemTouchHelperCallback.ButtonsState.INITIAL;
                handleLeftStripeVisibility();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void setButtonState(MyScoresItemTouchHelperCallback.ButtonsState buttonsState) {
            this.buttonsState = buttonsState;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void setInvertLeftColors(boolean z10) {
            this.invertLeftColors = z10;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void setLooseCoordinateX(float f10) {
            this.looseCoordinateX = f10;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void setOffsetX(float f10) {
            this.holderOffsetX = f10;
        }

        @Override // com.scores365.ui.swipe.SwipeableViewHolder
        public void setSelected(boolean z10) {
            try {
                this.hasNotifications = z10;
                getLeftStripe().setVisibility((z10 && this.shouldShowLeftStripe) ? 0 : 8);
                this.invertLeftColors = true;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public abstract void updateViewHolder(f fVar, boolean z10, boolean z11, boolean z12);
    }

    public f(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, Locale locale) {
        this.gameObj = gameObj;
        this.competitionObj = competitionObj;
        this.hasNotifications = z10;
        this.shouldShowLeftStripe = z11;
        this.isGameHasOnlyGameNotifications = z12;
        this.locale = locale;
        getDateNameFromItem();
        hashCode();
    }

    public CompetitionObj getCompetitionObj() {
        return this.competitionObj;
    }

    public Date getDateFromItem() {
        try {
            return this.gameObj.getSTime();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // ef.s
    public StringBuilder getDateNameFromItem() {
        try {
            if (this.dateName == null) {
                this.dateName = ef.l.m(getDateFromItem(), this.locale, false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.dateName;
    }

    public GameObj getGameObj() {
        return this.gameObj;
    }

    @Override // com.scores365.dashboardEntities.dashboardScores.e, com.scores365.dashboardEntities.dashboardScores.i
    public long getId() {
        return getItemId();
    }

    @Override // com.scores365.Design.PageObjects.c
    public long getItemId() {
        GameObj gameObj = this.gameObj;
        return gameObj != null ? (((gameObj.getID() * 2) + (this.isUnderCompetitionsByCountryInAllScores ? 1L : 0L)) * u.values().length) + getObjectTypeNum() : super.getItemId();
    }

    public int hashCode() {
        int i10;
        int hashCode = super.hashCode();
        try {
            i10 = this.hashCodeLocal;
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (i10 != -1) {
            return i10;
        }
        hashCode = getObjectTypeNum() + (this.gameObj.getID() * u.values().length);
        this.hashCodeLocal = hashCode;
        return hashCode;
    }

    public void initScoreText(StatusObj statusObj) {
    }

    public boolean isHasNotifications() {
        return this.hasNotifications;
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isMainScoresListItem() {
        return true;
    }

    public void setGameObj(GameObj gameObj) {
        this.gameObj = gameObj;
    }

    public void setHasNotifications(boolean z10) {
        this.hasNotifications = z10;
    }
}
