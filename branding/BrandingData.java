package com.scores365.branding;

import java.io.Serializable;
import java.util.LinkedHashMap;
import p9.c;
/* loaded from: classes2.dex */
public class BrandingData implements Serializable {
    @c("Placements")
    public LinkedHashMap<BrandingKey, BrandingPlacement> placements;
    @c("Split")
    public SplitObj[] splitObjs;
}
