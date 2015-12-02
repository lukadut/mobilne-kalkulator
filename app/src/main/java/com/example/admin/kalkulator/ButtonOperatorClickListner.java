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
        cleanDisplayMode=false;
        String currentText = textView.getText().toString();
        String[] parts = currentText.split("[\\+\\-\\*\\/]");
        if(parts.length==2 && currentText.charAt(0)!='-' || parts.length==3 && currentText.charAt(0)=='-'){
            MainActivity.getCalculator().parseText(currentText);
            textView.setText(MainActivity.getCalculator().result());
        }
    }
    @Override
    public void displayAction(){
        String currentText = textView.getText().toString();
        if(currentText.length()==0 || MainActivity.getCalculator().getBlocked()) {
            return;
        }

        if(currentText.substring(currentText.length()-1).matches("[\\+\\-\\*\\/]")){
            currentText = currentText.substring(0,currentText.length()-1);
            textView.setText(currentText);
        }

        textView.append(value);
        ButtonPointClickListner.setAvailablePoint(true);
    }

    @Override
    public void after(){


    }
}
