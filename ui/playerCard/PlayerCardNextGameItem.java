package com.scores365.ui.playerCard;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.scores365.Design.Pages.q;
import com.scores365.Design.Pages.t;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lf.u;
import li.x0;
import rf.w1;
import sg.d;
/* compiled from: PlayerCardNextGameItem.kt */
/* loaded from: classes2.dex */
public final class PlayerCardNextGameItem extends sg.d {
    public static final Companion Companion = new Companion(null);
    private Companion.InjurySuspensionStatusItemData injuryData;

    /* compiled from: PlayerCardNextGameItem.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* compiled from: PlayerCardNextGameItem.kt */
        /* loaded from: classes2.dex */
        public static final class InjurySuspensionStatusItemData {
            private String iconLink;
            private int iconResource;
            private String message;
            private String messageSecondary;

            public InjurySuspensionStatusItemData() {
                this(null, null, 0, null, 15, null);
            }

            public InjurySuspensionStatusItemData(String str, String str2, int i10, String str3) {
                this.message = str;
                this.messageSecondary = str2;
                this.iconResource = i10;
                this.iconLink = str3;
            }

            public /* synthetic */ InjurySuspensionStatusItemData(String str, String str2, int i10, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str3);
            }

            public final String getIconLink() {
                return this.iconLink;
            }

            public final int getIconResource() {
                return this.iconResource;
            }

            public final String getMessage() {
                return this.message;
            }

            public final String getMessageSecondary() {
                return this.messageSecondary;
            }

            public final void setIconLink(String str) {
                this.iconLink = str;
            }

            public final void setIconResource(int i10) {
                this.iconResource = i10;
            }

            public final void setMessage(String str) {
                this.message = str;
            }

