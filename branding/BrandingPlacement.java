package com.scores365.branding;

import com.scores365.entitys.IGsonEntity;
import java.io.Serializable;
import java.util.LinkedHashMap;
import li.x0;
import p9.c;
/* loaded from: classes2.dex */
public class BrandingPlacement implements Serializable, IGsonEntity<BrandingKey> {
    @c("BrandAssets")
    public LinkedHashMap<String, BrandAsset> brandAssets;
    @c("BrandsAvailable")
    public String[] brands_available;
    @c("exclusiveBrand")
    public String exclusiveBrand;
    @c("FilterType")
    public BrandingPlacementFilter filters;
    @c("Placement")
    private String key;

    public BrandAsset getBrandAsset(String str) {
        BrandAsset brandAsset;
        try {
            String str2 = this.exclusiveBrand;
            if (str2 == null || !this.brandAssets.containsKey(str2)) {
                LinkedHashMap<String, BrandAsset> linkedHashMap = this.brandAssets;
                if (linkedHashMap == null || !linkedHashMap.containsKey(str)) {
                    return null;
                }
                brandAsset = this.brandAssets.get(str);
            } else {
                brandAsset = this.brandAssets.get(this.exclusiveBrand);
            }
            return brandAsset;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public BrandingKey getBrandingKey() {
        try {
            return BrandingKey.create(this.key);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public BrandingPlacementFilter getFilters() {
        return this.filters;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scores365.entitys.IGsonEntity
    public BrandingKey getKey() {
        return getBrandingKey();
    }
}
