package com.scores365.bets.model;

import androidx.annotation.NonNull;
import com.scores365.entitys.BaseObj;
import java.util.Arrays;
import java.util.HashMap;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BookmakerActionButton extends BaseObj {
    public static final String PREDICTION_BEFORE_VOTE_EXTRA_CONTEXT = "PredictionsBeforeVote";
    @c("ExtraContexts")
    public ExtraContext[] extraContexts;
    private HashMap<String, ExtraContext> extraContextsByContextName = null;
    @c("Tag")
    public String tag;
    @c("Text")
    public String text;
    @c("URL")
    private String url;
    private String urlProcessed;

    public HashMap<String, ExtraContext> getExtraContextsByContextName() {
        try {
            if (this.extraContextsByContextName == null) {
                this.extraContextsByContextName = new HashMap<>();
                ExtraContext[] extraContextArr = this.extraContexts;
                if (extraContextArr != null) {
                    for (ExtraContext extraContext : extraContextArr) {
                        this.extraContextsByContextName.put(extraContext.contextStr, extraContext);
                    }
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return this.extraContextsByContextName;
    }

    public String getOddsOptionClickLink(boolean z10) {
        String url = getUrl();
        if (z10) {
            return url;
        }
        try {
            return (!getExtraContextsByContextName().containsKey(PREDICTION_BEFORE_VOTE_EXTRA_CONTEXT) || getExtraContextsByContextName().get(PREDICTION_BEFORE_VOTE_EXTRA_CONTEXT) == null) ? url : getExtraContextsByContextName().get(PREDICTION_BEFORE_VOTE_EXTRA_CONTEXT).getUrl();
        } catch (Exception e10) {
            x0.N1(e10);
            return url;
        }
    }

    public String getUrl() {
        if (this.urlProcessed == null) {
            this.urlProcessed = x0.W0(this.url);
        }
        return this.urlProcessed;
    }

    @NonNull
    public String toString() {
        return "BMActionButton{id=" + this.f23582id + ", name='" + this.name + "', text='" + this.text + "', url='" + this.url + "', urlProcessed='" + this.urlProcessed + "', tag='" + this.tag + "', extraContexts=" + Arrays.toString(this.extraContexts) + ", extraContextsByContextName=" + this.extraContextsByContextName + '}';
    }
}
