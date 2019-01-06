package com.igameguide.pubg.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.igameguide.pubg.R;
import com.igameguide.pubg.pic.WallPaperFragment;
import com.igameguide.pubg.video.VideoFragment;
import com.igameguide.pubg.weapon.WeaponFragment;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainContract.Presenter mPresenter;
    ViewPager viewPager;
    CommonTabLayout tabLayout;


    private String[] mTitles = new String[]{"战绩", "视频", "武器", "壁纸"};
    private List<Fragment> mFragments;
    private int[] mIconUnselectIds = {
            R.mipmap.icon_data_unsel, R.mipmap.icon_video_unsel,
             R.mipmap.icon_weapon_unsel, R.mipmap.icon_wallpaper_nusel, R.mipmap.icon_guides_unsel,};
    private int[] mIconSelectIds = {
            R.mipmap.icon_data_sel, R.mipmap.icon_video_sel,
             R.mipmap.icon_weapon_sel,  R.mipmap.icon_wallpaper_sel, R.mipmap.icon_guides_sel,};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainPresenter(this);


        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        String language = Locale.getDefault().getLanguage();
        String country = getResources().getConfiguration().locale.getCountry();
        Log.d("wyl", "language:" + language + " country:" + country);
        if (language.equals("en")) {
            if (country.equals("US")) {
                mTitles = new String[]{"战绩", "武器"};
                mIconUnselectIds = new int[] {R.mipmap.icon_data_unsel, R.mipmap.icon_weapon_unsel};
                mIconSelectIds = new int[] {R.mipmap.icon_data_sel, R.mipmap.icon_weapon_sel};
            }
        }

        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            String title = mTitles[i];
            Fragment f = getFragmentByName(title);
            if (f == null) {
                continue;
            }
            mFragments.add(f);
            mTabEntities.add(new TabEntity(title, mIconSelectIds[i], mIconUnselectIds[i]));
        }

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                tabLayout.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        MobclickAgent.setDebugMode(true);
    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;

    }


    @Override
    public void onLoadStart() {

    }

    @Override
    public void onLoadFail() {

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    private Fragment getFragmentByName(String name) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        if (TextUtils.equals(name, "战绩")) {
            return StandingsFragment.getInstance();
        } else if (TextUtils.equals(name, "视频")) {
            return VideoFragment.getInstance();
        }else if (TextUtils.equals(name, "武器")) {
            return WeaponFragment.getInstance();
        }else if (TextUtils.equals(name, "壁纸")) {
            return WallPaperFragment.getInstance();
        }
        return null;

    }
}
