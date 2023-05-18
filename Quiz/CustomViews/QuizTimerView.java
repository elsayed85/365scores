package com.scores365.Quiz.CustomViews;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import java.util.concurrent.TimeUnit;
import li.o0;
import li.x0;
import ud.e;
/* loaded from: classes2.dex */
public class QuizTimerView extends ConstraintLayout {

    /* renamed from: d  reason: collision with root package name */
    private TextView f21457d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21458e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21459f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f21460g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f21461h;

    /* renamed from: i  reason: collision with root package name */
    long f21462i;

    /* renamed from: j  reason: collision with root package name */
    e f21463j;

    /* renamed from: k  reason: collision with root package name */
    boolean f21464k;

    /* renamed from: l  reason: collision with root package name */
    Runnable f21465l;

    /* renamed from: m  reason: collision with root package name */
    Handler f21466m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            e eVar2;
            try {
                QuizTimerView quizTimerView = QuizTimerView.this;
                quizTimerView.f21464k = true;
                long j10 = quizTimerView.f21462i - 1000;
                quizTimerView.f21462i = j10;
                if (j10 <= 0 && (eVar2 = quizTimerView.f21463j) != null) {
                    eVar2.q();
                } else if (j10 > 0 && (eVar = quizTimerView.f21463j) != null) {
                    eVar.d0(j10);
                    QuizTimerView.this.f();
                    Handler handler = QuizTimerView.this.f21466m;
                    if (handler != null) {
                        handler.postDelayed(this, 1000L);
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
    }

    public QuizTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21462i = 0L;
        this.f21464k = false;
        initView();
    }

    public QuizTimerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21462i = 0L;
        this.f21464k = false;
        initView();
    }

    private long getTimeHours() {
        return (long) Math.floor(TimeUnit.MILLISECONDS.toHours(this.f21462i));
    }

    private long getTimeMinutes() {
        return (long) Math.floor(TimeUnit.MILLISECONDS.toMinutes(this.f21462i - TimeUnit.HOURS.toMillis(getTimeHours())));
    }

    private long getTimeSeconds() {
        return (long) Math.floor(TimeUnit.MILLISECONDS.toSeconds(this.f21462i - TimeUnit.MINUTES.toMillis(getTimeMinutes())) % 60);
    }

    private void initView() {
        View.inflate(getContext(), R.layout.f22530f7, this);
        this.f21457d = (TextView) findViewById(R.id.gm);
        this.f21458e = (TextView) findViewById(R.id.hm);
        this.f21459f = (TextView) findViewById(R.id.f22079im);
        this.f21460g = (TextView) findViewById(R.id.fm);
        this.f21461h = (TextView) findViewById(R.id.em);
        this.f21457d.setTypeface(o0.c(App.m()));
        this.f21458e.setTypeface(o0.c(App.m()));
        this.f21459f.setTypeface(o0.c(App.m()));
        this.f21466m = new Handler();
        this.f21465l = new a();
    }

    public boolean d() {
        return this.f21464k;
    }

    public void f() {
        try {
            this.f21457d.setVisibility(8);
            this.f21460g.setVisibility(8);
            if (getTimeHours() != 0) {
                this.f21457d.setText(getTextHours());
                this.f21457d.setVisibility(0);
                this.f21460g.setVisibility(0);
            }
            this.f21458e.setText(getTextMinutes());
            this.f21459f.setText(getTextSeconds());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public long getLeftTime() {
        return this.f21462i;
    }

    public String getTextHours() {
        StringBuilder sb2 = new StringBuilder();
        try {
            long timeHours = getTimeHours();
            if (timeHours >= 1) {
                if (timeHours < 10) {
                    sb2.append('0');
                }
                sb2.append(timeHours);
            } else {
                sb2.append("00");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    public String getTextMinutes() {
        StringBuilder sb2 = new StringBuilder();
        try {
            long timeMinutes = getTimeMinutes();
            if (timeMinutes <= 0) {
                sb2.append("00");
            } else {
                if (timeMinutes < 10) {
                    sb2.append('0');
                }
                sb2.append(timeMinutes);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    public String getTextSeconds() {
        StringBuilder sb2 = new StringBuilder();
        try {
            long timeSeconds = getTimeSeconds() - 1;
            if (timeSeconds >= 1) {
                if (timeSeconds < 10) {
                    sb2.append('0');
                }
                sb2.append(timeSeconds);
            } else {
                sb2.append("00");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }

    public e getTimerEndedListener() {
        return this.f21463j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21465l = null;
        this.f21466m = null;
    }

    public void setNewTimeLeft(long j10) {
        try {
            this.f21462i = j10 - System.currentTimeMillis();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setTimeLeft(long j10) {
        try {
            if (this.f21464k) {
                this.f21462i = j10;
                return;
            }
            this.f21462i = j10 - System.currentTimeMillis();
            this.f21457d.setVisibility(8);
            this.f21460g.setVisibility(8);
            if (getTimeHours() != 0) {
                this.f21457d.setText(getTextHours());
                this.f21457d.setVisibility(0);
                this.f21460g.setVisibility(0);
            }
            this.f21458e.setText(getTextMinutes());
            this.f21459f.setText(getTextSeconds());
            this.f21466m.postDelayed(this.f21465l, 1000L);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setTimerEndedListener(e eVar) {
        this.f21463j = eVar;
    }
}
