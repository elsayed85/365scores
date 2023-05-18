package com.scores365.gameCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class HeaderBonusView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f23688d;

    /* renamed from: e  reason: collision with root package name */
    TextView f23689e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<View> f23690f;

    public HeaderBonusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public HeaderBonusView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initView();
    }

    private void initView() {
        View inflate = View.inflate(getContext(), R.layout.f22575j0, this);
        this.f23689e = (TextView) inflate.findViewById(R.id.f21900b0);
        this.f23688d = (LinearLayout) inflate.findViewById(R.id.f21877a0);
        this.f23689e.setTypeface(li.o0.d(App.m()));
        ArrayList<View> arrayList = new ArrayList<>();
        this.f23690f = arrayList;
        arrayList.add(inflate.findViewById(R.id.Q6));
        this.f23690f.add(inflate.findViewById(R.id.S6));
        this.f23690f.add(inflate.findViewById(R.id.V6));
        this.f23690f.add(inflate.findViewById(R.id.R6));
        this.f23690f.add(inflate.findViewById(R.id.P6));
        this.f23690f.add(inflate.findViewById(R.id.U6));
        this.f23690f.add(inflate.findViewById(R.id.T6));
    }

    public void d(e eVar, int i10, String str) {
        try {
            if (eVar == null) {
                Log.d("teamFouls", "no data");
                this.f23688d.setVisibility(8);
                this.f23689e.setVisibility(8);
                return;
            }
            if (eVar.b()) {
                this.f23689e.setText(li.p0.l0("BASKETBALL_BONUS"));
                this.f23689e.setVisibility(0);
            } else {
                this.f23689e.setText("");
                this.f23689e.setVisibility(4);
            }
            this.f23688d.setVisibility(0);
            if (i10 != this.f23690f.size()) {
                for (int size = this.f23690f.size() - 1; size >= i10; size--) {
                    this.f23690f.get(size).setVisibility(8);
                }
            }
            for (int i11 = 0; i11 < i10; i11++) {
                if (i11 < eVar.a()) {
                    this.f23690f.get(i11).setBackgroundResource(R.drawable.f21695e0);
                } else {
                    this.f23690f.get(i11).setBackgroundResource(R.drawable.f21703f0);
                }
            }
        } catch (Exception unused) {
            this.f23688d.setVisibility(8);
            this.f23689e.setVisibility(8);
        }
    }
}
