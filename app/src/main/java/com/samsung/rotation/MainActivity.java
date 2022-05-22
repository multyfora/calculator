package com.samsung.rotation;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.Contacts;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button dot;
    Button AC;
    Button negative;
    Button percent;
    Button divide;
    Button multiply;
    Button plus;
    Button minus;
    Button equals;
    TextView UI;
    String UItext;
    TextView action;
    TextView answer;
    String answertext;
    String actiontext;
    int isdot = 0;
    String buffer;
    double UII = 0;
    double answerdouble;
    int answerint;
    double bufferint;
    double UIint;
    double tmp;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = findViewById(R.id.answer);
        action = findViewById(R.id.action);
        b0 = findViewById(R.id.b0);
        UI = findViewById(R.id.UI);
        b1 = findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        dot=findViewById(R.id.dot);
        AC=findViewById(R.id.AC);
        negative=findViewById(R.id.negative);
        percent=findViewById(R.id.percent);
        divide = findViewById(R.id.divide);
        multiply= findViewById(R.id.multiply);
        plus =findViewById(R.id.plus);
        minus =findViewById(R.id.minus);
        equals = findViewById(R.id.equals);
        UItext= UI.getText().toString();
        b0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"0");
                UI.setText(UItext);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"1");
                UI.setText(UItext);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"2");
                UI.setText(UItext);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"3");
                UI.setText(UItext);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"4");
                UI.setText(UItext);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"5");
                UI.setText(UItext);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"6");
                UI.setText(UItext);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"7");
                UI.setText(UItext);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"8");
                UI.setText(UItext);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                UItext=(UItext+"9");
                UI.setText(UItext);

            }
        });
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer(UItext);
                if(UItext.length()!=0) {
                    sb.deleteCharAt(sb.length() - 1);
                    UI.setText(sb);
                    UItext = sb + "";
                }
                else {
                    actiontext = "";
                    action.setText(actiontext);
                    answertext = "";
                    answer.setText(answertext);
                }
            }
        });
        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Objects.equals(UItext, "")) {
                    char firstChar = UItext.charAt(0);
                    if (firstChar != '-') {
                        UItext = "-" + UItext;
                        UI.setText(UItext);
                    } else {
                        StringBuffer sb = new StringBuffer(UItext);
                        sb.deleteCharAt(0);
                        UItext = sb + "";
                        UI.setText(sb);
                    }
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer(UItext);
                String UItemp = UItext;
                isdot = 0;
                for(int i = 0; i<UItemp.length(); i++) {
                    char St = sb.charAt(i);
                    if (St == '.') {
                        isdot++;
                    }

                }
                if (isdot==0) {
                    UItext = (UItext + ".");
                    UI.setText(UItext);
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setText("x");
                buffer = UItext;
                UItext = "";
                UI.setText("");
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actiontext =action.getText().toString();

                if (!Objects.equals(UItext, "")&&!Objects.equals(buffer, "")){
                    bufferint = Double.parseDouble(buffer);
                    UIint = Double.parseDouble(UItext);
                    switch(actiontext){
                        case "+": answerdouble = bufferint+UIint;
                        break;
                        case "x": answerdouble = bufferint*UIint;
                        break;
                        case "-": answerdouble = bufferint-UIint;
                        break;
                        case "÷": answerdouble = bufferint/UIint;
                        break;
                    }
                    answerint = (int) answerdouble;


                    //easter egg
                    if (bufferint == 1000 && UIint == 7 && actiontext.equals("-")){
                        Toast.makeText(getApplicationContext(),"you are ghoul",Toast.LENGTH_LONG).show();
                    }
                    //easter egg


                    if (answerint == answerdouble){
                        answertext = answerint + "";
                        answer.setText(answertext);
                    }
                    else {
                        answertext = answerdouble + "";
                        answer.setText(answertext);
                    }
                    if (answertext.length()>18){
                        answer.setTextSize(25);
                    }
                    else answer.setTextSize(34);

                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setText("+");
                buffer = UItext;
                UItext = "";
                UI.setText("");

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setText("-");
                buffer = UItext;
                UItext = "";
                UI.setText("");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setText("÷");
                buffer = UItext;
                UItext = "";
                UI.setText("");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Objects.equals(UItext,"")) {
                    UIint = Integer.parseInt(UItext);
                    UIint = UIint/100;
                    UItext = String.valueOf(UIint);
                    UI.setText(UItext);
                }
            }
        });
    }
}