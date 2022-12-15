package main.library;

import java.util.List;
import javax.swing.JLabel;

public class Paginador<T> {

    private final List<T> dataList;
    private final JLabel lbl;
    private static int maxReg;
    private static int regPorPagina;
    private static int pageCount;
    private static int numPag = 1;

    public Paginador(List<T> dataList, JLabel lbl, int regPorPagina2) {
        this.dataList = dataList;
        this.lbl = lbl;
        regPorPagina = regPorPagina2;
        cargar();
    }

    private void cargar() {
        numPag = 1;
        maxReg = dataList.size();
        pageCount = maxReg / regPorPagina;
        if ((maxReg % regPorPagina) > 0) {
            pageCount++;
        }
        lbl.setText("Paginas 1/" + pageCount);
    }

    public int primero() {
        numPag = 1;
        lbl.setText("Paginas " + numPag + "/" + pageCount);
        return numPag;
    }

    public int anterior() {
        if (numPag > 1) {
            numPag--;
            lbl.setText("Paginas " + numPag + "/" + pageCount);
        }
        return numPag;
    }

    public int siguiente() {
        if (numPag == pageCount) {
            numPag--;
        }
        if (numPag < pageCount) {
            numPag++;
            lbl.setText("Paginas " + numPag + "/" + pageCount);
        }
        return numPag;
    }

    public int ultimo() {
        numPag = pageCount;
        lbl.setText("Paginas " + numPag + "/" + pageCount);
        return numPag;
    }
}
