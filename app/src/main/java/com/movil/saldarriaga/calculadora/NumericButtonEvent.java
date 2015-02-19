package com.movil.saldarriaga.calculadora;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hass-pc on 18/02/2015.
 */
public class NumericButtonEvent extends ButtonEvent implements View.OnTouchListener {

    public NumericButtonEvent(TextView resu, Estructure est) {
        this.est = est;
        this.out = resu;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Button bt = (Button)v;
        if (event.getActionMasked() == MotionEvent.ACTION_CANCEL || event.getActionMasked() == MotionEvent.ACTION_UP) {
            bt.setBackgroundResource(R.drawable.button_numbers_free);
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                if (out.getText().toString().equals("0") || !ButtonEvent.IsNumeric(est.getLast())) {
                    out.setText(bt.getText().toString());
                } else {
                    out.setText(out.getText().toString()+bt.getText().toString());
                }
                est.setLast(bt.getText().toString());
            }
        } else {
            bt.setBackgroundResource(R.drawable.button_numbers_hold);
        }
        return false;
    }
}
