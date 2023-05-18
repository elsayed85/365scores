package com.scores365.ui.playerCard;

import com.scores365.api.d0;
import com.scores365.entitys.TrophyStats;
import java.lang.ref.WeakReference;
import li.x0;
/* loaded from: classes2.dex */
public class AthleteDataFetcherHelper {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class FetchAthleteTrophiesData implements Runnable {
        private int athleteId;
        private int competitionId;
        private int listPosition;
        private WeakReference<OnAthleteTrophiesDataListener> listenerRef;

        public FetchAthleteTrophiesData(int i10, int i11, int i12, OnAthleteTrophiesDataListener onAthleteTrophiesDataListener) {
            this.listenerRef = new WeakReference<>(onAthleteTrophiesDataListener);
            this.athleteId = i10;
            this.competitionId = i11;
            this.listPosition = i12;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d0 d0Var = new d0(this.athleteId, this.competitionId);
                d0Var.call();
                OnAthleteTrophiesDataListener onAthleteTrophiesDataListener = this.listenerRef.get();
                if (onAthleteTrophiesDataListener != null) {
                    onAthleteTrophiesDataListener.onAthleteTrophiesData(d0Var.f22943c, this.competitionId, this.listPosition);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnAthleteTrophiesDataListener {
        void onAthleteTrophiesData(TrophyStats trophyStats, int i10, int i11);
    }

    public static void getTrophiesData(int i10, int i11, int i12, OnAthleteTrophiesDataListener onAthleteTrophiesDataListener) {
        new Thread(new FetchAthleteTrophiesData(i10, i11, i12, onAthleteTrophiesDataListener)).start();
    }
}
