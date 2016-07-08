package com.vikaspandey.myapp.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.vikaspandey.myapp.R;
import com.vikaspandey.myapp.adapter.SectionsPagerAdapter;
import com.vikaspandey.myapp.app.MyApp;
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
import java.util.Objects;

public class RecentPostsActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateData();
        initToolbarPager();


    }
    private void initToolbarPager()
{
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle("Forums");
    setSupportActionBar(toolbar);
    // Create the adapter that will return a fragment for each of the three
    // primary sections of the activity.
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    // Set up the ViewPager with the sections adapter.
    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);
}
  private void updateData()
  {  final ProgressDialog progressDialog = new ProgressDialog(this);
      progressDialog.setTitle("Loading");
      progressDialog.show();
      String getPostUrl = "http://139.162.46.29/v2/posts.json";
      Map<String,String> headers = new HashMap<>();
      headers.put("X-Desidime-Client", "0c50c23d1ac0ec18eedee20ea0cdce91ea68a20e9503b2ad77f44dab982034b0");


      DaoSession daoSession = ((MyApp)getApplicationContext()).getDaoSession();

      final UserDao userDao = daoSession.getUserDao();
      final TopicDao topicDao = daoSession.getTopicDao();
      final PostDao postDao =daoSession.getPostDao();
      final ForumDao forumDao=daoSession.getForumDao();

      GsonRequest gsonRequest = new GsonRequest<ResponsePost>(getPostUrl, ResponsePost.class, headers, new Response.Listener<ResponsePost>() {
          @Override
          public void onResponse(ResponsePost response) {
              List<Datum> datumList = response.getData();

              for(int i=0;i<datumList.size();i++)
              {
                  Datum datum = datumList.get(i);
                  userDao.insertOrReplace(datum.getUser());
                  forumDao.insertOrReplace(datum.getForum());
                  topicDao.insertOrReplace(datum.getTopic());
                  postDao.insertOrReplace(datum.getPost());
                  setSharedPrefrence();
                  progressDialog.cancel();
              }

          }
      },new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Log.d("error", error.toString());
              progressDialog.cancel();
              if(ispostUpdated()==false)
              {  if(( (MyApp)getApplicationContext()).isNetworkConnected()==false)
                  Toast.makeText(getApplicationContext(),"No Internet",Toast.LENGTH_LONG).show();
              else
                  Toast.makeText(getApplicationContext(),"Please try Later!",Toast.LENGTH_LONG).show();


                  finish();
              }
          }
      });
      MySingleton.getInstance(this).getRequestQueue().add(gsonRequest);


  }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_posts, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private boolean ispostUpdated()
    {
        SharedPreferences preferences = getSharedPreferences("myPref",MODE_PRIVATE);
        return preferences.getBoolean("key1",false);
    }
    private void setSharedPrefrence()
    {
        SharedPreferences preferences = getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("key1",true);
        editor.commit();
    }
}
