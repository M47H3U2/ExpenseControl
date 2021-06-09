package com.example.prototypofinance.fragments.fragments_accounts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.prototypofinance.R;
import com.example.prototypofinance.activity_forms.Activity_Form_Account;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fragment_Account extends Fragment {

    private FloatingActionButton floatingActionButton;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_account, container, false);

        floatingActionButton = view.findViewById(R.id.fragment_account_floatingActionButton);
        setOnClickListener();

        return view;
    }

    public void setOnClickListener() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), Activity_Form_Account.class);
                startActivity(intent);
            }
        });
    }

    /*public void selectAccount() {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext(), "Finance", null, 1);
        ArrayList<Account_POJO> account_list_pojos;
        account_list_pojos = dataBaseHelper.selectAccount();
        if (account_list_pojos != null) {
            recyclerView.setAdapter(new RecycleView_Account_List(account_list_pojos));
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }*/

}
