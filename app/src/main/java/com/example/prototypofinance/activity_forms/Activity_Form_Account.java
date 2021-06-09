package com.example.prototypofinance.activity_forms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.prototypofinance.R;
import com.example.prototypofinance.database.DataBaseHelper;
import com.example.prototypofinance.pojos.Account_POJO;
import com.google.android.material.textfield.TextInputEditText;

import me.abhinay.input.CurrencyEditText;

public class Activity_Form_Account extends Activity {

    private Toolbar toolbar;
    private CalendarView calendarView;
    private TextInputEditText form_account_textInput_Name;
    private Button form_account_button_Category, form_account_button_Save;
    private CurrencyEditText form_account_textInput_Value;

    private Intent intent;
    private Account_POJO account_pojo;
    private DataBaseHelper dataBaseHelper;

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
        form_account_button_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), Activity_Form_Category.class);
                intent.putExtra("accountcategory", "account");
                startActivity(intent);
            }
        });
        form_account_button_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFormAccount();
            }
        });
    }

    private void saveFormAccount() {
        account_pojo = new Account_POJO();
        if (form_account_textInput_Name.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "NOME NÃO PREENCHIDO", Toast.LENGTH_SHORT).show();
            if (form_account_textInput_Value.getText().toString() == null) {
                Toast.makeText(getApplicationContext(), "SALDO NÃO PREENCHIDO", Toast.LENGTH_SHORT).show();
            } else if (form_account_button_Category.getText() == "Categoria") {
                Toast.makeText(getApplicationContext(), "CATEGORIA NÃO PREENCHIDA", Toast.LENGTH_SHORT).show();
            }
        }
        account_pojo.setDate("");
        account_pojo.setName(form_account_textInput_Name.getText().toString());
        account_pojo.setCategory(form_account_button_Category.getText().toString());
        account_pojo.setValue(String.valueOf(form_account_textInput_Value.getText().toString()));

        //Inserting the DATA in the database
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext(), "Finance", null, 1);
        dataBaseHelper.insertAccount(account_pojo);

        //Closing the activity
        this.finish();
    }

}
