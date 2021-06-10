package com.example.prototypofinance.activity_forms;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import com.example.prototypofinance.R;
import com.example.prototypofinance.database.DataBaseHelper;
import com.example.prototypofinance.pojos.Account_POJO;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class Activity_Form_Account extends Activity {

    private Toolbar toolbar;
    private CalendarView calendarView;
    private TextInputEditText form_account_textInput_Name, form_account_textInput_Category, form_account_textInput_Value;
    private Button form_account_button_Save;

    private Account_POJO account_pojo;
    private DataBaseHelper dataBaseHelper;
    private String datetime; //format: YYYY-MM-DD HH:MI:SS
    private String[] accountcategoryList = new String[]{
            "Carteira", "Conta salário", "Conta corrente", "Conta eletrônica", "Conta poupança"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponentsView();
        setOnClickListener();
        setInitialValueComponents();
    }

    private void setComponentsView() {
        setContentView(R.layout.fragment_form_account);
        toolbar = findViewById(R.id.form_account_toolbar);
        calendarView = findViewById(R.id.form_account_calendarView);
        form_account_textInput_Value = findViewById(R.id.form_account_textInput_Value);
        form_account_textInput_Name = findViewById(R.id.form_account_textInput_Name);
        form_account_textInput_Category = findViewById(R.id.form_account_textInput_Category);
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
                datetime = year + "-" + month + "-" + dayOfMonth;//the Time will be blanck
            }
        });
        form_account_textInput_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("Selecione uma categoria")
                        .setSingleChoiceItems(accountcategoryList, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                form_account_textInput_Category.setText(accountcategoryList[which]);
                                dialog.dismiss();
                            }
                        }).create()
                        .show();
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
        if (form_account_textInput_Name.getText() == null) {
            Toast.makeText(getApplicationContext(), "NOME NÃO PREENCHIDO", Toast.LENGTH_SHORT).show();
            if (form_account_textInput_Value.getText() == null) {
                Toast.makeText(getApplicationContext(), "SALDO NÃO PREENCHIDO", Toast.LENGTH_SHORT).show();
            } else if (form_account_textInput_Category.getText() == null) {
                Toast.makeText(getApplicationContext(), "CATEGORIA NÃO PREENCHIDA", Toast.LENGTH_SHORT).show();
            }
        }
        account_pojo.setDate(datetime);
        account_pojo.setName(form_account_textInput_Name.getText().toString());
        account_pojo.setCategory(form_account_textInput_Category.getText().toString());
        account_pojo.setValue(111);//Integer.parseInt(form_account_textInput_Value.getText().toString()));

        //Inserting the DATA in the database
        dataBaseHelper = new DataBaseHelper(getApplicationContext(), "Finance", null, 1);
        dataBaseHelper.insertAccount(account_pojo);

        Toast.makeText(getApplicationContext(), "CADASTRADO COM SUCESSO!", Toast.LENGTH_SHORT).show();

        //Closing the activity
        this.finish();
    }

    public void setInitialValueComponents(){
        calendarView.setDate(System.currentTimeMillis());
    }
}
