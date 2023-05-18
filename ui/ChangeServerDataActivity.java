package com.scores365.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.scores365.App;
import com.scores365.R;
import com.scores365.api.n0;
import com.scores365.db.InternalStorageDataManager;
import com.scores365.entitys.BaseObj;
import com.scores365.entitys.CountryObj;
import com.scores365.ui.ChangeServerDataActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import li.x0;
import li.z0;
/* loaded from: classes2.dex */
public class ChangeServerDataActivity extends com.scores365.Design.Activities.c implements z0.b {
    private CheckBox cbAdjustAdGroup;
    private CheckBox cbAdjustCampaign;
    private CheckBox cbAdjustCreative;
    private CheckBox cbAdjustNetwork;
    private CheckBox cbAllLevelsAnswered;
    private CheckBox cbAllStagesOpen;
    private CheckBox cbAppVersion;
    private CheckBox cbBiDebugStream;
    private CheckBox cbForceEditorsChoice;
    private CheckBox cbForceGoogleBettingLayout;
    private CheckBox cbIgnoreBettingRules;
    private CheckBox cbMaximumLevels;
    private CheckBox cbTwoMinutesWaiting;
    private CheckBox cbUseHttpForUserServer;
    private CheckBox cbUseLotteryGoogleBettingLayout;
    private CheckBox cbUseTxtFile;
    private CheckBox cbUserMaturityMonths;
    private CheckBox cbUserMaturityWeeks;
    private CheckBox chkBoxBlockAllScoresNatives;
    private CheckBox chkBoxBlockBanner;
    private CheckBox chkBoxBlockBigNatives;
    private CheckBox chkBoxBlockInterstitial;
    private CheckBox chkBoxBlockMPU;
    private CheckBox chkBoxBlockSmallNatives;
    private HashMap<Integer, CountryObj> countryById;
    private int countryId;
    private ProgressDialog dialogPreLoader;
    private EditText etAdjustAdGroup;
    private EditText etAdjustCampaign;
    private EditText etAdjustCreative;
    private EditText etAdjustNetwork;
    private EditText etAppVersion;
    private EditText etUserMaturityMonths;
    private EditText etUserMaturityWeeks;
    private CheckBox isDirtyCB;
    RelativeLayout progressBarLayout;
    Spinner spinnerChooseCountriesServer;
    Spinner spinnerChooseMonetizationServer;
    Spinner spinnerChoosePurchaseServer;
    Spinner spinnerChooseQuizApi;
    Spinner spinnerChooseServer;
    Spinner spinnerChooseTvChannels;
    Spinner spinnerChooseUsersServer;
    Spinner spinnerDhnApi;
    private boolean serverFirstTime = true;
    private boolean usersServerFirstTime = true;
    private boolean countryFirstTime = true;
    private boolean purchaseFirstTime = true;
    private boolean monetizationFirstTime = true;
    private boolean quizApiFirstTime = true;
    private boolean dhnApiFirstTime = true;
    private boolean tvChannelsFirstTime = true;
    private boolean isDirty = false;
    private boolean isFileUpdated = false;
    int check = 0;
    CompoundButton.OnCheckedChangeListener adjustCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            ChangeServerDataActivity.this.isDirty = true;
            int id2 = compoundButton.getId();
            if (id2 == R.id.S1) {
                ChangeServerDataActivity.this.etAdjustNetwork.setEnabled(z10);
                sf.b.X1().l9(z10);
            } else if (id2 == R.id.Q1) {
                ChangeServerDataActivity.this.etAdjustCampaign.setEnabled(z10);
                sf.b.X1().h9(z10);
            } else if (id2 == R.id.P1) {
                ChangeServerDataActivity.this.etAdjustAdGroup.setEnabled(z10);
                sf.b.X1().g9(z10);
            } else if (id2 == R.id.R1) {
                ChangeServerDataActivity.this.etAdjustCreative.setEnabled(z10);
                sf.b.X1().i9(z10);
            } else if (id2 == R.id.f22194o2) {
                ChangeServerDataActivity.this.etUserMaturityWeeks.setEnabled(z10);
                sf.b.X1().k9(z10);
            } else if (id2 == R.id.f22172n2) {
                ChangeServerDataActivity.this.etUserMaturityMonths.setEnabled(z10);
                sf.b.X1().j9(z10);
            } else if (id2 == R.id.V1) {
                ChangeServerDataActivity.this.etAppVersion.setEnabled(z10);
                sf.b.X1().B8(z10);
            }
        }
    };
    CompoundButton.OnCheckedChangeListener adsBlockChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.2
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @SuppressLint({"NonConstantResourceId"})
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            ChangeServerDataActivity.this.isDirty = true;
            int id2 = compoundButton.getId();
            if (id2 == R.id.J2) {
                sf.b.X1().K6(z10);
            } else if (id2 == R.id.H2) {
                sf.b.X1().O5(z10);
            } else if (id2 == R.id.L2) {
                sf.b.X1().D8(z10);
            } else if (id2 == R.id.I2) {
                sf.b.X1().Z5(z10);
            } else if (id2 == R.id.G2) {
                sf.b.X1().F5(z10);
            } else if (id2 == R.id.K2) {
                sf.b.X1().B7(z10);
            }
        }
    };

    /* renamed from: com.scores365.ui.ChangeServerDataActivity$23  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType;

        static {
            int[] iArr = new int[eSpinnerType.values().length];
            $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType = iArr;
            try {
                iArr[eSpinnerType.MAIN_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.USER_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.COUNTRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.PURCHASE_SERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.MONETIZATION_SERVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.QUIZ_API.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.DHN_API.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[eSpinnerType.TV_CHANNELS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class FetchCountriesListTask extends AsyncTask<Void, Void, HashMap<Integer, CountryObj>> {
        WeakReference<ChangeServerDataActivity> activityRef;

        public FetchCountriesListTask(ChangeServerDataActivity changeServerDataActivity) {
            this.activityRef = new WeakReference<>(changeServerDataActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$doInBackground$0(CountryObj countryObj, CountryObj countryObj2) {
            try {
                return countryObj.getName().compareToIgnoreCase(countryObj2.getName());
            } catch (Exception unused) {
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public HashMap<Integer, CountryObj> doInBackground(Void... voidArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            n0 n0Var = new n0(7);
            n0Var.g(true);
            n0Var.call();
            ArrayList<CountryObj> arrayList = new ArrayList();
            if (n0Var.e() != null) {
                Iterator<BaseObj> it = n0Var.e().iterator();
                while (it.hasNext()) {
                    BaseObj next = it.next();
                    if (next instanceof CountryObj) {
                        arrayList.add((CountryObj) next);
                    }
                }
                Collections.sort(arrayList, new Comparator() { // from class: com.scores365.ui.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int lambda$doInBackground$0;
                        lambda$doInBackground$0 = ChangeServerDataActivity.FetchCountriesListTask.lambda$doInBackground$0((CountryObj) obj, (CountryObj) obj2);
                        return lambda$doInBackground$0;
                    }
                });
                for (CountryObj countryObj : arrayList) {
                    linkedHashMap.put(Integer.valueOf(countryObj.getID()), countryObj);
                }
            }
            return linkedHashMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(HashMap<Integer, CountryObj> hashMap) {
            ChangeServerDataActivity changeServerDataActivity;
            super.onPostExecute((FetchCountriesListTask) hashMap);
            WeakReference<ChangeServerDataActivity> weakReference = this.activityRef;
            if (weakReference == null || (changeServerDataActivity = weakReference.get()) == null) {
                return;
            }
            changeServerDataActivity.dialogPreLoader.dismiss();
            changeServerDataActivity.countryById = hashMap;
            changeServerDataActivity.loadData();
            changeServerDataActivity.readFileAndUpdate();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ChangeServerDataActivity changeServerDataActivity;
            super.onPreExecute();
            WeakReference<ChangeServerDataActivity> weakReference = this.activityRef;
            if (weakReference == null || (changeServerDataActivity = weakReference.get()) == null) {
                return;
            }
            changeServerDataActivity.dialogPreLoader.show();
        }
    }

    /* loaded from: classes2.dex */
    public enum eSpinnerType {
        MAIN_SERVER(1),
        USER_SERVER(2),
        COUNTRY(4),
        PURCHASE_SERVER(5),
        MONETIZATION_SERVER(6),
        QUIZ_API(7),
        DHN_API(8),
        TV_CHANNELS(9);
        
        private int value;

        eSpinnerType(int i10) {
            this.value = i10;
        }

        public static eSpinnerType Create(int i10) {
            if (i10 == 1) {
                return MAIN_SERVER;
            }
            if (i10 == 2) {
                return USER_SERVER;
            }
            if (i10 == 4) {
                return COUNTRY;
            }
            if (i10 == 5) {
                return PURCHASE_SERVER;
            }
            if (i10 == 6) {
                return MONETIZATION_SERVER;
            }
            if (i10 == 7) {
                return QUIZ_API;
            }
            if (i10 == 8) {
                return DHN_API;
            }
            if (i10 == 9) {
                return TV_CHANNELS;
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }
    }

    private ArrayAdapter<String> getArrayAdapter(List<String> list) {
        return new ArrayAdapter<>(getApplicationContext(), R.layout.R8, list);
    }

    private List<String> getCountriesServersList() {
        CountryObj countryObj;
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.countryById.keySet()) {
            CountryObj countryObj2 = this.countryById.get(num);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            sb2.append(num);
            sb2.append(") ");
            if (countryObj2 != null) {
                int fatherCountryId = countryObj2.getFatherCountryId();
                if (fatherCountryId > -1 && (countryObj = this.countryById.get(Integer.valueOf(fatherCountryId))) != null) {
                    sb2.append(countryObj.getName());
                    sb2.append("- ");
                }
                sb2.append(countryObj2.getName());
            }
            sb2.append("                                         ");
            arrayList.add(sb2.toString());
        }
        arrayList.add("Manual");
        return arrayList;
    }

    @NonNull
    private static List<String> getUsersServersList(boolean z10) {
        String str = z10 ? "http" : TournamentShareDialogURIBuilder.scheme;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str + "://mobileusers.365scores.com/");
        arrayList.add(str + "://test.365scores.com/");
        arrayList.add(str + "://qausers.365scores.com");
        arrayList.add(str + "://qa2.365scores.com/");
        arrayList.add(str + "://qa3.365scores.com/");
        arrayList.add(str + "://qa4.365scores.com/");
        arrayList.add(str + "://qa5.365scores.com/");
        arrayList.add("Manual");
        return arrayList;
    }

    private void handleAdjustComponents() {
        this.cbAdjustNetwork = (CheckBox) findViewById(R.id.S1);
        this.etAdjustNetwork = (EditText) findViewById(R.id.f22131l5);
        this.cbAdjustCampaign = (CheckBox) findViewById(R.id.Q1);
        this.etAdjustCampaign = (EditText) findViewById(R.id.f22087j5);
        this.cbAdjustAdGroup = (CheckBox) findViewById(R.id.P1);
        this.etAdjustAdGroup = (EditText) findViewById(R.id.f22064i5);
        this.cbAdjustCreative = (CheckBox) findViewById(R.id.R1);
        this.etAdjustCreative = (EditText) findViewById(R.id.f22109k5);
        this.cbUserMaturityWeeks = (CheckBox) findViewById(R.id.f22194o2);
        this.etUserMaturityWeeks = (EditText) findViewById(R.id.f22286s5);
        this.cbUserMaturityMonths = (CheckBox) findViewById(R.id.f22172n2);
        this.cbAppVersion = (CheckBox) findViewById(R.id.V1);
        this.etUserMaturityMonths = (EditText) findViewById(R.id.f22263r5);
        this.etAppVersion = (EditText) findViewById(R.id.f22153m5);
        this.cbAdjustNetwork.setChecked(sf.b.X1().wa());
        this.cbAdjustCampaign.setChecked(sf.b.X1().sa());
        this.cbAdjustAdGroup.setChecked(sf.b.X1().ra());
        this.cbAdjustCreative.setChecked(sf.b.X1().ta());
        this.cbUserMaturityWeeks.setChecked(sf.b.X1().va());
        this.cbUserMaturityMonths.setChecked(sf.b.X1().ua());
        this.cbAppVersion.setChecked(sf.b.X1().Z9());
        this.etAdjustNetwork.setEnabled(sf.b.X1().wa());
        this.etAdjustCampaign.setEnabled(sf.b.X1().sa());
        this.etAdjustAdGroup.setEnabled(sf.b.X1().ra());
        this.etAdjustCreative.setEnabled(sf.b.X1().ta());
        this.etUserMaturityWeeks.setEnabled(sf.b.X1().va());
        this.etUserMaturityMonths.setEnabled(sf.b.X1().ua());
        this.etAppVersion.setEnabled(sf.b.X1().Z9());
        String n22 = sf.b.X1().n2();
        String j22 = sf.b.X1().j2();
        String i22 = sf.b.X1().i2();
        String k22 = sf.b.X1().k2();
        EditText editText = this.etAdjustNetwork;
        if (n22.isEmpty()) {
            n22 = "";
        }
        editText.setText(n22);
        EditText editText2 = this.etAdjustCampaign;
        if (j22.isEmpty()) {
            j22 = "";
        }
        editText2.setText(j22);
        EditText editText3 = this.etAdjustAdGroup;
        if (i22.isEmpty()) {
            i22 = "";
        }
        editText3.setText(i22);
        EditText editText4 = this.etAdjustCreative;
        if (k22.isEmpty()) {
            k22 = "";
        }
        editText4.setText(k22);
        this.etUserMaturityWeeks.setText(sf.b.X1().m2());
        this.etUserMaturityMonths.setText(sf.b.X1().l2());
        this.etAppVersion.setText(sf.b.X1().h2());
        this.cbAdjustNetwork.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
        this.cbAdjustCampaign.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
        this.cbAdjustAdGroup.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
        this.cbAdjustCreative.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
        this.cbUserMaturityWeeks.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
        this.cbUserMaturityMonths.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
        this.cbAppVersion.setOnCheckedChangeListener(this.adjustCheckedChangeListener);
    }

    private void initAdBlockOptions() {
        this.chkBoxBlockInterstitial = (CheckBox) findViewById(R.id.J2);
        this.chkBoxBlockBanner = (CheckBox) findViewById(R.id.H2);
        this.chkBoxBlockSmallNatives = (CheckBox) findViewById(R.id.L2);
        this.chkBoxBlockBigNatives = (CheckBox) findViewById(R.id.I2);
        this.chkBoxBlockAllScoresNatives = (CheckBox) findViewById(R.id.G2);
        this.chkBoxBlockMPU = (CheckBox) findViewById(R.id.K2);
        this.chkBoxBlockInterstitial.setChecked(sf.b.X1().c4());
        this.chkBoxBlockBanner.setChecked(sf.b.X1().E3());
        this.chkBoxBlockSmallNatives.setChecked(sf.b.X1().T4());
        this.chkBoxBlockBigNatives.setChecked(sf.b.X1().J3());
        this.chkBoxBlockAllScoresNatives.setChecked(sf.b.X1().z3());
        this.chkBoxBlockMPU.setChecked(sf.b.X1().f4());
        this.chkBoxBlockInterstitial.setOnCheckedChangeListener(this.adsBlockChangeListener);
        this.chkBoxBlockBanner.setOnCheckedChangeListener(this.adsBlockChangeListener);
        this.chkBoxBlockSmallNatives.setOnCheckedChangeListener(this.adsBlockChangeListener);
        this.chkBoxBlockBigNatives.setOnCheckedChangeListener(this.adsBlockChangeListener);
        this.chkBoxBlockAllScoresNatives.setOnCheckedChangeListener(this.adsBlockChangeListener);
        this.chkBoxBlockMPU.setOnCheckedChangeListener(this.adsBlockChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadData() {
        try {
            setServerSpinnerData();
            setUsersServerSpinnerData(sf.b.X1().a4());
            setCountriesSpinnerData();
            setPurchaseSpinnerData();
            setMonetizationSpinnerData();
            setQuizApiEnvironment();
            setDhnApiEnvironment();
            setTvChannelUC();
            handleCheckBox();
            setViewsEnabled(sf.b.X1().j4());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDiaog(eSpinnerType espinnertype, int i10) {
        ChangeServerDialog changeServerDialog = new ChangeServerDialog();
        changeServerDialog.setSpinnerType(espinnertype);
        changeServerDialog.setPositionInSpinner(i10);
        changeServerDialog.show(getSupportFragmentManager(), "Dialog Special tag");
    }

    private void setCountriesSpinnerData() {
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(getCountriesServersList());
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                try {
                    if (!ChangeServerDataActivity.this.countryFirstTime) {
                        ChangeServerDataActivity.this.isDirty = true;
                    }
                    if (i10 == adapterView.getCount() - 1) {
                        ChangeServerDataActivity.this.openDiaog(eSpinnerType.COUNTRY, i10);
                        return;
                    }
                    String str = (String) adapterView.getItemAtPosition(i10);
                    String substring = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
                    ChangeServerDataActivity.this.countryId = Integer.parseInt(substring);
                    sf.b.X1().Z7(ChangeServerDataActivity.this.countryId);
                    ChangeServerDataActivity.this.countryFirstTime = false;
                } catch (NumberFormatException e10) {
                    x0.N1(e10);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChooseCountriesServer;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChooseCountriesServer.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private void setDhnApiEnvironment() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("https://dhn-ads-api.365scores.com");
        arrayList.add("https://dhn-ads-api.appspot.com/");
        arrayList.add("http://dhn-ads-api.365scores.com");
        arrayList.add("http://dhn-ads-api.appspot.com/");
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(arrayList);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.5
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (!ChangeServerDataActivity.this.dhnApiFirstTime) {
                    ChangeServerDataActivity.this.isDirty = true;
                }
                sf.b.X1().g6((String) adapterView.getItemAtPosition(i10));
                ChangeServerDataActivity.this.dhnApiFirstTime = false;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerDhnApi;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerDhnApi.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHttpForUsers(boolean z10) {
        setUsersServerSpinnerData(z10);
        this.spinnerChooseUsersServer.setAdapter((SpinnerAdapter) getArrayAdapter(getUsersServersList(z10)));
        ((ArrayAdapter) this.spinnerChooseUsersServer.getAdapter()).notifyDataSetChanged();
    }

    private void setMonetizationSpinnerData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http://adrsettings.365scores.com/api/AdsSettings/GetAdsSettings/");
        arrayList.add("http://adrsettingstest.365scores.com/api/AdsSettings/GetAdsSettings/");
        arrayList.add("Manual");
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(arrayList);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (!ChangeServerDataActivity.this.monetizationFirstTime) {
                    ChangeServerDataActivity.this.isDirty = true;
                }
                if (i10 == adapterView.getCount() - 1) {
                    ChangeServerDataActivity.this.openDiaog(eSpinnerType.MONETIZATION_SERVER, i10);
                } else {
                    sf.b.X1().I7((String) adapterView.getItemAtPosition(i10));
                }
                ChangeServerDataActivity.this.monetizationFirstTime = false;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChooseMonetizationServer;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChooseMonetizationServer.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private void setPurchaseSpinnerData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http://purchase.365scores.com/");
        arrayList.add("http://purchasetest.365scores.com/");
        arrayList.add("Manual");
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(arrayList);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (!ChangeServerDataActivity.this.purchaseFirstTime) {
                    ChangeServerDataActivity.this.isDirty = true;
                }
                if (i10 == adapterView.getCount() - 1) {
                    ChangeServerDataActivity.this.openDiaog(eSpinnerType.PURCHASE_SERVER, i10);
                } else {
                    sf.b.X1().b8((String) adapterView.getItemAtPosition(i10));
                }
                ChangeServerDataActivity.this.purchaseFirstTime = false;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChoosePurchaseServer;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChoosePurchaseServer.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private void setQuizApiEnvironment() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("prod");
        arrayList.add("qa");
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(arrayList);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (!ChangeServerDataActivity.this.quizApiFirstTime) {
                    ChangeServerDataActivity.this.isDirty = true;
                }
                sf.b.X1().c8((String) adapterView.getItemAtPosition(i10));
                ChangeServerDataActivity.this.quizApiFirstTime = false;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChooseQuizApi;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChooseQuizApi.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private void setServerSpinnerData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http://mobileapi.365scores.com/");
        arrayList.add("http://test.365scores.com/");
        arrayList.add("http://qa.365scores.com/");
        arrayList.add("http://qa1.365scores.com/");
        arrayList.add("http://qa2.365scores.com/");
        arrayList.add("http://qa3.365scores.com/");
        arrayList.add("http://qa4.365scores.com/");
        arrayList.add("http://qa5.365scores.com/");
        arrayList.add("http://qa6.365scores.com/");
        arrayList.add("http://qa7.365scores.com/");
        arrayList.add("http://qa8.365scores.com/");
        arrayList.add("http://qa9.365scores.com/");
        arrayList.add("http://qa10.365scores.com/");
        arrayList.add("http://dsbase.365scores.com/");
        arrayList.add("http://qa-auto.365scores.com/");
        arrayList.add("Manual");
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(arrayList);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.7
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (!ChangeServerDataActivity.this.serverFirstTime) {
                    ChangeServerDataActivity.this.isDirty = true;
                }
                if (i10 == adapterView.getCount() - 1) {
                    ChangeServerDataActivity.this.openDiaog(eSpinnerType.MAIN_SERVER, i10);
                } else {
                    sf.b.X1().C7((String) adapterView.getItemAtPosition(i10));
                }
                ChangeServerDataActivity.this.serverFirstTime = false;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChooseServer;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChooseServer.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private void setSpinnerPositionByString(Spinner spinner, String str) {
        for (int i10 = 0; i10 < spinner.getCount(); i10++) {
            if (spinner.getItemAtPosition(i10).equals(str)) {
                spinner.setSelection(i10);
            }
        }
    }

    private void setTvChannelUC() {
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(getCountriesServersList());
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                try {
                    if (!ChangeServerDataActivity.this.tvChannelsFirstTime) {
                        ChangeServerDataActivity.this.isDirty = true;
                    }
                    if (i10 == adapterView.getCount() - 1) {
                        ChangeServerDataActivity.this.openDiaog(eSpinnerType.TV_CHANNELS, i10);
                        return;
                    }
                    String str = (String) adapterView.getItemAtPosition(i10);
                    sf.b.X1().a9(str.substring(str.indexOf("(") + 1, str.indexOf(")")));
                    ChangeServerDataActivity.this.tvChannelsFirstTime = false;
                } catch (NumberFormatException e10) {
                    x0.N1(e10);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChooseTvChannels;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChooseTvChannels.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    private void setUsersServerSpinnerData(boolean z10) {
        ArrayAdapter<String> arrayAdapter = getArrayAdapter(getUsersServersList(z10));
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: com.scores365.ui.ChangeServerDataActivity.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (!ChangeServerDataActivity.this.usersServerFirstTime) {
                    ChangeServerDataActivity.this.isDirty = true;
                }
                if (i10 == adapterView.getCount() - 1) {
                    ChangeServerDataActivity.this.openDiaog(eSpinnerType.USER_SERVER, i10);
                } else {
                    sf.b.X1().C9((String) adapterView.getItemAtPosition(i10));
                }
                ChangeServerDataActivity.this.usersServerFirstTime = false;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        Spinner spinner = this.spinnerChooseUsersServer;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(onItemSelectedListener);
            this.spinnerChooseUsersServer.setAdapter((SpinnerAdapter) arrayAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewsEnabled(boolean z10) {
        try {
            this.spinnerChooseCountriesServer.setEnabled(z10);
            this.spinnerChooseServer.setEnabled(z10);
            this.spinnerChooseUsersServer.setEnabled(z10);
            this.spinnerChoosePurchaseServer.setEnabled(z10);
            this.spinnerChooseMonetizationServer.setEnabled(z10);
            this.spinnerChooseTvChannels.setEnabled(z10);
            this.spinnerChooseQuizApi.setEnabled(z10);
            this.cbUseTxtFile.setChecked(z10);
            this.cbUseHttpForUserServer.setEnabled(z10);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public static void startActivity(Context context) {
        try {
            Intent intent = new Intent(context, ChangeServerDataActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void defaultSelections(eSpinnerType espinnertype, int i10) {
        try {
            switch (AnonymousClass23.$SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[espinnertype.ordinal()]) {
                case 1:
                    sf.b.X1().C7(sf.b.X1().k1());
                    this.spinnerChooseServer.setSelection(0, false);
                    break;
                case 2:
                    sf.b.X1().C9(sf.b.X1().S2());
                    this.spinnerChooseUsersServer.setSelection(0, false);
                    break;
                case 3:
                    sf.b.X1().Z7(sf.b.X1().C1());
                    this.spinnerChooseCountriesServer.setSelection(0, false);
                    break;
                case 4:
                    sf.b.X1().b8(sf.b.X1().I1());
                    this.spinnerChoosePurchaseServer.setSelection(0, false);
                    break;
                case 5:
                    sf.b.X1().I7(sf.b.X1().r1());
                    this.spinnerChooseMonetizationServer.setSelection(0, false);
                    break;
                case 6:
                    sf.b.X1().c8(sf.b.X1().J1());
                    this.spinnerChooseQuizApi.setSelection(0, false);
                    break;
                case 7:
                    sf.b.X1().g6(sf.b.X1().n0());
                    this.spinnerDhnApi.setSelection(0, false);
                    break;
                case 8:
                    sf.b.X1().a9(sf.b.X1().z2());
                    this.spinnerChooseTvChannels.setSelection(0, false);
                    break;
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Activities.c
    public String getPageTitle() {
        return null;
    }

    public void handleCheckBox() {
        this.cbUseTxtFile.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.ChangeServerDataActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ChangeServerDataActivity.this.isDirty = true;
                    sf.b.X1().V6(((CheckBox) view).isChecked());
                    ChangeServerDataActivity.this.setViewsEnabled(((CheckBox) view).isChecked());
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        });
        this.isDirtyCB.setOnClickListener(new View.OnClickListener() { // from class: com.scores365.ui.ChangeServerDataActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ChangeServerDataActivity.this.isDirty = true;
                    sf.b.X1().V6(((CheckBox) view).isChecked());
                    ChangeServerDataActivity.this.setViewsEnabled(((CheckBox) view).isChecked());
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        });
        this.cbUseHttpForUserServer.setChecked(sf.b.X1().a4());
        this.cbUseHttpForUserServer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.13
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ChangeServerDataActivity.this.isDirty = true;
                ChangeServerDataActivity.this.setHttpForUsers(z10);
                sf.b.X1().E6(z10);
            }
        });
        this.cbForceEditorsChoice.setChecked(sf.b.X1().O3());
        this.cbForceEditorsChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                try {
                    ChangeServerDataActivity.this.isDirty = true;
                    sf.b.X1().x6(z10);
                } catch (Exception e10) {
                    x0.N1(e10);
                }
            }
        });
        this.cbMaximumLevels.setChecked(sf.b.X1().D4());
        this.cbMaximumLevels.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.15
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ChangeServerDataActivity.this.isDirty = true;
                sf.b.X1().i8(z10);
            }
        });
        this.cbTwoMinutesWaiting.setChecked(sf.b.X1().E4());
        this.cbTwoMinutesWaiting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.16
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ChangeServerDataActivity.this.isDirty = true;
                sf.b.X1().j8(z10);
            }
        });
        this.cbAllStagesOpen.setChecked(sf.b.X1().z4());
        this.cbAllStagesOpen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ChangeServerDataActivity.this.isDirty = true;
                sf.b.X1().e8(z10);
            }
        });
        this.cbAllLevelsAnswered.setChecked(sf.b.X1().y4());
        this.cbAllLevelsAnswered.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.18
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ChangeServerDataActivity.this.isDirty = true;
                sf.b.X1().d8(z10);
            }
        });
        this.cbBiDebugStream.setChecked(sf.b.X1().qa());
        this.cbBiDebugStream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.19
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                Toast.makeText(ChangeServerDataActivity.this.getApplicationContext(), "restart the app", 0).show();
                sf.b.X1().f9(z10);
            }
        });
        this.cbIgnoreBettingRules.setChecked(sf.b.X1().R9());
        this.cbIgnoreBettingRules.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.20
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                sf.b.X1().F6(z10);
            }
        });
        this.cbUseLotteryGoogleBettingLayout.setChecked(sf.b.X1().Q9());
        this.cbForceGoogleBettingLayout.setEnabled(sf.b.X1().Q9());
        this.cbUseLotteryGoogleBettingLayout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.21
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                sf.b.X1().z6(z10);
                ChangeServerDataActivity.this.cbForceGoogleBettingLayout.setEnabled(z10);
            }
        });
        this.cbForceGoogleBettingLayout.setChecked(sf.b.X1().P9());
        this.cbForceGoogleBettingLayout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.scores365.ui.ChangeServerDataActivity.22
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                sf.b.X1().y6(z10);
            }
        });
    }

    @Override // com.scores365.Design.Activities.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String str = "";
        try {
            if (!this.isDirty) {
                super.onBackPressed();
                return;
            }
            li.h0.b();
            sf.b.X1().s5(0L);
            re.h.f37484a = true;
            App.N("");
            this.progressBarLayout.setVisibility(0);
            li.j.f("DHN_SDK_VERSION", -1);
            InternalStorageDataManager.saveDhnData("");
            z0.l(this, true);
            String obj = this.etAdjustNetwork.getText().toString();
            String obj2 = this.etAdjustCampaign.getText().toString();
            String obj3 = this.etAdjustAdGroup.getText().toString();
            String obj4 = this.etAdjustCreative.getText().toString();
            String obj5 = this.etUserMaturityWeeks.getText().toString();
            String obj6 = this.etUserMaturityMonths.getText().toString();
            String obj7 = this.etAppVersion.getText().toString();
            boolean wa2 = sf.b.X1().wa();
            boolean sa2 = sf.b.X1().sa();
            boolean ra2 = sf.b.X1().ra();
            boolean ta2 = sf.b.X1().ta();
            boolean va2 = sf.b.X1().va();
            boolean ua2 = sf.b.X1().ua();
            boolean Z9 = sf.b.X1().Z9();
            sf.b X1 = sf.b.X1();
            if (!wa2 || obj.isEmpty()) {
                obj = "";
            }
            X1.R8(obj);
            sf.b X12 = sf.b.X1();
            if (!sa2 || obj2.isEmpty()) {
                obj2 = "";
            }
            X12.N8(obj2);
            sf.b X13 = sf.b.X1();
            if (!ra2 || obj3.isEmpty()) {
                obj3 = "";
            }
            X13.M8(obj3);
            sf.b X14 = sf.b.X1();
            if (!ta2 || obj4.isEmpty()) {
                obj4 = "";
            }
            X14.O8(obj4);
            sf.b X15 = sf.b.X1();
            if (!va2 || obj5.isEmpty()) {
                obj5 = "";
            }
            X15.Q8(obj5);
            sf.b X16 = sf.b.X1();
            if (!ua2 || obj6.isEmpty()) {
                obj6 = "";
            }
            X16.P8(obj6);
            sf.b X17 = sf.b.X1();
            if (Z9 && !obj7.isEmpty()) {
                str = obj7;
            }
            X17.L8(str);
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Activities.c, androidx.fragment.app.h, androidx.activity.ComponentActivity, androidx.core.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f22470b);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialogPreLoader = progressDialog;
        progressDialog.setTitle("Please wait while fetching countries");
        this.spinnerChooseServer = (Spinner) findViewById(R.id.Aq);
        this.spinnerChooseUsersServer = (Spinner) findViewById(R.id.Dq);
        this.spinnerChooseTvChannels = (Spinner) findViewById(R.id.Cq);
        this.spinnerChooseCountriesServer = (Spinner) findViewById(R.id.uq);
        this.spinnerChoosePurchaseServer = (Spinner) findViewById(R.id.yq);
        this.spinnerChooseMonetizationServer = (Spinner) findViewById(R.id.xq);
        this.spinnerDhnApi = (Spinner) findViewById(R.id.vq);
        this.spinnerChooseQuizApi = (Spinner) findViewById(R.id.zq);
        this.cbUseTxtFile = (CheckBox) findViewById(R.id.f22150m2);
        this.cbUseHttpForUserServer = (CheckBox) findViewById(R.id.f22128l2);
        this.isDirtyCB = (CheckBox) findViewById(R.id.np);
        this.cbForceEditorsChoice = (CheckBox) findViewById(R.id.f21948d2);
        this.cbMaximumLevels = (CheckBox) findViewById(R.id.f22039h2);
        this.cbTwoMinutesWaiting = (CheckBox) findViewById(R.id.f22106k2);
        this.cbAllStagesOpen = (CheckBox) findViewById(R.id.U1);
        this.cbAllLevelsAnswered = (CheckBox) findViewById(R.id.T1);
        this.cbBiDebugStream = (CheckBox) findViewById(R.id.W1);
        this.cbIgnoreBettingRules = (CheckBox) findViewById(R.id.f21994f2);
        this.cbForceGoogleBettingLayout = (CheckBox) findViewById(R.id.f21971e2);
        this.cbUseLotteryGoogleBettingLayout = (CheckBox) findViewById(R.id.f22017g2);
        this.progressBarLayout = (RelativeLayout) findViewById(R.id.Jn);
        initAdBlockOptions();
        handleAdjustComponents();
        new FetchCountriesListTask(this).execute(new Void[0]);
    }

    @Override // li.z0.b
    public void onProcessFinish(boolean z10, int i10) {
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            launchIntentForPackage.setFlags(268435456);
            launchIntentForPackage.addFlags(1073741824);
            launchIntentForPackage.addFlags(67108864);
            startActivity(launchIntentForPackage);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void readFileAndUpdate() {
        try {
            if (!sf.b.X1().j4()) {
                setViewsEnabled(false);
                return;
            }
            setSpinnerPositionByString(this.spinnerChooseServer, sf.b.X1().k1());
            setSpinnerPositionByString(this.spinnerChooseUsersServer, sf.b.X1().S2());
            setSpinnerPositionByString(this.spinnerChoosePurchaseServer, sf.b.X1().I1());
            setSpinnerPositionByString(this.spinnerChooseMonetizationServer, sf.b.X1().r1());
            setSpinnerPositionByString(this.spinnerChooseQuizApi, sf.b.X1().J1());
            for (int i10 = 0; i10 < this.spinnerChooseCountriesServer.getCount(); i10++) {
                if (((String) this.spinnerChooseCountriesServer.getItemAtPosition(i10)).contains("(" + sf.b.X1().C1() + ")")) {
                    this.spinnerChooseCountriesServer.setSelection(i10);
                }
            }
            String z22 = sf.b.X1().z2();
            for (int i11 = 0; i11 < this.spinnerChooseTvChannels.getCount(); i11++) {
                if (((String) this.spinnerChooseTvChannels.getItemAtPosition(i11)).contains("(" + z22 + ")")) {
                    this.spinnerChooseTvChannels.setSelection(i11);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
