package com.movil.saldarriaga.calculadora;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hass-pc on 18/02/2015.
 */
public class OperationButtonEvent extends ButtonEvent implements View.OnTouchListener {

    public OperationButtonEvent(TextView resu, Estructure est) {
        this.est = est;
        this.out = resu;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        Button bt = (Button)v;
        if (event.getActionMasked() == MotionEvent.ACTION_CANCEL || event.getActionMasked() == MotionEvent.ACTION_UP) {
            bt.setBackgroundResource(R.drawable.button_operation_free);
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                String btText =  out.getText().toString();
                if (bt.getText().toString().equals(".")) {
                    if (btText.equals("0")) {
                        out.setText("0.");
                        est.setLast(".");
                    } else {
                        if (!btText.contains(".")) {
                            out.setText(btText + ".");
                            est.setLast(".");
                        }
                    }
                } else {
                    try {
                        if (!est.Operando.equals("")) {
                            est.Operador2 = Float.parseFloat(btText);
                            est.Operador1 = est.Execute();
                            out.setText(est.Operador1 + "");
                        } else {
                            est.Operador1 = Float.parseFloat(btText);
                        }
                        est.setLast(bt.getText().toString());
                        est.Operando = bt.getText().toString();
                    } catch (Exception ex) {
                        est.advice.setText(R.string.syntax_error);
                    }
                }
            }
        } else {
            bt.setBackgroundResource(R.drawable.button_operation_hold);
        }

        return false;
    }
}
