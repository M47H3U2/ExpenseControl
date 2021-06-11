package com.example.prototypofinance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.prototypofinance.fragments.fragments_expenses.Fragment_Expense;
import com.example.prototypofinance.fragments.fragments_accounts.Fragment_Account;
import com.example.prototypofinance.fragments.fragments_incomes.Fragment_Income;
import com.example.prototypofinance.fragments.fragments_transfers.Fragment_Transfer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private Intent intent;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponentsView();
        setOnClickListener();
        setFragementView(new Fragment_Account());
    }

    private void setComponentsView() {
        bottomNavigationView = findViewById(R.id.activity_main_BottomNavigationView);
    }

    private void setFragementView(Fragment fragement) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_FrameLayout, fragement);
        fragmentTransaction.commit();
    }

    private void setOnClickListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.main_menu_item_Expense:

                    Toast.makeText(getApplicationContext(), "EXPENSE!", Toast.LENGTH_SHORT).show();
                    item.setChecked(true);
                    setFragementView(new Fragment_Expense());
                    break;
                case R.id.main_menu_item_Income:

                    Toast.makeText(getApplicationContext(), "RENDA!", Toast.LENGTH_SHORT).show();
                    item.setChecked(true);
                    setFragementView(new Fragment_Income());
                    break;
                case R.id.main_menu_item_Transfer:

                    Toast.makeText(getApplicationContext(), "TRANSFERENCIA!", Toast.LENGTH_SHORT).show();
                    item.setChecked(true);
                    setFragementView(new Fragment_Transfer());
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "CONTA!", Toast.LENGTH_SHORT).show();
                    item.setChecked(true);
                    setFragementView(new Fragment_Account());
            }
            return false;
        });
    }

}