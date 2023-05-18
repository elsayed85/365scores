package com.scores365.ui.viewpagerindicator;

import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public interface PageIndicator extends ViewPager.j {
    void notifyDataSetChanged();

    @Override // androidx.viewpager.widget.ViewPager.j
    /* synthetic */ void onPageScrollStateChanged(int i10);

    @Override // androidx.viewpager.widget.ViewPager.j
    /* synthetic */ void onPageScrolled(int i10, float f10, int i11);

    @Override // androidx.viewpager.widget.ViewPager.j
    /* synthetic */ void onPageSelected(int i10);

    void setCurrentItem(int i10);

    void setOnPageChangeListener(ViewPager.j jVar);

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int i10);
}
