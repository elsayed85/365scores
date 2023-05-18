package com.scores365.ui.playerCard;

import com.scores365.entitys.AthleteObj;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import wj.n0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SinglePlayerFutureMatchCoroutine.kt */
@kotlin.coroutines.jvm.internal.f(c = "com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1", f = "SinglePlayerFutureMatchCoroutine.kt", l = {41}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1 extends kotlin.coroutines.jvm.internal.l implements Function2<n0, kotlin.coroutines.d<? super Unit>, Object> {
    final /* synthetic */ AthleteObj $athlete;
    final /* synthetic */ SinglePlayerProfilePageCreator $pageCreator;
    int I$0;
    int label;
    final /* synthetic */ SinglePlayerFutureMatchCoroutine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1(SinglePlayerFutureMatchCoroutine singlePlayerFutureMatchCoroutine, AthleteObj athleteObj, SinglePlayerProfilePageCreator singlePlayerProfilePageCreator, kotlin.coroutines.d<? super SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1> dVar) {
        super(2, dVar);
        this.this$0 = singlePlayerFutureMatchCoroutine;
        this.$athlete = athleteObj;
        this.$pageCreator = singlePlayerProfilePageCreator;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final kotlin.coroutines.d<Unit> create(Object obj, kotlin.coroutines.d<?> dVar) {
        return new SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1(this.this$0, this.$athlete, this.$pageCreator, dVar);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, kotlin.coroutines.d<? super Unit> dVar) {
        return ((SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1) create(n0Var, dVar)).invokeSuspend(Unit.f33377a);
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0028 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[Catch: Exception -> 0x0013, TryCatch #0 {Exception -> 0x0013, blocks: (B:6:0x000e, B:24:0x007b, B:13:0x0022, B:15:0x002a, B:17:0x004a, B:19:0x0061, B:20:0x0068, B:21:0x006e, B:26:0x007f), top: B:31:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[Catch: Exception -> 0x0013, TRY_LEAVE, TryCatch #0 {Exception -> 0x0013, blocks: (B:6:0x000e, B:24:0x007b, B:13:0x0022, B:15:0x002a, B:17:0x004a, B:19:0x0061, B:20:0x0068, B:21:0x006e, B:26:0x007f), top: B:31:0x000e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0078 -> B:24:0x007b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kj.b.d()
            int r1 = r8.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1d
            if (r1 != r3) goto L15
            int r1 = r8.I$0
            hj.o.b(r9)     // Catch: java.lang.Exception -> L13
            r9 = r8
            goto L7b
        L13:
            r9 = move-exception
            goto L85
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1d:
            hj.o.b(r9)
            r1 = 0
            r9 = r8
        L22:
            com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine r4 = r9.this$0     // Catch: java.lang.Exception -> L13
            boolean r4 = com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine.access$getShouldRunRequest$p(r4)     // Catch: java.lang.Exception -> L13
            if (r4 == 0) goto L88
            com.scores365.api.b r4 = new com.scores365.api.b     // Catch: java.lang.Exception -> L13
            android.content.Context r5 = com.scores365.App.m()     // Catch: java.lang.Exception -> L13
            java.lang.String r6 = "getInstance()"
            kotlin.jvm.internal.m.f(r5, r6)     // Catch: java.lang.Exception -> L13
            com.scores365.entitys.AthleteObj r6 = r9.$athlete     // Catch: java.lang.Exception -> L13
            java.lang.String r6 = r6.nextMatchApiURL     // Catch: java.lang.Exception -> L13
            java.lang.String r7 = "athlete.nextMatchApiURL"
            kotlin.jvm.internal.m.f(r6, r7)     // Catch: java.lang.Exception -> L13
            r4.<init>(r5, r6)     // Catch: java.lang.Exception -> L13
            r4.call()     // Catch: java.lang.Exception -> L13
            boolean r5 = r4.isRequestSuccess()     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L6e
            com.scores365.ui.playerCard.SinglePlayerProfilePageCreator r5 = r9.$pageCreator     // Catch: java.lang.Exception -> L13
            com.scores365.entitys.GamesObj r6 = r4.a()     // Catch: java.lang.Exception -> L13
            r5.setFutureMatch(r6)     // Catch: java.lang.Exception -> L13
            com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine r5 = r9.this$0     // Catch: java.lang.Exception -> L13
            java.lang.ref.WeakReference r5 = com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine.access$getActivityRef$p(r5)     // Catch: java.lang.Exception -> L13
            java.lang.Object r5 = r5.get()     // Catch: java.lang.Exception -> L13
            com.scores365.ui.playerCard.SinglePlayerCardActivity r5 = (com.scores365.ui.playerCard.SinglePlayerCardActivity) r5     // Catch: java.lang.Exception -> L13
            if (r5 == 0) goto L68
            com.scores365.entitys.GamesObj r4 = r4.a()     // Catch: java.lang.Exception -> L13
            r5.insertFutureMatch(r4)     // Catch: java.lang.Exception -> L13
        L68:
            com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine r4 = r9.this$0     // Catch: java.lang.Exception -> L13
            com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine.access$setShouldRunRequest$p(r4, r2)     // Catch: java.lang.Exception -> L13
            goto L22
        L6e:
            r9.I$0 = r1     // Catch: java.lang.Exception -> L13
            r9.label = r3     // Catch: java.lang.Exception -> L13
            r4 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r4 = wj.x0.a(r4, r9)     // Catch: java.lang.Exception -> L13
            if (r4 != r0) goto L7b
            return r0
        L7b:
            int r1 = r1 + r3
            r4 = 5
            if (r1 < r4) goto L22
            com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine r4 = r9.this$0     // Catch: java.lang.Exception -> L13
            com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine.access$setShouldRunRequest$p(r4, r2)     // Catch: java.lang.Exception -> L13
            goto L22
        L85:
            li.x0.N1(r9)
        L88:
            kotlin.Unit r9 = kotlin.Unit.f33377a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.playerCard.SinglePlayerFutureMatchCoroutine$fetchFutureMatchAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
