package com.example.stuco.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText txtPercentage;
    EditText txtNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totalTextView = (TextView) findViewById(R.id.totalTextView);

        txtPercentage = (EditText) findViewById(R.id.txtPercentage);
        txtPercentage.requestFocus();
        txtNumber = (EditText) findViewById(R.id.txtNumber);

        Button btnCalc = (Button) findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalTextView.setTextSize(50);
                if(txtPercentage.getText().toString().isEmpty()){
                    totalTextView.setTextSize(30);
                    totalTextView.setText("Please input a percentage");
                    return;
                }
                float percentage = Float.parseFloat(txtPercentage.getText().toString());

                if(txtNumber.getText().toString().isEmpty()) {
                    totalTextView.setTextSize(30);
                    totalTextView.setText("Please input a number");
                    return;
                }
                float number = Float.parseFloat(txtNumber.getText().toString());

                float dec = percentage/100;
                float total = dec * number;
                totalTextView.setText(Float.toString(total));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
