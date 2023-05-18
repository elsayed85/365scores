package com.scores365.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.e1;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.ScreenSizeEnum;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SyncOldConfigurationFragment extends Fragment {
    private static final String COMPETITIONS_COUNT = "competitions_count";
    private static final String COMPETITORS_COUNT = "competitors_count";
    public static final String IS_MANUAL_REQUEST = "manual_request";
    private Toolbar frgToolbar;
    private ImageView ivSyncAnim;
    private OnUserChoiceSelectedListener listener;
    private TextView tvEntityCounter;
    private TextView tvEntityCounterTitle;
    private TextView tvSync;
    private TextView tvTitle;

    /* loaded from: classes2.dex */
    public interface OnUserChoiceSelectedListener {
        void onAbortSelected(boolean z10);

        void onSyncSelected(boolean z10);
    }

    private void getTeamsSyncStatusText() {
        int lastIndexOf;
        String replaceFirst;
        try {
            String replace = p0.l0("ANDROID_SYNC_STATUS").replaceFirst("#NUMBER", String.valueOf(getArguments().getInt(COMPETITORS_COUNT, 0))).replace("#NUMBER", String.valueOf(getArguments().getInt(COMPETITIONS_COUNT, 0)));
            int indexOf = replace.indexOf("[");
            String replaceFirst2 = replace.replaceFirst("\\[", "");
            int indexOf2 = replaceFirst2.indexOf("]");
            String replaceFirst3 = replaceFirst2.replaceFirst("\\]", "");
            int lastIndexOf2 = replaceFirst3.lastIndexOf("[");
            String replaceFirst4 = replaceFirst3.replaceFirst("\\[", "");
            if (replaceFirst4.indexOf("]") == replaceFirst4.length() - 1) {
                replaceFirst = replaceFirst4.replaceFirst("\\]", "");
                lastIndexOf = replaceFirst.length();
            } else {
                lastIndexOf = replaceFirst4.lastIndexOf("]");
                replaceFirst = replaceFirst4.replaceFirst("\\]", "");
            }
            SpannableString spannableString = new SpannableString(replaceFirst);
            spannableString.setSpan(new StyleSpan(1), indexOf, indexOf2, 0);
            spannableString.setSpan(new StyleSpan(1), lastIndexOf2, lastIndexOf, 0);
            spannableString.setSpan(new ForegroundColorSpan(p0.A(R.attr.T0)), indexOf, indexOf2, 0);
            spannableString.setSpan(new ForegroundColorSpan(p0.A(R.attr.T0)), lastIndexOf2, lastIndexOf, 0);
            this.tvEntityCounter.setText(spannableString);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static SyncOldConfigurationFragment newInstance(OnUserChoiceSelectedListener onUserChoiceSelectedListener, int i10, int i11, boolean z10) {
        SyncOldConfigurationFragment syncOldConfigurationFragment = new SyncOldConfigurationFragment();
        syncOldConfigurationFragment.listener = onUserChoiceSelectedListener;
        Bundle bundle = new Bundle();
        bundle.putInt(COMPETITORS_COUNT, i10);
        bundle.putInt(COMPETITIONS_COUNT, i11);
        bundle.putBoolean("manual_request", z10);
        syncOldConfigurationFragment.setArguments(bundle);
        return syncOldConfigurationFragment;
    }

    private void relateViews(View view) {
        this.frgToolbar = (Toolbar) view.findViewById(R.id.Uh);
        this.tvTitle = (TextView) view.findViewById(R.id.YG);
        ScreenSizeEnum e02 = p0.e0(App.m());
        ScreenSizeEnum screenSizeEnum = ScreenSizeEnum.SMALL;
        if (e02 == screenSizeEnum || p0.e0(App.m()) == ScreenSizeEnum.NORMAL) {
            this.tvTitle.setTextSize(1, 30.0f);
        }
        this.tvTitle.setText(p0.l0("ANDROID_SYNC_EXISTING_USER"));
        this.tvTitle.setTypeface(o0.c(App.m()));
        this.ivSyncAnim = (ImageView) view.findViewById(R.id.Ra);
        androidx.core.content.a.getDrawable(App.m(), R.drawable.P4);
        androidx.core.content.a.getDrawable(App.m(), R.drawable.Q4);
        this.tvEntityCounterTitle = (TextView) view.findViewById(R.id.Jy);
        if (p0.e0(App.m()) == screenSizeEnum) {
            this.tvEntityCounterTitle.setTextSize(1, 13.0f);
        }
        this.tvEntityCounterTitle.setTypeface(o0.b(App.m()));
        this.tvEntityCounterTitle.setText(p0.l0("ANDROID_SYNC_PREVIOUS_SETTINGS"));
        TextView textView = (TextView) view.findViewById(R.id.Iy);
        this.tvEntityCounter = textView;
        textView.setTypeface(o0.d(App.m()));
        if (p0.e0(App.m()) == screenSizeEnum) {
            this.tvEntityCounter.setTextSize(1, 13.0f);
        }
        getTeamsSyncStatusText();
        TextView textView2 = (TextView) view.findViewById(R.id.oG);
        this.tvSync = textView2;
        textView2.setTypeface(o0.d(App.m()));
        this.tvSync.setText(p0.l0("ANDROID_SYNC_SYNC"));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.F9, viewGroup, false);
            relateViews(view);
            this.frgToolbar.removeAllViews();
            String l02 = p0.l0("ANDROID_SYNC_TITLE");
            if (l02.contains("!")) {
                l02 = l02.replace("!", "!\n");
            }
            this.frgToolbar.setTitle(l02);
            e1.I0(this.frgToolbar, x0.m0());
            this.frgToolbar.setNavigationIcon(R.drawable.f21766n);
            this.frgToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.SyncOldConfigurationFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        if (SyncOldConfigurationFragment.this.listener != null) {
                            SyncOldConfigurationFragment.this.listener.onAbortSelected(SyncOldConfigurationFragment.this.getArguments().getBoolean("manual_request", false));
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
            for (int i10 = 0; i10 < this.frgToolbar.getChildCount(); i10++) {
                if (this.frgToolbar.getChildAt(i10) instanceof TextView) {
                    ((TextView) this.frgToolbar.getChildAt(i10)).setTypeface(o0.d(App.m()));
                }
            }
            this.tvSync.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.SyncOldConfigurationFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        if (SyncOldConfigurationFragment.this.listener != null) {
                            try {
                                Animation loadAnimation = AnimationUtils.loadAnimation(App.m(), R.anim.f21502b);
                                loadAnimation.setStartOffset(145L);
                                SyncOldConfigurationFragment.this.ivSyncAnim.startAnimation(loadAnimation);
                                SyncOldConfigurationFragment.this.tvSync.setEnabled(false);
                            } catch (Exception e10) {
                                x0.N1(e10);
                            }
                            SyncOldConfigurationFragment.this.listener.onSyncSelected(SyncOldConfigurationFragment.this.getArguments().getBoolean("manual_request", false));
                        }
                    } catch (Exception e11) {
                        x0.N1(e11);
                    }
                }
            });
            Context applicationContext = getActivity().getApplicationContext();
            String[] strArr = new String[2];
            strArr[0] = "request";
            strArr[1] = getArguments().getBoolean("manual_request", false) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0";
            ee.k.q(applicationContext, "synchronization", ServerProtocol.DIALOG_PARAM_DISPLAY, null, false, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ivSyncAnim.getAnimation() != null) {
            this.ivSyncAnim.clearAnimation();
        }
    }
}
