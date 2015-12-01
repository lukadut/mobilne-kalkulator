package com.example.admin.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Calculator calculator = new Calculator();
    List<Button> numberButtons, operationButtons;
    Button clear,back,add,sub,mul,div,dot,result;
    TextView textView ;//= ((TextView)findViewById(R.id.textView));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = ((TextView)findViewById(R.id.textView));
        ButtonNumberClickListener.setTextView(textView);
        getNumberButtons();
        getSpecialButtons();
    }

    private void getNumberButtons(){
        numberButtons = new ArrayList<Button>();
        for(int i=0; i<=9; i++){
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", "com.example.admin.kalkulator");
            Button b = ((Button) findViewById(resID));
            b.setOnClickListener(new ButtonNumberClickListener(b.getText().toString()));
            numberButtons.add(b);
        }
        Log.d("buttony", numberButtons.size() + "");
    }
    private void getSpecialButtons(){
        operationButtons = new ArrayList<Button>();
        clear = ((Button) findViewById(R.id.buttonClear));
        back = ((Button) findViewById(R.id.buttonBack));
        dot = ((Button) findViewById(R.id.buttonPoint));
        add = ((Button) findViewById(R.id.buttonPlus));
        sub = ((Button) findViewById(R.id.buttonMinus));
        div = ((Button) findViewById(R.id.buttonDiv));
        mul = ((Button) findViewById(R.id.buttonMul));

        operationButtons.add(sub);
        operationButtons.add(add);
        operationButtons.add(div);
        operationButtons.add(mul);

        for(Button b: operationButtons){
            b.setOnClickListener(new ButtonOperatorClickListner(b.getText().toString()));
        }

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.clear();
                textView.setText("0");
            }
        });
    }

}
