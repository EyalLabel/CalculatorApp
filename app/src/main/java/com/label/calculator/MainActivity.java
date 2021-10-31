package com.label.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView number;
    double res =0; //Double.parseDouble(number.getText().toString());
    String act="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    private void setPointer() {
        number=findViewById(R.id.number);
    }

    public double mathAction(double num, double num2,String action) {
        double result = 0;
        switch (action) {
            case "plus":
                result = num + num2;
                break;
            case "minus":
                result = num - num2;
                break;
            case "divide":
                result = num / num2;
                break;
            case "multiply":
                result = num * num2;
                break;
            case "":
                result=num;
        }
        return result;
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(number.getText().toString());
        switch (view.getId()) {

            case R.id.num1:
                sb.append("1");
                break;
            case R.id.num2:
                sb.append("2");
                break;
            case R.id.num3:
                sb.append("3");
                break;
            case R.id.num4:
                sb.append("4");
                break;
            case R.id.num5:
                sb.append("5");
                break;
            case R.id.num6:
                sb.append("6");
                break;
            case R.id.num7:
                sb.append("7");
                break;
            case R.id.num8:
                sb.append("8");
                break;
            case R.id.num9:
                sb.append("9");
                break;
            case R.id.num0:
                sb.append("0");
                break;
            case R.id.division:
                //sb.append("/");
                if (res==0) {
                    res = Double.parseDouble(number.getText().toString());
                }else {
                    if ((number.getText().toString())!=""){
                        res=mathAction(res,Double.parseDouble(number.getText().toString()),act);}
                    else {res=mathAction(res,0.0,act);}
                }
                number.setText("");
                act="divide";
                return;
            case R.id.dot:
                sb.append(".");
                break;
            case R.id.add:
                //sb.append("+");
                if (res==0) {
                    res = Double.parseDouble(number.getText().toString());
                }else {
                    if ((number.getText().toString())!=""){
                        res=mathAction(res,Double.parseDouble(number.getText().toString()),act);}
                    else {res=mathAction(res,0.0,act);}
                }
                number.setText("");
                act="plus";
                return;
            case R.id.minus:
                //sb.append("-");
                if (res==0) {
                    res = Double.parseDouble(number.getText().toString());
                }else {
                    if ((number.getText().toString())!=""){
                    res=mathAction(res,Double.parseDouble(number.getText().toString()),act);}
                    else {res=mathAction(res,0.0,act);}}

                number.setText("");
                act="minus";
                return;
            case R.id.multiply:
                //     sb.append("X");
                if (res==0) {
                    res = Double.parseDouble(number.getText().toString());
                }else {
                    if ((number.getText().toString())!=""){
                        res=mathAction(res,Double.parseDouble(number.getText().toString()),act);}
                    else {res=mathAction(res,0.0,act);}
                }
                number.setText("");
                act="multiply";
                return;
            case R.id.equals:
                if ((number.getText().toString())!=""){
                    res=mathAction(res,Double.parseDouble(number.getText().toString()),act);}
                else {res=mathAction(res,0.0,act);}
                number.setText(Double.toString(res));
                if (act=="divide"&& Double.parseDouble(number.getText().toString())==0){
                    res=0;
                    number.setText("IMPOSSIBLE");
                }
                act="";
                return;
            case R.id.delete:
                res=0;
                number.setText("");
                return;
        }
        number.setText(sb.toString());
    }
}

