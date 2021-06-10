package com.example.prototypofinance.activity_forms;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.widget.Toast;

import com.example.prototypofinance.R;
import com.example.prototypofinance.adapters.ViewPager_Adapter_Category;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Activity_Form_Category extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    private Intent intent;

    private int[] category_icon = new int[]{
            R.drawable.ic_baseline_house_24, R.drawable.ic_baseline_emoji_transportation_24,
            R.drawable.ic_baseline_free_breakfast_24, R.drawable.ic_baseline_build_24, R.drawable.ic_baseline_more_vert_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponentsView();
        setOnClickListener();
    }

    private void setComponentsView() {
        setContentView(R.layout.activity_category);
        toolbar = findViewById(R.id.activity_category_Toolbar);
        viewPager2 = findViewById(R.id.activity_category_ViewPager2);
        tabLayout = findViewById(R.id.activity_category_TabLayout);
    }

    private void setOnClickListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewPager2.setAdapter(new ViewPager_Adapter_Category(getSupportFragmentManager(), getLifecycle()));
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(category_icon[position]);
            }
        }).attach();

    }

}