package com.scores365.entitys;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.e1;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.bets.model.BookMakerObj;
import com.scores365.ui.OddsView;
import li.o0;
import li.p0;
import li.x0;
import nb.o;
import sh.a;
/* loaded from: classes2.dex */
public class PlainTitleItemWithSposored extends com.scores365.Design.PageObjects.b {
    private int backgroundColor;
    private BookMakerObj bookMakerObj;
    private GameObj gameObjForAnalytics;
    private String sourceForAnalytics;
    private String sponsored;
    private String title;

    /* loaded from: classes2.dex */
    private static class BookMakerLogoClickListener implements View.OnClickListener {
        BookMakerObj bookMakerObj;
        GameObj gameObj;
        boolean hasInsights;
        boolean hasOdds;
        boolean hasShare;
        boolean isPredictionsItem;
        boolean isSourceLineups;
        boolean isWwwScope;
        String source;

        public BookMakerLogoClickListener(BookMakerObj bookMakerObj, GameObj gameObj, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
            this.bookMakerObj = bookMakerObj;
            this.gameObj = gameObj;
            this.source = str;
            this.isPredictionsItem = z10;
            this.hasOdds = z11;
            this.hasInsights = z12;
            this.hasShare = z13;
            this.isSourceLineups = z14;
            this.isWwwScope = z15;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                a.C0569a c0569a = sh.a.f39207a;
                String g10 = c0569a.g();
                String p10 = c0569a.p(this.bookMakerObj.actionButton.getUrl(), g10);
                je.b.f32619a.i("", this.bookMakerObj.f23582id);
                x0.M1(p10);
                OddsView.sendClickAnalyticsEvent(this.source, this.gameObj, "", "2", this.isPredictionsItem, this.hasOdds, this.hasInsights, this.hasShare, this.isSourceLineups, null, null, false, this.bookMakerObj, p10, this.isWwwScope, -1, g10);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PlainTitleItemWithSposoredViewHolder extends t {
        private ImageView ivBookMakerImage;
        private TextView tvSponsored;
        private TextView tvSubsHeader;

        public PlainTitleItemWithSposoredViewHolder(View view, q.e eVar) {
            super(view);
            this.tvSubsHeader = (TextView) view.findViewById(R.id.iG);
            this.tvSponsored = (TextView) view.findViewById(R.id.pE);
            this.ivBookMakerImage = (ImageView) view.findViewById(R.id.Da);
            this.tvSubsHeader.setTypeface(o0.d(App.m()));
            this.tvSponsored.setTypeface(o0.d(App.m()));
            ((t) this).itemView.setOnClickListener(new u(this, eVar));
            ((t) this).itemView.setLayoutDirection(x0.l1() ? 1 : 0);
        }

        @Override // com.scores365.Design.Pages.t
        public boolean isSupportRTL() {
            return true;
        }
    }

    public PlainTitleItemWithSposored(String str, int i10, BookMakerObj bookMakerObj, String str2, GameObj gameObj, boolean z10) {
        this.sponsored = "";
        this.bookMakerObj = null;
        this.sourceForAnalytics = "";
        this.title = str;
        this.backgroundColor = i10;
        this.sponsored = z10 ? p0.l0("SPONSORED_AD_BETTING") : "";
        this.bookMakerObj = bookMakerObj;
        this.sourceForAnalytics = str2;
        this.gameObjForAnalytics = gameObj;
    }

    public static PlainTitleItemWithSposoredViewHolder onCreateViewHolder(ViewGroup viewGroup, q.e eVar) {
        return new PlainTitleItemWithSposoredViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.T5, viewGroup, false), eVar);
    }

    @Override // com.scores365.Design.PageObjects.c
    public long getItemId() {
        try {
            String str = this.title;
            return str != null ? (str.hashCode() * lf.u.values().length) + getObjectTypeNum() : super.getItemId();
        } catch (Exception e10) {
            x0.N1(e10);
            return 1L;
        }
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.PlainTitleItemWithSposored.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public boolean isFullSpanWidthSize() {
        return true;
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        try {
            PlainTitleItemWithSposoredViewHolder plainTitleItemWithSposoredViewHolder = (PlainTitleItemWithSposoredViewHolder) e0Var;
            String str = this.title;
            if (str == null || str.isEmpty()) {
                plainTitleItemWithSposoredViewHolder.tvSubsHeader.setText("");
            } else {
                plainTitleItemWithSposoredViewHolder.tvSubsHeader.setText(this.title);
            }
            if (this.sponsored != null) {
                plainTitleItemWithSposoredViewHolder.tvSponsored.setText(this.sponsored);
            } else {
                plainTitleItemWithSposoredViewHolder.tvSponsored.setText("");
            }
            plainTitleItemWithSposoredViewHolder.tvSubsHeader.setGravity(8388691);
            plainTitleItemWithSposoredViewHolder.tvSponsored.setGravity(8388693);
            int i11 = this.backgroundColor;
            if (i11 != -1) {
                ((t) plainTitleItemWithSposoredViewHolder).itemView.setBackgroundColor(i11);
                e1.C0(((t) plainTitleItemWithSposoredViewHolder).itemView, App.m().getResources().getDimension(androidx.cardview.R.dimen.f3942a));
            } else {
                ((t) plainTitleItemWithSposoredViewHolder).itemView.setBackgroundResource(0);
                e1.C0(((t) plainTitleItemWithSposoredViewHolder).itemView, 0.0f);
            }
            Boolean g10 = ke.a.f33223a.g();
            if (this.bookMakerObj == null || g10 == null || g10.booleanValue()) {
                plainTitleItemWithSposoredViewHolder.ivBookMakerImage.setImageResource(0);
                return;
            }
            BookMakerObj bookMakerObj = this.bookMakerObj;
            li.u.x(o.f(bookMakerObj.f23582id, bookMakerObj.getImgVer()), plainTitleItemWithSposoredViewHolder.ivBookMakerImage);
            if (x0.l1()) {
                plainTitleItemWithSposoredViewHolder.ivBookMakerImage.setScaleType(ImageView.ScaleType.FIT_START);
            } else {
                plainTitleItemWithSposoredViewHolder.ivBookMakerImage.setScaleType(ImageView.ScaleType.FIT_END);
            }
            plainTitleItemWithSposoredViewHolder.tvSponsored.setText("");
            plainTitleItemWithSposoredViewHolder.ivBookMakerImage.setOnClickListener(new BookMakerLogoClickListener(this.bookMakerObj, this.gameObjForAnalytics, this.sourceForAnalytics, true, false, false, false, false, true));
        } catch (Resources.NotFoundException e10) {
            x0.N1(e10);
        }
    }
}
