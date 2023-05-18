package com.scores365.Pages;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.scores365.Design.Pagers.GeneralTabPageIndicator;
import com.scores365.gameCenter.p0;
import com.scores365.ui.playerCard.SinglePlayerBuzzPageCreator;
import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* compiled from: PagesPagerAdapter.java */
/* loaded from: classes2.dex */
public class u extends androidx.fragment.app.y implements GeneralTabPageIndicator.b {

    /* renamed from: j  reason: collision with root package name */
    protected ArrayList<com.scores365.Design.Pages.b> f21321j;

    /* renamed from: k  reason: collision with root package name */
    private p0 f21322k;

    public u(FragmentManager fragmentManager, ArrayList<com.scores365.Design.Pages.b> arrayList) {
        super(fragmentManager);
        this.f21321j = arrayList;
    }

    @Override // com.scores365.Design.Pagers.GeneralTabPageIndicator.b
    public String a(int i10) {
        try {
            return this.f21321j.get(i10).iconLink;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @Override // com.scores365.Design.Pagers.GeneralTabPageIndicator.b
    public boolean b(int i10) {
        try {
            return this.f21321j.get(i10).isIconLocalResource;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    @Override // androidx.fragment.app.y, androidx.viewpager.widget.a
    public void d(ViewGroup viewGroup) {
        try {
            super.d(viewGroup);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.viewpager.widget.a
    public int e() {
        try {
            return this.f21321j.size();
        } catch (Exception e10) {
            x0.N1(e10);
            return 0;
        }
    }

    @Override // androidx.viewpager.widget.a
    public int f(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence g(int i10) {
        try {
            return this.f21321j.get(i10).title;
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }

    @Override // androidx.fragment.app.y, androidx.viewpager.widget.a
    public Object i(ViewGroup viewGroup, int i10) {
        try {
            return super.i(viewGroup, i10);
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    @Override // androidx.fragment.app.y
    public Fragment s(int i10) {
        com.scores365.Design.Pages.a aVar = null;
        try {
            aVar = this.f21321j.get(i10).CreatePage();
            if (this.f21322k != null && (this.f21321j.get(i10) instanceof SinglePlayerBuzzPageCreator) && (aVar instanceof com.scores365.Design.Pages.q)) {
                ((com.scores365.Design.Pages.q) aVar).setPageListScrolledListener(this.f21322k);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return aVar;
    }

    public com.scores365.Design.Pages.b t(int i10) {
        ArrayList<com.scores365.Design.Pages.b> arrayList = this.f21321j;
        if (arrayList == null || arrayList.size() <= i10) {
            return null;
        }
        return this.f21321j.get(i10);
    }

    public String toString() {
        try {
            Iterator<com.scores365.Design.Pages.b> it = this.f21321j.iterator();
            while (it.hasNext()) {
                "pages in PagesPagerAdapter: ".concat(it.next().title + ", ");
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return "pages in PagesPagerAdapter: ";
    }

    public ArrayList<com.scores365.Design.Pages.b> u() {
        return this.f21321j;
    }

    public void v(p0 p0Var) {
        this.f21322k = p0Var;
    }

    public void w(ArrayList<com.scores365.Design.Pages.b> arrayList) {
        this.f21321j = arrayList;
    }

    public void x(ArrayList<com.scores365.Design.Pages.b> arrayList) {
        try {
            this.f21321j = arrayList;
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
