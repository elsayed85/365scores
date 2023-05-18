package com.scores365.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class DiamondView extends View {
    private final String FIFA_GRADIENT_COLOR_END;
    private final String FIFA_GRADIENT_COLOR_START;
    private int color1;
    private int color2;
    private int diagonal;
    private int end;
    private int gradientBrushLength;
    private int height;
    private Paint mBoarderPaint;
    Paint mInnerPaint;
    private int numOfDivs;
    private float percentFill;
    private int start;
    private int strokeWidth;
    private int width;

    public DiamondView(Context context) {
        super(context);
        this.FIFA_GRADIENT_COLOR_START = "#412E5B";
        this.FIFA_GRADIENT_COLOR_END = "#FC5461";
        this.width = -1;
        this.height = -1;
        this.start = -1;
        this.end = -1;
        this.color1 = -1;
        this.color2 = -1;
        this.diagonal = -1;
        this.numOfDivs = 1;
        this.gradientBrushLength = 0;
        this.percentFill = 1.0f;
        this.strokeWidth = 1;
        init(context, null);
    }

    public DiamondView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FIFA_GRADIENT_COLOR_START = "#412E5B";
        this.FIFA_GRADIENT_COLOR_END = "#FC5461";
        this.width = -1;
        this.height = -1;
        this.start = -1;
        this.end = -1;
        this.color1 = -1;
        this.color2 = -1;
        this.diagonal = -1;
        this.numOfDivs = 1;
        this.gradientBrushLength = 0;
        this.percentFill = 1.0f;
        this.strokeWidth = 1;
        init(context, attributeSet);
    }

    public DiamondView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.FIFA_GRADIENT_COLOR_START = "#412E5B";
        this.FIFA_GRADIENT_COLOR_END = "#FC5461";
        this.width = -1;
        this.height = -1;
        this.start = -1;
        this.end = -1;
        this.color1 = -1;
        this.color2 = -1;
        this.diagonal = -1;
        this.numOfDivs = 1;
        this.gradientBrushLength = 0;
        this.percentFill = 1.0f;
        this.strokeWidth = 1;
        init(context, attributeSet);
    }

    private void drawManipulation(Canvas canvas) {
        int i10;
        try {
            Path path = new Path();
            int i11 = this.width / this.numOfDivs;
            int i12 = 1;
            int i13 = i11;
            int i14 = 1;
            boolean z10 = true;
            boolean z11 = true;
            while (true) {
                int i15 = this.numOfDivs;
                if (i14 > i15) {
                    return;
                }
                float f10 = this.percentFill;
                if (f10 >= i14 / i15) {
                    z10 = true;
                } else {
                    z11 = z10 && f10 != ((float) (i14 + (-1))) / ((float) i15);
                    z10 = false;
                }
                float f11 = i13;
                path.moveTo(f11, 0.0f);
                if (i14 == i12) {
                    int i16 = i13 - i11;
                    path.lineTo(this.diagonal + i16 + 0, 0.0f);
                    path.lineTo(i16 + 0, getHeight());
                    path.lineTo(i13 - this.diagonal, getHeight());
                    path.lineTo(f11, 0.0f);
                } else {
                    int i17 = i13 - i11;
                    path.lineTo((this.diagonal + i17) - 0, 0.0f);
                    path.lineTo(i17 + 0, getHeight());
                    path.lineTo(i13 - this.diagonal, getHeight());
                    path.lineTo(f11, 0.0f);
                }
                if (z10) {
                    canvas.drawPath(path, this.mInnerPaint);
                }
                if (!z10 && z11) {
                    int i18 = this.numOfDivs;
                    float f12 = i11 * ((this.percentFill - ((i14 - 1) / i18)) / (1.0f / i18));
                    Path path2 = new Path();
                    int i19 = i13 - i11;
                    path2.moveTo((this.diagonal + i19) - 0, 0.0f);
                    path2.lineTo(i19 + 0, getHeight());
                    if (isLeftEdge(f12, 16) || isRightEdge((i10 * i11) + f12, i13 - this.diagonal)) {
                        float f13 = i19 + f12;
                        if (isEdges(f13, (this.diagonal + i19) - 0)) {
                            if (isLeftEdge(f12, 16)) {
                                float f14 = 0;
                                path2.lineTo(this.diagonal + f13 + f14, getHeight());
                                path2.lineTo(f13 + this.diagonal + f14, 0.0f);
                            } else {
                                path2.lineTo(f13 - this.diagonal, getHeight());
                                path2.lineTo(f13 - this.diagonal, 0.0f);
                            }
                            path2.lineTo((i19 + this.diagonal) - 0, 0.0f);
                            canvas.drawPath(path2, this.mInnerPaint);
                        }
                    }
                    float f15 = i19 + f12;
                    path2.lineTo(f15, getHeight());
                    path2.lineTo(f15, 0.0f);
                    path2.lineTo((i19 + this.diagonal) - 0, 0.0f);
                    canvas.drawPath(path2, this.mInnerPaint);
                }
                canvas.drawPath(path, this.mBoarderPaint);
                i14++;
                i13 = i14 * i11;
                i12 = 1;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initFillBrush() {
        try {
            Paint paint = new Paint();
            this.mInnerPaint = paint;
            paint.setAntiAlias(true);
            this.mInnerPaint.setShader(new LinearGradient(0.0f, 0.0f, this.gradientBrushLength, 0.0f, this.color1, this.color2, Shader.TileMode.CLAMP));
            this.mInnerPaint.setStyle(Paint.Style.FILL);
            this.mInnerPaint.setStrokeJoin(Paint.Join.ROUND);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initStrokeBrush() {
        try {
            Paint paint = new Paint();
            this.mBoarderPaint = paint;
            paint.setAntiAlias(true);
            this.mBoarderPaint.setShader(new LinearGradient(0.0f, 0.0f, this.gradientBrushLength, 0.0f, this.color1, this.color2, Shader.TileMode.CLAMP));
            this.mBoarderPaint.setStyle(Paint.Style.STROKE);
            this.mBoarderPaint.setStrokeWidth(this.strokeWidth);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private boolean isEdges(float f10, float f11) {
        return f10 < f11 || f10 > f11;
    }

    private boolean isLeftEdge(float f10, int i10) {
        return f10 < ((float) i10);
    }

    private boolean isRightEdge(float f10, int i10) {
        return f10 > ((float) i10);
    }

    private void setDefaults() {
        try {
            if (this.color1 == -1 && this.color2 == -1) {
                setColor1(Color.parseColor("#412E5B"));
                setColor2(Color.parseColor("#FC5461"));
            }
            if (this.start == -1) {
                this.start = 0;
            }
            if (this.end == -1) {
                this.end = this.width;
            }
            if (this.diagonal == -1) {
                this.diagonal = 96;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawManipulation(canvas);
    }

    public void init(Context context, AttributeSet attributeSet) {
        try {
            setWillNotDraw(false);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842996});
                this.width = obtainStyledAttributes.getLayoutDimension(0, -2);
                obtainStyledAttributes.recycle();
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.f22862x);
                this.gradientBrushLength = this.width;
                if (this.color1 == -1) {
                    this.color1 = obtainStyledAttributes2.getColor(R.styleable.C, Color.parseColor("#412E5B"));
                }
                if (this.color1 == -1) {
                    this.color2 = obtainStyledAttributes2.getColor(R.styleable.A, Color.parseColor("#FC5461"));
                }
                this.numOfDivs = obtainStyledAttributes2.getColor(R.styleable.B, 10);
                this.diagonal = obtainStyledAttributes2.getLayoutDimension(R.styleable.f22863y, 96);
                this.strokeWidth = obtainStyledAttributes2.getLayoutDimension(R.styleable.f22864z, p0.s(1));
                obtainStyledAttributes2.recycle();
            }
            setDefaults();
            initStrokeBrush();
            initFillBrush();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (x0.l1()) {
            canvas.scale(-1.0f, 1.0f, this.width / 2.0f, this.height / 2.0f);
        }
        super.onDraw(canvas);
        initFillBrush();
        initStrokeBrush();
        drawManipulation(canvas);
    }

    public void setColor1(int i10) {
        this.color1 = i10;
    }

    public void setColor2(int i10) {
        this.color2 = i10;
    }

    public void setDiagonal(int i10) {
        this.diagonal = i10;
    }

    public void setEnd(int i10) {
        this.end = i10;
    }

    public void setGradientBrushLength(int i10) {
        try {
            this.gradientBrushLength = (int) ((i10 / 100.0f) * this.width);
            this.mInnerPaint.setShader(new LinearGradient(0.0f, 0.0f, this.gradientBrushLength, 0.0f, this.color1, this.color2, Shader.TileMode.CLAMP));
            this.mBoarderPaint.setShader(new LinearGradient(0.0f, 0.0f, this.gradientBrushLength, 0.0f, this.color1, this.color2, Shader.TileMode.CLAMP));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setNumOfDivs(int i10) {
        this.numOfDivs = i10;
    }

    public void setPercentFill(float f10) {
        this.percentFill = f10;
        invalidate();
    }

    public void setStart(int i10) {
        this.start = i10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }
}
