package com.example.andrew.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String Num1 = "", Num2 = "", opp;
    boolean operand = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Cal(View v){
        float result = 0;
        int resultI = 0;
        TextView resultView = (TextView) findViewById(R.id.Text);
        float num1 = Float.parseFloat(Num1.toString());
        float num2 = Float.parseFloat(Num2.toString());

        System.out.println("1");

        switch(opp){
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "/":
                result = num1/num2;
                break;

            case "*":
                result = num1 * num2;
                break;
        }
        System.out.println("2");
        if(result % 1 == 0){
            resultI = Math.round(result);
            resultView.setText(resultI + "");
        }
        else{
            resultView.setText(result + "");
        }

        reset();
    }

    public void NumberBuild (View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        TextView resultView = (TextView) findViewById(R.id.Text);

            System.out.println(operand);

            if (operand == false) {
                Num1 = Num1 + buttonText;
                resultView.setText(Num1 + "");

            } else {

                Num2 = Num2 + buttonText;
                resultView.setText(Num1 + " " + opp + " " + Num2);
            }
        }

    public void setOpp (View v){
        Button b = (Button) v;
        opp = b.getText().toString();
        TextView resultView = (TextView) findViewById(R.id.Text);
        resultView.setText(Num1 + " " + opp);
        operand = true;
    }

    public void reset(){
        operand = false;
        Num1 = "";
        Num2 = "";
    }

    public void conversion(View view){
        Intent intent = new Intent(this, ConversionActivity.class);
        startActivity(intent);
    }
}
