package com.example.prototypofinance.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.prototypofinance.fragments.fragments_category.Fragment_FreeTime;
import com.example.prototypofinance.fragments.fragments_category.Fragment_Housing;
import com.example.prototypofinance.fragments.fragments_category.Fragment_Maintence;
import com.example.prototypofinance.fragments.fragments_category.Fragment_Others;
import com.example.prototypofinance.fragments.fragments_category.Fragment_Transport;

public class ViewPager_Adapter_Category extends FragmentStateAdapter {
    private final int COUNT = 5;
    public ViewPager_Adapter_Category(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new Fragment_Transport();
            case 2:
                return new Fragment_FreeTime();
            case 3:
                return new Fragment_Maintence();
            case 4:
                return new Fragment_Others();
            default:
                return new Fragment_Housing();
        }
    }

    @Override
    public int getItemCount() {
        return COUNT;
    }
}
