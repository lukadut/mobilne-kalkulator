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

    List<Button> numberButtons;
    TextView textView ;//= ((TextView)findViewById(R.id.textView));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = ((TextView)findViewById(R.id.textView));
        ButtonClickListener.setTextView(textView);
        getNumberButtons();
    }

    private void getNumberButtons(){
        numberButtons = new ArrayList<Button>();
        for(int i=0; i<=9; i++){
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", "com.example.admin.kalkulator");
            Button b = ((Button) findViewById(resID));
            b.setOnClickListener(new ButtonClickListener(b.getText().toString()));
            numberButtons.add(b);
        }
        Log.d("buttony", numberButtons.size()+"");
    }
}