            public final void setMessageSecondary(String str) {
                this.messageSecondary = str;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: PlayerCardNextGameItem.kt */
        /* loaded from: classes2.dex */
        public static final class ViewHolder extends d.a.b {
            private final w1 binding;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ViewHolder(rf.w1 r3, com.scores365.Design.Pages.q.e r4) {
                /*
                    r2 = this;
                    java.lang.String r0 = "binding"
                    kotlin.jvm.internal.m.g(r3, r0)
                    androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
                    java.lang.String r1 = "binding.root"
                    kotlin.jvm.internal.m.f(r0, r1)
                    r2.<init>(r0, r4)
                    r2.binding = r3
                    rf.c1 r3 = r3.f38099h
                    android.widget.TextView r4 = r3.f37603d
                    android.graphics.Typeface r0 = nb.v.m()
                    r4.setTypeface(r0)
                    android.widget.TextView r4 = r3.f37604e
                    android.graphics.Typeface r0 = nb.v.m()
                    r4.setTypeface(r0)
                    android.widget.ImageView r4 = r3.f37601b
                    android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                    java.lang.String r0 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
                    kotlin.jvm.internal.m.e(r4, r0)
                    androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4
                    r0 = 1056964608(0x3f000000, float:0.5)
                    r4.G = r0
                    androidx.constraintlayout.widget.ConstraintLayout r3 = r3.getRoot()
                    r4 = 0
                    r3.setBackgroundResource(r4)
                    java.lang.String r4 = "lambda$2$lambda$1$lambda$0"
                    kotlin.jvm.internal.m.f(r3, r4)
                    nb.v.u(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.PlayerCardNextGameItem.Companion.ViewHolder.<init>(rf.w1, com.scores365.Design.Pages.q$e):void");
            }

            public final w1 getBinding() {
                return this.binding;
            }

            /* JADX WARN: Removed duplicated region for block: B:48:0x00b5  */
            /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
            @Override // sg.d.a.b, com.scores365.dashboardEntities.dashboardScores.g.a, com.scores365.dashboardEntities.dashboardScores.f.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void updateViewHolder(com.scores365.dashboardEntities.dashboardScores.f r4, boolean r5, boolean r6, boolean r7) {
                /*
                    r3 = this;
                    java.lang.String r0 = "absItem"
                    kotlin.jvm.internal.m.g(r4, r0)
                    r0 = 1
                    r1 = 0
                    if (r5 == 0) goto L15
                    com.scores365.entitys.GameObj r5 = r4.getGameObj()
                    boolean r5 = r5.isEditorsChoice()
                    if (r5 != 0) goto L15
                    r5 = 1
                    goto L16
                L15:
                    r5 = 0
                L16:
                    super.updateViewHolder(r4, r5, r6, r7)
                    boolean r5 = r4 instanceof com.scores365.ui.playerCard.PlayerCardNextGameItem
                    if (r5 == 0) goto Ldf
                    com.scores365.ui.playerCard.PlayerCardNextGameItem r4 = (com.scores365.ui.playerCard.PlayerCardNextGameItem) r4
                    com.scores365.ui.playerCard.PlayerCardNextGameItem$Companion$InjurySuspensionStatusItemData r5 = r4.getInjuryData()
                    if (r5 == 0) goto Lc7
                    com.scores365.ui.playerCard.PlayerCardNextGameItem$Companion$InjurySuspensionStatusItemData r4 = r4.getInjuryData()
                    if (r4 == 0) goto Ldf
                    rf.w1 r5 = r3.binding
                    rf.c1 r5 = r5.f38099h
                    android.widget.TextView r6 = r5.f37603d
                    java.lang.String r7 = r4.getMessage()
                    r6.setText(r7)
                    java.lang.String r7 = r4.getMessage()
                    if (r7 == 0) goto L47
                    int r7 = r7.length()
                    if (r7 != 0) goto L45
                    goto L47
                L45:
                    r7 = 0
                    goto L48
                L47:
                    r7 = 1
                L48:
                    r2 = 8
                    if (r7 == 0) goto L4f
                    r7 = 8
                    goto L50
                L4f:
                    r7 = 0
                L50:
                    r6.setVisibility(r7)
                    android.widget.TextView r6 = r5.f37604e
                    java.lang.String r7 = r4.getMessageSecondary()
                    r6.setText(r7)
                    java.lang.String r7 = r4.getMessageSecondary()
                    if (r7 == 0) goto L6b
                    int r7 = r7.length()
                    if (r7 != 0) goto L69
                    goto L6b
                L69:
                    r7 = 0
                    goto L6c
                L6b:
                    r7 = 1
                L6c:
                    if (r7 == 0) goto L6f
                    goto L70
                L6f:
                    r2 = 0
                L70:
                    r6.setVisibility(r2)
                    java.lang.String r6 = r4.getIconLink()
                    if (r6 == 0) goto L93
                    java.lang.String r6 = r4.getIconLink()
                    if (r6 == 0) goto L87
                    int r6 = r6.length()
                    if (r6 != 0) goto L86
                    goto L87
                L86:
                    r0 = 0
                L87:
                    if (r0 != 0) goto L93
                    java.lang.String r4 = r4.getIconLink()
                    android.widget.ImageView r6 = r5.f37601b
                    li.u.x(r4, r6)
                    goto L9c
                L93:
                    android.widget.ImageView r6 = r5.f37601b
                    int r4 = r4.getIconResource()
                    r6.setImageResource(r4)
                L9c:
                    androidx.constraintlayout.widget.ConstraintLayout r4 = r5.getRoot()
                    r4.setVisibility(r1)
                    rf.w1 r4 = r3.binding
                    android.view.View r4 = r4.f38097f
                    r4.setVisibility(r1)
                    android.view.View r4 = r3.itemView
                    android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                    int r4 = r4.height
                    r5 = -1
                    if (r4 <= r5) goto Ldf
                    android.view.View r4 = r3.itemView
                    android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                    int r5 = r4.height
                    r6 = 22
                    int r6 = nb.v.d(r6)
                    int r5 = r5 + r6
                    r4.height = r5
                    goto Ldf
                Lc7:
                    rf.w1 r4 = r3.binding
                    rf.c1 r4 = r4.f38099h
                    androidx.constraintlayout.widget.ConstraintLayout r4 = r4.getRoot()
                    android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                    r4.height = r1
                    rf.w1 r4 = r3.binding
                    android.view.View r4 = r4.f38097f
                    android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
                    r4.height = r1
                Ldf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.PlayerCardNextGameItem.Companion.ViewHolder.updateViewHolder(com.scores365.dashboardEntities.dashboardScores.f, boolean, boolean, boolean):void");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t onCreateViewHolder(ViewGroup parent, q.e eVar) {
            kotlin.jvm.internal.m.g(parent, "parent");
            try {
                w1 c10 = w1.c(LayoutInflater.from(parent.getContext()), parent, false);
                kotlin.jvm.internal.m.f(c10, "inflate(LayoutInflater.f….context), parent, false)");
                return new ViewHolder(c10, eVar);
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
    }

    public PlayerCardNextGameItem(GameObj gameObj, CompetitionObj competitionObj, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, Locale locale) {
        super(gameObj, competitionObj, z10, z11, z12, z13, z14, z15, locale);
    }

    public final Companion.InjurySuspensionStatusItemData getInjuryData() {
        return this.injuryData;
    }

    @Override // sg.d, com.scores365.dashboardEntities.dashboardScores.g, com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.PlayerCardNextGameItem.ordinal();
    }

    public final void setInjuryData(Companion.InjurySuspensionStatusItemData injurySuspensionStatusItemData) {
        this.injuryData = injurySuspensionStatusItemData;
    }
}
