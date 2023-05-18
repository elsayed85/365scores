package com.scores365.ui.playerCard;

import android.os.Bundle;
import com.scores365.entitys.GameObj;
import com.scores365.entitys.NewsObj;
import com.scores365.entitys.SocialStatEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import li.x0;
/* loaded from: classes2.dex */
public class PlayerBuzzPage extends com.scores365.Pages.f {
    private static final String ATHLETE_ID_TAG = "athleteIdTag";
    ArrayList<SocialStatEntity> socialStatEntities;

    public static PlayerBuzzPage newInstance(NewsObj newsObj, boolean z10, int i10, GameObj gameObj, int i11, String str, String str2, int i12, boolean z11, boolean z12, ArrayList<SocialStatEntity> arrayList, int i13) {
        PlayerBuzzPage playerBuzzPage = new PlayerBuzzPage();
        playerBuzzPage.newsObj = newsObj;
        Bundle bundle = new Bundle();
        bundle.putBoolean(com.scores365.Pages.f.IS_BUZZ_PAGE_FROM_NOTIFICATION, z10);
        bundle.putInt(com.scores365.Pages.f.GAME_ID_TAG, i10);
        bundle.putString("your_empty_msg", str);
        bundle.putString("page_key", str2);
        bundle.putInt(com.scores365.Pages.f.SCOPE_TAG, i12);
        bundle.putBoolean(com.scores365.Pages.f.SHOW_ADS, z11);
        bundle.putBoolean("is_need_to_add_native_ad", z11);
        bundle.putBoolean("show_direct_deals_ads", z12);
        bundle.putInt(ATHLETE_ID_TAG, i13);
        playerBuzzPage.promotedItem = i11;
        playerBuzzPage.socialStatEntities = arrayList;
        playerBuzzPage.setArguments(bundle);
        playerBuzzPage.gameObj = gameObj;
        return playerBuzzPage;
    }

    private void removeHeaderView() {
        try {
            this.rvBaseAdapter.B().remove(0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Pages.f
    public void addHeaderItem(List<com.scores365.Design.PageObjects.b> list) {
        try {
            Iterator<com.scores365.Design.PageObjects.b> it = list.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof SocialStatItem) {
                    list.remove(i10);
                    break;
                } else {
                    i10++;
                }
            }
            ArrayList<SocialStatEntity> arrayList = this.socialStatEntities;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            list.add(0, new SocialStatItem(this.socialStatEntities, getArguments().getInt(ATHLETE_ID_TAG)));
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Pages.f
    public void handleFloatingLabelClick() {
        removeHeaderView();
        super.handleFloatingLabelClick();
        try {
            this.tvFloatingNewItemsLabel.setVisibility(8);
            addHeaderItem(this.rvBaseAdapter.B());
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
