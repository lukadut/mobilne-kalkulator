package com.example.admin.kalkulator;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Created by Łukasz on 2015-11-29.
 */
public class Calculator {
    Boolean blocked = false;
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
        String minusE="";
        if(text.indexOf("E-")>=0){
            int index = text.indexOf("E-");
            minusE = text.substring(index,index+2);
            Log.d("minusE1", minusE);
            text=text.replace("E-","EMINUS");
            Log.d("minusE2", minusE);
        }
        parts = text.split("[\\+\\-\\*\\/]");//"[\\+\\*-/]"
        if(parts.length>1) {
            operation = text.replaceAll("[\\d\\.\\w]", "");
        }
        Log.d("minusE1", minusE);
        Log.d("part10", parts[0]);
        Log.d("EMINUS POSITION", parts[0].indexOf("EMINUS")+"");
        if(parts[0].indexOf("EMINUS")>=0){
            Log.d("minusE3", minusE);
            parts[0] = parts[0].replace("EMINUS", minusE);
        }
        first = Double.parseDouble(parts[0])*negativeNumber;
        if(parts.length==2){
            second = (parts[1]==null)? 0. :  Double.parseDouble(parts[1]);
        }

    }
    public String lastOperator(){
        return operation;
    }
    public Boolean getBlocked(){
        return blocked;
    }
    public String result(){
        if((Double.isNaN(second))){
            if(Double.isInfinite(first)){
                blocked=true;
            }
            String res = first+"";
            res = (res.indexOf(".0")==res.length()-2)?  res.replaceFirst("\\.0", "") : res;
            if(res.indexOf(".")>=0){
                ButtonPointClickListner.setAvailablePoint(false);
            }else{
                ButtonPointClickListner.setAvailablePoint(true);
            }

            return res;
        }
        try {
            String res = calculate();

            Log.d("res.indexOf(\".0\")", res.indexOf(".0")+"");
            Log.d("res.length()-2", res.length()-2+"");
            Log.d("wynik", res);
            res = (res.indexOf(".0")==res.length()-2)?  res.replaceFirst("\\.0", "") : res;

            first=Double.parseDouble(res);
            if(res.indexOf(".")>=0){
                ButtonPointClickListner.setAvailablePoint(false);
            }else{
                ButtonPointClickListner.setAvailablePoint(true);
            }
            if(Double.isInfinite(first)){
                blocked=true;
            }
            if(res.equals("-0")){
                return "0";
            }
            return  res;
        } catch (Exception e){
            e.printStackTrace();
            blocked = true;
            return e.getMessage();
        }

    }
    private String calculate() throws Exception {
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
                } catch (Exception exception){
                    clear();
                    throw exception;
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
        ButtonPointClickListner.setAvailablePoint(true);
        blocked = false;
        first=0;
        second=Double.NaN;
        operation="";
    }
}
