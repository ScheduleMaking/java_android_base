package com.example.practice4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdpater extends FragmentStateAdapter {
    public int mCount;
    public MyAdpater(@NonNull FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        // 슬라이딩할 fragment에 인덱스를 매긴다.
        if(index==0) return new FragFirst();
        else if(index==1) return new FragSecond();
        else if(index==2) return new FragThird();
        else return new FragFourth();
    }

    @Override
    public int getItemCount() { // 슬라이딩할 갯수
        return 4;
    }

    public int getRealPosition(int position){ return position % mCount; }
}
