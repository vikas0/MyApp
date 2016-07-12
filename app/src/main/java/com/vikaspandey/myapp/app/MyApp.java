package com.vikaspandey.myapp.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.vikaspandey.myapp.db.DaoMaster;
import com.vikaspandey.myapp.db.DaoSession;
import com.vikaspandey.myapp.db.ForumDao;
import com.vikaspandey.myapp.db.PostDao;
import com.vikaspandey.myapp.db.TopicDao;
import com.vikaspandey.myapp.db.UserDao;
import com.vikaspandey.myapp.response.Datum;
import com.vikaspandey.myapp.response.ResponsePost;
import com.vikaspandey.myapp.utils.GsonRequest;
import com.vikaspandey.myapp.utils.MySingleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    public void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }


}