package com.example.admin.kalkulator;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Łukasz on 2015-11-29.
 */
public class ButtonClickListener implements View.OnClickListener {
    static TextView textView;
    String value;
    public ButtonClickListener(){
        super();
    }
    public ButtonClickListener(String value){
        super();
        this.value=value;
    }

     public static void setTextView(TextView textView_){
        textView = textView_;
    }
    @Override
    public void onClick(View v) {
        textView.setText(value);
        Calculator calc = new Calculator();
        //calc.parseText("2+2");
        calc.parseText("2/0");
        //calc.parseText("2*2");
       // calc.parseText("2-2");
        textView.setText(calc.result());
    }
}
