package com.scores365.ui.tooltips;

import hj.o;
import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.functions.Function2;
import wj.n0;
import wj.x0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolTipFactory.kt */
@f(c = "com.scores365.ui.tooltips.ToolTipFactory$clear$1", f = "ToolTipFactory.kt", l = {155}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ToolTipFactory$clear$1 extends l implements Function2<n0, d<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolTipFactory$clear$1(d<? super ToolTipFactory$clear$1> dVar) {
        super(2, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final d<Unit> create(Object obj, d<?> dVar) {
        return new ToolTipFactory$clear$1(dVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, d<? super Unit> dVar) {
        return ((ToolTipFactory$clear$1) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object d10;
        d10 = kj.d.d();
        int i10 = this.label;
        if (i10 == 0) {
            o.b(obj);
            this.label = 1;
            if (x0.a(200L, this) == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            o.b(obj);
        }
        ToolTipFactory.Companion.setTag(-1);
        return Unit.f33377a;
    }
}
