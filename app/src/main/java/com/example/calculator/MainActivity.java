package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.media3.common.C;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView = findViewById(R.id.result);
    double operand1, operand2;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // הוספת מאזין לכפתורים
        ButtonClickListener buttonClickListener = new ButtonClickListener();
        setButtonListener(R.id.zero, buttonClickListener);
        setButtonListener(R.id.one, buttonClickListener);
        setButtonListener(R.id.two, buttonClickListener);
        setButtonListener(R.id.three, buttonClickListener);
        setButtonListener(R.id.four, buttonClickListener);
        setButtonListener(R.id.five, buttonClickListener);
        setButtonListener(R.id.six, buttonClickListener);
        setButtonListener(R.id.seven, buttonClickListener);
        setButtonListener(R.id.eight, buttonClickListener);
        setButtonListener(R.id.nine, buttonClickListener);
        setButtonListener(R.id.point, buttonClickListener);

        setButtonListener(R.id.plus, buttonClickListener);
        setButtonListener(R.id.minus, buttonClickListener);
        setButtonListener(R.id.multiply, buttonClickListener);
        setButtonListener(R.id.division, buttonClickListener);
        setButtonListener(R.id.equal, buttonClickListener);

            findViewById(R.id.C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operand1 = 0;
                operand2 = 0;
                operator = ' ';
                resultTextView.setText("");
            }
        });

        findViewById(R.id.ChangeSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temp = Double.parseDouble(resultTextView.getText().toString());
                temp = -temp;
                resultTextView.setText(String.valueOf(temp));
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                if (!currentText.isEmpty()) {
                    currentText = currentText.substring(0, currentText.length() - 1);
                    resultTextView.setText(currentText);
                }
            }
        });
    }

    private void setButtonListener(int buttonId, View.OnClickListener listener) {
        Button button = findViewById(buttonId);
        if (button != null) {
            button.setOnClickListener(listener);
        }
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.zero:
                    resultTextView.append("0");
                    break;
                case R.id.one:
                    resultTextView.append("1");
                    break;
                case R.id.two:
                    resultTextView.append("2");
                    break;
                case R.id.three:
                    resultTextView.append("3");
                    break;
                case R.id.four:
                    resultTextView.append("4");
                    break;
                case R.id.five:
                    resultTextView.append("5");
                    break;
                case R.id.six:
                    resultTextView.append("6");
                    break;
                case R.id.seven:
                    resultTextView.append("7");
                    break;
                case R.id.eight:
                    resultTextView.append("8");
                    break;
                case R.id.nine:
                    resultTextView.append("9");
                    break;
                case R.id.point:
                    resultTextView.append(".");
                    break;

                case R.id.plus:
                    operand1 = Double.parseDouble(resultTextView.getText().toString());
                    operator = '+';
                    resultTextView.setText("");
                    break;
                case R.id.minus:
                    operand1 = Double.parseDouble(resultTextView.getText().toString());
                    operator = '-';
                    resultTextView.setText("");
                    break;
                case R.id.multiply:
                    operand1 = Double.parseDouble(resultTextView.getText().toString());
                    operator = '*';
                    resultTextView.setText("");
                    break;
                case R.id.division:
                    operand1 = Double.parseDouble(resultTextView.getText().toString());
                    operator = '/';
                    resultTextView.setText("");
                    break;
                case R.id.equal:
                    operand2 = Double.parseDouble(resultTextView.getText().toString());
                    double result = calculateResult(operand1, operand2, operator);
                    resultTextView.setText(String.valueOf(result));
                    break;
            }
        }
    }

    private double calculateResult(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return Double.NaN; // Division by zero
                }
            default:
                return Double.NaN;
        }
    }
}