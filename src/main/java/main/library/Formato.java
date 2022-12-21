
package main.library;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Formato {
    Number numero;
    DecimalFormat formateador = new DecimalFormat("###,###,##0.00");

    public String decimal(double formato) {
        return formateador.format(formato);
    }

    public double reconstruir(String formato) {
        try {
            numero = formateador.parse(formato.replace(" ", ""));
        } catch (ParseException ex) {
            System.out.println("Error : " + ex);
        }
        return numero.doubleValue();
    }
}
