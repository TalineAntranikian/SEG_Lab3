package com.example.lab3simplecalculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String input = "";
    private String operator = "";
    private double firstValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // Assign button click listeners
        findViewById(R.id.button1).setOnClickListener(view -> appendInput("1"));
        findViewById(R.id.button2).setOnClickListener(view -> appendInput("2"));
        findViewById(R.id.button3).setOnClickListener(view -> appendInput("3"));
        findViewById(R.id.button4).setOnClickListener(view -> performOperation("+"));
        findViewById(R.id.button5).setOnClickListener(view -> appendInput("4"));
        findViewById(R.id.button6).setOnClickListener(view -> appendInput("5"));
        findViewById(R.id.button7).setOnClickListener(view -> appendInput("6"));
        findViewById(R.id.button8).setOnClickListener(view -> performOperation("-"));
        findViewById(R.id.button9).setOnClickListener(view -> appendInput("7"));
        findViewById(R.id.button10).setOnClickListener(view -> appendInput("8"));
        findViewById(R.id.button11).setOnClickListener(view -> appendInput("9"));
        findViewById(R.id.button12).setOnClickListener(view -> performOperation("/"));
        findViewById(R.id.button13).setOnClickListener(view -> clearInput());
        findViewById(R.id.button14).setOnClickListener(view -> appendInput("0"));
        findViewById(R.id.button15).setOnClickListener(view -> appendInput("."));
        findViewById(R.id.button16).setOnClickListener(view -> performOperation("*"));
        findViewById(R.id.button17).setOnClickListener(view -> calculate());  // Added button17 for equals
    }

    private void appendInput(String value) {
        input += value;
        textView.setText(input);
    }

    private void performOperation(String op) {
        if (!input.isEmpty()) {
            firstValue = Double.parseDouble(input);
            operator = op;
            input = "";  // Clear input for the second value
        }
    }

    private void calculate() {
        if (!input.isEmpty() && !operator.isEmpty()) {
            double secondValue = Double.parseDouble(input);
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "/":
                    result = firstValue / secondValue;
                    break;
                case "*":
                    result = firstValue * secondValue;
                    break;
            }
            textView.setText(String.valueOf(result));
            input = String.valueOf(result);  // Save result as input for further calculations
            operator = "";
        }
    }

    private void clearInput() {
        input = "";
        firstValue = 0;
        operator = "";
        textView.setText("");
    }
}