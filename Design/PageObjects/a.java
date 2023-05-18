package com.scores365.Design.PageObjects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.CustomLinearLayoutManager;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import li.x0;
/* compiled from: BaseHorizontalScrollItem.java */
/* loaded from: classes2.dex */
public abstract class a extends b implements q.e {
    public int clickedPosition = -1;
    public ArrayList<b> data;
    protected WeakReference<C0230a> holderRef;

    /* compiled from: BaseHorizontalScrollItem.java */
    /* renamed from: com.scores365.Design.PageObjects.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0230a extends t {
        protected com.scores365.Design.Pages.c adapter;
        protected RecyclerView horizontalRecyclerView;
        public CustomLinearLayoutManager layoutManager;
        public WeakReference<q.e> onRecylerItemClickListenerWeakReference;

        public C0230a(View view, q.e eVar) {
            super(view);
            this.layoutManager = null;
            try {
                this.onRecylerItemClickListenerWeakReference = new WeakReference<>(eVar);
                this.horizontalRecyclerView = (RecyclerView) view.findViewById(R.id.yo);
                handleLayoutManager();
                ((t) this).itemView.setSoundEffectsEnabled(false);
                ((t) this).itemView.setOnClickListener(new u(this, eVar));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public com.scores365.Design.Pages.c getAdapter() {
            return this.adapter;
        }

        public RecyclerView getHorizontalRecyclerView() {
            return this.horizontalRecyclerView;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void handleLayoutManager() {
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(App.m(), 0, x0.l1() && shouldReverseOnRtl());
            this.layoutManager = customLinearLayoutManager;
            this.horizontalRecyclerView.setLayoutManager(customLinearLayoutManager);
        }

        protected boolean shouldReverseOnRtl() {
            return true;
        }
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new C0230a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.Q, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // com.scores365.Design.Pages.q.e
    public void OnRecylerItemClick(int i10) {
        this.clickedPosition = i10;
        WeakReference<C0230a> weakReference = this.holderRef;
        if ((weakReference != null ? weakReference.get() : null) != null) {
            ((t) this.holderRef.get()).itemView.performClick();
        }
    }

    protected com.scores365.Design.Pages.c createRecyclerAdapter() {
        try {
            return new com.scores365.Design.Pages.c(getData(), this);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public int getClickedPosition() {
        return this.clickedPosition;
    }

    public ArrayList<b> getData() {
        try {
            if (this.data == null) {
                this.data = loadItems();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.data;
    }

    protected abstract int getItemHeight();

    protected abstract ArrayList<b> loadItems();

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            C0230a c0230a = (C0230a) e0Var;
            if (c0230a.adapter != null && !shouldReloadDataEveryBind()) {
                c0230a.adapter.H(getData());
                c0230a.adapter.notifyDataSetChanged();
                this.holderRef = new WeakReference<>(c0230a);
                c0230a.horizontalRecyclerView.getLayoutParams().height = getItemHeight();
            }
            com.scores365.Design.Pages.c createRecyclerAdapter = createRecyclerAdapter();
            c0230a.adapter = createRecyclerAdapter;
            createRecyclerAdapter.G(i10);
            c0230a.horizontalRecyclerView.setAdapter(c0230a.adapter);
            this.holderRef = new WeakReference<>(c0230a);
            c0230a.horizontalRecyclerView.getLayoutParams().height = getItemHeight();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reloadItems() {
        try {
            this.data = loadItems();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void resetClickedPosition() {
        this.clickedPosition = -1;
    }

    public void resetData() {
        this.data = null;
    }

    protected boolean shouldReloadDataEveryBind() {
        return false;
    }
}
