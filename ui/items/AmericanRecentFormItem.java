package com.scores365.ui.items;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.Design.Pages.u;
import com.scores365.R;
import com.scores365.entitys.AtsRecords;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.GameObj;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import li.p0;
import li.x0;
import nb.o;
import nb.p;
import nb.v;
import rf.d;
/* compiled from: AmericanRecentFormItem.kt */
/* loaded from: classes2.dex */
public final class AmericanRecentFormItem extends b {
    public static final Companion Companion = new Companion(null);
    private final int competitorNum;
    private final GameObj gameObj;
    private final ItemType itemType;

    /* compiled from: AmericanRecentFormItem.kt */
    /* loaded from: classes2.dex */
    public static final class AmericanRecentFormViewHolder extends t {
        private final d binding;
        private final q.e itemClickListener;

        /* compiled from: AmericanRecentFormItem.kt */
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ItemType.values().length];
                try {
                    iArr[ItemType.DATA.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ItemType.TITLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AmericanRecentFormViewHolder(d binding, q.e eVar) {
            super(binding.getRoot());
            m.g(binding, "binding");
            this.binding = binding;
            this.itemClickListener = eVar;
            binding.getRoot().setOnClickListener(new u(this, eVar));
        }

        public final void bind(GameObj gameObj, ItemType itemType, int i10) {
            int r10;
            int r11;
            m.g(gameObj, "gameObj");
            m.g(itemType, "itemType");
            try {
                if (x0.l1()) {
                    this.binding.getRoot().setLayoutDirection(1);
                }
                d dVar = this.binding;
                AtsRecords atsRecords = gameObj.atsRecords;
                int i11 = WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()];
                if (i11 != 1) {
                    if (i11 != 2) {
                        return;
                    }
                    dVar.f37611b.setVisibility(4);
                    dVar.f37612c.setVisibility(4);
                    dVar.getRoot().getLayoutParams().height = p0.s(32);
                    TextParams textParams = new TextParams(p0.A(R.attr.f21565m1), v.l());
                    List<BaseObj> columns = atsRecords.getColumns();
                    r11 = s.r(columns, 10);
                    ArrayList arrayList = new ArrayList(r11);
                    for (BaseObj baseObj : columns) {
                        arrayList.add(baseObj.getName());
                    }
                    initContainerViews(arrayList, textParams);
                    return;
                }
                dVar.f37611b.setVisibility(0);
                dVar.f37612c.setVisibility(0);
                dVar.getRoot().getLayoutParams().height = p0.s(40);
                TextParams textParams2 = new TextParams(p0.A(R.attr.U0), v.m());
                List<AtsRecords.Row.Value> values = atsRecords.getRows().get(i10).getValues();
                r10 = s.r(values, 10);
                ArrayList arrayList2 = new ArrayList(r10);
                for (AtsRecords.Row.Value value : values) {
                    arrayList2.add(value.getValue());
                }
                initContainerViews(arrayList2, textParams2);
                li.u.y(o.s(p.Competitors, gameObj.getComps()[i10].getID(), 70, 70, false, gameObj.getComps()[i10].getImgVer()), dVar.f37611b, p0.w(App.m(), R.attr.f21594w0));
                TextView tvTeamName = dVar.f37612c;
                m.f(tvTeamName, "tvTeamName");
                CompObj compObj = gameObj.getComps()[i10];
                m.f(compObj, "gameObj.comps[competitorNum]");
                v.v(tvTeamName, nb.u.b(compObj), v.m());
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        public final q.e getItemClickListener() {
            return this.itemClickListener;
        }

        public final void initContainerViews(List<String> values, TextParams textParams) {
            m.g(values, "values");
            m.g(textParams, "textParams");
            try {
                this.binding.f37613d.removeAllViews();
                for (String str : values) {
                    d dVar = this.binding;
                    TextView textView = new TextView(App.m());
                    textView.setTextColor(textParams.getTextColor());
                    v.v(textView, str, textParams.getTypeface());
                    textView.setLayoutParams(new LinearLayout.LayoutParams(p0.s(70), -1, 1.0f));
                    textView.setGravity(17);
                    textView.setTextSize(1, 12.0f);
                    dVar.f37613d.addView(textView);
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* compiled from: AmericanRecentFormItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t onCreateViewHolder(ViewGroup parent, q.e eVar) {
            m.g(parent, "parent");
            d c10 = d.c(LayoutInflater.from(parent.getContext()), parent, false);
            m.f(c10, "inflate(\n               …rent, false\n            )");
            return new AmericanRecentFormViewHolder(c10, eVar);
        }
    }

    /* compiled from: AmericanRecentFormItem.kt */
    /* loaded from: classes2.dex */
    public enum ItemType {
        DATA,
        TITLE
    }

    /* compiled from: AmericanRecentFormItem.kt */
    /* loaded from: classes2.dex */
    public static final class TextParams {
        private final int textColor;
        private final Typeface typeface;

        public TextParams(int i10, Typeface typeface) {
            m.g(typeface, "typeface");
            this.textColor = i10;
            this.typeface = typeface;
        }

        public static /* synthetic */ TextParams copy$default(TextParams textParams, int i10, Typeface typeface, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = textParams.textColor;
            }
            if ((i11 & 2) != 0) {
                typeface = textParams.typeface;
            }
            return textParams.copy(i10, typeface);
        }

        public final int component1() {
            return this.textColor;
        }

        public final Typeface component2() {
            return this.typeface;
        }

        public final TextParams copy(int i10, Typeface typeface) {
            m.g(typeface, "typeface");
            return new TextParams(i10, typeface);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TextParams) {
                TextParams textParams = (TextParams) obj;
                return this.textColor == textParams.textColor && m.b(this.typeface, textParams.typeface);
            }
            return false;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final Typeface getTypeface() {
            return this.typeface;
        }

        public int hashCode() {
            return (this.textColor * 31) + this.typeface.hashCode();
        }

        public String toString() {
            return "TextParams(textColor=" + this.textColor + ", typeface=" + this.typeface + ')';
        }
    }

    public AmericanRecentFormItem(GameObj gameObj, ItemType itemType, int i10) {
        m.g(gameObj, "gameObj");
        m.g(itemType, "itemType");
        this.gameObj = gameObj;
        this.itemType = itemType;
        this.competitorNum = i10;
    }

    public /* synthetic */ AmericanRecentFormItem(GameObj gameObj, ItemType itemType, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(gameObj, itemType, (i11 & 4) != 0 ? -1 : i10);
    }

    public final int getCompetitorNum() {
        return this.competitorNum;
    }

    public final GameObj getGameObj() {
        return this.gameObj;
    }

    @Override // com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return lf.u.AmericanRecentFormItem.ordinal();
    }

    @Override // com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        if (e0Var instanceof AmericanRecentFormViewHolder) {
            ((AmericanRecentFormViewHolder) e0Var).bind(this.gameObj, this.itemType, this.competitorNum);
        }
    }
}
