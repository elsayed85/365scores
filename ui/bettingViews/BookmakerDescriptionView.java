package com.scores365.ui.bettingViews;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.ui.bettingViews.BookmakerDescriptionView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import li.x0;
import rf.s;
/* compiled from: BookmakerDescriptionView.kt */
/* loaded from: classes2.dex */
public final class BookmakerDescriptionView extends ConstraintLayout {
    private int actionButtonBgColor;
    private String actionButtonText;
    private int actionButtonTextColor;
    private int bgColor;
    private s binding;
    private int containerHeight;
    private String descriptionText;
    private int descriptionTextColor;
    private boolean isRTL;

    /* compiled from: BookmakerDescriptionView.kt */
    /* loaded from: classes2.dex */
    public interface ActionButtonClickListener {
        void onActionButtonClick();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmakerDescriptionView(Context context) {
        super(context);
        m.g(context, "context");
        this.containerHeight = p0.s(24);
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmakerDescriptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        this.containerHeight = p0.s(24);
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmakerDescriptionView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.containerHeight = p0.s(24);
        initView();
    }

    public /* synthetic */ BookmakerDescriptionView(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$3$lambda$2(ActionButtonClickListener actionButtonClickListener, View view) {
        if (actionButtonClickListener != null) {
            try {
                actionButtonClickListener.onActionButtonClick();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public final int getActionButtonBgColor() {
        return this.actionButtonBgColor;
    }

    public final String getActionButtonText() {
        return this.actionButtonText;
    }

    public final int getActionButtonTextColor() {
        return this.actionButtonTextColor;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getContainerHeight() {
        return this.containerHeight;
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final int getDescriptionTextColor() {
        return this.descriptionTextColor;
    }

    public final void initView() {
        try {
            this.binding = s.c(LayoutInflater.from(getContext()), this, true);
            this.isRTL = x0.l1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final boolean isRTL() {
        return this.isRTL;
    }

    public final void setActionButtonBgColor(int i10) {
        this.actionButtonBgColor = i10;
    }

    public final void setActionButtonText(String str) {
        this.actionButtonText = str;
    }

    public final void setActionButtonTextColor(int i10) {
        this.actionButtonTextColor = i10;
    }

    public final void setBgColor(int i10) {
        this.bgColor = i10;
    }

    public final void setContainerHeight(int i10) {
        this.containerHeight = i10;
    }

    public final void setData(final ActionButtonClickListener actionButtonClickListener) {
        try {
            setLayoutDirection(this.isRTL ? 1 : 0);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = this.containerHeight;
            }
            s sVar = this.binding;
            if (sVar != null) {
                sVar.getRoot().setBackgroundColor(this.bgColor);
                TextView textView = sVar.f37978c;
                textView.setText(this.descriptionText);
                textView.setTextColor(this.descriptionTextColor);
                textView.setGravity(this.isRTL ? 21 : 19);
                textView.setTypeface(o0.c(textView.getContext()));
                BookmakerActionButtonView bookmakerActionButtonView = sVar.f37977b;
                bookmakerActionButtonView.setBgColor(this.actionButtonBgColor);
                bookmakerActionButtonView.setTextColor(this.actionButtonTextColor);
                bookmakerActionButtonView.setText(this.actionButtonText);
                ViewGroup.LayoutParams layoutParams2 = bookmakerActionButtonView.getLayoutParams();
                TextPaint textColorPaint = bookmakerActionButtonView.getTextColorPaint();
                m.d(textColorPaint);
                layoutParams2.width = (int) (textColorPaint.measureText(bookmakerActionButtonView.getText()) + p0.s(30));
                bookmakerActionButtonView.getLayoutParams().height = this.containerHeight;
                bookmakerActionButtonView.invalidate();
                if (actionButtonClickListener != null) {
                    sVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.bettingViews.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BookmakerDescriptionView.setData$lambda$3$lambda$2(BookmakerDescriptionView.ActionButtonClickListener.this, view);
                        }
                    });
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final void setDescriptionText(String str) {
        this.descriptionText = str;
    }

    public final void setDescriptionTextColor(int i10) {
        this.descriptionTextColor = i10;
    }

    public final void setRTL(boolean z10) {
        this.isRTL = z10;
    }
}
