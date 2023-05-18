package com.scores365.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cc.o0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.ui.PlayerView;
import com.scores365.App;
import com.scores365.R;
import com.scores365.VideoFullScreenActivity;
import com.scores365.dashboardEntities.PageBuzzBase;
import com.scores365.entitys.EntityConnection;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.ItemObj;
import com.scores365.entitys.NewsObj;
import com.scores365.gameCenter.i0;
import com.scores365.removeAds.RemoveAdsManager;
import com.scores365.ui.Bet365LandingActivity;
import com.scores365.ui.WebViewActivity;
import im.ene.toro.widget.Container;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import li.p0;
import li.x0;
import li.z;
import mf.a;
import mf.c;
/* compiled from: BuzzPage.java */
/* loaded from: classes2.dex */
public class f extends com.scores365.Design.Pages.h implements View.OnClickListener, a.c, wh.b, z.a {
    public static final String GAME_ID_TAG = "gameIdTag";
    public static final String IS_BUZZ_PAGE_FROM_NOTIFICATION = "isBuzzPageFromNotification";
    public static final String IS_FIRST_UPDATE_RENDERED = "isFirstUpdateRendered";
    public static final String ITEM_ID_TAG = "itemPosition";
    public static final int SCOPE_DASHBOARD = 1;
    public static final int SCOPE_GAME_CENTER = 0;
    public static final int SCOPE_PLAYER_CARD = 2;
    public static final String SCOPE_TAG = "scopeTag";
    public static final String SHOW_ADS = "showAds";
    private static final String TAG = "BuzzPage";
    public static final int VIDEO_ACTIVITY = 1;
    public static AudioManager audio = null;
    private static boolean isMuted = true;
    public static int maxObservedItems;
    public static boolean shouldSendItemPreviewEvent;
    public static float userVolumeLevel;
    public static int videoItemsObserved;
    protected GameObj gameObj;
    public Timer mTimer;
    private Vector<com.scores365.Design.PageObjects.b> newListItemsToPresent;
    protected NewsObj newsObj;
    private li.z orientationManager;
    protected NewsObj refreshedNewsObj;
    private Handler timerUpdateHandler;
    protected TextView tvFloatingNewItemsLabel;
    int promotedPosition = -1;
    protected int promotedItem = -1;
    private int currentlyPlayingHolderPosition = -1;
    private boolean isPageVisible = true;
    private boolean isBackFromFullScreenActivityClickingBack = false;
    dj.c playerSelector = null;
    private boolean shouldRestoreVideoPosition = false;
    private long positionToRestoreTo = -1;
    private boolean shouldPauseRestoredVideo = false;
    private int itemPositionOfVideoToRestore = -1;
    boolean wasRefreshedAfterBuzzNotification = false;
    boolean isUpdatedAlready = false;

