package com.scores365.Design.PageObjects;

import androidx.recyclerview.widget.RecyclerView;
import com.scores365.gameCenter.t;
import java.util.ArrayList;
/* compiled from: HideExpandItemsMgr.java */
/* loaded from: classes2.dex */
public class f {

    /* compiled from: HideExpandItemsMgr.java */
    /* loaded from: classes2.dex */
    public interface a {
        String getAnalyticsSource();

        int getCollapsedItemsCount();

        boolean isExpanded();

        void setExpanded(boolean z10);
    }

    /* compiled from: HideExpandItemsMgr.java */
    /* loaded from: classes2.dex */
    public interface b {
        void setHidden(boolean z10);

        void setShouldAnimate(boolean z10);
    }

    public static void a(RecyclerView.h hVar, int i10, int i11) {
        try {
            ArrayList<com.scores365.Design.PageObjects.b> B = hVar instanceof com.scores365.Design.Pages.c ? ((com.scores365.Design.Pages.c) hVar).B() : hVar instanceof t ? ((t) hVar).A() : null;
            a aVar = (a) B.get(i10);
            boolean z10 = !aVar.isExpanded();
            aVar.setExpanded(z10);
            int i12 = i10;
            for (int i13 = i10 - 1; i13 >= 0 && (B.get(i13) instanceof b); i13--) {
                i12 = i13;
            }
            int i14 = 0;
            while (i12 < i10) {
                if (B.get(i12) instanceof b) {
                    b bVar = (b) B.get(i12);
                    bVar.setHidden(!z10 && i14 >= i11);
                    bVar.setShouldAnimate(i14 >= i11);
                    i14++;
                }
                i12++;
            }
            hVar.notifyDataSetChanged();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
