package com.scores365.entitys;

import com.scores365.R;
/* loaded from: classes2.dex */
public class BottomNavigationMenuItem {
    public static final int BETTING_5TH_ICON_ID = R.id.V;
    public static final int FIFTH_ICON_ID = -711987;
    public static final int SPECIAL_FIFTH_ICON_ID = -711985;
    public static final int SPECIAL_ICON_ID = -711986;
    private BottomBadge badge;
    public int icon;

    /* renamed from: id  reason: collision with root package name */
    public int f23583id;
    private boolean isDefault;
    public int order;
    public String title;

    public BottomNavigationMenuItem(int i10, int i11, String str, int i12, BottomBadge bottomBadge, boolean z10) {
        this.f23583id = i10;
        this.order = i11;
        this.title = str;
        this.icon = i12;
        this.badge = bottomBadge;
        this.isDefault = z10;
    }

    public BottomBadge getBadge() {
        return this.badge;
    }

    public int getBadgeBackground() {
        return this.badge.background;
    }

    public String getBadgeText() {
        return this.badge.text;
    }

    public boolean isBadgeVisible() {
        BottomBadge bottomBadge = this.badge;
        return bottomBadge != null && bottomBadge.isVisible;
    }

    public void setBottomBadge(BottomBadge bottomBadge) {
        this.badge = bottomBadge;
    }
}
