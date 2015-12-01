package com.example.admin.kalkulator;

import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Łukasz on 2015-11-29.
 */
public class ButtonNumberClickListener implements View.OnClickListener {
    static TextView textView;
    static Calculator calc = new Calculator();
    String value;
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

    }

    public void displayAction(){
        String currentText = textView.getText().toString();
        if(currentText.length()==1 && currentText.codePointAt(0)==48) {
            textView.setText("");
        }
        textView.append(value);
        Log.d("listner", "klik klik");
    }
    public void after(){

    }

    @Override
    public void onClick(View v) {
        before();
        displayAction();
        after();
    }
}
