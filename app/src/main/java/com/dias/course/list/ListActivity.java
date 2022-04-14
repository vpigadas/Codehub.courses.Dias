package com.dias.course.list;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dias.course.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private MyListAdapter adapter;

    private boolean isActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        adapter = new MyListAdapter(new UIItemListener() {
            @Override
            public void onClick(View view, UiModel data) {
                Log.d("events", "ImageVIew clicked with title " + data.getName());
//                Toast.makeText(ListActivity.this, "ImageVIew clicked with title " + data.getName(), Toast.LENGTH_LONG).show();

                if (isActive == false) {
                    isActive = true;
                    Snackbar.make(view, "ImageVIew clicked with title " + data.getName(), Snackbar.LENGTH_LONG).addCallback(new Snackbar.Callback() {
                        @Override
                        public void onDismissed(Snackbar transientBottomBar, int event) {
                            super.onDismissed(transientBottomBar, event);
                            isActive = false;
                        }
                    }).show();
                }
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        MyAdapter adapter = new MyAdapter(getDataList());

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        adapter.submitList(getUiDataList());
    }

    private List<UiModel> getUiDataList() {
        List<UiModel> datalist = new ArrayList<>();

        datalist.add(new UiModel("Vassilis", ""));
        datalist.add(new UiModel("Markos", ""));
        datalist.add(new UiModel("Maria", ""));
        datalist.add(new UiModel("Kostas", ""));
        datalist.add(new UiModel("Orfeas", ""));
        datalist.add(new UiModel("Vassilis", ""));
        datalist.add(new UiModel("Markos", ""));
        datalist.add(new UiModel("Maria", ""));
        datalist.add(new UiModel("Kostas", ""));
        datalist.add(new UiModel("Orfeas", ""));
        datalist.add(new UiModel("Vassilis", ""));
        datalist.add(new UiModel("Markos", ""));
        datalist.add(new UiModel("Maria", ""));
        datalist.add(new UiModel("Kostas", ""));
        datalist.add(new UiModel("Orfeas", ""));
        datalist.add(new UiModel("Vassilis", ""));
        datalist.add(new UiModel("Markos", ""));
        datalist.add(new UiModel("Maria", ""));
        datalist.add(new UiModel("Kostas", ""));
        datalist.add(new UiModel("Orfeas", ""));


        return datalist;
    }

    private List<String> getDataList() {
        List<String> data = new ArrayList<>();

        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        data.add("Vassilis");
        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        data.add("Vassilis");
        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        data.add("Vassilis");
        data.add("Maria");
        data.add("Markos");
        data.add("Kostas");
        data.add("Orfeas");
        return data;
    }


}