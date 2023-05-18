package com.scores365.dashboardEntities;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.scores365.App;
import com.scores365.entitys.ItemObj;
import ee.k;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import li.x0;
/* loaded from: classes2.dex */
public abstract class PageBuzzBase extends com.scores365.Design.PageObjects.b {

    /* renamed from: b  reason: collision with root package name */
    protected int f23406b;

    /* renamed from: c  reason: collision with root package name */
    public ItemObj f23407c;

    /* renamed from: d  reason: collision with root package name */
    protected String f23408d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23409e;

    /* renamed from: f  reason: collision with root package name */
    protected int f23410f;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f23405a = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public c f23411g = c.general;

    /* loaded from: classes2.dex */
    private static class LinkSpan extends URLSpan {

        /* renamed from: a  reason: collision with root package name */
        private int f23412a;

        /* renamed from: b  reason: collision with root package name */
        private int f23413b;

        /* renamed from: c  reason: collision with root package name */
        private String f23414c;

        /* renamed from: d  reason: collision with root package name */
        private String f23415d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f23416e;

        private LinkSpan(String str, int i10, int i11, String str2, String str3, boolean z10) {
            super(str);
            this.f23412a = i10;
            this.f23413b = i11;
            this.f23414c = str2;
            this.f23415d = str3;
            this.f23416e = z10;
        }

        /* synthetic */ LinkSpan(String str, int i10, int i11, String str2, String str3, boolean z10, a aVar) {
            this(str, i10, i11, str2, str3, z10);
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                String url = getURL();
                if (url != null) {
                    super.onClick(view);
                    url.contains(ShareConstants.WEB_DIALOG_PARAM_HASHTAG);
                    k.n(App.m(), "gamecenter", "buzz", "items-click", null, true, "type", this.f23415d, "news_item_id", String.valueOf(this.f23413b), "page", this.f23414c, "game_id", String.valueOf(this.f23412a), "is_notification", String.valueOf(this.f23416e), ShareConstants.FEED_SOURCE_PARAM, "buzz-page");
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a implements Linkify.TransformFilter {
        a() {
        }

        @Override // android.text.util.Linkify.TransformFilter
        public final String transformUrl(Matcher matcher, String str) {
            return str.substring(1) + "?src=hash";
        }
    }

    /* loaded from: classes2.dex */
    class b implements Linkify.TransformFilter {
        b() {
        }

        @Override // android.text.util.Linkify.TransformFilter
        public final String transformUrl(Matcher matcher, String str) {
            return matcher.group();
        }
    }

    /* loaded from: classes2.dex */
    public enum c {
        general,
        share
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PageBuzzBase(int i10, ItemObj itemObj, String str, boolean z10, int i11) {
        this.f23406b = i10;
        this.f23407c = itemObj;
        this.f23408d = str;
        this.f23409e = z10;
        this.f23410f = i11;
    }

    @Override // com.scores365.Design.PageObjects.c
    public long getItemId() {
        try {
            ItemObj itemObj = this.f23407c;
            if (itemObj != null) {
                return itemObj.getID();
            }
            return 0L;
        } catch (Exception e10) {
            x0.N1(e10);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(TextView textView) {
        a aVar = new a();
        b bVar = new b();
        Linkify.addLinks(textView, Pattern.compile("@([A-Za-z0-9_-]+)"), "http://www.twitter.com/", (Linkify.MatchFilter) null, bVar);
        Linkify.addLinks(textView, Pattern.compile("#([A-Za-z0-9_-]+)"), "https://twitter.com/hashtag/", (Linkify.MatchFilter) null, aVar);
        Linkify.addLinks(textView, Patterns.WEB_URL, (String) null, (Linkify.MatchFilter) null, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(TextView textView, String str) {
        PageBuzzBase pageBuzzBase = this;
        if (textView != null) {
            try {
                if (textView.getText() instanceof SpannableString) {
                    SpannableString spannableString = (SpannableString) textView.getText();
                    URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
                    int length = uRLSpanArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        URLSpan uRLSpan = uRLSpanArr[i10];
                        int spanStart = spannableString.getSpanStart(uRLSpan);
                        int spanEnd = spannableString.getSpanEnd(uRLSpan);
                        spannableString.removeSpan(uRLSpan);
                        spannableString.setSpan(new LinkSpan(uRLSpan.getURL(), pageBuzzBase.f23406b, pageBuzzBase.f23407c.getID(), pageBuzzBase.f23408d, str, pageBuzzBase.f23409e, null), spanStart, spanEnd, 0);
                        i10++;
                        pageBuzzBase = this;
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }
}
