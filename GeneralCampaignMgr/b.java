package com.scores365.GeneralCampaignMgr;

import ad.h;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.scores365.App;
import com.scores365.entitys.SpecialSections;
import com.scores365.entitys.TabObj;
import com.scores365.removeAds.RemoveAdsManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import lf.c;
import li.p0;
import li.u;
import li.x0;
import sf.b;
/* compiled from: GeneralCampaignMgr.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<SpecialSections> f21091a = new ArrayList<>();

    /* compiled from: GeneralCampaignMgr.java */
    /* loaded from: classes2.dex */
    public enum a {
        Header,
        Menu
    }

    public static boolean a(@NonNull Context context, @NonNull a aVar, int i10, boolean z10) {
        try {
            String valueOf = String.valueOf(f21091a.get(i10).SectionID);
            String str = z10 ? f21091a.get(i10).Menu_URL : f21091a.get(i10).Header_URL;
            ng.a aVar2 = ng.a.f35508a;
            aVar2.b("GeneralCampaignMgr", "starting image download, type=" + aVar + ", num=" + i10 + ", menu=" + z10 + ", campaignName=" + valueOf + ", url=" + str, null);
            Bitmap t10 = u.t(context, str);
            File dir = new ContextWrapper(App.m()).getDir("Campaign", 0);
            if (!dir.exists()) {
                dir.mkdir();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, valueOf + "_" + aVar.name() + ".png"));
                t10.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                return true;
            } catch (Exception e10) {
                Log.e("SAVE_IMAGE", e10.getMessage(), e10);
                return true;
            }
        } catch (Exception e11) {
            x0.N1(e11);
            return true;
        }
    }

    public static Bitmap b(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return decodeStream;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public static SpecialSections c(String str) {
        for (int i10 = 0; i10 < f21091a.size(); i10++) {
            try {
                if (f21091a.get(i10).SectionID.equals(str)) {
                    return f21091a.get(i10);
                }
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
        return null;
    }

    public static ArrayList<com.scores365.Design.Pages.b> d(String str, c cVar) {
        SpecialSections specialSections;
        ArrayList<com.scores365.Design.Pages.b> arrayList = new ArrayList<>();
        int i10 = 0;
        while (true) {
            try {
                if (i10 >= f21091a.size()) {
                    specialSections = null;
                    break;
                } else if (f21091a.get(i10).Menu_pos_string.equals(str)) {
                    specialSections = f21091a.get(i10);
                    break;
                } else {
                    i10++;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        if (specialSections != null) {
            try {
                Iterator<TabObj> it = specialSections.getTabs().iterator();
                while (it.hasNext()) {
                    TabObj next = it.next();
                    if (next.tabType.equals(TabObj.tabTypeEnum.News)) {
                        arrayList.add(new h(null, null, next.tabName, cVar, null, null, null, null, null, true, p0.l0("EMPTY_SCREEN_NO_NEWS_FOR_SELECTIONS"), false, null, false, false, "News", false));
                    } else if (next.tabType.equals(TabObj.tabTypeEnum.WebView)) {
                        arrayList.add(new vb.a(next.tabName, next.tabURL, "watch_trailer", next.sectionID));
                    }
                }
            } catch (Exception e11) {
                x0.N1(e11);
            }
        }
        return arrayList;
    }

    public static String e(String str) {
        String str2 = "";
        for (int i10 = 0; i10 < f21091a.size(); i10++) {
            try {
                if (f21091a.get(i10).SectionID.equals(str)) {
                    str2 = f21091a.get(i10).Menu_pos_string;
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return str2;
    }

    public static int f(String str) {
        for (int i10 = 0; i10 < f21091a.size(); i10++) {
            if (f21091a.get(i10).SectionID.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    public static boolean g() {
        try {
            if (App.f20803w || RemoveAdsManager.isUserAdsRemoved(App.m()) || !h()) {
                return false;
            }
            return !f21091a.isEmpty();
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public static boolean h() {
        return sf.b.X1().c(b.e.SessionsCount, App.m()) > 1 || !App.f20793m;
    }

    public static String i(a aVar, int i10) {
        try {
            String str = String.valueOf(f21091a.get(i10).SectionID) + "_" + aVar.name() + ".png";
            File dir = new ContextWrapper(App.m()).getDir("Campaign", 0);
            if (dir.exists()) {
                File file = new File(dir, str);
                System.out.println(file.isFile());
                return Uri.decode(file.getAbsolutePath());
            }
            return "";
        } catch (Exception e10) {
            x0.N1(e10);
            return "";
        }
    }
}
