package com.scores365.ui.swipe;

import android.graphics.Rect;
import com.scores365.ui.swipe.MyScoresItemTouchHelperCallback;
/* loaded from: classes2.dex */
public interface SwipeableViewHolder {
    int getBottomOfItemView();

    MyScoresItemTouchHelperCallback.ButtonsState getButtonState();

    int getLayoutPosition();

    int getLeftOfItemView();

    float getLooseCoordinateX();

    Rect getNotificationButtonFrame();

    float getOffsetX();

    Rect getRemoveButtonFrame();

    float getSwipeWidth();

    int getTopMarginItemView();

    boolean isInvertLeftColors();

    boolean isSelected();

    boolean isSwipeable();

    void restoreInitialState();

    void restoreInitialStateWithoutAnimation();

    void setButtonState(MyScoresItemTouchHelperCallback.ButtonsState buttonsState);

    void setInvertLeftColors(boolean z10);

    void setLooseCoordinateX(float f10);

    void setOffsetX(float f10);

    void setSelected(boolean z10);

    void toggleViewHolder();
}
