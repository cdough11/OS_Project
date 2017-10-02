package edu.towson.cosc431.CarrieDougher.calculator;

import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button decimal;
    Button clear;

    Button add;
    Button subtract;
    Button multiply;
    Button divide;
    Button equals;
    TextView result;
    String firstNum = "";
    String secondNum = "";
    int currentNum = 1;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    public void bindView() {
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight= (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        decimal = (Button)findViewById(R.id.decimal);
        clear = (Button)findViewById(R.id.clear);
        add = (Button)findViewById(R.id.addition);
        subtract = (Button)findViewById(R.id.subtraction);
        multiply = (Button)findViewById(R.id.multiplication);
        divide = (Button)findViewById(R.id.division);
        equals = (Button)findViewById(R.id.equals);
        result = (TextView)findViewById(R.id.result);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        decimal.setOnClickListener(this);
        clear.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        equals.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                result.append("1");
                addToNumber("1");
                break;
            case R.id.two:
                result.append("2");
                addToNumber("2");
                break;
            case R.id.three:
                result.append("3");
                addToNumber("3");
                break;
            case R.id.four:
                result.append("4");
                addToNumber("4");
                break;
            case R.id.five:
                result.append("5");
                addToNumber("5");
                break;
            case R.id.six:
                result.append("6");
                addToNumber("6");
                break;
            case R.id.seven:
                result.append("7");
                addToNumber("7");
                break;
            case R.id.eight:
                result.append("8");
                addToNumber("8");
                break;
            case R.id.nine:
                result.append("9");
                addToNumber("9");
                break;
            case R.id.zero:
                result.append("0");
                addToNumber("0");
                break;
            case R.id.decimal:
                result.append(".");
                addToNumber(".");
                break;
            case R.id.clear:
                clear();
                break;
            case R.id.addition:
                result.append("+");
                logOperator("+");
                break;
            case R.id.subtraction:
                result.append("-");
                logOperator("-");
                break;
            case R.id.multiplication:
                result.append("*");
                logOperator("*");
                break;
            case R.id.division:
                result.append("/");
                logOperator("/");
                break;
            case R.id.equals:
                calculate(firstNum, secondNum, operator);
                break;
        }
    }

    public void addToNumber(String num){
        if(currentNum == 1){
            firstNum += num;
        }
        else{
            secondNum += num;
        }
    }

    public void logOperator(String symbol){
        if(operator == null) {
            operator = symbol;
            currentNum = 2;
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Invalid Entry");
            alertDialog.setMessage("Cannot yet operate with more than 2 numbers");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    public void calculate(String first, String second, String op) {
        double firstNum = Double.valueOf(first);
        double secondNum = Double.valueOf(second);
        double ans;
        String Stringanswer;
        if (op == "+") {
            ans = firstNum + secondNum;
            Stringanswer = String.valueOf(ans);
            if (Stringanswer.endsWith(".0")) {
                Stringanswer = Stringanswer.substring(0, Stringanswer.indexOf("."));
                result.setText(Stringanswer);
            } else {
                result.setText(String.valueOf(ans));
            }
        } else if (op == "-") {
            ans = firstNum - secondNum;
            Stringanswer = String.valueOf(ans);
            if (Stringanswer.endsWith(".0")) {
                Stringanswer = Stringanswer.substring(0, Stringanswer.indexOf("."));
                result.setText(Stringanswer);
            } else {
                result.setText(String.valueOf(ans));
            }
        } else if (op == "*") {
            ans = firstNum * secondNum;
            Stringanswer = String.valueOf(ans);
            if (Stringanswer.endsWith(".0")) {
                Stringanswer = Stringanswer.substring(0, Stringanswer.indexOf("."));
                result.setText(Stringanswer);
            } else {
                result.setText(String.valueOf(ans));
            }
        } else if (op == "/") {
            double firstNumber = Double.valueOf(first);
            double secondNumber = Double.valueOf(second);
            if (secondNumber == 0) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Invalid Entry");
                alertDialog.setMessage("Cannot divide by 0");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            } else {
                double answer;
                answer = firstNumber / secondNumber;
                result.setText(String.valueOf(answer));
            }
        }
    }

    public void clear() {
        result.setText(null);
        firstNum = "0";
        secondNum = "0";
        operator = null;
        currentNum = 1;
    }
}
