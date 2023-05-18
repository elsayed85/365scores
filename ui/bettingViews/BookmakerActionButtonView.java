package com.scores365.ui.bettingViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.o0;
import li.p0;
import li.x0;
/* compiled from: BookmakerActionButtonView.kt */
/* loaded from: classes2.dex */
public final class BookmakerActionButtonView extends View {
    private int bgColor;
    private Paint bgPaint;
    private boolean isRTL;
    private Path path;
    private float slopeLength;
    private String text;
    private int textColor;
    private TextPaint textColorPaint;
    private float viewHeight;
    private float viewWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmakerActionButtonView(Context context) {
        super(context);
        m.g(context, "context");
        this.text = "";
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmakerActionButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.g(context, "context");
        this.text = "";
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookmakerActionButtonView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m.g(context, "context");
        this.text = "";
        initView();
    }

    public /* synthetic */ BookmakerActionButtonView(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    private final void drawManipulation(Canvas canvas) {
        try {
            Paint paint = this.bgPaint;
            m.d(paint);
            paint.setColor(this.bgColor);
            Rect rect = new Rect();
            TextPaint textPaint = this.textColorPaint;
            if (textPaint != null) {
                String str = this.text;
                m.d(str);
                textPaint.getTextBounds(str, 0, str.length(), rect);
            }
            TextPaint textPaint2 = this.textColorPaint;
            if (textPaint2 != null) {
                textPaint2.setColor(this.textColor);
            }
            TextPaint textPaint3 = this.textColorPaint;
            if (textPaint3 != null) {
                textPaint3.setTextAlign(Paint.Align.CENTER);
            }
            TextPaint textPaint4 = this.textColorPaint;
            m.d(textPaint4);
            this.viewWidth = textPaint4.measureText(this.text) + p0.s(30);
            if (this.isRTL) {
                Path path = this.path;
                m.d(path);
                path.moveTo(0.0f, 0.0f);
                Path path2 = this.path;
                m.d(path2);
                path2.lineTo(this.viewWidth - this.slopeLength, 0.0f);
                Path path3 = this.path;
                m.d(path3);
                path3.lineTo(this.viewWidth, this.viewHeight);
                Path path4 = this.path;
                m.d(path4);
                path4.lineTo(0.0f, this.viewHeight);
            } else {
                Path path5 = this.path;
                m.d(path5);
                path5.moveTo(0.0f, this.viewHeight);
                Path path6 = this.path;
                m.d(path6);
                path6.lineTo(this.viewWidth, this.viewHeight);
                Path path7 = this.path;
                m.d(path7);
                path7.lineTo(this.viewWidth, 0.0f);
                Path path8 = this.path;
                m.d(path8);
                path8.lineTo(this.slopeLength, 0.0f);
            }
            Path path9 = this.path;
            m.d(path9);
            path9.close();
            if (canvas != null) {
                Path path10 = this.path;
                m.d(path10);
                Paint paint2 = this.bgPaint;
                m.d(paint2);
                canvas.drawPath(path10, paint2);
            }
            m.d(canvas);
            TextPaint textPaint5 = this.textColorPaint;
            m.d(textPaint5);
            float descent = textPaint5.descent();
            TextPaint textPaint6 = this.textColorPaint;
            m.d(textPaint6);
            float height = (canvas.getHeight() / 2) - ((descent + textPaint6.ascent()) / 2);
            float centerX = rect.centerX() + p0.s(this.isRTL ? 10 : 20);
            String str2 = this.text;
            m.d(str2);
            TextPaint textPaint7 = this.textColorPaint;
            m.d(textPaint7);
            canvas.drawText(str2, centerX, height, textPaint7);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawManipulation(canvas);
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final Paint getBgPaint() {
        return this.bgPaint;
    }

    public final Path getPath() {
        return this.path;
    }

    public final float getSlopeLength() {
        return this.slopeLength;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final TextPaint getTextColorPaint() {
        return this.textColorPaint;
    }

    public final float getViewHeight() {
        return this.viewHeight;
    }

    public final float getViewWidth() {
        return this.viewWidth;
    }

    public final void initView() {
        try {
            this.bgPaint = new Paint(1);
            this.textColorPaint = new TextPaint(1);
            this.path = new Path();
            this.viewHeight = p0.s(24);
            this.slopeLength = p0.s(10);
            TextPaint textPaint = this.textColorPaint;
            if (textPaint != null) {
                textPaint.setTypeface(o0.c(getContext()));
                textPaint.setTextSize(p0.s(13));
            }
            this.isRTL = x0.l1();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public final boolean isRTL() {
        return this.isRTL;
    }

    public final void setBgColor(int i10) {
        this.bgColor = i10;
    }

    public final void setBgPaint(Paint paint) {
        this.bgPaint = paint;
    }

    public final void setPath(Path path) {
        this.path = path;
    }

    public final void setRTL(boolean z10) {
        this.isRTL = z10;
    }

    public final void setSlopeLength(float f10) {
        this.slopeLength = f10;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTextColor(int i10) {
        this.textColor = i10;
    }

    public final void setTextColorPaint(TextPaint textPaint) {
        this.textColorPaint = textPaint;
    }

    public final void setViewHeight(float f10) {
        this.viewHeight = f10;
    }

    public final void setViewWidth(float f10) {
        this.viewWidth = f10;
    }
}
