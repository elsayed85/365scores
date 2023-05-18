package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class SocialTransferStats implements Serializable {
    @p9.c("Dislikes")
    private int dislikes;
    @p9.c("Likes")
    private int likes;

    public int getDislikesCount() {
        int i10 = this.dislikes + 1;
        this.dislikes = i10;
        return i10;
    }

    public int getLikesCount() {
        int i10 = this.likes + 1;
        this.likes = i10;
        return i10;
    }

    public void incrementDislikesCount() {
        this.dislikes++;
    }

    public void incrementLikesCount() {
        this.likes++;
    }
}
