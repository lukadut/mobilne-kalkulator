package com.example.admin.kalkulator;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Created by Łukasz on 2015-11-29.
 */
public class Calculator {
    double first, second;
    String operation = null;
    //String[] operations = {"+","-","*","/"};
    public void parseText(String text){
        String[] parts;
        parts = text.split("[\\+\\*-/]");
        for(int i=0; i<parts.length;i++){
            Log.d("CALC", i + " " + parts[i] + " operator " + text.replaceAll("\\d", ""));
        }
        operation = text.replaceAll("[\\d\\.]+", "");
        if(parts.length>0){
            first = Double.parseDouble(parts[0]);
            second = (parts[1]==null)? 0. :  Double.parseDouble(parts[1]);
        }

    }
    public String result(){
        String res = calculate();
        DecimalFormat format = new DecimalFormat("0.#");
        try{
            Double.parseDouble(res);
            return format.format(res);
        } catch (Exception e){
            return  res;
        }

    }
    private String calculate(){
        switch (operation) {
            case "+":{
                return add()+"";
            }
            case "-":{
                return  sub()+"";
            }
            case "*":{
                return mul()+"";
            }
            case "/":{
                try {
                    return div()+"";
                } catch (Exception e){
                    first = Double.NaN;
                    second = Double.NaN;
                    operation = "";
                    return "Dzielenie przez 0";
                }
            }
             default:{
                 return "Error";
             }

        }
    }

    private double add(){
        return first+second;
    }
    private double sub(){
        return first-second;
    }
    private double mul(){
        return first*second;
    }
    private double div() throws Exception {
        if (second == 0.){
            throw new Exception("Divide by 0");
        }
        return first/second;
    }
}
