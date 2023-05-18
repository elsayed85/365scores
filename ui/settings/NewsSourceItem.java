package com.scores365.ui.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.SourceObj;
import li.o0;
import li.x0;
/* loaded from: classes2.dex */
public class NewsSourceItem extends b {
    private boolean isChecked;
    private SourceObj sourceObj;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        private CheckBox checkBox;
        private TextView sourceName;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                view.setOnClickListener(new u(this, eVar));
                this.sourceName = (TextView) view.findViewById(R.id.Je);
                this.checkBox = (CheckBox) view.findViewById(R.id.X1);
                this.sourceName.setTypeface(o0.d(view.getContext()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public void setChecked(boolean z10) {
            this.checkBox.setChecked(z10);
        }
    }

    public NewsSourceItem(SourceObj sourceObj, boolean z10) {
        this.sourceObj = sourceObj;
        this.isChecked = z10;
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22570i8, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.newsSourceItem.ordinal();
    }

    public SourceObj getSourceObj() {
        return this.sourceObj;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        ViewHolder viewHolder = (ViewHolder) e0Var;
        try {
            viewHolder.sourceName.setText(this.sourceObj.getName());
            viewHolder.checkBox.setChecked(this.isChecked);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }
}
