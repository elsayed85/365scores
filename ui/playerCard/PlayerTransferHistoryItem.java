package com.scores365.ui.playerCard;

import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.PageObjects.f;
import com.scores365.Design.Pages.t;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.TransferHistoryObj;
import lf.u;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
/* loaded from: classes2.dex */
public class PlayerTransferHistoryItem extends com.scores365.Design.PageObjects.b implements f.b {
    public static final int POSITION_FIRST = 1;
    public static final int POSITION_LAST = 3;
    public static final int POSITION_MIDDLE = 2;
    public static final int POSITION_SINGLE = 4;
    private long animationDelay;
    private long animationDuration;
    private int athleteId;
    public CompObj compObj;
    OnCompetitorClickListener competitorClickListener;
    private boolean isHidden;
    private int positionType;
    public TransferHistoryObj transferHistoryObj;
    private String transferSubtitle;
    private boolean shouldAnimate = false;
    private boolean addBottomMargin = false;
    private boolean addTopMargin = false;

    /* loaded from: classes2.dex */
    private static class OnCompetitorClickListener implements View.OnClickListener {
        private int athleteId;
        private CompObj compObj;

        public OnCompetitorClickListener(CompObj compObj, int i10) {
            this.compObj = compObj;
            this.athleteId = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                x0.y2(this.compObj, App.m(), false, "player-card");
                ee.k.n(App.m(), "athlete", "entity", "click", null, true, "athlete_id", String.valueOf(this.athleteId), "section", "transfer-history", "entity_type", "2", "entity_id", String.valueOf(this.compObj.getID()));
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends t {
        ImageView centralDot;
        ImageView competitorLogo;
        TextView competitorName;
        View connectingLineBottom;
        View connectingLineTop;
        TextView transferDate;
        TextView transferName;
        TextView transferPrice;

        public ViewHolder(View view) {
            super(view);
            this.connectingLineBottom = view.findViewById(R.id.U3);
            this.connectingLineTop = view.findViewById(R.id.V3);
            this.centralDot = (ImageView) view.findViewById(R.id.Pa);
            this.competitorLogo = (ImageView) view.findViewById(R.id.f21911bb);
            this.transferName = (TextView) view.findViewById(R.id.yH);
            this.transferDate = (TextView) view.findViewById(R.id.xH);
            this.transferPrice = (TextView) view.findViewById(R.id.zH);
            this.competitorName = (TextView) view.findViewById(R.id.Qx);
            this.transferName.setTypeface(o0.c(App.m()));
            this.transferDate.setTypeface(o0.d(App.m()));
            this.transferPrice.setTypeface(o0.d(App.m()));
            this.competitorName.setTypeface(o0.d(App.m()));
        }
    }

    public PlayerTransferHistoryItem(int i10, TransferHistoryObj transferHistoryObj, CompObj compObj, int i11, boolean z10, long j10, long j11) {
        this.transferHistoryObj = transferHistoryObj;
        this.positionType = i11;
        this.isHidden = z10;
        this.compObj = compObj;
        this.athleteId = i10;
        this.animationDuration = j10;
        this.animationDelay = j11;
        this.competitorClickListener = new OnCompetitorClickListener(compObj, i10);
        this.transferSubtitle = transferHistoryObj.getTransferData(compObj);
    }

    public static ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(x0.l1() ? LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22731v6, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f22719u6, viewGroup, false));
    }

    public void addBottomMargin() {
        this.addBottomMargin = true;
    }

    public void addTopMargin() {
        this.addTopMargin = true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.playerTransferHistoryItem.ordinal();
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        final ViewHolder viewHolder = (ViewHolder) e0Var;
        try {
            int i11 = this.positionType;
            if (i11 == 1) {
                viewHolder.connectingLineTop.setVisibility(8);
                viewHolder.connectingLineBottom.setVisibility(0);
            } else if (i11 == 2) {
                viewHolder.connectingLineTop.setVisibility(0);
                viewHolder.connectingLineBottom.setVisibility(0);
            } else if (i11 == 3) {
                viewHolder.connectingLineTop.setVisibility(0);
                viewHolder.connectingLineBottom.setVisibility(8);
            } else if (i11 == 4) {
                viewHolder.connectingLineTop.setVisibility(8);
                viewHolder.connectingLineBottom.setVisibility(8);
            }
            if (this.transferHistoryObj.isActive()) {
                viewHolder.centralDot.setImageResource(R.drawable.N2);
            } else {
                viewHolder.centralDot.setImageResource(R.drawable.M2);
            }
            if (this.isHidden) {
                ((t) viewHolder).itemView.getLayoutParams().height = 0;
            } else {
                ((t) viewHolder).itemView.getLayoutParams().height = -2;
            }
            String s10 = o.s(p.Competitors, this.compObj.getID(), 70, 70, false, this.compObj.getImgVer());
            ImageView imageView = viewHolder.competitorLogo;
            li.u.A(s10, imageView, li.u.f(imageView.getLayoutParams().width));
            viewHolder.transferName.setText(this.transferHistoryObj.getTransferTitle());
            viewHolder.competitorName.setText(nb.u.b(this.compObj));
            viewHolder.transferPrice.setText(this.transferHistoryObj.getPrice());
            String str = this.transferSubtitle;
            if (str == null || str.isEmpty()) {
                viewHolder.transferDate.setVisibility(8);
            } else {
                viewHolder.transferDate.setText(this.transferSubtitle);
                viewHolder.transferDate.setVisibility(0);
            }
            viewHolder.transferName.setPadding(0, this.addTopMargin ? p0.s(8) : 0, 0, 0);
            viewHolder.transferDate.setPadding(0, 0, 0, this.addBottomMargin ? p0.s(8) : 0);
            viewHolder.competitorLogo.setOnClickListener(this.competitorClickListener);
            viewHolder.competitorName.setOnClickListener(this.competitorClickListener);
            if (!this.shouldAnimate || isHidden()) {
                return;
            }
            this.shouldAnimate = false;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(this.animationDuration);
            ofFloat.setStartDelay(this.animationDelay);
            ((t) viewHolder).itemView.setAlpha(0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scores365.ui.playerCard.PlayerTransferHistoryItem.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    try {
                        ((t) viewHolder).itemView.setAlpha(valueAnimator.getAnimatedFraction());
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            });
            ofFloat.start();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.scores365.Design.PageObjects.f.b
    public void setHidden(boolean z10) {
        this.isHidden = z10;
    }

    @Override // com.scores365.Design.PageObjects.f.b
    public void setShouldAnimate(boolean z10) {
        this.shouldAnimate = z10;
    }
}
