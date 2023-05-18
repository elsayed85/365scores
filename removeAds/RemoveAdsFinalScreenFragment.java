package com.scores365.removeAds;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.scores365.R;
import com.scores365.removeAds.RemoveAdsFirstScreenOptionBFragment;
import java.util.Date;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class RemoveAdsFinalScreenFragment extends Fragment {
    @NonNull
    public static RemoveAdsFinalScreenFragment newInstance(boolean z10, Date date) {
        RemoveAdsFinalScreenFragment removeAdsFinalScreenFragment = new RemoveAdsFinalScreenFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("lifetime", z10);
        if (date != null) {
            bundle.putLong("expiration_date", date.getTime());
        }
        removeAdsFinalScreenFragment.setArguments(bundle);
        return removeAdsFinalScreenFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f22672q7, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.oB);
        TextView textView2 = (TextView) inflate.findViewById(R.id.my);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sB);
        textView.setTypeface(o0.b(getActivity()));
        textView2.setTypeface(o0.a(getActivity()));
        textView3.setTypeface(o0.d(getActivity()));
        textView.setText(p0.l0("NO_ADS_UNTIL"));
        textView2.setText("");
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j10 = arguments.getLong("expiration_date", -1L);
            if (arguments.getBoolean("is_lifetime", false)) {
                textView2.setText(p0.l0("REMOVE_ADS_CONFIRMATION_IPHONE"));
            } else if (j10 > 0) {
                textView2.setText(x0.T(new Date(j10), true));
            }
        }
        textView3.setText(RemoveAdsFirstScreenOptionBFragment.getManageSubsText());
        textView3.setOnClickListener(new RemoveAdsFirstScreenOptionBFragment.ManageSubsClickListener());
        return inflate;
    }
}
