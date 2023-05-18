package com.scores365.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import com.scores365.App;
import com.scores365.Design.PageObjects.b;
import com.scores365.Design.Pages.q;
import com.scores365.entitys.SportTypeObj;
import com.scores365.ui.GeneralNotificationListActivity;
import java.util.ArrayList;
import java.util.Iterator;
import li.x0;
/* loaded from: classes2.dex */
public class GeneralNotificationsFragment extends q {
    ArrayList<SportTypeObj> sportTypeObjs;

    public static GeneralNotificationsFragment newInstance() {
        GeneralNotificationsFragment generalNotificationsFragment;
        Exception e10;
        try {
            Bundle bundle = new Bundle();
            generalNotificationsFragment = new GeneralNotificationsFragment();
            try {
                generalNotificationsFragment.setArguments(bundle);
            } catch (Exception e11) {
                e10 = e11;
                e10.printStackTrace();
                return generalNotificationsFragment;
            }
        } catch (Exception e12) {
            generalNotificationsFragment = null;
            e10 = e12;
        }
        return generalNotificationsFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<b> LoadData() {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            this.sportTypeObjs = new ArrayList<>();
            for (SportTypeObj sportTypeObj : App.l().getSportTypes().values()) {
                if (sportTypeObj.getID() != 10) {
                    this.sportTypeObjs.add(sportTypeObj);
                }
            }
            Iterator<SportTypeObj> it = this.sportTypeObjs.iterator();
            while (it.hasNext()) {
                arrayList.add(new SelectSportTypeItem(it.next()));
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
        return arrayList;
    }

    @Override // com.scores365.Design.Pages.a
    public String getIconLink() {
        return null;
    }

    @Override // com.scores365.Design.Pages.a
    public String getPageTitle() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        super.onRecyclerViewItemClick(i10);
        try {
            b A = this.rvBaseAdapter.A(i10);
            if (A instanceof SelectSportTypeItem) {
                SportTypeObj sportTypeObj = ((SelectSportTypeItem) A).sportTypeObj;
                Intent intent = new Intent(App.m(), GeneralNotificationListActivity.class);
                intent.putExtra(GeneralNotificationListActivity.SPORT_TYPE_TAG, sportTypeObj.getID());
                intent.setFlags(335544320);
                App.m().startActivity(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
