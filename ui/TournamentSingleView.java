package com.scores365.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.scores365.App;
import com.scores365.R;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.GameObj;
import li.o0;
import li.p0;
import li.x0;
import qf.c;
/* loaded from: classes2.dex */
public class TournamentSingleView extends ConstraintLayout {
    public qf.c gameData;
    int itemSize;
    public ImageView ivLeftStar;
    public ImageView ivLeftTeam;
    public ImageView ivRightStar;
    public ImageView ivRightTeam;
    private ConstraintLayout rlContainerLayout;
    public TextView tvData;
    public TextView tvGameStatus;
    public TextView tvLeftSeed;
    public TextView tvLeftTeam;
    public TextView tvRightSeed;
    public TextView tvRightTeam;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.TournamentSingleView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$TournamentSingleView$eTvDataStyle;

        static {
            int[] iArr = new int[eTvDataStyle.values().length];
            $SwitchMap$com$scores365$ui$TournamentSingleView$eTvDataStyle = iArr;
            try {
                iArr[eTvDataStyle.PAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$ui$TournamentSingleView$eTvDataStyle[eTvDataStyle.LIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$ui$TournamentSingleView$eTvDataStyle[eTvDataStyle.FUTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum eTvDataStyle {
        PAST,
        LIVE,
        FUTURE
    }

    public TournamentSingleView(Context context) {
        super(context);
        setViewProperties();
    }

    public TournamentSingleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setViewProperties();
    }

    private static String getCompetitorNameToShow(CompObj compObj) {
        try {
            String symbolicName = compObj.getSymbolicName();
            if (symbolicName != null) {
                try {
                    if (!symbolicName.isEmpty()) {
                        return symbolicName;
                    }
                } catch (Exception e10) {
                    e = e10;
                    x0.N1(e);
                    return null;
                }
            }
            String shortName = compObj.getShortName();
            if (shortName == null) {
                return "";
            }
            if (shortName.length() > 2) {
                shortName = shortName.substring(0, 3);
            }
            return shortName.toUpperCase();
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static String getScoreForLiveGame(GameObj gameObj) {
        SpannableString valueOf;
        SpannableString spannableString = new SpannableString("");
        boolean l10 = x0.l(gameObj.homeAwayTeamOrder, true);
        try {
            if (gameObj.getScores() != null) {
                if (l10) {
                    if (gameObj.getScores()[1].getScore() > -1 && gameObj.getScores()[0].getScore() > -1) {
                        valueOf = SpannableString.valueOf(gameObj.getScores()[1].getScore() + " - " + gameObj.getScores()[0].getScore());
                    }
                } else if (gameObj.getScores()[1].getScore() > -1 && gameObj.getScores()[0].getScore() > -1) {
                    valueOf = SpannableString.valueOf(gameObj.getScores()[0].getScore() + " - " + gameObj.getScores()[1].getScore());
                }
                spannableString = valueOf;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return spannableString.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0025, B:8:0x004c, B:10:0x0052, B:12:0x0065, B:37:0x00c1, B:11:0x0057, B:13:0x006b, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x0089, B:23:0x0090, B:26:0x00a3, B:32:0x00b0, B:34:0x00b4, B:35:0x00ba, B:24:0x0098, B:5:0x0017), top: B:42:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba A[Catch: Exception -> 0x00d4, TryCatch #0 {Exception -> 0x00d4, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0025, B:8:0x004c, B:10:0x0052, B:12:0x0065, B:37:0x00c1, B:11:0x0057, B:13:0x006b, B:15:0x0071, B:16:0x007b, B:18:0x0081, B:20:0x0089, B:23:0x0090, B:26:0x00a3, B:32:0x00b0, B:34:0x00b4, B:35:0x00ba, B:24:0x0098, B:5:0x0017), top: B:42:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void initializeSpecificGameObj(java.lang.String r9, com.scores365.entitys.GameObj r10, boolean r11, int r12) {
        /*
            r8 = this;
            int r12 = r10.homeAwayTeamOrder     // Catch: java.lang.Exception -> Ld4
            r0 = 1
            boolean r12 = li.x0.l(r12, r0)     // Catch: java.lang.Exception -> Ld4
            com.scores365.ui.TournamentSingleView$eTvDataStyle r7 = com.scores365.ui.TournamentSingleView.eTvDataStyle.FUTURE     // Catch: java.lang.Exception -> Ld4
            r8.setTvDataSpecs(r7)     // Catch: java.lang.Exception -> Ld4
            boolean r1 = r10.isGameStatusTitleExist()     // Catch: java.lang.Exception -> Ld4
            if (r1 == 0) goto L17
            java.lang.String r1 = r10.getGameStatusTitle()     // Catch: java.lang.Exception -> Ld4
            goto L25
        L17:
            java.util.Date r1 = r10.getSTime()     // Catch: java.lang.Exception -> Ld4
            li.x0$e r2 = li.x0.e.SHORT     // Catch: java.lang.Exception -> Ld4
            java.lang.String r2 = li.x0.H0(r2)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r1 = li.x0.U(r1, r2)     // Catch: java.lang.Exception -> Ld4
        L25:
            android.widget.TextView r2 = r8.tvGameStatus     // Catch: java.lang.Exception -> Ld4
            r2.setText(r1)     // Catch: java.lang.Exception -> Ld4
            r8.setTeamViewsSpecs()     // Catch: java.lang.Exception -> Ld4
            r2 = 0
            r1 = r8
            r3 = r12
            r4 = r9
            r5 = r10
            r6 = r11
            r1.setGameData(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> Ld4
            android.widget.ImageView r9 = r8.ivLeftStar     // Catch: java.lang.Exception -> Ld4
            r11 = 8
            r9.setVisibility(r11)     // Catch: java.lang.Exception -> Ld4
            android.widget.ImageView r9 = r8.ivRightStar     // Catch: java.lang.Exception -> Ld4
            r9.setVisibility(r11)     // Catch: java.lang.Exception -> Ld4
            int r9 = r10.getToQualify()     // Catch: java.lang.Exception -> Ld4
            boolean r11 = r10.isNotStarted()     // Catch: java.lang.Exception -> Ld4
            if (r11 == 0) goto L6b
            boolean r9 = r10.isGameStatusTitleExist()     // Catch: java.lang.Exception -> Ld4
            if (r9 == 0) goto L57
            java.lang.String r9 = r10.getGameStatusTitle()     // Catch: java.lang.Exception -> Ld4
            goto L65
        L57:
            java.util.Date r9 = r10.getSTime()     // Catch: java.lang.Exception -> Ld4
            li.x0$e r10 = li.x0.e.SHORT     // Catch: java.lang.Exception -> Ld4
            java.lang.String r10 = li.x0.H0(r10)     // Catch: java.lang.Exception -> Ld4
            java.lang.String r9 = li.x0.U(r9, r10)     // Catch: java.lang.Exception -> Ld4
        L65:
            android.widget.TextView r10 = r8.tvGameStatus     // Catch: java.lang.Exception -> Ld4
            r10.setText(r9)     // Catch: java.lang.Exception -> Ld4
            goto Lc1
        L6b:
            boolean r11 = r10.getIsActive()     // Catch: java.lang.Exception -> Ld4
            if (r11 == 0) goto L7b
            android.widget.TextView r9 = r8.tvGameStatus     // Catch: java.lang.Exception -> Ld4
            java.lang.String r10 = "Live"
            r9.setText(r10)     // Catch: java.lang.Exception -> Ld4
            com.scores365.ui.TournamentSingleView$eTvDataStyle r7 = com.scores365.ui.TournamentSingleView.eTvDataStyle.LIVE     // Catch: java.lang.Exception -> Ld4
            goto Lc1
        L7b:
            boolean r11 = r10.isFinished()     // Catch: java.lang.Exception -> Ld4
            if (r11 == 0) goto Lc0
            com.scores365.ui.TournamentSingleView$eTvDataStyle r7 = com.scores365.ui.TournamentSingleView.eTvDataStyle.PAST     // Catch: java.lang.Exception -> Ld4
            boolean r11 = r10.isFinished()     // Catch: java.lang.Exception -> Ld4
            if (r11 == 0) goto L98
            boolean r11 = r10.isAbnormal()     // Catch: java.lang.Exception -> Ld4
            if (r11 == 0) goto L90
            goto L98
        L90:
            android.widget.TextView r10 = r8.tvGameStatus     // Catch: java.lang.Exception -> Ld4
            java.lang.String r11 = ""
            r10.setText(r11)     // Catch: java.lang.Exception -> Ld4
            goto La1
        L98:
            android.widget.TextView r11 = r8.tvGameStatus     // Catch: java.lang.Exception -> Ld4
            java.lang.String r10 = r10.getShortGameStatusName()     // Catch: java.lang.Exception -> Ld4
            r11.setText(r10)     // Catch: java.lang.Exception -> Ld4
        La1:
            if (r9 <= 0) goto Lc1
            qf.c r10 = r8.gameData     // Catch: java.lang.Exception -> Ld4
            boolean r10 = r10.w()     // Catch: java.lang.Exception -> Ld4
            if (r10 == 0) goto Lc1
            r10 = 0
            if (r9 != r0) goto Laf
            goto Lb0
        Laf:
            r0 = 0
        Lb0:
            r9 = r12 ^ r0
            if (r9 == 0) goto Lba
            android.widget.ImageView r9 = r8.ivLeftStar     // Catch: java.lang.Exception -> Ld4
            r9.setVisibility(r10)     // Catch: java.lang.Exception -> Ld4
            goto Lc1
        Lba:
            android.widget.ImageView r9 = r8.ivRightStar     // Catch: java.lang.Exception -> Ld4
            r9.setVisibility(r10)     // Catch: java.lang.Exception -> Ld4
            goto Lc1
        Lc0:
            r7 = 0
        Lc1:
            androidx.constraintlayout.widget.ConstraintLayout r9 = r8.rlContainerLayout     // Catch: java.lang.Exception -> Ld4
            android.content.Context r10 = com.scores365.App.m()     // Catch: java.lang.Exception -> Ld4
            int r11 = com.scores365.R.attr.F1     // Catch: java.lang.Exception -> Ld4
            int r10 = li.p0.w(r10, r11)     // Catch: java.lang.Exception -> Ld4
            r9.setBackgroundResource(r10)     // Catch: java.lang.Exception -> Ld4
            r8.setTvDataSpecs(r7)     // Catch: java.lang.Exception -> Ld4
            goto Ld8
        Ld4:
            r9 = move-exception
            li.x0.N1(r9)
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.TournamentSingleView.initializeSpecificGameObj(java.lang.String, com.scores365.entitys.GameObj, boolean, int):void");
    }

    private boolean isEndedNormally(qf.c cVar) {
        try {
            GameObj gameObj = cVar.l()[cVar.l().length - 1].gameObj;
            if (gameObj.isFinished()) {
                return !gameObj.isAbnormal();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static void setDataText(TextView textView, String str, int i10, boolean z10) {
        if (str != null) {
            try {
                int indexOf = str.indexOf(40);
                if (indexOf == -1) {
                    textView.setText(str);
                    return;
                }
                int indexOf2 = str.indexOf(41);
                int lastIndexOf = str.lastIndexOf(40);
                int lastIndexOf2 = str.lastIndexOf(41);
                if (indexOf2 == -1 || lastIndexOf == -1 || lastIndexOf2 == -1) {
                    textView.setText(str);
                    return;
                }
                SpannableString spannableString = new SpannableString(str);
                int i11 = indexOf2 + 1;
                spannableString.setSpan(new AbsoluteSizeSpan(p0.s(i10)), indexOf, i11, 0);
                int i12 = lastIndexOf2 + 1;
                spannableString.setSpan(new AbsoluteSizeSpan(p0.s(i10)), lastIndexOf, i12, 0);
                if (z10) {
                    spannableString.setSpan(new ForegroundColorSpan(p0.A(R.attr.f21556j1)), indexOf, i11, 0);
                    spannableString.setSpan(new ForegroundColorSpan(p0.A(R.attr.f21556j1)), lastIndexOf, i12, 0);
                } else {
                    try {
                        if (textView.getText() instanceof SpannableString) {
                            SpannableString spannableString2 = (SpannableString) textView.getText();
                            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableString2.getSpans(0, textView.getText().length(), ForegroundColorSpan.class)) {
                                spannableString2.removeSpan(foregroundColorSpan);
                            }
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
                textView.setText(spannableString);
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
    }

    private void setGameData(boolean z10, boolean z11, String str, GameObj gameObj, boolean z12) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        try {
            this.ivLeftTeam.setAlpha(1.0f);
            this.ivRightTeam.setAlpha(1.0f);
            if (z11) {
                imageView = this.ivRightTeam;
                imageView2 = this.ivLeftTeam;
                textView = this.tvRightTeam;
                textView2 = this.tvLeftTeam;
                textView3 = this.tvRightSeed;
                textView4 = this.tvLeftSeed;
            } else {
                imageView = this.ivLeftTeam;
                imageView2 = this.ivRightTeam;
                textView = this.tvLeftTeam;
                textView2 = this.tvRightTeam;
                textView3 = this.tvLeftSeed;
                textView4 = this.tvRightSeed;
            }
            textView.setTypeface(o0.d(App.m()));
            textView2.setTypeface(o0.d(App.m()));
            textView3.setTypeface(o0.d(App.m()));
            textView4.setTypeface(o0.d(App.m()));
            if (z10 && gameObj.getWinner() > 0 && !this.gameData.w()) {
                if (gameObj.getWinner() == 1) {
                    textView.setTypeface(o0.a(App.m()));
                } else if (gameObj.getWinner() == 2) {
                    textView2.setTypeface(o0.a(App.m()));
                }
                if (z11 ^ (gameObj.getWinner() == 1)) {
                    this.ivLeftStar.setVisibility(0);
                } else {
                    this.ivRightStar.setVisibility(0);
                }
            }
            setDataText(this.tvData, str, 10, gameObj != null && gameObj.getIsActive());
            if (!z12) {
                nb.p pVar = nb.p.Competitors;
                long id2 = gameObj.getComps()[0].getID();
                boolean z13 = gameObj.getSportID() == 3;
                Integer valueOf = Integer.valueOf(gameObj.getSportID());
                nb.p pVar2 = nb.p.SportTypes;
                li.u.x(nb.o.l(pVar, id2, 70, 70, z13, true, valueOf, pVar2, Integer.valueOf(gameObj.getSportID()), gameObj.getComps()[0].getImgVer()), imageView);
                li.u.x(nb.o.l(pVar, gameObj.getComps()[1].getID(), 70, 70, gameObj.getSportID() == 3, true, Integer.valueOf(gameObj.getSportID()), pVar2, Integer.valueOf(gameObj.getSportID()), gameObj.getComps()[1].getImgVer()), imageView2);
            }
            String competitorNameToShow = getCompetitorNameToShow(gameObj.getComps()[0]);
            String competitorNameToShow2 = getCompetitorNameToShow(gameObj.getComps()[1]);
            textView.setText(competitorNameToShow);
            textView2.setText(competitorNameToShow2);
            textView3.setVisibility(8);
            textView4.setVisibility(8);
            if (gameObj.getComps() != null && this.gameData.w()) {
                String n10 = this.gameData.n(gameObj.getComps()[0].getID());
                if (!n10.isEmpty()) {
                    textView3.setVisibility(0);
                    textView3.setText(n10);
                }
                String n11 = this.gameData.n(gameObj.getComps()[1].getID());
                if (!n11.isEmpty()) {
                    textView4.setVisibility(0);
                    textView4.setText(n11);
                }
            }
            this.tvData.setVisibility(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setGameData(boolean z10, boolean z11, String str, boolean z12, boolean z13) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        this.ivLeftTeam.setAlpha(1.0f);
        this.ivRightTeam.setAlpha(1.0f);
        if (z11) {
            imageView = this.ivRightTeam;
            imageView2 = this.ivLeftTeam;
            textView = this.tvRightTeam;
            textView2 = this.tvLeftTeam;
            textView3 = this.tvRightSeed;
            textView4 = this.tvLeftSeed;
        } else {
            imageView = this.ivLeftTeam;
            imageView2 = this.ivRightTeam;
            textView = this.tvLeftTeam;
            textView2 = this.tvRightTeam;
            textView3 = this.tvLeftSeed;
            textView4 = this.tvRightSeed;
        }
        textView.setTypeface(o0.d(App.m()));
        textView2.setTypeface(o0.d(App.m()));
        textView3.setTypeface(o0.d(App.m()));
        textView4.setTypeface(o0.d(App.m()));
        if (z10 && this.gameData.u() > 0 && !this.gameData.w()) {
            if (this.gameData.u() == 1) {
                textView.setTypeface(o0.a(App.m()));
            } else if (this.gameData.u() == 2) {
                textView2.setTypeface(o0.a(App.m()));
            }
            if ((this.gameData.u() == 1) ^ z11) {
                this.ivLeftStar.setVisibility(0);
            } else {
                this.ivRightStar.setVisibility(0);
            }
        }
        setDataText(this.tvData, str, 10, z12);
        if (!z13) {
            this.gameData.y(imageView, c.a.FIRST);
            this.gameData.y(imageView2, c.a.SECOND);
        }
        String m10 = this.gameData.m(0);
        String m11 = this.gameData.m(1);
        textView.setText(m10);
        textView2.setText(m11);
        textView3.setVisibility(8);
        textView4.setVisibility(8);
        if (this.gameData.g() == null || this.gameData.g().getCompetitors() == null) {
            String str2 = this.gameData.c().seed;
            if (str2 != null && !str2.isEmpty() && this.gameData.w()) {
                textView3.setText(str2);
                textView3.setVisibility(0);
            }
            String str3 = this.gameData.p().seed;
            if (str3 != null && !str3.isEmpty() && this.gameData.w()) {
                textView4.setText(str3);
                textView4.setVisibility(0);
            }
        } else {
            qf.c cVar = this.gameData;
            String n10 = cVar.n(cVar.g().getCompetitors()[0].getID());
            if (!n10.isEmpty() && this.gameData.w()) {
                textView3.setVisibility(0);
                textView3.setText(n10);
            }
            qf.c cVar2 = this.gameData;
            String n11 = cVar2.n(cVar2.g().getCompetitors()[1].getID());
            if (!n11.isEmpty() && this.gameData.w()) {
                textView4.setVisibility(0);
                textView4.setText(n11);
            }
        }
        this.tvData.setVisibility(0);
    }

    private void setTeamViewsSpecs() {
        try {
            this.tvLeftTeam.setTextColor(p0.A(R.attr.U0));
            this.tvRightTeam.setTextColor(p0.A(R.attr.U0));
            this.ivLeftTeam.setImageResource(p0.T(R.attr.f21594w0));
            this.ivRightTeam.setImageResource(p0.T(R.attr.f21594w0));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setTvDataSpecs(eTvDataStyle etvdatastyle) {
        try {
            this.tvData.setBackgroundResource(0);
            this.tvData.setTypeface(o0.c(App.m()));
            int i10 = AnonymousClass1.$SwitchMap$com$scores365$ui$TournamentSingleView$eTvDataStyle[etvdatastyle.ordinal()];
            if (i10 == 1) {
                this.tvData.setTextColor(p0.A(R.attr.f21565m1));
                this.tvGameStatus.setTextColor(p0.A(R.attr.f21565m1));
                this.tvGameStatus.setBackgroundResource(0);
            } else if (i10 == 2) {
                this.tvData.setTextColor(p0.A(R.attr.U0));
                this.tvGameStatus.setTextColor(App.m().getResources().getColor(R.color.f21635y));
                this.tvGameStatus.setBackgroundResource(R.drawable.f21739j4);
            } else if (i10 == 3) {
                this.tvData.setTextColor(p0.A(R.attr.U0));
                this.tvGameStatus.setTextColor(p0.A(R.attr.f21565m1));
                this.tvGameStatus.setBackgroundResource(0);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setViewProperties() {
        try {
            LayoutInflater.from(getContext()).inflate(R.layout.N8, (ViewGroup) this, true);
            this.rlContainerLayout = (ConstraintLayout) findViewById(R.id.Pp);
            this.tvGameStatus = (TextView) findViewById(R.id.Qz);
            this.ivLeftTeam = (ImageView) findViewById(R.id.Tb);
            this.ivRightTeam = (ImageView) findViewById(R.id.Oc);
            this.tvLeftTeam = (TextView) findViewById(R.id.NA);
            this.tvRightTeam = (TextView) findViewById(R.id.iD);
            this.ivLeftStar = (ImageView) findViewById(R.id.f22360vd);
            this.ivRightStar = (ImageView) findViewById(R.id.f22382wd);
            this.tvLeftSeed = (TextView) findViewById(R.id.LA);
            this.tvRightSeed = (TextView) findViewById(R.id.gD);
            this.tvData = (TextView) findViewById(R.id.Hz);
            setBackgroundResource(p0.T(R.attr.F1));
            setDuplicateParentStateEnabled(true);
            this.tvGameStatus.setTypeface(nb.v.m());
            this.tvLeftSeed.setTypeface(nb.v.m());
            this.tvRightSeed.setTypeface(nb.v.m());
            this.tvRightSeed.setTextColor(p0.A(R.attr.U0));
            this.tvLeftSeed.setTextColor(p0.A(R.attr.U0));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void initialize(qf.c cVar, int i10, String str, GameObj gameObj, boolean z10, int i11) {
        try {
            if (gameObj != null) {
                this.gameData = cVar;
                initializeSpecificGameObj(str, gameObj, z10, i11);
            } else {
                initialize(cVar, i10, str, z10, i11);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:2:0x0000, B:4:0x001c, B:6:0x0022, B:8:0x0034, B:10:0x003a, B:12:0x0043, B:32:0x009a, B:34:0x00c2, B:36:0x00cc, B:40:0x00d5, B:11:0x003f, B:13:0x0049, B:15:0x004f, B:17:0x005b, B:19:0x0063, B:21:0x0073, B:23:0x0079, B:27:0x0089, B:25:0x0080, B:26:0x0085, B:28:0x008f), top: B:45:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initialize(qf.c r7, int r8, java.lang.String r9, boolean r10, int r11) {
        /*
            r6 = this;
            r6.itemSize = r8     // Catch: java.lang.Exception -> Ldd
            r6.gameData = r7     // Catch: java.lang.Exception -> Ldd
            r8 = 1
            boolean r2 = li.x0.l(r11, r8)     // Catch: java.lang.Exception -> Ldd
            android.widget.ImageView r11 = r6.ivLeftStar     // Catch: java.lang.Exception -> Ldd
            r0 = 8
            r11.setVisibility(r0)     // Catch: java.lang.Exception -> Ldd
            android.widget.ImageView r11 = r6.ivRightStar     // Catch: java.lang.Exception -> Ldd
            r11.setVisibility(r0)     // Catch: java.lang.Exception -> Ldd
            int r11 = r7.u()     // Catch: java.lang.Exception -> Ldd
            r0 = 0
            if (r11 > 0) goto L49
            boolean r1 = r7.v()     // Catch: java.lang.Exception -> Ldd
            if (r1 != 0) goto L49
            com.scores365.entitys.GroupGameObj[] r11 = r7.l()     // Catch: java.lang.Exception -> Ldd
            com.scores365.entitys.GroupGameObj[] r1 = r7.l()     // Catch: java.lang.Exception -> Ldd
            int r1 = r1.length     // Catch: java.lang.Exception -> Ldd
            int r1 = r1 - r8
            r11 = r11[r1]     // Catch: java.lang.Exception -> Ldd
            com.scores365.entitys.GameObj r11 = r11.gameObj     // Catch: java.lang.Exception -> Ldd
            com.scores365.ui.TournamentSingleView$eTvDataStyle r1 = com.scores365.ui.TournamentSingleView.eTvDataStyle.FUTURE     // Catch: java.lang.Exception -> Ldd
            if (r11 == 0) goto L3f
            boolean r3 = r11.isGameStatusTitleExist()     // Catch: java.lang.Exception -> Ldd
            if (r3 == 0) goto L3f
            java.lang.String r11 = r11.getGameStatusTitle()     // Catch: java.lang.Exception -> Ldd
            goto L43
        L3f:
            java.lang.String r11 = r7.k()     // Catch: java.lang.Exception -> Ldd
        L43:
            android.widget.TextView r3 = r6.tvGameStatus     // Catch: java.lang.Exception -> Ldd
            r3.setText(r11)     // Catch: java.lang.Exception -> Ldd
            goto L99
        L49:
            boolean r1 = r7.v()     // Catch: java.lang.Exception -> Ldd
            if (r1 == 0) goto L59
            com.scores365.ui.TournamentSingleView$eTvDataStyle r1 = com.scores365.ui.TournamentSingleView.eTvDataStyle.LIVE     // Catch: java.lang.Exception -> Ldd
            android.widget.TextView r11 = r6.tvGameStatus     // Catch: java.lang.Exception -> Ldd
            java.lang.String r3 = "Live"
            r11.setText(r3)     // Catch: java.lang.Exception -> Ldd
            goto L99
        L59:
            if (r11 <= 0) goto L98
            com.scores365.ui.TournamentSingleView$eTvDataStyle r1 = com.scores365.ui.TournamentSingleView.eTvDataStyle.PAST     // Catch: java.lang.Exception -> Ldd
            boolean r11 = r6.isEndedNormally(r7)     // Catch: java.lang.Exception -> Ldd
            if (r11 != 0) goto L8f
            com.scores365.entitys.GroupGameObj[] r11 = r7.l()     // Catch: java.lang.Exception -> Ldd
            com.scores365.entitys.GroupGameObj[] r3 = r7.l()     // Catch: java.lang.Exception -> Ldd
            int r3 = r3.length     // Catch: java.lang.Exception -> Ldd
            int r3 = r3 - r8
            r11 = r11[r3]     // Catch: java.lang.Exception -> Ldd
            com.scores365.entitys.GameObj r11 = r11.gameObj     // Catch: java.lang.Exception -> Ldd
            if (r11 == 0) goto L7e
            boolean r3 = r11.isGameStatusTitleExist()     // Catch: java.lang.Exception -> Ldd
            if (r3 == 0) goto L7e
            java.lang.String r11 = r11.getGameStatusTitle()     // Catch: java.lang.Exception -> Ldd
            goto L89
        L7e:
            if (r11 == 0) goto L85
            java.lang.String r11 = r11.getStatusShortName()     // Catch: java.lang.Exception -> Ldd
            goto L89
        L85:
            java.lang.String r11 = r7.k()     // Catch: java.lang.Exception -> Ldd
        L89:
            android.widget.TextView r3 = r6.tvGameStatus     // Catch: java.lang.Exception -> Ldd
            r3.setText(r11)     // Catch: java.lang.Exception -> Ldd
            goto L96
        L8f:
            android.widget.TextView r11 = r6.tvGameStatus     // Catch: java.lang.Exception -> Ldd
            java.lang.String r3 = ""
            r11.setText(r3)     // Catch: java.lang.Exception -> Ldd
        L96:
            r11 = 1
            goto L9a
        L98:
            r1 = 0
        L99:
            r11 = 0
        L9a:
            android.widget.TextView r3 = r6.tvData     // Catch: java.lang.Exception -> Ldd
            android.content.Context r4 = com.scores365.App.m()     // Catch: java.lang.Exception -> Ldd
            android.graphics.Typeface r4 = li.o0.c(r4)     // Catch: java.lang.Exception -> Ldd
            r3.setTypeface(r4)     // Catch: java.lang.Exception -> Ldd
            androidx.constraintlayout.widget.ConstraintLayout r3 = r6.rlContainerLayout     // Catch: java.lang.Exception -> Ldd
            android.content.Context r4 = com.scores365.App.m()     // Catch: java.lang.Exception -> Ldd
            int r5 = com.scores365.R.attr.F1     // Catch: java.lang.Exception -> Ldd
            int r4 = li.p0.w(r4, r5)     // Catch: java.lang.Exception -> Ldd
            r3.setBackgroundResource(r4)     // Catch: java.lang.Exception -> Ldd
            r6.setTvDataSpecs(r1)     // Catch: java.lang.Exception -> Ldd
            r6.setTeamViewsSpecs()     // Catch: java.lang.Exception -> Ldd
            com.scores365.entitys.GameObj r4 = qf.f.D(r7)     // Catch: java.lang.Exception -> Ldd
            if (r4 == 0) goto Lca
            r0 = r6
            r1 = r11
            r3 = r9
            r5 = r10
            r0.setGameData(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Ldd
            goto Le1
        Lca:
            if (r4 == 0) goto Ld4
            boolean r7 = r4.getIsActive()     // Catch: java.lang.Exception -> Ldd
            if (r7 == 0) goto Ld4
            r4 = 1
            goto Ld5
        Ld4:
            r4 = 0
        Ld5:
            r0 = r6
            r1 = r11
            r3 = r9
            r5 = r10
            r0.setGameData(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Ldd
            goto Le1
        Ldd:
            r7 = move-exception
            li.x0.N1(r7)
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.TournamentSingleView.initialize(qf.c, int, java.lang.String, boolean, int):void");
    }
}
