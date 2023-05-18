package com.scores365.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.SourceObj;
import java.util.ArrayList;
import java.util.HashSet;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class SelectNewsSourceListAdapter extends BaseAdapter {
    private OnNewsSourceClickListener listener;
    private ArrayList<SourceObj> newsSourceList;
    private HashSet<Integer> removedNewsSourceId;
    private HashSet<Integer> sourceObjSection;

    /* loaded from: classes2.dex */
    public interface OnNewsSourceClickListener {
        void OnNewsSourceClick(int i10, boolean z10);
    }

    /* loaded from: classes2.dex */
    private class ViewHolder {
        CheckBox cbNewsSource;
        ImageView ivNewsSourceLogo;
        RelativeLayout rlTitle;
        TextView tvNewsSourceName;
        TextView tvTitle;

        private ViewHolder() {
        }
    }

    public SelectNewsSourceListAdapter(HashSet<Integer> hashSet, ArrayList<SourceObj> arrayList, HashSet<Integer> hashSet2, OnNewsSourceClickListener onNewsSourceClickListener) {
        try {
            this.removedNewsSourceId = hashSet;
            this.newsSourceList = arrayList;
            this.sourceObjSection = hashSet2;
            this.listener = onNewsSourceClickListener;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        try {
            return this.newsSourceList.size();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.widget.Adapter
    public SourceObj getItem(int i10) {
        try {
            return this.newsSourceList.get(i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        int i11;
        try {
            i11 = this.newsSourceList.get(i10).getID();
        } catch (Exception unused) {
            i11 = 0;
        }
        return i11;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        try {
            final SourceObj item = getItem(i10);
            if (view == null) {
                viewHolder = new ViewHolder();
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22583j8, (ViewGroup) null);
                viewHolder.ivNewsSourceLogo = (ImageView) view.findViewById(R.id.f22160mc);
                viewHolder.tvNewsSourceName = (TextView) view.findViewById(R.id.FB);
                viewHolder.cbNewsSource = (CheckBox) view.findViewById(R.id.f22061i2);
                viewHolder.rlTitle = (RelativeLayout) view.findViewById(R.id.wn);
                TextView textView = (TextView) view.findViewById(R.id.lA);
                viewHolder.tvTitle = textView;
                textView.setTypeface(o0.a(viewGroup.getContext()));
                viewHolder.tvNewsSourceName.setTypeface(o0.d(viewGroup.getContext()));
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.rlTitle.setVisibility(8);
            if (this.sourceObjSection.contains(Integer.valueOf(item.getID()))) {
                viewHolder.rlTitle.setVisibility(0);
                viewHolder.tvTitle.setText(App.l().getLanguages().get(Integer.valueOf(item.newsLang)).getName());
            }
            viewHolder.ivNewsSourceLogo.setVisibility(8);
            viewHolder.tvNewsSourceName.setText(item.getName());
            viewHolder.cbNewsSource.setChecked(false);
            if (!this.removedNewsSourceId.contains(Integer.valueOf(item.getID()))) {
                viewHolder.cbNewsSource.setChecked(true);
            }
            final CheckBox checkBox = viewHolder.cbNewsSource;
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.SelectNewsSourceListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        if (SelectNewsSourceListAdapter.this.removedNewsSourceId.contains(Integer.valueOf(item.getID()))) {
                            checkBox.setChecked(true);
                            SelectNewsSourceListAdapter.this.removedNewsSourceId.remove(Integer.valueOf(item.getID()));
                        } else {
                            checkBox.setChecked(false);
                            SelectNewsSourceListAdapter.this.removedNewsSourceId.add(Integer.valueOf(item.getID()));
                        }
                        if (SelectNewsSourceListAdapter.this.listener != null) {
                            SelectNewsSourceListAdapter.this.listener.OnNewsSourceClick(item.getID(), SelectNewsSourceListAdapter.this.removedNewsSourceId.contains(Integer.valueOf(item.getID())));
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return view;
    }
}
