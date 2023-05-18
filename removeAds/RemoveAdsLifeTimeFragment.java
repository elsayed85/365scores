package com.scores365.removeAds;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.c0;
import com.scores365.App;
import com.scores365.R;
import java.util.Collection;
import java.util.Iterator;
import li.o0;
import li.p0;
import ne.k;
/* loaded from: classes2.dex */
public class RemoveAdsLifeTimeFragment extends Fragment {
    private static final String TAG = "RemoveAdsLifeTimeFrg";
    private ne.b billingProvider;
    ConstraintLayout pbLoading;
    TextView tvButtonText;
    TextView tvDesc;
    TextView tvFooter;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            this.pbLoading.setVisibility(0);
            return;
        }
        this.pbLoading.setVisibility(8);
        Iterator it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.android.billingclient.api.e eVar = (com.android.billingclient.api.e) it.next();
            if (eVar.b().equals("no_ads_lifetime_sell")) {
                this.tvButtonText.setText(p0.l0("REMOVE_ADS_FOREVER_BUTTON").replace("#PRICE", ne.h.a(eVar)));
                break;
            }
        }
        this.tvFooter.setText(p0.l0("REMOVE_ADS_PROMO_LIMITED_TIME").replace("#TIME", this.billingProvider.E()));
        this.tvDesc.setText(p0.l0("REMOVE_ADS_PROMO_FOREVER").replaceAll("#", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((ne.i) it.next()).c().contains("no_ads_lifetime_sell")) {
                androidx.fragment.app.h requireActivity = requireActivity();
                Intent intent = new Intent(requireActivity, RemoveAdsBasicActivity.class);
                intent.putExtra("remove_ads_starting_screen", eRemoveAdsScreenType.APPROVEMENT_SCREEN.getValue());
                intent.putExtra("analytics_funnel", "Buy Package");
                intent.putExtra("is_lifetime", true);
                startActivity(intent);
                requireActivity.finish();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(ne.k kVar) {
        if (kVar instanceof k.f) {
            this.billingProvider.D().j(getViewLifecycleOwner(), new c0() { // from class: com.scores365.removeAds.h
                @Override // androidx.lifecycle.c0
                public final void d(Object obj) {
                    RemoveAdsLifeTimeFragment.this.lambda$onViewCreated$1((Collection) obj);
                }
            });
            return;
        }
        Log.e(TAG, "error starting purchase flow, result=" + kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(View view) {
        this.billingProvider.Z((androidx.appcompat.app.d) requireActivity()).j(getViewLifecycleOwner(), new c0() { // from class: com.scores365.removeAds.k
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                RemoveAdsLifeTimeFragment.this.lambda$onViewCreated$2((ne.k) obj);
            }
        });
    }

    @NonNull
    public static RemoveAdsLifeTimeFragment newInstance() {
        return new RemoveAdsLifeTimeFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.billingProvider = ((App) context.getApplicationContext()).i();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.f22720u7, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tvFooter = (TextView) view.findViewById(R.id.vz);
        this.tvDesc = (TextView) view.findViewById(R.id.py);
        this.tvButtonText = (TextView) view.findViewById(R.id.oG);
        Context context = view.getContext();
        Typeface d10 = o0.d(context);
        this.tvFooter.setTypeface(d10);
        this.tvButtonText.setTypeface(d10);
        this.tvDesc.setTypeface(o0.b(context));
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.Hf);
        this.pbLoading = constraintLayout;
        constraintLayout.setVisibility(0);
        this.billingProvider.A().j(getViewLifecycleOwner(), new c0() { // from class: com.scores365.removeAds.i
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                RemoveAdsLifeTimeFragment.this.lambda$onViewCreated$0((Collection) obj);
            }
        });
        this.tvButtonText.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.removeAds.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RemoveAdsLifeTimeFragment.this.lambda$onViewCreated$3(view2);
            }
        });
    }
}
