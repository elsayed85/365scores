package com.scores365.ui.tooltips;

import android.content.Context;
import android.view.LayoutInflater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.n;
import rf.o2;
/* compiled from: ToolTipFactory.kt */
/* loaded from: classes2.dex */
final class ToolTipFactory$binding$2 extends n implements Function0<o2> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTipFactory$binding$2(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final o2 invoke() {
        return o2.c(LayoutInflater.from(this.$context));
    }
}
