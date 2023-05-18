package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.u;
import li.x0;
import nb.v;
/* loaded from: classes2.dex */
public class ModeButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f21406a;

    /* renamed from: b  reason: collision with root package name */
    private a f21407b;

    /* renamed from: c  reason: collision with root package name */
    private int f21408c;

    /* renamed from: d  reason: collision with root package name */
    private int f21409d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21410e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21411f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f21412g;

    /* renamed from: h  reason: collision with root package name */
    private ConstraintLayout f21413h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f21414i;

    /* loaded from: classes2.dex */
    public interface a {
        void w0(int i10);
    }

    /* loaded from: classes2.dex */
    public enum b {
        NEW,
        COMPLETED
    }

    public ModeButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public ModeButton(Context context, String str, String str2, int i10, boolean z10, b bVar, int i11, a aVar, int i12) {
        super(context);
        b(str, str2, i10, z10, bVar, i11, aVar, i12);
    }

    private void c(View view) {
        this.f21410e = (TextView) view.findViewById(R.id.AB);
        this.f21412g = (ImageView) view.findViewById(R.id.f22071ic);
        this.f21413h = (ConstraintLayout) view.findViewById(R.id.f21952d6);
        this.f21411f = (TextView) view.findViewById(R.id.Ow);
        this.f21414i = (ImageView) view.findViewById(R.id.f22143lh);
    }

    private void d(int i10, String str, int i11) {
        this.f21410e.setText(str);
        this.f21410e.setTextColor(i10);
        this.f21410e.setTextSize(1, i11);
        this.f21410e.setTypeface(v.m());
    }

    private void e(String str, int i10, String str2, b bVar, boolean z10, int i11) {
        setFrameStroke(i10);
        setImage(str);
        d(i10, str2, i11);
        a(bVar);
    }

    private void setFrameStroke(int i10) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(this.f21409d);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setColor(i10);
        this.f21413h.setBackground(shapeDrawable);
    }

    private void setImage(String str) {
        u.x(str, this.f21412g);
    }

    public void a(b bVar) {
        if (bVar == b.NEW) {
            this.f21411f.setBackgroundResource(R.drawable.Q5);
            this.f21411f.setText(p0.l0("QUIZ_GAME_NEW"));
            this.f21411f.setVisibility(0);
        } else if (bVar != b.COMPLETED) {
            this.f21411f.setVisibility(8);
        } else {
            this.f21411f.setBackgroundResource(R.drawable.O5);
            this.f21411f.setText(p0.l0("QUIZ_GAME_COMPLETED"));
            this.f21411f.setVisibility(0);
        }
    }

    public void b(String str, String str2, int i10, boolean z10, b bVar, int i11, a aVar, int i12) {
        this.f21406a = i11;
        this.f21407b = aVar;
        if (z10) {
            this.f21408c = p0.s(145);
        } else {
            this.f21408c = p0.s(120);
        }
        this.f21409d = p0.s(1);
        View inflate = View.inflate(App.m(), R.layout.f22501d4, null);
        addView(inflate);
        int i13 = this.f21408c;
        setLayoutParams(new ViewGroup.LayoutParams(i13, i13));
        c(inflate);
        e(str, i10, str2, bVar, z10, i12);
        this.f21414i.setBackgroundColor(App.m().getResources().getColor(R.color.f21611a));
        if (z10) {
            setOnClickListener(this);
            return;
        }
        this.f21412g.getLayoutParams().height = p0.s(42);
    }

    public int getModeId() {
        return this.f21406a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            Log.d("onModeClick", "in click");
            a aVar = this.f21407b;
            if (aVar != null) {
                aVar.w0(this.f21406a);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
