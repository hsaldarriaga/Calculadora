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
                String L = est.getLast();
                String S = out.getText().toString();
                String B = bt.getText().toString();
                if (Estructure.IsOperation(L)) {
                    est.setLast(B);
                    out.setText(B);
                } else if (Estructure.IsNumeric(L)) {
                    if (!S.equals("0")) {
                        est.setLast(B);
                        out.setText(S + B);
                    } else {
                        est.setLast(B);
                        out.setText(B);
                    }
                } else {
                    if (L.equals(".")) {
                        est.setLast(B);
                        out.setText(S+B);
                    } else { // it's "=" or ""
                        est.setLast(B);
                        out.setText(B);
                    }
                }
            }
        } else {
            bt.setBackgroundResource(R.drawable.button_numbers_hold);
        }
        return false;
    }
}
