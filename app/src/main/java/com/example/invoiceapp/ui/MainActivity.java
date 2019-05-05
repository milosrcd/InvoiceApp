package com.example.invoiceapp.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.invoiceapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonShowCustomers).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonShowCustomers:
                ViewCustomersDialog.newInstance().show(getSupportFragmentManager(), "viewDialog");
                break;
            case R.id.buttonAdd:
                AddCustomerDialog.newInstance().show(getSupportFragmentManager(), "addDialog");
                break;
        }
    }
}
