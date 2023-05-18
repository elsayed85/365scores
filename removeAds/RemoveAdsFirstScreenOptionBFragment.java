package com.scores365.removeAds;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import li.x0;
import ne.k;
/* loaded from: classes2.dex */
public class RemoveAdsFirstScreenOptionBFragment extends Fragment {
    private static final String TAG = "RemoveAdsS1OptionBFrg";
    private ne.b billingProvider;
    private Dialog loadingDialog;
    private TextView manageAccountTV;
    private ConstraintLayout pbLoading;
    private RadioButton rbOneYear;
    private RadioButton rbThreeMonths;
    private RadioGroup rgSubscriptionLength;
    private TextView subsDescTV;
    private TextView tvBuyPackage;
    private TextView tvOneYear;
    private TextView tvThreeMonths;
    private TextView tvTitle;
    private View view;

    /* loaded from: classes2.dex */
    public static class ManageSubsClickListener implements View.OnClickListener {
        final String url = "https://play.google.com/store/account/subscriptions";

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                x0.M1("https://play.google.com/store/account/subscriptions");
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public static CharSequence getManageSubsText() {
        String l02 = p0.l0("TIPS_MANAGE");
        int indexOf = l02.indexOf(35);
        int indexOf2 = l02.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = l02.length();
        }
        String replace = l02.replace("#", "");
        String replace2 = replace.substring(indexOf, indexOf2 - 1).replace("#", "");
        return Html.fromHtml(replace.replace(replace2, "<font color='#03a9f4'><u>" + p0.l0("TIPS_HERE") + "</u></font>"));
    }

    private com.android.billingclient.api.e getSelectedSku() {
        if (this.rbThreeMonths.isChecked()) {
            return (com.android.billingclient.api.e) this.rbThreeMonths.getTag();
        }
        if (this.rbOneYear.isChecked()) {
            return (com.android.billingclient.api.e) this.rbOneYear.getTag();
        }
        return null;
    }

