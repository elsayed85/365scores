package com.scores365.Design.Pagers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.e1;
import androidx.viewpager.widget.ViewPager;
import com.scores365.App;
import com.scores365.Design.Pagers.GeneralTabPageIndicator;
import com.scores365.R;
import com.scores365.entitys.ScreenSizeEnum;
import li.o0;
import li.p0;
import li.u;
import li.x0;
/* loaded from: classes2.dex */
public class GeneralTabPageIndicator extends HorizontalScrollView {
    private static final int[] F = {16842901, 16842904};
    private int A;
    private int B;
    private int C;
    private int D;
    private Integer E;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout.LayoutParams f20915a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout.LayoutParams f20916b;

    /* renamed from: c  reason: collision with root package name */
    private final c f20917c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.j f20918d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f20919e;

    /* renamed from: f  reason: collision with root package name */
    protected ViewPager f20920f;

    /* renamed from: g  reason: collision with root package name */
    private int f20921g;

    /* renamed from: h  reason: collision with root package name */
    private int f20922h;

    /* renamed from: i  reason: collision with root package name */
    private float f20923i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f20924j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f20925k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20926l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f20927m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f20928n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f20929o;

    /* renamed from: p  reason: collision with root package name */
    private int f20930p;

    /* renamed from: q  reason: collision with root package name */
    private Integer f20931q;

    /* renamed from: r  reason: collision with root package name */
    private Integer f20932r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f20933s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f20934t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f20935u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f20936v;

    /* renamed from: w  reason: collision with root package name */
    private int f20937w;

    /* renamed from: x  reason: collision with root package name */
    private int f20938x;

    /* renamed from: y  reason: collision with root package name */
    private int f20939y;

