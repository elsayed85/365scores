package com.scores365.Quiz.CustomViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class QuizButton extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private float f21422a;

    /* renamed from: b  reason: collision with root package name */
    private b f21423b;

    /* renamed from: c  reason: collision with root package name */
    private int f21424c;

    /* renamed from: d  reason: collision with root package name */
    private float f21425d;

    /* renamed from: e  reason: collision with root package name */
    private int f21426e;

    /* renamed from: f  reason: collision with root package name */
    private int f21427f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f21428g;

    /* renamed from: h  reason: collision with root package name */
    private Path f21429h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.scores365.Quiz.CustomViews.QuizButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0239a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ View f21431a;

            RunnableC0239a(View view) {
                this.f21431a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = this.f21431a;
                if (view != null) {
                    view.setEnabled(true);
                }
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Handler handler;
            RunnableC0239a runnableC0239a;
            try {
                try {
                    view.setEnabled(false);
                    if (QuizButton.this.f21423b != null) {
                        QuizButton.this.f21423b.j0(view);
                    }
                    handler = new Handler();
                    runnableC0239a = new RunnableC0239a(view);
                } catch (Exception e10) {
                    x0.N1(e10);
                    handler = new Handler();
                    runnableC0239a = new RunnableC0239a(view);
                }
                handler.postDelayed(runnableC0239a, 500L);
            } catch (Throwable th2) {
                new Handler().postDelayed(new RunnableC0239a(view), 500L);
                throw th2;
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void j0(View view);
    }

    public QuizButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21422a = -1.0f;
        b(context, attributeSet);
    }

    public QuizButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21422a = -1.0f;
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        try {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.K, 0, 0);
            this.f21424c = obtainStyledAttributes.getColor(R.styleable.L, 0);
            this.f21425d = obtainStyledAttributes.getDimension(R.styleable.O, p0.s(2));
            this.f21426e = obtainStyledAttributes.getColor(R.styleable.N, 0);
            this.f21427f = obtainStyledAttributes.getColor(R.styleable.M, App.m().getResources().getColor(R.color.f21611a));
            obtainStyledAttributes.recycle();
            setOnClickListener(new a());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            if (this.f21428g == null) {
                this.f21428g = new Paint();
            }
            this.f21428g.setAntiAlias(true);
            this.f21428g.setStrokeJoin(Paint.Join.ROUND);
            this.f21428g.setStrokeWidth(this.f21425d);
            int width = getWidth();
            int height = getHeight();
            if (this.f21429h == null) {
                this.f21429h = new Path();
            }
            if (this.f21422a != -1.0f) {
                this.f21422a = (float) (height * Math.tan(Math.toRadians(10.0d)));
            }
            this.f21428g.setStyle(Paint.Style.FILL);
            this.f21428g.setColor(this.f21424c);
            this.f21429h.reset();
            this.f21429h.moveTo(p0.s(1), height - p0.s(1));
            this.f21429h.lineTo(this.f21422a, p0.s(1));
            this.f21429h.lineTo(width - p0.s(1), p0.s(1));
            this.f21429h.lineTo(width - this.f21422a, height - p0.s(1));
            this.f21429h.lineTo(p0.s(1), height - p0.s(1));
            this.f21429h.lineTo(this.f21422a, p0.s(1));
            canvas.drawPath(this.f21429h, this.f21428g);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.draw(canvas);
    }

    public int getFillColor() {
        return this.f21424c;
    }

    public int getStrokeColor() {
        return this.f21426e;
    }

    public float getStrokeWidth() {
        return this.f21425d;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            if (this.f21428g == null) {
                this.f21428g = new Paint();
            }
            this.f21428g.setAntiAlias(true);
            this.f21428g.setStrokeJoin(Paint.Join.ROUND);
            this.f21428g.setStrokeWidth(this.f21425d);
            int width = getWidth();
            int height = getHeight();
            if (this.f21429h == null) {
                this.f21429h = new Path();
            }
            if (this.f21422a != -1.0f) {
                this.f21422a = (float) (height * Math.tan(Math.toRadians(10.0d)));
            }
            this.f21428g.setStyle(Paint.Style.FILL);
            this.f21428g.setColor(this.f21427f);
            this.f21429h.reset();
            this.f21429h.moveTo(0.0f, 0.0f);
            this.f21429h.lineTo(this.f21422a, 0.0f);
            float f10 = height;
            this.f21429h.lineTo(0.0f, f10);
            this.f21429h.lineTo(0.0f, 0.0f);
            this.f21429h.close();
            canvas.drawPath(this.f21429h, this.f21428g);
            this.f21428g.setStyle(Paint.Style.FILL);
            this.f21428g.setColor(this.f21427f);
            this.f21429h.reset();
            float f11 = width;
            this.f21429h.moveTo(f11, 0.0f);
            this.f21429h.lineTo(f11, f10);
            this.f21429h.lineTo(f11 - this.f21422a, f10);
            this.f21429h.lineTo(f11, 0.0f);
            this.f21429h.close();
            canvas.drawPath(this.f21429h, this.f21428g);
            this.f21428g.setStyle(Paint.Style.STROKE);
            this.f21428g.setColor(this.f21426e);
            this.f21429h.reset();
            this.f21429h.moveTo(p0.s(1), height - p0.s(1));
            this.f21429h.lineTo(this.f21422a, p0.s(1));
            this.f21429h.lineTo(width - p0.s(1), p0.s(1));
            this.f21429h.lineTo(f11 - this.f21422a, height - p0.s(1));
            this.f21429h.lineTo(p0.s(1), height - p0.s(1));
            this.f21429h.lineTo(this.f21422a, p0.s(1));
            canvas.drawPath(this.f21429h, this.f21428g);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        try {
            float tan = (float) ((i10 / 3) * Math.tan(Math.toRadians(30.0d)));
            this.f21422a = tan;
            setPadding((int) tan, getPaddingTop(), (int) this.f21422a, getPaddingBottom());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setFillColor(int i10) {
        this.f21424c = i10;
    }

    public void setQuizButtonClickListener(b bVar) {
        this.f21423b = bVar;
    }

    public void setStrokeColor(int i10) {
        this.f21426e = i10;
    }

    public void setStrokeWidth(float f10) {
        this.f21425d = f10;
    }
}
