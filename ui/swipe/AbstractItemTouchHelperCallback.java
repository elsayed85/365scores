package com.scores365.ui.swipe;

import androidx.recyclerview.widget.i;
import java.lang.ref.WeakReference;
import li.x0;
/* loaded from: classes2.dex */
public abstract class AbstractItemTouchHelperCallback extends i.e {
    protected float currentDx;
    protected SwipeableViewHolder currentHolder;
    protected WeakReference<SwipeableListPage> listPageRef;
    protected boolean swipeBack = false;

    public SwipeableViewHolder getCurrentHolder() {
        return this.currentHolder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwipeableListPage getListPage() {
        try {
            WeakReference<SwipeableListPage> weakReference = this.listPageRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }
}
