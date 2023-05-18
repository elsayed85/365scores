package com.scores365.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bf.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import li.l0;
import li.x0;
/* loaded from: classes2.dex */
public class SelectSoundFragment extends com.scores365.Design.Pages.q {
    public static final String ENTITY_TYPE_FOR_ANALYTICS = "entityTypeForAnalytics";
    public static final String NOTIFICATION_ID_TAG = "notificationId";
    public static final String NOTIFICATION_NAME_TAG = "notificationName";
    public static final String SOUND_ID_TAG = "soundId";
    boolean isDirty;
    private MediaPlayer mp;
    private int selectedSoundId;
    private int selectedSoundPosition;
    Vector<li.k0> sounds;

    public static SelectSoundFragment newInstance(int i10, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt(SOUND_ID_TAG, i10);
        bundle.putInt(NOTIFICATION_ID_TAG, i11);
        SelectSoundFragment selectSoundFragment = new SelectSoundFragment();
        selectSoundFragment.setArguments(bundle);
        return selectSoundFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public ArrayList<com.scores365.Design.PageObjects.b> LoadData() {
        ArrayList<com.scores365.Design.PageObjects.b> arrayList = new ArrayList<>();
        try {
            this.selectedSoundId = getArguments().getInt(SOUND_ID_TAG);
            this.sounds = l0.d();
            for (int i10 = 0; i10 < this.sounds.size(); i10++) {
                li.k0 elementAt = this.sounds.elementAt(i10);
                if (elementAt.f34612e) {
                    String str = elementAt.f34609b;
                    int i11 = elementAt.f34608a;
                    arrayList.add(new bf.i(str, i11, i11 == this.selectedSoundId));
                    if (elementAt.f34608a == this.selectedSoundId) {
                        this.selectedSoundPosition = i10;
                    }
                }
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

    public int getSelectedSoundId() {
        return this.selectedSoundId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void initRecyclerViewLayoutManager() {
        try {
            super.initRecyclerViewLayoutManager();
            RecyclerView.p pVar = this.rvLayoutMgr;
            if (pVar instanceof GridLayoutManager) {
                ((GridLayoutManager) pVar).B(1);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public boolean isDirty() {
        return this.isDirty;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            MediaPlayer mediaPlayer = this.mp;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.mp.stop();
        } catch (IllegalStateException e10) {
            x0.N1(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.scores365.Design.Pages.q
    public void onRecyclerViewItemClick(int i10) {
        int i11;
        super.onRecyclerViewItemClick(i10);
        try {
            bf.i iVar = (bf.i) this.rvBaseAdapter.A(i10);
            i.b bVar = iVar.f9086d;
            i.b bVar2 = i.b.general;
            if (bVar == bVar2) {
                if (this.selectedSoundId != iVar.m()) {
                    this.isDirty = true;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= this.rvBaseAdapter.getItemCount()) {
                            break;
                        }
                        bf.i iVar2 = (bf.i) this.rvBaseAdapter.A(i12);
                        if (iVar2.n()) {
                            iVar2.setSelected(false);
                            this.rvBaseAdapter.notifyItemChanged(i12);
                            break;
                        }
                        i12++;
                    }
                    this.selectedSoundId = iVar.m();
                    iVar.setSelected(true);
                    this.rvBaseAdapter.notifyItemChanged(i10);
                }
            } else if (bVar == i.b.playSound) {
                iVar.f9086d = bVar2;
                Iterator<li.k0> it = this.sounds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    }
                    li.k0 next = it.next();
                    if (next.f34608a == iVar.m()) {
                        i11 = next.f34610c;
                        break;
                    }
                }
                if (i11 != -1) {
                    MediaPlayer create = MediaPlayer.create(getActivity(), i11);
                    this.mp = create;
                    create.start();
                    this.mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.scores365.ui.SelectSoundFragment.1
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    });
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // com.scores365.Design.Pages.q
    public <T extends Collection> void renderData(T t10) {
        super.renderData(t10);
        this.rvItems.p1(this.selectedSoundPosition);
    }
}
