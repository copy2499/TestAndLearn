package com.example.tanatam.testandlearn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt1;
    EditText edt2;
    TextView tvresult;
    Button btncal;
    RadioGroup RdGroup;
    AlertDialog.Builder AlertBuilder;
    AlertDialog Alert;
    ImageButton meow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display();
        btnsum();
        meow();

    }

    private void meow() {
        meow = (ImageButton)findViewById(R.id.meow);
        meow.setOnClickListener(this);
    }

    private void Display() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(MainActivity.this,"Width = "+width+"  ,Height = "+height,Toast.LENGTH_SHORT).show();
    }

    public void Alert() {
        AlertBuilder = new AlertDialog.Builder(this);
        AlertBuilder.setTitle("ERROR");
        AlertBuilder.setMessage("Can't divide by 0");
        AlertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        Alert = AlertBuilder.create();
        Alert.show();

    }

    private void btnsum() {
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        RdGroup = (RadioGroup) findViewById(R.id.RdGroup);
        tvresult = (TextView) findViewById(R.id.tvresult);
        btncal = (Button) findViewById(R.id.btncal);
        btncal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btncal) {
            vbtncal();
        }
        if(v == meow){
            Toast.makeText(MainActivity.this,"Meow",Toast.LENGTH_SHORT).show();
        }
    }

    private void vbtncal() {
        float a = 0;
        float b;
        float sum = 0;
        try {
            a = Integer.parseInt(edt1.getText().toString());
        } catch (NumberFormatException e) {

        }
        try {
            b = Integer.parseInt(edt2.getText().toString());
        } catch (NumberFormatException e) {

        }
        b = Integer.parseInt(edt2.getText().toString());
        switch (RdGroup.getCheckedRadioButtonId()) {
            case R.id.RbPlus:
                sum = a + b;
                break;
            case R.id.RbMinus:
                sum = a - b;
                break;
            case R.id.RbMultiply:
                sum = a * b;
                break;
            case R.id.RbDivide:
                if (b == 0) {
                    Alert();
                    break;
                } else {
                    sum = a / b;
                    break;
                }

        }

        tvresult.setText("=" + sum + "");
        Log.d("Calculation", "Result = " + sum);
        Toast.makeText(MainActivity.this, "Result =" + sum, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            Toast.makeText(MainActivity.this,"Hi ,I'm a settings option",Toast.LENGTH_SHORT).show();
           return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
