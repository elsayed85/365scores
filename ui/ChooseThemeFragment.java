package com.scores365.ui;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb.m;
import cc.o0;
import com.scores365.App;
import com.scores365.R;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class ChooseThemeFragment extends com.scores365.Design.Pages.a implements View.OnClickListener {
    eThemesType choosenTheme;
    ViewHolder holder;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ViewHolder {
        ConstraintLayout background;
        ImageView checkMarkDark;
        ImageView checkMarkLight;
        TextView description;
        ImageView iv_previewDARK;
        ImageView iv_previewLIGHT;
        Button setThemeBTN;
        TextView title;

        private ViewHolder() {
        }
    }

    /* loaded from: classes2.dex */
    public enum eThemesType {
        none(1),
        dark(2),
        light(3);
        
        private int mValue;

        eThemesType(int i10) {
            this.mValue = i10;
        }

        public static eThemesType Create(int i10) {
            if (i10 == 1) {
                return none;
            }
            if (i10 == 2) {
                return dark;
            }
            if (i10 == 3) {
                return light;
            }
            return null;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    private void resetActivityViews() {
        try {
            this.holder.title.setText(p0.l0("THEME_TITLE_NEW_USER"));
            this.holder.description.setText(p0.l0("THEME_SUBTITLE"));
            this.holder.setThemeBTN.setText(p0.l0("MOBILE_MENU_SET_BACKGROUND"));
            this.holder.iv_previewDARK.setOnClickListener(this);
            this.holder.iv_previewLIGHT.setOnClickListener(this);
            this.holder.setThemeBTN.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.ChooseThemeFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    eThemesType ethemestype = ChooseThemeFragment.this.choosenTheme;
                    if (ethemestype != eThemesType.none) {
                        int value = ethemestype.getValue();
                        sf.b.X1().M5(value);
                        androidx.fragment.app.h activity = ChooseThemeFragment.this.getActivity();
                        if (value == eThemesType.light.getValue()) {
                            p0.C0(activity, R.style.f22831f);
                        } else {
                            p0.C0(activity, R.style.f22830e);
                        }
                        li.u.c();
                        ee.k.o(activity.getApplicationContext(), "app", "popup", "click", null, "type", "theme", "result", ChooseThemeFragment.this.choosenTheme.name());
                        o0.h(activity, true, true);
                        yc.m.B = null;
                        try {
                            activity.startActivity(x0.x0());
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                }
            });
            int i10 = App.f20805y;
            if (i10 == R.style.f22830e) {
                this.holder.iv_previewDARK.performClick();
            } else if (i10 == R.style.f22831f) {
                this.holder.iv_previewLIGHT.performClick();
            } else {
                this.choosenTheme = eThemesType.none;
            }
            startThemeConfigOnUi();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void startBackgroundAnimation(final ViewGroup viewGroup, int i10) {
        try {
            int color = App.m().getResources().getColor(i10);
            Drawable background = viewGroup.getBackground();
            bb.m y10 = bb.m.y(background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0, color);
            y10.B(new bb.b());
            y10.n(new m.g() { // from class: com.scores365.ui.ChooseThemeFragment.2
                @Override // bb.m.g
                public void onAnimationUpdate(bb.m mVar) {
                    viewGroup.setBackgroundColor(((Integer) mVar.t()).intValue());
                }
            });
            y10.A(400L);
            y10.F();
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    private void startThemeConfigOnUi() {
        try {
            eThemesType ethemestype = this.choosenTheme;
            if (ethemestype == eThemesType.none) {
                this.holder.background.setBackgroundResource(R.color.f21627q);
                this.holder.title.setTextColor(App.m().getResources().getColor(R.color.f21628r));
                this.holder.description.setTextColor(App.m().getResources().getColor(R.color.f21627q));
                this.holder.setThemeBTN.setBackgroundResource(R.drawable.N);
                p0.E0(getActivity(), R.color.f21623m);
                this.holder.checkMarkDark.setVisibility(8);
                this.holder.checkMarkLight.setVisibility(8);
            } else if (ethemestype == eThemesType.dark) {
                startBackgroundAnimation(this.holder.background, R.color.f21611a);
                this.holder.title.setTextColor(App.m().getResources().getColor(R.color.f21615e));
                this.holder.description.setTextColor(App.m().getResources().getColor(R.color.f21619i));
                p0.E0(getActivity(), 0);
                this.holder.checkMarkDark.setVisibility(0);
                this.holder.checkMarkLight.setVisibility(8);
            } else if (ethemestype == eThemesType.light) {
                startBackgroundAnimation(this.holder.background, R.color.f21622l);
                this.holder.title.setTextColor(App.m().getResources().getColor(R.color.f21625o));
                this.holder.description.setTextColor(App.m().getResources().getColor(R.color.f21627q));
                p0.E0(getActivity(), 0);
                this.holder.checkMarkDark.setVisibility(8);
                this.holder.checkMarkLight.setVisibility(0);
            }
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == this.holder.iv_previewLIGHT.getId()) {
                this.choosenTheme = eThemesType.light;
                this.holder.iv_previewDARK.setImageResource(R.drawable.L5);
                this.holder.iv_previewLIGHT.setOnClickListener(null);
                this.holder.iv_previewDARK.setOnClickListener(this);
                this.holder.setThemeBTN.setText(p0.l0("THEME_BUTTON_SET_LIGHT"));
            } else if (view.getId() == this.holder.iv_previewDARK.getId()) {
                this.choosenTheme = eThemesType.dark;
                this.holder.iv_previewLIGHT.setImageResource(R.drawable.M5);
                this.holder.iv_previewLIGHT.setOnClickListener(this);
                this.holder.iv_previewDARK.setOnClickListener(null);
                this.holder.setThemeBTN.setText(p0.l0("THEME_BUTTON_SET_DARK"));
            }
            if (this.holder.setThemeBTN.getVisibility() == 8) {
                this.holder.setThemeBTN.startAnimation(AnimationUtils.loadAnimation(App.m(), 17432576));
                this.holder.setThemeBTN.setVisibility(0);
            }
            startThemeConfigOnUi();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.holder = new ViewHolder();
            this.choosenTheme = eThemesType.none;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.M0, viewGroup, false);
            this.holder.background = (ConstraintLayout) view.findViewById(R.id.Q2);
            this.holder.title = (TextView) view.findViewById(R.id.ZG);
            this.holder.description = (TextView) view.findViewById(R.id.ry);
            this.holder.iv_previewDARK = (ImageView) view.findViewById(R.id.Td);
            this.holder.iv_previewLIGHT = (ImageView) view.findViewById(R.id.Ud);
            this.holder.checkMarkDark = (ImageView) view.findViewById(R.id.f22048hb);
            this.holder.checkMarkLight = (ImageView) view.findViewById(R.id.Wb);
            int p10 = (((App.p() - p0.s(32)) / 2) * 876) / 492;
            this.holder.iv_previewLIGHT.getLayoutParams().height = p10;
            this.holder.iv_previewDARK.getLayoutParams().height = p10;
            this.holder.setThemeBTN = (Button) view.findViewById(R.id.f21901b1);
            this.holder.setThemeBTN.setVisibility(8);
            this.holder.title.setTypeface(li.o0.d(App.m()));
            this.holder.description.setTypeface(li.o0.d(App.m()));
            this.holder.setThemeBTN.setTypeface(li.o0.d(App.m()));
            if (x0.n1()) {
                this.choosenTheme = eThemesType.light;
            } else {
                this.choosenTheme = eThemesType.dark;
            }
            startThemeConfigOnUi();
            ee.k.n(getActivity().getApplicationContext(), "app", "popup", "open", null, false, "type", "theme");
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        resetActivityViews();
    }
}
