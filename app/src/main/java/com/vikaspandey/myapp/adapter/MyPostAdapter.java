package com.vikaspandey.myapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vikaspandey.myapp.R;

/**
 * Created by vikas pandey on 7/6/2016.
 */
public class MyPostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView tv_forum_title;
        private TextView tv_topic_title;
        private TextView tv_user_name;

        public ViewHolder(CardView v) {
            super(v);
          tv_forum_title = (TextView)v.findViewById(R.id.tv_forum_title);
            tv_topic_title = (TextView)v.findViewById(R.id.tv_topic_title);
            tv_user_name = (TextView)v.findViewById(R.id.tv_user_name);

        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView)LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public MyPostAdapter(Context context) {

    }

}
