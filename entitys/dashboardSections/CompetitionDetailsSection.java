package com.scores365.entitys.dashboardSections;

import com.scores365.bets.model.BookMakerObj;
import com.scores365.entitys.CompObj;
import com.scores365.entitys.CompetitionObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.TvNetworkObj;
import com.scores365.entitys.competitionsDetailsCards.CompetitionDetailsData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.m;
import o1.t;
import p9.c;
/* compiled from: CompetitionDetailsSection.kt */
/* loaded from: classes2.dex */
public final class CompetitionDetailsSection extends AbstractSectionObject {
    @c("Bookmakers")
    private final LinkedHashMap<Integer, BookMakerObj> bookmakers;
    @c("Competitions")
    private final LinkedHashMap<Integer, CompetitionObj> competitions;
    @c("Competitors")
    private final ArrayList<CompObj> competitors;
    @c("Countries")
    private final ArrayList<CountryObj> countries;
    @c("CurrentDate")
    private final Date currentDate;
    @c("Data")
    private final CompetitionDetailsData data;
    @c("TTL")
    private final long ttl;
    @c("TVNetworks")
    private final ArrayList<TvNetworkObj> tvNetworks;

    /* compiled from: CompetitionDetailsSection.kt */
    /* loaded from: classes2.dex */
    public static final class CompetitionDetailsDataHelperObj implements Serializable {
        private final LinkedHashMap<Integer, BookMakerObj> bookmakers;
        private final LinkedHashMap<Integer, CompetitionObj> competitions;
        private final ArrayList<CompObj> competitors;
        private final ArrayList<CountryObj> countries;
        private final Date currentDate;
        private final CompetitionDetailsData data;
        private final long ttl;
        private final ArrayList<TvNetworkObj> tvNetworks;

        public CompetitionDetailsDataHelperObj(CompetitionDetailsData competitionDetailsData, ArrayList<CountryObj> arrayList, LinkedHashMap<Integer, CompetitionObj> linkedHashMap, ArrayList<CompObj> arrayList2, ArrayList<TvNetworkObj> arrayList3, LinkedHashMap<Integer, BookMakerObj> linkedHashMap2, Date date, long j10) {
            this.data = competitionDetailsData;
            this.countries = arrayList;
            this.competitions = linkedHashMap;
            this.competitors = arrayList2;
            this.tvNetworks = arrayList3;
            this.bookmakers = linkedHashMap2;
            this.currentDate = date;
            this.ttl = j10;
        }

        public final CompetitionDetailsData component1() {
            return this.data;
        }

        public final ArrayList<CountryObj> component2() {
            return this.countries;
        }

        public final LinkedHashMap<Integer, CompetitionObj> component3() {
            return this.competitions;
        }

        public final ArrayList<CompObj> component4() {
            return this.competitors;
        }

        public final ArrayList<TvNetworkObj> component5() {
            return this.tvNetworks;
        }

        public final LinkedHashMap<Integer, BookMakerObj> component6() {
            return this.bookmakers;
        }

        public final Date component7() {
            return this.currentDate;
        }

        public final long component8() {
            return this.ttl;
        }

        public final CompetitionDetailsDataHelperObj copy(CompetitionDetailsData competitionDetailsData, ArrayList<CountryObj> arrayList, LinkedHashMap<Integer, CompetitionObj> linkedHashMap, ArrayList<CompObj> arrayList2, ArrayList<TvNetworkObj> arrayList3, LinkedHashMap<Integer, BookMakerObj> linkedHashMap2, Date date, long j10) {
            return new CompetitionDetailsDataHelperObj(competitionDetailsData, arrayList, linkedHashMap, arrayList2, arrayList3, linkedHashMap2, date, j10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CompetitionDetailsDataHelperObj) {
                CompetitionDetailsDataHelperObj competitionDetailsDataHelperObj = (CompetitionDetailsDataHelperObj) obj;
                return m.b(this.data, competitionDetailsDataHelperObj.data) && m.b(this.countries, competitionDetailsDataHelperObj.countries) && m.b(this.competitions, competitionDetailsDataHelperObj.competitions) && m.b(this.competitors, competitionDetailsDataHelperObj.competitors) && m.b(this.tvNetworks, competitionDetailsDataHelperObj.tvNetworks) && m.b(this.bookmakers, competitionDetailsDataHelperObj.bookmakers) && m.b(this.currentDate, competitionDetailsDataHelperObj.currentDate) && this.ttl == competitionDetailsDataHelperObj.ttl;
            }
            return false;
        }

