package com.curm.sports.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.curm.sports.R;
import com.curm.sports.listener.OnConfirmListener;

public class ConfirmDialog extends Dialog {

    TextView tv_detail;

    OnConfirmListener listener;

    String content;

    public ConfirmDialog(@NonNull Context context) {
        super(context);
    }

    public ConfirmDialog(@NonNull Context context, int themeResId , OnConfirmListener listener) {
        super(context, themeResId);
        this.listener = listener;
    }

    protected ConfirmDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_dialog);
        tv_detail = findViewById(R.id.tv_detail);
    }

    public void setContent(String content){
        this.content = content;
        tv_detail.setText(this.content);
    }

}
