package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class PlayByPlayObj implements Serializable {
    @p9.c("half")
    private int half;
    @p9.c("iconIndicator")
    private int iconIndicator;
    @p9.c("lineNumber")
    private int lineNumber;
    @p9.c("seconds")
    private int seconds;
    @p9.c("teamIndicator")
    private int teamIndicator;
    @p9.c("text")
    private String text;
    @p9.c("time")
    private String time;
    @p9.c("uniqId")
    private int uniqId;

    public PlayByPlayObj(int i10, int i11, int i12, int i13, String str, int i14, int i15, String str2) {
        this.uniqId = i10;
        this.half = i11;
        this.seconds = i12;
        this.lineNumber = i13;
        this.time = str;
        this.teamIndicator = i14;
        this.iconIndicator = i15;
        this.text = str2;
    }

    public int getHalf() {
        return this.half;
    }

    public int getIconIndicator() {
        return this.iconIndicator;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public int getTeamIndicator() {
        return this.teamIndicator;
    }

    public String getText() {
        return this.text;
    }

    public String getTime() {
        return this.time;
    }

    public int getUniqId() {
        return this.uniqId;
    }

    public void setHalf(int i10) {
        this.half = i10;
    }

    public void setIconIndicator(int i10) {
        this.iconIndicator = i10;
    }

    public void setLineNumber(int i10) {
        this.lineNumber = i10;
    }

    public void setSeconds(int i10) {
        this.seconds = i10;
    }

    public void setTeamIndicator(int i10) {
        this.teamIndicator = i10;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUniqId(int i10) {
        this.uniqId = i10;
    }
}
