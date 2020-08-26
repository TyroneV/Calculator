package com.tyrone.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public static TextView mainTextView;
    boolean finalResult = true;
    public static String myURL = "";
    String mainAddress = "http://10.0.2.2:8080/test/Calculator?input=";
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

        String translate = mainTextView.getText().toString();
        translate = translate.replaceAll("(?<!^)-","minus");
        translate = translate.replaceAll("[+]","plus");
        translate = translate.replaceAll("[x]","times");
        translate = translate.replaceAll("[/]","div");
        myURL = mainAddress + translate;
        try{
            new Reader().execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
