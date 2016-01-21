package com.example.adrian.simplecalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.matheclipse.parser.client.eval.DoubleEvaluator;

public class MyCalcActivity extends AppCompatActivity {

    private String layoutString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_calc_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        layoutString = getString(R.string.simpleLayout);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_close_program:
                this.finish();
                break;
            case R.id.action_about:
                AlertDialog aboutDialog = new AlertDialog.Builder(MyCalcActivity.this).create();
                aboutDialog.setTitle(getString(R.string.aboutTittle));
                aboutDialog.setMessage(getString(R.string.aboutInfo));
                aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                aboutDialog.show();
                break;
            case R.id.action_change_language:

                break;
            case R.id.change_layout:
                if(layoutString == getString(R.string.simpleLayout)) {
                    setContentView(R.layout.scientific_calc_main);
                    Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
                    setSupportActionBar(toolbar);
                    layoutString = getString(R.string.scientificLayout);
                }else {
                    setContentView(R.layout.simple_calc_main);
                    Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
                    setSupportActionBar(toolbar);
                    layoutString = getString(R.string.simpleLayout);
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    public void buttonClick (View view) {

        TextView textViewEquation;
        TextView textViewAnswear;

        switch (view.getId()) {
            case R.id.buttonZero:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("0");
                break;
            case R.id.buttonOne:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("1");
                break;
            case R.id.buttonTwo:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("2");
                break;
            case R.id.buttonThree:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("3");
                break;
            case R.id.buttonFour:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("4");
                break;
            case R.id.buttonFive:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("5");
                break;
            case R.id.buttonSix:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("6");
                break;
            case R.id.buttonSeven:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("7");
                break;
            case R.id.buttonEight:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("8");
                break;
            case R.id.buttonNine:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("9");
                break;
            case R.id.buttonPlus:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("+");
                break;
            case R.id.buttonDivide:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("/");
                break;
            case R.id.buttonSubtract:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("-");
                break;
            case R.id.buttonMultiply:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("*");
                break;
            case R.id.buttonDot:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append(".");
                break;
            case R.id.buttonEqual:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                DoubleEvaluator mathParser = new DoubleEvaluator();
                textViewAnswear = (TextView) findViewById(R.id.textViewRes);
                textViewAnswear.setText(mathParser.evaluate(textViewEquation.getText().toString()) + "");
                break;
            case R.id.buttonDelete:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.setText("");
                break;
            case R.id.buttonPercent:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("%");
                break;
            case R.id.buttonSquareRoot:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("Sqrt[");
                break;
            case R.id.buttonCloseBracket:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                textViewEquation.append("]");
                break;
            case R.id.buttonBackSpace:
                textViewEquation = (TextView) findViewById(R.id.textViewInput);
                backSpace(textViewEquation);
                break;
        }
    }

    private void backSpace(TextView text) {
        if (text.length() < 1){
            text.setText("");
        }else {
            String stringFormated = text.getText().toString().substring(0, text.length()-1);
            text.setText(stringFormated);
        }
    }
}
