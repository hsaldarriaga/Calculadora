package com.movil.saldarriaga.calculadora;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hass-pc on 18/02/2015.
 */
public class ResultButtonEvent extends ButtonEvent implements View.OnTouchListener{

    TextView advice;

    public ResultButtonEvent(Estructure est, TextView advice, TextView resu) {
        this.est = est;
        this.out = resu;
        this.advice = advice;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Button bt = (Button)v;
        if (event.getActionMasked() == MotionEvent.ACTION_CANCEL || event.getActionMasked() == MotionEvent.ACTION_UP) {
            bt.setBackgroundResource(R.drawable.button_operation_free);
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                if (est.Operando!="") {
                    try {
                        est.Operador2 = Float.parseFloat(out.getText().toString());
                        est.Operador1 = est.Execute();
                        if (est.Operador1 == 0.0f)
                            out.setText("0");
                        else
                            out.setText(est.Operador1 + "");
                        est.Operando = "";
                        est.Operador2 = 0f;
                        est.setLast(bt.getText().toString());
                    } catch (Exception ex) {
                        advice.setText(R.string.syntax_error);
                    }
                }
            }
        } else {
            bt.setBackgroundResource(R.drawable.button_operation_hold);
        }
        return false;
    }
}
