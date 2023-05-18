package com.scores365.Design.Pages;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.scores365.App;
import com.scores365.dashboard.a;
import com.scores365.gameCenter.o0;
import li.x0;
/* compiled from: BasePage.java */
/* loaded from: classes2.dex */
public abstract class a extends Fragment {
    protected static final String DIRECT_DEALS_ADS_TAG = "show_direct_deals_ads";
    protected static final String EMPTY_MSG_TAG = "your_empty_msg";
    protected static final String GAME_CENTER_SCOPE_TAG = "game_center_score_tag";
    protected static final String IS_DATA_FETCHED = "isDataFetched";
    protected static final String NATIVE_ADS_TAG = "is_need_to_add_native_ad";
    protected static final String PAGE_KEY = "page_key";
    public boolean isReversed;
    protected String pageIconLink;
    protected String pageTitle;
    protected sc.i placement;
    private boolean lockOpeningActivity = false;
    protected boolean isClickBlocked = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public ne.b getBillingController() {
        return ((App) App.m()).i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o0 getContentPaddingListener() {
        if (getParentFragment() instanceof o0) {
            return (o0) getParentFragment();
        }
        if (getActivity() instanceof o0) {
            return (o0) getActivity();
        }
        return null;
    }

    public abstract String getIconLink();

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPaddingSize() {
        try {
            o0 contentPaddingListener = getContentPaddingListener();
            if (contentPaddingListener != null) {
                return contentPaddingListener.getPaddingSize(this);
            }
            return 0;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.scores365.Design.Activities.g getPageScrollListener() {
        com.scores365.Design.Activities.g gVar;
        try {
            if ((getActivity() instanceof com.scores365.Design.Activities.g) && !shouldConsiderParentFragmentDataMgrOverActivityDataMgr()) {
                gVar = (com.scores365.Design.Activities.g) getActivity();
            } else if (!(getParentFragment() instanceof a.d)) {
                return null;
            } else {
                gVar = (com.scores365.Design.Activities.g) getParentFragment();
            }
            return gVar;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public abstract String getPageTitle();

    /* JADX INFO: Access modifiers changed from: protected */
    public a.d getPagesDataListener() {
        a.d dVar;
        try {
            if ((getActivity() instanceof a.d) && !shouldConsiderParentFragmentDataMgrOverActivityDataMgr()) {
                dVar = (a.d) getActivity();
            } else if (!(getParentFragment() instanceof a.d)) {
                return null;
            } else {
                dVar = (a.d) getParentFragment();
            }
            return dVar;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public fi.d getTipController() {
        return ((App) App.m()).w();
    }

    public void handleContentPadding() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasContentPadding() {
        try {
            o0 contentPaddingListener = getContentPaddingListener();
            if (contentPaddingListener != null) {
                return contentPaddingListener.contentHasPadding();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContainedInCoordinatorLayout() {
        return false;
    }

    public boolean isOpeningActivityLocked() {
        return this.lockOpeningActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isPageDataFetched() {
        try {
            if (getArguments() != null) {
                return getArguments().getBoolean(IS_DATA_FETCHED, false);
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void lockUnLockActivityOpening() {
        this.lockOpeningActivity = !this.lockOpeningActivity;
    }

    public void onPageSelectedInViewPager() {
    }

    public void renderNativeAds() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public Bundle safeGetArguments() {
        Bundle arguments = getArguments();
        return arguments == null ? new Bundle() : arguments;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPageDataFetched(boolean z10) {
        try {
            if (getArguments() == null) {
                setArguments(new Bundle());
            }
            getArguments().putBoolean(IS_DATA_FETCHED, z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected boolean shouldConsiderParentFragmentDataMgrOverActivityDataMgr() {
        try {
            if (getParentFragment() instanceof a) {
                return ((a) getParentFragment()).shouldConsiderParentFragmentDataMgrOverActivityDataMgr();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void startActivityForResultWithLock(Intent intent, int i10) {
        try {
            if (isOpeningActivityLocked()) {
                lockUnLockActivityOpening();
                startActivityForResult(intent, i10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void updatePageData(Object obj) {
    }
}
