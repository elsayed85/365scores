package com.scores365.didomi;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.Design.Activities.d;
import com.scores365.didomi.DidomiNoticeActivity;
import com.scores365.entitys.LanguageObj;
import ee.k;
import io.didomi.sdk.Didomi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.x;
import li.o0;
import li.p0;
import li.x0;
import rf.q0;
/* compiled from: DidomiNoticeActivity.kt */
/* loaded from: classes2.dex */
public final class DidomiNoticeActivity extends d {
    public static final a G = new a(null);
    private static boolean H;
    private q0 F;

    /* compiled from: DidomiNoticeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return DidomiNoticeActivity.H;
        }
    }

    /* compiled from: DidomiNoticeActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View p02) {
            m.g(p02, "p0");
            try {
                Didomi.Companion.getInstance().showPreferences(DidomiNoticeActivity.this, Didomi.VIEW_VENDORS);
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    private final void b1(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new b(), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(x userType, DidomiNoticeActivity this$0, View view) {
        m.g(userType, "$userType");
        m.g(this$0, "this$0");
        try {
            Context m10 = App.m();
            String[] strArr = new String[6];
            strArr[0] = "user_type";
            strArr[1] = (String) userType.f33463a;
            strArr[2] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[3] = sf.b.X1().r0() == 1 ? "wizard" : "dashboard";
            strArr[4] = "click_type";
            strArr[5] = "approve";
            k.q(m10, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "permission", "click", true, strArr);
            sf.b.X1().k6(true);
            Didomi.Companion.getInstance().setUserAgreeToAll();
            tf.b.f39719a.b();
            this$0.finish();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(DidomiNoticeActivity this$0, x userType, View view) {
        String str = "wizard";
        m.g(this$0, "this$0");
        m.g(userType, "$userType");
        try {
            Didomi.Companion companion = Didomi.Companion;
            companion.getInstance().addEventListener(new tf.a(this$0, (String) userType.f33463a, "wizard"));
            Didomi.showPreferences$default(companion.getInstance(), this$0, null, 2, null);
            Context m10 = App.m();
            String[] strArr = new String[6];
            strArr[0] = "user_type";
            strArr[1] = (String) userType.f33463a;
            strArr[2] = ShareConstants.FEED_SOURCE_PARAM;
            if (sf.b.X1().r0() != 1) {
                str = "dashboard";
            }
            strArr[3] = str;
            strArr[4] = "click_type";
            strArr[5] = "settings";
            k.q(m10, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "permission", "click", true, strArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private final void g1(TextView textView, String str) {
        try {
            Spanned fromHtml = Html.fromHtml(str);
            m.f(fromHtml, "fromHtml(html)");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            URLSpan[] urls = (URLSpan[]) spannableStringBuilder.getSpans(0, fromHtml.length(), URLSpan.class);
            m.f(urls, "urls");
            for (URLSpan uRLSpan : urls) {
                b1(spannableStringBuilder, uRLSpan);
            }
            textView.setText(spannableStringBuilder);
            textView.setTypeface(o0.d(App.m()));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            q0 c10 = q0.c(getLayoutInflater());
            m.f(c10, "inflate(layoutInflater)");
            this.F = c10;
            q0 q0Var = null;
            if (c10 == null) {
                m.t("binding");
                c10 = null;
            }
            setContentView(c10.getRoot());
            Didomi.Companion companion = Didomi.Companion;
            Didomi companion2 = companion.getInstance();
            LanguageObj languageObj = App.l().getLanguages().get(Integer.valueOf(sf.a.i0(App.m()).k0()));
            m.d(languageObj);
            String didomiCode = languageObj.getDidomiCode();
            m.f(didomiCode, "App.getInitObj().\n      …serLanguage]!!.didomiCode");
            companion2.updateSelectedLanguage(didomiCode);
            final x xVar = new x();
            int r02 = sf.b.X1().r0();
            String str = "existing";
            T t10 = str;
            if (r02 != -1) {
                t10 = str;
                if (r02 == 1 || r02 == 2) {
                    t10 = "new";
                }
            }
            xVar.f33463a = t10;
            Context m10 = App.m();
            String[] strArr = new String[4];
            strArr[0] = "user_type";
            strArr[1] = (String) xVar.f33463a;
            strArr[2] = ShareConstants.FEED_SOURCE_PARAM;
            strArr[3] = sf.b.X1().r0() == 1 ? "wizard" : "dashboard";
            k.q(m10, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "permission", ServerProtocol.DIALOG_PARAM_DISPLAY, false, strArr);
            q0 q0Var2 = this.F;
            if (q0Var2 == null) {
                m.t("binding");
            } else {
                q0Var = q0Var2;
            }
            q0Var.f37922e.setText(p0.l0("DIDOMI_TITLE_UNSUPPORTED_LANGS"));
            q0Var.f37922e.setTypeface(o0.d(App.m()));
            TextView tvConsentContent = q0Var.f37921d;
            m.f(tvConsentContent, "tvConsentContent");
            g1(tvConsentContent, sf.a.i0(App.m()).k0() == 2 ? p0.l0("DIDOMI_APP_NOTICE_UNSUPPORTED_LANGS") : companion.getInstance().getTranslatedText("notice.content.notice"));
            TextView textView = q0Var.f37920c;
            textView.setText(p0.l0("DIDOMI_AGREE_BUTTON_UNSUPPORTED_LANGS"));
            textView.setTypeface(o0.d(App.m()));
            textView.setOnClickListener(new View.OnClickListener() { // from class: tf.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DidomiNoticeActivity.d1(x.this, this, view);
                }
            });
            TextView textView2 = q0Var.f37923f;
            textView2.setText(p0.l0("DIDOMI_LEARN_MORE_BUTTON_UNSUPPORTED_LANGS"));
            textView2.setTypeface(o0.d(App.m()));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: tf.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DidomiNoticeActivity.e1(DidomiNoticeActivity.this, xVar, view);
                }
            });
        } catch (Exception e10) {
            ng.a.f35508a.c("Didomi Screen", "Error while presenting didomi activity", e10);
            x0.N1(e10);
        }
        H = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        super.onPause();
        H = false;
    }

    @Override // com.scores365.Design.Activities.d, androidx.fragment.app.h, android.app.Activity
    protected void onResume() {
        super.onResume();
        H = true;
    }
}
