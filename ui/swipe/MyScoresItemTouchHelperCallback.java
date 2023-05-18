package com.scores365.ui.swipe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import androidx.vectordrawable.graphics.drawable.h;
import com.scores365.App;
import com.scores365.Design.Pages.c;
import com.scores365.R;
import com.scores365.dashboardEntities.dashboardScores.f;
import com.scores365.dashboardEntities.dashboardScores.g;
import java.lang.ref.WeakReference;
import li.o0;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class MyScoresItemTouchHelperCallback extends AbstractItemTouchHelperCallback {
    public static final float buttonWidth = p0.s(48);
    protected RecyclerView recyclerView;
    protected c recyclerViewAdapter;
    Rect iconBounds = new Rect();
    private RecyclerViewTouchListener touchListener = null;
    protected Paint paintLeft = new Paint(1);
    protected TextPaint mTextPaint = new TextPaint();

    /* renamed from: com.scores365.ui.swipe.MyScoresItemTouchHelperCallback$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState;

        static {
            int[] iArr = new int[ButtonsState.values().length];
            $SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState = iArr;
            try {
                iArr[ButtonsState.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState[ButtonsState.RIGHT_VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState[ButtonsState.DRAGGING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState[ButtonsState.LOOSE_INITIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState[ButtonsState.LOOSE_RIGHT_VISIBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum ButtonsState {
        INITIAL,
        RIGHT_VISIBLE,
        DRAGGING,
        LOOSE_INITIAL,
        LOOSE_RIGHT_VISIBLE;

        @Override // java.lang.Enum
        public String toString() {
            int i10 = AnonymousClass1.$SwitchMap$com$scores365$ui$swipe$MyScoresItemTouchHelperCallback$ButtonsState[ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "default" : "LOOSE_RIGHT_VISIBLE" : "LOOSE_INITIAL" : "DRAGGING" : "RIGHT_VISIBLE" : "INITIAL";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class RecyclerViewTouchListener implements View.OnTouchListener {
        private int CLICK_ACTION_THRESHOLD = p0.s(5);
        final int actionState;

        /* renamed from: c  reason: collision with root package name */
        final Canvas f24416c;
        WeakReference<MyScoresItemTouchHelperCallback> callbackRef;
        float dX;
        final float dY;
        final boolean isCurrentlyActive;
        final RecyclerView recyclerView;
        private float startX;
        private float startY;
        WeakReference<SwipeableListPage> swipeableListPageRef;
        RecyclerView.e0 viewHolder;

        public RecyclerViewTouchListener(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10, MyScoresItemTouchHelperCallback myScoresItemTouchHelperCallback, SwipeableListPage swipeableListPage) {
            this.f24416c = canvas;
            this.recyclerView = recyclerView;
            this.viewHolder = e0Var;
            this.dX = f10;
            this.dY = f11;
            this.actionState = i10;
            this.isCurrentlyActive = z10;
            this.callbackRef = new WeakReference<>(myScoresItemTouchHelperCallback);
            this.swipeableListPageRef = new WeakReference<>(swipeableListPage);
        }

        private boolean isAClick(float f10, float f11, float f12, float f13) {
            float abs = Math.abs(f10 - f11);
            float abs2 = Math.abs(f12 - f13);
            return ((float) Math.sqrt((double) ((abs * abs) + (abs2 * abs2)))) < ((float) this.CLICK_ACTION_THRESHOLD);
        }

        protected SwipeableListPage getListPage() {
            try {
                WeakReference<SwipeableListPage> weakReference = this.swipeableListPageRef;
                if (weakReference != null) {
                    return weakReference.get();
                }
                return null;
            } catch (Exception e10) {
                x0.N1(e10);
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0025 A[Catch: Exception -> 0x0247, TryCatch #0 {Exception -> 0x0247, blocks: (B:3:0x0003, B:5:0x0013, B:10:0x001d, B:12:0x0025, B:13:0x0031, B:15:0x0043, B:17:0x0049, B:19:0x004f, B:21:0x005a, B:29:0x009e, B:31:0x00a8, B:33:0x00b2, B:35:0x00b8, B:37:0x00cc, B:39:0x00d6, B:41:0x00e6, B:43:0x00ee, B:44:0x00f1, B:48:0x00fa, B:49:0x0101, B:51:0x0107, B:53:0x011b, B:55:0x0125, B:57:0x0135, B:59:0x013d, B:60:0x0141, B:62:0x0145, B:64:0x014b, B:65:0x014f, B:66:0x0152, B:22:0x0073, B:24:0x007d, B:67:0x0156, B:69:0x0162, B:71:0x0168, B:73:0x016d, B:75:0x0181, B:76:0x0188, B:78:0x018f, B:79:0x0196, B:81:0x01a6, B:87:0x01c1, B:89:0x01ce, B:92:0x01e2, B:95:0x01f3, B:100:0x020e, B:96:0x0202, B:83:0x01ae, B:85:0x01b9, B:101:0x0234, B:102:0x0239, B:105:0x0241), top: B:110:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: Exception -> 0x0247, TryCatch #0 {Exception -> 0x0247, blocks: (B:3:0x0003, B:5:0x0013, B:10:0x001d, B:12:0x0025, B:13:0x0031, B:15:0x0043, B:17:0x0049, B:19:0x004f, B:21:0x005a, B:29:0x009e, B:31:0x00a8, B:33:0x00b2, B:35:0x00b8, B:37:0x00cc, B:39:0x00d6, B:41:0x00e6, B:43:0x00ee, B:44:0x00f1, B:48:0x00fa, B:49:0x0101, B:51:0x0107, B:53:0x011b, B:55:0x0125, B:57:0x0135, B:59:0x013d, B:60:0x0141, B:62:0x0145, B:64:0x014b, B:65:0x014f, B:66:0x0152, B:22:0x0073, B:24:0x007d, B:67:0x0156, B:69:0x0162, B:71:0x0168, B:73:0x016d, B:75:0x0181, B:76:0x0188, B:78:0x018f, B:79:0x0196, B:81:0x01a6, B:87:0x01c1, B:89:0x01ce, B:92:0x01e2, B:95:0x01f3, B:100:0x020e, B:96:0x0202, B:83:0x01ae, B:85:0x01b9, B:101:0x0234, B:102:0x0239, B:105:0x0241), top: B:110:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[Catch: Exception -> 0x0247, TryCatch #0 {Exception -> 0x0247, blocks: (B:3:0x0003, B:5:0x0013, B:10:0x001d, B:12:0x0025, B:13:0x0031, B:15:0x0043, B:17:0x0049, B:19:0x004f, B:21:0x005a, B:29:0x009e, B:31:0x00a8, B:33:0x00b2, B:35:0x00b8, B:37:0x00cc, B:39:0x00d6, B:41:0x00e6, B:43:0x00ee, B:44:0x00f1, B:48:0x00fa, B:49:0x0101, B:51:0x0107, B:53:0x011b, B:55:0x0125, B:57:0x0135, B:59:0x013d, B:60:0x0141, B:62:0x0145, B:64:0x014b, B:65:0x014f, B:66:0x0152, B:22:0x0073, B:24:0x007d, B:67:0x0156, B:69:0x0162, B:71:0x0168, B:73:0x016d, B:75:0x0181, B:76:0x0188, B:78:0x018f, B:79:0x0196, B:81:0x01a6, B:87:0x01c1, B:89:0x01ce, B:92:0x01e2, B:95:0x01f3, B:100:0x020e, B:96:0x0202, B:83:0x01ae, B:85:0x01b9, B:101:0x0234, B:102:0x0239, B:105:0x0241), top: B:110:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[Catch: Exception -> 0x0247, TryCatch #0 {Exception -> 0x0247, blocks: (B:3:0x0003, B:5:0x0013, B:10:0x001d, B:12:0x0025, B:13:0x0031, B:15:0x0043, B:17:0x0049, B:19:0x004f, B:21:0x005a, B:29:0x009e, B:31:0x00a8, B:33:0x00b2, B:35:0x00b8, B:37:0x00cc, B:39:0x00d6, B:41:0x00e6, B:43:0x00ee, B:44:0x00f1, B:48:0x00fa, B:49:0x0101, B:51:0x0107, B:53:0x011b, B:55:0x0125, B:57:0x0135, B:59:0x013d, B:60:0x0141, B:62:0x0145, B:64:0x014b, B:65:0x014f, B:66:0x0152, B:22:0x0073, B:24:0x007d, B:67:0x0156, B:69:0x0162, B:71:0x0168, B:73:0x016d, B:75:0x0181, B:76:0x0188, B:78:0x018f, B:79:0x0196, B:81:0x01a6, B:87:0x01c1, B:89:0x01ce, B:92:0x01e2, B:95:0x01f3, B:100:0x020e, B:96:0x0202, B:83:0x01ae, B:85:0x01b9, B:101:0x0234, B:102:0x0239, B:105:0x0241), top: B:110:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0162 A[Catch: Exception -> 0x0247, TryCatch #0 {Exception -> 0x0247, blocks: (B:3:0x0003, B:5:0x0013, B:10:0x001d, B:12:0x0025, B:13:0x0031, B:15:0x0043, B:17:0x0049, B:19:0x004f, B:21:0x005a, B:29:0x009e, B:31:0x00a8, B:33:0x00b2, B:35:0x00b8, B:37:0x00cc, B:39:0x00d6, B:41:0x00e6, B:43:0x00ee, B:44:0x00f1, B:48:0x00fa, B:49:0x0101, B:51:0x0107, B:53:0x011b, B:55:0x0125, B:57:0x0135, B:59:0x013d, B:60:0x0141, B:62:0x0145, B:64:0x014b, B:65:0x014f, B:66:0x0152, B:22:0x0073, B:24:0x007d, B:67:0x0156, B:69:0x0162, B:71:0x0168, B:73:0x016d, B:75:0x0181, B:76:0x0188, B:78:0x018f, B:79:0x0196, B:81:0x01a6, B:87:0x01c1, B:89:0x01ce, B:92:0x01e2, B:95:0x01f3, B:100:0x020e, B:96:0x0202, B:83:0x01ae, B:85:0x01b9, B:101:0x0234, B:102:0x0239, B:105:0x0241), top: B:110:0x0003 }] */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r18, android.view.MotionEvent r19) {
            /*
                Method dump skipped, instructions count: 588
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.swipe.MyScoresItemTouchHelperCallback.RecyclerViewTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public MyScoresItemTouchHelperCallback(c cVar, RecyclerView recyclerView, SwipeableListPage swipeableListPage) {
        this.recyclerViewAdapter = cVar;
        this.recyclerView = recyclerView;
        this.listPageRef = new WeakReference<>(swipeableListPage);
    }

    public static void drawStretchedButtons(Canvas canvas, RecyclerView.e0 e0Var, float f10, boolean z10) {
        RecyclerView.e0 e0Var2;
        boolean z11;
        h b10;
        String l02;
        try {
            if (!(e0Var instanceof SwipeableViewHolder) || f10 <= 0.0f) {
                return;
            }
            SwipeableViewHolder swipeableViewHolder = (SwipeableViewHolder) e0Var;
            float swipeWidth = f10 / swipeableViewHolder.getSwipeWidth();
            float swipeWidth2 = f10 / swipeableViewHolder.getSwipeWidth();
            float min = Math.min(swipeWidth2 * swipeWidth2, 1.0f);
            View view = e0Var.itemView;
            int s10 = p0.s(12);
            int s11 = p0.s(19);
            int bottom = view.getBottom() - view.getTop();
            int top = z10 ? 0 : view.getTop();
            int bottom2 = z10 ? bottom : view.getBottom();
            float f11 = buttonWidth * swipeWidth;
            h b11 = h.b(App.m().getResources(), R.drawable.I4, App.m().getTheme());
            Rect rect = new Rect();
            Paint paint = new Paint();
            Rect removeButtonFrame = swipeableViewHolder.getRemoveButtonFrame();
            int i10 = top;
            removeButtonFrame.set(swipeableViewHolder.getLeftOfItemView(), top + swipeableViewHolder.getTopMarginItemView(), (int) (swipeableViewHolder.getLeftOfItemView() + f11), bottom2 - swipeableViewHolder.getBottomOfItemView());
            float f12 = f11 / 2.0f;
            rect.set((int) ((removeButtonFrame.left + f12) - (s10 / 2)), ((removeButtonFrame.top + (bottom / 2)) - (s11 / 2)) - p0.s(4), (int) ((removeButtonFrame.right - f12) + (s10 / 2)), ((removeButtonFrame.bottom - (bottom / 2)) + (s11 / 2)) - p0.s(4));
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(App.m().getResources().getColor(R.color.f21626p));
            paint.setAlpha(255);
            canvas.drawRect(removeButtonFrame, paint);
            canvas.save();
            canvas.clipRect(removeButtonFrame);
            b11.setBounds(rect);
            int i11 = (int) (min * 255.0f);
            b11.setAlpha(i11);
            b11.draw(canvas);
            b11.setAlpha(255);
            paint.setColor(-1);
            paint.setTextSize(p0.s(10));
            paint.setTypeface(o0.d(App.m()));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setAlpha(i11);
            canvas.drawText(p0.l0("SELECTIONS_MENU_EDITMENU_REMOVE"), (removeButtonFrame.left + removeButtonFrame.right) / 2, rect.bottom + p0.s(8) + p0.s(4), paint);
            canvas.restore();
            if (swipeableViewHolder instanceof g.a) {
                z11 = ((g.a) swipeableViewHolder).isOnlyRemoveButton;
                e0Var2 = e0Var;
            } else {
                e0Var2 = e0Var;
                z11 = false;
            }
            if (!(e0Var2 instanceof f.a) || z11) {
                return;
            }
            int s12 = p0.s(15);
            int s13 = p0.s(19);
            paint.setColor(p0.A(R.attr.f21565m1));
            paint.setAlpha(255);
            Rect notificationButtonFrame = swipeableViewHolder.getNotificationButtonFrame();
            notificationButtonFrame.set((int) (swipeableViewHolder.getLeftOfItemView() + f11), i10 + swipeableViewHolder.getTopMarginItemView(), (int) (swipeableViewHolder.getLeftOfItemView() + (f11 * 2.0f)), bottom2 - swipeableViewHolder.getBottomOfItemView());
            rect.set((int) ((notificationButtonFrame.left + f12) - (s12 / 2)), ((notificationButtonFrame.top + (bottom / 2)) - (s13 / 2)) - p0.s(4), (int) ((notificationButtonFrame.right - f12) + (s12 / 2)), ((notificationButtonFrame.bottom - (bottom / 2)) + (s13 / 2)) - p0.s(4));
            if (swipeableViewHolder.isSelected()) {
                b10 = h.b(App.m().getResources(), R.drawable.G4, App.m().getTheme());
                l02 = p0.l0("GAME_CENTER_MUTE");
            } else {
                b10 = h.b(App.m().getResources(), R.drawable.H4, App.m().getTheme());
                l02 = p0.l0("NEW_DASHBOARD_SCORES_ALERTS");
            }
            canvas.drawRect(notificationButtonFrame, paint);
            canvas.save();
            canvas.clipRect(notificationButtonFrame);
            b10.setBounds(rect);
            b10.setAlpha(i11);
            b10.draw(canvas);
            b10.setAlpha(255);
            paint.setColor(-1);
            paint.setTextSize(p0.s(10));
            paint.setTypeface(o0.d(App.m()));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setAlpha(i11);
            canvas.drawText(l02, (notificationButtonFrame.left + notificationButtonFrame.right) / 2, rect.bottom + p0.s(8) + p0.s(4), paint);
            canvas.restore();
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void setTouchListener(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
        RecyclerViewTouchListener recyclerViewTouchListener = this.touchListener;
        if (recyclerViewTouchListener != null) {
            recyclerViewTouchListener.dX = f10;
            recyclerViewTouchListener.viewHolder = e0Var;
            return;
        }
        RecyclerViewTouchListener recyclerViewTouchListener2 = new RecyclerViewTouchListener(canvas, recyclerView, e0Var, f10, f11, i10, z10, this, getListPage());
        this.touchListener = recyclerViewTouchListener2;
        recyclerView.setOnTouchListener(recyclerViewTouchListener2);
    }

    @Override // androidx.recyclerview.widget.i.e
    public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
        return super.getAnimationDuration(recyclerView, i10, f10, f11) / 2;
    }

    @Override // androidx.recyclerview.widget.i.e
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
        return i.e.makeMovementFlags(0, ((e0Var instanceof SwipeableViewHolder) && ((SwipeableViewHolder) e0Var).isSwipeable()) ? 12 : 0);
    }

    @Override // androidx.recyclerview.widget.i.e
    public float getSwipeEscapeVelocity(float f10) {
        return 9000000.0f;
    }

    @Override // androidx.recyclerview.widget.i.e
    public float getSwipeThreshold(RecyclerView.e0 e0Var) {
        return 1.0f;
    }

    @Override // androidx.recyclerview.widget.i.e
    public float getSwipeVelocityThreshold(float f10) {
        return 9000000.0f;
    }

    @Override // androidx.recyclerview.widget.i.e
    public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
        return super.interpolateOutOfBoundsScroll(recyclerView, i10, i11, i12, j10);
    }

    @Override // androidx.recyclerview.widget.i.e
    public boolean isItemViewSwipeEnabled() {
        return (getListPage() == null || getListPage().isItemSwipeTutorialCurrentlyShown()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.i.e
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.i.e
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
        float f12;
        float offsetX;
        float f13;
        float f14 = f10;
        try {
            if (i10 != 1) {
                super.onChildDraw(canvas, recyclerView, e0Var, f10, f11, i10, z10);
                return;
            }
            this.currentDx = f14;
            if (e0Var instanceof SwipeableViewHolder) {
                SwipeableViewHolder swipeableViewHolder = this.currentHolder;
                if (swipeableViewHolder != e0Var) {
                    if (swipeableViewHolder != null) {
                        swipeableViewHolder.restoreInitialState();
                    }
                    this.currentHolder = (SwipeableViewHolder) e0Var;
                }
            } else {
                this.currentHolder = null;
            }
            if (e0Var instanceof SwipeableViewHolder) {
                SwipeableViewHolder swipeableViewHolder2 = (SwipeableViewHolder) e0Var;
                if (swipeableViewHolder2.getButtonState() != ButtonsState.LOOSE_RIGHT_VISIBLE) {
                    if (swipeableViewHolder2.getButtonState() != ButtonsState.DRAGGING && swipeableViewHolder2.getButtonState() != ButtonsState.RIGHT_VISIBLE) {
                        ButtonsState buttonState = swipeableViewHolder2.getButtonState();
                        ButtonsState buttonsState = ButtonsState.INITIAL;
                        if (buttonState != buttonsState) {
                            if (swipeableViewHolder2.getButtonState() == ButtonsState.LOOSE_INITIAL) {
                                if (f14 == 0.0f) {
                                    swipeableViewHolder2.setOffsetX(0.0f);
                                    swipeableViewHolder2.setButtonState(buttonsState);
                                    this.swipeBack = false;
                                } else {
                                    offsetX = ((swipeableViewHolder2.getOffsetX() + swipeableViewHolder2.getLooseCoordinateX()) * f14) / swipeableViewHolder2.getLooseCoordinateX();
                                    f13 = offsetX;
                                }
                            }
                            f13 = f14;
                        }
                    }
                    offsetX = swipeableViewHolder2.getOffsetX() + f14;
                    f13 = offsetX;
                } else if (f14 == 0.0f) {
                    swipeableViewHolder2.setOffsetX(swipeableViewHolder2.getSwipeWidth());
                    f14 = swipeableViewHolder2.getSwipeWidth();
                    swipeableViewHolder2.setButtonState(ButtonsState.RIGHT_VISIBLE);
                    this.swipeBack = false;
                    f13 = f14;
                } else {
                    offsetX = (((swipeableViewHolder2.getOffsetX() + swipeableViewHolder2.getLooseCoordinateX()) * f14) / swipeableViewHolder2.getLooseCoordinateX()) + ((swipeableViewHolder2.getSwipeWidth() * (swipeableViewHolder2.getLooseCoordinateX() - f14)) / swipeableViewHolder2.getLooseCoordinateX());
                    f13 = offsetX;
                }
                try {
                    setTouchListener(canvas, recyclerView, e0Var, f13, f11, i10, z10);
                    View view = e0Var.itemView;
                    p0.s(22);
                    int bottom = ((view.getBottom() - view.getTop()) * 42) / 64;
                    float max = Math.max(f13, 0.0f);
                    view.setTranslationX(max);
                    if (e0Var instanceof f.a) {
                        if (max > 0.0f) {
                            ((f.a) e0Var).getLeftStripe().setVisibility(8);
                        } else {
                            ((f.a) e0Var).handleLeftStripeVisibility();
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    f12 = f13;
                    x0.N1(e);
                    super.onChildDraw(canvas, recyclerView, e0Var, f12, f11, i10, z10);
                }
            }
        } catch (Exception e11) {
            e = e11;
            f12 = f14;
        }
    }

    @Override // androidx.recyclerview.widget.i.e
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
        super.onChildDrawOver(canvas, recyclerView, e0Var, f10, f11, i10, z10);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        int i10;
        int i11;
        try {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                i10 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                i11 = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
            } else if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                i10 = ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                i11 = ((GridLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
            } else {
                i10 = -1;
                i11 = -1;
            }
            if (i10 != -1) {
                while (i10 <= i11 + 2) {
                    RecyclerView.e0 a02 = recyclerView.a0(i10);
                    if (a02 != null) {
                        drawStretchedButtons(canvas, a02, a02.itemView.getTranslationX(), false);
                    }
                    i10++;
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // androidx.recyclerview.widget.i.e
    public boolean onMove(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.i.e
    public void onSwiped(RecyclerView.e0 e0Var, int i10) {
    }
}
