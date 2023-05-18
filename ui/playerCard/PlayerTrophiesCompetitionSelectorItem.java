package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.e1;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.PageObjects.a;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.Trophy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import lf.u;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerTrophiesCompetitionSelectorItem extends com.scores365.Design.PageObjects.a {
    private final LinkedHashMap<Integer, CompetitionObj> competitionsById;
    private int selectedIndex = 0;
    private ArrayList<Trophy> trophies;

    /* loaded from: classes2.dex */
    public static class FlingListener extends RecyclerView.s {
        WeakReference<RecyclerView> recyclerViewRef;
        WeakReference<ViewHolder> viewHolderRef;

        public FlingListener(RecyclerView recyclerView, ViewHolder viewHolder) {
            this.recyclerViewRef = new WeakReference<>(recyclerView);
            this.viewHolderRef = new WeakReference<>(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean onFling(int i10, int i11) {
            RecyclerView recyclerView;
            ViewHolder viewHolder;
            String snapToPosition;
            try {
                WeakReference<RecyclerView> weakReference = this.recyclerViewRef;
                if (weakReference == null || this.viewHolderRef == null) {
                    recyclerView = null;
                    viewHolder = null;
                } else {
                    recyclerView = weakReference.get();
                    viewHolder = this.viewHolderRef.get();
                }
                if (recyclerView != null && viewHolder != null && (snapToPosition = PlayerTrophiesCompetitionSelectorItem.snapToPosition(recyclerView, i10, viewHolder)) != null && !snapToPosition.isEmpty()) {
                    ee.k.n(App.m(), "athlete", "trophies", "click", null, true, "direction", snapToPosition, "click_type", "swipe");
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollListener extends RecyclerView.u {
        boolean mScrolled = false;
        WeakReference<ViewHolder> viewHolderRef;

        public ScrollListener(ViewHolder viewHolder) {
            this.viewHolderRef = new WeakReference<>(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            String snapToPosition;
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0) {
                try {
                    if (this.mScrolled) {
                        WeakReference<ViewHolder> weakReference = this.viewHolderRef;
                        ViewHolder viewHolder = weakReference != null ? weakReference.get() : null;
                        if (viewHolder != null && (snapToPosition = PlayerTrophiesCompetitionSelectorItem.snapToPosition(recyclerView, 0, viewHolder)) != null && !snapToPosition.isEmpty()) {
                            ee.k.n(App.m(), "athlete", "trophies", "click", null, true, "direction", snapToPosition, "click_type", "swipe");
                        }
                        this.mScrolled = false;
                    }
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            if (i10 == 0 && i11 == 0) {
                return;
            }
            try {
                this.mScrolled = true;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends a.C0230a {
        ArrayList<ImageView> pagerDots;
        LinearLayout pagerDotsContainer;

        public ViewHolder(View view, q.e eVar) {
            super(view, eVar);
            this.pagerDots = new ArrayList<>();
            try {
                this.pagerDotsContainer = (LinearLayout) view.findViewById(R.id.f22297sg);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public PlayerTrophiesCompetitionSelectorItem(LinkedHashMap<Integer, CompetitionObj> linkedHashMap, ArrayList<Trophy> arrayList) {
        this.trophies = arrayList;
        this.competitionsById = linkedHashMap;
    }

    public static t onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        try {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22767y6, viewGroup, false), eVar);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static ArrayList<ImageView> populatePagerDotContainer(LinearLayout linearLayout, int i10, int i11, boolean z10) {
        ArrayList<ImageView> arrayList = new ArrayList<>();
        try {
            linearLayout.removeAllViews();
            if (i10 > 1) {
                linearLayout.setVisibility(0);
                for (int i12 = 0; i12 < i10; i12++) {
                    ImageView imageView = new ImageView(linearLayout.getContext());
                    imageView.setImageResource(i11);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(p0.s(7), p0.s(7));
                    layoutParams.leftMargin = p0.s(4);
                    layoutParams.rightMargin = p0.s(4);
                    if (x0.l1() && z10) {
                        linearLayout.addView(imageView, 0, layoutParams);
                    } else {
                        linearLayout.addView(imageView, layoutParams);
                    }
                    arrayList.add(imageView);
                }
            } else {
                linearLayout.setVisibility(8);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String snapToPosition(RecyclerView recyclerView, int i10, ViewHolder viewHolder) {
        try {
            int p10 = (App.p() / 2) + (i10 / 10);
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= recyclerView.getChildCount()) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i11);
                int position = recyclerView.getLayoutManager().getPosition(childAt);
                if (position % 3 == 1) {
                    p10 = (((int) childAt.getX()) + (App.p() / 6)) - p10;
                    i12 = position;
                    break;
                }
                i11++;
                i12 = position;
            }
            int p11 = p10 - App.p();
            int p12 = App.p() + p10;
            if (x0.l1()) {
                p11 = App.p() + p10;
                p12 = p10 - App.p();
            }
            if (Math.abs(p11) < Math.abs(p10)) {
                i12 -= 3;
                p10 = p11;
            }
            if (Math.abs(p12) < Math.abs(p10)) {
                i12 += 3;
            } else {
                p12 = p10;
            }
            recyclerView.t1(p12 + (i10 / 10), 0);
            return updatePagerDotsSelection(viewHolder.pagerDots, i12 / 3);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static String updatePagerDotsSelection(ArrayList<ImageView> arrayList, int i10) {
        String str = null;
        try {
            if (!arrayList.isEmpty()) {
                Iterator<ImageView> it = arrayList.iterator();
                int i11 = -1;
                int i12 = 0;
                while (it.hasNext()) {
                    ImageView next = it.next();
                    if (next.isSelected()) {
                        i11 = i12;
                    }
                    next.setSelected(false);
                    i12++;
                }
                if (i11 != i10) {
                    if (i11 > i10) {
                        str = "backward";
                    } else if (i11 < i10) {
                        str = "forward";
                    }
                }
                arrayList.get(i10).setSelected(true);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return str;
    }

    @Override // com.scores365.Design.PageObjects.a, com.scores365.Design.Pages.q.e
    public void OnRecylerItemClick(int i10) {
        try {
            this.selectedIndex = i10;
            int i11 = 0;
            while (i11 < this.data.size()) {
                if (this.data.get(i11) instanceof PlayerTrophiesCompetitionSingleItem) {
                    ((PlayerTrophiesCompetitionSingleItem) this.data.get(i11)).setSelected(i11 == i10);
                }
                i11++;
            }
            WeakReference<a.C0230a> weakReference = this.holderRef;
            a.C0230a c0230a = weakReference != null ? weakReference.get() : null;
            if (c0230a != null) {
                c0230a.getAdapter().notifyDataSetChanged();
            }
            super.OnRecylerItemClick(i10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public int getCompetitionIdByPosition(int i10) {
        try {
            if (this.data.get(i10) instanceof PlayerTrophiesCompetitionSingleItem) {
                return ((PlayerTrophiesCompetitionSingleItem) this.data.get(i10)).getCompetitionId();
            }
            return -1;
        } catch (Exception e10) {
            x0.N1(e10);
            return -1;
        }
    }

    @Override // com.scores365.Design.PageObjects.a
    public ArrayList<com.scores365.Design.PageObjects.b> getData() {
        try {
            if (this.data == null) {
                this.data = loadItems();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.data;
    }

    @Override // com.scores365.Design.PageObjects.a
    protected int getItemHeight() {
        return p0.s(84);
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerTrophiesCompetitionSelectorItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.a
    protected ArrayList<com.scores365.Design.PageObjects.b> loadItems() {
        int i10;
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        int i11 = 0;
        while (true) {
            try {
                i10 = 1;
                boolean z10 = true;
                if (i11 >= this.trophies.size()) {
                    break;
                }
                Trophy trophy = this.trophies.get(i11);
                if (i11 != this.selectedIndex) {
                    z10 = false;
                }
                arrayList.add(new PlayerTrophiesCompetitionSingleItem(z10, this.competitionsById.get(Integer.valueOf(trophy.getCompetitionID())), trophy.getCount(), trophy.getName()));
                i11++;
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        if (this.trophies.size() >= 3) {
            int size = arrayList.size() % 3;
            if (size != 2) {
                i10 = size == 1 ? 2 : size;
            }
            for (int i12 = 0; i12 < i10; i12++) {
                arrayList.add(new PlayerTrophiesCompetitionSelectorFillerItem(false));
            }
        } else if (this.trophies.size() == 1) {
            arrayList.add(0, new PlayerTrophiesCompetitionSelectorFillerItem(false));
        } else {
            arrayList.add(0, new PlayerTrophiesCompetitionSelectorFillerItem(true));
        }
        return arrayList;
    }

    @Override // com.scores365.Design.PageObjects.a, com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        boolean z10 = this.data == null;
        super.onBindViewHolder(e0Var, i10);
        try {
            ViewHolder viewHolder = (ViewHolder) e0Var;
            e1.C0(((t) viewHolder).itemView, App.m().getResources().getDimension(androidx.cardview.R.dimen.f3942a));
            viewHolder.getHorizontalRecyclerView().setOnFlingListener(new FlingListener(viewHolder.getHorizontalRecyclerView(), viewHolder));
            viewHolder.getHorizontalRecyclerView().l(new ScrollListener(viewHolder));
            if (z10) {
                int size = this.data.size() / 3;
                if (this.data.size() % 3 > 0) {
                    size++;
                }
                ((ViewGroup.MarginLayoutParams) viewHolder.getHorizontalRecyclerView().getLayoutParams()).bottomMargin = 0;
                ArrayList<ImageView> populatePagerDotContainer = populatePagerDotContainer(viewHolder.pagerDotsContainer, size, R.drawable.f21684c5, true);
                viewHolder.pagerDots = populatePagerDotContainer;
                updatePagerDotsSelection(populatePagerDotContainer, 0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void resetSelecetedIndex() {
        this.selectedIndex = 0;
    }

    public void setSelectedIndex(int i10) {
        this.selectedIndex = i10;
    }

    public void setTrophies(ArrayList<Trophy> arrayList) {
        this.trophies = arrayList;
    }
}
