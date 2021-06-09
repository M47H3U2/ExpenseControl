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

import me.abhinay.input.CurrencyEditText;

public class Activity_Form_Expense extends Activity {

    private Toolbar form_expense_toolbar;
    private CalendarView form_expense_calendarView;
    private Button form_expense_button_Account, form_expense_button_Category, form_expense_button_Description;
    private CurrencyEditText form_expense_textInput_Value;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponentsView();
        setOnClickListener();
    }

    private void setComponentsView() {
        setContentView(R.layout.fragment_form_expense);
        form_expense_toolbar = findViewById(R.id.form_expense_toolbar);
        form_expense_calendarView = findViewById(R.id.form_expense_calendarView);
        form_expense_textInput_Value = findViewById(R.id.form_expense_textInput_Value);
        form_expense_button_Account = findViewById(R.id.form_expense_button_Account);
        form_expense_button_Category = findViewById(R.id.form_expense_button_Category);
        form_expense_button_Description = findViewById(R.id.form_expense_button_Description);
    }

    private void setOnClickListener() {
        form_expense_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        form_expense_calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

            }
        });
        form_expense_button_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        form_expense_button_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), Activity_Form_Category.class);
                startActivity(intent);
            }
        });
        form_expense_button_Description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void registerAccount() {
        /*Expense_POJO expense = new Expense_POJO();
        expense.setDate("");
        expense.setAccountName(textInputEdit_RGE_Account.getText().toString());
        expense.setType(textInputEdit_RGE_Category.getText().toString());
        expense.setValue(textInputEdit_RGE_Description.getText().toString());
        expense.setDescription(textInputEdit_RGE_Description.getText().toString());*/

        //DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext(), "Finance", null, 1);
        //dataBaseHelper.insertExpense(expense);

        //Closing the activity
        //getActivity().finish();
    }

}
