package com.example.admin.kalkulator;

import android.util.Log;

/**
 * Created by Łukasz on 2015-12-01.
 */
public class ButtonPointClickListner extends ButtonNumberClickListener {
    public ButtonPointClickListner(){
        super();
    }
    public ButtonPointClickListner(String value){
        super();
        this.value=value;
    }
    static Boolean availablePoint=true;
    static void setAvailablePoint(Boolean available){
        availablePoint = available;
    }
    static Boolean getAvailablePoint(){
        return availablePoint;
    }

    @Override
    public void before(){
        cleanDisplayMode=false;

        //String currentText = textView.getText().toString().substring(1);
        //currentText = currentText.replaceAll("[\\+\\-\\*\\/]","|");
        //String[] parts = currentText.split("|");

        //if(parts[0].indexOf(".") <0){
        //    availablePoint=true;
        //}
        //if(currentText.indexOf("|") > currentText.lastIndexOf(".")){
        //    availablePoint= true;
        //}

    }
    @Override
    public void displayAction(){
        String currentText = textView.getText().toString();
        if(availablePoint) {
            textView.append(value);
            availablePoint=false;
        }
        Log.d("listner", "klik klik");
    }

    @Override
    public void after(){

    }
}
