package com.movil.saldarriaga.calculadora;

import android.widget.TextView;

/**
 * Created by hass-pc on 18/02/2015.
 */
public abstract class ButtonEvent {
    protected TextView out;
    protected Estructure est;

    static boolean IsNumeric(String f) {
        try {
            Integer.parseInt(f);
            return true;
        } catch (NumberFormatException ex) {
            if (f.equals(".")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
