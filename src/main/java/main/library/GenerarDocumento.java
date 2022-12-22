package main.library;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class GenerarDocumento {

    private final StringBuilder LINEAS = new StringBuilder();
    private final int MAX_CARACTERES = 50;
    private int stop;
    private final Formato FORMAT = new Formato();

    public String separarSeccion() {
        String separador = "";
        for (int i = 0; i < MAX_CARACTERES; i++) {
            separador += "-";
        }
        return LINEAS.append(separador).append("\n").toString();
    }

    public String separadorAs() {
        String asteriscos = "";
        for (int i = 0; i < MAX_CARACTERES; i++) {
            asteriscos += "*";
        }
        return LINEAS.append(asteriscos).append("\n").toString();
    }

    public String separadorE() {
        String igual = "";
        for (int i = 0; i < MAX_CARACTERES; i++) {
            igual += "=";
        }
        return LINEAS.append(igual).append("\n").toString();
    }

    public void encabezado(String columnas) {
        LINEAS.append(columnas).append("\n");
    }

    public void addTextLeft(String text) {
        if (text.length() > MAX_CARACTERES) {
            int caracter = 0;
            for (int i = text.length(); i > MAX_CARACTERES; i -= MAX_CARACTERES) {
                LINEAS.append(text.substring(caracter, MAX_CARACTERES)).append("\n");
                caracter += MAX_CARACTERES;
            }
            LINEAS.append(text.substring(caracter, text.length() - caracter)).append("\n");
        } else {
            LINEAS.append(text).append("\n");
        }
    }

    public void addTextRight(String text) {
        if (text.length() > MAX_CARACTERES) {
            int caracter = 0;
            for (int i = text.length(); i > MAX_CARACTERES; i -= MAX_CARACTERES) {
                LINEAS.append(text.substring(caracter, MAX_CARACTERES)).append("\n");
                caracter += MAX_CARACTERES;
            }
            String spaces = "";
            for (int i = 0; i < (MAX_CARACTERES - text.substring(caracter, text.length() - caracter).length()); i++) {
                spaces += " ";
            }
            LINEAS.append(spaces).append(text.substring(caracter, text.length() - caracter)).append("\n");
        } else {
            String spaces = "";
            for (int i = 0; i < (MAX_CARACTERES - text.length()); i++) {
                spaces += " ";
            }
            LINEAS.append(spaces).append(text).append("\n");
        }
    }

    public void addTextCenter(String text) {
        if (text.length() > MAX_CARACTERES) {
            int caracter = 0;
            for (int i = text.length(); i > MAX_CARACTERES; i -= MAX_CARACTERES) {
                LINEAS.append(text.substring(caracter, MAX_CARACTERES)).append("\n");
                caracter += MAX_CARACTERES;
            }
            String spaces = "";
            int cent = (MAX_CARACTERES - text.substring(caracter, text.length() - caracter).length()) / 2;
            for (int i = 0; i < cent; i++) {
                spaces += " ";
            }
            LINEAS.append(spaces).append(text.substring(caracter, text.length() - caracter)).append("\n");
        } else {
            String spaces = "";
            int cent = (MAX_CARACTERES - text.length()) / 2;
            for (int i = 0; i < cent; i++) {
                spaces += " ";
            }
            LINEAS.append(spaces).append(text).append("\n");
        }
    }

    public void addTextEx(String left, String right) {
        String l, r, cmpl = "", spaces = "";
        if (left.length() > 18) {
            stop = left.length() - 18;
            l = left.substring(stop, 19);

        } else {
            l = left;
        }

        cmpl = l;
        if (right.length() > 20) {
            stop = right.length() - 20;
            r = right.substring(stop, 20);
        } else {
            r = right;
        }

        int numSpaces = MAX_CARACTERES - (l.length() + r.length());
        for (int i = 0; i < numSpaces; i++) {
            spaces += " ";
        }
        cmpl += spaces + r;
        LINEAS.append(cmpl).append("\n");
    }

    public void addTotal(String text, double total, String mon) {
        String resumen, valor, completo, spaces = "";
        if (text.length() > 25) {
            stop = text.length() - 25;
            resumen = text.substring(stop, 25);
        } else {
            resumen = text;
        }
        completo = resumen;
        valor = mon + FORMAT.decimal(total);
        int numEspacios = MAX_CARACTERES - (resumen.length() + valor.length());
        for (int i = 0; i < numEspacios; i++) {
            spaces += " ";
        }
        completo += spaces + valor;
        LINEAS.append(completo).append("\n");
    }

    public void addItem(String item, String cant, String precio) {
        String elemento = "", espacios = "";
        boolean bandera = false;
        int numEspacios = 10;
        if (item.length() > 20) {
            //colocar la cantida a la derecha
            espacios = "";
            for (int i = 0; i < (numEspacios - cant.length()); i++) {
                espacios += " ";
            }
            elemento += cant + espacios;
            //colocar el precio a la drecha
            espacios = "";
            for (int i = 0; i < (numEspacios - precio.length()); i++) {
                espacios += " ";
            }
            elemento += precio + espacios;

            int caracterActual = 0;
            for (int i = item.length(); i > 20; i -= 20) {
                if (bandera) {
                    LINEAS.append(item.substring(0, caracterActual)).append("\n");
                } else {
                    LINEAS.append(item.substring(caracterActual, 20)).append(elemento).append("\n");
                    bandera = true;
                }
                caracterActual += 20;
            }
            LINEAS.append(item.substring(0, caracterActual)).append("\n");
        } else {
            for (int i = 0; i < (20 - item.length()); i++) {
                espacios += " ";  // Agregar espacios para poner el valor de articulo
            }
            elemento = item + espacios;
            //colocar la cantidad a la drecha
            espacios = "";
            for (int i = 0; i < (numEspacios - cant.length()); i++) {
                espacios += " ";   // Agregar espacios para poner el valor de cantidad
            }
            elemento += cant + espacios;
            //colocamos el precio a la derecha
            espacios = "";
            for (int i = 0; i < (numEspacios - precio.length()); i++) {
                espacios += " "; // Agregar espacios para poner el valor de precio
            }
            elemento += precio + espacios;

            LINEAS.append(elemento).append("\n");
        }
    }

    public void print() throws PrintException {
        //Especificamos el tipo de dato a imprimir
        //Tipo: bytes; Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        //Aca obtenemos el servicio de impresion por defatul
        //Si no quieres ver el dialogo de seleccionar impresora usa esto
        //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //Con esto mostramos el dialogo para seleccionar impresora
        //Si quieres ver el dialogo de seleccionar impresora usalo
        //Solo mostrara las impresoras que soporte arreglo de bits
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 700, 200, printService,
                defaultService, flavor, pras);

        //Creamos un arreglo de tipo byte
        byte[] bytes;
        //Aca convertimos el string(cuerpo del ticket) a bytes tal como
        //lo maneja la impresora(mas bien ticketera :p)
        bytes = LINEAS.toString().getBytes();
        //Creamos un documento a imprimir, a el se le appendeara
        //el arreglo de bytes
        Doc doc = new SimpleDoc(bytes, flavor, null);
        //Creamos un trabajo de impresión
        DocPrintJob job = service.createPrintJob();

        //Imprimimos dentro de un try de a huevo
        job.print(doc, null);
    }
}
