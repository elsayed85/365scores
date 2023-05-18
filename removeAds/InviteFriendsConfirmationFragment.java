package com.scores365.removeAds;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.scores365.R;
import com.scores365.removeAds.RemoveAdsBasicActivity;
import com.scores365.ui.LoginActivity;
import java.util.Date;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class InviteFriendsConfirmationFragment extends Fragment implements FacebookCallback<LoginResult> {
    ProfileTracker mProfileTracker;
    private TextView tvAdsExpiredDate;
    private TextView tvLoginTitle;
    private TextView tvSignInButton;
    private TextView tvTitle;

    private void initViews(View view) {
        try {
            this.tvTitle = (TextView) view.findViewById(R.id.Vx);
            this.tvAdsExpiredDate = (TextView) view.findViewById(R.id.my);
            this.tvLoginTitle = (TextView) view.findViewById(R.id.jB);
            TextView textView = (TextView) view.findViewById(R.id.fE);
            this.tvSignInButton = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.removeAds.InviteFriendsConfirmationFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        InviteFriendsConfirmationFragment.this.startActivityForResult(new Intent(InviteFriendsConfirmationFragment.this.getContext(), LoginActivity.class), 1);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            });
            this.tvTitle.setTypeface(o0.b(getActivity()));
            this.tvAdsExpiredDate.setTypeface(o0.a(getActivity()));
            this.tvLoginTitle.setTypeface(o0.c(getActivity()));
            this.tvSignInButton.setTypeface(o0.d(getActivity()));
            this.tvTitle.setText(p0.l0("NO_ADS_UNTIL"));
            this.tvLoginTitle.setText(p0.l0("SAVE_ADS_DEVICES"));
            this.tvAdsExpiredDate.setText("");
            try {
                this.tvAdsExpiredDate.setText(x0.T(new Date(getArguments().getLong("expiration_date")), true));
            } catch (Exception unused) {
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static InviteFriendsConfirmationFragment newInstance(Date date) {
        InviteFriendsConfirmationFragment inviteFriendsConfirmationFragment = new InviteFriendsConfirmationFragment();
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("expiration_date", date.getTime());
            inviteFriendsConfirmationFragment.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return inviteFriendsConfirmationFragment;
    }

    @Override // com.facebook.FacebookCallback
    public void onCancel() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.f22708t7, viewGroup, false);
            initViews(view);
            ((RemoveAdsBasicActivity) getActivity()).onActivityResultEventListener = new RemoveAdsBasicActivity.OnActivityResultEventListener() { // from class: com.scores365.removeAds.InviteFriendsConfirmationFragment.1
                @Override // com.scores365.removeAds.RemoveAdsBasicActivity.OnActivityResultEventListener
                public void onActivityResultEvent(int i10, int i11, Intent intent) {
                    try {
                        InviteFriendsConfirmationFragment.this.onActivityResult(i10, i11, intent);
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            };
            return view;
        } catch (Exception e10) {
            x0.N1(e10);
            return view;
        }
    }

    @Override // com.facebook.FacebookCallback
    public void onError(FacebookException facebookException) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.tvLoginTitle.setVisibility(0);
        this.tvSignInButton.setVisibility(0);
        if (sf.b.X1().P2() != 0) {
            this.tvLoginTitle.setVisibility(4);
            this.tvSignInButton.setVisibility(4);
        }
    }

    @Override // com.facebook.FacebookCallback
    public void onSuccess(LoginResult loginResult) {
        if (AccessToken.getCurrentAccessToken() != null) {
            if (Profile.getCurrentProfile() == null) {
                if (this.mProfileTracker == null) {
                    this.mProfileTracker = new ProfileTracker() { // from class: com.scores365.removeAds.InviteFriendsConfirmationFragment.3
                        @Override // com.facebook.ProfileTracker
                        protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                            Log.v("facebook - profile", profile2.getFirstName());
                            InviteFriendsConfirmationFragment.this.mProfileTracker.stopTracking();
                            sf.b.X1().K8(AccessToken.getCurrentAccessToken().getToken());
                            sf.b.X1().J8(profile2.getName());
                            sf.b.X1().H8(profile2.getId());
                            sf.b.X1().w9(1);
                        }
                    };
                }
                this.mProfileTracker.startTracking();
                return;
            }
            sf.b.X1().K8(AccessToken.getCurrentAccessToken().getToken());
            sf.b.X1().J8(Profile.getCurrentProfile().getName());
            sf.b.X1().H8(Profile.getCurrentProfile().getId());
            sf.b.X1().w9(1);
        }
    }
}
