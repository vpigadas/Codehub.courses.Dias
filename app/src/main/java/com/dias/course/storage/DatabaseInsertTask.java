package com.dias.course.storage;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.dias.course.storage.DatabaseInstance;
import com.dias.course.storage.UserEntity;

import java.util.UUID;

public class DatabaseInsertTask extends AsyncTask<Void, Void, UserEntity> {

    public interface Listener {
        void onResult(UserEntity userEntity);
    }

    private Context context;
    private Listener callback;

    public DatabaseInsertTask(Context context, Listener callback) {
        this.context = context;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected UserEntity doInBackground(Void... voids) {
        DatabaseInstance databaseInstance = Room.databaseBuilder(context, DatabaseInstance.class, "DiasApp").build();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setName(UUID.randomUUID().toString());
        databaseInstance.getUserDao().save(userEntity);
        return userEntity;
    }

    @Override
    protected void onPostExecute(UserEntity userEntity) {
        super.onPostExecute(userEntity);
        callback.onResult(userEntity);
    }
}
