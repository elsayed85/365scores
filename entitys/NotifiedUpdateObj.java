package com.scores365.entitys;

import com.scores365.App;
import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public class NotifiedUpdateObj extends BaseObj {
    public static final int ATHLETE_ENTITY_ID = 4;
    public static final int COMPETITIONS_ENTITY_ID = 1;
    public static final int COMPETITORS_ENTITY_ID = 2;
    public static final int GAMES_ENTITY_ID = 3;
    private static final long serialVersionUID = -184237943178719993L;
    @p9.c("AndroidNotificationText")
    private String AndroidNotificationText;
    @p9.c("AutoSelectTypes")
    private int[] autoSelectType;
    @p9.c("Category")
    private int categoryId;
    @p9.c("ConnectedToType")
    private int connectedTo;
    @p9.c("IsDisplayed")
    private boolean isDisplayed;
    @p9.c("IsMajor")
    public boolean isMajor;
    @p9.c("Params")
    private ParamObj[] params;
    @p9.c("RelevantEntitiesTypes")
    private ArrayList<RelevantEntitiesType> relevantEntitiesTypes;
    @p9.c("SelectedByDef")
    private boolean selectedByDef;
    private boolean selectedInAdapter;
    private int sound;
    @p9.c("SportTypeID")
    private int sportTypeId;
    @p9.c("Template")
    private String template;
    @p9.c("TimeOfRelevancy")
    public int timeOfRelevancy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.entitys.NotifiedUpdateObj$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$App$eEntityType;

        static {
            int[] iArr = new int[App.c.values().length];
            $SwitchMap$com$scores365$App$eEntityType = iArr;
            try {
                iArr[App.c.TEAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$App$eEntityType[App.c.LEAGUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$App$eEntityType[App.c.GAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$App$eEntityType[App.c.ATHLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public NotifiedUpdateObj() {
        this.connectedTo = -1;
        this.AndroidNotificationText = "";
        this.selectedInAdapter = false;
        this.isMajor = false;
        this.categoryId = -1;
    }

    public NotifiedUpdateObj(int i10, String str, ParamObj[] paramObjArr, int i11, boolean z10, String str2, boolean z11, int i12, String str3, boolean z12, int i13) {
        super(i10, str);
        this.selectedInAdapter = false;
        this.categoryId = -1;
        this.params = paramObjArr;
        this.sportTypeId = i11;
        this.selectedByDef = z10;
        this.template = str2;
        this.isDisplayed = z11;
        this.connectedTo = i12;
        this.AndroidNotificationText = str3;
        this.isMajor = z12;
        this.timeOfRelevancy = i13;
    }

    private int getCategoryForEntityType(int i10) {
        int intValue;
        int i11 = 0;
        try {
            if (i10 == -1) {
                intValue = this.categoryId;
            } else {
                RelevantEntitiesType relevantEntityType = getRelevantEntityType(i10);
                if (relevantEntityType == null) {
                    return 0;
                }
                intValue = relevantEntityType.getCategory().intValue();
            }
            i11 = intValue;
            return i11;
        } catch (Exception e10) {
            x0.N1(e10);
            return i11;
        }
    }

    public String GetNotificationNameText() {
        String str = this.name;
        try {
            return !this.AndroidNotificationText.equals("") ? this.AndroidNotificationText : str;
        } catch (Exception unused) {
            return str;
        }
    }

    public int[] getAutoSelectType() {
        return this.autoSelectType;
    }

    public int getCategoryId(int i10) {
        return getCategoryForEntityType(i10);
    }

    public int getConnectedTo() {
        return this.connectedTo;
    }

    public boolean getIsDisplayed() {
        return this.isDisplayed;
    }

    public String getNameForRelevantEntity(int i10) {
        String name = getName();
        try {
            RelevantEntitiesType relevantEntityType = getRelevantEntityType(i10);
            return (relevantEntityType == null || relevantEntityType.getName() == null || relevantEntityType.getName().isEmpty()) ? name : relevantEntityType.getName();
        } catch (Exception e10) {
            e10.printStackTrace();
            return name;
        }
    }

    public ParamObj[] getParams() {
        return this.params;
    }

    public RelevantEntitiesType getRelevantEntityType(int i10) {
        try {
            ArrayList<RelevantEntitiesType> arrayList = this.relevantEntitiesTypes;
            if (arrayList != null) {
                Iterator<RelevantEntitiesType> it = arrayList.iterator();
                while (it.hasNext()) {
                    RelevantEntitiesType next = it.next();
                    if (next != null && next.getEntityTypeId().intValue() == i10) {
                        return next;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e10) {
            x0.N1(e10);
            return null;
        }
    }

    public boolean getSelectedByDef() {
        return this.selectedByDef;
    }

    public int getSound() {
        return this.sound;
    }

    public String getTemplate() {
        return this.template;
    }

    public boolean isAutoSelectedNotificationsListNotEmpty() {
        int[] iArr = this.autoSelectType;
        return iArr != null && iArr.length > 0;
    }

    public boolean isNotificationShouldAutoSelect(int i10) {
        try {
            int[] iArr = this.autoSelectType;
            if (iArr == null || iArr.length <= 0) {
                return false;
            }
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isRelevantForEntityType(int i10) {
        try {
            return getRelevantEntityType(i10) != null;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isSelectedByDefAthlete() {
        return isSelectedByDefForEntityType(4);
    }

    public boolean isSelectedByDefCompetition() {
        return isSelectedByDefForEntityType(1);
    }

    public boolean isSelectedByDefCompetitor() {
        return isSelectedByDefForEntityType(2);
    }

    public boolean isSelectedByDefForEntityType(int i10) {
        try {
            RelevantEntitiesType relevantEntityType = getRelevantEntityType(i10);
            if (relevantEntityType != null) {
                return relevantEntityType.getSelectedByDef().booleanValue();
            }
            return false;
        } catch (Exception e10) {
            x0.N1(e10);
            return false;
        }
    }

    public boolean isSelectedByDefForEntityType(App.c cVar) {
        int i10 = AnonymousClass1.$SwitchMap$com$scores365$App$eEntityType[cVar.ordinal()];
        int i11 = 2;
        if (i10 != 1) {
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        i11 = 0;
                    }
                }
            } else {
                i11 = 1;
            }
        }
        return isSelectedByDefForEntityType(i11);
    }

    public boolean isSelectedByDefGame() {
        return isSelectedByDefForEntityType(3);
    }

    public boolean isSelectedInAdapter() {
        return this.selectedInAdapter;
    }

    public void setIsSelectedInAdapter(boolean z10) {
        this.selectedInAdapter = z10;
    }

    public void setSound(int i10) {
        this.sound = i10;
    }

    public int sportTypeId() {
        return this.sportTypeId;
    }
}
