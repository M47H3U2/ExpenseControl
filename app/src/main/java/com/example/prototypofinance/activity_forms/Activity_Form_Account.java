package com.example.prototypofinance.activity_forms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.prototypofinance.R;
import com.google.android.material.textfield.TextInputEditText;

import me.abhinay.input.CurrencyEditText;

public class Activity_Form_Account extends Activity {

    private Toolbar toolbar;
    private CalendarView calendarView;
    private TextInputEditText form_account_textInput_Name;
    private Button form_account_button_Category, form_account_button_Save;
    private CurrencyEditText form_account_textInput_Value;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponentsView();
        setOnClickListener();
    }

    private void setComponentsView() {
        setContentView(R.layout.fragment_form_account);
        toolbar = findViewById(R.id.form_account_toolbar);
        calendarView = findViewById(R.id.form_account_calendarView);
        form_account_textInput_Value = findViewById(R.id.form_account_textInput_Value);
        form_account_textInput_Name = findViewById(R.id.form_account_textInput_Name);
        form_account_button_Category = findViewById(R.id.form_account_button_Category);
        form_account_button_Save = findViewById(R.id.form_account_button_Save);
    }

    private void setOnClickListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

            }
        });
        form_account_textInput_Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        form_account_button_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), Activity_Form_Category.class);
                intent.putExtra("accountcategory","account");
                startActivity(intent);
            }
        });
        form_account_button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void registerAccount() {
       /* Account_POJO accountPOJO = new Account_POJO();

        accountPOJO.setDate("");
        accountPOJO.setName(textInputEdit_RGA_Name.getText().toString());
        accountPOJO.setCategory(textInputEdit_RGA_Category.getText().toString());
        accountPOJO.setValue(String.valueOf(textInputEdit_RGA_Value.getText().toString()));

        //Inserting the DATA in the database
        //DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext(), "Finance", null, 1);
        //dataBaseHelper.insertAccount(accountPOJO);

        //Closing the activity
        //getActivity().finish();*/
    }

}
