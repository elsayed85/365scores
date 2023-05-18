package com.scores365.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSpinner;
/* loaded from: classes2.dex */
public class CustomSpinner extends AppCompatSpinner {
    private OnSpinnerEventsListener mListener;
    private boolean mOpenInitiated;

    /* loaded from: classes2.dex */
    public interface OnSpinnerEventsListener {
        void onSpinnerClosed();

        void onSpinnerOpened();
    }

    public CustomSpinner(Context context) {
        super(context);
        this.mOpenInitiated = false;
    }

    public CustomSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOpenInitiated = false;
    }

    public CustomSpinner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mOpenInitiated = false;
    }

    public boolean hasBeenOpened() {
        return this.mOpenInitiated;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (hasBeenOpened() && z10) {
            performClosedEvent();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.view.View
    public boolean performClick() {
        this.mOpenInitiated = true;
        OnSpinnerEventsListener onSpinnerEventsListener = this.mListener;
        if (onSpinnerEventsListener != null) {
            onSpinnerEventsListener.onSpinnerOpened();
        }
        return super.performClick();
    }

    public void performClosedEvent() {
        this.mOpenInitiated = false;
        OnSpinnerEventsListener onSpinnerEventsListener = this.mListener;
        if (onSpinnerEventsListener != null) {
            onSpinnerEventsListener.onSpinnerClosed();
        }
    }

    public void setSpinnerEventsListener(OnSpinnerEventsListener onSpinnerEventsListener) {
        this.mListener = onSpinnerEventsListener;
    }
}
