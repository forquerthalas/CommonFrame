package com.lost.temple.commonframe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lost.temple.commonframe.R;

/**
 * Created by LostTemple on 2017/9/7.
 */

public class MineFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.mine_fragment_layout, container, false);
    }
}
