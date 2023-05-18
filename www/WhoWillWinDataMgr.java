package com.scores365.www;

import com.scores365.api.p;
import com.scores365.entitys.GsonManager;
import li.x0;
/* loaded from: classes2.dex */
public class WhoWillWinDataMgr {

    /* loaded from: classes2.dex */
    public interface iOnPollResultReceiveListener {
        void OnPollResultReceive(WhoWillWinObj whoWillWinObj);
    }

    public static void sendVote(final String str, final int i10, final iOnPollResultReceiveListener ionpollresultreceivelistener) {
        try {
            new Thread(new Runnable() { // from class: com.scores365.www.WhoWillWinDataMgr.1
                long timer;

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.timer = System.currentTimeMillis();
                        p pVar = new p();
                        pVar.a(str, i10);
                        pVar.call();
                        WhoWillWinObj whoWillWinObj = (WhoWillWinObj) GsonManager.getGson().l(pVar.c().toString(), WhoWillWinObj.class);
                        iOnPollResultReceiveListener ionpollresultreceivelistener2 = ionpollresultreceivelistener;
                        if (ionpollresultreceivelistener2 != null) {
                            ionpollresultreceivelistener2.OnPollResultReceive(whoWillWinObj);
                        }
                    } catch (Exception e10) {
                        x0.N1(e10);
                    }
                }
            }).start();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }
}
