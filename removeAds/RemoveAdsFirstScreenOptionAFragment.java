package com.scores365.removeAds;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.scores365.App;
import com.scores365.R;
import com.scores365.ui.GeneralNotificationListFragment;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class RemoveAdsFirstScreenOptionAFragment extends Fragment {
    private View inviteConnectLineLeft;
    private View inviteConnectLineRight;
    private View.OnClickListener inviteFriendClickListener = new View.OnClickListener() { // from class: com.scores365.removeAds.c
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RemoveAdsFirstScreenOptionAFragment.this.lambda$new$1(view);
        }
    };
    private ImageView ivFirstFriend;
    private ImageView ivSecondFriend;
    private ImageView ivThirdFriend;
    private TextView tvFirstInvite;
    private TextView tvSecondInvite;
    private TextView tvThirdInvite;

    private void changeConnectingLine(View view) {
        try {
            view.setBackgroundColor(p0.A(R.attr.T0));
            view.setAlpha(1.0f);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void changeFriendImageView(ImageView imageView) {
        try {
            imageView.setImageResource(R.drawable.W2);
            imageView.setEnabled(false);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void checkForFriendsInviteCount(int i10) {
        try {
            if (i10 == 1) {
                changeFriendImageView(this.ivFirstFriend);
                changeConnectingLine(this.inviteConnectLineLeft);
                this.ivSecondFriend.setAlpha(1.0f);
                this.tvSecondInvite.setAlpha(1.0f);
                this.tvFirstInvite.setVisibility(4);
            } else if (i10 == 2) {
                changeFriendImageView(this.ivFirstFriend);
                changeFriendImageView(this.ivSecondFriend);
                changeConnectingLine(this.inviteConnectLineLeft);
                changeConnectingLine(this.inviteConnectLineRight);
                this.ivSecondFriend.setAlpha(1.0f);
                this.ivThirdFriend.setAlpha(1.0f);
                this.tvSecondInvite.setAlpha(1.0f);
                this.tvThirdInvite.setAlpha(1.0f);
                this.tvFirstInvite.setVisibility(4);
                this.tvSecondInvite.setVisibility(4);
            } else if (i10 != 3) {
            } else {
                changeFriendImageView(this.ivFirstFriend);
                changeFriendImageView(this.ivSecondFriend);
                changeFriendImageView(this.ivThirdFriend);
                changeConnectingLine(this.inviteConnectLineLeft);
                changeConnectingLine(this.inviteConnectLineRight);
                this.ivSecondFriend.setAlpha(1.0f);
                this.ivThirdFriend.setAlpha(1.0f);
                this.tvSecondInvite.setAlpha(1.0f);
                this.tvThirdInvite.setAlpha(1.0f);
                this.tvFirstInvite.setVisibility(4);
                this.tvSecondInvite.setVisibility(4);
                this.tvThirdInvite.setVisibility(4);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void initViews(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ZB);
        TextView textView2 = (TextView) view.findViewById(R.id.yA);
        TextView textView3 = (TextView) view.findViewById(R.id.OG);
        TextView textView4 = (TextView) view.findViewById(R.id.jx);
        TextView textView5 = (TextView) view.findViewById(R.id.ix);
        this.ivFirstFriend = (ImageView) view.findViewById(R.id.f22247qb);
        this.ivSecondFriend = (ImageView) view.findViewById(R.id.Vc);
        this.ivThirdFriend = (ImageView) view.findViewById(R.id.Vd);
        this.inviteConnectLineLeft = view.findViewById(R.id.R9);
        this.inviteConnectLineRight = view.findViewById(R.id.S9);
        this.tvFirstInvite = (TextView) view.findViewById(R.id.xA);
        this.tvSecondInvite = (TextView) view.findViewById(R.id.zA);
        this.tvThirdInvite = (TextView) view.findViewById(R.id.AA);
        textView.setTypeface(o0.b(getActivity()));
        textView2.setTypeface(o0.b(getActivity()));
        textView3.setTypeface(o0.b(getActivity()));
        textView4.setTypeface(o0.b(getActivity()));
        textView5.setTypeface(o0.d(getActivity()));
        this.tvFirstInvite.setTypeface(o0.d(getActivity()));
        this.tvSecondInvite.setTypeface(o0.d(getActivity()));
        this.tvThirdInvite.setTypeface(o0.d(getActivity()));
        this.ivFirstFriend.setOnClickListener(this.inviteFriendClickListener);
        this.ivSecondFriend.setOnClickListener(this.inviteFriendClickListener);
        this.ivThirdFriend.setOnClickListener(this.inviteFriendClickListener);
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.removeAds.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RemoveAdsFirstScreenOptionAFragment.this.lambda$initViews$0(view2);
            }
        });
        textView.setText(p0.l0("REMOVE_ADS_OPTIONS"));
        String l02 = p0.l0("INVITE_FRIENDS");
        try {
            l02 = l02.replace("#NUMBER", GeneralNotificationListFragment.ANALYTICS_ENTITY_TYPE_SPORT_TYPE);
        } catch (Exception unused) {
        }
        textView2.setText(l02);
        String l03 = p0.l0("TIME_NO_ADS");
        try {
            l03 = l03.replace("#NUMBER", "6");
        } catch (Exception unused2) {
        }
        textView3.setText(l03);
        textView4.setText(p0.l0("PURCHASE_NO_ADS"));
        textView5.setText(p0.l0("REMOVE_ADS_CTA"));
        this.tvFirstInvite.setText(p0.l0("INVITE"));
        this.tvSecondInvite.setText(p0.l0("INVITE"));
        this.tvThirdInvite.setText(p0.l0("INVITE"));
        boolean z10 = false;
        if (sf.a.i0(App.m()).j0() == 80) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            ((LinearLayout) view.findViewById(R.id.f22208og)).setPadding(0, sf.b.X1().S1() / 3, 0, 0);
        }
        try {
            z10 = Boolean.valueOf((String) cc.o0.y().q().get("REMOVE_ADS_NOT_ALLOWED")).booleanValue();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (z10) {
            view.findViewById(R.id.jx).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initViews$0(View view) {
        Intent intent = new Intent(view.getContext(), RemoveAdsBasicActivity.class);
        intent.putExtra("remove_ads_starting_screen", true);
        intent.putExtra("analytics_funnel", "");
        startActivity(intent);
        androidx.fragment.app.h activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        String replace;
        String replace2;
        try {
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            App app = (App) activity.getApplication();
            String inviteFriendsLink = RemoveAdsManager.getInviteFriendsLink(activity);
            try {
                replace2 = p0.l0("ADS_INVITE_FRIENDS_SHARE_TXT").replace("#LINK", inviteFriendsLink);
            } catch (Exception unused) {
            }
            try {
                replace = p0.l0("ADS_INVITE_FRIENDS_TWITTER").replace("#LINK", inviteFriendsLink);
            } catch (Exception unused2) {
            }
            x0.x2(activity.getApplicationContext(), inviteFriendsLink, replace, replace2, inviteFriendsLink);
            sf.b.X1().a7(true);
            app.n().t(true);
            ee.k.o(activity.getApplicationContext(), "remove-ads", "invite-friends", "click", null, "friend_number", String.valueOf(getArguments().getInt("friends_invited")));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static RemoveAdsFirstScreenOptionAFragment newInstance(int i10) {
        RemoveAdsFirstScreenOptionAFragment removeAdsFirstScreenOptionAFragment = new RemoveAdsFirstScreenOptionAFragment();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("friends_invited", i10);
            removeAdsFirstScreenOptionAFragment.setArguments(bundle);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return removeAdsFirstScreenOptionAFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = null;
        try {
            view = layoutInflater.inflate(R.layout.f22684r7, viewGroup, false);
            initViews(view);
            checkForFriendsInviteCount(getArguments().getInt("friends_invited"));
            return view;
        } catch (Exception e10) {
            x0.N1(e10);
            return view;
        }
    }
}
