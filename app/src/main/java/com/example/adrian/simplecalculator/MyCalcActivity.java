package com.example.adrian.simplecalculator;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonClick (View view) {

        TextView textView;

        switch (view.getId()) {
            case R.id.buttonZero:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("0");
                break;
            case R.id.buttonOne:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("1");
                break;
            case R.id.buttonTwo:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("2");
                break;
            case R.id.buttonThree:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("3");
                break;
            case R.id.buttonFour:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("4");
                break;
            case R.id.buttonFive:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("5");
                break;
            case R.id.buttonSix:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("6");
                break;
            case R.id.buttonSeven:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("7");
                break;
            case R.id.buttonEight:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("8");
                break;
            case R.id.buttonNine:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("9");
                break;
            case R.id.buttonPlus:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("+");
                break;
            case R.id.buttonDivide:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("/");
                break;
            case R.id.buttonSubtract:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("-");
                break;
            case R.id.buttonMultiply:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append("*");
                break;
            case R.id.buttonDot:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.append(".");
                break;
            case R.id.buttonEqual:
                textView = (TextView) findViewById(R.id.textViewResult);
                DoubleEvaluator mathParser = new DoubleEvaluator();
                textView.setText(mathParser.evaluate(textView.getText().toString()) + "");
                break;
            case R.id.buttonDelete:
                textView = (TextView) findViewById(R.id.textViewResult);
                textView.setText("");
                break;
        }
    }
}
