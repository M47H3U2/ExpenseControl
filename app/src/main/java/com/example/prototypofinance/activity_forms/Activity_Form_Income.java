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
import com.google.android.material.textfield.TextInputEditText;

public class Activity_Form_Income extends Activity {

    private Toolbar toolbar;
    private CalendarView form_income_calendarView;
    private Button form_income_button_Account,form_income_button_Category,form_income_button_Description;
    private TextInputEditText form_transfer_textInput_Value;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponentsView();
        setOnClickListener();
    }

    private void setComponentsView() {
        setContentView(R.layout.fragment_form_income);
        toolbar = findViewById(R.id.form_income_toolbar);
        form_income_calendarView = findViewById(R.id.form_income_calendarView);
        form_transfer_textInput_Value = findViewById(R.id.form_transfer_textInput_Value);
        form_income_button_Account = findViewById(R.id.form_income_button_Account);
        form_income_button_Category = findViewById(R.id.form_income_button_Category);
        form_income_button_Description = findViewById(R.id.form_income_button_Description);
    }

    private void setOnClickListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        form_income_calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

            }
        });
        form_income_button_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), Activity_Form_Category.class);
                intent.putExtra("incomecategory","income");
                startActivity(intent);
            }
        });
        form_income_button_Description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void registerAccount() {
        /*Income_POJO income = new Income_POJO();
        income.setDate("");
        income.setAccountName(textInputEdit_RGI_Account.getText().toString());
        income.setType(textInputEdit_RGI_Category.getText().toString());
        income.setValue(textInputEdit_RGI_Description.getText().toString());
        income.setDescription(textInputEdit_RGI_Description.getText().toString());*/
        //envia o objeto pojo para outra classe para ser registrado no abnco de dados
        //Serializable
    }
}
