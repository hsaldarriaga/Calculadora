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
                String L = est.getLast();
                String S = out.getText().toString();
                String B = bt.getText().toString();
                if (B.equals(".")) {
                    if (Estructure.IsOperation(L)) {
                        est.setLast(B);
                        out.setText("0.");
                    } else if (Estructure.IsNumeric(L)) {
                        est.setLast(B);
                        out.setText(S+".");
                    } else {
                        if (L.equals(".")) {
                            est.setLast("");
                            est.advice.setText(R.string.syntax_error);
                            est.Operando = "";
                        } else { // it's "=" or ""
                            if (L.equals("=")) {
                                est.setLast(B);
                                out.setText("0.");
                            } else {
                                est.setLast("");
                                est.advice.setText(R.string.syntax_error);
                                est.Operando = "";
                            }
                        }
                    }
                } else {
                    if (Estructure.IsOperation(L)) {
                        est.setLast(B);
                        est.Operando = B;
                    } else if (Estructure.IsNumeric(L)) {
                        if (est.Operando.equals("")) {
                            est.Operador1 = Float.parseFloat(S);
                            est.Operando = B;
                            est.setLast(B);
                        } else {
                            try {
                                est.Operador2 = Float.parseFloat(S);
                                est.Operador1 = est.Execute();
                                if (est.Operador1 == 0.0f)
                                    out.setText("0");
                                else
                                    out.setText(est.Operador1 + "");
                                est.setLast(B);
                                est.Operando=B;
                            } catch (Exception ex) {
                                est.Operando = "";
                                est.setLast("");
                                est.advice.setText(R.string.syntax_error);
                            }
                        }
                    } else {
                        if (L.equals("=")) {
                            est.Operador1 = Float.parseFloat(S);
                            est.Operando = B;
                            est.setLast(B);
                        } else {
                            est.Operando = "";
                            est.setLast("");
                            est.advice.setText(R.string.syntax_error);
                        }
                    }
                }
            }
        } else {
            bt.setBackgroundResource(R.drawable.button_operation_hold);
        }

        return false;
    }
}