    private void initViews(@NonNull View view) {
        view.setVisibility(0);
        this.tvTitle = (TextView) view.findViewById(R.id.cD);
        this.rbOneYear = (RadioButton) view.findViewById(R.id.Hm);
        this.rbThreeMonths = (RadioButton) view.findViewById(R.id.Gm);
        this.tvOneYear = (TextView) view.findViewById(R.id.gI);
        this.tvThreeMonths = (TextView) view.findViewById(R.id.IG);
        this.tvBuyPackage = (TextView) view.findViewById(R.id.ix);
        this.rgSubscriptionLength = (RadioGroup) view.findViewById(R.id.dn);
        this.subsDescTV = (TextView) view.findViewById(R.id.Xr);
        this.manageAccountTV = (TextView) view.findViewById(R.id.f22009fh);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.Sm);
        this.pbLoading = constraintLayout;
        constraintLayout.setVisibility(0);
        this.tvTitle.setTypeface(o0.b(getActivity()));
        this.tvOneYear.setTypeface(o0.d(getActivity()));
        this.tvThreeMonths.setTypeface(o0.d(getActivity()));
        this.tvBuyPackage.setTypeface(o0.d(getActivity()));
        this.manageAccountTV.setTypeface(o0.d(getActivity()));
        this.subsDescTV.setTypeface(o0.d(getActivity()));
        this.subsDescTV.setText(p0.l0("ANDROID_REMOVE_ADS_EXPLANATION"));
        setManageAccountText();
        this.tvTitle.setText(p0.l0("NO_ADS_PURCHASE_DESC"));
        this.tvBuyPackage.setText(p0.l0("REMOVE_ADS_CTA"));
        this.tvBuyPackage.setClickable(true);
        this.billingProvider.A().j(getViewLifecycleOwner(), new c0() { // from class: com.scores365.removeAds.d
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                RemoveAdsFirstScreenOptionBFragment.this.lambda$initViews$3((Collection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$0(com.android.billingclient.api.e eVar, Collection collection) {
        if (getActivity() == null) {
            return;
        }
        String b10 = eVar.b();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ne.i iVar = (ne.i) it.next();
            if (iVar.c().contains(b10)) {
                this.billingProvider.w(iVar);
                Intent intent = new Intent(getActivity(), RemoveAdsBasicActivity.class);
                intent.putExtra("remove_ads_starting_screen", eRemoveAdsScreenType.APPROVEMENT_SCREEN.getValue());
                intent.putExtra("analytics_funnel", "Buy Package");
                intent.putExtra("is_lifetime", false);
                startActivity(intent);
                getActivity().finish();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$1(final com.android.billingclient.api.e eVar, ne.k kVar) {
        if (kVar instanceof k.f) {
            this.billingProvider.D().j(getViewLifecycleOwner(), new c0() { // from class: com.scores365.removeAds.g
                @Override // androidx.lifecycle.c0
                public final void d(Object obj) {
                    RemoveAdsFirstScreenOptionBFragment.this.lambda$initViews$0(eVar, (Collection) obj);
                }
            });
            return;
        }
        Log.e(TAG, "error starting purchase flow, result=" + kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$2(View view) {
        final com.android.billingclient.api.e selectedSku = getSelectedSku();
        if (selectedSku == null) {
            ng.a.f35508a.a(TAG, "no selected sku", null);
            return;
        }
        this.billingProvider.V((androidx.appcompat.app.d) requireActivity(), selectedSku, selectedSku.d().get(0).a()).j(getViewLifecycleOwner(), new c0() { // from class: com.scores365.removeAds.e
            @Override // androidx.lifecycle.c0
            public final void d(Object obj) {
                RemoveAdsFirstScreenOptionBFragment.this.lambda$initViews$1(selectedSku, (ne.k) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$3(Collection collection) {
        if (collection.isEmpty()) {
            this.pbLoading.setVisibility(0);
            return;
        }
        updateViews(collection);
        this.pbLoading.setVisibility(8);
        this.tvBuyPackage.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.removeAds.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoveAdsFirstScreenOptionBFragment.this.lambda$initViews$2(view);
            }
        });
    }

    public static RemoveAdsFirstScreenOptionBFragment newInstance() {
        return new RemoveAdsFirstScreenOptionBFragment();
    }

    private void setManageAccountText() {
        Spanned fromHtml;
        String l02 = p0.l0("TIPS_MANAGE");
        int indexOf = l02.indexOf(35);
        int indexOf2 = l02.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = l02.length();
        }
        String replace = l02.replace("#", "");
        String replace2 = replace.substring(indexOf, indexOf2 - 1).replace("#", "");
        String replace3 = replace.replace(replace2, "<font color='#03a9f4'><u>" + p0.l0("TIPS_HERE") + "</u></font>");
        if (Build.VERSION.SDK_INT >= 24) {
            TextView textView = this.manageAccountTV;
            fromHtml = Html.fromHtml(replace3, 63);
            textView.setText(fromHtml);
            this.manageAccountTV.setOnClickListener(new ManageSubsClickListener());
        }
    }

    private void setSkuText(@NonNull TextView textView, @NonNull View view, com.android.billingclient.api.e eVar, @NonNull String str, @NonNull String str2) {
        String replace = p0.l0(str).replace(str2, eVar == null ? "" : ne.h.a(eVar));
        view.setTag(eVar);
        textView.setText(replace);
    }

    private void updateViews(@NonNull Collection<com.android.billingclient.api.e> collection) {
        for (com.android.billingclient.api.e eVar : collection) {
            if (eVar.b().equals("no_ads_yearly_subs")) {
                setSkuText(this.tvOneYear, this.rbOneYear, eVar, "ADS_YEAR", "#YEARPRICE");
            } else if (eVar.b().equals("no_ads_monthly_subs")) {
                setSkuText(this.tvThreeMonths, this.rbThreeMonths, eVar, "ADS_MONTH", "#MONTHPRICE");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            androidx.fragment.app.h requireActivity = requireActivity();
            View inflate = layoutInflater.inflate(R.layout.f22696s7, viewGroup, false);
            this.view = inflate;
            inflate.setVisibility(8);
            this.loadingDialog = p0.H0(requireActivity, "", null);
            this.billingProvider = ((App) this.view.getContext().getApplicationContext()).i();
            initViews(this.view);
            p0.u0(this.loadingDialog);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.view;
    }
}
