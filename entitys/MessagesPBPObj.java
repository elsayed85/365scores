package com.scores365.entitys;

import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public class MessagesPBPObj {
    @p9.c("Drives")
    private ArrayList<PlayByPlayDriveObj> drives;
    @p9.c("FilterCategories")
    private ArrayList<FilterCategoriesObj> filterCategories;
    @p9.c("Messages")
    private ArrayList<PlayByPlayMessageObj> messages;
    @p9.c("TTL")
    private int ttl;
    @p9.c("UpdateURL")
    private String updateUrl;

    public ArrayList<PlayByPlayDriveObj> getDeltaOfDrivesList(ArrayList<PlayByPlayDriveObj> arrayList) {
        boolean z10;
        ArrayList<PlayByPlayDriveObj> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    ArrayList<PlayByPlayDriveObj> arrayList3 = this.drives;
                    if (arrayList3 == null || arrayList3.isEmpty()) {
                        arrayList2.addAll(arrayList);
                    } else {
                        Iterator<PlayByPlayDriveObj> it = arrayList.iterator();
                        while (it.hasNext()) {
                            PlayByPlayDriveObj next = it.next();
                            Iterator<PlayByPlayDriveObj> it2 = this.drives.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z10 = false;
                                    break;
                                } else if (it2.next().getId() == next.getId()) {
                                    z10 = true;
                                    break;
                                }
                            }
                            if (!z10) {
                                arrayList2.add(next);
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return arrayList2;
    }

    public ArrayList<PlayByPlayMessageObj> getDeltaOfList(ArrayList<PlayByPlayMessageObj> arrayList) {
        boolean z10;
        ArrayList<PlayByPlayMessageObj> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    ArrayList<PlayByPlayMessageObj> arrayList3 = this.messages;
                    if (arrayList3 == null || arrayList3.isEmpty()) {
                        arrayList2.addAll(arrayList);
                    } else {
                        Iterator<PlayByPlayMessageObj> it = arrayList.iterator();
                        while (it.hasNext()) {
                            PlayByPlayMessageObj next = it.next();
                            Iterator<PlayByPlayMessageObj> it2 = this.messages.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z10 = false;
                                    break;
                                } else if (it2.next().getId() == next.getId()) {
                                    z10 = true;
                                    break;
                                }
                            }
                            if (!z10) {
                                arrayList2.add(next);
                            }
                        }
                    }
                }
            } catch (Exception e10) {
                x0.N1(e10);
            }
        }
        return arrayList2;
    }

    public ArrayList<PlayByPlayDriveObj> getDrives() {
        return this.drives;
    }

    public ArrayList<FilterCategoriesObj> getFilterCategories() {
        return this.filterCategories;
    }

    public ArrayList<PlayByPlayMessageObj> getMessages() {
        return this.messages;
    }

    public int getTtl() {
        return this.ttl;
    }

    public String getUpdateUrl() {
        return this.updateUrl;
    }

    public void replace(ArrayList<PlayByPlayMessageObj> arrayList) {
        try {
            ArrayList<PlayByPlayMessageObj> arrayList2 = this.messages;
            if (arrayList2 == null || arrayList == null) {
                this.messages = new ArrayList<>(arrayList);
            } else {
                arrayList2.clear();
                this.messages.addAll(arrayList);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setFilterCategories(ArrayList<FilterCategoriesObj> arrayList) {
        this.filterCategories = arrayList;
    }

    public void setTTL(int i10) {
        this.ttl = i10;
    }

    public void setUpdateUrl(String str) {
        this.updateUrl = str;
    }

    public void updateDrives(ArrayList<PlayByPlayDriveObj> arrayList) {
        try {
            ArrayList<PlayByPlayDriveObj> arrayList2 = this.drives;
            if (arrayList2 != null) {
                if (arrayList != null) {
                    arrayList2.addAll(0, getDeltaOfDrivesList(arrayList));
                }
            } else if (arrayList != null) {
                this.drives = new ArrayList<>(arrayList);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void updateList(ArrayList<PlayByPlayMessageObj> arrayList) {
        try {
            ArrayList<PlayByPlayMessageObj> arrayList2 = this.messages;
            if (arrayList2 == null) {
                this.messages = new ArrayList<>(arrayList);
            } else if (arrayList != null) {
                arrayList2.addAll(0, getDeltaOfList(arrayList));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