        public final LinkedHashMap<Integer, BookMakerObj> getBookmakers() {
            return this.bookmakers;
        }

        public final LinkedHashMap<Integer, CompetitionObj> getCompetitions() {
            return this.competitions;
        }

        public final ArrayList<CompObj> getCompetitors() {
            return this.competitors;
        }

        public final ArrayList<CountryObj> getCountries() {
            return this.countries;
        }

        public final Date getCurrentDate() {
            return this.currentDate;
        }

        public final CompetitionDetailsData getData() {
            return this.data;
        }

        public final long getTtl() {
            return this.ttl;
        }

        public final ArrayList<TvNetworkObj> getTvNetworks() {
            return this.tvNetworks;
        }

        public int hashCode() {
            CompetitionDetailsData competitionDetailsData = this.data;
            int hashCode = (competitionDetailsData == null ? 0 : competitionDetailsData.hashCode()) * 31;
            ArrayList<CountryObj> arrayList = this.countries;
            int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
            LinkedHashMap<Integer, CompetitionObj> linkedHashMap = this.competitions;
            int hashCode3 = (hashCode2 + (linkedHashMap == null ? 0 : linkedHashMap.hashCode())) * 31;
            ArrayList<CompObj> arrayList2 = this.competitors;
            int hashCode4 = (hashCode3 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
            ArrayList<TvNetworkObj> arrayList3 = this.tvNetworks;
            int hashCode5 = (hashCode4 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
            LinkedHashMap<Integer, BookMakerObj> linkedHashMap2 = this.bookmakers;
            int hashCode6 = (hashCode5 + (linkedHashMap2 == null ? 0 : linkedHashMap2.hashCode())) * 31;
            Date date = this.currentDate;
            return ((hashCode6 + (date != null ? date.hashCode() : 0)) * 31) + t.a(this.ttl);
        }

        public String toString() {
            return "CompetitionDetailsDataHelperObj(data=" + this.data + ", countries=" + this.countries + ", competitions=" + this.competitions + ", competitors=" + this.competitors + ", tvNetworks=" + this.tvNetworks + ", bookmakers=" + this.bookmakers + ", currentDate=" + this.currentDate + ", ttl=" + this.ttl + ')';
        }
    }

    public CompetitionDetailsSection(CompetitionDetailsData data, ArrayList<CountryObj> countries, LinkedHashMap<Integer, CompetitionObj> competitions, ArrayList<CompObj> competitors, ArrayList<TvNetworkObj> tvNetworks, LinkedHashMap<Integer, BookMakerObj> bookmakers, Date currentDate, long j10) {
        m.g(data, "data");
        m.g(countries, "countries");
        m.g(competitions, "competitions");
        m.g(competitors, "competitors");
        m.g(tvNetworks, "tvNetworks");
        m.g(bookmakers, "bookmakers");
        m.g(currentDate, "currentDate");
        this.data = data;
        this.countries = countries;
        this.competitions = competitions;
        this.competitors = competitors;
        this.tvNetworks = tvNetworks;
        this.bookmakers = bookmakers;
        this.currentDate = currentDate;
        this.ttl = j10;
    }

    public final LinkedHashMap<Integer, BookMakerObj> getBookmakers() {
        return this.bookmakers;
    }

    public final LinkedHashMap<Integer, CompetitionObj> getCompetitions() {
        return this.competitions;
    }

    public final ArrayList<CompObj> getCompetitors() {
        return this.competitors;
    }

    public final ArrayList<CountryObj> getCountries() {
        return this.countries;
    }

    public final Date getCurrentDate() {
        return this.currentDate;
    }

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public final CompetitionDetailsData getData() {
        return this.data;
    }

    @Override // com.scores365.entitys.dashboardSections.AbstractSectionObject
    public Object getData() {
        return new CompetitionDetailsDataHelperObj(this.data, this.countries, this.competitions, this.competitors, this.tvNetworks, this.bookmakers, this.currentDate, this.ttl);
    }

    public final long getTtl() {
        return this.ttl;
    }

    public final ArrayList<TvNetworkObj> getTvNetworks() {
        return this.tvNetworks;
    }
}
