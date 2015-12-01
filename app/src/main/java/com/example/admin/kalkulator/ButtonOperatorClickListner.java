package com.example.admin.kalkulator;

import android.util.Log;

/**
 * Created by Łukasz on 2015-12-01.
 */
public class ButtonOperatorClickListner extends ButtonNumberClickListener {
    public ButtonOperatorClickListner(){
        super();
    }
    public ButtonOperatorClickListner(String value){
        super();
        this.value=value;
    }

    @Override
    public void before(){
        String currentText = textView.getText().toString();
        if(currentText.split("[\\+\\-\\*\\/]").length==2){
            MainActivity.calculator.parseText(currentText);
            textView.setText(MainActivity.calculator.result());
        }
    }
    @Override
    public void displayAction(){
        String currentText = textView.getText().toString();
        if(currentText.length()==0) {
            return;
        }

        if(currentText.substring(currentText.length()-1).matches("[\\+\\-\\*\\/]")){
            currentText = currentText.substring(0,currentText.length()-1);
            textView.setText(currentText);
        }

        textView.append(value);
        Log.d("listner", "klik klik");
    }

    @Override
    public void after(){

    }
}
