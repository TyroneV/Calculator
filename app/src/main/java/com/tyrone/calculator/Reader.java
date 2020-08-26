package com.tyrone.calculator;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static com.tyrone.calculator.MainActivity.myURL;
import static com.tyrone.calculator.MainActivity.mainTextView;

public class Reader extends AsyncTask<Void, Void, Void> {
    String result;
    @Override
    protected Void doInBackground(Void... voids) {
        URL url;
        try {
            url = new URL(myURL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String stringBuffer;
            String string = "";
            while ((stringBuffer = bufferedReader.readLine()) != null){
                string = String.format("%s%s", string, stringBuffer);
            }
            bufferedReader.close();
            result = string;
        } catch (IOException e){
            e.printStackTrace();
            result = e.toString();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        mainTextView.setText(result);
        super.onPostExecute(aVoid);
    }
}
