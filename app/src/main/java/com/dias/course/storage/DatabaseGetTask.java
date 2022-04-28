package com.dias.course.storage;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGetTask extends AsyncTask<Void, Void, List<UserEntity>> {

    public interface Listener {
        void onResult(List<UserEntity> userEntities);
    }

    private Context context;
    private Listener callback;

    public DatabaseGetTask(Context context, Listener callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<UserEntity> doInBackground(Void... voids) {
        DatabaseInstance databaseInstance = Room.databaseBuilder(context, DatabaseInstance.class, "DiasApp").build();

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<UserEntity> userEntity) {
        super.onPostExecute(userEntity);
        callback.onResult(userEntity);
    }
}
