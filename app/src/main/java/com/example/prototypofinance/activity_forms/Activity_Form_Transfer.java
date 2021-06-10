package com.example.prototypofinance.activity_forms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.prototypofinance.R;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_Form_Transfer extends Activity {

    private Toolbar toolbar;
    private CalendarView form_transfer_calendarView;
    private Button form_transfer_button_Account_Sender, form_transfer_button_Account_Receiver, form_transfer_button_Description;
    private TextInputEditText form_transfer_textInput_Value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_form_transfer);

        toolbar = findViewById(R.id.form_transfer_toolbar);
        form_transfer_calendarView = findViewById(R.id.form_transfer_calendarView);
        form_transfer_textInput_Value = findViewById(R.id.form_transfer_textInput_Value);
        form_transfer_button_Account_Sender = findViewById(R.id.form_transfer_button_Account_Sender);
        form_transfer_button_Account_Receiver = findViewById(R.id.form_transfer_button_Account_Receiver);
        form_transfer_button_Description = findViewById(R.id.form_transfer_button_Account_Description);

        setOnClickListener();

    }

    private void setOnClickListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void registerAccount() {

        /*Transfer_POJO transfer = new Transfer_POJO();
        transfer.setDate("");
        transfer.setAccountGive(textInputEdit_RGT_AccountS.getText().toString());
        transfer.setAccountTake(textInputEdit_RGT_AccountS.getText().toString());
        transfer.setValue(textInputEdit_RGT_Value.getText().toString());
        transfer.setDescription(textInputEdit_RGT_Description.getText().toString());
*/
        //envia o objeto pojo para outra classe para ser registrado no abnco de dados
        //Serializable
    }

}
