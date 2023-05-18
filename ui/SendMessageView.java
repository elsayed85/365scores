package com.scores365.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.e1;
import androidx.recyclerview.widget.i;
import com.scores365.App;
import com.scores365.R;
import li.x0;
/* loaded from: classes2.dex */
public class SendMessageView extends RelativeLayout implements TextWatcher, View.OnClickListener {
    private View Container;
    TransitionDrawable arrowBackgroundCrossFadeDrawable;
    TransitionDrawable arrowCrossFadeDrawable;
    Animation buttonEnabledAnim;
    private boolean isNeedToPlayAnimation;
    public FrameLayout mBtnContainer;
    public ImageView mButton;
    public EditText mEditText;

    public SendMessageView(Context context) {
        super(context);
        this.isNeedToPlayAnimation = true;
        createView();
        initialize();
    }

    public SendMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isNeedToPlayAnimation = true;
        createView();
        initialize();
    }

    private void createView() {
        try {
            if (x0.l1()) {
                this.Container = View.inflate(getContext(), R.layout.f22673q8, null);
            } else {
                this.Container = View.inflate(getContext(), R.layout.f22661p8, null);
            }
            addView(this.Container);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    private void initialize() {
        try {
            setVisibility(8);
            EditText editText = (EditText) this.Container.findViewById(R.id.f22197o5);
            this.mEditText = editText;
            editText.addTextChangedListener(this);
            this.mBtnContainer = (FrameLayout) this.Container.findViewById(R.id.f22088j6);
            this.mButton = (ImageView) this.Container.findViewById(R.id.Zc);
            try {
                e1.C0(this.mBtnContainer, 0.0f);
            } catch (Exception e10) {
                x0.N1(e10);
            }
            this.buttonEnabledAnim = AnimationUtils.loadAnimation(App.m(), R.anim.f21501a);
            Drawable[] drawableArr = new Drawable[2];
            if (x0.l1()) {
                drawableArr[0] = androidx.core.content.a.getDrawable(App.m(), R.drawable.f21738j3);
                drawableArr[1] = androidx.core.content.a.getDrawable(App.m(), R.drawable.f21730i3);
            } else {
                drawableArr[0] = androidx.core.content.a.getDrawable(App.m(), R.drawable.f21714g3);
                drawableArr[1] = androidx.core.content.a.getDrawable(App.m(), R.drawable.f21722h3);
            }
            TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArr);
            this.arrowCrossFadeDrawable = transitionDrawable;
            transitionDrawable.startTransition(0);
            this.arrowCrossFadeDrawable.resetTransition();
            this.mButton.setImageDrawable(this.arrowCrossFadeDrawable);
            this.arrowBackgroundCrossFadeDrawable = new TransitionDrawable(new Drawable[]{androidx.core.content.a.getDrawable(App.m(), R.drawable.J), androidx.core.content.a.getDrawable(App.m(), R.drawable.K)});
            this.mBtnContainer.setOnClickListener(this);
            this.mBtnContainer.setBackground(this.arrowBackgroundCrossFadeDrawable);
            this.mBtnContainer.setEnabled(false);
            startAnimation(AnimationUtils.loadAnimation(App.m(), R.anim.f21518r));
            Animation loadAnimation = AnimationUtils.loadAnimation(App.m(), R.anim.f21505e);
            loadAnimation.setStartOffset(330L);
            this.mBtnContainer.startAnimation(loadAnimation);
            setVisibility(0);
        } catch (Exception e11) {
            x0.N1(e11);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        try {
            if (editable.length() == 0) {
                this.isNeedToPlayAnimation = true;
                startAnimation(false);
                e1.C0(this.mBtnContainer, 0.0f);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void finish() {
        try {
            ((InputMethodManager) App.m().getSystemService("input_method")).hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public EditText getEditTextView() {
        return this.mEditText;
    }

    public String getText() {
        return this.mEditText.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.f22088j6) {
            startAnimation(false);
            this.mEditText.setText("");
            this.mBtnContainer.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        try {
            if (this.isNeedToPlayAnimation && i12 > 0) {
                startAnimation(true);
                this.mBtnContainer.setEnabled(true);
                e1.C0(this.mBtnContainer, 3.0f);
                this.isNeedToPlayAnimation = false;
            }
            if (charSequence.length() == 0) {
                this.isNeedToPlayAnimation = true;
                e1.C0(this.mBtnContainer, 0.0f);
                startAnimation(false);
            }
        } catch (Exception e10) {
            x0.N1(e10);
        }
    }

    public void setHint(String str) {
        this.mEditText.setHint(str);
    }

    public void setText(String str) {
        this.mEditText.setText(str);
    }

    public void startAnimation(boolean z10) {
        if (z10) {
            this.mBtnContainer.startAnimation(this.buttonEnabledAnim);
            this.arrowCrossFadeDrawable.startTransition(0);
            this.arrowBackgroundCrossFadeDrawable.startTransition(0);
            this.arrowCrossFadeDrawable.startTransition(i.e.DEFAULT_SWIPE_ANIMATION_DURATION);
            this.arrowBackgroundCrossFadeDrawable.startTransition(i.e.DEFAULT_SWIPE_ANIMATION_DURATION);
            return;
        }
        this.mBtnContainer.startAnimation(this.buttonEnabledAnim);
        this.arrowCrossFadeDrawable.startTransition(0);
        this.arrowBackgroundCrossFadeDrawable.startTransition(0);
        this.arrowCrossFadeDrawable.reverseTransition(i.e.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.arrowBackgroundCrossFadeDrawable.reverseTransition(i.e.DEFAULT_SWIPE_ANIMATION_DURATION);
    }
}
