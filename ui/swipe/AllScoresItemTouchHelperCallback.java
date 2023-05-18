package com.scores365.ui.swipe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import androidx.vectordrawable.graphics.drawable.h;
import com.scores365.App;
import com.scores365.Design.Pages.c;
import com.scores365.R;
import com.scores365.ui.swipe.MyScoresItemTouchHelperCallback;
import java.lang.ref.WeakReference;
import li.p0;
import li.x0;
/* loaded from: classes2.dex */
public class AllScoresItemTouchHelperCallback extends AbstractItemTouchHelperCallback {
    public static final int BUTTON_WIDTH;
    public static final int FOLLOW_ACTION_THRESHOLD_WIDTH;
    public static final int SWIPE_WIDTH = App.p() / 3;
    protected RecyclerView recyclerView;
    protected c recyclerViewAdapter;
    protected boolean isViewOverVibrateThreshold = false;
    private RecyclerViewTouchListener touchListener = null;
    protected Paint paintLeft = new Paint(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class RecyclerViewTouchListener implements View.OnTouchListener {
        private int CLICK_ACTION_THRESHOLD = p0.s(5);
        final int actionState;

        /* renamed from: c  reason: collision with root package name */
        final Canvas f24415c;
        WeakReference<AllScoresItemTouchHelperCallback> callbackRef;
        float dX;
        final float dY;
        private int ev;
        final boolean isCurrentlyActive;
        final RecyclerView recyclerView;
        private float startX;
        private float startY;
        WeakReference<SwipeableListPage> swipeableListPageRef;
        RecyclerView.e0 viewHolder;

        public RecyclerViewTouchListener(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10, AllScoresItemTouchHelperCallback allScoresItemTouchHelperCallback, SwipeableListPage swipeableListPage) {
            this.f24415c = canvas;
            this.recyclerView = recyclerView;
            this.viewHolder = e0Var;
            this.dX = f10;
            this.dY = f11;
            this.actionState = i10;
            this.isCurrentlyActive = z10;
            this.callbackRef = new WeakReference<>(allScoresItemTouchHelperCallback);
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

        /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[Catch: Exception -> 0x0262, TryCatch #0 {Exception -> 0x0262, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:12:0x0023, B:13:0x002f, B:15:0x0042, B:17:0x0048, B:19:0x004e, B:21:0x0058, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:35:0x00b6, B:37:0x00ca, B:39:0x00d4, B:41:0x00e4, B:43:0x00ec, B:44:0x00ef, B:48:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0119, B:55:0x0123, B:57:0x0133, B:59:0x013b, B:60:0x013f, B:62:0x0143, B:64:0x0149, B:65:0x014d, B:66:0x0150, B:22:0x0071, B:24:0x007b, B:67:0x0154, B:69:0x0160, B:71:0x0166, B:73:0x016b, B:75:0x017e, B:78:0x018a, B:79:0x0191, B:81:0x0196, B:83:0x019d, B:91:0x01c3, B:93:0x01c9, B:94:0x01d0, B:85:0x01a5, B:87:0x01b2, B:89:0x01bb, B:95:0x01d7, B:97:0x01e0, B:99:0x01e6, B:101:0x01f0, B:109:0x0234, B:111:0x023e, B:113:0x0244, B:114:0x0247, B:115:0x024c, B:102:0x0209, B:104:0x0213, B:116:0x024f, B:117:0x0254, B:120:0x025c), top: B:125:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: Exception -> 0x0262, TryCatch #0 {Exception -> 0x0262, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:12:0x0023, B:13:0x002f, B:15:0x0042, B:17:0x0048, B:19:0x004e, B:21:0x0058, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:35:0x00b6, B:37:0x00ca, B:39:0x00d4, B:41:0x00e4, B:43:0x00ec, B:44:0x00ef, B:48:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0119, B:55:0x0123, B:57:0x0133, B:59:0x013b, B:60:0x013f, B:62:0x0143, B:64:0x0149, B:65:0x014d, B:66:0x0150, B:22:0x0071, B:24:0x007b, B:67:0x0154, B:69:0x0160, B:71:0x0166, B:73:0x016b, B:75:0x017e, B:78:0x018a, B:79:0x0191, B:81:0x0196, B:83:0x019d, B:91:0x01c3, B:93:0x01c9, B:94:0x01d0, B:85:0x01a5, B:87:0x01b2, B:89:0x01bb, B:95:0x01d7, B:97:0x01e0, B:99:0x01e6, B:101:0x01f0, B:109:0x0234, B:111:0x023e, B:113:0x0244, B:114:0x0247, B:115:0x024c, B:102:0x0209, B:104:0x0213, B:116:0x024f, B:117:0x0254, B:120:0x025c), top: B:125:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0071 A[Catch: Exception -> 0x0262, TryCatch #0 {Exception -> 0x0262, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:12:0x0023, B:13:0x002f, B:15:0x0042, B:17:0x0048, B:19:0x004e, B:21:0x0058, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:35:0x00b6, B:37:0x00ca, B:39:0x00d4, B:41:0x00e4, B:43:0x00ec, B:44:0x00ef, B:48:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0119, B:55:0x0123, B:57:0x0133, B:59:0x013b, B:60:0x013f, B:62:0x0143, B:64:0x0149, B:65:0x014d, B:66:0x0150, B:22:0x0071, B:24:0x007b, B:67:0x0154, B:69:0x0160, B:71:0x0166, B:73:0x016b, B:75:0x017e, B:78:0x018a, B:79:0x0191, B:81:0x0196, B:83:0x019d, B:91:0x01c3, B:93:0x01c9, B:94:0x01d0, B:85:0x01a5, B:87:0x01b2, B:89:0x01bb, B:95:0x01d7, B:97:0x01e0, B:99:0x01e6, B:101:0x01f0, B:109:0x0234, B:111:0x023e, B:113:0x0244, B:114:0x0247, B:115:0x024c, B:102:0x0209, B:104:0x0213, B:116:0x024f, B:117:0x0254, B:120:0x025c), top: B:125:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009c A[Catch: Exception -> 0x0262, TryCatch #0 {Exception -> 0x0262, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:12:0x0023, B:13:0x002f, B:15:0x0042, B:17:0x0048, B:19:0x004e, B:21:0x0058, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:35:0x00b6, B:37:0x00ca, B:39:0x00d4, B:41:0x00e4, B:43:0x00ec, B:44:0x00ef, B:48:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0119, B:55:0x0123, B:57:0x0133, B:59:0x013b, B:60:0x013f, B:62:0x0143, B:64:0x0149, B:65:0x014d, B:66:0x0150, B:22:0x0071, B:24:0x007b, B:67:0x0154, B:69:0x0160, B:71:0x0166, B:73:0x016b, B:75:0x017e, B:78:0x018a, B:79:0x0191, B:81:0x0196, B:83:0x019d, B:91:0x01c3, B:93:0x01c9, B:94:0x01d0, B:85:0x01a5, B:87:0x01b2, B:89:0x01bb, B:95:0x01d7, B:97:0x01e0, B:99:0x01e6, B:101:0x01f0, B:109:0x0234, B:111:0x023e, B:113:0x0244, B:114:0x0247, B:115:0x024c, B:102:0x0209, B:104:0x0213, B:116:0x024f, B:117:0x0254, B:120:0x025c), top: B:125:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0160 A[Catch: Exception -> 0x0262, TryCatch #0 {Exception -> 0x0262, blocks: (B:3:0x0001, B:5:0x0011, B:10:0x001b, B:12:0x0023, B:13:0x002f, B:15:0x0042, B:17:0x0048, B:19:0x004e, B:21:0x0058, B:29:0x009c, B:31:0x00a6, B:33:0x00b0, B:35:0x00b6, B:37:0x00ca, B:39:0x00d4, B:41:0x00e4, B:43:0x00ec, B:44:0x00ef, B:48:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0119, B:55:0x0123, B:57:0x0133, B:59:0x013b, B:60:0x013f, B:62:0x0143, B:64:0x0149, B:65:0x014d, B:66:0x0150, B:22:0x0071, B:24:0x007b, B:67:0x0154, B:69:0x0160, B:71:0x0166, B:73:0x016b, B:75:0x017e, B:78:0x018a, B:79:0x0191, B:81:0x0196, B:83:0x019d, B:91:0x01c3, B:93:0x01c9, B:94:0x01d0, B:85:0x01a5, B:87:0x01b2, B:89:0x01bb, B:95:0x01d7, B:97:0x01e0, B:99:0x01e6, B:101:0x01f0, B:109:0x0234, B:111:0x023e, B:113:0x0244, B:114:0x0247, B:115:0x024c, B:102:0x0209, B:104:0x0213, B:116:0x024f, B:117:0x0254, B:120:0x025c), top: B:125:0x0001 }] */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
            /*
                Method dump skipped, instructions count: 615
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scores365.ui.swipe.AllScoresItemTouchHelperCallback.RecyclerViewTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    static {
        int s10 = p0.s(60);
        BUTTON_WIDTH = s10;
        FOLLOW_ACTION_THRESHOLD_WIDTH = s10 * 2;
    }

    public AllScoresItemTouchHelperCallback(c cVar, RecyclerView recyclerView, SwipeableListPage swipeableListPage) {
        this.recyclerViewAdapter = cVar;
        this.recyclerView = recyclerView;
        this.listPageRef = new WeakReference<>(swipeableListPage);
    }

    public static void drawLeftIconWithFrame(Canvas canvas, float f10, int i10, int i11, int i12, int i13, int i14, boolean z10, Paint paint, SwipeableViewHolder swipeableViewHolder) {
        Rect rect;
        int i15;
        BitmapDrawable bitmapDrawable;
        try {
            int s10 = p0.s(22);
            if (f10 != 0.0f) {
                if (swipeableViewHolder != null) {
                    rect = swipeableViewHolder.getNotificationButtonFrame();
                    i15 = swipeableViewHolder.getLeftOfItemView();
                } else {
                    rect = new Rect();
                    i15 = 0;
                }
                if (z10) {
                    h b10 = h.b(App.m().getResources(), R.drawable.f21678c, App.m().getTheme());
                    rect.set(i15 + p0.s(1), p0.s(1) + i12, ((int) f10) + i14, i13 - p0.s(1));
                    float f11 = i10;
                    Rect rect2 = new Rect((int) ((Math.min(f11, f10) - (i10 / 2)) - (s10 / 2)), ((i11 / 2) + i12) - (s10 / 2), (((int) Math.min(f11, f10)) - (i10 / 2)) + (s10 / 2), (i11 / 2) + i12 + (s10 / 2));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(p0.s(1));
                    paint.setColor(p0.A(R.attr.T0));
                    canvas.drawRect(rect, paint);
                    b10.setBounds(rect2);
                    Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    b10.setBounds(0, 0, rect2.width(), rect2.height());
                    b10.draw(canvas2);
                    int max = (int) Math.max(0.0f, Math.min(rect2.width(), rect2.width() - (f10 - ((i10 - s10) / 2))));
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(App.m().getResources(), Bitmap.createBitmap(createBitmap, max, 0, rect2.width() - max, rect2.height(), (Matrix) null, false));
                    if (((i11 / 2) + i12) - (s10 / 2) >= 0) {
                        float f12 = i10 - i14;
                        bitmapDrawable2.setBounds(i14 + Math.max(0, (int) ((Math.min(f12, f10) - (i10 / 2)) - (s10 / 2))), ((i11 / 2) + i12) - (s10 / 2), ((i14 + ((int) Math.min(f12, f10))) - (i10 / 2)) + (s10 / 2), (i11 / 2) + i12 + (s10 / 2));
                        canvas.clipRect(rect);
                        bitmapDrawable2.draw(canvas);
                        return;
                    }
                    return;
                }
                h b11 = h.b(App.m().getResources(), R.drawable.f21686d, App.m().getTheme());
                rect.set(i15 + p0.s(1), i12, ((int) f10) + i14, i13);
                float f13 = i10;
                Rect rect3 = new Rect((int) ((Math.min(f13, f10) - (i10 / 2)) - (s10 / 2)), i12, (((int) Math.min(f13, f10)) - (i10 / 2)) + (s10 / 2), i13);
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(p0.A(R.attr.T0));
                canvas.drawRect(rect, paint);
                Bitmap createBitmap2 = Bitmap.createBitmap(rect3.width(), rect3.height(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(createBitmap2);
                b11.setBounds(0, 0, rect3.width(), rect3.height());
                b11.draw(canvas3);
                int max2 = (int) Math.max(0.0f, Math.min(rect3.width(), rect3.width() - (f10 - ((i10 - s10) / 2))));
                int width = rect3.width() - max2;
                if (width > 0) {
                    bitmapDrawable = new BitmapDrawable(App.m().getResources(), Bitmap.createBitmap(createBitmap2, max2, 0, width, rect3.height(), (Matrix) null, false));
                } else {
                    bitmapDrawable = null;
                }
                if (bitmapDrawable == null || i13 < 0) {
                    return;
                }
                float f14 = i10 - i14;
                bitmapDrawable.setBounds(i14 + Math.max(0, (int) ((Math.min(f14, f10) - (i10 / 2)) - (s10 / 2))), ((i11 / 2) + i12) - (s10 / 2), ((i14 + ((int) Math.min(f14, f10))) - (i10 / 2)) + (s10 / 2), (i11 / 2) + i12 + (s10 / 2));
                canvas.clipRect(rect);
                bitmapDrawable.draw(canvas);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private static void rotateStar(Canvas canvas, Drawable drawable, float f10, Rect rect) {
        canvas.save();
        canvas.rotate(((f10 * 90.0f) / (App.p() / 3)) - 90.0f, rect.centerX(), rect.centerY());
        drawable.draw(canvas);
        canvas.restore();
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

    private static void vibrate() {
        Vibrator vibrator;
        VibrationEffect createOneShot;
        try {
            if (vibrationSettingsAreOn() && (vibrator = (Vibrator) App.m().getSystemService("vibrator")) != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    createOneShot = VibrationEffect.createOneShot(100L, -1);
                    vibrator.vibrate(createOneShot);
                } else {
                    vibrator.vibrate(100L);
                }
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private static boolean vibrationSettingsAreOn() {
        AudioManager audioManager = (AudioManager) App.m().getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        if (ringerMode != 0) {
            if (ringerMode == 1) {
                return true;
            }
            return audioManager.getStreamVolume(2) != 0 && 1 == Settings.System.getInt(App.m().getContentResolver(), "vibrate_when_ringing", 0);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.i.e
    public int convertToAbsoluteDirection(int i10, int i11) {
        if (this.swipeBack) {
            this.swipeBack = false;
            return 0;
        }
        return super.convertToAbsoluteDirection(i10, i11);
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
        return super.getSwipeEscapeVelocity(f10);
    }

    @Override // androidx.recyclerview.widget.i.e
    public float getSwipeThreshold(RecyclerView.e0 e0Var) {
        return 0.8f;
    }

    @Override // androidx.recyclerview.widget.i.e
    public float getSwipeVelocityThreshold(float f10) {
        return super.getSwipeVelocityThreshold(f10);
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
        float f12 = f10;
        if (i10 != 1) {
            super.onChildDraw(canvas, recyclerView, e0Var, f10, f11, i10, z10);
            return;
        }
        this.currentDx = f12;
        boolean z11 = e0Var instanceof SwipeableViewHolder;
        if (z11) {
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
        if (z11) {
            SwipeableViewHolder swipeableViewHolder2 = (SwipeableViewHolder) e0Var;
            View view = e0Var.itemView;
            int bottom = view.getBottom() - view.getTop();
            int i11 = BUTTON_WIDTH;
            if (swipeableViewHolder2.getButtonState() != MyScoresItemTouchHelperCallback.ButtonsState.LOOSE_RIGHT_VISIBLE) {
                if (swipeableViewHolder2.getButtonState() != MyScoresItemTouchHelperCallback.ButtonsState.DRAGGING && swipeableViewHolder2.getButtonState() != MyScoresItemTouchHelperCallback.ButtonsState.RIGHT_VISIBLE) {
                    MyScoresItemTouchHelperCallback.ButtonsState buttonState = swipeableViewHolder2.getButtonState();
                    MyScoresItemTouchHelperCallback.ButtonsState buttonsState = MyScoresItemTouchHelperCallback.ButtonsState.INITIAL;
                    if (buttonState != buttonsState) {
                        if (swipeableViewHolder2.getButtonState() == MyScoresItemTouchHelperCallback.ButtonsState.LOOSE_INITIAL) {
                            if (f12 == 0.0f) {
                                swipeableViewHolder2.setOffsetX(0.0f);
                                swipeableViewHolder2.setButtonState(buttonsState);
                                this.swipeBack = false;
                            } else {
                                f12 = ((swipeableViewHolder2.getOffsetX() + swipeableViewHolder2.getLooseCoordinateX()) * f12) / swipeableViewHolder2.getLooseCoordinateX();
                            }
                        }
                    }
                }
                f12 += swipeableViewHolder2.getOffsetX();
            } else if (f12 == 0.0f) {
                swipeableViewHolder2.setOffsetX(i11);
                f12 = i11;
                swipeableViewHolder2.setButtonState(MyScoresItemTouchHelperCallback.ButtonsState.RIGHT_VISIBLE);
                this.swipeBack = false;
            } else {
                f12 = (((swipeableViewHolder2.getOffsetX() + swipeableViewHolder2.getLooseCoordinateX()) * f12) / swipeableViewHolder2.getLooseCoordinateX()) + ((i11 * (swipeableViewHolder2.getLooseCoordinateX() - f12)) / swipeableViewHolder2.getLooseCoordinateX());
            }
            float f13 = f12;
            float min = Math.min(Math.max(f13, 0.0f), App.p() / 2);
            if (!this.isViewOverVibrateThreshold && min > FOLLOW_ACTION_THRESHOLD_WIDTH) {
                vibrate();
            }
            this.isViewOverVibrateThreshold = min > ((float) FOLLOW_ACTION_THRESHOLD_WIDTH);
            view.setTranslationX(min);
            p0.s(22);
            int p10 = App.p() / 3;
            if (f13 == 0.0f) {
                swipeableViewHolder2.setInvertLeftColors(false);
            }
            drawLeftIconWithFrame(canvas, min, i11, bottom, view.getTop(), view.getBottom(), ((SwipeableViewHolder) e0Var).getLeftOfItemView(), swipeableViewHolder2.isSelected() ^ swipeableViewHolder2.isInvertLeftColors(), this.paintLeft, swipeableViewHolder2);
            setTouchListener(canvas, recyclerView, e0Var, f13, f11, i10, z10);
        }
    }

    @Override // androidx.recyclerview.widget.i.e
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f10, float f11, int i10, boolean z10) {
        super.onChildDrawOver(canvas, recyclerView, e0Var, f10, f11, i10, z10);
    }

    @Override // androidx.recyclerview.widget.i.e
    public boolean onMove(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.i.e
    public void onSwiped(RecyclerView.e0 e0Var, int i10) {
    }
}
