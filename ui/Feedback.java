package com.scores365.ui;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.FileProvider;
import androidx.core.view.e1;
import com.scores365.App;
import com.scores365.Quiz.Activities.QuizWelcomePromotionActivity;
import com.scores365.R;
import com.scores365.didomi.DidomiNoticeActivity;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.NotifiedUpdateObj;
import com.scores365.entitys.SportTypeObj;
import com.scores365.leadForm.activities.LeadFormActivity;
import com.scores365.ui.Feedback;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.Vector;
import java.util.regex.Pattern;
import li.l0;
import li.n0;
import li.o0;
import li.p0;
import li.x0;
import li.y0;
import tf.b;
/* loaded from: classes2.dex */
public class Feedback extends com.scores365.Design.Activities.c {
    private static final int PICK_ACCOUNT_REQUEST = 132;
    private AppCompatEditText feed;
    private final boolean sendEmail = false;
    private Dialog progress = null;
    private boolean isUserCanSend = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.Feedback$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0(DialogInterface dialogInterface, int i10) {
            Feedback.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$popAlertDialog$1(DialogInterface dialogInterface, int i10) {
        }

        private void popAlertDialog() {
            try {
                p0.G0(Feedback.this, p0.l0("FEEDBACK_WRITE_TWO_WORDS"), "OK", null, new DialogInterface.OnClickListener() { // from class: com.scores365.ui.p
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        Feedback.AnonymousClass1.lambda$popAlertDialog$1(dialogInterface, i10);
                    }
                }, null).show();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z10;
            Intent newChooseAccountIntent;
            if (Feedback.this.isUserCanSend) {
                Feedback.this.isUserCanSend = false;
                if (!x0.o1(Feedback.this.getApplicationContext())) {
                    try {
                        p0.I0(Feedback.this.getApplicationContext(), "OK", null, new DialogInterface.OnClickListener() { // from class: com.scores365.ui.q
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i10) {
                                Feedback.AnonymousClass1.this.lambda$onClick$0(dialogInterface, i10);
                            }
                        }, null).show();
                        Feedback.this.isUserCanSend = true;
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                try {
                    String trim = Feedback.this.feed.getText().toString().trim();
                    if (trim.split(" ").length <= 1) {
                        z10 = false;
                        if (!trim.equals("") || !z10) {
                            popAlertDialog();
                            Feedback.this.isUserCanSend = true;
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            newChooseAccountIntent = AccountManager.newChooseAccountIntent(null, null, new String[]{"com.google"}, null, null, null, null);
                            Feedback.this.startActivityForResult(newChooseAccountIntent, Feedback.PICK_ACCOUNT_REQUEST);
                        }
                        Feedback.this.isUserCanSend = false;
                        return;
                    }
                    z10 = true;
                    if (!trim.equals("")) {
                    }
                    popAlertDialog();
                    Feedback.this.isUserCanSend = true;
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.Feedback$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements Runnable {
        long timer;

        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(DialogInterface dialogInterface, int i10) {
            try {
                dialogInterface.dismiss();
                Feedback.this.finish();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            try {
                p0.u0(Feedback.this.progress);
                AlertDialog.Builder builder = new AlertDialog.Builder(Feedback.this);
                builder.setMessage(p0.l0("FEEDBACK_THANKYOU"));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.scores365.ui.r
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        Feedback.AnonymousClass2.this.lambda$run$0(dialogInterface, i10);
                    }
                });
                builder.show();
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timer = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            Iterator<SportTypeObj> it = App.l().getSportTypes().values().iterator();
            while (true) {
                boolean z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                SportTypeObj next = it.next();
                for (CompObj compObj : sf.b.X1().Z2().values()) {
                    if (compObj.getSportID() == next.getID()) {
                        if (z10) {
                            sb2.append(next.getName());
                            sb2.append(": ");
                            z10 = false;
                        }
                        if (sf.a.i0(Feedback.this.getApplicationContext()).p1(compObj.getID())) {
                            sb3.append(compObj.getName());
                            sb3.append(": ");
                            for (int i10 = 0; i10 < App.l().getNotifiedUpdates().size(); i10++) {
                                NotifiedUpdateObj notifiedUpdateObj = App.l().getNotifiedUpdates().get(i10);
                                if (notifiedUpdateObj.sportTypeId() == next.getID() && sf.a.i0(Feedback.this.getApplicationContext()).q1(compObj.getID(), notifiedUpdateObj.getID())) {
                                    sb3.append(notifiedUpdateObj.getName());
                                    sb3.append(", ");
                                }
                            }
                        }
                        sb2.append(compObj.getName());
                        sb2.append(", ");
                    }
                }
            }
            StringBuilder sb4 = new StringBuilder();
            for (SportTypeObj sportTypeObj : App.l().getSportTypes().values()) {
                boolean z11 = true;
                for (CompetitionObj competitionObj : sf.b.X1().X2().values()) {
                    if (competitionObj.getSid() == sportTypeObj.getID()) {
                        if (z11) {
                            sb4.append(sportTypeObj.getName());
                            sb4.append(": ");
                            z11 = false;
                        }
                        sb4.append(competitionObj.getName());
                        sb4.append(", ");
                    }
                }
            }
            try {
                new com.scores365.api.f(Feedback.this.getApplicationContext(), Feedback.this.feed.getText().toString(), Feedback.this.getPackageManager().getPackageInfo(Feedback.this.getPackageName(), 0).versionName, Build.VERSION.RELEASE, x0.Z(), TimeZone.getDefault().getID(), Feedback.this.getApplicationContext().getResources().getConfiguration().locale.getCountry(), App.l().getLanguages().get(Integer.valueOf(sf.a.i0(Feedback.this.getApplicationContext()).k0())).getName(), x0.r0(Feedback.this.getApplicationContext()), sb2.toString(), sb4.toString(), sb3.toString(), sf.b.X1().M2(), x0.a0()).call();
                Feedback.this.runOnUiThread(new Runnable() { // from class: com.scores365.ui.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        Feedback.AnonymousClass2.this.lambda$run$1();
                    }
                });
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class textWatchListener implements TextWatcher {
        WeakReference<androidx.appcompat.app.d> activityWeakReference;

        public textWatchListener(androidx.appcompat.app.d dVar) {
            this.activityWeakReference = new WeakReference<>(dVar);
        }

        private void changeBet365SurveyData() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(App.m()).edit();
            edit.putBoolean("didUserSeeBet365Survey", false);
            edit.apply();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("token")) {
                    Feedback.this.feed.setText(sf.b.X1().J0());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("deviceid")) {
                    String F2 = sf.b.X1().F2();
                    Feedback.this.feed.setText(F2);
                    ((ClipboardManager) Feedback.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("365scores", F2));
                }
                if (Feedback.this.feed.getText().toString().equals("really??")) {
                    Feedback.this.feed.setText("Noooooooooo!!!!!");
                }
                if (Feedback.this.feed.getText().toString().equals("moblers")) {
                    Feedback.this.feed.setText("if (i==1 && i>1) \n { log.d(\"Great Programmer wrote this code!\"); }");
                }
                if (Feedback.this.feed.getText().toString().equals("sunny")) {
                    Feedback.this.feed.setText("I found a bug!!!");
                }
                if (Feedback.this.feed.getText().toString().equals("quiz")) {
                    Feedback.this.startActivity(new Intent(App.m(), QuizWelcomePromotionActivity.class));
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("openLead")) {
                    Feedback.this.startActivity(LeadFormActivity.H.a("feedback"));
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("appreviewtest")) {
                    Toast.makeText(App.m(), "Starting process for app review", 0).show();
                    th.e.f39731a.e(Feedback.this);
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("resetLeadForm")) {
                    sf.b.X1().o9("");
                    sf.b.X1().n9("");
                    sf.b.X1().u9("");
                    sf.b.X1().v9("");
                    sf.b.X1().t9("");
                    sf.b.X1().w7(-1);
                    sf.b.X1().v7(false);
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("changeserver")) {
                    ChangeServerDataActivity.startActivity(Feedback.this.getApplicationContext());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("getinit")) {
                    Feedback.this.reactToGetinit();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("developer_mode")) {
                    boolean L3 = sf.b.X1().L3();
                    sf.b.X1().e6(!L3);
                    Toast.makeText(App.m(), L3 ? "developer mode turned off" : "developer mode turned on", 0).show();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("bug_ori")) {
                    Feedback.this.feed.setText(Feedback.this.get_oris_bug_data());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("show_init")) {
                    Feedback.this.feed.setText(sf.a.i0(App.m()).s0());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("notification_sound")) {
                    Feedback.this.reactToGetNotifications();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("print_channels")) {
                    Feedback.this.printChannels();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("delete_channels")) {
                    x0.w(true, null);
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("appVersion")) {
                    PackageInfo packageInfo = Feedback.this.getPackageManager().getPackageInfo(Feedback.this.getPackageName(), 0);
                    Toast.makeText(App.m(), packageInfo.versionName + " " + packageInfo.versionCode, 0).show();
                }
                if (Feedback.this.feed.getText().toString().trim().equalsIgnoreCase("clearWWWVotes")) {
                    sf.a.i0(App.m()).G();
                    sf.a.i0(App.m()).F();
                    Toast.makeText(App.m(), "cleared who will will votes", 0).show();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("clearGameBlackList")) {
                    sf.a.i0(App.m()).C();
                    Toast.makeText(App.m(), "Black list of games is cleared", 0).show();
                }
                if (Feedback.this.feed.getText().toString().trim().equalsIgnoreCase("gameBlackList")) {
                    Feedback.this.feed.setText(y0.f34692a.a());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("giveMeCoinsNow")) {
                    od.a.D().l0(500);
                    Toast.makeText(App.m(), "500 coins added", 0).show();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("getbucketdata")) {
                    Feedback.this.shareBucketData();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("notificationsLinks")) {
                    Feedback.this.reactToGetNotificationsLinks();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("resetGcEventTooltip")) {
                    Feedback.this.resetGcEventTooltip();
                    Toast.makeText(App.m(), "reset GC Event Tooltip", 0).show();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("didomi_screen")) {
                    Feedback.this.startActivity(new Intent(App.m(), DidomiNoticeActivity.class));
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("usingVPN")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("check 1: ");
                    String str = "YES";
                    sb2.append(x0.w1() ? "YES" : "NO");
                    sb2.append("\ncheck 2: ");
                    if (!x0.x1()) {
                        str = "NO";
                    }
                    sb2.append(str);
                    Feedback.this.feed.setText(sb2.toString());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("get_tcf_data")) {
                    Feedback.this.reactToGetDidomiTCF(tf.b.f39719a.k());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("get_tcf_backup_data")) {
                    Feedback.this.reactToGetDidomiTCF(tf.b.f39719a.j());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("tcf_test")) {
                    Feedback.this.testDidomiMgr();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("tcf_delete")) {
                    tf.b.f39719a.c();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("tcf_restore_backup")) {
                    tf.b.f39719a.o();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("didomi_version_up")) {
                    sf.b.X1().j6(sf.b.X1().q0() + 1);
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("tcfbitest")) {
                    Feedback feedback = Feedback.this;
                    feedback.tcfBiTests(feedback.getInterstitialController());
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("getCounters")) {
                    Feedback.this.printCounters();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("Adjust_attr")) {
                    Feedback.this.printCounters();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("Follow_Behaviour")) {
                    Feedback.this.printFollowBehaviourCounters();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("bet365survey")) {
                    changeBet365SurveyData();
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("isReleaseVersion")) {
                    Feedback.this.feed.setText("Release");
                }
                if (Feedback.this.feed.getText().toString().equalsIgnoreCase("sendLogs")) {
                    Feedback.this.SendTraceLog();
                }
                if (Feedback.this.feed.getText().toString().trim().equalsIgnoreCase("printInstall")) {
                    Feedback.this.feed.setText(new Date(x0.f0()).toString());
                }
            } catch (Exception e10) {
                Feedback.this.feed.setText(e10.getMessage());
                x0.N1(e10);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SendTraceLog() {
        ng.a.f35508a.c("FEEDBACK", "on demand trace", new n0("Sent from feedback", null));
    }

    private String[] getEmailsForShare() {
        try {
            return p0.l0("EMAILS_FOR_DATA").split(",");
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    private String getSoundPerEntity() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("Games:\n");
            Iterator<Integer> it = App.b.m().iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (sf.a.i0(App.m()).k1(next.intValue())) {
                    sb2.append("Game id: ");
                    sb2.append(next);
                    sb2.append("\nNotifications:\n");
                    Iterator<Integer> it2 = sf.a.i0(App.m()).p0(next.intValue()).iterator();
                    while (it2.hasNext()) {
                        Integer next2 = it2.next();
                        sb2.append(getTextForNotification(next2.intValue(), sf.a.i0(App.m()).o0(next.intValue(), next2.intValue())));
                    }
                }
            }
            sb2.append("\n----------------------------------------------------------------------");
            sb2.append("\nCompetitors:\n");
            Iterator<CompObj> it3 = App.b.l().iterator();
            while (it3.hasNext()) {
                CompObj next3 = it3.next();
                if (sf.a.i0(App.m()).p1(next3.getID())) {
                    sb2.append(next3.getID());
                    sb2.append(" ");
                    sb2.append(next3.getName());
                    sb2.append("\nNotifications:\n");
                    Iterator<Integer> it4 = sf.a.i0(App.m()).M0(next3.getID()).iterator();
                    while (it4.hasNext()) {
                        Integer next4 = it4.next();
                        sb2.append(getTextForNotification(next4.intValue(), sf.a.i0(App.m()).L0(next3.getID(), next4.intValue())));
                    }
                    sb2.append("\n");
                }
            }
            sb2.append("\n----------------------------------------------------------------------");
            sb2.append("\nCompetitions:\n");
            Iterator<CompetitionObj> it5 = App.b.i().iterator();
            while (it5.hasNext()) {
                CompetitionObj next5 = it5.next();
                if (sf.a.i0(App.m()).m1(next5.getID())) {
                    sb2.append(next5.getID());
                    sb2.append(" ");
                    sb2.append(next5.getName());
                    sb2.append("\nNotifications:\n");
                    Iterator<Integer> it6 = sf.a.i0(App.m()).v0(next5.getID()).iterator();
                    while (it6.hasNext()) {
                        Integer next6 = it6.next();
                        sb2.append(getTextForNotification(next6.intValue(), sf.a.i0(App.m()).u0(next5.getID(), next6.intValue())));
                    }
                    sb2.append("\n");
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    private String getTextForNotification(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("notification id: ");
            sb2.append(i10);
            sb2.append(" | sound id: ");
            sb2.append(i11);
            sb2.append(" | sound name: ");
            sb2.append(l0.j(i11));
            sb2.append("\n");
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public String get_oris_bug_data() {
        App.b.q();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isWizardFinished : " + sf.b.X1().b5() + '\n');
        sb2.append("getInitObj Null : ");
        sb2.append(App.l() == null);
        sb2.append('\n');
        sb2.append("getCatalogExist : ");
        sb2.append(sf.a.i0(App.m()).h0());
        sb2.append('\n');
        sb2.append("GetcompetitorsCount : ");
        sb2.append(App.b.p());
        sb2.append('\n');
        sb2.append("IsCatalogExist : ");
        sb2.append(re.h.g());
        sb2.append('\n');
        sb2.append("catalog competitions count : ");
        sb2.append(sf.a.i0(App.m()).Y().size());
        sb2.append('\n');
        sb2.append("catalog competitors count : ");
        sb2.append(sf.a.i0(App.m()).b0().size());
        sb2.append('\n');
        sb2.append("catalog countries count : ");
        sb2.append(sf.a.i0(App.m()).d0().size());
        sb2.append('\n');
        sb2.append("catalog examples \n");
        CompObj a02 = sf.a.i0(App.m()).a0(PICK_ACCOUNT_REQUEST);
        sb2.append("catalog team : ");
        sb2.append(a02 == null ? "null" : a02.getName());
        sb2.append('\n');
        Vector<CompetitionObj> Z = sf.a.i0(App.m()).Z("11");
        sb2.append("catalog league : ");
        sb2.append(Z.size() != 0 ? Z.get(0).getName() : "null");
        sb2.append('\n');
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$0(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            sendData();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$popAlertDialog$1(DialogInterface dialogInterface, int i10) {
    }

    private void popAlertDialog() {
        try {
            p0.G0(this, p0.l0("FEEDBACK_WRITE_TWO_WORDS"), "OK", null, new DialogInterface.OnClickListener() { // from class: com.scores365.ui.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    Feedback.lambda$popAlertDialog$1(dialogInterface, i10);
                }
            }, null).show();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printCounters() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Adjust network: ");
        sb2.append(sf.b.X1().E2());
        sb2.append("\n");
        sb2.append("campaign: ");
        sb2.append(sf.b.X1().C2());
        sb2.append("\n");
        sb2.append("ad_group: ");
        sb2.append(sf.b.X1().B2());
        sb2.append("\n");
        sb2.append("creative: ");
        sb2.append(sf.b.X1().D2());
        this.feed.setText(sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printFollowBehaviourCounters() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("not interseted counter: ");
        sb2.append(sf.b.X1().F0());
        sb2.append("\n\n");
        sb2.append("days past since last time user saw popup: ");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(sf.b.X1().E0());
        sb2.append(x0.U(calendar.getTime(), "dd/MM/yyyy"));
        sb2.append("\n\n");
        sb2.append("DB data: \n");
        ArrayList<vf.c> m02 = sf.a.i0(App.m()).m0();
        HashMap hashMap = new HashMap();
        Iterator<vf.c> it = m02.iterator();
        while (it.hasNext()) {
            vf.c next = it.next();
            sb2.append("id: ");
            sb2.append(next.c());
            sb2.append(", type: ");
            sb2.append(next.d());
            sb2.append(", last interaction day: ");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(6, (int) (next.b() % 365));
            sb2.append(x0.U(calendar2.getTime(), "dd/MM/yyyy"));
            sb2.append(", count in day: ");
            sb2.append(next.a());
            sb2.append("\n");
            if (!hashMap.containsKey(Integer.valueOf(next.d()))) {
                hashMap.put(Integer.valueOf(next.d()), new HashMap());
            }
            if (!((HashMap) hashMap.get(Integer.valueOf(next.d()))).containsKey(Integer.valueOf(next.c()))) {
                ((HashMap) hashMap.get(Integer.valueOf(next.d()))).put(Integer.valueOf(next.c()), 0);
            }
            ((HashMap) hashMap.get(Integer.valueOf(next.d()))).put(Integer.valueOf(next.c()), Integer.valueOf(((Integer) ((HashMap) hashMap.get(Integer.valueOf(next.d()))).get(Integer.valueOf(next.c()))).intValue() + next.a()));
        }
        sb2.append("interaction summary: \n");
        for (Integer num : hashMap.keySet()) {
            sb2.append("type: ");
            sb2.append(num);
            sb2.append("\n");
            for (Integer num2 : ((HashMap) hashMap.get(num)).keySet()) {
                sb2.append("id: ");
                sb2.append(num2);
                sb2.append(" count: ");
                sb2.append(((HashMap) hashMap.get(num)).get(num2));
                sb2.append("\n");
            }
            sb2.append("\n");
        }
        this.feed.setText(sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reactToGetDidomiTCF(Map<String, ?> map) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : map.keySet()) {
                if (str != null) {
                    if (sb2.length() > 0) {
                        sb2.append("\n");
                    }
                    sb2.append(str);
                    sb2.append("=");
                    sb2.append(map.get(str).toString());
                }
                Log.d("SharedPrefs", "reactToGetSharedPrefs: " + str);
            }
            if (sb2.length() <= 0) {
                this.feed.setText("No Data");
                return;
            }
            x0.q("TCF_fromSharedPrefs.txt", sb2.toString());
            File file = new File(App.m().getFilesDir(), "TCF_fromSharedPrefs.txt");
            Uri f10 = FileProvider.f(App.m(), getResources().getString(R.string.f22817f), file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra("android.intent.extra.EMAIL", getEmailsForShare());
            intent.putExtra("android.intent.extra.STREAM", f10);
            intent.putExtra("android.intent.extra.SUBJECT", "365Scores SharedPrefs Data");
            startActivity(Intent.createChooser(intent, "Send 365Scores SharedPrefs Data"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reactToGetNotifications() {
        try {
            x0.q("notifications_data.txt", getSoundPerEntity());
            File file = new File(App.m().getFilesDir(), "notifications_data.txt");
            Uri f10 = FileProvider.f(App.m(), getResources().getString(R.string.f22817f), file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra("android.intent.extra.EMAIL", getEmailsForShare());
            intent.putExtra("android.intent.extra.STREAM", f10);
            intent.putExtra("android.intent.extra.SUBJECT", "365Scores Notifications Data");
            startActivity(Intent.createChooser(intent, "Send 365Scores Notifications Data"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reactToGetNotificationsLinks() {
        try {
            StringBuilder sb2 = new StringBuilder();
            Set<String> y12 = sf.b.X1().y1();
            for (String str : y12) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(str);
            }
            x0.q("notifications_links.txt", y12.toString());
            File file = new File(App.m().getFilesDir(), "notifications_links.txt");
            Uri f10 = FileProvider.f(App.m(), getResources().getString(R.string.f22817f), file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra("android.intent.extra.EMAIL", getEmailsForShare());
            intent.putExtra("android.intent.extra.STREAM", f10);
            intent.putExtra("android.intent.extra.SUBJECT", "365Scores Notifications Links Data");
            startActivity(Intent.createChooser(intent, "Send 365Scores Notifications Links Data"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reactToGetinit() {
        try {
            x0.q("init_content.txt", sf.a.i0(App.m()).s0());
            File file = new File(App.m().getFilesDir(), "init_content.txt");
            Uri f10 = FileProvider.f(App.m(), getResources().getString(R.string.f22817f), file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra("android.intent.extra.EMAIL", getEmailsForShare());
            intent.putExtra("android.intent.extra.STREAM", f10);
            intent.putExtra("android.intent.extra.SUBJECT", "365Scores Init Data");
            startActivity(Intent.createChooser(intent, "Send 365Scores Init Data"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetGcEventTooltip() {
        try {
            sf.b.X1().D6(0);
            sf.b.X1().B6(0);
            sf.b.X1().C6(false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void sendData() {
        this.progress = p0.H0(this, "", null);
        new Thread(new AnonymousClass2()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareBucketData() {
        try {
            x0.q("bucket_data.txt", x0.I());
            File file = new File(App.m().getFilesDir(), "bucket_data.txt");
            Uri f10 = FileProvider.f(App.m(), getResources().getString(R.string.f22817f), file);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("vnd.android.cursor.dir/email");
            intent.putExtra("android.intent.extra.EMAIL", getEmailsForShare());
            intent.putExtra("android.intent.extra.STREAM", f10);
            intent.putExtra("android.intent.extra.SUBJECT", "365Scores bucket Data");
            startActivity(Intent.createChooser(intent, "Send 365Scores bucket Data"));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void submit() {
        boolean z10;
        try {
            String trim = this.feed.getText().toString().trim();
            if (trim.split(" ").length <= 1) {
                z10 = false;
                if (trim.equals("") && z10) {
                    sendData();
                    this.isUserCanSend = false;
                } else {
                    popAlertDialog();
                    this.isUserCanSend = true;
                }
            }
            z10 = true;
            if (trim.equals("")) {
            }
            popAlertDialog();
            this.isUserCanSend = true;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tcfBiTests(@NonNull uc.d dVar) {
        try {
            SharedPreferences Y1 = sf.b.Y1();
            Y1.edit().putInt("IABTCF_gdprApplies", 1).putInt("IABTCF_String", 1).putInt("IABTCF_SHALOM_SHALOM_TEST", 1).apply();
            sc.i iVar = sc.i.Dashboard;
            sc.a aVar = sc.a.DFP;
            new ec.b(dVar, iVar, 1, aVar, "").h(null, this, false, false);
            Y1.edit().remove("IABTCF_gdprApplies").remove("IABTCF_String").remove("IABTCF_SHALOM_SHALOM_TEST").apply();
            new ec.b(dVar, iVar, 1, aVar, "").h(null, this, false, false);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void testDidomiMgr() {
        try {
            String str = "IABTCF_" + System.currentTimeMillis();
            Thread.sleep(10L);
            String str2 = "IABTCF_" + System.currentTimeMillis();
            sf.b.Y1().edit().putInt(str, 666).commit();
            sf.b.Y1().edit().putString(str2, "aa111").commit();
            b.a aVar = tf.b.f39719a;
            Map<String, Object> k10 = aVar.k();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get TCF Params test: ");
            boolean z10 = true;
            sb2.append(Boolean.parseBoolean(String.valueOf(k10.containsKey(str) && k10.containsKey(str2))));
            Log.d("heyhey", sb2.toString());
            aVar.b();
            Map<String, Object> j10 = aVar.j();
            String str3 = "TCFBACKUP_" + str;
            Thread.sleep(10L);
            String str4 = "TCFBACKUP_" + str2;
            boolean z11 = aVar.k().size() == 0;
            boolean z12 = j10.containsKey(str3) && j10.containsKey(str4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("delete & backup TCF Params test: ");
            sb3.append(z12 && z11);
            Log.d("heyhey", sb3.toString());
            aVar.o();
            Map<String, Object> k11 = aVar.k();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("restored TCF Params test: ");
            if (!k11.containsKey(str) || !k11.containsKey(str2)) {
                z10 = false;
            }
            sb4.append(Boolean.parseBoolean(String.valueOf(z10)));
            Log.d("heyhey", sb4.toString());
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return p0.l0("FEEDBACK");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        try {
            super.onActivityResult(i10, i11, intent);
            if (i10 == PICK_ACCOUNT_REQUEST) {
                if (i11 == -1) {
                    Account[] accounts = AccountManager.get(this).getAccounts();
                    Pattern pattern = Patterns.EMAIL_ADDRESS;
                    int length = accounts.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        }
                        Account account = accounts[i12];
                        if (pattern.matcher(account.name).matches()) {
                            sf.b.X1().t9(account.name);
                            break;
                        }
                        i12++;
                    }
                }
                submit();
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x0.j2(this);
        x0.D1(this);
        setContentView(R.layout.O1);
        e1.I0(findViewById(R.id.Fn), x0.m0());
        initActionBar();
        AppCompatEditText appCompatEditText = (AppCompatEditText) findViewById(R.id.D5);
        this.feed = appCompatEditText;
        appCompatEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.scores365.ui.m
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                boolean lambda$onCreate$0;
                lambda$onCreate$0 = Feedback.this.lambda$onCreate$0(textView, i10, keyEvent);
                return lambda$onCreate$0;
            }
        });
        this.feed.addTextChangedListener(new textWatchListener(this));
        this.feed.setTypeface(o0.d(App.m()));
        Button button = (Button) findViewById(R.id.jp);
        button.setTypeface(o0.d(getApplicationContext()));
        button.setText(p0.l0("SEND"));
        button.setOnClickListener(new AnonymousClass1());
        try {
            TextView textView = (TextView) findViewById(R.id.nz);
            textView.setText(p0.l0("FEEDBACK_GIVE_DETAILS"));
            textView.setTypeface(o0.d(App.m()));
        } catch (Exception unused) {
        }
        try {
            this.toolbar.setElevation(p0.s(4));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        try {
            TextView textView2 = (TextView) findViewById(R.id.ay);
            textView2.setText(p0.l0("SETTINGS_MENU_CONTACT_INFO_URL").replace("\\r\\n", "\n"));
            textView2.setTypeface(o0.d(App.m()));
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

    @Override // androidx.fragment.app.h, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"NeedOnRequestPermissionsResult"})
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, android.app.Activity
    public void onResume() {
        this.feed.requestFocus();
        super.onResume();
    }

    public void printChannels() {
        List<NotificationChannel> notificationChannels;
        List notificationChannels2;
        List notificationChannels3;
        String id2;
        Uri sound;
        CharSequence name;
        boolean shouldVibrate;
        if (Build.VERSION.SDK_INT >= 26) {
            l0.e();
            NotificationManager notificationManager = (NotificationManager) App.m().getSystemService("notification");
            notificationChannels = notificationManager.getNotificationChannels();
            notificationChannels2 = notificationManager.getNotificationChannels();
            if (notificationChannels2 != null) {
                notificationChannels3 = notificationManager.getNotificationChannels();
                if (notificationChannels3.isEmpty()) {
                    return;
                }
                for (NotificationChannel notificationChannel : notificationChannels) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("printChannels print----- sound id: ");
                    id2 = notificationChannel.getId();
                    sb2.append(id2);
                    sb2.append(" | sound uri: ");
                    sound = notificationChannel.getSound();
                    sb2.append(sound);
                    sb2.append(" | channel name: ");
                    name = notificationChannel.getName();
                    sb2.append((Object) name);
                    sb2.append(" | should vibrate: ");
                    shouldVibrate = notificationChannel.shouldVibrate();
                    sb2.append(shouldVibrate);
                    Log.i("ScoresChannel", sb2.toString());
                }
            }
        }
    }
}
