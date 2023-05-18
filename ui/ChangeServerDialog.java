package com.scores365.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import com.scores365.R;
import com.scores365.ui.ChangeServerDataActivity;
/* loaded from: classes2.dex */
public class ChangeServerDialog extends androidx.appcompat.app.t {
    boolean isOK;
    int positionInSpinner;
    EditText serverStringET;
    ChangeServerDataActivity.eSpinnerType spinnerType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scores365.ui.ChangeServerDialog$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType;

        static {
            int[] iArr = new int[ChangeServerDataActivity.eSpinnerType.values().length];
            $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType = iArr;
            try {
                iArr[ChangeServerDataActivity.eSpinnerType.MAIN_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[ChangeServerDataActivity.eSpinnerType.USER_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[ChangeServerDataActivity.eSpinnerType.COUNTRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[ChangeServerDataActivity.eSpinnerType.PURCHASE_SERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[ChangeServerDataActivity.eSpinnerType.MONETIZATION_SERVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateServer(String str, ChangeServerDataActivity.eSpinnerType espinnertype) {
        if (str == null || str.isEmpty()) {
            this.isOK = false;
            onDestroy();
            return;
        }
        int i10 = AnonymousClass3.$SwitchMap$com$scores365$ui$ChangeServerDataActivity$eSpinnerType[espinnertype.ordinal()];
        if (i10 == 1) {
            sf.b.X1().C7(str);
        } else if (i10 == 2) {
            sf.b.X1().C9(str);
        } else if (i10 == 3) {
            sf.b.X1().Z7(Integer.valueOf(str).intValue());
        } else if (i10 == 4) {
            sf.b.X1().b8(str);
        } else if (i10 != 5) {
        } else {
            sf.b.X1().I7(str);
        }
    }

    public int getPositionInSpinner() {
        return this.positionInSpinner;
    }

    public ChangeServerDataActivity.eSpinnerType getSpinnerType() {
        return this.spinnerType;
    }

    @Override // androidx.appcompat.app.t, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.I0, (ViewGroup) null);
        this.serverStringET = (EditText) inflate.findViewById(R.id.f22437z2);
        builder.setView(inflate).setTitle("Manual text insertion").setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.scores365.ui.ChangeServerDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                ChangeServerDialog changeServerDialog = ChangeServerDialog.this;
                changeServerDialog.isOK = false;
                changeServerDialog.onDestroy();
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.scores365.ui.ChangeServerDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                ChangeServerDialog changeServerDialog = ChangeServerDialog.this;
                changeServerDialog.isOK = true;
                changeServerDialog.updateServer(changeServerDialog.serverStringET.getText().toString(), ChangeServerDialog.this.getSpinnerType());
            }
        });
        return builder.create();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.isOK) {
            return;
        }
        ((ChangeServerDataActivity) getActivity()).defaultSelections(getSpinnerType(), getPositionInSpinner());
        Toast.makeText(getContext(), "Restored to selection before Manual..", 0).show();
    }

    public void setPositionInSpinner(int i10) {
        this.positionInSpinner = i10;
    }

    public void setSpinnerType(ChangeServerDataActivity.eSpinnerType espinnertype) {
        this.spinnerType = espinnertype;
    }
}
