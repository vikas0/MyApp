package com.vikaspandey.myapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.vikaspandey.myapp.R;
import com.vikaspandey.myapp.app.MyApp;
import com.vikaspandey.myapp.db.Post;
import com.vikaspandey.myapp.utils.MySingleton;

import java.util.List;

/**
 * Created by vikas pandey on 7/6/2016.
 */
public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder>{
List<Post> postList;
    Context appContext;
    public MyPostAdapter(Context context) {
        appContext=context.getApplicationContext();
        postList =((MyApp)appContext).getDaoSession().getPostDao().loadAll();

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_forum_title;
        public TextView tv_topic_title;
        public TextView tv_user_name;
        public NetworkImageView iv_user_icon;

        public ViewHolder(View v) {
            super(v);
          tv_forum_title = (TextView)v.findViewById(R.id.tv_forum_title);
            tv_topic_title = (TextView)v.findViewById(R.id.tv_topic_title);
            tv_user_name = (TextView)v.findViewById(R.id.tv_user_name);
            iv_user_icon=(NetworkImageView)v.findViewById(R.id.iv_user_icon);

        }
    }
    @Override
    public MyPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Post post = postList.get(position);
        holder.tv_forum_title.setText(post.getForum().getTitle());
        holder.tv_topic_title.setText(post.getTopic().getTitle());
        holder.tv_user_name.setText(post.getUser().getName());
        holder.iv_user_icon.setImageUrl(post.getUser().getImage(), MySingleton.getInstance(appContext).getImageLoader());
        holder.iv_user_icon.setErrorImageResId(R.drawable.user_icon);


    }


    @Override
    public int getItemCount() {

        return postList.size();
    }



}
