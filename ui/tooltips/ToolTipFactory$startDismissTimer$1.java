package com.scores365.ui.tooltips;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolTipFactory.kt */
@f(c = "com.scores365.ui.tooltips.ToolTipFactory", f = "ToolTipFactory.kt", l = {164}, m = "startDismissTimer")
/* loaded from: classes2.dex */
public final class ToolTipFactory$startDismissTimer$1 extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ToolTipFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTipFactory$startDismissTimer$1(ToolTipFactory toolTipFactory, kotlin.coroutines.d<? super ToolTipFactory$startDismissTimer$1> dVar) {
        super(dVar);
        this.this$0 = toolTipFactory;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object startDismissTimer;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        startDismissTimer = this.this$0.startDismissTimer(null, 0L, null, this);
        return startDismissTimer;
    }
}
