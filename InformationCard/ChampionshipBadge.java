package com.scores365.InformationCard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import li.x0;
/* loaded from: classes2.dex */
public class ChampionshipBadge extends View {

    /* renamed from: a  reason: collision with root package name */
    int f21094a;

    /* renamed from: b  reason: collision with root package name */
    int f21095b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeDrawable f21096c;

    /* renamed from: d  reason: collision with root package name */
    private ShapeDrawable f21097d;

    public ChampionshipBadge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21094a = -1;
        this.f21095b = -1;
    }

    public ChampionshipBadge(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21094a = -1;
        this.f21095b = -1;
    }

    private void a() {
        try {
            Path path = new Path();
            path.moveTo(0.0f, (float) (getHeight() * 0.8d));
            path.lineTo(0.0f, getHeight());
            path.lineTo(getWidth(), 0.0f);
            path.lineTo((float) (getWidth() * 0.8d), 0.0f);
            path.lineTo(0.0f, (float) (getHeight() * 0.8d));
            ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, getWidth(), getHeight()));
            this.f21097d = shapeDrawable;
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            this.f21097d.getPaint().setStrokeWidth(1.0f);
            this.f21097d.getPaint().setColor(this.f21095b);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void c() {
        try {
            Path path = new Path();
            path.moveTo(0.0f, (float) (getHeight() * 0.56d));
            path.lineTo(0.0f, (float) (getHeight() * 0.8d));
            path.lineTo((float) (getWidth() * 0.8d), 0.0f);
            path.lineTo((float) (getWidth() * 0.56d), 0.0f);
            path.lineTo(0.0f, (float) (getHeight() * 0.56d));
            ShapeDrawable shapeDrawable = new ShapeDrawable(new PathShape(path, getWidth(), getHeight()));
            this.f21096c = shapeDrawable;
            shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            this.f21096c.getPaint().setStrokeWidth(1.0f);
            this.f21096c.getPaint().setColor(this.f21094a);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void b() {
        try {
            c();
            a();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void d(int i10, int i11, int i12, int i13) {
        this.f21094a = i10;
        this.f21095b = i11;
        setLayoutParams(new ConstraintLayout.b(i12, i13));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f21096c.draw(canvas);
        this.f21097d.draw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        setMinimumWidth(i10);
        setMinimumHeight(i11);
        b();
        this.f21096c.setBounds(0, 0, i10, i11);
        this.f21097d.setBounds(0, 0, i10, i11);
    }
}
