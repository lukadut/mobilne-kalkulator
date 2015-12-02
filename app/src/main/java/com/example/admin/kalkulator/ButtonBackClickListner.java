package com.example.admin.kalkulator;

import android.util.Log;

/**
 * Created by Łukasz on 2015-12-01.
 */
public class ButtonBackClickListner extends ButtonNumberClickListener {
    public ButtonBackClickListner(){
        super();
    }
    public ButtonBackClickListner(String value){
        super();
        this.value=value;
    }

    @Override
    public void before(){

    }
    @Override
    public void displayAction(){
        String currentText = textView.getText().toString();
        int newLen = currentText.length()-1;

        //String deleted = currentText.substring(newLen);
        int lastPoint = currentText.lastIndexOf(".");
        Log.d("usuwam", String.valueOf(currentText.charAt(newLen-1)).matches("[a-zA-Z\\*\\+\\-\\/]+")+" "+ (currentText.charAt(newLen-1)) );
        while(String.valueOf(currentText.charAt(newLen-1)).matches("[a-zA-Z\\*\\+\\-\\/]+")){
            newLen--;
        }
        currentText = currentText.substring(0, newLen);
        if(currentText.length()==0){
            currentText="0";
        }
        if(currentText.lastIndexOf(".") < lastPoint){
            ButtonPointClickListner.setAvailablePoint(true);
        }


        textView.setText(currentText);
        ButtonPointClickListner.setAvailablePoint(true);

        Log.d("listner", "klik klik");
    }

    @Override
    public void after(){


    }
}
