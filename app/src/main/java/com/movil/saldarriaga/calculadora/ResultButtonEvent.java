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
                String L = est.getLast();
                String S = out.getText().toString();
                String B = bt.getText().toString();
                if (Estructure.IsOperation(L)) {
                    est.setLast(B);
                    est.advice.setText(R.string.syntax_error);
                    est.Operando="";
                } else if (Estructure.IsNumeric(L)) {
                    if (!est.Operando.equals("")) {
                        try {
                            est.Operador2 = Float.parseFloat(S);
                            out.setText(est.Execute() + "");
                            est.Operando = "";
                            est.setLast(B);
                        } catch (Exception ex) {
                            est.Operando = "";
                            est.setLast("");
                            est.advice.setText(R.string.syntax_error);
                        }
                    }
                } else {
                    if (L.equals(".")) {
                        est.advice.setText(R.string.syntax_error);
                        est.Operando="";
                        est.setLast(B);
                    } else { // it's "=" or ""
                        est.Operando=B;
                        est.setLast(B);
                    }
                }
            }
        } else {
            bt.setBackgroundResource(R.drawable.button_operation_hold);
        }
        return false;
    }
}
