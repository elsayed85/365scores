package com.scores365.gameCenter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.EventObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.VideoObj;
import com.scores365.gameCenter.gameCenterItems.a;
import com.scores365.ui.playerCard.SinglePlayerCardActivity;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SoccerTimelineEventPopup.kt */
/* loaded from: classes2.dex */
public final class u0 extends androidx.fragment.app.c implements View.OnClickListener {
    public static final a A = new a(null);

    /* renamed from: l  reason: collision with root package name */
    private ConstraintLayout f24056l;

    /* renamed from: m  reason: collision with root package name */
    private View f24057m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f24058n;

    /* renamed from: o  reason: collision with root package name */
    private View f24059o;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f24060p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f24061q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f24062r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f24063s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f24064t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f24065u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f24066v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f24067w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f24068x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f24069y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f24070z;

    /* compiled from: SoccerTimelineEventPopup.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final u0 a(b type, EventObj eventObj, int i10, int i11, int i12, int i13, String tab, String player1Name, String player2Name, yf.e eVar, String str, String str2, VideoObj videoObj, String status, int i14, boolean z10, GameObj gameObj, boolean z11, int i15, int i16, a.EnumC0251a listType, int i17, int i18) {
            kotlin.jvm.internal.m.g(type, "type");
            kotlin.jvm.internal.m.g(tab, "tab");
            kotlin.jvm.internal.m.g(player1Name, "player1Name");
            kotlin.jvm.internal.m.g(player2Name, "player2Name");
            kotlin.jvm.internal.m.g(status, "status");
            kotlin.jvm.internal.m.g(gameObj, "gameObj");
            kotlin.jvm.internal.m.g(listType, "listType");
            u0 u0Var = new u0();
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("event_type", type.getValue());
                bundle.putInt("game_id", i11);
                bundle.putBoolean("has_player_stats", z10);
                bundle.putBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, z11);
                bundle.putInt("sport_id", i10);
                bundle.putInt("player_id_1", i17);
                bundle.putInt("player_id_2", i18);
                bundle.putInt("athlete_id_1", i12);
                bundle.putInt("athlete_id_2", i13);
                bundle.putInt("game_time", i14);
                bundle.putInt("competitor_id", i15);
                bundle.putInt("competition_id", i16);
                bundle.putInt("list_type", listType.ordinal());
                bundle.putString("tab_status", tab);
                bundle.putString("athlete_1_text", player1Name);
                bundle.putString("athlete_2_text", player2Name);
                bundle.putString("athlete_1_position_name", str);
                bundle.putString("athlete_2_position_name", str2);
                bundle.putString("game_status", status);
                bundle.putSerializable("game_object", gameObj);
                bundle.putSerializable("event_obj", eventObj);
                bundle.putSerializable("video_obj", videoObj);
                bundle.putSerializable("substitution_obj", eVar);
                u0Var.setArguments(bundle);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
            return u0Var;
        }

        public final void b(int i10, String status, String tab, String eventType, boolean z10, boolean z11, int i11, int i12, String clickType) {
            kotlin.jvm.internal.m.g(status, "status");
            kotlin.jvm.internal.m.g(tab, "tab");
            kotlin.jvm.internal.m.g(eventType, "eventType");
            kotlin.jvm.internal.m.g(clickType, "clickType");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("game_id", Integer.valueOf(i10));
                hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, status);
                hashMap.put("tab", tab);
                hashMap.put("event_type", eventType);
                String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                hashMap.put("is_pbp", z10 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : "0");
                if (!z11) {
                    str = "0";
                }
                hashMap.put("is_live_stats", str);
                hashMap.put("athlete_id_1", Integer.valueOf(i11));
                hashMap.put("athlete_id_2", Integer.valueOf(i12));
                hashMap.put("click_type", clickType);
                ee.k.m(App.m(), "gamecenter", "event-div", "details", "click", true, hashMap);
            } catch (Exception e10) {
                li.x0.N1(e10);
            }
        }
    }

    /* compiled from: SoccerTimelineEventPopup.kt */
    /* loaded from: classes2.dex */
    public enum b {
        GOAL_WITH_ASSIST(1),
        SUBSTITUTE(2);
        
        private final int value;

