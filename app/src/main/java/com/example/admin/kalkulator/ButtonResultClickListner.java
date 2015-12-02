package com.example.admin.kalkulator;

import android.util.Log;

/**
 * Created by Łukasz on 2015-12-01.
 */
public class ButtonResultClickListner extends ButtonNumberClickListener {
    public ButtonResultClickListner(){
        super();
    }
    public ButtonResultClickListner(String value){
        super();
        this.value=value;
    }

    @Override
    public void before(){
        String currentText = textView.getText().toString();
        if(currentText.replaceAll("[\\+\\-\\*\\/]","").equals(currentText) && MainActivity.getCalculator().lastOperator().equals("")){
            MainActivity.getCalculator().parseText(currentText);
            cleanDisplayMode=true;
            return;
        }
        cleanDisplayMode=false;
        String[] parts = currentText.split("[\\+\\-\\*\\/]");
        if(parts.length==2 && currentText.charAt(0)!='-'|| parts.length==3 && currentText.charAt(0)=='-' || currentText.substring(currentText.length()-1).matches("[\\+\\-\\*\\/]")){
            MainActivity.getCalculator().parseText(currentText);
            //textView.setText(MainActivity.calculator.result());
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
        try{
            textView.setText(MainActivity.getCalculator().result());
        } catch (Exception e){
            //textView.setText();
            Log.d("result", "nieistotny blad");
        }
        currentText = textView.getText().toString();
        if(currentText.indexOf(".")<0){
            ButtonPointClickListner.setAvailablePoint(true);
        }

        Log.d("listner", "klik klik");
    }

    @Override
    public void after(){
        String currentText = textView.getText().toString();
        if(currentText.indexOf(".")<0){
            ButtonPointClickListner.setAvailablePoint(true);
        }
        else{
            ButtonPointClickListner.setAvailablePoint(false);
        }
    }
}
