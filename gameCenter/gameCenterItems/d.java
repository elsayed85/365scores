package com.scores365.gameCenter.gameCenterItems;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.scores365.App;
import com.scores365.entitys.PlayerObj;
import com.scores365.entitys.PlayerStatObj;
import com.scores365.entitys.SportTypesEnum;
import com.scores365.gameCenter.gameCenterItems.c;
import java.util.HashSet;
import java.util.Iterator;
import lf.u;
import li.p0;
import li.x0;
/* compiled from: GameCenterMissingPlayerItem.java */
/* loaded from: classes2.dex */
public class d extends c {

    /* renamed from: j  reason: collision with root package name */
    private Spannable f23808j;

    /* compiled from: GameCenterMissingPlayerItem.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f23809a;

        /* renamed from: b  reason: collision with root package name */
        public int f23810b;

        /* renamed from: c  reason: collision with root package name */
        public String f23811c;

        public a(int i10, int i11, String str) {
            this.f23809a = i10;
            this.f23810b = i11;
            this.f23811c = str;
        }
    }

    public d(PlayerObj playerObj, int i10, int i11, c.EnumC0252c enumC0252c, boolean z10, String str, int i12) {
        super(playerObj, i10, i11, enumC0252c, z10, str);
        this.f23790d = i12;
        this.f23808j = o(playerObj);
    }

    private Spannable o(PlayerObj playerObj) {
        PlayerStatObj[] playerStat;
        String str;
        int i10;
        SpannableString spannableString = null;
        try {
            if (playerObj.getSeasonStats() == null || playerObj.getSeasonStats().getPlayerStat() == null) {
                return this.f23792f ? new SpannableString(p0.l0("NEW_PLAYER_CARD_SOCCER_NO_INTERNATIONAL_CAPS")) : new SpannableString(p0.l0("LINEUPS_NO_APPEARANCES"));
            }
            StringBuilder sb2 = new StringBuilder();
            HashSet hashSet = new HashSet();
            for (PlayerStatObj playerStatObj : playerObj.getSeasonStats().getPlayerStat()) {
                if (playerStatObj.isSignificant()) {
                    i10 = sb2.length();
                    str = playerStatObj.getColor();
                } else {
                    str = null;
                    i10 = -1;
                }
                if (playerStatObj.getT() == 5 && this.f23790d == SportTypesEnum.SOCCER.getValue() && this.f23792f) {
                    sb2.append(p0.l0("NEW_PLAYER_CARD_SOCCER_INTERNATIONAL_CAPS"));
                } else if (playerStatObj.getTitle() == null || playerStatObj.getTitle().isEmpty()) {
                    sb2.append(App.l().getSportTypes().get(Integer.valueOf(SportTypesEnum.SOCCER.getValue())).athleteStatics.get(Integer.valueOf(playerStatObj.getT())).nameInMissingPlayers.replace(" ", " "));
                } else {
                    sb2.append(playerStatObj.getTitle().replace(" ", " "));
                }
                if (playerStatObj.getV() != null && !playerStatObj.getV().isEmpty()) {
                    sb2.append(" ");
                    sb2.append("(");
                    sb2.append(playerStatObj.getV());
                    sb2.append(")");
                }
                if (i10 > -1) {
                    hashSet.add(new a(i10, sb2.length(), str));
                }
                sb2.append("   ");
            }
            SpannableString spannableString2 = new SpannableString(sb2);
            try {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.f23811c != null) {
                        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(aVar.f23811c)), aVar.f23809a, aVar.f23810b, 33);
                    }
                }
                return spannableString2;
            } catch (Exception e10) {
                spannableString = spannableString2;
                e = e10;
                x0.N1(e);
                return spannableString;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Override // com.scores365.gameCenter.gameCenterItems.c, com.scores365.Design.PageObjects.c
    public int getObjectTypeNum() {
        return u.LINEUPS_BENCH.ordinal();
    }

    @Override // com.scores365.gameCenter.gameCenterItems.c, com.scores365.Design.PageObjects.c
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i10) {
        super.onBindViewHolder(e0Var, i10);
        c.b bVar = (c.b) e0Var;
        bVar.f23802j.setVisibility(0);
        Spannable spannable = this.f23808j;
        if (spannable == null || spannable.length() <= 0) {
            bVar.f23801i.setVisibility(8);
        } else {
            bVar.f23801i.setVisibility(0);
            bVar.f23801i.setText(this.f23808j);
        }
        TextView textView = bVar.f23802j;
        PlayerObj playerObj = this.f23787a;
        int i11 = this.f23790d;
        if (i11 == -1) {
            i11 = SportTypesEnum.SOCCER.getValue();
        }
        textView.setText(playerObj.getFormationPositionName(i11));
    }
}
