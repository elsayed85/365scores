package com.scores365.entitys;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
/* compiled from: StatsFilter.kt */
/* loaded from: classes2.dex */
public final class StatsFilter implements Serializable {
    @p9.c("Name")
    private final String name;
    @p9.c("Params")
    private final String param;
    @p9.c("Logo")
    private final StatsFilterLogo statsFilterLogo;

    /* compiled from: StatsFilter.kt */
    /* loaded from: classes2.dex */
    public static final class StatsFilterLogo implements Serializable {
        @p9.c("ID")

        /* renamed from: id  reason: collision with root package name */
        private final int f23598id;
        @p9.c("ImageCategory")
        private final String imageCategory;
        @p9.c("ImgVer")
        private final int imgVer;

        public StatsFilterLogo(String imageCategory, int i10, int i11) {
            m.g(imageCategory, "imageCategory");
            this.imageCategory = imageCategory;
            this.f23598id = i10;
            this.imgVer = i11;
        }

        public /* synthetic */ StatsFilterLogo(String str, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i12 & 2) != 0 ? -1 : i10, (i12 & 4) != 0 ? -1 : i11);
        }

        public static /* synthetic */ StatsFilterLogo copy$default(StatsFilterLogo statsFilterLogo, String str, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = statsFilterLogo.imageCategory;
            }
            if ((i12 & 2) != 0) {
                i10 = statsFilterLogo.f23598id;
            }
            if ((i12 & 4) != 0) {
                i11 = statsFilterLogo.imgVer;
            }
            return statsFilterLogo.copy(str, i10, i11);
        }

        public final String component1() {
            return this.imageCategory;
        }

        public final int component2() {
            return this.f23598id;
        }

        public final int component3() {
            return this.imgVer;
        }

        public final StatsFilterLogo copy(String imageCategory, int i10, int i11) {
            m.g(imageCategory, "imageCategory");
            return new StatsFilterLogo(imageCategory, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StatsFilterLogo) {
                StatsFilterLogo statsFilterLogo = (StatsFilterLogo) obj;
                return m.b(this.imageCategory, statsFilterLogo.imageCategory) && this.f23598id == statsFilterLogo.f23598id && this.imgVer == statsFilterLogo.imgVer;
            }
            return false;
        }

        public final int getId() {
            return this.f23598id;
        }

        public final String getImageCategory() {
            return this.imageCategory;
        }

        public final int getImgVer() {
            return this.imgVer;
        }

        public int hashCode() {
            return (((this.imageCategory.hashCode() * 31) + this.f23598id) * 31) + this.imgVer;
        }

        public String toString() {
            return "StatsFilterLogo(imageCategory=" + this.imageCategory + ", id=" + this.f23598id + ", imgVer=" + this.imgVer + ')';
        }
    }

    public StatsFilter(String name, String param, StatsFilterLogo statsFilterLogo) {
        m.g(name, "name");
        m.g(param, "param");
        m.g(statsFilterLogo, "statsFilterLogo");
        this.name = name;
        this.param = param;
        this.statsFilterLogo = statsFilterLogo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParam() {
        return this.param;
    }

    public final StatsFilterLogo getStatsFilterLogo() {
        return this.statsFilterLogo;
    }
}
