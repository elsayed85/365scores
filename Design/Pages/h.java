package com.scores365.Design.Pages;

import android.net.Uri;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import li.x0;
/* compiled from: FeedUpdatesPage.java */
/* loaded from: classes2.dex */
public abstract class h extends g {
    protected static final String SHOULD_UPDATER_START_FROM_ON_RESUME = "shouldUpdaterStartFromOnResume";
    private static Object SyncObj = new Object();
    private static boolean isUpdating;
    private Timer priodicTimer;
    private a priodicUpdateTask;
    private Handler uiHandler;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: FeedUpdatesPage.java */
    /* loaded from: classes2.dex */
    public static class a extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Handler> f20982a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<h> f20983b;

        public a(h hVar, Handler handler) {
            this.f20983b = new WeakReference<>(hVar);
            this.f20982a = new WeakReference<>(handler);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            h hVar;
            String fullUpdateUrlPath;
            Handler handler;
            try {
                if (h.isUpdating) {
                    return;
                }
                boolean unused = h.isUpdating = true;
                synchronized (h.SyncObj) {
                    try {
                        WeakReference<h> weakReference = this.f20983b;
                        if (weakReference != null && (hVar = weakReference.get()) != null && (fullUpdateUrlPath = hVar.getFullUpdateUrlPath()) != null && !fullUpdateUrlPath.isEmpty()) {
                            ArrayList<com.scores365.Design.PageObjects.b> updateDataListItems = hVar.getUpdateDataListItems(x0.R(fullUpdateUrlPath));
                            WeakReference<Handler> weakReference2 = this.f20982a;
                            if (weakReference2 != null && (handler = weakReference2.get()) != null) {
                                handler.post(new b(hVar, updateDataListItems));
                            }
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
                boolean unused2 = h.isUpdating = false;
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    /* compiled from: FeedUpdatesPage.java */
    /* loaded from: classes2.dex */
    protected static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<h> f20984a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<com.scores365.Design.PageObjects.b> f20985b;

        public b(h hVar, ArrayList<com.scores365.Design.PageObjects.b> arrayList) {
            this.f20984a = new WeakReference<>(hVar);
            this.f20985b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<h> weakReference;
            h hVar;
            try {
                ArrayList<com.scores365.Design.PageObjects.b> arrayList = this.f20985b;
                if (arrayList == null || arrayList.size() <= 0 || (weakReference = this.f20984a) == null || (hVar = weakReference.get()) == null) {
                    return;
                }
                hVar.handleUpdate(this.f20985b);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private void clearUpdater(boolean z10) {
        try {
            isUpdating = false;
            Timer timer = this.priodicTimer;
            if (timer != null) {
                timer.cancel();
                this.priodicTimer.purge();
                this.priodicTimer = null;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            a aVar = this.priodicUpdateTask;
            if (aVar != null) {
                aVar.cancel();
                this.priodicUpdateTask = null;
            }
        } catch (Exception e11) {
            x0.N1(e11);
        }
        try {
            Handler handler = this.uiHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (z10) {
                this.uiHandler = null;
            }
        } catch (Exception e12) {
            x0.N1(e12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFullUpdateUrlPath() {
        Uri parse;
        try {
            String baseUrlPath = getBaseUrlPath();
            String updateUrl = getUpdateUrl();
            if ((useBaseUrlPath() && (baseUrlPath == null || baseUrlPath.isEmpty())) || updateUrl == null || updateUrl.isEmpty()) {
                parse = null;
            } else {
                parse = Uri.parse(baseUrlPath + updateUrl);
            }
            return parse != null ? parse.toString() : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    protected abstract String getBaseUrlPath();

    protected abstract ArrayList<com.scores365.Design.PageObjects.b> getUpdateDataListItems(String str);

    protected abstract String getUpdateUrl();

    protected long getUpdatesStartDelay() {
        return 0L;
    }

    protected abstract long getUpdatesTimeInterval();

    protected abstract void handleUpdate(ArrayList<com.scores365.Design.PageObjects.b> arrayList);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onDataRendered() {
        super.onDataRendered();
        startUpdater();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        clearUpdater(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        try {
            super.onResume();
            if (getArguments().getBoolean(SHOULD_UPDATER_START_FROM_ON_RESUME, false)) {
                startUpdater();
            }
            getArguments().putBoolean(SHOULD_UPDATER_START_FROM_ON_RESUME, true);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected void startUpdater() {
        startUpdater(true);
    }

    protected void startUpdater(boolean z10) {
        try {
            clearUpdater(z10);
            if (this.uiHandler == null || !z10) {
                if (z10) {
                    this.uiHandler = new Handler();
                }
                this.priodicUpdateTask = new a(this, this.uiHandler);
                Timer timer = new Timer();
                this.priodicTimer = timer;
                timer.schedule(this.priodicUpdateTask, getUpdatesStartDelay(), getUpdatesTimeInterval());
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    protected boolean useBaseUrlPath() {
        return true;
    }
}
