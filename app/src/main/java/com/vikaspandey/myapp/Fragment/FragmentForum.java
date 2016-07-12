package com.vikaspandey.myapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vikaspandey.myapp.R;
import com.vikaspandey.myapp.adapter.MyPostAdapter;

/**
 * Created by vikas pandey on 7/6/2016.
 */
public class FragmentForum extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forum, container, false);



        return rootView;
    }
}
