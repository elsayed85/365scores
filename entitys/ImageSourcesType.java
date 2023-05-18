package com.scores365.entitys;

import li.x0;
/* loaded from: classes2.dex */
public class ImageSourcesType implements IGsonEntity<String> {
    @p9.c("Key")
    public String key = "";
    @p9.c("Path")
    public String path = "";
    @p9.c("Extension")
    public String extension = "";
    @p9.c("DefaultPath")
    public String defaultPath = "";
    @p9.c("DefaultFormat")
    public String defaultFormat = "";
    @p9.c("DefaultVersionFormat")
    private String defaultVersionFormat = "";

    public boolean equals(Object obj) {
        try {
            if (obj instanceof ImageSourcesType) {
                return this.key.equalsIgnoreCase(((ImageSourcesType) obj).key);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String getDefaultFormat() {
        return this.defaultFormat;
    }

    public String getDefaultPath() {
        return this.defaultPath;
    }

    public String getDefaultVersionFormat() {
        return this.defaultVersionFormat;
    }

    public String getExtension() {
        return this.extension;
    }

    @Override // com.scores365.entitys.IGsonEntity
    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        try {
            return this.key.hashCode();
        } catch (Exception e10) {
            x0.N1(e10);
            return hashCode;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(this.key);
            sb2.append("|");
            sb2.append(this.path);
            sb2.append("|");
            sb2.append(this.extension);
            sb2.append("|");
            sb2.append(this.defaultFormat);
        } catch (Exception unused) {
        }
        return sb2.toString();
    }
}
