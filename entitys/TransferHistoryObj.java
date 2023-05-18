package com.scores365.entitys;

import java.util.Calendar;
import java.util.Date;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class TransferHistoryObj extends BaseObj {
    @p9.c("CompetitorID")
    private int competitorId;
    @p9.c("Date")
    private Date date;
    @p9.c("DraftPick")
    private int draftPick;
    @p9.c("DraftRound")
    private int draftRound;
    @p9.c("DraftedBy")
    private int draftedBy;
    @p9.c("TransferID")
    private int transferID;
    @p9.c("TransferType")
    private int transferType;
    @p9.c("TransferTitle")
    private String transferTitle = "";
    @p9.c("Price")
    private String price = "";
    @p9.c("ContractUntil")
    private String contractUntil = "";
    @p9.c("Active")
    private boolean isActive = false;

    private String getTeamName(CompObj compObj) {
        if (compObj != null) {
            try {
                String symbolicName = compObj.getSymbolicName();
                return symbolicName.isEmpty() ? compObj.getShortName() : symbolicName;
            } catch (Exception e10) {
                x0.N1(e10);
                return "";
            }
        }
        return "";
    }

    public int getCompetitorId() {
        return this.competitorId;
    }

    public String getContractUntil() {
        return this.contractUntil;
    }

    public String getDate() {
        try {
            Date date = this.date;
            return date != null ? x0.T(date, true) : "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    public String getPrice() {
        return this.price;
    }

    public String getTransferData(CompObj compObj) {
        String date = getDate();
        try {
            if (this.draftedBy <= 0 || this.draftRound <= 0 || this.draftPick <= 0 || compObj == null) {
                return date;
            }
            StringBuilder sb2 = new StringBuilder();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.date);
            sb2.append(p0.l0("DRAFTED_STRUCTURE_FORMAT").replace("#YEAR", String.valueOf(calendar.get(1))).replace("#ROUND", String.valueOf(this.draftRound)).replace("#OVERALL_PICK", String.valueOf(this.draftPick)).replace("#TEAM_NAME", getTeamName(compObj)));
            sb2.append("\n");
            sb2.append(date);
            return sb2.toString();
        } catch (Exception e10) {
            x0.N1(e10);
            return date;
        }
    }

    public int getTransferID() {
        return this.transferID;
    }

    public String getTransferTitle() {
        return this.transferTitle;
    }

    public int getTransferType() {
        return this.transferType;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean useDraftText(CompObj compObj) {
        return this.draftedBy > 0 && this.draftRound > 0 && this.draftPick > 0 && compObj != null;
    }
}
