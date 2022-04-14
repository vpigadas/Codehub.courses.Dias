package com.dias.course;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AbstractActivity {

    @Nullable
    private EditText editText;

    @NonNull
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d("APP", String.valueOf(s));
        }
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login2;
    }

    @Override
    protected void startOperations() {

        Button button = findViewById(R.id.login_btn);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText = findViewById(R.id.edit_username);
                    if (editText != null) {
                        String input = String.valueOf(editText.getText());

                        Log.d("APP", "Button clicked!!!");

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        Bundle parameter = new Bundle();
                        parameter.putString("username", input);
                        parameter.putInt("pass", 12345);

                        intent.putExtras(parameter);
                        startActivityForResult(intent, 2000);
                    }


                }
            });
            button.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Log.d("APP", "Button long clicked!!!");
                    Snackbar.make(v, "Button long clicked!!!", Snackbar.LENGTH_LONG).show();
                    return true;
                }
            });
        }

        editText = findViewById(R.id.edit_username);
        editText.addTextChangedListener(textWatcher);
    }

    @Override
    protected void stopOperations() {
        if (editText != null) {
            editText.removeTextChangedListener(textWatcher);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            Bundle parameters = data.getExtras();
            String name = parameters.getString("name");
        }
    }
}