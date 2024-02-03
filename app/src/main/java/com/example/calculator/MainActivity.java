package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0= findViewById(R.id.zero);
        Button btn1= findViewById(R.id.one);
        Button btn2= findViewById(R.id.two);
        Button btn3= findViewById(R.id.three);
        Button btn4= findViewById(R.id.four);
        Button btn5= findViewById(R.id.five);
        Button btn6= findViewById(R.id.six);
        Button btn7= findViewById(R.id.seven);
        Button btn8= findViewById(R.id.eight);
        Button btn9= findViewById(R.id.nine);
        Button plus= findViewById(R.id.plus);
        Button minus= findViewById(R.id.minus);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button n = findViewById(R.id.C);
        Button change= findViewById(R.id.ChangeSign);
        Button del= findViewById(R.id.delete);
        Button div= findViewById(R.id.division);
        Button mult= findViewById(R.id.multiply);
        Button eq= findViewById(R.id.equal);
        Button point= findViewById(R.id.point);
        EditText ans= findViewById(R.id.Answer);

        btn5.setOnClickListener((View.OnClickListener) this);
        {
            ans.setText("5");
        }
    }
    }