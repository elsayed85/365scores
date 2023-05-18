package com.scores365.entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import li.x0;
/* loaded from: classes2.dex */
public class TransferObj implements Serializable, IGsonEntity<Integer> {
    private static final long serialVersionUID = 2443516660122850983L;
    @p9.c("Status")
    public BaseObj Status;
    @p9.c("Time")
    public Date TransferTime;
    @p9.c("AthleteID")
    public int athleteId;
    @p9.c("ContractUntil")
    public Date contractUntil;
    @p9.c("Origin")
    public int originTeam;
    @p9.c("PlayerCountry")
    public int playerCountry;
    @p9.c("PlayerName")
    private String playerName;
    @p9.c("PlayerSName")
    private String playerShortName;
    @p9.c("Price")
    private String price;
    @p9.c("SocialStats")
    public SocialTransferStats socialTransferStats;
    @p9.c("Target")
    public int targetTeam;
    @p9.c("ID")
    public int transferID;
    @p9.c("Articles")
    public ArrayList<ItemObj> relativeArticles = new ArrayList<>();
    @p9.c("IsPopular")
    public boolean isPopular = false;
    @p9.c("TransferType")
    public int transferType = -1;
    @p9.c("Position")
    public int athletePosition = -1;
    @p9.c("ImgVer")
    public int imageVersion = -1;

    /* loaded from: classes2.dex */
    public enum eTransferType {
        Unknown(0),
        FreeTransfer(1),
        FullOwnership(2),
        Loan(3),
        EndOfLoan(4);
        
        private int value;

        eTransferType(int i10) {
            this.value = i10;
        }

        public static eTransferType Create(int i10) {
            if (i10 == 0) {
                return Unknown;
            }
            if (i10 == 1) {
                return FreeTransfer;
            }
            if (i10 == 2) {
                return FullOwnership;
            }
            if (i10 == 3) {
                return Loan;
            }
            if (i10 == 4) {
                return EndOfLoan;
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int getImageVersion() {
        return this.imageVersion;
    }

    public String getImageVersionStr() {
        return String.valueOf(this.imageVersion);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return Integer.valueOf(this.transferID);
    }

    public String getPlayerName() {
        String str = this.playerName;
        return (str == null || str.isEmpty()) ? "" : this.playerName;
    }

    public String getPrice() {
        String str = this.price;
        try {
            return str.equals("-") ? "" : str;
        } catch (Exception e10) {
            x0.N1(e10);
            return str;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.transferID);
            sb2.append(" | player name: ");
            sb2.append(this.playerName);
            sb2.append(" | is popular: ");
            sb2.append(this.isPopular);
            sb2.append(" | date: ");
            sb2.append(x0.T(this.TransferTime, true));
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return sb2.toString();
    }
}
