package com.vikaspandey.myapp.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.vikaspandey.myapp.db.DaoMaster;
import com.vikaspandey.myapp.db.DaoSession;

/**
 * Created by vikas pandey on 7/6/2016.
 */
public class MyApp extends Application {
    public DaoSession daoSession;
    public final String dbName = "myapp-db";

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, dbName, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}