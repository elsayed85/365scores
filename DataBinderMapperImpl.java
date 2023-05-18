package com.scores365;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import java.util.ArrayList;
import java.util.List;
import rf.k1;
/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseIntArray f20860a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        f20860a = sparseIntArray;
        sparseIntArray.put(R.layout.f22753x4, 1);
    }

    @Override // androidx.databinding.d
    public List<d> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.d
    public ViewDataBinding b(e eVar, View view, int i10) {
        int i11 = f20860a.get(i10);
        if (i11 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                if (i11 != 1) {
                    return null;
                }
                if ("layout/most_titles_popup_layout_0".equals(tag)) {
                    return new k1(eVar, view);
                }
                throw new IllegalArgumentException("The tag for most_titles_popup_layout is invalid. Received: " + tag);
            }
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }

    @Override // androidx.databinding.d
    public ViewDataBinding c(e eVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f20860a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
