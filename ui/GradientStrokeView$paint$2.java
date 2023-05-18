package com.scores365.ui;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.jvm.functions.Function0;
/* compiled from: GradientStrokeView.kt */
/* loaded from: classes2.dex */
final class GradientStrokeView$paint$2 extends kotlin.jvm.internal.n implements Function0<Paint> {
    final /* synthetic */ GradientStrokeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GradientStrokeView$paint$2(GradientStrokeView gradientStrokeView) {
        super(0);
        this.this$0 = gradientStrokeView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Paint invoke() {
        Paint paint = new Paint();
        GradientStrokeView gradientStrokeView = this.this$0;
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, gradientStrokeView.getHeight(), gradientStrokeView.getTopColor(), gradientStrokeView.getBottomColor(), Shader.TileMode.MIRROR));
        return paint;
    }
}
