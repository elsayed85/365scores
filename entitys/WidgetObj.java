package com.scores365.entitys;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class WidgetObj implements Serializable, IGsonEntity<Integer> {
    @p9.c("PartnerID")
    protected String partnerID;
    @p9.c("Provider")
    protected String provider;
    @p9.c("WidgetRatio")
    protected float widgetRatio;
    @p9.c("WidgetType")
    private String widgetType;
    @p9.c("WidgetURL")
    protected String widgetURL;

    /* loaded from: classes2.dex */
    public enum eWidgetType {
        Momentum("Momentum"),
        LMT("LMT");
        
        private String name;

        eWidgetType(String str) {
            this.name = str;
        }

        public static eWidgetType create(String str) {
            str.hashCode();
            if (str.equals("Momentum")) {
                return Momentum;
            }
            if (str.equals("LMT")) {
                return LMT;
            }
            return null;
        }

        public String getName() {
            return this.name;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public Integer getKey() {
        return -1;
    }

    public String getPartnerID() {
        return this.partnerID;
    }

    public String getProvider() {
        return this.provider;
    }

    public float getWidgetRatio() {
        return this.widgetRatio;
    }

    public eWidgetType getWidgetType() {
        return eWidgetType.create(this.widgetType);
    }

    public String getWidgetURL() {
        return this.widgetURL;
    }
}
