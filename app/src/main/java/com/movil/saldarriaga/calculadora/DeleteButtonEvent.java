package com.movil.saldarriaga.calculadora;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by hass-pc on 18/02/2015.
 */
public class DeleteButtonEvent extends ButtonEvent implements View.OnTouchListener {

    public DeleteButtonEvent(Estructure est, TextView resu) {
        this.est = est;
        this.out = resu;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        TableRow row = (TableRow)v;
        if (event.getActionMasked() == MotionEvent.ACTION_CANCEL || event.getActionMasked() == MotionEvent.ACTION_UP) {
            row.setBackgroundResource(R.color.dark_red);
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                String L = est.getLast();
                String S = out.getText().toString();
                if (est.BackSpaceTwice==1) {
                    est.setLast("");
                    out.setText("0");
                    est.Operando="";
                } else {
                    if (Estructure.IsOperation(L)) {
                        est.setLast("");
                        out.setText("0");
                        est.Operando="";
                    } else if (Estructure.IsNumeric(L)) {
                        out.setText("0");
                        est.setLast("0");
                        est.BackSpaceTwice++;
                        est.advice.setText("");
                    } else {
                        if (L.equals(".")) {
                            out.setText("0");
                            est.setLast("0");
                            est.BackSpaceTwice++;
                            est.advice.setText("");
                        } else { // it's "=" or ""
                            if (L.equals("=")) {
                                out.setText("0");
                                est.setLast("0");
                                est.BackSpaceTwice++;
                                est.advice.setText("");
                            } else {
                                out.setText("0");
                                est.setLast("0");
                                est.advice.setText("");
                            }
                        }
                    }
                }
            }
        } else {
            row.setBackgroundResource(R.color.darker_red);
        }

        return false;
    }
}
