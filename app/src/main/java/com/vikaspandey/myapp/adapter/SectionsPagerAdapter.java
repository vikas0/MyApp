package com.vikaspandey.myapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vikaspandey.myapp.Fragment.FragmentForum;
import com.vikaspandey.myapp.Fragment.FramentPosts;

/**
 * Created by vikas pandey on 7/5/2016.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        return (position ==1)? new FramentPosts():new FragmentForum();

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "FORUMS";
            case 1:
                return "RECENT POSTS";

        }
        return null;
    }
}