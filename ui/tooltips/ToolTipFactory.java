package com.scores365.ui.tooltips;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import hj.h;
import hj.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import rf.o2;
import wj.d1;
import wj.k;
import wj.o0;
/* compiled from: ToolTipFactory.kt */
/* loaded from: classes2.dex */
public final class ToolTipFactory {
    private static boolean isForceDismissed;
    private static boolean isPopupShown;
    private static PopupWindow popupWindow;
    private final h binding$delegate;
    private Function0<Unit> clickBlock;
    public static final Companion Companion = new Companion(null);
    private static int tag = -1;

    /* compiled from: ToolTipFactory.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearForcedDismiss() {
            ToolTipFactory.isForceDismissed = false;
            setTag(-1);
        }

        public final void dismissPopup() {
            ToolTipFactory.isForceDismissed = true;
            PopupWindow popupWindow = ToolTipFactory.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }

        public final int getTag() {
            return ToolTipFactory.tag;
        }

        public final boolean isPopupShown() {
            return ToolTipFactory.isPopupShown;
        }

        public final void setPopupShown(boolean z10) {
            ToolTipFactory.isPopupShown = z10;
        }

        public final void setTag(int i10) {
            ToolTipFactory.tag = i10;
        }
    }

    /* compiled from: ToolTipFactory.kt */
    /* loaded from: classes2.dex */
    public interface ToolTipDismissListener {
        void onDismissed();
    }

    /* compiled from: ToolTipFactory.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OffsetTypeX.values().length];
            try {
                iArr[OffsetTypeX.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OffsetTypeX.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OffsetTypeX.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OffsetTypeX.START_DIMEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OffsetTypeX.END_DIMEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OffsetTypeY.values().length];
            try {
                iArr2[OffsetTypeY.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OffsetTypeY.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[OffsetTypeY.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[OffsetTypeY.TOP_DIMEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[OffsetTypeY.BOTTOM_DIMEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ToolTipFactory(Context context) {
        h b10;
        m.g(context, "context");
        b10 = j.b(new ToolTipFactory$binding$2(context));
        this.binding$delegate = b10;
        this.clickBlock = ToolTipFactory$clickBlock$1.INSTANCE;
    }

    private final o2 getBinding() {
        return (o2) this.binding$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToolTip$lambda$5$lambda$3(ToolTipFactory this$0, ToolTipData data) {
        m.g(this$0, "this$0");
        m.g(data, "$data");
        this$0.clear();
        ToolTipDismissListener dismissListener = data.getDismissListener();
        if (dismissListener != null) {
            dismissListener.onDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToolTip$lambda$5$lambda$4(ToolTipFactory this$0, ToolTipData data, View view) {
        m.g(this$0, "this$0");
        m.g(data, "$data");
        this$0.clickBlock.invoke();
        data.getClickListener().onClick(view);
        Companion.dismissPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object startDismissTimer(android.widget.PopupWindow r5, long r6, kotlin.jvm.functions.Function1<? super android.widget.PopupWindow, kotlin.Unit> r8, kotlin.coroutines.d<? super kotlin.Unit> r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.scores365.ui.tooltips.ToolTipFactory$startDismissTimer$1
            if (r0 == 0) goto L13
            r0 = r9
            com.scores365.ui.tooltips.ToolTipFactory$startDismissTimer$1 r0 = (com.scores365.ui.tooltips.ToolTipFactory$startDismissTimer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.scores365.ui.tooltips.ToolTipFactory$startDismissTimer$1 r0 = new com.scores365.ui.tooltips.ToolTipFactory$startDismissTimer$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kj.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            r8 = r5
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r5 = r0.L$0
            android.widget.PopupWindow r5 = (android.widget.PopupWindow) r5
            hj.o.b(r9)
            goto L4a
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            hj.o.b(r9)
            r0.L$0 = r5
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = wj.x0.a(r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r8.invoke(r5)
            kotlin.Unit r5 = kotlin.Unit.f33377a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.tooltips.ToolTipFactory.startDismissTimer(android.widget.PopupWindow, long, kotlin.jvm.functions.Function1, kotlin.coroutines.d):java.lang.Object");
    }

    public final void clear() {
        isPopupShown = false;
        if (isForceDismissed) {
            return;
        }
        k.d(o0.a(d1.b()), null, null, new ToolTipFactory$clear$1(null), 3, null);
    }

    public final ToolTipDimensions createDimensions() {
        getBinding().getRoot().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new ToolTipDimensions(getBinding().getRoot().getMeasuredWidth(), getBinding().getRoot().getMeasuredHeight());
    }

    public final Function0<Unit> getClickBlock() {
        return this.clickBlock;
    }

    public final void setClickBlock(Function0<Unit> function0) {
        m.g(function0, "<set-?>");
        this.clickBlock = function0;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showToolTip(final com.scores365.ui.tooltips.ToolTipData r24) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.tooltips.ToolTipFactory.showToolTip(com.scores365.ui.tooltips.ToolTipData):void");
    }
}
