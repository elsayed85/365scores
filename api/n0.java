package com.scores365.api;

import android.text.TextUtils;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CountryObj;
import com.scores365.entitys.EntityObj;
import com.scores365.entitys.GsonManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: ApiEntitiesSearch.java */
/* loaded from: classes2.dex */
public class n0 extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f23148a;

    /* renamed from: b  reason: collision with root package name */
    private String f23149b;

    /* renamed from: c  reason: collision with root package name */
    private EntityObj f23150c;

    /* renamed from: d  reason: collision with root package name */
    HashMap<Integer, ArrayList<BaseObj>> f23151d;

    /* renamed from: e  reason: collision with root package name */
    HashMap<Integer, ArrayList<BaseObj>> f23152e;

    /* renamed from: f  reason: collision with root package name */
    private int f23153f;

    /* renamed from: g  reason: collision with root package name */
    private int f23154g;

    /* renamed from: h  reason: collision with root package name */
    boolean f23155h;

    /* renamed from: i  reason: collision with root package name */
    boolean f23156i;

    /* renamed from: j  reason: collision with root package name */
    String f23157j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23158k;

    /* compiled from: ApiEntitiesSearch.java */
    /* loaded from: classes2.dex */
    class a extends com.google.gson.reflect.a<ArrayList<CountryObj>> {
        a() {
        }
    }

    public n0(int i10) {
        this(i10, null, false, -1, -1, null, false);
    }

    public n0(int i10, String str, boolean z10, int i11, int i12, String str2, boolean z11) {
        this.f23156i = true;
        this.f23148a = i10;
        this.f23149b = str;
        this.f23155h = z10;
        this.f23153f = i11;
        this.f23154g = i12;
        this.f23157j = str2;
        this.containSlash = shouldAddBaseParams();
        this.f23156i = z11;
    }

    public int a() {
        try {
            r0 = this.f23150c.getTotalAthleteCount().intValue() > 0 ? 0 + this.f23150c.getTotalAthleteCount().intValue() : 0;
            if (this.f23150c.getTotalCompetitionsCount().intValue() > 0) {
                r0 += this.f23150c.getTotalCompetitionsCount().intValue();
            }
            return this.f23150c.getTotalCompetitorsCount().intValue() > 0 ? r0 + this.f23150c.getTotalCompetitorsCount().intValue() : r0;
        } catch (Exception e10) {
            li.x0.N1(e10);
            return r0;
        }
    }

    public EntityObj b() {
        return this.f23150c;
    }

    public int c() {
        return this.f23148a;
    }

    public HashMap<Integer, ArrayList<BaseObj>> d() {
        return this.f23152e;
    }

    public ArrayList<BaseObj> e() {
        return f(this.f23148a);
    }

    public ArrayList<BaseObj> f(int i10) {
        return this.f23151d.get(Integer.valueOf(i10));
    }

    public void g(boolean z10) {
        this.f23158k = z10;
    }

    @Override // com.scores365.api.d
    protected String getParams() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f23157j;
        boolean z10 = true;
        if (str == null || str.isEmpty()) {
            sb2.append("Data/Entities/");
            int i10 = this.f23148a;
            if (i10 == 2) {
                sb2.append("Competitions/");
            } else if (i10 == 3) {
                sb2.append("Competitors/");
            } else if (i10 == 5) {
                sb2.append("Favorites/");
            } else if (i10 == 6) {
                sb2.append("Athletes/");
            } else if (i10 == 7) {
                sb2.append("Countries/");
                if (this.f23158k) {
                    sb2.append("?appendChildCountries=true");
                }
            }
            sb2.append(this.f23158k ? "&" : "?");
            String str2 = this.f23149b;
            if (str2 == null || str2.isEmpty()) {
                z10 = false;
            } else {
                sb2.append("Search=");
                sb2.append(li.x0.x(this.f23149b));
            }
            if (z10) {
                sb2.append("&");
            }
            sb2.append("catalog=false");
            sb2.append("&onlyfromcache=true");
            if (this.f23153f != -1) {
                sb2.append("&sid=");
                sb2.append(this.f23153f);
            }
            if (this.f23155h) {
                sb2.append("&limit=10");
            }
            if (this.f23154g > 0) {
                sb2.append("&competitions=");
                sb2.append(this.f23154g);
            }
            if (this.f23156i) {
                sb2.append("&includePlayers=true");
            }
        } else {
            String substring = this.f23157j.charAt(0) == '/' ? this.f23157j.substring(1) : this.f23157j;
            this.f23157j = substring;
            sb2.append(substring);
        }
        return sb2.toString();
    }

    @Override // com.scores365.api.d
    protected void parseJSON(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            String str2 = "error parsing search api data=" + str;
            ng.a.f35508a.c("APIClient", str2, new NullPointerException(str2));
            return;
        }
        try {
            if (this.f23151d == null) {
                this.f23151d = new HashMap<>();
            }
            if (this.f23152e == null) {
                this.f23152e = new HashMap<>();
            }
            if (this.f23151d.get(Integer.valueOf(this.f23148a)) == null) {
                this.f23151d.put(Integer.valueOf(this.f23148a), new ArrayList<>());
            }
            if (this.f23148a != 7) {
                EntityObj g10 = w.g(str);
                this.f23150c = g10;
                if (g10.getCompetitions() != null) {
                    this.f23151d.put(2, new ArrayList<>(this.f23150c.getCompetitions()));
                }
                if (this.f23150c.getCompetitors() != null) {
                    this.f23151d.put(3, new ArrayList<>(this.f23150c.getCompetitors()));
                }
                if (this.f23150c.getAthletes() != null) {
                    this.f23151d.put(6, new ArrayList<>(this.f23150c.getAthletes()));
                }
                if (this.f23150c.getRelatedEntities() != null) {
                    if (this.f23150c.getRelatedEntities().getCompetitions() != null) {
                        if (!this.f23152e.containsKey(2)) {
                            this.f23152e.put(2, new ArrayList<>());
                        }
                        this.f23152e.get(2).addAll(this.f23150c.getRelatedEntities().getCompetitions());
                    }
                    if (this.f23150c.getRelatedEntities().getCompetitors() != null) {
                        if (!this.f23152e.containsKey(3)) {
                            this.f23152e.put(3, new ArrayList<>());
                        }
                        this.f23152e.get(3).addAll(this.f23150c.getRelatedEntities().getCompetitors());
                    }
                    if (this.f23150c.getRelatedEntities().getAthletes() != null) {
                        if (!this.f23152e.containsKey(6)) {
                            this.f23152e.put(6, new ArrayList<>());
                        }
                        this.f23152e.get(6).addAll(this.f23150c.getRelatedEntities().getAthletes());
                    }
                    if (this.f23150c.getRelatedEntities().getCountries() != null) {
                        if (!this.f23152e.containsKey(7)) {
                            this.f23152e.put(7, new ArrayList<>());
                        }
                        this.f23152e.get(7).addAll(Arrays.asList(this.f23150c.getRelatedEntities().getCountries()));
                    }
                }
                arrayList = null;
            } else {
                arrayList = (ArrayList) GsonManager.getGson().m(str, new a().getType());
            }
            if (arrayList != null) {
                this.f23151d.get(Integer.valueOf(this.f23148a)).addAll(arrayList);
            }
        } catch (Exception e10) {
            ng.a.f35508a.c("APIClient", "error parsing search api data", e10);
        }
    }

    @Override // com.scores365.api.d
    protected boolean shouldAddBaseParams() {
        String str = this.f23157j;
        return str == null || str.isEmpty();
    }
}
