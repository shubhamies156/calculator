package com.calculator.calculator_byshubham;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    EditText editTextGen;
    boolean isNewOp= true;
    String op="+";
    String oldNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextGen=findViewById(R.id.editTextGen);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            editTextGen.setText("");
        isNewOp=false;
        String number=editTextGen.getText().toString();
        switch (view.getId()){
            case R.id.bu7:
                number +="7";
                break;
            case R.id.bu8:
                number +="8";
                break;
            case R.id.bu9:
                number +="9";
                break;
            case R.id.bu4:
                number +="4";
                break;
            case R.id.bu5:
                number +="5";
                break;
            case R.id.bu6:
                number +="6";
                break;
            case R.id.bu1:
                number +="1";
                break;
            case R.id.bu2:
                number +="2";
                break;
            case R.id.bu3:
                number +="3";
                break;
            case R.id.buO:
                number +="0";
                break;
            case R.id.buDot:
                number +=".";
                break;
            case R.id.buPlusMinus:
                number ="-"+number;
                break;
        }
        editTextGen.setText(number);

    }

    public void operatorEvent(View view) {
        isNewOp=true;
        oldNumber=editTextGen.getText().toString();
        switch (view.getId()) {
            case R.id.buDivide:
                op = "/";
                break;
            case R.id.buMultiply:
                op = "*";
                break;
            case R.id.buPlus:
                op = "+";
                break;
            case R.id.buMinus:
                op = "-";
                break;
        }
        editTextGen.setText(op);


    }

    public void equalEvent(View view) {
        String newNumber=editTextGen.getText().toString();
        double result=0.0;
        switch (op)
        {
            case "+":
                result=Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
            case "-":
                result=Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "*":
                result=Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case "/":
                result=Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                break;
        }
        editTextGen.setText(result+"");
    }

    public void acEvent(View view) {
        editTextGen.setText("0");
        isNewOp=true;
    }

    public void percentEvent(View view) {
        double no=Double.parseDouble(editTextGen.getText().toString())/100;
        editTextGen.setText(no+"");
        isNewOp=true;
    }

}