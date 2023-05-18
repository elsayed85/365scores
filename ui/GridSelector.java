package com.scores365.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import com.scores365.App;
import com.scores365.R;
import com.scores365.bets.model.BetLine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class GridSelector extends GridLayout {
    public static String TAG = "com.scores365.ui.GridSelector";
    public int MAX_COLUMNS;
    public int MAX_ROWS;
    private GridSelectorEvents eventsCallback;
    ArrayList<Button> marketButtons;

    /* loaded from: classes2.dex */
    public interface GridSelectorEvents {
        void onMarketSelected(int i10);
    }

    public GridSelector(Context context) {
        super(context);
        this.MAX_COLUMNS = 3;
        this.MAX_ROWS = 2;
    }

    public GridSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MAX_COLUMNS = 3;
        this.MAX_ROWS = 2;
    }

    public GridSelector(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.MAX_COLUMNS = 3;
        this.MAX_ROWS = 2;
    }

    public void addViews(LinkedHashMap<Integer, BetLine> linkedHashMap, int i10) {
        try {
            removeAllViews();
            this.marketButtons = new ArrayList<>();
            int i11 = this.MAX_COLUMNS * this.MAX_ROWS;
            HashSet hashSet = new HashSet();
            if (x0.l1()) {
                setRotationY(180.0f);
            }
            int i12 = 0;
            int i13 = 0;
            for (Integer num : linkedHashMap.keySet()) {
                BetLine betLine = linkedHashMap.get(num);
                if (!hashSet.contains(Integer.valueOf(betLine.type))) {
                    hashSet.add(Integer.valueOf(betLine.type));
                    Button button = new Button(getContext());
                    button.setGravity(17);
                    button.setText(betLine.getMarketName());
                    button.setTextColor(getContext().getResources().getColorStateList(R.color.f21629s));
                    button.setTextSize(1, 12.0f);
                    button.setMaxLines(2);
                    button.setBackgroundResource(p0.w(App.m(), R.attr.J0));
                    button.setTag(Integer.valueOf(betLine.type));
                    if (betLine.type == i10) {
                        button.setSelected(true);
                    }
                    GridLayout.o oVar = new GridLayout.o(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, 1.0f));
                    int s10 = p0.s(4);
                    oVar.setMargins(s10, s10, s10, s10);
                    oVar.d(7);
                    button.setLayoutParams(oVar);
                    button.setMaxWidth((getMeasuredWidth() / 3) - p0.s(8));
                    if (x0.l1()) {
                        button.setRotationY(180.0f);
                    }
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.GridSelector.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (view.isSelected()) {
                                view.setSelected(false);
                            } else {
                                Iterator<Button> it = GridSelector.this.marketButtons.iterator();
                                while (it.hasNext()) {
                                    it.next().setSelected(false);
                                }
                                view.setSelected(true);
                            }
                            if (GridSelector.this.eventsCallback != null) {
                                GridSelector.this.eventsCallback.onMarketSelected(((Integer) view.getTag()).intValue());
                            }
                        }
                    });
                    addView(button);
                    this.marketButtons.add(button);
                    i13++;
                    if (i13 >= i11) {
                        break;
                    }
                }
            }
            int min = Math.min(i13, this.MAX_COLUMNS);
            if (min != 0) {
                i12 = i13 / min;
                if (i13 % min != 0) {
                    i12++;
                }
            }
            int min2 = Math.min(i12, this.MAX_ROWS);
            setColumnCount(min);
            setRowCount(min2);
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }

    public GridSelectorEvents getEventsCallback() {
        return this.eventsCallback;
    }

    public void setEventsCallback(GridSelectorEvents gridSelectorEvents) {
        this.eventsCallback = gridSelectorEvents;
    }
}