    private void fakeScrollSoVideoCanPlay() {
        try {
            if (!this.wasRefreshedAfterBuzzNotification) {
                new Handler().postDelayed(new Runnable() { // from class: com.scores365.Pages.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.this.lambda$fakeScrollSoVideoCanPlay$2();
                    }
                }, 300L);
            }
            scrollToTop();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private ArrayList<ItemObj> filterByEntity(NewsObj newsObj, int i10) {
        ItemObj[] items;
        EntityConnection[] entitys;
        ArrayList<ItemObj> arrayList = new ArrayList<>();
        try {
            for (ItemObj itemObj : newsObj.getItems()) {
                if (itemObj.getEntitys() != null && itemObj.getEntitys().length > 0) {
                    for (EntityConnection entityConnection : itemObj.getEntitys()) {
                        if ((entityConnection.getEntityID() == i10 && entityConnection.getEntityType() == 4) || i10 == -1) {
                            arrayList.add(itemObj);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private String getLink(boolean z10) {
        String str;
        String str2 = null;
        try {
            if (z10) {
                String str3 = this.newsObj.paging.refreshPage;
                if (str3 == null || str3.isEmpty()) {
                    return null;
                }
                str = this.newsObj.paging.refreshPage;
            } else {
                String str4 = this.newsObj.paging.nextPage;
                if (str4 == null || str4.isEmpty()) {
                    return null;
                }
                str = this.newsObj.paging.nextPage;
            }
            str2 = str;
            return str2;
        } catch (Exception e10) {
            x0.N1(e10);
            return str2;
        }
    }

    private NewsObj getNewsFromServer(boolean z10) {
        com.scores365.api.l lVar;
        NewsObj newsObj = null;
        try {
            String l02 = p0.l0("DAY_BACKWARD_NEWS_COMPLETION");
            int parseInt = x0.r1(l02) ? Integer.parseInt(l02) : 0;
            String link = getLink(z10);
            if (link == null || link.isEmpty()) {
                com.scores365.api.l lVar2 = new com.scores365.api.l(App.m(), requireArguments().getInt(SCOPE_TAG, 0) == 1 ? "10" : null, sf.b.X1().s2(), sf.a.i0(App.m()).G0(), "", x0.D0(this.filterObj.f34290b), x0.D0(this.filterObj.f34289a), x0.D0(this.filterObj.f34291c), x0.D0(this.filterObj.f34292d), x0.X(parseInt, "dd/MM/yyyy"), x0.X(0, "dd/MM/yyyy"), "60", "0");
                if (!z10) {
                    lVar2.b(this.newsObj.getItems().length > 0 ? this.newsObj.getItems()[this.newsObj.getItems().length - 1].getID() : -1);
                }
                lVar = lVar2;
            } else {
                lVar = new com.scores365.api.l(getContext());
                lVar.c(link);
            }
            lVar.call();
            newsObj = lVar.a();
            this.newsObj.paging.nextPage = newsObj.paging.nextPage;
            return newsObj;
        } catch (Exception e10) {
            x0.N1(e10);
            return newsObj;
        }
    }

    private String getPageSourceForAnalytics() {
        try {
            int i10 = requireArguments().getInt(SCOPE_TAG, 0);
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? "" : "player-card" : "dashboard" : "gamecenter";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public static String getVideoPositionText(long j10) {
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return String.format("%02d:%02d", Long.valueOf(timeUnit.toMinutes(j10) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j10) % TimeUnit.MINUTES.toSeconds(1L)));
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    private void handleFloatingLabelOnScroll(int i10) {
        try {
            Vector<com.scores365.Design.PageObjects.b> vector = this.newListItemsToPresent;
            if (vector != null && !vector.isEmpty()) {
                if (i10 <= 0) {
                    setFloatingLabelPosition();
                } else {
                    removeFloatingLabel();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static boolean isMuted() {
        return isMuted;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fakeScrollSoVideoCanPlay$2() {
        try {
            this.rvItems.t1(0, 1);
            this.rvItems.t1(0, -1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreviousItems$0(boolean z10, NewsObj newsObj, boolean z11) {
        if (z10) {
            androidx.fragment.app.h activity = getActivity();
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || isStateSaved()) {
                return;
            }
            ArrayList<com.scores365.Design.PageObjects.b> buildItems = buildItems(filterByEntity(newsObj, -1), ((App) activity.getApplication()).n(), this.rvBaseAdapter.B().size());
            updateCurrentList(buildItems);
            addHeaderItem(buildItems);
        }
        onLoadingItemsFinished(z11, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreviousItems$1() {
        final boolean z10;
        final boolean z11 = false;
        final NewsObj newsFromServer = getNewsFromServer(false);
        if (newsFromServer == null || newsFromServer.getItems() == null) {
            z10 = false;
        } else {
            z10 = true;
            if (newsFromServer.getItems().length > 0) {
                z11 = true;
            } else {
                this.hasPrevItems = false;
            }
        }
        NewsObj newsObj = this.newsObj;
        if (newsObj != null) {
            newsObj.mergeNewsObj(newsFromServer);
        }
        li.c.f34483a.e().execute(new Runnable() { // from class: com.scores365.Pages.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.lambda$getPreviousItems$0(z11, newsFromServer, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDataRendered$3() {
        try {
            androidx.fragment.app.h activity = getActivity();
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing() && !isStateSaved()) {
                this.rvItems.scrollBy(0, 10);
                this.rvItems.scrollBy(0, -10);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @NonNull
    public static f newInstance(NewsObj newsObj, boolean z10, int i10, GameObj gameObj, int i11, String str, String str2, int i12, boolean z11, boolean z12) {
        f fVar = new f();
        fVar.newsObj = newsObj;
        Bundle bundle = new Bundle();
        bundle.putBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, z10);
        bundle.putInt(GAME_ID_TAG, i10);
        bundle.putString("your_empty_msg", str);
        bundle.putString("page_key", str2);
        bundle.putInt(SCOPE_TAG, i12);
        bundle.putBoolean(SHOW_ADS, z11);
        bundle.putBoolean("is_need_to_add_native_ad", z11);
        bundle.putBoolean("show_direct_deals_ads", z12);
        fVar.promotedItem = i11;
        fVar.setArguments(bundle);
        fVar.gameObj = gameObj;
        return fVar;
    }

    private void removeFloatingLabel() {
        try {
            if (this.tvFloatingNewItemsLabel.getVisibility() != 8) {
                this.tvFloatingNewItemsLabel.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.C));
                this.tvFloatingNewItemsLabel.setVisibility(8);
            }
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    public static void sendItemPreviewEvent(GameObj gameObj, String str, boolean z10) {
        int id2;
        if (gameObj != null) {
            try {
                id2 = gameObj.getID();
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        } else {
            id2 = -1;
        }
        if (shouldSendItemPreviewEvent) {
            ee.k.o(App.m(), "gamecenter", "buzz", "items-preview", null, ShareConstants.FEED_SOURCE_PARAM, str, "amount", String.valueOf(maxObservedItems), "videos_amount", String.valueOf(videoItemsObserved), "game_id", String.valueOf(id2), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, i0.D0(gameObj), "is_notification", String.valueOf(z10));
            maxObservedItems = 0;
            videoItemsObserved = 0;
        }
    }

    private void setFloatingLabelPosition() {
        try {
            if (this.tvFloatingNewItemsLabel.getVisibility() != 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(14);
                this.tvFloatingNewItemsLabel.setText(p0.l0("SOCIAL_FEED_NEW_UPDATES"));
                this.tvFloatingNewItemsLabel.setCompoundDrawablePadding(p0.s(5));
                this.tvFloatingNewItemsLabel.setVisibility(0);
                this.tvFloatingNewItemsLabel.setCompoundDrawablesWithIntrinsicBounds(p0.T(R.attr.f21553i1), 0, 0, 0);
                if (hasContentPadding()) {
                    layoutParams.topMargin = p0.s(20) + getPaddingSize();
                } else {
                    layoutParams.topMargin = p0.s(20);
                }
                addRulesForFloatingView(layoutParams);
                this.tvFloatingNewItemsLabel.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f21521u));
                this.tvFloatingNewItemsLabel.setLayoutParams(layoutParams);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void setIsMuted(boolean z10) {
        isMuted = z10;
    }

    public static void setUserVolumeLevel(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            audio = audioManager;
            userVolumeLevel = audioManager.getStreamVolume(3);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void stopTimer() {
        try {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                timer.purge();
            }
            this.mTimer = null;
        } catch (Exception e10) {
            ng.a.f35508a.c(TAG, "error stopping buzz page timer", e10);
        }
    }

    public static boolean tryToTurnOnSound() {
        try {
            return ((AudioManager) App.m().getSystemService("audio")).requestAudioFocus(null, 3, 1) == 1;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    private void updateCurrentList(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                int size = this.rvBaseAdapter.B().size();
                int size2 = arrayList.size();
                this.rvBaseAdapter.B().addAll(arrayList);
                this.rvBaseAdapter.I();
                this.rvBaseAdapter.notifyItemRangeInserted(size, size2);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List, T, java.util.ArrayList] */
    @Override // com.scores365.Design.Pages.q
    public <T> T LoadData() {
        androidx.fragment.app.h activity;
        this.shouldCheckForNativeInMidPage = true;
        ?? r02 = (T) new ArrayList();
        try {
            if (this.newsObj != null && (activity = getActivity()) != null) {
                r02.addAll(buildItems(filterByEntity(this.newsObj, -1), ((App) activity.getApplication()).n(), 0));
            }
            addHeaderItem(r02);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return r02;
    }

    @Override // com.scores365.Design.Pages.g, com.scores365.Design.Pages.q
    protected void OnScrollEvent(RecyclerView recyclerView, int i10, int i11, int i12, int i13) {
        super.OnScrollEvent(recyclerView, i10, i11, i12, i13);
        try {
            if (this.rvBaseAdapter.B().isEmpty()) {
                return;
            }
            handleFloatingLabelOnScroll(i13);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void addHeaderItem(List<com.scores365.Design.PageObjects.b> list) {
    }

    protected void addRulesForFloatingView(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(10);
    }

    protected ArrayList<com.scores365.Design.PageObjects.b> buildItems(ArrayList<ItemObj> arrayList, @NonNull uc.d dVar, int i10) {
        int i11;
        int i12;
        int i13;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            try {
                boolean z10 = true;
                if (RemoveAdsManager.isUserAdsRemoved(App.m()) || o0.y() == null) {
                    i11 = 0;
                    i12 = 0;
                } else {
                    i11 = o0.y().m();
                    i12 = o0.y().n() + 1;
                }
                Iterator<ItemObj> it = arrayList.iterator();
                int i14 = 0;
                while (it.hasNext()) {
                    ItemObj next = it.next();
                    if (i11 > 0 && i12 > 0) {
                        try {
                            if (shouldAddNativeAdsToListForSingleEntity() && (requireArguments().getBoolean(SHOW_ADS, z10) || requireArguments().getBoolean("show_direct_deals_ads", false) || (getParentFragment() != null && getParentFragment().requireArguments().getBoolean("isSpecialSection", false)))) {
                                if (!requireArguments().getBoolean("show_direct_deals_ads", false) && (i10 + i14 == i11 || ((i14 - i11) + i10) % i12 == 0)) {
                                    sc.f fVar = sc.f.BigLayout;
                                    if (requireArguments().getBoolean("show_direct_deals_ads", false)) {
                                        fVar = sc.f.Branding;
                                    }
                                    arrayList2.add(new lf.b(dVar, sc.i.GameDetails, fVar));
                                } else if (requireArguments().getBoolean("show_direct_deals_ads", false)) {
                                    arrayList2.add(new lf.b(dVar, sc.i.GameDetails, sc.f.Branding));
                                } else if (getParentFragment() != null && getParentFragment().getArguments().getBoolean("isSpecialSection", false)) {
                                    arrayList2.add(new lf.b(dVar, sc.i.Dashboard, sc.f.SpecialSectionBig));
                                }
                            }
                        } catch (Exception e10) {
                            x0.N1(e10);
                        }
                    }
                    if (next.getID() == this.promotedItem) {
                        this.promotedPosition = i14;
                    }
                    int width = getView() != null ? getView().getWidth() : -1;
                    if (width <= 0 && !App.f20803w) {
                        width = App.p();
                    }
                    if (next.getHasVideo() && isVideoContentTypeValidAsVideo(next)) {
                        i13 = i14;
                        arrayList2.add(new mf.c(next, requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), this, requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false), width, this));
                    } else {
                        i13 = i14;
                        arrayList2.add(new mf.b(dVar, next, requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), next.getHasVideo(), requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false), width));
                    }
                    i14 = i13 + 1;
                    z10 = true;
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
        return arrayList2;
    }

    public void changeCurrentItemStatusVideo(boolean z10) {
        c.C0461c c0461c;
        try {
            com.scores365.Design.Pages.c cVar = this.rvBaseAdapter;
            if (cVar != null) {
                ArrayList<com.scores365.Design.PageObjects.b> B = cVar.B();
                for (int i10 = 0; i10 < B.size(); i10++) {
                    if ((this.rvItems.c0(i10) instanceof c.C0461c) && (c0461c = (c.C0461c) this.rvItems.c0(i10)) != null && c0461c.l() != null) {
                        if (!z10) {
                            if (isMuted) {
                                muteAllHolders();
                            } else {
                                unmuteAllHolders();
                            }
                            fakeScrollSoVideoCanPlay();
                            return;
                        }
                        if (c0461c.l().getPlayer() != null) {
                            c0461c.l().getPlayer().l(false);
                        }
                        c0461c.D((mf.c) B.get(i10));
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void disableOrientationManager() {
        try {
            li.z zVar = this.orientationManager;
            if (zVar != null) {
                zVar.disable();
                this.orientationManager.a();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // wh.b
    public void finishLoading() {
        HideMainPreloader();
    }

    @Override // wh.b
    public Activity getActivityForUI() {
        return getActivity();
    }

    @Override // com.scores365.Design.Pages.h
    protected String getBaseUrlPath() {
        return com.scores365.api.d.handleAlternateURL(App.t()) + "/Data/News/?";
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.g, com.scores365.Design.Pages.q
    protected int getLayoutResourceID() {
        return R.layout.f22749x0;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return "";
    }

    public int getPositionForItemToOpenInFullscreen() {
        int i10 = this.currentlyPlayingHolderPosition;
        float f10 = -1.0f;
        int i11 = -1;
        for (int i12 = 0; i12 < this.rvBaseAdapter.getItemCount(); i12++) {
            try {
                RecyclerView.e0 a02 = this.rvItems.a0(i12);
                if (a02 instanceof mf.a) {
                    mf.a aVar = (mf.a) a02;
                    float c10 = dj.e.c((dj.d) aVar.l().getPlayer(), aVar.itemView.getParent());
                    if (c10 > f10) {
                        i11 = i12;
                        f10 = c10;
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return i10;
            }
        }
        return i11 != -1 ? i11 : i10;
    }

    @Override // com.scores365.Design.Pages.g
    protected void getPreviousItems() {
        li.c.f34483a.f().execute(new Runnable() { // from class: com.scores365.Pages.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.lambda$getPreviousItems$1();
            }
        });
    }

    @Override // com.scores365.Design.Pages.q
    protected int getRecyclerViewResourceID() {
        return R.id.Lm;
    }

    @Override // com.scores365.Design.Pages.q, com.scores365.Design.Pages.z
    public int getSwipeRefreshResourceID() {
        return R.id.Hr;
    }

    @Override // com.scores365.Design.Pages.h
    protected ArrayList<com.scores365.Design.PageObjects.b> getUpdateDataListItems(String str) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = null;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    ArrayList<com.scores365.Design.PageObjects.b> arrayList2 = new ArrayList<>();
                    try {
                        NewsObj l10 = com.scores365.api.w.l(str);
                        ArrayList<ItemObj> filterByEntity = filterByEntity(l10, -1);
                        ArrayList arrayList3 = new ArrayList();
                        Iterator<ItemObj> it = filterByEntity.iterator();
                        while (true) {
                            boolean z10 = false;
                            if (!it.hasNext()) {
                                break;
                            }
                            ItemObj next = it.next();
                            ItemObj[] items = this.newsObj.getItems();
                            int length = items.length;
                            int i10 = 0;
                            while (true) {
                                if (i10 >= length) {
                                    break;
                                }
                                if (next.getID() == items[i10].getID()) {
                                    z10 = true;
                                    break;
                                }
                                i10++;
                            }
                            if (!z10) {
                                arrayList3.add(next);
                            }
                        }
                        this.newsObj.mergeNewsObj(l10);
                        int width = getView() != null ? getView().getWidth() : -1;
                        if (width <= 0 && !App.f20803w) {
                            width = App.p();
                        }
                        androidx.fragment.app.h activity = getActivity();
                        if (activity == null) {
                            return arrayList2;
                        }
                        App app = (App) activity.getApplication();
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            ItemObj itemObj = (ItemObj) it2.next();
                            if (itemObj.getHasVideo() && isVideoContentTypeValidAsVideo(itemObj)) {
                                arrayList2.add(new mf.c(itemObj, requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), this, requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false), width, this));
                            } else {
                                arrayList2.add(new mf.b(app.n(), itemObj, requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), itemObj.getHasVideo(), requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false), width));
                            }
                        }
                        return arrayList2;
                    } catch (Exception e10) {
                        e = e10;
                        arrayList = arrayList2;
                        x0.N1(e);
                        return arrayList;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        }
        return null;
    }

    @Override // com.scores365.Design.Pages.h
    protected String getUpdateUrl() {
        NewsObj.Paging paging;
        NewsObj newsObj = this.newsObj;
        return (newsObj == null || (paging = newsObj.paging) == null) ? "" : paging.updatePage;
    }

    @Override // com.scores365.Design.Pages.h
    protected long getUpdatesTimeInterval() {
        return TimeUnit.SECONDS.toMillis(30L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r1 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r1 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
        r1.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
        removeFloatingLabel();
        ((androidx.recyclerview.widget.StaggeredGridLayoutManager) r3.rvLayoutMgr).scrollToPositionWithOffset(0, 0);
        r3.rvItems.t1(0, 1);
        r3.rvItems.t1(0, -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
        li.x0.N1(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handleFloatingLabelClick() {
        /*
            r3 = this;
            r0 = 0
            com.scores365.Design.Pages.c r1 = r3.rvBaseAdapter     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.util.ArrayList r1 = r1.B()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            boolean r1 = r1 instanceof com.scores365.ui.playerCard.SocialStatItem     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r1 != 0) goto L14
            java.util.Vector<com.scores365.Design.PageObjects.b> r1 = r3.newListItemsToPresent     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r3.addHeaderItem(r1)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
        L14:
            com.scores365.Design.Pages.c r1 = r3.rvBaseAdapter     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.util.ArrayList r1 = r1.B()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.util.Vector<com.scores365.Design.PageObjects.b> r2 = r3.newListItemsToPresent     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r1.addAll(r0, r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            com.scores365.Design.Pages.c r1 = r3.rvBaseAdapter     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r1.I()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            com.scores365.Design.Pages.c r1 = r3.rvBaseAdapter     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.util.Vector<com.scores365.Design.PageObjects.b> r2 = r3.newListItemsToPresent     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r1.notifyItemRangeInserted(r0, r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            androidx.fragment.app.h r1 = r3.getActivity()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            boolean r1 = r1 instanceof com.scores365.gameCenter.p0     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r1 == 0) goto L46
            androidx.fragment.app.h r1 = r3.getActivity()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            com.scores365.gameCenter.p0 r1 = (com.scores365.gameCenter.p0) r1     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r2 = -200(0xffffffffffffff38, float:NaN)
            int r2 = li.p0.s(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r1.onInnerPageListScrolled(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
        L46:
            java.util.Vector<com.scores365.Design.PageObjects.b> r1 = r3.newListItemsToPresent
            if (r1 == 0) goto L5f
            goto L5c
        L4b:
            r0 = move-exception
            goto L7b
        L4d:
            r1 = move-exception
            li.x0.N1(r1)     // Catch: java.lang.Throwable -> L4b
            com.scores365.Design.Pages.c r1 = r3.rvBaseAdapter     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L58
            r1.notifyDataSetChanged()     // Catch: java.lang.Throwable -> L4b
        L58:
            java.util.Vector<com.scores365.Design.PageObjects.b> r1 = r3.newListItemsToPresent
            if (r1 == 0) goto L5f
        L5c:
            r1.clear()
        L5f:
            r3.removeFloatingLabel()     // Catch: java.lang.Exception -> L76
            androidx.recyclerview.widget.RecyclerView$p r1 = r3.rvLayoutMgr     // Catch: java.lang.Exception -> L76
            androidx.recyclerview.widget.StaggeredGridLayoutManager r1 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r1     // Catch: java.lang.Exception -> L76
            r1.scrollToPositionWithOffset(r0, r0)     // Catch: java.lang.Exception -> L76
            androidx.recyclerview.widget.RecyclerView r1 = r3.rvItems     // Catch: java.lang.Exception -> L76
            r2 = 1
            r1.t1(r0, r2)     // Catch: java.lang.Exception -> L76
            androidx.recyclerview.widget.RecyclerView r1 = r3.rvItems     // Catch: java.lang.Exception -> L76
            r2 = -1
            r1.t1(r0, r2)     // Catch: java.lang.Exception -> L76
            goto L7a
        L76:
            r0 = move-exception
            li.x0.N1(r0)
        L7a:
            return
        L7b:
            java.util.Vector<com.scores365.Design.PageObjects.b> r1 = r3.newListItemsToPresent
            if (r1 == 0) goto L82
            r1.clear()
        L82:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.Pages.f.handleFloatingLabelClick():void");
    }

    @Override // com.scores365.Design.Pages.h
    protected void handleUpdate(ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                if (this.newListItemsToPresent == null) {
                    this.newListItemsToPresent = new Vector<>();
                }
                this.newListItemsToPresent.addAll(arrayList);
                setFloatingLabelPosition();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @Override // com.scores365.Design.Pages.g
    protected boolean hasNextItems() {
        return false;
    }

    @Override // com.scores365.Design.Pages.g
    protected boolean hasPreviousItems() {
        return this.hasPrevItems;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 1);
            this.rvLayoutMgr = staggeredGridLayoutManager;
            staggeredGridLayoutManager.setOrientation(1);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void initializeOrientationManager() {
        try {
            li.z zVar = this.orientationManager;
            if (zVar != null) {
                zVar.a();
                this.orientationManager.disable();
            }
            this.orientationManager = new li.z(App.m(), this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // mf.a.c
    public boolean isCallbackVisible() {
        return this.isPageVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.a
    public boolean isContainedInCoordinatorLayout() {
        return true;
    }

    @Override // com.scores365.Design.Pages.y
    public boolean isSwipeEnabled() {
        return true;
    }

    public boolean isVideoContentTypeValidAsVideo(ItemObj itemObj) {
        try {
            return itemObj.newsVideos.get(0).contentType.equals("video/mp4");
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public void muteAllHolders() {
        try {
            if (this.rvItems != null) {
                for (int i10 = 0; i10 < this.rvItems.getAdapter().getItemCount(); i10++) {
                    RecyclerView.e0 a02 = this.rvItems.a0(i10);
                    if (a02 instanceof c.C0461c) {
                        ((c.C0461c) a02).s(true);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            try {
                int i12 = requireArguments().getInt(ITEM_ID_TAG, -1);
                mf.a aVar = (mf.a) this.rvItems.a0(i12);
                com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i12);
                if ((A instanceof mf.c) && (aVar instanceof c.C0461c)) {
                    c.C0461c c0461c = (c.C0461c) aVar;
                    mf.c cVar = (mf.c) A;
                    long j10 = -1;
                    if (intent != null) {
                        stopTimer();
                        j10 = intent.getLongExtra("PositionInVideo", -1L);
                        boolean booleanExtra = intent.getBooleanExtra("isPaused", false);
                        c0461c.l().getPlayer().seekTo(j10);
                        c0461c.l().getPlayer().l(booleanExtra ? false : true);
                        cVar.j(booleanExtra);
                        r4 = booleanExtra;
                    }
                    this.shouldRestoreVideoPosition = true;
                    this.positionToRestoreTo = j10;
                    this.shouldPauseRestoredVideo = r4;
                    this.itemPositionOfVideoToRestore = i12;
                    fakeScrollSoVideoCanPlay();
                    initializeOrientationManager();
                }
                this.isBackFromFullScreenActivityClickingBack = true;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == R.id.DB) {
                handleFloatingLabelClick();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setUserVolumeLevel(getActivity());
        isMuted = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.scores365.Design.Pages.h, com.scores365.Design.Pages.q
    protected void onDataRendered() {
        int i10;
        super.onDataRendered();
        try {
            if (this.promotedItem != -1 && (i10 = this.promotedPosition) != -1) {
                this.rvItems.p1(i10);
            }
            this.rvItems.postDelayed(new Runnable() { // from class: com.scores365.Pages.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.lambda$onDataRendered$3();
                }
            }, 750L);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.g, com.scores365.Design.Pages.y, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // mf.a.c
    public void onManualVideoStart(int i10) {
        c.C0461c c0461c;
        try {
            ArrayList<com.scores365.Design.PageObjects.b> B = this.rvBaseAdapter.B();
            for (int i11 = 0; i11 < B.size(); i11++) {
                if (i11 != i10 && (this.rvItems.c0(i11) instanceof c.C0461c) && (c0461c = (c.C0461c) this.rvItems.c0(i11)) != null && c0461c.l() != null) {
                    c0461c.f34930s.j(true);
                    c0461c.l().getPlayer().l(false);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // li.z.a
    public void onOrientationChange(z.c cVar) {
        try {
            if (getUserVisibleHint() && cVar == z.c.LANDSCAPE && !this.isBackFromFullScreenActivityClickingBack) {
                startVideoActivity(getPositionForItemToOpenInFullscreen());
            } else if (cVar == z.c.PORTRAIT) {
                this.isBackFromFullScreenActivityClickingBack = false;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public void onPageSelectedInViewPager() {
        super.onPageSelectedInViewPager();
        try {
            fakeScrollSoVideoCanPlay();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.h, androidx.fragment.app.Fragment
    public void onPause() {
        try {
            unregisterToro();
            disableOrientationManager();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        super.onPause();
    }

    public void onPlaybackPaused(int i10) {
        stopTimer();
    }

    @Override // mf.a.c
    public void onPlaybackStarted(int i10) {
        try {
            this.currentlyPlayingHolderPosition = i10;
            stopTimer();
            this.mTimer = new Timer();
            if (this.timerUpdateHandler == null) {
                this.timerUpdateHandler = new Handler();
            }
            RecyclerView.e0 a02 = this.rvItems.a0(i10);
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (a02 instanceof mf.a) {
                mf.a aVar = (mf.a) a02;
                a.InterfaceC0458a interfaceC0458a = (a.InterfaceC0458a) A;
                if (this.positionToRestoreTo != -1 && i10 == this.itemPositionOfVideoToRestore && aVar.l().getPlayer().getDuration() >= this.positionToRestoreTo) {
                    aVar.l().getPlayer().seekTo(this.positionToRestoreTo);
                    interfaceC0458a.j(this.shouldPauseRestoredVideo);
                    boolean z10 = true;
                    aVar.l().getPlayer().l(!this.shouldPauseRestoredVideo);
                    if (this.shouldPauseRestoredVideo) {
                        z10 = false;
                    }
                    aVar.t(z10);
                    this.positionToRestoreTo = -1L;
                    this.itemPositionOfVideoToRestore = -1;
                }
                this.mTimer.schedule(new a.b(aVar, this.timerUpdateHandler, interfaceC0458a.getDuration()), 0L, 1000L);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void onPlaybackStopped(int i10) {
        try {
            stopTimer();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        int id2;
        int i11;
        int i12;
        super.onRecyclerViewItemClick(i10);
        try {
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            App app = (App) activity.getApplication();
            com.scores365.Design.PageObjects.b bVar = this.rvBaseAdapter.B().get(i10);
            int i13 = -1;
            if (!(bVar instanceof PageBuzzBase) || ((PageBuzzBase) bVar).f23411g != PageBuzzBase.c.share) {
                if (bVar instanceof mf.b) {
                    Intent intent = new Intent(App.m(), WebViewActivity.class);
                    intent.putExtra(ItemObj.class.getName(), ((mf.b) this.rvBaseAdapter.B().get(i10)).f23407c);
                    intent.putExtra("page_title", ((mf.b) this.rvBaseAdapter.B().get(i10)).f23407c.getTitle());
                    View findViewByPosition = this.rvLayoutMgr.findViewByPosition(i10);
                    if (findViewByPosition != null) {
                        androidx.core.content.a.startActivity(activity, intent, androidx.core.app.f.a(findViewByPosition, 0, 0, findViewByPosition.getWidth(), findViewByPosition.getHeight()).b());
                    }
                    id2 = ((mf.b) this.rvBaseAdapter.B().get(i10)).f23407c.getID();
                    i11 = requireArguments().getInt(GAME_ID_TAG, -1);
                } else if (bVar instanceof mf.c) {
                    Intent intent2 = new Intent(App.m(), WebViewActivity.class);
                    intent2.putExtra(ItemObj.class.getName(), ((mf.c) this.rvBaseAdapter.B().get(i10)).f23407c);
                    intent2.putExtra("page_title", ((mf.c) this.rvBaseAdapter.B().get(i10)).f23407c.getTitle());
                    View findViewByPosition2 = this.rvLayoutMgr.findViewByPosition(i10);
                    if (findViewByPosition2 != null) {
                        androidx.core.content.a.startActivity(activity, intent2, androidx.core.app.f.a(findViewByPosition2, 0, 0, findViewByPosition2.getWidth(), findViewByPosition2.getHeight()).b());
                    }
                    id2 = ((mf.c) this.rvBaseAdapter.B().get(i10)).f23407c.getID();
                    i11 = requireArguments().getInt(GAME_ID_TAG, -1);
                }
                int i14 = i11;
                i13 = id2;
                i12 = i14;
                ee.k.n(App.m(), "gamecenter", "buzz", "items-click", null, true, "type", "social", "news_item_id", String.valueOf(i13), "page", getPageSourceForAnalytics(), "game_id", String.valueOf(i12), "click_type", "regular", "is_notification", String.valueOf(requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false)), ShareConstants.FEED_SOURCE_PARAM, "buzz-page");
            }
            PageBuzzBase pageBuzzBase = (PageBuzzBase) bVar;
            pageBuzzBase.f23411g = PageBuzzBase.c.general;
            li.i0.a(this, app.n(), this, pageBuzzBase.f23407c, null, true, false);
            i12 = -1;
            ee.k.n(App.m(), "gamecenter", "buzz", "items-click", null, true, "type", "social", "news_item_id", String.valueOf(i13), "page", getPageSourceForAnalytics(), "game_id", String.valueOf(i12), "click_type", "regular", "is_notification", String.valueOf(requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false)), ShareConstants.FEED_SOURCE_PARAM, "buzz-page");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.y
    public void onRefreshFinished() {
        try {
            ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
            this.newsObj.mergeNewsObj(this.refreshedNewsObj);
            int width = getView() != null ? getView().getWidth() : -1;
            if (width <= 0 && !App.f20803w) {
                width = App.p();
            }
            ArrayList<ItemObj> filterByEntity = filterByEntity(this.newsObj, -1);
            androidx.fragment.app.h activity = getActivity();
            if (activity == null) {
                return;
            }
            App app = (App) activity.getApplication();
            Iterator<ItemObj> it = filterByEntity.iterator();
            while (it.hasNext()) {
                ItemObj next = it.next();
                if (next.getHasVideo() && isVideoContentTypeValidAsVideo(next)) {
                    arrayList.add(new mf.c(next, requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), this, requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false), width, this));
                } else {
                    arrayList.add(new mf.b(app.n(), next, requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), next.getHasVideo(), requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false), width));
                }
            }
            if (!arrayList.isEmpty()) {
                addHeaderItem(arrayList);
                this.rvBaseAdapter.H(arrayList);
                this.rvBaseAdapter.notifyDataSetChanged();
                this.hasPrevItems = true;
            }
            Vector<com.scores365.Design.PageObjects.b> vector = this.newListItemsToPresent;
            if (vector != null) {
                vector.clear();
                removeFloatingLabel();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.h, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            if (getParentFragment() == null || !getParentFragment().isHidden()) {
                setPageVisible(true);
                registerToro();
                if (x0.r2()) {
                    registerToro();
                    if (this.shouldRestoreVideoPosition) {
                        if (this.positionToRestoreTo != -1) {
                            mf.a aVar = (mf.a) this.rvItems.a0(this.itemPositionOfVideoToRestore);
                            i4.z zVar = null;
                            PlayerView l10 = aVar == null ? null : aVar.l();
                            if (l10 != null) {
                                zVar = l10.getPlayer();
                            }
                            if (zVar != null) {
                                zVar.seekTo(this.positionToRestoreTo);
                            }
                        }
                        this.shouldRestoreVideoPosition = false;
                    }
                }
                fakeScrollSoVideoCanPlay();
                initializeOrientationManager();
                if (App.f20803w) {
                    return;
                }
                this.orientationManager.enable();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        setPageVisible(false);
        changeCurrentItemStatusVideo(true);
        requireArguments().putBoolean(IS_FIRST_UPDATE_RENDERED, true);
    }

    @Override // mf.a.c
    public void performFakeScroll() {
        fakeScrollSoVideoCanPlay();
    }

    public void registerToro() {
        try {
            RecyclerView recyclerView = this.rvItems;
            if (recyclerView != null && ((Container) recyclerView).getPlayerSelector() == null) {
                ((Container) this.rvItems).setPlayerSelector(this.playerSelector);
            }
            li.z zVar = this.orientationManager;
            if (zVar == null || !this.isPageVisible) {
                return;
            }
            zVar.enable();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void relateCustomViews(View view) {
        super.relateCustomViews(view);
        try {
            this.svEmptyLayout = (NestedScrollView) view.findViewById(R.id.Er);
            TextView textView = (TextView) view.findViewById(R.id.DB);
            this.tvFloatingNewItemsLabel = textView;
            textView.setTypeface(li.o0.d(App.m()));
            this.tvFloatingNewItemsLabel.setVisibility(8);
            e1.C0(this.tvFloatingNewItemsLabel, p0.s(8));
            this.tvFloatingNewItemsLabel.setOnClickListener(this);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q, com.scores365.Design.Pages.y
    public void reloadData() {
        try {
            this.refreshedNewsObj = getNewsFromServer(true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        if (t10 != null) {
            try {
            } catch (Exception e10) {
                x0.N1(e10);
            }
            if (!t10.isEmpty() && !isListEmpty()) {
                this.svEmptyLayout.setVisibility(8);
                this.rvItems.setVisibility(0);
                com.scores365.Design.Pages.c cVar = new com.scores365.Design.Pages.c((ArrayList) t10, this.recylerItemClickListener);
                this.rvBaseAdapter = cVar;
                cVar.D(requireArguments().getInt(GAME_ID_TAG, -1), getPageSourceForAnalytics(), requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false));
                this.rvItems.setHasFixedSize(false);
                this.rvItems.setAdapter(this.rvBaseAdapter);
                onDataRendered();
                fakeScrollSoVideoCanPlay();
            }
        }
        super.renderData(t10);
        fakeScrollSoVideoCanPlay();
    }

    @Override // com.scores365.Design.Pages.q
    public void scrollToTop() {
        if (this.promotedItem == -1 || this.promotedPosition == -1) {
            super.scrollToTop();
        }
    }

    public void setPageVisible(boolean z10) {
        this.isPageVisible = z10;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        try {
            super.setUserVisibleHint(z10);
            sendItemPreviewEvent(this.gameObj, getPageSourceForAnalytics(), requireArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false));
            shouldSendItemPreviewEvent = z10;
            if (z10) {
                registerToro();
            } else {
                unregisterToro();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        if (!z10) {
            try {
                changeCurrentItemStatusVideo(true);
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
        try {
            li.z zVar = this.orientationManager;
            if (zVar != null) {
                if (App.f20803w || !z10) {
                    zVar.disable();
                } else {
                    zVar.enable();
                }
            }
        } catch (Exception e12) {
            x0.N1(e12);
        }
    }

    @Override // wh.b
    public void startLoading() {
        ShowMainPreloader();
    }

    public void startVideoActivity(int i10) {
        startVideoActivity(i10, -1, -1, false);
    }

    @Override // mf.a.c
    public void startVideoActivity(int i10, int i11, int i12, boolean z10) {
        String str;
        try {
            Intent intent = new Intent(App.m(), VideoFullScreenActivity.class);
            mf.a aVar = (mf.a) this.rvItems.a0(i10);
            if (aVar != null) {
                PlayerView l10 = aVar.l();
                Bundle bundle = new Bundle();
                mf.c cVar = (mf.c) this.rvBaseAdapter.A(i10);
                bundle.putString("url", cVar.f23407c.newsVideos.get(0).url);
                bundle.putString("thumbnailUrl", cVar.f23407c.newsVideos.get(0).thumbnailUrl);
                if (l10 == null || l10.getPlayer() == null) {
                    str = GAME_ID_TAG;
                    bundle.putLong("PositionInVideo", 0L);
                    bundle.putBoolean("isPaused", true);
                    bundle.putLong("videoDuration", cVar.f23407c.newsVideos.get(0).duration * 1000);
                } else {
                    i4.z player = l10.getPlayer();
                    str = GAME_ID_TAG;
                    bundle.putLong("PositionInVideo", player.getCurrentPosition());
                    bundle.putBoolean("isPaused", !l10.getPlayer().C());
                    bundle.putLong("videoDuration", l10.getPlayer().getDuration());
                }
                if (i12 != -1) {
                    bundle.putInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i12);
                }
                if (i11 != -1) {
                    bundle.putInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i11);
                }
                String str2 = str;
                bundle.putInt(Bet365LandingActivity.GAME_ID, requireArguments().getInt(str2, -1));
                bundle.putLong("itemId", cVar.getItemId());
                bundle.putString(ShareConstants.FEED_SOURCE_PARAM, getPageSourceForAnalytics());
                bundle.putBoolean("is_notification", getArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false));
                bundle.putBoolean("shouldDelayOrientationManager", z10);
                intent.putExtras(bundle);
                intent.addFlags(603979776);
                getArguments().putInt(ITEM_ID_TAG, i10);
                if (!(getActivity() instanceof com.scores365.Design.Activities.c) || ((com.scores365.Design.Activities.c) getActivity()).isOpeningActivityLocked()) {
                    startActivityForResult(intent, 1);
                } else {
                    ((com.scores365.Design.Activities.c) getActivity()).lockUnLockActivityOpening();
                    ((com.scores365.Design.Activities.c) getActivity()).startActivityForResultWithLock(intent, 1);
                }
                int id2 = ((mf.c) this.rvBaseAdapter.B().get(i10)).f23407c.getID();
                int i13 = getArguments().getInt(str2, -1);
                ee.k.n(App.m(), "gamecenter", "buzz", "items-click", null, true, "type", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "news_item_id", String.valueOf(id2), "page", getPageSourceForAnalytics(), "game_id", String.valueOf(i13), "click_type", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "is_notification", String.valueOf(getArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false)));
                ee.k.n(App.m(), "gamecenter", "buzz", "video-play", null, true, "item_id", String.valueOf(cVar.getItemId()), ShareConstants.FEED_SOURCE_PARAM, getPageSourceForAnalytics(), "game_id", String.valueOf(i13), "total_duration", String.valueOf(aVar.A / 1000), "is_preview", "0", "is_notification", String.valueOf(getArguments().getBoolean(IS_BUZZ_PAGE_FROM_NOTIFICATION, false)), ShareConstants.FEED_SOURCE_PARAM, "buzz-page");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void startVideoActivityFromDetails(int i10, String str) {
    }

    public void unmuteAllHolders() {
        try {
            if (this.rvItems != null) {
                for (int i10 = 0; i10 < this.rvItems.getAdapter().getItemCount(); i10++) {
                    if (this.rvItems.a0(i10) != null && (this.rvItems.a0(i10) instanceof c.C0461c)) {
                        ((c.C0461c) this.rvItems.a0(i10)).s(false);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void unregisterToro() {
        try {
            RecyclerView recyclerView = this.rvItems;
            if (recyclerView != null) {
                if (this.playerSelector == null) {
                    this.playerSelector = ((Container) recyclerView).getPlayerSelector();
                }
                ((Container) this.rvItems).setPlayerSelector(null);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void updateAllVisibleItems() {
        try {
            int firstVisiblePositionFromLayoutMgr = getFirstVisiblePositionFromLayoutMgr();
            int lastVisibilePositionFromLayoutMgr = getLastVisibilePositionFromLayoutMgr();
            if (firstVisiblePositionFromLayoutMgr <= -1 || lastVisibilePositionFromLayoutMgr <= -1 || this.rvItems == null) {
                return;
            }
            for (int i10 = 0; i10 < this.rvItems.getAdapter().getItemCount(); i10++) {
                if (this.rvItems.a0(i10) != null && (this.rvItems.a0(i10) instanceof c.C0461c)) {
                    c.C0461c c0461c = (c.C0461c) this.rvItems.a0(i10);
                    if (isMuted) {
                        c0461c.f34922k.setImageResource(R.drawable.f21841w2);
                    } else {
                        c0461c.f34922k.setImageResource(R.drawable.J3);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void updateData(NewsObj newsObj) {
        try {
            HideMainPreloader();
            if (requireArguments().getBoolean(IS_FIRST_UPDATE_RENDERED, true)) {
                this.newsObj = newsObj;
                ArrayList<com.scores365.Design.PageObjects.b> arrayList = (ArrayList) LoadData();
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.svEmptyLayout.setVisibility(8);
                }
                if (this.rvBaseAdapter != null) {
                    addHeaderItem(arrayList);
                    this.rvBaseAdapter.H(arrayList);
                    this.rvBaseAdapter.notifyDataSetChanged();
                } else {
                    renderData(arrayList);
                }
                this.rvItems.t1(0, 1);
                this.rvItems.t1(0, -1);
                requireArguments().putBoolean(IS_FIRST_UPDATE_RENDERED, false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.a
    public void updatePageData(Object obj) {
        super.updatePageData(obj);
        try {
            if (!this.isUpdatedAlready) {
                this.isUpdatedAlready = true;
                if (obj != null) {
                    this.newsObj = (NewsObj) obj;
                    LoadDataAsync();
                } else {
                    handleEmptyData();
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
