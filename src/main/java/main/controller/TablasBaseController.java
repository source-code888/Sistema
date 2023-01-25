package main.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import main.library.Paginador;
import main.model.*;
import main.model.TablaBase;
import main.view.TablasBase;
import static main.library.Objetos.*;
import static main.library.EventoComun.*;
import main.library.Objetos;

public class TablasBaseController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener, FocusListener {

    private final TablasBase tablaBase;
    private final String titulo;
    private List<TablaBase> lista;
    private int idRegistro;
    private String accion = "insert";

    //ELEMENTOS DEL PAGIANDOR
    private Paginador<TablaBase> paginador;
    private int rows = MAX_REGISTROS_TABLAS_BASE;
    private int pagNum = 1;
    private final JSpinner spinner;
    private DefaultTableModel defaultTableModel;
    //Elementos visuales
    private final List<JButton> buttons;
    private final List<JTextField> textFields;
    private final List<JLabel> labels;
    private final JTable tbBase;

    public TablasBaseController(TablasBase tablaBase, String titulo, List<JButton> buttons, List<JTextField> textFields, List<JLabel> labels, JTable tbBase, JSpinner spinner) {
        super();
        this.tablaBase = tablaBase;
        this.titulo = titulo;
        this.buttons = buttons;
        this.textFields = textFields;
        this.labels = labels;
        this.tbBase = tbBase;
        this.spinner = spinner;
        labels.get(0).setText(titulo);
        reestablecer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton btn = (JButton) source;
            if (btn.equals(buttons.get(0))) {
                //Agregar
                if (!textFields.get(0).getText().isBlank()) {
                    boolean existe = !lista.stream().filter(
                            base -> base.getNombre().equals(textFields.get(0).getText()))
                            .collect(Collectors.toList()).isEmpty();
                    if (accion.equals("insert")) {
                        //Conocer la tabla
                        if (!existe) {
                            Object[] data = {
                                textFields.get(0).getText()
                            };
                            try {
                                switch (titulo) {
                                    case "Area" ->
                                        AreaDAO.getInstance().insert(data);
                                    case "Clasificacion" ->
                                        ClasificacionDAO.getInstance().insert(data);
                                    case "Tienda" ->
                                        TiendaDAO.getInstance().insert(data);
                                    case "Unidad" ->
                                        UnidadDAO.getInstance().insert(data);
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La " + titulo + " ya existe.");
                        }
                    } else if (accion.equals("update")) {
                        if (!existe) {
                            Object[] data = {
                                textFields.get(0).getText()
                            };
                            try {
                                switch (titulo) {
                                    case "Area" ->
                                        AreaDAO.getInstance().update(idRegistro, data);
                                    case "Clasificacion" ->
                                        ClasificacionDAO.getInstance().update(idRegistro, data);
                                    case "Tienda" ->
                                        TiendaDAO.getInstance().update(idRegistro, data);
                                    case "Unidad" ->
                                        UnidadDAO.getInstance().update(idRegistro, data);
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            }
                        }
                    }
                }
                reestablecer();
            }
            if (btn.equals(buttons.get(1))) {
                //Eliminar
                try {
                    switch (titulo) {
                        case "Area" ->
                            AreaDAO.getInstance().remove(idRegistro);
                        case "Clasificacion" ->
                            ClasificacionDAO.getInstance().remove(idRegistro);
                        case "Tienda" ->
                            TiendaDAO.getInstance().remove(idRegistro);
                        case "Unidad" ->
                            UnidadDAO.getInstance().remove(idRegistro);
                    }
                    reestablecer();
                } catch (SQLException ex) {
                    reestablecer();
                    JOptionPane.showMessageDialog(null, "No se puede eliminar esta " + titulo + " porque está referenciada.");
                }

            }
            if (btn.equals(buttons.get(2))) {
                tablaBase.dispose();
            }
            if (btn.equals(buttons.get(3))) {
                //BOTON btnPrimero
                pager(METHOD_FIRST);
            }
            if (btn.equals(buttons.get(4))) {
                //BOTON btnAnterior
                pager(METHOD_LAST);
            }
            if (btn.equals(buttons.get(5))) {
                //BOTON btnSiguiente
                pager(METHOD_NEXT);
            }
            if (btn.equals(buttons.get(6))) {
                //BOTON btnUltimo
                pager(METHOD_LATEST);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    private void buscar(String data) {
        List<TablaBase> filter;
        String titulos[] = {
            "ID",
            "Nombre"
        };
        defaultTableModel = new DefaultTableModel(null, titulos);
        int start = (pagNum - 1) * rows;
        if (data.equals("")) {
            filter = lista.stream().skip(start).limit(rows).collect(Collectors.toList());
        } else {
            filter = lista.stream().filter(base
                    -> base.getNombre().startsWith(data)
            ).skip(start).limit(rows).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    base -> {
                        Object[] objects = {
                            base.getId(),
                            base.getNombre()
                        };
                        defaultTableModel.addRow(objects);
                    }
            );
        }
        tbBase.setModel(defaultTableModel);
        tbBase.setRowHeight(30);
        tbBase.getColumnModel().getColumn(0).setMaxWidth(0);
        tbBase.getColumnModel().getColumn(0).setMinWidth(0);
        tbBase.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void inicializarLista() {
        lista = new ArrayList<>();
        switch (titulo) {
            case "Area" -> {
                AreaDAO.getInstance().getAreas().forEach(area -> {
                    lista.add(area);
                });
            }
            case "Clasificacion" -> {
                ClasificacionDAO.getInstance().getClasificaciones().forEach(clasificacion -> {
                    lista.add(clasificacion);
                });
            }
            case "Tienda" -> {
                TiendaDAO.getInstance().getTiendas().forEach(tienda -> {
                    lista.add(tienda);
                });
            }
            case "Unidad" -> {
                UnidadDAO.getInstance().getUnidades().forEach(unidad -> {
                    lista.add(unidad);
                });
            }
        }
    }

    public void pager(String method) {
        switch (method) {
            case METHOD_FIRST -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.primero();
                }

            }
            case METHOD_LAST -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.anterior();
                }
            }
            case METHOD_NEXT -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.siguiente();
                }
            }
            case METHOD_LATEST -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.ultimo();
                }
            }
        }
        buscar("");
    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!lista.isEmpty()) {
            paginador = new Paginador<>(lista, labels.get(4), rows);
        }
        buscar("");
    }

    private void reestablecer() {
        accion = "insert";
        textFields.get(0).setText("");
        textFields.get(1).setText("");
        labels.get(0).setText(titulo);
        Objetos.eventoComun.remarcarLabel(labels.get(0), titulo, Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Nombre:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(2), "Buscar:", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(3), "Registros por paginas", Color.black);
        Objetos.eventoComun.remarcarLabel(labels.get(4), "Paginas", Color.black);
        textFields.get(0).requestFocus();
        inicializarLista();
        if (!lista.isEmpty()) {
            paginador = new Paginador<>(lista, labels.get(4), rows);
        }
        SpinnerNumberModel numberModel = new SpinnerNumberModel(10, 1, 100, 1);
        spinner.setModel(numberModel);
        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JSpinner) {
            JSpinner sp = (JSpinner) obj;
            if (sp.equals(spinner)) {
                mostrarRegistrosPorPagina();
            }
        }
    }

    private void obtenerRegistro() {
        accion = "update";
        int row = tbBase.getSelectedRow();
        if (!textFields.get(1).getText().equals("")) {
            textFields.get(1).setText("");
        }
        idRegistro = (Integer) defaultTableModel.getValueAt(row, 0);
        textFields.get(0).setText((String) defaultTableModel.getValueAt(row, 1));
        textFields.get(0).requestFocus();
        Objetos.eventoComun.remarcarLabel(labels.get(1), "Nombre:", COLOR_BASE);
        buttons.get(1).setVisible(true);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(textFields.get(1))) {
                if (!textFields.get(0).getText().equals("")) {
                    reestablecer();
                }
                if (labels.get(1).getForeground().equals(Color.red)) {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Nombre:", Color.black);
                }
                textFields.get(1).requestFocus();
                buscar(textFields.get(1).getText());
            }
            if (txt.equals(textFields.get(0))) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (tbBase.getSelectedRows().length > 0) {
                        int index = tbBase.getSelectedRow() + 1;
                        if (index < tbBase.getRowCount()) {
                            tbBase.getSelectionModel().setSelectionInterval(index, index);
                            obtenerRegistro();
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (tbBase.getSelectedRows().length > 0) {
                        int index = tbBase.getSelectedRow() - 1;
                        if (index >= 0) {
                            tbBase.getSelectionModel().setSelectionInterval(index, index);
                            obtenerRegistro();
                        }
                    }
                }
                if (textFields.get(0).getText().isBlank()) {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Ingresa el nombre", Color.red);
                } else {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Nombre:", COLOR_BASE);
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbBase)) {
                if (tbBase.getSelectedRows().length > 0) {
                    obtenerRegistro();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            if (source.equals(textFields.get(0))) {
                if (e.getKeyChar() == '\n') {
                    actionPerformed(new ActionEvent(buttons.get(0), 1001, ""));
                }
            }
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            JTextField txt = (JTextField) e.getSource();
            if (txt.equals(textFields.get(0))) {
                if (textFields.get(0).getText().isBlank()) {
                    Objetos.eventoComun.remarcarLabel(labels.get(1), "Nombre:", Color.black);
                }
            }
        }
    }

}
