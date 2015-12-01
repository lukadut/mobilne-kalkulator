package com.example.admin.kalkulator;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Created by Łukasz on 2015-11-29.
 */
public class Calculator {

    double first, second;
    String operation = "";
    //String[] operations = {"+","-","*","/"};
    public void parseText(String text){
        String[] parts;
        int negativeNumber= 1;
        if(text.charAt(0)=='-'){
            negativeNumber= -1;
            text = text.substring(1);
        }
        parts = text.split("[\\+\\-\\*\\/]");//"[\\+\\*-/]"
        for(int i=0; i<parts.length;i++){
            Log.d("CALC", i + " " + parts[i] + " operator " + text.replaceAll("[\\d\\.\\w]", ""));
        }
        operation = text.replaceAll("[\\d\\.\\w]", "");
        first = Double.parseDouble(parts[0])*negativeNumber;
        if(parts.length==2){
            second = (parts[1]==null)? 0. :  Double.parseDouble(parts[1]);
        }

    }
    public String lastOperator(){
        return operation;
    }
    public String result(){
        if((Double.isNaN(second))){
            String res = first+"";
            res = res.replaceFirst("\\.0+", "");
            return res;
        }
        try {
            String res = calculate();
            Log.d("wynik", res);
            res = res.replaceFirst("\\.0+", "");
            first=Double.parseDouble(res);
            if(res.equals("-0")){
                return "0";
            }
            return  res;
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
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
                    clear();
                    throw new ArithmeticException("Divide by 0");
                }
            }
             default:{
                 return first+"";
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
    public void clear(){
        first=0;
        second=Double.NaN;
        operation="";
    }
}
