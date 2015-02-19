package com.movil.saldarriaga.calculadora;

import android.widget.TextView;

/**
 * Created by hass-pc on 18/02/2015.
 */
public class Estructure {

    public float Operador1=0f, Operador2=0f;
    public String Operando="";
    private String Last="";
    public int BackSpaceTwice = 0;
    public TextView advice;
    public String getLast() {
        return Last;
    }

    public void setLast(String last) {
        Last = last;
        BackSpaceTwice = 0;
        advice.setText("");
    }

    public float Execute() {
        if (co("*",Operando))
            return Operador1 * Operador2;
        if (co("/",Operando))
        {
            if (Operador2 == 0.0f) {
                advice.setText(R.string.syntax_error);
                return 0;
            } else
                return Operador1 / Operador2;
        }
        if (co("+",Operando))
            return Operador1 + Operador2;
        if (co("-",Operando))
            return  Operador1-Operador2;
        return 0f;
    }

    public static boolean co (String st, String st2) {
        return st.equals(st2);
    }
}
