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

    public float Execute() throws NumberFormatException{
        if (co("*",Operando))
            return Operador1 * Operador2;
        if (co("/",Operando))
        {
            if (Operador2 == 0.0f) {
                throw new NumberFormatException("0 Division");
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

    static boolean IsOperation(String op) {
        try {
            if (op.equals(".") || op.equals("") || op.equals("=")) {
                return false;
            }
             Float.parseFloat(op);
             return false;
        } catch (Exception ex) {
            return true;
        }
    }
}
