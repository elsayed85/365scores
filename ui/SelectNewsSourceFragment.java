package com.scores365.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import com.scores365.dashboard.MainDashboardActivity;
import com.scores365.entitys.SourceObj;
import com.scores365.ui.SelectNewsSourceListAdapter;
import com.scores365.ui.settings.NewsSourceItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SelectNewsSourceFragment extends com.scores365.Design.Pages.q {
    private CheckBox cbCheckAll;
    private HashSet<Integer> removedNewsSourceId;
    private ArrayList<SourceObj> sourceList;
    private boolean isDirty = false;
    private View.OnClickListener checkBoxListener = new View.OnClickListener() { // from class: com.scores365.ui.SelectNewsSourceFragment.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                boolean isChecked = SelectNewsSourceFragment.this.cbCheckAll.isChecked();
                Iterator it = SelectNewsSourceFragment.this.sourceList.iterator();
                while (it.hasNext()) {
                    SourceObj sourceObj = (SourceObj) it.next();
                    if (!isChecked) {
                        SelectNewsSourceFragment.this.removedNewsSourceId.add(Integer.valueOf(sourceObj.getID()));
                    } else if (SelectNewsSourceFragment.this.removedNewsSourceId.contains(Integer.valueOf(sourceObj.getID()))) {
                        SelectNewsSourceFragment.this.removedNewsSourceId.remove(Integer.valueOf(sourceObj.getID()));
                    }
                }
                SelectNewsSourceFragment.this.isDirty = true;
                for (int i10 = 0; i10 < ((com.scores365.Design.Pages.q) SelectNewsSourceFragment.this).rvBaseAdapter.getItemCount(); i10++) {
                    com.scores365.Design.PageObjects.b A = ((com.scores365.Design.Pages.q) SelectNewsSourceFragment.this).rvBaseAdapter.A(i10);
                    if (A instanceof NewsSourceItem) {
                        ((NewsSourceItem) A).setChecked(isChecked);
                        NewsSourceItem.ViewHolder viewHolder = (NewsSourceItem.ViewHolder) SelectNewsSourceFragment.this.rvItems.a0(i10);
                        if (viewHolder != null) {
                            viewHolder.setChecked(isChecked);
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    private SelectNewsSourceListAdapter.OnNewsSourceClickListener newsSourceListener = new SelectNewsSourceListAdapter.OnNewsSourceClickListener() { // from class: com.scores365.ui.SelectNewsSourceFragment.6
        @Override // com.scores365.ui.SelectNewsSourceListAdapter.OnNewsSourceClickListener
        public void OnNewsSourceClick(int i10, boolean z10) {
            try {
                if (z10) {
                    SelectNewsSourceFragment.this.removedNewsSourceId.add(Integer.valueOf(i10));
                } else {
                    SelectNewsSourceFragment.this.removedNewsSourceId.remove(Integer.valueOf(i10));
                }
                SelectNewsSourceFragment.this.isDirty = true;
                SelectNewsSourceFragment.this.updateCheckBoxStatus();
                MainDashboardActivity.Z0 = true;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };

    private static HashSet<Integer> getRemovedNewsSources() {
        HashSet<Integer> hashSet = new HashSet<>();
        try {
            return sf.b.X1().x1();
        } catch (Exception e10) {
            x0.N1(e10);
            return hashSet;
        }
    }

    public static SelectNewsSourceFragment newInstance() {
        try {
            return new SelectNewsSourceFragment();
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckBoxStatus() {
        boolean z10;
        boolean z11;
        try {
            Iterator<SourceObj> it = this.sourceList.iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                } else if (this.removedNewsSourceId.contains(Integer.valueOf(it.next().getID()))) {
                    z11 = true;
                    break;
                }
            }
            CheckBox checkBox = this.cbCheckAll;
            if (z11) {
                z10 = false;
            }
            checkBox.setChecked(z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            com.scores365.api.m mVar = new com.scores365.api.m(App.m(), sf.b.X1().s2());
            mVar.call();
            ArrayList<SourceObj> a10 = mVar.a();
            this.sourceList = a10;
            if (a10 != null && !a10.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<SourceObj> it = this.sourceList.iterator();
                boolean z10 = false;
                while (it.hasNext()) {
                    SourceObj next = it.next();
                    if (next.newsLang == sf.b.X1().o1()) {
                        arrayList2.add(next);
                        z10 = true;
                    }
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    SourceObj sourceObj = (SourceObj) it2.next();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= this.sourceList.size()) {
                            break;
                        } else if (sourceObj.getID() == this.sourceList.get(i10).getID()) {
                            this.sourceList.remove(i10);
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (z10) {
                    Collections.sort(arrayList2, new Comparator<SourceObj>() { // from class: com.scores365.ui.SelectNewsSourceFragment.1
                        @Override // java.util.Comparator
                        public int compare(SourceObj sourceObj2, SourceObj sourceObj3) {
                            try {
                                return sourceObj2.getName().compareToIgnoreCase(sourceObj3.getName());
                            } catch (Exception unused) {
                                return 0;
                            }
                        }
                    });
                }
                Collections.sort(this.sourceList, new Comparator<SourceObj>() { // from class: com.scores365.ui.SelectNewsSourceFragment.2
                    @Override // java.util.Comparator
                    public int compare(SourceObj sourceObj2, SourceObj sourceObj3) {
                        try {
                            return sourceObj2.getName().compareToIgnoreCase(sourceObj3.getName());
                        } catch (Exception unused) {
                            return 0;
                        }
                    }
                });
                Collections.sort(this.sourceList, new Comparator<SourceObj>() { // from class: com.scores365.ui.SelectNewsSourceFragment.3
                    @Override // java.util.Comparator
                    public int compare(SourceObj sourceObj2, SourceObj sourceObj3) {
                        return sourceObj2.newsLang - sourceObj3.newsLang;
                    }
                });
                this.sourceList.addAll(0, arrayList2);
                Hashtable hashtable = new Hashtable();
                Iterator<SourceObj> it3 = this.sourceList.iterator();
                while (it3.hasNext()) {
                    SourceObj next2 = it3.next();
                    if (!hashtable.contains(Integer.valueOf(next2.newsLang))) {
                        hashtable.put(Integer.valueOf(next2.getID()), Integer.valueOf(next2.newsLang));
                    }
                }
                HashSet hashSet = new HashSet(hashtable.keySet());
                this.removedNewsSourceId = getRemovedNewsSources();
                Iterator<SourceObj> it4 = this.sourceList.iterator();
                while (it4.hasNext()) {
                    SourceObj next3 = it4.next();
                    if (hashSet.contains(Integer.valueOf(next3.getID()))) {
                        arrayList.add(new yc.r(App.l().getLanguages().get(Integer.valueOf(next3.newsLang)).getName()));
                    }
                    arrayList.add(new NewsSourceItem(next3, !this.removedNewsSourceId.contains(Integer.valueOf(next3.getID()))));
                }
                this.cbCheckAll.setOnClickListener(this.checkBoxListener);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public int getLayoutResourceID() {
        return R.layout.f22596k8;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    @Override // com.scores365.Design.Pages.q, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        try {
            TextView textView = (TextView) onCreateView.findViewById(R.id.fp);
            textView.setTypeface(o0.d(App.m().getApplicationContext()));
            textView.setText(p0.l0("SETTINGS_LANGUAGE_CHOOSE_SOURCES"));
            onCreateView.findViewById(R.id.G).setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.SelectNewsSourceFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        SelectNewsSourceFragment.this.getActivity().finish();
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
            CheckBox checkBox = (CheckBox) onCreateView.findViewById(R.id.Y1);
            this.cbCheckAll = checkBox;
            checkBox.setChecked(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        try {
            super.onPause();
            sf.b.X1().T7(this.removedNewsSourceId);
            if (this.isDirty) {
                MainDashboardActivity.Z0 = true;
                x0.A2(null, null);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            com.scores365.Design.PageObjects.b A = this.rvBaseAdapter.A(i10);
            if (A instanceof NewsSourceItem) {
                NewsSourceItem newsSourceItem = (NewsSourceItem) A;
                NewsSourceItem.ViewHolder viewHolder = (NewsSourceItem.ViewHolder) this.rvItems.a0(i10);
                if (this.removedNewsSourceId.contains(Integer.valueOf(newsSourceItem.getSourceObj().getID()))) {
                    newsSourceItem.setChecked(true);
                    viewHolder.setChecked(true);
                    this.removedNewsSourceId.remove(Integer.valueOf(newsSourceItem.getSourceObj().getID()));
                } else {
                    newsSourceItem.setChecked(false);
                    viewHolder.setChecked(false);
                    this.removedNewsSourceId.add(Integer.valueOf(newsSourceItem.getSourceObj().getID()));
                }
                this.isDirty = true;
                updateCheckBoxStatus();
                MainDashboardActivity.Z0 = true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        try {
            updateCheckBoxStatus();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
