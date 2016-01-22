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

import java.util.Locale;

public class MyCalcActivity extends AppCompatActivity {

    private boolean simpleLayout = true;
    private final String layoutStateKey = "LAYOUTSTATE_KEY";
    private final String equationStringKey = "EQUATiON_key";
    private final String answearStringKey = "ANSWEAR_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreState(savedInstanceState);
        if (simpleLayout == true) {
            setContentView(R.layout.simple_calc_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(toolbar);
        }else {
            setContentView(R.layout.scientific_calc_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(toolbar);
            simpleLayout = false;
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        TextView textViewEquation = (TextView) findViewById(R.id.textViewInput);
        savedInstanceState.putString(equationStringKey, textViewEquation.toString());
        TextView textViewAnswear = (TextView) findViewById(R.id.textViewRes);
        savedInstanceState.putString(answearStringKey, textViewAnswear.toString());
        savedInstanceState.putBoolean(layoutStateKey, simpleLayout);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            TextView textViewEquation = (TextView) findViewById(R.id.textViewInput);
            if(textViewEquation != null) {
                textViewEquation.setText(savedInstanceState.getString(equationStringKey));
            }
            TextView textViewAnswear = (TextView) findViewById(R.id.textViewRes);
            if(textViewAnswear != null) {
                textViewAnswear.setText(savedInstanceState.getString(answearStringKey));
            }
            simpleLayout = savedInstanceState.getBoolean(layoutStateKey);
        }
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
        String languageToLoad;
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

            case R.id.buttonScientifcView:
                String tempEquation = ((TextView) findViewById(R.id.textViewInput)).getText().toString();
                String tempAnswear = ((TextView) findViewById(R.id.textViewRes)).getText().toString();
                setContentView(R.layout.scientific_calc_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
                setSupportActionBar(toolbar);
                ((TextView) findViewById(R.id.textViewInput)).setText(tempEquation);
                ((TextView) findViewById(R.id.textViewRes)).setText(tempAnswear);
                simpleLayout=false;
                break;
            case R.id.buttonSimpleView:
                String tempEquationSimple = ((TextView) findViewById(R.id.textViewInput)).getText().toString();
                String tempAnswearSimple = ((TextView) findViewById(R.id.textViewRes)).getText().toString();
                setContentView(R.layout.simple_calc_main);
                Toolbar toolbarSimple = (Toolbar) findViewById(R.id.my_toolbar);
                setSupportActionBar(toolbarSimple);
                ((TextView) findViewById(R.id.textViewInput)).setText(tempEquationSimple);
                ((TextView) findViewById(R.id.textViewRes)).setText(tempAnswearSimple);
                simpleLayout=true;
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void buttonClick (View view) {

        TextView textViewEquation = (TextView) findViewById(R.id.textViewInput);
        TextView textViewAnswear;

        switch (view.getId()) {
            case R.id.buttonZero:
                textViewEquation.append("0");
                break;
            case R.id.buttonOne:
                textViewEquation.append("1");
                break;
            case R.id.buttonTwo:
                textViewEquation.append("2");
                break;
            case R.id.buttonThree:
                textViewEquation.append("3");
                break;
            case R.id.buttonFour:
                textViewEquation.append("4");
                break;
            case R.id.buttonFive:
                textViewEquation.append("5");
                break;
            case R.id.buttonSix:
                textViewEquation.append("6");
                break;
            case R.id.buttonSeven:
                textViewEquation.append("7");
                break;
            case R.id.buttonEight:
                textViewEquation.append("8");
                break;
            case R.id.buttonNine:
                textViewEquation.append("9");
                break;
            case R.id.buttonPlus:
                textViewEquation.append("+");
                break;
            case R.id.buttonDivide:
                textViewEquation.append("/");
                break;
            case R.id.buttonSubtract:
                textViewEquation.append("-");
                break;
            case R.id.buttonMultiply:
                textViewEquation.append("*");
                break;
            case R.id.buttonDot:
                textViewEquation.append(".");
                break;
            case R.id.buttonEqual:
                DoubleEvaluator mathParser = new DoubleEvaluator();
                textViewAnswear = (TextView) findViewById(R.id.textViewRes);
                try {
                    textViewAnswear.setText(mathParser.evaluate(textViewEquation.getText().toString()) + "");
                }catch (Exception exception){
                    AlertDialog aboutDialog = new AlertDialog.Builder(MyCalcActivity.this).create();
                    aboutDialog.setTitle(getString(R.string.expressionisWrongTitle));
                    aboutDialog.setMessage(getString(R.string.expressionIsWrong));
                    aboutDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "close",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    aboutDialog.show();
                }
                break;
            case R.id.buttonDelete:
                textViewEquation.setText("");
                textViewAnswear = (TextView) findViewById(R.id.textViewRes);
                textViewAnswear.setText("");
                break;
            case R.id.buttonPercent:
                textViewEquation.append("/100");
                break;
            case R.id.buttonSquareRoot:
                textViewEquation.append("Sqrt[");
                break;
            case R.id.buttonCloseBracket:
                textViewEquation.append("]");
                break;
            case R.id.buttonBackSpace:
                backSpace(textViewEquation);
                break;
            case R.id.buttonx2:
                textViewEquation.append("^2");
                break;
            case R.id.button10x:
                textViewEquation.append("10^");
                break;
            case R.id.buttonSin:
                textViewEquation.append("Sin[");
                break;
            case R.id.buttonCos:
                textViewEquation.append("Cos[");
                break;
            case R.id.buttonTan:
                textViewEquation.append("Tan[");
                break;
            case R.id.buttonLog:
                textViewEquation.append("Log[");
                break;
            case R.id.buttonEXP:
                textViewEquation.append("^");
                break;
            case R.id.buttonPI:
                textViewEquation.append("Pi");
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
