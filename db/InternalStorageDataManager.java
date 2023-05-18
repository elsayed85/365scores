package com.scores365.db;

import android.os.AsyncTask;
import com.scores365.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import li.x0;
/* loaded from: classes2.dex */
public class InternalStorageDataManager {
    private static final String DASHBOARD_FILE_NAME = "dashboardData.json";
    private static final String DHN_DATA_FILE_NAME = "dhnData.txt";
    private static final String PROMOTION_FILE_NAME = "promotionData.json";
    private static final String PURCHASE_DATA_FOR_FEEDBACK_FILE_NAME = "purchaseDataForFeedback.txt";
    private static final String RECENT_SEARCHES_FILE_NAME = "recentSearches.txt";
    private static final String SPECIAL_FILTERS_FILE_NAME = "specialFilters.txt";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends AsyncTask<String, Void, Void> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            try {
                InternalStorageDataManager.saveDashboardData(strArr[0]);
                return null;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }
    }

    public static String loadDashboardData() {
        return loadData(DASHBOARD_FILE_NAME);
    }

    private static String loadData(String str) {
        return loadData(str, true);
    }

    private static String loadData(String str, boolean z10) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                File filesDir = App.m().getFilesDir();
                filesDir.mkdir();
                File file = new File(filesDir, str);
                file.createNewFile();
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb3 = sb2.toString();
                    try {
                        bufferedReader.close();
                        return sb3;
                    } catch (Exception e11) {
                        x0.N1(e11);
                        return sb3;
                    }
                }
                sb2.append(readLine);
                if (z10) {
                    sb2.append('\n');
                }
            }
        } catch (Exception e12) {
            e = e12;
            bufferedReader2 = bufferedReader;
            x0.N1(e);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e13) {
                    x0.N1(e13);
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e14) {
                    x0.N1(e14);
                }
            }
            throw th;
        }
    }

    public static String loadDhnData() {
        return loadData(DHN_DATA_FILE_NAME);
    }

    public static String loadPromotionData() {
        return loadData(PROMOTION_FILE_NAME);
    }

    public static String loadPurchaseDataForFeedback() {
        return loadData(PURCHASE_DATA_FOR_FEEDBACK_FILE_NAME, false);
    }

    public static String loadRecentSearchesData() {
        return loadData(RECENT_SEARCHES_FILE_NAME, false);
    }

    public static String loadSpecialFiltersData() {
        return loadData(SPECIAL_FILTERS_FILE_NAME, false);
    }

    public static void saveDashboardData(String str) {
        saveData(DASHBOARD_FILE_NAME, str);
    }

    public static void saveDashboardDataAsync(String str) {
        try {
            new b().execute(str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private static void saveData(String str, String str2) {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    File filesDir = App.m().getFilesDir();
                    filesDir.mkdir();
                    File file = new File(filesDir, str);
                    if (str2 == null) {
                        file.delete();
                    } else {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                        try {
                            bufferedWriter2.write(str2);
                            bufferedWriter = bufferedWriter2;
                        } catch (Exception e10) {
                            bufferedWriter = bufferedWriter2;
                            e = e10;
                            x0.N1(e);
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            bufferedWriter = bufferedWriter2;
                            th = th2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception e11) {
                                    x0.N1(e11);
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e12) {
                    x0.N1(e12);
                    return;
                }
            } catch (Exception e13) {
                e = e13;
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void saveDhnData(String str) {
        saveData(DHN_DATA_FILE_NAME, str);
    }

    public static void savePromotionData(String str) {
        saveData(PROMOTION_FILE_NAME, str);
    }

    public static void savePurchaseDataForFeedback(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append(loadPurchaseDataForFeedback());
            sb2.append("\n");
            sb2.append(str);
        } catch (Exception e10) {
            x0.N1(e10);
        }
        saveData(PURCHASE_DATA_FOR_FEEDBACK_FILE_NAME, sb2.toString());
    }

    public static void saveRecentSearchesData(String str) {
        saveData(RECENT_SEARCHES_FILE_NAME, str);
    }

    public static void saveSpecialFiltersData(String str) {
        saveData(SPECIAL_FILTERS_FILE_NAME, str);
    }
}
