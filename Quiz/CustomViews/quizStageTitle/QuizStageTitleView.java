package com.scores365.Quiz.CustomViews.quizStageTitle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class QuizStageTitleView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    TextView f21497d;

    /* renamed from: e  reason: collision with root package name */
    View f21498e;

    /* loaded from: classes2.dex */
    private class a extends Drawable {

        /* renamed from: a  reason: collision with root package name */
        Paint f21499a;

        public a(String str) {
            try {
                Paint paint = new Paint();
                this.f21499a = paint;
                paint.setStyle(Paint.Style.FILL);
                this.f21499a.setAntiAlias(true);
                this.f21499a.setColor(Color.parseColor(str));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public void a(String str) {
            try {
                this.f21499a.setColor(Color.parseColor(str));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            try {
                Path path = new Path();
                if (x0.l1()) {
                    path.moveTo(QuizStageTitleView.this.f21498e.getWidth(), 0.0f);
                    path.lineTo(QuizStageTitleView.this.f21498e.getWidth() * 0.9f, QuizStageTitleView.this.f21498e.getHeight());
                    path.lineTo(0.0f, QuizStageTitleView.this.f21498e.getHeight());
                    path.lineTo(QuizStageTitleView.this.f21498e.getWidth() * 0.1f, 0.0f);
                    path.lineTo(QuizStageTitleView.this.f21498e.getWidth(), 0.0f);
                    canvas.drawPath(path, this.f21499a);
                } else {
                    path.moveTo(QuizStageTitleView.this.f21498e.getWidth(), QuizStageTitleView.this.f21498e.getHeight());
                    path.lineTo(QuizStageTitleView.this.f21498e.getWidth() * 0.1f, QuizStageTitleView.this.f21498e.getHeight());
                    path.lineTo(0.0f, 0.0f);
                    path.lineTo(QuizStageTitleView.this.f21498e.getWidth() * 0.9f, 0.0f);
                    path.lineTo(QuizStageTitleView.this.f21498e.getWidth(), QuizStageTitleView.this.f21498e.getHeight());
                    canvas.drawPath(path, this.f21499a);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public QuizStageTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public QuizStageTitleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    public void d(String str, int i10, String str2) {
        try {
            setGameNameTitle(str);
            setTitleSize(i10);
            if (str2 != null) {
                this.f21498e.setVisibility(0);
                this.f21498e.setBackground(new a(str2));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void initView() {
        try {
            if (x0.l1()) {
                View.inflate(App.m(), R.layout.f22517e7, this);
            } else {
                View.inflate(App.m(), R.layout.f22504d7, this);
            }
            TextView textView = (TextView) findViewById(R.id.Lz);
            this.f21497d = textView;
            textView.setTextColor(Color.parseColor("#ffffff"));
            this.f21497d.setTypeface(o0.c(App.m()));
            this.f21498e = findViewById(R.id.f22265r7);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setColorLine(String str) {
        try {
            if (str == null) {
                this.f21498e.setVisibility(4);
            } else if (this.f21498e.getVisibility() != 0 || this.f21498e.getBackground() == null) {
                this.f21498e.setVisibility(0);
                this.f21498e.setBackground(new a(str));
            } else {
                ((a) this.f21498e.getBackground()).a(str);
                this.f21498e.invalidate();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setGameNameTitle(String str) {
        this.f21497d.setText(str);
    }

    public void setTitleSize(int i10) {
        this.f21497d.setTextSize(1, i10);
    }
}
