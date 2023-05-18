package com.scores365.ui.settings;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.db.InternalStorageDataManager;
import com.scores365.entitys.LanguageObj;
import com.scores365.ui.settings.SelectLangItem;
import com.scores365.ui.settings.SelectNewsLangItem;
import ee.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import li.o0;
import li.p;
import li.p0;
import li.x0;
import li.z0;
import sf.a;
import sf.b;
import yc.d;
/* loaded from: classes2.dex */
public class SelectLanguageFragment extends q {
    private static final String ACTION_TAG = "action_tag";
    private HashSet<Integer> newsLanguages;
    private Dialog progress2;
    private int newLangId = -1;
    private int fallbackLangId = -1;
    private boolean isNeedToUpdateNewsLang = false;
    private final HashSet<Integer> addedNewsLanguagesForAnalytics = new HashSet<>();
    private boolean shouldClearQuizGameData = false;
    private boolean isProcessSuccess = false;
    private final z0.b changeListener = new z0.b() { // from class: com.scores365.ui.settings.SelectLanguageFragment.1
        @Override // li.z0.b
        public void onProcessFinish(boolean z10, int i10) {
            try {
                SelectLanguageFragment.this.isProcessSuccess = z10;
                Context context = SelectLanguageFragment.this.getContext();
                if (z10) {
                    SelectLanguageFragment.this.newsLanguages = b.X1().f0();
                    SelectLanguageFragment.this.newsLanguages.remove(Integer.valueOf(i10));
                    SelectLanguageFragment.this.newsLanguages.add(Integer.valueOf(SelectLanguageFragment.this.newLangId));
                    x0.d();
                    b.X1().R7(SelectLanguageFragment.this.newsLanguages);
                    MainDashboardActivity.Z0 = true;
                    App.O();
                    a.i0(context).P1(true);
                    b.X1().X6();
                    b.X1().Z2().clear();
                    b.X1().X2().clear();
                    App.b.t();
                    p.d(context);
                    d.f43140k = null;
                    if (SelectLanguageFragment.this.shouldClearQuizGameData) {
                        od.a.D().o(null);
                    }
                    od.a.D().n(true);
                    InternalStorageDataManager.saveDashboardDataAsync(null);
                    x0.A2(null, null);
                    SelectLanguageFragment.this.getTipController().E();
                } else {
                    a.i0(context).R1(SelectLanguageFragment.this.fallbackLangId);
                    Typeface d10 = o0.d(App.m());
                    SpannableString spannableString = new SpannableString(p0.l0("NETWORK_PROBLEM"));
                    spannableString.setSpan(new o0.a(d10), 0, spannableString.length(), 33);
                    Toast.makeText(App.m(), spannableString, 0).show();
                }
                p0.u0(SelectLanguageFragment.this.progress2);
                SelectLanguageFragment.this.getActivity().finish();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    };

    public static SelectLanguageFragment newInstance(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ACTION_TAG, str);
        SelectLanguageFragment selectLanguageFragment = new SelectLanguageFragment();
        selectLanguageFragment.setArguments(bundle);
        return selectLanguageFragment;
    }

    private void sendAnalytics() {
        try {
            if (this.addedNewsLanguagesForAnalytics.size() > 0) {
                String str = "";
                Iterator<Integer> it = this.addedNewsLanguagesForAnalytics.iterator();
                while (it.hasNext()) {
                    Integer next = it.next();
                    if (str.length() > 0) {
                        str = str + ",";
                    }
                    str = str + String.valueOf(next);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            ArrayList arrayList2 = new ArrayList(App.l().getLanguages().values());
            int k02 = a.i0(App.m()).k0();
            if (getAction().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    LanguageObj languageObj = (LanguageObj) it.next();
                    arrayList.add(new SelectLangItem(languageObj, languageObj.getID() == k02));
                }
            } else if (getAction().equals("2")) {
                this.newsLanguages = b.X1().f0();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    LanguageObj languageObj2 = (LanguageObj) it2.next();
                    arrayList.add(new SelectNewsLangItem(languageObj2, this.newsLanguages.contains(Integer.valueOf(languageObj2.getID()))));
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    public String getAction() {
        try {
            return getArguments().getString(ACTION_TAG);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return super.getLayoutResourceID();
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.Design.Pages.q, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.isProcessSuccess) {
                z0.a();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            k.g();
            if (this.isNeedToUpdateNewsLang) {
                b.X1().R7(this.newsLanguages);
                x0.d();
                sendAnalytics();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (!(A instanceof SelectLangItem)) {
                if (A instanceof SelectNewsLangItem) {
                    SelectNewsLangItem selectNewsLangItem = (SelectNewsLangItem) A;
                    boolean z10 = selectNewsLangItem.isChecked() ? false : true;
                    this.isNeedToUpdateNewsLang = true;
                    if (z10) {
                        this.newsLanguages.add(Integer.valueOf(selectNewsLangItem.getLanguageObj().getID()));
                        this.addedNewsLanguagesForAnalytics.add(Integer.valueOf(selectNewsLangItem.getLanguageObj().getID()));
                    } else {
                        this.newsLanguages.remove(Integer.valueOf(selectNewsLangItem.getLanguageObj().getID()));
                        if (this.addedNewsLanguagesForAnalytics.contains(Integer.valueOf(selectNewsLangItem.getLanguageObj().getID()))) {
                            this.addedNewsLanguagesForAnalytics.remove(Integer.valueOf(selectNewsLangItem.getLanguageObj().getID()));
                        }
                    }
                    MainDashboardActivity.Z0 = true;
                    selectNewsLangItem.setChecked(z10);
                    SelectNewsLangItem.ViewHolder viewHolder = (SelectNewsLangItem.ViewHolder) this.rvItems.a0(i10);
                    if (viewHolder != null) {
                        viewHolder.setChecked(z10);
                        return;
                    }
                    return;
                }
                return;
            }
            SelectLangItem selectLangItem = (SelectLangItem) A;
            if (!selectLangItem.isChecked()) {
                for (int i11 = 0; i11 < this.rvBaseAdapter.B().size(); i11++) {
                    com.scores365.Design.PageObjects.b A2 = this.rvBaseAdapter.A(i11);
                    if ((A2 instanceof SelectLangItem) && ((SelectLangItem) A2).isChecked() && i11 != i10) {
                        ((SelectLangItem) A2).setChecked(false);
                        SelectLangItem.ViewHolder viewHolder2 = (SelectLangItem.ViewHolder) this.rvItems.a0(i11);
                        if (viewHolder2 != null) {
                            viewHolder2.setChecked(false);
                        }
                    }
                }
                selectLangItem.setChecked(true);
                SelectLangItem.ViewHolder viewHolder3 = (SelectLangItem.ViewHolder) this.rvItems.a0(i10);
                if (viewHolder3 != null) {
                    viewHolder3.setChecked(true);
                }
            }
            int k02 = a.i0(getContext()).k0();
            this.newLangId = selectLangItem.getLanguageObj().getID();
            this.fallbackLangId = a.i0(getContext()).k0();
            a.i0(getContext()).R1(this.newLangId);
            try {
                this.shouldClearQuizGameData = selectLangItem.getLanguageObj().getFatherID() != App.l().getLanguages().get(Integer.valueOf(this.fallbackLangId)).getFatherID();
            } catch (Exception e10) {
                x0.N1(e10);
            }
            this.progress2 = p0.H0(getContext(), "", null);
            com.scores365.tournamentPromotion.a.c();
            z0.m(this.changeListener, true, true, k02);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
