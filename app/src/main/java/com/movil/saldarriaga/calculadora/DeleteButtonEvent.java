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
                out.setText(R.string.default_output);
                est.BackSpaceTwice++;
                if (est.BackSpaceTwice == 2) {
                    est.Operador1 = 0;
                    est.Operando = "";
                    est.Operador2 = 0;
                    est.setLast("");
                }
            }
        } else {
            row.setBackgroundResource(R.color.darker_red);
        }

        return false;
    }
}