        b(int i10) {
            this.value = i10;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a0 A[Catch: Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:2:0x0000, B:5:0x000a, B:7:0x0014, B:10:0x0021, B:13:0x0029, B:19:0x0035, B:21:0x003b, B:23:0x0045, B:25:0x004e, B:27:0x0054, B:32:0x005f, B:34:0x0063, B:35:0x0067, B:37:0x006e, B:38:0x0072, B:47:0x009a, B:49:0x00a0, B:51:0x00aa, B:54:0x00b5, B:57:0x00bd, B:63:0x00c9, B:65:0x00cf, B:67:0x00d9, B:69:0x00e2, B:71:0x00e8, B:76:0x00f3, B:78:0x00f7, B:79:0x00fb, B:81:0x0102, B:82:0x0106, B:84:0x010d, B:85:0x0111, B:93:0x0138, B:95:0x013e, B:97:0x0148, B:101:0x0155, B:103:0x0159, B:104:0x015d, B:106:0x0166, B:107:0x016a, B:109:0x0171, B:111:0x0178, B:86:0x011c, B:88:0x0120, B:89:0x0124, B:91:0x012b, B:92:0x012f, B:39:0x007d, B:41:0x0081, B:42:0x0085, B:44:0x008c, B:45:0x0090), top: B:116:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5 A[Catch: Exception -> 0x017c, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x017c, blocks: (B:2:0x0000, B:5:0x000a, B:7:0x0014, B:10:0x0021, B:13:0x0029, B:19:0x0035, B:21:0x003b, B:23:0x0045, B:25:0x004e, B:27:0x0054, B:32:0x005f, B:34:0x0063, B:35:0x0067, B:37:0x006e, B:38:0x0072, B:47:0x009a, B:49:0x00a0, B:51:0x00aa, B:54:0x00b5, B:57:0x00bd, B:63:0x00c9, B:65:0x00cf, B:67:0x00d9, B:69:0x00e2, B:71:0x00e8, B:76:0x00f3, B:78:0x00f7, B:79:0x00fb, B:81:0x0102, B:82:0x0106, B:84:0x010d, B:85:0x0111, B:93:0x0138, B:95:0x013e, B:97:0x0148, B:101:0x0155, B:103:0x0159, B:104:0x015d, B:106:0x0166, B:107:0x016a, B:109:0x0171, B:111:0x0178, B:86:0x011c, B:88:0x0120, B:89:0x0124, B:91:0x012b, B:92:0x012f, B:39:0x007d, B:41:0x0081, B:42:0x0085, B:44:0x008c, B:45:0x0090), top: B:116:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0120 A[Catch: Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:2:0x0000, B:5:0x000a, B:7:0x0014, B:10:0x0021, B:13:0x0029, B:19:0x0035, B:21:0x003b, B:23:0x0045, B:25:0x004e, B:27:0x0054, B:32:0x005f, B:34:0x0063, B:35:0x0067, B:37:0x006e, B:38:0x0072, B:47:0x009a, B:49:0x00a0, B:51:0x00aa, B:54:0x00b5, B:57:0x00bd, B:63:0x00c9, B:65:0x00cf, B:67:0x00d9, B:69:0x00e2, B:71:0x00e8, B:76:0x00f3, B:78:0x00f7, B:79:0x00fb, B:81:0x0102, B:82:0x0106, B:84:0x010d, B:85:0x0111, B:93:0x0138, B:95:0x013e, B:97:0x0148, B:101:0x0155, B:103:0x0159, B:104:0x015d, B:106:0x0166, B:107:0x016a, B:109:0x0171, B:111:0x0178, B:86:0x011c, B:88:0x0120, B:89:0x0124, B:91:0x012b, B:92:0x012f, B:39:0x007d, B:41:0x0081, B:42:0x0085, B:44:0x008c, B:45:0x0090), top: B:116:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012b A[Catch: Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:2:0x0000, B:5:0x000a, B:7:0x0014, B:10:0x0021, B:13:0x0029, B:19:0x0035, B:21:0x003b, B:23:0x0045, B:25:0x004e, B:27:0x0054, B:32:0x005f, B:34:0x0063, B:35:0x0067, B:37:0x006e, B:38:0x0072, B:47:0x009a, B:49:0x00a0, B:51:0x00aa, B:54:0x00b5, B:57:0x00bd, B:63:0x00c9, B:65:0x00cf, B:67:0x00d9, B:69:0x00e2, B:71:0x00e8, B:76:0x00f3, B:78:0x00f7, B:79:0x00fb, B:81:0x0102, B:82:0x0106, B:84:0x010d, B:85:0x0111, B:93:0x0138, B:95:0x013e, B:97:0x0148, B:101:0x0155, B:103:0x0159, B:104:0x015d, B:106:0x0166, B:107:0x016a, B:109:0x0171, B:111:0x0178, B:86:0x011c, B:88:0x0120, B:89:0x0124, B:91:0x012b, B:92:0x012f, B:39:0x007d, B:41:0x0081, B:42:0x0085, B:44:0x008c, B:45:0x0090), top: B:116:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013e A[Catch: Exception -> 0x017c, TryCatch #0 {Exception -> 0x017c, blocks: (B:2:0x0000, B:5:0x000a, B:7:0x0014, B:10:0x0021, B:13:0x0029, B:19:0x0035, B:21:0x003b, B:23:0x0045, B:25:0x004e, B:27:0x0054, B:32:0x005f, B:34:0x0063, B:35:0x0067, B:37:0x006e, B:38:0x0072, B:47:0x009a, B:49:0x00a0, B:51:0x00aa, B:54:0x00b5, B:57:0x00bd, B:63:0x00c9, B:65:0x00cf, B:67:0x00d9, B:69:0x00e2, B:71:0x00e8, B:76:0x00f3, B:78:0x00f7, B:79:0x00fb, B:81:0x0102, B:82:0x0106, B:84:0x010d, B:85:0x0111, B:93:0x0138, B:95:0x013e, B:97:0x0148, B:101:0x0155, B:103:0x0159, B:104:0x015d, B:106:0x0166, B:107:0x016a, B:109:0x0171, B:111:0x0178, B:86:0x011c, B:88:0x0120, B:89:0x0124, B:91:0x012b, B:92:0x012f, B:39:0x007d, B:41:0x0081, B:42:0x0085, B:44:0x008c, B:45:0x0090), top: B:116:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0151 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A1() {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.u0.A1():void");
    }

    private final void B1() {
        try {
            ImageView imageView = this.f24062r;
            ImageView imageView2 = null;
            if (imageView == null) {
                kotlin.jvm.internal.m.t("startPlayerEventIV");
                imageView = null;
            }
            ViewParent parent = imageView.getParent();
            kotlin.jvm.internal.m.e(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((ConstraintLayout) parent).setLayoutDirection(0);
            ImageView imageView3 = this.f24063s;
            if (imageView3 == null) {
                kotlin.jvm.internal.m.t("endPlayerEventIV");
                imageView3 = null;
            }
            ViewParent parent2 = imageView3.getParent();
            kotlin.jvm.internal.m.e(parent2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ((ConstraintLayout) parent2).setLayoutDirection(0);
            Bundle arguments = getArguments();
            if (arguments != null && arguments.getInt("event_type") == b.GOAL_WITH_ASSIST.getValue()) {
                TextView textView = this.f24064t;
                if (textView == null) {
                    kotlin.jvm.internal.m.t("startPlayerNameTV");
                    textView = null;
                }
                textView.setTextColor(li.p0.A(R.attr.U0));
                TextView textView2 = this.f24065u;
                if (textView2 == null) {
                    kotlin.jvm.internal.m.t("endPlayerNameTV");
                    textView2 = null;
                }
                textView2.setTextColor(li.p0.A(R.attr.U0));
                ImageView imageView4 = this.f24058n;
                if (imageView4 == null) {
                    kotlin.jvm.internal.m.t("substituteIV");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
                View view = this.f24059o;
                if (view == null) {
                    kotlin.jvm.internal.m.t("dividerView");
                    view = null;
                }
                view.setVisibility(0);
                Bundle arguments2 = getArguments();
                if ((arguments2 != null ? arguments2.getSerializable("video_obj") : null) != null) {
                    ImageView imageView5 = this.f24058n;
                    if (imageView5 == null) {
                        kotlin.jvm.internal.m.t("substituteIV");
                        imageView5 = null;
                    }
                    imageView5.setImageResource(li.p0.w(App.m(), R.attr.f21599y));
                } else {
                    ImageView imageView6 = this.f24058n;
                    if (imageView6 == null) {
                        kotlin.jvm.internal.m.t("substituteIV");
                        imageView6 = null;
                    }
                    imageView6.setImageResource(li.p0.w(App.m(), R.attr.f21596x));
                }
                ImageView imageView7 = this.f24062r;
                if (imageView7 == null) {
                    kotlin.jvm.internal.m.t("startPlayerEventIV");
                    imageView7 = null;
                }
                imageView7.setImageResource(R.drawable.D0);
                ImageView imageView8 = this.f24063s;
                if (imageView8 == null) {
                    kotlin.jvm.internal.m.t("endPlayerEventIV");
                    imageView8 = null;
                }
                imageView8.setImageResource(R.drawable.f21750l);
            } else {
                ImageView imageView9 = this.f24063s;
                if (imageView9 == null) {
                    kotlin.jvm.internal.m.t("endPlayerEventIV");
                    imageView9 = null;
                }
                imageView9.setVisibility(8);
                ImageView imageView10 = this.f24062r;
                if (imageView10 == null) {
                    kotlin.jvm.internal.m.t("startPlayerEventIV");
                    imageView10 = null;
                }
                imageView10.setVisibility(8);
                ImageView imageView11 = this.f24058n;
                if (imageView11 == null) {
                    kotlin.jvm.internal.m.t("substituteIV");
                    imageView11 = null;
                }
                imageView11.setVisibility(0);
                TextView textView3 = this.f24064t;
                if (textView3 == null) {
                    kotlin.jvm.internal.m.t("startPlayerNameTV");
                    textView3 = null;
                }
                textView3.setTextColor(li.p0.A(R.attr.f21562l1));
                TextView textView4 = this.f24065u;
                if (textView4 == null) {
                    kotlin.jvm.internal.m.t("endPlayerNameTV");
                    textView4 = null;
                }
                textView4.setTextColor(li.p0.A(R.attr.f21559k1));
            }
            ImageView imageView12 = this.f24058n;
            if (imageView12 == null) {
                kotlin.jvm.internal.m.t("substituteIV");
            } else {
                imageView2 = imageView12;
            }
            imageView2.setOnClickListener(this);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void initViews(View view) {
        try {
            View findViewById = view.findViewById(R.id.is);
            kotlin.jvm.internal.m.e(findViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            this.f24056l = (ConstraintLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.yr);
            kotlin.jvm.internal.m.e(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            this.f24058n = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.J4);
            kotlin.jvm.internal.m.e(findViewById3, "null cannot be cast to non-null type android.view.View");
            this.f24059o = findViewById3;
            View findViewById4 = view.findViewById(R.id.dr);
            kotlin.jvm.internal.m.e(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.f24060p = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.f21905b5);
            kotlin.jvm.internal.m.e(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
            this.f24061q = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.fr);
            kotlin.jvm.internal.m.e(findViewById6, "null cannot be cast to non-null type android.widget.ImageView");
            this.f24062r = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.f21951d5);
            kotlin.jvm.internal.m.e(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
            this.f24063s = (ImageView) findViewById7;
            View findViewById8 = view.findViewById(R.id.hr);
            kotlin.jvm.internal.m.e(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
            this.f24064t = (TextView) findViewById8;
            View findViewById9 = view.findViewById(R.id.f21997f5);
            kotlin.jvm.internal.m.e(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
            this.f24065u = (TextView) findViewById9;
            View findViewById10 = view.findViewById(R.id.er);
            kotlin.jvm.internal.m.e(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
            this.f24066v = (TextView) findViewById10;
            View findViewById11 = view.findViewById(R.id.f21928c5);
            kotlin.jvm.internal.m.e(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
            this.f24067w = (TextView) findViewById11;
            View findViewById12 = view.findViewById(R.id.fs);
            kotlin.jvm.internal.m.e(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
            this.f24068x = (TextView) findViewById12;
            View findViewById13 = view.findViewById(R.id.gr);
            kotlin.jvm.internal.m.e(findViewById13, "null cannot be cast to non-null type android.widget.TextView");
            this.f24069y = (TextView) findViewById13;
            View findViewById14 = view.findViewById(R.id.f21974e5);
            kotlin.jvm.internal.m.e(findViewById14, "null cannot be cast to non-null type android.widget.TextView");
            this.f24070z = (TextView) findViewById14;
            View findViewById15 = view.findViewById(R.id.Ap);
            kotlin.jvm.internal.m.e(findViewById15, "null cannot be cast to non-null type android.view.View");
            this.f24057m = findViewById15;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final String r1(int i10) {
        try {
            Bundle arguments = getArguments();
            boolean z10 = true;
            if (arguments != null && arguments.getInt("event_type") == b.GOAL_WITH_ASSIST.getValue()) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null || i10 != arguments2.getInt("athlete_id_1")) {
                    z10 = false;
                }
                return z10 ? "scorer" : "assiter";
            }
            Bundle arguments3 = getArguments();
            if (arguments3 == null || i10 != arguments3.getInt("athlete_id_1")) {
                z10 = false;
            }
            return z10 ? "sub-on" : "sub-off";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private final String s1() {
        try {
            Bundle arguments = getArguments();
            if ((arguments != null ? arguments.getSerializable("event_obj") : null) instanceof EventObj) {
                Bundle arguments2 = getArguments();
                Serializable serializable = arguments2 != null ? arguments2.getSerializable("event_obj") : null;
                kotlin.jvm.internal.m.e(serializable, "null cannot be cast to non-null type com.scores365.entitys.EventObj");
                return String.valueOf(((EventObj) serializable).type);
            }
            return "-1";
        } catch (Exception e10) {
            li.x0.N1(e10);
            return "";
        }
    }

    private final void setTexts() {
        String l02;
        try {
            String l03 = li.p0.l0("NEW_PLAYER_CARD_SOCCER_PLAYER_DETAILS");
            kotlin.jvm.internal.m.f(l03, "getTerm(\"NEW_PLAYER_CARD_SOCCER_PLAYER_DETAILS\")");
            TextView textView = null;
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                Boolean valueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean("has_player_stats", false)) : null;
                kotlin.jvm.internal.m.d(valueOf);
                if (valueOf.booleanValue()) {
                    l02 = li.p0.l0("PLAYER_STATS_BUTTON");
                    kotlin.jvm.internal.m.f(l02, "{\n                    Ui…UTTON\")\n                }");
                } else {
                    l02 = li.p0.l0("NEW_PLAYER_CARD_SOCCER_PLAYER_DETAILS");
                    kotlin.jvm.internal.m.f(l02, "{\n                    Ui…TAILS\")\n                }");
                }
                l03 = l02;
            }
            TextView textView2 = this.f24066v;
            if (textView2 == null) {
                kotlin.jvm.internal.m.t("startPlayerNextStage");
                textView2 = null;
            }
            textView2.setText(l03);
            TextView textView3 = this.f24067w;
            if (textView3 == null) {
                kotlin.jvm.internal.m.t("endPlayerNextStage");
                textView3 = null;
            }
            textView3.setText(l03);
            TextView textView4 = this.f24064t;
            if (textView4 == null) {
                kotlin.jvm.internal.m.t("startPlayerNameTV");
                textView4 = null;
            }
            Bundle arguments2 = getArguments();
            textView4.setText(arguments2 != null ? arguments2.getString("athlete_1_text") : null);
            TextView textView5 = this.f24065u;
            if (textView5 == null) {
                kotlin.jvm.internal.m.t("endPlayerNameTV");
                textView5 = null;
            }
            Bundle arguments3 = getArguments();
            textView5.setText(arguments3 != null ? arguments3.getString("athlete_2_text") : null);
            TextView textView6 = this.f24069y;
            if (textView6 == null) {
                kotlin.jvm.internal.m.t("player1PositionTv");
                textView6 = null;
            }
            Bundle arguments4 = getArguments();
            textView6.setText(arguments4 != null ? arguments4.getString("athlete_1_position_name") : null);
            TextView textView7 = this.f24070z;
            if (textView7 == null) {
                kotlin.jvm.internal.m.t("player2PositionTv");
                textView7 = null;
            }
            Bundle arguments5 = getArguments();
            textView7.setText(arguments5 != null ? arguments5.getString("athlete_2_position_name") : null);
            TextView textView8 = this.f24069y;
            if (textView8 == null) {
                kotlin.jvm.internal.m.t("player1PositionTv");
                textView8 = null;
            }
            textView8.setTextColor(li.p0.A(R.attr.f21565m1));
            TextView textView9 = this.f24070z;
            if (textView9 == null) {
                kotlin.jvm.internal.m.t("player2PositionTv");
                textView9 = null;
            }
            textView9.setTextColor(li.p0.A(R.attr.f21565m1));
            TextView textView10 = this.f24069y;
            if (textView10 == null) {
                kotlin.jvm.internal.m.t("player1PositionTv");
                textView10 = null;
            }
            CharSequence text = textView10.getText();
            kotlin.jvm.internal.m.f(text, "player1PositionTv.text");
            boolean z10 = true;
            if (text.length() == 0) {
                TextView textView11 = this.f24069y;
                if (textView11 == null) {
                    kotlin.jvm.internal.m.t("player1PositionTv");
                    textView11 = null;
                }
                textView11.setVisibility(8);
            } else {
                TextView textView12 = this.f24069y;
                if (textView12 == null) {
                    kotlin.jvm.internal.m.t("player1PositionTv");
                    textView12 = null;
                }
                textView12.setVisibility(0);
            }
            TextView textView13 = this.f24070z;
            if (textView13 == null) {
                kotlin.jvm.internal.m.t("player2PositionTv");
                textView13 = null;
            }
            CharSequence text2 = textView13.getText();
            kotlin.jvm.internal.m.f(text2, "player2PositionTv.text");
            if (text2.length() != 0) {
                z10 = false;
            }
            if (z10) {
                TextView textView14 = this.f24070z;
                if (textView14 == null) {
                    kotlin.jvm.internal.m.t("player2PositionTv");
                    textView14 = null;
                }
                textView14.setVisibility(8);
            } else {
                TextView textView15 = this.f24070z;
                if (textView15 == null) {
                    kotlin.jvm.internal.m.t("player2PositionTv");
                    textView15 = null;
                }
                textView15.setVisibility(0);
            }
            TextView textView16 = this.f24066v;
            if (textView16 == null) {
                kotlin.jvm.internal.m.t("startPlayerNextStage");
                textView16 = null;
            }
            textView16.setTypeface(li.o0.d(App.m()));
            TextView textView17 = this.f24067w;
            if (textView17 == null) {
                kotlin.jvm.internal.m.t("endPlayerNextStage");
                textView17 = null;
            }
            textView17.setTypeface(li.o0.d(App.m()));
            TextView textView18 = this.f24064t;
            if (textView18 == null) {
                kotlin.jvm.internal.m.t("startPlayerNameTV");
                textView18 = null;
            }
            textView18.setTypeface(li.o0.d(App.m()));
            TextView textView19 = this.f24065u;
            if (textView19 == null) {
                kotlin.jvm.internal.m.t("endPlayerNameTV");
                textView19 = null;
            }
            textView19.setTypeface(li.o0.d(App.m()));
            TextView textView20 = this.f24069y;
            if (textView20 == null) {
                kotlin.jvm.internal.m.t("player1PositionTv");
                textView20 = null;
            }
            textView20.setTypeface(li.o0.d(App.m()));
            TextView textView21 = this.f24070z;
            if (textView21 == null) {
                kotlin.jvm.internal.m.t("player2PositionTv");
                textView21 = null;
            }
            textView21.setTypeface(li.o0.d(App.m()));
            StringBuilder sb2 = new StringBuilder();
            Bundle arguments6 = getArguments();
            sb2.append(arguments6 != null ? Integer.valueOf(arguments6.getInt("game_time")) : null);
            sb2.append('\'');
            String sb3 = sb2.toString();
            TextView textView22 = this.f24068x;
            if (textView22 == null) {
                kotlin.jvm.internal.m.t("gameTimeTv");
                textView22 = null;
            }
            textView22.setText(sb3);
            TextView textView23 = this.f24068x;
            if (textView23 == null) {
                kotlin.jvm.internal.m.t("gameTimeTv");
                textView23 = null;
            }
            textView23.setTextDirection(3);
            Bundle arguments7 = getArguments();
            yf.d dVar = (EventObj) (arguments7 != null ? arguments7.getSerializable("event_obj") : null);
            Bundle arguments8 = getArguments();
            yf.d dVar2 = (yf.e) (arguments8 != null ? arguments8.getSerializable("substitution_obj") : null);
            if (dVar == null) {
                dVar = dVar2 != null ? dVar2 : null;
            }
            String gameTimeToDisplay = dVar != null ? dVar.getGameTimeToDisplay() : null;
            if (gameTimeToDisplay != null) {
                int addedTime = dVar != null ? dVar.getAddedTime() : -2;
                if (addedTime <= 0) {
                    TextView textView24 = this.f24068x;
                    if (textView24 == null) {
                        kotlin.jvm.internal.m.t("gameTimeTv");
                        textView24 = null;
                    }
                    textView24.setText(gameTimeToDisplay);
                    TextView textView25 = this.f24068x;
                    if (textView25 == null) {
                        kotlin.jvm.internal.m.t("gameTimeTv");
                    } else {
                        textView = textView25;
                    }
                    textView.setTextColor(li.p0.A(R.attr.U0));
                    return;
                }
                TextView textView26 = this.f24068x;
                if (textView26 == null) {
                    kotlin.jvm.internal.m.t("gameTimeTv");
                    textView26 = null;
                }
                textView26.setText(gameTimeToDisplay + '+' + addedTime);
                TextView textView27 = this.f24068x;
                if (textView27 == null) {
                    kotlin.jvm.internal.m.t("gameTimeTv");
                } else {
                    textView = textView27;
                }
                textView.setTextColor(li.p0.A(R.attr.f21559k1));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final int t1() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt("game_id");
        }
        return -1;
    }

    private final String u1() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("game_status") : null;
        return string == null ? "" : string;
    }

    private final String v1() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("tab_status") : null;
        return string == null ? "" : string;
    }

    private final void w1() {
        String str;
        String str2;
        ImageView imageView;
        ImageView imageView2;
        try {
            Bundle arguments = getArguments();
            yf.e eVar = (yf.e) (arguments != null ? arguments.getSerializable("substitution_obj") : null);
            if (eVar != null) {
                String imgVer = eVar.f43352a.getImgVer();
                kotlin.jvm.internal.m.f(imgVer, "subObj.inPlayer.imgVer");
                String imgVer2 = eVar.f43353b.getImgVer();
                kotlin.jvm.internal.m.f(imgVer2, "subObj.outPlayer.imgVer");
                str2 = imgVer2;
                str = imgVer;
            } else {
                str = "-1";
                str2 = str;
            }
            Bundle arguments2 = getArguments();
            Integer valueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt("athlete_id_1")) : null;
            kotlin.jvm.internal.m.d(valueOf);
            long intValue = valueOf.intValue();
            ImageView imageView3 = this.f24060p;
            if (imageView3 == null) {
                kotlin.jvm.internal.m.t("playerStartIV");
                imageView = null;
            } else {
                imageView = imageView3;
            }
            Drawable K = li.p0.K(R.attr.S0);
            Bundle arguments3 = getArguments();
            Boolean valueOf2 = arguments3 != null ? Boolean.valueOf(arguments3.getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, false)) : null;
            kotlin.jvm.internal.m.d(valueOf2);
            li.u.j(intValue, true, imageView, K, valueOf2.booleanValue(), str);
            Bundle arguments4 = getArguments();
            Integer valueOf3 = arguments4 != null ? Integer.valueOf(arguments4.getInt("athlete_id_2")) : null;
            kotlin.jvm.internal.m.d(valueOf3);
            long intValue2 = valueOf3.intValue();
            ImageView imageView4 = this.f24061q;
            if (imageView4 == null) {
                kotlin.jvm.internal.m.t("playerEndIV");
                imageView2 = null;
            } else {
                imageView2 = imageView4;
            }
            Drawable K2 = li.p0.K(R.attr.S0);
            Bundle arguments5 = getArguments();
            Boolean valueOf4 = arguments5 != null ? Boolean.valueOf(arguments5.getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT, false)) : null;
            kotlin.jvm.internal.m.d(valueOf4);
            li.u.j(intValue2, true, imageView2, K2, valueOf4.booleanValue(), str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2 A[Catch: Exception -> 0x014b, TryCatch #0 {Exception -> 0x014b, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:10:0x0024, B:12:0x002a, B:14:0x0032, B:16:0x003b, B:18:0x0041, B:20:0x004d, B:22:0x005a, B:24:0x0066, B:26:0x0074, B:31:0x0081, B:35:0x008a, B:38:0x0092, B:40:0x0098, B:42:0x00a0, B:44:0x00a8, B:46:0x00ae, B:49:0x00b4, B:58:0x00d2, B:60:0x00d8, B:66:0x00ee, B:68:0x00f6, B:70:0x0102, B:72:0x010f, B:74:0x011b, B:76:0x0124, B:77:0x0128, B:61:0x00df, B:63:0x00e5, B:50:0x00b9, B:53:0x00c2, B:55:0x00c8, B:32:0x0084), top: B:82:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00df A[Catch: Exception -> 0x014b, TryCatch #0 {Exception -> 0x014b, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:10:0x0024, B:12:0x002a, B:14:0x0032, B:16:0x003b, B:18:0x0041, B:20:0x004d, B:22:0x005a, B:24:0x0066, B:26:0x0074, B:31:0x0081, B:35:0x008a, B:38:0x0092, B:40:0x0098, B:42:0x00a0, B:44:0x00a8, B:46:0x00ae, B:49:0x00b4, B:58:0x00d2, B:60:0x00d8, B:66:0x00ee, B:68:0x00f6, B:70:0x0102, B:72:0x010f, B:74:0x011b, B:76:0x0124, B:77:0x0128, B:61:0x00df, B:63:0x00e5, B:50:0x00b9, B:53:0x00c2, B:55:0x00c8, B:32:0x0084), top: B:82:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f6 A[Catch: Exception -> 0x014b, TryCatch #0 {Exception -> 0x014b, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:10:0x0024, B:12:0x002a, B:14:0x0032, B:16:0x003b, B:18:0x0041, B:20:0x004d, B:22:0x005a, B:24:0x0066, B:26:0x0074, B:31:0x0081, B:35:0x008a, B:38:0x0092, B:40:0x0098, B:42:0x00a0, B:44:0x00a8, B:46:0x00ae, B:49:0x00b4, B:58:0x00d2, B:60:0x00d8, B:66:0x00ee, B:68:0x00f6, B:70:0x0102, B:72:0x010f, B:74:0x011b, B:76:0x0124, B:77:0x0128, B:61:0x00df, B:63:0x00e5, B:50:0x00b9, B:53:0x00c2, B:55:0x00c8, B:32:0x0084), top: B:82:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010f A[Catch: Exception -> 0x014b, TryCatch #0 {Exception -> 0x014b, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:10:0x0024, B:12:0x002a, B:14:0x0032, B:16:0x003b, B:18:0x0041, B:20:0x004d, B:22:0x005a, B:24:0x0066, B:26:0x0074, B:31:0x0081, B:35:0x008a, B:38:0x0092, B:40:0x0098, B:42:0x00a0, B:44:0x00a8, B:46:0x00ae, B:49:0x00b4, B:58:0x00d2, B:60:0x00d8, B:66:0x00ee, B:68:0x00f6, B:70:0x0102, B:72:0x010f, B:74:0x011b, B:76:0x0124, B:77:0x0128, B:61:0x00df, B:63:0x00e5, B:50:0x00b9, B:53:0x00c2, B:55:0x00c8, B:32:0x0084), top: B:82:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0124 A[Catch: Exception -> 0x014b, TryCatch #0 {Exception -> 0x014b, blocks: (B:3:0x0002, B:5:0x0009, B:7:0x0011, B:10:0x0024, B:12:0x002a, B:14:0x0032, B:16:0x003b, B:18:0x0041, B:20:0x004d, B:22:0x005a, B:24:0x0066, B:26:0x0074, B:31:0x0081, B:35:0x008a, B:38:0x0092, B:40:0x0098, B:42:0x00a0, B:44:0x00a8, B:46:0x00ae, B:49:0x00b4, B:58:0x00d2, B:60:0x00d8, B:66:0x00ee, B:68:0x00f6, B:70:0x0102, B:72:0x010f, B:74:0x011b, B:76:0x0124, B:77:0x0128, B:61:0x00df, B:63:0x00e5, B:50:0x00b9, B:53:0x00c2, B:55:0x00c8, B:32:0x0084), top: B:82:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void x1(boolean r19) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.u0.x1(boolean):void");
    }

    private final void y1(int i10) {
        try {
            Bundle arguments = getArguments();
            Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("competition_id")) : null;
            kotlin.jvm.internal.m.d(valueOf);
            int intValue = valueOf.intValue();
            Bundle arguments2 = getArguments();
            Boolean valueOf2 = arguments2 != null ? Boolean.valueOf(arguments2.getBoolean(SinglePlayerCardActivity.IS_NATIONAL_CONTEXT)) : null;
            kotlin.jvm.internal.m.d(valueOf2);
            startActivity(SinglePlayerCardActivity.createSinglePlayerCardActivityIntent(i10, intValue, valueOf2.booleanValue(), null, "gamecenter_match_events"));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void z1() {
        try {
            Bundle arguments = getArguments();
            EventObj eventObj = (EventObj) (arguments != null ? arguments.getSerializable("event_obj") : null);
            if (eventObj == null) {
                Bundle arguments2 = getArguments();
                eventObj = (EventObj) (arguments2 != null ? arguments2.getSerializable("event_obj") : null);
            }
            Context m10 = App.m();
            String[] strArr = new String[16];
            strArr[0] = "game_id";
            Bundle arguments3 = getArguments();
            strArr[1] = String.valueOf(arguments3 != null ? Integer.valueOf(arguments3.getInt("game_id")) : null);
            strArr[2] = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS;
            Bundle arguments4 = getArguments();
            strArr[3] = String.valueOf(arguments4 != null ? arguments4.getString("game_status") : null);
            strArr[4] = "tab";
            Bundle arguments5 = getArguments();
            strArr[5] = arguments5 != null ? arguments5.getString("tab_status") : null;
            strArr[6] = "event_type";
            strArr[7] = (eventObj == null || (r3 = Integer.valueOf(eventObj.type).toString()) == null) ? "-1" : "-1";
            strArr[8] = "is_pbp";
            strArr[9] = "0";
            strArr[10] = "is_live_stats";
            strArr[11] = "0";
            strArr[12] = "athlete_id_1";
            Bundle arguments6 = getArguments();
            strArr[13] = String.valueOf(arguments6 != null ? Integer.valueOf(arguments6.getInt("athlete_id_1")) : null);
            strArr[14] = "athlete_id_2";
            Bundle arguments7 = getArguments();
            strArr[15] = String.valueOf(arguments7 != null ? Integer.valueOf(arguments7.getInt("athlete_id_2")) : null);
            ee.k.n(m10, "gamecenter", "event-div", ServerProtocol.DIALOG_PARAM_DISPLAY, null, false, strArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0017 A[Catch: Exception -> 0x0010, TRY_LEAVE, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8 A[Catch: Exception -> 0x0010, TRY_ENTER, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0122 A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0133 A[Catch: Exception -> 0x0010, TRY_ENTER, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0161 A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a7 A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01be A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0006, B:12:0x0017, B:15:0x001f, B:18:0x0027, B:20:0x002d, B:22:0x0033, B:25:0x0043, B:27:0x0049, B:29:0x0068, B:31:0x0072, B:33:0x0083, B:35:0x0089, B:37:0x00cd, B:38:0x00d5, B:42:0x00e8, B:44:0x00f0, B:45:0x00f4, B:51:0x0101, B:53:0x0109, B:54:0x010f, B:59:0x011a, B:61:0x0122, B:62:0x0126, B:65:0x0133, B:67:0x0139, B:68:0x013d, B:70:0x0143, B:72:0x014d, B:74:0x0156, B:91:0x018e, B:93:0x01a7, B:95:0x01b1, B:97:0x01be, B:98:0x01c6, B:76:0x015c, B:78:0x0161, B:80:0x0167, B:81:0x016b, B:83:0x0171, B:85:0x017b, B:87:0x0184, B:89:0x018a), top: B:102:0x0006 }] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r15) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.gameCenter.u0.onClick(android.view.View):void");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        Dialog dialog = getDialog();
        kotlin.jvm.internal.m.d(dialog);
        Window window = dialog.getWindow();
        kotlin.jvm.internal.m.d(window);
        window.requestFeature(1);
        Dialog dialog2 = getDialog();
        kotlin.jvm.internal.m.d(dialog2);
        dialog2.setCanceledOnTouchOutside(true);
        View inflate = inflater.inflate(R.layout.O8, viewGroup, false);
        kotlin.jvm.internal.m.f(inflate, "inflater.inflate(R.layou…_popup, container, false)");
        try {
            initViews(inflate);
            w1();
            setTexts();
            B1();
            A1();
            z1();
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Dialog dialog = getDialog();
            kotlin.jvm.internal.m.d(dialog);
            Window window = dialog.getWindow();
            kotlin.jvm.internal.m.d(window);
            WindowManager.LayoutParams attributes = window.getAttributes();
            kotlin.jvm.internal.m.f(attributes, "dialog!!.window!!.attributes");
            ((ViewGroup.LayoutParams) attributes).width = (int) (sf.b.X1().T1() * 0.844d);
            ((ViewGroup.LayoutParams) attributes).height = -2;
            Dialog dialog2 = getDialog();
            kotlin.jvm.internal.m.d(dialog2);
            Window window2 = dialog2.getWindow();
            kotlin.jvm.internal.m.d(window2);
            window2.setAttributes(attributes);
            Dialog dialog3 = getDialog();
            kotlin.jvm.internal.m.d(dialog3);
            Window window3 = dialog3.getWindow();
            kotlin.jvm.internal.m.d(window3);
            window3.setGravity(17);
        } catch (Exception e10) {
            li.x0.N1(e10);
        }
    }
}
