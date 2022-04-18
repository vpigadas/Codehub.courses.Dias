package com.dias.course.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dias.course.R;

import java.util.List;

public class StorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button button = findViewById(R.id.btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatabaseInsertTask(StorageActivity.this, new DatabaseInsertTask.Listener() {
                    @Override
                    public void onResult(UserEntity userEntity) {
                        new DatabaseGetTask(StorageActivity.this, new DatabaseGetTask.Listener() {
                            @Override
                            public void onResult(List<UserEntity> userEntities) {
                                TextView textView = findViewById(R.id.txt_label);
                                textView.setText(String.valueOf(userEntities.size()));
                            }
                        }).execute();
                    }
                }).execute();
            }
        });

        new DatabaseGetTask(StorageActivity.this, new DatabaseGetTask.Listener() {
            @Override
            public void onResult(List<UserEntity> userEntities) {
                TextView textView = findViewById(R.id.txt_label);
                textView.setText(String.valueOf(userEntities.size()));
            }
        }).execute();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences("keys", Context.MODE_PRIVATE);

        preferences.edit().putString("name", "Vassilis").apply();
    }
}