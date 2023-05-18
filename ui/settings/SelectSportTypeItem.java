package com.scores365.ui.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.SportTypeObj;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class SelectSportTypeItem extends b {
    SportTypeObj sportTypeObj;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        private ImageView sportTypeImage;
        private TextView sportTypeName;

        public ViewHolder(View view, q.e eVar) {
            super(view);
            try {
                view.setOnClickListener(new u(this, eVar));
                this.sportTypeImage = (ImageView) view.findViewById(R.id.f22161md);
                TextView textView = (TextView) view.findViewById(R.id.uE);
                this.sportTypeName = textView;
                textView.setTypeface(o0.d(view.getContext()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public SelectSportTypeItem(SportTypeObj sportTypeObj) {
        this.sportTypeObj = sportTypeObj;
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new ViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22648o8, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22635n8, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.selectSportTypeItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            viewHolder.sportTypeName.setText(this.sportTypeObj.getName());
            viewHolder.sportTypeImage.setImageResource(p0.v(this.sportTypeObj.getID(), true));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
