package com.vikaspandey.myapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.vikaspandey.myapp.R;
import com.vikaspandey.myapp.activity.ThredDetailActivity;
import com.vikaspandey.myapp.app.MyApp;
import com.vikaspandey.myapp.db.Post;
import com.vikaspandey.myapp.db.PostDao;
import com.vikaspandey.myapp.utils.MySingleton;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by vikas pandey on 7/7/2016.
 */
public class ThreadDetailAdapter extends RecyclerView.Adapter<ThreadDetailAdapter.ViewHolder>{
    List<Post> postList;
    Long topic_id;
    Context actContext;
    public ThreadDetailAdapter(Context context,Long topic_id) {
        actContext =context;
       this.topic_id=topic_id;
        postList =((MyApp) actContext.getApplicationContext()).getDaoSession().getPostDao().queryDeep("where T.\"" + PostDao.Properties.Topic_id.columnName + "\" = " + topic_id);
//        postList =((MyApp) actContext.getApplicationContext()).getDaoSession().getPostDao().loadDeep()


    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tv_user_name;
        public NetworkImageView iv_user_icon;
        public TextView tv_post_text;
        public TextView tv_liked;
        public TextView tv_karma;
        public TextView tv_time_elapsed;

        public ViewHolder(View v) {
            super(v);


            tv_user_name = (TextView)v.findViewById(R.id.tv_user_name);
            tv_post_text = (TextView)v.findViewById(R.id.tv_post_text);
            tv_liked = (TextView)v.findViewById(R.id.tv_liked);
            tv_karma = (TextView)v.findViewById(R.id.tv_karma);
            tv_time_elapsed = (TextView)v.findViewById(R.id.tv_time_elapsed);
            iv_user_icon=(NetworkImageView)v.findViewById(R.id.iv_user_icon);

        }
    }
    @Override
    public ThreadDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.thread_item_layout, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(postList.size()==0)
        {
            holder.tv_user_name.setText("No Thread Detail");
            return;
        }
        final Post post = postList.get(position);

        holder.tv_user_name.setText(post.getUser().getName());
        holder.tv_post_text.setText(Html.fromHtml(post.getText()));
        holder.tv_liked.setText(post.getLike_count()+" Dimer Liked");
        holder.tv_karma.setText(post.getUser().getKarma()+" Karma");
        holder.tv_time_elapsed.setText(getTime(post.getCreated_at()));
        holder.iv_user_icon.setImageUrl(post.getUser().getImage(), MySingleton.getInstance(actContext).getImageLoader());
        holder.iv_user_icon.setErrorImageResId(R.drawable.user_icon);


    }

    private String getTime(Long created_at) {
        Long miliSec = System.currentTimeMillis()-created_at;
        long d = TimeUnit.MILLISECONDS.toDays(miliSec);
        if(d>0)
            return d+"d";
        long h = TimeUnit.MILLISECONDS.toHours(miliSec);
        if(h>0) return h+"h";
        long m = TimeUnit.MILLISECONDS.toMinutes(miliSec);
        if(m>0)return m+"m";

        long s = TimeUnit.MILLISECONDS.toSeconds(miliSec);
        if(s>0)return s+"s";

        return "";
    }


    @Override
    public int getItemCount() {
if(postList.size()==0)
    return 1;
        return postList.size();
    }



}
