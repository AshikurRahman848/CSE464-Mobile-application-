package com.akram.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showToast(View view){
        TextView textView = findViewById(R.id.textAkram);
        textView.setText("0");
        Toast toast= Toast.makeText(this,"Hello Toast!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showCount(View view){
        TextView textView = findViewById(R.id.textAkram);
        String st = "";
        st = textView.getText().toString();
        int sum = Integer.parseInt(st);
        int count = sum+1;
        textView.setText(Integer.toString(count));
    }
}