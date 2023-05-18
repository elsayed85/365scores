package com.scores365.branding;

import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.ItemObj;
import java.io.Serializable;
import java.util.HashSet;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BrandingPlacementFilter implements Serializable {
    @c("competitions")
    public HashSet<Integer> competitions = new HashSet<>();
    @c("competitors")
    public HashSet<Integer> competitors = new HashSet<>();
    @c("games")
    public HashSet<Integer> games = new HashSet<>();
    @c("athletes")
    public HashSet<Integer> athletes = new HashSet<>();
    @c("articles")
    public HashSet<Integer> articles = new HashSet<>();

    public boolean isFilterEntityExists(CompObj compObj) {
        try {
            HashSet<Integer> hashSet = this.competitors;
            if (hashSet != null) {
                return hashSet.contains(Integer.valueOf(compObj.getID()));
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isFilterEntityExists(CompetitionObj competitionObj) {
        try {
            HashSet<Integer> hashSet = this.competitions;
            if (hashSet != null) {
                return hashSet.contains(Integer.valueOf(competitionObj.getID()));
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isFilterEntityExists(GameObj gameObj) {
        try {
            HashSet<Integer> hashSet = this.games;
            if (hashSet != null) {
                return hashSet.contains(Integer.valueOf(gameObj.getID()));
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isFilterEntityExists(ItemObj itemObj) {
        try {
            HashSet<Integer> hashSet = this.articles;
            if (hashSet != null) {
                return hashSet.contains(Integer.valueOf(itemObj.getID()));
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }
}
