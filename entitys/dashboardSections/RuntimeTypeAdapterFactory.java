package com.scores365.entitys.dashboardSections;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.p;
import com.google.gson.reflect.a;
import com.google.gson.x;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.c;
/* loaded from: classes2.dex */
public class RuntimeTypeAdapterFactory<T> implements x {
    private final Class<?> baseType;
    private final Map<String, Class<?>> labelToSubtype = new LinkedHashMap();
    private final Map<Class<?>, String> subtypeToLabel = new LinkedHashMap();
    private final String typeFieldName;

    private RuntimeTypeAdapterFactory(Class<?> cls, String str) {
        if (str == null || cls == null) {
            throw null;
        }
        this.baseType = cls;
        this.typeFieldName = str;
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls) {
        return new RuntimeTypeAdapterFactory<>(cls, "type");
    }

    public static <T> RuntimeTypeAdapterFactory<T> of(Class<T> cls, String str) {
        return new RuntimeTypeAdapterFactory<>(cls, str);
    }

    @Override // com.google.gson.x
    public <R> TypeAdapter<R> create(Gson gson, a<R> aVar) {
        if (aVar.getRawType() != this.baseType) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, Class<?>> entry : this.labelToSubtype.entrySet()) {
            TypeAdapter<T> r10 = gson.r(this, a.get((Class) entry.getValue()));
            linkedHashMap.put(entry.getKey(), r10);
            linkedHashMap2.put(entry.getValue(), r10);
        }
        return new TypeAdapter<R>() { // from class: com.scores365.entitys.dashboardSections.RuntimeTypeAdapterFactory.1
            /* JADX WARN: Type inference failed for: r3v3, types: [R, java.lang.Object] */
            @Override // com.google.gson.TypeAdapter
            public R read(s9.a aVar2) {
                j a10 = l.a(aVar2);
                j p10 = a10.e().p(RuntimeTypeAdapterFactory.this.typeFieldName);
                if (p10 != null) {
                    TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap.get(p10.h());
                    if (typeAdapter == null) {
                        return null;
                    }
                    return typeAdapter.fromJsonTree(a10);
                }
                throw new n("cannot deserialize " + RuntimeTypeAdapterFactory.this.baseType + " because it does not define a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
            }

            @Override // com.google.gson.TypeAdapter
            public void write(c cVar, R r11) {
                Class<?> cls = r11.getClass();
                String str = (String) RuntimeTypeAdapterFactory.this.subtypeToLabel.get(cls);
                TypeAdapter typeAdapter = (TypeAdapter) linkedHashMap2.get(cls);
                if (typeAdapter == null) {
                    throw new n("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
                }
                m e10 = typeAdapter.toJsonTree(r11).e();
                if (e10.t(RuntimeTypeAdapterFactory.this.typeFieldName)) {
                    throw new n("cannot serialize " + cls.getName() + " because it already defines a field named " + RuntimeTypeAdapterFactory.this.typeFieldName);
                }
                m mVar = new m();
                mVar.m(RuntimeTypeAdapterFactory.this.typeFieldName, new p(str));
                for (Map.Entry<String, j> entry2 : e10.o()) {
                    mVar.m(entry2.getKey(), entry2.getValue());
                }
                l.b(mVar, cVar);
            }
        }.nullSafe();
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls) {
        return registerSubtype(cls, cls.getSimpleName());
    }

    public RuntimeTypeAdapterFactory<T> registerSubtype(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw null;
        }
        if (!this.subtypeToLabel.containsKey(cls)) {
            this.labelToSubtype.containsKey(str);
        }
        this.labelToSubtype.put(str, cls);
        this.subtypeToLabel.put(cls, str);
        return this;
    }
}
