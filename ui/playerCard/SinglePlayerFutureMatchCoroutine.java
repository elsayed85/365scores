package com.scores365.ui.playerCard;

import androidx.lifecycle.n;
import androidx.lifecycle.u;
import com.scores365.entitys.AthleteObj;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import wj.d1;
import wj.k0;
/* compiled from: SinglePlayerFutureMatchCoroutine.kt */
/* loaded from: classes2.dex */
public final class SinglePlayerFutureMatchCoroutine {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_RETRIES = 5;
    private static final long REQUEST_RETRY_TIMEOUT = 3000;
    private final WeakReference<SinglePlayerCardActivity> activityRef;
    private final k0 errorHandler;
    private boolean shouldRunRequest;

    /* compiled from: SinglePlayerFutureMatchCoroutine.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SinglePlayerFutureMatchCoroutine(SinglePlayerCardActivity activity) {
        kotlin.jvm.internal.m.g(activity, "activity");
        this.activityRef = new WeakReference<>(activity);
        this.errorHandler = new SinglePlayerFutureMatchCoroutine$special$$inlined$CoroutineExceptionHandler$1(k0.f41495c0);
        this.shouldRunRequest = true;
    }

    public final void fetchFutureMatchAsync(AthleteObj athlete, SinglePlayerProfilePageCreator pageCreator) {
        n a10;
        kotlin.jvm.internal.m.g(athlete, "athlete");
        kotlin.jvm.internal.m.g(pageCreator, "pageCreator");
        SinglePlayerCardActivity singlePlayerCardActivity = this.activityRef.get();
        if (singlePlayerCardActivity == null || (a10 = u.a(singlePlayerCardActivity)) == null) {
            return;
        }
        wj.k.d(a10, d1.b().plus(this.errorHandler), null, new SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1(this, athlete, pageCreator, null), 2, null);
    }
}