    /* renamed from: z  reason: collision with root package name */
    private int f20940z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f20941a;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            try {
                this.f20941a = parcel.readInt();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            try {
                parcel.writeInt(this.f20941a);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            try {
                GeneralTabPageIndicator.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                GeneralTabPageIndicator generalTabPageIndicator = GeneralTabPageIndicator.this;
                generalTabPageIndicator.f20922h = generalTabPageIndicator.f20920f.getCurrentItem();
                GeneralTabPageIndicator generalTabPageIndicator2 = GeneralTabPageIndicator.this;
                generalTabPageIndicator2.m(generalTabPageIndicator2.f20922h, 0);
                GeneralTabPageIndicator.this.j();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        String a(int i10);

        boolean b(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements ViewPager.j {
        private c() {
        }

        /* synthetic */ c(GeneralTabPageIndicator generalTabPageIndicator, a aVar) {
            this();
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            if (i10 == 0) {
                try {
                    GeneralTabPageIndicator generalTabPageIndicator = GeneralTabPageIndicator.this;
                    generalTabPageIndicator.m(generalTabPageIndicator.f20920f.getCurrentItem(), 0);
                } catch (Exception e10) {
                    x0.N1(e10);
                    return;
                }
            }
            ViewPager.j jVar = GeneralTabPageIndicator.this.f20918d;
            if (jVar != null) {
                jVar.onPageScrollStateChanged(i10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            try {
                if (GeneralTabPageIndicator.this.f20919e == null || GeneralTabPageIndicator.this.f20919e.getChildAt(i10) == null) {
                    return;
                }
                GeneralTabPageIndicator.this.f20922h = i10;
                GeneralTabPageIndicator.this.f20923i = f10;
                GeneralTabPageIndicator generalTabPageIndicator = GeneralTabPageIndicator.this;
                generalTabPageIndicator.m(i10, (int) (generalTabPageIndicator.f20919e.getChildAt(i10).getWidth() * f10));
                GeneralTabPageIndicator.this.j();
                GeneralTabPageIndicator.this.invalidate();
                ViewPager.j jVar = GeneralTabPageIndicator.this.f20918d;
                if (jVar != null) {
                    jVar.onPageScrolled(i10, f10, i11);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            try {
                ViewPager.j jVar = GeneralTabPageIndicator.this.f20918d;
                if (jVar != null) {
                    jVar.onPageSelected(i10);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public GeneralTabPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GeneralTabPageIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20917c = new c(this, null);
        this.f20922h = 0;
        this.f20923i = 0.0f;
        this.f20926l = false;
        this.f20927m = false;
        this.f20928n = false;
        this.f20929o = false;
        this.f20930p = -1;
        this.f20931q = null;
        this.f20932r = null;
        this.f20933s = false;
        this.f20934t = false;
        this.f20935u = false;
        this.f20936v = true;
        this.f20937w = 52;
        this.f20938x = 1;
        this.f20939y = 2;
        this.f20940z = 4;
        this.A = 12;
        this.B = 1;
        this.C = 16;
        this.D = 0;
        this.E = null;
        setFillViewport(true);
        setWillNotDraw(false);
        this.f20919e = new LinearLayout(context);
        e1.I0(this, x0.m0());
        e1.I0(this.f20919e, x0.m0());
        this.f20919e.setOrientation(0);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.D, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 16;
        this.f20919e.setLayoutParams(layoutParams);
        this.f20919e.setGravity(16);
        addView(this.f20919e);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f20937w = (int) TypedValue.applyDimension(1, this.f20937w, displayMetrics);
        this.f20939y = (int) TypedValue.applyDimension(1, this.f20939y, displayMetrics);
        try {
            this.f20938x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.E, (int) TypedValue.applyDimension(1, this.f20938x, displayMetrics));
            obtainStyledAttributes.recycle();
            this.f20940z = (int) TypedValue.applyDimension(1, this.f20940z, displayMetrics);
            this.A = (int) TypedValue.applyDimension(1, this.A, displayMetrics);
            this.B = (int) TypedValue.applyDimension(1, this.B, displayMetrics);
            this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, F);
            this.C = obtainStyledAttributes2.getDimensionPixelSize(0, this.C);
            obtainStyledAttributes2.recycle();
            Paint paint = new Paint();
            this.f20924j = paint;
            paint.setAntiAlias(true);
            this.f20924j.setStyle(Paint.Style.FILL);
            Paint paint2 = new Paint();
            this.f20925k = paint2;
            paint2.setAntiAlias(true);
            this.f20925k.setStrokeWidth(this.B);
            this.f20915a = new LinearLayout.LayoutParams(-2, -1);
            this.f20916b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void i(int i10, String str) {
        TextView textView = new TextView(getContext());
        if (this.f20936v) {
            textView.setText(str.toUpperCase());
        } else {
            textView.setText(str);
        }
        textView.setGravity(17);
        textView.setSingleLine();
        h(i10, textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i10, View view) {
        try {
            this.f20920f.setCurrentItem(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, int i11) {
        try {
            if (this.f20921g == 0) {
                return;
            }
            int left = this.f20919e.getChildAt(i10).getLeft() + i11;
            if (i10 > 0 || i11 > 0) {
                left -= this.f20937w;
            }
            if (left != this.D) {
                this.D = left;
                scrollTo(left, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void q() {
        for (int i10 = 0; i10 < this.f20921g; i10++) {
            View childAt = this.f20919e.getChildAt(i10);
            TextView textView = childAt instanceof TextView ? (TextView) childAt : childAt instanceof LinearLayout ? (TextView) ((LinearLayout) childAt).getChildAt(1) : null;
            if (this.f20929o) {
                textView.setTextSize(1, 10.0f);
            } else {
                textView.setTextSize(0, this.C);
            }
            textView.setTypeface(o0.c(getContext()));
            if (this.f20933s) {
                textView.setTypeface(o0.c(App.m()));
                textView.setTextColor(this.f20932r.intValue());
            } else {
                Integer num = this.f20932r;
                if (num != null && !this.f20928n) {
                    textView.setTextColor(num.intValue());
                } else if (this.f20926l) {
                    textView.setTextColor(App.m().getResources().getColor(R.color.f21635y));
                } else {
                    textView.setTextColor(App.m().getResources().getColorStateList(p0.T(R.attr.f21539e)));
                }
            }
            Integer num2 = this.E;
            if (num2 != null) {
                textView.setTextColor(num2.intValue());
            }
        }
    }

    public View g(int i10, String str, String str2, boolean z10) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = null;
        try {
            linearLayout = (LinearLayout) LayoutInflater.from(this.f20919e.getContext()).inflate(R.layout.f22760y, (ViewGroup) this.f20919e, false);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            if (x0.n1()) {
                linearLayout.setBackgroundResource(R.drawable.R);
            } else {
                linearLayout.setBackgroundResource(R.drawable.Q);
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.Nd);
            imageView.setAdjustViewBounds(true);
            if (str2 == null || str2.isEmpty()) {
                imageView.setVisibility(8);
            } else if (z10) {
                try {
                    imageView.setImageResource(Integer.parseInt(str2));
                } catch (Exception e11) {
                    x0.N1(e11);
                }
            } else {
                u.x(str2, imageView);
            }
            TextView textView = (TextView) linearLayout.findViewById(R.id.pG);
            if (this.f20929o) {
                textView.setText(str);
            } else {
                if (this.f20936v) {
                    textView.setText(str.toUpperCase());
                } else {
                    textView.setText(str);
                }
                if (i10 == this.f20930p) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.f21683c4, 0);
                    textView.setCompoundDrawablePadding(p0.s(8));
                }
            }
            if (this.f20927m) {
                if (i10 == this.f20930p) {
                    textView.setGravity(17);
                } else {
                    textView.setGravity(81);
                }
                textView.setPadding(0, 0, 0, p0.s(6));
            } else {
                textView.setGravity(17);
                textView.setPadding(0, 0, 0, 0);
                textView.getLayoutParams().width = -2;
            }
            textView.setSingleLine();
            h(i10, linearLayout);
            return linearLayout;
        } catch (Exception e12) {
            e = e12;
            linearLayout2 = linearLayout;
            x0.N1(e);
            return linearLayout2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(final int i10, View view) {
        boolean z10 = true;
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: qb.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GeneralTabPageIndicator.this.k(i10, view2);
            }
        });
        z10 = (this.f20921g > 2 || p0.e0(getContext()) == ScreenSizeEnum.SMALL) ? false : false;
        this.f20934t = z10;
        if (z10 || this.f20935u) {
            view.setPadding(0, 0, 0, 0);
            this.f20919e.addView(view, i10, this.f20916b);
            return;
        }
        int i11 = this.A;
        view.setPadding(i11, 0, i11, 0);
        this.f20919e.addView(view, i10, this.f20915a);
    }

    public void j() {
        try {
            if (!(this.f20920f.getAdapter() instanceof b)) {
                for (int i10 = 0; i10 < this.f20919e.getChildCount(); i10++) {
                    ((TextView) this.f20919e.getChildAt(i10)).setSelected(false);
                }
                ((TextView) this.f20919e.getChildAt(this.f20922h)).setSelected(true);
                return;
            }
            for (int i11 = 0; i11 < this.f20919e.getChildCount(); i11++) {
                TextView textView = (TextView) this.f20919e.getChildAt(i11).findViewById(R.id.pG);
                ImageView imageView = (ImageView) this.f20919e.getChildAt(i11).findViewById(R.id.Nd);
                textView.setSelected(false);
                imageView.setSelected(false);
                if (this.f20933s) {
                    textView.setTypeface(o0.b(App.m()));
                    textView.setTextColor(this.f20932r.intValue());
                } else {
                    Integer num = this.f20932r;
                    if (num != null && !this.f20928n) {
                        textView.setTextColor(num.intValue());
                    } else if (this.f20926l) {
                        textView.setTextColor(p0.A(R.attr.f21565m1));
                    }
                }
                Integer num2 = this.E;
                if (num2 != null) {
                    textView.setTextColor(num2.intValue());
                    textView.setTypeface(o0.d(App.m()));
                }
                imageView.setAlpha(0.5f);
            }
            TextView textView2 = (TextView) this.f20919e.getChildAt(this.f20922h).findViewById(R.id.pG);
            ImageView imageView2 = (ImageView) this.f20919e.getChildAt(this.f20922h).findViewById(R.id.Nd);
            textView2.setSelected(true);
            imageView2.setSelected(true);
            if (this.f20933s) {
                textView2.setTypeface(o0.c(App.m()));
            }
            Integer num3 = this.f20931q;
            if (num3 == null && this.f20926l) {
                textView2.setTextColor(getContext().getResources().getColor(R.color.f21635y));
            } else if (num3 != null) {
                textView2.setTextColor(num3.intValue());
            }
            Integer num4 = this.E;
            if (num4 != null) {
                textView2.setTextColor(num4.intValue());
                textView2.setTypeface(o0.a(App.m()));
            }
            imageView2.setAlpha(1.0f);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void l() {
        int i10;
        this.f20919e.removeAllViews();
        this.f20921g = this.f20920f.getAdapter().e();
        int i11 = 0;
        while (true) {
            i10 = this.f20921g;
            if (i11 >= i10) {
                break;
            }
            if (this.f20920f.getAdapter() instanceof b) {
                g(i11, this.f20920f.getAdapter().g(i11).toString(), ((b) this.f20920f.getAdapter()).a(i11), ((b) this.f20920f.getAdapter()).b(i11));
            } else {
                try {
                    i(i11, this.f20920f.getAdapter().g(i11).toString());
                } catch (Exception unused) {
                    i(i11, String.valueOf(i11));
                }
            }
            i11++;
        }
        this.f20934t = i10 <= 2;
        q();
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void n() {
        this.f20933s = true;
    }

    public void o(int i10, int i11) {
        this.f20932r = Integer.valueOf(i11);
        this.f20931q = Integer.valueOf(i10);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        float f11;
        int i10;
        try {
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (!isInEditMode() && this.f20921g != 0) {
            int height = getHeight();
            if (this.f20928n) {
                this.f20924j.setColor(p0.A(R.attr.T0));
            } else {
                this.f20924j.setColor(p0.A(R.attr.f21536d));
            }
            View childAt = this.f20919e.getChildAt(this.f20922h);
            if (childAt != null) {
                f11 = childAt.getLeft();
                f10 = childAt.getRight();
            } else {
                f10 = 0.0f;
                f11 = 0.0f;
            }
            if (this.f20923i > 0.0f && (i10 = this.f20922h) < this.f20921g - 1) {
                View childAt2 = this.f20919e.getChildAt(i10 + 1);
                float f12 = this.f20923i;
                f11 = (childAt2.getLeft() * f12) + ((1.0f - f12) * f11);
                f10 = (childAt2.getRight() * f12) + ((1.0f - f12) * f10);
            }
            float f13 = height;
            canvas.drawRect(f11, height - this.f20938x, f10, f13, this.f20924j);
            this.f20924j.setColor(getResources().getColor(17170445));
            canvas.drawRect(0.0f, height - this.f20939y, this.f20919e.getWidth(), f13, this.f20924j);
            this.f20925k.setColor(getResources().getColor(17170445));
            for (int i11 = 0; i11 < this.f20921g - 1; i11++) {
                View childAt3 = this.f20919e.getChildAt(i11);
                canvas.drawLine(childAt3.getRight(), this.f20940z, childAt3.getRight(), height - this.f20940z, this.f20925k);
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f20922h = savedState.f20941a;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f20941a = this.f20922h;
        return savedState;
    }

    public void p(String str, String str2) {
        this.f20932r = Integer.valueOf(Color.parseColor("#" + str2));
        this.f20931q = Integer.valueOf(Color.parseColor("#" + str));
    }

    public void setAlignTabTextToBottom(boolean z10) {
        this.f20927m = z10;
    }

    public void setExpandedTabsContext(boolean z10) {
        this.f20935u = z10;
    }

    public void setHasIcons(boolean z10) {
        this.f20929o = z10;
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.f20918d = jVar;
    }

    public void setTabIndicatorColorWhite(boolean z10) {
        this.f20928n = z10;
    }

    public void setTabTextColorWhite(boolean z10) {
        this.f20926l = z10;
    }

    public void setTextColor(String str) {
        if (str == null) {
            this.E = null;
        } else {
            this.E = Integer.valueOf(Color.parseColor(str));
        }
    }

    public void setUseUpperText(boolean z10) {
        this.f20936v = z10;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f20920f = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.f20917c);
        l();
    }
}
