package com.scores365.entitys;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import li.x0;
/* loaded from: classes2.dex */
public class CommentsObj implements Serializable, IGsonEntity<String> {
    private static final long serialVersionUID = 6631031202314991237L;
    @p9.c("dislikes")
    public int Dislikes;
    @p9.c("likes")
    public int Likes;
    @p9.c("replies_count")
    public int RepliesCount;
    private Date commDate;
    @p9.c("message")
    public String commentContent;
    @p9.c("Id")
    public String commentId;
    @p9.c("seq")
    public int commentSeq;
    @p9.c("createdAt")
    private String commentTime;
    @p9.c("replies")
    public ArrayList<CommentsObj> Replies = new ArrayList<>();
    @p9.c("author")
    public Author author = new Author();

    /* loaded from: classes2.dex */
    public static class Author implements Serializable {
        @p9.c("slug")
        public String Slug = "";
        @p9.c("avatar")
        public String avatar = "";
        @p9.c("username")
        public String commenterName;
        public String userId;

        public String getAvatar() {
            return this.avatar;
        }

        public String getCommenterName() {
            return this.commenterName;
        }

        public String getSlug() {
            return this.Slug;
        }
    }

    public Author getAuthor() {
        return this.author;
    }

    public Date getCommentTime() {
        Date date = new Date();
        if (this.commDate == null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
                String str = this.commentTime;
                if (str != null) {
                    this.commDate = simpleDateFormat.parse(str);
                }
            } catch (ParseException e10) {
                x0.N1(e10);
            }
        }
        Date date2 = this.commDate;
        return date2 != null ? date2 : date;
    }

    @Override // com.scores365.entitys.IGsonEntity
    public String getKey() {
        return this.commentId;
    }
}
