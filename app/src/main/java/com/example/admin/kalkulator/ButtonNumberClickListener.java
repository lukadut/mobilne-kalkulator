package com.example.admin.kalkulator;

import android.os.Debug;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Łukasz on 2015-11-29.
 */
public class ButtonNumberClickListener implements View.OnClickListener {
    static TextView textView;
    static Calculator calc = MainActivity.getCalculator();
    String value;
    static Boolean cleanDisplayMode=false;
    public ButtonNumberClickListener(){
        super();
    }
    public ButtonNumberClickListener(String value){
        super();
        this.value=value;
    }

     public static void setTextView(TextView textView_){
        textView = textView_;
    }

    public void before(){
        String currentText = textView.getText().toString();
        if(currentText.equals("0") || cleanDisplayMode) {
            textView.setText("");
        }
    }

    public void displayAction(){
        textView.append(value);
        cleanDisplayMode=false;
    }
    public void after(){
    }

    @Override
    public void onClick(View v) {
        if(MainActivity.getCalculator().getBlocked()){
            return;
        }
        before();
        displayAction();
        after();
    }
}
