package com.movil.saldarriaga.calculadora;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class calculadora extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        Init();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
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

    private void Init() {
        Estructure est = new Estructure();
        TextView view = (TextView) findViewById(R.id.NumericOuput);
        TextView advice = (TextView) findViewById(R.id.advice);
        est.advice = advice;
        NumericButtonEvent ev1 = new NumericButtonEvent(view, est);
        OperationButtonEvent ev2 = new OperationButtonEvent(view, est);
        ResultButtonEvent resubt = new ResultButtonEvent(est, advice, view);
        DeleteButtonEvent deletebt = new DeleteButtonEvent(est, view);
        TableLayout table = (TableLayout) findViewById(R.id.buttons);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                if (row.getChildAt(j) instanceof ImageView) {
                    row.setOnTouchListener(deletebt);
                } else { // Button
                    Button bt = (Button) row.getChildAt(j);
                    String text = bt.getTag().toString();
                    if (text.equals("num")) {
                        bt.setOnTouchListener(ev1);
                    } else if (text.equals("op")) {
                        bt.setOnTouchListener(ev2);
                    } else {
                        bt.setOnTouchListener(resubt);
                    }
                }

            }
        }
    }
}

