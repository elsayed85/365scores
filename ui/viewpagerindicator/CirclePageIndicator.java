package com.scores365.ui.viewpagerindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.y2;
import androidx.viewpager.widget.ViewPager;
import com.scores365.R;
import li.p0;
/* loaded from: classes2.dex */
public class CirclePageIndicator extends View implements PageIndicator {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private boolean mCentered;
    private int mCurrentPage;
    private boolean mIsDragging;
    private float mLastMotionX;
    private ViewPager.j mListener;
    private int mOrientation;
    private float mPageOffset;
    private final Paint mPaintFill;
    private final Paint mPaintPageFill;
    private final Paint mPaintStroke;
    private float mRadius;
    private int mScrollState;
    private boolean mSnap;
    private int mSnapPage;
    private int mTouchSlop;
    private ViewPager mViewPager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.scores365.ui.viewpagerindicator.CirclePageIndicator.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        int currentPage;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPage = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.currentPage);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.M1);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Paint paint = new Paint(1);
        this.mPaintPageFill = paint;
        Paint paint2 = new Paint(1);
        this.mPaintStroke = paint2;
        Paint paint3 = new Paint(1);
        this.mPaintFill = paint3;
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        if (isInEditMode()) {
            return;
        }
        int A = p0.A(R.attr.f21565m1);
        int A2 = p0.A(R.attr.B1);
        int integer = getResources().getInteger(R.integer.f22456a);
        int color = getResources().getColor(R.color.f21621k);
        float dimension = getResources().getDimension(R.dimen.f21642g);
        boolean z10 = getResources().getBoolean(R.bool.f21605a);
        boolean z11 = getResources().getBoolean(R.bool.f21606b);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f22846h, i10, 0);
        this.mCentered = obtainStyledAttributes.getBoolean(R.styleable.f22849k, z10);
        this.mOrientation = obtainStyledAttributes.getInt(R.styleable.f22847i, integer);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(obtainStyledAttributes.getColor(R.styleable.f22851m, A));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(obtainStyledAttributes.getColor(R.styleable.f22854p, color));
        paint2.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.f22855q, dimension));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(obtainStyledAttributes.getColor(R.styleable.f22850l, A2));
        this.mRadius = obtainStyledAttributes.getDimension(R.styleable.f22852n, p0.s(5));
        this.mSnap = obtainStyledAttributes.getBoolean(R.styleable.f22853o, z11);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.f22848j);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.mTouchSlop = y2.d(ViewConfiguration.get(context));
    }

    private int measureLong(int i10) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824 || (viewPager = this.mViewPager) == null) {
            return size;
        }
        int e10 = viewPager.getAdapter().e();
        float f10 = this.mRadius;
        int paddingLeft = (int) (getPaddingLeft() + getPaddingRight() + (e10 * 2 * f10) + ((e10 - 1) * f10) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int measureShort(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.mRadius * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public int getFillColor() {
        return this.mPaintFill.getColor();
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPageColor() {
        return this.mPaintPageFill.getColor();
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getStrokeColor() {
        return this.mPaintStroke.getColor();
    }

    public float getStrokeWidth() {
        return this.mPaintStroke.getStrokeWidth();
    }

    public boolean isCentered() {
        return this.mCentered;
    }

    public boolean isSnap() {
        return this.mSnap;
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator
    public void notifyDataSetChanged() {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int e10;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        float f10;
        float f11;
        super.onDraw(canvas);
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || (e10 = viewPager.getAdapter().e()) == 0) {
            return;
        }
        if (this.mCurrentPage >= e10) {
            setCurrentItem(e10 - 1);
            return;
        }
        if (this.mOrientation == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f12 = this.mRadius;
        float f13 = 4.0f * f12;
        float f14 = paddingLeft + f12;
        float f15 = paddingTop + f12;
        if (this.mCentered) {
            f15 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((e10 * f13) / 2.0f);
        }
        if (this.mPaintStroke.getStrokeWidth() > 0.0f) {
            f12 -= this.mPaintStroke.getStrokeWidth() / 2.0f;
        }
        for (int i10 = 0; i10 < e10; i10++) {
            float f16 = (i10 * f13) + f15;
            if (this.mOrientation == 0) {
                f11 = this.mCentered ? getHeight() / 2 : f14;
            } else {
                f11 = f16;
                f16 = this.mCentered ? getWidth() / 2 : f14;
            }
            if (this.mPaintPageFill.getAlpha() > 0) {
                canvas.drawCircle(f16, f11, f12, this.mPaintPageFill);
            }
            float f17 = this.mRadius;
            if (f12 != f17) {
                canvas.drawCircle(f16, f11, f17, this.mPaintStroke);
            }
        }
        boolean z10 = this.mSnap;
        float f18 = (z10 ? this.mSnapPage : this.mCurrentPage) * f13;
        if (!z10) {
            f18 += this.mPageOffset * f13;
        }
        if (this.mOrientation == 0) {
            f10 = f15 + f18;
            if (this.mCentered) {
                f14 = getHeight() / 2;
            }
        } else {
            if (this.mCentered) {
                f14 = getWidth() / 2;
            }
            float f19 = f15 + f18;
            f10 = f14;
            f14 = f19;
        }
        canvas.drawCircle(f10, f14, this.mRadius, this.mPaintFill);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.mOrientation == 0) {
            setMeasuredDimension(measureLong(i10), measureShort(i11));
        } else {
            setMeasuredDimension(measureShort(i10), measureLong(i11));
        }
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator, androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i10) {
        this.mScrollState = i10;
        ViewPager.j jVar = this.mListener;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i10);
        }
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator, androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i10, float f10, int i11) {
        this.mCurrentPage = i10;
        this.mPageOffset = f10;
        invalidate();
        ViewPager.j jVar = this.mListener;
        if (jVar != null) {
            jVar.onPageScrolled(i10, f10, i11);
        }
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator, androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i10) {
        if (this.mSnap || this.mScrollState == 0) {
            this.mCurrentPage = i10;
            this.mSnapPage = i10;
            invalidate();
        }
        ViewPager.j jVar = this.mListener;
        if (jVar != null) {
            jVar.onPageSelected(i10);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i10 = savedState.currentPage;
        this.mCurrentPage = i10;
        this.mSnapPage = i10;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPage = this.mCurrentPage;
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null || viewPager.getAdapter().e() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float e10 = androidx.core.view.p0.e(motionEvent, androidx.core.view.p0.a(motionEvent, this.mActivePointerId));
                    float f10 = e10 - this.mLastMotionX;
                    if (!this.mIsDragging && Math.abs(f10) > this.mTouchSlop) {
                        this.mIsDragging = true;
                    }
                    if (this.mIsDragging) {
                        this.mLastMotionX = e10;
                        if (this.mViewPager.z() || this.mViewPager.e()) {
                            this.mViewPager.r(f10);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int b10 = androidx.core.view.p0.b(motionEvent);
                        this.mLastMotionX = androidx.core.view.p0.e(motionEvent, b10);
                        this.mActivePointerId = androidx.core.view.p0.d(motionEvent, b10);
                    } else if (action == 6) {
                        int b11 = androidx.core.view.p0.b(motionEvent);
                        if (androidx.core.view.p0.d(motionEvent, b11) == this.mActivePointerId) {
                            this.mActivePointerId = androidx.core.view.p0.d(motionEvent, b11 == 0 ? 1 : 0);
                        }
                        this.mLastMotionX = androidx.core.view.p0.e(motionEvent, androidx.core.view.p0.a(motionEvent, this.mActivePointerId));
                    }
                }
            }
            if (!this.mIsDragging) {
                int e11 = this.mViewPager.getAdapter().e();
                float width = getWidth();
                float f11 = width / 2.0f;
                float f12 = width / 6.0f;
                if (this.mCurrentPage > 0 && motionEvent.getX() < f11 - f12) {
                    if (action != 3) {
                        this.mViewPager.setCurrentItem(this.mCurrentPage - 1);
                    }
                    return true;
                } else if (this.mCurrentPage < e11 - 1 && motionEvent.getX() > f11 + f12) {
                    if (action != 3) {
                        this.mViewPager.setCurrentItem(this.mCurrentPage + 1);
                    }
                    return true;
                }
            }
            this.mIsDragging = false;
            this.mActivePointerId = -1;
            if (this.mViewPager.z()) {
                this.mViewPager.p();
            }
        } else {
            this.mActivePointerId = androidx.core.view.p0.d(motionEvent, 0);
            this.mLastMotionX = motionEvent.getX();
        }
        return true;
    }

    public void setCentered(boolean z10) {
        this.mCentered = z10;
        invalidate();
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator
    public void setCurrentItem(int i10) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        viewPager.setCurrentItem(i10);
        this.mCurrentPage = i10;
        invalidate();
    }

    public void setFillColor(int i10) {
        this.mPaintFill.setColor(i10);
        invalidate();
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator
    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.mListener = jVar;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.mOrientation = i10;
        requestLayout();
    }

    public void setPageColor(int i10) {
        this.mPaintPageFill.setColor(i10);
        invalidate();
    }

    public void setRadius(float f10) {
        this.mRadius = f10;
        invalidate();
    }

    public void setSnap(boolean z10) {
        this.mSnap = z10;
        invalidate();
    }

    public void setStrokeColor(int i10) {
        this.mPaintStroke.setColor(i10);
        invalidate();
    }

    public void setStrokeWidth(float f10) {
        this.mPaintStroke.setStrokeWidth(f10);
        invalidate();
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator
    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.mViewPager = viewPager;
        viewPager.setOnPageChangeListener(this);
        invalidate();
    }

    @Override // com.scores365.ui.viewpagerindicator.PageIndicator
    public void setViewPager(ViewPager viewPager, int i10) {
        setViewPager(viewPager);
        setCurrentItem(i10);
    }
}
