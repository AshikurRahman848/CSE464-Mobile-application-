package com.bitto.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    double num1, num2, ans;
    char c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.tv1);
    }

    public void zeroBtnClick(View view) {
        String s = result.getText().toString();
        if(s.length() != 0){
            result.setText(s+"0");
        }
    }

    public void oneBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"1");
    }

    public void twoBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"2");
    }

    public void threeBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"3");
    }

    public void fourBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"4");
    }

    public void fiveBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"5");
    }

    public void sixBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"6");
    }

    public void sevenBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"7");
    }

    public void eightBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"8");
    }

    public void nineBtnClick(View view) {
        String s = result.getText().toString();
        result.setText(s+"9");
    }

    public void clearOnClick(View view) {
        result.setText("");
    }

    public void backOnClick(View view) {
        String s = result.getText().toString();
        if(s.length() != 0){
            s = s.substring(0,s.length()-1);
            result.setText(s);
        }
    }

    public void plusBtnClick(View view) {
        String s = result.getText().toString();
        num1 = Double.parseDouble(s);
        result.setText("");
        c = '+';
    }

    public void minusBtnClick(View view) {
        String s = result.getText().toString();
        num1 = Double.parseDouble(s);
        result.setText("");
        c = '-';
    }

    public void multiplyBtnClick(View view) {
        String s = result.getText().toString();
        num1 = Double.parseDouble(s);
        result.setText("");
        c = '*';
    }

    public void divisionBtnClick(View view) {
        String s = result.getText().toString();
        num1 = Double.parseDouble(s);
        result.setText("");
        c = '/';
    }

    public void equalBtnClick(View view) {
        if(c != '0'){
            String s = result.getText().toString();
            num2 = Double.parseDouble(s);
            if(c == '+'){
                ans = num1 + num2;
                s = String.valueOf(ans);
                result.setText(s);
                c = '0';
            }
            if(c == '-'){
                ans = num1 - num2;
                s = String.valueOf(ans);
                result.setText(s);
                c = '0';
            }
            if(c == '*'){
                ans = num1 * num2;
                s = String.valueOf(ans);
                result.setText(s);
                c = '0';
            }
            if(c == '/'){
                ans = num1 / num2;
                s = String.valueOf(ans);
                result.setText(s);
                c = '0';
            }
        }
    }
}