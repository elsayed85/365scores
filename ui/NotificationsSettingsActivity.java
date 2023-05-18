package com.scores365.ui;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.e1;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.scores365.App;
import com.scores365.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class NotificationsSettingsActivity extends com.scores365.Design.Activities.c {
    private static final int DEFAULT_SILENT_HOUR_FROM = 0;
    private static final int DEFAULT_SILENT_HOUR_TO = 8;
    private Date[] SilentTImes;
    private ImageView bellIV;
    private ConstraintLayout clSilentTimeContainer;
    private TextView deviceSettingsTV;
    private TimePickerDialog fromTimePicker;
    private boolean is24HourFormat;
    private LinearLayout llFeedbackBtn;
    private LinearLayout llGeneralNotificationsBtn;
    private SwitchCompat llNewsPushOnOffBtn;
    private SwitchCompat llPushOnOffBtn;
    private SwitchCompat llSilentOnOffBtn;
    private LinearLayout llSilentTimeBtn;
    private SwitchCompat llSoundOnOffBtn;
    private SwitchCompat llVibrateOnOffBtn;
    private ConstraintLayout notificationsDisabledView;
    private SwitchCompat scOddsPushOnOffBtn;
    private TextView sepFrom;
    private TextView sepTo;
    private TextView titleTV;
    private TimePickerDialog toTimePicker;
    private TextView tvFeedbackTitle;
    private TextView tvFromAmpm;
    private TextView tvFromHour;
    private TextView tvFromMinute;
    private TextView tvFromTitle;
    private TextView tvGeneralNotificationsTitle;
    private TextView tvNewsPushTitle;
    private TextView tvNotificationTitle;
    private TextView tvOddsPushTitle;
    private TextView tvPushTitle;
    private TextView tvSilentTitle;
    private TextView tvSoundTitle;
    private TextView tvToAmpm;
    private TextView tvToHour;
    private TextView tvToMinute;
    private TextView tvToTitle;
    private TextView tvVibrateTitle;
    private boolean isDirty = false;
    View.OnClickListener generalNotifListener = new View.OnClickListener() { // from class: com.scores365.ui.z
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.this.lambda$new$0(view);
        }
    };
    View.OnClickListener feedBackClickListener = new View.OnClickListener() { // from class: com.scores365.ui.a0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.lambda$new$1(view);
        }
    };
    View.OnClickListener pushOnOffClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.b0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.this.lambda$new$2(view);
        }
    };
    View.OnClickListener oddsOnOffClickListener = new View.OnClickListener() { // from class: com.scores365.ui.c0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.this.lambda$new$3(view);
        }
    };
    View.OnClickListener pushOnOffNewsClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.d0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.this.lambda$new$4(view);
        }
    };
    View.OnClickListener soundOnOffClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.e0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.this.lambda$new$5(view);
        }
    };
    View.OnClickListener silentModeOnOffClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.f0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.this.lambda$new$6(view);
        }
    };
    boolean isVibrationEnabled = true;
    View.OnClickListener vibrateOnOffClickLinstener = new View.OnClickListener() { // from class: com.scores365.ui.NotificationsSettingsActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (NotificationsSettingsActivity.this.isVibrationEnabled || Build.VERSION.SDK_INT < 26) {
                    String str = "unselect";
                    if (sf.b.X1().a5()) {
                        sf.b.X1().G9(false);
                    } else {
                        sf.b.X1().G9(true);
                        str = "select";
                    }
                    x0.w(true, NotificationsSettingsActivity.this.channelCreationFinishedListener);
                    NotificationsSettingsActivity.this.isDirty = true;
                    ee.k.o(App.m(), "settings", "notifications", "enable-vibrate", null, ServerProtocol.DIALOG_PARAM_STATE, str);
                    NotificationsSettingsActivity.this.isVibrationEnabled = false;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    private final OnChannelCreationFinishedListener channelCreationFinishedListener = new OnChannelCreationFinishedListener() { // from class: com.scores365.ui.g0
        @Override // com.scores365.ui.OnChannelCreationFinishedListener
        public final void onChannelCreationFinished() {
            NotificationsSettingsActivity.this.lambda$new$7();
        }
    };
    View.OnClickListener fromClickListener = new View.OnClickListener() { // from class: com.scores365.ui.NotificationsSettingsActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                NotificationsSettingsActivity.this.fromTimePicker.setTitle(p0.l0("SET_TIME"));
                NotificationsSettingsActivity.this.fromTimePicker.show();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    View.OnClickListener toClickListener = new View.OnClickListener() { // from class: com.scores365.ui.NotificationsSettingsActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                NotificationsSettingsActivity.this.toTimePicker.setTitle(p0.l0("SET_TIME"));
                NotificationsSettingsActivity.this.toTimePicker.show();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    };
    private final View.OnClickListener openSettingsNotificationActivity = new View.OnClickListener() { // from class: com.scores365.ui.h0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NotificationsSettingsActivity.lambda$new$8(view);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Date getTimeDate(int i10, int i11) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i10);
            calendar.set(12, i11);
            return calendar.getTime();
        } catch (Exception unused) {
            return null;
        }
    }

    private String getTimeStrings(Date date, boolean z10) {
        try {
            return (z10 ? new SimpleDateFormat("HH:mm") : new SimpleDateFormat("hh:mm")).format(date);
        } catch (Exception unused) {
            return "";
        }
    }

    private void handleNotificationsDisabledView() {
        if (!nb.s.a(this)) {
            this.notificationsDisabledView.setVisibility(8);
            return;
        }
        if (x0.l1()) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.bellIV.getLayoutParams())).rightMargin = p0.s(16);
            ((ConstraintLayout.b) this.bellIV.getLayoutParams()).f4622e = -1;
            ((ConstraintLayout.b) this.bellIV.getLayoutParams()).f4628h = R.id.Si;
            ((ConstraintLayout.b) this.titleTV.getLayoutParams()).f4624f = -1;
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.titleTV.getLayoutParams())).leftMargin = 0;
            ((ConstraintLayout.b) this.titleTV.getLayoutParams()).f4626g = R.id.Qi;
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.titleTV.getLayoutParams())).rightMargin = p0.s(13);
        }
        this.titleTV.setText(p0.l0("DISABLED_NOTIFICATIONS_NOTICE"));
        TextView textView = this.deviceSettingsTV;
        textView.setText(Html.fromHtml("<u>" + p0.l0("DEVICE_SETTINGS") + "</u>"));
        this.bellIV.setImageResource(R.drawable.f21824u1);
        this.titleTV.setTypeface(o0.b(App.m()));
        this.deviceSettingsTV.setTypeface(o0.d(App.m()));
        this.deviceSettingsTV.setOnClickListener(this.openSettingsNotificationActivity);
        this.notificationsDisabledView.setVisibility(0);
    }

    private void initViews() {
        try {
            this.tvNotificationTitle = (TextView) findViewById(R.id.ip);
            this.llGeneralNotificationsBtn = (LinearLayout) findViewById(R.id.f22354v7);
            this.tvGeneralNotificationsTitle = (TextView) findViewById(R.id.f22376w7);
            this.tvPushTitle = (TextView) findViewById(R.id.kl);
            this.llPushOnOffBtn = (SwitchCompat) findViewById(R.id.hl);
            this.tvOddsPushTitle = (TextView) findViewById(R.id.UG);
            this.scOddsPushOnOffBtn = (SwitchCompat) findViewById(R.id.Ao);
            this.tvNewsPushTitle = (TextView) findViewById(R.id.jl);
            this.llNewsPushOnOffBtn = (SwitchCompat) findViewById(R.id.il);
            this.tvSoundTitle = (TextView) findViewById(R.id.lq);
            this.llSoundOnOffBtn = (SwitchCompat) findViewById(R.id.kq);
            this.llSilentTimeBtn = (LinearLayout) findViewById(R.id.Jp);
            this.tvSilentTitle = (TextView) findViewById(R.id.Kp);
            this.llSilentOnOffBtn = (SwitchCompat) findViewById(R.id.Ip);
            this.tvVibrateTitle = (TextView) findViewById(R.id.GI);
            this.llVibrateOnOffBtn = (SwitchCompat) findViewById(R.id.EI);
            if (!p0.v0(getApplicationContext())) {
                ((LinearLayout) findViewById(R.id.FI)).setVisibility(8);
            }
            this.llFeedbackBtn = (LinearLayout) findViewById(R.id.A5);
            this.tvFeedbackTitle = (TextView) findViewById(R.id.B5);
            this.sepTo = (TextView) findViewById(R.id.NG);
            this.sepFrom = (TextView) findViewById(R.id.MG);
            this.tvFromTitle = (TextView) findViewById(R.id.Bz);
            this.tvFromHour = (TextView) findViewById(R.id.Dz);
            this.tvFromMinute = (TextView) findViewById(R.id.Ez);
            this.tvFromAmpm = (TextView) findViewById(R.id.Cz);
            this.tvToTitle = (TextView) findViewById(R.id.lH);
            this.tvToHour = (TextView) findViewById(R.id.nH);
            this.tvToMinute = (TextView) findViewById(R.id.oH);
            this.tvToAmpm = (TextView) findViewById(R.id.mH);
            this.tvFromTitle.setText(p0.l0("FROM_TIME"));
            this.tvToTitle.setText(p0.l0("TO"));
            this.tvFromTitle.setTypeface(o0.d(App.m()));
            this.tvFromAmpm.setTypeface(o0.d(App.m()));
            this.tvFromMinute.setTypeface(o0.d(App.m()));
            this.tvFromHour.setTypeface(o0.d(App.m()));
            this.tvToTitle.setTypeface(o0.d(App.m()));
            this.tvToHour.setTypeface(o0.d(App.m()));
            this.tvToMinute.setTypeface(o0.d(App.m()));
            this.tvToAmpm.setTypeface(o0.d(App.m()));
            this.is24HourFormat = DateFormat.is24HourFormat(getApplicationContext());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initiateDatePickers() {
        try {
            Date[] k10 = sf.b.X1().k();
            this.SilentTImes = k10;
            if (k10 == null) {
                this.SilentTImes = new Date[2];
                Calendar calendar = Calendar.getInstance();
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                this.SilentTImes[0] = calendar.getTime();
                calendar.set(11, 8);
                this.SilentTImes[1] = calendar.getTime();
                sf.b.X1().u(this.SilentTImes);
            }
            setTimeLogic(this.is24HourFormat, this.SilentTImes[0], this.tvFromHour, this.tvFromMinute, this.tvFromAmpm);
            setTimeLogic(this.is24HourFormat, this.SilentTImes[1], this.tvToHour, this.tvToMinute, this.tvToAmpm);
            this.fromTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() { // from class: com.scores365.ui.NotificationsSettingsActivity.2
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public void onTimeSet(TimePicker timePicker, int i10, int i11) {
                    NotificationsSettingsActivity.this.SilentTImes[0] = NotificationsSettingsActivity.this.getTimeDate(i10, i11);
                    NotificationsSettingsActivity notificationsSettingsActivity = NotificationsSettingsActivity.this;
                    notificationsSettingsActivity.setTimeLogic(notificationsSettingsActivity.is24HourFormat, NotificationsSettingsActivity.this.SilentTImes[0], NotificationsSettingsActivity.this.tvFromHour, NotificationsSettingsActivity.this.tvFromMinute, NotificationsSettingsActivity.this.tvFromAmpm);
                    sf.b.X1().u(NotificationsSettingsActivity.this.SilentTImes);
                    NotificationsSettingsActivity.this.isDirty = true;
                }
            }, this.SilentTImes[0].getHours(), this.SilentTImes[0].getMinutes(), this.is24HourFormat);
            this.toTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() { // from class: com.scores365.ui.NotificationsSettingsActivity.3
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public void onTimeSet(TimePicker timePicker, int i10, int i11) {
                    NotificationsSettingsActivity.this.SilentTImes[1] = NotificationsSettingsActivity.this.getTimeDate(i10, i11);
                    NotificationsSettingsActivity notificationsSettingsActivity = NotificationsSettingsActivity.this;
                    notificationsSettingsActivity.setTimeLogic(notificationsSettingsActivity.is24HourFormat, NotificationsSettingsActivity.this.SilentTImes[1], NotificationsSettingsActivity.this.tvToHour, NotificationsSettingsActivity.this.tvToMinute, NotificationsSettingsActivity.this.tvToAmpm);
                    sf.b.X1().u(NotificationsSettingsActivity.this.SilentTImes);
                    NotificationsSettingsActivity.this.isDirty = true;
                }
            }, this.SilentTImes[1].getHours(), this.SilentTImes[1].getMinutes(), this.is24HourFormat);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private String isAmOrPm(Date date) {
        String str;
        try {
            int hours = date.getHours();
            if (hours >= 0 && hours < 12) {
                str = "AM";
            } else if (hours < 12 || hours > 23) {
                return "";
            } else {
                str = "PM";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        try {
            Intent intent = new Intent(getApplicationContext(), GeneralNotifications.class);
            intent.setFlags(67108864);
            startActivity(intent);
            ee.k.h(getApplicationContext(), "settings", "notifications", "general-notifications-click");
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1(View view) {
        try {
            FaqOptions faqOptions = new FaqOptions();
            faqOptions.showContactUsOnFaqNotHelpful(false);
            faqOptions.showContactUsOnFaqScreens(false);
            faqOptions.showContactUsOnAppBar(false);
            Freshchat.showFAQs(App.m(), faqOptions);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        String str;
        try {
            if (sf.a.i0(getApplicationContext()).H0()) {
                sf.a.i0(getApplicationContext()).Z1(false);
                str = "unselect";
            } else {
                sf.a.i0(getApplicationContext()).Z1(true);
                str = "select";
            }
            this.isDirty = true;
            ee.k.o(getApplicationContext(), "settings", "notifications", "enable-notifications", "click", ServerProtocol.DIALOG_PARAM_STATE, str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        String str;
        try {
            if (sf.b.X1().m4()) {
                sf.b.X1().K7(false);
                str = "2";
            } else {
                sf.b.X1().K7(true);
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            ee.k.o(getApplicationContext(), "settings", "notifications", "enable-betting-notifications", "click", ServerProtocol.DIALOG_PARAM_STATE, str, ShareConstants.FEED_SOURCE_PARAM, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            this.isDirty = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) {
        String str;
        try {
            if (sf.b.X1().p4()) {
                sf.b.X1().S7(false);
                str = "unselect";
            } else {
                sf.b.X1().S7(true);
                str = "select";
            }
            this.isDirty = true;
            ee.k.o(getApplicationContext(), "settings", "notifications", "enable-news-notifications", "click", ServerProtocol.DIALOG_PARAM_STATE, str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(View view) {
        String str;
        try {
            if (sf.a.i0(getApplicationContext()).C0()) {
                sf.a.i0(getApplicationContext()).d2(false);
                str = "unselect";
            } else {
                sf.a.i0(getApplicationContext()).d2(true);
                str = "select";
            }
            this.isDirty = true;
            ee.k.o(getApplicationContext(), "settings", "notifications", "play-sound-click", null, ServerProtocol.DIALOG_PARAM_STATE, str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(View view) {
        try {
            boolean S4 = sf.b.X1().S4();
            sf.b.X1().C8(!S4);
            String str = S4 ? "unselect" : "select";
            this.isDirty = true;
            ee.k.o(getApplicationContext(), "settings", "notification", "night-mode-click", null, ServerProtocol.DIALOG_PARAM_STATE, str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7() {
        this.isVibrationEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$8(View view) {
        ee.k.o(App.m(), "notification", "disabled", "click", null, "page", "notifications-tab");
        Intent intent = new Intent();
        Context m10 = App.m();
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", m10.getPackageName());
            } else if (i10 >= 25) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", m10.getPackageName());
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.putExtra("app_package", m10.getPackageName());
                intent.putExtra("app_uid", m10.getApplicationInfo().uid);
            }
            intent.setData(Uri.fromParts("package", App.m().getPackageName(), null));
            intent.setFlags(268435456);
            m10.startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", App.m().getPackageName(), null));
            m10.startActivity(intent);
        }
    }

    private void setListeners() {
        try {
            this.llGeneralNotificationsBtn.setOnClickListener(this.generalNotifListener);
            this.llPushOnOffBtn.setOnClickListener(this.pushOnOffClickLinstener);
            this.scOddsPushOnOffBtn.setOnClickListener(this.oddsOnOffClickListener);
            this.llNewsPushOnOffBtn.setOnClickListener(this.pushOnOffNewsClickLinstener);
            this.llSoundOnOffBtn.setOnClickListener(this.soundOnOffClickLinstener);
            this.llSilentOnOffBtn.setOnClickListener(this.silentModeOnOffClickLinstener);
            this.llVibrateOnOffBtn.setOnClickListener(this.vibrateOnOffClickLinstener);
            this.llFeedbackBtn.setOnClickListener(this.feedBackClickListener);
            this.tvFromTitle.setOnClickListener(this.fromClickListener);
            this.tvFromHour.setOnClickListener(this.fromClickListener);
            this.tvFromMinute.setOnClickListener(this.fromClickListener);
            this.tvFromAmpm.setOnClickListener(this.fromClickListener);
            this.tvToTitle.setOnClickListener(this.toClickListener);
            this.tvToHour.setOnClickListener(this.toClickListener);
            this.tvToMinute.setOnClickListener(this.toClickListener);
            this.tvToAmpm.setOnClickListener(this.toClickListener);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setNewsNotificationValue() {
        try {
            this.llNewsPushOnOffBtn.setChecked(sf.b.X1().p4());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setNotificationValue() {
        try {
            this.llPushOnOffBtn.setChecked(sf.a.i0(getApplicationContext()).H0());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setSilentTimeValue() {
        try {
            this.llSilentOnOffBtn.setChecked(sf.b.X1().S4());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setSoundValue() {
        try {
            this.llSoundOnOffBtn.setChecked(sf.a.i0(getApplicationContext()).C0());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeLogic(boolean z10, Date date, TextView textView, TextView textView2, TextView textView3) {
        try {
            String str = getTimeStrings(date, this.is24HourFormat).split(CertificateUtil.DELIMITER)[0];
            String str2 = getTimeStrings(date, this.is24HourFormat).split(CertificateUtil.DELIMITER)[1];
            textView.setText(str);
            textView2.setText(str2);
            if (this.is24HourFormat) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(isAmOrPm(date));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setVibrateValue() {
        try {
            this.llVibrateOnOffBtn.setChecked(sf.b.X1().a5());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void updateTextViews() {
        try {
            this.toolbar.setTitle(p0.l0("SETTINGS_TITLE"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            this.tvOddsPushTitle.setText(p0.l0("TIPS_BETTING_NOTIFICATION"));
            this.tvNotificationTitle.setText(p0.l0("GENERAL_NOTIFICATIONS"));
            this.tvGeneralNotificationsTitle.setText(p0.l0("GENERAL_NOTIFICATIONS"));
            this.tvPushTitle.setText(p0.l0("SETTINGS_ENABLE_NOTIFICATIONS"));
            this.tvNewsPushTitle.setText(p0.l0("SETTINGS_NEWS_NOTIFICATIONS"));
            this.tvSoundTitle.setText(p0.l0("SETTINGS_ENABLE_SOUNDS"));
            this.tvSilentTitle.setText(p0.l0("NIGHT_MODE"));
            this.tvFeedbackTitle.setText(p0.l0("FEEDBACK"));
            this.tvVibrateTitle.setText(p0.l0("ENABLE_VIBRATION"));
            this.tvNotificationTitle.setTypeface(o0.c(getApplicationContext()));
            this.tvOddsPushTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvGeneralNotificationsTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvPushTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvNewsPushTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvSoundTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvSilentTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvFeedbackTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvVibrateTitle.setTypeface(o0.d(getApplicationContext()));
            this.tvOddsPushTitle.setGravity(x0.L());
            this.tvNotificationTitle.setGravity(x0.L() | 80);
            this.tvGeneralNotificationsTitle.setGravity(x0.L());
            this.tvPushTitle.setGravity(x0.L());
            this.tvNewsPushTitle.setGravity(x0.L());
            this.tvSoundTitle.setGravity(x0.L());
            this.tvSilentTitle.setGravity(x0.L());
            this.tvVibrateTitle.setGravity(x0.L());
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public int getAppIcon() {
        return 0;
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("SETTINGS_CATEGORY_NOTIFICATIONS");
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.j2(this);
        x0.D1(this);
        setContentView(R.layout.f22626n);
        this.notificationsDisabledView = (ConstraintLayout) findViewById(R.id.Si);
        this.titleTV = (TextView) findViewById(R.id.Ti);
        this.deviceSettingsTV = (TextView) findViewById(R.id.Ri);
        this.bellIV = (ImageView) findViewById(R.id.Qi);
        this.clSilentTimeContainer = (ConstraintLayout) findViewById(R.id.f22284s3);
        if (x0.l1()) {
            LayoutInflater.from(this).inflate(R.layout.f22619m5, this.clSilentTimeContainer);
        } else {
            LayoutInflater.from(this).inflate(R.layout.f22606l5, this.clSilentTimeContainer);
        }
        e1.I0(findViewById(R.id.Fn), x0.m0());
        try {
            initActionBar();
            initViews();
            updateTextViews();
            setListeners();
            initiateDatePickers();
            setNotificationValue();
            this.scOddsPushOnOffBtn.setChecked(sf.b.X1().m4());
            setNewsNotificationValue();
            setSoundValue();
            setSilentTimeValue();
            setVibrateValue();
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            this.toolbar.setElevation(p0.s(4));
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onPause() {
        try {
            super.onPause();
            if (this.isDirty) {
                x0.A2(null, null);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        super.onResume();
        initActionBar();
        handleNotificationsDisabledView();
    }
}
