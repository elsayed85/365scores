package com.scores365.ui.tooltips;

import android.widget.PopupWindow;
import hj.o;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import wj.n0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolTipFactory.kt */
@f(c = "com.scores365.ui.tooltips.ToolTipFactory$showToolTip$1", f = "ToolTipFactory.kt", l = {144}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ToolTipFactory$showToolTip$1 extends l implements Function2<n0, d<? super Unit>, Object> {
    final /* synthetic */ long $dismissTime;
    final /* synthetic */ PopupWindow $popup;
    int label;
    final /* synthetic */ ToolTipFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ToolTipFactory.kt */
    /* renamed from: com.scores365.ui.tooltips.ToolTipFactory$showToolTip$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends n implements Function1<PopupWindow, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PopupWindow popupWindow) {
            invoke2(popupWindow);
            return Unit.f33377a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(PopupWindow it) {
            m.g(it, "it");
            it.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTipFactory$showToolTip$1(ToolTipFactory toolTipFactory, PopupWindow popupWindow, long j10, d<? super ToolTipFactory$showToolTip$1> dVar) {
        super(2, dVar);
        this.this$0 = toolTipFactory;
        this.$popup = popupWindow;
        this.$dismissTime = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d<Unit> create(Object obj, d<?> dVar) {
        return new ToolTipFactory$showToolTip$1(this.this$0, this.$popup, this.$dismissTime, dVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, d<? super Unit> dVar) {
        return ((ToolTipFactory$showToolTip$1) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object d10;
        Object startDismissTimer;
        d10 = kj.d.d();
        int i10 = this.label;
        if (i10 == 0) {
            o.b(obj);
            ToolTipFactory toolTipFactory = this.this$0;
            PopupWindow popupWindow = this.$popup;
            long j10 = this.$dismissTime;
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            this.label = 1;
            startDismissTimer = toolTipFactory.startDismissTimer(popupWindow, j10, anonymousClass1, this);
            if (startDismissTimer == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            o.b(obj);
        }
        return Unit.f33377a;
    }
}
