package com.scores365.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.SwitchCompat;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.ui.BaseSettingsFragmentActivity;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class MyScoresSettingsFragment extends com.scores365.Design.Pages.a implements View.OnClickListener, BaseSettingsFragmentActivity.ShouldRestartRootActivityListener {
    boolean isDirty = false;
    AppCompatRadioButton rbStatus;
    AppCompatRadioButton rbTime;

    public static MyScoresSettingsFragment newInstance() {
        return new MyScoresSettingsFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResultIntentData() {
        try {
            Intent intent = new Intent();
            intent.putExtra("update_dashboard", true);
            getActivity().setResult(-1, intent);
            x0.A2(null, null);
        } catch (Exception unused) {
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return p0.l0("MY_SCORES_SETTINGS");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.W4) {
                this.isDirty = true;
                boolean N3 = sf.b.X1().N3();
                sf.b.X1().m6(!N3);
                setResultIntentData();
                Context m10 = App.m();
                String[] strArr = new String[2];
                strArr[0] = ServerProtocol.DIALOG_PARAM_STATE;
                strArr[1] = N3 ? "unselect" : "select";
                ee.k.o(m10, "settings", "enable-editor", "click", null, strArr);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.B4, viewGroup, false);
        try {
            TextView textView = (TextView) inflate.findViewById(R.id.Cy);
            textView.setText(p0.l0("SHOW_EDITOR_CHOICE"));
            textView.setTypeface(o0.d(App.m()));
            SwitchCompat switchCompat = (SwitchCompat) inflate.findViewById(R.id.W4);
            switchCompat.setOnClickListener(this);
            switchCompat.setChecked(sf.b.X1().N3());
            TextView textView2 = (TextView) inflate.findViewById(R.id.Zz);
            textView2.setText(p0.l0("GAMES_ORDER"));
            textView2.setTypeface(o0.d(App.m()));
            TextView textView3 = (TextView) inflate.findViewById(R.id.Rz);
            textView3.setText(p0.l0("ORDER_BY_GAME_STATUS"));
            textView3.setTypeface(o0.d(App.m()));
            TextView textView4 = (TextView) inflate.findViewById(R.id.Sz);
            textView4.setText(p0.l0("BY_GAME_STATUS_DESC"));
            textView4.setTypeface(o0.d(App.m()));
            TextView textView5 = (TextView) inflate.findViewById(R.id.Uz);
            textView5.setText(p0.l0("ORDER_BY_LEAGUE_TIME"));
            textView5.setTypeface(o0.d(App.m()));
            TextView textView6 = (TextView) inflate.findViewById(R.id.Vz);
            textView6.setText(p0.l0("BY_TIME_STATUS_DESC"));
            textView6.setTypeface(o0.d(App.m()));
            if (sf.b.X1().K0(true) == 1) {
                ((AppCompatRadioButton) inflate.findViewById(R.id.Em)).setChecked(true);
                ((AppCompatRadioButton) inflate.findViewById(R.id.Fm)).setChecked(false);
            } else {
                ((AppCompatRadioButton) inflate.findViewById(R.id.Em)).setChecked(false);
                ((AppCompatRadioButton) inflate.findViewById(R.id.Fm)).setChecked(true);
            }
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) inflate.findViewById(R.id.Em);
            this.rbStatus = appCompatRadioButton;
            appCompatRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.MyScoresSettingsFragment.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    if (z10) {
                        try {
                            MyScoresSettingsFragment.this.rbTime.setChecked(false);
                            compoundButton.setChecked(true);
                            if (sf.b.X1().K0(true) != 1) {
                                MainDashboardActivity.Z0 = true;
                            }
                            sf.b.X1().L7(true);
                            MyScoresSettingsFragment myScoresSettingsFragment = MyScoresSettingsFragment.this;
                            myScoresSettingsFragment.isDirty = true;
                            myScoresSettingsFragment.setResultIntentData();
                            ee.k.o(App.m(), "settings", "match-order", "click", null, "choice", "live-first");
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                }
            });
            AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) inflate.findViewById(R.id.Fm);
            this.rbTime = appCompatRadioButton2;
            appCompatRadioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.MyScoresSettingsFragment.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    if (z10) {
                        try {
                            MyScoresSettingsFragment.this.rbStatus.setChecked(false);
                            compoundButton.setChecked(true);
                            if (sf.b.X1().K0(true) == 1) {
                                MainDashboardActivity.Z0 = true;
                            }
                            sf.b.X1().L7(false);
                            MyScoresSettingsFragment myScoresSettingsFragment = MyScoresSettingsFragment.this;
                            myScoresSettingsFragment.isDirty = true;
                            myScoresSettingsFragment.setResultIntentData();
                            ee.k.o(App.m(), "settings", "match-order", "click", null, "choice", "selection");
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return inflate;
    }

    @Override // com.scores365.ui.BaseSettingsFragmentActivity.ShouldRestartRootActivityListener
    public boolean shouldRestartRootActivity() {
        return this.isDirty;
    }
}
