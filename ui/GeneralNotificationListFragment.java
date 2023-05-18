package com.scores365.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bf.d;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.GeneralNotifyObj;
import com.scores365.entitys.NotificationCategory;
import com.scores365.entitys.NotifiedUpdateObj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Vector;
import li.l0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class GeneralNotificationListFragment extends com.scores365.Design.Pages.q {
    public static final String ANALYTICS_ENTITY_TYPE_SPORT_TYPE = "3";
    static final int SELECT_SOUND_REQUEST_CODE = 1;
    Vector<GeneralNotifyObj> generalNotifyObjs = new Vector<>();
    public boolean isSomethingChanged = false;
    int sportType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.GeneralNotificationListFragment$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements DialogInterface.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            final ProgressDialog J0 = p0.J0(GeneralNotificationListFragment.this.getActivity(), "");
            new Thread(new Runnable() { // from class: com.scores365.ui.GeneralNotificationListFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GeneralNotificationListFragment.this.saveGeneralNotificationToDatabase();
                        sf.a.i0(App.m()).E();
                        sf.a.i0(App.m()).R0();
                        Iterator<CompObj> it = sf.b.X1().Z2().values().iterator();
                        while (true) {
                            boolean z10 = true;
                            if (!it.hasNext()) {
                                break;
                            }
                            CompObj next = it.next();
                            if (sf.a.i0(GeneralNotificationListFragment.this.getContext()).O0(next.getID()) <= 0) {
                                z10 = false;
                            }
                            if (GeneralNotificationListFragment.this.sportType == next.getSportID() && z10) {
                                sf.a.i0(GeneralNotificationListFragment.this.getContext()).I1(next.getID());
                                for (int i11 = 0; i11 < GeneralNotificationListFragment.this.generalNotifyObjs.size(); i11++) {
                                    GeneralNotifyObj generalNotifyObj = GeneralNotificationListFragment.this.generalNotifyObjs.get(i11);
                                    sf.a.i0(GeneralNotificationListFragment.this.getContext()).r(next.getID(), generalNotifyObj.getNotifyID(), generalNotifyObj.getSound());
                                }
                            }
                        }
                        App.l().initNotificationsPerSportType();
                        LinkedHashSet<NotifiedUpdateObj> notificationsBySportType = App.l().getNotificationsBySportType(GeneralNotificationListFragment.this.sportType);
                        Iterator<Integer> it2 = sf.b.X1().V1().iterator();
                        while (it2.hasNext()) {
                            Integer next2 = it2.next();
                            Vector<Integer> Q = App.b.Q(App.c.GAME, next2.intValue());
                            Iterator<NotifiedUpdateObj> it3 = notificationsBySportType.iterator();
                            while (it3.hasNext()) {
                                NotifiedUpdateObj next3 = it3.next();
                                Iterator<Integer> it4 = Q.iterator();
                                while (it4.hasNext()) {
                                    Integer next4 = it4.next();
                                    if (next3.getID() == next4.intValue()) {
                                        boolean z11 = false;
                                        for (int i12 = 0; i12 < GeneralNotificationListFragment.this.generalNotifyObjs.size(); i12++) {
                                            if (GeneralNotificationListFragment.this.generalNotifyObjs.get(i12).getNotifyID() == next4.intValue()) {
                                                z11 = true;
                                            }
                                        }
                                        if (!z11) {
                                            App.b.r0(App.c.GAME, next2.intValue(), next4.intValue());
                                        }
                                    }
                                }
                            }
                        }
                        App.b.t();
                        x0.A2(null, null);
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                    li.p.f34637a = false;
                    li.p.f34638b = false;
                    GeneralNotificationListFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.scores365.ui.GeneralNotificationListFragment.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            J0.hide();
                            GeneralNotificationListFragment.this.getActivity().finish();
                        }
                    });
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.GeneralNotificationListFragment$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            final ProgressDialog J0 = p0.J0(GeneralNotificationListFragment.this.getActivity(), "");
            new Thread(new Runnable() { // from class: com.scores365.ui.GeneralNotificationListFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    for (int i11 = 0; i11 < GeneralNotificationListFragment.this.generalNotifyObjs.size(); i11++) {
                        GeneralNotifyObj generalNotifyObj = GeneralNotificationListFragment.this.generalNotifyObjs.get(i11);
                        li.p.a(GeneralNotificationListFragment.this.getContext(), generalNotifyObj.getSportID(), generalNotifyObj.getNotifyID(), generalNotifyObj.getSound());
                    }
                    li.p.f34637a = false;
                    li.p.f34638b = false;
                    GeneralNotificationListFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.scores365.ui.GeneralNotificationListFragment.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            J0.hide();
                            GeneralNotificationListFragment.this.getActivity().finish();
                        }
                    });
                }
            }).start();
        }
    }

    public static ArrayList<com.scores365.Design.PageObjects.b> getNotificationsToRender(int i10, int i11) {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            LinkedHashMap<Integer, LinkedHashMap<Integer, ArrayList<NotifiedUpdateObj>>> notificationsPerSportTypePerCategoryForEntityType = App.l().getNotificationsPerSportTypePerCategoryForEntityType(i10);
            HashMap hashMap = new HashMap();
            for (Integer num : notificationsPerSportTypePerCategoryForEntityType.get(Integer.valueOf(i11)).keySet()) {
                if (notificationsPerSportTypePerCategoryForEntityType.get(Integer.valueOf(i11)).get(num) != null && !notificationsPerSportTypePerCategoryForEntityType.get(Integer.valueOf(i11)).get(num).isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<NotifiedUpdateObj> it = notificationsPerSportTypePerCategoryForEntityType.get(Integer.valueOf(i11)).get(num).iterator();
                    boolean z10 = false;
                    while (it.hasNext()) {
                        NotifiedUpdateObj next = it.next();
                        if (next.getIsDisplayed() && next.isRelevantForEntityType(i10)) {
                            arrayList2.add(new bf.d(next, i10));
                            z10 = true;
                        }
                    }
                    if (z10) {
                        arrayList2.add(0, new bf.b(App.l().getNotificationCategories().get(num) != null ? App.l().getNotificationCategories().get(num).getName() : ""));
                    }
                    hashMap.put(num, arrayList2);
                }
            }
            for (NotificationCategory notificationCategory : App.l().getNotificationCategories().values()) {
                if (hashMap.containsKey(Integer.valueOf(notificationCategory.getID()))) {
                    arrayList.addAll((Collection) hashMap.get(Integer.valueOf(notificationCategory.getID())));
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    private String getSourceForAnalytics() {
        return "settings";
    }

    private void handleCheckBoxClick(bf.d dVar, int i10) {
        try {
            this.isSomethingChanged = true;
            dVar.f9050e = l0.h(dVar.f9046a.getID()).f34608a;
            updateSelectAllState();
            this.rvBaseAdapter.notifyItemChanged(i10);
            HashMap hashMap = new HashMap();
            hashMap.put("entity_type", ANALYTICS_ENTITY_TYPE_SPORT_TYPE);
            hashMap.put("entity_id", Integer.valueOf(this.sportType));
            hashMap.put(ServerProtocol.DIALOG_PARAM_STATE, dVar.f9047b ? "select" : "unselect");
            hashMap.put(ShareConstants.FEED_SOURCE_PARAM, getSourceForAnalytics());
            hashMap.put("notification_type_id", Integer.valueOf(dVar.f9046a.getID()));
            ee.k.k(App.m(), "notification", "edit", "made", "click", hashMap);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static GeneralNotificationListFragment newInstance(int i10) {
        GeneralNotificationListFragment generalNotificationListFragment = new GeneralNotificationListFragment();
        generalNotificationListFragment.sportType = i10;
        return generalNotificationListFragment;
    }

    private void updateSelectAllState() {
        for (int i10 = 0; i10 < this.rvBaseAdapter.getItemCount(); i10++) {
            try {
                if (this.rvBaseAdapter.B().get(i10) instanceof bf.f) {
                    ((bf.f) this.rvBaseAdapter.B().get(i10)).f9074a = isAllNotificationSelected();
                    this.rvBaseAdapter.notifyItemChanged(i10);
                    return;
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        arrayList.add(new bf.f(false));
        arrayList.addAll(getNotificationsToRender(2, this.sportType));
        Vector<GeneralNotifyObj> S = sf.a.i0(App.m()).S(this.sportType);
        Iterator<com.scores365.Design.PageObjects.b> it = arrayList.iterator();
        while (it.hasNext()) {
            com.scores365.Design.PageObjects.b next = it.next();
            if (next instanceof bf.d) {
                bf.d dVar = (bf.d) next;
                NotifiedUpdateObj notifiedUpdateObj = dVar.f9046a;
                Iterator<GeneralNotifyObj> it2 = S.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        GeneralNotifyObj next2 = it2.next();
                        if (next2.getNotifyID() == notifiedUpdateObj.getID()) {
                            dVar.o(true);
                            dVar.n(next2.getSound());
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    public void handleToggleButtonClick() {
        try {
            if (isAllNotificationSelected()) {
                Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
                while (it.hasNext()) {
                    com.scores365.Design.PageObjects.b next = it.next();
                    if (next instanceof bf.d) {
                        if (((bf.d) next).f9047b) {
                            ((bf.d) next).f9049d = true;
                        }
                        ((bf.d) next).f9047b = false;
                    }
                }
            } else {
                Iterator<com.scores365.Design.PageObjects.b> it2 = this.rvBaseAdapter.B().iterator();
                while (it2.hasNext()) {
                    com.scores365.Design.PageObjects.b next2 = it2.next();
                    if (next2 instanceof bf.d) {
                        bf.d dVar = (bf.d) next2;
                        if (!dVar.f9047b) {
                            dVar.f9049d = true;
                            dVar.f9047b = true;
                            dVar.f9050e = l0.h(dVar.f9046a.getID()).f34608a;
                        }
                    }
                }
            }
            this.rvBaseAdapter.notifyDataSetChanged();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            super.initRecyclerViewLayoutManager();
            RecyclerView.p pVar = this.rvLayoutMgr;
            if (pVar instanceof GridLayoutManager) {
                ((GridLayoutManager) pVar).B(1);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean isAllNotificationSelected() {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            while (it.hasNext()) {
                com.scores365.Design.PageObjects.b next = it.next();
                if ((next instanceof bf.d) && !((bf.d) next).f9047b) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1 && i11 == -1) {
            try {
                int intExtra = intent.getIntExtra(SelectSoundFragment.SOUND_ID_TAG, -1);
                int intExtra2 = intent.getIntExtra(SelectSoundFragment.NOTIFICATION_ID_TAG, -1);
                for (int i12 = 0; i12 < this.rvBaseAdapter.getItemCount(); i12++) {
                    com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i12);
                    if (A instanceof bf.d) {
                        bf.d dVar = (bf.d) A;
                        if (dVar.f9046a.getID() == intExtra2) {
                            dVar.f9050e = intExtra;
                            this.rvBaseAdapter.notifyItemChanged(i12);
                            this.isSomethingChanged = true;
                        }
                    }
                }
                Context m10 = App.m();
                String[] strArr = new String[14];
                strArr[0] = "with_sound";
                strArr[1] = intExtra == -1 ? "0" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
                strArr[2] = "entity_type";
                strArr[3] = ANALYTICS_ENTITY_TYPE_SPORT_TYPE;
                strArr[4] = "entity_id";
                strArr[5] = String.valueOf(this.sportType);
                strArr[6] = "notification_type";
                strArr[7] = String.valueOf(intExtra2);
                strArr[8] = ServerProtocol.DIALOG_PARAM_STATE;
                strArr[9] = "select";
                strArr[10] = ShareConstants.FEED_SOURCE_PARAM;
                strArr[11] = getSourceForAnalytics();
                strArr[12] = "type-of-click";
                strArr[13] = "edit";
                ee.k.q(m10, "notification", "settings", "edit", true, strArr);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            if (this.rvBaseAdapter.A(i10) instanceof bf.d) {
                bf.d dVar = (bf.d) this.rvBaseAdapter.A(i10);
                d.b bVar = dVar.f9048c;
                int i11 = 0;
                if (bVar == d.b.sounds) {
                    Intent activityIntent = SelectSoundActivity.getActivityIntent(getActivity(), dVar.f9050e, dVar.f9046a.getID(), ANALYTICS_ENTITY_TYPE_SPORT_TYPE, dVar.f9046a.getName(), "settings", String.valueOf(this.sportType));
                    activityIntent.setFlags(67108864);
                    startActivityForResult(activityIntent, 1);
                    ee.k.n(App.m(), "notification", "settings", "sound", "click", true, "entity_type", ANALYTICS_ENTITY_TYPE_SPORT_TYPE, "entity_id", String.valueOf(this.sportType));
                } else if (bVar == d.b.checkBox) {
                    handleCheckBoxClick(dVar, i10);
                    if (dVar.f9047b) {
                        NotifiedUpdateObj notifiedUpdateObj = dVar.f9046a;
                        if (notifiedUpdateObj != null && notifiedUpdateObj.isAutoSelectedNotificationsListNotEmpty()) {
                            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
                            while (it.hasNext()) {
                                com.scores365.Design.PageObjects.b next = it.next();
                                if ((next instanceof bf.d) && !((bf.d) next).f9047b && dVar.f9046a.isNotificationShouldAutoSelect(((bf.d) next).f9046a.getID())) {
                                    ((bf.d) next).f9047b = true;
                                    ((bf.d) next).f9049d = true;
                                    d.c cVar = (d.c) this.rvItems.a0(i11);
                                    if (cVar != null) {
                                        ((bf.d) next).l(cVar);
                                    }
                                    handleCheckBoxClick((bf.d) next, i11);
                                }
                                i11++;
                            }
                        }
                    } else {
                        Iterator<com.scores365.Design.PageObjects.b> it2 = this.rvBaseAdapter.B().iterator();
                        int i12 = 0;
                        while (it2.hasNext()) {
                            com.scores365.Design.PageObjects.b next2 = it2.next();
                            if ((next2 instanceof bf.d) && ((bf.d) next2).f9047b && ((bf.d) next2).f9046a.isNotificationShouldAutoSelect(dVar.f9046a.getID())) {
                                ((bf.d) next2).f9047b = false;
                                ((bf.d) next2).f9049d = true;
                                d.c cVar2 = (d.c) this.rvItems.a0(i12);
                                if (cVar2 != null) {
                                    ((bf.d) next2).l(cVar2);
                                }
                                handleCheckBoxClick((bf.d) next2, i12);
                            }
                            i12++;
                        }
                    }
                }
            } else if (this.rvBaseAdapter.A(i10) instanceof bf.f) {
                this.isSomethingChanged = true;
                handleToggleButtonClick();
                ((bf.f) this.rvBaseAdapter.A(i10)).f9074a = isAllNotificationSelected();
            }
            updateSelectAllState();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        try {
            updateSelectAllState();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void saveGeneralNotificationToDatabase() {
        try {
            this.generalNotifyObjs = new Vector<>();
            Iterator<com.scores365.Design.PageObjects.b> it = this.rvBaseAdapter.B().iterator();
            while (it.hasNext()) {
                com.scores365.Design.PageObjects.b next = it.next();
                if (next instanceof bf.d) {
                    bf.d dVar = (bf.d) next;
                    if (dVar.f9047b) {
                        this.generalNotifyObjs.add(new GeneralNotifyObj(this.sportType, dVar.f9046a.getID(), dVar.f9050e));
                    }
                }
            }
            sf.a.i0(getContext()).C1(this.sportType);
            sf.a.i0(getContext()).g(this.generalNotifyObjs);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void showOverrunDialog() {
        p0.G0(getContext(), p0.l0("WANT_TO_RUN_OVER"), p0.l0("YES"), p0.l0("NO"), new AnonymousClass1(), new AnonymousClass2()).show();
    }
}
