package com.tyrone.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView mainTextView;
    boolean finalResult = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.resultText);
    }
    void setOperator(char c){
        char[] myChars = mainTextView.getText().toString().toCharArray();
        if(myChars[myChars.length - 1] != c){
            finalResult = false;
            mainTextView.setText(String.format("%s%s", mainTextView.getText(), c));
        }
    }
    void insertNumber(char c){
        if(mainTextView.getText().toString().equals("0")|| finalResult){
            mainTextView.setText(Character.toString(c));
            finalResult = false;
        }else {
            mainTextView.setText(String.format("%s%s", mainTextView.getText(), c));
        }
    }
    double compute(double n1 , double n2, String operator){
        double result = 0d;
        switch (operator){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "x":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            default:
                return result;
        }
        return result;

    }
    public void addButton(View view){
        setOperator('+');
    }
    public void subButton(View view){
        if(mainTextView.getText().toString().length() == 0){
            mainTextView.setText(String.format("%s-", mainTextView.getText()));
        }else {
            setOperator('-');
        }
    }
    public void multButton(View view){
        setOperator('x');
    }
    public void divButton(View view){
        setOperator('/');
    }
    public void number0(View view){
        insertNumber('0');
    }
    public void number1(View view){
        insertNumber('1');
    }
    public void number2(View view){
        insertNumber('2');
    }
    public void number3(View view){
        insertNumber('3');
    }
    public void number4(View view){
        insertNumber('4');
    }
    public void number5(View view){
        insertNumber('5');
    }
    public void number6(View view){
        insertNumber('6');
    }
    public void number7(View view){
        insertNumber('7');
    }
    public void number8(View view){
        insertNumber('8');
    }
    public void number9(View view){
        insertNumber('9');
    }

    public void decimalButton(View view){
        setOperator('.');
    }
    public void clearButton(View view){
        mainTextView.setText("0");
    }
    public void resultButton(View view){
        String[] strNumbers = mainTextView.getText().toString().split("(?<!^)[x+/-]");
        String[] ops = mainTextView.getText().toString().split("\\d+|[.]|^-");
        List<String> strOperators = new ArrayList<>();

        boolean initialize = false;
        try {
            for (String s: ops){
                if(s.equals("x")||s.equals("/")||s.equals("-")||s.equals("+")){
                    strOperators.add(s);
                }
            }
            double holder = 0d;
            for (String strNumber : strNumbers) {
                if (!initialize) {
                    holder = Double.parseDouble(strNumber);
                    initialize = true;
                } else if (strOperators.size() > 0) {
                    holder = compute(holder, Double.parseDouble(strNumber), strOperators.get(0));
                    strOperators.remove(0);
                }
            }
            mainTextView.setText(Double.toString(holder));
        } catch (Exception e){
            mainTextView.setText("Syntax Error");
        }

        finalResult = true;
    }

}
